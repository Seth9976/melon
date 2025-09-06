package com.iloen.melon.player.playlist.music;

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
import com.melon.ui.U1;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
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

public final class f implements k {
    public final MusicPlaylistBaseFragment a;
    public final Playable b;
    public final Playable c;
    public final b d;

    public f(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, Playable playable0, Playable playable1, b b0) {
        this.a = musicPlaylistBaseFragment0;
        this.b = playable0;
        this.c = playable1;
        this.d = b0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        k2 k20 = (k2)object0;
        MusicPlaylistBaseFragment musicPlaylistBaseFragment0 = this.a;
        Playable playable0 = this.b;
        if(k20 instanceof I1) {
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendInfoLikeClickLog(((I1)k20).a, playable0);
            return H.a;
        }
        Playable playable1 = this.c;
        if(k20 instanceof B1) {
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendDeleteClickLog(playable0);
            MusicPlaylistBaseFragment.access$getViewModel(musicPlaylistBaseFragment0).deletePlayable(playable1);
            return H.a;
        }
        b b0 = this.d;
        if(k20 instanceof f2) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.1(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendSongInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof w1) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.2(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendAlbumInfoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof x1) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.3(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendArtistChannelClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof N1) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.4(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendMusicVideoClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof E1) {
            playable1.setDownloadOrigin(1);
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.5(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendDownloadClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof U1) {
            musicPlaylistBaseFragment0.sendUserEvent(new ClickPutInMorePopupUserEvent(playable1));
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendPutClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof H1) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.6(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendKakaoProfileClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof c2) {
            MusicPlaylistBaseFragment.access$getSharedViewModel(musicPlaylistBaseFragment0).handleActivityResultEvent(new SharePlayable(playable0));
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendInfoShareClickLog(playable1);
            return H.a;
        }
        if(k20 instanceof e2) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.7(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendSimilarSongClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof i2) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.8(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.sendUserEvent(new a("playlistSongTiktok"));
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendTikTokClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof M1) {
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            musicPlaylistBaseFragment0.sendUserEvent(new i("1000000558", new l1("", "", playable1.getArtistid(), null)));
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendPlayMixUpClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof L1) {
            musicPlaylistBaseFragment0.handleMoreListPopupOnEvent(musicPlaylistBaseFragment0, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.showMorePopup.1.1.9(1, 0, MusicPlaylistBaseFragment.class, musicPlaylistBaseFragment0, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"), b0, k20);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendLyricDownloadClickLog(playable0);
            return H.a;
        }
        if(k20 instanceof K1) {
            M m0 = ((K1)k20).b.a;
            if(m0 == M.T) {
                musicPlaylistBaseFragment0.sendUserEvent(new q3("M20001", e.k.z(playable1), ""));
            }
            else if(m0 == M.W) {
                musicPlaylistBaseFragment0.sendUserEvent(new q3("M20002", e.k.z(playable1), ""));
            }
            musicPlaylistBaseFragment0.getTiaraLogHelper().sendPutClickLog(playable0);
            return H.a;
        }
        LogU.warn$default(musicPlaylistBaseFragment0.getLog(), "ContextPopupMore Ignored: " + Cb.i.o(k20), null, false, 6, null);
        return H.a;
    }
}

