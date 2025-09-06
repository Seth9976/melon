package com.iloen.melon.player.playlist.drawernew.composable;

import androidx.compose.runtime.l;
import ie.H;
import r0.q;
import we.n;

public final class a implements n {
    public final int a;
    public final q b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final int f;
    public final int g;

    public a(q q0, String s, boolean z, boolean z1, int v, int v1) {
        this.a = 0;
        super();
        this.b = q0;
        this.d = s;
        this.c = z;
        this.e = z1;
        this.f = v;
        this.g = v1;
    }

    public a(q q0, boolean z, String s, boolean z1, int v, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.c = z;
        this.d = s;
        this.e = z1;
        this.f = v;
        this.g = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            e2.a.p(this.b, this.d, this.c, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)), this.g);
            return H.a;
        }
        ((Integer)object1).intValue();
        DrawerAlyacKt.DrawerAlyac(this.b, this.d, this.c, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)), this.g);
        return H.a;
    }
}

