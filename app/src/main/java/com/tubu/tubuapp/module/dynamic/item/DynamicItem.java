package com.tubu.tubuapp.module.dynamic.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.module.dynamic.entity.DynamicEntity;

import kale.adapter.item.AdapterItem;

/**
 * @Description: 动态 Item
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 14:32
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 14:32
 */
public class DynamicItem implements AdapterItem<DynamicEntity> {

    private DynamicItemTop dynamicItemTop = new DynamicItemTop();
    private DynamicItemCenter dynamicItemCenter = new DynamicItemCenter();
    private DynamicItemBottom dynamicItemBottom = new DynamicItemBottom();

    private Context context;

    public DynamicItem(Context context) {
        this.context = context;
    }

    /**
     * item布局文件的layoutId
     * @return
     */
    @Override
    public int getLayoutResId() {
        return R.layout.dynamic_item;
    }

    /**
     * 初始化views
     * @param view
     */
    @Override
    public void bindViews(View view) {
        setDynamicItemTop(view);
        setDynamicItemCenter(view);
        setDynamicItemBottom(view);
    }

    /**
     * 设置view的参数
     */
    @Override
    public void setViews() {
        setDynamicItemTopOnclickListener();
        setDynamicItemCenterOnclickListener();
        setDynamicItemBottomOnclickListener();
    }

    /**
     * 根据数据来设置item的内部views
     * @param dynamicEntity 数据list内部的entity
     * @param i 当前adapter调用item的位置
     */
    @Override
    public void handleData(DynamicEntity dynamicEntity, int i) {
        updateDynamicItemTop(dynamicEntity);
        updateDynamicItemCenter(dynamicEntity);
        updateDynamicItemBottom(dynamicEntity);
    }


    private void setDynamicItemTop(View view) {
        dynamicItemTop.setIvImg((ImageView) view.findViewById(R.id.ivImg));
        dynamicItemTop.setTvName((TextView) view.findViewById(R.id.tvName));
        dynamicItemTop.setTvTime((TextView) view.findViewById(R.id.tvTime));
    }

    private void setDynamicItemTopOnclickListener() {

    }

    private void setDynamicItemCenter(View view) {
        dynamicItemCenter.setIvImg((ImageView) view.findViewById(R.id.ivImg));
        dynamicItemCenter.setTvDesc((TextView) view.findViewById(R.id.tvDesc));
    }

    private void setDynamicItemCenterOnclickListener() {

    }

    private void setDynamicItemBottom(View view) {
        dynamicItemBottom.setLayDynamicItemBottomComment((RelativeLayout) view.findViewById(R.id.layDynamicItemBottomComment));
        dynamicItemBottom.setLayDynamicItemBottomAttention((RelativeLayout) view.findViewById(R.id.layDynamicItemBottomAttention));
        dynamicItemBottom.setLayDynamicItemBottomShare((RelativeLayout) view.findViewById(R.id.layDynamicItemBottomShare));

        dynamicItemBottom.setTvCommentCount((TextView) view.findViewById(R.id.tvCommentCount));
        dynamicItemBottom.setTvAttentionCount((TextView) view.findViewById(R.id.tvAttentionCount));
    }

    private void setDynamicItemBottomOnclickListener() {
        dynamicItemBottom.getLayDynamicItemBottomComment().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dynamicItemBottom.getLayDynamicItemBottomAttention().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dynamicItemBottom.getLayDynamicItemBottomShare().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void updateDynamicItemTop(DynamicEntity dynamicEntity) {

    }

    private void updateDynamicItemCenter(DynamicEntity dynamicEntity) {

    }

    private void updateDynamicItemBottom(DynamicEntity dynamicEntity) {

    }
}
