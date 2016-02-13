package com.jimstin.framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jimstin.framework.R;
import com.jimstin.frameworklib.entity.UserEntity;
import com.jimstin.frameworklib.utils.DebugUtil;
import com.jimstin.frameworklib.utils.GlobalUtil;


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

        Button btnJump = (Button) findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName("jim");
                userEntity.setGender(UserEntity.GENDER_MALE);
                userEntity.setAge(26);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("obj", userEntity);
                toActivity(intent);
            }
        });

        testConvertToInt();
    }

    private void testConvertToInt() {
        DebugUtil.logInfo(GlobalUtil.convertToInt("Jim", 9) + "");
        DebugUtil.logInfo(GlobalUtil.convertToInt("123", 9)+"");
    }

    /**
     * 获取数据(本地或网络)
     */
    @Override
    protected void loadData() {

    }
}
