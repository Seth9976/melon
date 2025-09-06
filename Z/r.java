package Z;

import P0.f;
import a0.b;
import ie.H;
import we.a;
import y0.M;

public final class r extends kotlin.jvm.internal.r implements a {
    public final int f;
    public final s g;

    public r(s s0, int v) {
        this.f = v;
        this.g = s0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        s s0 = this.g;
        if(this.f != 0) {
            if(((F)f.i(s0, G.a)) == null) {
                b b0 = s0.h;
                if(b0 != null) {
                    s0.n0(b0);
                }
                s0.h = null;
                return H.a;
            }
            if(s0.h == null) {
                q q0 = new q(s0, 0);
                r r0 = new r(s0, 0);
                b b1 = new b(s0.d, s0.e, s0.f, q0, r0);
                s0.m0(b1);
                s0.h = b1;
            }
            return H.a;
        }
        F f0 = (F)f.i(s0, G.a);
        long v = ((y0.s)f.i(s0, i.a)).a;
        if(((e)f.i(s0, g.a)).d()) {
            return ((double)M.q(v)) > 0.5 ? G.c : G.d;
        }
        return G.e;
    }
}

