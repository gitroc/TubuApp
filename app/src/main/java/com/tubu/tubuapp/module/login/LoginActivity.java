package com.tubu.tubuapp.module.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseActivity;

/**
 * @Description: 登录
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 16:39
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 16:39
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
    }
}
