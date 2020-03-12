package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.GlobalCollectConstants;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.common.utils.DateUtil;
import com.liri.reference.common.utils.HttpUtil;
import com.liri.reference.common.utils.StringUtil;
import com.liri.reference.dao.GcApplyInfoMapper;
import com.liri.reference.dao.OrderIdMapper;
import com.liri.reference.model.*;
import com.liri.reference.service.CacheService;
import com.liri.reference.service.GlobalCollectService;
import com.liri.reference.service.RecommendBankService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * GC
 *
 * @author William
 * @date 2019/10/14
 */
@Service
public class GlobalCollectServiceImpl implements GlobalCollectService {

    private static Logger logger = LoggerFactory.getLogger(GlobalCollectService.class);
    
    @Autowired
    private CacheService cacheService;
    
    @Autowired
    private RecommendBankService recommendBankService;
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    OrderIdMapper orderIdMapper;
    
    @Autowired
    GcApplyInfoMapper gcApplyInfoMapper;
    
    
    /**
     * 推荐银行
     *
     * @param condition
     * @return ResultBean
     */
    @Override
    public ResultBean recommendBank(GetBankParam condition) {
        
        ResultBean resultBean = new ResultBean();
        logger.debug("The begin of the method recommendDepositBank");
        if (condition == null) {
            resultBean.setMessage(StatusEnum.PARAM_ERROR.getMsg());
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        // 单笔金额过低无推荐银行
        BigDecimal currencyMinLimit = GlobalCollectConstants.CURRENCY_MIN_LIMIT.get(condition.getCurrencyCode());
        if (currencyMinLimit != null) {
        
            if (currencyMinLimit.compareTo(condition.getAmount()) > 0) {
                resultBean.setMessage(StatusEnum.EXCEED_MIN .getMsg());
                resultBean.setStatus(StatusEnum.EXCEED_MIN.getCode());
                resultBean.setDataObject(null);
                return resultBean;
            }
        }
    
        // 单笔金额过大无推荐银行
        BigDecimal currencyMaxLimit = GlobalCollectConstants.CURRENCY_MAX_LIMIT.get(condition.getCurrencyCode());
        if (currencyMaxLimit != null) {
            if (currencyMaxLimit.compareTo(condition.getAmount()) < 0) {
                resultBean.setMessage(StatusEnum.EXCEED_MAX  .getMsg());
                resultBean.setStatus(StatusEnum.EXCEED_MAX.getCode());
                resultBean.setDataObject(null);
                return resultBean;
            }
        }
        String url = request.getHeader("referer");
        // 获取ServiceNumber
        String serviceRefNo = recommendBankService.getRefNo(condition.getWalletTypeCode(), "124",
                url);
    
        serviceRefNo =""+ Math.random();
        if (StringUtil.isBlank(serviceRefNo)) {
            logger.info(">>>>>> serviceRefNo is empty of condition:" + condition.toString());
            resultBean.setMessage(StatusEnum.NO_REF.getMsg());
            resultBean.setStatus(StatusEnum.NO_REF.getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        // 订单ID
        String orderId = orderIdMapper.getOrderId();
        if (StringUtil.isBlank(orderId)) {
            logger.info(">>>>>> orderId is empty");
            resultBean.setMessage("OrderId is empty");
            resultBean.setStatus(StatusEnum.FAIL.getCode());
            resultBean.setDataObject(null);
        }
    
        // 创建XML文档
        Document request = creatXML(condition, orderId, serviceRefNo);
    
        logger.info("****** request:" + request.asXML());
        long requestTime = System.currentTimeMillis();
    
        // Global Collect请求地址
        DictItemDto globalCollectUrl = cacheService.getDicItemByItemCode(GlobalCollectConstants.DICT_CLASS_REF,
                GlobalCollectConstants.DICT_ITEM_GC_URL,null);
        if (globalCollectUrl == null) {
            resultBean.setMessage(StatusEnum.PARAM_ERROR .getMsg());
            resultBean.setStatus(StatusEnum.PARAM_ERROR .getCode());
            resultBean.setDataObject(null);
            return resultBean;
        }
    
        // 请求 Global Collect响应
        String response = HttpUtil.doPost(globalCollectUrl.getDictItemValue(), request.asXML(), null);
    
        long responseTime = System.currentTimeMillis();
        logger.info("****** responseTime:" + (responseTime - requestTime) + ", response:" + response);
    
        // 解析XML
        Document responseDocument = parseXML(response);
    
        Element root = responseDocument.getRootElement();
        Element result = root.element(GlobalCollectConstants.KEY_REQUEST).element(GlobalCollectConstants.KEY_RESPONSE);
        Element resultStatus = result.element(GlobalCollectConstants.KEY_RESPONSE_RESULT);
    
        // 响应状态:接收到消息并成功处理 - OK; 消息已收到，但未被接受 - NOK
        if (GlobalCollectConstants.OK.equals(resultStatus.getText())) {
        
            Element row = result.element(GlobalCollectConstants.KEY_RESPONSE_ROW);
     
            // 设置推荐银行
            GcConfirmParam gcApplyInfoDto = setGCBankInfo(row, condition, serviceRefNo);
        
            resultBean.setDataObject(gcApplyInfoDto);
            return resultBean;
        } else {
            Element error = result.element(GlobalCollectConstants.KEY_RESPONSE_ERROR);
      
            resultBean.setStatus ( StatusEnum.FAIL );
            resultBean.setMessage("response error Code:"
                    + error.element(GlobalCollectConstants.KEY_RESPONSE_ERROR_CODE).getText() + ", message:"
                    + error.element(GlobalCollectConstants.KEY_RESPONSE_ERROR_MESSAGE).getText());
        
            logger.info(">>>>>> response is NOK of condition:" + condition.toString());
            return resultBean;
        }
    }

    /**
     * 新增数据到DB
     *
     * @param gcApplyInfoDto
     * @return ResultBean
     */
    @Override
    public ResultBean insert(GcApplyInfoDto gcApplyInfoDto) {
        
        ResultBean resultBean = new ResultBean();
        try {
            WalletTypeDto walletType = cacheService.getWalletTypeByCode(gcApplyInfoDto.getWalletTypeCode());
            if (walletType == null) {
                resultBean.setStatus (StatusEnum.FAIL);
                resultBean.setMessage("walletType is null");
                return resultBean;
            }
            // schema
            gcApplyInfoDto.setSchema(walletType.getWalletTypeSchema());
            gcApplyInfoDto.setCreateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
            gcApplyInfoMapper.insert(gcApplyInfoDto);
    
            resultBean.setDataObject(gcApplyInfoDto);
            resultBean.setStatus(StatusEnum.SUCCESS);
            resultBean.setMessage(StatusEnum.SUCCESS.getMsg());
        } catch (Exception e) {
            logger.error("****** LocalBankServiceImpl.insert error:" + e);
            resultBean.setStatus (StatusEnum.FAIL);
            resultBean.setMessage(e.getMessage());
        }
        return resultBean;
    }
    
    /**
     * 设置推荐银行
     *
     * @param row
     * @param condition
     * @param serviceRefNo
     */
    private  GcConfirmParam setGCBankInfo(Element row, GetBankParam condition,
                                  String serviceRefNo) {
    
        GcConfirmParam  gcBankInfo = new GcConfirmParam();
        
        Element paymentReferenceNo = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_PAYMENT_REFERENCE);
        if (paymentReferenceNo != null) {
            gcBankInfo.setPaymentReferenceNo(paymentReferenceNo.getText());
        }
        
        Element statusId = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_STATUS_ID);
        if (statusId != null) {
            gcBankInfo.setStatus(statusId.getText());
        }
        
        Element orderId = row.element(GlobalCollectConstants.KEY_ORDER_ID);
        if (orderId != null) {
            gcBankInfo.setOrderId(Integer.valueOf(orderId.getText()));
        }
        
        Element bankAccountNumber = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_BANK_ACCOUNT_NUMBER);
        if (bankAccountNumber != null) {
            gcBankInfo.setAccountNumber(bankAccountNumber.getText());
        }
        
        Element accountHolder = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_ACCOUNT_HOLDER);
        if (accountHolder != null) {
            gcBankInfo.setAccountHolderName(accountHolder.getText());
        }
        
        Element bankName = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_BANK_NAME);
        if (bankName != null) {
            gcBankInfo.setBank(bankName.getText());
        }
        
        Element bankCountry = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_COUNTRY_DESCRIPTION);
        if (bankCountry != null) {
            gcBankInfo.setCountry(bankCountry.getText());
        }
        
        Element city = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_CITY);
        if (city != null) {
            gcBankInfo.setCity(city.getText());
        }
        
        Element iban = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_IBAN);
        if (iban != null) {
            gcBankInfo.setIban(iban.getText());
        }
        
        Element specialId = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_SPECIAL_ID);
        if (specialId != null) {
            gcBankInfo.setCountrySpecificBankID(specialId.getText());
        }
        
        Element swiftCode = row.element(GlobalCollectConstants.KEY_RESPONSE_ROW_SWIFT_CODE);
        if (swiftCode != null) {
            gcBankInfo.setSwiftCode(swiftCode.getText());
        }
        
        // 交易手续费
        if ("00196".equals(condition.getWalletTypeCode())) {
            if ("JPY".equals(condition.getCurrencyCode())) {
                gcBankInfo.setFee(BigDecimal.valueOf(1500));
            } else if ("USD".equals(condition.getCurrencyCode())) {
                gcBankInfo.setFee(BigDecimal.valueOf(15));
            } else if ("EUR".equals(condition.getCurrencyCode())) {
                gcBankInfo.setFee(BigDecimal.valueOf(10));
            }
        }
        /*if (gcBankInfo.getFee()!= null) {
            // Fee = rate * 10
            gcBankInfo.setFee(condition.getRate().multiply(new BigDecimal("10")));
        }*/
    
        gcBankInfo.setMerchantRef(serviceRefNo);
     
        return gcBankInfo;
    }
    
    /**
     * 设置Meta
     *
     * @param request
     */
    private static void setMeta(Element request) {
        
        Element meta = request.addElement(GlobalCollectConstants.KEY_META);
        meta.addElement(GlobalCollectConstants.KEY_MERCHANT_ID)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_MERCHANT_ID));
        
        meta.addElement(GlobalCollectConstants.KEY_IP_ADDRESS)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_IP_ADDRESS));
        meta.addElement(GlobalCollectConstants.KEY_VERSION)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_VERSION));
    }
    
    /**
     * 创建XML文档
     *
     * @param condition
     * @param orderId
     * @param serviceRefNo
     * @return
     */
    public Document creatXML(GetBankParam condition, String orderId, String serviceRefNo) {
        
        // 创建文档
        Document document = DocumentHelper.createDocument();
        
        // 创建根元素
        Element root = document.addElement(GlobalCollectConstants.KEY_XML);
        
        // request
        Element request = root.addElement(GlobalCollectConstants.KEY_REQUEST);
        
        // action
        request.addElement(GlobalCollectConstants.KEY_ACTION)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_ACTION));
        
        // meta
        setMeta(request);
        
        // params
        Element params = request.addElement(GlobalCollectConstants.KEY_PARAMS);
        
        // order
        setOrder(params, condition, orderId, serviceRefNo);
        
        // payment
        setPayment(params, condition);
        
        // fraud fields
        setFraudFields(params);
        
        return document;
    }
    
    /**
     * 设置订单
     *
     * @param params
     * @param condition
     * @param orderId
     * @param serviceRefNo
     */
    private void setOrder(Element params, GetBankParam condition, String orderId, String serviceRefNo) {
        
        Element order = params.addElement(GlobalCollectConstants.KEY_ORDER);
        
        if (StringUtil.isNotBlank(orderId)) {
            order.addElement(GlobalCollectConstants.KEY_ORDER_ID).addText(orderId);
        }
        
        order.addElement(GlobalCollectConstants.KEY_ORDER_TYPE)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_ORDER_TYPE));
        
        // Amount of the order in cents:29990 (=299.90)
        if (condition.getAmount() != null) {
            order.addElement(GlobalCollectConstants.KEY_AMOUNT)
                    .addText((condition.getAmount().multiply(new BigDecimal("100"))).toPlainString());
        }
        
        if (StringUtil.isNotBlank(condition.getCurrencyCode())) {
            order.addElement(GlobalCollectConstants.KEY_CURRENCY_CODE).addText(condition.getCurrencyCode());
        }
        
        order.addElement(GlobalCollectConstants.KEY_LANGUAGE_CODE)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_LANGUAGE_CODE));
        
        if (StringUtil.isNotBlank(condition.getCountryCode())) {
            order.addElement(GlobalCollectConstants.KEY_COUNTRY_CODE).addText(condition.getCountryCode());
        }
        
        if (StringUtil.isNotBlank(condition.getAccountNo())) {
            order.addElement(GlobalCollectConstants.KEY_CUSTOMER_ID).addText(condition.getAccountNo());
        }
        
        if (StringUtil.isNotBlank(serviceRefNo)) {
            order.addElement(GlobalCollectConstants.KEY_MERCHANT_REFERENCE).addText(serviceRefNo);
        }
    }
    
    /**
     * 设置付款
     *
     * @param params
     * @param condition
     */
    private void setPayment(Element params, GetBankParam condition) {
        
        Element payment = params.addElement(GlobalCollectConstants.KEY_PAYMENT);
        payment.addElement(GlobalCollectConstants.KEY_PAYMENT_PRODUCT_ID)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_PAYMENT_PRODUCT_ID));
        
        // Amount of the order in cents:29990 (=299.90)
        if (condition.getAmount() != null) {
            payment.addElement(GlobalCollectConstants.KEY_PAYMENT_AMOUNT)
                    .addText((condition.getAmount().multiply(new BigDecimal("100"))).toPlainString());
        }
        
        if (StringUtil.isNotBlank(condition.getCurrencyCode())) {
            payment.addElement(GlobalCollectConstants.KEY_PAYMENT_CURRENCY_CODE).addText(condition.getCurrencyCode());
        }
        
        payment.addElement(GlobalCollectConstants.KEY_PAYMENT_LANGUAGE_CODE)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_LANGUAGE_CODE));
        
        if (StringUtil.isNotBlank(condition.getCountryCode())) {
            payment.addElement(GlobalCollectConstants.KEY_PAYMENT_COUNTRY_CODE).addText(condition.getCountryCode());
        }
        
        payment.addElement(GlobalCollectConstants.KEY_PAYMENT_HOSTED_INDICATOR)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_PAYMENT_HOSTED_INDICATOR));
        payment.addElement(GlobalCollectConstants.KEY_PAYMENT_RETURN_URL)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_PAYMENT_RETURN_URL));
    }
    
    /**
     * 设置fraudFields
     *
     * @param params
     */
    private static void setFraudFields(Element params) {
        
        Element fraudFields = params.addElement(GlobalCollectConstants.KEY_FRAUD_FIELDS);
        fraudFields.addElement(GlobalCollectConstants.KEY_EBT_USER_DATA1)
                .addText(GlobalCollectConstants.CONFIG.get(GlobalCollectConstants.KEY_EBT_USER_DATA1));
    }
    
    /**
     * 解析XML
     *
     * @param xml
     * @return
     */
    public Document parseXML(String xml) {
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml); // XML转Document对象 
        } catch (DocumentException e) {
            logger.error("****** ParsingXML error:", e);
        }
        return document;
    }
    
}
