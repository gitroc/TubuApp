package com.tubu.tubuapp.common.utils.net;

import okhttp3.MediaType;

/**
 * @Description: okhttp constants define
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/20 10:42
 * @Modifier: songjunpeng
 * @Update: 2016/7/20 10:42
 */
public class JsonConstants {
    public static final String TAG = "[JsonConstants]";

    public static final int CONNECT_TIMEOUT = 45000;
    public static final int READ_TIMEOUT = 45000;
    public static final int WRITE_TIMEOUT = 45000;

    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String NAME_VALUE_SEPARATOR = "=";

    public static final MediaType JSON = MediaType.parse("application/json; charset=" + DEFAULT_CHARSET);
    public static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");

    public static enum METHOD {
        GET, POST, PUT, DELETE
    }
}
