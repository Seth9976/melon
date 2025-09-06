package com.iloen.melon.fragments.melontv;

import B.a;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.ScrollTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MelonTvLiveOnAirReq;
import com.iloen.melon.net.v4x.response.MelonTvLiveOnAirRes.Response;
import com.iloen.melon.net.v4x.response.MelonTvLiveOnAirRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;

public class MelonTvTabFragment extends MelonPagerFragment {
    private static final String ARG_ORDER_INDEX = "argOrderIndex";
    public static final int TAB_INDEX_BROADCAST = 5;
    public static final int TAB_INDEX_LIKE = 7;
    public static final int TAB_INDEX_LIVE = 6;
    public static final int TAB_INDEX_MV = 3;
    public static final int TAB_INDEX_NEW = 1;
    public static final int TAB_INDEX_ORIGINAL = 4;
    public static final int TAB_INDEX_POPULAR = 2;
    public static final int TAB_INDEX_TODAY;
    private int mOrderByIndex;

    public MelonTvTabFragment() {
        this.mOrderByIndex = -1;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        if(ScreenUtils.isPortrait(this.getContext())) {
            ScrollTabLayout scrollTabLayout0 = new ScrollTabLayout(this.getActivity());
            this.mTabIndicatorLayout = scrollTabLayout0;
            scrollTabLayout0.setScrollOffset(ScreenUtils.dipToPixel(this.getActivity(), 135.0f));
            ((ScrollTabLayout)this.mTabIndicatorLayout).setLeftFade(0x7F08064E);  // drawable:img_mainmenu_shadow_left
            ((ScrollTabLayout)this.mTabIndicatorLayout).setRightFade(0x7F08064F);  // drawable:img_mainmenu_shadow_right
            this.mTabIndicatorLayout.setSelectedTabIndex(this.mLandingIndex);
        }
        else {
            FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getActivity());
            this.mTabIndicatorLayout = fixedTabLayout0;
            fixedTabLayout0.setSelectedTabIndex(this.mLandingIndex);
        }
        this.mTabIndicatorLayout.setViewPager(this.mPager);
        this.mTabContainer.addView(this.mTabIndicatorLayout, -1, ScreenUtils.dipToPixel(this.getActivity(), 50.0f));
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                MelonTvTabFragment.this.mLandingIndex = v;
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isTopLevelFragment() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        int v1 = this.mLandingIndex == v ? this.mOrderByIndex : 0;
        switch(v) {
            case 0: {
                return MelonTvTodayFragment.newInstance();
            }
            case 1: {
                return MelonTvNewFragment.newInstance();
            }
            case 2: {
                return MelonTvPopularFragment.newInstance(v1);
            }
            case 3: {
                return MelonTvMusicVideoFragment.newInstance(v1);
            }
            case 4: {
                return MelonTvOriginalFragment.newInstance();
            }
            case 5: {
                return MelonTvBroadcastFragment.newInstance();
            }
            case 6: {
                return MelonTvLiveFragment.newInstance();
            }
            case 7: {
                return MelonTvLikedFragment.newInstance(v1);
            }
            default: {
                return MelonTvTodayFragment.newInstance();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030054);  // array:subtabs_melontv
        if(arr_s == null) {
            return null;
        }
        for(int v = 0; true; ++v) {
            int v1 = 15;
            if(v >= arr_s.length) {
                break;
            }
            if(v == arr_s.length - 1) {
                v1 = 16;
            }
            String s = arr_s[v];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 0;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = 0x7F080820;  // drawable:selector_dot
            tabInfo0.j = -1.0f;
            tabInfo0.k = (float)(v == 0 ? 16 : 15);
            tabInfo0.l = (float)v1;
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        return arrayList0;
    }

    public static MelonTvTabFragment newInstance() {
        return MelonTvTabFragment.newInstance(-1);
    }

    public static MelonTvTabFragment newInstance(int v) {
        return MelonTvTabFragment.newInstance(v, -1);
    }

    public static MelonTvTabFragment newInstance(int v, int v1) {
        MelonTvTabFragment melonTvTabFragment0 = new MelonTvTabFragment();
        Bundle bundle0 = new Bundle();
        if(v >= 0) {
            bundle0.putInt("argLandingIndex", v);
        }
        if(v1 > 0 && (v == 0 || v == 2 || v == 3 || v == 7)) {
            bundle0.putInt("argOrderIndex", v1);
        }
        melonTvTabFragment0.setArguments(bundle0);
        return melonTvTabFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.buildTabIndicator();
        this.selectTabByIndex(this.mLandingIndex);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onNewArguments(Bundle bundle0) {
        super.onNewArguments(bundle0);
        this.onRestoreInstanceState(bundle0);
        this.selectTabByIndex(this.mLandingIndex);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        super.onRestoreInstanceState(bundle0);
        this.mOrderByIndex = bundle0.getInt("argOrderIndex", -1);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F13062A));  // string:melon_tv_title "멜론TV"
        }
    }

    public void updateOnIconTab() {
        RequestBuilder.newInstance(new MelonTvLiveOnAirReq(this.getContext())).tag("MelonPagerFragment").listener(new Listener() {
            public void onResponse(MelonTvLiveOnAirRes melonTvLiveOnAirRes0) {
                if(melonTvLiveOnAirRes0 != null && melonTvLiveOnAirRes0.isSuccessful(false)) {
                    Response melonTvLiveOnAirRes$Response0 = melonTvLiveOnAirRes0.response;
                    if(melonTvLiveOnAirRes$Response0 != null) {
                        MelonTvTabFragment.this.onSetOnIconVisible(6, melonTvLiveOnAirRes$Response0.isOnAir);
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MelonTvLiveOnAirRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                LogU.e("MelonPagerFragment", "MelonTvTabFragment$updateOnIconTab() " + volleyError0.getMessage());
            }
        }).request();
    }
}

