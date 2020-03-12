package com.liri.reference.model;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class MstRate implements Serializable{
	private Integer rateID;
	private String rateGetDate;
	private String rateGetTime;
	private String currencyPair;
	private String currencyPairFrom;
	private String targetCurrencyTo;
	private BigDecimal currencyRate;
	private String sort;
	private String remarks;
	private String createTime;
	private Integer createUser;
	private String updateTime;
	private Integer updateUser;
	private Integer isDelete;
	private Integer version;
	
	public Integer getRateID() {
		return rateID;
	}
	
	public void setRateID(Integer rateID) {
		this.rateID = rateID;
	}
	
	public String getRateGetDate() {
		return rateGetDate;
	}
	
	public void setRateGetDate(String rateGetDate) {
		this.rateGetDate = rateGetDate;
	}
	
	public String getRateGetTime() {
		return rateGetTime;
	}
	
	public void setRateGetTime(String rateGetTime) {
		this.rateGetTime = rateGetTime;
	}
	
	public String getCurrencyPair() {
		return currencyPair;
	}
	
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	
	public String getCurrencyPairFrom() {
		return currencyPairFrom;
	}
	
	public void setCurrencyPairFrom(String currencyPairFrom) {
		this.currencyPairFrom = currencyPairFrom;
	}
	
	public String getTargetCurrencyTo() {
		return targetCurrencyTo;
	}
	
	public void setTargetCurrencyTo(String targetCurrencyTo) {
		this.targetCurrencyTo = targetCurrencyTo;
	}
	
	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}
	
	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}
	
	public String getSort() {
		return sort;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
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
	

}