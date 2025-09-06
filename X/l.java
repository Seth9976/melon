package X;

import A0.d;
import A0.h;
import De.w;
import F.B;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.K;
import P0.f;
import P0.z0;
import P0.z;
import Q1.c;
import U.b0;
import X0.x;
import a1.C;
import a1.M;
import a1.U;
import a1.a;
import a1.g;
import e.k;
import e1.i;
import i.n.i.b.a.s.e.M3;
import java.util.HashMap;
import java.util.List;
import r0.p;
import r1.b;
import r1.m;
import y0.P;
import y0.o;
import y0.q;
import y0.s;
import y0.u;

public final class l extends p implements P0.p, z0, z {
    public String a;
    public U b;
    public i c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public u h;
    public HashMap i;
    public e j;
    public j k;
    public X.i l;

    @Override  // P0.p
    public final void draw(d d0) {
        e e0;
        if(this.isAttached()) {
            X.i i0 = this.l;
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                if(!i0.c) {
                    i0 = null;
                }
                if(i0 == null) {
                    e0 = this.n0();
                }
                else {
                    e0 = i0.d;
                    if(e0 == null) {
                        e0 = this.n0();
                    }
                }
            }
            a a0 = e0.j;
            if(a0 == null) {
                L.a.b(("no paragraph (layoutCache=" + this.j + ", textSubstitution=" + this.l + ')'));
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            q q0 = ((K)d0).a.b.h();
            boolean z = e0.k;
            if(z) {
                float f = (float)(((int)(e0.l >> 0x20)));
                float f1 = (float)(((int)(e0.l & 0xFFFFFFFFL)));
                q0.q();
                q0.h(0.0f, 0.0f, f, f1, 1);
            }
            try {
                M m0 = this.b.a;
                l1.l l0 = m0.m == null ? l1.l.b : m0.m;
                P p0 = m0.n == null ? P.d : m0.n;
                A0.e e1 = m0.o;
                if(e1 == null) {
                    e1 = h.b;
                }
                o o0 = m0.a.c();
                if(o0 == null) {
                    long v = this.h == null ? s.g : this.h.invoke-0d7_KjU();
                    if(v == 16L) {
                        v = this.b.b() == 16L ? s.b : this.b.b();
                    }
                    a0.f(q0, v, p0, l0, e1);
                }
                else {
                    a0.g(q0, o0, this.b.a.a.a(), p0, l0, e1);
                    goto label_41;
                label_38:
                    if(!z) {
                        throw throwable0;
                    }
                    goto label_39;
                }
                goto label_41;
            }
            catch(Throwable throwable0) {
                goto label_38;
            }
        label_39:
            q0.j();
            throw throwable0;
        label_41:
            if(z) {
                q0.j();
            }
        }
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.z0
    public final void l(x x0) {
        j j0 = this.k;
        if(j0 == null) {
            j0 = new j(this, 0);
            this.k = j0;
        }
        List list0 = k.z(new g(this.a));
        ((X0.l)x0).g(X0.s.y, list0);
        X.i i0 = this.l;
        if(i0 != null) {
            boolean z = i0.c;
            w w0 = X0.u.a[15];
            X0.s.A.a(x0, Boolean.valueOf(z));
            g g0 = new g(i0.b);
            w w1 = X0.u.a[14];
            X0.s.z.a(x0, g0);
        }
        X0.a a0 = new X0.a(null, new j(this, 1));
        ((X0.l)x0).g(X0.k.k, a0);
        X0.a a1 = new X0.a(null, new j(this, 2));
        ((X0.l)x0).g(X0.k.l, a1);
        X0.a a2 = new X0.a(null, new X.k(this, 0));
        ((X0.l)x0).g(X0.k.m, a2);
        X0.u.d(x0, j0);
    }

    public static final void m0(l l0) {
        f.v(l0).E();
        f.v(l0).D();
        f.m(l0);
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(N0.q q0, N0.p p0, int v) {
        e e0;
        X.i i0 = this.l;
        if(i0 == null) {
            e0 = this.n0();
        }
        else {
            if(!i0.c) {
                i0 = null;
            }
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                e0 = i0.d;
                if(e0 == null) {
                    e0 = this.n0();
                }
            }
        }
        e0.c(((O)q0));
        return e0.a(v, q0.getLayoutDirection());
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(N0.q q0, N0.p p0, int v) {
        e e0;
        X.i i0 = this.l;
        if(i0 == null) {
            e0 = this.n0();
        }
        else {
            if(!i0.c) {
                i0 = null;
            }
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                e0 = i0.d;
                if(e0 == null) {
                    e0 = this.n0();
                }
            }
        }
        e0.c(((O)q0));
        return b0.r(e0.d(q0.getLayoutDirection()).c());
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        boolean z;
        int v6;
        e e0;
        X.i i0 = this.l;
        if(i0 == null) {
            e0 = this.n0();
        }
        else {
            if(!i0.c) {
                i0 = null;
            }
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                e0 = i0.d;
                if(e0 == null) {
                    e0 = this.n0();
                }
            }
        }
        e0.c(o0);
        m m0 = o0.getLayoutDirection();
        long v1 = e0.g <= 1 ? v : e.e(e0, v, m0);
        a a0 = e0.j;
        if(a0 == null || (e0.n == null || e0.n.b() || m0 != e0.o || !r1.a.b(v1, e0.p) && (r1.a.h(v1) != r1.a.h(e0.p) || r1.a.j(v1) != r1.a.j(e0.p) || ((float)r1.a.g(v1)) < a0.b() || a0.d.d))) {
            C c0 = e0.d(m0);
            long v3 = c.w(v1, e0.e, e0.d, c0.c());
            int v4 = e0.d;
            int v5 = e0.f;
            if(!e0.e && (v4 == 2 || v4 == 4 || v4 == 5)) {
                v6 = 1;
            }
            else if(v5 >= 1) {
                v6 = v5;
            }
            else {
                v6 = 1;
            }
            a a2 = new a(((i1.c)c0), v6, v4, v3);
            e0.p = v1;
            long v7 = b.d(v1, ((long)b0.r(a2.b())) & 0xFFFFFFFFL | ((long)b0.r(a2.d())) << 0x20);
            e0.l = v7;
            e0.k = e0.d != 3 && (((float)(((int)(v7 >> 0x20)))) < a2.d() || ((float)(((int)(v7 & 0xFFFFFFFFL)))) < a2.b());
            e0.j = a2;
            z = true;
        }
        else {
            if(!r1.a.b(v1, e0.p)) {
                a a1 = e0.j;
                kotlin.jvm.internal.q.d(a1);
                float f = a1.a.i.c();
                long v2 = b.d(v1, ((long)b0.r(a1.b())) & 0xFFFFFFFFL | ((long)b0.r(Math.min(f, a1.d()))) << 0x20);
                e0.l = v2;
                e0.k = e0.d != 3 && (((float)(((int)(v2 >> 0x20)))) < a1.d() || ((float)(((int)(v2 & 0xFFFFFFFFL)))) < a1.b());
                e0.p = v1;
            }
            z = false;
        }
        C c1 = e0.n;
        if(c1 != null) {
            c1.b();
        }
        a a3 = e0.j;
        kotlin.jvm.internal.q.d(a3);
        b1.i i1 = a3.d;
        long v8 = e0.l;
        if(z) {
            f.t(this, 2).Y0();
            HashMap hashMap0 = this.i;
            if(hashMap0 == null) {
                hashMap0 = new HashMap(2);
                this.i = hashMap0;
            }
            Integer integer0 = Math.round(i1.d(0));
            hashMap0.put(N0.c.a, integer0);
            Integer integer1 = Math.round(i1.d(i1.g - 1));
            hashMap0.put(N0.c.b, integer1);
        }
        int v9 = (int)(v8 >> 0x20);
        int v10 = (int)(v8 & 0xFFFFFFFFL);
        a0 a00 = l0.O(df.d.r(v9, v9, v10, v10));
        HashMap hashMap1 = this.i;
        kotlin.jvm.internal.q.d(hashMap1);
        return o0.w(v9, v10, hashMap1, new B(a00, 12));
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(N0.q q0, N0.p p0, int v) {
        e e0;
        X.i i0 = this.l;
        if(i0 == null) {
            e0 = this.n0();
        }
        else {
            if(!i0.c) {
                i0 = null;
            }
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                e0 = i0.d;
                if(e0 == null) {
                    e0 = this.n0();
                }
            }
        }
        e0.c(((O)q0));
        return e0.a(v, q0.getLayoutDirection());
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(N0.q q0, N0.p p0, int v) {
        e e0;
        X.i i0 = this.l;
        if(i0 == null) {
            e0 = this.n0();
        }
        else {
            if(!i0.c) {
                i0 = null;
            }
            if(i0 == null) {
                e0 = this.n0();
            }
            else {
                e0 = i0.d;
                if(e0 == null) {
                    e0 = this.n0();
                }
            }
        }
        e0.c(((O)q0));
        return b0.r(e0.d(q0.getLayoutDirection()).d());
    }

    public final e n0() {
        if(this.j == null) {
            this.j = new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        e e0 = this.j;
        kotlin.jvm.internal.q.d(e0);
        return e0;
    }
}

