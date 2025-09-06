package com.iloen.melon.fragments.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.MelonBigButton;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import pc.R0;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\tJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0017H\u0004\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001B\u0010\u001D\u001A\u00020\u00072\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0004\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\'\u0010+\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\'2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b+\u0010,J\'\u0010-\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\'2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b-\u0010,J\'\u0010.\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\'2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b.\u0010,J\'\u0010/\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\'2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b/\u0010,J7\u00102\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\'2\u0006\u00100\u001A\u00020)2\u0006\u0010*\u001A\u00020)2\u0006\u00101\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b4\u0010\u0004J\u0011\u00106\u001A\u0004\u0018\u000105H\u0014\u00A2\u0006\u0004\b6\u00107J!\u0010:\u001A\u00020\u00072\b\u0010(\u001A\u0004\u0018\u0001082\u0006\u00109\u001A\u00020)H\u0014\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b<\u0010\u0004J\u000F\u0010=\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b=\u0010\u0004R\"\u0010>\u001A\u00020\u001B8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010\u001ER\"\u0010C\u001A\u00020\u001B8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010?\u001A\u0004\bD\u0010A\"\u0004\bE\u0010\u001ER\u0018\u0010G\u001A\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001A\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010HR\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u001B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001C\u0010?R\u0018\u0010L\u001A\u0004\u0018\u00010\u001B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010?R\u001A\u0010M\u001A\u00020\u001B8\u0014X\u0094D\u00A2\u0006\f\n\u0004\bM\u0010?\u001A\u0004\bN\u0010AR\u001A\u0010O\u001A\u00020\u00178\u0014X\u0094D\u00A2\u0006\f\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010RR$\u0010T\u001A\u0004\u0018\u00010S8\u0014@\u0014X\u0094\u000E\u00A2\u0006\u0012\n\u0004\bT\u0010U\u001A\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010]\u001A\u00020Z8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b[\u0010\\\u00A8\u0006_"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailContentsAllSongBaseFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "show", "setHeaderButtonVisibility", "(Z)V", "", "songCount", "updateSongCount", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/melon/net/res/common/SongInfoBase;", "item", "", "position", "onThumbClick", "(Landroid/view/View;Lcom/melon/net/res/common/SongInfoBase;I)V", "onInfoClick", "onPlaySongClick", "onSongLongClick", "rawPosition", "isMarked", "onSongClick", "(Landroid/view/View;Lcom/melon/net/res/common/SongInfoBase;IIZ)V", "onPause", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "makeHeaderView", "updateSongCountAndPlayTimeView", "playlistSeq", "Ljava/lang/String;", "getPlaylistSeq", "()Ljava/lang/String;", "setPlaylistSeq", "playlistName", "getPlaylistName", "setPlaylistName", "Landroid/widget/TextView;", "songCountTv", "Landroid/widget/TextView;", "dot", "Landroid/view/View;", "playTimeTv", "playTime", "pageMetaType", "getPageMetaType", "hasMixUpPlayBtn", "Z", "getHasMixUpPlayBtn", "()Z", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistDetailContentsAllSongBaseFragment extends MetaContentBaseFragment implements SongActionListener {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailContentsAllSongBaseFragment$Companion;", "", "<init>", "()V", "PAGE_SIZE", "", "ARG_PLAYLIST_SEQ", "", "ARG_PLAYLIST_NAME", "ARG_PLAY_TIME", "ARG_SONG_COUNT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PLAYLIST_NAME = "argPlaylistName";
    @NotNull
    public static final String ARG_PLAYLIST_SEQ = "argPlaylistSeq";
    @NotNull
    public static final String ARG_PLAY_TIME = "argPlayTime";
    @NotNull
    public static final String ARG_SONG_COUNT = "argSongCount";
    @NotNull
    public static final Companion Companion = null;
    public static final int PAGE_SIZE = 100;
    @Nullable
    private View dot;
    private final boolean hasMixUpPlayBtn;
    @NotNull
    private final String pageMetaType;
    @Nullable
    private String playTime;
    @Nullable
    private TextView playTimeTv;
    @NotNull
    private String playlistName;
    @NotNull
    private String playlistSeq;
    @Nullable
    private String songCount;
    @Nullable
    private TextView songCountTv;
    @Nullable
    private StatsElementsBase statsElements;

    static {
        PlaylistDetailContentsAllSongBaseFragment.Companion = new Companion(null);
        PlaylistDetailContentsAllSongBaseFragment.$stable = 8;
    }

    public PlaylistDetailContentsAllSongBaseFragment() {
        this.playlistSeq = "";
        this.playlistName = "";
        this.songCount = "";
        this.playTime = "";
        this.pageMetaType = "";
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
        j0 j00 = new DetailContentsSongAdapter(context0, null, this, false, false, null, 0x30, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.playlistSeq;
        f0.p = this.getPageMetaType();
        f0.q = this.playlistName;
        return f0;
    }

    public boolean getHasMixUpPlayBtn() {
        return this.hasMixUpPlayBtn;
    }

    @NotNull
    public String getPageMetaType() {
        return this.pageMetaType;
    }

    @NotNull
    public final String getPlaylistName() {
        return this.playlistName;
    }

    @NotNull
    public final String getPlaylistSeq() {
        return this.playlistSeq;
    }

    @Nullable
    public StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    private final void makeHeaderView() {
        View view0 = this.findViewById(0x7F0A01BB);  // id:btn_shuffle
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonBigButton");
        View view1 = this.findViewById(0x7F0A0178);  // id:btn_mixup
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonBigButton");
        View view2 = this.findViewById(0x7F0A0183);  // id:btn_play_all
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.MelonBigButton");
        if(this.getHasMixUpPlayBtn()) {
            ViewUtils.showWhen(((MelonBigButton)view1), true);
        }
        ((MelonBigButton)view1).setOnClickListener(new F(this, 0));
        ((MelonBigButton)view2).setOnClickListener(new F(this, 1));
        ((MelonBigButton)view0).setOnClickListener(new F(this, 2));
        View view3 = this.findViewById(0x7F0A049E);  // id:filter_layout
        q.e(view3, "null cannot be cast to non-null type com.iloen.melon.custom.FilterLayout");
        e e0 = new e(this, 4);
        ((FilterLayout)view3).b(I.e, e0);
        View view4 = this.findViewById(0x7F0A0D17);  // id:tv_song_count
        TextView textView0 = null;
        this.songCountTv = view4 instanceof TextView ? ((TextView)view4) : null;
        this.dot = this.findViewById(0x7F0A03E1);  // id:dot
        View view5 = this.findViewById(0x7F0A0CDF);  // id:tv_play_time
        if(view5 instanceof TextView) {
            textView0 = (TextView)view5;
        }
        this.playTimeTv = textView0;
    }

    private static final void makeHeaderView$lambda$0(PlaylistDetailContentsAllSongBaseFragment playlistDetailContentsAllSongBaseFragment0, View view0) {
        playlistDetailContentsAllSongBaseFragment0.playMixUp(playlistDetailContentsAllSongBaseFragment0.getMenuId(), new R0(playlistDetailContentsAllSongBaseFragment0.playlistSeq, playlistDetailContentsAllSongBaseFragment0.playlistName, playlistDetailContentsAllSongBaseFragment0.getStatsElements()));
        f f0 = playlistDetailContentsAllSongBaseFragment0.getBaseTiaraLogEventBuilder();
        f0.a = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
        f0.e = playlistDetailContentsAllSongBaseFragment0.playlistSeq;
        f0.f = Y.i(ContsTypeCode.DJ_PLAYLIST_MIXUP, "code(...)");
        f0.g = playlistDetailContentsAllSongBaseFragment0.playlistName;
        f0.J = "1000003099";
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$1(PlaylistDetailContentsAllSongBaseFragment playlistDetailContentsAllSongBaseFragment0, View view0) {
        playlistDetailContentsAllSongBaseFragment0.playAll();
        f f0 = playlistDetailContentsAllSongBaseFragment0.getBaseTiaraLogEventBuilder();
        f0.a = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.y = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130CF9);  // string:tiara_click_copy_all_play "전체재생"
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$2(PlaylistDetailContentsAllSongBaseFragment playlistDetailContentsAllSongBaseFragment0, View view0) {
        playlistDetailContentsAllSongBaseFragment0.playShuffleAll();
        f f0 = playlistDetailContentsAllSongBaseFragment0.getBaseTiaraLogEventBuilder();
        f0.a = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.y = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130D9C);  // string:tiara_click_copy_shuffle_play "셔플재생"
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$3(PlaylistDetailContentsAllSongBaseFragment playlistDetailContentsAllSongBaseFragment0, S s0, boolean z) {
        q.g(s0, "<unused var>");
        playlistDetailContentsAllSongBaseFragment0.toggleSelectAll();
        if(playlistDetailContentsAllSongBaseFragment0.mMarkedAll) {
            f f0 = playlistDetailContentsAllSongBaseFragment0.getBaseTiaraLogEventBuilder();
            f0.a = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.y = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = playlistDetailContentsAllSongBaseFragment0.getString(0x7F130D93);  // string:tiara_click_copy_select_all "전체선택"
            f0.a().track();
        }
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
        return layoutInflater0.inflate(0x7F0D0191, null, false);  // layout:common_detail_contents_song_fragment
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
    public void onInfoClick(@NotNull View view0, @NotNull SongInfoBase songInfoBase0, int v) {
        q.g(view0, "view");
        q.g(songInfoBase0, "item");
        this.showContextPopupSong(Playable.from(songInfoBase0, this.getMenuId(), null));
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = this.getString(0x7F130D56);  // string:tiara_click_copy_more_song "곡더보기"
        f0.C = String.valueOf(v + 1);
        f0.e = songInfoBase0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songInfoBase0.songName;
        f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
        f0.a().track();
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        this.setSelectAllWithToolbar(false);
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
    public void onPlaySongClick(@NotNull View view0, @NotNull SongInfoBase songInfoBase0, int v) {
        q.g(view0, "view");
        q.g(songInfoBase0, "item");
        this.playSong(Playable.from(songInfoBase0, this.getMenuId(), null), true);
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.C = String.valueOf(v + 1);
        f0.F = this.getString(0x7F130D6A);  // string:tiara_click_copy_play_music "음악재생"
        f0.e = songInfoBase0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songInfoBase0.songName;
        f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
        f0.a().track();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.playlistSeq = l1.g(bundle0, "inState", "argPlaylistSeq", "", "getString(...)");
        String s = bundle0.getString("argPlaylistName", "");
        q.f(s, "getString(...)");
        this.playlistName = s;
        this.playTime = bundle0.getString("argPlayTime", "");
        this.songCount = bundle0.getString("argSongCount", "");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argPlaylistSeq", this.playlistSeq);
        bundle0.putString("argPlaylistName", this.playlistName);
        bundle0.putString("argPlayTime", this.playTime);
        bundle0.putString("argSongCount", this.songCount);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
    public void onSongClick(@NotNull View view0, @NotNull SongInfoBase songInfoBase0, int v, int v1, boolean z) {
        q.g(view0, "view");
        q.g(songInfoBase0, "item");
        this.onItemClick(view0, v);
        if(z) {
            f f0 = this.getBaseTiaraLogEventBuilder();
            f0.a = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.C = String.valueOf(v1 + 1);
            f0.F = this.getString(0x7F130D95);  // string:tiara_click_copy_select_song "곡선택"
            f0.e = songInfoBase0.songId;
            f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            f0.g = songInfoBase0.songName;
            f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
    public void onSongLongClick(@NotNull View view0, @NotNull SongInfoBase songInfoBase0, int v) {
        q.g(view0, "view");
        q.g(songInfoBase0, "item");
        this.showContextPopupSongOrInstantPlay(Playable.from(songInfoBase0, this.getMenuId(), null));
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
    public void onThumbClick(@NotNull View view0, @NotNull SongInfoBase songInfoBase0, int v) {
        q.g(view0, "view");
        q.g(songInfoBase0, "item");
        this.showAlbumInfoPage(songInfoBase0);
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = this.getString(0x7F130D57);  // string:tiara_click_copy_move_album "앨범페이지이동"
        f0.C = String.valueOf(v + 1);
        f0.e = songInfoBase0.albumId;
        f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
        f0.g = songInfoBase0.albumName;
        f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
        f0.a().track();
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        String s;
        super.onToolBarClick(toolBar$ToolBarItem0, v);
        switch(v) {
            case 0: {
                s = "재생";
                break;
            }
            case 1: {
                s = "다운";
                break;
            }
            case 2: {
                s = "담기";
                break;
            }
            default: {
                s = "";
            }
        }
        q.d(s);
        if(s.length() > 0) {
            f f0 = this.getBaseTiaraLogEventBuilder();
            f0.a = "페이지이동";
            f0.y = "선택팝업";
            f0.F = s;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.makeHeaderView();
        this.setHeaderButtonVisibility(this.getItemCount() > 0);
        this.updateSongCountAndPlayTimeView();
    }

    public final void setHeaderButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.findViewById(0x7F0A01BC), z);  // id:btn_shuffle_play_all
        ViewUtils.showWhen(this.findViewById(0x7F0A049B), z);  // id:filter_container
        if(!z) {
            ViewUtils.hideWhen(this.songCountTv, true);
            ViewUtils.hideWhen(this.playTimeTv, true);
            ViewUtils.hideWhen(this.dot, true);
        }
    }

    public final void setPlaylistName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.playlistName = s;
    }

    public final void setPlaylistSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.playlistSeq = s;
    }

    public void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElements = statsElementsBase0;
    }

    public final void updateSongCount(@Nullable String s) {
        if(s != null && s.length() != 0) {
            this.songCount = s;
        }
        this.updateSongCountAndPlayTimeView();
    }

    public static void updateSongCount$default(PlaylistDetailContentsAllSongBaseFragment playlistDetailContentsAllSongBaseFragment0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSongCount");
        }
        if((v & 1) != 0) {
            s = "";
        }
        playlistDetailContentsAllSongBaseFragment0.updateSongCount(s);
    }

    private final void updateSongCountAndPlayTimeView() {
        boolean z = false;
        boolean z1 = this.songCount == null || this.songCount.length() == 0;
        if(this.playTime == null || this.playTime.length() == 0) {
            z = true;
        }
        if(!z1) {
            ViewUtils.showWhen(this.songCountTv, true);
            TextView textView0 = this.songCountTv;
            if(textView0 != null) {
                String s = "곡";
                String s1 = this.songCount;
                if(this.getContext() == null) {
                    s = "";
                }
                textView0.setText(s1 + s);
            }
        }
        if(!z) {
            ViewUtils.showWhen(this.playTimeTv, true);
            TextView textView1 = this.playTimeTv;
            if(textView1 != null) {
                textView1.setText(this.playTime);
            }
        }
        if(!z && !z1) {
            ViewUtils.showWhen(this.dot, true);
        }
    }
}

