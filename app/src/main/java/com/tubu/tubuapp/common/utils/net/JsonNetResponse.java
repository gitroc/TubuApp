package com.tubu.tubuapp.common.utils.net;

import android.content.Context;
import android.widget.Toast;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.common.utils.toast.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.SocketException;
import java.net.UnknownHostException;

import timber.log.Timber;

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
    public Context context;

    public abstract void onSuccess(int statusCode, JSONObject response);

    public void onFailure(Throwable error, String content) {
        Timber.e(TAG, content);
        exceptionHandler(context, error);
    }

    private void exceptionHandler(Context context, Throwable error) {
        if (error instanceof JSONException) {
            // json异常
            ToastUtils.show(context, context.getString(R.string.hit_prase_json_failure));
        } else if (error instanceof NullPointerException) {
            // 获取数据失败数据为空
            ToastUtils.show(context, context.getString(R.string.hit_no_data));
        } else if (error instanceof UnknownHostException) {
            // 网络异常
            ToastUtils.show(context, context.getString(R.string.hit_network_failure));
        } else if (error instanceof SocketException) {
            // 网络异常
            ToastUtils.show(context, context.getString(R.string.hit_network_failure));
        } else {
            // 加载失败
        }
    }


}
