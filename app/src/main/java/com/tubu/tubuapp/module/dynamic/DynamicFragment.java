package com.tubu.tubuapp.module.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jakewharton.disklrucache.DiskLruCache;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.common.utils.DlcCacheUtils;
import com.tubu.tubuapp.module.main.listener.TabListener;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description: 动态频道
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 15:20
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 15:20
 */
public class DynamicFragment extends BaseTabFragment<Toolbar> implements TabListener {
    protected View view;
//    private WebView webView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dynamic_layout, null);
//        initWebView();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_msg3, menu);
    }

    @Override
    public void onMenuClick(MenuItem item) {

    }

    @Override
    public void onSelected() {
        super.onSelected();
        titlebar.setTitle("Dynamic");
    }

    @Override
    public void setTitlebar(Toolbar titlebar) {
        super.setTitlebar(titlebar);
    }

}
