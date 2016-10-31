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

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.common.utils.toast.ToastUtils;
import com.tubu.tubuapp.module.main.listener.TabListener;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

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
        TestRxAndroid();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(inflater, R.layout.discover_layout, true);
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


    private void TestRxAndroid() {
        Observable.just("hello word")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        Logger.i("String to Integer");
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        Logger.i("Integer to String");
                        return integer.toString();
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.i(s);
                    }
                });
    }
}
