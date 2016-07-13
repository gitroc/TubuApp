package com.tubu.tubuapp.module.dynamic.item;

import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @Description: TODO describe this class
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/12 14:33
 * @Modifier: songjunpeng
 * @Update: 2016/7/12 14:33
 */
public class TabItem {
    public TextView tvTab;
    public LinearLayout viewTab;

    public void setTextColor(int color) {
        tvTab.setTextColor(color);
    }
}
