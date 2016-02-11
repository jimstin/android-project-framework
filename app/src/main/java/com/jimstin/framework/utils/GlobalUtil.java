package com.jimstin.framework.utils;

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
}
