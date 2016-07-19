package com.tubu.tubuapp.module.dynamic.item;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @Description: 动态 Item Top
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 14:33
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 14:33
 */
public class DynamicItemTop {
    public ImageView getIvImg() {
        return ivImg;
    }

    public void setIvImg(ImageView ivImg) {
        this.ivImg = ivImg;
    }

    public TextView getTvName() {
        return tvName;
    }

    public void setTvName(TextView tvName) {
        this.tvName = tvName;
    }

    public TextView getTvTime() {
        return tvTime;
    }

    public void setTvTime(TextView tvTime) {
        this.tvTime = tvTime;
    }

    private ImageView ivImg;
    private TextView tvName;
    private TextView tvTime;
}
