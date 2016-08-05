package com.tubu.tubuapp.common.utils.ptr;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

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
        protected ProgressBar pbPtrFooter;
        protected TextView tvPtrFooter;

        protected OnClickListener onClickListener;

        @Override
        public void init(FootViewAdder footViewHolder, View.OnClickListener onClickLoadMoreListener) {
            footer = footViewHolder.addFootView(R.layout.ptr_footer);
            pbPtrFooter = (ProgressBar) footer.findViewById(R.id.pbPtrFooter);
            tvPtrFooter = (TextView) footer.findViewById(R.id.tvPtrFooter);

            this.onClickListener = onClickLoadMoreListener;

            showNormal();
        }

        @Override
        public void showNormal() {
            tvPtrFooter.setText(R.string.ptr_footer_normal);
            pbPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(onClickListener);
        }

        @Override
        public void showNomore() {
            tvPtrFooter.setText(R.string.ptr_footer_nomore);
            pbPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(null);
        }

        @Override
        public void showLoading() {
            tvPtrFooter.setText(R.string.ptr_footer_loading);
            pbPtrFooter.setVisibility(View.VISIBLE);
            footer.setOnClickListener(null);
        }

        @Override
        public void showFail(Exception e) {
            tvPtrFooter.setText(R.string.ptr_footer_fail);
            pbPtrFooter.setVisibility(View.GONE);
            footer.setOnClickListener(onClickListener);
        }
    }
}
