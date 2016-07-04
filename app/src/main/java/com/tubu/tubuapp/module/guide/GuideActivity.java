package com.tubu.tubuapp.module.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseActivity;
import com.tubu.tubuapp.common.utils.SpUtils;
import com.tubu.tubuapp.constants.PublicConstants;
import com.tubu.tubuapp.module.main.MainActivity;

/**
 * @Description: 引导
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 16:40
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 16:40
 */
public class GuideActivity extends BaseActivity {
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(GuideActivity.this, MainActivity.class));
            finish();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.guide_splash, null);
        setContentView(view);

        boolean isWelcome = SpUtils.getPreference(this, PublicConstants.SP_KEY_IS_GUIDE_SHOW, true);
        if (isWelcome) {
            view.setBackgroundResource(R.mipmap.app_splash);
            SpUtils.setPreferences(this, PublicConstants.SP_KEY_IS_GUIDE_SHOW, false);
        }

        handler.postDelayed(runnable, 2000);
    }
}
