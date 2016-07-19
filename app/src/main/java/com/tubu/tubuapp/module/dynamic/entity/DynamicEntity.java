package com.tubu.tubuapp.module.dynamic.entity;

/**
 * @Description: 动态实体
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 14:48
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 14:48
 */
public class DynamicEntity {
    public DynamicEntityTop getDynamicEntityTop() {
        return dynamicEntityTop;
    }

    public void setDynamicEntityTop(DynamicEntityTop dynamicEntityTop) {
        this.dynamicEntityTop = dynamicEntityTop;
    }

    public DynamicEntityCenter getDynamicEntityCenter() {
        return dynamicEntityCenter;
    }

    public void setDynamicEntityCenter(DynamicEntityCenter dynamicEntityCenter) {
        this.dynamicEntityCenter = dynamicEntityCenter;
    }

    public DynamicEntityBottom getDynamicEntityBottom() {
        return dynamicEntityBottom;
    }

    public void setDynamicEntityBottom(DynamicEntityBottom dynamicEntityBottom) {
        this.dynamicEntityBottom = dynamicEntityBottom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private DynamicEntityTop dynamicEntityTop = new DynamicEntityTop();
    private DynamicEntityCenter dynamicEntityCenter = new  DynamicEntityCenter();
    private DynamicEntityBottom dynamicEntityBottom = new DynamicEntityBottom();
    private String url;
}
