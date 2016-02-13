package com.jimstin.framework.activity;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.jimstin.framework.R;
import com.jimstin.frameworklib.entity.UserEntity;

public class SecondActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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

        Intent intent = getIntent();
        if (intent != null) {
            UserEntity userEntity = (UserEntity) intent.getSerializableExtra("obj");
            String jsonString = JSON.toJSONString(userEntity);
            toastShortMsg(jsonString);
        }
    }


}
