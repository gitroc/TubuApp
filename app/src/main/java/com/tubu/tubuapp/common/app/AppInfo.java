package com.tubu.tubuapp.common.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @Description: App信息
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/5 15:40
 * @Modifier: songjunpeng
 * @Update: 2016/7/5 15:40
 */
public class AppInfo {

    /**
     * 包名
     * @param context
     * @return
     */
    public static String getPackageName(Context context) {
        assert context != null;

        return context.getPackageName();
    }

    /**
     * 版本名
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        assert context != null;

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        assert context != null;

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
