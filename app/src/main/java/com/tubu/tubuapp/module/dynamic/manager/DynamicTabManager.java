package com.tubu.tubuapp.module.dynamic.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.module.dynamic.item.TabItem;
import com.tubu.tubuapp.module.dynamic.listener.OnTabClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO describe this class
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/12 11:23
 * @Modifier: songjunpeng
 * @Update: 2016/7/12 11:23
 */
public class DynamicTabManager {
    private int select;
    private Context context;
    private ViewGroup parent;
    private List<TabItem> tabItemList;
    private OnTabClickListener listener;

    public DynamicTabManager(Context context, ViewGroup parent) {
        this.context = context;
        this.parent = parent;
        tabItemList = new ArrayList<>();
        select = -1;
    }

    public void setOnTabClickListener(OnTabClickListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null) listener.onTabClick((Integer) v.getTag(R.id.dynamic_position));
        }
    };

    public DynamicTabManager addTab(CharSequence text) {
        TabItem tabItem = new TabItem();
        tabItem.viewTab = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.dynamic_tab_item, parent, false);
        tabItem.viewTab.setOnClickListener(onClickListener);

        tabItem.tvTab = (TextView) tabItem.viewTab.findViewById(R.id.tvTab);
        tabItem.tvTab.setText(text);

        tabItem.viewTab.setTag(R.id.dynamic_position, tabItemList.size());

        tabItemList.add(tabItem);
        parent.addView(tabItem.viewTab);
        return this;
    }

    public void selected(int index) {
        if (select >= 0) {
            tabItemList.get(select).setTextColor(parent.getResources().getColor(R.color.gray));
        }

        tabItemList.get(index).setTextColor(parent.getResources().getColor(R.color.blue));
        select = index;
    }
}
