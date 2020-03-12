package com.liri.reference.common.constants;

/**
 * @author William
 * @date 2019/10/14
 */
public class Constants {

    private Constants() {

    }

    /**
     * 访问令牌
     */
    public static final String ACCESS_TOKEN = "token";

    /**
     * 入金方式: GC(Global Collect)
     */
    public static final String BANK_TYPE_GC = "2";

    /**
     * 入金方式: Reference
     */
    public static final String BANK_TYPE_REF = "1";

    /**
     * 入金方式: Help2Pay
     */
    public static final String BANK_TYPE_H2P = "3";

    /**
     * 充值方式: 1 - Domestic remittance(国内汇款);
     */
    public static final String DOMESTIC_REMITTANCE = "1";

    /**
     * 充值方式: 2 - Overseas remittance(海外汇款)
     */
    public static final String OVERSEAS_REMITTANCE = "2";

    /**
     * Wallet Type:i-Account
     */
    public static final String WALLET_TYPE_IACCOUNT = "IAC";

    /**
     * DB SCHEMA NAME:public
     */
    public static final String DB_SCHEMA_PUBLIC_NAME = "public";

    /**
     * DB schema name:i-Account
     */
    public static final String DB_SCHEMA_MONEYINOUT_IACCOUNT = "MoneyInOut";

    /**
     * DB schema name prefix
     */
    public static final String DB_SCHEMA_MONEYINOUT_PRFFIX = "MoneyInOut_";

    /**
     * DICT_CLASS_REF
     */
    public static final String DICT_CLASS_REF = "DICT_CLASS_REF";

    /**
     * CacheService定时器周期
     */
    public static final String DICT_ITEM_CACHE_TIMER_PERIOD = "CACHE_TIMER_PERIOD";

    /**
     * 域名白名单
     */
    public static final String DICT_CLASS_REF_ALLOW_URL = "DICT_CLASS_REF_ALLOW_URL";

    /**
     * 是否开发模式
     */
    public static final String DICT_CLASS_REF_DEV_MODEL = "DICT_CLASS_REF_DEV_MODEL";

    /**
     * 授权过期间隔
     */
    public static final String AUTHORIZATION_EXPIRATION_INTERVAL = "AUTHORIZATION_EXPIRATION_INTERVAL";

    /**
     * 授权过期间隔，单位秒(s)，默认30分钟=30*60
     */
    public static final int DEFAULT_AUTHORIZATION_EXPIRATION_INTERVAL = 1800;

    /**
     * 开发模式
     */
    public static final String DEV_MODEL = "true";

    /**
     * 汇款人：Myself / Others
     */
    public static final String SENDER = "sender";


    /**
     * 汇款人类别：Personal / Corporation
     */
    public static final String SENDER_TYPE = "senderType";
}
