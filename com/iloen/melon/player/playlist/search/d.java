package com.iloen.melon.player.playlist.search;

import Ed.a;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel.NewActivityEvent.SharePlayable;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.B1;
import com.melon.ui.E1;
import com.melon.ui.H1;
import com.melon.ui.I1;
import com.melon.ui.L1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.U1;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.i2;
import com.melon.ui.i;
import com.melon.ui.k2;
import com.melon.ui.w1;
import com.melon.ui.x1;
import ie.H;
import kotlin.jvm.internal.q;
import pc.l1;
import we.k;
import zd.Q;

public final class d implements k {
    public final PlaylistSearchFragment a;
    public final Playable b;
    public final Q c;
    public final Playable d;

    public d(PlaylistSearchFragment playlistSearchFragment0, Playable playable0, Q q0, Playable playable1) {
        this.a = playlistSearchFragment0;
        this.b = playable0;
        this.c = q0;
        this.d = playable1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        k2 k20 = (k2)object0;
        PlaylistSearchFragment playlistSearchFragment0 = this.a;
        Playable playable0 = this.b;
        if(k20 instanceof I1) {
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendInfoLikeClickLog(((I1)k20).a, playable0);
            return H.a;
        }
        if(k20 instanceof B1) {
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendDeleteClickLog(playable0);
            PlaylistSearchFragment.access$getViewModel(playlistSearchFragment0).deletePlayable(playable0);
            return H.a;
        }
        Q q0 = this.c;
        if(k20 instanceof f2) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.1(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendSongInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof w1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.2(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendAlbumInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof x1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.3(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendArtistChannelClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof N1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.4(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendMusicVideoClickLog(playable0);
            return H.a;
        }
        Playable playable1 = this.d;
        if(k20 instanceof E1) {
            if(PlaylistSearchFragment.access$getViewModel(playlistSearchFragment0).isLocalDownloadablePlaylist()) {
                playable1.setDownloadOrigin(1);
            }
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.5(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendDownloadClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof U1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.6(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendPutClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof H1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.7(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendKakaoProfileClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof c2) {
            PlaylistSearchFragment.access$getSharedViewModel(playlistSearchFragment0).handleActivityResultEvent(new SharePlayable(playable0));
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendInfoShareClickLog(playable1);
            return H.a;
        }
        if(k20 instanceof e2) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.8(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendSimilarSongClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof i2) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.9(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            playlistSearchFragment0.sendUserEvent(new a("playlistSongTiktok"));
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendTikTokClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof M1) {
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            playlistSearchFragment0.sendUserEvent(new i("1000000558", new l1("", "", playable1.getArtistid(), null)));
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendPlayMixUpClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof L1) {
            playlistSearchFragment0.handleMoreListPopupOnEvent(playlistSearchFragment0, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.performShowMoreContextPopup.1.1.10(1, 0, PlaylistSearchFragment.class, playlistSearchFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), q0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendLyricDownloadClickLog(playable0);
            return H.a;
        }
        LogU.warn$default(playlistSearchFragment0.h, "ContextPopupMore Ignored: " + Cb.i.o(k20), null, false, 6, null);
        return H.a;
    }
}

