package com.tubu.tubuapp.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;

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

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titlebar.setBackgroundColor(getResources().getColor(R.color.blue));
    }

    @CallSuper
    public void onSelected() {
        Logger.t(TAG).i(toString() + "onSelected");
    }

    public void setTitlebar(T titlebar) {
        Logger.t(TAG).i(toString() + "setTitlebar");
        this.titlebar = titlebar;
    }
}
