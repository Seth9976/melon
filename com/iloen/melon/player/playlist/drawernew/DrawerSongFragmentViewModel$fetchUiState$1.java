package com.iloen.melon.player.playlist.drawernew;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import nc.C0;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel", f = "DrawerSongFragmentViewModel.kt", l = {452, 454, 0x1D0, 468}, m = "fetchUiState")
final class DrawerSongFragmentViewModel.fetchUiState.1 extends c {
    public final DrawerSongFragmentViewModel B;
    public int D;
    public C0 r;
    public Object w;

    public DrawerSongFragmentViewModel.fetchUiState.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
        this.B = drawerSongFragmentViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return DrawerSongFragmentViewModel.access$fetchUiState(this.B, this);
    }
}

