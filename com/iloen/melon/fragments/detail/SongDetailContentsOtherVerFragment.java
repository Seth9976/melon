package com.iloen.melon.fragments.detail;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.SONG;
import com.iloen.melon.net.v6x.request.SongContentsOtherVerReq.Params;
import com.iloen.melon.net.v6x.request.SongContentsOtherVerReq;
import com.iloen.melon.net.v6x.response.SongContentsOtherVerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongContentsOtherVerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00014\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000F\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ!\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u001B\u0010$\u001A\u0006\u0012\u0002\b\u00030#2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b$\u0010%J-\u0010+\u001A\u00020\u00062\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010)\u001A\u0004\u0018\u00010(2\b\u0010*\u001A\u0004\u0018\u00010\u0010H\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b-\u0010\u0003J\u0011\u0010/\u001A\u0004\u0018\u00010.H\u0014\u00A2\u0006\u0004\b/\u00100R\u0016\u00101\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001A\u0002048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001A\u0002078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u00109\u00A8\u0006<"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailContentsOtherVerFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "makeHeaderView", "", "show", "setHeaderButtonVisibility", "(Z)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onPause", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "songId", "Ljava/lang/String;", "pageMetaName", "com/iloen/melon/fragments/detail/SongDetailContentsOtherVerFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/detail/SongDetailContentsOtherVerFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongDetailContentsOtherVerFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailContentsOtherVerFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/SongDetailContentsOtherVerFragment;", "songId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongDetailContentsOtherVerFragment newInstance(@Nullable String s) {
            SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0 = new SongDetailContentsOtherVerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argSongId", s);
            songDetailContentsOtherVerFragment0.setArguments(bundle0);
            return songDetailContentsOtherVerFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SongDetailContentsOtherVerFragment";
    @NotNull
    private final com.iloen.melon.fragments.detail.SongDetailContentsOtherVerFragment.actionListener.1 actionListener;
    @NotNull
    private String pageMetaName;
    @NotNull
    private String songId;

    static {
        SongDetailContentsOtherVerFragment.Companion = new Companion(null);
        SongDetailContentsOtherVerFragment.$stable = 8;
    }

    public SongDetailContentsOtherVerFragment() {
        this.songId = "";
        this.pageMetaName = "";
        this.actionListener = new SongActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onInfoClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsOtherVerFragment.this.getMenuId(), null);
                SongDetailContentsOtherVerFragment.this.showContextPopupSong(playable0);
                f f0 = SongDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsOtherVerFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = SongDetailContentsOtherVerFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.F = SongDetailContentsOtherVerFragment.this.getString(0x7F130D56);  // string:tiara_click_copy_more_song "곡더보기"
                f0.C = String.valueOf(v + 1);
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.a().track();
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onPlaySongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsOtherVerFragment.this.getMenuId(), null);
                SongDetailContentsOtherVerFragment.this.playSong(playable0, true);
                f f0 = SongDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsOtherVerFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = SongDetailContentsOtherVerFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.C = String.valueOf(v + 1);
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.a().track();
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongClick(View view0, SongInfoBase songInfoBase0, int v, int v1, boolean z) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                SongDetailContentsOtherVerFragment.this.onItemClick(view0, v);
                if(z) {
                    f f0 = SongDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = SongDetailContentsOtherVerFragment.this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    f0.d = ActionKind.ClickContent;
                    f0.y = SongDetailContentsOtherVerFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                    f0.C = String.valueOf(v1 + 1);
                    f0.e = songInfoBase0.songId;
                    f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f0.g = songInfoBase0.songName;
                    f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongLongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsOtherVerFragment.this.getMenuId(), null);
                SongDetailContentsOtherVerFragment.access$showContextPopupSongOrInstantPlay(SongDetailContentsOtherVerFragment.this, playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onThumbClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                SongDetailContentsOtherVerFragment.this.showSongInfoPage(songInfoBase0.songId);
                f f0 = SongDetailContentsOtherVerFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsOtherVerFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = SongDetailContentsOtherVerFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.C = String.valueOf(v + 1);
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.a().track();
            }
        };
    }

    public static final void access$showContextPopupSongOrInstantPlay(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, Playable playable0) {
        songDetailContentsOtherVerFragment0.showContextPopupSongOrInstantPlay(playable0);
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

    public static void d0(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, VolleyError volleyError0) {
        SongDetailContentsOtherVerFragment.onFetchStart$lambda$11(songDetailContentsOtherVerFragment0, volleyError0);
    }

    public static void e0(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, View view0) {
        SongDetailContentsOtherVerFragment.makeHeaderView$lambda$2(songDetailContentsOtherVerFragment0, view0);
    }

    public static void f0(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, View view0) {
        SongDetailContentsOtherVerFragment.makeHeaderView$lambda$1(songDetailContentsOtherVerFragment0, view0);
    }

    public static void g0(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, i i0, DetailContentsSongAdapter detailContentsSongAdapter0, SongContentsOtherVerRes songContentsOtherVerRes0) {
        SongDetailContentsOtherVerFragment.onFetchStart$lambda$10(songDetailContentsOtherVerFragment0, i0, detailContentsSongAdapter0, songContentsOtherVerRes0);
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.songId;
        f0.p = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        f0.q = this.pageMetaName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.d.buildUpon().appendPath("OTHER_VER"), this.songId, "toString(...)");
    }

    public static void h0(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, S s0, boolean z) {
        SongDetailContentsOtherVerFragment.makeHeaderView$lambda$4$lambda$3(songDetailContentsOtherVerFragment0, s0, z);
    }

    private final void makeHeaderView() {
        View view0 = this.findViewById(0x7F0A0183);  // id:btn_play_all
        if(view0 != null) {
            view0.setOnClickListener(new J(this, 0));
        }
        View view1 = this.findViewById(0x7F0A01BB);  // id:btn_shuffle
        if(view1 != null) {
            view1.setOnClickListener(new J(this, 1));
        }
        View view2 = this.findViewById(0x7F0A049E);  // id:filter_layout
        FilterLayout filterLayout0 = view2 instanceof FilterLayout ? ((FilterLayout)view2) : null;
        if(filterLayout0 != null) {
            K k0 = new K(this);
            filterLayout0.b(I.e, k0);
            filterLayout0.setCheckButtonChecked(this.mMarkedAll);
        }
    }

    private static final void makeHeaderView$lambda$1(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, View view0) {
        songDetailContentsOtherVerFragment0.playAll();
        f f0 = songDetailContentsOtherVerFragment0.getBaseTiaraLogEventBuilder();
        f0.a = songDetailContentsOtherVerFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = songDetailContentsOtherVerFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = songDetailContentsOtherVerFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$2(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, View view0) {
        songDetailContentsOtherVerFragment0.playShuffleAll();
        f f0 = songDetailContentsOtherVerFragment0.getBaseTiaraLogEventBuilder();
        f0.a = songDetailContentsOtherVerFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = songDetailContentsOtherVerFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = songDetailContentsOtherVerFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$4$lambda$3(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, S s0, boolean z) {
        songDetailContentsOtherVerFragment0.toggleSelectAll();
        if(songDetailContentsOtherVerFragment0.mMarkedAll) {
            f f0 = songDetailContentsOtherVerFragment0.getBaseTiaraLogEventBuilder();
            f0.a = songDetailContentsOtherVerFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.y = songDetailContentsOtherVerFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = songDetailContentsOtherVerFragment0.getString(0x7F130E36);  // string:tiara_common_layer2_select_all "전체선택"
            f0.a().track();
        }
    }

    @NotNull
    public static final SongDetailContentsOtherVerFragment newInstance(@Nullable String s) {
        return SongDetailContentsOtherVerFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(false);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0849, null, false);  // layout:song_detail_contents_song_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsSongAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            this.setHeaderButtonVisibility(false);
            ((DetailContentsSongAdapter)j00).clear();
        }
        Params songContentsOtherVerReq$Params0 = new Params();
        songContentsOtherVerReq$Params0.songId = this.songId;
        songContentsOtherVerReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsSongAdapter)j00).getCount() + 1;
        songContentsOtherVerReq$Params0.pageSize = 30;
        RequestBuilder.newInstance(new SongContentsOtherVerReq(this.getContext(), songContentsOtherVerReq$Params0)).tag(this.getRequestTag()).listener(new B(this, i0, ((DetailContentsSongAdapter)j00), 2)).errorListener(new K(this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$10(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, i i0, DetailContentsSongAdapter detailContentsSongAdapter0, SongContentsOtherVerRes songContentsOtherVerRes0) {
        int v = 0;
        if(!songDetailContentsOtherVerFragment0.prepareFetchComplete(songContentsOtherVerRes0)) {
            songDetailContentsOtherVerFragment0.setHeaderButtonVisibility(false);
            return;
        }
        RESPONSE songContentsOtherVerRes$RESPONSE0 = songContentsOtherVerRes0.response;
        List list0 = songContentsOtherVerRes$RESPONSE0.songs;
        q.f(list0, "songs");
        for(Object object0: list0) {
            if(v >= 0) {
                if(((SONG)object0).isOrigin()) {
                    detailContentsSongAdapter0.setOriginSongIndex(v);
                    break;
                }
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        songDetailContentsOtherVerFragment0.mMelonTiaraProperty = new s(songContentsOtherVerRes$RESPONSE0.section, songContentsOtherVerRes$RESPONSE0.page, songContentsOtherVerRes$RESPONSE0.menuId, null);
        String s = songContentsOtherVerRes$RESPONSE0.pageMetaName;
        q.f(s, "pageMetaName");
        songDetailContentsOtherVerFragment0.pageMetaName = s;
        Collection collection0 = songContentsOtherVerRes0.getItems();
        if(collection0 != null && !collection0.isEmpty() == 1) {
            songDetailContentsOtherVerFragment0.setHeaderButtonVisibility(true);
        }
        songDetailContentsOtherVerFragment0.performFetchComplete(i0, songContentsOtherVerRes0);
    }

    private static final void onFetchStart$lambda$11(SongDetailContentsOtherVerFragment songDetailContentsOtherVerFragment0, VolleyError volleyError0) {
        songDetailContentsOtherVerFragment0.performFetchError(volleyError0);
        songDetailContentsOtherVerFragment0.setHeaderButtonVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        this.setSelectAllWithToolbar(false);
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.songId = l1.g(bundle0, "inState", "argSongId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argSongId", this.songId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = true;
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F130A67));  // string:song_detail_contents_other_ver_title "이 곡의 다른 버전"
        }
        this.makeHeaderView();
        if(this.getItemCount() <= 0) {
            z = false;
        }
        this.setHeaderButtonVisibility(z);
    }

    private final void setHeaderButtonVisibility(boolean z) {
        if(this.isFragmentValid()) {
            ViewUtils.showWhen(this.findViewById(0x7F0A01BC), z);  // id:btn_shuffle_play_all
            ViewUtils.showWhen(this.findViewById(0x7F0A049B), z);  // id:filter_container
        }
    }
}

