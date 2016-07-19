package com.tubu.tubuapp.module.dynamic.entity;

/**
 * @Description: 动态实体 bottom
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 15:03
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 15:03
 */
public class DynamicEntityBottom {
    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(String attentionCount) {
        this.attentionCount = attentionCount;
    }

    private String commentCount;
    private String attentionCount;
}
