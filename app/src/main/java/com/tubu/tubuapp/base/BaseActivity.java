package com.tubu.tubuapp.base;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @Description: activity基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 14:08
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 14:08
 */
public class BaseActivity extends AppCompatActivity {
    protected BaseApplication core;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        core = (BaseApplication) getApplication();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public BaseApplication getCore() {
        return core;
    }


}
