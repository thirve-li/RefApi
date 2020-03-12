package com.liri.reference.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64加解密工具
 *
 * @author William
 * @date 2019/8/22
 */
public class Base64Util {

    private static Logger logger = LoggerFactory.getLogger(Base64Util.class);

    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static final String charsetName = "UTF-8";

    /**
     * 加密
     *
     * @param data 加密的内容
     * @return
     */
    public static String encrypt(String data) {
        byte[] textByte = new byte[0];
        try {
            textByte = data.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            logger.error(">>>>>> encrypt error:", e);
        }

        return encoder.encodeToString(textByte);
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @return
     */
    public static String decrypt(String data) {
        String text = null;
        try {
            text = new String(decoder.decode(data), charsetName);
        } catch (UnsupportedEncodingException e) {
            logger.error(">>>>>> decrypt error:", e);
        }

        return text;
    }

    public static void main(String[] args) {
        String encryptText = Base64Util.encrypt("Wj!TCfjQFtku76Ac");
        System.out.println(encryptText);

        String decrypt = Base64Util.decrypt(encryptText);
        System.out.println(decrypt);
    }
}
