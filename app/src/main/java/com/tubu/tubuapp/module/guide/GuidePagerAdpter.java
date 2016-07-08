package com.tubu.tubuapp.module.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;


import com.tubu.tubuapp.R;
import com.tubu.tubuapp.common.utils.SpUtils;
import com.tubu.tubuapp.constants.PublicConstants;
import com.tubu.tubuapp.module.main.MainActivity;

import java.util.List;

/**
 * Created by songjunpeng on 2015/10/16.
 */
public class GuidePagerAdpter extends PagerAdapter {

    private Activity activity;
    //界面列表
    private List<View> views;

    public GuidePagerAdpter(Activity activity, List<View> views){
        this.activity = activity;
        this.views = views;
    }

    //销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
        // TODO Auto-generated method stub

    }

    //获得当前界面数
    @Override
    public int getCount() {
        if (views != null)
        {
            return views.size();
        }

        return 0;
    }


    //初始化arg1位置的界面
    @Override
    public Object instantiateItem(View arg0, int arg1) {

        ((ViewPager) arg0).addView(views.get(arg1), 0);

        if (arg1 == views.size() - 1) {
            ImageView mStartWeiboImageButton = (ImageView) arg0
                    .findViewById(R.id.iv_start_app);
            mStartWeiboImageButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    SpUtils.setPreferences(activity, PublicConstants.SP_KEY_IS_FIRST_GUIDE, true);

                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                }
            });
        }

        return views.get(arg1);
    }

    //判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public Parcelable saveState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
        // TODO Auto-generated method stub

    }
}
