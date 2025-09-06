package com.iloen.melon.player.playlist;

import androidx.compose.runtime.l;
import e1.x;
import ie.H;
import r0.q;
import we.n;

public final class b implements n {
    public final int a;
    public final q b;
    public final String c;
    public final int d;
    public final int e;

    public b(q q0, String s, int v, int v1, int v2) {
        this.a = v2;
        this.b = q0;
        this.c = s;
        this.d = v;
        this.e = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            x.r(this.b, this.c, ((l)object0), this.d, (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
            return H.a;
        }
        ((Integer)object1).intValue();
        PlaylistMainComposablesKt.a(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
        return H.a;
    }
}

