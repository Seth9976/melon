package J2;

import H0.e;
import androidx.compose.foundation.lazy.layout.F;
import androidx.compose.foundation.lazy.layout.j;
import androidx.compose.foundation.lazy.layout.v;
import androidx.compose.runtime.l;
import androidx.compose.ui.viewinterop.a;
import ie.H;
import kotlin.jvm.internal.r;
import m0.b;
import r0.q;
import we.k;
import we.n;
import we.o;

public final class f extends r implements n {
    public final int f;
    public final int g;
    public final int h;
    public final Object i;
    public final Object j;
    public final Object k;

    public f(int v, int v1, int v2, ie.f f0, Object object0, Object object1) {
        this.f = v2;
        this.i = object0;
        this.j = object1;
        this.k = f0;
        this.g = v;
        this.h = v1;
        super(2);
    }

    public f(v v0, Object object0, int v1, Object object1, int v2) {
        this.f = 1;
        this.i = v0;
        this.j = object0;
        this.g = v1;
        this.k = object1;
        this.h = v2;
        super(2);
    }

    public f(Object object0, int v, F f0, b b0, int v1) {
        this.f = 2;
        this.i = object0;
        this.g = v;
        this.j = f0;
        this.k = b0;
        this.h = v1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                e.a(((B2.n)this.i), ((c)this.j), ((b)this.k), ((l)object0), this.g | 1, this.h);
                return H.a;
            }
            case 1: {
                ((Number)object1).intValue();
                j.g(((v)this.i), this.j, this.g, this.k, ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 2: {
                ((Number)object1).intValue();
                j.e(this.i, this.g, ((F)this.j), ((b)this.k), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 3: {
                ((Number)object1).intValue();
                u1.j.a(((o)this.i), ((q)this.j), ((k)this.k), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                a.a(((k)this.i), ((q)this.j), ((k)this.k), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return H.a;
            }
        }
    }
}

