package com.tubu.tubuapp.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.module.main.manager.TabManager;

/**
 * @Description: Tab布局基类
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/1 17:37
 * @Modifier: songjunpeng
 * @Update: 2016/7/1 17:37
 */
public abstract class BaseTabActivity <T extends View> extends BaseActivity {
    private String TAG = "[BaseTabActivity]";
    private static final int TAB_SIZE_MIN = 3;
    private static final int TAB_SIZE_MAX = 5;

    private FragmentManager fragmentManager;
    private ViewPager viewPager;
    protected T titlebar;
    private TabManager tabManager;
    private LinearLayout tabs;
    private TabPagerAdapter adapter;
    private int size;

    protected void init(int[] iconResIds, String[] titles) {
        initTitleBar();
        initTabBar(iconResIds, titles);
        initViewPager();
    }

    protected abstract void initTitleBar();

    private void initTabBar(int[] iconResIds, String[] titles) {
        if (iconResIds == null || titles == null) {
            throw new IllegalArgumentException("iconResIds or titles can be null");
        }
        if (iconResIds.length != titles.length) {
            throw new IllegalArgumentException("iconResIds size must equals titles size");
        }


        size = iconResIds.length;
        if (size < TAB_SIZE_MIN || size > TAB_SIZE_MAX) {
            throw new IllegalArgumentException("tab size must between 3 and 5");
        }

        tabs = (LinearLayout) findViewById(R.id.mainTabs);
        tabManager = new TabManager(this, tabs);
        for (int i = 0; i < size; ++i) {
            tabManager.addTab(iconResIds[i], titles[i]);
        }

        tabManager.setOnTabClickListener(new TabManager.onTabClickListener() {
            @Override
            public void onClick(int index) {
                viewPager.setCurrentItem(index, true);
            }
        });

        tabManager.select(0);
    }


    private void initViewPager() {
        fragmentManager = getSupportFragmentManager();

        adapter = new TabPagerAdapter(fragmentManager);
        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setOffscreenPageLimit(size - 1);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Logger.t(TAG).i("onPageSelected1===,position:" + position);
                tabManager.select(position);
                Fragment f = getFragment(position);
                ((BaseTabFragment) f).onSelected();
                onFragmentSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    protected abstract void onFragmentSelected(int position);

    public class TabPagerAdapter extends FragmentPagerAdapter {
        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Logger.t(TAG).i("getItem===" + position);
            return initFragment(position);
        }

        @Override
        public Fragment instantiateItem(ViewGroup container, int position) {
            Logger.t(TAG).i("instantiateItem===,position:" + position);
            Fragment obj = (Fragment) super.instantiateItem(container, position);
            ((BaseTabFragment) obj).setTitlebar(titlebar);
            return obj;
        }

        @Override
        public int getCount() {
            return size;
        }
    }

    protected abstract Fragment initFragment(int position);

    public Fragment getFragment(int position) {
        return adapter.instantiateItem(viewPager, position);
    }

    public Fragment getSelectedFragment() {
        return getFragment(viewPager.getCurrentItem());
    }
}
