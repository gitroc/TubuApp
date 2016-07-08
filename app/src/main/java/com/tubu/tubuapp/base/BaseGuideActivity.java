package com.tubu.tubuapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @Description: 引导页基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/4 12:28
 * @Modifier: songjunpeng
 * @Update: 2016/7/4 12:28
 */
public class BaseGuideActivity <T extends View> extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
