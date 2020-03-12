package com.liri.reference.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RefConfirmParam implements Serializable  {
  
    /************Reference参数 开始*******************/
    //和数据库字段名不一样
    /**
     * Wallet的Code
     * 必填
      */
    private String walletTypeCode;
    /**
     * Reference入金类型 MySelf 或 Others
     * 必填
     */
    private String sender;
    
    /**
     * Reference入金类型 Individual 或 Corporate
     */
    private String senderType;
    /**
     * 用户类型 personal 或 corporation
     * 必填
     */
    private String userType;
    
    /**
     * 入金2位国家代码
     * 必填
     */
    private String countryCode;
    /**
     * 3位入金币种
     * 必填
     */
    private String currencyCode;
    
    /**
     * 系统账号
     * 必填
     */
    private String accountNo;
    
    /**
     * 入金金额
     * 必填
     */
    private BigDecimal amount;
    
    /**
     * 入金银行账号ID
     * 必填
     */
    private Long fiAccountID;
    
    /***********Session用户信息*********/
    /**
     * 系统用户账号名称
     * firstName+ middlename+lastName 或 法人名
     * 必填
     */
    private String accountName;
    
    /**
     * 系统用户生日
     * yyyy-MM-dd
     * 必填
     */
    private String birthday;
    
    /**
     * 系统用户地址
     * 非必填
     */
    private String streetAddress;
    
    /**
     * 系统用户Email
     * 必填
     */
    private String email;
    
    /***********MySelf或者others Individual时的个人信息*********/
    
    /**
     * 持卡人姓
     * 个人必填
     */
    private String firstName;
    
    /**
     * 持卡人中间名
     * 非必填
     */
    private String midName;
    
    /**
     * 持卡人名
     * 个人必填
     */
    private String lastName;
    
    
    /***********MySelf或者others Coporate时的法人信息*********/
    /**
     * 持卡法人名
     * 法人必填
     */
    private String corporateName;
    
    /**
     * 持卡法人号
     * 法人必填
     */
    private String corporateNum;
    
    /**
     * 系统法人成立日期
     * yyyy-MM-dd
     * 法人必填
     */
    private String establishmentDate;
    
    /***********入金目的、资金来源信息*********/
    
    /**
     * 资金来源
     * 必填
     */
    private String sourceOfFunds;
    
    /**
     * 目的
     * 必填
     */
    private String purposeName;
    
    /**
     * 其它目的描述
     * 非必填
     */
    private String detailsOfPurpose;
    
    /*****入金证明资料******/
    
    /**
     * 证明材料类型
     * 非必填
     */
    private String idType;
    /**
     * 证件号
     * 非必填
     */
    private String idNum;
    /**
     * 其它证件类型
     * 非必填
     */
    private String otherIdType;
    
    /**
     * 证件材料文件名
     * 非必填
     */
    private String supportEvidence;
    
    /**
     * 证件材料身份证文件名
     * 非必填
     */
    private String senderIdEvidence;
    /**
     * 证件材料地址证件文件名
     * 非必填
     */
    private String senderAddressEvidence;
    /**
     * 证件材料法人证件文件名
     * 非必填
     */
    private String corporateEvidence;
    /**
     * 证件材料法人证件文件名
     * 非必填
     */
    private String remittanceEvidence;
    /**
     * 法人证明
     * 非必填
     */
    private String corporateSupportEvidence;
    /**
     * 二位语言代码
     * 例如 en,cn,jp,kr
     * 非必填
     */
    private String lang;
 
    public String getWalletTypeCode() {
        return walletTypeCode;
    }
    
    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
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
    
    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
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
    
 
    public String getAccountNo() {
        return accountNo;
    }
    
 
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
 
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public Long getFiAccountID() {
        return fiAccountID;
    }
    
    public void setFiAccountID(Long fiAccountID) {
        this.fiAccountID = fiAccountID;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }
    
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMidName() {
        return midName;
    }
    
    public void setMidName(String midName) {
        this.midName = midName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getCorporateName() {
        return corporateName;
    }
    
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
    
    public String getCorporateNum() {
        return corporateNum;
    }
    
    public void setCorporateNum(String corporateNum) {
        this.corporateNum = corporateNum;
    }
    
    public String getEstablishmentDate() {
        return establishmentDate;
    }
    
    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
    
    public String getSourceOfFunds() {
        return sourceOfFunds;
    }
    
    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }
    
    public String getPurposeName() {
        return purposeName;
    }
    
    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }
    
    public String getDetailsOfPurpose() {
        return detailsOfPurpose;
    }
    
    public void setDetailsOfPurpose(String detailsOfPurpose) {
        this.detailsOfPurpose = detailsOfPurpose;
    }
    
    public String getIdType() {
        return idType;
    }
    
    public void setIdType(String idType) {
        this.idType = idType;
    }
    
    public String getIdNum() {
        return idNum;
    }
    
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    
    public String getOtherIdType() {
        return otherIdType;
    }
    
    public void setOtherIdType(String otherIdType) {
        this.otherIdType = otherIdType;
    }
    
    public String getSupportEvidence() {
        return supportEvidence;
    }
    
    public void setSupportEvidence(String supportEvidence) {
        this.supportEvidence = supportEvidence;
    }
    
    public String getSenderIdEvidence() {
        return senderIdEvidence;
    }
    
    public void setSenderIdEvidence(String senderIdEvidence) {
        this.senderIdEvidence = senderIdEvidence;
    }
    
    public String getSenderAddressEvidence() {
        return senderAddressEvidence;
    }
    
    public void setSenderAddressEvidence(String senderAddressEvidence) {
        this.senderAddressEvidence = senderAddressEvidence;
    }
    
    public String getCorporateEvidence() {
        return corporateEvidence;
    }
    
    public void setCorporateEvidence(String corporateEvidence) {
        this.corporateEvidence = corporateEvidence;
    }
    
    public String getRemittanceEvidence() {
        return remittanceEvidence;
    }
    
    public void setRemittanceEvidence(String remittanceEvidence) {
        this.remittanceEvidence = remittanceEvidence;
    }
    
    public String getCorporateSupportEvidence() {
        return corporateSupportEvidence;
    }
    
    public void setCorporateSupportEvidence(String corporateSupportEvidence) {
        this.corporateSupportEvidence = corporateSupportEvidence;
    }
    
    public String getLang() {
        return lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
    
    @Override
    public String toString() {
        return "GetRefDto{" +
                ", walletTypeCode='" + walletTypeCode + '\'' +
                ", sender='" + sender + '\'' +
                ", senderType='" + senderType + '\'' +
                ", userType='" + userType + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", amount=" + amount +
                ", fiAccountID=" + fiAccountID +
                ", accountName='" + accountName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", corporateNum='" + corporateNum + '\'' +
                ", establishmentDate='" + establishmentDate + '\'' +
                ", sourceOfFunds='" + sourceOfFunds + '\'' +
                ", purposeName='" + purposeName + '\'' +
                ", detailsOfPurpose='" + detailsOfPurpose + '\'' +
                ", idType='" + idType + '\'' +
                ", idNum='" + idNum + '\'' +
                ", otherIdType='" + otherIdType + '\'' +
                ", supportEvidence='" + supportEvidence + '\'' +
                ", senderIdEvidence='" + senderIdEvidence + '\'' +
                ", senderAddressEvidence='" + senderAddressEvidence + '\'' +
                ", corporateEvidence='" + corporateEvidence + '\'' +
                ", remittanceEvidence='" + remittanceEvidence + '\'' +
                ", corporateSupportEvidence='" + corporateSupportEvidence + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
    
}
