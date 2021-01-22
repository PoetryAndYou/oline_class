package com.yantumeijing.oline_class.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 公共工具类
 */
public class CommontUtils {
    /**
     * MD5加密
     *
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) |
                        0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
