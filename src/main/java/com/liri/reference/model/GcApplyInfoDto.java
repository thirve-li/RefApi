package com.liri.reference.model;

import com.liri.reference.common.utils.StringUtil;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * GC
 *
 * @author William
 * @date 2019/8/20
 */
public class GcApplyInfoDto implements Serializable {
    private static final long serialVersionUID = 6721324284521060015L;
    
    private String walletTypeCode;
    
    private String schema;
    
    private Integer id;

    private String country;

    private String sendingCurrency;

    private BigDecimal amount;

    private String benificiaryCurrency;

    private BigDecimal exchangeRate;

    private BigDecimal convertedAmount;

    private String firstName;

    private String lastName;

    private String iAccountNo;

    private String paymentReferenceNo;

    private String email;

    private BigDecimal fee;

    private String status;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private Integer isDelete;

    private String remark;

    private Integer version;

    private BigDecimal paidAmount;

    private Integer orderId;

    private String merchantRef;

    private BigDecimal paidAmtAfterExchange;

    private BigDecimal reflectedAmt;

    private Integer rejectionCode;

    private String lastStatus;

    private String paymentMethod;

    private String accountNumber;

    private String accountHolderName;

    private String bank;

    private String city;

    private String iban;

    private String countrySpecificBankID;

    private String swiftCode;

    private String message;

    private String corporateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPaymentReferenceNo() {
        return paymentReferenceNo;
    }

    public void setPaymentReferenceNo(String paymentReferenceNo) {
        this.paymentReferenceNo = paymentReferenceNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMerchantRef() {
        return merchantRef;
    }

    public void setMerchantRef(String merchantRef) {
        this.merchantRef = merchantRef;
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

    public Integer getRejectionCode() {
        return rejectionCode;
    }

    public void setRejectionCode(Integer rejectionCode) {
        this.rejectionCode = rejectionCode;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
    
    public String getWalletTypeCode() {
        return walletTypeCode;
    }
    
    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
    }
    
    public String getSchema() {
        return schema;
    }
    
    public void setSchema(String schema) {
        if(StringUtil.isBlank(schema) || "IAC".equalsIgnoreCase(schema)){
            this.schema = "MoneyInOut";
        }
        this.schema = "MoneyInOut_"+schema;
    }
    @Override
    public String toString() {
        return "GcApplyInfoDto{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", sendingCurrency='" + sendingCurrency + '\'' +
                ", amount='" + amount + '\'' +
                ", benificiaryCurrency='" + benificiaryCurrency + '\'' +
                ", exchangeRate='" + exchangeRate + '\'' +
                ", convertedAmount='" + convertedAmount + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", iAccountNo='" + iAccountNo + '\'' +
                ", paymentReferenceNo='" + paymentReferenceNo + '\'' +
                ", email='" + email + '\'' +
                ", fee='" + fee + '\'' +
                ", status='" + status + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", isDelete=" + isDelete +
                ", remark='" + remark + '\'' +
                ", version=" + version +
                ", paidAmount=" + paidAmount +
                ", orderId=" + orderId +
                ", merchantRef='" + merchantRef + '\'' +
                ", paidAmtAfterExchange=" + paidAmtAfterExchange +
                ", reflectedAmt=" + reflectedAmt +
                ", rejectionCode=" + rejectionCode +
                ", lastStatus='" + lastStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", bank='" + bank + '\'' +
                ", city='" + city + '\'' +
                ", iban='" + iban + '\'' +
                ", countrySpecificBankID='" + countrySpecificBankID + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", message='" + message + '\'' +
                ", corporateName='" + corporateName + '\'' +
                '}';
    }
}
