package com.liri.reference.model;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class MstFiAccount implements Serializable {
    private Integer fiAccountID;
    private Integer fiID;
    private String fiAccountNo;
    private String fiAccountType;
    private String fiAccountPurpose;
    private String fiAccountAddress;
    
    private String bankName;
    private String bankBranchAddress;
    private String branch;
    private String currencyCode;
    
    private String iban;
    private String inCurrencyCode;
    private BigDecimal maxMoneyInAmount;
    private BigDecimal maxMoneyOutAmount;
    private String country;
    private Integer countryPriority;
    private Integer regionPriority;
    private Integer globalPriority;
    private String inFeeCurrency;
    private BigDecimal inFeeAmount;
    private BigDecimal inMinFeeAmount;
    private BigDecimal inMaxFeeAmount;
    private String outFeeCurrency;
    private BigDecimal outFeeAmount;
    private BigDecimal outMinFeeAmount;
    private BigDecimal outMaxFeeAmount;
    private BigDecimal fiBalance;
    private BigDecimal fiReservedAmount;
    private BigDecimal fiReservedCancelAmount;
    private String startDate;
    private String endDate;
    private String remarks;
    private String createTime;
    private Integer createUser;
    private String updateTime;
    private Integer updateUser;
    private Integer isDelete;
    private Integer version;
    private String currencyCodeOut;
    private BigDecimal minMoneyInAmount;
    private BigDecimal minMoneyOutAmount;
    private Integer countryPriorityOut;
    private Integer regionPriorityOut;
    private Integer globalPriorityOut;
    private String startDateOut;
    


    public String getCurrencyCodeOut() {
        return currencyCodeOut;
    }

    public void setCurrencyCodeOut(String currencyCodeOut) {
        this.currencyCodeOut = currencyCodeOut;
    }

    public BigDecimal getMinMoneyInAmount() {
        return minMoneyInAmount;
    }

    public void setMinMoneyInAmount(BigDecimal minMoneyInAmount) {
        this.minMoneyInAmount = minMoneyInAmount;
    }

    public BigDecimal getMinMoneyOutAmount() {
        return minMoneyOutAmount;
    }

    public void setMinMoneyOutAmount(BigDecimal minMoneyOutAmount) {
        this.minMoneyOutAmount = minMoneyOutAmount;
    }

    public Integer getCountryPriorityOut() {
        return countryPriorityOut;
    }

    public void setCountryPriorityOut(Integer countryPriorityOut) {
        this.countryPriorityOut = countryPriorityOut;
    }

    public Integer getRegionPriorityOut() {
        return regionPriorityOut;
    }

    public void setRegionPriorityOut(Integer regionPriorityOut) {
        this.regionPriorityOut = regionPriorityOut;
    }

    public Integer getGlobalPriorityOut() {
        return globalPriorityOut;
    }

    public void setGlobalPriorityOut(Integer globalPriorityOut) {
        this.globalPriorityOut = globalPriorityOut;
    }

    public String getStartDateOut() {
        return startDateOut;
    }

    public void setStartDateOut(String startDateOut) {
        this.startDateOut = startDateOut;
    }

    public String getEndDateOut() {
        return endDateOut;
    }

    public void setEndDateOut(String endDateOut) {
        this.endDateOut = endDateOut;
    }

    private String endDateOut;

    public Integer getFiAccountID() {
        return fiAccountID;
    }

    public void setFiAccountID(Integer fiAccountID) {
        this.fiAccountID = fiAccountID;
    }

    public String getFiAccountNo() {
        return fiAccountNo;
    }

    public void setFiAccountNo(String fiAccountNo) {
        this.fiAccountNo = fiAccountNo;
    }

    public String getFiAccountType() {
        return fiAccountType;
    }

    public void setFiAccountType(String fiAccountType) {
        this.fiAccountType = fiAccountType;
    }

    public String getFiAccountPurpose() {
        return fiAccountPurpose;
    }

    public void setFiAccountPurpose(String fiAccountPurpose) {
        this.fiAccountPurpose = fiAccountPurpose;
    }

    public String getInCurrencyCode() {
        return inCurrencyCode;
    }

    public void setInCurrencyCode(String inCurrencyCode) {
        this.inCurrencyCode = inCurrencyCode;
    }

    public BigDecimal getMaxMoneyInAmount() {
        return maxMoneyInAmount;
    }

    public void setMaxMoneyInAmount(BigDecimal maxMoneyInAmount) {
        this.maxMoneyInAmount = maxMoneyInAmount;
    }

    public BigDecimal getMaxMoneyOutAmount() {
        return maxMoneyOutAmount;
    }

    public void setMaxMoneyOutAmount(BigDecimal maxMoneyOutAmount) {
        this.maxMoneyOutAmount = maxMoneyOutAmount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCountryPriority() {
        return countryPriority;
    }

    public void setCountryPriority(Integer countryPriority) {
        this.countryPriority = countryPriority;
    }

    public Integer getRegionPriority() {
        return regionPriority;
    }

    public void setRegionPriority(Integer regionPriority) {
        this.regionPriority = regionPriority;
    }

    public Integer getGlobalPriority() {
        return globalPriority;
    }

    public void setGlobalPriority(Integer globalPriority) {
        this.globalPriority = globalPriority;
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

    public BigDecimal getInMinFeeAmount() {
        return inMinFeeAmount;
    }

    public void setInMinFeeAmount(BigDecimal inMinFeeAmount) {
        this.inMinFeeAmount = inMinFeeAmount;
    }

    public BigDecimal getInMaxFeeAmount() {
        return inMaxFeeAmount;
    }

    public void setInMaxFeeAmount(BigDecimal inMaxFeeAmount) {
        this.inMaxFeeAmount = inMaxFeeAmount;
    }

    public String getOutFeeCurrency() {
        return outFeeCurrency;
    }

    public void setOutFeeCurrency(String outFeeCurrency) {
        this.outFeeCurrency = outFeeCurrency;
    }

    public BigDecimal getOutFeeAmount() {
        return outFeeAmount;
    }

    public void setOutFeeAmount(BigDecimal outFeeAmount) {
        this.outFeeAmount = outFeeAmount;
    }

    public BigDecimal getOutMinFeeAmount() {
        return outMinFeeAmount;
    }

    public void setOutMinFeeAmount(BigDecimal outMinFeeAmount) {
        this.outMinFeeAmount = outMinFeeAmount;
    }

    public BigDecimal getOutMaxFeeAmount() {
        return outMaxFeeAmount;
    }

    public void setOutMaxFeeAmount(BigDecimal outMaxFeeAmount) {
        this.outMaxFeeAmount = outMaxFeeAmount;
    }

    public BigDecimal getFiBalance() {
        return fiBalance;
    }

    public void setFiBalance(BigDecimal fiBalance) {
        this.fiBalance = fiBalance;
    }

    public BigDecimal getFiReservedAmount() {
        return fiReservedAmount;
    }

    public void setFiReservedAmount(BigDecimal fiReservedAmount) {
        this.fiReservedAmount = fiReservedAmount;
    }

    public BigDecimal getFiReservedCancelAmount() {
        return fiReservedCancelAmount;
    }

    public void setFiReservedCancelAmount(BigDecimal fiReservedCancelAmount) {
        this.fiReservedCancelAmount = fiReservedCancelAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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

    public Integer getFiID() {
        return fiID;
    }

    public void setFiID(Integer fiID) {
        this.fiID = fiID;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getFiAccountAddress() {
		return fiAccountAddress;
	}

	public void setFiAccountAddress(String fiAccountAddress) {
		this.fiAccountAddress = fiAccountAddress;
	}

}
