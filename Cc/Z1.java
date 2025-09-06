package Cc;

import I.Z;
import M.f;
import M.h;
import M.i0;
import M.j0;
import P.F;
import P.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import r0.q;
import we.k;
import we.n;

public final class z1 implements n {
    public final int a;
    public final a b;
    public final q c;
    public final F d;
    public final h e;
    public final f f;
    public final Z g;
    public final boolean h;
    public final k i;
    public final i0 j;

    public z1(a a0, q q0, F f0, i0 i00, h h0, f f1, Z z0, boolean z1, k k0) {
        this.a = 1;
        super();
        this.b = a0;
        this.c = q0;
        this.d = f0;
        this.j = i00;
        this.e = h0;
        this.f = f1;
        this.g = z0;
        this.h = z1;
        this.i = k0;
    }

    public z1(a a0, q q0, F f0, j0 j00, f f1, h h0, Z z0, boolean z1, k k0) {
        this.a = 0;
        super();
        this.b = a0;
        this.c = q0;
        this.d = f0;
        this.j = j00;
        this.f = f1;
        this.e = h0;
        this.g = z0;
        this.h = z1;
        this.i = k0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                E9.h.i(this.b, this.c, this.d, this.j, this.e, this.f, this.g, this.h, null, this.i, ((p)(((l)object0))), 0, 0x200);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        j0 j00 = (j0)this.j;
        int v1 = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
            E9.h.h(this.b, this.c, this.d, j00, this.f, this.e, this.g, this.h, null, this.i, ((p)(((l)object0))), 0, 0, 0x200);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

