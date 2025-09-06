package com.iloen.melon.player.playlist;

import Pc.d;
import Pc.e;
import T2.a;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.Navigator;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.I4;
import com.melon.ui.N3;
import com.melon.ui.n0;
import com.melon.ui.n4;
import e1.b;
import ie.H;
import javax.inject.Inject;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import mb.k;
import ob.A;
import ob.z;
import oc.Q;
import oc.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pc.c;
import pc.z0;
import va.e0;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u0017\u0010\t\u001A\u00020\b8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u001D\u0010,\u001A\b\u0012\u0004\u0012\u00020\'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R\u001D\u00100\u001A\b\u0012\u0004\u0012\u00020-0&8\u0006¢\u0006\f\n\u0004\b.\u0010)\u001A\u0004\b/\u0010+R\u001D\u00103\u001A\b\u0012\u0004\u0012\u0002010&8\u0006¢\u0006\f\n\u0004\b2\u0010)\u001A\u0004\b3\u0010+R\u001D\u00106\u001A\b\u0012\u0004\u0012\u0002010&8\u0006¢\u0006\f\n\u0004\b4\u0010)\u001A\u0004\b5\u0010+R\u001D\u0010:\u001A\b\u0012\u0004\u0012\u0002070&8\u0006¢\u0006\f\n\u0004\b8\u0010)\u001A\u0004\b9\u0010+R\u0011\u0010;\u001A\u0002018F¢\u0006\u0006\u001A\u0004\b;\u0010<R\u0011\u0010=\u001A\u0002018F¢\u0006\u0006\u001A\u0004\b=\u0010<¨\u0006>"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainViewModel;", "Lcom/melon/ui/n0;", "LPc/d;", "stringProvider", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lmb/k;", "loginUseCase", "Lcom/melon/ui/n4;", "shareSNSPopupUserEventHelper", "<init>", "(LPc/d;Lkc/s2;Lob/z;Lmb/k;Lcom/melon/ui/n4;)V", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "getCurrentPlaylistDJMalrangInfo", "()Lcom/melon/playlist/mixup/DjMalrangInfo;", "LPc/e;", "userEvent", "Lie/H;", "onUserEvent", "(LPc/e;)V", "a", "LPc/d;", "getStringProvider", "()LPc/d;", "b", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "c", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "d", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/net/Uri;", "f", "Lkotlinx/coroutines/flow/StateFlow;", "getThumbnailUriStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "thumbnailUriStateFlow", "Lob/A;", "g", "getPositionStateFlow", "positionStateFlow", "", "h", "isPlayingStateFlow", "i", "getMixUpIsDjMalrangStateFlow", "mixUpIsDjMalrangStateFlow", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "j", "getBgDataStateFlow", "bgDataStateFlow", "isLoginUser", "()Z", "isDjLoginUser", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistMainViewModel extends n0 {
    public static final int $stable = 8;
    public final d a;
    public final s2 b;
    public final z c;
    public final k d;
    public final n4 e;
    public final StateFlow f;
    public final StateFlow g;
    public final StateFlow h;
    public final StateFlow i;
    public final StateFlow j;

    @Inject
    public PlaylistMainViewModel(@NotNull d d0, @NotNull s2 s20, @NotNull z z0, @NotNull k k0, @NotNull n4 n40) {
        q.g(d0, "stringProvider");
        PlaylistMainBgData playlistMainBgData0;
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        q.g(k0, "loginUseCase");
        q.g(n40, "shareSNSPopupUserEventHelper");
        super();
        this.a = d0;
        this.b = s20;
        this.c = z0;
        this.d = k0;
        this.e = n40;
        this.f = FlowKt.stateIn(FlowKt.distinctUntilChanged(new PlaylistMainViewModel.initThumbnailUriStateFlow..inlined.map.1(z0.i())), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), Uri.EMPTY);
        this.g = FlowKt.stateIn(z.k(z0), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), new A(0L, 0x7FFFFFFFFFFFFFFFL));
        this.h = FlowKt.stateIn(z0.h(), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), Boolean.FALSE);
        this.i = FlowKt.stateIn(FlowKt.callbackFlow(new PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1(this, null)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), Boolean.FALSE);
        Flow flow0 = FlowKt.callbackFlow(new PlaylistMainViewModel.initBgDataStateFlow.1(this, null));
        a a0 = f0.h(this);
        SharingStarted sharingStarted0 = Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null);
        w w0 = ((d3)s20).k();
        if(w0 == null) {
            playlistMainBgData0 = new Default(null);
        }
        else {
            Q q0 = w0.getState();
            playlistMainBgData0 = q0 == null ? new Default(null) : PlaylistMainViewModel.b(q0);
        }
        this.j = FlowKt.stateIn(flow0, a0, sharingStarted0, playlistMainBgData0);
    }

    public static final PlaylistMainBgData access$getPlaylistMainBgData(PlaylistMainViewModel playlistMainViewModel0, Q q0) {
        playlistMainViewModel0.getClass();
        return PlaylistMainViewModel.b(q0);
    }

    public static PlaylistMainBgData b(Q q0) {
        Uri uri0 = null;
        if(q0 instanceof z0) {
            c c0 = ((z0)q0).c;
            if(c0 instanceof DjMalrangInfo) {
                return new DjMalrang(((DjMalrangInfo)c0));
            }
            PlayableData playableData0 = b.z(q0);
            if(playableData0 != null) {
                uri0 = playableData0.n;
            }
            return new Default(uri0);
        }
        PlayableData playableData1 = b.z(q0);
        if(playableData1 != null) {
            uri0 = playableData1.n;
        }
        return new Default(uri0);
    }

    @NotNull
    public final StateFlow getBgDataStateFlow() {
        return this.j;
    }

    @Nullable
    public final DjMalrangInfo getCurrentPlaylistDJMalrangInfo() {
        w w0 = ((d3)this.b).k();
        if(w0 != null) {
            Q q0 = w0.getState();
            if(q0 != null) {
                z0 z00 = q0 instanceof z0 ? ((z0)q0) : null;
                c c0 = z00 == null ? null : z00.c;
                return c0 instanceof DjMalrangInfo ? ((DjMalrangInfo)c0) : null;
            }
        }
        return null;
    }

    @NotNull
    public final k getLoginUseCase() {
        return this.d;
    }

    @NotNull
    public final StateFlow getMixUpIsDjMalrangStateFlow() {
        return this.i;
    }

    @NotNull
    public final z getPlayerUseCase() {
        return this.c;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        return this.b;
    }

    @NotNull
    public final StateFlow getPositionStateFlow() {
        return this.g;
    }

    @NotNull
    public final d getStringProvider() {
        return this.a;
    }

    @NotNull
    public final StateFlow getThumbnailUriStateFlow() {
        return this.f;
    }

    public final boolean isDjLoginUser() {
        return ((e0)this.d).j().getIsDj();
    }

    public final boolean isLoginUser() {
        return ((e0)this.d).m();
    }

    @NotNull
    public final StateFlow isPlayingStateFlow() {
        return this.h;
    }

    @Override  // com.melon.ui.n0
    public void onUserEvent(@NotNull e e0) {
        q.g(e0, "userEvent");
        super.onUserEvent(e0);
        if(e0 instanceof ClickPlayPauseButton) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new PlaylistMainViewModel.onClickPlayPauseButton.1(this, null), 3, null);
            return;
        }
        if(e0 instanceof ClickPrevButton) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new PlaylistMainViewModel.onClickPrevButton.1(this, null), 3, null);
            return;
        }
        if(e0 instanceof ClickNextButton) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new PlaylistMainViewModel.onClickNextButton.1(this, null), 3, null);
            return;
        }
        z z0 = this.c;
        if(e0 instanceof LongClickPrevButton) {
            z0.y(((LongClickPrevButton)e0).getRepCnt(), ((LongClickPrevButton)e0).getHowLong());
            return;
        }
        if(e0 instanceof LongClickNextButton) {
            z0.c(((LongClickNextButton)e0).getRepCnt(), ((LongClickNextButton)e0).getHowLong());
            return;
        }
        if(e0 instanceof ClickAlbumArtButton) {
            w w0 = ((d3)this.b).k();
            if(w0 != null) {
                Q q0 = w0.getState();
                if(q0 != null && !b.D(q0)) {
                    Navigator.openNowPlayer$default(Navigator.INSTANCE, 0, 1, null);
                }
            }
        }
        else if(e0 instanceof N3) {
            a a0 = f0.h(this);
            boolean z1 = this.isLoginUser();
            com.iloen.melon.player.playlist.PlaylistMainViewModel.onUserEvent.1 playlistMainViewModel$onUserEvent$10 = new we.k(0, PlaylistMainViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((PlaylistMainViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l00 = this.getProgressUpdater();
            this.e.b(((N3)e0), a0, z1, playlistMainViewModel$onUserEvent$10, l00);
        }
    }
}

