package com.iloen.melon.player.playlist.music;

import M6.B;
import Mb.v;
import Pc.d;
import androidx.lifecycle.f0;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.t3;
import d5.n;
import eb.y;
import ie.H;
import java.util.List;
import javax.inject.Inject;
import je.D;
import kc.G2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import ob.a;
import ob.z;
import oc.L;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.s0;
import oc.t0;
import oc.u0;
import oc.v0;
import oc.w0;
import oc.x0;
import oc.x;
import oc.y0;
import oe.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u007F\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0011\u001A\u00020\u0010\u0012\u0006\u0010\u0013\u001A\u00020\u0012\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u0012\u0006\u0010\u0017\u001A\u00020\u0016\u0012\u0006\u0010\u0019\u001A\u00020\u0018\u0012\u0006\u0010\u001B\u001A\u00020\u001A¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0016¢\u0006\u0004\b\u001F\u0010 R\u001A\u0010&\u001A\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u001A\u0010,\u001A\u00020\'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistViewModel;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "defaultDispatcher", "ioDispatcher", "LPc/d;", "stringProvider", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lob/a;", "playableUseCase", "Lmb/k;", "loginUseCase", "Leb/y;", "uaLogUseCase", "Lcom/melon/ui/Q;", "addPlayUserEventHelper", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "deleteHelper", "Lcom/melon/ui/b3;", "morePopupUserEventHelper", "Lk8/a;", "blockingProgressDialogManage", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;LPc/d;Lkc/s2;Lob/z;Lob/a;Lmb/k;Leb/y;Lcom/melon/ui/Q;Lcom/melon/ui/t3;Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;Lcom/melon/ui/b3;Lk8/a;)V", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "getPvLoggingData", "()Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "LMb/v;", "y", "LMb/v;", "getOfflinePlaylistHelper", "()LMb/v;", "offlinePlaylistHelper", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "z", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "tiaraLogHelper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistViewModel extends MusicPlaylistBaseViewModel {
    public static final int $stable = 8;
    public final v y;
    public final com.iloen.melon.player.playlist.music.MusicPlaylistViewModel.tiaraLogHelper.1 z;

    @Inject
    public MusicPlaylistViewModel(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull CoroutineDispatcher coroutineDispatcher1, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull d d0, @NotNull s2 s20, @NotNull z z0, @NotNull a a0, @NotNull k k0, @NotNull y y0, @NotNull Q q0, @NotNull t3 t30, @NotNull PlaylistDeleteHelper playlistDeleteHelper0, @NotNull b3 b30, @NotNull k8.a a1) {
        q.g(coroutineDispatcher0, "mainDispatcher");
        q.g(coroutineDispatcher1, "defaultDispatcher");
        q.g(coroutineDispatcher2, "ioDispatcher");
        q.g(d0, "stringProvider");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        q.g(a0, "playableUseCase");
        q.g(k0, "loginUseCase");
        q.g(y0, "uaLogUseCase");
        q.g(q0, "addPlayUserEventHelper");
        q.g(t30, "putPopupUserEventHelper");
        q.g(playlistDeleteHelper0, "deleteHelper");
        q.g(b30, "morePopupUserEventHelper");
        q.g(a1, "blockingProgressDialogManage");
        super(coroutineDispatcher0, coroutineDispatcher1, coroutineDispatcher2, PlaylistId.MUSIC, "1000000558", "MusicPlaylistViewModel", d0, s20, z0, a0, k0, y0, q0, t30, playlistDeleteHelper0, b30, a1);
        this.y = new v(d0, new Ib.a() {
            public final s2 a;
            public final MusicPlaylistViewModel b;

            {
                s2 s20 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = s20;
                this.b = musicPlaylistViewModel0;
            }

            @Override  // Ib.a
            public List getPlayableList() {
                return this.b.getAllPlayables();
            }

            @Override  // Ib.a
            public Object isOfflineModeFromLocalData(Continuation continuation0) {
                com.iloen.melon.player.playlist.music.MusicPlaylistViewModel.offlineDataAccessor.1.isOfflineModeFromLocalData.1 musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10;
                if(continuation0 instanceof com.iloen.melon.player.playlist.music.MusicPlaylistViewModel.offlineDataAccessor.1.isOfflineModeFromLocalData.1) {
                    musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10 = (com.iloen.melon.player.playlist.music.MusicPlaylistViewModel.offlineDataAccessor.1.isOfflineModeFromLocalData.1)continuation0;
                    int v = musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10.B;
                    if((v & 0x80000000) == 0) {
                        musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            public int B;
                            public Object r;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.r = object0;
                                this.B |= 0x80000000;
                                return continuation0.isOfflineModeFromLocalData(this);
                            }
                        };
                    }
                    else {
                        musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10.B = v ^ 0x80000000;
                    }
                }
                else {
                    musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        public int B;
                        public Object r;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.r = object0;
                            this.B |= 0x80000000;
                            return continuation0.isOfflineModeFromLocalData(this);
                        }
                    };
                }
                Object object0 = musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10.r;
                ne.a a0 = ne.a.a;
                x x0 = null;
                switch(musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10.B) {
                    case 0: {
                        n.D(object0);
                        G2 g20 = new G2(((d3)this.a), null);
                        B b0 = ListenableFutureKt.future$default(((d3)this.a).b, null, null, g20, 3, null);
                        musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10.B = 1;
                        object0 = ListenableFutureKt.await(b0, musicPlaylistViewModel$offlineDataAccessor$1$isOfflineModeFromLocalData$10);
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
                if(object0 instanceof x) {
                    x0 = (x)object0;
                }
                if(x0 != null) {
                    MutableStateFlow mutableStateFlow0 = x0.y();
                    if(mutableStateFlow0 != null) {
                        L l0 = (L)mutableStateFlow0.getValue();
                        return l0 == null ? false : Boolean.valueOf(l0.e());
                    }
                }
                return false;
            }

            @Override  // Ib.a
            public Object setOfflineModeToLocalData(boolean z, Continuation continuation0) {
                Object object0 = ListenableFutureKt.await(((d3)this.a).A(this.b.getPlaylistId(), z), continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        }, f0.h(this), new m(this, 1));
        this.z = new PlaylistSongBaseTiaraLogHelper(/*ERROR_MISSING_ARG_0/*) {
            @Override  // com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper
            public String getFilterClickLayer1() {
                return ((StringProviderImpl)this.c).a(0x7F130794);  // string:normal_playlist_filter_layer1 "곡리스트"
            }
        };
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel
    @NotNull
    public v getOfflinePlaylistHelper() {
        return this.y;
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel
    @NotNull
    public PvLoggingData getPvLoggingData() {
        Object object0 = this.getUiState().getValue();
        y0 y00 = null;
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            y00 = musicPlaylistUiState$Success0.getSortType();
        }
        if(q.b(y00, t0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O17")));
        }
        if(q.b(y00, s0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O18")));
        }
        if(q.b(y00, u0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O22")));
        }
        if(q.b(y00, v0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O31")));
        }
        if(q.b(y00, q0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O32")));
        }
        if(q.b(y00, r0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O33")));
        }
        if(q.b(y00, w0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O34")));
        }
        if(q.b(y00, x0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O35")));
        }
        if(q.b(y00, p0.b)) {
            return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O36")));
        }
        LogU.error$default(this.getLog(), "getPvLoggingData() - sortType is invalid.", null, false, 6, null);
        return new PvLoggingData("playlistSong", D.O(new ie.m("orderBy", "O17")));
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel
    @NotNull
    public PlaylistSongBaseTiaraLogHelper getTiaraLogHelper() {
        return this.z;
    }
}

