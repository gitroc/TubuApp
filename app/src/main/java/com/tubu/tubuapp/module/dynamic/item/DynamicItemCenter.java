package com.tubu.tubuapp.module.dynamic.item;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @Description: 动态 Item Center
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 14:35
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 14:35
 */
public class DynamicItemCenter {
    public ImageView getIvImg() {
        return ivImg;
    }

    public void setIvImg(ImageView ivImg) {
        this.ivImg = ivImg;
    }

    public TextView getTvDesc() {
        return tvDesc;
    }

    public void setTvDesc(TextView tvDesc) {
        this.tvDesc = tvDesc;
    }

    private ImageView ivImg;
    private TextView tvDesc;
}
