package com.tubu.tubuapp.module.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabActivity;
import com.tubu.tubuapp.module.discover.DiscoverFragment;
import com.tubu.tubuapp.module.dynamic.DynamicFragment;
import com.tubu.tubuapp.module.main.listener.TabListener;
import com.tubu.tubuapp.module.mall.MallFragment;
import com.tubu.tubuapp.module.sport.SportFragment;
import com.tubu.tubuapp.module.user.UserFragment;

import timber.log.Timber;

public class MainActivity extends BaseTabActivity<Toolbar> {

    private static String TAG = "[MainActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] tabImages = new int[]{R.drawable.tabbar_dynamic,
                R.drawable.tabbar_mall,
                R.drawable.tabbar_sport,
                R.drawable.tabbar_discover,
                R.drawable.tabbar_user};
        String[] tabNames = getResources().getStringArray(R.array.main_tab_fragment_names);


        init(tabImages, tabNames);
    }

    @Override
    protected void initTitleBar() {
        titlebar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(titlebar);
        getSupportActionBar().setTitle("Home");

        titlebar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ((TabListener) getSelectedFragment()).onMenuClick(item);
                return true;
            }
        });
    }

    @Override
    protected Fragment initFragment(int position) {
        Timber.i(TAG, toString() + "initFragment. position:" + position);
        Fragment [] fragments = new Fragment[] {new DynamicFragment(),
                new MallFragment(),
                new SportFragment(),
                new DiscoverFragment(),
                new UserFragment()};

        return fragments[position];
    }

    @Override
    protected void onFragmentSelected(int position) {
        Timber.i(TAG, toString() + "onFragmentSelected. position:" + position);
//        if ((position == 1 || position == 2) && !MyApp.isLogin) {
//            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            loginIntent.putExtra("changeTab", position);
//            startActivityForResult(loginIntent, REQUEST_CODE_LOGIN);
//        }
    }
}
