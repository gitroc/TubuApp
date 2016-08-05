package com.tubu.tubuapp.common.utils.ptr;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chanven.lib.cptr.loadmore.ILoadViewMoreFactory;
import com.tubu.tubuapp.R;

/**
 * Created by roc on 16/8/3.
 */
public class PtrFooter implements ILoadViewMoreFactory {

    @Override
    public ILoadMoreView madeLoadMoreView() {
        return new LoadMoreHelper();
    }

    private class LoadMoreHelper implements ILoadMoreView {

        protected View footer;
        protected ImageView ivPtrFooter;
        protected TextView tvPtrFooter;

        protected OnClickListener onClickListener;

        @Override
        public void init(FootViewAdder footViewHolder, View.OnClickListener onClickLoadMoreListener) {
            footer = footViewHolder.addFootView(R.layout.ptr_footer);
            ivPtrFooter = (ImageView) footer.findViewById(R.id.ivPtrFooter);
            tvPtrFooter = (TextView) footer.findViewById(R.id.tvPtrFooter);

            this.onClickListener = onClickLoadMoreListener;

            showNormal();
        }

        @Override
        public void showNormal() {
            tvPtrFooter.setText(R.string.ptr_footer_normal);
            ivPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(onClickListener);
        }

        @Override
        public void showNomore() {
            tvPtrFooter.setText(R.string.ptr_footer_nomore);
            ivPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(null);
        }

        @Override
        public void showLoading() {
            tvPtrFooter.setText(R.string.ptr_footer_loading);
            ivPtrFooter.setVisibility(View.VISIBLE);

            Glide.with(footer.getContext())
                    .load(R.drawable.common_icon_refresh)
                    .asGif()
                    .into(ivPtrFooter);

            footer.setOnClickListener(null);
        }

        @Override
        public void showFail(Exception e) {
            tvPtrFooter.setText(R.string.ptr_footer_fail);
            ivPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(onClickListener);
        }
    }
}
