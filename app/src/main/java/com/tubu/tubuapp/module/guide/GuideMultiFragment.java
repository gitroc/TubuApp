package com.tubu.tubuapp.module.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tubu.tubuapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 多图片的欢迎页
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/4/20 17:04
 * @Modifier: songjunpeng
 * @Update: 2016/4/20 17:04
 */
public class GuideMultiFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private View view;
    private ViewPager vp;
    private GuidePagerAdpter vpAdapter;
    private List<View> views;

    //引导图片资源
    private static final int[] layouts = {R.layout.guide_page_one, R.layout.guide_page_two, R.layout.guide_page_three};

    //底部小店图片
    private ImageView[] dots;

    //记录当前选中位置
    private int currentIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(this.getActivity()).inflate(R.layout.guide_multi, null);

        initData();
        vp = (ViewPager) view.findViewById(R.id.viewpager);

        //初始化Adapter
        vpAdapter = new GuidePagerAdpter(this.getActivity(), views);
        vp.setAdapter(vpAdapter);
        //绑定回调
        vp.setOnPageChangeListener(this);

        getActivity().getWindow().setBackgroundDrawable(null);
        return view;
    }

    private void initData() {
        views = new ArrayList<>();

        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        //初始化引导图片列表
        for (int i = 0; i < layouts.length; i++) {
            views.add(inflater.inflate(layouts[i], null));
        }

        //初始化底部小点
        initDots();
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll);

        dots = new ImageView[layouts.length];

        //循环取得小点图片
        for (int i = 0; i < layouts.length; i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);//都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);//设置位置tag，方便取出与当前位置对应
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(false);//设置为白色，即选中状态
    }

    /**
     * 设置当前的引导页
     */
    private void setCurView(int position) {
        if (position < 0 || position >= layouts.length) {
            return;
        }

        vp.setCurrentItem(position);
    }

    /**
     * 这只当前引导小点的选中
     */
    private void setCurDot(int positon) {
        if (positon < 0 || positon > layouts.length - 1 || currentIndex == positon) {
            return;
        }

        dots[positon].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = positon;
    }

    //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    //当当前页面被滑动时调用
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    //当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        //设置底部小点选中状态
        setCurDot(arg0);
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }
}

