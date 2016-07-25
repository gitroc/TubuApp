package com.tubu.tubuapp.common.utils.net;

import android.app.Activity;
import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @Description: Json格式网络请求
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/19 10:10
 * @Modifier: songjunpeng
 * @Update: 2016/7/19 10:10
 */
public class JsonNetRequest {
    private static OkHttpClient okHttpClient = new OkHttpClient();

    static {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(JsonConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.readTimeout(JsonConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(JsonConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient = builder.build();
    }

    /**
     * json Post 请求
     * @param url
     * @param jsonString
     * @param jsonNetResponse
     */
    public static void jsonPost(final String url, final String jsonString, final JsonNetResponse jsonNetResponse) {
        assert (url == null);
        assert (jsonString == null);
        assert (jsonNetResponse == null);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    jsonExecute(JsonConstants.METHOD.POST, url, jsonString, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            jsonNetResponse.onFailure(e);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                            jsonNetResponse.onResponse(call, response);
                        }
                    });
                } catch (Exception e) {
                    jsonNetResponse.onFailure(e);
                }
            }
        }).start();
    }

    private static void jsonExecute(JsonConstants.METHOD method, String url, String body, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .method(method.toString(), RequestBody.create(JsonConstants.JSON, body))
                .build();

        okHttpClient.newCall(request).enqueue(callback);
    }
}
