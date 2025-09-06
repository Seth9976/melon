package com.iloen.melon.slook;

import E9.w;
import Ma.c;
import Ma.m;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RemoteViews;
import b3.Z;
import com.bumptech.glide.Glide;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.U0;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes.response;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes;
import com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes.RESPONSE.PLYLSTLIST;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.slook.request.DjPopularListReqDelegate;
import com.iloen.melon.slook.request.DjTodayReqDelegate;
import com.iloen.melon.slook.request.EdgeDailySongChartReqDelegate;
import com.iloen.melon.slook.request.SlookListReqDelegator.DelegateEventListener;
import com.iloen.melon.slook.request.SlookListReqDelegator;
import com.iloen.melon.slook.request.ThemeJenreListReqDelegate;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.SamsungEdgeUtils;
import com.melon.net.res.common.SongInfoBase;
import com.melon.playlist.interfaces.PlayableData;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailManager;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider;
import d3.g;
import e1.n;
import java.util.ArrayList;
import java.util.HashMap;
import k8.a;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import ob.z;
import p8.O;
import r8.f;

public class CocktailPlayerPanelProvider extends SlookCocktailProvider {
    class UpdateHandler extends U0 {
        public final CocktailPlayerPanelProvider a;

        public UpdateHandler(CocktailPlayerPanelProvider cocktailPlayerPanelProvider1) {
            super(cocktailPlayerPanelProvider1);
        }

        public void handleMessage(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0, Message message0) {
            boolean z = this.hasMessages(1000);
            CocktailPlayerPanelProvider cocktailPlayerPanelProvider1 = CocktailPlayerPanelProvider.this;
            if(z) {
                try {
                    this.removeMessages(1000);
                    cocktailPlayerPanelProvider1.b.sendMessageDelayed(message0, 200L);
                }
                catch(Exception exception0) {
                    Z.v(exception0, new StringBuilder("UpdateHandler$handleMessage() - error : "), "CocktailPlayerPanelProvider");
                }
                return;
            }
            cocktailPlayerPanelProvider1.performUpdate(((Context)message0.obj), false);
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((CocktailPlayerPanelProvider)object0), message0);
        }
    }

    public SlookListReqDelegator a;
    public final UpdateHandler b;
    public final CocktailPlayerKt c;
    public final s2 d;
    public final z e;
    public final a f;
    public static Uri g;
    public static Bitmap h;

    public CocktailPlayerPanelProvider() {
        this.a = null;
        this.b = new UpdateHandler(this, this);
        this.c = new CocktailPlayerKt();
        Context context0 = MelonAppBase.instance.getContext();
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        this.d = (s2)((o)(((m)b.B(context1, m.class)))).w.get();
        Context context2 = MelonAppBase.instance.getContext();
        q.g(context2, "context");
        Context context3 = context2.getApplicationContext();
        q.d(context3);
        this.e = ((o)(((Ma.o)b.B(context3, Ma.o.class)))).k();
        this.f = ((o)(((c)b.B(MelonAppBase.instance.getContext().getApplicationContext(), c.class)))).d();
    }

    public final void a(Context context0, int v) {
        if(SamsungEdgeUtils.getChartMode() != v) {
            SamsungEdgeUtils.setChartMode(v);
            this.performUpdate(context0, true);
            this.c(context0);
            g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(v), "T05", "V2");
        }
    }

    public final HttpResponse b(Context context0, int v) {
        EdgeDailySongChartReqDelegate edgeDailySongChartReqDelegate0;
        switch(v) {
            case 0: {
                edgeDailySongChartReqDelegate0 = new EdgeDailySongChartReqDelegate(context0);
                return this.e(context0).getCachedChartListResponse(edgeDailySongChartReqDelegate0);
            }
            case 1: {
                edgeDailySongChartReqDelegate0 = new DjPopularListReqDelegate(context0);
                return this.e(context0).getCachedChartListResponse(edgeDailySongChartReqDelegate0);
            }
            case 2: {
                edgeDailySongChartReqDelegate0 = new ThemeJenreListReqDelegate(context0);
                return this.e(context0).getCachedChartListResponse(edgeDailySongChartReqDelegate0);
            }
            default: {
                return this.e(context0).getCachedChartListResponse(null);
            }
        }
    }

    public final void c(Context context0) {
        EdgeDailySongChartReqDelegate edgeDailySongChartReqDelegate0;
        switch(SamsungEdgeUtils.getChartMode()) {
            case 0: {
                edgeDailySongChartReqDelegate0 = new EdgeDailySongChartReqDelegate(context0);
                break;
            }
            case 1: {
                edgeDailySongChartReqDelegate0 = new DjPopularListReqDelegate(context0);
                break;
            }
            case 2: {
                edgeDailySongChartReqDelegate0 = new ThemeJenreListReqDelegate(context0);
                break;
            }
            default: {
                edgeDailySongChartReqDelegate0 = null;
            }
        }
        this.e(context0).request(edgeDailySongChartReqDelegate0, new CocktailPlayerPanelProvider.2(this, context0));
    }

    public static PendingIntent d(Context context0, int v) {
        Intent intent0 = new Intent(context0, CocktailPlayerPanelProvider.class);
        intent0.setAction("com.example.cocktailslooksample.action.ACTION_REMOTE_CLICK");
        intent0.putExtra("id", v);
        return PendingIntent.getBroadcast(context0, v, intent0, 0xA000000);
    }

    public final SlookListReqDelegator e(Context context0) {
        synchronized(this) {
            if(this.a == null) {
                this.a = new SlookListReqDelegator(context0);
            }
            return this.a;
        }
    }

    public final RemoteViews f(Context context0, boolean z) {
        boolean z3;
        boolean z2;
        int v2;
        RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D0804);  // layout:samsung_edge_controler_panel_layout
        Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.prev").putExtra("com.iloen.melon.intent.extra.actor.ordinal", Actor.EdgeSinglePlus.ordinal()).setData(new Uri.Builder().appendPath("EdgeSinglePlus").build());
        q.f(intent0, "setData(...)");
        remoteViews0.setOnClickPendingIntent(0x7F0A0198, PendingIntent.getService(context0, Actor.EdgeSinglePlus.ordinal(), intent0, 0xC000000));  // id:btn_prev
        Intent intent1 = w.u("com.iloen.melon.intent.action.playservice.playpause").putExtra("com.iloen.melon.intent.extra.actor.ordinal", Actor.EdgeSinglePlus.ordinal()).setData(new Uri.Builder().appendPath("EdgeSinglePlus").build());
        q.f(intent1, "setData(...)");
        remoteViews0.setOnClickPendingIntent(0x7F0A0189, PendingIntent.getService(context0, Actor.EdgeSinglePlus.ordinal(), intent1, 0xC000000));  // id:btn_play_toggle
        Intent intent2 = w.u("com.iloen.melon.intent.action.playservice.next").putExtra("com.iloen.melon.intent.extra.actor.ordinal", Actor.EdgeSinglePlus.ordinal()).setData(new Uri.Builder().appendPath("EdgeSinglePlus").build());
        q.f(intent2, "setData(...)");
        remoteViews0.setOnClickPendingIntent(0x7F0A017F, PendingIntent.getService(context0, Actor.EdgeSinglePlus.ordinal(), intent2, 0xC000000));  // id:btn_next
        remoteViews0.setOnClickPendingIntent(0x7F0A0729, CocktailPlayerPanelProvider.d(context0, 0x7F0A0729));  // id:layout_melon_dj_today_container
        int v = SamsungEdgeUtils.getChartMode();
        int v1 = 0;
        remoteViews0.setInt(0x7F0A060F, "setVisibility", (v == 0 ? 0 : 8));  // id:iv_chart_play_all
        if(v == 0) {
            v2 = 0x7F130380;  // string:edge_chart_melon_real "멜론차트"
        }
        else {
            v2 = v == 1 ? 0x7F13037F : 0x7F130381;  // string:edge_chart_melon_dj "멜론 DJ"
        }
        remoteViews0.setTextViewText(0x7F0A0C35, context0.getString(v2));  // id:tv_chart_title
        remoteViews0.setRemoteAdapter(0x7F0A09E6, new Intent(context0, CocktailPlayerRemoteService.class));  // id:remote_list
        remoteViews0.setPendingIntentTemplate(0x7F0A09E6, CocktailPlayerPanelProvider.d(context0, 0x7F0A09E6));  // id:remote_list
        if(z) {
            remoteViews0.setScrollPosition(0x7F0A09E6, 0);  // id:remote_list
        }
        s2 s20 = this.d;
        PlayableData playableData0 = this.c.getCurrentPlayableDataOfRecentAudioPlaylist(s20);
        remoteViews0.setViewVisibility(0x7F0A0D18, 0);  // id:tv_song_list_no
        remoteViews0.setViewVisibility(0x7F0A0AB4, 4);  // id:song_title
        remoteViews0.setViewVisibility(0x7F0A00B8, 4);  // id:artist_name
        remoteViews0.setViewVisibility(0x7F0A0B82, (CocktailPlayerPanelProvider.h == null ? 8 : 0));  // id:thumbnail
        remoteViews0.setImageViewBitmap(0x7F0A0B82, CocktailPlayerPanelProvider.h);  // id:thumbnail
        Uri uri0 = playableData0 == null ? Uri.EMPTY : playableData0.n;
        if(!ClassUtils.equals(uri0, CocktailPlayerPanelProvider.g)) {
            CocktailPlayerPanelProvider.g = uri0;
            CocktailPlayerPanelProvider.h = null;
            Glide.with(context0).asBitmap().load(CocktailPlayerPanelProvider.g).into(new CocktailPlayerPanelProvider.4(this, uri0, remoteViews0, context0));
        }
        PlaylistId playlistId0 = ((d3)s20).j();
        ((com.melon.playlist.b)((d3)s20).a).Y("getRecentAudioPlaylistIdOrNull");
        PlaylistId playlistId1 = (PlaylistId)((com.melon.playlist.b)((d3)s20).a).q.getValue();
        z z1 = this.e;
        remoteViews0.setImageViewResource(0x7F0A0189, ((playlistId0 == playlistId1 ? z1.n() : false) ? 0x7F080823 : 0x7F080824));  // id:btn_play_toggle
        ((com.melon.playlist.b)((d3)s20).a).Y("getRecentAudioPlaylistIdOrNull");
        PlaylistId playlistId2 = (PlaylistId)((com.melon.playlist.b)((d3)s20).a).q.getValue();
        if(playlistId2 == null) {
            z2 = false;
        }
        else {
            z1.getClass();
            z2 = n.k(playlistId2);
        }
        if(z2) {
            remoteViews0.setViewVisibility(0x7F0A0198, 0);  // id:btn_prev
            remoteViews0.setViewVisibility(0x7F0A017F, 0);  // id:btn_next
        }
        else {
            remoteViews0.setViewVisibility(0x7F0A0198, 8);  // id:btn_prev
            remoteViews0.setViewVisibility(0x7F0A017F, 8);  // id:btn_next
        }
        remoteViews0.setOnClickPendingIntent(0x7F0A0708, CocktailPlayerPanelProvider.d(context0, 0x7F0A0708));  // id:layout_chart_type
        HttpResponse httpResponse0 = this.e(context0).getCachedChartListResponse(new DjTodayReqDelegate(context0));
        if(httpResponse0 instanceof DjTodayListForEdgeRes) {
            ArrayList arrayList0 = ((DjTodayListForEdgeRes)httpResponse0).response.plylstList;
            if(arrayList0 == null || arrayList0.get(0) == null) {
                z3 = false;
            }
            else {
                remoteViews0.setTextViewText(0x7F0A0CB0, ((PLYLSTLIST)arrayList0.get(0)).plylsttitle);  // id:tv_melon_dj_today_desc
                remoteViews0.setTextViewText(0x7F0A0CB2, ((PLYLSTLIST)arrayList0.get(0)).ownernickname);  // id:tv_melon_dj_today_name
                z3 = true;
            }
        }
        else {
            z3 = false;
        }
        remoteViews0.setViewVisibility(0x7F0A0CB0, (z3 ? 0 : 4));  // id:tv_melon_dj_today_desc
        remoteViews0.setViewVisibility(0x7F0A0CB2, (z3 ? 0 : 4));  // id:tv_melon_dj_today_name
        if(z3) {
            v1 = 4;
        }
        remoteViews0.setViewVisibility(0x7F0A0CB1, v1);  // id:tv_melon_dj_today_error
        return remoteViews0;
    }

    public final RemoteViews g(Context context0) {
        RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", 0x7F0D0808);  // layout:samsung_edge_state_panel_layout
        Playable playable0 = this.c.getCurrentPlayableOfRecentAudioPlaylist(this.d);
        remoteViews0.setTextViewText(0x7F0A008F, "");  // id:album_title
        remoteViews0.setTextViewText(0x7F0A00B8, "");  // id:artist_name
        int v = ColorUtils.getColor(context0, 0x7F0604B4);  // color:white500e_support_high_contrast
        int v1 = ColorUtils.getColor(context0, 0x7F0604A1);  // color:white000e
        int v2 = SamsungEdgeUtils.getChartMode();
        switch(v2) {
            case 0: {
                remoteViews0.setInt(0x7F0A0CAE, "setTextColor", v1);  // id:tv_melon_chart
                remoteViews0.setInt(0x7F0A0CAF, "setTextColor", v);  // id:tv_melon_dj
                remoteViews0.setInt(0x7F0A0D2A, "setTextColor", v);  // id:tv_theme_genre
                break;
            }
            case 1: {
                remoteViews0.setInt(0x7F0A0CAE, "setTextColor", v);  // id:tv_melon_chart
                remoteViews0.setInt(0x7F0A0CAF, "setTextColor", v1);  // id:tv_melon_dj
                remoteViews0.setInt(0x7F0A0D2A, "setTextColor", v);  // id:tv_theme_genre
                break;
            }
            default: {
                if(v2 == 2) {
                    remoteViews0.setInt(0x7F0A0CAE, "setTextColor", v);  // id:tv_melon_chart
                    remoteViews0.setInt(0x7F0A0CAF, "setTextColor", v);  // id:tv_melon_dj
                    remoteViews0.setInt(0x7F0A0D2A, "setTextColor", v1);  // id:tv_theme_genre
                }
            }
        }
        this.setAlbumInfoPendingIntent(context0, remoteViews0, 0x7F0A008F, playable0);  // id:album_title
        if(playable0 == null) {
            remoteViews0.setOnClickPendingIntent(0x7F0A00B8, null);  // id:artist_name
        }
        else if(!playable0.isMelonSong() || !playable0.hasSongId()) {
            remoteViews0.setOnClickPendingIntent(0x7F0A00B8, null);  // id:artist_name
        }
        else {
            Playable playable1 = Playable.copyValueOf(playable0);
            if(playable1.isTypeOfSong() && playable1.isOriginLocal()) {
                playable1.updateFrom(Song.e(playable1, true));
            }
            String s = playable1.getArtistid();
            if(TextUtils.isEmpty(s)) {
                remoteViews0.setOnClickPendingIntent(0x7F0A00B8, null);  // id:artist_name
            }
            else {
                Intent intent0 = new Intent(context0, MusicBrowserActivity.class);
                intent0.setAction("android.intent.action.VIEW");
                HashMap hashMap0 = new HashMap();
                hashMap0.put("ref", "W60302");
                intent0.setData(f.b(r8.c.b, s, hashMap0));
                remoteViews0.setOnClickPendingIntent(0x7F0A00B8, PendingIntent.getActivity(context0, Actor.EdgeSinglePlus.ordinal(), intent0, 0xC000000));  // id:artist_name
            }
        }
        remoteViews0.setOnClickPendingIntent(0x7F0A0CAE, CocktailPlayerPanelProvider.d(context0, 0x7F0A0CAE));  // id:tv_melon_chart
        remoteViews0.setOnClickPendingIntent(0x7F0A0CAF, CocktailPlayerPanelProvider.d(context0, 0x7F0A0CAF));  // id:tv_melon_dj
        remoteViews0.setOnClickPendingIntent(0x7F0A0D2A, CocktailPlayerPanelProvider.d(context0, 0x7F0A0D2A));  // id:tv_theme_genre
        return remoteViews0;
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider
    public void onReceive(Context context0, Intent intent0) {
        super.onReceive(context0, intent0);
        if(SlookCompat.getInstance().isSupported(context0)) {
            if(intent0 == null) {
                LogU.e("CocktailPlayerPanelProvider", "onReceive() Intent instance is null.");
                return;
            }
            String s = intent0.getAction();
            if("android.appwidget.action.APPWIDGET_UPDATE".equals(s)) {
                s = intent0.getStringExtra("com.iloen.melon.intent.action");
            }
            if(!TextUtils.isEmpty(s)) {
                LogU.d("CocktailPlayerPanelProvider", "onReceive: " + s);
                s.getClass();
            alab1:
                switch(s) {
                    case "action_slook_lookup_song": {
                        Playable playable0 = (Playable)intent0.getParcelableExtra("extra_playable");
                        Playable playable1 = Playable.copyValueOf(playable0);
                        if(playable0.isTypeOfSong() && playable0.isOriginLocal()) {
                            playable1.updateFrom(Song.e(playable0, true));
                            return;
                        }
                        ToastManager.showShort(0x7F13019A);  // string:cannot_find_album_info "앨범 정보가 없습니다."
                        return;
                    }
                    case "com.example.cocktailslooksample.action.ACTION_PULL_TO_REFRESH": {
                        LogU.i("CocktailPlayerPanelProvider", "forceRefreshContents()");
                        SamsungEdgeUtils.clearResponseCache(context0);
                        LogU.d("CocktailPlayerPanelProvider", "updatePanels()");
                        DjTodayReqDelegate djTodayReqDelegate0 = new DjTodayReqDelegate(context0);
                        this.e(context0).request(djTodayReqDelegate0, new CocktailPlayerPanelProvider.1(this, context0));
                        return;
                    }
                    case "com.example.cocktailslooksample.action.ACTION_REMOTE_CLICK": {
                        int v = intent0.getIntExtra("id", -1);
                        if(v == 0x7F0A0CAE) {  // id:tv_melon_chart
                            this.a(context0, 0);
                            return;
                        }
                        switch(v) {
                            case 0x7F0A0729: {  // id:layout_melon_dj_today_container
                                if(MelonAppBase.instance.isAppPip()) {
                                    ToastManager.show(0x7F130391);  // string:end_pip "PIP 모드를 종료하고 이용해주세요."
                                    return;
                                }
                                if(this.a == null) {
                                    this.a = new SlookListReqDelegator(context0);
                                }
                                DjTodayReqDelegate djTodayReqDelegate1 = new DjTodayReqDelegate(context0);
                                this.e(context0).request(djTodayReqDelegate1, new CocktailPlayerPanelProvider.6(this));
                                return;
                            }
                            case 0x7F0A0CAF: {  // id:tv_melon_dj
                                this.a(context0, 1);
                                return;
                            }
                            case 0x7F0A0D2A: {  // id:tv_theme_genre
                                this.a(context0, 2);
                                return;
                            label_47:
                                CocktailPlayerKt cocktailPlayerKt0 = this.c;
                                if(v == 0x7F0A0708) {  // id:layout_chart_type
                                    if(MelonAppBase.instance.isAppPip()) {
                                        ToastManager.show(0x7F130391);  // string:end_pip "PIP 모드를 종료하고 이용해주세요."
                                        return;
                                    }
                                    if(SamsungEdgeUtils.getChartMode() != 0) {
                                        LogU.w("CocktailPlayerPanelProvider", "playMelonChartList() chartMode is not CHART_MODE_DAILY_SONG.");
                                        return;
                                    }
                                    ChartHitsEdgeSongChartListRes chartHitsEdgeSongChartListRes0 = (ChartHitsEdgeSongChartListRes)this.b(context0, 0);
                                    if(chartHitsEdgeSongChartListRes0 != null) {
                                        RESPONSE chartHitsEdgeSongChartListRes$RESPONSE0 = chartHitsEdgeSongChartListRes0.response;
                                        if(chartHitsEdgeSongChartListRes$RESPONSE0 != null) {
                                            cocktailPlayerKt0.playSongs(Playable.getListFromSongBaseArrayOnlyCanService(chartHitsEdgeSongChartListRes$RESPONSE0.hitsSongList, "1000001515", null));
                                        }
                                    }
                                    g.f0("R01", "T11", "P1");
                                    return;
                                }
                                if(v == 0x7F0A09E6) {  // id:remote_list
                                    int v1 = intent0.getIntExtra("chart_mode", -1);
                                    int v2 = intent0.getIntExtra("item_id", -1);
                                    if(v1 > -1 || v2 > -1) {
                                        if(MelonAppBase.instance.isAppPip()) {
                                            ToastManager.show(0x7F130391);  // string:end_pip "PIP 모드를 종료하고 이용해주세요."
                                            return;
                                        }
                                        HttpResponse httpResponse0 = this.b(context0, v1);
                                        if(httpResponse0 == null) {
                                            LogU.w("CocktailPlayerPanelProvider", "playListItem() httpResponse is null.");
                                            return;
                                        }
                                        if(v1 != 0) {
                                            a a0 = this.f;
                                            switch(v1) {
                                                case 1: {
                                                    if(!(httpResponse0 instanceof DjPopularListPlylstForEdgeRes)) {
                                                        g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(1), "T11", "P1");
                                                        return;
                                                    }
                                                    response djPopularListPlylstForEdgeRes$response0 = ((DjPopularListPlylstForEdgeRes)httpResponse0).response;
                                                    if(djPopularListPlylstForEdgeRes$response0 != null && (djPopularListPlylstForEdgeRes$response0.plylstList != null && djPopularListPlylstForEdgeRes$response0.plylstList.size() >= 1)) {
                                                        com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes.response.PLYLSTLIST djPopularListPlylstForEdgeRes$response$PLYLSTLIST0 = (com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes.response.PLYLSTLIST)((DjPopularListPlylstForEdgeRes)httpResponse0).response.plylstList.get(v2);
                                                        if(djPopularListPlylstForEdgeRes$response$PLYLSTLIST0 != null && !TextUtils.isEmpty(djPopularListPlylstForEdgeRes$response$PLYLSTLIST0.plylstseq)) {
                                                            cocktailPlayerKt0.playPlaylist(a0, djPopularListPlylstForEdgeRes$response$PLYLSTLIST0.plylstseq, "1000001515");
                                                            g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(1), "T11", "P1");
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    if(!(httpResponse0 instanceof DjThemeListPlylstForEdgeRes)) {
                                                        g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(2), "T11", "P1");
                                                        return;
                                                    }
                                                    com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response djThemeListPlylstForEdgeRes$response0 = ((DjThemeListPlylstForEdgeRes)httpResponse0).response;
                                                    if(djThemeListPlylstForEdgeRes$response0 != null && (djThemeListPlylstForEdgeRes$response0.plylstList != null && djThemeListPlylstForEdgeRes$response0.plylstList.size() >= 1)) {
                                                        com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response.PLYLSTLIST djThemeListPlylstForEdgeRes$response$PLYLSTLIST0 = (com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response.PLYLSTLIST)((DjThemeListPlylstForEdgeRes)httpResponse0).response.plylstList.get(v2);
                                                        if(djThemeListPlylstForEdgeRes$response$PLYLSTLIST0 != null && !TextUtils.isEmpty(djThemeListPlylstForEdgeRes$response$PLYLSTLIST0.plylstseq)) {
                                                            cocktailPlayerKt0.playPlaylist(a0, djThemeListPlylstForEdgeRes$response$PLYLSTLIST0.plylstseq, "1000001515");
                                                            g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(2), "T11", "P1");
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(v1), "T11", "P1");
                                                    return;
                                                }
                                            }
                                        }
                                        else if(httpResponse0 instanceof ChartHitsEdgeSongChartListRes) {
                                            RESPONSE chartHitsEdgeSongChartListRes$RESPONSE1 = ((ChartHitsEdgeSongChartListRes)httpResponse0).response;
                                            if(chartHitsEdgeSongChartListRes$RESPONSE1 != null) {
                                                ArrayList arrayList0 = chartHitsEdgeSongChartListRes$RESPONSE1.hitsSongList;
                                                if(arrayList0 != null && !arrayList0.isEmpty() && v2 >= 0 && v2 < arrayList0.size()) {
                                                    SongInfoBase songInfoBase0 = (SongInfoBase)arrayList0.get(v2);
                                                    if(songInfoBase0 != null) {
                                                        ArrayList arrayList1 = new ArrayList();
                                                        arrayList1.add(Playable.from(songInfoBase0, "1000001515", null));
                                                        cocktailPlayerKt0.playSongs(arrayList1);
                                                        g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(0), "T11", "P1");
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            g.f0(SamsungEdgeUtils.convertChartModeToClickLogArea(0), "T11", "P1");
                                        }
                                    }
                                }
                                break alab1;
                            }
                            default: {
                                goto label_47;
                            }
                        }
                    }
                    case "com.iloen.melon.intent.action.playback.statechanged": {
                        Message message0 = this.b.obtainMessage(1000, context0);
                        this.b.sendMessageDelayed(message0, 300L);
                    }
                }
            }
        }
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider
    public void onUpdate(Context context0, SlookCocktailManager slookCocktailManager0, int[] arr_v) {
        LogU.d("CocktailPlayerPanelProvider", "onUpdate()");
        LogU.d("CocktailPlayerPanelProvider", "updatePanels()");
        DjTodayReqDelegate djTodayReqDelegate0 = new DjTodayReqDelegate(context0);
        this.e(context0).request(djTodayReqDelegate0, new CocktailPlayerPanelProvider.1(this, context0));
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider
    public void onVisibilityChanged(Context context0, int v, int v1) {
        super.onVisibilityChanged(context0, v, v1);
        LogU.i("CocktailPlayerPanelProvider", "onVisibilityChanged() - visibility: " + v1);
        if(v1 == 1) {
            DjTodayReqDelegate djTodayReqDelegate0 = new DjTodayReqDelegate(context0);
            this.e(context0).request(djTodayReqDelegate0, new DelegateEventListener() {
                public final Context a;
                public final CocktailPlayerPanelProvider b;

                {
                    Context context0 = context0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.b = cocktailPlayerPanelProvider0;
                    this.a = context0;
                }

                @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
                public void onFailed() {
                    this.b.performUpdate(this.a, false);
                    this.b.c(this.a);
                }

                @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
                public void onSuccess(HttpResponse httpResponse0) {
                    this.b.performUpdate(this.a, false);
                    this.b.c(this.a);
                }
            });
            O.a(new PvLogDummyReq(context0, "samsungEdgePanel"));
        }
    }

    public void performUpdate(Context context0, boolean z) {
        try {
            SlookCocktailManager slookCocktailManager0 = SlookCocktailManager.getInstance(context0);
            int[] arr_v = slookCocktailManager0.getCocktailIds(new ComponentName("com.iloen.melon", this.getClass().getName()));
            for(int v = 0; v < arr_v.length; ++v) {
                int v1 = arr_v[v];
                slookCocktailManager0.updateCocktail(v1, this.f(context0, z), this.g(context0));
                Intent intent0 = new Intent(context0, CocktailPlayerPanelProvider.class);
                intent0.setAction("com.example.cocktailslooksample.action.ACTION_PULL_TO_REFRESH");
                PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, 0xFF, intent0, 0xC000000);
                SlookCocktailManager.getInstance(context0).setOnPullPendingIntent(v1, 0x7F0A09E6, pendingIntent0);  // id:remote_list
            }
        }
        catch(Error | Exception unused_ex) {
        }
    }

    public void setAlbumInfoPendingIntent(Context context0, RemoteViews remoteViews0, int v, Playable playable0) {
        Intent intent0 = new Intent(context0, MusicBrowserActivity.class);
        intent0.setAction("com.iloen.melon.ALBUM_INFO");
        intent0.putExtra("com.iloen.melon.intent.extra.actor", Actor.EdgeSinglePlus);
        remoteViews0.setOnClickPendingIntent(v, PendingIntent.getActivity(context0, Actor.EdgeSinglePlus.ordinal(), intent0, 0xC000000));
    }
}

