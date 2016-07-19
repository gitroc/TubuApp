package com.tubu.tubuapp.module.dynamic.entity;

/**
 * @Description: 动态实体 top
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 15:02
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 15:02
 */
public class DynamicEntityTop {
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String imgUrl;
    private String name;
    private String time;
}
