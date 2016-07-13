package com.tubu.tubuapp.module.dynamic.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseFragment;
import com.tubu.tubuapp.module.dynamic.DynamicFragment;
import com.tubu.tubuapp.module.dynamic.fragment.AttentionFragment;
import com.tubu.tubuapp.module.dynamic.fragment.ChoicenessFragment;
import com.tubu.tubuapp.module.dynamic.listener.OnTabClickListener;
import com.tubu.tubuapp.module.dynamic.manager.DynamicTabManager;

import timber.log.Timber;

/**
 * @Description: TODO describe this class
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/12 10:35
 * @Modifier: songjunpeng
 * @Update: 2016/7/12 10:35
 */
public class DynamicController {
    private String TAG = "[DynamicController]";
    private FragmentActivity context;
    private View view;

    private static final int TAB_SIZE_MIN = 1;
    private static final int TAB_SIZE_MAX = 15;
    private int size;
    private LinearLayout tabs;
    private ViewPager viewPager;
    private DynamicTabManager dynamicTabManager;
    private DynamicTabPagerAdpter dynamicTabPagerAdpter;

    public DynamicController(DynamicFragment dynamicFragment, View view) {
        super();
        assert dynamicFragment == null;
        assert view == null;

        this.context = dynamicFragment.getActivity();
        this.view = view;

        String[] tabNames = context.getResources().getStringArray(R.array.dynamicFragmentNames);

        init(tabNames);
    }

    protected void init(String[] titles) {
        initTabBar(titles);
        initViewPager();
    }

    private void initTabBar(String[] titles) {
        if (titles == null) {
            throw new IllegalArgumentException("iconResIds or titles can be null");
        }

        size = titles.length;
        if (size < TAB_SIZE_MIN || size > TAB_SIZE_MAX) {
            throw new IllegalArgumentException("tab size must between 1 and 15");
        }

        tabs = (LinearLayout) view.findViewById(R.id.dynamicTabs);
        dynamicTabManager = new DynamicTabManager(context, tabs);
        for (int i = 0; i < size; ++i) {
            dynamicTabManager.addTab(titles[i]);
        }

        dynamicTabManager.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabClick(int index) {
                viewPager.setCurrentItem(index, true);
            }
        });

        dynamicTabManager.selected(0);
    }

    private void initViewPager() {
        dynamicTabPagerAdpter = new DynamicTabPagerAdpter(context.getSupportFragmentManager());
        viewPager = (ViewPager) view.findViewById(R.id.dynamicViewPager);
        viewPager.setOffscreenPageLimit(size - 1);
        viewPager.setAdapter(dynamicTabPagerAdpter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Timber.i("[OnPageChangeListener]", "onPageSelected position = " + position);
                dynamicTabManager.selected(position);

//                Fragment fragment = getFragment(position);
//                ((DynamicFragment) fragment).onSelected();
                onFragmentSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    protected Fragment initFragment(int position) {
        Timber.i(TAG, toString() + "initFragment. position:" + position);
        BaseFragment [] fragments = new BaseFragment[] {new AttentionFragment(),
                new ChoicenessFragment()};

        return fragments[position];
    }

    protected void onFragmentSelected(int position){
        Timber.i(TAG, "onFragmentSelected position = " + position);
    }

    public Fragment getFragment(int position) {
        return (Fragment) dynamicTabPagerAdpter.instantiateItem(viewPager, position);
    }

    public Fragment getSelectedFragment() {
        return getFragment(viewPager.getCurrentItem());
    }

    class DynamicTabPagerAdpter extends FragmentPagerAdapter {
        private String TAG = "[DynamicTabPagerAdpter]";

        public DynamicTabPagerAdpter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Timber.i(TAG, "getItem position = " + position);
            return initFragment(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Timber.i(TAG, "instantiateItem  position = " + position);
            return super.instantiateItem(container, position);
        }

        @Override
        public int getCount() {
            return size;
        }
    }

}
