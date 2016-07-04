package com.tubu.tubuapp.base;

import android.app.Dialog;
import android.content.Context;

/**
 * @Description: 弹出框基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 14:09
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 14:09
 */
public class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
