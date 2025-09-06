package com.iloen.melon.player.playlist.common.scrollbar;

import K.l;
import ie.H;
import r0.q;
import we.k;
import we.n;

public final class c implements n {
    public final int a;
    public final ScrollbarState b;
    public final q c;
    public final l d;
    public final float e;
    public final k f;
    public final n g;
    public final int h;
    public final int i;

    public c(ScrollbarState scrollbarState0, q q0, l l0, float f, k k0, n n0, int v, int v1, int v2) {
        this.a = v2;
        this.b = scrollbarState0;
        this.c = q0;
        this.d = l0;
        this.e = f;
        this.f = k0;
        this.g = n0;
        this.h = v;
        this.i = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).intValue();
            ScrollbarKt.Scrollbar-jIwJxvA(this.b, this.c, this.d, this.e, this.f, this.g, ((androidx.compose.runtime.l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)), this.i);
            return H.a;
        }
        ((Integer)object1).intValue();
        ScrollbarKt.Scrollbar-jIwJxvA(this.b, this.c, this.d, this.e, this.f, this.g, ((androidx.compose.runtime.l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)), this.i);
        return H.a;
    }
}

