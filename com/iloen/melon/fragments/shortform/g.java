package com.iloen.melon.fragments.shortform;

import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kd.G;
import r0.q;
import we.n;

public final class g implements n {
    public final int a;
    public final List b;
    public final q c;
    public final int d;
    public final int e;

    public g(int v, List list0, q q0, int v1) {
        this.a = 2;
        super();
        this.d = v;
        this.b = list0;
        this.c = q0;
        this.e = v1;
    }

    public g(List list0, q q0, int v, int v1) {
        this.a = 1;
        super();
        this.b = list0;
        this.c = q0;
        this.d = v;
        this.e = v1;
    }

    public g(q q0, List list0, int v, int v1) {
        this.a = 0;
        super();
        this.c = q0;
        this.b = list0;
        this.d = v;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return TrendMusicWaveExclusiveFragmentKt.a(this.b, this.c, this.d, this.e, ((l)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                return TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout$lambda$18(this.b, this.c, this.d, this.e, ((l)object0), ((int)(((Integer)object1))));
            }
            default: {
                ((Integer)object1).getClass();
                G.o(this.b, this.c, ((l)object0), this.d, (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
        }
    }
}

