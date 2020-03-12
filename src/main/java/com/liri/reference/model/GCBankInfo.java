package com.liri.reference.model;
import java.io.Serializable;

public class GCBankInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5723755034666754711L;

	private String bankName;

	private String bankCountry;

	private String method;

	private String walletTypeCode;

	private String functionCode;

	private String lang;

	// GC:PAYMENTREFERENCE
	private String paymentReferenceNo;

	// STATUSID
	private String status;

	// GC:STATUSDATE
	private String createTime;

	// GC:ORDERID
	private String orderId;

	// 账户号码 GC:BANKACCOUNTNUMBER
	private String accountNumber;

	// 账户持有人姓名 GC:ACCOUNTHOLDER
	private String accountHolderName;

	private String city;

	private String iban;

	private String swiftCode;

	// 国家特殊银行代码 GC:SPECIALID
	private String countrySpecificBankID;

	// GC_APPLY_INFO:MerchantRef
	private String serviceRefNo;

	// 汇款国家代码
	private String countryCode;

	// 汇款国家名称
	private String countryName;

	// 汇款币种
	private String currency;

	// 汇款金额
	private String amount;

	private String rate;

	// 收款币种
	private String targetCurrency;

	private String targetAmount;

	private String firstName;

	private String lastName;

	// 收款方wallet账号
	private String accountNo;

	private String email;

	private String fee;

	private String message;

	private String corporateName;

	/**
	 * 充值方式: 1 - Domestic remittance; 2 - Overseas remittance
	 */
	private String topUpWay;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getWalletTypeCode() {
		return walletTypeCode;
	}

	public void setWalletTypeCode(String walletTypeCode) {
		this.walletTypeCode = walletTypeCode;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getPaymentReferenceNo() {
		return paymentReferenceNo;
	}

	public void setPaymentReferenceNo(String paymentReferenceNo) {
		this.paymentReferenceNo = paymentReferenceNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
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

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getCountrySpecificBankID() {
		return countrySpecificBankID;
	}

	public void setCountrySpecificBankID(String countrySpecificBankID) {
		this.countrySpecificBankID = countrySpecificBankID;
	}

	public String getServiceRefNo() {
		return serviceRefNo;
	}

	public void setServiceRefNo(String serviceRefNo) {
		this.serviceRefNo = serviceRefNo;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
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

	public String getTopUpWay() {
		return topUpWay;
	}

	public void setTopUpWay(String topUpWay) {
		this.topUpWay = topUpWay;
	}

	@Override
	public String toString() {
		return "RecommendBank [bankName=" + bankName + ", bankCountry=" + bankCountry + ", method=" + method
				+ ", walletTypeCode=" + walletTypeCode + ", functionCode=" + functionCode + ", lang=" + lang
				+ ", paymentReferenceNo=" + paymentReferenceNo + ", status=" + status + ", createTime=" + createTime
				+ ", orderId=" + orderId + ", accountNumber=" + accountNumber + ", accountHolderName="
				+ accountHolderName + ", city=" + city + ", iban=" + iban + ", swiftCode=" + swiftCode
				+ ", countrySpecificBankID=" + countrySpecificBankID + ", serviceRefNo=" + serviceRefNo
				+ ", countryCode=" + countryCode + ", countryName=" + countryName + ", currency=" + currency
				+ ", amount=" + amount + ", rate=" + rate + ", targetCurrency=" + targetCurrency + ", targetAmount="
				+ targetAmount + ", firstName=" + firstName + ", lastName=" + lastName + ", accountNo=" + accountNo
				+ ", email=" + email + ", fee=" + fee + ", message=" + message + ", corporateName=" + corporateName
				+ ", topUpWay=" + topUpWay + "]";
	}

}
