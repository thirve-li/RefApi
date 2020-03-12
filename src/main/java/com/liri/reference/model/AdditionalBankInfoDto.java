package com.liri.reference.model;

import java.io.Serializable;

/**
 * 附加银行信息
 *
 * @author William
 * @date 2019/8/20
 */
public class AdditionalBankInfoDto implements Serializable {

    private static final long serialVersionUID = -1461467407380167639L;

    /**
     * 推荐方式
     * <p>
     * 1 - GC
     * 2 - Reference
     * 3 - Help2Pay
     */
    private String method;

    /**
     * ID 选择银行的唯一标识
     */
    private int id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 收款币种
     * <p>
     * GC推荐独有参数，对应BenificiaryCurrency字段
     */
    private String targetCurrency;

    /**
     * 收款金额
     * <p>
     * GC推荐独有参数，对应ConvertedAmount字段
     */
    private String targetAmount;

    /**
     * 汇率，汇款币种到收款币种的汇率
     * <p>
     * GC推荐独有参数，对应ExchangeRate
     */
    private String rate;

    /**
     * 备注信息
     * <p>
     * Reference推荐时，sender为Myself，sourceOfFunds为Other的时候必填，对应Reason字段
     */
    private String message;

    /**
     * 地址
     * <p>
     * Reference推荐独有参数
     */
    private String streetAddress;

    /**
     * 用户类型
     * <p>
     * Personal / Corporation
     * <p>
     * Reference推荐独有参数
     */
    private String userType;

    /**
     * 汇款人名字
     * <p>
     * 如果userType = "Personal"时必填
     */
    private String firstName;

    /**
     * 汇款人中间名
     * <p>
     * 如果userType = "Personal"时必填
     * <p>
     * Reference/Help2Pay推荐独有参数
     */
    private String midName;

    /**
     * 汇款人姓氏
     * <p>
     * 如果userType = "Personal"时必填
     */
    private String lastName;

    /**
     * 出生日期，格式yyyy-MM-dd
     * <p>
     * 如果userType = "Personal"时必填
     * <p>
     * Reference推荐独有参数
     */
    private String birthday;

    /**
     * 法人名称
     * <p>
     * 如果userType = "Corporation"时必填
     */
    private String corporateName;

    /**
     * 法人注册日期，格式yyyy-MM-dd
     * <p>
     * 如果userType = "Corporation"时必填
     * <p>
     * Reference推荐独有参数
     */
    private String establishmentDate;

    /**
     * 法人注册编号
     * <p>
     * sender为Others、senderType为Corporation的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String corporateNum;

    /**
     * 资金来源
     * <p>
     * sender为Myself的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String sourceOfFunds;

    /**
     * 其他邮箱
     * <p>
     * sender为Others、senderType为Personal的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String othersEmail;

    /**
     * ID类型
     * <p>
     * 0 - Others
     * 1 - Passport
     * 2 - Driving License
     * 3 - National ID
     * <p>
     * sender为Others、senderType为Personal的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String idType;

    /**
     * ID号码
     * <p>
     * sender为Others、senderType为Personal的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String idNum;

    /**
     * 汇款目的
     * <p>
     * sender为Others的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String purpose;

    /**
     * 汇款目的详情
     * <p>
     * sender为Others、purpose为other的时候必填
     * <p>
     * Reference推荐独有参数
     */
    private String detailsOfPurpose;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getCorporateNum() {
        return corporateNum;
    }

    public void setCorporateNum(String corporateNum) {
        this.corporateNum = corporateNum;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getOthersEmail() {
        return othersEmail;
    }

    public void setOthersEmail(String othersEmail) {
        this.othersEmail = othersEmail;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDetailsOfPurpose() {
        return detailsOfPurpose;
    }

    public void setDetailsOfPurpose(String detailsOfPurpose) {
        this.detailsOfPurpose = detailsOfPurpose;
    }

    @Override
    public String toString() {
        return "AdditionalBankInfoDto{" +
                "method='" + method + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", targetAmount='" + targetAmount + '\'' +
                ", rate='" + rate + '\'' +
                ", message='" + message + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", userType='" + userType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", establishmentDate='" + establishmentDate + '\'' +
                ", corporateNum='" + corporateNum + '\'' +
                ", sourceOfFunds='" + sourceOfFunds + '\'' +
                ", othersEmail='" + othersEmail + '\'' +
                ", idType='" + idType + '\'' +
                ", idNum='" + idNum + '\'' +
                ", purpose='" + purpose + '\'' +
                ", detailsOfPurpose='" + detailsOfPurpose + '\'' +
                '}';
    }
}
