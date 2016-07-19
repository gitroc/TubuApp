package com.tubu.tubuapp.module.dynamic.entity;

/**
 * @Description: 动态实体 bottom
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 15:02
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 15:02
 */
public class DynamicEntityCenter {
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String imgUrl;
    private String desc;
}
