package X;

import a1.P;
import a1.Q;
import a1.U;
import e1.i;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;
import y0.s;

public final class g extends r implements k {
    public final int f;
    public final h g;

    public g(h h0, int v) {
        this.f = v;
        this.g = h0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                h h1 = this.g;
                Q q0 = h1.n0().n;
                if(q0 != null) {
                    U u0 = h1.b;
                    long v = h1.k == null ? s.g : h1.k.invoke-0d7_KjU();
                    Q q1 = new Q(new P(q0.a.a, U.e(u0, v, 0L, null, null, 0L, 0, 0L, 0xFFFFFE), q0.a.c, q0.a.d, q0.a.e, q0.a.f, q0.a.g, q0.a.h, q0.a.i, q0.a.j), q0.b, q0.c);
                    ((List)object0).add(q1);
                    return q1 == null ? false : true;
                }
                return false;
            }
            case 1: {
                h h2 = this.g;
                f f2 = h2.r;
                w w0 = w.a;
                if(f2 == null) {
                    f f3 = new f(h2.a, ((a1.g)object0));
                    d d1 = new d(((a1.g)object0), h2.b, h2.c, h2.e, h2.f, h2.g, h2.h, w0);
                    d1.c(h2.n0().j);
                    f3.d = d1;
                    h2.r = f3;
                }
                else if(!q.b(((a1.g)object0), f2.b)) {
                    f2.b = (a1.g)object0;
                    d d0 = f2.d;
                    if(d0 != null) {
                        U u1 = h2.b;
                        i i0 = h2.c;
                        int v1 = h2.e;
                        boolean z1 = h2.f;
                        int v2 = h2.g;
                        int v3 = h2.h;
                        d0.a = (a1.g)object0;
                        boolean z2 = u1.c(d0.k);
                        d0.k = u1;
                        if(!z2) {
                            d0.l = null;
                            d0.n = null;
                            d0.p = -1;
                            d0.o = -1;
                        }
                        d0.b = i0;
                        d0.c = v1;
                        d0.d = z1;
                        d0.e = v2;
                        d0.f = v3;
                        d0.g = w0;
                        d0.l = null;
                        d0.n = null;
                        d0.p = -1;
                        d0.o = -1;
                    }
                }
                h.m0(h2);
                return true;
            }
            default: {
                boolean z = ((Boolean)object0).booleanValue();
                h h0 = this.g;
                f f0 = h0.r;
                if(f0 == null) {
                    return false;
                }
                k k0 = h0.l;
                if(k0 != null) {
                    k0.invoke(f0);
                }
                f f1 = h0.r;
                if(f1 != null) {
                    f1.c = z;
                }
                h.m0(h0);
                return true;
            }
        }
    }
}

