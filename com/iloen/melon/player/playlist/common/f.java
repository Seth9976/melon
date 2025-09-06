package com.iloen.melon.player.playlist.common;

import androidx.compose.runtime.l;
import e1.x;
import ie.H;
import ud.u;
import we.a;
import we.n;

public final class f implements n {
    public final int a;
    public final boolean b;
    public final a c;
    public final int d;

    public f(boolean z, a a0, int v, int v1) {
        this.a = v1;
        this.b = z;
        this.c = a0;
        this.d = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        switch(this.a) {
            case 0: {
                PlaylistCommonSongListComposableKt.Selector(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            case 1: {
                x.p(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            default: {
                u.h(this.b, this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
        }
    }
}

