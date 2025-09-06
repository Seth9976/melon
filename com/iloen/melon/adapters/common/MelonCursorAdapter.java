package com.iloen.melon.adapters.common;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import androidx.recyclerview.widget.l0;
import androidx.viewpager2.adapter.d;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.responsecache.b;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import v9.i;
import v9.k;
import v9.o;

public abstract class MelonCursorAdapter extends r implements B, e, l, n, u {
    private static final String TAG = "MelonCursorAdapter";
    protected static final int TYPE_ITEM_BASE = 100;
    protected static final int TYPE_ITEM_EMPTY_VIEW = 103;
    protected static final int TYPE_ITEM_LOADING_MORE = 102;
    protected static final int TYPE_ITEM_NETWORK_ERROR_VIEW = 104;
    protected static final int TYPE_ITEM_PARALLAX_FOOTER = 105;
    protected static final int TYPE_ITEM_PARALLAX_HEADER = 101;
    private int footerClipToPaddingHeight;
    protected String mCacheKey;
    private v9.e mEmptyViewInfo;
    private int mEmptyViewResId;
    private int mErrorViewResId;
    private boolean mFooterParallaxEnabled;
    private int mFooterParallaxHeight;
    private boolean mHasMore;
    private boolean mHeaderParallaxEnabled;
    private int mHeaderParallaxHeight;
    private boolean mIsShowEmptyView;
    private boolean mIsShowErrorView;
    private boolean mIsShowLoading;
    private int mLoadingResId;
    private k mLoadingViewInfo;
    private o mNetworkErrorInfo;
    private final l0 mObserver;
    protected HttpResponse mResponse;

    public MelonCursorAdapter(Context context0, Cursor cursor0) {
        super(context0, cursor0);
        this.mHeaderParallaxHeight = -1;
        this.mFooterParallaxHeight = -1;
        this.footerClipToPaddingHeight = 0;
        this.mLoadingResId = -1;
        this.mEmptyViewResId = -1;
        this.mErrorViewResId = -1;
        d d0 = new d(this, 1);
        this.mObserver = d0;
        this.registerAdapterDataObserver(d0);
    }

    @Override  // com.iloen.melon.adapters.common.B
    public void addResponse(String s, i i0, HttpResponse httpResponse0) {
        LogU.v("MelonCursorAdapter", "addResponse() key: " + s + ", FetchType:" + i0);
        this.mCacheKey = s;
        this.mResponse = httpResponse0;
        i i1 = i.b;
        if(i1.equals(i0)) {
            a.c(this.getContext(), s, false);
        }
        if(httpResponse0 instanceof ResponseAdapter) {
            this.setMenuId(((ResponseAdapter)httpResponse0).getMenuId());
            this.setHasMore(((ResponseAdapter)httpResponse0).hasMore());
            this.setStatsElements(((ResponseAdapter)httpResponse0).getStatsElements());
            Collection collection0 = ((ResponseAdapter)httpResponse0).getItems();
            if(collection0 != null && !collection0.isEmpty() && !TextUtils.isEmpty(s)) {
                LogU.v("MelonCursorAdapter", "addResponse() collection size: " + collection0.size());
                int v = collection0.size();
                ArrayList arrayList0 = new ArrayList();
                long v1 = System.currentTimeMillis();
                int v2 = 0;
                for(Object object0: collection0) {
                    arrayList0.add(b.a(s, object0, (v2 == v - 1 ? ((ResponseAdapter)httpResponse0).hasMore() : false), v1));
                    ++v2;
                }
                a.b(this.getContext(), s, arrayList0, i1.equals(i0));
                return;
            }
            LogU.w("MelonCursorAdapter", "addResponse() collection is empty or key doesn\'t exist.");
        }
    }

    public static void b(MelonCursorAdapter melonCursorAdapter0) {
        melonCursorAdapter0.checkIfEmpty();
    }

    private void checkIfEmpty() {
        this.showEmptyView(this.getCount() == 0);
    }

    @Override  // com.iloen.melon.adapters.common.B
    public void clearCache(String s) {
        LogU.v("MelonCursorAdapter", "clearCache() key: " + s);
        this.mCacheKey = null;
        this.mResponse = null;
        if(!TextUtils.isEmpty(s)) {
            a.c(this.getContext(), s, false);
        }
    }

    public final int getAvailableFooterPosition() {
        return this.getLoadingMoreViewPosition() - 1;
    }

    public final int getAvailableHeaderPosition() {
        return this.getParallaxHeaderViewPosition() + 1;
    }

    @Override  // com.iloen.melon.adapters.common.B
    public String getCacheKey() {
        return this.mCacheKey;
    }

    public final int getEmptyViewPosition() {
        return this.getNetworkErrorViewPosition() - 1;
    }

    public int getFooterParallaxHeight() {
        return this.mFooterParallaxHeight;
    }

    @Override  // com.iloen.melon.adapters.common.RecyclerViewCursorAdapter
    public final int getFooterViewCount() {
        return this.hasFooterParallax() + 3;
    }

    public int getFooterViewItemCount() [...] // Inlined contents

    public int getHeaderParallaxHeight() {
        return this.mHeaderParallaxHeight;
    }

    @Override  // com.iloen.melon.adapters.common.RecyclerViewCursorAdapter
    public final int getHeaderViewCount() {
        return this.getHeaderViewItemCount() + this.hasHeaderParallax();
    }

    public int getHeaderViewItemCount() {
        return 0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemViewType(int v) {
        if(v == this.getParallaxHeaderViewPosition() && this.hasHeaderParallax()) {
            return 101;
        }
        if(v == this.getLoadingMoreViewPosition()) {
            return 102;
        }
        if(v == this.getEmptyViewPosition()) {
            return 103;
        }
        if(v == this.getNetworkErrorViewPosition()) {
            return 104;
        }
        return v != this.getParallaxFooterViewPosition() || !this.hasFooterParallax() ? this.getItemViewTypeImpl(v, this.getItemPositionFromList(v)) : 105;
    }

    public abstract int getItemViewTypeImpl(int arg1, int arg2);

    public final int getLoadingMoreViewPosition() {
        return this.getEmptyViewPosition() - 1;
    }

    public final int getNetworkErrorViewPosition() {
        return this.getParallaxFooterViewPosition() - 1;
    }

    public final int getParallaxFooterViewPosition() {
        int v = this.getItemCount();
        return this.hasFooterParallax() ? v - 1 : v;
    }

    // 去混淆评级： 低(20)
    public final int getParallaxHeaderViewPosition() {
        return this.hasHeaderParallax() ? 0 : -1;
    }

    public HttpResponse getResponse() {
        return this.mResponse;
    }

    public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) [...] // Inlined contents

    @Override  // com.iloen.melon.adapters.common.u
    public boolean hasFooterParallax() {
        return this.mFooterParallaxEnabled;
    }

    public boolean hasHeaderParallax() {
        return this.mHeaderParallaxEnabled;
    }

    @Override  // com.iloen.melon.adapters.common.l
    public boolean hasMore() {
        return this.mHasMore;
    }

    @Override  // com.iloen.melon.adapters.common.n
    public void hideLoading() {
        this.showLoadingImpl(false);
    }

    @Override  // com.iloen.melon.adapters.common.B
    public boolean isExpired(String s, long v) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonCursorAdapter", "isExpired() invalid key");
            return true;
        }
        return a.e(v, s, this.getContext());
    }

    @Override  // com.iloen.melon.adapters.common.n
    public boolean isLoadingShowing() {
        return this.mIsShowLoading;
    }

    public final boolean isReservedPosition(int v) {
        return this.getParallaxHeaderViewPosition() == v || this.getLoadingMoreViewPosition() == v || this.getEmptyViewPosition() == v || this.getNetworkErrorViewPosition() == v || this.getParallaxFooterViewPosition() == v;
    }

    @Override  // com.iloen.melon.adapters.common.RecyclerViewCursorAdapter
    public final void onBindViewHolder(O0 o00, Cursor cursor0, int v, int v1) {
        boolean z = false;
        switch(o00.getItemViewType()) {
            case 101: {
                FrameLayout frameLayout0 = ((v)o00).a;
                if(this.mHeaderParallaxHeight > 0) {
                    z = true;
                }
                ViewUtils.showWhen(frameLayout0, z);
                if(frameLayout0.getLayoutParams().height != this.mHeaderParallaxHeight) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
                    viewGroup$LayoutParams0.height = this.mHeaderParallaxHeight;
                    return;
                }
                break;
            }
            case 102: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                boolean z1 = this.mIsShowLoading;
                ViewUtils.showWhen(((m)o00).itemView, z1);
                ViewUtils.showWhen(((m)o00).b, z1);
                return;
            }
            case 103: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                ((f)o00).a(this.mIsShowEmptyView, this.mEmptyViewInfo);
                return;
            }
            case 104: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                ((t)o00).a(this.mIsShowErrorView, this.mNetworkErrorInfo);
                return;
            }
            case 105: {
                FrameLayout frameLayout1 = ((v)o00).a;
                if(this.mFooterParallaxHeight > 0) {
                    z = true;
                }
                ViewUtils.showWhen(frameLayout1, z);
                if(frameLayout1.getLayoutParams().height != this.mFooterParallaxHeight) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = frameLayout1.getLayoutParams();
                    viewGroup$LayoutParams1.height = this.mFooterParallaxHeight - this.footerClipToPaddingHeight;
                }
                break;
            }
            default: {
                this.onBindViewImpl(o00, cursor0, v, v1);
            }
        }
    }

    public abstract void onBindViewImpl(O0 arg1, Cursor arg2, int arg3, int arg4);

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        switch(v) {
            case 101: {
                return new v(this.mInflater.inflate(0x7F0D085F, viewGroup0, false));  // layout:spacing_header
            }
            case 102: {
                return new m(this.mInflater.inflate((this.mLoadingResId == -1 ? 0x7F0D0024 : this.mLoadingResId), viewGroup0, false));  // layout:adapter_loading_more_view
            }
            case 103: {
                return new f(this.getContext(), this.mInflater.inflate((this.mEmptyViewResId == -1 ? 0x7F0D0022 : this.mEmptyViewResId), viewGroup0, false));  // layout:adapter_empty_view
            }
            case 104: {
                return new t(this.getContext(), this.mInflater.inflate((this.mErrorViewResId == -1 ? 0x7F0D0028 : this.mErrorViewResId), viewGroup0, false));  // layout:adapter_network_error_view
            }
            case 105: {
                return new v(this.mInflater.inflate(0x7F0D085F, viewGroup0, false));  // layout:spacing_header
            }
            default: {
                return this.onCreateViewHolderImpl(viewGroup0, v);
            }
        }
    }

    public abstract O0 onCreateViewHolderImpl(ViewGroup arg1, int arg2);

    @Override  // com.iloen.melon.adapters.common.B
    public void removeResponse(String s) {
        LogU.v("MelonCursorAdapter", "removeResponse() key: " + s);
        this.clearCache(s);
        this.setMenuId(null);
        this.setHasMore(false);
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void setEmptyViewInfo(v9.e e0) {
        this.mEmptyViewInfo = v9.e.a(this.mEmptyViewInfo, e0);
    }

    public void setEmptyViewResId(int v) {
        this.mEmptyViewResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void setErrorViewInfo(o o0) {
        this.mNetworkErrorInfo = o.a(this.mNetworkErrorInfo, o0);
    }

    public void setErrorViewResId(int v) {
        this.mErrorViewResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterClipToPaddingHeight(int v) {
        this.footerClipToPaddingHeight = v;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterParallaxEnabled(boolean z) {
        this.mFooterParallaxEnabled = z;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterParallaxHeight(int v) {
        if(v < 0) {
            v = 0;
        }
        if(this.hasFooterParallax() && this.mFooterParallaxHeight != v) {
            this.mFooterParallaxHeight = v;
            this.notifyDataSetChanged();
        }
    }

    public void setFullSpanIfStaggeredGridLayoutManager(View view0) {
        if(view0 == null) {
            LogU.w("MelonCursorAdapter", "setFullSpanIfStaggeredGridLayoutManager() invalid view");
            return;
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            ((LayoutParams)viewGroup$LayoutParams0).f = true;
            viewGroup$LayoutParams0.width = -1;
            viewGroup$LayoutParams0.height = -2;
            view0.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    @Override  // com.iloen.melon.adapters.common.l
    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setHeaderParallaxEnabled(boolean z) {
        this.mHeaderParallaxEnabled = z;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setHeaderParallaxHeight(int v) {
        if(this.hasHeaderParallax()) {
            this.mHeaderParallaxHeight = v;
            this.notifyDataSetChanged();
        }
    }

    public void setLoadingViewInfo(k k0) {
    }

    public void setLoadingViewResId(int v) {
        this.mLoadingResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void showEmptyView(boolean z) {
        if(this.mIsShowEmptyView == z) {
            return;
        }
        this.mIsShowErrorView = false;
        this.mIsShowEmptyView = z;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void showErrorView(boolean z) {
        if(this.mIsShowErrorView == z) {
            return;
        }
        this.mIsShowEmptyView = false;
        this.mIsShowErrorView = z;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.n
    public void showLoading() {
        this.showLoadingImpl(true);
    }

    private void showLoadingImpl(boolean z) {
        if(this.mIsShowLoading == z) {
            return;
        }
        this.mIsShowLoading = z;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void updateParallaxFooterView() {
        this.notifyItemChanged(this.getParallaxFooterViewPosition());
    }
}

