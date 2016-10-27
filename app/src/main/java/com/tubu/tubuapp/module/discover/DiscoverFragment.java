package com.tubu.tubuapp.module.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.common.utils.toast.ToastUtils;
import com.tubu.tubuapp.module.main.listener.TabListener;

import rx.Observer;

/**
 * @Description: 发现频道
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 15:06
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 15:06
 */
public class DiscoverFragment extends BaseTabFragment<Toolbar> implements TabListener {
    private String TAG = "[DiscoverFragment]";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_msg3, menu);
    }

    @Override
    public void initView() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.t(TAG).i("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Logger.t(TAG).i("onError");
            }

            @Override
            public void onNext(String s) {
                Logger.t(TAG).i("Item: " + s);
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.discover_layout, null);
    }

    @Override
    public void onMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.msg:
                ToastUtils.show(getActivity(), "discover的msg");
                break;
        }
    }

    @Override
    public void onSelected() {
        super.onSelected();
        titlebar.setTitle("Discover");
    }

    @Override
    public void setTitlebar(Toolbar titlebar) {
        super.setTitlebar(titlebar);
    }
}
