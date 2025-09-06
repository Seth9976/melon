package com.iloen.melon.player.playlist.drawernew;

import android.net.Uri;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import nc.C0;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel", f = "DrawerSongFragmentViewModel.kt", l = {0x150, 356}, m = "convertPlayableListToUiStateList")
final class DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1 extends c {
    public Iterator B;
    public Uri D;
    public String E;
    public String G;
    public String I;
    public String M;
    public Collection N;
    public int S;
    public int T;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public boolean e0;
    public boolean f0;
    public Object g0;
    public final DrawerSongFragmentViewModel h0;
    public int i0;
    public C0 r;
    public Collection w;

    public DrawerSongFragmentViewModel.convertPlayableListToUiStateList.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
        this.h0 = drawerSongFragmentViewModel0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.g0 = object0;
        this.i0 |= 0x80000000;
        return DrawerSongFragmentViewModel.access$convertPlayableListToUiStateList(this.h0, null, this);
    }
}

