package com.tubu.tubuapp.common.utils.net;

import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.net.SocketException;
import java.net.UnknownHostException;

import okhttp3.Call;
import okhttp3.Response;
/**
 * @Description: Json格式网络应答
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/19 10:11
 * @Modifier: songjunpeng
 * @Update: 2016/7/19 10:11
 */
public abstract class JsonNetResponse {
    private String TAG = "[JsonNetResponse]";

    public abstract void onResponse(Call call, Response response);

    public void onFailure(Exception e) {
        exceptionHandler(e);
    }

    /**
     * Json Post请求异常处理
     * @param error
     */
    private void exceptionHandler(Exception error) {
        if (error instanceof JSONException) {
            // json异常
            Logger.t(TAG).i("json异常");
        } else if (error instanceof NullPointerException) {
            // 获取数据失败数据为空
            Logger.t(TAG).i("获取数据失败数据为空");
        } else if (error instanceof UnknownHostException) {
            // 网络异常
            Logger.t(TAG).i("网络异常");
        } else if (error instanceof SocketException) {
            // 网络异常
            Logger.t(TAG).i("网络异常");
        } else {
            // 加载失败
            Logger.t(TAG).i("加载失败");
        }
    }
}
