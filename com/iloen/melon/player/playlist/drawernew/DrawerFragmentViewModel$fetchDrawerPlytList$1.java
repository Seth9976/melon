package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel", f = "DrawerFragmentViewModel.kt", l = {339, 347, 358, 359, 360, 365}, m = "fetchDrawerPlytList")
final class DrawerFragmentViewModel.fetchDrawerPlytList.1 extends c {
    public DrawerFragmentViewModel B;
    public String D;
    public ResponseV6Res E;
    public Object G;
    public final DrawerFragmentViewModel I;
    public int M;
    public String r;
    public DrawerPlaylistInfo w;

    public DrawerFragmentViewModel.fetchDrawerPlytList.1(DrawerFragmentViewModel drawerFragmentViewModel0, Continuation continuation0) {
        this.I = drawerFragmentViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return DrawerFragmentViewModel.access$fetchDrawerPlytList(this.I, null, this);
    }
}

