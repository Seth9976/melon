package com.iloen.melon.fragments.melonchart;

import F8.m;
import F8.o;
import F8.p;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.ScrollTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.Objects;
import n8.q;
import p8.g;
import p8.s;

public class MelonChartPagerFragment extends MelonPagerFragment {
    private static final String ARG_AGE_SORT = "argAgeSort";
    private static final String ARG_AGE_TYPE = "argAgeType";
    private static final String ARG_AGE_YEAR = "argAgeYear";
    private static final String ARG_GENRE_CODE = "argGenreCode";
    private static final String ARG_HOTTRACK_FILTER = "argHotTrackFilter";
    private static final String ARG_HOTTRACK_TYPE = "argHotTrackType";
    private static final String ARG_PERIOD_FILTER = "argPeriodFilter";
    private static final String ARG_PERIOD_SORT = "argPeriodSort";
    public static final int TAB_AGE = 3;
    public static final int TAB_ARTIST = 5;
    private static final int TAB_DEFAULT = 0;
    public static final int TAB_GENRE = 1;
    public static final int TAB_HOT_TRACK = 4;
    public static final int TAB_PERIOD = 0;
    public static final int TAB_THEME = 2;
    private static final String TAG = "MelonChartPagerFragment";
    private int mAgeSortType;
    private String mAgeType;
    private String mAgeYear;
    private String mGenreCode;
    private String mHotTrackFilter;
    private String mHotTrackType;
    private int mPeriodFilter;
    private String mPeriodSort;

    public MelonChartPagerFragment() {
        this.mPeriodSort = null;
        this.mPeriodFilter = -1;
        this.mAgeType = "";
        this.mAgeYear = "";
        this.mAgeSortType = 0;
        this.mGenreCode = "";
        this.mHotTrackType = "";
        this.mHotTrackFilter = "";
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        if(ScreenUtils.isPortrait(this.getContext())) {
            ScrollTabLayout scrollTabLayout0 = new ScrollTabLayout(this.getContext());
            this.mTabIndicatorLayout = scrollTabLayout0;
            scrollTabLayout0.setScrollOffset(ScreenUtils.dipToPixel(this.getContext(), 135.0f));
            ((ScrollTabLayout)this.mTabIndicatorLayout).setLeftFade(0x7F08064E);  // drawable:img_mainmenu_shadow_left
            ((ScrollTabLayout)this.mTabIndicatorLayout).setRightFade(0x7F08064F);  // drawable:img_mainmenu_shadow_right
        }
        else {
            this.mTabIndicatorLayout = new FixedTabLayout(this.getActivity());
        }
        int v = this.getResources().getDimensionPixelSize(0x7F0703F4);  // dimen:new_tab_container_height
        this.mTabContainer.getLayoutParams().height = v;
        this.mTabIndicatorLayout.setSelectedTabIndex(this.mPager.getCurrentItem());
        this.mTabIndicatorLayout.setViewPager(this.mPager);
        this.mTabContainer.addView(this.mTabIndicatorLayout, -1, v);
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
                Z.r(v, "onPageScrollStateChanged: ", "MelonChartPagerFragment");
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
                LogU.d("MelonChartPagerFragment", "onPageScrolled position: " + v + ", positionOffset: " + f);
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                MelonChartPagerFragment.this.tiaraClickLog(v);
            }
        });
    }

    private s getBeforeSelectedTiaraProperty() {
        AbsTabIndicatorLayout absTabIndicatorLayout0 = this.mTabIndicatorLayout;
        if(absTabIndicatorLayout0 != null) {
            I i0 = this.mPagerAdapter.getItem(absTabIndicatorLayout0.getPreviousIndex());
            return i0 instanceof MelonBaseFragment ? ((MelonBaseFragment)i0).getTiaraProperty() : null;
        }
        return null;
    }

    private String getTiaraCopy(int v) {
        String[] arr_s = this.getResources().getStringArray(0x7F03004F);  // array:subtabs_chart
        return v <= -1 || v >= arr_s.length ? "" : arr_s[v];
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public s getTiaraProperty() {
        q q0 = this.mPagerAdapter;
        if(q0 != null) {
            I i0 = q0.getItem(this.mLandingIndex);
            return i0 instanceof MelonBaseFragment ? ((MelonBaseFragment)i0).getTiaraProperty() : null;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        switch(v) {
            case 0: {
                return MelonChartPeriodFragment.newInstance(this.mPeriodSort, this.mPeriodFilter);
            }
            case 1: {
                return MelonChartGenreFragment.newInstance(this.mGenreCode);
            }
            case 2: {
                return MelonChartThemeFragment.newInstance();
            }
            case 3: {
                return MelonChartAgeFragment.newInstance(this.mAgeType, this.mAgeYear, this.mAgeSortType);
            }
            case 4: {
                return MelonChartHotTrackListFragment.newInstance(this.mHotTrackType, this.mHotTrackFilter);
            }
            case 5: {
                return MelonChartArtistFragment.newInstance();
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F03004F);  // array:subtabs_chart
        int v = ScreenUtils.isPortrait(this.getContext()) ? 20 : 0;
        int v1 = ScreenUtils.isPortrait(this.getContext()) ? 11 : 0;
        for(int v2 = 0; v2 < arr_s.length; ++v2) {
            String s = arr_s[v2];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 2;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v2;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = -1;
            tabInfo0.j = -1.0f;
            tabInfo0.k = v2 == 0 ? ((float)v) : ((float)v1);
            tabInfo0.l = v2 == arr_s.length - 1 ? ((float)v) : ((float)v1);
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        return arrayList0;
    }

    public static MelonChartPagerFragment newInstance() {
        return MelonChartPagerFragment.newInstance(0);
    }

    public static MelonChartPagerFragment newInstance(int v) {
        MelonChartPagerFragment melonChartPagerFragment0 = new MelonChartPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argLandingIndex", v);
        melonChartPagerFragment0.setArguments(bundle0);
        return melonChartPagerFragment0;
    }

    public static MelonChartPagerFragment newInstance(int v, int v1, String s, String s1, String s2) {
        MelonChartPagerFragment melonChartPagerFragment0 = new MelonChartPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argLandingIndex", v);
        bundle0.putInt("argAgeSort", v1);
        bundle0.putString("argAgeType", s);
        bundle0.putString("argAgeYear", s1);
        bundle0.putString("argGenreCode", s2);
        melonChartPagerFragment0.setArguments(bundle0);
        return melonChartPagerFragment0;
    }

    public static MelonChartPagerFragment newInstance(int v, String s) {
        MelonChartPagerFragment melonChartPagerFragment0 = new MelonChartPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argLandingIndex", v);
        bundle0.putString("argGenreCode", s);
        melonChartPagerFragment0.setArguments(bundle0);
        return melonChartPagerFragment0;
    }

    public static MelonChartPagerFragment newInstance(int v, String s, int v1) {
        MelonChartPagerFragment melonChartPagerFragment0 = new MelonChartPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argLandingIndex", v);
        bundle0.putString("argPeriodSort", s);
        bundle0.putInt("argPeriodFilter", v1);
        melonChartPagerFragment0.setArguments(bundle0);
        return melonChartPagerFragment0;
    }

    public static MelonChartPagerFragment newInstance(int v, String s, String s1) {
        MelonChartPagerFragment melonChartPagerFragment0 = new MelonChartPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argLandingIndex", v);
        bundle0.putString("argHotTrackType", s);
        bundle0.putString("argHotTrackFilter", s1);
        melonChartPagerFragment0.setArguments(bundle0);
        return melonChartPagerFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.buildTabIndicator();
        this.mTabIndicatorLayout.e(this.makeTabInfo());
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(this.getArguments() != null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            if(bundle0.containsKey("argPeriodSort")) {
                this.mPeriodSort = bundle0.getString("argPeriodSort");
            }
            if(bundle0.containsKey("argPeriodFilter")) {
                this.mPeriodFilter = bundle0.getInt("argPeriodFilter");
            }
            if(bundle0.containsKey("argAgeSort")) {
                this.mAgeSortType = bundle0.getInt("argAgeSort");
            }
            if(bundle0.containsKey("argAgeType")) {
                this.mAgeType = bundle0.getString("argAgeType", "");
            }
            if(bundle0.containsKey("argAgeYear")) {
                this.mAgeYear = bundle0.getString("argAgeYear", "");
            }
            if(bundle0.containsKey("argGenreCode")) {
                this.mGenreCode = bundle0.getString("argGenreCode", "");
            }
            if(bundle0.containsKey("argHotTrackType")) {
                this.mHotTrackType = bundle0.getString("argHotTrackType", "");
            }
            if(bundle0.containsKey("argHotTrackFilter")) {
                this.mHotTrackFilter = bundle0.getString("argHotTrackFilter", "");
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onDestroy() {
        super.onDestroy();
        MelonAppBase.instance.getRequestQueue().cancelAll("MelonChartPagerFragment");
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.updateTitleBar();
    }

    private void tiaraClickLog(int v) {
        this.mLandingIndex = v;
        s s0 = this.getTiaraProperty();
        if(s0 != null) {
            s s1 = this.getBeforeSelectedTiaraProperty();
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = s1 == null ? s0.c : s1.c;
            g0.a = "페이지이동";
            g0.b = s1 == null ? s0.a : s1.a;
            g0.c = s1 == null ? s0.b : s1.b;
            g0.y = "GNB";
            g0.F = this.getTiaraCopy(v);
            g0.a().track();
        }
    }

    private void updateTitleBar() {
        TitleBar titleBar0 = this.getTitleBar();
        o[] arr_o = {new p(1), new m(2, false)};
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
        Objects.requireNonNull(o0);
        titleBar0.a(o0);
        titleBar0.setTitle(this.getString(0x7F1305F9));  // string:melon_chart_title "멜론차트"
    }
}

