package com.tubu.tubuapp.module.guide;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tubu.tubuapp.R;
import com.tubu.tubuapp.module.main.MainActivity;


/**
 * @Description: 单图片的欢迎页
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: guizhen
 * @Date: 2016/4/12 12:00
 * @Modifier:
 * @Update:
 */
public class GuideSingleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
            }
        }, 3000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getWindow().setBackgroundDrawable(null);
        return inflater.inflate(R.layout.guide_single, container, false);
    }

}
