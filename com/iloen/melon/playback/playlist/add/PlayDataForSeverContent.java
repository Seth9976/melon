package com.iloen.melon.playback.playlist.add;

import A7.d;
import Ba.B;
import Ba.Q;
import Ba.b;
import Ba.e;
import Cb.j;
import Ma.l;
import Ma.m;
import U4.x;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq.ParamInfo;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq;
import com.iloen.melon.net.v4x.response.HourlyChartListRes;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes.RESPONSE.MVLIST;
import com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes;
import com.iloen.melon.net.v4x.response.MelonTvVdoStreamInAppRes;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.CastDetailRes;
import com.iloen.melon.net.v6x.response.AlbumSongPlayListRes.RESPONSE.CdInfo;
import com.iloen.melon.net.v6x.response.AlbumSongPlayListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.AlbumSongPlayListRes;
import com.iloen.melon.net.v6x.response.ArtistMusicReqSongListRes;
import com.iloen.melon.net.v6x.response.ArtistplaylistConnectedSongRes;
import com.iloen.melon.net.v6x.response.AutoplayMixPlayRes;
import com.iloen.melon.net.v6x.response.DjConnectedPlaylistSongsRes;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.CHANNELINFO;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes;
import com.iloen.melon.net.v6x.response.MyMusicLikeListLikeSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistConnectedListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistRecentListSongRecntRes;
import com.iloen.melon.playback.Playable.Builder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistUtil;
import com.iloen.melon.playback.playlist.add.musicwave.AddMusicWaveDataSource;
import com.iloen.melon.playback.playlist.add.musicwave.AddMusicWaveRepository;
import com.iloen.melon.playback.playlist.add.musicwave.AddMusicWaveRepositoryImpl;
import com.iloen.melon.playback.playlist.add.mv.AddMVRepository;
import com.iloen.melon.playback.playlist.add.mv.AddMVRepositoryImpl;
import com.iloen.melon.playback.playlist.add.mv.AddMvRemoteDataSource;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo.DsPlyOrderData;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfoKt;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import d5.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import k8.Y;
import k8.o;
import kc.H1;
import kc.L1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import mb.k;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pc.d1;
import pc.w1;
import tg.U;
import va.e0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 $2\u00020\u0001:\f\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0014\u001A\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\u0082\u0001\u000B%&\'()*+,-./¨\u00060"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "", "<init>", "()V", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "menuId", "", "getMenuId", "()Ljava/lang/String;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "Song", "Album", "Playlist", "MV", "ChartTop100", "Station", "Artist", "Live", "DrawerPlaylist", "MixUp", "MusicWave", "Companion", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Album;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Artist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$ChartTop100;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$DrawerPlaylist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Live;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MV;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MixUp;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MusicWave;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Playlist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Song;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Station;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlayDataForSeverContent {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u0016\u001A\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001E\u001A\u00020\u00132\b\u0010\u001F\u001A\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001A\u00020\"HÖ\u0001J\t\u0010#\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0006\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0016\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Album;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "albumId", "", "cType", "Lcom/iloen/melon/constants/CType;", "menuId", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/constants/CType;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getAlbumId", "()Ljava/lang/String;", "getCType", "()Lcom/iloen/melon/constants/CType;", "getMenuId", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Album extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final String albumId;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public Album(@NotNull String s, @NotNull CType cType0, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "albumId");
            q.g(cType0, "cType");
            q.g(s1, "menuId");
            super(null);
            this.albumId = s;
            this.cType = cType0;
            this.menuId = s1;
            this.statsElements = statsElementsBase0;
        }

        @NotNull
        public final String component1() {
            return this.albumId;
        }

        @NotNull
        public final CType component2() {
            return this.cType;
        }

        @NotNull
        public final String component3() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component4() {
            return this.statsElements;
        }

        @NotNull
        public final Album copy(@NotNull String s, @NotNull CType cType0, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "albumId");
            q.g(cType0, "cType");
            q.g(s1, "menuId");
            return new Album(s, cType0, s1, statsElementsBase0);
        }

        public static Album copy$default(Album playDataForSeverContent$Album0, String s, CType cType0, String s1, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Album0.albumId;
            }
            if((v & 2) != 0) {
                cType0 = playDataForSeverContent$Album0.cType;
            }
            if((v & 4) != 0) {
                s1 = playDataForSeverContent$Album0.menuId;
            }
            if((v & 8) != 0) {
                statsElementsBase0 = playDataForSeverContent$Album0.statsElements;
            }
            return playDataForSeverContent$Album0.copy(s, cType0, s1, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Album)) {
                return false;
            }
            if(!q.b(this.albumId, ((Album)object0).albumId)) {
                return false;
            }
            if(!q.b(this.cType, ((Album)object0).cType)) {
                return false;
            }
            return q.b(this.menuId, ((Album)object0).menuId) ? q.b(this.statsElements, ((Album)object0).statsElements) : false;
        }

        @NotNull
        public final String getAlbumId() {
            return this.albumId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Album.getPlayableList.1 playDataForSeverContent$Album$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Album.getPlayableList.1) {
                playDataForSeverContent$Album$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Album.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Album$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Album$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Album$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Album$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Album$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Album$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    Ba.a a1 = (Ba.a)((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).M.get();
                    playDataForSeverContent$Album$getPlayableList$10.L$0 = null;
                    playDataForSeverContent$Album$getPlayableList$10.label = 1;
                    object0 = a1.a(this.albumId, playDataForSeverContent$Album$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    Ba.a a2 = (Ba.a)playDataForSeverContent$Album$getPlayableList$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            if(((ApiResult)object0) instanceof Success) {
                AlbumSongPlayListRes albumSongPlayListRes0 = (AlbumSongPlayListRes)((Success)(((ApiResult)object0))).getData();
                j.b(albumSongPlayListRes0.notification, false, 3);
                if(j.d(albumSongPlayListRes0)) {
                    RESPONSE albumSongPlayListRes$RESPONSE0 = albumSongPlayListRes0.response;
                    if(albumSongPlayListRes$RESPONSE0 == null) {
                        return EmptyAddRequestPlayableListInfo.INSTANCE;
                    }
                    ArrayList arrayList0 = albumSongPlayListRes$RESPONSE0.cdList;
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        ArrayList arrayList1 = new ArrayList();
                        Iterator iterator0 = arrayList0.iterator();
                        q.f(iterator0, "iterator(...)");
                        while(iterator0.hasNext()) {
                            Object object1 = iterator0.next();
                            ArrayList arrayList2 = ((CdInfo)object1).songList;
                            if(arrayList2 != null && !arrayList2.isEmpty()) {
                                arrayList1.addAll(Playable.getListFromSongBaseArrayOnlyCanService(arrayList2, this.getMenuId(), this.getStatsElements()));
                            }
                        }
                        return new CommonAddRequestPlayableListInfo(arrayList1);
                    }
                    return EmptyAddRequestPlayableListInfo.INSTANCE;
                }
            }
            throw new AddNormalException("playAlbum() {apiResult is not ApiResult.Success}");
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b((this.cType.hashCode() + this.albumId.hashCode() * 0x1F) * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Album(albumId=" + this.albumId + ", cType=" + this.cType + ", menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0016\u001A\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u00132\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FHÖ\u0003J\t\u0010 \u001A\u00020!HÖ\u0001J\t\u0010\"\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Artist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "artistId", "", "menuId", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getArtistId", "()Ljava/lang/String;", "getMenuId", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Artist extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final String artistId;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public Artist(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "artistId");
            q.g(s1, "menuId");
            super(null);
            this.artistId = s;
            this.menuId = s1;
            this.statsElements = statsElementsBase0;
            q.f(CType.ARTIST, "ARTIST");
            this.cType = CType.ARTIST;
        }

        @NotNull
        public final String component1() {
            return this.artistId;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final Artist copy(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "artistId");
            q.g(s1, "menuId");
            return new Artist(s, s1, statsElementsBase0);
        }

        public static Artist copy$default(Artist playDataForSeverContent$Artist0, String s, String s1, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Artist0.artistId;
            }
            if((v & 2) != 0) {
                s1 = playDataForSeverContent$Artist0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$Artist0.statsElements;
            }
            return playDataForSeverContent$Artist0.copy(s, s1, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Artist)) {
                return false;
            }
            if(!q.b(this.artistId, ((Artist)object0).artistId)) {
                return false;
            }
            return q.b(this.menuId, ((Artist)object0).menuId) ? q.b(this.statsElements, ((Artist)object0).statsElements) : false;
        }

        @NotNull
        public final String getArtistId() {
            return this.artistId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Artist.getPlayableList.1 playDataForSeverContent$Artist$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Artist.getPlayableList.1) {
                playDataForSeverContent$Artist$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Artist.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Artist$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Artist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Artist$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Artist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Artist$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Artist$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    if(this.artistId.length() == 0) {
                        throw new AddNormalException("playArtist() {artistId is invalid}");
                    }
                    b b0 = (b)((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).Q.get();
                    playDataForSeverContent$Artist$getPlayableList$10.label = 1;
                    object0 = b0.c(this.artistId, playDataForSeverContent$Artist$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            ArtistMusicReqSongListRes artistMusicReqSongListRes0 = (ArtistMusicReqSongListRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(artistMusicReqSongListRes0.notification, false, 3);
            if(!j.d(artistMusicReqSongListRes0)) {
                throw new AddNormalException("playArtist() {res is not ArtistMusicReqSongListRes}");
            }
            if(artistMusicReqSongListRes0.response != null && artistMusicReqSongListRes0.response.songList != null) {
                ArrayList arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(artistMusicReqSongListRes0.getItems(), this.getMenuId(), this.getStatsElements());
                q.d(arrayList0);
                return new CommonAddRequestPlayableListInfo(arrayList0);
            }
            return EmptyAddRequestPlayableListInfo.INSTANCE;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.artistId.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Artist(artistId=", this.artistId, ", menuId=", this.menuId, ", statsElements=");
            stringBuilder0.append(this.statsElements);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0014\u001A\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001A\u001A\u00020\u00112\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CHÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$ChartTop100;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "menuId", "", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getMenuId", "()Ljava/lang/String;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ChartTop100 extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public ChartTop100(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "menuId");
            super(null);
            this.menuId = s;
            this.statsElements = statsElementsBase0;
            q.f(CType.CHART_TOP100, "CHART_TOP100");
            this.cType = CType.CHART_TOP100;
        }

        @NotNull
        public final String component1() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component2() {
            return this.statsElements;
        }

        @NotNull
        public final ChartTop100 copy(@NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "menuId");
            return new ChartTop100(s, statsElementsBase0);
        }

        public static ChartTop100 copy$default(ChartTop100 playDataForSeverContent$ChartTop1000, String s, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$ChartTop1000.menuId;
            }
            if((v & 2) != 0) {
                statsElementsBase0 = playDataForSeverContent$ChartTop1000.statsElements;
            }
            return playDataForSeverContent$ChartTop1000.copy(s, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ChartTop100)) {
                return false;
            }
            return q.b(this.menuId, ((ChartTop100)object0).menuId) ? q.b(this.statsElements, ((ChartTop100)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.ChartTop100.getPlayableList.1 playDataForSeverContent$ChartTop100$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.ChartTop100.getPlayableList.1) {
                playDataForSeverContent$ChartTop100$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.ChartTop100.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$ChartTop100$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$ChartTop100$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$ChartTop100$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$ChartTop100$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$ChartTop100$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$ChartTop100$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    e e0 = (e)((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).N.get();
                    playDataForSeverContent$ChartTop100$getPlayableList$10.label = 1;
                    object0 = e0.a(playDataForSeverContent$ChartTop100$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            HourlyChartListRes hourlyChartListRes0 = (HourlyChartListRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(hourlyChartListRes0.notification, false, 3);
            if(j.d(hourlyChartListRes0)) {
                ArrayList arrayList0 = hourlyChartListRes0.response.chartList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    ArrayList arrayList1 = Playable.getListFromSongBaseArrayOnlyCanService(arrayList0, this.getMenuId(), this.getStatsElements());
                    q.f(arrayList1, "getListFromSongBaseArrayOnlyCanService(...)");
                    return new CommonAddRequestPlayableListInfo(arrayList1);
                }
                return EmptyAddRequestPlayableListInfo.INSTANCE;
            }
            return EmptyAddRequestPlayableListInfo.INSTANCE;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = this.menuId.hashCode();
            return this.statsElements == null ? v * 0x1F : v * 0x1F + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ChartTop100(menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u0018\u001A\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001AJ\"\u0010\u001B\u001A\f\u0012\u0004\u0012\u00020\u001D0\u001Cj\u0002`\u001E2\u000E\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001CH\u0002J\t\u0010!\u001A\u00020\u0003HÆ\u0003J\t\u0010\"\u001A\u00020\u0005HÆ\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010%\u001A\u00020\u00152\b\u0010&\u001A\u0004\u0018\u00010\'HÖ\u0003J\t\u0010(\u001A\u00020)HÖ\u0001J\t\u0010*\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$DrawerPlaylist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "playlistInfo", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "menuId", "", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getPlaylistInfo", "()Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "getMenuId", "()Ljava/lang/String;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayOrderDataListOnlyCanService", "", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo$DsPlyOrderData;", "Lcom/iloen/melon/player/playlist/drawernew/model/DsPlyOrderDataList;", "list", "Lcom/iloen/melon/net/v4x/common/PlaylistSongInfoBase;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DrawerPlaylist extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @NotNull
        private final DrawerPlaylistInfo playlistInfo;
        @Nullable
        private final StatsElementsBase statsElements;

        public DrawerPlaylist(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(drawerPlaylistInfo0, "playlistInfo");
            q.g(s, "menuId");
            super(null);
            this.playlistInfo = drawerPlaylistInfo0;
            this.menuId = s;
            this.statsElements = statsElementsBase0;
            q.f(CType.DRAWER_PLAYLIST, "DRAWER_PLAYLIST");
            this.cType = CType.DRAWER_PLAYLIST;
            this.needToClear = true;
        }

        @NotNull
        public final DrawerPlaylistInfo component1() {
            return this.playlistInfo;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final DrawerPlaylist copy(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(drawerPlaylistInfo0, "playlistInfo");
            q.g(s, "menuId");
            return new DrawerPlaylist(drawerPlaylistInfo0, s, statsElementsBase0);
        }

        public static DrawerPlaylist copy$default(DrawerPlaylist playDataForSeverContent$DrawerPlaylist0, DrawerPlaylistInfo drawerPlaylistInfo0, String s, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                drawerPlaylistInfo0 = playDataForSeverContent$DrawerPlaylist0.playlistInfo;
            }
            if((v & 2) != 0) {
                s = playDataForSeverContent$DrawerPlaylist0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$DrawerPlaylist0.statsElements;
            }
            return playDataForSeverContent$DrawerPlaylist0.copy(drawerPlaylistInfo0, s, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DrawerPlaylist)) {
                return false;
            }
            if(!q.b(this.playlistInfo, ((DrawerPlaylist)object0).playlistInfo)) {
                return false;
            }
            return q.b(this.menuId, ((DrawerPlaylist)object0).menuId) ? q.b(this.statsElements, ((DrawerPlaylist)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        private final List getDisplayOrderDataListOnlyCanService(List list0) {
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    if(((PlaylistSongInfoBase)object0).canService) {
                        arrayList0.add(object0);
                    }
                }
                List list1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    String s = ((PlaylistSongInfoBase)object1).dsplyOrder;
                    q.f(s, "dsplyOrder");
                    list1.add(new DsPlyOrderData(s, ((PlaylistSongInfoBase)object1).songId));
                }
                return list1;
            }
            return DrawerPlaylistInfoKt.placeHolderDsPlyOrderDataList();
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            ArrayList arrayList0;
            StatsElementsBase statsElementsBase0;
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist.getPlayableList.1 playDataForSeverContent$DrawerPlaylist$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist.getPlayableList.1) {
                playDataForSeverContent$DrawerPlaylist$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$DrawerPlaylist$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$DrawerPlaylist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$DrawerPlaylist$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$DrawerPlaylist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$DrawerPlaylist$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$DrawerPlaylist$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    k k0 = va.o.a();
                    playDataForSeverContent$DrawerPlaylist$getPlayableList$10.label = 1;
                    object0 = ((e0)k0).o(playDataForSeverContent$DrawerPlaylist$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_20;
                }
                case 1: {
                    n.D(object0);
                label_20:
                    if(!((Boolean)object0).booleanValue()) {
                        throw new AddNormalException("Login required");
                    }
                    playDataForSeverContent$DrawerPlaylist$getPlayableList$10.label = 2;
                    object0 = this.playlistInfo.requestPlaylistInfo("PlayDataForSeverContent", playDataForSeverContent$DrawerPlaylist$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_27;
                }
                case 2: {
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            n.D(object0);
        label_27:
            if(((HttpResponse)object0) != null) {
                String s = "";
                j.b(((HttpResponse)object0).notification, false, 3);
                if(j.d(((HttpResponse)object0))) {
                    if(((HttpResponse)object0).getResponse() == null) {
                        throw new AddNormalException("playSmartTabPlaylist() {res.response is null}");
                    }
                    if(((HttpResponse)object0) instanceof AutoplayMixPlayRes) {
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((AutoplayMixPlayRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((AutoplayMixPlayRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo0 = this.playlistInfo;
                        String s1 = ((AutoplayMixPlayRes)(((HttpResponse)object0))).response.mainTitle;
                        if(s1 == null) {
                            s1 = "";
                        }
                        drawerPlaylistInfo0.setTitle(s1);
                        DrawerPlaylistInfo drawerPlaylistInfo1 = this.playlistInfo;
                        String s2 = ((AutoplayMixPlayRes)(((HttpResponse)object0))).response.mainReplace;
                        if(s2 != null) {
                            s = s2;
                        }
                        drawerPlaylistInfo1.setTitleReplace(s);
                        goto label_94;
                    }
                    if(((HttpResponse)object0) instanceof ArtistplaylistConnectedSongRes) {
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((ArtistplaylistConnectedSongRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((ArtistplaylistConnectedSongRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo2 = this.playlistInfo;
                        String s3 = ((ArtistplaylistConnectedSongRes)(((HttpResponse)object0))).response.playlistTitle;
                        if(s3 != null) {
                            s = s3;
                        }
                        drawerPlaylistInfo2.setTitle(s);
                        goto label_94;
                    }
                    if(((HttpResponse)object0) instanceof MyMusicPlaylistRecentListSongRecntRes) {
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((MyMusicPlaylistRecentListSongRecntRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((MyMusicPlaylistRecentListSongRecntRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo3 = this.playlistInfo;
                        String s4 = ((MyMusicPlaylistRecentListSongRecntRes)(((HttpResponse)object0))).response.playlistTitle;
                        if(s4 != null) {
                            s = s4;
                        }
                        drawerPlaylistInfo3.setTitle(s);
                        goto label_94;
                    }
                    if(((HttpResponse)object0) instanceof MyMusicLikeListLikeSongRes) {
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((MyMusicLikeListLikeSongRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((MyMusicLikeListLikeSongRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo4 = this.playlistInfo;
                        String s5 = ((MyMusicLikeListLikeSongRes)(((HttpResponse)object0))).response.playlistTitle;
                        if(s5 != null) {
                            s = s5;
                        }
                        drawerPlaylistInfo4.setTitle(s);
                        goto label_94;
                    }
                    boolean z = false;
                    if(((HttpResponse)object0) instanceof DjConnectedPlaylistSongsRes) {
                        z = true;
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((DjConnectedPlaylistSongsRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((DjConnectedPlaylistSongsRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo5 = this.playlistInfo;
                        String s6 = ((DjConnectedPlaylistSongsRes)(((HttpResponse)object0))).response.playlistTitle;
                        if(s6 != null) {
                            s = s6;
                        }
                        drawerPlaylistInfo5.setTitle(s);
                        List list0 = this.getDisplayOrderDataListOnlyCanService(((DjConnectedPlaylistSongsRes)(((HttpResponse)object0))).response.songList);
                        this.playlistInfo.setDsPlyOrderDataList(list0);
                    }
                    else if(((HttpResponse)object0) instanceof MyMusicPlaylistConnectedListSongRes) {
                        z = true;
                        statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), ((MyMusicPlaylistConnectedListSongRes)(((HttpResponse)object0))).response.statsElements);
                        arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(((MyMusicPlaylistConnectedListSongRes)(((HttpResponse)object0))).response.songList, this.getMenuId(), statsElementsBase0);
                        DrawerPlaylistInfo drawerPlaylistInfo6 = this.playlistInfo;
                        String s7 = ((MyMusicPlaylistConnectedListSongRes)(((HttpResponse)object0))).response.playlistTitle;
                        if(s7 != null) {
                            s = s7;
                        }
                        drawerPlaylistInfo6.setTitle(s);
                        List list1 = this.getDisplayOrderDataListOnlyCanService(((MyMusicPlaylistConnectedListSongRes)(((HttpResponse)object0))).response.songList);
                        this.playlistInfo.setDsPlyOrderDataList(list1);
                    }
                    if(z) {
                    label_94:
                        if(arrayList0 != null && !arrayList0.isEmpty()) {
                            if(statsElementsBase0 != null && q.b("N10009", statsElementsBase0.parentContsType)) {
                                Context context0 = Y.a(MelonAppBase.Companion);
                                ParamInfo djPlaylistPlayLogReq$ParamInfo0 = new ParamInfo();
                                djPlaylistPlayLogReq$ParamInfo0.plylstSeq = this.playlistInfo.getContsId();
                                ReportService.sendLogging(new DjPlaylistPlayLogReq(context0, djPlaylistPlayLogReq$ParamInfo0));
                            }
                            return new DrawerAddRequestPlayableListInfo(arrayList0, this.playlistInfo);
                        }
                        return EmptyAddRequestPlayableListInfo.INSTANCE;
                    }
                    LogU.Companion.e("PlayDataForSeverContent", "playSmartTabPlaylist() Invalid response");
                    throw new AddNormalException("playSmartTabPlaylist() Invalid response");
                }
            }
            throw new AddNormalException("drawer res is not valid");
        }

        @NotNull
        public final DrawerPlaylistInfo getPlaylistInfo() {
            return this.playlistInfo;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.playlistInfo.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "DrawerPlaylist(playlistInfo=" + this.playlistInfo + ", menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0016\u001A\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001F\u001A\u00020\u00132\b\u0010 \u001A\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Live;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "liveSeq", "", "menuId", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getLiveSeq", "()Ljava/lang/String;", "getMenuId", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Live extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String liveSeq;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public Live(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "liveSeq");
            q.g(s1, "menuId");
            super(null);
            this.liveSeq = s;
            this.menuId = s1;
            this.statsElements = statsElementsBase0;
            q.f(CType.LIVE, "LIVE");
            this.cType = CType.LIVE;
        }

        @NotNull
        public final String component1() {
            return this.liveSeq;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final Live copy(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "liveSeq");
            q.g(s1, "menuId");
            return new Live(s, s1, statsElementsBase0);
        }

        public static Live copy$default(Live playDataForSeverContent$Live0, String s, String s1, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Live0.liveSeq;
            }
            if((v & 2) != 0) {
                s1 = playDataForSeverContent$Live0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$Live0.statsElements;
            }
            return playDataForSeverContent$Live0.copy(s, s1, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Live)) {
                return false;
            }
            if(!q.b(this.liveSeq, ((Live)object0).liveSeq)) {
                return false;
            }
            return q.b(this.menuId, ((Live)object0).menuId) ? q.b(this.statsElements, ((Live)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public DeviceConnectableInfo getDeviceConnectInfo() {
            return new DeviceConnectableInfo(true, false);
        }

        @NotNull
        public final String getLiveSeq() {
            return this.liveSeq;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Live.getPlayableList.1 playDataForSeverContent$Live$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Live.getPlayableList.1) {
                playDataForSeverContent$Live$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Live.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Live$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Live$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Live$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Live$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Live$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Live$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    if(this.liveSeq.length() == 0) {
                        throw new AddNormalException("playLive() {liveSeq is invalid}");
                    }
                    Ba.o o0 = (Ba.o)((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).P.get();
                    playDataForSeverContent$Live$getPlayableList$10.label = 1;
                    object0 = o0.a("", this.liveSeq, playDataForSeverContent$Live$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            LiveDetailRes liveDetailRes0 = (LiveDetailRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(liveDetailRes0.notification, false, 3);
            if(!j.d(liveDetailRes0)) {
                throw new AddNormalException("live res is not valid");
            }
            Response liveDetailRes$Response0 = liveDetailRes0.response;
            if(liveDetailRes$Response0 != null && liveDetailRes$Response0.live != null) {
                return liveDetailRes$Response0.menuId == null || liveDetailRes$Response0.menuId.length() <= 0 ? new LiveAddRequestPlayableListInfo(e.k.z(Playable.from(liveDetailRes0.response.live, (this.getMenuId().length() == 0 ? "1000002967" : this.getMenuId()), this.getStatsElements())), liveDetailRes0) : new LiveAddRequestPlayableListInfo(e.k.z(Playable.from(liveDetailRes0.response.live, liveDetailRes0.response.menuId, this.getStatsElements())), liveDetailRes0);
            }
            return EmptyAddRequestPlayableListInfo.INSTANCE;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.liveSeq.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Live(liveSeq=", this.liveSeq, ", menuId=", this.menuId, ", statsElements=");
            stringBuilder0.append(this.statsElements);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u0096@\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0012\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0011J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J>\u0010\u0016\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u00C6\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0011J\u0010\u0010\u001A\u001A\u00020\u0019H\u00D6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u00D6\u0003\u00A2\u0006\u0004\b\u001F\u0010 R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010!\u001A\u0004\b\"\u0010\u0011R\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010!\u001A\u0004\b#\u0010\u0011R\u001A\u0010\u0005\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010!\u001A\u0004\b$\u0010\u0011R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010%\u001A\u0004\b&\u0010\u0015R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u001A\u0010+\u001A\u00020*8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b-\u0010.R\u001A\u0010/\u001A\u00020\u001E8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b/\u00100\u001A\u0004\b1\u00102\u00A8\u00063"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MV;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "", "mvId", "songId", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getPlayableList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MV;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMvId", "getSongId", "getMenuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lkc/H1;", "melonPlaylistContentsRepository", "Lkc/H1;", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "Z", "getNeedToClear", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MV extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final H1 melonPlaylistContentsRepository;
        @NotNull
        private final String menuId;
        @Nullable
        private final String mvId;
        private final boolean needToClear;
        @Nullable
        private final String songId;
        @Nullable
        private final StatsElementsBase statsElements;

        public MV(@Nullable String s, @Nullable String s1, @NotNull String s2, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s2, "menuId");
            super(null);
            this.mvId = s;
            this.songId = s1;
            this.menuId = s2;
            this.statsElements = statsElementsBase0;
            this.melonPlaylistContentsRepository = (H1)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).r.get();
            q.f(CType.MV, "MV");
            this.cType = CType.MV;
        }

        public MV(String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                s1 = null;
            }
            this(s, s1, s2, statsElementsBase0);
        }

        @Nullable
        public final String component1() {
            return this.mvId;
        }

        @Nullable
        public final String component2() {
            return this.songId;
        }

        @NotNull
        public final String component3() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component4() {
            return this.statsElements;
        }

        @NotNull
        public final MV copy(@Nullable String s, @Nullable String s1, @NotNull String s2, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s2, "menuId");
            return new MV(s, s1, s2, statsElementsBase0);
        }

        public static MV copy$default(MV playDataForSeverContent$MV0, String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$MV0.mvId;
            }
            if((v & 2) != 0) {
                s1 = playDataForSeverContent$MV0.songId;
            }
            if((v & 4) != 0) {
                s2 = playDataForSeverContent$MV0.menuId;
            }
            if((v & 8) != 0) {
                statsElementsBase0 = playDataForSeverContent$MV0.statsElements;
            }
            return playDataForSeverContent$MV0.copy(s, s1, s2, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MV)) {
                return false;
            }
            if(!q.b(this.mvId, ((MV)object0).mvId)) {
                return false;
            }
            if(!q.b(this.songId, ((MV)object0).songId)) {
                return false;
            }
            return q.b(this.menuId, ((MV)object0).menuId) ? q.b(this.statsElements, ((MV)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public DeviceConnectableInfo getDeviceConnectInfo() {
            return new DeviceConnectableInfo(true, false);
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Nullable
        public final String getMvId() {
            return this.mvId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            StringBuilder stringBuilder1;
            String s;
            com.iloen.melon.net.v4x.response.MelonTvVdoStreamInAppRes.RESPONSE melonTvVdoStreamInAppRes$RESPONSE0;
            AddMVRepository addMVRepository0;
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV.getPlayableList.1 playDataForSeverContent$MV$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV.getPlayableList.1) {
                playDataForSeverContent$MV$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$MV$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$MV$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$MV$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$MV$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$MV$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$MV$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    o o0 = (o)(((Ma.a)Y.f(MelonAppBase.Companion, Ma.a.class)));
                    addMVRepository0 = new AddMVRepositoryImpl(new AddMvRemoteDataSource(((Ba.x)o0.C.get()), ((Q)com.iloen.melon.utils.a.j(((U)o0.D.get()), "retrofit", Q.class, "create(...)"))));
                    if(this.mvId == null || this.mvId.length() == 0) {
                        playDataForSeverContent$MV$getPlayableList$10.L$0 = addMVRepository0;
                        playDataForSeverContent$MV$getPlayableList$10.label = 1;
                        object0 = addMVRepository0.getMelonTvVdoStreamInApp((this.songId == null ? "" : this.songId), playDataForSeverContent$MV$getPlayableList$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        melonTvVdoStreamInAppRes$RESPONSE0 = ((MelonTvVdoStreamInAppRes)ApiResultKt.getOrThrow(((ApiResult)object0))).response;
                        s = melonTvVdoStreamInAppRes$RESPONSE0 == null ? null : melonTvVdoStreamInAppRes$RESPONSE0.cid;
                    }
                    else {
                        s = this.mvId;
                    }
                    goto label_30;
                }
                case 1: {
                    addMVRepository0 = (AddMVRepository)playDataForSeverContent$MV$getPlayableList$10.L$0;
                    n.D(object0);
                    melonTvVdoStreamInAppRes$RESPONSE0 = ((MelonTvVdoStreamInAppRes)ApiResultKt.getOrThrow(((ApiResult)object0))).response;
                    s = melonTvVdoStreamInAppRes$RESPONSE0 == null ? null : melonTvVdoStreamInAppRes$RESPONSE0.cid;
                label_30:
                    if(s == null || s.length() == 0) {
                        throw new AddNormalException("playMv() {TextUtils.isEmpty(contsId)}");
                    }
                    if(!Tf.o.v0(s, ",", false)) {
                        StringBuilder stringBuilder0 = new StringBuilder(s);
                        playDataForSeverContent$MV$getPlayableList$10.L$0 = null;
                        playDataForSeverContent$MV$getPlayableList$10.L$1 = null;
                        playDataForSeverContent$MV$getPlayableList$10.L$2 = stringBuilder0;
                        playDataForSeverContent$MV$getPlayableList$10.label = 2;
                        object0 = addMVRepository0.getMelonTvVdoRelateVdoList(s, playDataForSeverContent$MV$getPlayableList$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        stringBuilder1 = stringBuilder0;
                        goto label_46;
                    }
                    goto label_62;
                }
                case 2: {
                    stringBuilder1 = (StringBuilder)playDataForSeverContent$MV$getPlayableList$10.L$2;
                    String s1 = (String)playDataForSeverContent$MV$getPlayableList$10.L$1;
                    AddMVRepository addMVRepository1 = (AddMVRepository)playDataForSeverContent$MV$getPlayableList$10.L$0;
                    n.D(object0);
                label_46:
                    MelonTvVdoRelateVdoListRes melonTvVdoRelateVdoListRes0 = (MelonTvVdoRelateVdoListRes)ApiResultKt.getOrThrow(((ApiResult)object0));
                    j.b(melonTvVdoRelateVdoListRes0.notification, false, 3);
                    if(j.d(melonTvVdoRelateVdoListRes0)) {
                        com.iloen.melon.net.v4x.response.MelonTvVdoRelateVdoListRes.RESPONSE melonTvVdoRelateVdoListRes$RESPONSE0 = melonTvVdoRelateVdoListRes0.response;
                        if(melonTvVdoRelateVdoListRes$RESPONSE0 != null) {
                            ArrayList arrayList0 = melonTvVdoRelateVdoListRes$RESPONSE0.mvlist;
                            if(arrayList0 != null && !arrayList0.isEmpty()) {
                                Iterator iterator0 = arrayList0.iterator();
                                q.f(iterator0, "iterator(...)");
                                while(iterator0.hasNext()) {
                                    Object object1 = iterator0.next();
                                    stringBuilder1.append(",");
                                    stringBuilder1.append(((MVLIST)object1).mvId);
                                }
                            }
                        }
                    }
                    s = stringBuilder1.toString();
                    q.f(s, "toString(...)");
                label_62:
                    playDataForSeverContent$MV$getPlayableList$10.L$0 = null;
                    playDataForSeverContent$MV$getPlayableList$10.L$1 = null;
                    playDataForSeverContent$MV$getPlayableList$10.L$2 = null;
                    playDataForSeverContent$MV$getPlayableList$10.label = 3;
                    object0 = ((L1)this.melonPlaylistContentsRepository).d(s, this.getCType().getValue(), playDataForSeverContent$MV$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_73;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            String s2 = (String)playDataForSeverContent$MV$getPlayableList$10.L$2;
            String s3 = (String)playDataForSeverContent$MV$getPlayableList$10.L$1;
            AddMVRepository addMVRepository2 = (AddMVRepository)playDataForSeverContent$MV$getPlayableList$10.L$0;
            n.D(object0);
        label_73:
            StreamGetSongInfoRes streamGetSongInfoRes0 = (StreamGetSongInfoRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(streamGetSongInfoRes0.notification, false, 3);
            if(j.d(streamGetSongInfoRes0)) {
                ArrayList arrayList1 = Playable.makeList(streamGetSongInfoRes0.response.contentsInfo, this.getMenuId(), this.mvId, this.getStatsElements());
                q.d(arrayList1);
                return new CommonAddRequestPlayableListInfo(arrayList1);
            }
            return EmptyAddRequestPlayableListInfo.INSTANCE;
        }

        @Nullable
        public final String getSongId() {
            return this.songId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = x.b(((this.mvId == null ? 0 : this.mvId.hashCode()) * 0x1F + (this.songId == null ? 0 : this.songId.hashCode())) * 0x1F, 0x1F, this.menuId);
            StatsElementsBase statsElementsBase0 = this.statsElements;
            if(statsElementsBase0 != null) {
                v = statsElementsBase0.hashCode();
            }
            return v1 + v;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("MV(mvId=", this.mvId, ", songId=", this.songId, ", menuId=");
            stringBuilder0.append(this.menuId);
            stringBuilder0.append(", statsElements=");
            stringBuilder0.append(this.statsElements);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u0096@¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0017\u001A\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001A\u0010\u001C\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001C\u0010\u001DR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001E\u001A\u0004\b\u001F\u0010\u000ER\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001A\u0004\b!\u0010\u0010R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001A\u0004\b#\u0010\u0012R\u001A\u0010%\u001A\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(R\u001A\u0010)\u001A\u00020\u001B8\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MixUp;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "Lpc/w1;", "mixUpType", "", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "<init>", "(Lpc/w1;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getPlayableList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lpc/w1;", "component2", "()Ljava/lang/String;", "component3", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "copy", "(Lpc/w1;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MixUp;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lpc/w1;", "getMixUpType", "Ljava/lang/String;", "getMenuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lcom/iloen/melon/constants/CType;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "Z", "getNeedToClear", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MixUp extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        @NotNull
        private final w1 mixUpType;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public MixUp(@NotNull w1 w10, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(w10, "mixUpType");
            q.g(s, "menuId");
            super(null);
            this.mixUpType = w10;
            this.menuId = s;
            this.statsElements = statsElementsBase0;
            q.f(CType.MIX_UP_PLAYLIST, "MIX_UP_PLAYLIST");
            this.cType = CType.MIX_UP_PLAYLIST;
            this.needToClear = true;
        }

        @NotNull
        public final w1 component1() {
            return this.mixUpType;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final MixUp copy(@NotNull w1 w10, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(w10, "mixUpType");
            q.g(s, "menuId");
            return new MixUp(w10, s, statsElementsBase0);
        }

        public static MixUp copy$default(MixUp playDataForSeverContent$MixUp0, w1 w10, String s, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                w10 = playDataForSeverContent$MixUp0.mixUpType;
            }
            if((v & 2) != 0) {
                s = playDataForSeverContent$MixUp0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$MixUp0.statsElements;
            }
            return playDataForSeverContent$MixUp0.copy(w10, s, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MixUp)) {
                return false;
            }
            if(!q.b(this.mixUpType, ((MixUp)object0).mixUpType)) {
                return false;
            }
            return q.b(this.menuId, ((MixUp)object0).menuId) ? q.b(this.statsElements, ((MixUp)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @NotNull
        public final w1 getMixUpType() {
            return this.mixUpType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            d1 d10;
            String s;
            w1 w10;
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp.getPlayableList.1 playDataForSeverContent$MixUp$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp.getPlayableList.1) {
                playDataForSeverContent$MixUp$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$MixUp$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$MixUp$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$MixUp$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$MixUp$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$MixUp$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$MixUp$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    w10 = this.mixUpType;
                    playDataForSeverContent$MixUp$getPlayableList$10.L$0 = w10;
                    playDataForSeverContent$MixUp$getPlayableList$10.label = 1;
                    object0 = w10.h("PlayDataForSeverContent", this.getMenuId(), playDataForSeverContent$MixUp$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_22;
                }
                case 1: {
                    w10 = (w1)playDataForSeverContent$MixUp$getPlayableList$10.L$0;
                    n.D(object0);
                label_22:
                    if(((d1)object0) == null) {
                        throw new AddNormalException("playMixUpPlaylist() {mixupPlayableInfo is null}");
                    }
                    List list0 = ((d1)object0).a();
                    if(list0 == null) {
                        s = "";
                    }
                    else {
                        Playable playable0 = (Playable)p.n0(0, list0);
                        if(playable0 == null) {
                            s = "";
                        }
                        else {
                            s = playable0.getSongName();
                            if(s == null) {
                                s = "";
                            }
                        }
                    }
                    Context context0 = Y.a(MelonAppBase.Companion);
                    playDataForSeverContent$MixUp$getPlayableList$10.L$0 = null;
                    playDataForSeverContent$MixUp$getPlayableList$10.L$1 = (d1)object0;
                    playDataForSeverContent$MixUp$getPlayableList$10.L$2 = null;
                    playDataForSeverContent$MixUp$getPlayableList$10.label = 2;
                    Object object1 = w10.j(((d1)object0), context0, s, playDataForSeverContent$MixUp$getPlayableList$10);
                    if(object1 == a0) {
                        return a0;
                    }
                    d10 = (d1)object0;
                    object0 = object1;
                    break;
                }
                case 2: {
                    String s1 = (String)playDataForSeverContent$MixUp$getPlayableList$10.L$2;
                    d10 = (d1)playDataForSeverContent$MixUp$getPlayableList$10.L$1;
                    w1 w11 = (w1)playDataForSeverContent$MixUp$getPlayableList$10.L$0;
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            List list1 = d10.a();
            List list2 = w.a;
            if(list1 == null) {
                list1 = list2;
            }
            List list3 = d10.c();
            if(list3 != null) {
                list2 = list3;
            }
            MixUpAddRequestPlayableListInfo mixUpAddRequestPlayableListInfo0 = new MixUpAddRequestPlayableListInfo(list1, list2, ((MixUpRequestInfo)object0), d10.b());
            if(mixUpAddRequestPlayableListInfo0.getUserRequestedPlaylist().isEmpty()) {
                return EmptyAddRequestPlayableListInfo.INSTANCE;
            }
            LogU.Companion.d("PlayDataForSeverContent", androidx.appcompat.app.o.h(mixUpAddRequestPlayableListInfo0.getUserRequestedPlaylist().size(), mixUpAddRequestPlayableListInfo0.getRecommendPlayableLists().size(), "playMixUpPlaylist - seedSize = ", ", recommendSize = ", "}"));
            return mixUpAddRequestPlayableListInfo0;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.mixUpType.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "MixUp(mixUpType=" + this.mixUpType + ", menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u0018\u001A\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u001CH\u0016J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010!\u001A\u00020\u00152\b\u0010\"\u001A\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001A\u00020%HÖ\u0001J\t\u0010&\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006\'"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$MusicWave;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "channelInfo", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "menuId", "", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getChannelInfo", "()Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "getMenuId", "()Ljava/lang/String;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/MusicWaveAddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MusicWave extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final MusicWaveChannelInfo channelInfo;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final StatsElementsBase statsElements;

        public MusicWave(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(musicWaveChannelInfo0, "channelInfo");
            q.g(s, "menuId");
            super(null);
            this.channelInfo = musicWaveChannelInfo0;
            this.menuId = s;
            this.statsElements = statsElementsBase0;
            q.f(CType.MUSIC_WAVE, "MUSIC_WAVE");
            this.cType = CType.MUSIC_WAVE;
        }

        @NotNull
        public final MusicWaveChannelInfo component1() {
            return this.channelInfo;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final MusicWave copy(@NotNull MusicWaveChannelInfo musicWaveChannelInfo0, @NotNull String s, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(musicWaveChannelInfo0, "channelInfo");
            q.g(s, "menuId");
            return new MusicWave(musicWaveChannelInfo0, s, statsElementsBase0);
        }

        public static MusicWave copy$default(MusicWave playDataForSeverContent$MusicWave0, MusicWaveChannelInfo musicWaveChannelInfo0, String s, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                musicWaveChannelInfo0 = playDataForSeverContent$MusicWave0.channelInfo;
            }
            if((v & 2) != 0) {
                s = playDataForSeverContent$MusicWave0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$MusicWave0.statsElements;
            }
            return playDataForSeverContent$MusicWave0.copy(musicWaveChannelInfo0, s, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MusicWave)) {
                return false;
            }
            if(!q.b(this.channelInfo, ((MusicWave)object0).channelInfo)) {
                return false;
            }
            return q.b(this.menuId, ((MusicWave)object0).menuId) ? q.b(this.statsElements, ((MusicWave)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @NotNull
        public final MusicWaveChannelInfo getChannelInfo() {
            return this.channelInfo;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public DeviceConnectableInfo getDeviceConnectInfo() {
            return new DeviceConnectableInfo(false, false);
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            Float float0;
            Long long0;
            Integer integer0;
            MusicWaveChannelInfo musicWaveChannelInfo1;
            H h2;
            int v1;
            H h1;
            F f1;
            AddMusicWaveRepository addMusicWaveRepository0;
            G g1;
            MusicWaveChannelInfo musicWaveChannelInfo0;
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave.getPlayableList.1 playDataForSeverContent$MusicWave$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave.getPlayableList.1) {
                playDataForSeverContent$MusicWave$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$MusicWave$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$MusicWave$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int I$0;
                        int I$1;
                        long J$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$MusicWave$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$MusicWave$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$MusicWave$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$MusicWave$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f0.a = 5;
                    G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                    g0.a = 500L;
                    AddMusicWaveRepositoryImpl addMusicWaveRepositoryImpl0 = new AddMusicWaveRepositoryImpl(new AddMusicWaveDataSource(((B)((o)(((Ma.a)Y.f(MelonAppBase.Companion, Ma.a.class)))).E.get())));
                    musicWaveChannelInfo0 = this.channelInfo;
                    g1 = g0;
                    addMusicWaveRepository0 = addMusicWaveRepositoryImpl0;
                    f1 = f0;
                    h1 = h0;
                    v1 = 0;
                    break;
                }
                case 1: {
                    v1 = playDataForSeverContent$MusicWave$getPlayableList$10.I$0;
                    h1 = (H)playDataForSeverContent$MusicWave$getPlayableList$10.L$7;
                    String s = (String)playDataForSeverContent$MusicWave$getPlayableList$10.L$6;
                    MusicWave playDataForSeverContent$MusicWave0 = (MusicWave)playDataForSeverContent$MusicWave$getPlayableList$10.L$5;
                    addMusicWaveRepository0 = (AddMusicWaveRepository)playDataForSeverContent$MusicWave$getPlayableList$10.L$4;
                    g1 = (G)playDataForSeverContent$MusicWave$getPlayableList$10.L$3;
                    f1 = (F)playDataForSeverContent$MusicWave$getPlayableList$10.L$2;
                    h2 = (H)playDataForSeverContent$MusicWave$getPlayableList$10.L$1;
                    musicWaveChannelInfo1 = (MusicWaveChannelInfo)playDataForSeverContent$MusicWave$getPlayableList$10.L$0;
                    try {
                        n.D(object0);
                        goto label_75;
                    }
                    catch(Throwable throwable0) {
                        goto label_98;
                    }
                }
                case 2: {
                    v1 = playDataForSeverContent$MusicWave$getPlayableList$10.I$0;
                    AddMusicWaveRepository addMusicWaveRepository1 = (AddMusicWaveRepository)playDataForSeverContent$MusicWave$getPlayableList$10.L$4;
                    G g2 = (G)playDataForSeverContent$MusicWave$getPlayableList$10.L$3;
                    F f2 = (F)playDataForSeverContent$MusicWave$getPlayableList$10.L$2;
                    H h3 = (H)playDataForSeverContent$MusicWave$getPlayableList$10.L$1;
                    musicWaveChannelInfo0 = (MusicWaveChannelInfo)playDataForSeverContent$MusicWave$getPlayableList$10.L$0;
                    n.D(object0);
                    addMusicWaveRepository0 = addMusicWaveRepository1;
                    h1 = h3;
                    f1 = f2;
                    g1 = g2;
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            while(true) {
                Object object1 = h1.a;
                if(object1 != null) {
                    com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE musicWavePlayInfoRes$RESPONSE0 = ((MusicWavePlayInfoRes)object1).response;
                    if(q.b((musicWavePlayInfoRes$RESPONSE0 == null ? null : musicWavePlayInfoRes$RESPONSE0.status), "retry")) {
                        goto label_53;
                    }
                    break;
                }
            label_53:
                if(v1 >= f1.a) {
                    break;
                }
                try {
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$0 = musicWaveChannelInfo0;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$1 = h1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$2 = f1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$3 = g1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$4 = addMusicWaveRepository0;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$5 = null;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$6 = null;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$7 = h1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.I$0 = v1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.I$1 = 0;
                    playDataForSeverContent$MusicWave$getPlayableList$10.J$0 = 500L;
                    playDataForSeverContent$MusicWave$getPlayableList$10.label = 1;
                    object0 = addMusicWaveRepository0.getMusicWavePlayInfo(musicWaveChannelInfo0.getId(), musicWaveChannelInfo0.getType(), "3514259108", playDataForSeverContent$MusicWave$getPlayableList$10);
                }
                catch(Throwable throwable0) {
                    musicWaveChannelInfo1 = musicWaveChannelInfo0;
                    h2 = h1;
                    goto label_98;
                }
                if(object0 != a0) {
                    musicWaveChannelInfo1 = musicWaveChannelInfo0;
                    h2 = h1;
                    try {
                    label_75:
                        h1.a = ApiResultKt.getOrThrow(((ApiResult)object0));
                        MusicWavePlayInfoRes musicWavePlayInfoRes0 = (MusicWavePlayInfoRes)h2.a;
                        j.b((musicWavePlayInfoRes0 == null ? null : musicWavePlayInfoRes0.notification), false, 3);
                        MusicWavePlayInfoRes musicWavePlayInfoRes1 = (MusicWavePlayInfoRes)h2.a;
                        if(musicWavePlayInfoRes1 == null) {
                            integer0 = null;
                        }
                        else {
                            com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE musicWavePlayInfoRes$RESPONSE1 = musicWavePlayInfoRes1.response;
                            if(musicWavePlayInfoRes$RESPONSE1 != null) {
                                integer0 = new Integer(musicWavePlayInfoRes$RESPONSE1.intervalCount);
                            }
                        }
                        MusicWavePlayInfoRes musicWavePlayInfoRes2 = (MusicWavePlayInfoRes)h2.a;
                        if(musicWavePlayInfoRes2 == null) {
                            long0 = null;
                        }
                        else {
                            com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE musicWavePlayInfoRes$RESPONSE2 = musicWavePlayInfoRes2.response;
                            if(musicWavePlayInfoRes$RESPONSE2 != null) {
                                long0 = new Long(musicWavePlayInfoRes$RESPONSE2.interval);
                            }
                        }
                        if(integer0 != null) {
                            f1.a = (int)integer0;
                        }
                        if(long0 != null) {
                            g1.a = (long)long0;
                        }
                        goto label_99;
                    }
                    catch(Throwable throwable0) {
                    }
                label_98:
                    n.t(throwable0);
                label_99:
                    musicWaveChannelInfo0 = musicWaveChannelInfo1;
                    ++v1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$0 = musicWaveChannelInfo0;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$1 = h2;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$2 = f1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$3 = g1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$4 = addMusicWaveRepository0;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$5 = null;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$6 = null;
                    playDataForSeverContent$MusicWave$getPlayableList$10.L$7 = null;
                    playDataForSeverContent$MusicWave$getPlayableList$10.I$0 = v1;
                    playDataForSeverContent$MusicWave$getPlayableList$10.label = 2;
                    if(DelayKt.delay(g1.a, playDataForSeverContent$MusicWave$getPlayableList$10) == a0) {
                        return a0;
                    }
                    h1 = h2;
                    continue;
                }
                return a0;
            }
            MusicWavePlayInfoRes musicWavePlayInfoRes3 = (MusicWavePlayInfoRes)h1.a;
            com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE musicWavePlayInfoRes$RESPONSE3 = musicWavePlayInfoRes3 == null ? null : musicWavePlayInfoRes3.response;
            String s1 = musicWavePlayInfoRes$RESPONSE3 == null ? null : musicWavePlayInfoRes$RESPONSE3.songId;
            if(musicWavePlayInfoRes$RESPONSE3 == null) {
                float0 = new Integer(0);
            }
            else {
                float0 = musicWavePlayInfoRes$RESPONSE3.currentTimeMs;
                if(float0 == null) {
                    float0 = new Integer(0);
                }
            }
            long v2 = float0.longValue();
            if(s1 == null || s1.length() == 0) {
                throw new AddNormalException("playMusicWave() fetch failed");
            }
            String s2 = musicWaveChannelInfo0.getOriginMenuId();
            if(s2 == null) {
                s2 = this.getMenuId();
            }
            Builder playable$Builder0 = Playable.newBuilder().cType(CType.get(musicWavePlayInfoRes$RESPONSE3.cType)).songId(s1).artists(StringUtils.makeArtistMap(musicWavePlayInfoRes$RESPONSE3.artistId, musicWavePlayInfoRes$RESPONSE3.artistName)).originMenuId(s2).menuId(this.getMenuId());
            String s3 = musicWavePlayInfoRes$RESPONSE3.songName;
            String s4 = "";
            if(s3 == null) {
                s3 = "";
            }
            Builder playable$Builder1 = playable$Builder0.songName(s3).albumImg((musicWavePlayInfoRes$RESPONSE3.songImgUrl == null ? "" : musicWavePlayInfoRes$RESPONSE3.songImgUrl));
            String s5 = musicWavePlayInfoRes$RESPONSE3.songImgUrl;
            if(s5 != null) {
                s4 = s5;
            }
            List list0 = e.k.z(playable$Builder1.albumImgThumb(s4).isMusicWaveSong(true).statsElements(musicWavePlayInfoRes$RESPONSE3.statsElements).build());
            CHANNELINFO musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 = musicWavePlayInfoRes$RESPONSE3.channelInfo;
            String s6 = musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 == null ? null : musicWavePlayInfoRes$RESPONSE$CHANNELINFO0.title;
            String s7 = musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 == null ? null : musicWavePlayInfoRes$RESPONSE$CHANNELINFO0.subTitle;
            String s8 = musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 == null ? null : musicWavePlayInfoRes$RESPONSE$CHANNELINFO0.channelTitle;
            if(musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 != null) {
                String s9 = musicWavePlayInfoRes$RESPONSE$CHANNELINFO0.imgUrl;
                return musicWavePlayInfoRes$RESPONSE$CHANNELINFO0 == null ? new MusicWaveAddRequestPlayableListInfo(list0, s1, MusicWaveChannelInfo.copy$default(musicWaveChannelInfo0, null, null, s2, null, s9, s6, s7, s8, 3, null), v2, musicWavePlayInfoRes$RESPONSE3.nextSong, musicWavePlayInfoRes$RESPONSE3.log) : new MusicWaveAddRequestPlayableListInfo(list0, s1, MusicWaveChannelInfo.copy$default(musicWaveChannelInfo0, null, null, s2, musicWavePlayInfoRes$RESPONSE$CHANNELINFO0.imgType, s9, s6, s7, s8, 3, null), v2, musicWavePlayInfoRes$RESPONSE3.nextSong, musicWavePlayInfoRes$RESPONSE3.log);
            }
            return new MusicWaveAddRequestPlayableListInfo(list0, s1, MusicWaveChannelInfo.copy$default(musicWaveChannelInfo0, null, null, s2, null, null, s6, s7, s8, 3, null), v2, musicWavePlayInfoRes$RESPONSE3.nextSong, musicWavePlayInfoRes$RESPONSE3.log);
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.channelInfo.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "MusicWave(channelInfo=" + this.channelInfo + ", menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u0016\u001A\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u00132\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FHÖ\u0003J\t\u0010 \u001A\u00020!HÖ\u0001J\t\u0010\"\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Playlist;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "playlistId", "", "menuId", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getPlaylistId", "()Ljava/lang/String;", "getMenuId", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Playlist extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @NotNull
        private final String playlistId;
        @Nullable
        private final StatsElementsBase statsElements;

        public Playlist(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "playlistId");
            q.g(s1, "menuId");
            super(null);
            this.playlistId = s;
            this.menuId = s1;
            this.statsElements = statsElementsBase0;
            q.f(CType.PLAYLIST, "PLAYLIST");
            this.cType = CType.PLAYLIST;
        }

        @NotNull
        public final String component1() {
            return this.playlistId;
        }

        @NotNull
        public final String component2() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component3() {
            return this.statsElements;
        }

        @NotNull
        public final Playlist copy(@NotNull String s, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "playlistId");
            q.g(s1, "menuId");
            return new Playlist(s, s1, statsElementsBase0);
        }

        public static Playlist copy$default(Playlist playDataForSeverContent$Playlist0, String s, String s1, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Playlist0.playlistId;
            }
            if((v & 2) != 0) {
                s1 = playDataForSeverContent$Playlist0.menuId;
            }
            if((v & 4) != 0) {
                statsElementsBase0 = playDataForSeverContent$Playlist0.statsElements;
            }
            return playDataForSeverContent$Playlist0.copy(s, s1, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Playlist)) {
                return false;
            }
            if(!q.b(this.playlistId, ((Playlist)object0).playlistId)) {
                return false;
            }
            return q.b(this.menuId, ((Playlist)object0).menuId) ? q.b(this.statsElements, ((Playlist)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist.getPlayableList.1 playDataForSeverContent$Playlist$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist.getPlayableList.1) {
                playDataForSeverContent$Playlist$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Playlist$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Playlist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Playlist$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Playlist$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Playlist$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Playlist$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    playDataForSeverContent$Playlist$getPlayableList$10.label = 1;
                    object0 = PlaylistUtil.INSTANCE.getPlayablesMyPlaylistInfo(this.playlistId, this.getStatsElements(), this.getMenuId(), "PlayDataForSeverContent", playDataForSeverContent$Playlist$getPlayableList$10);
                    return object0 == a0 ? a0 : new CommonAddRequestPlayableListInfo(((List)object0));
                }
                case 1: {
                    n.D(object0);
                    return new CommonAddRequestPlayableListInfo(((List)object0));
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }

        @NotNull
        public final String getPlaylistId() {
            return this.playlistId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b(this.playlistId.hashCode() * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Playlist(playlistId=", this.playlistId, ", menuId=", this.menuId, ", statsElements=");
            stringBuilder0.append(this.statsElements);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BH\u0096@\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u000FJ\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J:\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0017\u0010\u000FJ\u0010\u0010\u0019\u001A\u00020\u0018H\u00D6\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001A\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u00D6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010 \u001A\u0004\b!\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010\"\u001A\u0004\b#\u0010\u0011R\u001A\u0010\u0006\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010 \u001A\u0004\b$\u0010\u000FR\u001C\u0010\b\u001A\u0004\u0018\u00010\u00078\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\b\u0010%\u001A\u0004\b&\u0010\u0014R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u001A\u0010*\u001A\u00020\u001D8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\u00A8\u0006."}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Song;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "", "songId", "Lcom/iloen/melon/constants/CType;", "cType", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/constants/CType;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getPlayableList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/constants/CType;", "component3", "component4", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "copy", "(Ljava/lang/String;Lcom/iloen/melon/constants/CType;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Song;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSongId", "Lcom/iloen/melon/constants/CType;", "getCType", "getMenuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "Lkc/H1;", "melonPlaylistContentsRepository", "Lkc/H1;", "needToClear", "Z", "getNeedToClear", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Song extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final H1 melonPlaylistContentsRepository;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @NotNull
        private final String songId;
        @Nullable
        private final StatsElementsBase statsElements;

        public Song(@NotNull String s, @NotNull CType cType0, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "songId");
            q.g(cType0, "cType");
            q.g(s1, "menuId");
            super(null);
            this.songId = s;
            this.cType = cType0;
            this.menuId = s1;
            this.statsElements = statsElementsBase0;
            this.melonPlaylistContentsRepository = (H1)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).r.get();
        }

        @NotNull
        public final String component1() {
            return this.songId;
        }

        @NotNull
        public final CType component2() {
            return this.cType;
        }

        @NotNull
        public final String component3() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component4() {
            return this.statsElements;
        }

        @NotNull
        public final Song copy(@NotNull String s, @NotNull CType cType0, @NotNull String s1, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "songId");
            q.g(cType0, "cType");
            q.g(s1, "menuId");
            return new Song(s, cType0, s1, statsElementsBase0);
        }

        public static Song copy$default(Song playDataForSeverContent$Song0, String s, CType cType0, String s1, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Song0.songId;
            }
            if((v & 2) != 0) {
                cType0 = playDataForSeverContent$Song0.cType;
            }
            if((v & 4) != 0) {
                s1 = playDataForSeverContent$Song0.menuId;
            }
            if((v & 8) != 0) {
                statsElementsBase0 = playDataForSeverContent$Song0.statsElements;
            }
            return playDataForSeverContent$Song0.copy(s, cType0, s1, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Song)) {
                return false;
            }
            if(!q.b(this.songId, ((Song)object0).songId)) {
                return false;
            }
            if(!q.b(this.cType, ((Song)object0).cType)) {
                return false;
            }
            return q.b(this.menuId, ((Song)object0).menuId) ? q.b(this.statsElements, ((Song)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Song.getPlayableList.1 playDataForSeverContent$Song$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Song.getPlayableList.1) {
                playDataForSeverContent$Song$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Song.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Song$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Song$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Song$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Song$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Song$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Song$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    LogU.Companion.d("PlayDataForSeverContent", "playSong()");
                    playDataForSeverContent$Song$getPlayableList$10.label = 1;
                    object0 = ((L1)this.melonPlaylistContentsRepository).d(this.songId, this.getCType().getValue(), playDataForSeverContent$Song$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            StreamGetSongInfoRes streamGetSongInfoRes0 = (StreamGetSongInfoRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(streamGetSongInfoRes0.notification, false, 3);
            if(j.d(streamGetSongInfoRes0)) {
                com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE streamGetSongInfoRes$RESPONSE0 = streamGetSongInfoRes0.response;
                if(streamGetSongInfoRes$RESPONSE0 == null) {
                    return EmptyAddRequestPlayableListInfo.INSTANCE;
                }
                ArrayList arrayList0 = Playable.makeList(streamGetSongInfoRes$RESPONSE0.contentsInfo, this.getMenuId(), null, this.getStatsElements());
                q.f(arrayList0, "makeList(...)");
                return new CommonAddRequestPlayableListInfo(arrayList0);
            }
            LogU.Companion.e("PlayDataForSeverContent", "playSong() {res.notification.message}");
            throw new AddNormalException("playSong() {res is not StreamGetSongInfoRes}");
        }

        @NotNull
        public final String getSongId() {
            return this.songId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = x.b((this.cType.hashCode() + this.songId.hashCode() * 0x1F) * 0x1F, 0x1F, this.menuId);
            return this.statsElements == null ? v : v + this.statsElements.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Song(songId=" + this.songId + ", cType=" + this.cType + ", menuId=" + this.menuId + ", statsElements=" + this.statsElements + ")";
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u0018\u001A\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u001CH\u0016J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\u000B\u0010 \u001A\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\"\u001A\u00020\u00152\b\u0010#\u001A\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001A\u00020&HÖ\u0001J\t\u0010\'\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0014\u0010\u0005\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent$Station;", "Lcom/iloen/melon/playback/playlist/add/PlayDataForSeverContent;", "stationId", "", "startingContsId", "menuId", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getStationId", "()Ljava/lang/String;", "getStartingContsId", "getMenuId", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "cType", "Lcom/iloen/melon/constants/CType;", "getCType", "()Lcom/iloen/melon/constants/CType;", "needToClear", "", "getNeedToClear", "()Z", "getPlayableList", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceConnectInfo", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Station extends PlayDataForSeverContent {
        public static final int $stable = 8;
        @NotNull
        private final CType cType;
        @NotNull
        private final String menuId;
        private final boolean needToClear;
        @Nullable
        private final String startingContsId;
        @NotNull
        private final String stationId;
        @Nullable
        private final StatsElementsBase statsElements;

        public Station(@NotNull String s, @Nullable String s1, @NotNull String s2, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "stationId");
            q.g(s2, "menuId");
            super(null);
            this.stationId = s;
            this.startingContsId = s1;
            this.menuId = s2;
            this.statsElements = statsElementsBase0;
            q.f(CType.STATION, "STATION");
            this.cType = CType.STATION;
            this.needToClear = true;
        }

        public Station(String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                s1 = "";
            }
            this(s, s1, s2, statsElementsBase0);
        }

        @NotNull
        public final String component1() {
            return this.stationId;
        }

        @Nullable
        public final String component2() {
            return this.startingContsId;
        }

        @NotNull
        public final String component3() {
            return this.menuId;
        }

        @Nullable
        public final StatsElementsBase component4() {
            return this.statsElements;
        }

        @NotNull
        public final Station copy(@NotNull String s, @Nullable String s1, @NotNull String s2, @Nullable StatsElementsBase statsElementsBase0) {
            q.g(s, "stationId");
            q.g(s2, "menuId");
            return new Station(s, s1, s2, statsElementsBase0);
        }

        public static Station copy$default(Station playDataForSeverContent$Station0, String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v, Object object0) {
            if((v & 1) != 0) {
                s = playDataForSeverContent$Station0.stationId;
            }
            if((v & 2) != 0) {
                s1 = playDataForSeverContent$Station0.startingContsId;
            }
            if((v & 4) != 0) {
                s2 = playDataForSeverContent$Station0.menuId;
            }
            if((v & 8) != 0) {
                statsElementsBase0 = playDataForSeverContent$Station0.statsElements;
            }
            return playDataForSeverContent$Station0.copy(s, s1, s2, statsElementsBase0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Station)) {
                return false;
            }
            if(!q.b(this.stationId, ((Station)object0).stationId)) {
                return false;
            }
            if(!q.b(this.startingContsId, ((Station)object0).startingContsId)) {
                return false;
            }
            return q.b(this.menuId, ((Station)object0).menuId) ? q.b(this.statsElements, ((Station)object0).statsElements) : false;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public CType getCType() {
            return this.cType;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public DeviceConnectableInfo getDeviceConnectInfo() {
            return new DeviceConnectableInfo(false, false);
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @NotNull
        public String getMenuId() {
            return this.menuId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        public boolean getNeedToClear() {
            return this.needToClear;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public Object getPlayableList(@NotNull Continuation continuation0) {
            String s;
            com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station.getPlayableList.1 playDataForSeverContent$Station$getPlayableList$10;
            if(continuation0 instanceof com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station.getPlayableList.1) {
                playDataForSeverContent$Station$getPlayableList$10 = (com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Station.getPlayableList.1)continuation0;
                int v = playDataForSeverContent$Station$getPlayableList$10.label;
                if((v & 0x80000000) == 0) {
                    playDataForSeverContent$Station$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getPlayableList(this);
                        }
                    };
                }
                else {
                    playDataForSeverContent$Station$getPlayableList$10.label = v ^ 0x80000000;
                }
            }
            else {
                playDataForSeverContent$Station$getPlayableList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(this);
                    }
                };
            }
            Object object0 = playDataForSeverContent$Station$getPlayableList$10.result;
            a a0 = a.a;
            switch(playDataForSeverContent$Station$getPlayableList$10.label) {
                case 0: {
                    n.D(object0);
                    if(this.stationId.length() == 0) {
                        LogU.Companion.d("PlayDataForSeverContent", "playRadioCast() castSeq is invalid");
                        throw new AddNormalException("playRadioCast() castSeq is invalid");
                    }
                    Ba.d d0 = (Ba.d)((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).O.get();
                    playDataForSeverContent$Station$getPlayableList$10.label = 1;
                    object0 = d0.d(this.stationId, playDataForSeverContent$Station$getPlayableList$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    break;
                }
                case 1: {
                    n.D(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            CastDetailRes castDetailRes0 = (CastDetailRes)ApiResultKt.getOrThrow(((ApiResult)object0));
            j.b(castDetailRes0.notification, false, 3);
            if(!j.d(castDetailRes0)) {
                throw new AddNormalException("playRadioCast() {res is not CastDetailRes}");
            }
            if(castDetailRes0.response != null && castDetailRes0.getItems() != null && !castDetailRes0.getItems().isEmpty()) {
                StatsElementsBase statsElementsBase0 = StatsElementsBase.mergeStatsElements(this.getStatsElements(), castDetailRes0.getStatsElements());
                ArrayList arrayList0 = Playable.getListFromSongBaseArrayOnlyCanService(castDetailRes0.getItems(), (this.getMenuId().length() <= 0 || "9999999999".equals(this.getMenuId()) ? "1000002296" : this.getMenuId()), statsElementsBase0);
                return arrayList0.isEmpty() ? EmptyAddRequestPlayableListInfo.INSTANCE : new StationAddRequestPlayableListInfo(arrayList0, castDetailRes0.response, this.startingContsId);
            }
            LogU.Companion.e("PlayDataForSeverContent", "playStation() contents empty");
            Notification httpResponse$Notification0 = castDetailRes0.notification;
            if(httpResponse$Notification0 == null) {
                s = "";
            }
            else {
                s = httpResponse$Notification0.message;
                if(s == null) {
                    s = "";
                }
            }
            if(TextUtils.isEmpty(s)) {
                return EmptyAddRequestPlayableListInfo.INSTANCE;
            }
            ToastManager.showShort(s);
            throw new AddNormalException("playStation() contents empty");
        }

        @Nullable
        public final String getStartingContsId() {
            return this.startingContsId;
        }

        @NotNull
        public final String getStationId() {
            return this.stationId;
        }

        @Override  // com.iloen.melon.playback.playlist.add.PlayDataForSeverContent
        @Nullable
        public StatsElementsBase getStatsElements() {
            return this.statsElements;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = x.b((this.stationId.hashCode() * 0x1F + (this.startingContsId == null ? 0 : this.startingContsId.hashCode())) * 0x1F, 0x1F, this.menuId);
            StatsElementsBase statsElementsBase0 = this.statsElements;
            if(statsElementsBase0 != null) {
                v = statsElementsBase0.hashCode();
            }
            return v1 + v;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Station(stationId=", this.stationId, ", startingContsId=", this.startingContsId, ", menuId=");
            stringBuilder0.append(this.menuId);
            stringBuilder0.append(", statsElements=");
            stringBuilder0.append(this.statsElements);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlayDataForSeverContent";

    static {
        PlayDataForSeverContent.Companion = new Companion(null);
    }

    private PlayDataForSeverContent() {
    }

    public PlayDataForSeverContent(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @NotNull
    public abstract CType getCType();

    @NotNull
    public DeviceConnectableInfo getDeviceConnectInfo() {
        return new DeviceConnectableInfo(true, true);
    }

    @NotNull
    public abstract String getMenuId();

    public abstract boolean getNeedToClear();

    @Nullable
    public abstract Object getPlayableList(@NotNull Continuation arg1);

    @Nullable
    public abstract StatsElementsBase getStatsElements();
}

