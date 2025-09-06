package com.iloen.melon.fragments.detail;

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
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.fragments.main.common.OnImpLogListener;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder.OnStateChangeListener;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.SONG;
import com.iloen.melon.net.v6x.request.SongContentsSimilarReq.Params;
import com.iloen.melon.net.v6x.request.SongContentsSimilarReq;
import com.iloen.melon.net.v6x.response.SongContentsSimilarRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongContentsSimilarRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.common.SongInfoBase;
import ie.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;
import v9.m;

@Metadata(d1 = {"\u0000\u00B9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001Y\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001`B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\tJ\u000F\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\f\u0010\u0004J\u000F\u0010\r\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u0004J\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0005H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b\"\u0010#J-\u0010*\u001A\u00020)2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010(\u001A\u0004\u0018\u00010\u000EH\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b,\u0010\u0004J\u0011\u0010.\u001A\u0004\u0018\u00010-H\u0014\u00A2\u0006\u0004\b.\u0010/J!\u00104\u001A\u00020\u00072\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00103\u001A\u000202H\u0014\u00A2\u0006\u0004\b4\u00105J\u001F\u00109\u001A\u00020\u00072\u0006\u00106\u001A\u00020\u000E2\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010=\u001A\u00020\u00072\u0006\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010?\u001A\u00020\u00072\u0006\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b?\u0010>J\u000F\u0010@\u001A\u00020)H\u0016\u00A2\u0006\u0004\b@\u0010AJ\u000F\u0010B\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bB\u0010\u0004J\u0017\u0010D\u001A\u00020\u00072\u0006\u0010C\u001A\u00020)H\u0002\u00A2\u0006\u0004\bD\u0010EJ\u001D\u0010I\u001A\u00020\u00072\f\u0010H\u001A\b\u0012\u0004\u0012\u00020G0FH\u0002\u00A2\u0006\u0004\bI\u0010JJ\u000F\u0010K\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bK\u0010\u0004J\u000F\u0010L\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bL\u0010\u0004J\u000F\u0010M\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bM\u0010\u0004R\u0016\u0010N\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010OR\u0016\u0010Q\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010@\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010RR \u0010T\u001A\u000E\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u0002070S8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u001A\u0010W\u001A\b\u0012\u0004\u0012\u00020;0V8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001A\u00020Y8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001A\u00020\\8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b]\u0010^\u00A8\u0006a"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailContentsSimilarFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onStart", "onStop", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onPause", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "key", "Lcom/kakao/tiara/data/ViewImpContent;", "viewImpContent", "onImpLogListener", "(Ljava/lang/String;Lcom/kakao/tiara/data/ViewImpContent;)V", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "listener", "addOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "removeOnStateChangeListener", "isForegroundFragment", "()Z", "makeHeaderView", "show", "setHeaderButtonVisibility", "(Z)V", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$SONG;", "songs", "setSongIds", "(Ljava/util/List;)V", "startViewableCheck", "stopViewableCheck", "tiaraViewImpMapFlush", "songId", "Ljava/lang/String;", "songIds", "pageMetaName", "Z", "Ljava/util/HashMap;", "tiaraViewImpMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "onStateChangeListenerHashSet", "Ljava/util/HashSet;", "com/iloen/melon/fragments/detail/SongDetailContentsSimilarFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/detail/SongDetailContentsSimilarFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongDetailContentsSimilarFragment extends MetaContentBaseFragment implements OnImpLogListener {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongDetailContentsSimilarFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/SongDetailContentsSimilarFragment;", "songId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @d
        @NotNull
        public final SongDetailContentsSimilarFragment newInstance(@Nullable String s) {
            SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0 = new SongDetailContentsSimilarFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argSongId", s);
            songDetailContentsSimilarFragment0.setArguments(bundle0);
            return songDetailContentsSimilarFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SongDetailContentsSimilarFragment";
    @NotNull
    private final com.iloen.melon.fragments.detail.SongDetailContentsSimilarFragment.actionListener.1 actionListener;
    private boolean isForegroundFragment;
    @NotNull
    private final HashSet onStateChangeListenerHashSet;
    @NotNull
    private String pageMetaName;
    @NotNull
    private String songId;
    @NotNull
    private String songIds;
    @NotNull
    private final HashMap tiaraViewImpMap;

    static {
        SongDetailContentsSimilarFragment.Companion = new Companion(null);
        SongDetailContentsSimilarFragment.$stable = 8;
    }

    public SongDetailContentsSimilarFragment() {
        this.songId = "";
        this.songIds = "";
        this.pageMetaName = "";
        this.tiaraViewImpMap = new HashMap();
        this.onStateChangeListenerHashSet = new HashSet();
        this.actionListener = new SongActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onInfoClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsSimilarFragment.this.getMenuId(), null);
                SongDetailContentsSimilarFragment.this.showContextPopupSong(playable0);
                f f0 = SongDetailContentsSimilarFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsSimilarFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = SongDetailContentsSimilarFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.F = SongDetailContentsSimilarFragment.this.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
                f0.C = String.valueOf(v + 1);
                f0.G = "melon_song_similar_base";
                f0.H = "toros";
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.L = "melon_song_similar_base";
                f0.N = "488c8fbcfbba439072";
                f0.O = "app_user_id";
                f0.P = String.valueOf(v + 1);
                f0.Q = "melon_song_similar";
                f0.R = songInfoBase0.songId;
                f0.S = SongDetailContentsSimilarFragment.this.songIds;
                f0.T = songInfoBase0.songId;
                f0.a().track();
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onPlaySongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsSimilarFragment.this.getMenuId(), null);
                SongDetailContentsSimilarFragment.this.playSong(playable0, true);
                f f0 = SongDetailContentsSimilarFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsSimilarFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f0.d = ActionKind.PlayMusic;
                f0.y = SongDetailContentsSimilarFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.F = SongDetailContentsSimilarFragment.this.getString(0x7F130D6A);  // string:tiara_click_copy_play_music "음악재생"
                f0.C = String.valueOf(v + 1);
                f0.G = "melon_song_similar_base";
                f0.H = "toros";
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.L = "melon_song_similar_base";
                f0.N = "488c8fbcfbba439072";
                f0.O = "app_user_id";
                f0.P = String.valueOf(v + 1);
                f0.Q = "melon_song_similar";
                f0.R = songInfoBase0.songId;
                f0.S = SongDetailContentsSimilarFragment.this.songIds;
                f0.T = songInfoBase0.songId;
                f0.a().track();
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongClick(View view0, SongInfoBase songInfoBase0, int v, int v1, boolean z) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                SongDetailContentsSimilarFragment.this.onItemClick(view0, v);
                if(z) {
                    f f0 = SongDetailContentsSimilarFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = SongDetailContentsSimilarFragment.this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    f0.d = ActionKind.ClickContent;
                    f0.y = SongDetailContentsSimilarFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                    f0.F = SongDetailContentsSimilarFragment.this.getString(0x7F130D95);  // string:tiara_click_copy_select_song "곡선택"
                    f0.C = String.valueOf(v1 + 1);
                    f0.G = "melon_song_similar_base";
                    f0.H = "toros";
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
                Playable playable0 = Playable.from(songInfoBase0, SongDetailContentsSimilarFragment.this.getMenuId(), null);
                SongDetailContentsSimilarFragment.access$showContextPopupSongOrInstantPlay(SongDetailContentsSimilarFragment.this, playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onThumbClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                SongDetailContentsSimilarFragment.this.showSongInfoPage(songInfoBase0.songId);
                f f0 = SongDetailContentsSimilarFragment.this.getBaseTiaraLogEventBuilder();
                f0.a = SongDetailContentsSimilarFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = SongDetailContentsSimilarFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                f0.F = SongDetailContentsSimilarFragment.this.getString(0x7F130D58);  // string:tiara_click_copy_move_song_detail "곡상세이동"
                f0.C = String.valueOf(v + 1);
                f0.G = "melon_song_similar_base";
                f0.H = "toros";
                f0.e = songInfoBase0.songId;
                f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                f0.g = songInfoBase0.songName;
                f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                f0.L = "melon_song_similar_base";
                f0.N = "488c8fbcfbba439072";
                f0.O = "app_user_id";
                f0.P = String.valueOf(v + 1);
                f0.Q = "melon_song_similar";
                f0.R = songInfoBase0.songId;
                f0.S = SongDetailContentsSimilarFragment.this.songIds;
                f0.T = songInfoBase0.songId;
                f0.a().track();
            }
        };
    }

    public static final void access$showContextPopupSongOrInstantPlay(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, Playable playable0) {
        songDetailContentsSimilarFragment0.showContextPopupSongOrInstantPlay(playable0);
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void addOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.add(viewableCheckViewHolder$OnStateChangeListener0);
        }
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
        j0 j00 = new DetailContentsSongAdapter(context0, null, this.actionListener, false, false, this);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    public static void d0(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, View view0) {
        SongDetailContentsSimilarFragment.makeHeaderView$lambda$2(songDetailContentsSimilarFragment0, view0);
    }

    public static void e0(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, S s0, boolean z) {
        SongDetailContentsSimilarFragment.makeHeaderView$lambda$4$lambda$3(songDetailContentsSimilarFragment0, s0, z);
    }

    public static void f0(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, VolleyError volleyError0) {
        SongDetailContentsSimilarFragment.onFetchStart$lambda$10(songDetailContentsSimilarFragment0, volleyError0);
    }

    public static void g0(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, View view0) {
        SongDetailContentsSimilarFragment.makeHeaderView$lambda$1(songDetailContentsSimilarFragment0, view0);
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
        return l1.e(MelonContentUris.d.buildUpon().appendPath("SIMILAR"), this.songId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public boolean isForegroundFragment() {
        return this.isForegroundFragment;
    }

    private final void makeHeaderView() {
        View view0 = this.findViewById(0x7F0A0183);  // id:btn_play_all
        if(view0 != null) {
            view0.setOnClickListener(new M(this, 0));
        }
        View view1 = this.findViewById(0x7F0A01BB);  // id:btn_shuffle
        if(view1 != null) {
            view1.setOnClickListener(new M(this, 1));
        }
        View view2 = this.findViewById(0x7F0A049E);  // id:filter_layout
        FilterLayout filterLayout0 = view2 instanceof FilterLayout ? ((FilterLayout)view2) : null;
        if(filterLayout0 != null) {
            L l0 = new L(this);
            filterLayout0.b(I.e, l0);
            filterLayout0.setCheckButtonChecked(this.mMarkedAll);
        }
    }

    private static final void makeHeaderView$lambda$1(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, View view0) {
        songDetailContentsSimilarFragment0.playAll();
        f f0 = songDetailContentsSimilarFragment0.getBaseTiaraLogEventBuilder();
        f0.a = songDetailContentsSimilarFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = songDetailContentsSimilarFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = songDetailContentsSimilarFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        f0.G = "melon_song_similar_base";
        f0.H = "toros";
        f0.e = songDetailContentsSimilarFragment0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songDetailContentsSimilarFragment0.pageMetaName;
        f0.L = "melon_song_similar_base";
        f0.N = "488c8fbcfbba439072";
        f0.O = "app_user_id";
        f0.Q = "melon_song_similar";
        f0.R = songDetailContentsSimilarFragment0.songIds;
        f0.S = songDetailContentsSimilarFragment0.songIds;
        f0.T = songDetailContentsSimilarFragment0.songId;
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$2(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, View view0) {
        songDetailContentsSimilarFragment0.playShuffleAll();
        f f0 = songDetailContentsSimilarFragment0.getBaseTiaraLogEventBuilder();
        f0.a = songDetailContentsSimilarFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = songDetailContentsSimilarFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = songDetailContentsSimilarFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        f0.G = "melon_song_similar_base";
        f0.H = "toros";
        f0.e = songDetailContentsSimilarFragment0.songId;
        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        f0.g = songDetailContentsSimilarFragment0.pageMetaName;
        f0.L = "melon_song_similar_base";
        f0.N = "488c8fbcfbba439072";
        f0.O = "app_user_id";
        f0.Q = "melon_song_similar";
        f0.R = songDetailContentsSimilarFragment0.songIds;
        f0.S = songDetailContentsSimilarFragment0.songIds;
        f0.T = songDetailContentsSimilarFragment0.songId;
        f0.a().track();
    }

    private static final void makeHeaderView$lambda$4$lambda$3(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, S s0, boolean z) {
        songDetailContentsSimilarFragment0.toggleSelectAll();
        if(songDetailContentsSimilarFragment0.mMarkedAll) {
            f f0 = songDetailContentsSimilarFragment0.getBaseTiaraLogEventBuilder();
            f0.a = songDetailContentsSimilarFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.y = songDetailContentsSimilarFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = songDetailContentsSimilarFragment0.getString(0x7F130D93);  // string:tiara_click_copy_select_all "전체선택"
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
        Params songContentsSimilarReq$Params0 = new Params();
        songContentsSimilarReq$Params0.songId = this.songId;
        songContentsSimilarReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsSongAdapter)j00).getCount() + 1;
        songContentsSimilarReq$Params0.pageSize = 30;
        RequestBuilder.newInstance(new SongContentsSimilarReq(this.getContext(), songContentsSimilarReq$Params0)).tag(this.getRequestTag()).listener(new a(18, this, i0)).errorListener(new L(this)).request();
        return true;
    }

    private static final void onFetchStart$lambda$10(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, VolleyError volleyError0) {
        songDetailContentsSimilarFragment0.performFetchError(volleyError0);
        songDetailContentsSimilarFragment0.setHeaderButtonVisibility(false);
    }

    private static final void onFetchStart$lambda$9(SongDetailContentsSimilarFragment songDetailContentsSimilarFragment0, i i0, SongContentsSimilarRes songContentsSimilarRes0) {
        if(!songDetailContentsSimilarFragment0.prepareFetchComplete(songContentsSimilarRes0)) {
            songDetailContentsSimilarFragment0.setHeaderButtonVisibility(false);
            return;
        }
        RESPONSE songContentsSimilarRes$RESPONSE0 = songContentsSimilarRes0.response;
        songDetailContentsSimilarFragment0.mMelonTiaraProperty = new s(songContentsSimilarRes$RESPONSE0.section, songContentsSimilarRes$RESPONSE0.page, songContentsSimilarRes$RESPONSE0.menuId, null);
        String s = songContentsSimilarRes$RESPONSE0.pageMetaName;
        q.f(s, "pageMetaName");
        songDetailContentsSimilarFragment0.pageMetaName = s;
        Collection collection0 = songContentsSimilarRes0.getItems();
        if(collection0 != null && !collection0.isEmpty() == 1) {
            songDetailContentsSimilarFragment0.setHeaderButtonVisibility(true);
            Collection collection1 = songContentsSimilarRes0.getItems();
            q.e(collection1, "null cannot be cast to non-null type kotlin.collections.MutableList<com.iloen.melon.net.v5x.response.DetailBaseRes.SONG>");
            songDetailContentsSimilarFragment0.setSongIds(N.b(collection1));
        }
        songDetailContentsSimilarFragment0.performFetchComplete(i0, songContentsSimilarRes0);
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void onImpLogListener(@NotNull String s, @NotNull ViewImpContent viewImpContent0) {
        q.g(s, "key");
        q.g(viewImpContent0, "viewImpContent");
        synchronized(this.tiaraViewImpMap) {
            Integer integer0 = Integer.parseInt(s);
            ViewImpContent viewImpContent1 = (ViewImpContent)this.tiaraViewImpMap.put(integer0, viewImpContent0);
        }
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
    public void onStart() {
        super.onStart();
        this.isForegroundFragment = true;
        this.startViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        this.isForegroundFragment = false;
        this.tiaraViewImpMapFlush();
        this.stopViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        String s2;
        String s1;
        m m0 = this.getMarkedList(false);
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MetaInfoAdapter");
        List list0 = ((com.iloen.melon.adapters.common.s)j00).getPlayableItems(m0.d);
        q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.playback.Playable>");
        StringBuilder stringBuilder0 = new StringBuilder();
        int v2 = ((ArrayList)list0).size();
        for(int v1 = 0; v1 < v2; ++v1) {
            int v3 = ((Playable)((ArrayList)list0).get(v1)).getSongid();
            if(v1 >= 1) {
                stringBuilder0.append(",");
            }
            stringBuilder0.append(v3);
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        switch(v) {
            case 0: {
                q.f("음악재생", "getString(...)");
                s2 = "선택재생";
                q.f("선택재생", "getString(...)");
                s1 = "음악재생";
                break;
            }
            case 1: {
                q.f("다운로드", "getString(...)");
                s2 = "선택다운";
                q.f("선택다운", "getString(...)");
                s1 = "다운로드";
                break;
            }
            case 2: {
                q.f("담기", "getString(...)");
                s2 = "선택담기";
                q.f("선택담기", "getString(...)");
                s1 = "담기";
                break;
            }
            case 14: {
                q.f("선물하기", "getString(...)");
                s2 = "선택선물";
                q.f("선택선물", "getString(...)");
                s1 = "선물하기";
                break;
            }
            default: {
                s1 = "";
                s2 = "";
            }
        }
        super.onToolBarClick(toolBar$ToolBarItem0, v);
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = s1;
        f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        f0.F = s2;
        f0.G = "melon_song_similar_base";
        f0.H = "toros";
        f0.L = "melon_song_similar_base";
        f0.N = "488c8fbcfbba439072";
        f0.O = "app_user_id";
        f0.Q = "melon_song_similar";
        f0.R = s;
        f0.S = s;
        f0.T = this.songId;
        f0.a().track();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = true;
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130A68));  // string:song_detail_contents_similar_title "유사한 곡"
        }
        this.makeHeaderView();
        if(this.getItemCount() <= 0) {
            z = false;
        }
        this.setHeaderButtonVisibility(z);
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void removeOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.remove(viewableCheckViewHolder$OnStateChangeListener0);
        }
    }

    private final void setHeaderButtonVisibility(boolean z) {
        if(this.isFragmentValid()) {
            ViewUtils.showWhen(this.findViewById(0x7F0A01BC), z);  // id:btn_shuffle_play_all
            ViewUtils.showWhen(this.findViewById(0x7F0A049B), z);  // id:filter_container
        }
    }

    private final void setSongIds(List list0) {
        if(this.songIds.length() > 0) {
            this.songIds = "";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ((SONG)list0.get(v1)).songId;
            if(v1 >= 1) {
                stringBuilder0.append(",");
            }
            stringBuilder0.append(s);
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        this.songIds = s1;
    }

    private final void startViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStart();
            }
        }
    }

    private final void stopViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStop();
            }
        }
    }

    private final void tiaraViewImpMapFlush() {
        HashMap hashMap0 = this.tiaraViewImpMap;
        __monitor_enter(hashMap0);
        try {
            if(!this.tiaraViewImpMap.isEmpty()) {
                ContentList contentList0 = new ContentList();
                for(Object object0: this.tiaraViewImpMap.values()) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.tiaraViewImpMap.clear();
                s s0 = this.mMelonTiaraProperty;
                if(s0 != null) {
                    p8.i i0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
                    i0.b = s0.a;
                    i0.c = s0.b;
                    i0.I = s0.c;
                    i0.Z = contentList0;
                    i0.Q = "melon_song_similar";
                    i0.L = "melon_song_similar_base";
                    i0.N = "488c8fbcfbba439072";
                    i0.O = "app_user_id";
                    i0.a().track();
                }
                goto label_26;
            }
            goto label_28;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(hashMap0);
        throw throwable0;
    label_26:
        __monitor_exit(hashMap0);
        return;
    label_28:
        __monitor_exit(hashMap0);
    }
}

