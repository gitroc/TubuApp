//package com.tubu.tubuapp.base;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.tubu.tubuapp.R;
//
//import timber.log.Timber;
//
///**
// * @Description: BaseViewFragment基类，添加Loading View 和 Login View 管理
// * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
// * @Author: songjunpeng
// * @Date: 2016/7/11 14:22
// * @Modifier: songjunpeng
// * @Update: 2016/7/11 14:22
// */
//public abstract class BaseViewFragment extends BaseFragment {
//    private static String TAG = "[BaseViewFragment]";
//    private View view;
//    private ImageView imageView;
//
//    public View createView(LayoutInflater inflater, int layoutId, boolean showLoading) {
//        return createView(inflater, layoutId, showLoading, false);
//    }
//
//    public View createView(LayoutInflater inflater, int layoutId, boolean showLoading, boolean recreate) {
//        if (view != null) {
//            ViewGroup group = (ViewGroup) view.getParent();
//            if (group != null) {
//                group.removeAllViews();
//            }
//        }
//
//        if (view == null || recreate) {
//            view = inflater.inflate(layoutId, null);
//            if (showLoading) {
//                imageView = (ImageView) view.findViewById(R.id.ivLoading);
//                Timber.i(TAG, "show loading page");
//                startLoading();
//            }
//            initView();
//        }
//
//        return view;
//    }
//
//    /**
//     * 显示加载页
//     */
//    public void startLoading() {
//        if (imageView != null) {
//            imageView.setVisibility(View.VISIBLE);
//        }
//    }
//
//    /**
//     * 隐藏加载页面
//     */
//    public void stopLoading() {
//        if (imageView != null) {
//            imageView.setVisibility(View.GONE);
//        }
//    }
//
//    public abstract void initView();
//}
