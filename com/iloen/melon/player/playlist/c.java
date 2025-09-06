package com.iloen.melon.player.playlist;

import androidx.compose.runtime.l;
import ie.H;
import we.a;
import we.n;

public final class c implements n {
    public final int a;
    public final long b;
    public final long c;
    public final a d;
    public final a e;
    public final n f;
    public final boolean g;
    public final a h;
    public final a i;
    public final n j;
    public final String k;
    public final a l;
    public final int m;
    public final int n;
    public final int o;

    public c(long v, long v1, a a0, a a1, n n0, boolean z, a a2, a a3, n n1, String s, a a4, int v2, int v3, int v4, int v5) {
        this.a = v5;
        this.b = v;
        this.c = v1;
        this.d = a0;
        this.e = a1;
        this.f = n0;
        this.g = z;
        this.h = a2;
        this.i = a3;
        this.j = n1;
        this.k = s;
        this.l = a4;
        this.m = v2;
        this.n = v3;
        this.o = v4;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                PlaylistMainComposablesKt.PlaylistBottomController(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, ((l)object0), (this.m | 1) & -920350135 | ((0x24924924 & (this.m | 1)) >> 1 | 306783378 & (this.m | 1)) | (306783378 & (this.m | 1)) << 1 & (0x24924924 & (this.m | 1)), this.n & -920350135 | ((0x24924924 & this.n) >> 1 | 306783378 & this.n) | (306783378 & this.n) << 1 & (0x24924924 & this.n), this.o);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                PlaylistMainComposablesKt.PlaylistLandscapeBottomController(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, ((l)object0), (this.m | 1) & -920350135 | ((0x24924924 & (this.m | 1)) >> 1 | 306783378 & (this.m | 1)) | (306783378 & (this.m | 1)) << 1 & (0x24924924 & (this.m | 1)), this.n & -920350135 | ((0x24924924 & this.n) >> 1 | 306783378 & this.n) | (306783378 & this.n) << 1 & (0x24924924 & this.n), this.o);
                return H.a;
            }
            default: {
                ((Integer)object1).intValue();
                PlaylistMainComposablesKt.PlaylistPortraitBottomController(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, ((l)object0), (this.m | 1) & -920350135 | ((0x24924924 & (this.m | 1)) >> 1 | 306783378 & (this.m | 1)) | (306783378 & (this.m | 1)) << 1 & (0x24924924 & (this.m | 1)), this.n & -920350135 | ((0x24924924 & this.n) >> 1 | 306783378 & this.n) | (306783378 & this.n) << 1 & (0x24924924 & this.n), this.o);
                return H.a;
            }
        }
    }
}

