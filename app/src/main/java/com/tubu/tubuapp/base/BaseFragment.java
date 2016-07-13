package com.tubu.tubuapp.base;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tubu.tubuapp.R;

import timber.log.Timber;

/**
 * @Description: BaseFragment基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 14:08
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 14:08
 */
public abstract class BaseFragment extends Fragment {
    private static String TAG = "[BaseFragment]";

    protected BaseApplication core;
    protected View view;
    private ImageView imageView;

    public View createView(LayoutInflater inflater, int layoutId, boolean showLoading) {
        return createView(inflater, layoutId, showLoading, false);
    }

    public View createView(LayoutInflater inflater, int layoutId, boolean showLoading, boolean recreate) {
        if (view != null) {
            ViewGroup group = (ViewGroup) view.getParent();
            if (group != null) {
                group.removeAllViews();
            }
        }

        if (view == null || recreate) {
            view = inflater.inflate(layoutId, null);
            if (showLoading) {
                imageView = (ImageView) view.findViewById(R.id.ivLoading);
                Timber.i(TAG, "show loading page");
                startLoading();
            }
            initView();
        }

        return view;
    }

    /**
     * 显示加载页
     */
    public void startLoading() {
        if (imageView != null) {
            imageView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 隐藏加载页面
     */
    public void stopLoading() {
        if (imageView != null) {
            imageView.setVisibility(View.GONE);
        }
    }

    public abstract void initView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        core = (BaseApplication) getActivity().getApplication();
    }

    public BaseApplication getCore() {
        return core;
    }

    public void push(int resId, BaseFragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(tag).add(resId, fragment, tag).commitAllowingStateLoss();
    }

    public void replace(int resId, BaseFragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(tag).replace(resId, fragment, tag).commitAllowingStateLoss();
    }

    public void remove(BaseFragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(tag).remove(fragment).commitAllowingStateLoss();
    }

    public void reload() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(this);
        fragmentTransaction.attach(this);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
