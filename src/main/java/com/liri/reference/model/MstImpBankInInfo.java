package com.liri.reference.model;


public class MstImpBankInInfo {

	private String dateFrom;
	private String dateTo;
	private int fiAccountID;
	private String walletTypeSchema;
	
	public String getWalletTypeSchema() {
		return walletTypeSchema;
	}
	public void setWalletTypeSchema(String walletTypeSchema) {
		this.walletTypeSchema = walletTypeSchema;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public int getFiAccountID() {
		return fiAccountID;
	}
	public void setFiAccountID(int fiAccountID) {
		this.fiAccountID = fiAccountID;
	}
}