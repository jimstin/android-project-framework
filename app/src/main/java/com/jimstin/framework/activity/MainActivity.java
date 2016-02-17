package com.jimstin.framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jimstin.framework.R;
import com.jimstin.frameworklib.entity.UserEntity;
import com.jimstin.frameworklib.utils.DebugUtil;
import com.jimstin.frameworklib.utils.GlobalUtil;
import com.jimstin.frameworklib.utils.UrlConfigManager;


public class MainActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 初始化变量
     */
    @Override
    protected void initVariables() {

    }

    /**
     * 加载 layout 布局文件
     */
    @Override
    protected void initViews() {

    }

    /**
     * 获取数据(本地或网络)
     */
    @Override
    protected void loadData() {
        UrlConfigManager.findUrlDate(this, "login");
    }
}
