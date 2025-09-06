package com.iloen.melon.player.playlist.drawernew;

import M6.B;
import Mb.v;
import Ud.e;
import Ud.f;
import Ud.g;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventPremiumCacheDelete;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfoKt;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeleteDrawerPlaylist;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeleteViewModeDrawerPlaylist;
import com.iloen.melon.player.playlist.common.DeletePlaylist;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectButton;
import com.iloen.melon.player.playlist.common.SectionSelectUserEvent.ClickSectionSelectCancelButton;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListItemData;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper.TiaraMixUpEventMeta;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.I4;
import com.melon.ui.L2;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.q3;
import com.melon.ui.q4;
import com.melon.ui.t3;
import com.melon.ui.t4;
import e1.F;
import e1.b;
import eb.y;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import ie.s;
import j9.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kc.R2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import nc.C0;
import nc.u0;
import ob.a;
import ob.z;
import oc.E;
import oc.L;
import oc.S;
import oc.U;
import oc.c0;
import oc.x;
import oe.c;
import oe.i;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000\u00E6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 y2\u00020\u0001:\u0001yB\u007F\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0011\u001A\u00020\u0010\u0012\u0006\u0010\u0013\u001A\u00020\u0012\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u0012\u0006\u0010\u0017\u001A\u00020\u0016\u0012\u0006\u0010\u0019\u001A\u00020\u0018\u0012\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010#\u001A\u00020\"2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b#\u0010$J\u0018\u0010\'\u001A\u00020\"2\u0006\u0010&\u001A\u00020%H\u0096@\u00A2\u0006\u0004\b\'\u0010(J\r\u0010)\u001A\u00020\"\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010.\u001A\u0004\u0018\u00010-2\u0006\u0010,\u001A\u00020+\u00A2\u0006\u0004\b.\u0010/J\r\u00101\u001A\u000200\u00A2\u0006\u0004\b1\u00102J\u0017\u00105\u001A\u00020\"2\u0006\u00104\u001A\u000203H\u0014\u00A2\u0006\u0004\b5\u00106J\u0015\u00109\u001A\u00020\"2\u0006\u00108\u001A\u000207\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u00020\"\u00A2\u0006\u0004\b;\u0010*J\r\u0010<\u001A\u00020\"\u00A2\u0006\u0004\b<\u0010*J\u0015\u0010>\u001A\u00020\"2\u0006\u0010=\u001A\u000207\u00A2\u0006\u0004\b>\u0010:J\u001B\u0010A\u001A\u00020\"2\f\u0010@\u001A\b\u0012\u0004\u0012\u00020+0?\u00A2\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001A\u00020\"2\u0006\u0010D\u001A\u00020CH\u0007\u00A2\u0006\u0004\bE\u0010FJ\r\u0010G\u001A\u00020 \u00A2\u0006\u0004\bG\u0010HR\u0017\u0010K\u001A\u0002078\u0006\u00A2\u0006\f\n\u0004\bI\u0010J\u001A\u0004\bK\u0010LR\u001F\u0010R\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001E0M8\u0006\u00A2\u0006\f\n\u0004\bN\u0010O\u001A\u0004\bP\u0010QR\u001F\u0010V\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010S0M8\u0006\u00A2\u0006\f\n\u0004\bT\u0010O\u001A\u0004\bU\u0010QR#\u0010Z\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0?0M8\u0006\u00A2\u0006\f\n\u0004\bX\u0010O\u001A\u0004\bY\u0010QR\u001D\u0010^\u001A\b\u0012\u0004\u0012\u00020[0M8\u0006\u00A2\u0006\f\n\u0004\b\\\u0010O\u001A\u0004\b]\u0010QR/\u0010b\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0_0M8\u0006\u00A2\u0006\f\n\u0004\b`\u0010O\u001A\u0004\ba\u0010QR\u001D\u0010d\u001A\b\u0012\u0004\u0012\u0002070M8\u0006\u00A2\u0006\f\n\u0004\bc\u0010O\u001A\u0004\bd\u0010QR\u001D\u0010f\u001A\b\u0012\u0004\u0012\u0002070M8\u0006\u00A2\u0006\f\n\u0004\be\u0010O\u001A\u0004\bf\u0010QR\u001D\u0010l\u001A\b\u0012\u0004\u0012\u00020\"0g8\u0006\u00A2\u0006\f\n\u0004\bh\u0010i\u001A\u0004\bj\u0010kR\u0017\u0010r\u001A\u00020m8\u0006\u00A2\u0006\f\n\u0004\bn\u0010o\u001A\u0004\bp\u0010qR\u0017\u0010x\u001A\u00020s8\u0006\u00A2\u0006\f\n\u0004\bt\u0010u\u001A\u0004\bv\u0010w\u00A8\u0006z"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel;", "Lcom/melon/ui/k1;", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "defaultDispatcher", "ioDispatcher", "Lmb/k;", "loginUseCase", "Leb/y;", "uaLogUseCase", "Lob/z;", "playerUseCase", "Lob/a;", "playableUseCase", "Lkc/s2;", "playlistManager", "Lj9/d;", "networkMonitor", "LPc/d;", "stringProvider", "Lcom/melon/ui/Q;", "addPlayUserEventHelper", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "deleteHelper", "Lcom/melon/ui/b3;", "morePopupUserEventHelper", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lmb/k;Leb/y;Lob/z;Lob/a;Lkc/s2;Lj9/d;LPc/d;Lcom/melon/ui/Q;Lcom/melon/ui/t3;Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;Lcom/melon/ui/b3;)V", "Lnc/a;", "playlist", "", "fromCall", "Lie/H;", "updateInternalPlaylist", "(Lnc/a;Ljava/lang/String;)V", "Lcom/melon/ui/g1;", "type", "onFetchStart", "(Lcom/melon/ui/g1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFragmentResumed", "()V", "", "position", "Lcom/melon/playlist/interfaces/PlayableData;", "getPlayableDataForMorePopup", "(I)Lcom/melon/playlist/interfaces/PlayableData;", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "getTiaraEventMetaForMixUp", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper$TiaraMixUpEventMeta;", "LPc/e;", "userEvent", "onUserEvent", "(LPc/e;)V", "", "hasToolbarPadding", "updateHasToolbarPadding", "(Z)V", "toggleSelectAll", "unSelectAll", "isDragging", "setIsDragging", "", "indices", "deleteIndices", "(Ljava/util/List;)V", "Lcom/iloen/melon/eventbus/EventPremiumCacheDelete;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPremiumCacheDelete;)V", "getPvDummyLogAction", "()Ljava/lang/String;", "p", "Z", "isDj", "()Z", "Lkotlinx/coroutines/flow/StateFlow;", "r", "Lkotlinx/coroutines/flow/StateFlow;", "getInternalPlaylist", "()Lkotlinx/coroutines/flow/StateFlow;", "internalPlaylist", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "s", "getPlaylistInfoStateFlow", "playlistInfoStateFlow", "Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "u", "getSongListState", "songListState", "Loc/c0;", "w", "getSectionSelectState", "sectionSelectState", "Lie/s;", "y", "getOnSwapCancelPosition", "onSwapCancelPosition", "A", "isToolbarVisible", "C", "isProgressVisible", "Lkotlinx/coroutines/flow/SharedFlow;", "E", "Lkotlinx/coroutines/flow/SharedFlow;", "getScrollTopEventByFetch", "()Lkotlinx/coroutines/flow/SharedFlow;", "scrollTopEventByFetch", "LMb/v;", "H", "LMb/v;", "getOfflinePlaylistHelper", "()LMb/v;", "offlinePlaylistHelper", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongTiaraLogHelper;", "I", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/drawernew/DrawerSongTiaraLogHelper;", "tiaraLogHelper", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongFragmentViewModel extends k1 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    public final StateFlow A;
    public final MutableStateFlow B;
    public final StateFlow C;
    @NotNull
    public static final Companion Companion;
    public final MutableSharedFlow D;
    public final SharedFlow E;
    public final AtomicBoolean F;
    public boolean G;
    public final v H;
    public final DrawerSongTiaraLogHelper I;
    public final g J;
    public final r K;
    public final CoroutineDispatcher a;
    public final CoroutineDispatcher b;
    public final k c;
    public final y d;
    public final z e;
    public final a f;
    public final s2 g;
    public final d h;
    public final Pc.d i;
    public final Q j;
    public final t3 k;
    public final PlaylistDeleteHelper l;
    public final b3 m;
    public final LogU n;
    public final PlaylistId o;
    public final boolean p;
    public final MutableStateFlow q;
    public final StateFlow r;
    public final StateFlow s;
    public final MutableStateFlow t;
    public final StateFlow u;
    public final MutableStateFlow v;
    public final StateFlow w;
    public final MutableStateFlow x;
    public final StateFlow y;
    public final MutableStateFlow z;

    static {
        DrawerSongFragmentViewModel.Companion = new Companion(null);
        DrawerSongFragmentViewModel.$stable = 8;
    }

    @Inject
    public DrawerSongFragmentViewModel(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull CoroutineDispatcher coroutineDispatcher1, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull k k0, @NotNull y y0, @NotNull z z0, @NotNull a a0, @NotNull s2 s20, @NotNull d d0, @NotNull Pc.d d1, @NotNull Q q0, @NotNull t3 t30, @NotNull PlaylistDeleteHelper playlistDeleteHelper0, @NotNull b3 b30) {
        q.g(coroutineDispatcher0, "mainDispatcher");
        q.g(coroutineDispatcher1, "defaultDispatcher");
        q.g(coroutineDispatcher2, "ioDispatcher");
        q.g(k0, "loginUseCase");
        q.g(y0, "uaLogUseCase");
        q.g(z0, "playerUseCase");
        q.g(a0, "playableUseCase");
        q.g(s20, "playlistManager");
        q.g(d0, "networkMonitor");
        q.g(d1, "stringProvider");
        q.g(q0, "addPlayUserEventHelper");
        q.g(t30, "putPopupUserEventHelper");
        q.g(playlistDeleteHelper0, "deleteHelper");
        q.g(b30, "morePopupUserEventHelper");
        super();
        this.a = coroutineDispatcher1;
        this.b = coroutineDispatcher2;
        this.c = k0;
        this.d = y0;
        this.e = z0;
        this.f = a0;
        this.g = s20;
        this.h = d0;
        this.i = d1;
        this.j = q0;
        this.k = t30;
        this.l = playlistDeleteHelper0;
        this.m = b30;
        this.n = LogU.Companion.create("DrawerSongFragmentViewModel", true, Category.UI);
        this.o = PlaylistId.DRAWER;
        this.p = ((e0)k0).j().getIsDj();
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(null);
        this.q = mutableStateFlow0;
        this.r = FlowKt.asStateFlow(mutableStateFlow0);
        this.s = FlowKt.stateIn(FlowKt.callbackFlow(new DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1(this, null)), f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), null);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(new ArrayList());
        this.t = mutableStateFlow1;
        this.u = FlowKt.asStateFlow(mutableStateFlow1);
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(c0.b);
        this.v = mutableStateFlow2;
        this.w = FlowKt.asStateFlow(mutableStateFlow2);
        MutableStateFlow mutableStateFlow3 = StateFlowKt.MutableStateFlow(new s(-1, -1, -1));
        this.x = mutableStateFlow3;
        this.y = FlowKt.asStateFlow(mutableStateFlow3);
        MutableStateFlow mutableStateFlow4 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.z = mutableStateFlow4;
        this.A = FlowKt.asStateFlow(mutableStateFlow4);
        MutableStateFlow mutableStateFlow5 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.B = mutableStateFlow5;
        this.C = FlowKt.asStateFlow(mutableStateFlow5);
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.D = mutableSharedFlow0;
        this.E = FlowKt.asSharedFlow(mutableSharedFlow0);
        this.F = new AtomicBoolean(false);
        this.H = new v(d1, new Ib.a() {
            public final DrawerSongFragmentViewModel a;

            {
                this.a = drawerSongFragmentViewModel0;
            }

            @Override  // Ib.a
            public List getPlayableList() {
                nc.a a0 = (nc.a)this.a.getInternalPlaylist().getValue();
                if(a0 != null) {
                    C0 c00 = ((u0)a0).I();
                    return c00 == null ? new ArrayList() : b.B(c00);
                }
                return new ArrayList();
            }

            @Override  // Ib.a
            public Object isOfflineModeFromLocalData(Continuation continuation0) {
                Object object0 = this.a.getInternalPlaylist().getValue();
                x x0 = object0 instanceof x ? ((x)object0) : null;
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
                boolean z1;
                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.a;
                nc.a a0 = (nc.a)drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                if(a0 == null) {
                    z1 = true;
                }
                else {
                    C0 c00 = ((u0)a0).I();
                    z1 = c00 == null ? true : c00.h;
                }
                if(z1) {
                    Object object0 = drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                    x x0 = object0 instanceof x ? ((x)object0) : null;
                    if(x0 != null) {
                        Object object1 = x0.w(z, continuation0);
                        if(object1 == ne.a.a) {
                            return object1;
                        }
                    }
                }
                else {
                    Object object2 = ListenableFutureKt.await(((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).A(DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel0), z), continuation0);
                    if(object2 == ne.a.a) {
                        return object2;
                    }
                }
                return H.a;
            }
        }, f0.h(this), new p(this, 0));
        this.I = new DrawerSongTiaraLogHelper(d1);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final DrawerSongFragmentViewModel w;

            {
                this.w = drawerSongFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.filterNotNull(this.w.getInternalPlaylist());
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1 drawerSongFragmentViewModel$1$10 = new n(null) {
                            public final DrawerSongFragmentViewModel B;
                            public int r;
                            public Object w;

                            {
                                this.B = drawerSongFragmentViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1(this.B, continuation0);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((nc.a)object0), ((Continuation)object1));
                            }

                            public final Object invoke(nc.a a0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1)this.create(a0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                nc.a a0 = (nc.a)this.w;
                                ne.a a1 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        C0 c00 = ((u0)a0).I();
                                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.B;
                                        if(c00.h) {
                                            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1 drawerSongFragmentViewModel$1$1$10 = new n(null, a0) {
                                                public final DrawerSongFragmentViewModel B;
                                                public Object r;
                                                public final nc.a w;

                                                {
                                                    this.w = a0;
                                                    this.B = drawerSongFragmentViewModel0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1(this.B, continuation0, this.w);
                                                    continuation1.r = object0;
                                                    return continuation1;
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                                                    d5.n.D(object0);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null, this.w) {
                                                        public final DrawerSongFragmentViewModel B;
                                                        public int r;
                                                        public final nc.a w;

                                                        {
                                                            this.w = a0;
                                                            this.B = drawerSongFragmentViewModel0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.1(this.B, continuation0, this.w);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            ne.a a0 = ne.a.a;
                                                            switch(this.r) {
                                                                case 0: {
                                                                    d5.n.D(object0);
                                                                    com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.1.1 drawerSongFragmentViewModel$1$1$1$1$10 = new n(null) {
                                                                        public final DrawerSongFragmentViewModel B;
                                                                        public int r;
                                                                        public Object w;

                                                                        {
                                                                            this.B = drawerSongFragmentViewModel0;
                                                                            super(2, continuation0);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                                            Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.1.1(this.B, continuation0);
                                                                            continuation1.w = object0;
                                                                            return continuation1;
                                                                        }

                                                                        @Override  // we.n
                                                                        public Object invoke(Object object0, Object object1) {
                                                                            return this.invoke(((C0)object0), ((Continuation)object1));
                                                                        }

                                                                        public final Object invoke(C0 c00, Continuation continuation0) {
                                                                            return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.1.1)this.create(c00, continuation0)).invokeSuspend(H.a);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Object invokeSuspend(Object object0) {
                                                                            C0 c00 = (C0)this.w;
                                                                            ne.a a0 = ne.a.a;
                                                                            DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.B;
                                                                            switch(this.r) {
                                                                                case 0: {
                                                                                    d5.n.D(object0);
                                                                                    drawerSongFragmentViewModel0.getOfflinePlaylistHelper().k((c00.f ? Ib.b.e : Ib.b.g), "updatePlaylistState_isViewMode:true");
                                                                                    this.w = c00;
                                                                                    this.r = 1;
                                                                                    object0 = DrawerSongFragmentViewModel.access$convertPlayableListToUiStateList(drawerSongFragmentViewModel0, c00, this);
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
                                                                            if(((List)object0).isEmpty()) {
                                                                                LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), "empty uiState so setLandingPlaylist: " + c00.i, null, false, 6, null);
                                                                                DrawerSongFragmentViewModel.access$setLandingPlaylist(drawerSongFragmentViewModel0, c00.i);
                                                                            }
                                                                            else {
                                                                                LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), U4.x.e(((List)object0).size(), "makeUiState size:"), null, false, 6, null);
                                                                            }
                                                                            DrawerSongFragmentViewModel.access$updateSongListStatePreservePrevSelectedState(drawerSongFragmentViewModel0, ((List)object0), "songListState change_isViewMode:true");
                                                                            return H.a;
                                                                        }
                                                                    };
                                                                    this.r = 1;
                                                                    return FlowKt.collectLatest(((u0)this.w).h, drawerSongFragmentViewModel$1$1$1$1$10, this) == a0 ? a0 : H.a;
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
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null, this.w) {
                                                        public final nc.a B;
                                                        public int r;
                                                        public final DrawerSongFragmentViewModel w;

                                                        {
                                                            this.w = drawerSongFragmentViewModel0;
                                                            this.B = a0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.2(this.w, continuation0, this.B);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            ne.a a0 = ne.a.a;
                                                            DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.w;
                                                            switch(this.r) {
                                                                case 0: {
                                                                    d5.n.D(object0);
                                                                    B b0 = ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).l();
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
                                                            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.2.1 drawerSongFragmentViewModel$1$1$1$2$10 = new n(drawerSongFragmentViewModel0, ((nc.a)object0), null) {
                                                                public final DrawerSongFragmentViewModel B;
                                                                public final nc.a D;
                                                                public Object r;
                                                                public final nc.a w;

                                                                {
                                                                    this.w = a0;
                                                                    this.B = drawerSongFragmentViewModel0;
                                                                    this.D = a1;
                                                                    super(2, continuation0);
                                                                }

                                                                @Override  // oe.a
                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                    Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.2.1(this.w, this.B, this.D, continuation0);
                                                                    continuation1.r = object0;
                                                                    return continuation1;
                                                                }

                                                                @Override  // we.n
                                                                public Object invoke(Object object0, Object object1) {
                                                                    return this.invoke(((C0)object0), ((Continuation)object1));
                                                                }

                                                                public final Object invoke(C0 c00, Continuation continuation0) {
                                                                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.2.1)this.create(c00, continuation0)).invokeSuspend(H.a);
                                                                }

                                                                @Override  // oe.a
                                                                public final Object invokeSuspend(Object object0) {
                                                                    C0 c00 = (C0)this.r;
                                                                    d5.n.D(object0);
                                                                    if(q.b((c00.g == null ? null : Boolean.valueOf(DrawerPlaylistInfoKt.compareToViewMode(c00.g, ((u0)this.w).I().g))), Boolean.FALSE)) {
                                                                        this.B.updateInternalPlaylist(this.D, "viewMode > playMode");
                                                                    }
                                                                    return H.a;
                                                                }
                                                            };
                                                            this.r = 2;
                                                            return FlowKt.collectLatest(((u0)(((nc.a)object0))).h, drawerSongFragmentViewModel$1$1$1$2$10, this) == a0 ? a0 : H.a;
                                                        }
                                                    }, 3, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null, this.w) {
                                                        public final nc.a B;
                                                        public int r;
                                                        public final DrawerSongFragmentViewModel w;

                                                        {
                                                            this.w = drawerSongFragmentViewModel0;
                                                            this.B = a0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.3(this.w, continuation0, this.B);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            ne.a a0 = ne.a.a;
                                                            switch(this.r) {
                                                                case 0: {
                                                                    d5.n.D(object0);
                                                                    Flow flow0 = FlowKt.debounce(DrawerSongFragmentViewModel.access$getNetworkMonitor$p(this.w).c, 3000L);
                                                                    com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.3.1 drawerSongFragmentViewModel$1$1$1$3$10 = new n(null, this.B) {
                                                                        public final DrawerSongFragmentViewModel B;
                                                                        public final nc.a D;
                                                                        public int r;
                                                                        public boolean w;

                                                                        {
                                                                            this.B = drawerSongFragmentViewModel0;
                                                                            this.D = a0;
                                                                            super(2, continuation0);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                                            Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.3.1(this.B, continuation0, this.D);
                                                                            continuation1.w = ((Boolean)object0).booleanValue();
                                                                            return continuation1;
                                                                        }

                                                                        @Override  // we.n
                                                                        public Object invoke(Object object0, Object object1) {
                                                                            return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                                                        }

                                                                        public final Object invoke(boolean z, Continuation continuation0) {
                                                                            return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.1.3.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                                                        }

                                                                        @Override  // oe.a
                                                                        public final Object invokeSuspend(Object object0) {
                                                                            E e0;
                                                                            boolean z = this.w;
                                                                            ne.a a0 = ne.a.a;
                                                                            switch(this.r) {
                                                                                case 0: {
                                                                                    d5.n.D(object0);
                                                                                    LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(this.B), "network connection changed: " + z, null, false, 6, null);
                                                                                    nc.a a1 = this.D;
                                                                                    if(((u0)a1).I().h) {
                                                                                        x x0 = a1 instanceof x ? ((x)a1) : null;
                                                                                        if(x0 != null) {
                                                                                            this.w = z;
                                                                                            this.r = 1;
                                                                                            object0 = x0.A(z, this);
                                                                                            if(object0 == a0) {
                                                                                                return a0;
                                                                                            }
                                                                                            e0 = (E)object0;
                                                                                            return H.a;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                case 1: {
                                                                                    d5.n.D(object0);
                                                                                    e0 = (E)object0;
                                                                                    break;
                                                                                }
                                                                                default: {
                                                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                                }
                                                                            }
                                                                            return H.a;
                                                                        }
                                                                    };
                                                                    this.r = 1;
                                                                    return FlowKt.collectLatest(flow0, drawerSongFragmentViewModel$1$1$1$3$10, this) == a0 ? a0 : H.a;
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
                                                    return H.a;
                                                }
                                            };
                                            this.w = null;
                                            this.r = 1;
                                            if(CoroutineScopeKt.coroutineScope(drawerSongFragmentViewModel$1$1$10, this) == a1) {
                                                return a1;
                                            }
                                        }
                                        else {
                                            Flow flow0 = DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).h();
                                            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.2 drawerSongFragmentViewModel$1$1$20 = new o(null) {
                                                public final DrawerSongFragmentViewModel B;
                                                public int r;
                                                public C0 w;

                                                {
                                                    this.B = drawerSongFragmentViewModel0;
                                                    super(3, continuation0);
                                                }

                                                @Override  // we.o
                                                public Object invoke(Object object0, Object object1, Object object2) {
                                                    return this.invoke(((C0)object0), ((Boolean)object1).booleanValue(), ((Continuation)object2));
                                                }

                                                public final Object invoke(C0 c00, boolean z, Continuation continuation0) {
                                                    com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.2 drawerSongFragmentViewModel$1$1$20 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.2(this.B, continuation0);
                                                    drawerSongFragmentViewModel$1$1$20.w = c00;
                                                    return drawerSongFragmentViewModel$1$1$20.invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    C0 c00 = this.w;
                                                    ne.a a0 = ne.a.a;
                                                    DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.B;
                                                    switch(this.r) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            drawerSongFragmentViewModel0.getOfflinePlaylistHelper().k((c00.f ? Ib.b.e : Ib.b.g), "updatePlaylistState_isViewMode:false");
                                                            this.w = c00;
                                                            this.r = 1;
                                                            object0 = DrawerSongFragmentViewModel.access$convertPlayableListToUiStateList(drawerSongFragmentViewModel0, c00, this);
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
                                                    if(((List)object0).isEmpty()) {
                                                        LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), "empty uiState so setLandingPlaylist: " + c00.i, null, false, 6, null);
                                                        DrawerSongFragmentViewModel.access$setLandingPlaylist(drawerSongFragmentViewModel0, c00.i);
                                                        return object0;
                                                    }
                                                    LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), U4.x.e(((List)object0).size(), "makeUiState size:"), null, false, 6, null);
                                                    return object0;
                                                }
                                            };
                                            Flow flow1 = FlowKt.flowOn(FlowKt.distinctUntilChanged(new Flow() {
                                                @Override  // kotlinx.coroutines.flow.Flow
                                                public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                                    com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.invokeSuspend..inlined.filter.1.2 drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$20 = new FlowCollector() {
                                                        @Override  // kotlinx.coroutines.flow.FlowCollector
                                                        public final Object emit(Object object0, Continuation continuation0) {
                                                            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.invokeSuspend..inlined.filter.1.2.1 drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10;
                                                            if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.invokeSuspend..inlined.filter.1.2.1) {
                                                                drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10 = (com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.invokeSuspend..inlined.filter.1.2.1)continuation0;
                                                                int v = drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10.w;
                                                                if((v & 0x80000000) == 0) {
                                                                    drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                                        public Object r;
                                                                        public int w;

                                                                        @Override  // oe.a
                                                                        public final Object invokeSuspend(Object object0) {
                                                                            this.r = object0;
                                                                            this.w |= 0x80000000;
                                                                            return continuation0.emit(null, this);
                                                                        }
                                                                    };
                                                                }
                                                                else {
                                                                    drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10.w = v ^ 0x80000000;
                                                                }
                                                            }
                                                            else {
                                                                drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                                    public Object r;
                                                                    public int w;

                                                                    @Override  // oe.a
                                                                    public final Object invokeSuspend(Object object0) {
                                                                        this.r = object0;
                                                                        this.w |= 0x80000000;
                                                                        return continuation0.emit(null, this);
                                                                    }
                                                                };
                                                            }
                                                            Object object1 = drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10.r;
                                                            ne.a a0 = ne.a.a;
                                                            switch(drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10.w) {
                                                                case 0: {
                                                                    d5.n.D(object1);
                                                                    if(!((List)object0).isEmpty()) {
                                                                        drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10.w = 1;
                                                                        if(this.a.emit(object0, drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$2$10) == a0) {
                                                                            return a0;
                                                                        }
                                                                    }
                                                                    return H.a;
                                                                }
                                                                case 1: {
                                                                    d5.n.D(object1);
                                                                    return H.a;
                                                                }
                                                                default: {
                                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                }
                                                            }
                                                        }
                                                    };
                                                    Object object0 = this.a.collect(drawerSongFragmentViewModel$1$1$invokeSuspend$$inlined$filter$1$20, continuation0);
                                                    return object0 == ne.a.a ? object0 : H.a;
                                                }
                                            }), DrawerSongFragmentViewModel.access$getDefaultDispatcher$p(drawerSongFragmentViewModel0));
                                            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.4 drawerSongFragmentViewModel$1$1$40 = new n(null) {
                                                public Object r;
                                                public final DrawerSongFragmentViewModel w;

                                                {
                                                    this.w = drawerSongFragmentViewModel0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.4(this.w, continuation0);
                                                    continuation1.r = object0;
                                                    return continuation1;
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((List)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(List list0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.1.1.4)this.create(list0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    List list0 = (List)this.r;
                                                    d5.n.D(object0);
                                                    DrawerSongFragmentViewModel.access$updateSongListStatePreservePrevSelectedState(this.w, list0, "songListState change_isViewMode:false");
                                                    LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(this.w), U4.x.e(list0.size(), "updateUiState size:"), null, false, 6, null);
                                                    return H.a;
                                                }
                                            };
                                            this.w = null;
                                            this.r = 2;
                                            if(FlowKt.collectLatest(flow1, drawerSongFragmentViewModel$1$1$40, this) == a1) {
                                                return a1;
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
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, drawerSongFragmentViewModel$1$10, this) == a0 ? a0 : H.a;
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
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), coroutineDispatcher0, null, new n(null) {
            public final DrawerSongFragmentViewModel B;
            public int r;
            public Object w;

            {
                this.B = drawerSongFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2.1 drawerSongFragmentViewModel$2$10 = new FlowCollector() {
                            public final DrawerSongFragmentViewModel a;
                            public final CoroutineScope b;

                            {
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = coroutineScope0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = drawerSongFragmentViewModel0;
                                this.b = coroutineScope0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((String)object0), continuation0);
                            }

                            public final Object emit(String s, Continuation continuation0) {
                                String s1;
                                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2.1.emit.1 drawerSongFragmentViewModel$2$1$emit$10;
                                if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2.1.emit.1) {
                                    drawerSongFragmentViewModel$2$1$emit$10 = (com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.2.1.emit.1)continuation0;
                                    int v = drawerSongFragmentViewModel$2$1$emit$10.D;
                                    if((v & 0x80000000) == 0) {
                                        drawerSongFragmentViewModel$2$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                        drawerSongFragmentViewModel$2$1$emit$10.D = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    drawerSongFragmentViewModel$2$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                Object object0 = drawerSongFragmentViewModel$2$1$emit$10.w;
                                ne.a a0 = ne.a.a;
                                H h0 = H.a;
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.a;
                                switch(drawerSongFragmentViewModel$2$1$emit$10.D) {
                                    case 0: {
                                        d5.n.D(object0);
                                        s1 = s;
                                        LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), "isOfflineDownloadSongComplete contentId: " + s1, null, false, 6, null);
                                        if(s1.length() == 0) {
                                            return h0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        s1 = drawerSongFragmentViewModel$2$1$emit$10.r;
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                while(CoroutineScopeKt.isActive(this.b) && DrawerSongFragmentViewModel.access$isDragging$p(drawerSongFragmentViewModel0)) {
                                    drawerSongFragmentViewModel$2$1$emit$10.r = s1;
                                    drawerSongFragmentViewModel$2$1$emit$10.D = 1;
                                    if(DelayKt.delay(1000L, drawerSongFragmentViewModel$2$1$emit$10) == a0) {
                                        return a0;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                                Iterable iterable0 = (Iterable)drawerSongFragmentViewModel0.getSongListState().getValue();
                                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                                for(Object object1: iterable0) {
                                    DrawerSongListItemData drawerSongListItemData0 = (DrawerSongListItemData)object1;
                                    drawerSongFragmentViewModel0.getOfflinePlaylistHelper().getClass();
                                    if(v.b(drawerSongListItemData0.getContentId()) || q.b(drawerSongListItemData0.getContentId(), s1)) {
                                        drawerSongListItemData0 = DrawerSongListItemData.copy$default(drawerSongListItemData0, null, null, null, null, null, false, false, false, false, true, false, false, false, false, null, 0x7DFF, null);
                                    }
                                    arrayList0.add(drawerSongListItemData0);
                                }
                                DrawerSongFragmentViewModel.access$updateSongListState(drawerSongFragmentViewModel0, arrayList0, "isOfflineDownloadSongComplete collectLatest");
                                return h0;
                            }
                        };
                        this.w = null;
                        this.r = 1;
                        if(this.B.getOfflinePlaylistHelper().m.collect(drawerSongFragmentViewModel$2$10, this) == a0) {
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
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final DrawerSongFragmentViewModel w;

            {
                this.w = drawerSongFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.3.1 drawerSongFragmentViewModel$3$10 = new n(null) {
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
                            public final DrawerSongFragmentViewModel w;

                            {
                                this.w = drawerSongFragmentViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.3.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(Ib.b b0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.3.1)this.create(b0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Ib.b)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Ib.b b0 = (Ib.b)this.r;
                                d5.n.D(object0);
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.w;
                                LogU.debug$default(DrawerSongFragmentViewModel.access$getLog$p(drawerSongFragmentViewModel0), "offlineState collectLatest: " + b0, null, false, 6, null);
                                if(WhenMappings.$EnumSwitchMapping$0[b0.ordinal()] == 1) {
                                    Iterable iterable0 = (Iterable)drawerSongFragmentViewModel0.getSongListState().getValue();
                                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                                    for(Object object1: iterable0) {
                                        arrayList0.add(DrawerSongListItemData.copy$default(((DrawerSongListItemData)object1), null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, 0x7DFF, null));
                                    }
                                    DrawerSongFragmentViewModel.access$updateSongListState(drawerSongFragmentViewModel0, arrayList0, "offlineState: " + b0 + ", collectLatest");
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(this.w.getOfflinePlaylistHelper().k, drawerSongFragmentViewModel$3$10, this) == a0 ? a0 : H.a;
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
        g g0 = new g(new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.1());  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.d = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.2.1();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.c = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.2.2();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.J = g0;
        this.K = d3.g.Q(new com.iloen.melon.player.playlist.drawernew.o(this, 1));

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel$selectHelper$1", "LUd/e;", "Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "state", "", "select", "onChange", "(Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;Z)Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.1 implements e {
            public DrawerSongListItemData onChange(DrawerSongListItemData drawerSongListItemData0, boolean z) {
                q.g(drawerSongListItemData0, "state");
                return DrawerSongListItemData.copy$default(drawerSongListItemData0, null, null, null, null, null, false, z, false, false, false, false, false, false, false, null, 0x7FBF, null);
            }

            @Override  // Ud.e
            public Object onChange(Object object0, boolean z) {
                return this.onChange(((DrawerSongListItemData)object0), z);
            }
        }


        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\u0007\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"com/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel$selectHelper$2$1", "LUd/f;", "Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "Lkotlin/Function1;", "Loc/c0;", "Lie/H;", "callback", "onStart", "(Lwe/k;)V", "onEnd", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.2.1 implements f {
            @Override  // Ud.f
            public void onEnd(we.k k0) {
                q.g(k0, "callback");
                k0.invoke(c0.b);
            }

            @Override  // Ud.f
            public void onStart(we.k k0) {
                q.g(k0, "callback");
                k0.invoke(c0.e);
            }
        }


        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel$selectHelper$2$2", "LUd/d;", "Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "state", "", "marquee", "onChange", "(Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;Z)Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.selectHelper.2.2 implements Ud.d {
            public DrawerSongListItemData onChange(DrawerSongListItemData drawerSongListItemData0, boolean z) {
                q.g(drawerSongListItemData0, "state");
                return DrawerSongListItemData.copy$default(drawerSongListItemData0, null, null, null, null, null, false, false, z, false, false, false, false, false, false, null, 0x7F7F, null);
            }

            @Override  // Ud.d
            public Object onChange(Object object0, boolean z) {
                return this.onChange(((DrawerSongListItemData)object0), z);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.toolBarEventHelper.2.1 extends kotlin.jvm.internal.n implements we.k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((I4)object0));
                return H.a;
            }

            public final void invoke(I4 i40) {
                q.g(i40, "p0");
                DrawerSongFragmentViewModel.access$sendUiEvent(((DrawerSongFragmentViewModel)this.receiver), i40);
            }
        }

    }

    public static final void access$afterDeleteTask(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, U u0, boolean z) {
        Pc.d d0 = drawerSongFragmentViewModel0.i;
        LogU.debug$default(drawerSongFragmentViewModel0.n, "afterDeleteTask removeResult: " + u0 + ", isViewMode: " + z, null, false, 6, null);
        if(u0 instanceof S && !((S)u0).b) {
            if(NetUtils.isConnected()) {
                drawerSongFragmentViewModel0.sendUiEvent(new t4(((StringProviderImpl)d0).a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            drawerSongFragmentViewModel0.sendUiEvent(new q4(28, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F1307AF), null, null));  // string:alert_dlg_title_info "안내"
        }
    }

    public static final void access$cancelSwapSongPosition(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v, int v1, int v2) {
        Pc.d d0 = drawerSongFragmentViewModel0.i;
        s s0 = new s(v, v1, v2);
        drawerSongFragmentViewModel0.x.setValue(s0);
        if(NetUtils.isConnected()) {
            if(v1 == v2) {
                return;
            }
            drawerSongFragmentViewModel0.sendUiEvent(new t4(((StringProviderImpl)d0).a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            return;
        }
        drawerSongFragmentViewModel0.sendUiEvent(new q4(28, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F1307AF), null, null));  // string:alert_dlg_title_info "안내"
    }

    public static final void access$checkSelectRepeatClearAndDo(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, we.k k0, we.k k1) {
        drawerSongFragmentViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(drawerSongFragmentViewModel0), null, null, new DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.2(drawerSongFragmentViewModel0, k0, k1, null), 3, null);
    }

    public static final Object access$checkViewModeAndRunAction(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, we.k k0, we.k k1, Continuation continuation0) {
        boolean z;
        nc.a a0 = (nc.a)drawerSongFragmentViewModel0.r.getValue();
        if(a0 == null) {
            z = true;
        }
        else {
            C0 c00 = ((u0)a0).I();
            z = c00 == null ? true : c00.h;
        }
        if(z) {
            Object object0 = k0.invoke(continuation0);
            if(object0 == ne.a.a) {
                return object0;
            }
        }
        else {
            Object object1 = k1.invoke(continuation0);
            if(object1 == ne.a.a) {
                return object1;
            }
        }
        return H.a;
    }

    public static final Object access$fetchUiState(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
        return drawerSongFragmentViewModel0.d(continuation0);
    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.a;
    }

    public static final CoroutineDispatcher access$getIoDispatcher$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.b;
    }

    public static final d access$getNetworkMonitor$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.h;
    }

    public static final s2 access$getPlaylistManager$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.g;
    }

    public static final Jd.a access$getToolBarEventHelper(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return (Jd.a)drawerSongFragmentViewModel0.K.getValue();
    }

    public static final boolean access$isDragging$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.G;
    }

    public static final AtomicBoolean access$isPlayRequest$p(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        return drawerSongFragmentViewModel0.F;
    }

    public static final void access$playAtPosition(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v) {
        if(!drawerSongFragmentViewModel0.F.compareAndSet(false, true)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(drawerSongFragmentViewModel0), null, null, new DrawerSongFragmentViewModel.playAtPosition.1(drawerSongFragmentViewModel0, v, null), 3, null);
    }

    public static final void access$setLandingPlaylist(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, PlaylistId playlistId0) {
        drawerSongFragmentViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(drawerSongFragmentViewModel0), null, null, new DrawerSongFragmentViewModel.setLandingPlaylist.1(drawerSongFragmentViewModel0, playlistId0, null), 3, null);
    }

    public static final void access$setSelectRepeatAndPlay(DrawerSongFragmentViewModel drawerSongFragmentViewModel0) {
        ArrayList arrayList0 = drawerSongFragmentViewModel0.f();
        drawerSongFragmentViewModel0.unSelectAll();
        BuildersKt__Builders_commonKt.launch$default(f0.h(drawerSongFragmentViewModel0), null, null, new DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1(drawerSongFragmentViewModel0, arrayList0, null), 3, null);
    }

    public static final void access$updateSongListState(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, List list0, String s) {
        drawerSongFragmentViewModel0.j(s, list0);
    }

    public static final void access$updateSongListStatePreservePrevSelectedState(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, List list0, String s) {
        LogU.debug$default(drawerSongFragmentViewModel0.n, "updateSongListStatePreservePrevSelectedState fromCall: " + s, null, false, 6, null);
        MutableStateFlow mutableStateFlow0 = drawerSongFragmentViewModel0.t;
        do {
            Object object0 = mutableStateFlow0.getValue();
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: ((List)object0)) {
                if(((DrawerSongListItemData)object1).isSelected()) {
                    arrayList0.add(object1);
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object2: arrayList0) {
                arrayList1.add(((DrawerSongListItemData)object2).getContentId());
            }
            HashSet hashSet0 = je.p.N0(arrayList1);
            ArrayList arrayList2 = new ArrayList();
            for(Object object3: ((List)object0)) {
                if(((DrawerSongListItemData)object3).isMarquee()) {
                    arrayList2.add(object3);
                }
            }
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object4: arrayList2) {
                arrayList3.add(((DrawerSongListItemData)object4).getContentId());
            }
            HashSet hashSet1 = je.p.N0(arrayList3);
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, list0));
            for(Object object5: list0) {
                String s1 = ((DrawerSongListItemData)object5).getContentId();
                arrayList4.add(DrawerSongListItemData.copy$default(((DrawerSongListItemData)object5), null, null, null, null, null, false, hashSet0.contains(s1), hashSet1.contains(s1), false, false, false, false, false, false, null, 0x7F3F, null));
            }
        }
        while(!mutableStateFlow0.compareAndSet(object0, arrayList4));
    }

    public final Object c(C0 c00, Continuation continuation0) {
        int v16;
        int v7;
        Iterator iterator0;
        C0 c02;
        int v6;
        DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1 drawerSongFragmentViewModel$convertPlayableListToUiStateList$11;
        int v5;
        int v4;
        boolean z1;
        Collection collection0;
        Enum enum1;
        int v2;
        DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1 drawerSongFragmentViewModel$convertPlayableListToUiStateList$10;
        if(continuation0 instanceof DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1) {
            drawerSongFragmentViewModel$convertPlayableListToUiStateList$10 = (DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1)continuation0;
            int v = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.i0;
            if((v & 0x80000000) == 0) {
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$10 = new DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1(this, continuation0);
            }
            else {
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.i0 = v ^ 0x80000000;
            }
        }
        else {
            drawerSongFragmentViewModel$convertPlayableListToUiStateList$10 = new DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1(this, continuation0);
        }
        Enum enum0 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.g0;
        ne.a a0 = ne.a.a;
        v v1 = this.H;
        switch(drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.i0) {
            case 0: {
                d5.n.D(enum0);
                v2 = c00 == null ? 0 : c00.b;
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.r = c00;
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.S = v2;
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.i0 = 1;
                enum1 = v1.h(drawerSongFragmentViewModel$convertPlayableListToUiStateList$10);
                if(enum1 == a0) {
                    return a0;
                }
                goto label_28;
            }
            case 1: {
                int v3 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.S;
                C0 c01 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.r;
                d5.n.D(enum0);
                enum1 = enum0;
                v2 = v3;
                c00 = c01;
            label_28:
                boolean z = ((Boolean)enum1).booleanValue();
                if(c00 != null) {
                    collection0 = new ArrayList(je.q.Q(10, c00.a));
                    z1 = z;
                    v4 = 0;
                    v5 = 0;
                    drawerSongFragmentViewModel$convertPlayableListToUiStateList$11 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10;
                    v6 = v2;
                    c02 = c00;
                    iterator0 = c00.a.iterator();
                    v7 = 0;
                    goto label_88;
                }
                break;
            }
            case 2: {
                boolean z2 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.e0;
                int v8 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.Z;
                boolean z3 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.d0;
                int v9 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.Y;
                int v10 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.X;
                boolean z4 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.c0;
                int v11 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.W;
                int v12 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.V;
                int v13 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.T;
                boolean z5 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.b0;
                boolean z6 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.f0;
                int v14 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.S;
                Collection collection1 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.N;
                String s = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.M;
                String s1 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.I;
                String s2 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.G;
                String s3 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.E;
                Uri uri0 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.D;
                Iterator iterator1 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.B;
                Collection collection2 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.w;
                C0 c03 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10.r;
                d5.n.D(enum0);
                boolean z7 = z6;
                ne.a a1 = a0;
                boolean z8 = z2;
                boolean z9 = z5;
                boolean z10 = z3;
                boolean z11 = z4;
                String s4 = s;
                String s5 = s1;
                String s6 = s2;
                String s7 = s3;
                Uri uri1 = uri0;
                C0 c04 = c03;
                v7 = v13;
                v4 = v12;
                Collection collection3 = collection1;
                collection0 = collection2;
                drawerSongFragmentViewModel$convertPlayableListToUiStateList$11 = drawerSongFragmentViewModel$convertPlayableListToUiStateList$10;
                v6 = v14;
                v v15 = v1;
                while(true) {
                    collection3.add(new DrawerSongListItemData(s4, s5, s6, s7, uri1, z7, false, false, z8, v8 != 0, z10, v9 != 0, v10 != 0, z11, ((pb.b)enum0)));
                    z1 = z9;
                    v5 = v11;
                    v1 = v15;
                    c02 = c04;
                    iterator0 = iterator1;
                    a0 = a1;
                label_88:
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    if(v5 >= 0) {
                        Playable playable0 = ((PlayableData)object0).a;
                        v15 = v1;
                        q.f("", "getTrackId(...)");
                        q.f("", "getContentId(...)");
                        String s8 = l1.n("", "getSongName(...)", playable0, "getArtistNames(...)");
                        Uri uri2 = ((PlayableData)object0).m;
                        boolean z12 = this.e.n();
                        boolean z13 = playable0.isAdult();
                        if(z1) {
                            q.f("", "getContentId(...)");
                            v15.getClass();
                            if(v.b("")) {
                                v16 = 1;
                            }
                        }
                        else {
                            v16 = 0;
                        }
                        boolean z14 = c02.h;
                        int v17 = v5 == v6 ? 1 : 0;
                        boolean z15 = c02.g == null ? false : c02.g.isOwner();
                        boolean z16 = c02.d.contains(new Integer(v5));
                        boolean z17 = playable0.isOriginMelon();
                        boolean z18 = playable0.isOriginLocal();
                        DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1 drawerSongFragmentViewModel$convertPlayableListToUiStateList$convertUiStateList$1$10 = new DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1(playable0, this, null);
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.r = c02;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.w = collection0;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.B = iterator0;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.D = uri2;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.E = s8;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.G = "";
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.I = "";
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.M = "";
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.N = collection0;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.S = v6;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.b0 = z1;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.T = v7;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.V = v4;
                        v11 = v5 + 1;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.W = v11;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.c0 = z16;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.X = z15;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.Y = v17;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.d0 = z14;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.Z = v16;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.e0 = z13;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.f0 = z12;
                        drawerSongFragmentViewModel$convertPlayableListToUiStateList$11.i0 = 2;
                        this.f.getClass();
                        c04 = c02;
                        enum0 = new F().t(z17, z18, drawerSongFragmentViewModel$convertPlayableListToUiStateList$convertUiStateList$1$10, drawerSongFragmentViewModel$convertPlayableListToUiStateList$11);  // 初始化器: Ljava/lang/Object;-><init>()V
                        a1 = a0;
                        if(enum0 == a1) {
                            return a1;
                        }
                        s6 = "";
                        s5 = "";
                        z11 = z16;
                        z9 = z1;
                        s7 = s8;
                        uri1 = uri2;
                        s4 = "";
                        collection3 = collection0;
                        collection0 = collection3;
                        z7 = z12;
                        z8 = z13;
                        v8 = v16;
                        z10 = z14;
                        v9 = v17;
                        v10 = z15;
                        iterator1 = iterator0;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                if(((List)collection0) != null) {
                    return (List)collection0;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new ArrayList();
    }

    public final Object d(Continuation continuation0) {
        C0 c00;
        String s;
        DrawerSongFragmentViewModel.fetchUiState.1 drawerSongFragmentViewModel$fetchUiState$10;
        if(continuation0 instanceof DrawerSongFragmentViewModel.fetchUiState.1) {
            drawerSongFragmentViewModel$fetchUiState$10 = (DrawerSongFragmentViewModel.fetchUiState.1)continuation0;
            int v = drawerSongFragmentViewModel$fetchUiState$10.D;
            if((v & 0x80000000) == 0) {
                drawerSongFragmentViewModel$fetchUiState$10 = new DrawerSongFragmentViewModel.fetchUiState.1(this, continuation0);
            }
            else {
                drawerSongFragmentViewModel$fetchUiState$10.D = v ^ 0x80000000;
            }
        }
        else {
            drawerSongFragmentViewModel$fetchUiState$10 = new DrawerSongFragmentViewModel.fetchUiState.1(this, continuation0);
        }
        Object object0 = drawerSongFragmentViewModel$fetchUiState$10.w;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        v v1 = this.H;
        switch(drawerSongFragmentViewModel$fetchUiState$10.D) {
            case 0: {
                d5.n.D(object0);
                nc.a a1 = (nc.a)this.r.getValue();
                c00 = a1 == null ? null : ((u0)a1).I();
                if(c00 == null || !c00.h != 1) {
                    drawerSongFragmentViewModel$fetchUiState$10.r = c00;
                    drawerSongFragmentViewModel$fetchUiState$10.D = 2;
                    object0 = this.c(c00, drawerSongFragmentViewModel$fetchUiState$10);
                    if(object0 != a0) {
                        this.j("fetchUiState", ((List)object0));
                    label_41:
                        if(c00 == null) {
                            s = null;
                        }
                        else {
                            DrawerPlaylistInfo drawerPlaylistInfo0 = c00.g;
                            s = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getMenuId();
                        }
                        String s1 = "";
                        if(s == null) {
                            s = "";
                        }
                        p8.s s2 = this.getTiaraProperty();
                        String s3 = s2 == null ? null : s2.b;
                        if(s3 == null) {
                            s3 = "";
                        }
                        p8.s s4 = this.getTiaraProperty();
                        String s5 = s4 == null ? null : s4.a;
                        if(s5 != null) {
                            s1 = s5;
                        }
                        this.updateTiaraProperty(s1, s3, s);
                        drawerSongFragmentViewModel$fetchUiState$10.r = null;
                        drawerSongFragmentViewModel$fetchUiState$10.D = 3;
                        if(v1.f("fetchUiState", drawerSongFragmentViewModel$fetchUiState$10) != a0) {
                        label_64:
                            v1.a();
                            this.B.setValue(Boolean.FALSE);
                            drawerSongFragmentViewModel$fetchUiState$10.r = null;
                            drawerSongFragmentViewModel$fetchUiState$10.D = 4;
                            if(this.D.emit(h0, drawerSongFragmentViewModel$fetchUiState$10) != a0) {
                                return h0;
                            }
                        }
                    }
                }
                else {
                    R2 r20 = new R2(((d3)this.g), null);
                    B b0 = ListenableFutureKt.future$default(((d3)this.g).b, null, null, r20, 3, null);
                    drawerSongFragmentViewModel$fetchUiState$10.r = c00;
                    drawerSongFragmentViewModel$fetchUiState$10.D = 1;
                    if(ListenableFutureKt.await(b0, drawerSongFragmentViewModel$fetchUiState$10) != a0) {
                        goto label_41;
                    }
                    return a0;
                }
                break;
            }
            case 1: {
                c00 = drawerSongFragmentViewModel$fetchUiState$10.r;
                d5.n.D(object0);
                goto label_41;
            }
            case 2: {
                c00 = drawerSongFragmentViewModel$fetchUiState$10.r;
                d5.n.D(object0);
                this.j("fetchUiState", ((List)object0));
                goto label_41;
            }
            case 3: {
                d5.n.D(object0);
                goto label_64;
            }
            case 4: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final void deleteIndices(@NotNull List list0) {
        q.g(list0, "indices");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(list0, null) {
            public final List B;
            public int r;
            public final DrawerSongFragmentViewModel w;

            {
                this.w = drawerSongFragmentViewModel0;
                this.B = list0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.1 drawerSongFragmentViewModel$deleteIndices$1$10 = new we.k(this.B, null) {
                            public final DrawerSongFragmentViewModel r;
                            public final List w;

                            {
                                this.r = drawerSongFragmentViewModel0;
                                this.w = list0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.1(this.r, this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                d5.n.D(object0);
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.r;
                                Object object1 = drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                                if(((nc.a)object1) != null) {
                                    p p0 = new p(drawerSongFragmentViewModel0, 2);
                                    drawerSongFragmentViewModel0.onUserEvent(new DeleteViewModeDrawerPlaylist(((nc.a)object1), this.w, false, false, null, p0, 28, null));
                                }
                                return H.a;
                            }
                        };
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.2 drawerSongFragmentViewModel$deleteIndices$1$20 = new we.k(this.B, null) {
                            public final DrawerSongFragmentViewModel r;
                            public final List w;

                            {
                                this.r = drawerSongFragmentViewModel0;
                                this.w = list0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.2(this.r, this.w, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.deleteIndices.1.2)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                d5.n.D(object0);
                                p p0 = new p(this.r, 3);
                                DeleteDrawerPlaylist deletePlaylist$DeleteDrawerPlaylist0 = new DeleteDrawerPlaylist(this.w, false, false, null, p0, 14, null);
                                this.r.onUserEvent(deletePlaylist$DeleteDrawerPlaylist0);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(this.w, drawerSongFragmentViewModel$deleteIndices$1$10, drawerSongFragmentViewModel$deleteIndices$1$20, this) == a0 ? a0 : H.a;
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

    public final Playable e(int v) {
        nc.a a0 = (nc.a)this.r.getValue();
        if(a0 != null) {
            C0 c00 = ((u0)a0).I();
            return c00 == null ? null : ((Playable)je.p.n0(v, b.B(c00)));
        }
        return null;
    }

    public final ArrayList f() {
        Iterable iterable0 = (Iterable)this.u.getValue();
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        for(Object object0: iterable0) {
            Integer integer0 = null;
            if(v >= 0) {
                if(((DrawerSongListItemData)object0).isSelected()) {
                    integer0 = v;
                }
                if(integer0 != null) {
                    arrayList0.add(integer0);
                }
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
        return arrayList0;
    }

    public final void g(int v) {
        List list0 = (List)this.u.getValue();
        p p0 = new p(this, 1);
        this.J.getClass();
        q.g(list0, "itemList");
        Ce.g g0 = new Ce.g(v, v, 1);  // 初始化器: LCe/e;-><init>(III)V
        this.j("sectionSelect selectPosition: " + v, this.J.c(g0, list0, p0));
    }

    @NotNull
    public final StateFlow getInternalPlaylist() {
        return this.r;
    }

    @NotNull
    public final v getOfflinePlaylistHelper() {
        return this.H;
    }

    @NotNull
    public final StateFlow getOnSwapCancelPosition() {
        return this.y;
    }

    @Nullable
    public final PlayableData getPlayableDataForMorePopup(int v) {
        nc.a a0 = (nc.a)this.r.getValue();
        if(a0 != null) {
            C0 c00 = ((u0)a0).I();
            if(c00 != null) {
                return c00.a == null ? null : ((PlayableData)je.p.n0(v, c00.a));
            }
        }
        return null;
    }

    @NotNull
    public final StateFlow getPlaylistInfoStateFlow() {
        return this.s;
    }

    @NotNull
    public final String getPvDummyLogAction() {
        DrawerPlaylistInfo drawerPlaylistInfo0;
        nc.a a0 = (nc.a)this.r.getValue();
        String s = null;
        if(a0 == null) {
            drawerPlaylistInfo0 = null;
        }
        else {
            C0 c00 = ((u0)a0).I();
            drawerPlaylistInfo0 = c00 == null ? null : c00.g;
        }
        if(drawerPlaylistInfo0 != null) {
            s = drawerPlaylistInfo0.getContsId();
        }
        if(q.b(s, "PlaylistSeqRecent")) {
            return "connStorageRecentSongDtl";
        }
        if(q.b(s, "PlaylistSeqLike")) {
            return "connStorageLikeSongDtl";
        }
        com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab.Companion drawerPlytTab$Companion0 = DrawerPlytTab.Companion;
        if(drawerPlaylistInfo0 != null) {
            String s1 = drawerPlaylistInfo0.getLandingFrom();
            return s1 == null ? drawerPlytTab$Companion0.getActionName("RECENT", true) : drawerPlytTab$Companion0.getActionName(s1, true);
        }
        return drawerPlytTab$Companion0.getActionName("RECENT", true);
    }

    @NotNull
    public final SharedFlow getScrollTopEventByFetch() {
        return this.E;
    }

    @NotNull
    public final StateFlow getSectionSelectState() {
        return this.w;
    }

    @NotNull
    public final StateFlow getSongListState() {
        return this.u;
    }

    @NotNull
    public final TiaraMixUpEventMeta getTiaraEventMetaForMixUp() {
        ArrayList arrayList0 = this.f();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            Playable playable0 = this.e(((Number)object0).intValue());
            if(playable0 != null) {
                arrayList1.add(playable0);
            }
        }
        String s = arrayList1.size() <= 1 ? ((StringProviderImpl)this.i).a(0x7F130F14) : ((StringProviderImpl)this.i).a(0x7F130F15);  // string:tiara_mixup_page_meta_type_song "곡 믹스업"
        Playable playable1 = (Playable)je.p.m0(arrayList1);
        return new TiaraMixUpEventMeta("", s, "");
    }

    @NotNull
    public final DrawerSongTiaraLogHelper getTiaraLogHelper() {
        return this.I;
    }

    public final void h(int v) {
        List list0 = (List)this.u.getValue();
        DrawerSongListItemData drawerSongListItemData0 = (DrawerSongListItemData)je.p.n0(v, list0);
        if(drawerSongListItemData0 != null) {
            List list1 = this.J.b(list0, drawerSongListItemData0);
            if(list0.size() < 2) {
                this.i(c0.c);
            }
            this.j("select selectPosition: " + v, list1);
        }
    }

    public final void i(c0 c00) {
        this.v.setValue(c00);
    }

    public final boolean isDj() {
        return this.p;
    }

    @NotNull
    public final StateFlow isProgressVisible() {
        return this.C;
    }

    @NotNull
    public final StateFlow isToolbarVisible() {
        return this.A;
    }

    public final void j(String s, List list0) {
        LogU.debug$default(this.n, "updateSongList fromCall: " + s, null, false, 6, null);
        this.t.setValue(list0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPremiumCacheDelete eventPremiumCacheDelete0) {
        q.g(eventPremiumCacheDelete0, "event");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public final DrawerSongFragmentViewModel B;
            public DrawerSongFragmentViewModel r;
            public int w;

            {
                this.B = drawerSongFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onEventMainThread.1(this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onEventMainThread.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.B;
                switch(this.w) {
                    case 0: {
                        d5.n.D(object0);
                        this.w = 1;
                        object0 = drawerSongFragmentViewModel0.getOfflinePlaylistHelper().h(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_10;
                    }
                    case 1: {
                        d5.n.D(object0);
                    label_10:
                        boolean z = ((Boolean)object0).booleanValue();
                        LogU.debug$default(drawerSongFragmentViewModel0.n, "EventPremiumCacheDelete showOfflineBadge: " + z, null, false, 6, null);
                        if(z) {
                            nc.a a1 = (nc.a)drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                            C0 c00 = a1 == null ? null : ((u0)a1).I();
                            this.r = drawerSongFragmentViewModel0;
                            this.w = 2;
                            object0 = drawerSongFragmentViewModel0.c(c00, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            DrawerSongFragmentViewModel.access$updateSongListState(drawerSongFragmentViewModel0, ((List)object0), "EventPremiumCacheDelete");
                            return H.a;
                        }
                        break;
                    }
                    case 2: {
                        drawerSongFragmentViewModel0 = this.r;
                        d5.n.D(object0);
                        DrawerSongFragmentViewModel.access$updateSongListState(drawerSongFragmentViewModel0, ((List)object0), "EventPremiumCacheDelete");
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.melon.ui.k1
    @Nullable
    public Object onFetchStart(@NotNull g1 g10, @NotNull Continuation continuation0) {
        this.B.setValue(Boolean.TRUE);
        this.updateUiState(new h(8));
        Object object0 = this.d(continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public final void onFragmentResumed() {
        boolean z;
        nc.a a0 = (nc.a)this.r.getValue();
        if(a0 == null) {
            z = true;
        }
        else {
            C0 c00 = ((u0)a0).I();
            z = c00 == null ? true : c00.h;
        }
        if(!z) {
            this.H.a();
        }
        this.unSelectAll();
    }

    @Override  // com.melon.ui.k1
    public void onUserEvent(@NotNull Pc.e e0) {
        ArrayList arrayList3;
        q.g(e0, "userEvent");
        DrawerSongTiaraLogHelper drawerSongTiaraLogHelper0 = this.I;
        if(e0 instanceof OnClickHeader) {
            this.sendUiEvent(OpenDrawerBottomSheet.INSTANCE);
            drawerSongTiaraLogHelper0.sendHeaderClickLog();
            return;
        }
        if(e0 instanceof ClickAllSelectUserEvent) {
            this.toggleSelectAll();
            drawerSongTiaraLogHelper0.sendAllSelectFilterClickLog();
            return;
        }
        if(e0 instanceof OnSwapSongPosition) {
            Playable playable0 = this.e(((OnSwapSongPosition)e0).getStart());
            int v = ((OnSwapSongPosition)e0).getStart();
            int v1 = ((OnSwapSongPosition)e0).getEnd();
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new DrawerSongFragmentViewModel.onSwapSongPosition.1(this, v, v1, null), 3, null);
            drawerSongTiaraLogHelper0.sendMoveClickLog(((OnSwapSongPosition)e0).getStart(), playable0);
            return;
        }
        if(e0 instanceof OnTouchDownMoveIconWhenSelectRepeatOn) {
            this.sendUiEvent(new ShowSelectionRepeatInterruptPopup(new com.iloen.melon.player.playlist.drawernew.o(this, 0)));
            return;
        }
        if(e0 instanceof OnCheckSong) {
            c0 c00 = ((OnCheckSong)e0).getSectionSelectState();
            c0.a.getClass();
            if(F.u(c00)) {
                this.g(((OnCheckSong)e0).getIndex());
            }
            else {
                this.h(((OnCheckSong)e0).getIndex());
            }
            drawerSongTiaraLogHelper0.sendCheckBoxClickLog(((OnCheckSong)e0).getIndex(), this.e(((OnCheckSong)e0).getIndex()));
            return;
        }
        StateFlow stateFlow0 = this.w;
        if(e0 instanceof OnClickSong) {
            c0 c01 = (c0)stateFlow0.getValue();
            c0.a.getClass();
            if(F.u(c01)) {
                this.g(((OnClickSong)e0).getIndex());
            }
            else if(this.f().isEmpty()) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(e0, null) {
                    public final Pc.e B;
                    public int r;
                    public final DrawerSongFragmentViewModel w;

                    {
                        this.w = drawerSongFragmentViewModel0;
                        this.B = e0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1 drawerSongFragmentViewModel$onUserEvent$2$10 = new we.k(this.B, null) {
                                    public final DrawerSongFragmentViewModel r;
                                    public final Pc.e w;

                                    {
                                        this.r = drawerSongFragmentViewModel0;
                                        this.w = e0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1(this.r, this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d5.n.D(object0);
                                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1.1 drawerSongFragmentViewModel$onUserEvent$2$1$10 = new we.k(this.w, null) {
                                            public final DrawerSongFragmentViewModel r;
                                            public final Pc.e w;

                                            {
                                                this.r = drawerSongFragmentViewModel0;
                                                this.w = e0;
                                                super(1, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Continuation continuation0) {
                                                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1.1(this.r, this.w, continuation0);
                                            }

                                            @Override  // we.k
                                            public Object invoke(Object object0) {
                                                return this.invoke(((Continuation)object0));
                                            }

                                            public final Object invoke(Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                int v = ((OnClickSong)this.w).getIndex();
                                                DrawerSongFragmentViewModel.access$playAtPosition(this.r, v);
                                                return H.a;
                                            }
                                        };
                                        DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.1 drawerSongFragmentViewModel$checkSelectRepeatClearAndDo$10 = new DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.1(this.r, null);
                                        BuildersKt__Builders_commonKt.launch$default(f0.h(this.r), null, null, new DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.2(this.r, drawerSongFragmentViewModel$checkSelectRepeatClearAndDo$10, drawerSongFragmentViewModel$onUserEvent$2$1$10, null), 3, null);
                                        return H.a;
                                    }
                                };
                                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2 drawerSongFragmentViewModel$onUserEvent$2$20 = new we.k(this.B, null) {
                                    public final DrawerSongFragmentViewModel r;
                                    public final Pc.e w;

                                    {
                                        this.r = drawerSongFragmentViewModel0;
                                        this.w = e0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2(this.r, this.w, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d5.n.D(object0);
                                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.1 drawerSongFragmentViewModel$onUserEvent$2$2$10 = new we.k(this.w, null) {
                                            public final Pc.e B;
                                            public int r;
                                            public final DrawerSongFragmentViewModel w;

                                            {
                                                this.w = drawerSongFragmentViewModel0;
                                                this.B = e0;
                                                super(1, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Continuation continuation0) {
                                                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.1(this.w, this.B, continuation0);
                                            }

                                            @Override  // we.k
                                            public Object invoke(Object object0) {
                                                return this.invoke(((Continuation)object0));
                                            }

                                            public final Object invoke(Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                ne.a a0 = ne.a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        int v = ((OnClickSong)this.B).getIndex();
                                                        this.r = 1;
                                                        Object object1 = this.w.e.p(this.w.o, v, this);
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
                                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.2 drawerSongFragmentViewModel$onUserEvent$2$2$20 = new we.k(this.w, null) {
                                            public final DrawerSongFragmentViewModel r;
                                            public final Pc.e w;

                                            {
                                                this.r = drawerSongFragmentViewModel0;
                                                this.w = e0;
                                                super(1, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Continuation continuation0) {
                                                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.2(this.r, this.w, continuation0);
                                            }

                                            @Override  // we.k
                                            public Object invoke(Object object0) {
                                                return this.invoke(((Continuation)object0));
                                            }

                                            public final Object invoke(Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.2.2.2)this.create(continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                int v = ((OnClickSong)this.w).getIndex();
                                                DrawerSongFragmentViewModel.access$playAtPosition(this.r, v);
                                                return H.a;
                                            }
                                        };
                                        DrawerSongFragmentViewModel.access$checkSelectRepeatClearAndDo(this.r, drawerSongFragmentViewModel$onUserEvent$2$2$10, drawerSongFragmentViewModel$onUserEvent$2$2$20);
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                return DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(this.w, drawerSongFragmentViewModel$onUserEvent$2$10, drawerSongFragmentViewModel$onUserEvent$2$20, this) == a0 ? a0 : H.a;
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
            else {
                this.h(((OnClickSong)e0).getIndex());
            }
            drawerSongTiaraLogHelper0.sendPlayClickLog(((OnClickSong)e0).getIndex(), this.e(((OnClickSong)e0).getIndex()));
            return;
        }
        if(e0 instanceof OnClickThumb) {
            Playable playable1 = this.e(((OnClickThumb)e0).getIndex());
            drawerSongTiaraLogHelper0.sendAlbumImgClickLog(((OnClickThumb)e0).getIndex(), playable1);
            c0 c02 = (c0)stateFlow0.getValue();
            c0.a.getClass();
            if(F.u(c02)) {
                this.g(((OnClickThumb)e0).getIndex());
                return;
            }
            if(!this.f().isEmpty()) {
                this.h(((OnClickThumb)e0).getIndex());
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(this, null) {
                public final DrawerSongFragmentViewModel B;
                public int r;
                public final Playable w;

                {
                    this.w = playable0;
                    this.B = drawerSongFragmentViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.3(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            Playable playable0 = this.w;
                            if(playable0 != null) {
                                L0 l00 = this.B.getProgressUpdater();
                                this.r = 1;
                                this.B.f.getClass();
                                if(a.a(playable0, l00, this) == a0) {
                                    return a0;
                                }
                            }
                            return H.a;
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
        if(e0 instanceof OnLongClickSong) {
            this.unSelectAll();
            this.sendUiEvent(new OnShowMorePopup(((OnLongClickSong)e0).getIndex(), ((OnLongClickSong)e0).isOwner()));
            return;
        }
        if(e0 instanceof OnClickSongMore) {
            this.sendUiEvent(new OnShowMorePopup(((OnClickSongMore)e0).getIndex(), false));
            return;
        }
        if(e0 instanceof Lb.d) {
            drawerSongTiaraLogHelper0.sendOfflinePlayClickLog(!((Ib.b)this.H.k.getValue()).a);
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
                public int r;
                public final DrawerSongFragmentViewModel w;

                {
                    this.w = drawerSongFragmentViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.4(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return this.w.getOfflinePlaylistHelper().d(this) == a0 ? a0 : H.a;
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
        Pc.d d0 = this.i;
        if(e0 instanceof ClickSectionSelectButton) {
            this.unSelectAll();
            this.sendUiEvent(new t4(((StringProviderImpl)d0).a(0x7F130A3F)));  // string:smartplaylist_section_start_toast_msg "구간선택을 위해 곡 선택이 해제되었습니다."
            this.i(c0.d);
            drawerSongTiaraLogHelper0.sendSectionSelectClickLog();
            return;
        }
        if(e0 instanceof ClickSectionSelectCancelButton) {
            this.unSelectAll();
            this.i(c0.b);
            return;
        }
        if(e0 instanceof Jd.g) {
            Iterable iterable0 = (Iterable)this.u.getValue();
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                if(((DrawerSongListItemData)object0).isSelected()) {
                    arrayList0.add(object0);
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object1: arrayList0) {
                arrayList1.add(((DrawerSongListItemData)object1).getContentId());
            }
            nc.a a0 = (nc.a)this.r.getValue();
            if(a0 == null) {
                arrayList3 = new ArrayList();
            }
            else {
                C0 c03 = ((u0)a0).I();
                if(c03 == null) {
                    arrayList3 = new ArrayList();
                }
                else {
                    ArrayList arrayList2 = b.B(c03);
                    arrayList3 = new ArrayList();
                    for(Object object2: arrayList2) {
                        if(arrayList1.contains("")) {
                            arrayList3.add(object2);
                        }
                    }
                }
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(this, arrayList3, null) {
                public final DrawerSongFragmentViewModel B;
                public final ArrayList D;
                public int r;
                public final Pc.e w;

                {
                    this.w = e0;
                    this.B = drawerSongFragmentViewModel0;
                    this.D = arrayList0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.5(this.w, this.B, this.D, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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
                            Jd.a a1 = DrawerSongFragmentViewModel.access$getToolBarEventHelper(this.B);
                            this.r = 1;
                            Jd.a.b(a1, ((Jd.g)this.w), this.D);
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
        if(e0 instanceof ToolBarClickReplayUserEvent) {
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.6 drawerSongFragmentViewModel$onUserEvent$60 = new we.k(null) {
                public final DrawerSongFragmentViewModel r;

                {
                    this.r = drawerSongFragmentViewModel0;
                    super(1, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.6(this.r, continuation0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.6)this.create(continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    d5.n.D(object0);
                    DrawerSongFragmentViewModel.access$setSelectRepeatAndPlay(this.r);
                    return H.a;
                }
            };
            DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.1 drawerSongFragmentViewModel$checkSelectRepeatClearAndDo$10 = new DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.1(this, null);
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new DrawerSongFragmentViewModel.checkSelectRepeatClearAndDo.2(this, drawerSongFragmentViewModel$checkSelectRepeatClearAndDo$10, drawerSongFragmentViewModel$onUserEvent$60, null), 3, null);
            return;
        }
        if(e0 instanceof ToolBarClickRemoveUserEvent) {
            if(NetUtils.isConnected()) {
                this.deleteIndices(this.f());
                return;
            }
            this.sendUiEvent(new q4(28, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F1307AF), null, null));  // string:alert_dlg_title_info "안내"
            return;
        }
        if(e0 instanceof DeletePlaylist) {
            T2.a a1 = f0.h(this);
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.7 drawerSongFragmentViewModel$onUserEvent$70 = new we.k(0, DrawerSongFragmentViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((DrawerSongFragmentViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.l.handleUserEvent(((DeletePlaylist)e0), a1, drawerSongFragmentViewModel$onUserEvent$70);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a2 = f0.h(this);
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.8 drawerSongFragmentViewModel$onUserEvent$80 = new we.k(0, DrawerSongFragmentViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((DrawerSongFragmentViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.j.d(((com.melon.ui.q)e0), a2, drawerSongFragmentViewModel$onUserEvent$80);
            return;
        }
        k k0 = this.c;
        if(e0 instanceof L2) {
            T2.a a3 = f0.h(this);
            boolean z = ((e0)k0).m();
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.9 drawerSongFragmentViewModel$onUserEvent$90 = new we.k(0, DrawerSongFragmentViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((DrawerSongFragmentViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l00 = this.getProgressUpdater();
            this.m.b(((L2)e0), a3, z, drawerSongFragmentViewModel$onUserEvent$90, l00);
            return;
        }
        if(e0 instanceof q3) {
            T2.a a4 = f0.h(this);
            boolean z1 = ((e0)k0).m();
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.10 drawerSongFragmentViewModel$onUserEvent$100 = new we.k(0, DrawerSongFragmentViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((DrawerSongFragmentViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l01 = this.getProgressUpdater();
            this.k.a(((q3)e0), a4, z1, drawerSongFragmentViewModel$onUserEvent$100, l01);
            return;
        }
        if(e0 instanceof Ed.a) {
            T2.a a5 = f0.h(this);
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.11 drawerSongFragmentViewModel$onUserEvent$110 = new n(e0, null) {
                public final Pc.e B;
                public int r;
                public final DrawerSongFragmentViewModel w;

                {
                    this.w = drawerSongFragmentViewModel0;
                    this.B = e0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.11(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.11)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return this.w.d.a(((Ed.a)this.B).a, ((Ed.a)this.B).b, this) == a0 ? a0 : H.a;
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
            BuildersKt__Builders_commonKt.launch$default(a5, this.b, null, drawerSongFragmentViewModel$onUserEvent$110, 2, null);
            return;
        }
        super.onUserEvent(e0);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$onUserEvent$1$1", f = "DrawerSongFragmentViewModel.kt", l = {0x210}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.1.1 extends i implements n {
            public int r;
            public final DrawerSongFragmentViewModel w;

            public com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.1.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
                this.w = drawerSongFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.1.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.e.b(0x7F13090F, this) == a0 ? a0 : H.a;  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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

    public final void setIsDragging(boolean z) {
        this.G = z;
        LogU.debug$default(this.n, "setIsDragging: " + z, null, false, 6, null);
    }

    public final void toggleSelectAll() {
        List list0 = (List)this.u.getValue();
        g g0 = this.J;
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                if(((DrawerSongListItemData)object0).isSelected()) {
                    this.j("toggleSelectAll unselect", g0.a(list0, false));
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
        List list1 = g0.a(list0, true);
        if(list0.size() < 2) {
            this.i(c0.c);
        }
        this.j("toggleSelectAll select", list1);
    }

    public final void unSelectAll() {
        this.i(c0.b);
        List list0 = (List)this.u.getValue();
        this.j("unSelectAll", this.J.a(list0, false));
    }

    public final void updateHasToolbarPadding(boolean z) {
        this.z.setValue(Boolean.valueOf(z));
    }

    public final void updateInternalPlaylist(@Nullable nc.a a0, @NotNull String s) {
        q.g(s, "fromCall");
        LogU.debug$default(this.n, "updateInternalPlaylist fromCall: " + s, null, false, 6, null);
        this.q.setValue(a0);
    }
}

