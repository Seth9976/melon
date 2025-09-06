package com.iloen.melon.fragments;

import E8.b;
import F8.B;
import F8.C;
import F8.m;
import F8.o;
import android.os.Bundle;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.c;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.e;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.tablayout.TabView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import n8.q;
import n8.r;

public abstract class MelonPagerFragment extends MelonBaseFragment implements b, e, IFragmentContainer, IPagerFragment, OnTabInfoChangedListener {
    public static enum State {
        EXPANDED,
        COLLAPSED,
        IDLE;

        private static State[] $values() [...] // Inlined contents
    }

    public static final String ARG_LANDING_INDEX = "argLandingIndex";
    public static final String ARG_OFFSCREEN = "argOffscreen";
    public static final String ARG_SWIPE_DISABLED = "argSwipeDisabled";
    public static final String ARG_TAB_TITLE_NAME = "argTabTitleName";
    private static final boolean DEBUG = false;
    public static final String TAG = "MelonPagerFragment";
    protected AppBarLayout mAppBarLayout;
    protected CoordinatorLayout mCoordinatorLayout;
    protected State mCurrentState;
    protected FrameLayout mFixedView;
    protected FrameLayout mFixedViewAboveTab;
    protected boolean mIsFixedMode;
    protected boolean mIsSwipeDisabled;
    protected int mLandingIndex;
    protected int mOffscreenLimit;
    protected ViewPager mPager;
    protected q mPagerAdapter;
    protected FrameLayout mTabContainer;
    protected AbsTabIndicatorLayout mTabIndicatorLayout;
    protected String mTitleName;

    public MelonPagerFragment() {
        this.mLandingIndex = 0;
        this.mIsFixedMode = false;
        this.mOffscreenLimit = 1;
        this.mCurrentState = State.IDLE;
    }

    public q buildPagerAdater() {
        l0 l00 = this.getChildFragmentManager();
        return new r(this.makeFragments(this.makeTabInfo()), l00);  // 初始化器: Ln8/q;-><init>(Ljava/util/List;Landroidx/fragment/app/l0;)V
    }

    public void buildTab() {
        this.mPagerAdapter = this.buildPagerAdater();
        if(this.mPagerAdapter != null) {
            this.mOffscreenLimit = this.mPagerAdapter.a.size();
            this.mPager.setOffscreenPageLimit(this.mOffscreenLimit);
            this.mPager.setAdapter(this.mPagerAdapter);
        }
        this.buildTabIndicator();
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null) {
            absTabIndicatorLayout0.setOnTabEventListener(this);
        }
        this.selectTabByIndex(this.mLandingIndex);
    }

    public void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getActivity());
        this.mTabIndicatorLayout = fixedTabLayout0;
        fixedTabLayout0.setViewPager(this.mPager);
        this.mTabContainer.addView(this.mTabIndicatorLayout, -1, this.getResources().getDimensionPixelSize(0x7F07044F));  // dimen:tab_container_height
    }

    public void collapseTitlebar() {
        LogU.d("MelonPagerFragment", "collapseTitlebar()");
        AppBarLayout appBarLayout0 = this.mAppBarLayout;
        if(appBarLayout0 != null) {
            appBarLayout0.setExpanded(false);
        }
    }

    public void enableSwipe(boolean z) {
        ViewPager viewPager0 = this.mPager;
        if(viewPager0 instanceof NonSwipeableViewPager) {
            ((NonSwipeableViewPager)viewPager0).enableSwipe(z, z);
        }
    }

    public void expandTitlebar() {
        LogU.d("MelonPagerFragment", "expandTitlebar()");
        AppBarLayout appBarLayout0 = this.mAppBarLayout;
        if(appBarLayout0 != null) {
            appBarLayout0.setExpanded(true);
        }
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    public I getCurrentFragment() {
        l0 l00 = null;
        if(this.mPagerAdapter != null && this.mTabIndicatorLayout != null) {
            try {
                l00 = this.getChildFragmentManager();
            }
            catch(IllegalStateException illegalStateException0) {
                LogU.w("MelonPagerFragment", "getCurrentFragment() " + illegalStateException0);
            }
            int v = this.mTabIndicatorLayout.getCurrentItem();
            return l00 == null ? this.mPagerAdapter.getItem(v) : l00.E(String.valueOf(v));
        }
        LogU.w("MelonPagerFragment", "getCurrentFragment() mPagerAdapter or mTabIndicatorLayout is invalid");
        return null;
    }

    @Override  // com.iloen.melon.fragments.IPagerFragment
    public boolean isOffscreenLimitPager() [...] // Inlined contents

    public boolean isTabInfoReady() [...] // Inlined contents

    @Override  // com.iloen.melon.fragments.IPagerFragment
    public boolean isUseLoopViewPager() [...] // Inlined contents

    public List makeFragments(List list0) {
        List list1 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            TabInfo tabInfo0 = (TabInfo)list0.get(v);
            I i0 = this.makeTabFragment(tabInfo0, v);
            if(i0 instanceof TabFragment) {
                ((TabFragment)i0).setTabInfo(tabInfo0);
                ((ArrayList)list1).add(i0);
            }
        }
        return list1;
    }

    public abstract I makeTabFragment(TabInfo arg1, int arg2);

    public abstract ArrayList makeTabInfo();

    @Override  // E8.b
    public boolean onAfterReSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // E8.b
    public boolean onAfterSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean onBackPressed() {
        I i0 = this.getCurrentFragment();
        return !(i0 instanceof MelonBaseFragment) || !((MelonBaseFragment)i0).onBackPressed() ? super.onBackPressed() : true;
    }

    @Override  // E8.b
    public boolean onBeforeReSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // E8.b
    public boolean onBeforeSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.OnTabInfoChangedListener
    public void onCountChanged(int v, String s) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null && v >= 0) {
            absTabIndicatorLayout0.c(v, s);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.onRestoreInstanceState(bundle0);
        }
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02B5, viewGroup0, false);  // layout:fragment_melon_pager
    }

    @Override  // com.iloen.melon.fragments.OnTabInfoChangedListener
    public void onNewIconVisibleChanged(int v, boolean z) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null && v >= 0) {
            TabView tabView0 = (TabView)absTabIndicatorLayout0.a.getChildAt(v);
            if(tabView0 != null) {
                ViewUtils.showWhen(tabView0.h, z);
                tabView0.requestLayout();
                absTabIndicatorLayout0.a.requestLayout();
                absTabIndicatorLayout0.requestLayout();
            }
        }
    }

    @Override  // com.google.android.material.appbar.e
    public void onOffsetChanged(AppBarLayout appBarLayout0, int v) {
        if(MelonPagerFragment.DEBUG) {
            LogU.v("MelonPagerFragment", "onOffsetChanged diff: " + v);
        }
        if(v == 0) {
            this.setCurrentStateAndNotify(appBarLayout0, State.EXPANDED);
        }
        else if(Math.abs(v) >= appBarLayout0.getTotalScrollRange()) {
            this.setCurrentStateAndNotify(appBarLayout0, State.COLLAPSED);
        }
        else {
            this.setCurrentStateAndNotify(appBarLayout0, State.IDLE);
        }
        I i0 = this.getCurrentFragment();
        if(i0 instanceof MelonAdapterViewBaseFragment) {
            boolean z = ((MelonAdapterViewBaseFragment)i0).isToolBarShowing();
            ToolBar toolBar0 = ((MelonAdapterViewBaseFragment)i0).getToolBar();
            if(z && toolBar0 != null) {
                toolBar0.setTranslationY(((float)(-this.getTitleBarHeight() - v)));
            }
            ((MelonAdapterViewBaseFragment)i0).onAppbarOffsetChanged(appBarLayout0, v, this.getTitleBarHeight());
        }
    }

    public void onRestoreInstanceState(Bundle bundle0) {
        this.mLandingIndex = bundle0.getInt("argLandingIndex", 0);
        this.mTitleName = bundle0.getString("argTabTitleName");
        LogU.d("MelonPagerFragment", "onRestoreInstanceState::mLandingIndex:" + this.mLandingIndex);
        if(bundle0.containsKey("argSwipeDisabled")) {
            this.mIsSwipeDisabled = bundle0.getBoolean("argSwipeDisabled", false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
            if(absTabIndicatorLayout0 != null) {
                bundle0.putInt("argLandingIndex", absTabIndicatorLayout0.getCurrentItem());
            }
            bundle0.putString("argTabTitleName", this.mTitleName);
            bundle0.putBoolean("argSwipeDisabled", this.mIsSwipeDisabled);
        }
    }

    public void onSetHighlightSingleTab(int v) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null && v >= 0) {
            int v1 = absTabIndicatorLayout0.a.getChildCount();
            for(int v2 = 0; v2 < v1; ++v2) {
                TabView tabView0 = (TabView)absTabIndicatorLayout0.a.getChildAt(v2);
                if(tabView0 != null) {
                    tabView0.c(v2 == v);
                }
            }
            absTabIndicatorLayout0.requestLayout();
        }
    }

    public void onSetOnIconVisible(int v, boolean z) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null && v >= 0) {
            TabView tabView0 = (TabView)absTabIndicatorLayout0.a.getChildAt(v);
            if(tabView0 != null) {
                ViewUtils.showWhen(tabView0.i, z);
                tabView0.requestLayout();
                absTabIndicatorLayout0.a.requestLayout();
                absTabIndicatorLayout0.requestLayout();
            }
        }
    }

    public void onStateChanged(AppBarLayout appBarLayout0, State melonPagerFragment$State0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onStop() {
        super.onStop();
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null) {
            this.mLandingIndex = absTabIndicatorLayout0.getCurrentItem();
        }
    }

    @Override  // com.iloen.melon.fragments.OnTabInfoChangedListener
    public void onTabInfoChanged() {
    }

    public void onUnsetAllHighlights() {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null) {
            int v = absTabIndicatorLayout0.a.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                TabView tabView0 = (TabView)absTabIndicatorLayout0.a.getChildAt(v1);
                if(tabView0 != null) {
                    tabView0.c(false);
                }
            }
            absTabIndicatorLayout0.requestLayout();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.mCoordinatorLayout = (CoordinatorLayout)this.findViewById(0x7F0A08FA);  // id:pager_container
        AppBarLayout appBarLayout0 = (AppBarLayout)this.findViewById(0x7F0A00AA);  // id:appbar
        this.mAppBarLayout = appBarLayout0;
        appBarLayout0.a(this);
        this.mPager = (ViewPager)this.findViewById(0x7F0A08F9);  // id:pager
        this.mFixedView = (FrameLayout)this.findViewById(0x7F0A04B8);  // id:fixed_view
        this.mFixedViewAboveTab = (FrameLayout)this.findViewById(0x7F0A04B9);  // id:fixed_view_above_tab
        this.mTabContainer = (FrameLayout)this.findViewById(0x7F0A0B12);  // id:tab_container
        if(this.mIsSwipeDisabled) {
            this.enableSwipe(false);
        }
        this.buildTab();
        c c0 = (c)this.mAppBarLayout.getLayoutParams();
        this.mAppBarLayout.requestDisallowInterceptTouchEvent(true);
    }

    public void selectTabByIndex(int v) {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 == null) {
            LogU.w("MelonPagerFragment", "mTabIndicatorLayout is invalid");
            return;
        }
        absTabIndicatorLayout0.setCurrentItem(v);
    }

    private void setCurrentStateAndNotify(AppBarLayout appBarLayout0, State melonPagerFragment$State0) {
        this.mCurrentState = melonPagerFragment$State0;
    }

    public void setEditMode(boolean z, String s, F8.c c0) {
        this.setEditMode(z, s, false, false, c0);
    }

    public void setEditMode(boolean z, String s, boolean z1, boolean z2, F8.c c0) {
        LogU.d("MelonPagerFragment", "setEditMode() isEdit: " + z + ", editModeTitle: " + s);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            if(z) {
                C c1 = z2 ? new C() : new B();  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
                o[] arr_o = {c1, new m(2, false)};
                o o0 = null;
                for(int v = 0; v < 2; ++v) {
                    o o1 = arr_o[v];
                    if(o0 == null) {
                        o0 = o1;
                    }
                    else {
                        o0.g(o1);
                    }
                }
                titleBar0.g(s, o0, z1, c0);
            }
            else {
                titleBar0.h();
            }
        }
        ViewUtils.hideWhen(this.mTabContainer, z);
        if(!this.mIsSwipeDisabled) {
            this.enableSwipe(!z);
        }
    }

    public void showTabContainer(boolean z) {
        ViewUtils.showWhen(this.mTabContainer, z);
    }
}

