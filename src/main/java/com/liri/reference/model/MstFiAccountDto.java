package com.liri.reference.model;

import java.math.BigDecimal;

import com.liri.reference.model.MstFiAccount;

public class MstFiAccountDto extends MstFiAccount {
    private Integer id;
    private BigDecimal refInDayAmount;
    private BigDecimal refInWeekAmount;
    private BigDecimal refInMonthAmount;
    private BigDecimal refInQuarterAmount;
    private BigDecimal refInHalfYearAmount;
    private BigDecimal refInYearAmount;
    private String refInTimeCalculationMethod;
    private String swiftCode;
    private String countryName;
    private String fiFullName;
    private String fiAddress;
    
    private Integer refInDayQuantity;
	private Integer refInWeekQuantity;
	private Integer refInMonthQuantity;
	private Integer refInQuarterQuantity;
	private Integer refInHalfYearQuantity;
	private Integer refInYearQuantity;
    
    private int rowspan;

    public String getRefInTimeCalculationMethod() {
		return refInTimeCalculationMethod;
	}

	public void setRefInTimeCalculationMethod(String refInTimeCalculationMethod) {
		this.refInTimeCalculationMethod = refInTimeCalculationMethod;
	}

	public BigDecimal getRefInDayAmount() {
		return refInDayAmount== null?new BigDecimal("0"):refInDayAmount;
	}

	public void setRefInDayAmount(BigDecimal refInDayAmount) {
		this.refInDayAmount = refInDayAmount;
	}

	public BigDecimal getRefInWeekAmount() {
		return refInWeekAmount== null?new BigDecimal("0"):refInWeekAmount;
	}

	public void setRefInWeekAmount(BigDecimal refInWeekAmount) {
		this.refInWeekAmount = refInWeekAmount;
	}

	public BigDecimal getRefInMonthAmount() {
		return refInMonthAmount== null?new BigDecimal("0"):refInMonthAmount;
	}

	public void setRefInMonthAmount(BigDecimal refInMonthAmount) {
		this.refInMonthAmount = refInMonthAmount;
	}

	public BigDecimal getRefInQuarterAmount() {
		return refInQuarterAmount== null?new BigDecimal("0"):refInQuarterAmount;
	}

	public void setRefInQuarterAmount(BigDecimal refInQuarterAmount) {
		this.refInQuarterAmount = refInQuarterAmount;
	}

	public BigDecimal getRefInHalfYearAmount() {
		return refInHalfYearAmount== null?new BigDecimal("0"):refInHalfYearAmount;
	}

	public void setRefInHalfYearAmount(BigDecimal refInHalfYearAmount) {
		this.refInHalfYearAmount = refInHalfYearAmount;
	}

	public BigDecimal getRefInYearAmount() {
		return refInYearAmount == null?new BigDecimal("0"):refInYearAmount;
	}

	public void setRefInYearAmount(BigDecimal refInYearAmount) {
		this.refInYearAmount = refInYearAmount;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getFiFullName() {
		return this.getBankName();
	}

	public void setFiFullName(String fiFullName) {
		this.fiFullName = fiFullName;
	}

	public String getFiAddress() {
		return this.getFiAccountAddress();
	}

	public void setFiAddress(String fiAddress) {
		this.fiAddress = fiAddress;
	}

	public Integer getRefInDayQuantity() {
		return refInDayQuantity;
	}

	public void setRefInDayQuantity(Integer refInDayQuantity) {
		this.refInDayQuantity = refInDayQuantity;
	}

	public Integer getRefInWeekQuantity() {
		return refInWeekQuantity;
	}

	public void setRefInWeekQuantity(Integer refInWeekQuantity) {
		this.refInWeekQuantity = refInWeekQuantity;
	}

	public Integer getRefInMonthQuantity() {
		return refInMonthQuantity;
	}

	public void setRefInMonthQuantity(Integer refInMonthQuantity) {
		this.refInMonthQuantity = refInMonthQuantity;
	}

	public Integer getRefInQuarterQuantity() {
		return refInQuarterQuantity;
	}

	public void setRefInQuarterQuantity(Integer refInQuarterQuantity) {
		this.refInQuarterQuantity = refInQuarterQuantity;
	}

	public Integer getRefInHalfYearQuantity() {
		return refInHalfYearQuantity;
	}

	public void setRefInHalfYearQuantity(Integer refInHalfYearQuantity) {
		this.refInHalfYearQuantity = refInHalfYearQuantity;
	}

	public Integer getRefInYearQuantity() {
		return refInYearQuantity;
	}

	public void setRefInYearQuantity(Integer refInYearQuantity) {
		this.refInYearQuantity = refInYearQuantity;
	}
	
	
}
