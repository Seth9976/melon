package com.iloen.melon.playback.playlist;

import android.content.Context;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq.ParamInfo;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.request.ArtistPlaylistConnectedSongReq;
import com.iloen.melon.net.v6x.request.AutoplayMixPlayReq.Params;
import com.iloen.melon.net.v6x.request.AutoplayMixPlayReq;
import com.iloen.melon.net.v6x.request.DjConnectedPlaylistSongsReq;
import com.iloen.melon.net.v6x.request.MyMusicLikeListLikeSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistConnectedListSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistPlayListSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistRecentListSongRecntReq;
import com.iloen.melon.net.v6x.response.ArtistplaylistConnectedSongRes;
import com.iloen.melon.net.v6x.response.AutoplayMixPlayRes.RESPONSE.STATSELEMENTS;
import com.iloen.melon.net.v6x.response.AutoplayMixPlayRes;
import com.iloen.melon.net.v6x.response.DjConnectedPlaylistSongsRes;
import com.iloen.melon.net.v6x.response.MyMusicLikeListLikeSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistConnectedListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistPlayListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistRecentListSongRecntRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.DsPlyOrderData;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import e1.u;
import ie.H;
import java.util.ArrayList;
import je.w;
import k8.Y;
import k9.g;
import k9.h;
import k9.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u000FJ\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0012J\"\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0018J\"\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0018J&\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\"J \u0010#\u001A\u00020$2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010\u0018J:\u0010%\u001A\b\u0012\u0004\u0012\u00020\'0&2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\b\u0010(\u001A\u0004\u0018\u00010)2\b\u0010!\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086@\u00A2\u0006\u0002\u0010*R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T\u00A2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t\u00A8\u0006+"}, d2 = {"Lcom/iloen/melon/playback/playlist/PlaylistUtil;", "", "<init>", "()V", "TAG", "", "log", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "requestStreamGetAutoplayMixPlay", "Lcom/iloen/melon/net/v6x/response/AutoplayMixPlayRes;", "params", "Lcom/iloen/melon/net/v6x/request/AutoplayMixPlayReq$Params;", "tag", "(Lcom/iloen/melon/net/v6x/request/AutoplayMixPlayReq$Params;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestStreamGetMyMusicLikeListLikeSong", "Lcom/iloen/melon/net/v6x/response/MyMusicLikeListLikeSongRes;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestStreamGetMyMusicPlaylistRecentListSongRecnt", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistRecentListSongRecntRes;", "requestStreamGetMyMusicPlaylistConnectedListSong", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistConnectedListSongRes;", "playlistSeq", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestStreamGetArtistPlaylistConnectedSong", "Lcom/iloen/melon/net/v6x/response/ArtistplaylistConnectedSongRes;", "requestStreamGetDjConnectedPlaylistSongs", "Lcom/iloen/melon/net/v6x/response/DjConnectedPlaylistSongsRes;", "getTabSmartPlaylistListPlayable", "Lcom/iloen/melon/playback/playlist/PlaylistListType;", "playlistInfo", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "menuId", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestStreamGetMyPlaylistInfo", "Lcom/iloen/melon/net/HttpResponse;", "getPlayablesMyPlaylistInfo", "", "Lcom/iloen/melon/playback/Playable;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistUtil {
    public static final int $stable = 0;
    @NotNull
    public static final PlaylistUtil INSTANCE = null;
    @NotNull
    public static final String TAG = "PlaylistUtil";
    @NotNull
    private static final LogU log;

    static {
        PlaylistUtil.INSTANCE = new PlaylistUtil();
        PlaylistUtil.log = LogU.Companion.create("PlaylistUtil", false, Category.None);
        PlaylistUtil.$stable = 8;
    }

    @NotNull
    public final LogU getLog() {
        return PlaylistUtil.log;
    }

    @Nullable
    public final Object getPlayablesMyPlaylistInfo(@Nullable String s, @Nullable StatsElementsBase statsElementsBase0, @Nullable String s1, @NotNull String s2, @NotNull Continuation continuation0) {
        com.iloen.melon.playback.playlist.PlaylistUtil.getPlayablesMyPlaylistInfo.1 playlistUtil$getPlayablesMyPlaylistInfo$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.PlaylistUtil.getPlayablesMyPlaylistInfo.1) {
            playlistUtil$getPlayablesMyPlaylistInfo$10 = (com.iloen.melon.playback.playlist.PlaylistUtil.getPlayablesMyPlaylistInfo.1)continuation0;
            int v = playlistUtil$getPlayablesMyPlaylistInfo$10.label;
            if((v & 0x80000000) == 0) {
                playlistUtil$getPlayablesMyPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayablesMyPlaylistInfo(null, null, null, null, this);
                    }
                };
            }
            else {
                playlistUtil$getPlayablesMyPlaylistInfo$10.label = v ^ 0x80000000;
            }
        }
        else {
            playlistUtil$getPlayablesMyPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getPlayablesMyPlaylistInfo(null, null, null, null, this);
                }
            };
        }
        Object object0 = playlistUtil$getPlayablesMyPlaylistInfo$10.result;
        a a0 = a.a;
        switch(playlistUtil$getPlayablesMyPlaylistInfo$10.label) {
            case 0: {
                n.D(object0);
                playlistUtil$getPlayablesMyPlaylistInfo$10.L$0 = s;
                playlistUtil$getPlayablesMyPlaylistInfo$10.L$1 = statsElementsBase0;
                playlistUtil$getPlayablesMyPlaylistInfo$10.L$2 = s1;
                playlistUtil$getPlayablesMyPlaylistInfo$10.L$3 = null;
                playlistUtil$getPlayablesMyPlaylistInfo$10.label = 1;
                object0 = this.requestStreamGetMyPlaylistInfo(s, s2, playlistUtil$getPlayablesMyPlaylistInfo$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                String s3 = (String)playlistUtil$getPlayablesMyPlaylistInfo$10.L$3;
                s1 = (String)playlistUtil$getPlayablesMyPlaylistInfo$10.L$2;
                statsElementsBase0 = (StatsElementsBase)playlistUtil$getPlayablesMyPlaylistInfo$10.L$1;
                s = (String)playlistUtil$getPlayablesMyPlaylistInfo$10.L$0;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0) instanceof MyMusicPlaylistPlayListSongRes && ((HttpResponse)object0).isSuccessful()) {
            RESPONSE playlistListSongBaseRes$RESPONSE0 = ((MyMusicPlaylistPlayListSongRes)(((HttpResponse)object0))).response;
            if(playlistListSongBaseRes$RESPONSE0 != null) {
                ArrayList arrayList0 = playlistListSongBaseRes$RESPONSE0.songList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    StatsElementsBase statsElementsBase1 = StatsElementsBase.mergeStatsElements(statsElementsBase0, ((MyMusicPlaylistPlayListSongRes)(((HttpResponse)object0))).getStatsElements());
                    if(statsElementsBase1 != null && q.b("N10009", statsElementsBase1.parentContsType)) {
                        Context context0 = Y.a(MelonAppBase.Companion);
                        ParamInfo djPlaylistPlayLogReq$ParamInfo0 = new ParamInfo();
                        djPlaylistPlayLogReq$ParamInfo0.plylstSeq = s;
                        ReportService.sendLogging(new DjPlaylistPlayLogReq(context0, djPlaylistPlayLogReq$ParamInfo0));
                    }
                    ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, s1, statsElementsBase1);
                    q.f(arrayList1, "getListFromSongBaseArrayOnlyCanService(...)");
                    return arrayList1;
                }
            }
        }
        return w.a;
    }

    @Nullable
    public final Object getTabSmartPlaylistListPlayable(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0, @NotNull String s, @NotNull String s1, @NotNull Continuation continuation0) {
        ArrayList arrayList0;
        STATSELEMENTS autoplayMixPlayRes$RESPONSE$STATSELEMENTS0;
        com.iloen.melon.playback.playlist.PlaylistUtil.getTabSmartPlaylistListPlayable.1 playlistUtil$getTabSmartPlaylistListPlayable$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.PlaylistUtil.getTabSmartPlaylistListPlayable.1) {
            playlistUtil$getTabSmartPlaylistListPlayable$10 = (com.iloen.melon.playback.playlist.PlaylistUtil.getTabSmartPlaylistListPlayable.1)continuation0;
            int v = playlistUtil$getTabSmartPlaylistListPlayable$10.label;
            if((v & 0x80000000) == 0) {
                playlistUtil$getTabSmartPlaylistListPlayable$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getTabSmartPlaylistListPlayable(null, null, null, this);
                    }
                };
            }
            else {
                playlistUtil$getTabSmartPlaylistListPlayable$10.label = v ^ 0x80000000;
            }
        }
        else {
            playlistUtil$getTabSmartPlaylistListPlayable$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getTabSmartPlaylistListPlayable(null, null, null, this);
                }
            };
        }
        Object object0 = playlistUtil$getTabSmartPlaylistListPlayable$10.result;
        a a0 = a.a;
        switch(playlistUtil$getTabSmartPlaylistListPlayable$10.label) {
            case 0: {
                n.D(object0);
                if(drawerPlaylistInfo0.getSeedContsId().length() > 0 && drawerPlaylistInfo0.getSeedContsTypeCode().length() > 0) {
                    Params autoplayMixPlayReq$Params0 = new Params(drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getSeedContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getMenuId());
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 1;
                    object0 = this.requestStreamGetAutoplayMixPlay(autoplayMixPlayReq$Params0, s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 != a0) {
                        goto label_66;
                    }
                }
                else if(q.b(drawerPlaylistInfo0.getContsId(), "PlaylistSeqLike")) {
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 2;
                    object0 = this.requestStreamGetMyMusicLikeListLikeSong(s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 != a0) {
                        goto label_87;
                    }
                }
                else if(q.b(drawerPlaylistInfo0.getContsId(), "PlaylistSeqRecent")) {
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 3;
                    object0 = this.requestStreamGetMyMusicPlaylistRecentListSongRecnt(s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 != a0) {
                        goto label_108;
                    }
                }
                else if(q.b(drawerPlaylistInfo0.getContsTypeCode(), "N10006")) {
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 4;
                    object0 = this.requestStreamGetArtistPlaylistConnectedSong(drawerPlaylistInfo0.getContsId(), s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 != a0) {
                        goto label_129;
                    }
                }
                else if(q.b(drawerPlaylistInfo0.getContsTypeCode(), "N10009")) {
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 5;
                    object0 = this.requestStreamGetDjConnectedPlaylistSongs(drawerPlaylistInfo0.getContsId(), s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 != a0) {
                        goto label_150;
                    }
                }
                else {
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$0 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$1 = null;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.L$2 = s1;
                    playlistUtil$getTabSmartPlaylistListPlayable$10.label = 6;
                    object0 = this.requestStreamGetMyMusicPlaylistConnectedListSong(drawerPlaylistInfo0.getContsId(), s, playlistUtil$getTabSmartPlaylistListPlayable$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_171;
                }
                return a0;
            }
            case 1: {
                s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
                String s2 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
                DrawerPlaylistInfo drawerPlaylistInfo1 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
                n.D(object0);
            label_66:
                if(((AutoplayMixPlayRes)object0) == null) {
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.AutoplayMixPlayRes.RESPONSE autoplayMixPlayRes$RESPONSE0 = ((AutoplayMixPlayRes)object0).response;
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = autoplayMixPlayRes$RESPONSE0 == null ? null : autoplayMixPlayRes$RESPONSE0.statsElements;
                }
                if(((AutoplayMixPlayRes)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.AutoplayMixPlayRes.RESPONSE autoplayMixPlayRes$RESPONSE1 = ((AutoplayMixPlayRes)object0).response;
                    arrayList0 = autoplayMixPlayRes$RESPONSE1 == null ? null : autoplayMixPlayRes$RESPONSE1.songList;
                }
                goto label_187;
            }
            case 2: {
                s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
                String s3 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
                DrawerPlaylistInfo drawerPlaylistInfo2 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
                n.D(object0);
            label_87:
                if(((MyMusicLikeListLikeSongRes)object0) == null) {
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.MyMusicLikeListLikeSongRes.RESPONSE myMusicLikeListLikeSongRes$RESPONSE0 = ((MyMusicLikeListLikeSongRes)object0).response;
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = myMusicLikeListLikeSongRes$RESPONSE0 == null ? null : myMusicLikeListLikeSongRes$RESPONSE0.statsElements;
                }
                if(((MyMusicLikeListLikeSongRes)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.MyMusicLikeListLikeSongRes.RESPONSE myMusicLikeListLikeSongRes$RESPONSE1 = ((MyMusicLikeListLikeSongRes)object0).response;
                    arrayList0 = myMusicLikeListLikeSongRes$RESPONSE1 == null ? null : myMusicLikeListLikeSongRes$RESPONSE1.songList;
                }
                goto label_187;
            }
            case 3: {
                s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
                String s4 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
                DrawerPlaylistInfo drawerPlaylistInfo3 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
                n.D(object0);
            label_108:
                if(((MyMusicPlaylistRecentListSongRecntRes)object0) == null) {
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.MyMusicPlaylistRecentListSongRecntRes.RESPONSE myMusicPlaylistRecentListSongRecntRes$RESPONSE0 = ((MyMusicPlaylistRecentListSongRecntRes)object0).response;
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = myMusicPlaylistRecentListSongRecntRes$RESPONSE0 == null ? null : myMusicPlaylistRecentListSongRecntRes$RESPONSE0.statsElements;
                }
                if(((MyMusicPlaylistRecentListSongRecntRes)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.MyMusicPlaylistRecentListSongRecntRes.RESPONSE myMusicPlaylistRecentListSongRecntRes$RESPONSE1 = ((MyMusicPlaylistRecentListSongRecntRes)object0).response;
                    arrayList0 = myMusicPlaylistRecentListSongRecntRes$RESPONSE1 == null ? null : myMusicPlaylistRecentListSongRecntRes$RESPONSE1.songList;
                }
                goto label_187;
            }
            case 4: {
                s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
                String s5 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
                DrawerPlaylistInfo drawerPlaylistInfo4 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
                n.D(object0);
            label_129:
                if(((ArtistplaylistConnectedSongRes)object0) == null) {
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.ArtistplaylistConnectedSongRes.RESPONSE artistplaylistConnectedSongRes$RESPONSE0 = ((ArtistplaylistConnectedSongRes)object0).response;
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = artistplaylistConnectedSongRes$RESPONSE0 == null ? null : artistplaylistConnectedSongRes$RESPONSE0.statsElements;
                }
                if(((ArtistplaylistConnectedSongRes)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.ArtistplaylistConnectedSongRes.RESPONSE artistplaylistConnectedSongRes$RESPONSE1 = ((ArtistplaylistConnectedSongRes)object0).response;
                    arrayList0 = artistplaylistConnectedSongRes$RESPONSE1 == null ? null : artistplaylistConnectedSongRes$RESPONSE1.songList;
                }
                goto label_187;
            }
            case 5: {
                s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
                String s6 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
                DrawerPlaylistInfo drawerPlaylistInfo5 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
                n.D(object0);
            label_150:
                if(((DjConnectedPlaylistSongsRes)object0) == null) {
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.DjConnectedPlaylistSongsRes.RESPONSE djConnectedPlaylistSongsRes$RESPONSE0 = ((DjConnectedPlaylistSongsRes)object0).response;
                    autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = djConnectedPlaylistSongsRes$RESPONSE0 == null ? null : djConnectedPlaylistSongsRes$RESPONSE0.statsElements;
                }
                if(((DjConnectedPlaylistSongsRes)object0) == null) {
                    arrayList0 = null;
                }
                else {
                    com.iloen.melon.net.v6x.response.DjConnectedPlaylistSongsRes.RESPONSE djConnectedPlaylistSongsRes$RESPONSE1 = ((DjConnectedPlaylistSongsRes)object0).response;
                    arrayList0 = djConnectedPlaylistSongsRes$RESPONSE1 == null ? null : djConnectedPlaylistSongsRes$RESPONSE1.songList;
                }
                goto label_187;
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        s1 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$2;
        String s7 = (String)playlistUtil$getTabSmartPlaylistListPlayable$10.L$1;
        DrawerPlaylistInfo drawerPlaylistInfo6 = (DrawerPlaylistInfo)playlistUtil$getTabSmartPlaylistListPlayable$10.L$0;
        n.D(object0);
    label_171:
        if(((MyMusicPlaylistConnectedListSongRes)object0) == null) {
            autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = null;
        }
        else {
            com.iloen.melon.net.v6x.response.MyMusicPlaylistConnectedListSongRes.RESPONSE myMusicPlaylistConnectedListSongRes$RESPONSE0 = ((MyMusicPlaylistConnectedListSongRes)object0).response;
            autoplayMixPlayRes$RESPONSE$STATSELEMENTS0 = myMusicPlaylistConnectedListSongRes$RESPONSE0 == null ? null : myMusicPlaylistConnectedListSongRes$RESPONSE0.statsElements;
        }
        if(((MyMusicPlaylistConnectedListSongRes)object0) == null) {
            arrayList0 = null;
        }
        else {
            com.iloen.melon.net.v6x.response.MyMusicPlaylistConnectedListSongRes.RESPONSE myMusicPlaylistConnectedListSongRes$RESPONSE1 = ((MyMusicPlaylistConnectedListSongRes)object0).response;
            arrayList0 = myMusicPlaylistConnectedListSongRes$RESPONSE1 == null ? null : myMusicPlaylistConnectedListSongRes$RESPONSE1.songList;
        }
    label_187:
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, s1, autoplayMixPlayRes$RESPONSE$STATSELEMENTS0);
            q.f(arrayList1, "getListFromSongBaseArrayOnlyCanService(...)");
            ArrayList arrayList2 = new ArrayList();
            for(Object object1: arrayList0) {
                if(((PlaylistSongInfoBase)object1).canService) {
                    arrayList2.add(object1);
                }
            }
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object2: arrayList2) {
                String s8 = ((PlaylistSongInfoBase)object2).dsplyOrder;
                q.f(s8, "dsplyOrder");
                arrayList3.add(new DsPlyOrderData(s8, ((PlaylistSongInfoBase)object2).songId));
            }
            return new PlaylistListType(arrayList1, arrayList3);
        }
        return new PlaylistListType(null, null, 3, null);
    }

    @Nullable
    public final Object requestStreamGetArtistPlaylistConnectedSong(@Nullable String s, @NotNull String s1, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(s1, null) {
            final String $playlistSeq;
            final String $tag;
            int label;

            {
                this.$playlistSeq = s;
                this.$tag = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetArtistPlaylistConnectedSong.2(this.$playlistSeq, this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetArtistPlaylistConnectedSong.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.h;
                if(z) {
                    return h.f(g0, ArtistplaylistConnectedSongRes.class, new String[]{this.$playlistSeq});
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new ArtistPlaylistConnectedSongReq(Y.a(MelonAppBase.Companion), this.$playlistSeq)).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                ArtistplaylistConnectedSongRes artistplaylistConnectedSongRes0 = httpResponse0 instanceof ArtistplaylistConnectedSongRes ? ((ArtistplaylistConnectedSongRes)httpResponse0) : null;
                if(j.c()) {
                    h.h(g0, artistplaylistConnectedSongRes0, PlaylistId.DRAWER.getSeq(), new String[]{this.$playlistSeq});
                }
                return artistplaylistConnectedSongRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetAutoplayMixPlay(@Nullable Params autoplayMixPlayReq$Params0, @NotNull String s, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(s, null) {
            final Params $params;
            final String $tag;
            int label;

            {
                this.$params = autoplayMixPlayReq$Params0;
                this.$tag = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetAutoplayMixPlay.2(this.$params, this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetAutoplayMixPlay.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.g;
                String s = null;
                if(z) {
                    Params autoplayMixPlayReq$Params0 = this.$params;
                    String s1 = autoplayMixPlayReq$Params0 == null ? null : autoplayMixPlayReq$Params0.contsId;
                    String s2 = autoplayMixPlayReq$Params0 == null ? null : autoplayMixPlayReq$Params0.seedContsId;
                    if(autoplayMixPlayReq$Params0 != null) {
                        s = autoplayMixPlayReq$Params0.seedContsTypeCode;
                    }
                    return h.f(g0, AutoplayMixPlayRes.class, new String[]{s1, s2, s});
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new AutoplayMixPlayReq(Y.a(MelonAppBase.Companion), this.$params)).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                AutoplayMixPlayRes autoplayMixPlayRes0 = httpResponse0 instanceof AutoplayMixPlayRes ? ((AutoplayMixPlayRes)httpResponse0) : null;
                if(j.c()) {
                    int v = PlaylistId.DRAWER.getSeq();
                    Params autoplayMixPlayReq$Params1 = this.$params;
                    String s3 = autoplayMixPlayReq$Params1 == null ? null : autoplayMixPlayReq$Params1.contsId;
                    String s4 = autoplayMixPlayReq$Params1 == null ? null : autoplayMixPlayReq$Params1.seedContsId;
                    if(autoplayMixPlayReq$Params1 != null) {
                        s = autoplayMixPlayReq$Params1.seedContsTypeCode;
                    }
                    h.h(g0, autoplayMixPlayRes0, v, new String[]{s3, s4, s});
                }
                return autoplayMixPlayRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetDjConnectedPlaylistSongs(@Nullable String s, @NotNull String s1, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(s1, null) {
            final String $playlistSeq;
            final String $tag;
            int label;

            {
                this.$playlistSeq = s;
                this.$tag = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetDjConnectedPlaylistSongs.2(this.$playlistSeq, this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetDjConnectedPlaylistSongs.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.l;
                if(z) {
                    return h.f(g0, DjConnectedPlaylistSongsRes.class, new String[]{this.$playlistSeq});
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new DjConnectedPlaylistSongsReq(Y.a(MelonAppBase.Companion), this.$playlistSeq)).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                DjConnectedPlaylistSongsRes djConnectedPlaylistSongsRes0 = httpResponse0 instanceof DjConnectedPlaylistSongsRes ? ((DjConnectedPlaylistSongsRes)httpResponse0) : null;
                if(j.c()) {
                    h.h(g0, djConnectedPlaylistSongsRes0, PlaylistId.DRAWER.getSeq(), new String[]{this.$playlistSeq});
                }
                return djConnectedPlaylistSongsRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetMyMusicLikeListLikeSong(@NotNull String s, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(null) {
            final String $tag;
            int label;

            {
                this.$tag = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicLikeListLikeSong.2(this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicLikeListLikeSong.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.j;
                if(z) {
                    return h.f(g0, MyMusicLikeListLikeSongRes.class, new String[0]);
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicLikeListLikeSongReq(Y.a(MelonAppBase.Companion))).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                MyMusicLikeListLikeSongRes myMusicLikeListLikeSongRes0 = httpResponse0 instanceof MyMusicLikeListLikeSongRes ? ((MyMusicLikeListLikeSongRes)httpResponse0) : null;
                if(j.c()) {
                    h.h(g0, myMusicLikeListLikeSongRes0, PlaylistId.DRAWER.getSeq(), new String[0]);
                }
                return myMusicLikeListLikeSongRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetMyMusicPlaylistConnectedListSong(@Nullable String s, @NotNull String s1, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(s1, null) {
            final String $playlistSeq;
            final String $tag;
            int label;

            {
                this.$playlistSeq = s;
                this.$tag = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicPlaylistConnectedListSong.2(this.$playlistSeq, this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicPlaylistConnectedListSong.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.k;
                if(z) {
                    return h.f(g0, MyMusicPlaylistConnectedListSongRes.class, new String[]{this.$playlistSeq});
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicPlaylistConnectedListSongReq(Y.a(MelonAppBase.Companion), this.$playlistSeq)).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                MyMusicPlaylistConnectedListSongRes myMusicPlaylistConnectedListSongRes0 = httpResponse0 instanceof MyMusicPlaylistConnectedListSongRes ? ((MyMusicPlaylistConnectedListSongRes)httpResponse0) : null;
                if(j.c()) {
                    h.h(g0, myMusicPlaylistConnectedListSongRes0, PlaylistId.DRAWER.getSeq(), new String[]{this.$playlistSeq});
                }
                return myMusicPlaylistConnectedListSongRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetMyMusicPlaylistRecentListSongRecnt(@NotNull String s, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(null) {
            final String $tag;
            int label;

            {
                this.$tag = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicPlaylistRecentListSongRecnt.2(this.$tag, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyMusicPlaylistRecentListSongRecnt.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                boolean z = j.b();
                g g0 = g.i;
                if(z) {
                    return h.f(g0, MyMusicPlaylistRecentListSongRecntRes.class, new String[0]);
                }
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicPlaylistRecentListSongRecntReq(Y.a(MelonAppBase.Companion), u.v(((e0)o.a()).j()))).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                MyMusicPlaylistRecentListSongRecntRes myMusicPlaylistRecentListSongRecntRes0 = httpResponse0 instanceof MyMusicPlaylistRecentListSongRecntRes ? ((MyMusicPlaylistRecentListSongRecntRes)httpResponse0) : null;
                if(j.c()) {
                    h.h(g0, myMusicPlaylistRecentListSongRecntRes0, PlaylistId.DRAWER.getSeq(), new String[0]);
                }
                return myMusicPlaylistRecentListSongRecntRes0;
            }
        }, continuation0);
    }

    @Nullable
    public final Object requestStreamGetMyPlaylistInfo(@Nullable String s, @NotNull String s1, @NotNull Continuation continuation0) {
        com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.1 playlistUtil$requestStreamGetMyPlaylistInfo$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.1) {
            playlistUtil$requestStreamGetMyPlaylistInfo$10 = (com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.1)continuation0;
            int v = playlistUtil$requestStreamGetMyPlaylistInfo$10.label;
            if((v & 0x80000000) == 0) {
                playlistUtil$requestStreamGetMyPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.requestStreamGetMyPlaylistInfo(null, null, this);
                    }
                };
            }
            else {
                playlistUtil$requestStreamGetMyPlaylistInfo$10.label = v ^ 0x80000000;
            }
        }
        else {
            playlistUtil$requestStreamGetMyPlaylistInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.requestStreamGetMyPlaylistInfo(null, null, this);
                }
            };
        }
        Object object0 = playlistUtil$requestStreamGetMyPlaylistInfo$10.result;
        a a0 = a.a;
        switch(playlistUtil$requestStreamGetMyPlaylistInfo$10.label) {
            case 0: {
                n.D(object0);
                com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.2 playlistUtil$requestStreamGetMyPlaylistInfo$20 = new we.n(s1, null) {
                    final String $playlistSeq;
                    final String $tag;
                    int label;

                    {
                        this.$playlistSeq = s;
                        this.$tag = s1;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.2(this.$playlistSeq, this.$tag, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.playlist.PlaylistUtil.requestStreamGetMyPlaylistInfo.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        return RequestBuilder.newInstance(new MyMusicPlaylistPlayListSongReq(Y.a(MelonAppBase.Companion), this.$playlistSeq)).tag(this.$tag).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    }
                };
                playlistUtil$requestStreamGetMyPlaylistInfo$10.L$0 = null;
                playlistUtil$requestStreamGetMyPlaylistInfo$10.L$1 = null;
                playlistUtil$requestStreamGetMyPlaylistInfo$10.label = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), playlistUtil$requestStreamGetMyPlaylistInfo$20, playlistUtil$requestStreamGetMyPlaylistInfo$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                String s2 = (String)playlistUtil$requestStreamGetMyPlaylistInfo$10.L$1;
                String s3 = (String)playlistUtil$requestStreamGetMyPlaylistInfo$10.L$0;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.f(object0, "withContext(...)");
        return object0;
    }
}

