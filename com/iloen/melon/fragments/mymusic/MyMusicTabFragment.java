package com.iloen.melon.fragments.mymusic;

import B.a;
import F8.G;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.I;
import androidx.viewpager.widget.j;
import com.iloen.melon.custom.tablayout.FiveItemTabLayout;
import com.iloen.melon.custom.tablayout.FixedTabLayout;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.utils.system.ScreenUtils;
import e.k;
import e1.u;
import java.util.ArrayList;
import java.util.List;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\u00112\u0006\u0010!\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\"\u0010 J#\u0010&\u001A\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%H\u0014\u00A2\u0006\u0004\b&\u0010\'J!\u0010+\u001A\u00020*2\b\u0010(\u001A\u0004\u0018\u00010$2\u0006\u0010)\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b-\u0010\u0003J\u0011\u0010/\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0004\b/\u00100R\u001A\u00102\u001A\b\u0012\u0004\u0012\u00020\n018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u000B\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000B\u00104R\u0016\u00105\u001A\u00020\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00107\u00A8\u0006:"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicTabFragment;", "Lcom/iloen/melon/fragments/MelonPagerFragment;", "<init>", "()V", "", "isMyself", "()Z", "LF8/G;", "getPlaylistEditRightButton", "()LF8/G;", "", "tabType", "", "getTitles", "(Ljava/lang/String;)[Ljava/lang/String;", "", "selectedTabIndex", "Lie/H;", "tiaraLogTabSelect", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "Lkotlin/collections/ArrayList;", "makeTabInfo", "()Ljava/util/ArrayList;", "tabInfo", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "buildTabIndicator", "Lp8/s;", "getTiaraProperty", "()Lp8/s;", "", "newTabStyleAppliedTypes", "Ljava/util/List;", "Ljava/lang/String;", "term", "isPowerDj", "Z", "isSeries", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicTabFragment extends MelonPagerFragment {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\fH\u0007J \u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020%H\u0007J \u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\fH\u0007J0\u0010 \u001A\u00020!2\u0006\u0010\'\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020%H\u0007J8\u0010 \u001A\u00020!2\u0006\u0010\'\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020%2\u0006\u0010(\u001A\u00020%H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\fX\u0086T\u00A2\u0006\u0002\n\u0000\u00A8\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_TAB_TYPE", "ARG_TERM", "ARG_TAB_INDEX", "ARG_TAB_POWER_DJ", "ARG_FILTER_SERIES", "TAB_INDEX_LIKED_SONG", "", "TAB_INDEX_LIKED_ALBUM", "TAB_INDEX_LIKED_PLAYLIST", "TAB_INDEX_LIKED_CAST", "TAB_INDEX_LIKED_TAG", "TAB_INDEX_LIKED_VIDEO", "TAB_INDEX_LISTENED_SONG", "TAB_INDEX_LISTENED_PLAYLIST", "TAB_INDEX_LISTENED_CAST", "TAB_INDEX_LISTENED_VIDEO", "TAB_INDEX_PLAYLIST_DJ", "TAB_INDEX_PLAYLIST_NOMAL", "TAB_INDEX_MYCHART_1WEEK", "TAB_INDEX_MYCHART_1MONTH", "TAB_INDEX_MYCHART_3MONTH", "TAB_INDEX_MYCHART_TERM", "TAB_INDEX_FAN_ARTIST_FAN", "TAB_INDEX_FAN_ARTIST_FRIENDLY", "TAB_INDEX_MYCOMMENT_COMMENT", "TAB_INDEX_MYCOMMENT_REPLY", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicTabFragment;", "type", "tabIndex", "isPowerDj", "", "term", "targetMemberKey", "isSeries", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicTabFragment newInstance(@NotNull String s, int v) {
            q.g(s, "type");
            return this.newInstance(u.v(((e0)o.a()).j()), s, "", v, false);
        }

        @NotNull
        public final MyMusicTabFragment newInstance(@NotNull String s, int v, boolean z) {
            q.g(s, "type");
            return this.newInstance(u.v(((e0)o.a()).j()), s, "", v, z);
        }

        @NotNull
        public final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, int v) {
            q.g(s, "type");
            q.g(s1, "term");
            return this.newInstance(u.v(((e0)o.a()).j()), s, s1, v, false);
        }

        @NotNull
        public final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, boolean z) {
            q.g(s, "targetMemberKey");
            q.g(s1, "type");
            q.g(s2, "term");
            return this.newInstance(s, s1, s2, v, z, false);
        }

        @NotNull
        public final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, boolean z, boolean z1) {
            q.g(s, "targetMemberKey");
            q.g(s1, "type");
            q.g(s2, "term");
            MyMusicTabFragment myMusicTabFragment0 = new MyMusicTabFragment();
            Bundle bundle0 = Y.c("argMemberKey", s, "argTabType", s1);
            bundle0.putString("argTerm", s2);
            bundle0.putInt("argTabIndex", v);
            bundle0.putBoolean("argTabPowerDj", z);
            bundle0.putBoolean("argFilterSeries", z1);
            myMusicTabFragment0.setArguments(bundle0);
            return myMusicTabFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_SERIES = "argFilterSeries";
    @NotNull
    private static final String ARG_TAB_INDEX = "argTabIndex";
    @NotNull
    private static final String ARG_TAB_POWER_DJ = "argTabPowerDj";
    @NotNull
    private static final String ARG_TAB_TYPE = "argTabType";
    @NotNull
    private static final String ARG_TERM = "argTerm";
    @NotNull
    public static final Companion Companion = null;
    public static final int TAB_INDEX_FAN_ARTIST_FAN = 0;
    public static final int TAB_INDEX_FAN_ARTIST_FRIENDLY = 1;
    public static final int TAB_INDEX_LIKED_ALBUM = 1;
    public static final int TAB_INDEX_LIKED_CAST = 3;
    public static final int TAB_INDEX_LIKED_PLAYLIST = 2;
    public static final int TAB_INDEX_LIKED_SONG = 0;
    public static final int TAB_INDEX_LIKED_TAG = 4;
    public static final int TAB_INDEX_LIKED_VIDEO = 5;
    public static final int TAB_INDEX_LISTENED_CAST = 2;
    public static final int TAB_INDEX_LISTENED_PLAYLIST = 1;
    public static final int TAB_INDEX_LISTENED_SONG = 0;
    public static final int TAB_INDEX_LISTENED_VIDEO = 3;
    public static final int TAB_INDEX_MYCHART_1MONTH = 1;
    public static final int TAB_INDEX_MYCHART_1WEEK = 0;
    public static final int TAB_INDEX_MYCHART_3MONTH = 2;
    public static final int TAB_INDEX_MYCHART_TERM = 3;
    public static final int TAB_INDEX_MYCOMMENT_COMMENT = 0;
    public static final int TAB_INDEX_MYCOMMENT_REPLY = 1;
    public static final int TAB_INDEX_PLAYLIST_DJ = 0;
    public static final int TAB_INDEX_PLAYLIST_NOMAL = 1;
    @NotNull
    private static final String TAG = "MyMusicTabFragment";
    private boolean isPowerDj;
    private boolean isSeries;
    @NotNull
    private final List newTabStyleAppliedTypes;
    @NotNull
    private String tabType;
    @NotNull
    private String term;

    static {
        MyMusicTabFragment.Companion = new Companion(null);
        MyMusicTabFragment.$stable = 8;
    }

    public MyMusicTabFragment() {
        this.newTabStyleAppliedTypes = k.A(new String[]{"otherlike", "playlist", "fanartist"});
        this.tabType = "";
        this.term = "";
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        FixedTabLayout fixedTabLayout0 = !ScreenUtils.isPortrait(this.getContext()) || !k.A(new String[]{"mylike", "listen", "mychart"}).contains(this.tabType) ? new FixedTabLayout(this.getActivity()) : new FiveItemTabLayout(this.getActivity());
        this.mTabIndicatorLayout = fixedTabLayout0;
        fixedTabLayout0.setViewPager(this.mPager);
        if(this.newTabStyleAppliedTypes.contains(this.tabType)) {
            int v = this.getResources().getDimensionPixelSize(0x7F0703F4);  // dimen:new_tab_container_height
            this.mTabContainer.getLayoutParams().height = v;
            this.mTabContainer.addView(this.mTabIndicatorLayout, -1, v);
        }
        else {
            this.mTabContainer.addView(this.mTabIndicatorLayout, -1, this.getResources().getDimensionPixelSize(0x7F07044F));  // dimen:tab_container_height
        }
        this.mTabIndicatorLayout.setSelectedTabIndex(this.mLandingIndex);
        this.mTabIndicatorLayout.setOnPageChangeListener(new j() {
            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                MyMusicTabFragment.this.tiaraLogTabSelect(v);
                MyMusicTabFragment.this.mLandingIndex = v;
            }
        });
    }

    private final G getPlaylistEditRightButton() {
        G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.c = new w(this, 4);
        return g0;
    }

    private static final void getPlaylistEditRightButton$lambda$2$lambda$1(MyMusicTabFragment myMusicTabFragment0, View view0) {
        I i0 = myMusicTabFragment0.getCurrentFragment();
        if(i0 instanceof PlaylistFragment) {
            String s = ((PlaylistFragment)i0).getCacheKey();
            MyMusicPlayListEditFragment.Companion.newInstance(0, s).open();
        }
        else if(i0 instanceof DjPlaylistFragment) {
            int v = myMusicTabFragment0.isPowerDj ? 2 : 1;
            String s1 = ((DjPlaylistFragment)i0).getCacheKey();
            MyMusicPlayListEditFragment.Companion.newInstance(v, s1).open();
        }
        s s2 = myMusicTabFragment0.getTiaraProperty();
        if(s2 != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = myMusicTabFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            g0.b = s2.a;
            g0.c = s2.b;
            g0.I = s2.c;
            g0.y = myMusicTabFragment0.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            g0.F = myMusicTabFragment0.getString(0x7F130D27);  // string:tiara_click_copy_edit "편집"
            g0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public s getTiaraProperty() {
        I i0 = this.mPagerAdapter == null ? null : this.mPagerAdapter.getItem(this.mLandingIndex);
        MelonBaseFragment melonBaseFragment0 = i0 instanceof MelonBaseFragment ? ((MelonBaseFragment)i0) : null;
        return melonBaseFragment0 == null ? null : melonBaseFragment0.getTiaraProperty();
    }

    private final String[] getTitles(String s) {
        switch(s) {
            case "fanartist": {
                return this.getResources().getStringArray(0x7F030056);  // array:subtabs_mymusic_more_fan_artist
            }
            case "listen": {
                return this.getResources().getStringArray(0x7F030058);  // array:subtabs_mymusic_more_listen
            }
            case "mychart": {
                return this.getResources().getStringArray(0x7F030059);  // array:subtabs_mymusic_more_mychart
            }
            case "mycomment": {
                return this.getResources().getStringArray(0x7F03005B);  // array:subtabs_mymusic_mycomment
            }
            case "mylike": {
                return this.getResources().getStringArray(0x7F030057);  // array:subtabs_mymusic_more_liked
            }
            case "otherlike": {
                return this.getResources().getStringArray(0x7F03005D);  // array:subtabs_othermusic_more_liked
            }
            case "playlist": {
                return this.getResources().getStringArray(0x7F03005A);  // array:subtabs_mymusic_more_playlist
            }
            default: {
                return null;
            }
        }
    }

    // 去混淆评级： 低(20)
    private final boolean isMyself() {
        return TextUtils.isEmpty(this.mUserKey) || q.b(this.mUserKey, u.v(((e0)o.a()).j()));
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    @NotNull
    public MelonBaseFragment makeTabFragment(@Nullable TabInfo tabInfo0, int v) {
        String s = this.tabType;
        if(q.b(s, "playlist")) {
            String s1 = this.mUserKey;
            q.f(s1, "mUserKey");
            return MyMusicFragmentFactory.Companion.create(s1, v, this.isPowerDj, this.isSeries);
        }
        if(q.b(s, "mychart")) {
            if(!TextUtils.isEmpty(this.term)) {
                String s2 = this.mUserKey;
                q.f(s2, "mUserKey");
                return MyMusicFragmentFactory.Companion.create(s2, this.tabType, this.term, v);
            }
            String s3 = this.mUserKey;
            q.f(s3, "mUserKey");
            return MyMusicFragmentFactory.Companion.create(s3, this.tabType, v);
        }
        String s4 = this.mUserKey;
        q.f(s4, "mUserKey");
        return MyMusicFragmentFactory.Companion.create(s4, this.tabType, v);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    @Nullable
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getTitles(this.tabType);
        if(arr_s == null) {
            return null;
        }
        boolean z = this.newTabStyleAppliedTypes.contains(this.tabType);
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = z ? 3 : 0;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = z ? -1 : 0x7F080820;  // drawable:selector_dot
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

    @NotNull
    public static final MyMusicTabFragment newInstance(@NotNull String s, int v) {
        return MyMusicTabFragment.Companion.newInstance(s, v);
    }

    @NotNull
    public static final MyMusicTabFragment newInstance(@NotNull String s, int v, boolean z) {
        return MyMusicTabFragment.Companion.newInstance(s, v, z);
    }

    @NotNull
    public static final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, int v) {
        return MyMusicTabFragment.Companion.newInstance(s, s1, v);
    }

    @NotNull
    public static final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, boolean z) {
        return MyMusicTabFragment.Companion.newInstance(s, s1, s2, v, z);
    }

    @NotNull
    public static final MyMusicTabFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, boolean z, boolean z1) {
        return MyMusicTabFragment.Companion.newInstance(s, s1, s2, v, z, z1);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.buildTabIndicator();
        this.mTabIndicatorLayout.setCurrentItem(this.mLandingIndex);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argTabType");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.tabType = s;
        String s2 = bundle0.getString("argTerm");
        if(s2 != null) {
            s1 = s2;
        }
        this.term = s1;
        this.isPowerDj = bundle0.getBoolean("argTabPowerDj");
        this.isSeries = bundle0.getBoolean("argFilterSeries");
        int v = bundle0.getInt("argTabIndex", -1);
        this.mLandingIndex = v;
        this.selectTabByIndex(v);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTabType", this.tabType);
        bundle0.putString("argTerm", this.term);
        bundle0.putBoolean("argTabPowerDj", this.isPowerDj);
        bundle0.putBoolean("argFilterSeries", this.isSeries);
        bundle0.putInt("argTabIndex", this.mLandingIndex);
        this.selectTabByIndex(this.mLandingIndex);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        String s;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        F8.o o0 = a.s(1);
        if(this.isMyself() && q.b(this.tabType, "playlist")) {
            o0.g(this.getPlaylistEditRightButton());
        }
        titleBar0.a(o0);
        switch(this.tabType) {
            case "fanartist": {
                s = "팬맺은";
                q.f("팬맺은", "getString(...)");
                break;
            }
            case "listen": {
                s = "최근들은";
                q.f("최근들은", "getString(...)");
                break;
            }
            case "mychart": {
                s = "많이 들은";
                q.f("많이 들은", "getString(...)");
                break;
            }
            case "mycomment": {
                s = "댓글";
                q.f("댓글", "getString(...)");
                break;
            }
            case "mylike": 
            case "otherlike": {
                s = "좋아요";
                q.f("좋아요", "getString(...)");
                break;
            }
            case "playlist": {
                s = "플레이리스트";
                q.f("플레이리스트", "getString(...)");
                break;
            }
            default: {
                s = "";
            }
        }
        this.getTitleBar().setTitle(s);
    }

    private final void tiaraLogTabSelect(int v) {
        String s1;
        if(q.b(this.tabType, "playlist") || q.b(this.tabType, "fanartist")) {
            s s0 = this.getTiaraProperty();
            if(s0 != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                g0.b = s0.a;
                g0.c = s0.b;
                g0.I = s0.c;
                g0.y = this.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
                String[] arr_s = this.getTitles(this.tabType);
                if(arr_s == null) {
                    s1 = "";
                }
                else {
                    s1 = (String)n.n0(v, arr_s);
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                g0.F = s1;
                g0.a().track();
            }
        }
    }
}

