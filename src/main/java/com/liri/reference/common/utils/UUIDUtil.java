package com.liri.reference.common.utils;

import java.util.UUID;

/**
 * 生成唯一性字符串工具
 *
 * @author William
 * @date 2019/8/22
 */
public class UUIDUtil {
    private UUIDUtil() {
    }

    /**
     * 基于指定的关键字符串生成UUID
     *
     * @param key 关键字符串
     * @return 唯一性字符串
     */
    public static String getUUID(String key) {

        if (StringUtil.isBlank(key)) {
            return getUUID();
        }

        return UUID.nameUUIDFromBytes(key.getBytes()).toString().replaceAll("-", "");
    }

    /**
     * 伪随机数生成器生成UUID
     *
     * @return 唯一性字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
