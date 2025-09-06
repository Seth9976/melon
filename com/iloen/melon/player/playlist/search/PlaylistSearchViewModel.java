package com.iloen.melon.player.playlist.search;

import Pc.d;
import android.net.Uri;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.LocalDownloadablePlaylist;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeleteDrawerPlaylist;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeletePlaylistByPlayables;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeleteViewModeDrawerPlaylist;
import com.iloen.melon.player.playlist.common.DeletePlaylist;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.L2;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import com.melon.ui.q3;
import com.melon.ui.t3;
import d5.n;
import e1.b;
import eb.y;
import java.util.Iterator;
import javax.inject.Inject;
import je.w;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import nc.C0;
import nc.u0;
import ob.a;
import ob.z;
import oc.H;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;

@Metadata(d1 = {"\u0000\u00BA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YBu\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\r\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\u0006\u0010\u0012\u001A\u00020\u0011\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0016\u001A\u00020\u0015\u0012\u0006\u0010\u0018\u001A\u00020\u0017\u0012\u0006\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001E\u0010\u001FJ!\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010!\u001A\u00020 2\b\u0010#\u001A\u0004\u0018\u00010\"\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010*\u001A\u00020)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0015\u0010-\u001A\u00020)2\u0006\u0010,\u001A\u00020\u001D\u00A2\u0006\u0004\b-\u0010.J\u0015\u00101\u001A\u00020)2\u0006\u00100\u001A\u00020/\u00A2\u0006\u0004\b1\u00102J\u0015\u00103\u001A\u00020)2\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b3\u00104R\u0019\u0010:\u001A\u0004\u0018\u0001058\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u00109R#\u0010B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0;8\u0006\u00A2\u0006\f\n\u0004\b>\u0010?\u001A\u0004\b@\u0010AR\u001D\u0010I\u001A\b\u0012\u0004\u0012\u00020D0C8\u0006\u00A2\u0006\f\n\u0004\bE\u0010F\u001A\u0004\bG\u0010HR\u001D\u0010K\u001A\b\u0012\u0004\u0012\u00020\u001D0;8\u0006\u00A2\u0006\f\n\u0004\bJ\u0010?\u001A\u0004\bK\u0010AR\u001D\u0010Q\u001A\b\u0012\u0004\u0012\u00020\u001D0L8\u0006\u00A2\u0006\f\n\u0004\bM\u0010N\u001A\u0004\bO\u0010PR\u0017\u0010W\u001A\u00020R8\u0006\u00A2\u0006\f\n\u0004\bS\u0010T\u001A\u0004\bU\u0010VR\u0011\u0010X\u001A\u00020\u001D8F\u00A2\u0006\u0006\u001A\u0004\bX\u0010\u001F\u00A8\u0006Z"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchViewModel;", "Lcom/melon/ui/n0;", "Landroidx/lifecycle/c0;", "savedStateHandle", "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "ioDispatcher", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lob/a;", "playableUseCase", "Lmb/k;", "loginUseCase", "Leb/y;", "uaLogUseCase", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "deleteHelper", "LPc/d;", "stringProvider", "Lcom/melon/ui/Q;", "addPlayUserEventHelper", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "Lcom/melon/ui/b3;", "morePopupUserEventHelper", "<init>", "(Landroidx/lifecycle/c0;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkc/s2;Lob/z;Lob/a;Lmb/k;Leb/y;Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;LPc/d;Lcom/melon/ui/Q;Lcom/melon/ui/t3;Lcom/melon/ui/b3;)V", "", "isLocalDownloadablePlaylist", "()Z", "Lcom/iloen/melon/playback/Playable;", "playable", "Landroid/net/Uri;", "thumbUri", "Lzd/Q;", "getMorePopUpType", "(Lcom/iloen/melon/playback/Playable;Landroid/net/Uri;)Lzd/Q;", "LPc/e;", "userEvent", "Lie/H;", "onUserEvent", "(LPc/e;)V", "newIsDone", "updateIsDone", "(Z)V", "", "newKeyword", "updateKeyword", "(Ljava/lang/String;)V", "deletePlayable", "(Lcom/iloen/melon/playback/Playable;)V", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "n", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "o", "Lkotlinx/coroutines/flow/StateFlow;", "getUiListStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "uiListStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "", "r", "Lkotlinx/coroutines/flow/SharedFlow;", "getKeyword", "()Lkotlinx/coroutines/flow/SharedFlow;", "keyword", "t", "isDone", "Lkotlinx/coroutines/flow/Flow;", "v", "Lkotlinx/coroutines/flow/Flow;", "getSearchCloseEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "searchCloseEventFlow", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "w", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "tiaraLogHelper", "isDrawerViewMode", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchViewModel extends n0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "ARG_PLAYLIST_ID", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PLAYLIST_ID = "playlistId";
    @NotNull
    public static final Companion Companion;
    public final CoroutineDispatcher a;
    public final CoroutineDispatcher b;
    public final s2 c;
    public final z d;
    public final a e;
    public final k f;
    public final y g;
    public final PlaylistDeleteHelper h;
    public final d i;
    public final Q j;
    public final t3 k;
    public final b3 l;
    public final LogU m;
    public final PlaylistId n;
    public final StateFlow o;
    public H p;
    public final MutableSharedFlow q;
    public final SharedFlow r;
    public final MutableStateFlow s;
    public final StateFlow t;
    public final MutableSharedFlow u;
    public final SharedFlow v;
    public final com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.tiaraLogHelper.1 w;

    static {
        PlaylistSearchViewModel.Companion = new Companion(null);
        PlaylistSearchViewModel.$stable = 8;
    }

    @Inject
    public PlaylistSearchViewModel(@NotNull c0 c00, @NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull CoroutineDispatcher coroutineDispatcher1, @NotNull s2 s20, @NotNull z z0, @NotNull a a0, @NotNull k k0, @NotNull y y0, @NotNull PlaylistDeleteHelper playlistDeleteHelper0, @NotNull d d0, @NotNull Q q0, @NotNull t3 t30, @NotNull b3 b30) {
        q.g(c00, "savedStateHandle");
        q.g(coroutineDispatcher0, "defaultDispatcher");
        q.g(coroutineDispatcher1, "ioDispatcher");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        q.g(a0, "playableUseCase");
        q.g(k0, "loginUseCase");
        q.g(y0, "uaLogUseCase");
        q.g(playlistDeleteHelper0, "deleteHelper");
        q.g(d0, "stringProvider");
        q.g(q0, "addPlayUserEventHelper");
        q.g(t30, "putPopupUserEventHelper");
        q.g(b30, "morePopupUserEventHelper");
        super();
        this.a = coroutineDispatcher0;
        this.b = coroutineDispatcher1;
        this.c = s20;
        this.d = z0;
        this.e = a0;
        this.f = k0;
        this.g = y0;
        this.h = playlistDeleteHelper0;
        this.i = d0;
        this.j = q0;
        this.k = t30;
        this.l = b30;
        this.m = new LogU("PlaylistSearchViewModel");
        this.n = (PlaylistId)c00.a("playlistId");
        this.o = FlowKt.stateIn(FlowKt.callbackFlow(new PlaylistSearchViewModel.initUiStateFlow.1(this, null)), f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), w.a);
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.q = mutableSharedFlow0;
        this.r = FlowKt.asSharedFlow(mutableSharedFlow0);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.s = mutableStateFlow0;
        this.t = FlowKt.asStateFlow(mutableStateFlow0);
        MutableSharedFlow mutableSharedFlow1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.u = mutableSharedFlow1;
        this.v = FlowKt.asSharedFlow(mutableSharedFlow1);
        this.w = new PlaylistSongBaseTiaraLogHelper(/*ERROR_MISSING_ARG_1/*) {
            @Override  // com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper
            public String getFilterClickLayer1() {
                return ((StringProviderImpl)PlaylistSearchViewModel.access$getStringProvider$p(d0)).a(0x7F130ECC);  // string:tiara_localplylist_layer1 "곡리스트"
            }
        };
    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(PlaylistSearchViewModel playlistSearchViewModel0) {
        return playlistSearchViewModel0.a;
    }

    public static final CoroutineDispatcher access$getIoDispatcher$p(PlaylistSearchViewModel playlistSearchViewModel0) {
        return playlistSearchViewModel0.b;
    }

    public static final LogU access$getLog$p(PlaylistSearchViewModel playlistSearchViewModel0) {
        return playlistSearchViewModel0.m;
    }

    public static final d access$getStringProvider$p(PlaylistSearchViewModel playlistSearchViewModel0) {
        return playlistSearchViewModel0.i;
    }

    public static final Object access$playAtPosition(PlaylistSearchViewModel playlistSearchViewModel0, int v, Continuation continuation0) {
        ie.H h0 = ie.H.a;
        if(playlistSearchViewModel0.n == null) {
            return h0;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(playlistSearchViewModel0), null, null, new PlaylistSearchViewModel.playAtPosition.2(playlistSearchViewModel0, v, null), 3, null);
        return h0;
    }

    public final H b() {
        PlaylistId playlistId0 = this.n;
        if(playlistId0 == null) {
            LogU.warn$default(this.m, "getPlaylist() playlistId is null", null, false, 6, null);
            return null;
        }
        H h0 = this.p;
        return h0 == null ? ((d3)this.c).q(playlistId0) : h0;
    }

    public final void deletePlayable(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        PlaylistId playlistId0 = this.n;
        if(playlistId0 != null) {
            PlaylistDeleteHelper playlistDeleteHelper0 = this.h;
            if(playlistId0 != PlaylistId.DRAWER) {
                playlistDeleteHelper0.handleUserEvent(new DeletePlaylistByPlayables(playlistId0, e.k.z(playable0), true, true, null, null, 0x30, null), f0.h(this), new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((I4)object0));
                        return ie.H.a;
                    }

                    public final void invoke(I4 i40) {
                        q.g(i40, "p0");
                        ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                    }
                });
                return;
            }
            int v = -1;
            int v1 = 0;
            if(this.isDrawerViewMode()) {
                nc.a a0 = this.p instanceof nc.a ? ((nc.a)this.p) : null;
                if(a0 != null) {
                    Iterator iterator0 = b.B(((u0)a0).I()).iterator();
                    while(iterator0.hasNext()) {
                        iterator0.next();
                        if(q.b("", "")) {
                            v = v1;
                            break;
                        }
                        ++v1;
                    }
                    playlistDeleteHelper0.handleUserEvent(new DeleteViewModeDrawerPlaylist(a0, e.k.z(v), true, true, null, new e(this, 0), 16, null), f0.h(this), new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    });
                }
            }
            else {
                H h0 = this.b();
                if(h0 != null) {
                    Iterator iterator1 = b.B(h0.getState()).iterator();
                    while(iterator1.hasNext()) {
                        iterator1.next();
                        if(q.b("", "")) {
                            v = v1;
                            break;
                        }
                        ++v1;
                    }
                    playlistDeleteHelper0.handleUserEvent(new DeleteDrawerPlaylist(e.k.z(v), true, true, null, new e(this, 1), 8, null), f0.h(this), new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    });
                }
            }
        }
    }

    @NotNull
    public final SharedFlow getKeyword() {
        return this.r;
    }

    @Nullable
    public final zd.Q getMorePopUpType(@NotNull Playable playable0, @Nullable Uri uri0) {
        boolean z;
        q.g(playable0, "playable");
        C0 c00 = null;
        PlaylistId playlistId0 = this.n;
        if(playlistId0 == null) {
            return null;
        }
        k k0 = this.f;
        if(playlistId0 == PlaylistId.DRAWER) {
            H h0 = this.b();
            oc.Q q0 = h0 == null ? null : h0.getState();
            if(q0 instanceof C0) {
                c00 = (C0)q0;
            }
            if(c00 == null) {
                z = false;
            }
            else {
                DrawerPlaylistInfo drawerPlaylistInfo0 = c00.g;
                z = drawerPlaylistInfo0 == null ? false : drawerPlaylistInfo0.isOwner();
            }
            boolean z1 = ((e0)k0).j().getIsDj();
            return new com.melon.ui.popup.context.more.b(this.n, playable0, z, z1, uri0);
        }
        return new com.melon.ui.popup.context.more.b(playlistId0, playable0, true, ((e0)k0).j().getIsDj(), uri0);
    }

    @Nullable
    public final PlaylistId getPlaylistId() {
        return this.n;
    }

    @NotNull
    public final Flow getSearchCloseEventFlow() {
        return this.v;
    }

    @NotNull
    public final PlaylistSongBaseTiaraLogHelper getTiaraLogHelper() {
        return this.w;
    }

    @NotNull
    public final StateFlow getUiListStateFlow() {
        return this.o;
    }

    @NotNull
    public final StateFlow isDone() {
        return this.t;
    }

    public final boolean isDrawerViewMode() {
        C0 c00 = null;
        oc.Q q0 = this.p == null ? null : this.p.getState();
        if(q0 instanceof C0) {
            c00 = (C0)q0;
        }
        return c00 != null && c00.h;
    }

    public final boolean isLocalDownloadablePlaylist() {
        return this.b() instanceof LocalDownloadablePlaylist;
    }

    @Override  // com.melon.ui.n0
    public void onUserEvent(@NotNull Pc.e e0) {
        q.g(e0, "userEvent");
        PlaylistId playlistId0 = this.n;
        if(playlistId0 != null) {
            if(e0 instanceof ClickSongItem) {
                com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.1 playlistSearchViewModel$onUserEvent$10 = new we.k(e0, null) {
                    public final Pc.e B;
                    public int r;
                    public final PlaylistSearchViewModel w;

                    {
                        this.w = playlistSearchViewModel0;
                        this.B = e0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.1)this.create(continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                int v = ((ClickSongItem)this.B).getIndexInPlaylist();
                                this.r = 1;
                                Object object1 = this.w.d.p(this.w.getPlaylistId(), v, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.2 playlistSearchViewModel$onUserEvent$20 = new we.k(e0, null) {
                    public final Pc.e B;
                    public int r;
                    public final PlaylistSearchViewModel w;

                    {
                        this.w = playlistSearchViewModel0;
                        this.B = e0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.2(this.w, this.B, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.2)this.create(continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                int v = ((ClickSongItem)this.B).getIndexInPlaylist();
                                this.r = 1;
                                return PlaylistSearchViewModel.access$playAtPosition(this.w, v, this) == a0 ? a0 : ie.H.a;
                            }
                            case 1: {
                                n.D(object0);
                                return ie.H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new PlaylistSearchViewModel.checkSelectRepeatClearAndDo.2(playlistSearchViewModel$onUserEvent$10, this, playlistSearchViewModel$onUserEvent$20, null), 3, null);
                return;
            }
            if(!(e0 instanceof ClickAlbumThumbnail)) {
                goto label_13;
            }
            Playable playable0 = ((ClickAlbumThumbnail)e0).getPlayable();
            if(playable0.hasSongId()) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(playable0, null) {
                    public final Playable B;
                    public int r;
                    public final PlaylistSearchViewModel w;

                    {
                        this.w = playlistSearchViewModel0;
                        this.B = playable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.3(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.3)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                L0 l00 = this.w.getProgressUpdater();
                                this.r = 1;
                                this.w.e.getClass();
                                return a.a(this.B, l00, this) == a0 ? a0 : ie.H.a;
                            }
                            case 1: {
                                n.D(object0);
                                return ie.H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }, 3, null);
                return;
            label_13:
                if(e0 instanceof DeletePlaylist) {
                    T2.a a0 = f0.h(this);
                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.4 playlistSearchViewModel$onUserEvent$40 = new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    };
                    this.h.handleUserEvent(((DeletePlaylist)e0), a0, playlistSearchViewModel$onUserEvent$40);
                    return;
                }
                if(e0 instanceof com.melon.ui.q) {
                    T2.a a1 = f0.h(this);
                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.5 playlistSearchViewModel$onUserEvent$50 = new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    };
                    this.j.d(((com.melon.ui.q)e0), a1, playlistSearchViewModel$onUserEvent$50);
                    return;
                }
                k k0 = this.f;
                if(e0 instanceof q3) {
                    T2.a a2 = f0.h(this);
                    boolean z = ((e0)k0).m();
                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.6 playlistSearchViewModel$onUserEvent$60 = new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    };
                    L0 l00 = this.getProgressUpdater();
                    this.k.a(((q3)e0), a2, z, playlistSearchViewModel$onUserEvent$60, l00);
                    return;
                }
                if(e0 instanceof L2) {
                    T2.a a3 = f0.h(this);
                    boolean z1 = ((e0)k0).m();
                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.7 playlistSearchViewModel$onUserEvent$70 = new we.k(0, PlaylistSearchViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((I4)object0));
                            return ie.H.a;
                        }

                        public final void invoke(I4 i40) {
                            q.g(i40, "p0");
                            ((PlaylistSearchViewModel)this.receiver).sendUiEvent(i40);
                        }
                    };
                    L0 l01 = this.getProgressUpdater();
                    this.l.b(((L2)e0), a3, z1, playlistSearchViewModel$onUserEvent$70, l01);
                    return;
                }
                if(e0 instanceof OnChangeDrawerPlaylistInfo) {
                    if(playlistId0 == PlaylistId.DRAWER) {
                        this.p = ((OnChangeDrawerPlaylistInfo)e0).getPlaylist();
                        return;
                    }
                    LogU.warn$default(this.m, "setPlaylistForDrawerViewMode() playlistId is not DRAWER", null, false, 6, null);
                    return;
                }
                if(e0 instanceof Ed.a) {
                    T2.a a4 = f0.h(this);
                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.8 playlistSearchViewModel$onUserEvent$80 = new we.n(e0, null) {
                        public final Pc.e B;
                        public int r;
                        public final PlaylistSearchViewModel w;

                        {
                            this.w = playlistSearchViewModel0;
                            this.B = e0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.8(this.w, this.B, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.onUserEvent.8)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.r) {
                                case 0: {
                                    n.D(object0);
                                    this.r = 1;
                                    return this.w.g.a(((Ed.a)this.B).a, ((Ed.a)this.B).b, this) == a0 ? a0 : ie.H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return ie.H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    BuildersKt__Builders_commonKt.launch$default(a4, this.b, null, playlistSearchViewModel$onUserEvent$80, 2, null);
                    return;
                }
                super.onUserEvent(e0);
            }
        }
    }

    public final void updateIsDone(boolean z) {
        this.s.setValue(Boolean.valueOf(z));
    }

    public final void updateKeyword(@NotNull String s) {
        q.g(s, "newKeyword");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(s, null) {
            public final String B;
            public int r;
            public final PlaylistSearchViewModel w;

            {
                this.w = playlistSearchViewModel0;
                this.B = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.updateKeyword.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.updateKeyword.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        this.r = 1;
                        return this.w.q.emit(this.B, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }
}

