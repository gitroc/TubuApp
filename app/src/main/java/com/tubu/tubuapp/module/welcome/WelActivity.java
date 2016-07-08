package com.tubu.tubuapp.module.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseActivity;
import com.tubu.tubuapp.common.utils.SpUtils;
import com.tubu.tubuapp.constants.PublicConstants;
import com.tubu.tubuapp.module.guide.GuideMultiFragment;
import com.tubu.tubuapp.module.main.MainActivity;


/**
 * @Description: 主界面之前的引导页or欢迎页。
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: guizhen
 * @Date: 2016/4/12 12:00
 * @Modifier:
 * @Update:
 */
public class WelActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        final boolean isfirst = SpUtils.getPreference(this, PublicConstants.SP_KEY_IS_FIRST_GUIDE, true);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isfirst) {
                    SpUtils.setPreferences(WelActivity.this, PublicConstants.SP_KEY_IS_FIRST_GUIDE, false);
                    getSupportFragmentManager().beginTransaction().add(R.id.container, new GuideMultiFragment()).commitAllowingStateLoss();
                } else {
                    startActivity(new Intent(WelActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 1000);
    }
}
