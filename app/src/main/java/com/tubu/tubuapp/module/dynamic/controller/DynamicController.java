package com.tubu.tubuapp.module.dynamic.controller;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.tubu.tubuapp.R;
import com.tubu.tubuapp.base.BaseFragment;
import com.tubu.tubuapp.base.BaseFragmentTop;
import com.tubu.tubuapp.common.utils.ptr.PtrLayout;
import com.tubu.tubuapp.module.dynamic.DynamicFragment;
import com.tubu.tubuapp.module.dynamic.entity.DynamicEntity;
import com.tubu.tubuapp.module.dynamic.item.DynamicItem;

import java.util.ArrayList;
import java.util.List;

import kale.adapter.CommonRcvAdapter;
import kale.adapter.item.AdapterItem;

/**
 * @Description: 动态Fragment控制
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/12 10:35
 * @Modifier: songjunpeng
 * @Update: 2016/7/12 10:35
 */
public class DynamicController {
    private String TAG = "[DynamicController]";
    private BaseFragment baseFragment;
    private FragmentActivity context;
    private View view;

    private PtrLayout ptrClassicFrameLayout;
    private RecyclerView recyclerView;
    private List<DynamicEntity> dynamicEntityList = new ArrayList<>();
    private RecyclerAdapterWithHF recyclerAdapterWithHF;
    private CommonRcvAdapter rcvAdapter;

    Handler handler = new Handler();
    int page = 0;

    public DynamicController(DynamicFragment dynamicFragment, View view) {
        super();
        assert dynamicFragment == null;
        assert view == null;

        this.baseFragment = dynamicFragment;
        this.context = dynamicFragment.getActivity();
        this.view = view;

        String[] tabNames = context.getResources().getStringArray(R.array.dynamicFragmentNames);

        init(tabNames);
    }

    protected void init(String[] titles) {
        initBaseFragmentTop(titles);

        initViewPager();
        loadData();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                DaoUtils.testGreenDao(context);
//            }
//        }).start();
    }

    private void initBaseFragmentTop(String[] titles) {
        new BaseFragmentTop(baseFragment, view, titles);
    }

    private void initViewPager() {
        ptrClassicFrameLayout = (PtrLayout) view.findViewById(R.id.layDynamicRecyclerViewFrame);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewDynamicList);

        rcvAdapter = new CommonRcvAdapter<DynamicEntity>(dynamicEntityList) {
            @NonNull
            @Override
            public AdapterItem<DynamicEntity> createItem(Object o) {
                return new DynamicItem(context);
            }
        };

        recyclerAdapterWithHF = new RecyclerAdapterWithHF(rcvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recyclerAdapterWithHF);

        ptrClassicFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptrClassicFrameLayout.autoRefresh();
            }
        }, 150);

        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 0;
                        dynamicEntityList.clear();
                        for (int i = 0; i < 3; i++) {
                            dynamicEntityList.add(new DynamicEntity());
                        }
                        recyclerAdapterWithHF.notifyDataSetChanged();
                        ptrClassicFrameLayout.refreshComplete();
                        ptrClassicFrameLayout.setLoadMoreEnable(true);

                        baseFragment.stopLoading();
                    }
                }, 2000);
            }
        });

        ptrClassicFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        dynamicEntityList.add(new DynamicEntity());
                        recyclerAdapterWithHF.notifyDataSetChanged();
                        ptrClassicFrameLayout.loadMoreComplete(true);
                        page++;
//                        Toast.makeText(context, "load more complete", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });
    }

    private void loadData() {

    }
}