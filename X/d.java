package X;

import U.b0;
import U4.F;
import a1.P;
import a1.Q;
import a1.U;
import a1.g;
import a1.t;
import a1.y;
import e1.i;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import r1.c;
import r1.m;

public final class d {
    public g a;
    public i b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public List g;
    public b h;
    public long i;
    public c j;
    public U k;
    public H8.i l;
    public m m;
    public Q n;
    public int o;
    public int p;

    public d(g g0, U u0, i i0, int v, boolean z, int v1, int v2, List list0) {
        this.a = g0;
        this.b = i0;
        this.c = v;
        this.d = z;
        this.e = v1;
        this.f = v2;
        this.g = list0;
        this.i = a.a;
        this.k = u0;
        this.o = -1;
        this.p = -1;
    }

    public final int a(int v, m m0) {
        int v1 = this.p;
        if(v == this.o && this.o != -1) {
            return v1;
        }
        long v2 = r1.b.a(0, v, 0, 0x7FFFFFFF);
        if(this.f > 1) {
            b b0 = this.h;
            U u0 = this.k;
            c c0 = this.j;
            q.d(c0);
            b b1 = F.t(b0, m0, u0, c0, this.b);
            this.h = b1;
            v2 = b1.a(this.f, v2);
        }
        int v3 = b0.r(this.b(v2, m0).e);
        int v4 = r1.a.i(v2);
        if(v3 < v4) {
            v3 = v4;
        }
        this.o = v;
        this.p = v3;
        return v3;
    }

    public final y b(long v, m m0) {
        H8.i i0 = this.d(m0);
        long v1 = Q1.c.w(v, this.d, this.c, i0.c());
        int v2 = this.c;
        int v3 = this.e;
        if(!this.d && (v2 == 2 || v2 == 4 || v2 == 5)) {
            return new y(i0, v1, 1, v2);
        }
        return v3 < 1 ? new y(i0, v1, 1, v2) : new y(i0, v1, v3, v2);
    }

    public final void c(c c0) {
        c c1 = this.j;
        long v = c0 == null ? a.a : a.a(c0.b(), c0.W());
        if(c1 == null) {
            this.j = c0;
            this.i = v;
            return;
        }
        if(c0 != null && this.i == v) {
            return;
        }
        this.j = c0;
        this.i = v;
        this.l = null;
        this.n = null;
        this.p = -1;
        this.o = -1;
    }

    public final H8.i d(m m0) {
        H8.i i0 = this.l;
        if(i0 == null || m0 != this.m || i0.b()) {
            this.m = m0;
            g g0 = this.a;
            U u0 = t.i(this.k, m0);
            c c0 = this.j;
            q.d(c0);
            i i1 = this.b;
            List list0 = this.g;
            if(list0 == null) {
                list0 = w.a;
            }
            i0 = new H8.i(g0, u0, list0, c0, i1);
        }
        this.l = i0;
        return i0;
    }

    public final Q e(m m0, long v, y y0) {
        float f = Math.min(y0.a.c(), y0.d);
        g g0 = this.a;
        U u0 = this.k;
        List list0 = this.g;
        if(list0 == null) {
            list0 = w.a;
        }
        int v1 = this.e;
        boolean z = this.d;
        int v2 = this.c;
        c c0 = this.j;
        q.d(c0);
        return new Q(new P(g0, u0, list0, v1, z, v2, c0, m0, this.b, v), y0, r1.b.d(v, ((long)b0.r(f)) << 0x20 | ((long)b0.r(y0.e)) & 0xFFFFFFFFL));
    }
}

