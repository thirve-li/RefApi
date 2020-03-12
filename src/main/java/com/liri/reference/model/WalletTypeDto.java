package com.liri.reference.model;

import java.util.Date;

public class WalletTypeDto {
    
    private Long walletTypeID;
    
    private String walletTypeCode;
    
    private String walletTypeSimpleName;
    
    private String walletTypeFullName;
    
    private String walletTypeSchema;
    
    private String companyID;
    
    private String remarks;
    
    private Date createTime;
    
    private Integer createUser;
    
    private Date updateTime;
    
    private Integer updateUser;
    
    private Integer isDelete;
    
    private Integer version;
    
    private String contactUsMail;
    
    private String fromEmail;
    
    private String themeName;
    
    private String domain;
    
    private String functionCode;
    private String masterWalletType;
    
    public String getMasterWalletType() {
        return masterWalletType;
    }
    
    public void setMasterWalletType(String masterWalletType) {
        this.masterWalletType = masterWalletType;
    }
    
    
    public Long getWalletTypeID() {
        return walletTypeID;
    }
    
    public void setWalletTypeID(Long walletTypeID) {
        this.walletTypeID = walletTypeID;
    }
    
    public String getWalletTypeCode() {
        return walletTypeCode;
    }
    
    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
    }
    
    public String getWalletTypeSimpleName() {
        return walletTypeSimpleName;
    }
    
    public void setWalletTypeSimpleName(String walletTypeSimpleName) {
        this.walletTypeSimpleName = walletTypeSimpleName;
    }
    
    public String getWalletTypeFullName() {
        return walletTypeFullName;
    }
    
    public void setWalletTypeFullName(String walletTypeFullName) {
        this.walletTypeFullName = walletTypeFullName;
    }
    
    public String getWalletTypeSchema() {
        return walletTypeSchema;
    }
    
    public void setWalletTypeSchema(String walletTypeSchema) {
        this.walletTypeSchema = walletTypeSchema;
    }
    
    public String getCompanyID() {
        return companyID;
    }
    
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
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
    
    public String getContactUsMail() {
        return contactUsMail;
    }
    
    public void setContactUsMail(String contactUsMail) {
        this.contactUsMail = contactUsMail;
    }
    
    public String getFromEmail() {
        return fromEmail;
    }
    
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }
    
    public String getThemeName() {
        return themeName;
    }
    
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
    
    public String getDomain() {
        return domain;
    }
    
    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public String getFunctionCode() {
        return functionCode;
    }
    
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }
}
