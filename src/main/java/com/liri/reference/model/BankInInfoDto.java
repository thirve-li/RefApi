package com.liri.reference.model;

import java.math.BigDecimal;

/**
 * 
 * @author Dana
 *
 */
public class BankInInfoDto {

	private String originalCurrency;

	private BigDecimal originalAmount;

	public String getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

}
