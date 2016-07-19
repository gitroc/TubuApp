package com.tubu.tubuapp.module.dynamic.item;

import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @Description: 动态 Item Bottom
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/17 14:35
 * @Modifier: songjunpeng
 * @Update: 2016/7/17 14:35
 */
public class DynamicItemBottom {
    public RelativeLayout getLayDynamicItemBottomComment() {
        return layDynamicItemBottomComment;
    }

    public void setLayDynamicItemBottomComment(RelativeLayout layDynamicItemBottomComment) {
        this.layDynamicItemBottomComment = layDynamicItemBottomComment;
    }

    public RelativeLayout getLayDynamicItemBottomAttention() {
        return layDynamicItemBottomAttention;
    }

    public void setLayDynamicItemBottomAttention(RelativeLayout layDynamicItemBottomAttention) {
        this.layDynamicItemBottomAttention = layDynamicItemBottomAttention;
    }

    public RelativeLayout getLayDynamicItemBottomShare() {
        return layDynamicItemBottomShare;
    }

    public void setLayDynamicItemBottomShare(RelativeLayout layDynamicItemBottomShare) {
        this.layDynamicItemBottomShare = layDynamicItemBottomShare;
    }

    public TextView getTvCommentCount() {
        return tvCommentCount;
    }

    public void setTvCommentCount(TextView tvCommentCount) {
        this.tvCommentCount = tvCommentCount;
    }

    public TextView getTvAttentionCount() {
        return tvAttentionCount;
    }

    public void setTvAttentionCount(TextView tvAttentionCount) {
        this.tvAttentionCount = tvAttentionCount;
    }

    private RelativeLayout layDynamicItemBottomComment;
    private RelativeLayout layDynamicItemBottomAttention;
    private RelativeLayout layDynamicItemBottomShare;

    private TextView tvCommentCount;
    private TextView tvAttentionCount;
}
