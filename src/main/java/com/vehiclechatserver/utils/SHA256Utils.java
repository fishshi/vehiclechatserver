package com.vehiclechatserver.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * SHA256加密工具类
 */
public class SHA256Utils {
    /**
     * 盐值
     */
    private static String salt = "vehiclechatserver";

    /**
     * SHA256加密
     * 
     * @param str 原始字符串
     * @return 加密后的字符串
     */
    public static String sha256(String str) {
        str += salt;
        return DigestUtils.sha256Hex(str);
    }
}