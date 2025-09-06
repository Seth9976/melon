package com.iloen.melon.fragments.friend;

import B.a;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.tablayout.AbsTabIndicatorLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.system.ToastManager;
import java.util.ArrayList;

public class FriendSelectPagerFragment extends MelonPagerFragment {
    private static final String ARG_FRIEND_RECEIVER_LIST = "argFriendReceiverList";
    private static final String ARG_MAX_COUNT = "argMaxCount";
    private static final String ARG_TITLE = "argTitle";
    public static final int INDEX_FOLLOWER = 1;
    public static final int INDEX_FOLLOWING = 0;
    public static final int INDEX_SEARCH = 2;
    public static final String TAG = "FriendSelectPagerFragment";
    private Sharable mAttachedSharable;
    private int mFrom;
    private int mMaxCount;
    private ArrayList mReceivers;
    private String mTabTitle;

    public FriendSelectPagerFragment() {
        this.mTabTitle = "";
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        super.buildTabIndicator();
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
                if(v == 1) {
                    FriendSelectPagerFragment.this.clearMakedItemsAndToast();
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
            }
        });
    }

    public boolean clearMakedItemsAndToast() {
        I i0 = this.getCurrentFragment();
        if(i0 instanceof FriendBaseSelectFragment) {
            if(((FriendBaseSelectFragment)i0).existMarkedItem()) {
                ((FriendBaseSelectFragment)i0).clearMakedItems();
                ToastManager.show(0x7F1308FD);  // string:search_selected_clear_msg "메뉴를 이동하여 이전 선택 내역이 초기화 되었습니다."
            }
            SearchBarView searchBarView0 = ((FriendBaseSelectFragment)i0).mSearchBarView;
            if(searchBarView0 != null) {
                searchBarView0.a();
            }
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        switch(v) {
            case 0: {
                return FollowingSelectFragment.newInstance(this.mReceivers, this.mAttachedSharable, this.mMaxCount, this.mFrom);
            }
            case 1: {
                return FollowerSelectFragment.newInstance(this.mReceivers, this.mAttachedSharable, this.mMaxCount, this.mFrom);
            }
            case 2: {
                return FriendSelectFragment.newInstance(this.mReceivers, this.mAttachedSharable, this.mMaxCount, this.mFrom);
            }
            default: {
                return null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030052);  // array:subtabs_friend_search
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

    public static FriendSelectPagerFragment newInstance(String s, ArrayList arrayList0, Sharable sharable0, int v, int v1, int v2) {
        FriendSelectPagerFragment friendSelectPagerFragment0 = new FriendSelectPagerFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argTitle", s);
        bundle0.putParcelableArrayList("argFriendReceiverList", arrayList0);
        bundle0.putParcelable("argAttachedSharable", ((Parcelable)sharable0));
        bundle0.putInt("argMaxCount", v);
        bundle0.putInt("argLandingIndex", v1);
        bundle0.putInt("argWhereRUFrom", v2);
        friendSelectPagerFragment0.setArguments(bundle0);
        return friendSelectPagerFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public boolean onBeforeSelected(AbsTabIndicatorLayout absTabIndicatorLayout0, int v) {
        return this.clearMakedItemsAndToast();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(this.getArguments() != null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mTabTitle = bundle0.getString("argTitle");
            this.mReceivers = bundle0.getParcelableArrayList("argFriendReceiverList");
            this.mAttachedSharable = (Sharable)bundle0.getParcelable("argAttachedSharable");
            this.mMaxCount = bundle0.getInt("argMaxCount");
            this.mLandingIndex = bundle0.getInt("argLandingIndex");
            this.mFrom = bundle0.getInt("argWhereRUFrom");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.mTabTitle);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

