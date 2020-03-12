package com.liri.reference.model;

import java.io.Serializable;

/**
 * Help2Pay
 *
 * @author William
 * @date 2019/8/20
 */
public class H2PApplyDto implements Serializable {

    private static final long serialVersionUID = 7360451848208022388L;

    private Integer id;

    private String refNo;

    private String firstName;

    private String midName;

    private String lastName;

    private String remittanceCountry;

    private String remittanceCurrency;

    private String remittanceAmount;

    private String fee;

    private String iacReflectedCurrency;

    private String iacReflectedAmount;

    private String payingBank;

    private String iacNo;

    private String depositID;

    private String h2pTransationTime;

    private String h2pProcessingStatus;

    private String bankInDefectBreakDay;

    private String bankInDefectBreakMemo;

    private String iacTxtNo;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

    private String isDelete;

    private String version;

    private String remarks;

    private String clientIP;

    private String language;

    private String h2pResult;

    private String bankInDeal;

    private String rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
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

    public String getRemittanceCountry() {
        return remittanceCountry;
    }

    public void setRemittanceCountry(String remittanceCountry) {
        this.remittanceCountry = remittanceCountry;
    }

    public String getRemittanceCurrency() {
        return remittanceCurrency;
    }

    public void setRemittanceCurrency(String remittanceCurrency) {
        this.remittanceCurrency = remittanceCurrency;
    }

    public String getRemittanceAmount() {
        return remittanceAmount;
    }

    public void setRemittanceAmount(String remittanceAmount) {
        this.remittanceAmount = remittanceAmount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getIacReflectedCurrency() {
        return iacReflectedCurrency;
    }

    public void setIacReflectedCurrency(String iacReflectedCurrency) {
        this.iacReflectedCurrency = iacReflectedCurrency;
    }

    public String getIacReflectedAmount() {
        return iacReflectedAmount;
    }

    public void setIacReflectedAmount(String iacReflectedAmount) {
        this.iacReflectedAmount = iacReflectedAmount;
    }

    public String getPayingBank() {
        return payingBank;
    }

    public void setPayingBank(String payingBank) {
        this.payingBank = payingBank;
    }

    public String getIacNo() {
        return iacNo;
    }

    public void setIacNo(String iacNo) {
        this.iacNo = iacNo;
    }

    public String getDepositID() {
        return depositID;
    }

    public void setDepositID(String depositID) {
        this.depositID = depositID;
    }

    public String getH2pTransationTime() {
        return h2pTransationTime;
    }

    public void setH2pTransationTime(String h2pTransationTime) {
        this.h2pTransationTime = h2pTransationTime;
    }

    public String getH2pProcessingStatus() {
        return h2pProcessingStatus;
    }

    public void setH2pProcessingStatus(String h2pProcessingStatus) {
        this.h2pProcessingStatus = h2pProcessingStatus;
    }

    public String getBankInDefectBreakDay() {
        return bankInDefectBreakDay;
    }

    public void setBankInDefectBreakDay(String bankInDefectBreakDay) {
        this.bankInDefectBreakDay = bankInDefectBreakDay;
    }

    public String getBankInDefectBreakMemo() {
        return bankInDefectBreakMemo;
    }

    public void setBankInDefectBreakMemo(String bankInDefectBreakMemo) {
        this.bankInDefectBreakMemo = bankInDefectBreakMemo;
    }

    public String getIacTxtNo() {
        return iacTxtNo;
    }

    public void setIacTxtNo(String iacTxtNo) {
        this.iacTxtNo = iacTxtNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getH2pResult() {
        return h2pResult;
    }

    public void setH2pResult(String h2pResult) {
        this.h2pResult = h2pResult;
    }

    public String getBankInDeal() {
        return bankInDeal;
    }

    public void setBankInDeal(String bankInDeal) {
        this.bankInDeal = bankInDeal;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
