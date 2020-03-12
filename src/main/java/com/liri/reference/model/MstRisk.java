package com.liri.reference.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class MstRisk implements Serializable{
	private Integer id;
	private String checkCategory;
	private String checkType;
	private Integer fi;
	private String checkEntity;
	private String iaccountNo;
	private String riskCountry;
	private String riskItem;
	private String risklevel;
	private String memo;
	private Date startDate;
    private Date endDate;
	private String createTime;
	private Integer createUser;
	private String updateTime;
	private Integer updateUser;
	private Integer version;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCheckCategory() {
        return checkCategory;
    }
    public void setCheckCategory(String checkCategory) {
        this.checkCategory = checkCategory;
    }
    public String getCheckType() {
        return checkType;
    }
    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }
    public Integer getFi() {
        return fi;
    }
    public void setFi(Integer fi) {
        this.fi = fi;
    }
    public String getCheckEntity() {
        return checkEntity;
    }
    public void setCheckEntity(String checkEntity) {
        this.checkEntity = checkEntity;
    }
    public String getIaccountNo() {
        return iaccountNo;
    }
    public void setIaccountNo(String iaccountNo) {
        this.iaccountNo = iaccountNo;
    }
    public String getRiskCountry() {
        return riskCountry;
    }
    public void setRiskCountry(String riskCountry) {
        this.riskCountry = riskCountry;
    }
    public String getRiskItem() {
        return riskItem;
    }
    public void setRiskItem(String riskItem) {
        this.riskItem = riskItem;
    }
    public String getRisklevel() {
        return risklevel;
    }
    public void setRisklevel(String risklevel) {
        this.risklevel = risklevel;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
}