package com.jimstin.framework.activity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import com.jimstin.framework.R;
import com.jimstin.frameworklib.net.RemoteService;
import com.jimstin.frameworklib.net.Response;
import com.jimstin.frameworklib.net.UrlData;
import com.jimstin.frameworklib.utils.DebugUtil;
import com.jimstin.frameworklib.utils.UrlConfigManager;


public class MainActivity extends AppBaseActivity {

    private int i;
    private boolean isOnPause;
    private TextView tvText;

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
        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOnPause = true;
                toActivity(SecondActivity.class);
            }
        });
        tvText = (TextView) findViewById(R.id.tv_text);
    }

    /**
     * 获取数据(本地或网络)
     */
    @Override
    protected void loadData() {
    }

    private void startHeartBeat() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (i < 200 && !isOnPause) {
                        RemoteService.login(new AbstractRequestCallback() {
                            @Override
                            public void onSuccess(Response response) {
                                tvText.setText((i + 1)+"");
                                DebugUtil.logInfo("request" + (i + 1));
                            }
                        }, requestManager);
                        i++;
                        //Thread.sleep(500);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}
