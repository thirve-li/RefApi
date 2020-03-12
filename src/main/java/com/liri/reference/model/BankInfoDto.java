package com.liri.reference.model;

import java.io.Serializable;


/**
 * 银行信息基类
 *
 * @author William
 * @date 2019/10/14
 */
public class BankInfoDto implements Serializable {

    private static final long serialVersionUID = -8608447703448113321L;

    /**
     * ID 为了之后选择银行时，作为唯一标识
     */
    private int id;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 币种
     */
    private String currency;

    /**
     * 金额
     */
    private String amount;

    /**
     * 银行所属国家
     */
    private String bankCountry;

    /**
     * 充值方式
     * 1 - 国内汇款(Domestic remittance)
     * 2 - 海外汇款(Overseas remittance)
     */
    private String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "BankInfoDto{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", bankCountry='" + bankCountry + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
