package com.tubu.tubuapp.module.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.github.johnpersano.supertoasts.SuperToast;
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
    private boolean isExit = false;

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
        if (keyCode == KeyEvent.KEYCODE_BACK) {// 没有其他页面需要退出，就执行两次退出程序操作
            exit();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出操作
     */
    private void exit() {
        if (!isExit) {
            SuperToast superToast = new SuperToast(getApplicationContext());
            superToast.setAnimations(SuperToast.Animations.FLYIN);
            superToast.setDuration(SuperToast.Duration.SHORT);
            superToast.setText(getResources().getString(R.string.exit_app));
            superToast.setTextSize(SuperToast.TextSize.SMALL);
            superToast.setBackground(SuperToast.Background.RED);
            superToast.setIcon(SuperToast.Icon.Dark.INFO, SuperToast.IconPosition.LEFT);
            superToast.show();
//            SuperToast.show(getApplicationContext(), getResources().getString(R.string.exit_app));
            isExit = true;
            handler.postDelayed(runnable, 2000);// 两秒种重置
        } else {
            this.finish();
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Message msg = new Message();
            msg.what = EXIT_APP;
            handler.handleMessage(msg);
        }
    };

    protected static final int EXIT_APP = 0x001;

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case EXIT_APP:
                    isExit = false;
                    break;
                default:
                    break;
            }
        }
    };

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
