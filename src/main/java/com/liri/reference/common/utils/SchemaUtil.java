package com.liri.reference.common.utils;

import com.liri.reference.common.constants.Constants;

/**
 * Wallet Type Schema
 *
 * @author William
 * @date 2019/8/19
 */
public class SchemaUtil {
    private SchemaUtil() {
    }

    /**
     * 根据表"public"."MST_WALLETTYPE"."WalletTypeSchema"值拼装对应 Schema
     *
     * @param walletType
     * @return
     */
    public static String getSchemaName(String walletType) {

        if (Constants.WALLET_TYPE_IACCOUNT.equals(walletType)) {
            return Constants.DB_SCHEMA_MONEYINOUT_IACCOUNT;
        }

        if (Constants.DB_SCHEMA_PUBLIC_NAME.equals(walletType)) {
            return Constants.DB_SCHEMA_PUBLIC_NAME;
        }

        return Constants.DB_SCHEMA_MONEYINOUT_PRFFIX + walletType;
    }
}
