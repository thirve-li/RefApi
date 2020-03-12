package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.common.utils.*;
import com.liri.reference.dao.DictItemDao;
import com.liri.reference.model.*;
import com.liri.reference.service.*;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 推荐银行
 *
 * @author William
 * @date 2019/8/19
 */
@Service
public class RecommendBankServiceImpl implements RecommendBankService {
    
    private static Logger logger = LoggerFactory.getLogger(RecommendBankService.class);
    
    @Autowired
    GlobalCollectService globalCollectService;
    
    @Autowired
    ReferenceService referenceService;
    
    @Autowired
    Help2PayService help2PayService;
    
    @Autowired
    CacheService cacheService;
    
    @Autowired
    DictItemDao dictItemDao;
    
    /**
     * 推荐银行
     *
     * @param condition 条件
     * @return ResultBean
     */
    @Override
    public ResultBean getBank(GetBankParam condition) {
        
        ResultBean resultBean = new ResultBean();
        
        Map<String, Object> bankInfoMap = new LinkedHashMap<>();
        
        try {
            
            DictItemDto item = cacheService.getDicItemByItemCode("DICT_CLASS_REF",
                    "DICT_CLASS_API_BANK_TYPE", condition.getWalletTypeCode());
            
            if (item != null && StringUtil.isNotBlank(item.getDictItemValue())) {
                String[] bankTypes = item.getDictItemValue().split("_");
                for (String bankType : bankTypes) {
                    
                    // reference
                    if (ValidateUtil.isBankType(Constants.BANK_TYPE_REF, bankType)) {
                        
                        // 参数校验
                        resultBean = ValidateUtil.checkRefRecommendParam(condition);
                        if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {
                            
                            // 推荐银行
                            resultBean = referenceService.recommendBank(condition);
                            if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {
                                bankInfoMap.put("REF_BANK", resultBean.getDataObject());
                            }
                        } else {
                            logger.warn(">>>>>> reference推荐失败：" + resultBean.toString());
                            return resultBean;
                        }
                    }
                    
                    // GC
                    if (ValidateUtil.isBankType(Constants.BANK_TYPE_GC, bankType)) {
                        
                        // 参数校验
                        resultBean = ValidateUtil.checkGcRecommendParam(condition);
                        if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {
                            
                            // 推荐银行
                            resultBean = globalCollectService.recommendBank(condition);
                            if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {
                                bankInfoMap.put("GC_BANK", resultBean.getDataObject());
                            }
                        } else {
                            logger.warn(">>>>>> GC推荐失败：" + resultBean.toString());
                            return resultBean;
                        }
                    }
                }
            }
            
            
        } catch (Exception e) {
            resultBean = new ResultBean();
            resultBean.setStatus(StatusEnum.SYSTEM_ERROR);
            logger.error(">>>>>> recommendDepositBank error", e);
            return resultBean;
        }
        
        // 推荐银行成功
        if (CollectionUtil.isNotEmpty(bankInfoMap)) {
            resultBean = new ResultBean();
            resultBean.setDataObject(bankInfoMap);
            
            ActionContextUtil.getContext().setBankInfo(bankInfoMap);
            return resultBean;
        }else{
            resultBean.setStatus(StatusEnum.NO_BANK);
            resultBean.setMessage(StatusEnum.NO_BANK.getMsg());
            return resultBean;
        }
        
    }
    
    /**
     * Reference No.取得，保存Ref入金信息
     *
     * @param refDto Ref入金信息
     * @return ResultBean
     */
    @Override
    public ResultBean insertRef(RefConfirmParam refDto, String refNo) {
        
        // 参数校验
        ResultBean resultBean = ValidateUtil.checkRefConfirmParam(refDto);
        if (StatusEnum.SUCCESS.getCode() != resultBean.getStatus()) {
            return resultBean;
        }
        
        WalletTypeDto walletTypeDto = cacheService.getWalletTypeByCode(refDto.getWalletTypeCode());
        
        //保存入金信息
        try {
            
            ReferenceInfoDto referenceInfoDto = new ReferenceInfoDto();
            BeanUtils.copyProperties(refDto,referenceInfoDto);
            referenceInfoDto.setRefNo(refNo);
            referenceInfoDto.setWalletTypeSchema(walletTypeDto.getWalletTypeSchema());
            referenceInfoDto.setWalletTypeID(walletTypeDto.getWalletTypeID());
            referenceInfoDto.setProcessorEmail(refDto.getEmail());
            referenceInfoDto.setIaccountNo(refDto.getAccountNo());
            referenceInfoDto.setTargetCurrencyCode(refDto.getCurrencyCode());
            referenceInfoDto.setCreateTime(new Date());
            referenceInfoDto.setRefCreatedTimestamp(Timestamp.valueOf(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss")));
            if (StringUtil.isBlank(refNo)) {
                resultBean.setMessage(StatusEnum.NO_REF.getMsg());
                resultBean.setStatus(StatusEnum.NO_REF.getCode());
                resultBean.setDataObject(null);
                return resultBean;
            }
            referenceInfoDto.setRefNo(refNo);
            resultBean = referenceService.insert(referenceInfoDto);
            
            
        } catch (Exception e) {
            resultBean.setStatus(StatusEnum.SYSTEM_ERROR);
            logger.error(">>>>>> recommendDepositBank error", e);
        }
        
        return resultBean;
    }
    
    @Override
    public ResultBean insertGC(GcConfirmParam refConfirmParam, String refNo) {
        
        // 参数校验
        ResultBean resultBean = ValidateUtil.checkGcConfirmParam(refConfirmParam);
        if (StatusEnum.SUCCESS.getCode() != resultBean.getStatus()) {
            return resultBean;
        }
        WalletTypeDto walletTypeDto = cacheService.getWalletTypeByCode(refConfirmParam.getWalletTypeCode());
        
        GcApplyInfoDto gcApplyInfoDto = new GcApplyInfoDto();
        BeanUtils.copyProperties(refConfirmParam, gcApplyInfoDto);
        gcApplyInfoDto.setSchema(walletTypeDto.getWalletTypeSchema());
        resultBean = globalCollectService.insert(gcApplyInfoDto);
        return resultBean;
    }
    
    /**
     * 生成refNo
     */
    public String getRefNo(String walletTypeCode, String functionCode, String serverUrl) {
        logger.info("The begin of the method getRefNo");
        String param = "{\"walletTypeCode\":\"" + walletTypeCode + "\",\"functionTypeCode\":\"" + functionCode + "\"}";
        DictItemDto commonUrl = dictItemDao.selectValueByCode("COMMON_MODULE_DOMAIN", null);
        DictItemDto refNoUrl = dictItemDao.selectValueByCode("ServiceRefNo", null);
        
        String url = commonUrl.getDictItemValue();
        String serviceRefNoUrl = refNoUrl.getDictItemValue();
        String postUrl = url + serviceRefNoUrl;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String res = null;
        String referer = serverUrl;
        
        try {
            
            System.setProperty("jsse.enableSNIExtension", "false");
            
            // 设置参数
            String b = Base64.getEncoder().encodeToString(param.getBytes("UTF-8"));
            param = "p=" + b;
            
            // local test url
            //postUrl = "http://localhost:8083/sn/getServiceRefNo";
            
            URL realUrl = new URL(postUrl);
            // 打开连接
            URLConnection conn = realUrl.openConnection();
            // 请求属�?
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("referer", referer);
            // 发送POST
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参�?
            out.print(param);
            out.flush();
            // 响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            if (StringUtil.isNotBlank(result)) {
                JSONObject json = JSONObject.fromObject(result);
                if ("00".equals(json.get("resultCode"))) {
                    res = json.get("serviceRefNo") + "";
                } else {
                    logger.info("getRefNo error walletTypeCode:" + walletTypeCode + ", functionCode:" + functionCode
                            + ", referer:" + referer);
                }
            }
        } catch (Exception e) {
            System.out.println("" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            logger.info("The end of the method getRefNo");
        }
        logger.info("############ getRefNo 7." + res);
        return res;
    }
    
    
}
