package Cc;

import I.Z;
import M.h;
import M.i0;
import O.F;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import r0.g;
import r0.q;
import we.k;
import we.n;
import ye.a;

public final class x1 implements n {
    public final q a;
    public final F b;
    public final i0 c;
    public final boolean d;
    public final h e;
    public final g f;
    public final Z g;
    public final boolean h;
    public final k i;

    public x1(q q0, F f0, i0 i00, boolean z, h h0, g g0, Z z1, boolean z2, k k0) {
        this.a = q0;
        this.b = f0;
        this.c = i00;
        this.d = z;
        this.e = h0;
        this.f = g0;
        this.g = z1;
        this.h = z2;
        this.i = k0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            a.i(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null, this.i, ((p)(((l)object0))), 0, 0x100);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

