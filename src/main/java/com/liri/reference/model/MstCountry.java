package com.liri.reference.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MstCountry implements Serializable{
	private Integer countryID;
	private String countryCode;
	private String localizedCountryName;
	private Integer regionID;
	private String countryName;
	private String phonePrefix;
	private Integer riskLevel;
	private String remarks;
	private String createTime;
	private Integer createUser;
	private String updateTime;
	private Integer updateUser;
	private Integer isDelete;
	private Integer version;
	private String iacMailLangCode;
	private String lang;
	private Integer walletTypeID;

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPhonePrefix() {
		return phonePrefix;
	}

	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
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

    public String getIacMailLangCode() {
        return iacMailLangCode;
    }

    public void setIacMailLangCode(String iacMailLangCode) {
        this.iacMailLangCode = iacMailLangCode;
    }

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLocalizedCountryName() {
		return localizedCountryName;
	}

	public void setLocalizedCountryName(String localizedCountryName) {
		this.localizedCountryName = localizedCountryName;
	}

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

	public Integer getWalletTypeID() {
		return walletTypeID;
	}

	public void setWalletTypeID(Integer walletTypeID) {
		this.walletTypeID = walletTypeID;
	}
}