package com.jimstin.frameworklib.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jimstin.frameworklib.R;
import com.jimstin.frameworklib.net.RequestManager;
import com.jimstin.frameworklib.utils.DebugUtil;

/**
 * @author jim
 * @version 1.0
 */
public abstract class BaseActivity extends Activity {

    protected RequestManager requestManager = null;

    @Override
    protected void onStart() {
        super.onStart();
        requestManager = new RequestManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (requestManager != null) {
            requestManager.cancelRequest();
            DebugUtil.logInfo(getLocalClassName()+" >> onPause");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (requestManager != null) {
            requestManager.cancelRequest();
            DebugUtil.logInfo(getLocalClassName()+" >> onDestroy");
        }
    }
}
