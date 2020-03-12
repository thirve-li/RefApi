package com.liri.reference.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class GcConfirmParam implements Serializable {
    
    /**
     * Wallet代号
     * 必填
     */
    private String walletTypeCode;
    
    /**
     * Wallet个人用户的姓
     * 个人用户时必填
     */
    private String firstName;
    /**
     * Wallet个人用户的名
     */
    private String lastName;
    
    /**
     * wallet系统账号
     * 必填
     */
    private String iAccountNo;
    
    /**
     * wallet用户Email
     * 必填
     */
    private String email;
    
    /**
     * 法人名
     * 法人用户时必填
     */
    private String corporateName;
    
    /**
     * 出金国家code
     * 必填
     */
    private String country;
    
    /**
     * 出金币种code
     * 必填
     */
    private String sendingCurrency;
    
    /**
     * 出金金额
     * 必填
     */
    private BigDecimal amount;
   
    /**
     * 收款币种code
     * 必填
     */
    private String benificiaryCurrency;
    
    /**
     * 出金币种和收款币种的汇率
     * 必填
     */
    private BigDecimal exchangeRate;
    
    /**
     * 汇率转换后的到账币种金额
     * 必填
     */
    private BigDecimal convertedAmount;
    
    /**
     * 手续费
     * 必填
     */
    private BigDecimal fee;
    
    /**
     * 入金备注
     * 非必填
     */
    private String message;
    
    /**
     * 应付出金币种总金额
     * 必填
     */
    private BigDecimal paidAmount;
    
    /**
     * 应付到账币种总金额
     * 必填
     */
    private BigDecimal paidAmtAfterExchange;
    
    /**
     * 实际反映到账币种总金额
     * 必填
     */
    private BigDecimal reflectedAmt;
    
    /**
     * ARMS生成的Service Ref No
     * 必填
     */
    private String merchantRef;
    
    /**
     * GC生成的交易RefNo
     * 必填
     */
    private String paymentReferenceNo;
    
    /**
     * GC生成的orderId
     * 必填
     */
    private Integer orderId;
    
    /**
     * GC生成的到账银行账号
     * 必填
     */
    private String accountNumber;
    
    /**
     * GC生成的到账银行账号名称
     */
    private String accountHolderName;
    
    /**
     * GC生成的到账银行名称
     * 必填
     */
    private String bank;
    
    /**
     * GC生成的到账银行所在城市
     * 必填
     */
    private String city;
    
    /**
     * GC生成的到账银行iban
     * 非必填
     */
    private String iban;
    
    /**
     * GC生成的到账银行ID
     * 非必填
     */
    private String countrySpecificBankID;
    
    /**
     * GC生成的到账银行swiftCode
     * 非必填
     */
    private String swiftCode;
    
    /**
     * GC生成的到账银行status
     * 非必填
     */
    private String status;
    
    public String getWalletTypeCode() {
        return walletTypeCode;
    }
    
    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getiAccountNo() {
        return iAccountNo;
    }
    
    public void setiAccountNo(String iAccountNo) {
        this.iAccountNo = iAccountNo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCorporateName() {
        return corporateName;
    }
    
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getSendingCurrency() {
        return sendingCurrency;
    }
    
    public void setSendingCurrency(String sendingCurrency) {
        this.sendingCurrency = sendingCurrency;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getBenificiaryCurrency() {
        return benificiaryCurrency;
    }
    
    public void setBenificiaryCurrency(String benificiaryCurrency) {
        this.benificiaryCurrency = benificiaryCurrency;
    }
    
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }
    
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    
    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }
    
    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
    
    public BigDecimal getFee() {
        return fee;
    }
    
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }
    
    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
    
    public BigDecimal getPaidAmtAfterExchange() {
        return paidAmtAfterExchange;
    }
    
    public void setPaidAmtAfterExchange(BigDecimal paidAmtAfterExchange) {
        this.paidAmtAfterExchange = paidAmtAfterExchange;
    }
    
    public BigDecimal getReflectedAmt() {
        return reflectedAmt;
    }
    
    public void setReflectedAmt(BigDecimal reflectedAmt) {
        this.reflectedAmt = reflectedAmt;
    }
    
    public String getMerchantRef() {
        return merchantRef;
    }
    
    public void setMerchantRef(String merchantRef) {
        this.merchantRef = merchantRef;
    }
    
    public String getPaymentReferenceNo() {
        return paymentReferenceNo;
    }
    
    public void setPaymentReferenceNo(String paymentReferenceNo) {
        this.paymentReferenceNo = paymentReferenceNo;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    public String getBank() {
        return bank;
    }
    
    public void setBank(String bank) {
        this.bank = bank;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getIban() {
        return iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }
    
    public String getCountrySpecificBankID() {
        return countrySpecificBankID;
    }
    
    public void setCountrySpecificBankID(String countrySpecificBankID) {
        this.countrySpecificBankID = countrySpecificBankID;
    }
    
    public String getSwiftCode() {
        return swiftCode;
    }
    
    public void setSwiftCode(String swiftcode) {
        this.swiftCode = swiftcode;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "GcConfirmParam{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", iAccountNo='" + iAccountNo + '\'' +
                ", email='" + email + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", country='" + country + '\'' +
                ", sendingCurrency='" + sendingCurrency + '\'' +
                ", amount=" + amount +
                ", benificiaryCurrency='" + benificiaryCurrency + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", convertedAmount=" + convertedAmount +
                ", fee=" + fee +
                ", message='" + message + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", paidAmtAfterExchange='" + paidAmtAfterExchange + '\'' +
                ", reflectedAmt=" + reflectedAmt +
                ", merchantRef='" + merchantRef + '\'' +
                ", paymentReferenceNo='" + paymentReferenceNo + '\'' +
                ", orderId=" + orderId +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", bank='" + bank + '\'' +
                ", city='" + city + '\'' +
                ", iban='" + iban + '\'' +
                ", countrySpecificBankID='" + countrySpecificBankID + '\'' +
                ", swiftcode='" + swiftCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
