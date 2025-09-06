package com.iloen.melon.player.playlist.drawernew.composable;

import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import r0.q;
import we.k;
import we.n;

public final class e implements n {
    public final q a;
    public final List b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final k g;
    public final k h;
    public final int i;
    public final int j;

    public e(q q0, List list0, String s, boolean z, boolean z1, String s1, k k0, k k1, int v, int v1) {
        this.a = q0;
        this.b = list0;
        this.c = s;
        this.d = z;
        this.e = z1;
        this.f = s1;
        this.g = k0;
        this.h = k1;
        this.i = v;
        this.j = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        DrawerPlytListKt.DrawerPlytPlyt(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, ((l)object0), (this.i | 1) & -920350135 | ((0x24924924 & (this.i | 1)) >> 1 | 306783378 & (this.i | 1)) | (306783378 & (this.i | 1)) << 1 & (0x24924924 & (this.i | 1)), this.j);
        return H.a;
    }
}

