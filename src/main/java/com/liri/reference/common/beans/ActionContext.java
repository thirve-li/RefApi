package com.liri.reference.common.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author William
 * @date 2019/8/19
 */
public class ActionContext implements Serializable {

    public ActionContext() {
        context.put(SESSION, new HashMap<String, Object>());
    }

    private static final long serialVersionUID = 491485624231941860L;

    private static final String SESSION = "session";

    /**
     * 自定义超时时间，单位毫秒(ms)：30分钟 = 1000*60*30
     */
    private static final long INTERVAL = 1800000L;

    /**
     * 创建时间，单位毫秒(ms)
     */
    private long creationTime = System.currentTimeMillis();

    private Map<String, Object> context = new HashMap<>();

    /**
     * Wallet类型代码
     */
    private String walletTypeCode;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 推荐成功的银行
     */
    private Object bankInfo;

    /**
     * 设置操作会话值的映射
     *
     * @param session 会话值
     */
    public void setSession(Map<String, Object> session) {

        put(SESSION, session);
    }

    /**
     * 获取会话映射中值的映射。
     *
     * @return 会话值
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getSession() {

        return (Map<String, Object>) get(SESSION);
    }

    /**
     * 是否到期，超时时间默认30分钟
     *
     * @return {@code true} 如果时间已到期
     */
    public boolean expire() {
        return (System.currentTimeMillis()) > (creationTime + INTERVAL);
    }

    /**
     * 是否到期
     *
     * @param interval 间隔时间，单位毫秒(ms)
     * @return {@code true} 如果时间已到期
     */
    public boolean expire(long interval) {
        return (System.currentTimeMillis()) > (creationTime + interval);
    }

    public Object get(String key) {
        return context.get(key);
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    public String getWalletTypeCode() {
        return walletTypeCode;
    }

    public void setWalletTypeCode(String walletTypeCode) {
        this.walletTypeCode = walletTypeCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Object getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(Object bankInfo) {
        this.bankInfo = bankInfo;
    }

    @Override
    public String toString() {
        return "ActionContext{" +
                "creationTime=" + creationTime +
                ", context=" + context +
                ", walletTypeCode='" + walletTypeCode + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", bankIfo=" + bankInfo +
                '}';
    }
}
