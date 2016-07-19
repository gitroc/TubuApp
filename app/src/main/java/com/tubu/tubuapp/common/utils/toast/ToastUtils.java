package com.tubu.tubuapp.common.utils.toast;

import android.content.Context;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperToast;

/**
 * @Description: Toast封装
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/19 11:18
 * @Modifier: songjunpeng
 * @Update: 2016/7/19 11:18
 */
public class ToastUtils {
    public synchronized static void show(Context context, String msg) {
        SuperToast superToast = new SuperToast(context);
        superToast.setFrame(Style.FRAME_STANDARD);
        superToast.setDuration(Style.DURATION_LONG);
        superToast.setText(msg);
        superToast.show();
    }
}
