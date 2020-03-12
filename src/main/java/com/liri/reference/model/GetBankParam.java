package com.liri.reference.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 推荐条件
 *
 * @author William
 * @date 2019/10/14
 */
public class GetBankParam implements Serializable {

    private static final long serialVersionUID = 1019178726219701037L;
    
    
    /**
     * 国家2位代码
     */
    private String countryCode;
    
    /**
     * 汇款币种
     */
    private String currencyCode;

    /**
     * 汇款金额
     */
    private BigDecimal amount;

    /**
     * 用户类型，个人 personal 法人 corporation、
     */
    private String userType;

    /**
     * 汇款人，值为：Myself / Others
     * <p>
     * 对应ARMS中的 DepositorType
     * <p>
     * Reference推荐独有参数
     */
    private String sender;

    /**
     * 汇款人类别，值为：Individual / Corporate
     * <p>
     * 对应ARMS中的 DepositorEntityType
     * <p>
     * Reference推荐独有参数
     */
    private String senderType;
    
    /**
     * Wallet的AccountNo
     */
    private String accountNo;
    
    /**
     * Wallet的代号
     */
    private String walletTypeCode;
    
    public String getCountryCode() {
        return countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getSender() {
        return sender;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public String getSenderType() {
        return senderType;
    }
    
    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }
    
    public String getAccountNo() {
        return accountNo;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    public String getWalletTypeCode() {
        return walletTypeCode;
    }
    
    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
    }
    
}
