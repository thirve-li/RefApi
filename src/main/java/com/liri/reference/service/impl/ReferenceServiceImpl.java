package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.common.utils.DateUtil;
import com.liri.reference.common.utils.StringUtil;
import com.liri.reference.dao.*;
import com.liri.reference.model.*;
import com.liri.reference.service.CacheService;
import com.liri.reference.service.ReferenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Reference推荐银行接口
 *
 * @author William
 * @date 2019/10/14
 */
@Service
public class ReferenceServiceImpl implements ReferenceService {

    private static Logger logger = LoggerFactory.getLogger(ReferenceService.class);
    
    @Autowired
    private MstRiskDao mstRiskDao;
    
    @Autowired
    private MstFiAccountDao mstFiAccountDao;
    
    @Autowired
    private WalletTypeDao walletTypeDao;
    
    @Autowired
    private BankDao bankDao;
    
    @Autowired
    private MstRateDao mstRateDao;
    
    @Autowired
    private ReferenceUserFiRefMapper referenceUserFiRefMapper;
    
    @Autowired
    private MstCountryDao mstCountryDao;
    
    @Autowired
    CacheService cacheService;
    
    @Autowired
    ReferenceInfoMapper referenceInfoMapper;
    private Boolean checkRisk(String nowDate, String countryCode, Long walletTypeID) {
       
        List<MstRisk> list = mstRiskDao.checkRiskCountry(countryCode, nowDate, walletTypeID);
        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * 查找符合入金条件的银行
     * @param nowDate
     * @param currency
     * @param countryCode
     * @param walletTypeCode
     * @return
     */
    private List<MstFiAccountDto> selectMaxAndMinMoneyList(String nowDate, String currency,
                                                           String countryCode,  String walletTypeCode){
    
        WalletTypeDto walletTypeDto = walletTypeDao.selectByCode(walletTypeCode);
        Long walletTypeID = walletTypeDto.getWalletTypeID();
        return mstFiAccountDao.selectMaxAndMinMoneyByDate(nowDate, currency, countryCode, walletTypeID, walletTypeCode);
    }
    
    private MstRate selectRate(String fromCurrencyCode,String currencyCode){
        return mstRateDao.selectLatestRate(fromCurrencyCode, currencyCode);
    }
    
    /**
     * 根据ImpBankInfo查询每种币种的总OriginalAmount
     * @param ImpBankInfo
     * @return
     */
    private BigDecimal getRefInAmount(MstImpBankInInfo ImpBankInfo) {
        BigDecimal amount = new BigDecimal("0");
        BigDecimal refInAmount = new BigDecimal("0");
        
        List<BankInInfoDto> list = bankDao.selectRefInAmount(ImpBankInfo);
        if (list.size() > 0) {
            for (BankInInfoDto bankInfo : list) {
                MstRate rate = selectRate(bankInfo.getOriginalCurrency(), "USD");
                amount = bankInfo.getOriginalAmount().multiply(rate.getCurrencyRate());
                refInAmount = refInAmount.add(amount);
            }
        }
        return refInAmount;
    }
    
    
    private List<Integer> calculateFIAmount(GetBankParam condition, BigDecimal currencyRate, List<MstFiAccountDto> maxMoneyList ){
        List<Integer> fiAccountIDList = new ArrayList<Integer>();
        
        int i = 0;
        int min = 0;
        
        // 换算美元
        BigDecimal amonutUSD = condition.getAmount().multiply(currencyRate);
        
        // yyyyMMdd
        String refNowDateString = DateUtil.getCurrentDate("yyyyMMdd");
        Date refNowDate = DateUtil.getCurrentDate();
      
        // 比较金额 【支持出金金额 范围】
        for (MstFiAccountDto target : maxMoneyList) {
            
            // 入金金额按日期分类限制
            // 按日
            MstImpBankInInfo inInfo = new MstImpBankInInfo();
            inInfo.setFiAccountID(target.getFiAccountID());
            inInfo.setDateFrom(refNowDateString);
            inInfo.setDateTo(refNowDateString);
            String walletTypeSchema =  bankDao.selectWalletTypeSchema(inInfo);
            String schema = "";
            if (StringUtil.isNotBlank(walletTypeSchema)) {
                schema = MstWalletTypeDto.getSchemaNotQuotes(walletTypeSchema);
                inInfo.setWalletTypeSchema(schema);
                
                BigDecimal refInDayAmount = getRefInAmount(inInfo);
                
                if (refInDayAmount.add(amonutUSD).compareTo(target.getRefInDayAmount()) > 0) {
                    i++;
                    continue;
                }
                
                Integer count = bankDao.selectRefInCount(inInfo);
                
                if (count > target.getRefInDayQuantity()) {
                    i++;
                    continue;
                }
                
                // 按周
                String refInTimeCalculationMethod = target.getRefInTimeCalculationMethod();
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfWeek(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfWeek(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfWeek2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
                
                BigDecimal refInWeekAmount = getRefInAmount(inInfo);
                
                count = bankDao.selectRefInCount(inInfo);
                
                if (count > target.getRefInWeekQuantity()) {
                    i++;
                    continue;
                }
                
                if (refInWeekAmount.add(amonutUSD).compareTo(target.getRefInWeekAmount()) > 0) {
                    i++;
                    continue;
                }
                
                // 按月
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfMonth(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfMonth(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfMonth2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
                
                BigDecimal refInMonthAmount = getRefInAmount(inInfo);
                
                count = bankDao.selectRefInCount(inInfo);
                if (count > target.getRefInMonthQuantity()) {
                    i++;
                    continue;
                }
                
                if (refInMonthAmount.add(amonutUSD).compareTo(target.getRefInMonthAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按季度
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfQuarter(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfQuarter(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfQuarter2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
                
                BigDecimal refInQuarterAmount = getRefInAmount(inInfo);
                
                count = bankDao.selectRefInCount(inInfo);
                
                if (count > target.getRefInQuarterQuantity()) {
                    i++;
                    continue;
                }
                
                if (refInQuarterAmount.add(amonutUSD).compareTo(target.getRefInQuarterAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按半年
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfHalfYear(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfHalfYear(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfHalfYear2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
                
                BigDecimal refInHalfYearAmount = getRefInAmount(inInfo);
                
                count = bankDao.selectRefInCount(inInfo);
                
                if (count > target.getRefInHalfYearQuantity()) {
                    i++;
                    continue;
                }
                
                if (refInHalfYearAmount.add(amonutUSD).compareTo(target.getRefInHalfYearAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按年
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfYear(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfYear(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfYear2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
                
                BigDecimal refInYearAmount = getRefInAmount(inInfo);
                
                count = bankDao.selectRefInCount(inInfo);
                
                if (count > target.getRefInYearQuantity()) {
                    i++;
                    continue;
                }
                
                if (refInYearAmount.add(amonutUSD).compareTo(target.getRefInYearAmount()) > 0) {
                    i++;
                    continue;
                }
                
                // 最大值、最小值都不为空
                if (null != target.getMinMoneyInAmount() && null != target.getMaxMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMinMoneyInAmount()) >= 0
                            && amonutUSD.compareTo(target.getMaxMoneyInAmount()) <= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else if (amonutUSD.compareTo(target.getMinMoneyInAmount()) < 0) {
                        min++;
                    } else {
                        i++;
                    }
                    // 最大值为空、最小值不为空
                } else if (null == target.getMaxMoneyInAmount() && null != target.getMinMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMinMoneyInAmount()) >= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else {
                        min++;
                    }
                    // 最大值不为空、最小值为空
                } else if (null != target.getMaxMoneyInAmount() && null == target.getMinMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMaxMoneyInAmount()) <= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else {
                        i++;
                    }
                } else {
                    fiAccountIDList.add(target.getFiAccountID());
                }
            }
        }
        
        return null;
    }
    
    /**
     * 推荐银行
     *
     * @param condition 条件
     * @return ResultBean
     */
    @Override
    public ResultBean recommendBank(GetBankParam condition) {
        ResultBean resultBean = new ResultBean();
        List<BankInfoDto> bankInfoList = new LinkedList<>();
        String nowDate = DateUtil.getCurrentDate("yyyy/MM/dd");
    
        WalletTypeDto walletDto = cacheService.getWalletTypeByCode(condition.getWalletTypeCode());
        Long walletTypeID = walletDto.getWalletTypeID();
    
        // 排除风险国
        Boolean checkRisk = checkRisk(nowDate, condition.getCountryCode(),
                walletTypeID);
        if (checkRisk) {// 风险国无推荐银行
            resultBean.setMessage(StatusEnum.NO_BANK_RISK_COUNTRY.getMsg());
            resultBean.setStatus(StatusEnum.NO_BANK_RISK_COUNTRY.getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        // 查找符合入金条件的银行
        List<MstFiAccountDto> maxMoneyList = selectMaxAndMinMoneyList(nowDate,
                condition.getCurrencyCode(), condition.getCountryCode(),
                condition.getWalletTypeCode());
    
        if (null == maxMoneyList || maxMoneyList.isEmpty()) {//无符合条件的银行
            resultBean.setMessage(StatusEnum.NO_BANK.getMsg());
            resultBean.setStatus(StatusEnum.NO_BANK.getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        List<Integer> fiAccountIDList = new ArrayList<Integer>();
    
        // 汇率计算
        MstRate rateInCurrency = selectRate(condition.getCurrencyCode(), "USD");
        // 汇率不存在
        if (null == rateInCurrency) {
            resultBean.setMessage(condition.getCurrencyCode() + "USD " + StatusEnum.NO_RATE);
            resultBean.setStatus(StatusEnum.NO_BANK.getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        // 换算成美元
        BigDecimal amonutUSD = condition.getAmount().multiply(rateInCurrency.getCurrencyRate());
    
        // yyyyMMdd
        String refNowDateString = DateUtil.getCurrentDate(DateUtil.FORMAT_DATE);
        Date refNowDate = DateUtil.getCurrentDate();
    
        // 比较金额 【支持出金金额 范围】
        resultBean.setDataObject(bankInfoList);
    
        int i = 0;
        int min = 0;
        // 比较金额 【支持出金金额 范围】
        for (MstFiAccountDto target : maxMoneyList) {
        
            // 入金金额按日期分类限制
            // 按日
            MstImpBankInInfo inInfo = new MstImpBankInInfo();
            inInfo.setFiAccountID(target.getFiAccountID());
            inInfo.setDateFrom(refNowDateString);
            inInfo.setDateTo(refNowDateString);
            String walletTypeSchema = bankDao.selectWalletTypeSchema(inInfo);
            String schema = "";
            if (StringUtil.isNotBlank(walletTypeSchema)) {
                schema = MstWalletTypeDto.getSchemaNotQuotes(walletTypeSchema);
            
                inInfo.setWalletTypeSchema(schema);
            
                BigDecimal refInDayAmount = getRefInAmount(inInfo);
            
                if (refInDayAmount.add(amonutUSD).compareTo(target.getRefInDayAmount()) > 0) {
                    i++;
                    continue;
                }
            
                Integer count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInDayQuantity()) {
                    i++;
                    continue;
                }
            
                // 按周
                String refInTimeCalculationMethod = target.getRefInTimeCalculationMethod();
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfWeek(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfWeek(refNowDate));
                } else {
                
                    inInfo.setDateFrom(DateUtil.getFirstDayOfWeek2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
            
                BigDecimal refInWeekAmount = getRefInAmount(inInfo);
            
                count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInWeekQuantity()) {
                    i++;
                    continue;
                }
            
                if (refInWeekAmount.add(amonutUSD).compareTo(target.getRefInWeekAmount()) > 0) {
                    i++;
                    continue;
                }
            
                // 按月
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfMonth(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfMonth(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfMonth2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
            
                BigDecimal refInMonthAmount = getRefInAmount(inInfo);
            
                count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInMonthQuantity()) {
                    i++;
                    continue;
                }
            
                if (refInMonthAmount.add(amonutUSD).compareTo(target.getRefInMonthAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按季度
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfQuarter(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfQuarter(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfQuarter2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
            
                BigDecimal refInQuarterAmount = getRefInAmount(inInfo);
            
                count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInQuarterQuantity()) {
                    i++;
                    continue;
                }
            
                if (refInQuarterAmount.add(amonutUSD).compareTo(target.getRefInQuarterAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按半年
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfHalfYear(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfHalfYear(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfHalfYear2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
            
                BigDecimal refInHalfYearAmount = getRefInAmount(inInfo);
            
                count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInHalfYearQuantity()) {
                    i++;
                    continue;
                }
            
                if (refInHalfYearAmount.add(amonutUSD).compareTo(target.getRefInHalfYearAmount()) > 0) {
                    i++;
                    continue;
                }
                // 按年
                if ("1".equals(refInTimeCalculationMethod)) {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfYear(refNowDate));
                    inInfo.setDateTo(DateUtil.getLastDayOfYear(refNowDate));
                } else {
                    inInfo.setDateFrom(DateUtil.getFirstDayOfYear2(refNowDate));
                    inInfo.setDateTo(refNowDateString);
                }
            
                BigDecimal refInYearAmount = getRefInAmount(inInfo);
            
                count = bankDao.selectRefInCount(inInfo);
            
                if (count > target.getRefInYearQuantity()) {
                    i++;
                    continue;
                }
            
                if (refInYearAmount.add(amonutUSD).compareTo(target.getRefInYearAmount()) > 0) {
                    i++;
                    continue;
                }
            
                // 最大值、最小值都不为空
                if (null != target.getMinMoneyInAmount() && null != target.getMaxMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMinMoneyInAmount()) >= 0
                            && amonutUSD.compareTo(target.getMaxMoneyInAmount()) <= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else if (amonutUSD.compareTo(target.getMinMoneyInAmount()) < 0) {
                        min++;
                    } else {
                        i++;
                    }
                    // 最大值为空、最小值不为空
                } else if (null == target.getMaxMoneyInAmount() && null != target.getMinMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMinMoneyInAmount()) >= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else {
                        min++;
                    }
                    // 最大值不为空、最小值为空
                } else if (null != target.getMaxMoneyInAmount() && null == target.getMinMoneyInAmount()) {
                    if (amonutUSD.compareTo(target.getMaxMoneyInAmount()) <= 0) {
                        fiAccountIDList.add(target.getFiAccountID());
                    } else {
                        i++;
                    }
                } else {
                    fiAccountIDList.add(target.getFiAccountID());
                }
            }
        }
    
        if (!fiAccountIDList.isEmpty()) {
            List<FICompanyDto> recommondBankList = new ArrayList<FICompanyDto>();
            bankInfo(recommondBankList,fiAccountIDList, condition,amonutUSD);
            if (recommondBankList.isEmpty()) {
                resultBean.setMessage(StatusEnum.NO_BANK.getMsg());
                resultBean.setStatus(StatusEnum.NO_BANK.getCode());
                resultBean.setDataObject(null);
            }else {
                resultBean.setMessage(StatusEnum.SUCCESS.getMsg());
                resultBean.setStatus(StatusEnum.SUCCESS.getCode());
                resultBean.setDataObject(recommondBankList);
            }
        }else{
            resultBean.setMessage(StatusEnum.NO_BANK.getMsg());
            resultBean.setStatus(StatusEnum.NO_BANK.getCode());
            resultBean.setDataObject(null);
        }
        
        return resultBean;
    }
    
    
    private void bankInfo(List<FICompanyDto> recommondBankList,
                          List<Integer> fiAccountIDList,
                          GetBankParam condition,
                          BigDecimal amonutUSD) {
        try {
            
            /**
             * 0124修改推荐逻辑： 原逻辑：DepositorEntityType对应登录用户类型，没有Myself Others区分 修改为：选Myself
             * DepositorEntityType对应登录用户类型，选Others DepositorEntityType对应 Others里面的Individual
             * / Corporate 选项
             */
            String depositorEntityType = "";
            if ("Myself".equals(condition.getSender())) {
                depositorEntityType = condition.getUserType();
            } else {
                if ("Individual".equals(condition.getSenderType())) {
                    depositorEntityType = "Personal";
                } else {
                    depositorEntityType = "Corporation";
                }
            }
            
            // 客户所在国银行
            String nowDate = DateUtil.getDate("yyyy-MM-dd");
            List<FICompanyDto> countryBankList = bankDao.selectBankByCountry(
                    condition.getCountryCode(), nowDate,condition.getCurrencyCode(), fiAccountIDList,
                    condition.getWalletTypeCode(), condition.getSender(), depositorEntityType);
      
            // 排序
            sortCountry(countryBankList);
            for (FICompanyDto item : countryBankList) {
                
                // OWT2
                if (item.getCountryPriority() < 0) {
                    continue;
                }
                
                // 如果MaxMoneyInAmount为空，看成无限大
                if (null == item.getMaxMoney()
                        || item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                    item.setMailFlag(true);
                }
                addVipBank( item,  condition,recommondBankList);
            }
            
            // 所在州、区域
            List<FICompanyDto> regionBankList = new ArrayList<FICompanyDto>();
    
            Map<String, MstCountry> countryMap = new HashMap<String, MstCountry>();
            for (MstCountry item : getCountryList(condition.getWalletTypeCode())) {
                countryMap.put(item.getCountryCode(), item);
            }
     
            regionBankList = bankDao.selectBankByRegion(condition.getCountryCode(),
                    countryMap.get(condition.getCountryCode()).getRegionID(), nowDate,
                    condition.getCurrencyCode(),
                    fiAccountIDList, condition.getWalletTypeCode(), condition.getSender(), depositorEntityType);
     
            // 排序
            sortRegion(regionBankList);
            
            for (FICompanyDto item : regionBankList) {
                
                // OWT2
                if (item.getRegionPriority() < 0) {
                    continue;
                }
                
                if (null == item.getMaxMoney()
                        || item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                    item.setMailFlag(true);
                }
    
                // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
                addVipBank( item,  condition,recommondBankList);
            }
            
            
            // 全球
            List<FICompanyDto> globalBankList = new ArrayList<FICompanyDto>();
            globalBankList = bankDao.selectBankByGlobal(condition.getCountryCode(),
                    countryMap.get(condition.getCountryCode()).getRegionID(), nowDate,condition.getCurrencyCode(),
                    fiAccountIDList, condition.getWalletTypeCode(), condition.getSender(), depositorEntityType);
            // 排序
            sortGlobal(globalBankList);
            
            for (FICompanyDto item : globalBankList) {
                
                // OWT2
                if (item.getGlobalPriority() < 0) {
                    continue;
                }
                
                if (null == item.getMaxMoney()
                        || item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                    item.setMailFlag(true);
                }
                
                // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
                addVipBank( item,  condition,recommondBankList);
            }
            
            if (recommondBankList.size() == 0) {
                // 每家FI账户MAX入金金额- 同币种的余额 < 入金金额
                for (FICompanyDto item : countryBankList) {
                    // OWT2
                    if (item.getCountryPriority() < 0) {
                        continue;
                    }
                    
                    if (null != item.getMaxMoney()
                            && item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                        item.setMailFlag(true);
                    }
                    
                    // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
                    addVipBank( item,  condition,recommondBankList);
                }
                
                for (FICompanyDto item : regionBankList) {
                    // OWT2
                    if (item.getRegionPriority() < 0) {
                        continue;
                    }
                    
                    if (null != item.getMaxMoney()
                            && item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                        item.setMailFlag(true);
                    }
                    
                    // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
                    addVipBank( item,  condition,recommondBankList);
                }
                
                for (FICompanyDto item : globalBankList) {
                    
                    // OWT2
                    if (item.getGlobalPriority() < 0) {
                        continue;
                    }
                    
                    if (null != item.getMaxMoney()
                            && item.getMaxMoney().subtract(item.getFiBalance()).compareTo(amonutUSD) < 0) {
                        item.setMailFlag(true);
                    }
                    // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
                    addVipBank( item,  condition,recommondBankList);
                }
            }
            
            // 普通FI最多显示三家，VIP FI无限制
            List<FICompanyDto> viplist = new ArrayList<FICompanyDto>();
            List<FICompanyDto> normallist = new ArrayList<FICompanyDto>();
            for (int j = 0; j < recommondBankList.size(); j++) {
                if (null != recommondBankList.get(j).getIsVIP() && 1 == recommondBankList.get(j).getIsVIP()) {
                    viplist.add(recommondBankList.get(j));
                } else {
                    normallist.add(recommondBankList.get(j));
                }
            }
            recommondBankList = viplist;
            int normalcount = normallist.size();
            if (normalcount > 3) {
                normalcount = 3;
            }
            for (int j = 0; j < normalcount; j++) {
                FICompanyDto fi = normallist.get(j);
                recommondBankList.add(fi);
            }
            
            // vip排序
            sortVip(recommondBankList);
            
            // 中继银行
            for (int i = 0; i < recommondBankList.size(); i++) {
                
                List<List<MstFiAccountDto>> resultList = new ArrayList<List<MstFiAccountDto>>();
                
                FICompanyDto company = recommondBankList.get(i);
                List<MstFiAccountDto> fiList = bankDao.selectChildBanks(company.getFiID(),
                        company.getFiAccountID(), condition.getWalletTypeCode());
                
                for (int j = 0; j < fiList.size(); j++) {
                    List<MstFiAccountDto> childFiList = bankDao
                            .selectChildBanks(fiList.get(j).getFiID(), fiList.get(j).getFiAccountID(), condition.getWalletTypeCode());
                    List<MstFiAccountDto> grandsonList = new ArrayList<MstFiAccountDto>();
                    if (childFiList.size() > 0) {
                        for (MstFiAccountDto item : childFiList) {
                            grandsonList = new ArrayList<MstFiAccountDto>();
                            
                            int rowspan = 10;
                            if (StringUtil.isEmpty(item.getFiAccountNo())) {
                                rowspan = rowspan - 1;
                            }
                            
                            if (StringUtil.isEmpty(item.getSwiftCode())) {
                                rowspan = rowspan - 1;
                            }
                            
                            if (StringUtil.isEmpty(item.getFiAccountAddress())) {
                                rowspan = rowspan - 1;
                            }
                            
                            if (StringUtil.isEmpty(fiList.get(j).getFiAccountNo())) {
                                rowspan = rowspan - 1;
                            }
                            
                            if (StringUtil.isEmpty(fiList.get(j).getCountryName())) {
                                rowspan = rowspan - 1;
                            }
                            
                            if (StringUtil.isEmpty(fiList.get(j).getFiAccountAddress())) {
                                rowspan = rowspan - 1;
                            }
                            
                            fiList.get(j).setRowspan(rowspan);
                            
                            grandsonList.add(fiList.get(j));
                            grandsonList.add(item);
                            resultList.add(grandsonList);
                        }
                    } else {
                        int rowspan = 5;
                        if (StringUtil.isEmpty(fiList.get(j).getFiAccountNo())) {
                            rowspan = rowspan - 1;
                        }
                        
                        if (StringUtil.isEmpty(fiList.get(j).getCountryName())) {
                            rowspan = rowspan - 1;
                        }
                        
                        if (StringUtil.isEmpty(fiList.get(j).getFiAccountAddress())) {
                            rowspan = rowspan - 1;
                        }
                        fiList.get(j).setRowspan(rowspan);
                        grandsonList.add(fiList.get(j));
                        resultList.add(grandsonList);
                    }
                }
                
                if (resultList.size() > 0) {
                    recommondBankList.get(i).setChildFiActList(resultList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增数据到DB
     *
     * @param referenceInfoDto
     * @return ResultBean
     */
    @Override
    public ResultBean insert(ReferenceInfoDto referenceInfoDto) {
        ResultBean resultBean = new ResultBean();
        try {
           Long id =  referenceInfoMapper.insert(referenceInfoDto);
           resultBean.setStatus(StatusEnum.SUCCESS.getCode());
           resultBean.setMessage(StatusEnum.SUCCESS.getMsg());
           resultBean.setDataObject(referenceInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setStatus(StatusEnum.FAIL .getCode());
            resultBean.setMessage(e.getMessage());
            resultBean.setDataObject(referenceInfoDto);
        }
        return resultBean;
    }
    
    private void addVipBank(FICompanyDto item, GetBankParam condition,List<FICompanyDto> recommondBankList){
        // 判断是否是VIP FI 如果是，判断是否对该accountNo开放
        if (null != item.getIsVIP() && 1 == item.getIsVIP()) {
            HashMap mapParam = new HashMap<String, Object>();
            mapParam.put("accountNo", condition.getAccountNo());
            mapParam.put("fiAccountId", item.getFiAccountID());
            List<ReferenceUserFiRef> vip = selectVipByMap(mapParam);
            if (!CollectionUtils.isEmpty(vip)) {
                recommondBankList.add(item);
            }
        } else {
            recommondBankList.add(item);
        }
    }
    
    Map<String, String> mesMap = new HashMap<String, String>();
    private void sortCountry(List<FICompanyDto> list) {
        if (list.size() > 1) {
            Collections.sort(list, new Comparator<FICompanyDto>() {
                public int compare(FICompanyDto dto0, FICompanyDto dto1) {
                    if (dto0.getCountryPriority() == dto1.getCountryPriority()) {
                        // 汇率计算
                        MstRate rateInCurrency = selectRate(dto0.getInFeeCurrency(), "USD");
                        
                        MstRate rateOriginal = selectRate(dto1.getInFeeCurrency(), "USD");
                        if (rateInCurrency == null) {
                            if (!mesMap.containsKey(dto0.getInFeeCurrency())) {
                                mesMap.put(dto0.getInFeeCurrency(), dto0.getInFeeCurrency());
                            }
                            return -1;
                        } else if (rateOriginal == null) {
                            if (!mesMap.containsKey(dto1.getInFeeCurrency())) {
                                mesMap.put(dto1.getInFeeCurrency(), dto1.getInFeeCurrency());
                            }
                            return -1;
                        }
                        
                        return getInFeeAmount(dto0.getInFeeAmount()).multiply(rateInCurrency.getCurrencyRate())
                                .compareTo(
                                        getInFeeAmount(dto1.getInFeeAmount()).multiply(rateOriginal.getCurrencyRate()));
                    } else {
                        return 1;
                    }
                }
            });
        }
    }
    
    private void sortRegion(List<FICompanyDto> list) {
        if (list.size() > 1) {
            Collections.sort(list, new Comparator<FICompanyDto>() {
                public int compare(FICompanyDto dto0, FICompanyDto dto1) {
                    if (dto0.getRegionPriority() == dto1.getRegionPriority()) {
                        // 汇率计算
                        MstRate rateInCurrency = selectRate(dto0.getInFeeCurrency(), "USD");
                        
                        MstRate rateOriginal = selectRate(dto1.getInFeeCurrency(), "USD");
                        
                        if (rateInCurrency == null) {
                            if (!mesMap.containsKey(dto0.getInFeeCurrency())) {
                                mesMap.put(dto0.getInFeeCurrency(), dto0.getInFeeCurrency());
                            }
                            return -1;
                        } else if (rateOriginal == null) {
                            if (!mesMap.containsKey(dto1.getInFeeCurrency())) {
                                mesMap.put(dto1.getInFeeCurrency(), dto1.getInFeeCurrency());
                            }
                            return -1;
                        }
                        
                        return getInFeeAmount(dto0.getInFeeAmount()).multiply(rateInCurrency.getCurrencyRate())
                                .compareTo(
                                        getInFeeAmount(dto1.getInFeeAmount()).multiply(rateOriginal.getCurrencyRate()));
                    } else {
                        return 1;
                    }
                }
            });
        }
    }
    
    private void sortGlobal(List<FICompanyDto> list) {
        if (list.size() > 1) {
            Collections.sort(list, new Comparator<FICompanyDto>() {
                public int compare(FICompanyDto dto0, FICompanyDto dto1) {
                    if (dto0.getGlobalPriority() == dto1.getGlobalPriority()) {
                        // 汇率计算
                        MstRate rateInCurrency = selectRate(dto0.getInFeeCurrency(), "USD");
                        
                        MstRate rateOriginal = selectRate(dto1.getInFeeCurrency(), "USD");
                        
                        if (rateInCurrency == null) {
                            if (!mesMap.containsKey(dto0.getInFeeCurrency())) {
                                mesMap.put(dto0.getInFeeCurrency(), dto0.getInFeeCurrency());
                            }
                            return -1;
                        } else if (rateOriginal == null) {
                            if (!mesMap.containsKey(dto1.getInFeeCurrency())) {
                                mesMap.put(dto1.getInFeeCurrency(), dto1.getInFeeCurrency());
                            }
                            return -1;
                        }
                        
                        return getInFeeAmount(dto0.getInFeeAmount()).multiply(rateInCurrency.getCurrencyRate())
                                .compareTo(
                                        getInFeeAmount(dto1.getInFeeAmount()).multiply(rateOriginal.getCurrencyRate()));
                    } else {
                        return 1;
                    }
                }
            });
        }
    }
    
    private void sortVip(List<FICompanyDto> recommondBankList) {
        List<FICompanyDto> bank = new ArrayList<FICompanyDto>();
        List<FICompanyDto> vipBank = new ArrayList<FICompanyDto>();
        for (int i = 0; i < recommondBankList.size(); i++) {
            FICompanyDto dto = recommondBankList.get(i);
            if (null != dto.getIsVIP() && 1 == dto.getIsVIP()) {
                vipBank.add(dto);
            } else {
                bank.add(dto);
            }
        }
        
        recommondBankList =  new ArrayList<FICompanyDto>();
        recommondBankList = vipBank;
        for (int i = 0; i < bank.size(); i++) {
            FICompanyDto dto = bank.get(i);
            recommondBankList.add(dto);
        }
    }
    
    
    private List<ReferenceUserFiRef> selectVipByMap(Map<String, Object> map) {
        return referenceUserFiRefMapper.selectInfoByMap(map);
    }
    
    public List<MstCountry> getCountryList(String walletTypeCode) {
        return mstCountryDao.selectAllCountry(walletTypeCode);
    }
    
    private BigDecimal getInFeeAmount(BigDecimal inFeeAmount) {
        if (null == inFeeAmount) {
            return new BigDecimal(0);
        } else {
            return inFeeAmount;
        }
    }
    
}
