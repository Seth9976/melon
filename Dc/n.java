package Dc;

import O.F;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import d9.h;
import h7.u0;
import ie.H;
import ie.f;
import java.util.List;
import m0.b;
import qd.I;
import qd.J;
import r0.q;
import we.k;

public final class n implements we.n {
    public final int a;
    public final q b;
    public final int c;
    public final boolean d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;
    public final f i;

    public n(a a0, u u0, Object object0, q q0, boolean z, g g0, b b0, int v) {
        this.a = 0;
        super();
        this.e = a0;
        this.f = u0;
        this.g = object0;
        this.b = q0;
        this.d = z;
        this.h = g0;
        this.i = b0;
        this.c = v;
    }

    public n(q q0, F f0, List list0, J j0, int v, boolean z, h h0, k k0, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.e = f0;
        this.f = list0;
        this.g = j0;
        this.c = v;
        this.d = z;
        this.h = h0;
        this.i = k0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            I.c(this.b, ((F)this.e), ((List)this.f), ((J)this.g), this.c, this.d, ((h)this.h), ((k)this.i), ((l)object0), 1);
            return H.a;
        }
        ((Integer)object1).getClass();
        u0.e(((a)this.e), ((u)this.f), this.g, this.b, this.d, ((g)this.h), ((b)this.i), ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)));
        return H.a;
    }
}

