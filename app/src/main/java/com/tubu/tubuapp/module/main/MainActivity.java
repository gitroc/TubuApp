package com.tubu.tubuapp.module.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseTabActivity;
import com.tubu.tubuapp.base.BaseTabFragment;
import com.tubu.tubuapp.common.utils.toast.ToastUtils;
import com.tubu.tubuapp.module.discover.DiscoverFragment;
import com.tubu.tubuapp.module.dynamic.DynamicFragment;
import com.tubu.tubuapp.module.main.listener.TabListener;
import com.tubu.tubuapp.module.mall.MallFragment;
import com.tubu.tubuapp.module.sport.SportFragment;
import com.tubu.tubuapp.module.user.UserFragment;

public class MainActivity extends BaseTabActivity<Toolbar> {

    private static String TAG = "[MainActivity]";
    //    private boolean isExit = false;
    private long exitTime = 0l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] tabImages = new int[]{R.drawable.tabbar_dynamic,
                R.drawable.tabbar_mall,
                R.drawable.tabbar_sport,
                R.drawable.tabbar_discover,
                R.drawable.tabbar_user};

        String[] tabNames = getResources().getStringArray(R.array.mainTabFragmentNames);


        init(tabImages, tabNames);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {// 没有其他页面需要退出，就执行两次退出程序操作
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.show(this, getResources().getString(R.string.exit_app));
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void initTitleBar() {
        titlebar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(titlebar);
        getSupportActionBar().setTitle("Dynamic");

        titlebar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ((TabListener) getSelectedFragment()).onMenuClick(item);
                return true;
            }
        });
    }

    @Override
    protected BaseTabFragment initFragment(int position) {
        Logger.t(TAG).i("initFragment. position:" + position);
        BaseTabFragment[] fragments = new BaseTabFragment[]{new DynamicFragment(),
                new MallFragment(),
                new SportFragment(),
                new DiscoverFragment(),
                new UserFragment()};

        return fragments[position];
    }

    @Override
    protected void onFragmentSelected(int position) {
        Logger.t(TAG).i(toString() + "onFragmentSelected. position:" + position);
//        if ((position == 1 || position == 2) && !MyApp.isLogin) {
//            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
//            loginIntent.putExtra("changeTab", position);
//            startActivityForResult(loginIntent, REQUEST_CODE_LOGIN);
//        }
    }
}
