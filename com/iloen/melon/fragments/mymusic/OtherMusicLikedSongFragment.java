package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailContentsSongAdapter;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.MyMusicLikeListSongReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSongRes;
import com.iloen.melon.net.v5x.request.LikeListSongReq.Params;
import com.iloen.melon.net.v5x.request.LikeListSongReq;
import com.iloen.melon.net.v5x.response.LikeListSongRes.RESPONSE;
import com.iloen.melon.net.v5x.response.LikeListSongRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import v9.h;
import v9.i;
import we.k;

@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001W\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ!\u0010\u0011\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0017J-\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0011\u0010*\u001A\u0004\u0018\u00010)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b,\u0010\u0003J\u000F\u0010-\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b-\u0010\u0003J\u0017\u0010.\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b0\u0010\u0003J\u000F\u00101\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b1\u0010\u0003J)\u00106\u001A\u00020\t2\u0018\u00105\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0012\u0004\u0012\u00020\t02H\u0002\u00A2\u0006\u0004\b6\u00107J\u0017\u00109\u001A\u00020\t2\u0006\u00108\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b;\u0010<J#\u0010?\u001A\u00020\t2\b\u0010=\u001A\u0004\u0018\u00010\u00042\b\u0010>\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bA\u0010\u0003J\u000F\u0010B\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bB\u0010\u0003J\u000F\u0010C\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bC\u0010\u0003J\u000F\u0010D\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bD\u0010\u0003J\u001F\u0010H\u001A\u00020\t2\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bH\u0010IJ\u001F\u0010J\u001A\u00020\t2\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bJ\u0010IJ\u001F\u0010K\u001A\u00020\t2\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bK\u0010IR\u0016\u0010L\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010MR\u0018\u0010=\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010MR\u0018\u0010>\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010MR\u0018\u0010O\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010PR\u0018\u0010S\u001A\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010PR\u0018\u0010V\u001A\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bV\u0010TR\u0014\u0010X\u001A\u00020W8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010]\u001A\u00020Z8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b[\u0010\\\u00A8\u0006_"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedSongFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "onResume", "onPause", "initHeaderView", "(Landroid/view/View;)V", "playAllLikedSong", "shufflePlayAllLikedSong", "Lkotlin/Function1;", "", "Lcom/iloen/melon/net/v5x/response/LikeListSongRes$RESPONSE$SONGLIST;", "andDo", "getAllLikedSong", "(Lwe/k;)V", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "isHeaderButtonVisible", "()Z", "songCount", "playTime", "updateSongCountAndPlayTime", "(Ljava/lang/String;Ljava/lang/String;)V", "updateSongCountAndPlayTimeView", "tiaraLogPlayShuffle", "tiaraLogPlayAll", "tiaraLogSelectAll", "Lcom/melon/net/res/common/SongInfoBase;", "data", "position", "tiaraLogSelectSong", "(Lcom/melon/net/res/common/SongInfoBase;I)V", "tiaraLogPlaySong", "tiaraLogMoreSong", "otherMemberKey", "Ljava/lang/String;", "filterType", "shuffleAndAllPlayButtons", "Landroid/view/View;", "allSelectAndOrderButton", "Landroid/widget/TextView;", "songCountTv", "Landroid/widget/TextView;", "dot", "playTimeTv", "com/iloen/melon/fragments/mymusic/OtherMusicLikedSongFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedSongFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OtherMusicLikedSongFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "START_INDEX", "", "PAGE_SIZE", "PAGE_SIZE_ALL", "newInstance", "Lcom/iloen/melon/fragments/mymusic/OtherMusicLikedSongFragment;", "memberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final OtherMusicLikedSongFragment newInstance(@NotNull String s) {
            q.g(s, "memberKey");
            OtherMusicLikedSongFragment otherMusicLikedSongFragment0 = new OtherMusicLikedSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            otherMusicLikedSongFragment0.setArguments(bundle0);
            return otherMusicLikedSongFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 100;
    private static final int PAGE_SIZE_ALL = 1000;
    private static final int START_INDEX = 1;
    @NotNull
    private static final String TAG = "OtherMusicLikedSongFragment";
    @NotNull
    private final com.iloen.melon.fragments.mymusic.OtherMusicLikedSongFragment.actionListener.1 actionListener;
    @Nullable
    private View allSelectAndOrderButton;
    @Nullable
    private View dot;
    @NotNull
    private String filterType;
    @NotNull
    private String otherMemberKey;
    @Nullable
    private String playTime;
    @Nullable
    private TextView playTimeTv;
    @Nullable
    private View shuffleAndAllPlayButtons;
    @Nullable
    private String songCount;
    @Nullable
    private TextView songCountTv;

    static {
        OtherMusicLikedSongFragment.Companion = new Companion(null);
        OtherMusicLikedSongFragment.$stable = 8;
    }

    public OtherMusicLikedSongFragment() {
        this.otherMemberKey = "";
        this.filterType = "NEW";
        this.songCount = "";
        this.playTime = "";
        this.actionListener = new SongActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onInfoClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, OtherMusicLikedSongFragment.this.getMenuId(), null);
                OtherMusicLikedSongFragment.this.showContextPopupSong(playable0);
                OtherMusicLikedSongFragment.this.tiaraLogMoreSong(songInfoBase0, v);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onPlaySongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, OtherMusicLikedSongFragment.this.getMenuId(), null);
                OtherMusicLikedSongFragment.this.playSong(playable0, true);
                OtherMusicLikedSongFragment.access$tiaraLogPlaySong(OtherMusicLikedSongFragment.this, songInfoBase0, v);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongClick(View view0, SongInfoBase songInfoBase0, int v, int v1, boolean z) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                OtherMusicLikedSongFragment.this.onItemClick(view0, v);
                if(z) {
                    OtherMusicLikedSongFragment.access$tiaraLogSelectSong(OtherMusicLikedSongFragment.this, songInfoBase0, v1);
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongLongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, OtherMusicLikedSongFragment.this.getMenuId(), null);
                OtherMusicLikedSongFragment.access$showContextPopupSongOrInstantPlay(OtherMusicLikedSongFragment.this, playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onThumbClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                OtherMusicLikedSongFragment.access$showAlbumInfoPage(OtherMusicLikedSongFragment.this, songInfoBase0);
            }
        };
    }

    public static final void access$showAlbumInfoPage(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, SongInfoBase songInfoBase0) {
        otherMusicLikedSongFragment0.showAlbumInfoPage(songInfoBase0);
    }

    public static final void access$showContextPopupSongOrInstantPlay(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, Playable playable0) {
        otherMusicLikedSongFragment0.showContextPopupSongOrInstantPlay(playable0);
    }

    public static final void access$tiaraLogPlaySong(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, SongInfoBase songInfoBase0, int v) {
        otherMusicLikedSongFragment0.tiaraLogPlaySong(songInfoBase0, v);
    }

    public static final void access$tiaraLogSelectSong(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, SongInfoBase songInfoBase0, int v) {
        otherMusicLikedSongFragment0.tiaraLogSelectSong(songInfoBase0, v);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D058D, null, false);  // layout:other_music_liked_song_header
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
        j0 j00 = new DetailContentsSongAdapter(context0, null, this.actionListener, false, false, null, 0x30, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    private final void getAllLikedSong(k k0) {
        Params likeListSongReq$Params0 = new Params();
        likeListSongReq$Params0.orderBy = this.filterType;
        likeListSongReq$Params0.startIndex = 1;
        likeListSongReq$Params0.pageSize = 1000;
        likeListSongReq$Params0.targetMemberKey = this.otherMemberKey;
        RequestBuilder.newInstance(new LikeListSongReq(this.getContext(), likeListSongReq$Params0)).tag(this.getRequestTag()).listener(new g(this, k0, 24)).errorListener(new W(12)).request();
    }

    private static final void getAllLikedSong$lambda$7(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, k k0, Object object0) {
        if(((LikeListSongRes)object0) != null && otherMusicLikedSongFragment0.isFragmentValid()) {
            Notification httpResponse$Notification0 = ((LikeListSongRes)object0).notification;
            Cb.j.b(httpResponse$Notification0, false, 3);
            if(Cb.j.c(httpResponse$Notification0)) {
                RESPONSE likeListSongRes$RESPONSE0 = ((LikeListSongRes)object0).response;
                ArrayList arrayList0 = likeListSongRes$RESPONSE0 == null ? null : likeListSongRes$RESPONSE0.songlist;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    k0.invoke(arrayList0);
                }
            }
        }
    }

    private static final void getAllLikedSong$lambda$8(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        f0.c = s1;
        f0.I = this.getMenuId();
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("song"), "targetMemberKey", this.otherMemberKey, "toString(...)");
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return this.isHeaderButtonVisible() ? ScreenUtils.dipToPixel(this.getContext(), 118.0f) : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return this.isHeaderButtonVisible() ? ScreenUtils.dipToPixel(this.getContext(), 118.0f) : 0;
    }

    private final void initHeaderView(View view0) {
        View view1 = view0.findViewById(0x7F0A01BC);  // id:btn_shuffle_play_all
        this.shuffleAndAllPlayButtons = view1;
        TextView textView0 = null;
        View view2 = view1 == null ? null : view1.findViewById(0x7F0A01BB);  // id:btn_shuffle
        if(view2 != null) {
            view2.setOnClickListener(new b0(this, 0));
        }
        View view3 = this.shuffleAndAllPlayButtons == null ? null : this.shuffleAndAllPlayButtons.findViewById(0x7F0A0183);  // id:btn_play_all
        if(view3 != null) {
            view3.setOnClickListener(new b0(this, 1));
        }
        View view4 = view0.findViewById(0x7F0A049B);  // id:filter_container
        this.allSelectAndOrderButton = view4;
        FilterLayout filterLayout0 = view4 == null ? null : ((FilterLayout)view4.findViewById(0x7F0A049E));  // id:filter_layout
        if(filterLayout0 != null) {
            a0 a00 = new a0(this);
            filterLayout0.b(I.e, a00);
        }
        View view5 = this.findViewById(0x7F0A0D17);  // id:tv_song_count
        this.songCountTv = view5 instanceof TextView ? ((TextView)view5) : null;
        this.dot = this.findViewById(0x7F0A03E1);  // id:dot
        View view6 = this.findViewById(0x7F0A0CDF);  // id:tv_play_time
        if(view6 instanceof TextView) {
            textView0 = (TextView)view6;
        }
        this.playTimeTv = textView0;
    }

    private static final void initHeaderView$lambda$0(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, View view0) {
        otherMusicLikedSongFragment0.shufflePlayAllLikedSong();
        otherMusicLikedSongFragment0.tiaraLogPlayShuffle();
    }

    private static final void initHeaderView$lambda$1(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, View view0) {
        otherMusicLikedSongFragment0.playAllLikedSong();
        otherMusicLikedSongFragment0.tiaraLogPlayAll();
    }

    private static final void initHeaderView$lambda$2(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, S s0, boolean z) {
        otherMusicLikedSongFragment0.toggleSelectAll();
        otherMusicLikedSongFragment0.tiaraLogSelectAll();
    }

    private final boolean isHeaderButtonVisible() {
        return this.allSelectAndOrderButton != null && this.allSelectAndOrderButton.getVisibility() == 0;
    }

    @NotNull
    public static final OtherMusicLikedSongFragment newInstance(@NotNull String s) {
        return OtherMusicLikedSongFragment.Companion.newInstance(s);
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

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsSongAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((DetailContentsSongAdapter)j00).clear();
        }
        com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params likeListSongBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params();
        likeListSongBaseReq$Params0.orderBy = this.filterType;
        likeListSongBaseReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsSongAdapter)j00).getCount() + 1;
        likeListSongBaseReq$Params0.pageSize = 100;
        likeListSongBaseReq$Params0.targetMemberKey = this.otherMemberKey;
        RequestBuilder.newInstance(new MyMusicLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0)).tag(this.getRequestTag()).listener(new g(this, i0, 23)).errorListener(new a0(this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$10(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, i i0, MyMusicLikeListSongRes myMusicLikeListSongRes0) {
        if(!otherMusicLikedSongFragment0.prepareFetchComplete(myMusicLikeListSongRes0)) {
            otherMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        com.iloen.melon.net.v4x.response.LikeListSongBaseRes.RESPONSE likeListSongBaseRes$RESPONSE0 = myMusicLikeListSongRes0.response;
        if(likeListSongBaseRes$RESPONSE0 != null) {
            if(likeListSongBaseRes$RESPONSE0.songlist != null && !likeListSongBaseRes$RESPONSE0.songlist.isEmpty()) {
                otherMusicLikedSongFragment0.updateSongCountAndPlayTime(likeListSongBaseRes$RESPONSE0.totalLikeSong, likeListSongBaseRes$RESPONSE0.totalPlayTime);
                otherMusicLikedSongFragment0.setAllCheckButtonVisibility(true);
            }
            otherMusicLikedSongFragment0.mMelonTiaraProperty = new s(likeListSongBaseRes$RESPONSE0.section, likeListSongBaseRes$RESPONSE0.page, likeListSongBaseRes$RESPONSE0.menuId, null);
        }
        otherMusicLikedSongFragment0.performFetchComplete(i0, myMusicLikeListSongRes0);
    }

    private static final void onFetchStart$lambda$11(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, VolleyError volleyError0) {
        otherMusicLikedSongFragment0.performFetchError(volleyError0);
        otherMusicLikedSongFragment0.setAllCheckButtonVisibility(false);
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
        this.otherMemberKey = s;
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
        bundle0.putString("argMemberKey", this.otherMemberKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        this.initHeaderView(view0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        boolean z = false;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
        this.updateSongCountAndPlayTimeView();
    }

    private final void playAllLikedSong() {
        this.getAllLikedSong(new c0(this, 0));
    }

    private static final H playAllLikedSong$lambda$3(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, List list0) {
        q.g(list0, "songList");
        ArrayList arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(list0, otherMusicLikedSongFragment0.getMenuId(), null);
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            otherMusicLikedSongFragment0.playSongs(arrayList0, true);
            return H.a;
        }
        ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        return H.a;
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(this.isFragmentValid() && this.isHeaderButtonVisible() != z) {
            ViewUtils.showWhen(this.allSelectAndOrderButton, z);
            ViewUtils.showWhen(this.shuffleAndAllPlayButtons, z);
            this.onUpdateParallaxHeader();
        }
    }

    private final void shufflePlayAllLikedSong() {
        this.getAllLikedSong(new c0(this, 1));
    }

    private static final H shufflePlayAllLikedSong$lambda$4(OtherMusicLikedSongFragment otherMusicLikedSongFragment0, List list0) {
        q.g(list0, "songList");
        ArrayList arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(list0, otherMusicLikedSongFragment0.getMenuId(), null);
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            otherMusicLikedSongFragment0.playSongs(arrayList0, true, false, true);
            return H.a;
        }
        ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        return H.a;
    }

    private final void tiaraLogMoreSong(SongInfoBase songInfoBase0, int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = songInfoBase0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songInfoBase0.songName;
        f0.a().track();
    }

    private final void tiaraLogPlayAll() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.F = this.getString(0x7F130CF9);  // string:tiara_click_copy_all_play "전체재생"
        f0.a().track();
    }

    private final void tiaraLogPlayShuffle() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.F = this.getString(0x7F130D9C);  // string:tiara_click_copy_shuffle_play "셔플재생"
        f0.a().track();
    }

    private final void tiaraLogPlaySong(SongInfoBase songInfoBase0, int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = songInfoBase0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songInfoBase0.songName;
        f0.a().track();
    }

    private final void tiaraLogSelectAll() {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.F = this.getString(0x7F130D93);  // string:tiara_click_copy_select_all "전체선택"
        f0.a().track();
    }

    private final void tiaraLogSelectSong(SongInfoBase songInfoBase0, int v) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
        f0.C = String.valueOf(v + 1);
        f0.e = songInfoBase0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songInfoBase0.songName;
        f0.a().track();
    }

    private final void updateSongCountAndPlayTime(String s, String s1) {
        this.songCount = s;
        this.playTime = s1;
        this.updateSongCountAndPlayTimeView();
    }

    private final void updateSongCountAndPlayTimeView() {
        String s;
        boolean z = false;
        int v = this.songCount == null || this.songCount.length() == 0 ? 1 : 0;
        int v1 = this.playTime == null || this.playTime.length() == 0 ? 1 : 0;
        TextView textView0 = this.songCountTv;
        if(textView0 != null) {
            Context context0 = this.getContext();
            if(context0 == null) {
                s = this.songCount;
            }
            else {
                s = context0.getString(0x7F1304F1, new Object[]{this.songCount});  // string:library_recent_song_count "%1$s곡"
                if(s == null) {
                    s = this.songCount;
                }
            }
            textView0.setText(s);
        }
        ViewUtils.showWhen(this.songCountTv, ((boolean)(v ^ 1)));
        TextView textView1 = this.playTimeTv;
        if(textView1 != null) {
            textView1.setText(this.playTime);
        }
        ViewUtils.showWhen(this.playTimeTv, ((boolean)(v1 ^ 1)));
        View view0 = this.dot;
        if(v1 == 0 && v == 0) {
            z = true;
        }
        ViewUtils.showWhen(view0, z);
    }
}

