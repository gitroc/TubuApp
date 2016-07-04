package com.tubu.tubuapp.base;

import android.support.annotation.CallSuper;
import android.view.View;

import timber.log.Timber;

/**
 * @Description: BaseTabFragment
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 17:43
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 17:43
 */
public class BaseTabFragment<T extends View> extends BaseFragment {
    private String TAG = "[BaseTabFragment]";
    protected T titlebar;

    @CallSuper
    public void onSelected() {
        Timber.i(TAG, toString() + "onSelected");
    }

    public void setTitlebar(T titlebar) {
        Timber.i(TAG, toString() + "setTitlebar");
        this.titlebar = titlebar;
    }
}
