package com.iloen.melon.player.playlist.drawernew;

import androidx.lifecycle.f0;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import we.a;

public final class o implements a {
    public final int a;
    public final DrawerSongFragmentViewModel b;

    public o(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v) {
        this.a = v;
        this.b = drawerSongFragmentViewModel0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.toolBarEventHelper.2.1 drawerSongFragmentViewModel$toolBarEventHelper$2$10 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.toolBarEventHelper.2.1(1, 0, DrawerSongFragmentViewModel.class, this.b, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V");  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            return new Jd.a(this.b.i, drawerSongFragmentViewModel$toolBarEventHelper$2$10, null);
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(this.b), null, null, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onUserEvent.1.1(this.b, null), 3, null);
        return H.a;
    }
}

