package com.tubu.tubuapp.common.phone;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;

/**
 * @Description: 手机设备信息
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/5 15:40
 * @Modifier: songjunpeng
 * @Update: 2016/7/5 15:40
 */
public class PhoneInfo {
    private static String TAG = "[PhoneInfo]";
    /**
     * 屏幕宽度
     * @param context
     * @return
     */
    public static int getWidth(Context context) {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        Logger.t(TAG).i("屏幕宽度" + String.valueOf(width));
        return width;
    }

    /**
     * 屏幕高度
     * @param context
     * @return
     */
    public static int getHeight(Context context) {
        int height = context.getResources().getDisplayMetrics().heightPixels;
        Logger.t(TAG).i("屏幕高度" + String.valueOf(height));
        return height;
    }

    /**
     * 屏幕密度
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        Logger.t(TAG).i("屏幕密度" + String.valueOf(density));
        return density;
    }
    /**
     * IMEI
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        Logger.t(TAG).i("IMEI" + imei);
        return imei;
    }

    /**
     * MODEL
     * @return
     */
    public static String getModel() {
        Build bd = new Build();
        String mode = bd.MODEL;
        Logger.t(TAG).i("MODEL" + mode);
        return mode;
    }

    /**
     * rom版本号
     * @return
     */
    public static String getDisplay() {
        Build bd = new Build();
        String display = bd.DISPLAY;
        Logger.t(TAG).i("DISPLAY" + display);
        return display;
    }

    /**
     * 制造厂商
     * @return
     */
    public static String getManufacturer() {
        String manufacturer = android.os.Build.MANUFACTURER;
        Logger.t(TAG).i("制造厂商" + manufacturer);
        return manufacturer;
    }

    /**
     * Android系统版本
     * @return
     */
    public static String getOsVersion() {
        String osVersion = android.os.Build.VERSION.RELEASE;
        Logger.t(TAG).i("Android系统版本" + osVersion);
        return osVersion;
    }

}
