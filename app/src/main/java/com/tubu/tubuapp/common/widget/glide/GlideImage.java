package com.tubu.tubuapp.common.widget.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tubu.tubuapp.R;

/**
 * @Description: Glide库简单封装
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/11 14:37
 * @Modifier: songjunpeng
 * @Update: 2016/7/11 14:37
 */
public class GlideImage {

    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param activity
     * @param url
     * @param imageView
     */
    public static void display(Activity activity, String url, ImageView imageView) {
        Glide.with(activity).load(url).centerCrop().placeholder(R.drawable.common_pic_loading).crossFade().into(imageView);
    }
    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param context
     * @param url
     * @param imageView
     */
    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).centerCrop().placeholder(R.drawable.common_pic_loading).crossFade().into(imageView);
    }

    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param fragment
     * @param url
     * @param imageView
     */
    public static void display(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment).load(url).centerCrop().placeholder(R.drawable.common_pic_loading).crossFade().into(imageView);
    }

    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param activity
     * @param drawableId
     * @param imageView
     */
    public static void dispaly(Activity activity, int drawableId, ImageView imageView) {
        Glide.with(activity).load(drawableId).centerCrop().into(imageView);
    }

    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param context
     * @param drawableId
     * @param imageView
     */
    public static void display(Context context, int drawableId, ImageView imageView) {
        Glide.with(context).load(drawableId).centerCrop().into(imageView);
    }

    /**
     * 使用异步图片加载库加载并显示图片
     * 会裁剪图片适应ImageView
     * @param fragment
     * @param drawableId
     * @param imageView
     */
    public static void diplay(Fragment fragment, int drawableId, ImageView imageView) {
        Glide.with(fragment).load(drawableId).centerCrop().into(imageView);
    }

    /**
     * 使用异步图片加载库加载并显示图片
     * 此方法提供成功加载图片后的回调
     * 不会裁剪图片适应ImageView
     * @param fragment
     * @param url
     * @param imageView
     * @param imageListener
     */
    private static void displayImage(Fragment fragment, String url, ImageView imageView, final ImageListener imageListener) {
        Glide.with(fragment).load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                if (imageListener != null) {
                    imageListener.onReady();
                }
                return false;
            }
        }).placeholder(R.drawable.common_pic_loading).crossFade().into(imageView);
    }
}
