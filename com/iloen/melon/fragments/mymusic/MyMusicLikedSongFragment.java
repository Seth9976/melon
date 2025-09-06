package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameSongReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSameSongReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSongReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameSongRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameSongRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSongRes;
import com.iloen.melon.net.v5x.request.LikeListSongReq;
import com.iloen.melon.net.v5x.response.LikeListSongRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import e1.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002QRB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ!\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0004J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001D\u001A\u00020\u00152\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0004J\u000F\u0010 \u001A\u00020\nH\u0016\u00A2\u0006\u0004\b \u0010\u0004J\u000F\u0010!\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010%J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010-\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0011\u00100\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b2\u0010\u0004J\u0017\u00104\u001A\u00020\n2\u0006\u00103\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b6\u0010\u0004J\u0017\u00107\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b7\u00108J\u0017\u0010:\u001A\u00020\u00052\u0006\u00109\u001A\u00020#H\u0002\u00A2\u0006\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020#8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020#8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001A\u00020#8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b?\u0010=R$\u0010C\u001A\u0012\u0012\u0004\u0012\u00020A0@j\b\u0012\u0004\u0012\u00020A`B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010=R\u0016\u0010J\u001A\u00020I8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001A\u00020L8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001A\u00020\u000F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bO\u0010P\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedSongFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "Lcom/iloen/melon/fragments/mymusic/OnCheckMyself;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "isMyself", "()Z", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onResume", "onPause", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "setFilterData", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "playAllLikedSong", "initHeaderView", "(Landroid/view/View;)V", "position", "getFilterTypeForServer", "(I)Ljava/lang/String;", "START_INDEX", "I", "PAGE_SIZE", "PAGE_SIZE_ALL_PLAY", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "filterList", "Ljava/util/ArrayList;", "memberKey", "Ljava/lang/String;", "filterType", "togglePos", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "Lcom/iloen/melon/custom/FilterLayout;", "headerView", "Lcom/iloen/melon/custom/FilterLayout;", "headerContainer", "Landroid/view/View;", "Companion", "LikedSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedSongFragment extends DetailMetaContentBaseFragment implements OnCheckMyself {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedSongFragment;", "memberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedSongFragment newInstance(@NotNull String s) {
            q.g(s, "memberKey");
            MyMusicLikedSongFragment myMusicLikedSongFragment0 = new MyMusicLikedSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedSongFragment0.setArguments(bundle0);
            return myMusicLikedSongFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedSongFragment$LikedSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedSongFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedSongAdapter extends p {
        private final int VIEW_TYPE_SONG;

        public LikedSongAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedSongFragment.this = myMusicLikedSongFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_SONG = 1;
        }

        public static void a(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            LikedSongAdapter.onBindViewImpl$lambda$2(myMusicLikedSongFragment0, songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0, view0);
        }

        public static void c(MyMusicLikedSongFragment myMusicLikedSongFragment0, int v, View view0) {
            LikedSongAdapter.onBindViewImpl$lambda$0(myMusicLikedSongFragment0, v, view0);
        }

        public static void d(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            LikedSongAdapter.onBindViewImpl$lambda$3(myMusicLikedSongFragment0, songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0, view0);
        }

        public static boolean e(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            return LikedSongAdapter.onBindViewImpl$lambda$1(myMusicLikedSongFragment0, songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_SONG;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.viewholders.SongHolder");
            SongHolder songHolder0 = (SongHolder)o00;
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
            if(songInfoBase0 != null) {
                ViewUtils.setEnable(songHolder0.wrapperLayout, songInfoBase0.canService);
                if(songInfoBase0.canService) {
                    ViewUtils.setOnClickListener(songHolder0.rootView, new J(MyMusicLikedSongFragment.this, v, 0));
                    if(this.isMarked(v1)) {
                        songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                    }
                    else {
                        songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    }
                }
                else {
                    ViewUtils.setOnClickListener(songHolder0.rootView, null);
                    songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                }
                ViewUtils.setOnLongClickListener(songHolder0.rootView, new A(MyMusicLikedSongFragment.this, songInfoBase0, this, 1));
                ImageView imageView0 = songHolder0.thumbnailIv;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(songHolder0.thumbnailIv);
                }
                ViewUtils.showWhen(songHolder0.btnPlay, songInfoBase0.canService);
                ViewUtils.setOnClickListener(songHolder0.btnPlay, new K(MyMusicLikedSongFragment.this, songInfoBase0, this, 0));
                ViewUtils.showWhen(songHolder0.btnInfo, true);
                ViewUtils.setOnClickListener(songHolder0.btnInfo, new K(MyMusicLikedSongFragment.this, songInfoBase0, this, 1));
                ViewUtils.setOnClickListener(songHolder0.thumbContainer, new e(3, MyMusicLikedSongFragment.this, songInfoBase0));
                ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                songHolder0.titleTv.setText(songInfoBase0.songName);
                songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
                ViewUtils.showWhen(songHolder0.list19Iv, songInfoBase0.isAdult);
                ViewUtils.showWhen(songHolder0.listFreeIv, songInfoBase0.isFree);
                ViewUtils.showWhen(songHolder0.listHoldbackIv, songInfoBase0.isHoldback);
            }
        }

        private static final void onBindViewImpl$lambda$0(MyMusicLikedSongFragment myMusicLikedSongFragment0, int v, View view0) {
            myMusicLikedSongFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$1(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            myMusicLikedSongFragment0.showContextPopupSongOrInstantPlay(Playable.from(songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$2(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            myMusicLikedSongFragment0.playSong(Playable.from(songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0.getMenuId(), null), true);
        }

        private static final void onBindViewImpl$lambda$3(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, LikedSongAdapter myMusicLikedSongFragment$LikedSongAdapter0, View view0) {
            myMusicLikedSongFragment0.showContextPopupSong(Playable.from(songInfoBase0, myMusicLikedSongFragment$LikedSongAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$4(MyMusicLikedSongFragment myMusicLikedSongFragment0, SongInfoBase songInfoBase0, View view0) {
            myMusicLikedSongFragment0.showAlbumInfoPage(songInfoBase0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int PAGE_SIZE_ALL_PLAY;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedSongFragment";
    @NotNull
    private final ArrayList filterList;
    @NotNull
    private String filterType;
    private View headerContainer;
    private FilterLayout headerView;
    @NotNull
    private String memberKey;
    private int togglePos;
    private ToggleView toggleView;

    static {
        MyMusicLikedSongFragment.Companion = new Companion(null);
        MyMusicLikedSongFragment.$stable = 8;
    }

    public MyMusicLikedSongFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.PAGE_SIZE_ALL_PLAY = 1000;
        this.filterList = new ArrayList();
        this.memberKey = "";
        this.filterType = "NEW";
    }

    public static void A0(MyMusicLikedSongFragment myMusicLikedSongFragment0, Object object0) {
        MyMusicLikedSongFragment.playAllLikedSong$lambda$25(myMusicLikedSongFragment0, object0);
    }

    public static void B0(MyMusicLikedSongFragment myMusicLikedSongFragment0, S s0, boolean z) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$15(myMusicLikedSongFragment0, s0, z);
    }

    public static void C0(MyMusicLikedSongFragment myMusicLikedSongFragment0, int v, String s) {
        MyMusicLikedSongFragment.initHeaderView$lambda$27(myMusicLikedSongFragment0, v, s);
    }

    public static void D0(MyMusicLikedSongFragment myMusicLikedSongFragment0, VolleyError volleyError0) {
        MyMusicLikedSongFragment.onFetchStart$lambda$8(myMusicLikedSongFragment0, volleyError0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D089A, null, false);  // layout:toggle_edit_stanalone
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 1000);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedSongAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("song").appendQueryParameter("filterType", this.filterType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        v9.j j0 = (v9.j)je.p.n0(v, this.filterList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        if(this.headerContainer != null && this.headerContainer.getVisibility() != 0) {
            return 0;
        }
        return this.isMyself() ? ScreenUtils.dipToPixel(this.getContext(), 52.0f) : ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        if(this.headerContainer != null && this.headerContainer.getVisibility() != 0) {
            return 0;
        }
        return this.isMyself() ? ScreenUtils.dipToPixel(this.getContext(), 98.0f) : ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    private final void initHeaderView(View view0) {
        int v;
        Resources resources0;
        View view1 = view0.findViewById(0x7F0A0BBD);  // id:toggle_layout
        q.f(view1, "findViewById(...)");
        this.toggleView = (ToggleView)view1;
        View view2 = view0.findViewById(0x7F0A052A);  // id:header_view
        q.f(view2, "findViewById(...)");
        this.headerView = (FilterLayout)view2;
        View view3 = view0.findViewById(0x7F0A0526);  // id:header_container
        q.f(view3, "findViewById(...)");
        this.headerContainer = view3;
        if(this.isMyself()) {
            FilterLayout filterLayout0 = this.headerView;
            if(filterLayout0 != null) {
                ViewUtils.hideWhen(filterLayout0, true);
                goto label_19;
            }
            q.m("headerView");
            throw null;
        }
        FilterLayout filterLayout1 = this.headerView;
        if(filterLayout1 != null) {
            ViewUtils.showWhen(filterLayout1, true);
        label_19:
            if(this.isMyself()) {
                resources0 = this.getResources();
                v = 0x7F03001E;  // array:my_music_like_filter_type
            }
            else {
                resources0 = this.getResources();
                v = 0x7F030021;  // array:other_music_like
            }
            String[] arr_s = resources0.getStringArray(v);
            q.d(arr_s);
            List list0 = k.A(Arrays.copyOf(arr_s, arr_s.length));
            ToggleView toggleView0 = this.toggleView;
            if(toggleView0 != null) {
                toggleView0.e(list0, new I(this, 1));
                ToggleView toggleView1 = this.toggleView;
                if(toggleView1 != null) {
                    toggleView1.setFilterPosition(this.togglePos);
                    return;
                }
                q.m("toggleView");
                throw null;
            }
            q.m("toggleView");
            throw null;
        }
        q.m("headerView");
        throw null;
    }

    private static final void initHeaderView$lambda$27(MyMusicLikedSongFragment myMusicLikedSongFragment0, int v, String s) {
        myMusicLikedSongFragment0.filterType = myMusicLikedSongFragment0.getFilterTypeForServer(v);
        myMusicLikedSongFragment0.togglePos = v;
        myMusicLikedSongFragment0.startFetch("filter change");
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.mymusic.OnCheckMyself
    public boolean isMyself() {
        return TextUtils.isEmpty(this.memberKey) || q.b(this.memberKey, u.v(((e0)o.a()).j()));
    }

    @NotNull
    public static final MyMusicLikedSongFragment newInstance(@NotNull String s) {
        return MyMusicLikedSongFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        FilterLayout filterLayout0 = this.headerView;
        if(filterLayout0 != null) {
            filterLayout0.setOnCheckedListener(null);
            ToggleView toggleView0 = this.toggleView;
            if(toggleView0 != null) {
                toggleView0.setOnCheckedListener(null);
                return;
            }
            q.m("toggleView");
            throw null;
        }
        q.m("headerView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        int v1;
        int v;
        i i1 = i.b;
        if(i1.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedSongFragment.LikedSongAdapter");
            ((LikedSongAdapter)j00).clear();
        }
        if(q.b(this.filterType, "LIKE_ME")) {
            Params myMusicLikeListSameSongReq$Params0 = new Params();
            if(i1.equals(i0)) {
                v = this.START_INDEX;
            }
            else {
                j0 j01 = this.mAdapter;
                q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedSongFragment.LikedSongAdapter");
                v = ((LikedSongAdapter)j01).getCount() + 1;
            }
            myMusicLikeListSameSongReq$Params0.startIndex = v;
            myMusicLikeListSameSongReq$Params0.pageSize = this.PAGE_SIZE;
            myMusicLikeListSameSongReq$Params0.targetMemberKey = this.memberKey;
            RequestBuilder.newInstance(new MyMusicLikeListSameSongReq(this.getContext(), myMusicLikeListSameSongReq$Params0)).tag("MyMusicLikedSongFragment").listener(new H(this, i0, 0)).errorListener(new I(this, 3)).request();
            return true;
        }
        com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params likeListSongBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params();
        likeListSongBaseReq$Params0.orderBy = this.filterType;
        if(i1.equals(i0)) {
            v1 = this.START_INDEX;
        }
        else {
            j0 j02 = this.mAdapter;
            q.e(j02, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedSongFragment.LikedSongAdapter");
            v1 = ((LikedSongAdapter)j02).getCount() + 1;
        }
        likeListSongBaseReq$Params0.startIndex = v1;
        likeListSongBaseReq$Params0.pageSize = this.PAGE_SIZE;
        likeListSongBaseReq$Params0.targetMemberKey = this.isMyself() ? u.v(((e0)o.a()).j()) : this.memberKey;
        RequestBuilder.newInstance(new MyMusicLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0)).tag("MyMusicLikedSongFragment").listener(new H(this, i0, 1)).errorListener(new I(this, 4)).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(MyMusicLikedSongFragment myMusicLikedSongFragment0, i i0, MyMusicLikeListSameSongRes myMusicLikeListSameSongRes0) {
        int v = 0;
        if(!myMusicLikedSongFragment0.prepareFetchComplete(myMusicLikeListSameSongRes0)) {
            myMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        RESPONSE myMusicLikeListSameSongRes$RESPONSE0 = myMusicLikeListSameSongRes0.response;
        if(myMusicLikeListSameSongRes$RESPONSE0 != null) {
            myMusicLikedSongFragment0.mMelonTiaraProperty = new s(myMusicLikeListSameSongRes$RESPONSE0.section, myMusicLikeListSameSongRes$RESPONSE0.page, myMusicLikeListSameSongRes$RESPONSE0.menuId, null);
            ArrayList arrayList0 = myMusicLikeListSameSongRes$RESPONSE0.songlist;
            if(arrayList0 != null) {
                v = arrayList0.size();
            }
            if(v > 0) {
                myMusicLikedSongFragment0.setAllCheckButtonVisibility(true);
            }
        }
        myMusicLikedSongFragment0.performFetchComplete(i0, myMusicLikeListSameSongRes0);
    }

    private static final void onFetchStart$lambda$4(MyMusicLikedSongFragment myMusicLikedSongFragment0, VolleyError volleyError0) {
        myMusicLikedSongFragment0.performFetchError(volleyError0);
        myMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
    }

    private static final void onFetchStart$lambda$7(MyMusicLikedSongFragment myMusicLikedSongFragment0, i i0, MyMusicLikeListSongRes myMusicLikeListSongRes0) {
        int v = 0;
        if(!myMusicLikedSongFragment0.prepareFetchComplete(myMusicLikeListSongRes0)) {
            myMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        com.iloen.melon.net.v4x.response.LikeListSongBaseRes.RESPONSE likeListSongBaseRes$RESPONSE0 = myMusicLikeListSongRes0.response;
        if(likeListSongBaseRes$RESPONSE0 != null) {
            myMusicLikedSongFragment0.mMelonTiaraProperty = new s(likeListSongBaseRes$RESPONSE0.section, likeListSongBaseRes$RESPONSE0.page, likeListSongBaseRes$RESPONSE0.menuId, null);
            ArrayList arrayList0 = likeListSongBaseRes$RESPONSE0.songlist;
            if(arrayList0 != null) {
                v = arrayList0.size();
            }
            if(v > 0) {
                myMusicLikedSongFragment0.setAllCheckButtonVisibility(true);
            }
        }
        myMusicLikedSongFragment0.performFetchComplete(i0, myMusicLikeListSongRes0);
    }

    private static final void onFetchStart$lambda$8(MyMusicLikedSongFragment myMusicLikedSongFragment0, VolleyError volleyError0) {
        myMusicLikedSongFragment0.performFetchError(volleyError0);
        myMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onResume() {
        super.onResume();
        this.setAllCheckButtonVisibility(this.getItemCount() > 0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        this.initHeaderView(view0);
        this.setFilterData();
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        boolean z = false;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
    }

    private final void playAllLikedSong() {
        com.iloen.melon.net.v5x.request.LikeListSongReq.Params likeListSongReq$Params0 = new com.iloen.melon.net.v5x.request.LikeListSongReq.Params();
        likeListSongReq$Params0.orderBy = this.filterType;
        likeListSongReq$Params0.startIndex = 1;
        likeListSongReq$Params0.pageSize = this.PAGE_SIZE_ALL_PLAY;
        likeListSongReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new LikeListSongReq(this.getContext(), likeListSongReq$Params0)).tag(this.getRequestTag()).listener(new I(this, 5)).errorListener(new W(10)).request();
    }

    private static final void playAllLikedSong$lambda$25(MyMusicLikedSongFragment myMusicLikedSongFragment0, Object object0) {
        if(((LikeListSongRes)object0) != null && myMusicLikedSongFragment0.isFragmentValid()) {
            Notification httpResponse$Notification0 = ((LikeListSongRes)object0).notification;
            Cb.j.b(httpResponse$Notification0, false, 3);
            if(Cb.j.c(httpResponse$Notification0)) {
                com.iloen.melon.net.v5x.response.LikeListSongRes.RESPONSE likeListSongRes$RESPONSE0 = ((LikeListSongRes)object0).response;
                ArrayList arrayList0 = likeListSongRes$RESPONSE0 == null ? null : likeListSongRes$RESPONSE0.songlist;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, myMusicLikedSongFragment0.getMenuId(), null);
                    if(arrayList1 != null && !arrayList1.isEmpty()) {
                        myMusicLikedSongFragment0.playSongs(arrayList1, true);
                        return;
                    }
                    ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
                }
            }
        }
    }

    private static final void playAllLikedSong$lambda$26(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static void r0(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$16(myMusicLikedSongFragment0, view0);
    }

    public static void s0(MyMusicLikedSongFragment myMusicLikedSongFragment0, S s0, boolean z) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$17(myMusicLikedSongFragment0, s0, z);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        boolean z1 = this.isMyself();
        L l0 = L.b;
        if(z1) {
            FilterLayout filterLayout0 = this.headerView;
            if(filterLayout0 != null) {
                ViewUtils.showWhen(filterLayout0, true);
                if(z) {
                    View view0 = this.headerContainer;
                    if(view0 != null) {
                        ViewUtils.showWhen(view0, true);
                        ToggleView toggleView0 = this.toggleView;
                        if(toggleView0 != null) {
                            I i0 = new I(this, 6);
                            toggleView0.c(L.f, i0);
                            FilterLayout filterLayout1 = this.headerView;
                            if(filterLayout1 != null) {
                                filterLayout1.setOnCheckedListener(new I(this, 7));
                                FilterLayout filterLayout2 = this.headerView;
                                if(filterLayout2 != null) {
                                    filterLayout2.c(l0, new I(this, 8));
                                    this.updateParallaxHeaderView();
                                    return;
                                }
                                q.m("headerView");
                                throw null;
                            }
                            q.m("headerView");
                            throw null;
                        }
                        q.m("toggleView");
                        throw null;
                    }
                    q.m("headerContainer");
                    throw null;
                }
                FilterLayout filterLayout3 = this.headerView;
                if(filterLayout3 != null) {
                    filterLayout3.setOnCheckedListener(null);
                    FilterLayout filterLayout4 = this.headerView;
                    if(filterLayout4 != null) {
                        filterLayout4.setLeftButton(null);
                        FilterLayout filterLayout5 = this.headerView;
                        if(filterLayout5 != null) {
                            filterLayout5.setRightLayout(null);
                            ToggleView toggleView1 = this.toggleView;
                            if(toggleView1 != null) {
                                toggleView1.setRightLayout(null);
                                View view1 = this.headerContainer;
                                if(view1 != null) {
                                    ViewUtils.hideWhen(view1, true);
                                    this.updateParallaxHeaderView();
                                    return;
                                }
                                q.m("headerContainer");
                                throw null;
                            }
                            q.m("toggleView");
                            throw null;
                        }
                        q.m("headerView");
                        throw null;
                    }
                    q.m("headerView");
                    throw null;
                }
                q.m("headerView");
                throw null;
            }
            q.m("headerView");
            throw null;
        }
        FilterLayout filterLayout6 = this.headerView;
        if(filterLayout6 != null) {
            ViewUtils.hideWhen(filterLayout6, true);
            if(z) {
                ToggleView toggleView2 = this.toggleView;
                if(toggleView2 != null) {
                    toggleView2.setOnCheckedListener(new I(this, 9));
                    ToggleView toggleView3 = this.toggleView;
                    if(toggleView3 != null) {
                        toggleView3.c(l0, new I(this, 0));
                        return;
                    }
                    q.m("toggleView");
                    throw null;
                }
                q.m("toggleView");
                throw null;
            }
            ToggleView toggleView4 = this.toggleView;
            if(toggleView4 != null) {
                toggleView4.setOnCheckedListener(null);
                ToggleView toggleView5 = this.toggleView;
                if(toggleView5 != null) {
                    toggleView5.setLeftButton(null);
                    ToggleView toggleView6 = this.toggleView;
                    if(toggleView6 != null) {
                        toggleView6.setRightLayout(null);
                        return;
                    }
                    q.m("toggleView");
                    throw null;
                }
                q.m("toggleView");
                throw null;
            }
            q.m("toggleView");
            throw null;
        }
        q.m("headerView");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$14(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        MyMusicLikeEditFragment.newInstance("song", myMusicLikedSongFragment0.filterType, myMusicLikedSongFragment0.getCacheKey()).open();
    }

    private static final void setAllCheckButtonVisibility$lambda$15(MyMusicLikedSongFragment myMusicLikedSongFragment0, S s0, boolean z) {
        myMusicLikedSongFragment0.toggleSelectAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$16(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        myMusicLikedSongFragment0.playAllLikedSong();
    }

    private static final void setAllCheckButtonVisibility$lambda$17(MyMusicLikedSongFragment myMusicLikedSongFragment0, S s0, boolean z) {
        myMusicLikedSongFragment0.toggleSelectAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$22(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        if("LIKE_ME".equals(myMusicLikedSongFragment0.filterType)) {
            Params myMusicLikeListSameSongReq$Params0 = new Params();
            myMusicLikeListSameSongReq$Params0.startIndex = 1;
            myMusicLikeListSameSongReq$Params0.pageSize = myMusicLikedSongFragment0.PAGE_SIZE_ALL_PLAY;
            myMusicLikeListSameSongReq$Params0.targetMemberKey = myMusicLikedSongFragment0.memberKey;
            RequestBuilder.newInstance(new MyMusicLikeListSameSongReq(myMusicLikedSongFragment0.getContext(), myMusicLikeListSameSongReq$Params0)).tag(myMusicLikedSongFragment0.getRequestTag()).listener(new I(myMusicLikedSongFragment0, 2)).errorListener(new W(9)).request();
            return;
        }
        myMusicLikedSongFragment0.playAllLikedSong();
    }

    private static final void setAllCheckButtonVisibility$lambda$22$lambda$20(MyMusicLikedSongFragment myMusicLikedSongFragment0, Object object0) {
        if(((MyMusicLikeListSameSongRes)object0) != null && myMusicLikedSongFragment0.isFragmentValid()) {
            Notification httpResponse$Notification0 = ((MyMusicLikeListSameSongRes)object0).notification;
            Cb.j.b(httpResponse$Notification0, false, 3);
            if(Cb.j.c(httpResponse$Notification0)) {
                RESPONSE myMusicLikeListSameSongRes$RESPONSE0 = ((MyMusicLikeListSameSongRes)object0).response;
                ArrayList arrayList0 = myMusicLikeListSameSongRes$RESPONSE0 == null ? null : myMusicLikeListSameSongRes$RESPONSE0.songlist;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    myMusicLikedSongFragment0.playSongs(Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, myMusicLikedSongFragment0.getMenuId(), null), true);
                }
            }
        }
    }

    private static final void setAllCheckButtonVisibility$lambda$22$lambda$21(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void setFilterData() {
        if(this.isMyself()) {
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.c = "NEW";
            this.filterList.add(j0);
            v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.c = "ALPHABET";
            this.filterList.add(j1);
            v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j2.c = "ARTIST";
            this.filterList.add(j2);
            return;
        }
        v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j3.c = "NEW";
        this.filterList.add(j3);
        v9.j j4 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j4.c = "LIKE_ME";
        this.filterList.add(j4);
    }

    public static void t0(MyMusicLikedSongFragment myMusicLikedSongFragment0, VolleyError volleyError0) {
        MyMusicLikedSongFragment.onFetchStart$lambda$4(myMusicLikedSongFragment0, volleyError0);
    }

    public static void u0(MyMusicLikedSongFragment myMusicLikedSongFragment0, i i0, MyMusicLikeListSongRes myMusicLikeListSongRes0) {
        MyMusicLikedSongFragment.onFetchStart$lambda$7(myMusicLikedSongFragment0, i0, myMusicLikeListSongRes0);
    }

    public static void v0(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$14(myMusicLikedSongFragment0, view0);
    }

    public static void w0(MyMusicLikedSongFragment myMusicLikedSongFragment0, View view0) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$22(myMusicLikedSongFragment0, view0);
    }

    public static void x0(MyMusicLikedSongFragment myMusicLikedSongFragment0, i i0, MyMusicLikeListSameSongRes myMusicLikeListSameSongRes0) {
        MyMusicLikedSongFragment.onFetchStart$lambda$3(myMusicLikedSongFragment0, i0, myMusicLikeListSameSongRes0);
    }

    public static void z0(MyMusicLikedSongFragment myMusicLikedSongFragment0, Object object0) {
        MyMusicLikedSongFragment.setAllCheckButtonVisibility$lambda$22$lambda$20(myMusicLikedSongFragment0, object0);
    }
}

