package H;

import A7.d;
import F.g;
import K.l;
import N0.v;
import P0.h;
import P0.i;
import P0.j;
import U.A;
import U.T;
import U.b0;
import U.f0;
import Y.Q;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.w;
import b0.E;
import b0.N;
import f1.p;
import f1.x;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import r1.c;
import we.a;
import we.k;
import we.n;

public final class b extends r implements n {
    public final int f;
    public final boolean g;
    public final int h;
    public final Object i;
    public final Object j;
    public final Object k;
    public final Object l;
    public final Object m;
    public final Object n;

    public b(H.n n0, a a0, g g0, q q0, boolean z, a a1, m0.b b0, int v) {
        this.f = 0;
        this.i = n0;
        this.j = a0;
        this.l = g0;
        this.m = q0;
        this.g = z;
        this.k = a1;
        this.n = b0;
        this.h = v;
        super(2);
    }

    public b(Q q0, f0 f00, boolean z, k k0, x x0, p p0, c c0, int v) {
        this.f = 1;
        this.i = q0;
        this.j = f00;
        this.g = z;
        this.k = k0;
        this.l = x0;
        this.m = p0;
        this.n = c0;
        this.h = v;
        super(2);
    }

    public b(b0.Q q0, q q1, boolean z, E e0, l l0, m0.b b0, m0.b b1, int v) {
        this.f = 2;
        this.i = q0;
        this.m = q1;
        this.g = z;
        this.j = e0;
        this.k = l0;
        this.n = b0;
        this.l = b1;
        this.h = v;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                Q1.c.d(((H.n)this.i), ((a)this.j), ((g)this.l), ((q)this.m), this.g, ((a)this.k), ((m0.b)this.n), ((androidx.compose.runtime.l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
            case 1: {
                int v = ((Number)object1).intValue();
                Q q0 = (Q)this.i;
                f0 f00 = (f0)this.j;
                boolean z = true;
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((androidx.compose.runtime.l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    A a0 = new A(f00, ((k)this.k), ((x)this.l), ((p)this.m), ((c)this.n), this.h);
                    int v1 = p0.P;
                    i0 i00 = p0.m();
                    q q1 = r0.a.d(p0, r0.n.a);
                    P0.k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, a0, j.f);
                    w.x(p0, i00, j.e);
                    h h0 = j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                        d.q(v1, p0, v1, h0);
                    }
                    w.x(p0, q1, j.d);
                    p0.p(true);
                    T t0 = f00.a();
                    boolean z1 = this.g;
                    if(t0 == T.a || f00.c() == null) {
                        z = false;
                    }
                    else {
                        v v2 = f00.c();
                        kotlin.jvm.internal.q.d(v2);
                        if(!v2.h() || !z1) {
                            z = false;
                        }
                    }
                    b0.j(q0, z, p0, 0);
                    if(f00.a() == T.c && z1) {
                        p0.a0(0xFF92A08E);
                        b0.i(q0, p0, 0);
                        p0.p(false);
                        return H.a;
                    }
                    p0.a0(-7090978);
                    p0.p(false);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                N.b(((b0.Q)this.i), ((q)this.m), this.g, ((E)this.j), ((l)this.k), ((m0.b)this.n), ((m0.b)this.l), ((androidx.compose.runtime.l)object0), (this.h | 1) & -920350135 | ((0x24924924 & (this.h | 1)) >> 1 | 306783378 & (this.h | 1)) | (306783378 & (this.h | 1)) << 1 & (0x24924924 & (this.h | 1)));
                return H.a;
            }
        }
    }
}

