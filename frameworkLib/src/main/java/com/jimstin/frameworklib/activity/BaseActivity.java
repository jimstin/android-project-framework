package com.jimstin.frameworklib.activity;

import android.app.Activity;
import android.os.Bundle;
import com.jimstin.frameworklib.R;

/**
 * @author jim
 * @version 1.0
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        initViews();
        loadData();
    }

    protected abstract void initVariables();
    protected abstract void initViews();
    protected abstract void loadData();

}
