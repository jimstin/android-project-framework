package com.jimstin.frameworklib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jim on 16-2-12.
 */
public class GlobalUtil {

    public static final int convertToInt(Object obj, int defaultValue) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return (int) Double.parseDouble(obj.toString());
            } catch (Exception e1) {
                return defaultValue;
            }
        }
    }

    public static String toMd5L32(String str) {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }
}
