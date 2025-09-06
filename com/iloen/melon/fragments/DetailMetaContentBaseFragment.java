package com.iloen.melon.fragments;

import A6.d;
import a9.b;
import a9.c;
import a9.e;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.adapters.common.RecyclerViewCursorAdapter;
import com.iloen.melon.adapters.common.f;
import com.iloen.melon.adapters.common.i;
import com.iloen.melon.adapters.common.t;
import com.iloen.melon.adapters.common.u;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.TranslationParallaxView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.custom.z;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;

public abstract class DetailMetaContentBaseFragment extends MetaContentBaseFragment implements e {
    protected static final String ARG_CACHE_KEY = "argCacheKey";
    private static final String ARG_PARALLAX_TRANSLATION_Y = "ArgParallaxTranslationY";
    private static final String ARG_SCROLL_Y = "argScrollY";
    protected static final String REQUEST_PAGE_MODE = "modify";
    protected static final int REQUEST_PAGE_SIZE_DEFAULT = 100;
    private static final String TAG = "DetailMetaContentBaseFragment";
    boolean isParallaxHeightInitialized;
    private String mHeaderCacheKey;
    private boolean mIsDisableTranslation;
    private int mLastItemCount;
    private int mLastScrollY;
    private ViewTreeObserver.OnGlobalLayoutListener mLayoutChangedListener;
    private A0 mOnScrollListener;
    private int mParallaxTranslationY;
    private TranslationParallaxView mParallaxView;
    protected int mScrollState;
    private View mTranslationContainer;

    public DetailMetaContentBaseFragment() {
        this.isParallaxHeightInitialized = false;
        this.mLastItemCount = -1;
        this.mIsDisableTranslation = false;
        this.mScrollState = 0;
        this.mOnScrollListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                DetailMetaContentBaseFragment detailMetaContentBaseFragment0 = DetailMetaContentBaseFragment.this;
                detailMetaContentBaseFragment0.mScrollState = v;
                if(detailMetaContentBaseFragment0.isFragmentVisible) {
                    I i0 = detailMetaContentBaseFragment0.getParentFragment();
                    if(i0 instanceof c) {
                        ((c)i0).onScrollStateChanged(DetailMetaContentBaseFragment.this.mRecyclerView, v);
                    }
                }
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                DetailMetaContentBaseFragment.this.mLastScrollY += v1;
                RecyclerView recyclerView1 = DetailMetaContentBaseFragment.this.mRecyclerView;
                if(recyclerView1 != null) {
                    int v2 = recyclerView1.computeVerticalScrollOffset();
                    if(v2 == 0 || DetailMetaContentBaseFragment.this.mLastScrollY < 0) {
                        LogU.v("DetailMetaContentBaseFragment", "onScrolled offset : " + v2);
                        DetailMetaContentBaseFragment.this.mLastScrollY = v2;
                    }
                }
                if(DetailMetaContentBaseFragment.this.mLastScrollY >= 0 && !DetailMetaContentBaseFragment.this.mIsDisableTranslation) {
                    DetailMetaContentBaseFragment detailMetaContentBaseFragment0 = DetailMetaContentBaseFragment.this;
                    if(detailMetaContentBaseFragment0.isFragmentVisible) {
                        I i0 = detailMetaContentBaseFragment0.getParentFragment();
                        if(i0 instanceof c) {
                            ((c)i0).onScrolled(DetailMetaContentBaseFragment.this.mRecyclerView, DetailMetaContentBaseFragment.this.mLastScrollY);
                        }
                        int v3 = Math.max(DetailMetaContentBaseFragment.this.getTranslationHeight(), 0);
                        DetailMetaContentBaseFragment.this.updateParallaxTranslation(-Math.min(DetailMetaContentBaseFragment.this.mLastScrollY, v3));
                        float f = DetailMetaContentBaseFragment.this.getRatioHeaderHeight();
                        DetailMetaContentBaseFragment.this.updateHeaderRatio(f);
                    }
                }
            }
        };
        this.mLayoutChangedListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
            public void onGlobalLayout() {
                if(DetailMetaContentBaseFragment.this.isFragmentValid()) {
                    DetailMetaContentBaseFragment detailMetaContentBaseFragment0 = DetailMetaContentBaseFragment.this;
                    if(detailMetaContentBaseFragment0.mRecyclerView != null && detailMetaContentBaseFragment0.mAdapter instanceof u) {
                        if(!detailMetaContentBaseFragment0.isSavedStateComplete()) {
                            DetailMetaContentBaseFragment.this.mLastItemCount = -1;
                            return;
                        }
                        if(DetailMetaContentBaseFragment.this.mIsDisableTranslation) {
                            DetailMetaContentBaseFragment.this.mLastItemCount = -1;
                        }
                        boolean z = DetailMetaContentBaseFragment.this.getItemCount() == 0;
                        u u0 = (u)DetailMetaContentBaseFragment.this.mAdapter;
                        int v = z ? DetailMetaContentBaseFragment.this.getItemCountWithEmptyView() : DetailMetaContentBaseFragment.this.getItemCountWithHeaderView();
                        if(DetailMetaContentBaseFragment.this.mLastItemCount != v) {
                            DetailMetaContentBaseFragment.this.mLastItemCount = v;
                            if(z && !DetailMetaContentBaseFragment.this.showEmptyOrNetworkErrorView(v)) {
                                DetailMetaContentBaseFragment.this.mLastItemCount = -1;
                            }
                            w0 w00 = DetailMetaContentBaseFragment.this.mRecyclerView.getLayoutManager();
                            if(!(w00 instanceof z)) {
                                u0.setFooterParallaxHeight(0);
                                return;
                            }
                            int v1 = ((z)w00).h(v, DetailMetaContentBaseFragment.this.getParallaxHeight());
                            if(v1 >= 0) {
                                int v2 = DetailMetaContentBaseFragment.this.getMinScrollHeight();
                                int v3 = Math.max(DetailMetaContentBaseFragment.this.mRecyclerView.getMeasuredHeight() + v2 - v1, 0);
                                DetailMetaContentBaseFragment.this.setFooterParallaxHeight(v3);
                                if(v3 > 0 && DetailMetaContentBaseFragment.this.mRecyclerView.computeVerticalScrollOffset() == 0) {
                                    DetailMetaContentBaseFragment.this.mLastItemCount = -1;
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public View buildParallaxHeaderView() {
        return null;
    }

    public final void clearListItems() {
        if(this.mRecyclerView == null) {
            return;
        }
        this.mIsDisableTranslation = true;
        this.mLastItemCount = -1;
        j0 j00 = this.mAdapter;
        if(j00 instanceof RecyclerViewCursorAdapter) {
            ((RecyclerViewCursorAdapter)j00).changeCursor(null);
        }
        else if(j00 instanceof y) {
            ((y)j00).clear();
        }
        this.mRecyclerView.stopScroll();
        boolean z = this.isSavedStateComplete();
        if(z) {
            w0 w00 = this.mRecyclerView.getLayoutManager();
            if(w00 instanceof z) {
                w00.removeAllViews();
            }
        }
        this.initParallaxFooterHeight();
        if(this.isChildFragment()) {
            this.mParallaxTranslationY = this.getParentTranslationPosition();
        }
        else {
            TranslationParallaxView translationParallaxView0 = this.mParallaxView;
            if(translationParallaxView0 != null) {
                this.mParallaxTranslationY = (int)translationParallaxView0.getTranslationY();
            }
        }
        this.updateParallaxTranslation(this.mParallaxTranslationY);
        if(!z) {
            this.mIsDisableTranslation = false;
            return;
        }
        this.mLastScrollY = 0;
        new Handler(Looper.getMainLooper()).post(new l(this, 1));
    }

    public final void collapsedParallaxHeaderView(boolean z) {
        int v1;
        int v;
        if(this.mRecyclerView != null) {
            if(this.isChildFragment()) {
                v = Math.abs(this.getParentTranslationPosition());
                v1 = this.getParentHeaderTranslationHeight();
            }
            else {
                TranslationParallaxView translationParallaxView0 = this.mParallaxView;
                if(translationParallaxView0 == null) {
                    v = 0;
                    v1 = 0;
                }
                else {
                    v = (int)Math.abs(translationParallaxView0.getTranslationY());
                    v1 = this.getTranslationHeight();
                }
            }
            if(v < v1) {
                this.mLastScrollY = v;
                int v2 = v1 - v;
                if(z) {
                    this.mRecyclerView.smoothScrollBy(0, v2);
                    return;
                }
                this.mRecyclerView.scrollBy(0, v2);
                I i0 = this.getParentFragment();
                if(i0 instanceof c) {
                    ((c)i0).onScrollStateChanged(this.mRecyclerView, 0);
                }
            }
        }
    }

    public static void e0(DetailMetaContentBaseFragment detailMetaContentBaseFragment0, int v) {
        detailMetaContentBaseFragment0.lambda$onUpdateScroll$0(v);
    }

    private int getItemCountWithEmptyView() {
        int v;
        j0 j00 = this.mAdapter;
        if(j00 instanceof y) {
            v = ((y)j00).getItemCount();
            return !(this.mAdapter instanceof u) || !((u)this.mAdapter).hasFooterParallax() ? v : v - 1;
        }
        v = j00 instanceof RecyclerViewCursorAdapter ? ((RecyclerViewCursorAdapter)j00).getItemCount() : 0;
        return !(this.mAdapter instanceof u) || !((u)this.mAdapter).hasFooterParallax() ? v : v - 1;
    }

    private int getItemCountWithHeaderView() {
        int v = this.getItemCount();
        return this.mAdapter instanceof i ? ((i)this.mAdapter).getHeaderCount() + v : v;
    }

    // 去混淆评级： 低(20)
    private int getMinScrollHeight() {
        return this.isChildFragment() ? this.getParentHeaderHeight() - this.getParentFixedHeight() : this.getParallaxHeaderHeight() - this.getParallaxFixedHeight();
    }

    public int getParallaxFixedHeight() {
        return 0;
    }

    public int getParallaxHeaderHeight() {
        return 0;
    }

    public final int getParallaxHeight() {
        if(this.isChildFragment()) {
            int v = this.getParentHeaderHeight();
            return this.getParallaxHeaderHeight() + v;
        }
        return this.getParallaxHeaderHeight();
    }

    public final int getParentFixedHeight() {
        I i0 = this.getParentFragment();
        return i0 instanceof b ? ((b)i0).getFixedHeight() : 0;
    }

    public final int getParentHeaderHeight() {
        I i0 = this.getParentFragment();
        return i0 instanceof b ? ((b)i0).getHeaderHeight() : 0;
    }

    public final int getParentHeaderTranslationHeight() {
        I i0 = this.getParentFragment();
        return i0 instanceof b ? ((b)i0).getHeaderTranslationHeight() : 0;
    }

    public final int getParentTranslationPosition() {
        I i0 = this.getParentFragment();
        return i0 instanceof b ? ((b)i0).getTranslationPosition() : 0;
    }

    public final float getRatioHeaderHeight() {
        TranslationParallaxView translationParallaxView0 = this.mParallaxView;
        if(translationParallaxView0 == null) {
            return 0.0f;
        }
        float f = translationParallaxView0.getTranslationY();
        int v = this.getTranslationHeight();
        return v == 0 ? 0.0f : Math.max(Math.min(Math.abs(f) / ((float)v), 1.0f), 0.0f);
    }

    public int getTotalParallaxFiexedHeight() {
        int v = this.getParentFixedHeight();
        return this.getParallaxFixedHeight() + v;
    }

    private int getTotalParallaxHeight() {
        if(this.isChildFragment()) {
            int v = this.getParentHeaderHeight();
            return this.getParallaxHeaderHeight() + v;
        }
        return this.getParallaxHeaderHeight();
    }

    // 去混淆评级： 低(20)
    public final int getTranslationHeight() {
        return this.isChildFragment() ? this.getTotalParallaxHeight() - this.getTotalParallaxFiexedHeight() : this.getParallaxHeaderHeight() - this.getParallaxFixedHeight();
    }

    public final int getTranslationPosition() {
        TranslationParallaxView translationParallaxView0 = this.mParallaxView;
        return translationParallaxView0 == null ? this.getParentTranslationPosition() : ((int)translationParallaxView0.getTranslationY());
    }

    public boolean hasHeaderCacheKey() {
        return !TextUtils.isEmpty(this.mHeaderCacheKey);
    }

    private void initParallaxAdapter() {
        j0 j00 = this.mAdapter;
        if(j00 instanceof u) {
            ((u)j00).setHeaderParallaxEnabled(this.isHeaderParallaxEnabled());
            ((u)j00).setFooterParallaxEnabled(true);
            int v = this.getParallaxHeight();
            int v1 = this.getTotalParallaxFiexedHeight();
            this.setFooterParallaxHeight(ScreenUtils.getScreenHeight(this.getContext()) + (v - v1));
        }
    }

    public void initParallaxFooterHeight() {
        if(!(this.mAdapter instanceof u)) {
            return;
        }
        int v = this.getParallaxHeight();
        int v1 = this.getTotalParallaxFiexedHeight();
        this.setFooterParallaxHeight(ScreenUtils.getScreenHeight(this.getContext()) + (v - v1));
    }

    private void initParallaxHeight() {
        this.isParallaxHeightInitialized = true;
        this.mLastItemCount = -1;
        this.updateLayoutManagerMinScrollHeight();
        this.initParallaxAdapter();
        this.updateHeaderHeight();
    }

    private void initParallaxTranslation() {
        if(this.mParallaxView != null) {
            this.updateParallaxTranslation(this.mParallaxTranslationY);
            return;
        }
        this.updateParallaxTranslation(this.getParentTranslationPosition());
    }

    public final boolean isChildFragment() {
        return this.getParentFragment() instanceof b;
    }

    public boolean isFooterParallaxEnabled() [...] // Inlined contents

    public boolean isHeaderParallaxEnabled() {
        return true;
    }

    public boolean isRecyclerViewBelowTitleBar() {
        return false;
    }

    private boolean isSavedStateComplete() {
        w0 w00 = this.mRecyclerView.getLayoutManager();
        return w00 instanceof z ? ((z)w00).l() : true;
    }

    private void lambda$clearListItems$1() {
        if(this.isFragmentValid() && this.mRecyclerView != null) {
            int v = Math.abs(this.getTranslationPosition());
            this.mRecyclerView.scrollBy(0, v - this.mLastScrollY);
            this.mIsDisableTranslation = false;
            j0 j00 = this.mAdapter;
            if(j00 != null) {
                j00.notifyDataSetChanged();
            }
        }
    }

    private void lambda$onUpdateScroll$0(int v) {
        if(this.isFragmentValid() && this.mRecyclerView != null) {
            this.mRecyclerView.scrollBy(0, Math.abs(v) - this.mLastScrollY);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.resetScrollPosition();
        this.updateParallaxHeaderView();
        this.initParallaxTranslation();
        this.initParallaxHeight();
        TranslationParallaxView translationParallaxView0 = this.mParallaxView;
        if(translationParallaxView0 != null) {
            translationParallaxView0.requestLayout();
        }
        j0 j00 = this.mAdapter;
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0200, viewGroup0, false);  // layout:detail_base_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.removeOnScrollListener(this.mOnScrollListener);
        }
        super.onDestroyView();
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        if(bundle0.containsKey("argPreventDefaultFetcher")) {
            this.mPreventDefaultFetcher = bundle0.getBoolean("argPreventDefaultFetcher");
        }
        if(bundle0.containsKey("argCacheKey")) {
            this.mHeaderCacheKey = bundle0.getString("argCacheKey");
            Context context0 = this.getContext();
            if(!a.e(300000L, this.mHeaderCacheKey, context0)) {
                this.mPreventDefaultFetcher = false;
            }
        }
        this.mLastScrollY = bundle0.getInt("argScrollY");
        this.mParallaxTranslationY = bundle0.getInt("ArgParallaxTranslationY");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        this.initParallaxHeight();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putBoolean("argPreventDefaultFetcher", this.mPreventDefaultFetcher);
            if(!TextUtils.isEmpty(this.mHeaderCacheKey)) {
                bundle0.putString("argCacheKey", this.mHeaderCacheKey);
            }
            bundle0.putInt("argScrollY", this.mLastScrollY);
            bundle0.putInt("ArgParallaxTranslationY", this.mParallaxTranslationY);
        }
    }

    @Override  // a9.e
    public void onStopScroll() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.stopScroll();
        }
    }

    @Override  // a9.e
    public void onUpdateParallaxHeader() {
        this.updateParallaxHeaderView();
        this.updateParallaxTranslation(-Math.min(Math.abs(this.getTranslationPosition()), this.mLastScrollY));
    }

    @Override  // a9.e
    public void onUpdateScroll(int v) {
        if(!this.isFragmentVisible && this.isFragmentValid() && this.mRecyclerView != null) {
            if(!this.isParallaxHeightInitialized) {
                this.initParallaxHeight();
            }
            new Handler(Looper.getMainLooper()).post(new d(this, v, 10));
            this.updateParallaxTranslation(v);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.mTranslationContainer = this.findViewById(0x7F0A0BE7);  // id:translation_layout
        this.mParallaxView = (TranslationParallaxView)this.findViewById(0x7F0A08FD);  // id:parallax
        if(this.isRecyclerViewBelowTitleBar()) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                View view1 = this.mTranslationContainer;
                if(view1 != null) {
                    ((RelativeLayout.LayoutParams)view1.getLayoutParams()).addRule(3, titleBar0.getId());
                }
            }
        }
        View view2 = this.buildParallaxHeaderView();
        if(view2 != null) {
            TranslationParallaxView translationParallaxView0 = this.mParallaxView;
            if(translationParallaxView0 != null) {
                translationParallaxView0.addView(view2);
            }
        }
        this.updateParallaxHeaderView();
        this.initParallaxTranslation();
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.addOnScrollListener(this.mOnScrollListener);
            this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutChangedListener);
            this.mRecyclerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view0) {
                }

                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view0) {
                    view0.getViewTreeObserver().removeOnGlobalLayoutListener(DetailMetaContentBaseFragment.this.mLayoutChangedListener);
                }
            });
        }
        this.initParallaxHeight();
    }

    public final void resetScrollPosition() {
        if(this.mRecyclerView == null) {
            return;
        }
        this.mLastScrollY = 0;
        I i0 = this.getParentFragment();
        if(i0 instanceof c) {
            ((c)i0).onScrolled(this.mRecyclerView, this.mLastScrollY);
        }
        this.mRecyclerView.scrollToPosition(0);
    }

    private void setFooterParallaxHeight(int v) {
        if(this.mAdapter instanceof u && (this.mRecyclerView == null ? null : this.mRecyclerView.getLayoutManager()) instanceof z) {
            ((u)this.mAdapter).setFooterParallaxHeight(v);
        }
    }

    private boolean showEmptyOrNetworkErrorView(int v) {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 == null) {
            return false;
        }
        w0 w00 = recyclerView0.getLayoutManager();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = w00.findViewByPosition(v1);
            if(view0 != null) {
                O0 o00 = this.mRecyclerView.getChildViewHolder(view0);
                if((o00 instanceof f || o00 instanceof t) && w00.getDecoratedMeasuredHeight(view0) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void updateHeaderHeight() {
        j0 j00 = this.mAdapter;
        if(j00 instanceof u) {
            ((u)j00).setHeaderParallaxHeight(this.getParallaxHeight());
        }
    }

    public void updateHeaderRatio(float f) {
    }

    private void updateLayoutManagerMinScrollHeight() {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof z) {
                ((z)w00).g(this.getTotalParallaxHeight());
            }
        }
    }

    public final void updateParallaxHeaderView() {
        int v = this.getParentHeaderHeight();
        int v1 = this.getParallaxHeaderHeight();
        int v2 = this.getParallaxFixedHeight();
        if(this.mParallaxView != null) {
            I i0 = this.getParentFragment();
            int v3 = i0 instanceof b ? ((b)i0).getHeaderTranslationHeight() : 0;
            this.mParallaxView.setMinHeaderHeight(v1 - v2 + v3);
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.mParallaxView.getLayoutParams();
            viewGroup$MarginLayoutParams0.topMargin = v;
            viewGroup$MarginLayoutParams0.height = v1;
            this.mParallaxView.requestLayout();
        }
        this.updateHeaderHeight();
        this.updateLayoutManagerMinScrollHeight();
    }

    public final void updateParallaxTranslation(int v) {
        TranslationParallaxView translationParallaxView0 = this.mParallaxView;
        if(translationParallaxView0 == null) {
            return;
        }
        this.mParallaxTranslationY = v;
        translationParallaxView0.setTranslationY(((float)v));
    }
}

