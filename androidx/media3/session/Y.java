package androidx.media3.session;

import b3.P;
import b3.m;
import e3.j;
import e3.k;

public final class y implements O, j, k {
    public final int a;
    public final Q b;

    public y(Q q0, int v) {
        this.a = v;
        this.b = q0;
        super();
    }

    @Override  // e3.k
    public void a(Object object0, m m0) {
        b3.O o0 = new b3.O(m0);
        ((P)object0).M(this.b.a, o0);
    }

    @Override  // androidx.media3.session.O
    public void d(androidx.media3.session.m m0, int v) {
        switch(this.a) {
            case 0: {
                m0.o(this.b.c, v);
                return;
            }
            case 1: {
                m0.p0(this.b.c, v);
                return;
            }
            case 2: {
                m0.m0(this.b.c, v);
                return;
            }
            case 3: {
                m0.B(this.b.c, v);
                return;
            }
            case 4: {
                m0.p(this.b.c, v);
                return;
            }
            case 5: {
                m0.n0(this.b.c, v);
                return;
            }
            case 6: {
                m0.w(this.b.c, v);
                return;
            }
            case 7: {
                m0.v(this.b.c, v);
                return;
            }
            case 8: {
                m0.h(this.b.c, v);
                return;
            }
            case 9: {
                m0.s0(this.b.c, v);
                return;
            }
            case 10: {
                m0.a(this.b.c, v);
                return;
            }
            case 11: {
                m0.d0(this.b.c, v);
                return;
            }
            case 13: {
                m0.u0(this.b.c, v);
                return;
            }
            default: {
                m0.b(this.b.c, v);
            }
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 14) {
            ((P)object0).n0(this.b.u);
            return;
        }
        ((P)object0).n0(this.b.u);
    }
}

