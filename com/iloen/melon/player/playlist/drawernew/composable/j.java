package com.iloen.melon.player.playlist.drawernew.composable;

import androidx.compose.runtime.l;
import ie.H;
import ie.s;
import java.util.List;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import we.a;
import we.k;
import we.n;

public final class j implements n {
    public final List a;
    public final boolean b;
    public final StateFlow c;
    public final s d;
    public final Flow e;
    public final k f;
    public final k g;
    public final k h;
    public final k i;
    public final n j;
    public final a k;
    public final n l;
    public final a m;
    public final int n;
    public final int o;
    public final int r;

    public j(List list0, boolean z, StateFlow stateFlow0, s s0, Flow flow0, k k0, k k1, k k2, k k3, n n0, a a0, n n1, a a1, int v, int v1, int v2) {
        this.a = list0;
        this.b = z;
        this.c = stateFlow0;
        this.d = s0;
        this.e = flow0;
        this.f = k0;
        this.g = k1;
        this.h = k2;
        this.i = k3;
        this.j = n0;
        this.k = a0;
        this.l = n1;
        this.m = a1;
        this.n = v;
        this.o = v1;
        this.r = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        DrawerSongListKt.DrawerSongList(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, ((l)object0), (this.n | 1) & -920350135 | ((0x24924924 & (this.n | 1)) >> 1 | 306783378 & (this.n | 1)) | (306783378 & (this.n | 1)) << 1 & (0x24924924 & (this.n | 1)), this.o & -920350135 | ((0x24924924 & this.o) >> 1 | 306783378 & this.o) | (306783378 & this.o) << 1 & (0x24924924 & this.o), this.r);
        return H.a;
    }
}

