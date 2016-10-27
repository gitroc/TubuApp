package com.tubu.tubuapp.base;

import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO describe this class
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/14 16:11
 * @Modifier: songjunpeng
 * @Update: 2016/7/14 16:11
 */
public class BaseFragmentTop {
    private String TAG = "[BaseFragmentTop]";

    private BaseFragment fragment;
    private View view;

    private int currentIndex = 0;

    private TextView tvFramentOne;
    private TextView tvFramentTwo;
    private TextView tvFramentThree;
    private TextView tvFramentFour;
    private TextView tvFramentFive;

    private final int fragmentIndexOne = 0;
    private final int fragmentIndexTwo = 1;
    private final int fragmentIndexThree = 2;
    private final int fragmentIndexFour = 3;
    private final int fragmentIndexFive = 4;

    private List<TextView> textViews = new ArrayList<>();

    public BaseFragmentTop(BaseFragment fragment, View view, String[] titles) {
        assert fragment == null || view == null || titles == null;

        this.fragment = fragment;
        this.view = view;

        initViewPager();

        init(titles);

        setCurrentIndex(0);

        setOnClickListener();
    }

    private void initViewPager() {
        tvFramentOne = (TextView) view.findViewById(R.id.tvFramentOne);
        tvFramentTwo = (TextView) view.findViewById(R.id.tvFramentTwo);
        tvFramentThree = (TextView) view.findViewById(R.id.tvFramentThree);
        tvFramentFour = (TextView) view.findViewById(R.id.tvFramentFour);
        tvFramentFive = (TextView) view.findViewById(R.id.tvFramentFive);

        textViews.add(tvFramentOne);
        textViews.add(tvFramentTwo);
        textViews.add(tvFramentThree);
        textViews.add(tvFramentFour);
        textViews.add(tvFramentFive);
    }


    public void init(String[] titles) {
        if (titles.length < textViews.size()) {
            for (int i = titles.length; i < textViews.size(); i++) {
                hideTitle(textViews.get(i));
                textViews.remove(i);
            }
        }

        for (int i = 0; i < titles.length; i++) {
            showTitle(textViews.get(i));
            setTitleText(textViews.get(i), titles[i]);
        }
    }

    private void setCurrentIndex(int index) {
        currentIndex = index;

        for (int i = 0; i < textViews.size(); i++) {
            if (index == i) {
                enableTitle(textViews.get(i));
            } else {
                disableTitle(textViews.get(i));
            }
        }
    }

    private int getCurrentIndex() {
        return currentIndex;
    }

    private void setOnClickListener() {
        Logger.t(TAG).i("currentIndex = " + currentIndex);
        tvFramentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentIndexOne != getCurrentIndex()) {
                    setCurrentIndex(fragmentIndexOne);
                }
            }
        });

        tvFramentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentIndexTwo != getCurrentIndex()) {
                    setCurrentIndex(fragmentIndexTwo);
                }
            }
        });

        tvFramentThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentIndexThree != getCurrentIndex()) {
                    setCurrentIndex(fragmentIndexThree);
                }
            }
        });

        tvFramentFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentIndexFour != getCurrentIndex()) {
                    setCurrentIndex(fragmentIndexFour);
                }
            }
        });

        tvFramentFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentIndexFive != getCurrentIndex()) {
                    setCurrentIndex(fragmentIndexFive);
                }
            }
        });
    }

    private void showTitle(TextView textView) {
        textView.setVisibility(View.VISIBLE);
    }

    private void hideTitle(TextView textView) {
        textView.setVisibility(View.GONE);
    }

    private void enableTitle(TextView textView) {
        textView.setTextColor(fragment.getActivity().getResources().getColor(R.color.blue));
    }

    private void disableTitle(TextView textView) {
        textView.setTextColor(fragment.getActivity().getResources().getColor(R.color.gray1));
    }

    private void setTitleText(TextView textView, String title) {
        textView.setText(title);
    }
}
