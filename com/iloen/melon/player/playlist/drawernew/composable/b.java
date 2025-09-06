package com.iloen.melon.player.playlist.drawernew.composable;

import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import r0.q;
import we.n;

public final class b implements n {
    public final q a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final int e;
    public final int f;
    public final List g;
    public final String h;
    public final int i;
    public final boolean j;
    public final int k;
    public final int l;

    public b(q q0, boolean z, boolean z1, String s, int v, int v1, List list0, String s1, int v2, boolean z2, int v3, int v4) {
        this.a = q0;
        this.b = z;
        this.c = z1;
        this.d = s;
        this.e = v;
        this.f = v1;
        this.g = list0;
        this.h = s1;
        this.i = v2;
        this.j = z2;
        this.k = v3;
        this.l = v4;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        DrawerPlytListItemKt.DrawerPlytPlytThumb(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, ((l)object0), (this.k | 1) & -920350135 | ((0x24924924 & (this.k | 1)) >> 1 | 306783378 & (this.k | 1)) | (306783378 & (this.k | 1)) << 1 & (0x24924924 & (this.k | 1)), this.l);
        return H.a;
    }
}

