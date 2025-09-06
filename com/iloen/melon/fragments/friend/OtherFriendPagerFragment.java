package com.iloen.melon.fragments.friend;

import B.a;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import java.util.ArrayList;
import k8.Y;

public class OtherFriendPagerFragment extends MelonPagerFragment {
    private static final String ARG_NICKNAME = "argNickName";
    private static final String ARG_OTHER_MEMBER_KEY = "argOtherMemberKey";
    public static final int INDEX_FOLLOWER = 0;
    public static final int INDEX_FOLLOWING = 1;
    public static final String TAG = "OtherFriendPagerFragment";
    private String nickname;
    private String otherMemberKey;

    public OtherFriendPagerFragment() {
        this.nickname = "";
        this.otherMemberKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getContext());
        this.mTabIndicatorLayout = fixedTabLayout0;
        fixedTabLayout0.setViewPager(this.mPager);
        int v = this.getResources().getDimensionPixelSize(0x7F0703F4);  // dimen:new_tab_container_height
        this.mTabContainer.getLayoutParams().height = v;
        this.mTabContainer.addView(this.mTabIndicatorLayout, -1, v);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        switch(v) {
            case 0: {
                return OtherFollowerFragment.Companion.newInstance(this.otherMemberKey);
            }
            case 1: {
                return OtherFollowingFragment.Companion.newInstance(this.otherMemberKey);
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F03005C);  // array:subtabs_othermusic_friend
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 3;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = -1;
            tabInfo0.j = -1.0f;
            tabInfo0.k = -1.0f;
            tabInfo0.l = -1.0f;
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        return arrayList0;
    }

    public static OtherFriendPagerFragment newInstance(String s, String s1, int v) {
        OtherFriendPagerFragment otherFriendPagerFragment0 = new OtherFriendPagerFragment();
        Bundle bundle0 = Y.c("argNickName", s, "argOtherMemberKey", s1);
        bundle0.putInt("argLandingIndex", v);
        otherFriendPagerFragment0.setArguments(bundle0);
        return otherFriendPagerFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(this.getArguments() != null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.nickname = bundle0.getString("argNickName");
            this.otherMemberKey = bundle0.getString("argOtherMemberKey");
            this.mLandingIndex = bundle0.getInt("argLandingIndex");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.nickname);
        }
    }
}

