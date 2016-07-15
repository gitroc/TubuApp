package com.tubu.tubuapp.module.dynamic.controller;

import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseFragment;
import com.tubu.tubuapp.base.BaseFragmentTop;
import com.tubu.tubuapp.module.dynamic.DynamicFragment;

/**
 * @Description: TODO describe this class
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/12 10:35
 * @Modifier: songjunpeng
 * @Update: 2016/7/12 10:35
 */
public class DynamicController {
    private String TAG = "[DynamicController]";
    private BaseFragment baseFragment;
    private FragmentActivity context;
    private View view;

    public DynamicController(DynamicFragment dynamicFragment, View view) {
        super();
        assert dynamicFragment == null;
        assert view == null;

        this.baseFragment = dynamicFragment;
        this.context = dynamicFragment.getActivity();
        this.view = view;

        String[] tabNames = context.getResources().getStringArray(R.array.dynamicFragmentNames);

        init(tabNames);
    }

    protected void init(String[] titles) {
        new BaseFragmentTop(this.baseFragment, view, titles);
        initViewPager();
    }

    private void initViewPager() {

    }
}
