package com.liri.reference.model;

import com.liri.reference.common.utils.StringUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Reference
 *
 * @author William
 * @date 2019/8/20
 */
public class ReferenceInfoDto implements Serializable {

    private static final long serialVersionUID = 8608105289258840936L;

    private Long refID;

    private Long fiAccountID;

    private String refNo;

    private String countryCode;

    private String targetCurrencyCode;

    private String iaccountNo;

    private BigDecimal amount;

    private Timestamp refCreatedTimestamp;

    private Integer isDownload;

    private Timestamp downloadTimestamp;

    private Integer isCMSSync;

    private Timestamp cmssyncTimestamp;

    private String actualReceiveMoneyDay;

    private String actualSendMoneyUser;

    private String actualAcceptBank;

    private String actualInAccountNo;

    private String actualInCurrencyCode;

    private BigDecimal actualReactionAmount;

    private String actualInPeriod;

    private String actualInSourceBank;

    private String actualInMessage;

    private String actualInComment;

    private String actualReceiveOrg;

    private String slipNo;

    private BigDecimal actualInAmount;

    private BigDecimal actualCharge;

    private String actualType;

    private String actualDescription;

    private String actualStatementFileName;

    private String remarks;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    private Integer isDelete;

    private Integer version;

    private String processorIacNo;

    private String processorEmail;

    private String walletTypeSchema;
    
    private Long walletTypeID;

    private String sender;

    private String userType;

    private String firstName;

    private String midName;

    private String lastName;

    private String senderEmail;

    private String corporateName;

    private String wayOfTransfer;

    private String wayOfTransferCode;

    private String sourceOfFunds;

    private String sourceOfFundsCode;

    private String reason;

    private String otherWay;

    private String senderType;

    private String othersEmail;

    private String purpose;

    private String purposeName;

    private String detailsOfPurpose;

    private String birthday;

    private String streetAddress;

    private String idType;

    private String idNum;

    private String establishmentDate;

    private String corporateNum;

    private String otherIdType;

    private String supportEvidence;

    private String senderIdEvidence;

    private String senderAddressEvidence;

    private String corporateEvidence;

    private String remittanceEvidence;

    private String corporateSupportEvidence;

    private String legalStatus;

    private String legalReason;

    private String legalOptUser;

    private String opsStatus;

    private String opsReason;

    private String opsOptUser;

    private String abdMemo;

    private String accountName;

    private String lang;

    private String iLexUserID;

    private String ticketNum;

    private String kycMemo;

    public Long getRefID() {
        return refID;
    }

    public void setRefID(Long refID) {
        this.refID = refID;
    }

    public Long getFiAccountID() {
        return fiAccountID;
    }

    public void setFiAccountID(Long fiAccountID) {
        this.fiAccountID = fiAccountID;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public String getIaccountNo() {
        return iaccountNo;
    }

    public void setIaccountNo(String iaccountNo) {
        this.iaccountNo = iaccountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getRefCreatedTimestamp() {
        return refCreatedTimestamp;
    }

    public void setRefCreatedTimestamp(Timestamp refCreatedTimestamp) {
        this.refCreatedTimestamp = refCreatedTimestamp;
    }

    public Integer getIsDownload() {
        return isDownload;
    }

    public void setIsDownload(Integer isDownload) {
        this.isDownload = isDownload;
    }

    public Timestamp getDownloadTimestamp() {
        return downloadTimestamp;
    }

    public void setDownloadTimestamp(Timestamp downloadTimestamp) {
        this.downloadTimestamp = downloadTimestamp;
    }

    public Integer getIsCMSSync() {
        return isCMSSync;
    }

    public void setIsCMSSync(Integer isCMSSync) {
        this.isCMSSync = isCMSSync;
    }

    public Timestamp getCmssyncTimestamp() {
        return cmssyncTimestamp;
    }

    public void setCmssyncTimestamp(Timestamp cmssyncTimestamp) {
        this.cmssyncTimestamp = cmssyncTimestamp;
    }

    public String getActualReceiveMoneyDay() {
        return actualReceiveMoneyDay;
    }

    public void setActualReceiveMoneyDay(String actualReceiveMoneyDay) {
        this.actualReceiveMoneyDay = actualReceiveMoneyDay;
    }

    public String getActualSendMoneyUser() {
        return actualSendMoneyUser;
    }

    public void setActualSendMoneyUser(String actualSendMoneyUser) {
        this.actualSendMoneyUser = actualSendMoneyUser;
    }

    public String getActualAcceptBank() {
        return actualAcceptBank;
    }

    public void setActualAcceptBank(String actualAcceptBank) {
        this.actualAcceptBank = actualAcceptBank;
    }

    public String getActualInAccountNo() {
        return actualInAccountNo;
    }

    public void setActualInAccountNo(String actualInAccountNo) {
        this.actualInAccountNo = actualInAccountNo;
    }

    public String getActualInCurrencyCode() {
        return actualInCurrencyCode;
    }

    public void setActualInCurrencyCode(String actualInCurrencyCode) {
        this.actualInCurrencyCode = actualInCurrencyCode;
    }

    public BigDecimal getActualReactionAmount() {
        return actualReactionAmount;
    }

    public void setActualReactionAmount(BigDecimal actualReactionAmount) {
        this.actualReactionAmount = actualReactionAmount;
    }

    public String getActualInPeriod() {
        return actualInPeriod;
    }

    public void setActualInPeriod(String actualInPeriod) {
        this.actualInPeriod = actualInPeriod;
    }

    public String getActualInSourceBank() {
        return actualInSourceBank;
    }

    public void setActualInSourceBank(String actualInSourceBank) {
        this.actualInSourceBank = actualInSourceBank;
    }

    public String getActualInMessage() {
        return actualInMessage;
    }

    public void setActualInMessage(String actualInMessage) {
        this.actualInMessage = actualInMessage;
    }

    public String getActualInComment() {
        return actualInComment;
    }

    public void setActualInComment(String actualInComment) {
        this.actualInComment = actualInComment;
    }

    public String getActualReceiveOrg() {
        return actualReceiveOrg;
    }

    public void setActualReceiveOrg(String actualReceiveOrg) {
        this.actualReceiveOrg = actualReceiveOrg;
    }

    public String getSlipNo() {
        return slipNo;
    }

    public void setSlipNo(String slipNo) {
        this.slipNo = slipNo;
    }

    public BigDecimal getActualInAmount() {
        return actualInAmount;
    }

    public void setActualInAmount(BigDecimal actualInAmount) {
        this.actualInAmount = actualInAmount;
    }

    public BigDecimal getActualCharge() {
        return actualCharge;
    }

    public void setActualCharge(BigDecimal actualCharge) {
        this.actualCharge = actualCharge;
    }

    public String getActualType() {
        return actualType;
    }

    public void setActualType(String actualType) {
        this.actualType = actualType;
    }

    public String getActualDescription() {
        return actualDescription;
    }

    public void setActualDescription(String actualDescription) {
        this.actualDescription = actualDescription;
    }

    public String getActualStatementFileName() {
        return actualStatementFileName;
    }

    public void setActualStatementFileName(String actualStatementFileName) {
        this.actualStatementFileName = actualStatementFileName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProcessorIacNo() {
        return processorIacNo;
    }

    public void setProcessorIacNo(String processorIacNo) {
        this.processorIacNo = processorIacNo;
    }

    public String getProcessorEmail() {
        return processorEmail;
    }

    public void setProcessorEmail(String processorEmail) {
        this.processorEmail = processorEmail;
    }

    public String getWalletTypeSchema() {
        return walletTypeSchema;
    }

    public void setWalletTypeSchema(String walletTypeSchema) {
        if(StringUtil.isBlank(walletTypeSchema) || "IAC".equalsIgnoreCase(walletTypeSchema)){
            this.walletTypeSchema = "MoneyInOut";
        }
        this.walletTypeSchema = "MoneyInOut_"+walletTypeSchema;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getWayOfTransfer() {
        return wayOfTransfer;
    }

    public void setWayOfTransfer(String wayOfTransfer) {
        this.wayOfTransfer = wayOfTransfer;
    }

    public String getWayOfTransferCode() {
        return wayOfTransferCode;
    }

    public void setWayOfTransferCode(String wayOfTransferCode) {
        this.wayOfTransferCode = wayOfTransferCode;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getSourceOfFundsCode() {
        return sourceOfFundsCode;
    }

    public void setSourceOfFundsCode(String sourceOfFundsCode) {
        this.sourceOfFundsCode = sourceOfFundsCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOtherWay() {
        return otherWay;
    }

    public void setOtherWay(String otherWay) {
        this.otherWay = otherWay;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

    public String getOthersEmail() {
        return othersEmail;
    }

    public void setOthersEmail(String othersEmail) {
        this.othersEmail = othersEmail;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public String getLegalStatus() {
        return legalStatus;
    }

    public void setLegalStatus(String legalStatus) {
        this.legalStatus = legalStatus;
    }

    public String getLegalReason() {
        return legalReason;
    }

    public void setLegalReason(String legalReason) {
        this.legalReason = legalReason;
    }

    public String getLegalOptUser() {
        return legalOptUser;
    }

    public void setLegalOptUser(String legalOptUser) {
        this.legalOptUser = legalOptUser;
    }

    public String getOpsStatus() {
        return opsStatus;
    }

    public void setOpsStatus(String opsStatus) {
        this.opsStatus = opsStatus;
    }

    public String getOpsReason() {
        return opsReason;
    }

    public void setOpsReason(String opsReason) {
        this.opsReason = opsReason;
    }

    public String getOpsOptUser() {
        return opsOptUser;
    }

    public void setOpsOptUser(String opsOptUser) {
        this.opsOptUser = opsOptUser;
    }

    public String getAbdMemo() {
        return abdMemo;
    }

    public void setAbdMemo(String abdMemo) {
        this.abdMemo = abdMemo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getiLexUserID() {
        return iLexUserID;
    }

    public void setiLexUserID(String iLexUserID) {
        this.iLexUserID = iLexUserID;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getKycMemo() {
        return kycMemo;
    }

    public void setKycMemo(String kycMemo) {
        this.kycMemo = kycMemo;
    }
    public Long getWalletTypeID() {
        return walletTypeID;
    }
    
    public void setWalletTypeID(Long walletTypeID) {
        this.walletTypeID = walletTypeID;
    }
}
