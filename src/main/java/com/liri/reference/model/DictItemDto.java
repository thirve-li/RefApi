package com.liri.reference.model;

import java.io.Serializable;

/**
 * @author William
 * @date 2019/8/19
 */
public class DictItemDto implements Serializable {

    private static final long serialVersionUID = -3432285355007794695L;

    private Integer dictItemID;

    private Integer parentID;

    private String dictClassCode;

    private String dictItemCode;

    private String dictItemName;

    private String dictItemValue;

    private Integer sequence;

    private String remarks;

    private String createTime;

    private Integer createUser;

    private String updateTime;

    private Integer updateUser;

    private Integer isReadonly;

    private Integer isDisable;

    private Integer isDefault;

    private Integer isDelete;

    private Integer version;

    private Long walletTypeId;

    public Integer getDictItemID() {
        return dictItemID;
    }

    public void setDictItemID(Integer dictItemID) {
        this.dictItemID = dictItemID;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getDictClassCode() {
        return dictClassCode;
    }

    public void setDictClassCode(String dictClassCode) {
        this.dictClassCode = dictClassCode;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public String getDictItemValue() {
        return dictItemValue;
    }

    public void setDictItemValue(String dictItemValue) {
        this.dictItemValue = dictItemValue;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public Integer getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(Integer isReadonly) {
        this.isReadonly = isReadonly;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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

    public Long getWalletTypeId() {
        return walletTypeId;
    }

    public void setWalletTypeId(Long walletTypeId) {
        this.walletTypeId = walletTypeId;
    }

    @Override
    public String toString() {
        return "DictItemDto{" +
                "dictItemID=" + dictItemID +
                ", parentID=" + parentID +
                ", dictClassCode='" + dictClassCode + '\'' +
                ", dictItemCode='" + dictItemCode + '\'' +
                ", dictItemName='" + dictItemName + '\'' +
                ", dictItemValue='" + dictItemValue + '\'' +
                ", sequence=" + sequence +
                ", remarks='" + remarks + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createUser=" + createUser +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser=" + updateUser +
                ", isReadonly=" + isReadonly +
                ", isDisable=" + isDisable +
                ", isDefault=" + isDefault +
                ", isDelete=" + isDelete +
                ", version=" + version +
                ", walletTypeId=" + walletTypeId +
                '}';
    }
}
