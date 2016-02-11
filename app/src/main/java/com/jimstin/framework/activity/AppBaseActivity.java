package com.jimstin.framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.jimstin.framework.R;
import com.jimstin.frameworklib.activity.BaseActivity;

public abstract class AppBaseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_base);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initVariables();
        initViews();
        loadData();
    }

    /**
     * 初始化变量
     */
    protected abstract void initVariables();

    /**
     * 加载 layout 布局文件
     */
    protected abstract void initViews();

    /**
     * 获取数据(本地或网络)
     */
    protected abstract void loadData();

    protected void toActivity(Intent intent) {
        startActivity(intent);
    }

    protected void toActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected void toActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    protected void toActivityForResult(Class cls, int requestCode) {
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, requestCode);
    }

    protected void toastShortMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void toastLongMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void toastMsgForDuration(String msg, int millis) {
        Toast.makeText(this, msg, millis).show();
    }
}
