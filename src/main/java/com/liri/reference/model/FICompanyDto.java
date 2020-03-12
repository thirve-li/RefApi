package com.liri.reference.model;

import com.liri.reference.common.utils.DateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


 
public class FICompanyDto implements Serializable {

	private static final long serialVersionUID = -6238073380307288956L;

	private String fiFullName;

	private String fiAddress;

	private String bankCountry;

	private String swiftCode;

	private String fullName;

	private String comCountry;

	private String address;

	private String fiAccountNo;

	private List<List<MstFiAccountDto>> childFiActList;

	private int fiID;

	private String fiCode;

	private int countryPriority;

	private int regionPriority;

	private int globalPriority;

	private String inFeeCurrency;

	private BigDecimal inFeeAmount;

	private BigDecimal maxMoney;

	private BigDecimal fiBalance;

	private Boolean mailFlag;

	private int fiAccountID;

	private String iban;

	private String inCurrencyCode;

	private String accountLang;

	private String createTime;

	private String fiAccountMemo;

	private String fiAccountMemoShow;

	private String currentYear;

	private String depositorType;

	private String refInDepositorEntityType;

	private int refInNameAccumulativeAmount;

	/** 0 不需要，1 需要 **/
	private Integer needKyc;

	/**
	 * 是否需要填写KycMemo Y:需要 N：不需要
	 */
	private String needKycMemo;

	/**
	 * 是否需要上传Myself的图片 Y:需要 N：不需要
	 */
	private String needSupportEvidence;

	/**
	 * 是否需要上传Others的 Individual的图片 Y:需要 N：不需要
	 */
	private String needSenderIdEvidence;

	/**
	 * 是否需要上传Others的 Individual的图片 Y:需要 N：不需要
	 */
	private String needSenderAddressEvidence;

	/**
	 * 是否需要上传Others的Corporate图片 Y:需要 N：不需要
	 */
	private String needCorporateEvidence;

	/**
	 * 是否需要上传Others的 Individual的图片 Y:需要 N：不需要
	 */
	private String needRemittanceEvidence;

	/**
	 * 是否需要上传Others的Corporate图片 Y:需要 N：不需要
	 */
	private String needCorporateSupportEvidence;
	
    private String bankName;//fiFullName
    private String bankBranchAddress;//fiAddress
    private String branch;
    private String branchCode;
    private String fiAccountName;//fullName
    private String fiAccountAddress;//》address
	
	/**
	 * 公司编号
	 */
	private String companyId;
	
	/**
	 * 汇款类型: 1 - LBT(Local Bank Transfer); 2 - Intenational;
	 */
	private String method;

	/**
	 * 充值方式: 1 - Domestic remittance; 2 - Overseas remittance
	 */
	private String topUpWay;

	/**
	 * 银行的fiSimpleName
	 */
	private String fiSimpleName;

	public Integer getNeedKyc() {
		return needKyc;
	}

	public void setNeedKyc(Integer needKyc) {
		this.needKyc = needKyc;
	}

	/**
	 * 1 vip 0 no
	 */
	private Integer isVIP;

	public String getRefInDepositorEntityType() {
		return refInDepositorEntityType;
	}

	public void setRefInDepositorEntityType(String refInDepositorEntityType) {
		this.refInDepositorEntityType = refInDepositorEntityType;
	}

	public Integer getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(Integer isVIP) {
		this.isVIP = isVIP;
	}

	public String getCurrentYear() {
		this.currentYear = DateUtil.getCurrentDate("yyyy");
		return currentYear;
	}

	public String getFiFullName() {
		return bankName;
	}

	public void setFiFullName(String fiFullName) {
		this.fiFullName = fiFullName;
	}

	public String getFiAddress() {
		return bankBranchAddress;
	}

	public void setFiAddress(String fiAddress) {
		this.fiAddress = fiAddress;
	}

	public String getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getFullName() {
		return fiAccountName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getComCountry() {
		return comCountry;
	}

	public void setComCountry(String comCountry) {
		this.comCountry = comCountry;
	}

	public String getAddress() {
		return fiAccountAddress;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFiAccountNo() {
		return fiAccountNo;
	}

	public void setFiAccountNo(String fiAccountNo) {
		this.fiAccountNo = fiAccountNo;
	}

	public int getCountryPriority() {
		return countryPriority;
	}

	public void setCountryPriority(int countryPriority) {
		this.countryPriority = countryPriority;
	}

	public int getFiID() {
		return fiID;
	}

	public void setFiID(int fiID) {
		this.fiID = fiID;
	}

	public String getInFeeCurrency() {
		return inFeeCurrency;
	}

	public void setInFeeCurrency(String inFeeCurrency) {
		this.inFeeCurrency = inFeeCurrency;
	}

	public BigDecimal getInFeeAmount() {
		return inFeeAmount;
	}

	public void setInFeeAmount(BigDecimal inFeeAmount) {
		this.inFeeAmount = inFeeAmount;
	}

	public int getGlobalPriority() {
		return globalPriority;
	}

	public void setGlobalPriority(int globalPriority) {
		this.globalPriority = globalPriority;
	}

	public int getRegionPriority() {
		return regionPriority;
	}

	public void setRegionPriority(int regionPriority) {
		this.regionPriority = regionPriority;
	}

	public BigDecimal getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
	}

	public BigDecimal getFiBalance() {
		return fiBalance == null ? new BigDecimal(0) : fiBalance;
	}

	public void setFiBalance(BigDecimal fiBalance) {
		this.fiBalance = fiBalance;
	}

	public Boolean getMailFlag() {
		return mailFlag;
	}

	public void setMailFlag(Boolean mailFlag) {
		this.mailFlag = mailFlag;
	}

	public String getFiCode() {
		return fiCode;
	}

	public void setFiCode(String fiCode) {
		this.fiCode = fiCode;
	}

	public int getFiAccountID() {
		return fiAccountID;
	}

	public void setFiAccountID(int fiAccountID) {
		this.fiAccountID = fiAccountID;
	}

	public String getIban() {
		return iban == null ? "" : iban.trim();
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getInCurrencyCode() {
		return inCurrencyCode;
	}

	public void setInCurrencyCode(String inCurrencyCode) {
		this.inCurrencyCode = inCurrencyCode;
	}

	public String getAccountLang() {
		return accountLang;
	}

	public void setAccountLang(String accountLang) {
		this.accountLang = accountLang;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFiAccountMemo() {
		return fiAccountMemo == null ? "" : fiAccountMemo;
	}

	public void setFiAccountMemo(String fiAccountMemo) {
		this.fiAccountMemo = fiAccountMemo;
	}

	public String getFiAccountMemoShow() {
		return getFiAccountMemo().replace("\r\n", "<br/>");
	}

	public List<List<MstFiAccountDto>> getChildFiActList() {
		return childFiActList;
	}

	public void setChildFiActList(List<List<MstFiAccountDto>> childFiActList) {
		this.childFiActList = childFiActList;
	}

	public String getDepositorType() {
		return depositorType;
	}

	public void setDepositorType(String depositorType) {
		this.depositorType = depositorType;
	}

	public int getRefInNameAccumulativeAmount() {
		return refInNameAccumulativeAmount;
	}

	public void setRefInNameAccumulativeAmount(int refInNameAccumulativeAmount) {
		this.refInNameAccumulativeAmount = refInNameAccumulativeAmount;
	}

	public String getNeedSupportEvidence() {
		return needSupportEvidence;
	}

	public void setNeedSupportEvidence(String needSupportEvidence) {
		this.needSupportEvidence = needSupportEvidence;
	}

	public String getNeedSenderIdEvidence() {
		return needSenderIdEvidence;
	}

	public void setNeedSenderIdEvidence(String needSenderIdEvidence) {
		this.needSenderIdEvidence = needSenderIdEvidence;
	}

	public String getNeedSenderAddressEvidence() {
		return needSenderAddressEvidence;
	}

	public void setNeedSenderAddressEvidence(String needSenderAddressEvidence) {
		this.needSenderAddressEvidence = needSenderAddressEvidence;
	}

	public String getNeedCorporateEvidence() {
		return needCorporateEvidence;
	}

	public void setNeedCorporateEvidence(String needCorporateEvidence) {
		this.needCorporateEvidence = needCorporateEvidence;
	}

	public String getNeedRemittanceEvidence() {
		return needRemittanceEvidence;
	}

	public void setNeedRemittanceEvidence(String needRemittanceEvidence) {
		this.needRemittanceEvidence = needRemittanceEvidence;
	}

	public String getNeedCorporateSupportEvidence() {
		return needCorporateSupportEvidence;
	}

	public void setNeedCorporateSupportEvidence(String needCorporateSupportEvidence) {
		this.needCorporateSupportEvidence = needCorporateSupportEvidence;
	}

	public String getNeedKycMemo() {
		return needKycMemo;
	}

	public void setNeedKycMemo(String needKycMemo) {
		this.needKycMemo = needKycMemo;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFiSimpleName() {
		return fiSimpleName;
	}

	public void setFiSimpleName(String fiSimpleName) {
		this.fiSimpleName = fiSimpleName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchAddress() {
		return bankBranchAddress;
	}

	public void setBankBranchAddress(String bankBranchAddress) {
		this.bankBranchAddress = bankBranchAddress;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getFiAccountName() {
		return fiAccountName;
	}

	public void setFiAccountName(String fiAccountName) {
		this.fiAccountName = fiAccountName;
	}

	public String getFiAccountAddress() {
		return fiAccountAddress;
	}

	public void setFiAccountAddress(String fiAccountAddress) {
		this.fiAccountAddress = fiAccountAddress;
	}

	public void setFiAccountMemoShow(String fiAccountMemoShow) {
		this.fiAccountMemoShow = fiAccountMemoShow;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTopUpWay() {
		return topUpWay;
	}

	public void setTopUpWay(String topUpWay) {
		this.topUpWay = topUpWay;
	}

}
