package com.iloen.melon.player.playlist.music;

import M6.B;
import Mb.v;
import Pc.d;
import Pc.e;
import Ud.g;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventPremiumCacheDelete;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeletePlaylistByIndices;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeletePlaylistByPlayables;
import com.iloen.melon.player.playlist.common.DeletePlaylist;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectButton;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectCancelButton;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper.TiaraMixUpEventMeta;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.I4;
import com.melon.ui.L2;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import com.melon.ui.q3;
import com.melon.ui.s4;
import com.melon.ui.t3;
import com.melon.ui.t4;
import e1.F;
import eb.y;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.p;
import je.w;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import ob.a;
import ob.z;
import oc.O;
import oc.P;
import oc.c0;
import oc.t0;
import oc.y0;
import oe.c;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pb.b;
import va.e0;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000\u00CE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001:\u0002\u0098\u0001B\u008F\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\u0006\u0010\u0012\u001A\u00020\u0011\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0016\u001A\u00020\u0015\u0012\u0006\u0010\u0018\u001A\u00020\u0017\u0012\u0006\u0010\u001A\u001A\u00020\u0019\u0012\u0006\u0010\u001C\u001A\u00020\u001B\u0012\u0006\u0010\u001E\u001A\u00020\u001D\u0012\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001A\u0004\u0018\u00010%2\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u0004\u0018\u00010(2\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b)\u0010*J\u0013\u0010,\u001A\b\u0012\u0004\u0012\u00020(0+\u00A2\u0006\u0004\b,\u0010-J\r\u0010/\u001A\u00020.\u00A2\u0006\u0004\b/\u00100J\u0017\u00104\u001A\u0002032\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b4\u00105J\u0015\u00107\u001A\u0002032\u0006\u00106\u001A\u00020#\u00A2\u0006\u0004\b7\u00108J\r\u00109\u001A\u000203\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u000203\u00A2\u0006\u0004\b;\u0010:J\u0015\u0010>\u001A\u0002032\u0006\u0010=\u001A\u00020<\u00A2\u0006\u0004\b>\u0010?J\u0015\u0010A\u001A\u0002032\u0006\u0010@\u001A\u00020<\u00A2\u0006\u0004\bA\u0010?J\u0015\u0010C\u001A\u0002032\u0006\u0010B\u001A\u00020(\u00A2\u0006\u0004\bC\u0010DJ\r\u0010E\u001A\u00020<\u00A2\u0006\u0004\bE\u0010FJ\u0017\u0010I\u001A\u0002032\u0006\u0010H\u001A\u00020GH\u0007\u00A2\u0006\u0004\bI\u0010JJ\r\u0010K\u001A\u000203\u00A2\u0006\u0004\bK\u0010:J\u000F\u0010M\u001A\u00020LH&\u00A2\u0006\u0004\bM\u0010NR\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010RR\u0017\u0010\t\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\bS\u0010T\u001A\u0004\bU\u0010VR\u0017\u0010\n\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\bW\u0010T\u001A\u0004\bX\u0010VR\u001A\u0010\f\u001A\u00020\u000B8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\R\u001A\u0010\u000E\u001A\u00020\r8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`R\u001A\u0010\u0010\u001A\u00020\u000F8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\ba\u0010b\u001A\u0004\bc\u0010dR\u001A\u0010\u0012\u001A\u00020\u00118\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\be\u0010f\u001A\u0004\bg\u0010hR\u001A\u0010\u0014\u001A\u00020\u00138\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bi\u0010j\u001A\u0004\bk\u0010lR\u001A\u0010\u0016\u001A\u00020\u00158\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bm\u0010n\u001A\u0004\bo\u0010pR\u001A\u0010\u0018\u001A\u00020\u00178\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bq\u0010r\u001A\u0004\bs\u0010tR\u001A\u0010\u001A\u001A\u00020\u00198\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bu\u0010v\u001A\u0004\bw\u0010xR\u001A\u0010\u001C\u001A\u00020\u001B8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\by\u0010z\u001A\u0004\b{\u0010|R\u001B\u0010\u001E\u001A\u00020\u001D8\u0004X\u0084\u0004\u00A2\u0006\r\n\u0004\b}\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001R\u001E\u0010 \u001A\u00020\u001F8\u0004X\u0084\u0004\u00A2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u008A\u0001\u001A\u00030\u0085\u00018\u0004X\u0084\u0004\u00A2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001A\u0006\b\u0088\u0001\u0010\u0089\u0001R#\u0010\u008E\u0001\u001A\t\u0012\u0004\u0012\u00020<0\u008B\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u008C\u0001\u0010\u008D\u0001\u001A\u0006\b\u008E\u0001\u0010\u008F\u0001R\u0018\u0010\u0093\u0001\u001A\u00030\u0090\u00018&X\u00A6\u0004\u00A2\u0006\b\u001A\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0097\u0001\u001A\u00030\u0094\u00018&X\u00A6\u0004\u00A2\u0006\b\u001A\u0006\b\u0095\u0001\u0010\u0096\u0001\u00A8\u0006\u0099\u0001"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel;", "Lcom/melon/ui/n0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "defaultDispatcher", "ioDispatcher", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "", "defaultMenuId", "tagString", "LPc/d;", "stringProvider", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lob/a;", "playableUseCase", "Lmb/k;", "loginUseCase", "Leb/y;", "uaLogUseCase", "Lcom/melon/ui/Q;", "addPlayUserEventHelper", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "deleteHelper", "Lcom/melon/ui/b3;", "morePopupUserEventHelper", "Lk8/a;", "blockingProgressDialogManage", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/lang/String;Ljava/lang/String;LPc/d;Lkc/s2;Lob/z;Lob/a;Lmb/k;Leb/y;Lcom/melon/ui/Q;Lcom/melon/ui/t3;Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;Lcom/melon/ui/b3;Lk8/a;)V", "", "position", "Lcom/iloen/melon/player/playlist/music/SongUiState;", "getSongUiState", "(I)Lcom/iloen/melon/player/playlist/music/SongUiState;", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "(I)Lcom/iloen/melon/playback/Playable;", "", "getAllPlayables", "()Ljava/util/List;", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "getTiaraEventMetaForMixUp", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "LPc/e;", "userEvent", "Lie/H;", "onUserEvent", "(LPc/e;)V", "index", "select", "(I)V", "toggleSelectAll", "()V", "unSelectAll", "", "hasToolbarPadding", "updateHasToolbarPadding", "(Z)V", "isDragging", "setIsDragging", "playable", "deletePlayable", "(Lcom/iloen/melon/playback/Playable;)V", "isDj", "()Z", "Lcom/iloen/melon/eventbus/EventPremiumCacheDelete;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPremiumCacheDelete;)V", "performPvLoggingOnForeground", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "getPvLoggingData", "()Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "c", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "d", "Ljava/lang/String;", "getDefaultMenuId", "()Ljava/lang/String;", "e", "getTagString", "f", "LPc/d;", "getStringProvider", "()LPc/d;", "g", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "h", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "i", "Lob/a;", "getPlayableUseCase", "()Lob/a;", "j", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "k", "Leb/y;", "getUaLogUseCase", "()Leb/y;", "l", "Lcom/melon/ui/Q;", "getAddPlayUserEventHelper", "()Lcom/melon/ui/Q;", "m", "Lcom/melon/ui/t3;", "getPutPopupUserEventHelper", "()Lcom/melon/ui/t3;", "n", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "getDeleteHelper", "()Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "o", "Lcom/melon/ui/b3;", "getMorePopupUserEventHelper", "()Lcom/melon/ui/b3;", "p", "Lk8/a;", "getBlockingProgressDialogManage", "()Lk8/a;", "Lcom/iloen/melon/utils/log/LogU;", "q", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "Lkotlinx/coroutines/flow/StateFlow;", "s", "Lkotlinx/coroutines/flow/StateFlow;", "isToolbarVisible", "()Lkotlinx/coroutines/flow/StateFlow;", "LMb/v;", "getOfflinePlaylistHelper", "()LMb/v;", "offlinePlaylistHelper", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "tiaraLogHelper", "PvLoggingData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicPlaylistBaseViewModel extends n0 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001C\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ2\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR#\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "", "", "action", "", "params", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/util/Map;)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$PvLoggingData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getAction", "b", "Ljava/util/Map;", "getParams", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PvLoggingData {
        public static final int $stable = 8;
        public final String a;
        public final Map b;

        public PvLoggingData(@Nullable String s, @NotNull Map map0) {
            q.g(map0, "params");
            super();
            this.a = s;
            this.b = map0;
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Map component2() {
            return this.b;
        }

        @NotNull
        public final PvLoggingData copy(@Nullable String s, @NotNull Map map0) {
            q.g(map0, "params");
            return new PvLoggingData(s, map0);
        }

        public static PvLoggingData copy$default(PvLoggingData musicPlaylistBaseViewModel$PvLoggingData0, String s, Map map0, int v, Object object0) {
            if((v & 1) != 0) {
                s = musicPlaylistBaseViewModel$PvLoggingData0.a;
            }
            if((v & 2) != 0) {
                map0 = musicPlaylistBaseViewModel$PvLoggingData0.b;
            }
            return musicPlaylistBaseViewModel$PvLoggingData0.copy(s, map0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof PvLoggingData)) {
                return false;
            }
            return q.b(this.a, ((PvLoggingData)object0).a) ? q.b(this.b, ((PvLoggingData)object0).b) : false;
        }

        @Nullable
        public final String getAction() {
            return this.a;
        }

        @NotNull
        public final Map getParams() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "PvLoggingData(action=" + this.a + ", params=" + this.b + ")";
        }
    }

    public static final int $stable = 8;
    public final CoroutineDispatcher a;
    public final CoroutineDispatcher b;
    public final PlaylistId c;
    public final String d;
    public final String e;
    public final d f;
    public final s2 g;
    public final z h;
    public final a i;
    public final k j;
    public final y k;
    public final Q l;
    public final t3 m;
    public final PlaylistDeleteHelper n;
    public final b3 o;
    public final k8.a p;
    public final LogU q;
    public final MutableStateFlow r;
    public final StateFlow s;
    public final g t;
    public boolean u;
    public boolean v;
    public final r w;
    public String x;

    public MusicPlaylistBaseViewModel(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull CoroutineDispatcher coroutineDispatcher1, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull PlaylistId playlistId0, @NotNull String s, @NotNull String s1, @NotNull d d0, @NotNull s2 s20, @NotNull z z0, @NotNull a a0, @NotNull k k0, @NotNull y y0, @NotNull Q q0, @NotNull t3 t30, @NotNull PlaylistDeleteHelper playlistDeleteHelper0, @NotNull b3 b30, @NotNull k8.a a1) {
        q.g(coroutineDispatcher0, "mainDispatcher");
        q.g(coroutineDispatcher1, "defaultDispatcher");
        q.g(coroutineDispatcher2, "ioDispatcher");
        q.g(playlistId0, "playlistId");
        q.g(s, "defaultMenuId");
        q.g(s1, "tagString");
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
        super();
        this.a = coroutineDispatcher1;
        this.b = coroutineDispatcher2;
        this.c = playlistId0;
        this.d = s;
        this.e = s1;
        this.f = d0;
        this.g = s20;
        this.h = z0;
        this.i = a0;
        this.j = k0;
        this.k = y0;
        this.l = q0;
        this.m = t30;
        this.n = playlistDeleteHelper0;
        this.o = b30;
        this.p = a1;
        this.q = LogU.Companion.create(s1, true, Category.UI);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.r = mutableStateFlow0;
        this.s = FlowKt.asStateFlow(mutableStateFlow0);
        g g0 = new g(new MusicPlaylistBaseViewModel.initSelectHelper.1());  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.d = new MusicPlaylistBaseViewModel.initSelectHelper.2.1();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.c = new MusicPlaylistBaseViewModel.initSelectHelper.2.2();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.t = g0;
        this.w = d3.g.Q(new com.iloen.melon.player.playlist.music.g(this, 0));
        n0.updateTiaraProperty$default(this, null, null, s, 3, null);
        this.updateUiState(new h(14));
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public final MusicPlaylistBaseViewModel B;
            public int r;
            public Object w;

            {
                this.B = musicPlaylistBaseViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                ne.a a0 = ne.a.a;
                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.B;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        B b0 = ((d3)musicPlaylistBaseViewModel0.getPlaylistManager()).p(musicPlaylistBaseViewModel0.getPlaylistId());
                        this.w = coroutineScope0;
                        this.r = 1;
                        object0 = ListenableFutureKt.await(b0, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Flow flow0 = ((d3)musicPlaylistBaseViewModel0.getPlaylistManager()).i();
                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1 musicPlaylistBaseViewModel$2$10 = new n(((oc.H)object0), coroutineScope0, null) {
                    public final MusicPlaylistBaseViewModel B;
                    public final oc.H D;
                    public final CoroutineScope E;
                    public int r;
                    public Object w;

                    {
                        this.B = musicPlaylistBaseViewModel0;
                        this.D = h0;
                        this.E = coroutineScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1(this.B, this.D, this.E, continuation0);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1)this.create(playlistId0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        PlaylistId playlistId0 = (PlaylistId)this.w;
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.B;
                                CoroutineScope coroutineScope0 = this.E;
                                oc.H h0 = this.D;
                                if(playlistId0 == musicPlaylistBaseViewModel0.getPlaylistId()) {
                                    Flow flow0 = FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.combine(h0.d(), musicPlaylistBaseViewModel0.getPlayerUseCase().h(), new o(coroutineScope0, null) {
                                        public Iterator B;
                                        public String D;
                                        public String E;
                                        public Uri G;
                                        public Playable I;
                                        public String M;
                                        public PlaylistId N;
                                        public y0 S;
                                        public List T;
                                        public Collection V;
                                        public boolean W;
                                        public boolean X;
                                        public boolean Y;
                                        public long Z;
                                        public int b0;
                                        public int c0;
                                        public int d0;
                                        public int e0;
                                        public int f0;
                                        public oc.Q g0;
                                        public boolean h0;
                                        public final MusicPlaylistBaseViewModel i0;
                                        public final CoroutineScope j0;
                                        public MusicPlaylistBaseViewModel r;
                                        public Collection w;

                                        {
                                            this.i0 = musicPlaylistBaseViewModel0;
                                            this.j0 = coroutineScope0;
                                            super(3, continuation0);
                                        }

                                        @Override  // we.o
                                        public Object invoke(Object object0, Object object1, Object object2) {
                                            return this.invoke(((oc.Q)object0), ((Boolean)object1).booleanValue(), ((Continuation)object2));
                                        }

                                        public final Object invoke(oc.Q q0, boolean z, Continuation continuation0) {
                                            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1 musicPlaylistBaseViewModel$2$1$10 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1(this.i0, this.j0, continuation0);
                                            musicPlaylistBaseViewModel$2$1$10.g0 = q0;
                                            musicPlaylistBaseViewModel$2$1$10.h0 = z;
                                            return musicPlaylistBaseViewModel$2$1$10.invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            int v17;
                                            boolean z9;
                                            String s5;
                                            int v15;
                                            String s4;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel3;
                                            PlaylistId playlistId2;
                                            String s3;
                                            boolean z7;
                                            int v14;
                                            y0 y03;
                                            Enum enum0;
                                            Collection collection3;
                                            Uri uri1;
                                            Playable playable1;
                                            int v13;
                                            List list3;
                                            long v12;
                                            Iterator iterator1;
                                            boolean z6;
                                            Collection collection1;
                                            int v7;
                                            boolean z4;
                                            Iterator iterator0;
                                            long v6;
                                            boolean z3;
                                            int v5;
                                            int v4;
                                            y0 y01;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel1;
                                            boolean z2;
                                            int v3;
                                            Collection collection0;
                                            List list1;
                                            PlaylistId playlistId0;
                                            List list0;
                                            Object object1;
                                            long v;
                                            oc.Q q0 = this.g0;
                                            boolean z = this.h0;
                                            ne.a a0 = ne.a.a;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.i0;
                                            switch(this.f0) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    v = System.currentTimeMillis();
                                                    v v1 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                                                    this.g0 = q0;
                                                    this.h0 = z;
                                                    this.Z = v;
                                                    this.f0 = 1;
                                                    if(v1.f("playlistId changed", this) == a0) {
                                                        return a0;
                                                    }
                                                    goto label_17;
                                                }
                                                case 1: {
                                                    v = this.Z;
                                                    d5.n.D(object0);
                                                label_17:
                                                    v v2 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                                                    this.g0 = q0;
                                                    this.h0 = z;
                                                    this.Z = v;
                                                    this.f0 = 2;
                                                    object1 = v2.h(this);
                                                    if(object1 == a0) {
                                                        return a0;
                                                    }
                                                    goto label_28;
                                                }
                                                case 2: {
                                                    v = this.Z;
                                                    d5.n.D(object0);
                                                    object1 = object0;
                                                label_28:
                                                    boolean z1 = ((Boolean)object1).booleanValue();
                                                    P p0 = q0 instanceof P ? ((P)q0) : null;
                                                    y0 y00 = p0 == null ? null : p0.a();
                                                    if(y00 == null) {
                                                        y00 = null;
                                                    }
                                                    if(y00 == null) {
                                                        LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not MusicSortType PlaylistSort", null, false, 6, null);
                                                        y00 = t0.b;
                                                    }
                                                    O o0 = q0 instanceof O ? ((O)q0) : null;
                                                    if(o0 == null) {
                                                        LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not PlaylistSelectRepeat", null, false, 6, null);
                                                        list0 = w.a;
                                                    }
                                                    else {
                                                        list0 = o0.d();
                                                        if(list0 == null) {
                                                            LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not PlaylistSelectRepeat", null, false, 6, null);
                                                            list0 = w.a;
                                                        }
                                                    }
                                                    playlistId0 = musicPlaylistBaseViewModel0.getPlaylistId();
                                                    Iterable iterable0 = q0.c();
                                                    list1 = list0;
                                                    collection0 = new ArrayList(je.q.Q(10, iterable0));
                                                    v3 = 0;
                                                    z2 = z1;
                                                    musicPlaylistBaseViewModel1 = musicPlaylistBaseViewModel0;
                                                    y01 = y00;
                                                    v4 = 1;
                                                    v5 = 0;
                                                    z3 = z;
                                                    v6 = v;
                                                    iterator0 = iterable0.iterator();
                                                    goto label_109;
                                                }
                                                case 3: {
                                                    z4 = this.X;
                                                    v7 = this.d0;
                                                    int v8 = this.c0;
                                                    int v9 = this.b0;
                                                    boolean z5 = this.W;
                                                    int v10 = this.e0;
                                                    long v11 = this.Z;
                                                    collection1 = this.V;
                                                    List list2 = this.T;
                                                    y0 y02 = this.S;
                                                    z6 = this.Y;
                                                    PlaylistId playlistId1 = this.N;
                                                    String s = this.M;
                                                    Playable playable0 = this.I;
                                                    Uri uri0 = this.G;
                                                    String s1 = this.E;
                                                    String s2 = this.D;
                                                    iterator1 = this.B;
                                                    Collection collection2 = this.w;
                                                    MusicPlaylistBaseViewModel musicPlaylistBaseViewModel2 = this.r;
                                                    d5.n.D(object0);
                                                    v12 = v11;
                                                    list3 = list2;
                                                    v13 = v8;
                                                    playable1 = playable0;
                                                    uri1 = uri0;
                                                    collection3 = collection2;
                                                    enum0 = object0;
                                                    y03 = y02;
                                                    v14 = v9;
                                                    z7 = z5;
                                                    s3 = s2;
                                                    playlistId2 = playlistId1;
                                                    musicPlaylistBaseViewModel3 = musicPlaylistBaseViewModel2;
                                                    s4 = s;
                                                    v15 = v10;
                                                    s5 = s1;
                                                    break;
                                                }
                                                default: {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                            }
                                            while(true) {
                                                collection1.add(new SongUiState(s4, playable1, uri1, s5, s3, false, false, z4, v7 != 0, ((b)enum0), 0x60, null));
                                                z3 = z6;
                                                musicPlaylistBaseViewModel1 = musicPlaylistBaseViewModel3;
                                                v4 = v15;
                                                v5 = v14;
                                                y01 = y03;
                                                playlistId0 = playlistId2;
                                                iterator0 = iterator1;
                                                z2 = z7;
                                                v6 = v12;
                                                collection0 = collection3;
                                                v3 = v13;
                                                list1 = list3;
                                            label_109:
                                                if(!iterator0.hasNext()) {
                                                    break;
                                                }
                                                Object object2 = iterator0.next();
                                                Playable playable2 = ((PlayableData)object2).a;
                                                q.f("", "getTrackId(...)");
                                                Uri uri2 = ((PlayableData)object2).m;
                                                String s6 = l1.n("", "getSongName(...)", playable2, "getArtistNames(...)");
                                                boolean z8 = playable2.isAdult();
                                                if(z2) {
                                                    v v16 = musicPlaylistBaseViewModel1.getOfflinePlaylistHelper();
                                                    z9 = z8;
                                                    z7 = true;
                                                    q.f("", "getContentId(...)");
                                                    v16.getClass();
                                                    if(v.b("")) {
                                                        v17 = 1;
                                                        goto label_128;
                                                    }
                                                }
                                                else {
                                                    z7 = false;
                                                    z9 = z8;
                                                }
                                                v17 = 0;
                                            label_128:
                                                boolean z10 = playable2.isOriginMelon();
                                                boolean z11 = playable2.isOriginLocal();
                                                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1 musicPlaylistBaseViewModel$2$1$1$1$10 = new we.k(playable2, null) {
                                                    public final Playable B;
                                                    public int r;
                                                    public final MusicPlaylistBaseViewModel w;

                                                    {
                                                        this.w = musicPlaylistBaseViewModel0;
                                                        this.B = playable0;
                                                        super(1, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Continuation continuation0) {
                                                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1(this.w, this.B, continuation0);
                                                    }

                                                    @Override  // we.k
                                                    public Object invoke(Object object0) {
                                                        return this.invoke(((Continuation)object0));
                                                    }

                                                    public final Object invoke(Continuation continuation0) {
                                                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                d5.n.D(object0);
                                                                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1.1 musicPlaylistBaseViewModel$2$1$1$1$1$10 = new n(null) {
                                                                    public final Playable r;

                                                                    {
                                                                        this.r = playable0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1.1(this.r, continuation0);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                    }

                                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        d5.n.D(object0);
                                                                        return this.r.getDisplayName();
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                object0 = BuildersKt.withContext(MusicPlaylistBaseViewModel.access$getIoDispatcher$p(this.w), musicPlaylistBaseViewModel$2$1$1$1$1$10, this);
                                                                if(object0 == a0) {
                                                                    return a0;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                d5.n.D(object0);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                        q.f(object0, "withContext(...)");
                                                        return object0;
                                                    }
                                                };
                                                this.g0 = q0;
                                                this.r = musicPlaylistBaseViewModel1;
                                                this.w = collection0;
                                                this.B = iterator0;
                                                this.D = s6;
                                                this.E = "";
                                                this.G = uri2;
                                                this.I = playable2;
                                                this.M = "";
                                                this.N = playlistId0;
                                                this.S = y01;
                                                this.T = list1;
                                                this.V = collection0;
                                                this.h0 = z;
                                                this.Z = v6;
                                                this.W = z7;
                                                this.b0 = v5;
                                                this.c0 = v3;
                                                this.d0 = v17;
                                                this.X = z9;
                                                this.e0 = v4;
                                                this.Y = z3;
                                                this.f0 = 3;
                                                musicPlaylistBaseViewModel1.getPlayableUseCase().getClass();
                                                enum0 = new F().t(z10, z11, musicPlaylistBaseViewModel$2$1$1$1$10, this);  // 初始化器: Ljava/lang/Object;-><init>()V
                                                if(enum0 == a0) {
                                                    return a0;
                                                }
                                                iterator1 = iterator0;
                                                s4 = "";
                                                playable1 = playable2;
                                                playlistId2 = playlistId0;
                                                z4 = z9;
                                                v12 = v6;
                                                z6 = z3;
                                                v13 = v3;
                                                list3 = list1;
                                                v7 = v17;
                                                collection3 = collection0;
                                                v14 = v5;
                                                y03 = y01;
                                                s5 = "";
                                                v15 = v4;
                                                musicPlaylistBaseViewModel3 = musicPlaylistBaseViewModel1;
                                                uri1 = uri2;
                                                s3 = s6;
                                                collection1 = collection3;
                                            }
                                            Success musicPlaylistUiState$Success0 = new Success(playlistId0, v4 != 0, z3, y01, list1, ((List)collection0), q0.b(), null, 0x80, null);
                                            LogConstantsKt.debug(musicPlaylistBaseViewModel0.getLog(), "makeUiStateWhenIsCurrentPlaylist - songListSize:" + musicPlaylistUiState$Success0.getSongList().size(), v6);
                                            return musicPlaylistUiState$Success0;
                                        }
                                    })), MusicPlaylistBaseViewModel.access$getDefaultDispatcher$p(musicPlaylistBaseViewModel0));
                                    com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.2 musicPlaylistBaseViewModel$2$1$20 = new n(null) {
                                        public Object r;
                                        public final MusicPlaylistBaseViewModel w;

                                        {
                                            this.w = musicPlaylistBaseViewModel0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.2(this.w, continuation0);
                                            continuation1.r = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(Success musicPlaylistUiState$Success0, Continuation continuation0) {
                                            return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.2)this.create(musicPlaylistUiState$Success0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((Success)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            Success musicPlaylistUiState$Success0 = (Success)this.r;
                                            d5.n.D(object0);
                                            long v = System.currentTimeMillis();
                                            m m0 = new m(musicPlaylistUiState$Success0, 0);
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.w;
                                            MusicPlaylistBaseViewModel.access$updateUiStatePreservePrevSelectedState(musicPlaylistBaseViewModel0, m0);
                                            if(!MusicPlaylistBaseViewModel.access$getCheckOfflineDownloadingOnInit$p(musicPlaylistBaseViewModel0)) {
                                                musicPlaylistBaseViewModel0.getOfflinePlaylistHelper().a();
                                                MusicPlaylistBaseViewModel.access$setCheckOfflineDownloadingOnInit$p(musicPlaylistBaseViewModel0, true);
                                            }
                                            LogConstantsKt.debug(musicPlaylistBaseViewModel0.getLog(), "updateUiStateWhenIsCurrentPlaylist - songListSize:" + musicPlaylistUiState$Success0.getSongList().size(), v);
                                            return H.a;
                                        }
                                    };
                                    this.w = null;
                                    this.r = 1;
                                    if(FlowKt.collectLatest(flow0, musicPlaylistBaseViewModel$2$1$20, this) == a0) {
                                        return a0;
                                    }
                                }
                                else {
                                    MutableStateFlow mutableStateFlow0 = h0.d();
                                    com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3 musicPlaylistBaseViewModel$2$1$30 = new n(coroutineScope0, null) {
                                        public Iterator B;
                                        public String D;
                                        public String E;
                                        public Uri G;
                                        public Playable I;
                                        public String M;
                                        public PlaylistId N;
                                        public y0 S;
                                        public List T;
                                        public Collection V;
                                        public long W;
                                        public boolean X;
                                        public boolean Y;
                                        public int Z;
                                        public int b0;
                                        public int c0;
                                        public int d0;
                                        public int e0;
                                        public int f0;
                                        public Object g0;
                                        public final MusicPlaylistBaseViewModel h0;
                                        public final CoroutineScope i0;
                                        public MusicPlaylistBaseViewModel r;
                                        public Collection w;

                                        {
                                            this.h0 = musicPlaylistBaseViewModel0;
                                            this.i0 = coroutineScope0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3(this.h0, this.i0, continuation0);
                                            continuation1.g0 = object0;
                                            return continuation1;
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((oc.Q)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(oc.Q q0, Continuation continuation0) {
                                            return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3)this.create(q0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            int v20;
                                            int v19;
                                            boolean z5;
                                            long v17;
                                            Iterator iterator2;
                                            String s5;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel3;
                                            Enum enum0;
                                            Collection collection3;
                                            String s4;
                                            boolean z3;
                                            int v16;
                                            int v15;
                                            List list3;
                                            String s3;
                                            y0 y03;
                                            Uri uri1;
                                            PlaylistId playlistId2;
                                            Playable playable1;
                                            int v14;
                                            int v13;
                                            Collection collection1;
                                            int v10;
                                            Iterator iterator0;
                                            int v7;
                                            long v6;
                                            int v5;
                                            y0 y01;
                                            int v4;
                                            int v3;
                                            Collection collection0;
                                            List list1;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel1;
                                            boolean z1;
                                            PlaylistId playlistId0;
                                            List list0;
                                            Object object1;
                                            long v;
                                            oc.Q q0 = (oc.Q)this.g0;
                                            ne.a a0 = ne.a.a;
                                            MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.h0;
                                            switch(this.f0) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    v = System.currentTimeMillis();
                                                    v v1 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                                                    this.g0 = q0;
                                                    this.W = v;
                                                    this.f0 = 1;
                                                    if(v1.f("playlistId changed", this) == a0) {
                                                        return a0;
                                                    }
                                                    goto label_15;
                                                }
                                                case 1: {
                                                    v = this.W;
                                                    d5.n.D(object0);
                                                label_15:
                                                    v v2 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                                                    this.g0 = q0;
                                                    this.W = v;
                                                    this.f0 = 2;
                                                    object1 = v2.h(this);
                                                    if(object1 == a0) {
                                                        return a0;
                                                    }
                                                    goto label_25;
                                                }
                                                case 2: {
                                                    v = this.W;
                                                    d5.n.D(object0);
                                                    object1 = object0;
                                                label_25:
                                                    boolean z = ((Boolean)object1).booleanValue();
                                                    P p0 = q0 instanceof P ? ((P)q0) : null;
                                                    y0 y00 = p0 == null ? null : p0.a();
                                                    if(y00 == null) {
                                                        y00 = null;
                                                    }
                                                    if(y00 == null) {
                                                        LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not MusicSortType PlaylistSort", null, false, 6, null);
                                                        y00 = t0.b;
                                                    }
                                                    O o0 = q0 instanceof O ? ((O)q0) : null;
                                                    if(o0 == null) {
                                                        LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not PlaylistSelectRepeat", null, false, 6, null);
                                                        list0 = w.a;
                                                    }
                                                    else {
                                                        list0 = o0.d();
                                                        if(list0 == null) {
                                                            LogU.warn$default(musicPlaylistBaseViewModel0.getLog(), "not PlaylistSelectRepeat", null, false, 6, null);
                                                            list0 = w.a;
                                                        }
                                                    }
                                                    playlistId0 = musicPlaylistBaseViewModel0.getPlaylistId();
                                                    Iterable iterable0 = q0.c();
                                                    z1 = z;
                                                    musicPlaylistBaseViewModel1 = musicPlaylistBaseViewModel0;
                                                    list1 = list0;
                                                    collection0 = new ArrayList(je.q.Q(10, iterable0));
                                                    v3 = 0;
                                                    v4 = 0;
                                                    y01 = y00;
                                                    v5 = 0;
                                                    v6 = v;
                                                    v7 = 0;
                                                    iterator0 = iterable0.iterator();
                                                    goto label_106;
                                                }
                                                case 3: {
                                                    int v8 = this.d0;
                                                    int v9 = this.c0;
                                                    v10 = this.b0;
                                                    int v11 = this.Z;
                                                    z1 = this.X;
                                                    boolean z2 = this.Y;
                                                    long v12 = this.W;
                                                    collection1 = this.V;
                                                    List list2 = this.T;
                                                    y0 y02 = this.S;
                                                    PlaylistId playlistId1 = this.N;
                                                    v13 = this.e0;
                                                    String s = this.M;
                                                    Playable playable0 = this.I;
                                                    Uri uri0 = this.G;
                                                    String s1 = this.E;
                                                    String s2 = this.D;
                                                    Iterator iterator1 = this.B;
                                                    Collection collection2 = this.w;
                                                    MusicPlaylistBaseViewModel musicPlaylistBaseViewModel2 = this.r;
                                                    d5.n.D(object0);
                                                    v14 = v8;
                                                    playable1 = playable0;
                                                    playlistId2 = playlistId1;
                                                    uri1 = uri0;
                                                    y03 = y02;
                                                    s3 = s2;
                                                    list3 = list2;
                                                    v15 = v9;
                                                    v16 = v11;
                                                    z3 = z2;
                                                    s4 = s;
                                                    collection3 = collection2;
                                                    enum0 = object0;
                                                    musicPlaylistBaseViewModel3 = musicPlaylistBaseViewModel2;
                                                    s5 = s1;
                                                    iterator2 = iterator1;
                                                    v17 = v12;
                                                    break;
                                                }
                                                default: {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                            }
                                            while(true) {
                                                collection1.add(new SongUiState(s4, playable1, uri1, s5, s3, false, false, z3, v15 != 0, ((b)enum0), 0x60, null));
                                                v7 = v13;
                                                musicPlaylistBaseViewModel1 = musicPlaylistBaseViewModel3;
                                                v5 = v14;
                                                y01 = y03;
                                                iterator0 = iterator2;
                                                playlistId0 = playlistId2;
                                                v6 = v17;
                                                v3 = v10;
                                                v4 = v16;
                                                collection0 = collection3;
                                                list1 = list3;
                                            label_106:
                                                if(!iterator0.hasNext()) {
                                                    break;
                                                }
                                                Object object2 = iterator0.next();
                                                Playable playable2 = ((PlayableData)object2).a;
                                                q.f("", "getTrackId(...)");
                                                Uri uri2 = ((PlayableData)object2).m;
                                                v14 = v5;
                                                String s6 = l1.n("", "getSongName(...)", playable2, "getArtistNames(...)");
                                                boolean z4 = playable2.isAdult();
                                                if(z1) {
                                                    v v18 = musicPlaylistBaseViewModel1.getOfflinePlaylistHelper();
                                                    z5 = z4;
                                                    v19 = v4;
                                                    q.f("", "getContentId(...)");
                                                    v18.getClass();
                                                    if(v.b("")) {
                                                        v20 = 1;
                                                        goto label_126;
                                                    }
                                                }
                                                else {
                                                    z5 = z4;
                                                    v19 = v4;
                                                }
                                                v20 = 0;
                                            label_126:
                                                boolean z6 = playable2.isOriginMelon();
                                                boolean z7 = playable2.isOriginLocal();
                                                v15 = v20;
                                                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1 musicPlaylistBaseViewModel$2$1$3$newUiState$1$10 = new we.k(playable2, null) {
                                                    public final Playable B;
                                                    public int r;
                                                    public final MusicPlaylistBaseViewModel w;

                                                    {
                                                        this.w = musicPlaylistBaseViewModel0;
                                                        this.B = playable0;
                                                        super(1, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Continuation continuation0) {
                                                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1(this.w, this.B, continuation0);
                                                    }

                                                    @Override  // we.k
                                                    public Object invoke(Object object0) {
                                                        return this.invoke(((Continuation)object0));
                                                    }

                                                    public final Object invoke(Continuation continuation0) {
                                                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.r) {
                                                            case 0: {
                                                                d5.n.D(object0);
                                                                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1.1 musicPlaylistBaseViewModel$2$1$3$newUiState$1$1$10 = new n(null) {
                                                                    public final Playable r;

                                                                    {
                                                                        this.r = playable0;
                                                                        super(2, continuation0);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1.1(this.r, continuation0);
                                                                    }

                                                                    @Override  // we.n
                                                                    public Object invoke(Object object0, Object object1) {
                                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                    }

                                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.2.1.3.newUiState.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                    }

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        d5.n.D(object0);
                                                                        return "";
                                                                    }
                                                                };
                                                                this.r = 1;
                                                                object0 = BuildersKt.withContext(MusicPlaylistBaseViewModel.access$getIoDispatcher$p(this.w), musicPlaylistBaseViewModel$2$1$3$newUiState$1$1$10, this);
                                                                if(object0 == a0) {
                                                                    return a0;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                d5.n.D(object0);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                        q.f(object0, "withContext(...)");
                                                        return object0;
                                                    }
                                                };
                                                this.g0 = q0;
                                                this.r = musicPlaylistBaseViewModel1;
                                                this.w = collection0;
                                                this.B = iterator0;
                                                this.D = s6;
                                                this.E = "";
                                                this.G = uri2;
                                                this.I = playable2;
                                                this.M = "";
                                                this.N = playlistId0;
                                                this.S = y01;
                                                this.T = list1;
                                                this.V = collection0;
                                                this.W = v6;
                                                this.X = z1;
                                                this.Z = v19;
                                                v10 = v3;
                                                this.b0 = v10;
                                                this.c0 = v15;
                                                this.Y = z5;
                                                this.d0 = v14;
                                                this.e0 = v7;
                                                this.f0 = 3;
                                                musicPlaylistBaseViewModel1.getPlayableUseCase().getClass();
                                                iterator2 = iterator0;
                                                enum0 = new F().t(z6, z7, musicPlaylistBaseViewModel$2$1$3$newUiState$1$10, this);  // 初始化器: Ljava/lang/Object;-><init>()V
                                                if(enum0 == a0) {
                                                    return a0;
                                                }
                                                uri1 = uri2;
                                                s4 = "";
                                                y03 = y01;
                                                s3 = s6;
                                                collection3 = collection0;
                                                v13 = v7;
                                                list3 = list1;
                                                v16 = v19;
                                                musicPlaylistBaseViewModel3 = musicPlaylistBaseViewModel1;
                                                playable1 = playable2;
                                                playlistId2 = playlistId0;
                                                s5 = "";
                                                collection1 = collection3;
                                                z3 = z5;
                                                v17 = v6;
                                            }
                                            Success musicPlaylistUiState$Success0 = new Success(playlistId0, v5 != 0, v7 != 0, y01, list1, ((List)collection0), q0.b(), null, 0x80, null);
                                            LogConstantsKt.debug(musicPlaylistBaseViewModel0.getLog(), "makeUiState - songListSize:" + musicPlaylistUiState$Success0.getSongList().size(), v6);
                                            long v21 = System.currentTimeMillis();
                                            MusicPlaylistBaseViewModel.access$updateUiStatePreservePrevSelectedState(musicPlaylistBaseViewModel0, new m(musicPlaylistUiState$Success0, 0));
                                            if(!musicPlaylistBaseViewModel0.v) {
                                                musicPlaylistBaseViewModel0.getOfflinePlaylistHelper().a();
                                                musicPlaylistBaseViewModel0.v = true;
                                            }
                                            LogConstantsKt.debug(musicPlaylistBaseViewModel0.getLog(), "updateUiState - songListSize: " + musicPlaylistUiState$Success0.getSongList().size(), v21);
                                            return H.a;
                                        }
                                    };
                                    this.w = null;
                                    this.r = 2;
                                    if(FlowKt.collectLatest(mutableStateFlow0, musicPlaylistBaseViewModel$2$1$30, this) == a0) {
                                        return a0;
                                    }
                                }
                                return H.a;
                            }
                            case 1: 
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                this.w = null;
                this.r = 2;
                return FlowKt.collectLatest(flow0, musicPlaylistBaseViewModel$2$10, this) == a0 ? a0 : H.a;
            }
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), coroutineDispatcher0, null, new n(null) {
            public final MusicPlaylistBaseViewModel B;
            public int r;
            public Object w;

            {
                this.B = musicPlaylistBaseViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        v v0 = this.B.getOfflinePlaylistHelper();
                        com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3.1 musicPlaylistBaseViewModel$3$10 = new FlowCollector() {
                            public final MusicPlaylistBaseViewModel a;
                            public final CoroutineScope b;

                            {
                                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = coroutineScope0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = musicPlaylistBaseViewModel0;
                                this.b = coroutineScope0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((String)object0), continuation0);
                            }

                            public final Object emit(String s, Continuation continuation0) {
                                w w0;
                                String s1;
                                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3.1.emit.1 musicPlaylistBaseViewModel$3$1$emit$10;
                                if(continuation0 instanceof com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3.1.emit.1) {
                                    musicPlaylistBaseViewModel$3$1$emit$10 = (com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.3.1.emit.1)continuation0;
                                    int v = musicPlaylistBaseViewModel$3$1$emit$10.D;
                                    if((v & 0x80000000) == 0) {
                                        musicPlaylistBaseViewModel$3$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            public int D;
                                            public String r;
                                            public Object w;

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                this.w = object0;
                                                this.D |= 0x80000000;
                                                return continuation0.emit(null, this);
                                            }
                                        };
                                    }
                                    else {
                                        musicPlaylistBaseViewModel$3$1$emit$10.D = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    musicPlaylistBaseViewModel$3$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        public int D;
                                        public String r;
                                        public Object w;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.w = object0;
                                            this.D |= 0x80000000;
                                            return continuation0.emit(null, this);
                                        }
                                    };
                                }
                                Object object0 = musicPlaylistBaseViewModel$3$1$emit$10.w;
                                ne.a a0 = ne.a.a;
                                H h0 = H.a;
                                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.a;
                                switch(musicPlaylistBaseViewModel$3$1$emit$10.D) {
                                    case 0: {
                                        d5.n.D(object0);
                                        s1 = s;
                                        LogU.debug$default(musicPlaylistBaseViewModel0.getLog(), "isOfflineDownloadSongComplete contentId: " + s1, null, false, 6, null);
                                        if(s1.length() == 0) {
                                            return h0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        s1 = musicPlaylistBaseViewModel$3$1$emit$10.r;
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                while(CoroutineScopeKt.isActive(this.b) && MusicPlaylistBaseViewModel.access$isDragging$p(musicPlaylistBaseViewModel0)) {
                                    musicPlaylistBaseViewModel$3$1$emit$10.r = s1;
                                    musicPlaylistBaseViewModel$3$1$emit$10.D = 1;
                                    if(DelayKt.delay(1000L, musicPlaylistBaseViewModel$3$1$emit$10) == a0) {
                                        return a0;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                                Object object1 = musicPlaylistBaseViewModel0.getUiState().getValue();
                                Success musicPlaylistUiState$Success0 = object1 instanceof Success ? ((Success)object1) : null;
                                if(musicPlaylistUiState$Success0 == null) {
                                    w0 = w.a;
                                }
                                else {
                                    List list0 = musicPlaylistUiState$Success0.getSongList();
                                    if(list0 == null) {
                                        w0 = w.a;
                                    }
                                    else {
                                        w0 = new ArrayList(je.q.Q(10, list0));
                                        for(Object object2: list0) {
                                            SongUiState songUiState0 = (SongUiState)object2;
                                            v v1 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                                            q.f("", "getContentId(...)");
                                            v1.getClass();
                                            if(v.b("") || q.b("", s1)) {
                                                songUiState0 = SongUiState.copy$default(songUiState0, null, null, null, null, null, false, false, false, true, null, 0x2FF, null);
                                            }
                                            ((ArrayList)w0).add(songUiState0);
                                        }
                                    }
                                }
                                MusicPlaylistBaseViewModel.access$updateSuccessUiState(musicPlaylistBaseViewModel0, new com.iloen.melon.player.playlist.music.n(w0, 0));
                                return h0;
                            }
                        };
                        this.w = null;
                        this.r = 1;
                        if(v0.m.collect(musicPlaylistBaseViewModel$3$10, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }, 2, null);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), coroutineDispatcher0, null, new n(null) {
            public int r;
            public final MusicPlaylistBaseViewModel w;

            {
                this.w = musicPlaylistBaseViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.4(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        v v0 = this.w.getOfflinePlaylistHelper();
                        com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.4.1 musicPlaylistBaseViewModel$4$10 = new n(null) {
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                            public static final class WhenMappings {
                                public static final int[] $EnumSwitchMapping$0;

                                static {
                                    int[] arr_v = new int[Ib.b.values().length];
                                    try {
                                        arr_v[4] = 1;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                }
                            }

                            public Object r;
                            public final MusicPlaylistBaseViewModel w;

                            {
                                this.w = musicPlaylistBaseViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.4.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(Ib.b b0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.4.1)this.create(b0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Ib.b)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                w w0;
                                Ib.b b0 = (Ib.b)this.r;
                                d5.n.D(object0);
                                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.w;
                                LogU.debug$default(musicPlaylistBaseViewModel0.getLog(), "offlineState: " + b0, null, false, 6, null);
                                if(WhenMappings.$EnumSwitchMapping$0[b0.ordinal()] == 1) {
                                    Object object1 = musicPlaylistBaseViewModel0.getUiState().getValue();
                                    Success musicPlaylistUiState$Success0 = object1 instanceof Success ? ((Success)object1) : null;
                                    if(musicPlaylistUiState$Success0 == null) {
                                        w0 = w.a;
                                    }
                                    else {
                                        List list0 = musicPlaylistUiState$Success0.getSongList();
                                        if(list0 == null) {
                                            w0 = w.a;
                                        }
                                        else {
                                            w0 = new ArrayList(je.q.Q(10, list0));
                                            for(Object object2: list0) {
                                                ((ArrayList)w0).add(SongUiState.copy$default(((SongUiState)object2), null, null, null, null, null, false, false, false, false, null, 0x2FF, null));
                                            }
                                        }
                                    }
                                    MusicPlaylistBaseViewModel.access$updateSuccessUiState(musicPlaylistBaseViewModel0, new com.iloen.melon.player.playlist.music.n(w0, 1));
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(v0.k, musicPlaylistBaseViewModel$4$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.toolBarEventHelper.2.1 extends kotlin.jvm.internal.n implements we.k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((I4)object0));
                return H.a;
            }

            public final void invoke(I4 i40) {
                q.g(i40, "p0");
                MusicPlaylistBaseViewModel.access$sendUiEvent(((MusicPlaylistBaseViewModel)this.receiver), i40);
            }
        }

    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        return musicPlaylistBaseViewModel0.a;
    }

    public static final CoroutineDispatcher access$getIoDispatcher$p(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        return musicPlaylistBaseViewModel0.b;
    }

    public static final Jd.a access$getToolBarEventHelper(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        return (Jd.a)musicPlaylistBaseViewModel0.w.getValue();
    }

    public static final boolean access$isDragging$p(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        return musicPlaylistBaseViewModel0.u;
    }

    public static final Object access$playAtPosition(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, int v, Continuation continuation0) {
        int v2;
        MusicPlaylistBaseViewModel.playAtPosition.1 musicPlaylistBaseViewModel$playAtPosition$10;
        z z0 = musicPlaylistBaseViewModel0.h;
        if(continuation0 instanceof MusicPlaylistBaseViewModel.playAtPosition.1) {
            musicPlaylistBaseViewModel$playAtPosition$10 = (MusicPlaylistBaseViewModel.playAtPosition.1)continuation0;
            int v1 = musicPlaylistBaseViewModel$playAtPosition$10.E;
            if((v1 & 0x80000000) == 0) {
                musicPlaylistBaseViewModel$playAtPosition$10 = new MusicPlaylistBaseViewModel.playAtPosition.1(musicPlaylistBaseViewModel0, continuation0);
            }
            else {
                musicPlaylistBaseViewModel$playAtPosition$10.E = v1 ^ 0x80000000;
            }
        }
        else {
            musicPlaylistBaseViewModel$playAtPosition$10 = new MusicPlaylistBaseViewModel.playAtPosition.1(musicPlaylistBaseViewModel0, continuation0);
        }
        Object object0 = musicPlaylistBaseViewModel$playAtPosition$10.B;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(musicPlaylistBaseViewModel$playAtPosition$10.E) {
            case 0: {
                d5.n.D(object0);
                Object object1 = musicPlaylistBaseViewModel0.getUiState().getValue();
                Success musicPlaylistUiState$Success0 = object1 instanceof Success ? ((Success)object1) : null;
                if(musicPlaylistUiState$Success0 == null) {
                    return h0;
                }
                v2 = musicPlaylistUiState$Success0.getCurrentIndex() == v ? 1 : 0;
                if(!musicPlaylistUiState$Success0.isCurrentPlaylist()) {
                    B b0 = ((d3)musicPlaylistBaseViewModel0.g).a(musicPlaylistBaseViewModel0.c);
                    musicPlaylistBaseViewModel$playAtPosition$10.r = v;
                    musicPlaylistBaseViewModel$playAtPosition$10.w = v2;
                    musicPlaylistBaseViewModel$playAtPosition$10.E = 1;
                    if(ListenableFutureKt.await(b0, musicPlaylistBaseViewModel$playAtPosition$10) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                int v3 = musicPlaylistBaseViewModel$playAtPosition$10.w;
                v = musicPlaylistBaseViewModel$playAtPosition$10.r;
                d5.n.D(object0);
                v2 = v3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(v2 != 0) {
            if(!z0.n()) {
                z0.u();
            }
            return h0;
        }
        z0.v(v);
        return h0;
    }

    public static final void access$setSelectRepeatAndPlay(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0) {
        List list0 = musicPlaylistBaseViewModel0.c();
        musicPlaylistBaseViewModel0.unSelectAll();
        BuildersKt__Builders_commonKt.launch$default(f0.h(musicPlaylistBaseViewModel0), null, null, new MusicPlaylistBaseViewModel.setSelectRepeatAndPlay.1(musicPlaylistBaseViewModel0, list0, null), 3, null);
    }

    public static final void access$updateUiStatePreservePrevSelectedState(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, we.k k0) {
        musicPlaylistBaseViewModel0.getClass();
        musicPlaylistBaseViewModel0.updateUiState(new l(0, k0));
    }

    public final c0 b() {
        Object object0 = this.getUiState().getValue();
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            c0 c00 = musicPlaylistUiState$Success0.getSectionSelectState();
            return c00 == null ? c0.b : c00;
        }
        return c0.b;
    }

    public final List c() {
        Object object0 = this.getUiState().getValue();
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            List list0 = musicPlaylistUiState$Success0.getSongList();
            if(list0 != null) {
                List list1 = new ArrayList();
                int v = 0;
                for(Object object1: list0) {
                    if(v >= 0) {
                        Integer integer0 = ((SongUiState)object1).isSelected() ? v : null;
                        if(integer0 != null) {
                            list1.add(integer0);
                        }
                        ++v;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return list1;
            }
        }
        return w.a;
    }

    public final List d() {
        Object object0 = this.getUiState().getValue();
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            List list0 = musicPlaylistUiState$Success0.getSongList();
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: list0) {
                    if(((SongUiState)object1).isSelected()) {
                        arrayList0.add(object1);
                    }
                }
                List list1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object2: arrayList0) {
                    list1.add(((SongUiState)object2).getPlayable());
                }
                return list1;
            }
        }
        return w.a;
    }

    public final void deletePlayable(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(playable0, null) {
            public final MusicPlaylistBaseViewModel r;
            public final Playable w;

            {
                this.r = musicPlaylistBaseViewModel0;
                this.w = playable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.deletePlayable.1(this.r, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.deletePlayable.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                List list0 = e.k.z(this.w);
                DeletePlaylistByPlayables deletePlaylist$DeletePlaylistByPlayables0 = new DeletePlaylistByPlayables(this.r.getPlaylistId(), list0, true, true, null, null, 0x30, null);
                T2.a a0 = f0.h(this.r);
                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.deletePlayable.1.1 musicPlaylistBaseViewModel$deletePlayable$1$10 = new we.k(0, MusicPlaylistBaseViewModel.class, this.r, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((I4)object0));
                        return H.a;
                    }

                    public final void invoke(I4 i40) {
                        q.g(i40, "p0");
                        ((MusicPlaylistBaseViewModel)this.receiver).sendUiEvent(i40);
                    }
                };
                this.r.getDeleteHelper().handleUserEvent(deletePlaylist$DeletePlaylistByPlayables0, a0, musicPlaylistBaseViewModel$deletePlayable$1$10);
                return H.a;
            }
        }, 3, null);
    }

    public final void e(String s, List list0) {
        e0 e00 = (e0)this.j;
        if(!e00.m()) {
            this.sendUiEvent(s4.a);
            return;
        }
        this.x = s;
        if(!e00.j().getIsDj()) {
            this.onUserEvent(new q3("M20001", list0, ""));
            return;
        }
        this.sendUiEvent(new ShowContextMenuAddToPopup(list0, s));
    }

    public final void f(we.k k0) {
        this.updateUiState(new l(1, k0));
    }

    @NotNull
    public final Q getAddPlayUserEventHelper() {
        return this.l;
    }

    @NotNull
    public final List getAllPlayables() {
        Object object0 = this.getUiState().getValue();
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            List list0 = musicPlaylistUiState$Success0.getSongList();
            if(list0 != null) {
                List list1 = new ArrayList(je.q.Q(10, list0));
                for(Object object1: list0) {
                    list1.add(((SongUiState)object1).getPlayable());
                }
                return list1;
            }
        }
        return w.a;
    }

    @NotNull
    public final k8.a getBlockingProgressDialogManage() {
        return this.p;
    }

    @NotNull
    public final String getDefaultMenuId() {
        return this.d;
    }

    @NotNull
    public final PlaylistDeleteHelper getDeleteHelper() {
        return this.n;
    }

    @NotNull
    public final LogU getLog() {
        return this.q;
    }

    @NotNull
    public final k getLoginUseCase() {
        return this.j;
    }

    @NotNull
    public final b3 getMorePopupUserEventHelper() {
        return this.o;
    }

    @NotNull
    public abstract v getOfflinePlaylistHelper();

    @Nullable
    public final Playable getPlayable(int v) {
        SongUiState songUiState0 = this.getSongUiState(v);
        return songUiState0 == null ? null : songUiState0.getPlayable();
    }

    @NotNull
    public final a getPlayableUseCase() {
        return this.i;
    }

    @NotNull
    public final z getPlayerUseCase() {
        return this.h;
    }

    @NotNull
    public final PlaylistId getPlaylistId() {
        return this.c;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        return this.g;
    }

    @NotNull
    public final t3 getPutPopupUserEventHelper() {
        return this.m;
    }

    @NotNull
    public abstract PvLoggingData getPvLoggingData();

    @Nullable
    public final SongUiState getSongUiState(int v) {
        Object object0 = this.getUiState().getValue();
        Success musicPlaylistUiState$Success0 = object0 instanceof Success ? ((Success)object0) : null;
        if(musicPlaylistUiState$Success0 != null) {
            List list0 = musicPlaylistUiState$Success0.getSongList();
            return list0 == null ? null : ((SongUiState)p.n0(v, list0));
        }
        return null;
    }

    @NotNull
    public final d getStringProvider() {
        return this.f;
    }

    @NotNull
    public final String getTagString() {
        return this.e;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final TiaraMixUpEventMeta getTiaraEventMetaForMixUp() {
        List list0 = this.d();
        String s = list0.size() <= 1 ? ((StringProviderImpl)this.f).a(0x7F130F14) : ((StringProviderImpl)this.f).a(0x7F130F15);  // string:tiara_mixup_page_meta_type_song "곡 믹스업"
        boolean z = ((Playable)p.m0(list0)) == null;
        return new TiaraMixUpEventMeta("", s, "");
    }

    @NotNull
    public abstract PlaylistSongBaseTiaraLogHelper getTiaraLogHelper();

    @NotNull
    public final y getUaLogUseCase() {
        return this.k;
    }

    public final boolean isDj() {
        return ((e0)this.j).j().getIsDj();
    }

    @NotNull
    public final StateFlow isToolbarVisible() {
        return this.s;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPremiumCacheDelete eventPremiumCacheDelete0) {
        q.g(eventPremiumCacheDelete0, "event");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final MusicPlaylistBaseViewModel w;

            {
                this.w = musicPlaylistBaseViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onEventMainThread.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onEventMainThread.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        v v0 = musicPlaylistBaseViewModel0.getOfflinePlaylistHelper();
                        this.r = 1;
                        object0 = v0.h(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                boolean z = ((Boolean)object0).booleanValue();
                LogU.debug$default(musicPlaylistBaseViewModel0.getLog(), "EventPremiumCacheDelete showOfflineItemBadgeInPlaylist: " + z, null, false, 6, null);
                if(z) {
                    musicPlaylistBaseViewModel0.f(new j(musicPlaylistBaseViewModel0, 4));
                }
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.melon.ui.n0
    public void onUserEvent(@NotNull e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof ClickSortOrderUserEvent) {
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.1 musicPlaylistBaseViewModel$onUserEvent$10 = new we.k(null) {
                public final MusicPlaylistBaseViewModel r;

                {
                    this.r = musicPlaylistBaseViewModel0;
                    super(1, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.1(this.r, continuation0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.1)this.create(continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    d5.n.D(object0);
                    this.r.sendUiEvent(SortOrderListPopupEvent.INSTANCE);
                    return H.a;
                }
            };
            MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1 musicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$10 = new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1(this, null);
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2(musicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$10, this, musicPlaylistBaseViewModel$onUserEvent$10, null), 3, null);
            this.getTiaraLogHelper().sendOrderClickLog();
            return;
        }
        if(e0 instanceof ClickSortTypeInPopupUserEvent) {
            y0 y00 = ((ClickSortTypeInPopupUserEvent)e0).getSortType();
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MusicPlaylistBaseViewModel.setSort.1(this, y00, null), 3, null);
            this.getTiaraLogHelper().sendOrderPopupClickLog(((ClickSortTypeInPopupUserEvent)e0).getSortTypeString());
            return;
        }
        if(e0 instanceof ClickCheckBoxSongItem) {
            c0 c00 = this.b();
            c0.a.getClass();
            if(F.u(c00)) {
                this.f(new com.iloen.melon.player.playlist.music.h(this, ((ClickCheckBoxSongItem)e0).getPosition()));
            }
            else {
                this.select(((ClickCheckBoxSongItem)e0).getPosition());
            }
            this.getTiaraLogHelper().sendCheckBoxClickLog(((ClickCheckBoxSongItem)e0).getPosition(), this.getPlayable(((ClickCheckBoxSongItem)e0).getPosition()));
            return;
        }
        if(e0 instanceof ClickAllSelectUserEvent) {
            this.toggleSelectAll();
            this.getTiaraLogHelper().sendAllSelectFilterClickLog();
            return;
        }
        if(e0 instanceof ClickSongItem) {
            c0 c01 = this.b();
            c0.a.getClass();
            if(F.u(c01)) {
                this.f(new com.iloen.melon.player.playlist.music.h(this, ((ClickSongItem)e0).getPosition()));
            }
            else if(this.c().isEmpty()) {
                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.2 musicPlaylistBaseViewModel$onUserEvent$20 = new we.k(this, null) {
                    public final e B;
                    public int r;
                    public final MusicPlaylistBaseViewModel w;

                    {
                        this.w = musicPlaylistBaseViewModel0;
                        this.B = e0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.2(this.B, this.w, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.2)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                int v = ((ClickSongItem)this.B).getPosition();
                                this.r = 1;
                                Object object1 = this.w.getPlayerUseCase().p(this.w.getPlaylistId(), v, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.3 musicPlaylistBaseViewModel$onUserEvent$30 = new we.k(this, null) {
                    public final e B;
                    public int r;
                    public final MusicPlaylistBaseViewModel w;

                    {
                        this.w = musicPlaylistBaseViewModel0;
                        this.B = e0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.3(this.B, this.w, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.3)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                int v = ((ClickSongItem)this.B).getPosition();
                                this.r = 1;
                                return MusicPlaylistBaseViewModel.access$playAtPosition(this.w, v, this) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2(musicPlaylistBaseViewModel$onUserEvent$20, this, musicPlaylistBaseViewModel$onUserEvent$30, null), 3, null);
            }
            else {
                this.select(((ClickSongItem)e0).getPosition());
            }
            this.getTiaraLogHelper().sendPlayClickLog(((ClickSongItem)e0).getPosition(), this.getPlayable(((ClickSongItem)e0).getPosition()));
            return;
        }
        if(e0 instanceof ClickAlbumThumbnail) {
            Playable playable0 = this.getPlayable(((ClickAlbumThumbnail)e0).getPosition());
            this.getTiaraLogHelper().sendAlbumImgClickLog(((ClickAlbumThumbnail)e0).getPosition(), playable0);
            c0 c02 = this.b();
            c0.a.getClass();
            if(F.u(c02)) {
                this.f(new com.iloen.melon.player.playlist.music.h(this, ((ClickAlbumThumbnail)e0).getPosition()));
                return;
            }
            if(!this.c().isEmpty()) {
                this.select(((ClickAlbumThumbnail)e0).getPosition());
                return;
            }
            if(playable0 != null && playable0.hasSongId()) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(playable0, null) {
                    public final Playable B;
                    public int r;
                    public final MusicPlaylistBaseViewModel w;

                    {
                        this.w = musicPlaylistBaseViewModel0;
                        this.B = playable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.4(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                L0 l00 = this.w.getProgressUpdater();
                                this.r = 1;
                                this.w.getPlayableUseCase().getClass();
                                return a.a(this.B, l00, this) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }, 3, null);
            }
            return;
        }
        if(e0 instanceof ClickGroupTitle) {
            int v = ((ClickGroupTitle)e0).getGroupItemStartIndex();
            int v1 = ((ClickGroupTitle)e0).getCount();
            c0 c03 = this.b();
            c0.a.getClass();
            if(F.u(c03)) {
                this.f(new i(this, P4.a.K(v, v1 + v)));
                return;
            }
            this.f(new Uc.n(v, v1, this, 3));
            return;
        }
        if(e0 instanceof ClickSectionSelectButton) {
            this.unSelectAll();
            this.sendUiEvent(new t4(((StringProviderImpl)this.f).a(0x7F130A3F)));  // string:smartplaylist_section_start_toast_msg "구간선택을 위해 곡 선택이 해제되었습니다."
            this.f(new h(15));
            this.getTiaraLogHelper().sendSectionSelectClickLog();
            return;
        }
        if(e0 instanceof ClickSectionSelectCancelButton) {
            this.unSelectAll();
            this.f(new h(16));
            return;
        }
        if(e0 instanceof MoveSongItem) {
            Playable playable1 = this.getPlayable(((MoveSongItem)e0).getFrom());
            int v2 = ((MoveSongItem)e0).getFrom();
            int v3 = ((MoveSongItem)e0).getTo();
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MusicPlaylistBaseViewModel.moveSongItem.1(this, v2, v3, null), 3, null);
            this.getTiaraLogHelper().sendMoveClickLog(((MoveSongItem)e0).getFrom(), playable1);
            return;
        }
        if(e0 instanceof OnTouchDownMoveIconWhenSelectRepeatOn) {
            this.sendUiEvent(new ShowSelectionRepeatInterruptPopup(new com.iloen.melon.player.playlist.music.g(this, 1)));
            return;
        }
        if(e0 instanceof ToolBarClickReplayUserEvent) {
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.8 musicPlaylistBaseViewModel$onUserEvent$80 = new we.k(null) {
                public final MusicPlaylistBaseViewModel r;

                {
                    this.r = musicPlaylistBaseViewModel0;
                    super(1, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.8(this.r, continuation0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.8)this.create(continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    d5.n.D(object0);
                    MusicPlaylistBaseViewModel.access$setSelectRepeatAndPlay(this.r);
                    return H.a;
                }
            };
            MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1 musicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$11 = new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.1(this, null);
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MusicPlaylistBaseViewModel.checkSelectRepeatClearAndDo.2(musicPlaylistBaseViewModel$checkSelectRepeatClearAndDo$11, this, musicPlaylistBaseViewModel$onUserEvent$80, null), 3, null);
            return;
        }
        if(e0 instanceof ToolBarClickPutUserEvent) {
            this.e("toolbar", this.d());
            return;
        }
        if(e0 instanceof ToolBarClickRemoveUserEvent) {
            List list0 = this.c();
            this.onUserEvent(new DeletePlaylistByIndices(this.c, list0, true, true, null, null, 0x30, null));
            return;
        }
        if(e0 instanceof ClickPutInMorePopupUserEvent) {
            this.e("more", e.k.z(((ClickPutInMorePopupUserEvent)e0).getPlayable()));
            return;
        }
        if(e0 instanceof DeletePlaylist) {
            T2.a a0 = f0.h(this);
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.9 musicPlaylistBaseViewModel$onUserEvent$90 = new we.k(0, MusicPlaylistBaseViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MusicPlaylistBaseViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.n.handleUserEvent(((DeletePlaylist)e0), a0, musicPlaylistBaseViewModel$onUserEvent$90);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a1 = f0.h(this);
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.10 musicPlaylistBaseViewModel$onUserEvent$100 = new we.k(0, MusicPlaylistBaseViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MusicPlaylistBaseViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.l.d(((com.melon.ui.q)e0), a1, musicPlaylistBaseViewModel$onUserEvent$100);
            return;
        }
        if(e0 instanceof Jd.g) {
            if(e0 instanceof Jd.c) {
                for(Object object0: this.d()) {
                    ((Playable)object0).setDownloadOrigin(1);
                }
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(this, null) {
                public final MusicPlaylistBaseViewModel B;
                public int r;
                public final e w;

                {
                    this.w = e0;
                    this.B = musicPlaylistBaseViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.12(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.12)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    H h0 = H.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            String s = this.B.getMenuId();
                            ((Jd.g)this.w).b(s);
                            ((Jd.g)this.w).b = this.B.getStatsElements();
                            Jd.a a1 = MusicPlaylistBaseViewModel.access$getToolBarEventHelper(this.B);
                            List list0 = this.B.d();
                            this.r = 1;
                            Jd.a.b(a1, ((Jd.g)this.w), list0);
                            return h0 == a0 ? a0 : h0;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return h0;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 3, null);
            return;
        }
        k k0 = this.j;
        if(e0 instanceof q3) {
            if(q.b(this.x, "toolbar")) {
                this.unSelectAll();
            }
            T2.a a2 = f0.h(this);
            boolean z = ((e0)k0).m();
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.13 musicPlaylistBaseViewModel$onUserEvent$130 = new we.k(0, MusicPlaylistBaseViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MusicPlaylistBaseViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l00 = this.getProgressUpdater();
            this.m.a(((q3)e0), a2, z, musicPlaylistBaseViewModel$onUserEvent$130, l00);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a3 = f0.h(this);
            boolean z1 = ((e0)k0).m();
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.14 musicPlaylistBaseViewModel$onUserEvent$140 = new we.k(0, MusicPlaylistBaseViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MusicPlaylistBaseViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l01 = this.getProgressUpdater();
            this.o.b(((L2)e0), a3, z1, musicPlaylistBaseViewModel$onUserEvent$140, l01);
            return;
        }
        if(e0 instanceof Lb.d) {
            this.getTiaraLogHelper().sendOfflinePlayClickLog(!((Ib.b)this.getOfflinePlaylistHelper().k.getValue()).a);
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
                public int r;
                public final MusicPlaylistBaseViewModel w;

                {
                    this.w = musicPlaylistBaseViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.15(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.15)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            v v0 = this.w.getOfflinePlaylistHelper();
                            this.r = 1;
                            return v0.d(this) == a0 ? a0 : H.a;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 3, null);
            return;
        }
        if(e0 instanceof Ed.a) {
            T2.a a4 = f0.h(this);
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.16 musicPlaylistBaseViewModel$onUserEvent$160 = new n(this, null) {
                public final e B;
                public int r;
                public final MusicPlaylistBaseViewModel w;

                {
                    this.w = musicPlaylistBaseViewModel0;
                    this.B = e0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.16(this.B, this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.16)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return this.w.getUaLogUseCase().a(((Ed.a)this.B).a, ((Ed.a)this.B).b, this) == a0 ? a0 : H.a;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            };
            BuildersKt__Builders_commonKt.launch$default(a4, this.b, null, musicPlaylistBaseViewModel$onUserEvent$160, 2, null);
            return;
        }
        super.onUserEvent(e0);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel$onUserEvent$7$1", f = "MusicPlaylistBaseViewModel.kt", l = {538}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.7.1 extends oe.i implements n {
            public int r;
            public final MusicPlaylistBaseViewModel w;

            public com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.7.1(MusicPlaylistBaseViewModel musicPlaylistBaseViewModel0, Continuation continuation0) {
                this.w = musicPlaylistBaseViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.7.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.7.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.getPlayerUseCase().b(0x7F13090F, this) == a0 ? a0 : H.a;  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    public final void performPvLoggingOnForeground() {
        PvLoggingData musicPlaylistBaseViewModel$PvLoggingData0 = this.getPvLoggingData();
        this.performPvLoggingOnForeground(musicPlaylistBaseViewModel$PvLoggingData0.getAction(), musicPlaylistBaseViewModel$PvLoggingData0.getParams());
    }

    public final void select(int v) {
        this.f(new com.iloen.melon.player.playlist.music.h(v, this));
    }

    public final void setIsDragging(boolean z) {
        this.u = z;
        LogU.debug$default(this.q, "setIsDragging: " + z, null, false, 6, null);
    }

    public final void toggleSelectAll() {
        this.f(new j(this, 2));
    }

    public final void unSelectAll() {
        this.f(new j(this, 3));
    }

    public final void updateHasToolbarPadding(boolean z) {
        this.r.setValue(Boolean.valueOf(z));
    }
}

