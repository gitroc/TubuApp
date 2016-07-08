package com.tubu.tubuapp.module.main.manager;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tubu.tubuapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: tab bar 管理
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/5/30 17:17
 * @Modifier: guizhen
 * @Update: 2016/5/30 17:17
 */
public class TabManager {

    public class TabItem {

        public ImageView iv;
        public TextView tv;
        public LinearLayout view;
        public int position;

        public void select() {
            iv.setSelected(true);
            tv.setTextColor(context.getResources().getColor(R.color.blue));
        }

        public void unSelect() {
            iv.setSelected(false);
            tv.setTextColor(context.getResources().getColor(R.color.gray));
        }

    }

    public interface onTabClickListener {
        void onClick(int index);
    }

    private Context context;
    private ViewGroup parent;
    private List<TabItem> tabItemList;
    private int select;
    private onTabClickListener listener;

    public TabManager(Context context, ViewGroup parent) {
        this.context = context;
        this.parent = parent;
        tabItemList = new ArrayList<>();
        select = -1;
    }

    public void setOnTabClickListener(onTabClickListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null) listener.onClick((Integer) v.getTag(R.id.tab_position));
        }
    };

    public TabManager addTab(int imageResid, CharSequence text) {
        TabItem tabItem = new TabItem();
        tabItem.view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.tabbar_item, parent, false);
        tabItem.view.setOnClickListener(onClickListener);
        tabItem.iv = (ImageView) tabItem.view.findViewById(R.id.iv);
        tabItem.iv.setImageResource(imageResid);
        tabItem.tv = (TextView) tabItem.view.findViewById(R.id.tv);
        tabItem.tv.setText(text);
        tabItem.position = tabItemList.size();
        tabItem.view.setTag(R.id.tab_position, tabItem.position);
        tabItemList.add(tabItem);
        parent.addView(tabItem.view);
        return this;
    }

    public TabItem getTab(int index) {
        return index > tabItemList.size() ? null : tabItemList.get(index);
    }

    public void select(int index) {
        if (select >= 0) tabItemList.get(select).unSelect();
        tabItemList.get(index).select();
        select = index;
    }

}
