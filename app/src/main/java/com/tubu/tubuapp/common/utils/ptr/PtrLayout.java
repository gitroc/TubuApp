package com.tubu.tubuapp.common.utils.ptr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;

import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.DefaultLoadMoreFooter;
import com.chanven.lib.cptr.loadmore.GridViewHandler;
import com.chanven.lib.cptr.loadmore.ILoadViewMoreFactory;
import com.chanven.lib.cptr.loadmore.ListViewHandler;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.OnScrollBottomListener;
import com.chanven.lib.cptr.loadmore.RecyclerViewHandler;

/**
 * Created by roc on 16/8/3.
 */
public class PtrLayout extends PtrFrameLayout {
    private PtrHeader ptrHeader;
    public PtrLayout(Context context) {
        super(context);
        initViews();
    }

    public PtrLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public PtrLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    private void initViews() {
        ptrHeader = new PtrHeader(getContext());
        setHeaderView(ptrHeader);
        addPtrUIHandler(ptrHeader);
    }

    public PtrHeader getHeader() {
        return ptrHeader;
    }

    /**
     * Specify the last update time by this key string
     *
     * @param key
     */
    public void setLastUpdateTimeKey(String key) {
        if (ptrHeader != null) {
            ptrHeader.setLastUpdateTimeKey(key);
        }
    }

    /**
     * Using an object to specify the last update time.
     *
     * @param object
     */
    public void setLastUpdateTimeRelateObject(Object object) {
        if (ptrHeader != null) {
            ptrHeader.setLastUpdateTimeRelateObject(object);
        }
    }

    private boolean isLoading = false;
    private boolean isAutoLoadMore = true;
    private boolean isLoadMoreEnable = false;
    private boolean hasInitLoadMoreView = false;
    private ILoadViewMoreFactory loadViewFactory = new PtrFooter();
    private ListViewHandler listViewHandler = new ListViewHandler();
    private RecyclerViewHandler recyclerViewHandler = new RecyclerViewHandler();
    private GridViewHandler gridViewHandler = new GridViewHandler();

    private View mContentView;
    private ILoadViewMoreFactory.ILoadMoreView mLoadMoreView;

    public void setLoadMoreEnable(boolean loadMoreEnable) {
        if (this.isLoadMoreEnable == loadMoreEnable) {
            return;
        }
        this.isLoadMoreEnable = loadMoreEnable;
        if (!hasInitLoadMoreView && isLoadMoreEnable) {
            mContentView = getContentView();
            mLoadMoreView = loadViewFactory.madeLoadMoreView();
            if (mContentView instanceof GridView) {
                hasInitLoadMoreView = gridViewHandler.handleSetAdapter(mContentView, mLoadMoreView,
                        onClickLoadMoreListener);
                gridViewHandler.setOnScrollBottomListener(mContentView, onScrollBottomListener);
                return;
            }
            if (mContentView instanceof AbsListView) {
                hasInitLoadMoreView = listViewHandler.handleSetAdapter(mContentView, mLoadMoreView,
                        onClickLoadMoreListener);
                listViewHandler.setOnScrollBottomListener(mContentView, onScrollBottomListener);
            } else if (mContentView instanceof RecyclerView) {
                hasInitLoadMoreView = recyclerViewHandler.handleSetAdapter(mContentView, mLoadMoreView,
                        onClickLoadMoreListener);
                recyclerViewHandler.setOnScrollBottomListener(mContentView, onScrollBottomListener);
            }
        }
    }

    private OnScrollBottomListener onScrollBottomListener = new OnScrollBottomListener() {
        @Override
        public void onScorllBootom() {
            if (isAutoLoadMore && isLoadMoreEnable && !isLoading()) {
                // 此处可加入网络是否可用的判断
                loadMore();
            }
        }
    };

    private View.OnClickListener onClickLoadMoreListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            loadMore();
        }
    };

    void loadMore() {
        isLoading = true;
        mLoadMoreView.showLoading();
        mOnLoadMoreListener.loadMore();
    }

    public void loadMoreComplete(boolean hasMore) {
        isLoading = false;
        if (hasMore) {
            mLoadMoreView.showNormal();
        } else {
            setNoMoreData();
        }
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setNoMoreData() {
        isLoadMoreEnable = false;
        mLoadMoreView.showNomore();
    }

    OnLoadMoreListener mOnLoadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.mOnLoadMoreListener = loadMoreListener;
    }
}
