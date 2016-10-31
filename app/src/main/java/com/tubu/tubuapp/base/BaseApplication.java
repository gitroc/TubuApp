package com.tubu.tubuapp.base;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.BuildConfig;

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
            Logger.init("[ROC]")                    // default PRETTYLOGGER or use just init()
                    .methodCount(2)                 // default 2 方法栈打印的个数，默认是2
                    .hideThreadInfo()               // default shown  隐藏线程信息
                    .logLevel(LogLevel.FULL)        // default LogLevel.FULL 显示全部日志，LogLevel.NONE不显示日志，默认是Full
                    .methodOffset(0);               // default 0 设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
                                                    // 自定义一个打印适配器，这里适配了Android的Log打印，你也可以自己实现LogAdapter接口来做一些特殊需求的日志打印适配

        } else {
            Logger.init("[ROC]")
                    .methodCount(2)
                    .hideThreadInfo()
                    .logLevel(LogLevel.NONE)
                    .methodOffset(0);
        }
    }
}
