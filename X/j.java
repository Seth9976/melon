package X;

import a1.P;
import a1.Q;
import a1.U;
import a1.g;
import a1.y;
import e1.i;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import r1.c;
import r1.m;
import we.k;
import y0.s;
import y0.u;

public final class j extends r implements k {
    public final int f;
    public final l g;

    public j(l l0, int v) {
        this.f = v;
        this.g = l0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Q q1;
        switch(this.f) {
            case 0: {
                e e0 = this.g.n0();
                u u0 = this.g.h;
                U u1 = U.e(this.g.b, (u0 == null ? s.g : u0.invoke-0d7_KjU()), 0L, null, null, 0L, 0, 0L, 0xFFFFFE);
                m m0 = e0.o;
                Q q0 = null;
                if(m0 == null) {
                    q1 = null;
                }
                else {
                    c c0 = e0.i;
                    if(c0 == null) {
                        q1 = null;
                    }
                    else {
                        g g0 = new g(e0.a);
                        if(e0.j == null || e0.n == null) {
                            q1 = null;
                        }
                        else {
                            long v = e0.p & 0xFFFFFFFE00000003L;
                            i i1 = e0.c;
                            q1 = new Q(new P(g0, u1, w.a, e0.f, e0.e, e0.d, c0, m0, i1, v), new y(new H8.i(g0, u1, w.a, c0, i1), v, e0.f, e0.d), e0.l);
                        }
                    }
                }
                if(q1 != null) {
                    ((List)object0).add(q1);
                    q0 = q1;
                }
                return q0 == null ? false : true;
            }
            case 1: {
                String s = ((g)object0).b;
                l l1 = this.g;
                X.i i2 = l1.l;
                if(i2 == null) {
                    X.i i3 = new X.i(l1.a, s);
                    e e2 = new e(s, l1.b, l1.c, l1.d, l1.e, l1.f, l1.g);
                    e2.c(l1.n0().i);
                    i3.d = e2;
                    l1.l = i3;
                }
                else if(!q.b(s, i2.b)) {
                    i2.b = s;
                    e e1 = i2.d;
                    if(e1 != null) {
                        e1.a = s;
                        e1.b = l1.b;
                        e1.c = l1.c;
                        e1.d = l1.d;
                        e1.e = l1.e;
                        e1.f = l1.f;
                        e1.g = l1.g;
                        e1.b();
                    }
                }
                l.m0(l1);
                return true;
            }
            default: {
                boolean z = ((Boolean)object0).booleanValue();
                l l0 = this.g;
                X.i i0 = l0.l;
                if(i0 == null) {
                    return false;
                }
                i0.c = z;
                l.m0(l0);
                return true;
            }
        }
    }
}

