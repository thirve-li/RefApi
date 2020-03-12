package com.liri.reference.model;

import java.io.Serializable;

public class ReferenceUserFiRef implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String accountNo;
	
	private Integer fIID;
	
	private Integer fiAccountId;
	
	private String status;
	
	private Integer version;
	
	private String isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getfIID() {
		return fIID;
	}

	public void setfIID(Integer fIID) {
		this.fIID = fIID;
	}

	public Integer getFiAccountId() {
		return fiAccountId;
	}

	public void setFiAccountId(Integer fiAccountId) {
		this.fiAccountId = fiAccountId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
