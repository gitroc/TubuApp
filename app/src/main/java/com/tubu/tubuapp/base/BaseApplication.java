package com.tubu.tubuapp.base;

import android.app.Application;

import com.tubu.tubuapp.BuildConfig;

import timber.log.Timber;

/**
 * @Description: 应用基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 14:02
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 14:02
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
