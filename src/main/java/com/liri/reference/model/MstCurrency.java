package com.liri.reference.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MstCurrency implements Serializable{
	private String currencyCode;
	private String currencyName;
	private String localizedCurrencyName;
	private String remarks;
	private String createTime;
	private Integer createUser;
	private String updateTime;
	private Integer updateUser;
	private Integer isDelete;
	private Integer version;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	public String getLocalizedCurrencyName() {
		return localizedCurrencyName;
	}
	
	public void setLocalizedCurrencyName(String localizedCurrencyName) {
		this.localizedCurrencyName = localizedCurrencyName;
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