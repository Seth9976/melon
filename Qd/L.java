package qd;

import d3.g;
import e1.x;
import ie.H;
import r0.q;
import we.a;
import we.n;

public final class l implements n {
    public final int a;
    public final q b;
    public final boolean c;
    public final int d;
    public final a e;
    public final a f;

    public l(q q0, boolean z, int v, a a0, a a1, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.c = z;
        this.d = v;
        this.e = a0;
        this.f = a1;
    }

    public l(q q0, boolean z, a a0, a a1, int v) {
        this.a = 0;
        super();
        this.b = q0;
        this.c = z;
        this.e = a0;
        this.f = a1;
        this.d = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            g.l(this.b, this.c, this.d, this.e, this.f, ((androidx.compose.runtime.l)object0), 1);
            return H.a;
        }
        ((Integer)object1).getClass();
        x.t(this.b, this.c, this.e, this.f, ((androidx.compose.runtime.l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
        return H.a;
    }
}

