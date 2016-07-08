package com.tubu.tubuapp.module.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.tubu.tubuapp.BuildConfig;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);

        final boolean is_first_guide = SpUtils.getPreference(this, PublicConstants.SP_KEY_IS_FIRST_GUIDE, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!is_first_guide) {
                    SpUtils.setPreferences(GuideActivity.this, PublicConstants.SP_KEY_IS_FIRST_GUIDE, true);

                    if (BuildConfig.single_guide) {
                        getSupportFragmentManager().beginTransaction().add(R.id.container, new GuideSingleFragment()).commitAllowingStateLoss();
                    } else {
                        getSupportFragmentManager().beginTransaction().add(R.id.container, new GuideMultiFragment()).commitAllowingStateLoss();
                    }
                } else {
                    startActivity(new Intent(GuideActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 1000);
    }
}
