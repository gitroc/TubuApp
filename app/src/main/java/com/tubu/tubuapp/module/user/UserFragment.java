package com.tubu.tubuapp.module.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseFragment;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.module.main.listener.TabListener;

/**
 * @Description: 用户信息频道
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 15:21
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 15:21
 */
public class UserFragment extends BaseTabFragment<Toolbar> implements TabListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_layout, null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_msg0, menu);
    }

    @Override
    public void onMenuClick(MenuItem item) {

    }

    @Override
    public void onSelected() {
        super.onSelected();
        titlebar.setTitle("User");
    }

    @Override
    public void setTitlebar(Toolbar titlebar) {
        super.setTitlebar(titlebar);
    }

    @Override
    public void initView() {

    }
}
