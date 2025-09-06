package com.iloen.melon.player.playlist.music;

import androidx.lifecycle.f0;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class g implements a {
    public final int a;
    public final Object b;

    public g(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.toolBarEventHelper.2.1 musicPlaylistBaseViewModel$toolBarEventHelper$2$10 = new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.toolBarEventHelper.2.1(1, 0, MusicPlaylistBaseViewModel.class, ((MusicPlaylistBaseViewModel)object0), "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V");  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                return new Jd.a(((MusicPlaylistBaseViewModel)object0).f, musicPlaylistBaseViewModel$toolBarEventHelper$2$10, null);
            }
            case 1: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((MusicPlaylistBaseViewModel)object0)), null, null, new com.iloen.melon.player.playlist.music.MusicPlaylistBaseViewModel.onUserEvent.7.1(((MusicPlaylistBaseViewModel)object0), null), 3, null);
                return h0;
            }
            default: {
                Navigator.openChartMain();
                ((MusicPlaylistFragment)object0).getTiaraLogHelper().sendOpenMelonChartClickLog();
                return h0;
            }
        }
    }
}

