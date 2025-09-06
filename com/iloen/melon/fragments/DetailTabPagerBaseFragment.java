package com.iloen.melon.fragments;

import B.a;
import E8.b;
import a9.c;
import a9.e;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import com.iloen.melon.custom.TranslationView;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import n8.q;

public abstract class DetailTabPagerBaseFragment extends MetaContentBaseFragment implements b, a9.b, c, j, IFragmentContainer {
    public static final String ARG_COLLAPSED_TAB_BAR = "argCollapsedTabBar";
    public static final String ARG_LANDING_INDEX = "argLandingIndex";
    private static final String ARG_SCROLL_Y = "argScrollY";
    private static final String ARG_TRANSLATION_HEHGHT = "argTranslationHeight";
    public static final String TAG = "DetailTabPagerBaseFragment";
    private static final float TITLE_RATIO_CRITERIA = 0.99f;
    protected FrameLayout mBottomContainer;
    private int mBottomHeaderHeight;
    protected View mBottomHeaderView;
    private boolean mCollapsedTabBar;
    private int mCurrTranslation;
    private int mCurrentTabIndex;
    protected FrameLayout mImageContainer;
    protected int mLastScrollY;
    private int mPageScrollState;
    protected ViewPager mPager;
    protected q mPagerAdapter;
    private float mPriorRatio;
    private float mPriorTitleRatio;
    protected int mProfilePixel;
    private int mScrollState;
    protected FrameLayout mTabContainer;
    private int mTabHeight;
    protected AbsTabIndicatorLayout mTabIndicator;
    protected TitleBar mTitleBar;
    private int mTitleBarHeight;
    protected FrameLayout mTopContainer;
    private int mTopHeaderHeight;
    protected View mTopHeaderView;
    protected TranslationView mTranslationContainer;

    public DetailTabPagerBaseFragment() {
        this.mCurrentTabIndex = -1;
        this.mScrollState = 0;
        this.mCurrTranslation = 0;
        this.mPageScrollState = 0;
        this.mPriorRatio = -1.0f;
        this.mPriorTitleRatio = -1.0f;
        this.mProfilePixel = 0;
    }

    public void changeTabIndicator(AbsTabIndicatorLayout absTabIndicatorLayout0) {
        AbsTabIndicatorLayout absTabIndicatorLayout1 = this.mTabIndicator;
        if(absTabIndicatorLayout1 != null) {
            this.mTabContainer.removeView(absTabIndicatorLayout1);
            this.mTabIndicator = absTabIndicatorLayout0;
            absTabIndicatorLayout0.setOnTabEventListener(this);
            this.mTabContainer.addView(this.mTabIndicator, -1, this.mTabHeight);
        }
    }

    public final void collapsedParallaxHeaderView(boolean z) {
        I i0 = this.getCurrentFragment();
        if(i0 instanceof DetailMetaContentBaseFragment) {
            ((DetailMetaContentBaseFragment)i0).collapsedParallaxHeaderView(z);
        }
    }

    public View createBottomHeaderView(LayoutInflater layoutInflater0) {
        return null;
    }

    public View createImageHeaderView(LayoutInflater layoutInflater0) {
        return null;
    }

    public AbsTabIndicatorLayout createTabIndicator() {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = new FixedTabLayout(this.getActivity());
        absTabIndicatorLayout0.setOnPageChangeListener(this);
        return absTabIndicatorLayout0;
    }

    public View createTopHeaderView(LayoutInflater layoutInflater0) {
        return null;
    }

    public boolean disableSwipeable() {
        return false;
    }

    public float getAlphaValue(float f) {
        return Math.max(1.0f - Math.max(f - 0.5f, 0.0f) * 5.0f, 0.0f);
    }

    public int getBottomHeaderHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    public I getCurrentFragment() {
        if(this.mPagerAdapter != null) {
            ViewPager viewPager0 = this.mPager;
            if(viewPager0 != null) {
                int v = viewPager0.getCurrentItem();
                l0 l00 = this.getChildFragmentManager();
                return l00 == null ? this.mPagerAdapter.getItem(v) : l00.E(String.valueOf(v));
            }
        }
        return null;
    }

    public int getCurrentTabIndex() {
        int v = this.mCurrentTabIndex;
        if(v != -1) {
            return v;
        }
        return this.mTabIndicator == null ? 0 : this.mTabIndicator.getCurrentItem();
    }

    @Override  // a9.b
    public int getFixedHeight() {
        return this.mTitleBarHeight + this.mTabHeight;
    }

    public I getFragment(int v) {
        return this.mPagerAdapter == null || this.mPager == null || v >= this.mPagerAdapter.a.size() ? null : this.mPagerAdapter.getItem(v);
    }

    @Override  // a9.b
    public int getHeaderHeight() {
        return this.mTopHeaderHeight + this.mBottomHeaderHeight + this.mTabHeight;
    }

    @Override  // a9.b
    public int getHeaderTranslationHeight() {
        return this.mTopHeaderHeight + this.mBottomHeaderHeight - this.mTitleBarHeight;
    }

    private float getRatioHeaderHeight() {
        float f = (float)Math.abs(this.mCurrTranslation);
        float f1 = (float)(this.mTopHeaderHeight - this.mTitleBarHeight * 2);
        return Float.compare(f, f1) >= 0 ? Math.max(Math.min((f - f1) / ((float)this.mTitleBarHeight), 1.0f), 0.0f) : 0.0f;
    }

    private float getRatioTopHeaderHeight(int v) {
        return ((float)Math.abs(v)) / ((float)this.getTopHeaderTranslationHeight());
    }

    public int getTabHeight() {
        return this.getContext().getResources().getDimensionPixelSize(0x7F07044F);  // dimen:tab_container_height
    }

    public int getTitleHeight() {
        return this.getActivity().getResources().getDimensionPixelSize(0x7F07046D);  // dimen:top_container_height
    }

    public int getTopHeaderHeight() {
        return this.getActivity().getResources().getDimensionPixelSize(0x7F07046E);  // dimen:top_header_default_height
    }

    public int getTopHeaderTranslationHeight() {
        return this.mTopHeaderHeight - this.mTitleBarHeight;
    }

    @Override  // a9.b
    public final int getTranslationPosition() {
        return this.mCurrTranslation;
    }

    private void initTabInfoList() {
        List list0 = this.makeTabInfo();
        if(list0 != null && !list0.isEmpty()) {
            l0 l00 = this.getChildFragmentManager();
            this.mPagerAdapter = new q(this.makeFragments(list0), l00);
            ViewPager viewPager0 = this.mPager;
            if(viewPager0 != null) {
                viewPager0.setOffscreenPageLimit(list0.size());
                this.mPager.setAdapter(null);
                this.mPager.setAdapter(this.mPagerAdapter);
            }
            AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicator;
            if(absTabIndicatorLayout0 != null) {
                absTabIndicatorLayout0.setViewPager(this.mPager);
            }
            this.selectTabByIndex(this.getCurrentTabIndex());
        }
    }

    private void initTranslationHeight() {
        if(Math.abs(this.mCurrTranslation) < 0) {
            return;
        }
        this.updateTranslationViews();
        new Handler(Looper.getMainLooper()).post(new com.iloen.melon.fragments.j(this, 0));
    }

    private boolean isShowMiniPlayerOfCurrentFragment() {
        I i0 = this.getCurrentFragment();
        return i0 instanceof MelonBaseFragment ? ((MelonBaseFragment)i0).shouldShowMiniPlayer() : false;
    }

    private boolean isShowToolBarOfCurrentFragment() {
        I i0 = this.getCurrentFragment();
        return i0 instanceof MelonAdapterViewBaseFragment ? ((MelonAdapterViewBaseFragment)i0).isToolBarShowing() : false;
    }

    private void lambda$initTranslationHeight$1() {
        this.updateHeaderRatio(this.getRatioHeaderHeight());
        this.updateTitleBarRatio(this.getRatioTopHeaderHeight(this.mLastScrollY));
    }

    private void lambda$onViewCreated$0() {
        if(!this.isFragmentValid()) {
            return;
        }
        this.collapsedParallaxHeaderView(true);
    }

    public List makeFragments(List list0) {
        List list1 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            TabInfo tabInfo0 = (TabInfo)list0.get(v);
            MelonBaseFragment melonBaseFragment0 = this.makeTabFragment(tabInfo0, v);
            melonBaseFragment0.setTabInfo(tabInfo0);
            ((ArrayList)list1).add(melonBaseFragment0);
        }
        return list1;
    }

    public abstract MelonBaseFragment makeTabFragment(TabInfo arg1, int arg2);

    public List makeTabInfo() {
        return null;
    }

    @Override  // E8.b
    public boolean onAfterReSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // E8.b
    public boolean onAfterSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        if(this.mScrollState != 0) {
            this.updateScrollChildFragment();
        }
        return false;
    }

    @Override  // E8.b
    public boolean onBeforeReSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // E8.b
    public boolean onBeforeSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        if(this.mScrollState != 0) {
            this.stopScrollChildFragment();
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mProfilePixel = (int)this.getResources().getDimension(0x7F07041B);  // dimen:profile_image_detail_default_pixel
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0224, viewGroup0, false);  // layout:detail_pager_tab_view
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        FrameLayout frameLayout0 = this.mTabContainer;
        if(frameLayout0 != null) {
            frameLayout0.removeView(this.mTabIndicator);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrollStateChanged(int v) {
        this.mPageScrollState = v;
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrolled(int v, float f, int v1) {
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageSelected(int v) {
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        if(bundle0.containsKey("argLandingIndex")) {
            this.mCurrentTabIndex = bundle0.getInt("argLandingIndex", -1);
        }
        this.mCollapsedTabBar = bundle0.getBoolean("argCollapsedTabBar");
        this.mCurrTranslation = bundle0.getInt("argTranslationHeight");
        this.mLastScrollY = bundle0.getInt("argScrollY");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt("argLandingIndex", this.getCurrentTabIndex());
            bundle0.putInt("argTranslationHeight", this.mCurrTranslation);
            bundle0.putInt("argScrollY", this.mLastScrollY);
        }
    }

    @Override  // a9.c
    public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
        if(v == 0) {
            this.updateScrollChildFragment();
        }
        this.mScrollState = v;
    }

    @Override  // a9.c
    public void onScrolled(RecyclerView recyclerView0, int v) {
        if(this.mPageScrollState != 0) {
            return;
        }
        this.mCurrTranslation = -Math.min(v, this.getHeaderTranslationHeight());
        this.updateTranslationViews();
        float f = this.getRatioHeaderHeight();
        if(f != this.mPriorRatio || v == this.mLastScrollY) {
            this.updateHeaderRatio(f);
        }
        this.mPriorRatio = f;
        float f1 = this.getRatioTopHeaderHeight(v);
        if(this.mPriorTitleRatio > 0.99f && f1 <= 0.99f || this.mPriorTitleRatio < 0.99f && f1 >= 0.99f || v == this.mLastScrollY) {
            this.updateTitleBarRatio(f1);
        }
        this.mPriorTitleRatio = f1;
        this.mLastScrollY = v;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.mEmptyView = this.findViewById(0x7F0A08A5);  // id:network_error_layout
        this.mTabContainer = (FrameLayout)view0.findViewById(0x7F0A0B12);  // id:tab_container
        this.mPager = (ViewPager)view0.findViewById(0x7F0A08F9);  // id:pager
        this.mTranslationContainer = (TranslationView)view0.findViewById(0x7F0A0BE6);  // id:translation_header
        this.mTopContainer = (FrameLayout)view0.findViewById(0x7F0A0BCE);  // id:top_container
        this.mBottomContainer = (FrameLayout)view0.findViewById(0x7F0A0118);  // id:bottom_container
        this.mImageContainer = (FrameLayout)view0.findViewById(0x7F0A055A);  // id:image_container
        View view1 = this.mEmptyView;
        if(view1 != null) {
            ViewUtils.showWhen(view1, false);
        }
        if(this.mTabIndicator == null) {
            this.mTabIndicator = this.createTabIndicator();
        }
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicator;
        if(absTabIndicatorLayout0 != null) {
            absTabIndicatorLayout0.setOnTabEventListener(this);
        }
        int v = this.getTabHeight();
        this.mTabHeight = v;
        this.mTabContainer.addView(this.mTabIndicator, -1, v);
        if(this.mPager instanceof NonSwipeableViewPager && this.disableSwipeable()) {
            ((NonSwipeableViewPager)this.mPager).enableSwipe(false, false);
        }
        this.initTabInfoList();
        this.mTitleBarHeight = this.getTitleHeight();
        TitleBar titleBar0 = this.getTitleBar();
        this.mTitleBar = titleBar0;
        if(titleBar0 != null) {
            titleBar0.a(a.s(0));
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.mTitleBar.getLayoutParams();
            viewGroup$LayoutParams0.height = this.mTitleBarHeight;
            this.mTitleBar.setBackgroundColor(0);
        }
        this.mTopHeaderHeight = this.getTopHeaderHeight();
        this.mBottomHeaderHeight = this.getBottomHeaderHeight();
        LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
        View view2 = this.createTopHeaderView(layoutInflater0);
        this.mTopHeaderView = view2;
        if(view2 != null) {
            this.mTopContainer.addView(view2, new ViewGroup.LayoutParams(-1, this.mTopHeaderHeight));
        }
        View view3 = this.createBottomHeaderView(layoutInflater0);
        this.mBottomHeaderView = view3;
        if(view3 != null) {
            this.mBottomContainer.addView(view3, new RelativeLayout.LayoutParams(-1, this.mBottomHeaderHeight));
        }
        View view4 = this.createImageHeaderView(layoutInflater0);
        if(view4 == null) {
            this.mImageContainer.setVisibility(8);
        }
        else {
            this.mImageContainer.addView(view4);
        }
        TranslationView translationView0 = this.mTranslationContainer;
        if(translationView0 != null) {
            translationView0.setMinHeaderHeight(this.getHeaderTranslationHeight());
            this.mTranslationContainer.getLayoutParams().height = this.getHeaderHeight();
            this.mTranslationContainer.requestLayout();
        }
        this.initTranslationHeight();
        if(this.mCollapsedTabBar) {
            this.mCollapsedTabBar = false;
            new Handler(Looper.getMainLooper()).post(new com.iloen.melon.fragments.j(this, 1));
        }
    }

    public void selectTabByIndex(int v) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicator;
        if(absTabIndicatorLayout0 == null) {
            LogU.w("DetailTabPagerBaseFragment", "selectTabByIndex() invalid mTabIndicator");
            return;
        }
        absTabIndicatorLayout0.setCurrentItem(v);
        this.mCurrentTabIndex = -1;
    }

    public void setCurrentTabIndex(int v) {
        this.mCurrentTabIndex = v;
    }

    public final void stopScrollChildFragment() {
        I i0 = this.getCurrentFragment();
        if(i0 instanceof e) {
            ((e)i0).onStopScroll();
        }
    }

    public final void updateHeaderHeight() {
        q q0 = this.mPagerAdapter;
        if(q0 != null) {
            int v = q0.a.size();
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = this.mPagerAdapter.getItem(v1);
                if(i0 instanceof e) {
                    ((e)i0).onUpdateParallaxHeader();
                }
            }
        }
    }

    public void updateHeaderRatio(float f) {
    }

    public final void updateParallaxHeaderHeight() {
        this.mTopHeaderHeight = this.getTopHeaderHeight();
        this.mBottomHeaderHeight = this.getBottomHeaderHeight();
        this.mTabHeight = this.getTabHeight();
        FrameLayout frameLayout0 = this.mTopContainer;
        if(frameLayout0 != null && this.mTopHeaderView != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
            viewGroup$LayoutParams0.height = this.mTopHeaderHeight;
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.mTopHeaderView.getLayoutParams();
            viewGroup$LayoutParams1.height = this.mTopHeaderHeight;
            this.mTopContainer.requestLayout();
        }
        FrameLayout frameLayout1 = this.mBottomContainer;
        if(frameLayout1 != null && this.mBottomHeaderView != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams2 = frameLayout1.getLayoutParams();
            viewGroup$LayoutParams2.height = this.mBottomHeaderHeight;
            ViewGroup.LayoutParams viewGroup$LayoutParams3 = this.mBottomHeaderView.getLayoutParams();
            viewGroup$LayoutParams3.height = this.mBottomHeaderHeight;
            this.mBottomContainer.requestLayout();
        }
        if(this.mTabIndicator != null && this.mTabIndicator.getLayoutParams() != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams4 = this.mTabIndicator.getLayoutParams();
            viewGroup$LayoutParams4.height = this.mTabHeight;
            this.mTabIndicator.requestLayout();
        }
        TranslationView translationView0 = this.mTranslationContainer;
        if(translationView0 != null) {
            translationView0.setMinHeaderHeight(this.getHeaderTranslationHeight());
            this.mTranslationContainer.getLayoutParams().height = this.getHeaderHeight();
            this.mTranslationContainer.requestLayout();
        }
        this.updateTranslationViews();
        this.updateHeaderHeight();
    }

    public final void updateScrollChildFragment() {
        q q0 = this.mPagerAdapter;
        if(q0 != null) {
            int v = q0.a.size();
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = this.mPagerAdapter.getItem(v1);
                if(i0 instanceof e) {
                    ((e)i0).onUpdateScroll(this.mCurrTranslation);
                }
            }
        }
    }

    public final void updateTabInfoList(List list0) {
        this.updateTabInfoList(list0, this.getCurrentTabIndex());
    }

    public final void updateTabInfoList(List list0, int v) {
        this.updateTabInfoList(list0, v, false);
    }

    public final void updateTabInfoList(List list0, int v, boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        if(z) {
            q q0 = this.mPagerAdapter;
            if(q0 != null) {
                ArrayList arrayList0 = q0.a;
                l0 l00 = q0.b;
                if(arrayList0.size() > 0) {
                    for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                        I i0 = (I)arrayList0.get(v1);
                        l00.getClass();
                        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
                        a0.d(i0);
                        a0.f(i0);
                        a0.l(true, true);
                        try {
                            q0.destroyItem(null, v1, i0);
                        }
                        catch(Exception unused_ex) {
                        }
                        q0.removeSavedStateAndClear(v1);
                    }
                    l00.C();
                    arrayList0.clear();
                }
            }
        }
        if(z || this.mPagerAdapter == null) {
            l0 l01 = this.getChildFragmentManager();
            this.mPagerAdapter = new q(this.makeFragments(list0), l01);
        }
        ViewPager viewPager0 = this.mPager;
        if(viewPager0 != null) {
            q q1 = this.mPagerAdapter;
            if(viewPager0.getAdapter() != q1) {
                this.mPager.setAdapter(q1);
            }
        }
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicator;
        if(absTabIndicatorLayout0 != null) {
            absTabIndicatorLayout0.setViewPager(this.mPager);
        }
        this.selectTabByIndex(v);
    }

    public void updateTitleBarRatio(float f) {
        TitleBar titleBar0 = this.mTitleBar;
        if(titleBar0 != null) {
            titleBar0.setTitleVisibility(f >= 0.99f);
        }
    }

    private void updateTranslationViews() {
        float f = (float)Math.abs(this.mCurrTranslation);
        this.mTranslationContainer.setTranslationY(((float)this.mCurrTranslation));
        float f1 = (float)this.getTopHeaderTranslationHeight();
        this.mTopContainer.setTranslationY((f > f1 ? f - f1 : 0.0f));
        this.mBottomContainer.setTranslationY(((float)this.mTopHeaderHeight));
        this.mTabContainer.setTranslationY(((float)(this.mTopHeaderHeight + this.mBottomHeaderHeight)));
    }
}

