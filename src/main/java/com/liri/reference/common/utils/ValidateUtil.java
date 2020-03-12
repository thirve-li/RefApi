package com.liri.reference.common.utils;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.constants.GlobalCollectConstants;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.model.*;
import com.liri.reference.model.RefConfirmParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 校验工具
 *
 * @author William
 * @date 2019/8/20
 */
public class ValidateUtil {
    private static Logger logger = LoggerFactory.getLogger(ValidateUtil.class);

    private static final String AUTHORIZATION_CODE = "authorization_code";

    private static final String SYSTEM_CODE = "liri0000";
    
    private static final String USER_TYPE_PERSONAL = "personal";
    private static final String USER_TYPE_CORPORATION = "corporation";

    /**
     * 汇款人:自己
     */
    private static final String SENDER_MYSELF = "Myself";

    /**
     * 汇款人:他人
     */
    private static final String SENDER_OTHERS = "Others";

    /**
     * 用户类型：个人
     */
    private static final String SENDER_TYPE_INDIVIDUAL  = "Individual";

    /**
     * 用户类型：企业
     */
    private static final String SENDER_TYPE_CORPORATE = "Corporate";

    private static final String OTHER = "other";

    /**
     * 验证授权参数
     * @param code           SysCode
     * @param accountNo       客户端的ID
     * @param walletTypeCode wallet类型代码
     * @return ResultBean
     */
    public static ResultBean validateAuthorizationParams( String code, String accountNo, String walletTypeCode) {
        ResultBean resultBean = new ResultBean();

        // code
        if (StringUtil.isBlank(code)) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("code" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
        String codeText = Base64Util.decrypt(code);
        if (!SYSTEM_CODE.equals(codeText)) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("code" + StatusEnum.PARAM_ERROR.getMsg());
        }

        // accountNo
        if (StringUtil.isBlank(accountNo)) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("accountNo" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }

        // walletTypeCode
        if (StringUtil.isBlank(walletTypeCode)) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR);
            resultBean.setMessage("walletTypeCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }

        return resultBean;
    }

    /**
     * 验证推荐参数
     *
     * @param condition 参数
     * @return ResultBean
     */
    public static ResultBean validateCommonParam(GetBankParam condition) {
        ResultBean resultBean = new ResultBean();

        if (StringUtil.isBlank(condition.getCountryCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("CountryCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }

        if (StringUtil.isBlank(condition.getCurrencyCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("Currency" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }

        if (condition.getAmount() == null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("Amount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }

        return resultBean;
    }

    /**
     * 验证GC推荐参数
     *
     * @param condition 参数
     * @return ResultBean
     */
    public static ResultBean checkGcRecommendParam(GetBankParam condition) {
        ResultBean resultBean = validateCommonParam(condition);

        if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {

            // 单笔金额过低无推荐银行
            BigDecimal currencyMinLimit = GlobalCollectConstants.CURRENCY_MIN_LIMIT.get(condition.getCurrencyCode());
            if (currencyMinLimit != null) {

                if (currencyMinLimit.compareTo(condition.getAmount()) > 0) {
                    resultBean.setStatus(StatusEnum.EXCEED_MIN);
                    return resultBean;
                }
            }

            // 单笔金额过大无推荐银行
            BigDecimal currencyMaxLimit = GlobalCollectConstants.CURRENCY_MAX_LIMIT.get(condition.getCurrencyCode());
            if (currencyMaxLimit != null) {
                if (currencyMaxLimit.compareTo(condition.getAmount()) < 0) {
                    resultBean.setStatus(StatusEnum.EXCEED_MAX);
                    return resultBean;
                }
            }
        }

        return resultBean;
    }

    /**
     * 验证Reference推荐参数
     *
     * @param condition 参数
     * @return ResultBean
     */
    public static ResultBean checkRefRecommendParam(GetBankParam condition) {
        ResultBean resultBean = validateCommonParam(condition);
        if (StatusEnum.SUCCESS.getCode() == resultBean.getStatus()) {

            if (StringUtil.isBlank(condition.getSender()) ||
                    !(  SENDER_MYSELF .equals(condition.getSender())
                            || SENDER_OTHERS.equals(condition.getSender()))) {

                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("Sender" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
            
            if(SENDER_OTHERS.equals(condition.getSender())) {
    
                if (StringUtil.isBlank(condition.getSenderType())
                        || !(SENDER_TYPE_INDIVIDUAL.equals(condition.getSenderType())
                        || SENDER_TYPE_CORPORATE.equals(condition.getSenderType()))) {
        
                    resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                    resultBean.setMessage("SenderType" + StatusEnum.PARAM_ERROR.getMsg());
                    return resultBean;
                }
            }
        }

        return resultBean;
    }

    /**
     * 验证Help2Pay推荐参数
     *
     * @param condition 参数
     * @return ResultBean
     */
    public static ResultBean checkH2pRecommendParam(GetBankParam condition) {
        ResultBean resultBean = validateCommonParam(condition);

        return resultBean;
    }

    

    /**
     * 验证GC银行信息
     *
     * @param gcConfirmParam GC银行信息
     * @return ResultBean
     */
    public static ResultBean checkGcConfirmParam(GcConfirmParam gcConfirmParam) {
        ResultBean resultBean = new ResultBean();
     
        if (StringUtil.isBlank(gcConfirmParam.getWalletTypeCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("WalletTypeCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (StringUtil.isBlank(gcConfirmParam.getFirstName())
            && StringUtil.isBlank(gcConfirmParam.getLastName())
                && StringUtil.isBlank(gcConfirmParam.getCorporateName())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("系统用户名称不能为空！");
            return resultBean;
        }
    
        if (StringUtil.isBlank(gcConfirmParam.getiAccountNo() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("系统账号iAccountNo不能为空！");
            return resultBean;
        }
    
        if (StringUtil.isBlank(gcConfirmParam.getEmail())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("Email" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
    
    
        if (StringUtil.isBlank(gcConfirmParam.getCountry() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("Country" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
    
        if (StringUtil.isBlank(gcConfirmParam.getSendingCurrency() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("sendingCurrency" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (gcConfirmParam.getAmount()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("amount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        
        
        if (StringUtil.isBlank(gcConfirmParam.getBenificiaryCurrency() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("benificiaryCurrency" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (gcConfirmParam.getExchangeRate()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("ExchangeRate" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        if (gcConfirmParam.getConvertedAmount()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("convertedAmount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
     
        if (gcConfirmParam.getFee()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("convertedAmount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (gcConfirmParam.getPaidAmount()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("paidAmount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
 
        if (gcConfirmParam.getPaidAmtAfterExchange()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("paidAmtAfterExchange" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (gcConfirmParam.getReflectedAmt()==null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("reflectedAmt" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
        
        if (StringUtil.isBlank(gcConfirmParam.getMerchantRef() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("merchantRef" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        if (StringUtil.isBlank(gcConfirmParam.getPaymentReferenceNo() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("paymentReferenceNo" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        if (gcConfirmParam.getOrderId() == null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("orderId" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        if (StringUtil.isBlank(gcConfirmParam.getAccountNumber() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("accountNumber" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
 
        if (StringUtil.isBlank(gcConfirmParam.getAccountHolderName() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("accountHolderName" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
        
        if (StringUtil.isBlank(gcConfirmParam.getBank() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("bank" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
     
        if (StringUtil.isBlank(gcConfirmParam.getCity() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("city" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
  
    
        if (StringUtil.isBlank(gcConfirmParam.getStatus() )) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("status" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        return resultBean;
    }

    /**
     * 验证获取ReferenceNo的参数合法性
     *
     * @param refDto 获取ReferenceNo的参数
     * @return ResultBean
     */
    public static ResultBean checkRefConfirmParam(RefConfirmParam refDto) {
        ResultBean resultBean = new ResultBean();
    
    
        if (StringUtil.isBlank(refDto.getWalletTypeCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("WalletTypeCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
  
        if (StringUtil.isBlank(refDto.getSender())
                || !(SENDER_MYSELF .equalsIgnoreCase(refDto.getSender())
                || SENDER_OTHERS.equalsIgnoreCase(refDto.getSender()))) {
        
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("sender" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
        
        if(SENDER_OTHERS.equalsIgnoreCase(refDto.getSender()) ) {
            if (StringUtil.isBlank(refDto.getSenderType())
                    || !(SENDER_TYPE_INDIVIDUAL.equalsIgnoreCase(refDto.getSenderType())
                    || SENDER_TYPE_CORPORATE.equalsIgnoreCase(refDto.getSenderType()))) {
            
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("senderType" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        }
        
        if (StringUtil.isBlank(refDto.getUserType())
                || !(USER_TYPE_PERSONAL.equalsIgnoreCase(refDto.getUserType())
                || USER_TYPE_CORPORATION.equalsIgnoreCase(refDto.getUserType()))) {
        
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("UserType" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (StringUtil.isBlank(refDto.getCountryCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("countryCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
  
        if (StringUtil.isBlank(refDto.getCurrencyCode())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("currencyCode" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if (StringUtil.isBlank(refDto.getAccountNo())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("accountNo" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if ( refDto.getAmount() == null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("amount" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        if ( refDto.getFiAccountID() == null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("fiAccountID" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
  
        if (StringUtil.isBlank(refDto.getAccountName())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("accountName" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
        
        if (StringUtil.isBlank(refDto.getEmail())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("email" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
    
        if (USER_TYPE_PERSONAL.equalsIgnoreCase(refDto.getUserType())) {
            if (StringUtil.isBlank(refDto.getFirstName())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("FirstName" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        
            if (StringUtil.isBlank(refDto.getLastName())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("LastName" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        
            if (StringUtil.isBlank(refDto.getBirthday())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("Birthday" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        }
    
        if (USER_TYPE_CORPORATION.equalsIgnoreCase(refDto.getUserType())) {
            if (StringUtil.isBlank(refDto.getCorporateName())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("CorporateName" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        
            if (StringUtil.isBlank(refDto.getEstablishmentDate())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("EstablishmentDate" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        }
        
        if (StringUtil.isBlank(refDto.getPurposeName())) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
            resultBean.setMessage("purposeName" + StatusEnum.PARAM_ERROR.getMsg());
            return resultBean;
        }
     
        String sender = refDto.getSender();
        String senderType =  refDto.getSenderType();

        if (SENDER_MYSELF.equals(sender)) {
            if (StringUtil.isBlank(refDto.getSourceOfFunds())) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("SourceOfFunds" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        }

        if (SENDER_OTHERS.equals(sender)) {
            if (StringUtil.isBlank(refDto.getPurposeName() )) {
                resultBean.setStatus(StatusEnum.PARAM_ERROR.getCode());
                resultBean.setMessage("Purpose" + StatusEnum.PARAM_ERROR.getMsg());
                return resultBean;
            }
        }

        return resultBean;
    }
 
    /**
     * 推荐方式
     * <p>
     * 1 - GC
     * 2 - Reference
     * 3 - Help2Pay
     *
     * @param method 方式
     * @param params 多种推荐方式使用横杠"-"连接
     * @return {@code true} params包含method
     */
    public static boolean isBankType(String method, String params) {

        String[] paramArr = params.trim().split("-");
        for (int i = 0; i < paramArr.length; i++) {
            if (method.equals(paramArr[i])) {
                return true;
            }
        }

        return false;
    }
}
