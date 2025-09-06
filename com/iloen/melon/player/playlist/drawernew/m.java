package com.iloen.melon.player.playlist.drawernew;

import Ed.a;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel.NewActivityEvent.SharePlayable;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.B1;
import com.melon.ui.E1;
import com.melon.ui.H1;
import com.melon.ui.I1;
import com.melon.ui.K1;
import com.melon.ui.L1;
import com.melon.ui.M1;
import com.melon.ui.N1;
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
import ie.H;
import kotlin.jvm.internal.q;
import pc.l1;
import we.k;
import zd.M;

public final class m implements k {
    public final DrawerSongFragment a;
    public final Playable b;
    public final int c;
    public final b d;
    public final Playable e;

    public m(DrawerSongFragment drawerSongFragment0, Playable playable0, int v, b b0, Playable playable1) {
        this.a = drawerSongFragment0;
        this.b = playable0;
        this.c = v;
        this.d = b0;
        this.e = playable1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        k2 k20 = (k2)object0;
        DrawerSongFragment drawerSongFragment0 = this.a;
        Playable playable0 = this.b;
        if(k20 instanceof I1) {
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendInfoLikeClickLog(((I1)k20).a, playable0);
            return H.a;
        }
        if(k20 instanceof B1) {
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendDeleteClickLog(playable0);
            DrawerSongFragment.access$getViewModel(drawerSongFragment0).deleteIndices(e.k.z(this.c));
            return H.a;
        }
        b b0 = this.d;
        if(k20 instanceof f2) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.1(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendSongInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof w1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.2(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendAlbumInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof x1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.3(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendArtistChannelClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof N1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.4(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendMusicVideoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof E1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.5(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendDownloadClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof H1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.6(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendKakaoProfileClickLog(playable0);
            return H.a;
        }
        Playable playable1 = this.e;
        if(k20 instanceof c2) {
            DrawerSongFragment.access$getSharedViewModel(drawerSongFragment0).handleActivityResultEvent(new SharePlayable(playable0));
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendInfoShareClickLog(playable1);
            return H.a;
        }
        if(k20 instanceof e2) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.7(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendSimilarSongClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof i2) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.8(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            drawerSongFragment0.sendUserEvent(new a("playlistSongTiktok"));
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendTikTokClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof M1) {
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            drawerSongFragment0.sendUserEvent(new i("1000000558", new l1("", "", playable1.getArtistid(), null)));
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendPlayMixUpClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof L1) {
            drawerSongFragment0.handleMoreListPopupOnEvent(drawerSongFragment0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.showMorePopup.1.1.9(1, 0, DrawerSongFragment.class, drawerSongFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendLyricDownloadClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.T) {
                drawerSongFragment0.sendUserEvent(new q3("M20001", e.k.z(playable1), ""));
            }
            else if(m0 == M.W) {
                drawerSongFragment0.sendUserEvent(new q3("M20002", e.k.z(playable1), ""));
            }
            else if(m0 == M.S) {
                drawerSongFragment0.sendUserEvent(new g(e.k.z(playable1), DrawerSongFragment.access$getViewModel(drawerSongFragment0).getMenuId()));
            }
            DrawerSongFragment.access$getTiaraLogHelper(drawerSongFragment0).sendPutClickLog(playable0);
            return H.a;
        }
        LogU.warn$default(drawerSongFragment0.g, "ContextPopupMore Ignored: " + Cb.i.o(k20), null, false, 6, null);
        return H.a;
    }
}

