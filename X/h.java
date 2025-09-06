package X;

import A0.e;
import De.w;
import F.B;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.K;
import P0.z0;
import P0.z;
import U.b0;
import U4.F;
import X0.a;
import X0.x;
import a1.M;
import a1.Q;
import a1.U;
import a1.g;
import a1.y;
import e1.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l1.l;
import r0.p;
import r1.m;
import we.k;
import x0.c;
import y0.P;
import y0.o;
import y0.q;
import y0.s;
import y0.u;

public final class h extends p implements P0.p, z0, z {
    public g a;
    public U b;
    public i c;
    public k d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public List i;
    public k j;
    public u k;
    public k l;
    public Map m;
    public d n;
    public X.g o;
    public f r;

    @Override  // P0.p
    public final void draw(A0.d d0) {
        if(this.isAttached()) {
            q q0 = ((K)d0).a.b.h();
            Q q1 = this.o0(d0).n;
            if(q1 == null) {
                throw new IllegalStateException("You must call layoutWithConstraints first");
            }
            y y0 = q1.b;
            boolean z = q1.d() && this.e != 3;
            if(z) {
                c c0 = e.k.d(0L, ((long)Float.floatToRawIntBits(((int)(q1.c >> 0x20)))) << 0x20 | ((long)Float.floatToRawIntBits(((int)(q1.c & 0xFFFFFFFFL)))) & 0xFFFFFFFFL);
                q0.q();
                q.c(q0, c0);
            }
            try {
                M m0 = this.b.a;
                l l0 = m0.m == null ? l.b : m0.m;
                P p0 = m0.n == null ? P.d : m0.n;
                e e0 = m0.o;
                if(e0 == null) {
                    e0 = A0.h.b;
                }
                o o0 = m0.a.c();
                if(o0 == null) {
                    long v1 = this.k == null ? s.g : this.k.invoke-0d7_KjU();
                    if(v1 == 16L) {
                        v1 = this.b.b() == 16L ? s.b : this.b.b();
                    }
                    y.i(y0, q0, v1, p0, l0, e0);
                }
                else {
                    y.j(y0, q0, o0, this.b.a.a.a(), p0, l0, e0);
                }
            }
            finally {
                if(z) {
                    q0.j();
                }
            }
            if((this.r == null || !this.r.c ? V4.u.v(this.a) : false) || this.i != null && !this.i.isEmpty()) {
                ((K)d0).a();
            }
        }
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.z0
    public final void l(x x0) {
        X.g g0 = this.o;
        if(g0 == null) {
            g0 = new X.g(this, 0);
            this.o = g0;
        }
        List list0 = e.k.z(this.a);
        ((X0.l)x0).g(X0.s.y, list0);
        f f0 = this.r;
        if(f0 != null) {
            g g1 = f0.b;
            w w0 = X0.u.a[14];
            X0.s.z.a(x0, g1);
            boolean z = f0.c;
            w w1 = X0.u.a[15];
            X0.s.A.a(x0, Boolean.valueOf(z));
        }
        a a0 = new a(null, new X.g(this, 1));
        ((X0.l)x0).g(X0.k.k, a0);
        a a1 = new a(null, new X.g(this, 2));
        ((X0.l)x0).g(X0.k.l, a1);
        a a2 = new a(null, new B2.o(this, 29));
        ((X0.l)x0).g(X0.k.m, a2);
        X0.u.d(x0, g0);
    }

    public static final void m0(h h0) {
        P0.f.v(h0).E();
        P0.f.v(h0).D();
        P0.f.m(h0);
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(N0.q q0, N0.p p0, int v) {
        return this.o0(q0).a(v, q0.getLayoutDirection());
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(N0.q q0, N0.p p0, int v) {
        return b0.r(this.o0(q0).d(q0.getLayoutDirection()).c());
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        d d0 = this.o0(o0);
        m m0 = o0.getLayoutDirection();
        boolean z = true;
        if(d0.f > 1) {
            b b0 = d0.h;
            U u0 = d0.k;
            r1.c c0 = d0.j;
            kotlin.jvm.internal.q.d(c0);
            b b1 = F.t(b0, m0, u0, c0, d0.b);
            d0.h = b1;
            v = b1.a(d0.f, v);
        }
        Q q0 = d0.n;
        if(q0 == null || (q0.b.a.b() || (m0 != q0.a.h || !r1.a.b(v, q0.a.j) && (r1.a.h(v) != r1.a.h(q0.a.j) || r1.a.j(v) != r1.a.j(q0.a.j) || ((float)r1.a.g(v)) < q0.b.e || q0.b.c)))) {
            d0.n = d0.e(m0, v, d0.b(v, m0));
        }
        else {
            Q q1 = d0.n;
            kotlin.jvm.internal.q.d(q1);
            if(r1.a.b(v, q1.a.j)) {
                z = false;
            }
            else {
                Q q2 = d0.n;
                kotlin.jvm.internal.q.d(q2);
                d0.n = d0.e(m0, v, q2.b);
            }
        }
        Q q3 = d0.n;
        if(q3 == null) {
            throw new IllegalStateException("You must call layoutWithConstraints first");
        }
        long v1 = q3.c;
        q3.b.a.b();
        if(z) {
            P0.f.t(this, 2).Y0();
            k k0 = this.d;
            if(k0 != null) {
                k0.invoke(q3);
            }
            Map map0 = this.m;
            if(map0 == null) {
                map0 = new LinkedHashMap(2);
            }
            map0.put(N0.c.a, Math.round(q3.d));
            map0.put(N0.c.b, Math.round(q3.e));
            this.m = map0;
        }
        k k1 = this.j;
        if(k1 != null) {
            k1.invoke(q3.f);
        }
        int v2 = (int)(v1 >> 0x20);
        int v3 = (int)(v1 & 0xFFFFFFFFL);
        a0 a00 = l0.O(df.d.r(v2, v2, v3, v3));
        Map map1 = this.m;
        kotlin.jvm.internal.q.d(map1);
        return o0.w(v2, v3, map1, new B(a00, 11));
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(N0.q q0, N0.p p0, int v) {
        return this.o0(q0).a(v, q0.getLayoutDirection());
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(N0.q q0, N0.p p0, int v) {
        return b0.r(this.o0(q0).d(q0.getLayoutDirection()).d());
    }

    public final d n0() {
        if(this.n == null) {
            this.n = new d(this.a, this.b, this.c, this.e, this.f, this.g, this.h, this.i);
        }
        d d0 = this.n;
        kotlin.jvm.internal.q.d(d0);
        return d0;
    }

    public final d o0(r1.c c0) {
        f f0 = this.r;
        if(f0 != null && f0.c) {
            d d0 = f0.d;
            if(d0 != null) {
                d0.c(c0);
                return d0;
            }
        }
        d d1 = this.n0();
        d1.c(c0);
        return d1;
    }
}

