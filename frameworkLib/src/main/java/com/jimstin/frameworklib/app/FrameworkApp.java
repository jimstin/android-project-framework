package com.jimstin.frameworklib.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by jim on 16-2-17.
 */
public class FrameworkApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
