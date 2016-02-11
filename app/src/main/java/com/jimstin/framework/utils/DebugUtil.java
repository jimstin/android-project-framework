package com.jimstin.framework.utils;

import android.util.Log;

/**
 * Created by jim on 16-2-11.
 */
public class DebugUtil {

    private static final String TAG = "com.jimstin.framework";

    public static void logInfo(String msg) {
        Log.i(TAG, msg);
    }

    public static void logWarnig(String msg) {
        Log.w(TAG, msg);
    }

    public static void logError(String msg) {
        Log.e(TAG, msg);
    }

    public static void logInfo(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void logWarnig(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void logError(String tag, String msg) {
        Log.e(tag, msg);
    }
}
