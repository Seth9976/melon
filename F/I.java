package F;

import G.t0;
import H.c;
import androidx.compose.runtime.l;
import ie.H;
import kotlin.jvm.internal.r;
import m0.b;
import r0.q;
import u1.j;
import v1.p;
import we.a;
import we.k;
import we.n;
import we.o;

public final class i extends r implements n {
    public final int f;
    public final Object g;
    public final int h;
    public final Object i;
    public final Object j;
    public final Object k;

    public i(H.n n0, a a0, q q0, g g0, int v) {
        this.f = 1;
        this.i = n0;
        this.j = a0;
        this.g = q0;
        this.k = g0;
        this.h = v;
        super(2);
    }

    public i(Object object0, Object object1, Object object2, Object object3, int v, int v1) {
        this.f = v1;
        this.i = object0;
        this.g = object1;
        this.j = object2;
        this.k = object3;
        this.h = v;
        super(2);
    }

    public i(p p0, a a0, c c0, g g0, int v) {
        this.f = 2;
        this.i = p0;
        this.g = a0;
        this.j = c0;
        this.k = g0;
        this.h = v;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                androidx.compose.animation.a.a(((t0)this.i), ((q)this.g), ((k)this.j), ((k)this.k), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 1: {
                ((Number)object1).intValue();
                Q1.c.c(((H.n)this.i), ((a)this.j), ((q)this.g), ((g)this.k), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 2: {
                ((Number)object1).intValue();
                H.p.d(((p)this.i), ((a)this.g), ((c)this.j), ((g)this.k), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 3: {
                ((Number)object1).intValue();
                ((b)this.i).g(this.g, this.j, this.k, ((l)object0), this.h & -920350135 | ((0x24924924 & this.h) >> 1 | 306783378 & this.h) | (306783378 & this.h) << 1 & (0x24924924 & this.h) | 1);
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                j.b(((o)this.i), ((q)this.g), ((k)this.j), ((k)this.k), ((l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
        }
    }
}

