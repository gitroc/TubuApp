package com.tubu.tubuapp.base.entity;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 数据请求基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/21 14:03
 * @Modifier: songjunpeng
 * @Update: 2016/7/21 14:03
 */
public class BaseReqEntity {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
