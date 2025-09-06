package com.iloen.melon.fragments.artistchannel;

import A7.d;
import Tf.o;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailContentsSongAdapter;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.ArtistMusicSongFilterListReq;
import com.iloen.melon.net.v6x.request.ArtistMusicSongListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistMusicSongListReq;
import com.iloen.melon.net.v6x.response.ArtistMusicSongFilterListRes.RESPONSE.FILTERLIST;
import com.iloen.melon.net.v6x.response.ArtistMusicSongFilterListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistMusicSongFilterListRes;
import com.iloen.melon.net.v6x.response.ArtistMusicSongListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import je.w;
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

@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u0019\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b \u0010\u001FJ\u000F\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\'\u00101\u001A\u00020\u00042\u0006\u0010-\u001A\u00020,2\u0006\u0010/\u001A\u00020.2\u0006\u00100\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b1\u00102J\u0017\u00103\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b5\u0010\u0003J\u0017\u00106\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b6\u00104J\u0017\u00107\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b7\u00104J\u0017\u00109\u001A\u00020\t2\u0006\u00108\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b;\u0010\u0003J\u0017\u0010=\u001A\u00020\t2\u0006\u0010<\u001A\u00020,H\u0002\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010@\u001A\u00020?2\u0006\u0010<\u001A\u00020,H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u000F\u0010B\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\bB\u0010\u0010R\u0016\u0010C\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010DR\u0016\u0010F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010G\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010DR\u0016\u0010H\u001A\u00020\u001D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001A\u00020\u001D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010IR&\u0010N\u001A\u0012\u0012\u0004\u0012\u00020L0Kj\b\u0012\u0004\u0012\u00020L`M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001A\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010TR\u0018\u0010W\u001A\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001A\u00020Y8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\\\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\\\u0010\u0006R\u0014\u0010`\u001A\u00020]8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b^\u0010_\u00A8\u0006b"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsSongFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "isRecyclerViewBelowTitleBar", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onPause", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "makeHeaderView", "(Landroid/view/View;)V", "setScrollableAlyacView", "makeShuffleAllPlayButtons", "makeAllSelectAndOrderButton", "isVisible", "setHeaderButtonVisibility", "(Z)V", "fetchFilterLevel1DataArray", "fetchType", "fetchSongList", "(Lv9/i;)V", "Lcom/iloen/melon/net/v6x/request/ArtistMusicSongListReq;", "getRequestProtocol", "(Lv9/i;)Lcom/iloen/melon/net/v6x/request/ArtistMusicSongListReq;", "getOrderType", "artistId", "Ljava/lang/String;", "artistName", "filterType", "categoryCode", "orderType", "I", "currentFilterIndex", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "filters", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "alyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "shuffleAndAllPlayButtons", "Landroid/view/View;", "allSelectAndOrderButton", "Landroid/widget/TextView;", "orderButton", "Landroid/widget/TextView;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "isHeaderButtonVisible", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsSongFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005H\u0007J$\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u0005J.\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_FILTER_TYPE", "ARG_ORDER_TYPE", "ARG_CATEGORY_CODE", "ORDER_TYPE_NEW", "", "ORDER_TYPE_POP", "ORDER_TYPE_ALPHABET", "UNKNOWN_INDEX", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsSongFragment;", "artistId", "artistName", "filterLevel1Type", "categoryCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsSongFragment newInstance(@Nullable String s, @Nullable String s1) {
            ArtistDetailContentsSongFragment artistDetailContentsSongFragment0 = new ArtistDetailContentsSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            bundle0.putString("argArtistName", s1);
            artistDetailContentsSongFragment0.setArguments(bundle0);
            return artistDetailContentsSongFragment0;
        }

        @NotNull
        public final ArtistDetailContentsSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2) {
            ArtistDetailContentsSongFragment artistDetailContentsSongFragment0 = new ArtistDetailContentsSongFragment();
            Bundle bundle0 = Y.c("argArtistId", s, "argArtistName", s1);
            bundle0.putString("argFilterType", s2);
            artistDetailContentsSongFragment0.setArguments(bundle0);
            return artistDetailContentsSongFragment0;
        }

        @NotNull
        public final ArtistDetailContentsSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            ArtistDetailContentsSongFragment artistDetailContentsSongFragment0 = new ArtistDetailContentsSongFragment();
            Bundle bundle0 = Y.c("argArtistId", s, "argArtistName", s1);
            bundle0.putString("argFilterType", s2);
            bundle0.putString("argCategoryCode", s3);
            artistDetailContentsSongFragment0.setArguments(bundle0);
            return artistDetailContentsSongFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_CATEGORY_CODE = "argCategoryCode";
    @NotNull
    private static final String ARG_FILTER_TYPE = "argFilterType";
    @NotNull
    private static final String ARG_ORDER_TYPE = "argOrderType";
    @NotNull
    public static final Companion Companion = null;
    public static final int ORDER_TYPE_ALPHABET = 2;
    public static final int ORDER_TYPE_NEW = 0;
    public static final int ORDER_TYPE_POP = 1;
    @NotNull
    private static final String TAG = "ArtistDetailContentsSongFragment";
    private static final int UNKNOWN_INDEX = -1;
    @NotNull
    private final SongActionListener actionListener;
    @Nullable
    private View allSelectAndOrderButton;
    @Nullable
    private ScrollableAlyacFilter alyacFilter;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private String categoryCode;
    private int currentFilterIndex;
    @NotNull
    private String filterType;
    @NotNull
    private ArrayList filters;
    @Nullable
    private TextView orderButton;
    private int orderType;
    @Nullable
    private View shuffleAndAllPlayButtons;

    static {
        ArtistDetailContentsSongFragment.Companion = new Companion(null);
        ArtistDetailContentsSongFragment.$stable = 8;
    }

    public ArtistDetailContentsSongFragment() {
        this.artistId = "";
        this.artistName = "";
        this.filterType = "";
        this.categoryCode = "";
        this.currentFilterIndex = -1;
        this.filters = new ArrayList();
        this.actionListener = new SongActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onInfoClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, ArtistDetailContentsSongFragment.this.getMenuId(), null);
                ArtistDetailContentsSongFragment.this.showContextPopupSong(playable0);
                if(ArtistDetailContentsSongFragment.this.mMelonTiaraProperty != null) {
                    f f0 = ArtistDetailContentsSongFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = ArtistDetailContentsSongFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistDetailContentsSongFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                    f0.F = ArtistDetailContentsSongFragment.this.getString(0x7F130E2D);  // string:tiara_common_layer2_more "더보기"
                    f0.C = String.valueOf(v + 1);
                    f0.e = songInfoBase0.songId;
                    f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f0.g = songInfoBase0.songName;
                    f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onPlaySongClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                Playable playable0 = Playable.from(songInfoBase0, ArtistDetailContentsSongFragment.this.getMenuId(), null);
                ArtistDetailContentsSongFragment.this.playSong(playable0, true);
                if(ArtistDetailContentsSongFragment.access$getMMelonTiaraProperty$p$s-257913481(ArtistDetailContentsSongFragment.this) != null) {
                    f f0 = ArtistDetailContentsSongFragment.access$getBaseTiaraLogEventBuilder(ArtistDetailContentsSongFragment.this);
                    f0.a = ArtistDetailContentsSongFragment.this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                    f0.d = ActionKind.PlayMusic;
                    f0.y = ArtistDetailContentsSongFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                    f0.C = String.valueOf(v + 1);
                    f0.e = songInfoBase0.songId;
                    f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f0.g = songInfoBase0.songName;
                    f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                    f0.a().track();
                }
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onSongClick(View view0, SongInfoBase songInfoBase0, int v, int v1, boolean z) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                ArtistDetailContentsSongFragment.this.onItemClick(view0, v);
                if(z && ArtistDetailContentsSongFragment.access$getMMelonTiaraProperty$p$s-257913481(ArtistDetailContentsSongFragment.this) != null) {
                    f f0 = ArtistDetailContentsSongFragment.access$getBaseTiaraLogEventBuilder(ArtistDetailContentsSongFragment.this);
                    f0.a = ArtistDetailContentsSongFragment.this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistDetailContentsSongFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
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
                Playable playable0 = Playable.from(songInfoBase0, ArtistDetailContentsSongFragment.this.getMenuId(), null);
                ArtistDetailContentsSongFragment.this.showContextPopupSongOrInstantPlay(playable0);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder$SongActionListener
            public void onThumbClick(View view0, SongInfoBase songInfoBase0, int v) {
                q.g(view0, "view");
                q.g(songInfoBase0, "item");
                ArtistDetailContentsSongFragment.this.showAlbumInfoPage(songInfoBase0);
                if(ArtistDetailContentsSongFragment.this.mMelonTiaraProperty != null) {
                    f f0 = ArtistDetailContentsSongFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = ArtistDetailContentsSongFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistDetailContentsSongFragment.this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                    f0.C = String.valueOf(v + 1);
                    f0.e = songInfoBase0.songId;
                    f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                    f0.g = songInfoBase0.songName;
                    f0.h = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
                    f0.a().track();
                }
            }
        };
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D002F, null, false);  // layout:alyac_filter_toggle
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 1000);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new DetailContentsSongAdapter(context0, null, this.actionListener, false, false, null, 56, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    private final void fetchFilterLevel1DataArray() {
        this.filters.clear();
        RequestBuilder.newInstance(new ArtistMusicSongFilterListReq(this.getContext(), this.artistId)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.artistchannel.f(this, 3)).errorListener(new com.iloen.melon.fragments.artistchannel.f(this, 4)).request();
    }

    private static final void fetchFilterLevel1DataArray$lambda$16(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, ArtistMusicSongFilterListRes artistMusicSongFilterListRes0) {
        q.g(artistMusicSongFilterListRes0, "response");
        boolean z = artistDetailContentsSongFragment0.isFragmentValid();
        i i0 = i.b;
        if(z) {
            Cb.j.b(artistMusicSongFilterListRes0.notification, false, 3);
            if(Cb.j.d(artistMusicSongFilterListRes0)) {
                RESPONSE artistMusicSongFilterListRes$RESPONSE0 = artistMusicSongFilterListRes0.response;
                if(artistMusicSongFilterListRes$RESPONSE0 != null && (artistMusicSongFilterListRes$RESPONSE0.filterList != null && !artistMusicSongFilterListRes$RESPONSE0.filterList.isEmpty() == 1)) {
                    ArrayList arrayList0 = artistMusicSongFilterListRes$RESPONSE0.filterList;
                    q.f(arrayList0, "filterList");
                    for(Object object0: arrayList0) {
                        ArrayList arrayList1 = artistDetailContentsSongFragment0.filters;
                        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j0.b = ((FILTERLIST)object0).filterName;
                        j0.d = ((FILTERLIST)object0).filterCode;
                        j0.c = ((FILTERLIST)object0).categoryCode;
                        arrayList1.add(j0);
                    }
                    if(o.H0(artistDetailContentsSongFragment0.filterType)) {
                        artistDetailContentsSongFragment0.currentFilterIndex = 0;
                        String s = ((v9.j)artistDetailContentsSongFragment0.filters.get(0)).d;
                        q.f(s, "type");
                        artistDetailContentsSongFragment0.filterType = s;
                        if("TR".equals(s)) {
                            String s1 = ((v9.j)artistDetailContentsSongFragment0.filters.get(artistDetailContentsSongFragment0.currentFilterIndex)).c;
                            q.f(s1, "code");
                            artistDetailContentsSongFragment0.categoryCode = s1;
                        }
                    }
                    else if("TR".equals(artistDetailContentsSongFragment0.filterType)) {
                        int v = 0;
                        for(Object object1: artistDetailContentsSongFragment0.filters) {
                            if(v >= 0) {
                                if(q.b(artistDetailContentsSongFragment0.categoryCode, ((v9.j)object1).c)) {
                                    artistDetailContentsSongFragment0.currentFilterIndex = v;
                                }
                                ++v;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                    }
                    else {
                        int v1 = 0;
                        for(Object object2: artistDetailContentsSongFragment0.filters) {
                            if(v1 >= 0) {
                                if(q.b(artistDetailContentsSongFragment0.filterType, ((v9.j)object2).d)) {
                                    artistDetailContentsSongFragment0.currentFilterIndex = v1;
                                }
                                ++v1;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                    }
                    if(artistDetailContentsSongFragment0.currentFilterIndex <= -1) {
                        artistDetailContentsSongFragment0.currentFilterIndex = 0;
                        String s2 = ((v9.j)artistDetailContentsSongFragment0.filters.get(0)).d;
                        q.f(s2, "type");
                        artistDetailContentsSongFragment0.filterType = s2;
                        if("TR".equals(s2)) {
                            String s3 = ((v9.j)artistDetailContentsSongFragment0.filters.get(artistDetailContentsSongFragment0.currentFilterIndex)).c;
                            q.f(s3, "code");
                            artistDetailContentsSongFragment0.categoryCode = s3;
                        }
                    }
                }
                artistDetailContentsSongFragment0.fetchSongList(i0);
                artistDetailContentsSongFragment0.setScrollableAlyacView();
                return;
            }
        }
        artistDetailContentsSongFragment0.fetchSongList(i0);
    }

    private static final void fetchFilterLevel1DataArray$lambda$17(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, VolleyError volleyError0) {
        a.v("fetchFilterLevel1DataArray() >> onErrorResponse() ", HttpResponse.Companion.getErrorMessage(volleyError0), LogU.Companion, "ArtistDetailContentsSongFragment");
        artistDetailContentsSongFragment0.fetchSongList(i.b);
    }

    private final void fetchSongList(i i0) {
        RequestBuilder.newInstance(this.getRequestProtocol(i0)).tag(this.getRequestTag()).listener(new c(8, this, i0)).errorListener(new com.iloen.melon.fragments.artistchannel.f(this, 1)).request();
    }

    private static final void fetchSongList$lambda$19(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, i i0, ArtistMusicSongListRes artistMusicSongListRes0) {
        q.g(artistMusicSongListRes0, "response");
        if(!artistDetailContentsSongFragment0.prepareFetchComplete(artistMusicSongListRes0)) {
            artistDetailContentsSongFragment0.setHeaderButtonVisibility(true);
            return;
        }
        com.iloen.melon.net.v6x.response.ArtistMusicSongListRes.RESPONSE artistMusicSongListRes$RESPONSE0 = artistMusicSongListRes0.response;
        if(artistMusicSongListRes$RESPONSE0 != null && (artistMusicSongListRes$RESPONSE0.songlist != null && !artistMusicSongListRes$RESPONSE0.songlist.isEmpty() == 1)) {
            artistDetailContentsSongFragment0.setHeaderButtonVisibility(true);
        }
        if(artistMusicSongListRes$RESPONSE0 != null) {
            artistDetailContentsSongFragment0.mMelonTiaraProperty = new s(artistMusicSongListRes$RESPONSE0.section, artistMusicSongListRes$RESPONSE0.page, "", null);
        }
        artistDetailContentsSongFragment0.performFetchComplete(i0, artistMusicSongListRes0);
    }

    private static final void fetchSongList$lambda$20(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, VolleyError volleyError0) {
        artistDetailContentsSongFragment0.performFetchError(volleyError0);
        artistDetailContentsSongFragment0.setHeaderButtonVisibility(false);
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.mMelonTiaraProperty.c;
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.artistId;
        f0.p = this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
        f0.q = this.artistName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.b.buildUpon().appendPath(this.artistId).appendPath("SONG").appendQueryParameter("filterType", this.filterType).appendQueryParameter("orderType", String.valueOf(this.orderType)), "categoryCode", this.categoryCode, "toString(...)");
    }

    private final String getOrderType() {
        switch(this.orderType) {
            case 1: {
                return "POP";
            }
            case 2: {
                return "ALPHABET";
            }
            default: {
                return "NEW";
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return this.isHeaderButtonVisible() ? ScreenUtils.dipToPixel(this.getContext(), 106.0f) : 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        if(this.isHeaderButtonVisible()) {
            return ScreenUtils.dipToPixel(this.getContext(), 168.0f);
        }
        return this.getContext() == null ? 0 : this.getResources().getDimensionPixelSize(0x7F0703F3);  // dimen:new_scrollable_alyac_filter_height
    }

    private final ArtistMusicSongListReq getRequestProtocol(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsSongAdapter");
        Params artistMusicSongListReq$Params0 = new Params();
        artistMusicSongListReq$Params0.artistId = this.artistId;
        artistMusicSongListReq$Params0.startIndex = i.b.equals(i0) ? 1 : ((DetailContentsSongAdapter)j00).getCount() + 1;
        artistMusicSongListReq$Params0.pageSize = 100;
        artistMusicSongListReq$Params0.filterBy = this.filterType;
        if(!"RS".equals(this.filterType) && !"TR".equals(artistMusicSongListReq$Params0.filterBy)) {
            artistMusicSongListReq$Params0.orderBy = this.getOrderType();
        }
        if("TR".equals(artistMusicSongListReq$Params0.filterBy)) {
            artistMusicSongListReq$Params0.categoryCode = this.categoryCode;
        }
        String s = artistMusicSongListReq$Params0.categoryCode;
        StringBuilder stringBuilder0 = d.o("getRequestProtocal() >> filterBy: ", artistMusicSongListReq$Params0.filterBy, ", orderBy: ", artistMusicSongListReq$Params0.orderBy, ", categoryCode: ");
        stringBuilder0.append(s);
        LogU.Companion.i("ArtistDetailContentsSongFragment", stringBuilder0.toString());
        return new ArtistMusicSongListReq(this.getContext(), artistMusicSongListReq$Params0);
    }

    private final boolean isHeaderButtonVisible() {
        return this.allSelectAndOrderButton != null && this.allSelectAndOrderButton.getVisibility() == 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public boolean isRecyclerViewBelowTitleBar() {
        return true;
    }

    private final void makeAllSelectAndOrderButton(View view0) {
        String[] arr_s;
        View view1 = view0.findViewById(0x7F0A049B);  // id:filter_container
        this.allSelectAndOrderButton = view1;
        CharSequence charSequence0 = null;
        FilterLayout filterLayout0 = view1 == null ? null : ((FilterLayout)view1.findViewById(0x7F0A049E));  // id:filter_layout
        if(filterLayout0 != null) {
            com.iloen.melon.fragments.artistchannel.f f0 = new com.iloen.melon.fragments.artistchannel.f(this, 2);
            filterLayout0.b(I.e, f0);
        }
        this.orderButton = (TextView)view0.findViewById(0x7F0A0499);  // id:filter_btn
        Context context0 = this.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030002);  // array:artist_channel_album_tab_filter_level2
        }
        List list0 = arr_s == null ? w.a : k.A(Arrays.copyOf(arr_s, arr_s.length));
        String s = (String)list0.get(this.orderType);
        TextView textView0 = this.orderButton;
        if(textView0 != null) {
            textView0.setText(s);
        }
        TextView textView1 = this.orderButton;
        if(textView1 != null) {
            charSequence0 = textView1.getText();
        }
        ViewUtils.setContentDescriptionWithButtonClassName(textView1, this.getString(0x7F130BAF, new Object[]{charSequence0}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
        TextView textView2 = this.orderButton;
        if(textView2 != null) {
            textView2.setOnClickListener(new com.iloen.melon.fragments.artistchannel.j(3, this, list0));
        }
    }

    private static final void makeAllSelectAndOrderButton$lambda$5(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, S s0, boolean z) {
        artistDetailContentsSongFragment0.toggleSelectAll();
        if(artistDetailContentsSongFragment0.mMarkedAll && artistDetailContentsSongFragment0.mMelonTiaraProperty != null) {
            f f0 = artistDetailContentsSongFragment0.getBaseTiaraLogEventBuilder();
            f0.a = artistDetailContentsSongFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailContentsSongFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = artistDetailContentsSongFragment0.getString(0x7F130E36);  // string:tiara_common_layer2_select_all "전체선택"
            f0.a().track();
        }
    }

    private static final void makeAllSelectAndOrderButton$lambda$8(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, List list0, View view0) {
        FragmentActivity fragmentActivity0 = artistDetailContentsSongFragment0.getActivity();
        if(fragmentActivity0 == null || !artistDetailContentsSongFragment0.isPossiblePopupShow()) {
            return;
        }
        BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
        bottomSingleFilterListPopup0.setTitle("정렬");
        bottomSingleFilterListPopup0.setFilterItem(list0, artistDetailContentsSongFragment0.orderType);
        bottomSingleFilterListPopup0.setFilterListener(new e(list0, artistDetailContentsSongFragment0, fragmentActivity0, 5));
        bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsSongFragment0.mDialogDismissListener);
        artistDetailContentsSongFragment0.mRetainDialog = bottomSingleFilterListPopup0;
        bottomSingleFilterListPopup0.show();
    }

    private static final void makeAllSelectAndOrderButton$lambda$8$lambda$7$lambda$6(List list0, ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, FragmentActivity fragmentActivity0, int v) {
        String s = (String)list0.get(v);
        artistDetailContentsSongFragment0.orderType = v;
        TextView textView0 = artistDetailContentsSongFragment0.orderButton;
        if(textView0 != null) {
            textView0.setText(s);
        }
        ViewUtils.setContentDescriptionWithButtonClassName(artistDetailContentsSongFragment0.orderButton, artistDetailContentsSongFragment0.getString(0x7F130BAF, new Object[]{(artistDetailContentsSongFragment0.orderButton == null ? null : artistDetailContentsSongFragment0.orderButton.getText())}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
        artistDetailContentsSongFragment0.startFetch("filter change");
        if(artistDetailContentsSongFragment0.mMelonTiaraProperty != null) {
            f f0 = artistDetailContentsSongFragment0.getBaseTiaraLogEventBuilder();
            f0.a = "페이지이동";
            f0.d = ActionKind.ClickContent;
            f0.y = "곡리스트";
            f0.F = s;
            f0.a().track();
        }
    }

    private final void makeHeaderView(View view0) {
        this.setScrollableAlyacView();
        this.makeShuffleAllPlayButtons(view0);
        this.makeAllSelectAndOrderButton(view0);
    }

    private final void makeShuffleAllPlayButtons(View view0) {
        this.shuffleAndAllPlayButtons = view0.findViewById(0x7F0A01BC);  // id:btn_shuffle_play_all
        View view1 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        if(view1 != null) {
            view1.setOnClickListener(new com.iloen.melon.fragments.artistchannel.g(this, 0));
        }
        View view2 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        if(view2 != null) {
            view2.setOnClickListener(new com.iloen.melon.fragments.artistchannel.g(this, 1));
        }
    }

    private static final void makeShuffleAllPlayButtons$lambda$3(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, View view0) {
        if(artistDetailContentsSongFragment0.getItemCount() > 0) {
            artistDetailContentsSongFragment0.playShuffleAll();
        }
        else {
            ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        }
        if(artistDetailContentsSongFragment0.mMelonTiaraProperty != null) {
            f f0 = artistDetailContentsSongFragment0.getBaseTiaraLogEventBuilder();
            f0.a = artistDetailContentsSongFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = artistDetailContentsSongFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = artistDetailContentsSongFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
            f0.a().track();
        }
    }

    private static final void makeShuffleAllPlayButtons$lambda$4(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, View view0) {
        if(artistDetailContentsSongFragment0.getItemCount() > 0) {
            artistDetailContentsSongFragment0.playAll();
        }
        else {
            ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        }
        if(artistDetailContentsSongFragment0.mMelonTiaraProperty != null) {
            f f0 = artistDetailContentsSongFragment0.getBaseTiaraLogEventBuilder();
            f0.a = artistDetailContentsSongFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = artistDetailContentsSongFragment0.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = artistDetailContentsSongFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
            f0.a().track();
        }
    }

    @NotNull
    public static final ArtistDetailContentsSongFragment newInstance(@Nullable String s, @Nullable String s1) {
        return ArtistDetailContentsSongFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.alyacFilter;
        if(scrollableAlyacFilter0 != null) {
            scrollableAlyacFilter0.c(this.currentFilterIndex);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setPadding(0, ScreenUtils.dipToPixel(((RecyclerView)view0).getContext(), -1.0f), 0, 0);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(i.b.equals(i0)) {
            this.setHeaderButtonVisibility(false);
            this.clearListItems();
            if(this.filters.isEmpty()) {
                this.fetchFilterLevel1DataArray();
                return true;
            }
            this.fetchSongList(i0);
            return true;
        }
        this.fetchSongList(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        if(bundle0.containsKey("argArtistId")) {
            String s = bundle0.getString("argArtistId", "");
            q.f(s, "getString(...)");
            this.artistId = s;
        }
        if(bundle0.containsKey("argFilterType")) {
            String s1 = bundle0.getString("argFilterType", "");
            q.f(s1, "getString(...)");
            this.filterType = s1;
        }
        if(bundle0.containsKey("argOrderType")) {
            this.orderType = bundle0.getInt("argOrderType", 0);
        }
        if(bundle0.containsKey("argArtistName")) {
            String s2 = bundle0.getString("argArtistName", "");
            q.f(s2, "getString(...)");
            this.artistName = s2;
        }
        if(bundle0.containsKey("argCategoryCode")) {
            String s3 = bundle0.getString("argCategoryCode", "");
            q.f(s3, "getString(...)");
            this.categoryCode = s3;
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
        bundle0.putString("argFilterType", this.filterType);
        bundle0.putInt("argOrderType", this.orderType);
        bundle0.putString("argCategoryCode", this.categoryCode);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = true;
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F13012C));  // string:artist_detail_contents_song_title "곡"
        }
        View view1 = this.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.tablayout.ScrollableAlyacFilter");
        this.alyacFilter = (ScrollableAlyacFilter)view1;
        this.makeHeaderView(view0);
        int v = 0;
        if(this.getItemCount() <= 0) {
            z = false;
        }
        this.setHeaderButtonVisibility(z);
        View view2 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view2;
        if(view2 != null) {
            if(this.getItemCount() != 0) {
                v = 8;
            }
            view2.setVisibility(v);
        }
    }

    private final void setHeaderButtonVisibility(boolean z) {
        if(this.isFragmentValid() && this.isHeaderButtonVisible() != z) {
            View view0 = this.allSelectAndOrderButton;
            int v = 8;
            if(view0 != null) {
                view0.setVisibility((z ? 0 : 8));
            }
            View view1 = this.shuffleAndAllPlayButtons;
            if(view1 != null) {
                view1.setVisibility((z ? 0 : 8));
            }
            boolean z1 = !"RS".equals(this.filterType) && !"TR".equals(this.filterType);
            TextView textView0 = this.orderButton;
            if(textView0 != null) {
                if(z && z1) {
                    v = 0;
                }
                textView0.setVisibility(v);
            }
            this.onUpdateParallaxHeader();
        }
    }

    private final void setScrollableAlyacView() {
        if(!this.filters.isEmpty()) {
            ScrollableAlyacFilter scrollableAlyacFilter0 = this.alyacFilter;
            if(scrollableAlyacFilter0 != null) {
                scrollableAlyacFilter0.setPadding(ScreenUtils.dipToPixel(scrollableAlyacFilter0.getContext(), 20.0f));
                scrollableAlyacFilter0.d(this.filters);
                scrollableAlyacFilter0.setSelectedIndex(this.currentFilterIndex);
                scrollableAlyacFilter0.e(new com.iloen.melon.fragments.artistchannel.f(this, 0), new E8.c());  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
    }

    private static final void setScrollableAlyacView$lambda$2$lambda$1(ArtistDetailContentsSongFragment artistDetailContentsSongFragment0, int v) {
        if(artistDetailContentsSongFragment0.currentFilterIndex != v) {
            artistDetailContentsSongFragment0.currentFilterIndex = v;
            String s = ((v9.j)artistDetailContentsSongFragment0.filters.get(v)).d;
            q.f(s, "type");
            artistDetailContentsSongFragment0.filterType = s;
            String s1 = ((v9.j)artistDetailContentsSongFragment0.filters.get(artistDetailContentsSongFragment0.currentFilterIndex)).c;
            q.f(s1, "code");
            artistDetailContentsSongFragment0.categoryCode = s1;
            artistDetailContentsSongFragment0.startFetch("alyac change");
            if(artistDetailContentsSongFragment0.mMelonTiaraProperty != null) {
                f f0 = artistDetailContentsSongFragment0.getBaseTiaraLogEventBuilder();
                f0.a = artistDetailContentsSongFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = artistDetailContentsSongFragment0.getString(0x7F130E02);  // string:tiara_common_layer1_page_menu "Pagemenu"
                f0.F = ((v9.j)artistDetailContentsSongFragment0.filters.get(v)).b;
                f0.a().track();
            }
        }
    }
}

