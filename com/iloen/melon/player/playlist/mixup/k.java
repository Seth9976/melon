package com.iloen.melon.player.playlist.mixup;

import Ed.a;
import O.F;
import androidx.compose.runtime.H;
import androidx.lifecycle.D;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel.NewActivityEvent.SharePlayable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.B1;
import com.melon.ui.E1;
import com.melon.ui.H1;
import com.melon.ui.I1;
import com.melon.ui.K1;
import com.melon.ui.L1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.U1;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.g;
import com.melon.ui.i2;
import com.melon.ui.i;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.b;
import com.melon.ui.q3;
import com.melon.ui.w1;
import com.melon.ui.x1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import pc.l1;
import zd.M;

public final class k implements we.k {
    public final int a;
    public final MixUpPlaylistComposeFragment b;
    public final Object c;
    public final Object d;
    public final Object e;

    public k(D d0, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, CoroutineScope coroutineScope0, F f0) {
        this.a = 1;
        super();
        this.c = d0;
        this.b = mixUpPlaylistComposeFragment0;
        this.d = coroutineScope0;
        this.e = f0;
    }

    public k(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, Playable playable0, b b0, Playable playable1) {
        this.a = 0;
        super();
        this.b = mixUpPlaylistComposeFragment0;
        this.c = playable0;
        this.e = b0;
        this.d = playable1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Object object1 = this.e;
        Object object2 = this.d;
        Object object3 = this.c;
        if(this.a != 0) {
            q.g(((H)object0), "$this$DisposableEffect");
            j j0 = new j(this.b, ((CoroutineScope)object2), ((F)object1));
            ((D)object3).getLifecycle().a(j0);
            return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.66.lambda.65..inlined.onDispose.1(((D)object3), j0);
        }
        k2 k20 = (k2)object0;
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        if(k20 instanceof I1) {
            mixUpPlaylistComposeFragment0.n().logClickLikeFromMorePopup(((I1)k20).a, ((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof B1) {
            MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).deletePlayable(((Playable)object3));
            mixUpPlaylistComposeFragment0.n().logClickDeleteFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof f2) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.1(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickSongInfoFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof w1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.2(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickAlbumInfoFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof x1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.3(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            MixUpPlaylistTiaraLogHelper.logClickArtistChannelFromMorePopup$default(mixUpPlaylistComposeFragment0.n(), ((Playable)object3), null, null, 6, null);
            return ie.H.a;
        }
        if(k20 instanceof N1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.4(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickMusicVideoFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof E1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.5(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickDownloadFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof U1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.6(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickPutFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof H1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.7(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickKakaoProfileFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof c2) {
            MixUpPlaylistComposeFragment.access$getSharedViewModel(mixUpPlaylistComposeFragment0).handleActivityResultEvent(new SharePlayable(((Playable)object3)));
            mixUpPlaylistComposeFragment0.n().logClickShareFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof e2) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.8(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickSimilarSongFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof i2) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.9(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.sendUserEvent(new a("playlistSongTiktok"));
            mixUpPlaylistComposeFragment0.n().logClickTikTokFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof M1) {
            String s = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMenuId();
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            mixUpPlaylistComposeFragment0.sendUserEvent(new i(s, new l1("", "", ((Playable)object2).getArtistid(), null)));
            mixUpPlaylistComposeFragment0.n().logClickMixUpFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof L1) {
            mixUpPlaylistComposeFragment0.handleMoreListPopupOnEvent(mixUpPlaylistComposeFragment0, new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.getClickListener.1.onMore.1.1.10(1, 0, MixUpPlaylistComposeFragment.class, mixUpPlaylistComposeFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), ((b)object1), k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            mixUpPlaylistComposeFragment0.n().logClickLyricDownloadFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.T) {
                mixUpPlaylistComposeFragment0.sendUserEvent(new q3("M20001", e.k.z(((Playable)object2)), ""));
            }
            else if(m0 == M.W) {
                mixUpPlaylistComposeFragment0.sendUserEvent(new q3("M20002", e.k.z(((Playable)object2)), ""));
            }
            else if(m0 == M.S) {
                mixUpPlaylistComposeFragment0.sendUserEvent(new g(e.k.z(((Playable)object2)), MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getMenuId()));
            }
            mixUpPlaylistComposeFragment0.n().logClickPutFromMorePopup(((Playable)object3));
            return ie.H.a;
        }
        LogU.warn$default(mixUpPlaylistComposeFragment0.j, "ContextPopupMore Ignored: " + Cb.i.o(k20), null, false, 6, null);
        return ie.H.a;
    }
}

