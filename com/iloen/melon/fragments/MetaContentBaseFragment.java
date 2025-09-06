package com.iloen.melon.fragments;

import Cb.j;
import E9.u;
import Gd.F;
import Ub.t;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.ListMarker;
import com.iloen.melon.adapters.common.h;
import com.iloen.melon.adapters.common.q;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaylist.EventDeleteSong;
import com.iloen.melon.fragments.detail.DetailLikePersonListFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.melonchart.MelonChartReportBottomSheetFragment;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.request.PostSongKakaoBadgeReq;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.response.PostSongKakaoBadgeRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.request.ForUInformForUMixContsPlayReq;
import com.iloen.melon.net.v5x.request.MyMusicPlaylistListSongReq;
import com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq.Params;
import com.iloen.melon.net.v5x.response.ForUInformForUMixContsPlayRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ForUInformForUMixContsPlayRes;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.net.v6x.request.DjPlaylistDeleteReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistDeleteReq;
import com.iloen.melon.net.v6x.response.DjPlaylistDeleteRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistDeleteRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist;
import com.iloen.melon.player.playlist.tiara.ToolbarTiaraLogHelper;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.popup.PopupClickLogHelper;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.SharableArtistPlaylist;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharableMv;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.sns.model.a;
import com.iloen.melon.sns.model.c;
import com.iloen.melon.task.request.PostImageAsyncCoroutine.OnPostImageAsyncCoroutineListener;
import com.iloen.melon.task.request.PostImageAsyncCoroutine;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.C1;
import com.melon.ui.D1;
import com.melon.ui.G1;
import com.melon.ui.H1;
import com.melon.ui.J1;
import com.melon.ui.K1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.X1;
import com.melon.ui.Y1;
import com.melon.ui.a2;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.k2;
import com.melon.ui.popup.b;
import com.melon.ui.popup.context.more.ExtraProperties.Link;
import com.melon.ui.w1;
import com.melon.ui.x1;
import com.melon.ui.y1;
import com.melon.ui.z1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import p8.O;
import pc.l1;
import pc.n1;
import v9.m;
import va.e0;
import va.o;
import vd.E;
import zd.A0;
import zd.M;
import zd.Q;
import zd.d;
import zd.g;
import zd.p0;
import zd.u0;

public abstract class MetaContentBaseFragment extends FetcherBaseFragment {
    protected static final String ARG_ITEM_ID = "argItemId";
    protected static final String ARG_TAB_TYPE = "argTabType";
    private static final String TAG = "MetaContentBaseFragment";
    private int TYPE_REPORT;
    protected static final int TYPE_SNS;
    private InstantPlayPopup instantPlayPopup;

    public MetaContentBaseFragment() {
        this.instantPlayPopup = null;
        this.TYPE_REPORT = 0;
    }

    public static H K() {
        return null;
    }

    public static H L() {
        return null;
    }

    public static void N(VolleyError volleyError0) {
        MetaContentBaseFragment.lambda$deletePlayList$16(volleyError0);
    }

    public static H Q() {
        return null;
    }

    public static H R(MetaContentBaseFragment metaContentBaseFragment0, Playable playable0, k2 k20) {
        return metaContentBaseFragment0.lambda$showContextPopupAlbum$4(playable0, k20);
    }

    public static void S(VolleyError volleyError0) {
        MetaContentBaseFragment.lambda$deleteDjPlayList$11(volleyError0);
    }

    public static H T(MetaContentBaseFragment metaContentBaseFragment0, Playable playable0, k2 k20) {
        return metaContentBaseFragment0.lambda$showContextPopupMv$18(playable0, k20);
    }

    public static H V() {
        return null;
    }

    public static H Y(MetaContentBaseFragment metaContentBaseFragment0, Playable playable0, k2 k20) {
        return metaContentBaseFragment0.lambda$showContextPopupSong$1(playable0, k20);
    }

    public static H Z() {
        return null;
    }

    public static H c0() {
        return null;
    }

    private void deleteDjPlayList(String s, String s1) {
        LogU.d("MetaContentBaseFragment", "deleteDjPlayList() playlistId:" + s + " playlistName:" + s1);
        RequestBuilder.newInstance(new DjPlaylistDeleteReq(this.getContext(), s)).tag(this.getRequestTag()).listener(new y(this, s, 0)).errorListener(new B(1)).request();
    }

    private void deletePlayList(String s, String s1) {
        LogU.d("MetaContentBaseFragment", "deletePlayList() playlistId:" + s + " playlistName:" + s1);
        RequestBuilder.newInstance(new MyMusicPlaylistDeleteReq(this.getContext(), s)).tag(this.getRequestTag()).listener(new y(this, s, 1)).errorListener(new B(0)).request();
    }

    public void downloadFlacSongs() {
        LogU.d("MetaContentBaseFragment", "downloadFlacSongs()");
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "downloadFlacSongs() invalid adapter");
            return;
        }
        List list0 = ((s)object0).getMarkedPlayableItems();
        if(list0 != null && !list0.isEmpty()) {
            this.downloadFlacSongs("", "", list0);
            return;
        }
        LogU.w("MetaContentBaseFragment", "downloadFlacSongs() invalid playables");
    }

    public void downloadMv() {
        LogU.d("MetaContentBaseFragment", "downloadMv()");
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "downloadMv() invalid adapter");
            return;
        }
        List list0 = ((s)object0).getMarkedPlayableItems();
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() > 1) {
                l0 l00 = this.getChildFragmentManager();
                String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                String s1 = this.getString(0x7F1300E3);  // string:alert_message_mv_download_limit "뮤직비디오는 한 곡씩 다운로드가 가능합니다."
                b.a.c(l00, s, s1);
                return;
            }
            this.setSelectAllWithToolbar(false);
            Playable playable0 = (Playable)list0.get(0);
            this.downloadMv(playable0.getMenuid(), playable0);
            return;
        }
        LogU.d("MetaContentBaseFragment", "downloadMv() invalid playables");
    }

    public void downloadSongs() {
        LogU.d("MetaContentBaseFragment", "downloadSongs()");
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "downloadSongs() invalid adapter");
            return;
        }
        List list0 = ((s)object0).getMarkedPlayableItems();
        if(list0 != null && !list0.isEmpty()) {
            this.downloadSongs(((Playable)list0.get(0)).getMenuid(), list0);
            return;
        }
        LogU.w("MetaContentBaseFragment", "downloadSongs() invalid playables");
    }

    // 去混淆评级： 低(25)
    public void fragmentVisibilityChanged(boolean z) {
        if(z && !this.mVisibleWhenActivate) {
            TimeExpiredCache.getInstance().hasKey("");
            j0 j00 = this.getAdapter();
            if(j00 instanceof com.iloen.melon.adapters.common.B) {
                ((com.iloen.melon.adapters.common.B)j00).isExpired("", 300000L);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public m getAllItemsWithoutRecommend() {
        Object object0 = this.getContentAdapter();
        return object0 instanceof s ? ((s)object0).getAllWithoutRecommend() : super.getAllItemsWithoutRecommend();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public m getMarkedList(boolean z) {
        Object object0 = this.getContentAdapter();
        return object0 instanceof s ? ((s)object0).getMarkedList(z) : super.getMarkedList(z);
    }

    public final Sharable getSharableAlbumData(Playable playable0, String s, String s1) {
        if(playable0 != null) {
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.a = true;
            a0.b = "";
            a0.c = "";
            a0.d = s;
            a0.e = s1;
            a0.g = "";
            a0.f = "";
            return new SharableAlbum(a0);
        }
        return null;
    }

    public final Sharable getSharableArtistPlaylistData(ArtistPlayListInfoBase artistPlayListInfoBase0, String s, String s1) {
        if(artistPlayListInfoBase0 != null) {
            com.iloen.melon.sns.model.b b0 = new com.iloen.melon.sns.model.b();  // 初始化器: Lcom/iloen/melon/sns/model/c;-><init>()V
            b0.j = artistPlayListInfoBase0.artistId;
            b0.k = artistPlayListInfoBase0.ownernickname;
            b0.a = artistPlayListInfoBase0.plylstseq;
            b0.e = artistPlayListInfoBase0.plylsttitle;
            b0.h = artistPlayListInfoBase0.songcnt;
            b0.b = s;
            b0.c = s1;
            return new SharableArtistPlaylist(b0);
        }
        return null;
    }

    public final Sharable getSharableDJCollectionData(DjPlayListInfoBase djPlayListInfoBase0, String s, String s1) {
        if(djPlayListInfoBase0 != null) {
            c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.a = djPlayListInfoBase0.plylstseq;
            c0.b = djPlayListInfoBase0.plylsttitle;
            c0.c = djPlayListInfoBase0.ownernickname;
            c0.d = djPlayListInfoBase0.ownermemberkey;
            c0.e = djPlayListInfoBase0.songcnt;
            c0.f = s;
            c0.g = s1;
            return new SharableDJCollection(c0);
        }
        return null;
    }

    public final Sharable getSharableMvData(Playable playable0, String s, String s1) {
        if(playable0 != null) {
            Sharable sharable0 = new SharableMv();  // 初始化器: Ljava/lang/Object;-><init>()V
            sharable0.a = "";
            sharable0.b = "";
            sharable0.d = "";
            sharable0.e = s;
            sharable0.f = s1;
            sharable0.g = "";
            sharable0.h = null;
            sharable0.i = false;
            return sharable0;
        }
        return null;
    }

    public final Sharable getSharablePlaylistData(ArtistPlayListInfoBase artistPlayListInfoBase0, String s, String s1) {
        if(artistPlayListInfoBase0 != null) {
            c c0 = new c();
            c0.a = artistPlayListInfoBase0.plylstseq;
            c0.b = s;
            c0.c = s1;
            c0.d = artistPlayListInfoBase0.ownermemberkey;
            c0.e = artistPlayListInfoBase0.plylsttitle;
            c0.f = artistPlayListInfoBase0.ownernickname;
            c0.g = artistPlayListInfoBase0.dpdate;
            return new SharablePlaylist(c0);
        }
        return null;
    }

    public final Sharable getSharableSongData(Playable playable0, String s, String s1) {
        if(playable0 != null) {
            u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
            u0.a = Integer.toString(playable0.getSongid());
            u0.b = "";
            u0.c = "";
            u0.d = s;
            u0.e = s1;
            u0.f = "";
            return new SharableSong(u0);
        }
        return null;
    }

    private void lambda$deleteDjPlayList$10(String s, DjPlaylistDeleteRes djPlaylistDeleteRes0) {
        if(this.isFragmentValid()) {
            j.a(djPlaylistDeleteRes0.notification, true);
            if(j.d(djPlaylistDeleteRes0)) {
                EventBusHelper.post(new EventDeleteSong(s, null));
                this.startFetch("after delete");
            }
        }
    }

    private static void lambda$deleteDjPlayList$11(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private void lambda$deletePlayList$15(String s, MyMusicPlaylistDeleteRes myMusicPlaylistDeleteRes0) {
        if(this.isFragmentValid()) {
            j.a(myMusicPlaylistDeleteRes0.notification, true);
            if(j.d(myMusicPlaylistDeleteRes0)) {
                EventBusHelper.post(new EventDeleteSong(s, null));
                this.startFetch("after delete");
            }
        }
    }

    private static void lambda$deletePlayList$16(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static H lambda$showContextPopupAlbum$3() [...] // Inlined contents

    private H lambda$showContextPopupAlbum$4(Playable playable0, k2 k20) {
        if(k20 instanceof J1) {
            Navigator.open(DetailLikePersonListFragment.newInstance("N10002", "N20001", ""));
            return null;
        }
        if(k20 instanceof X1) {
            this.shareData(playable0, "N10002");
            return null;
        }
        if(k20 instanceof w1) {
            this.showAlbumInfoPage(playable0);
            return null;
        }
        if(k20 instanceof x1) {
            this.showArtistInfoPage(playable0);
        }
        return null;
    }

    private static H lambda$showContextPopupArtistPlaylist$7() [...] // Inlined contents

    private H lambda$showContextPopupArtistPlaylist$8(ArtistPlayListInfoBase artistPlayListInfoBase0, String s, k2 k20) {
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.a) {
                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction(this.getActivity(), new AddServerContent(new AddPlay(false), false, false, this.blockingProgressDialogManage, new Playlist(artistPlayListInfoBase0.plylstseq, s, null)), true);
                return null;
            }
            if(m0 == M.B) {
                Navigator.open(DetailLikePersonListFragment.newInstance("N10016", "N20001", artistPlayListInfoBase0.plylstseq));
                return null;
            }
            if(m0 == M.f) {
                this.downloadPlaylist(artistPlayListInfoBase0.plylstseq, s);
                return null;
            }
            if(m0 == M.l) {
                this.showArtistInfoPage(artistPlayListInfoBase0.artistId);
                return null;
            }
        }
        else {
            if(k20 instanceof a2) {
                this.shareData(artistPlayListInfoBase0, "N10016");
                return null;
            }
            if(k20 instanceof J1) {
                Navigator.open(DetailLikePersonListFragment.newInstance("N10016", "N20001", artistPlayListInfoBase0.plylstseq));
                return null;
            }
            if(k20 instanceof x1) {
                this.showArtistInfoPage(artistPlayListInfoBase0.artistId);
            }
        }
        return null;
    }

    private static H lambda$showContextPopupDjPlaylist$5() [...] // Inlined contents

    private H lambda$showContextPopupDjPlaylist$6(DjPlayListInfoBase djPlayListInfoBase0, Q q0, k2 k20) {
        if(k20 instanceof J1) {
            Navigator.open(DetailLikePersonListFragment.newInstance("N10009", "N20001", djPlayListInfoBase0.plylstseq));
            return null;
        }
        if(k20 instanceof D1) {
            Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
            return null;
        }
        if(k20 instanceof z1) {
            Navigator.openUserMain(djPlayListInfoBase0.ownermemberkey, "Y".equals(djPlayListInfoBase0.withdrawyn));
            return null;
        }
        if(k20 instanceof G1) {
            Navigator.openDjPlaylistEdit(djPlayListInfoBase0.plylstseq, null);
            return null;
        }
        if(k20 instanceof C1) {
            this.showDeleteDjPlaylistPopup(djPlayListInfoBase0.plylstseq, djPlayListInfoBase0.plylsttitle);
            return null;
        }
        if(k20 instanceof Y1) {
            this.shareData(djPlayListInfoBase0, q0.b());
            return null;
        }
        if(k20 instanceof a2) {
            this.shareData(djPlayListInfoBase0, q0.b());
        }
        return null;
    }

    private static H lambda$showContextPopupMv$17() [...] // Inlined contents

    private H lambda$showContextPopupMv$18(Playable playable0, k2 k20) {
        if(k20 instanceof J1) {
            Navigator.open(DetailLikePersonListFragment.newInstance("N10003", "N20001", ""));
            return null;
        }
        if(k20 instanceof f2) {
            this.showSongInfoPage(playable0);
            return null;
        }
        if(k20 instanceof x1) {
            if(playable0.getBrandDj()) {
                Navigator.openUserMain(playable0.getArtistid());
                return null;
            }
            this.showArtistInfoPage(playable0);
            return null;
        }
        if(k20 instanceof N1) {
            this.showMvInfoPage(playable0);
            return null;
        }
        if(k20 instanceof a2) {
            this.shareData(playable0, "N10003");
            return null;
        }
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.I) {
                this.playMv(playable0, false, true);
                return null;
            }
            if(m0 == M.m) {
                this.showMvInfoPage(playable0);
            }
        }
        return null;
    }

    private static H lambda$showContextPopupPlayList$12() [...] // Inlined contents

    private H lambda$showContextPopupPlayList$13(ArtistPlayListInfoBase artistPlayListInfoBase0, boolean z, k2 k20) {
        String s = "N10005";
        String s1 = "N10005";
        if(k20 instanceof z1) {
            Navigator.openUserMain(artistPlayListInfoBase0.ownermemberkey, "Y".equals(artistPlayListInfoBase0.withdrawyn));
            return null;
        }
        if(k20 instanceof J1) {
            if(z) {
                s1 = "N10009";
            }
            Navigator.open(DetailLikePersonListFragment.newInstance(s1, "N20001", artistPlayListInfoBase0.plylstseq));
            return null;
        }
        if(!(k20 instanceof K1)) {
            if(k20 instanceof G1) {
                PlaylistMakeFragment.newInstance(artistPlayListInfoBase0.plylstseq, (z ? "M20002" : "M20001")).open();
                return null;
            }
            if(k20 instanceof C1) {
                if(z) {
                    this.showDeleteDjPlaylistPopup(artistPlayListInfoBase0.plylstseq, artistPlayListInfoBase0.plylsttitle);
                    return null;
                }
                this.showDeletePlaylistPopup(artistPlayListInfoBase0.plylstseq, artistPlayListInfoBase0.plylsttitle);
                return null;
            }
            if(k20 instanceof a2) {
                this.shareData(artistPlayListInfoBase0, artistPlayListInfoBase0.contsTypeCode);
                return null;
            }
            if(k20 instanceof Y1) {
                this.shareData(artistPlayListInfoBase0, artistPlayListInfoBase0.contsTypeCode);
                return null;
            }
            if(k20 instanceof D1) {
                Navigator.openDjPlaylistDetail(artistPlayListInfoBase0.plylstseq);
            }
        }
        else if(((K1)k20).b.a == M.B) {
            if(z) {
                s = "N10009";
            }
            Navigator.open(DetailLikePersonListFragment.newInstance(s, "N20001", artistPlayListInfoBase0.plylstseq));
            return null;
        }
        return null;
    }

    private static H lambda$showContextPopupSong$0() [...] // Inlined contents

    private H lambda$showContextPopupSong$1(Playable playable0, k2 k20) {
        if(k20 instanceof H1) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return null;
            }
            this.showKakaoProfileMusicPopup("", "", "");
            return null;
        }
        if(k20 instanceof e2) {
            this.setSelectAllWithToolbar(false);
            Navigator.openSimilarSongList("", "N10001");
            return null;
        }
        if(k20 instanceof J1) {
            this.setSelectAllWithToolbar(false);
            Navigator.open(DetailLikePersonListFragment.newInstance("N10001", "N20001", ""));
            return null;
        }
        if(k20 instanceof h2) {
            this.setSelectAllWithToolbar(false);
            Navigator.open(StreamingCardFragment.newInstance(""));
            return null;
        }
        if(k20 instanceof y1) {
            new MelonChartReportBottomSheetFragment("").show(this.getActivity().getSupportFragmentManager(), "MelonChartReportBottomSheetFragment");
            MelonPrefs.getInstance().setBoolean("CHART_REPORT_THROUGH_INFO_POPUP_SHOWN_BEFORE", true);
            return null;
        }
        if(k20 instanceof M1) {
            StatsElementsBase statsElementsBase0 = this.getAdapter() instanceof q ? ((q)this.getAdapter()).getStatsElements() : null;
            String s = TextUtils.isEmpty(this.mMenuId) ? "" : this.mMenuId;
            this.playMixUp(s, new l1("", "", playable0.getArtistid(), statsElementsBase0));
            PopupClickLogHelper.sendMorePopupPlayClickLog(this.getContext(), s, playable0);
            return null;
        }
        if(k20 instanceof i2) {
            O.a(new UaLogDummyReq(this.getContext(), "songListTiktok"));
            this.setSelectAllWithToolbar(false);
            MelonLinkExecutor.open(((i2)k20).a, ((i2)k20).b);
            return null;
        }
        if(k20 instanceof f2) {
            this.showSongInfoPage(playable0);
            return null;
        }
        if(k20 instanceof w1) {
            this.showAlbumInfoPage(playable0);
            return null;
        }
        if(k20 instanceof x1) {
            this.showArtistInfoPage(playable0);
            return null;
        }
        if(k20 instanceof N1) {
            this.showMvInfoPage(playable0);
            return null;
        }
        if(k20 instanceof c2) {
            this.shareData(playable0, "N10001");
            return null;
        }
        if(k20 instanceof K1 && ((K1)k20).b.a.equals(M.h0)) {
            O.a(new UaLogDummyReq(this.getContext(), "songListTiktok"));
            this.setSelectAllWithToolbar(false);
            Link extraProperties$Link0 = (Link)((K1)k20).b.f;
            MelonLinkExecutor.open(extraProperties$Link0.a, extraProperties$Link0.b);
        }
        return null;
    }

    private H lambda$showDeleteDjPlaylistPopup$9(String s, String s1) {
        this.deleteDjPlayList(s, s1);
        return null;
    }

    private H lambda$showDeletePlaylistPopup$14(String s, String s1) {
        this.deletePlayList(s, s1);
        return null;
    }

    private H lambda$showKakaoProfileMusicSetPopup$2(String s, String s1) {
        RequestBuilder.newInstance(new PostSongKakaoBadgeReq(this.getContext(), "N10001", s, s1)).tag("MetaContentBaseFragment").listener(new com.iloen.melon.fragments.MetaContentBaseFragment.2(this)).errorListener(new com.iloen.melon.fragments.MetaContentBaseFragment.1(this)).request();
        return null;
    }

    public final void makeDjPlayList(String s) {
        Params playlistListSongBaseReq$Params0 = new Params();
        playlistListSongBaseReq$Params0.startIndex = 1;
        playlistListSongBaseReq$Params0.pageSize = 100;
        playlistListSongBaseReq$Params0.plylstSeq = s;
        playlistListSongBaseReq$Params0.mode = "all";
        RequestBuilder.newInstance(new MyMusicPlaylistListSongReq(this.getContext(), playlistListSongBaseReq$Params0)).tag("MetaContentBaseFragment").listener(new Listener() {
            public void onResponse(MyMusicPlaylistListSongRes myMusicPlaylistListSongRes0) {
                if(MetaContentBaseFragment.this.isFragmentValid() && myMusicPlaylistListSongRes0.isSuccessful() && (myMusicPlaylistListSongRes0.response != null && (myMusicPlaylistListSongRes0.response.songList != null && myMusicPlaylistListSongRes0.response.songList.size() > 0))) {
                    ArrayList arrayList0 = new ArrayList();
                    boolean z = false;
                    for(Object object0: myMusicPlaylistListSongRes0.response.songList) {
                        SONGLIST myMusicPlaylistListSongRes$RESPONSE$SONGLIST0 = (SONGLIST)object0;
                        if(!myMusicPlaylistListSongRes$RESPONSE$SONGLIST0.isHoldback && myMusicPlaylistListSongRes$RESPONSE$SONGLIST0.canService) {
                            arrayList0.add(myMusicPlaylistListSongRes$RESPONSE$SONGLIST0.songId);
                        }
                        else {
                            z = true;
                        }
                    }
                    if(!arrayList0.isEmpty()) {
                        Navigator.open(PlaylistMakeFragment.newInstance("", "M20002", arrayList0, null, null));
                    }
                    else if(z) {
                        ToastManager.showShort(0x7F130826);  // string:playlist_donot_service_songs_msg "현재 서비스 중인 곡만 추가가 가능합니다."
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicPlaylistListSongRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public List onAddSongsToPlaylist(String s, String s1) {
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "onAddSongsToPlaylist() invalid adapter");
            return null;
        }
        m m0 = this.getMarkedList(false);
        ArrayList arrayList0 = new ArrayList();
        if(m0.a) {
            arrayList0.addAll(this.getWeakMarkedList());
            return ((s)object0).getSongsFromPositionIndices(arrayList0);
        }
        arrayList0.addAll(m0.d);
        return ((s)object0).getSongsFromPositionIndices(arrayList0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddToNowPlayingList(Object object0) {
        if(this.getMarkedList(false).a) {
            Object object1 = this.getContentAdapter();
            if(object1 instanceof ListMarker && object1 instanceof s) {
                int v = ((ListMarker)object1).getWeakMarked();
                if(v == -1) {
                    LogU.w("MetaContentBaseFragment", "onAddToNowPlayingList() invalid position");
                    return;
                }
                Playable playable0 = ((s)object1).getPlayable(v);
                if(playable0 != null) {
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(playable0);
                    this.playSongs(arrayList0, false, false, false);
                }
                return;
            }
            LogU.w("MetaContentBaseFragment", "onAddToNowPlayingList() invalid adapter");
            return;
        }
        this.playSongs(false, false, false);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        if(this.instantPlayPopup != null && this.instantPlayPopup.isShowing()) {
            this.instantPlayPopup.dismiss();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(v == 0) {
            this.toolbarMenuClickLog(0);
            this.playSongs(false, true, false);
            return;
        }
        if(0x1F == v) {
            this.toolbarMenuClickLog(0x1F);
            this.playMixUpSongs();
            return;
        }
        if(1 == v) {
            Object object0 = this.getContentAdapter();
            if(!(object0 instanceof h)) {
                LogU.d("MetaContentBaseFragment", "onToolbarClick() - invalid adapter");
                return;
            }
            this.toolbarMenuClickLog(1);
            int v1 = ((h)object0).getListContentType();
            if(1 == v1) {
                this.downloadSongs();
                return;
            }
            if(3 == v1) {
                this.downloadMv();
            }
        }
        else if(2 == v) {
            if(!this.getMarkedList(false).a) {
                this.toolbarMenuClickLog(2);
                this.showContextMenuAddTo();
            }
        }
        else if(14 == v) {
            Object object1 = this.getContentAdapter();
            if(!(object1 instanceof h)) {
                LogU.d("MetaContentBaseFragment", "onToolbarClick() - invalid adapter");
                return;
            }
            if(1 == ((h)object1).getListContentType()) {
                this.toolbarMenuClickLog(14);
                this.presentForSong();
            }
        }
        else if(10 == v) {
            Object object2 = this.getContentAdapter();
            if(!(object2 instanceof h)) {
                LogU.d("MetaContentBaseFragment", "onToolbarClick() - invalid adapter");
                return;
            }
            if(3 == ((h)object2).getListContentType()) {
                this.playMvs(false);
            }
        }
        else {
            if(17 == v) {
                this.onAddToNowPlayingList(null);
                return;
            }
            if(3 == v) {
                Object object3 = this.getContentAdapter();
                if(!(object3 instanceof h)) {
                    LogU.d("MetaContentBaseFragment", "onToolbarClick() - invalid adapter");
                    return;
                }
                if(1 == ((h)object3).getListContentType()) {
                    this.downloadFlacSongs();
                }
            }
        }
    }

    public void playAlbum(int v) {
        if(v < 0) {
            LogU.w("MetaContentBaseFragment", "playAlbum() - invalid position");
            return;
        }
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "playAlbum() - invalid adapter");
            return;
        }
        Z.r(v, "playAlbum() position:", "MetaContentBaseFragment");
        this.playAlbum(((s)object0).getPlayable(v));
    }

    public void playAll() {
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof h)) {
            LogU.d("MetaContentBaseFragment", "playAll() - invalid adapter");
            return;
        }
        int v = ((h)object0).getListContentType();
        if(v == 1) {
            this.playSongs(true, true, false);
            return;
        }
        if(v == 3) {
            this.playMvs(true);
            return;
        }
        LogU.w("MetaContentBaseFragment", "playAll() invalid content type");
    }

    public final void playMixSongs(String s, String s1, String s2, String s3) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3)) {
            com.iloen.melon.net.v5x.request.ForUInformForUMixContsPlayReq.Params forUInformForUMixContsPlayReq$Params0 = new com.iloen.melon.net.v5x.request.ForUInformForUMixContsPlayReq.Params();
            forUInformForUMixContsPlayReq$Params0.contsId = s;
            forUInformForUMixContsPlayReq$Params0.seedContsId = s1;
            forUInformForUMixContsPlayReq$Params0.seedContsTypeCode = s2;
            forUInformForUMixContsPlayReq$Params0.menuId = s3;
            this.showProgress(true);
            RequestBuilder.newInstance(new ForUInformForUMixContsPlayReq(this.getContext(), forUInformForUMixContsPlayReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
                public void onResponse(ForUInformForUMixContsPlayRes forUInformForUMixContsPlayRes0) {
                    if(forUInformForUMixContsPlayRes0 != null && forUInformForUMixContsPlayRes0.isSuccessful()) {
                        RESPONSE forUInformForUMixContsPlayRes$RESPONSE0 = forUInformForUMixContsPlayRes0.response;
                        if(forUInformForUMixContsPlayRes$RESPONSE0 != null) {
                            if(forUInformForUMixContsPlayRes$RESPONSE0.songList == null || forUInformForUMixContsPlayRes$RESPONSE0.songList.isEmpty()) {
                                ToastManager.showShort(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
                            }
                            else {
                                ArrayList arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(forUInformForUMixContsPlayRes0.response.songList, forUInformForUMixContsPlayRes0.response.menuId, forUInformForUMixContsPlayRes0.response.statsElements);
                                MetaContentBaseFragment.this.playSongs(arrayList0, true);
                            }
                        }
                    }
                    MetaContentBaseFragment.this.showProgress(false);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((ForUInformForUMixContsPlayRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    MetaContentBaseFragment.this.showProgress(false);
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }).request();
        }
    }

    public void playMixUpSongs() {
        m m0 = this.getMarkedList(false);
        if(!m0.a && !m0.c) {
            Object object0 = this.getContentAdapter();
            if(!(object0 instanceof s)) {
                LogU.d("MetaContentBaseFragment", "playMixUpSongs() - invalid adapter");
                return;
            }
            ArrayList arrayList0 = (ArrayList)((s)object0).getPlayableItems(m0.d);
            if(arrayList0 != null && arrayList0.size() != 0) {
                this.setSelectAllWithToolbar(false);
                StatsElementsBase statsElementsBase0 = this.getAdapter() instanceof q ? ((q)this.getAdapter()).getStatsElements() : null;
                this.playMixUp(this.mMenuId, new n1(arrayList0, statsElementsBase0, true));
            }
            return;
        }
        ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
    }

    public void playMv(int v) {
        if(v < 0) {
            LogU.w("MetaContentBaseFragment", "playMv() - invalid position");
            return;
        }
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "playMv() invalid adapter");
            return;
        }
        this.playMv(((s)object0).getPlayable(v));
        this.setSelectAllWithToolbar(false);
    }

    public void playMvs(boolean z) {
        LogU.d("MetaContentBaseFragment", "playMvs() playAll:" + z);
        m m0 = this.getMarkedList(z);
        if(m0.a) {
            if(z && m0.c) {
                ToastManager.show(0x7F13038B);  // string:empty_list_video "재생 가능한 비디오가 없습니다."
            }
            LogU.w("MetaContentBaseFragment", "playMvs() list is empty");
            return;
        }
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "playMvs() invalid adapter");
            return;
        }
        ArrayList arrayList0 = m0.d;
        if(arrayList0 != null && arrayList0.size() > 0) {
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: arrayList0) {
                arrayList1.add(((s)object0).getPlayable(((int)(((Integer)object1)))));
            }
            this.playMvByMvId(arrayList1);
        }
        this.setSelectAllWithToolbar(false);
    }

    public void playShuffleAll() {
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof h)) {
            LogU.d("MetaContentBaseFragment", "playAll() - invalid adapter");
            return;
        }
        if(((h)object0).getListContentType() == 1) {
            this.playSongs(true, true, true);
            return;
        }
        LogU.w("MetaContentBaseFragment", "playShuffleAll() invalid content type");
    }

    public void playSongs(boolean z, boolean z1, boolean z2) {
        LogU.d("MetaContentBaseFragment", "playSongs() playAll:" + z + " nowPlay:" + z1);
        m m0 = this.getMarkedList(z);
        if(!m0.a) {
            if(z1 && m0.b) {
                LogU.d("MetaContentBaseFragment", "playSongs() - TaskAuthMsgContent run...");
                this.runTaskAuthMsgContent();
                return;
            }
            Object object0 = this.getContentAdapter();
            if(!(object0 instanceof s)) {
                LogU.d("MetaContentBaseFragment", "playSongs() - invalid adapter");
                return;
            }
            ArrayList arrayList0 = (ArrayList)((s)object0).getPlayableItems(m0.d);
            if(arrayList0 != null && arrayList0.size() != 0) {
                this.setSelectAllWithToolbar(false);
                this.playSongs(arrayList0, z1, false, z2);
            }
        }
        else if(z && m0.c) {
            ToastManager.show(0x7F13038A);  // string:empty_list_song "재생 가능한 곡이 없습니다."
        }
    }

    public void playTop100Songs() {
        LogU.d("MetaContentBaseFragment", "playTop100Songs()");
        m m0 = this.getAllItemsWithoutRecommend();
        if(!m0.a) {
            if(m0.b) {
                LogU.d("MetaContentBaseFragment", "playTop100Songs() - TaskAuthMsgContent run...");
                this.runTaskAuthMsgContent();
                return;
            }
            Object object0 = this.getContentAdapter();
            if(!(object0 instanceof s)) {
                LogU.d("MetaContentBaseFragment", "playTop100Songs() - invalid adapter");
                return;
            }
            ArrayList arrayList0 = (ArrayList)((s)object0).getPlayableItems(m0.d);
            if(arrayList0 != null && arrayList0.size() != 0) {
                this.setSelectAllWithToolbar(false);
                this.playSongs(arrayList0, true);
            }
        }
    }

    public void presentForSong() {
        m m0 = this.getMarkedList(false);
        if(m0.a) {
            LogU.w("MetaContentBaseFragment", "presentForSong() list is empty");
            return;
        }
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof s)) {
            LogU.w("MetaContentBaseFragment", "presentForSong() invalid adapter");
            return;
        }
        ArrayList arrayList0 = m0.d;
        if(arrayList0 != null && arrayList0.size() > 0) {
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: arrayList0) {
                arrayList1.add(((s)object0).getPlayable(((int)(((Integer)object1)))));
            }
            this.openPresentSendPage(null, arrayList1);
        }
    }

    public final void shareData(Object object0, String s) {
        ArtistPlayListInfoBase artistPlayListInfoBase0;
        Playable playable1;
        String s2;
        DjPlayListInfoBase djPlayListInfoBase0;
        String s1;
        Playable playable0;
        if(object0 == null) {
            return;
        }
        if("N10001".equals(s)) {
            playable0 = (Playable)object0;
            s1 = Integer.toString(playable0.getSongid());
            playable1 = playable0;
            s2 = s;
            djPlayListInfoBase0 = null;
            artistPlayListInfoBase0 = null;
        }
        else if("N10002".equals(s)) {
            playable0 = (Playable)object0;
            s1 = "";
            playable1 = playable0;
            s2 = s;
            djPlayListInfoBase0 = null;
            artistPlayListInfoBase0 = null;
        }
        else if("N10009".equals(s)) {
            s1 = ((DjPlayListInfoBase)object0).plylstseq;
            djPlayListInfoBase0 = (DjPlayListInfoBase)object0;
            s2 = s;
            playable1 = null;
            artistPlayListInfoBase0 = null;
        }
        else if("N10005".equals(s) || "N10016".equals(s)) {
            s1 = ((ArtistPlayListInfoBase)object0).plylstseq;
            artistPlayListInfoBase0 = (ArtistPlayListInfoBase)object0;
            s2 = s;
            playable1 = null;
            djPlayListInfoBase0 = null;
        }
        else {
            if("N10003".equals(s)) {
                playable0 = (Playable)object0;
                s1 = "";
                playable1 = playable0;
                s2 = s;
            }
            else {
                s1 = "";
                s2 = "";
                playable1 = null;
            }
            djPlayListInfoBase0 = null;
            artistPlayListInfoBase0 = null;
        }
        PostImageAsyncCoroutine postImageAsyncCoroutine0 = new PostImageAsyncCoroutine(s1, s2);
        postImageAsyncCoroutine0.setOnPostImageAsyncTaskListener(new OnPostImageAsyncCoroutineListener() {
            @Override  // com.iloen.melon.task.request.PostImageAsyncCoroutine$OnPostImageAsyncCoroutineListener
            public void onTaskFinish(String s, String s1) {
                Sharable sharable0;
                MetaContentBaseFragment.this.showProgress(false);
                if("N10001".equals(s)) {
                    sharable0 = MetaContentBaseFragment.this.getSharableSongData(playable1, s, s1);
                }
                else if("N10002".equals(s)) {
                    sharable0 = MetaContentBaseFragment.this.getSharableAlbumData(playable1, s, s1);
                }
                else if("N10009".equals(s)) {
                    sharable0 = MetaContentBaseFragment.this.getSharableDJCollectionData(djPlayListInfoBase0, s, s1);
                }
                else if("N10005".equals(s)) {
                    sharable0 = MetaContentBaseFragment.this.getSharablePlaylistData(artistPlayListInfoBase0, s, s1);
                }
                else if("N10016".equals(s)) {
                    sharable0 = MetaContentBaseFragment.this.getSharableArtistPlaylistData(artistPlayListInfoBase0, s, s1);
                }
                else {
                    sharable0 = "N10003".equals(s) ? MetaContentBaseFragment.this.getSharableMvData(playable1, s, s1) : null;
                }
                MetaContentBaseFragment.this.showSNSListPopup(sharable0);
            }

            @Override  // com.iloen.melon.task.request.PostImageAsyncCoroutine$OnPostImageAsyncCoroutineListener
            public void onTaskStart() {
                MetaContentBaseFragment.this.showProgress(true);
            }
        });
        postImageAsyncCoroutine0.execute(null);
    }

    public void showContextPopupAlbum(Playable playable0) {
        if(!this.isAdded() || !this.isPossiblePopupShow()) {
            return;
        }
        if(playable0 == null) {
            LogU.w("MetaContentBaseFragment", "showContextPopupFromAlbum() invalid playable");
            return;
        }
        LogU.d("MetaContentBaseFragment", "showContextPopupFromAlbum() playable:" + playable0);
        d d0 = new d(playable0);
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(3);
        A a0 = new A(this, playable0, 0);
        b.n(l00, d0, p0, E.a, a0);
    }

    public void showContextPopupArtistPlaylist(ArtistPlayListInfoBase artistPlayListInfoBase0, String s) {
        if(!this.isAdded() || !this.isPossiblePopupShow() || artistPlayListInfoBase0 == null) {
            return;
        }
        g g0 = new g(artistPlayListInfoBase0);
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(8);
        com.iloen.melon.fragments.s s1 = new com.iloen.melon.fragments.s(this, artistPlayListInfoBase0, s, 2);
        b.n(l00, g0, p0, E.a, s1);
    }

    public void showContextPopupDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0) {
        if(!this.isAdded() || !this.isPossiblePopupShow() || djPlayListInfoBase0 == null) {
            return;
        }
        zd.q q0 = new zd.q((djPlayListInfoBase0.plylstseq == null ? "" : djPlayListInfoBase0.plylstseq), (djPlayListInfoBase0.plylsttitle == null ? "" : djPlayListInfoBase0.plylsttitle), (djPlayListInfoBase0.ownernickname == null ? "" : djPlayListInfoBase0.ownernickname), (djPlayListInfoBase0.ownermemberkey == null ? "" : djPlayListInfoBase0.ownermemberkey), (djPlayListInfoBase0.songcnt == null ? "" : djPlayListInfoBase0.songcnt), djPlayListInfoBase0.fameregyn, this.mMenuId, djPlayListInfoBase0.withdrawyn, djPlayListInfoBase0.thumbimg, e1.u.v(((e0)o.a()).j()), "Y".equals(djPlayListInfoBase0.delYn), true);
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(4);
        com.iloen.melon.fragments.s s0 = new com.iloen.melon.fragments.s(this, djPlayListInfoBase0, q0, 1);
        b.n(l00, q0, p0, E.a, s0);
    }

    private void showContextPopupMv(Playable playable0, int v) {
        if(!this.isAdded() || !this.isPossiblePopupShow()) {
            return;
        }
        if(playable0 == null) {
            LogU.w("MetaContentBaseFragment", "showContextPopupFromAlbum() invalid playable");
            return;
        }
        LogU.d("MetaContentBaseFragment", "showContextPopupFromMv() playable:" + playable0);
        p0 p00 = new p0(playable0, v == 8);
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(6);
        A a0 = new A(this, playable0, 1);
        b.n(l00, p00, p0, E.a, a0);
    }

    public void showContextPopupMv(Playable playable0) {
        this.showContextPopupMv(playable0, 7);
    }

    public void showContextPopupMvWithLike(Playable playable0) {
        this.showContextPopupMv(playable0, 8);
    }

    public final void showContextPopupPlayList(ArtistPlayListInfoBase artistPlayListInfoBase0) {
        zd.q q0;
        if(!this.isAdded() || !this.isPossiblePopupShow() || artistPlayListInfoBase0 == null) {
            return;
        }
        boolean z = "Y".equals(artistPlayListInfoBase0.delYn);
        boolean z1 = "N".equals(artistPlayListInfoBase0.openyn);
        boolean z2 = "N10009".equals(artistPlayListInfoBase0.contsTypeCode);
        if(z2) {
            String s = artistPlayListInfoBase0.plylstseq;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = artistPlayListInfoBase0.plylsttitle == null ? "" : artistPlayListInfoBase0.plylsttitle;
            String s3 = artistPlayListInfoBase0.ownernickname == null ? "" : artistPlayListInfoBase0.ownernickname;
            String s4 = artistPlayListInfoBase0.ownermemberkey == null ? "" : artistPlayListInfoBase0.ownermemberkey;
            String s5 = artistPlayListInfoBase0.songcnt;
            if(s5 != null) {
                s1 = s5;
            }
            q0 = new zd.q(s, s2, s3, s4, s1, artistPlayListInfoBase0.fameregyn, this.mMenuId, artistPlayListInfoBase0.withdrawyn, artistPlayListInfoBase0.thumbimg, e1.u.v(((e0)o.a()).j()), z, !z1);
        }
        else {
            q0 = new u0(artistPlayListInfoBase0, artistPlayListInfoBase0.openyn);
        }
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(5);
        F f0 = new F(this, artistPlayListInfoBase0, z2, 7);
        b.n(l00, q0, p0, E.a, f0);
    }

    public void showContextPopupSong(Playable playable0) {
        this.showContextPopupSong(playable0, 0);
    }

    public void showContextPopupSong(Playable playable0, int v) {
        if(!this.isAdded() || !this.isPossiblePopupShow()) {
            return;
        }
        if(playable0 == null) {
            LogU.w("MetaContentBaseFragment", "showContextPopupFromSong() invalid playable");
            return;
        }
        LogU.d("MetaContentBaseFragment", "showContextPopupFromSong() playable:" + playable0);
        A0 a00 = new A0(playable0);
        l0 l00 = this.getChildFragmentManager();
        p p0 = new p(7);
        A a0 = new A(this, playable0, 2);
        b.n(l00, a00, p0, E.a, a0);
    }

    public void showContextPopupSongOrInstantPlay(Playable playable0) {
        if(MelonSettingInfo.isUseInstantPlay()) {
            this.showInstantPlayPopup(playable0);
            return;
        }
        this.showContextPopupSong(playable0);
    }

    public void showContextPopupSongOrInstantPlay(Playable playable0, int v) {
        if(MelonSettingInfo.isUseInstantPlay()) {
            this.showInstantPlayPopup(playable0);
            return;
        }
        this.showContextPopupSong(playable0, v);
    }

    public void showContextPopupSongOrInstantPlay(Playable playable0, boolean z) {
        if(MelonSettingInfo.isUseInstantPlay()) {
            this.showInstantPlayPopup(playable0);
            return;
        }
        this.showContextPopupSong(playable0, (z ? 14 : 1));
    }

    public final void showDeleteDjPlaylistPopup(String s, String s1) {
        LogU.d("MetaContentBaseFragment", "showDeleteDjPlaylistPopup() playlistSeq : " + s + " playlistTitle:" + s1);
        if(!this.isAdded()) {
            return;
        }
        l0 l00 = this.getChildFragmentManager();
        String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        StringBuilder stringBuilder0 = Y.p(s1);
        stringBuilder0.append(this.getString(0x7F13008D));  // string:alert_dlg_body_delete_myalbum_dj "을(를) 삭제 하시겠습니까?\n삭제한 DJ 플레이리스트는 복구할 수 없습니다."
        b.v(l00, s2, stringBuilder0.toString(), true, null, null, new z(this, s, s1, 0), null);
    }

    public final void showDeletePlaylistPopup(String s, String s1) {
        LogU.d("MetaContentBaseFragment", "showDeletePlaylistPopup() playlistSeq : " + s + " playlistTitle:" + s1);
        if(!this.isAdded()) {
            return;
        }
        l0 l00 = this.getChildFragmentManager();
        String s2 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        StringBuilder stringBuilder0 = Y.p(s1);
        stringBuilder0.append("을(를) 삭제 하시겠습니까?\n삭제한 플레이리스트는 복구할 수 없습니다.");
        b.v(l00, s2, stringBuilder0.toString(), true, null, null, new z(this, s, s1, 1), null);
    }

    public void showInstantPlayPopup(Playable playable0) {
        Context context0 = MelonAppBase.instance.getContext();
        kotlin.jvm.internal.q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        kotlin.jvm.internal.q.d(context1);
        Ub.s s0 = (Ub.s)((k8.o)(((Ma.m)com.google.firebase.b.B(context1, Ma.m.class)))).z.get();
        if(!MelonAppBase.instance.isCarConnected() && !((t)s0).f()) {
            InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(playable0);
            this.instantPlayPopup = instantPlayPopup0;
            instantPlayPopup0.show(this.getChildFragmentManager(), "InstantPlayPopup");
            return;
        }
        ToastManager.show("기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다.");
    }

    public final void showKakaoProfileMusicPopup(String s, String s1, String s2) {
        this.showKakaoProfileMusicSetPopup(this.getString(0x7F1304C5), String.format(this.getString(0x7F1304C4), s1), s, s2);  // string:kakao_profile_music_set_title "카카오톡 프로필뮤직 설정"
    }

    private void showKakaoProfileMusicSetPopup(String s, String s1, String s2, String s3) {
        if(this.isFragmentValid() && !TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s3)) {
            if(!this.isLoginUser()) {
                this.showLoginPopup();
                return;
            }
            b.v(this.getChildFragmentManager(), s, s1, false, null, null, new z(this, s2, s3, 2), null);
        }

        class com.iloen.melon.fragments.MetaContentBaseFragment.1 implements ErrorListener {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }


        class com.iloen.melon.fragments.MetaContentBaseFragment.2 implements Listener {
            public void onResponse(PostSongKakaoBadgeRes postSongKakaoBadgeRes0) {
                if(postSongKakaoBadgeRes0.isSuccessful() && postSongKakaoBadgeRes0.response != null) {
                    MetaContentBaseFragment.this.setSelectAllWithToolbar(false);
                    Navigator.showKakaoProfileAgreePage(postSongKakaoBadgeRes0.response.agreeUrl, postSongKakaoBadgeRes0.response.headerToken);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((PostSongKakaoBadgeRes)object0));
            }
        }

    }

    public void toolbarMenuClickLog(int v) {
        m m0 = this.getMarkedList(false);
        if(m0 != null) {
            ArrayList arrayList0 = m0.d;
            if(arrayList0 != null && arrayList0.size() > 0) {
                ArrayList arrayList1 = (ArrayList)((s)this.getAdapter()).getPlayableItems(arrayList0);
                if(arrayList1 != null && arrayList1.size() > 0) {
                    p8.s s0 = this.getTiaraProperty();
                    if(s0 != null) {
                        ToolbarTiaraLogHelper.sendClickLog(v, s0, arrayList1);
                        return;
                    }
                    LogU.w("MetaContentBaseFragment", this.getClass().getSimpleName() + " - MelonTiaraProperty is null");
                }
            }
        }
    }
}

