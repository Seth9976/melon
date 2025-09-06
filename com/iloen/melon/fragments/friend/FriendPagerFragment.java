package com.iloen.melon.fragments.friend;

import B.a;
import F8.G;
import F8.o;
import F8.x;
import Gd.f;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.Navigator;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u0005H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\u001C\u0010\u0004J\u0017\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001DH\u0017¢\u0006\u0004\b\u001F\u0010 R\u0016\u0010\"\u001A\u00020!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001A\u00020\u001D8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/friend/FriendPagerFragment;", "Lcom/iloen/melon/fragments/MelonPagerFragment;", "Lcom/iloen/melon/fragments/friend/FollowerFragment$EditButtonEnableListener;", "<init>", "()V", "", "tabIndex", "Lie/H;", "buildTitleBar", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "Lkotlin/collections/ArrayList;", "makeTabInfo", "()Ljava/util/ArrayList;", "tabInfo", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "buildTabIndicator", "", "enable", "onEditButtonEnableStateChange", "(Z)V", "", "nickname", "Ljava/lang/String;", "editButtonEnabled", "Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FriendPagerFragment extends MelonPagerFragment implements EditButtonEnableListener {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u00052\u0006\u0010\r\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/friend/FriendPagerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_NICKNAME", "INDEX_FOLLOWER", "", "INDEX_FOLLOWING", "newInstance", "Lcom/iloen/melon/fragments/friend/FriendPagerFragment;", "nickname", "landingIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FriendPagerFragment newInstance(@Nullable String s, int v) {
            FriendPagerFragment friendPagerFragment0 = new FriendPagerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argNickName", s);
            bundle0.putInt("argLandingIndex", v);
            friendPagerFragment0.setArguments(bundle0);
            return friendPagerFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_NICKNAME = "argNickName";
    @NotNull
    public static final Companion Companion = null;
    public static final int INDEX_FOLLOWER = 0;
    public static final int INDEX_FOLLOWING = 1;
    @NotNull
    public static final String TAG = "FriendPagerFragment";
    private boolean editButtonEnabled;
    @NotNull
    private String nickname;

    static {
        FriendPagerFragment.Companion = new Companion(null);
        FriendPagerFragment.$stable = 8;
    }

    public FriendPagerFragment() {
        this.nickname = "";
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = new FixedTabLayout(this.getActivity());
        this.mTabIndicatorLayout = fixedTabLayout0;
        fixedTabLayout0.setViewPager(this.mPager);
        int v = this.getResources().getDimensionPixelSize(0x7F0703F4);  // dimen:new_tab_container_height
        this.mTabContainer.getLayoutParams().height = v;
        this.mTabContainer.addView(this.mTabIndicatorLayout, -1, v);
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                FriendPagerFragment.this.buildTitleBar(v);
            }
        });
    }

    private final void buildTitleBar(int v) {
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            switch(v) {
                case 0: {
                    o o1 = a.s(1);
                    if(this.editButtonEnabled) {
                        G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                        g0.c = new i(this, 4);
                        o1.g(g0);
                    }
                    titleBar0.a(o1);
                    titleBar0.setTitle(this.nickname);
                    break;
                }
                case 1: {
                    x x0 = new x(0);
                    x0.c = new f(4);
                    o o0 = a.s(1);
                    o0.g(x0);
                    titleBar0.a(o0);
                    titleBar0.setTitle(this.nickname);
                }
            }
        }
    }

    public static void buildTitleBar$default(FriendPagerFragment friendPagerFragment0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = friendPagerFragment0.mTabIndicatorLayout.getCurrentItem();
        }
        friendPagerFragment0.buildTitleBar(v);
    }

    private static final void buildTitleBar$lambda$3$lambda$1(FriendPagerFragment friendPagerFragment0, View view0) {
        I i0 = friendPagerFragment0.getCurrentFragment();
        FollowerFragment followerFragment0 = i0 instanceof FollowerFragment ? ((FollowerFragment)i0) : null;
        if(followerFragment0 != null) {
            followerFragment0.setEditMode();
        }
    }

    private static final void buildTitleBar$lambda$3$lambda$2(View view0) {
        Navigator.open(new FriendAddFragment());
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    @NotNull
    public MelonBaseFragment makeTabFragment(@NotNull TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        if(v == 1) {
            return FollowingFragment.Companion.newInstance();
        }
        MelonBaseFragment melonBaseFragment0 = FollowerFragment.Companion.newInstance(this.nickname);
        ((FollowerFragment)melonBaseFragment0).setEditButtonEnableListener(this);
        return melonBaseFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    @NotNull
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030055);  // array:subtabs_mymusic_friend
        q.f(arr_s, "getStringArray(...)");
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

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            bundle0 = bundle1;
        }
        if(bundle0 != null) {
            String s = bundle0.getString("argNickName", "");
            q.f(s, "getString(...)");
            this.nickname = s;
            this.mLandingIndex = bundle0.getInt("argLandingIndex");
        }
    }

    @Override  // com.iloen.melon.fragments.friend.FollowerFragment$EditButtonEnableListener
    public void onEditButtonEnableStateChange(boolean z) {
        boolean z1 = this.editButtonEnabled != z;
        this.editButtonEnabled = z;
        if(z1) {
            FriendPagerFragment.buildTitleBar$default(this, 0, 1, null);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        FriendPagerFragment.buildTitleBar$default(this, 0, 1, null);
    }
}

