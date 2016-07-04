package com.tubu.tubuapp.module.mall;

import android.content.Intent;
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

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.module.main.listener.TabListener;

/**
 * @Description: 商城频道
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 15:20
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 15:20
 */
public class MallFragment extends BaseTabFragment<Toolbar> implements TabListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mall_layout, null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filter1, menu);
    }

    @Override
    public void onMenuClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.msg:
                Toast.makeText(getActivity(), "home的msg", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClassName("com.seazon.launchmodeonedemo","com.seazon.launchmodeonedemo.TaskActivity");
                startActivity(intent);
                break;
        }
    }
}
