package X;

import U.b0;
import U4.F;
import a1.C;
import a1.U;
import a1.a;
import a1.t;
import e1.i;
import je.w;
import kotlin.jvm.internal.q;
import r1.c;
import r1.m;

public final class e {
    public String a;
    public U b;
    public i c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public long h;
    public c i;
    public a j;
    public boolean k;
    public long l;
    public b m;
    public C n;
    public m o;
    public long p;
    public int q;
    public int r;

    public e(String s, U u0, i i0, int v, boolean z, int v1, int v2) {
        this.a = s;
        this.b = u0;
        this.c = i0;
        this.d = v;
        this.e = z;
        this.f = v1;
        this.g = v2;
        this.h = X.a.a;
        this.l = 0L;
        this.p = r1.b.h(0, 0, 0, 0);
        this.q = -1;
        this.r = -1;
    }

    public final int a(int v, m m0) {
        int v6;
        int v1 = this.r;
        if(v == this.q && this.q != -1) {
            return v1;
        }
        long v2 = r1.b.a(0, v, 0, 0x7FFFFFFF);
        if(this.g > 1) {
            v2 = e.e(this, v2, m0);
        }
        C c0 = this.d(m0);
        long v3 = Q1.c.w(v2, this.e, this.d, c0.c());
        int v4 = this.d;
        int v5 = this.f;
        if(!this.e && (v4 == 2 || v4 == 4 || v4 == 5)) {
            v6 = 1;
        }
        else if(v5 >= 1) {
            v6 = v5;
        }
        else {
            v6 = 1;
        }
        int v7 = b0.r(new a(((i1.c)c0), v6, v4, v3).b());
        int v8 = r1.a.i(v2);
        if(v7 < v8) {
            v7 = v8;
        }
        this.q = v;
        this.r = v7;
        return v7;
    }

    public final void b() {
        this.j = null;
        this.n = null;
        this.o = null;
        this.q = -1;
        this.r = -1;
        this.p = r1.b.h(0, 0, 0, 0);
        this.l = 0L;
        this.k = false;
    }

    public final void c(c c0) {
        c c1 = this.i;
        long v = c0 == null ? X.a.a : X.a.a(c0.b(), c0.W());
        if(c1 == null) {
            this.i = c0;
            this.h = v;
            return;
        }
        if(c0 != null && this.h == v) {
            return;
        }
        this.i = c0;
        this.h = v;
        this.b();
    }

    public final C d(m m0) {
        C c0 = this.n;
        if(c0 == null || m0 != this.o || c0.b()) {
            this.o = m0;
            String s = this.a;
            U u0 = t.i(this.b, m0);
            c c1 = this.i;
            q.d(c1);
            c0 = new i1.c(s, u0, w.a, w.a, this.c, c1);
        }
        this.n = c0;
        return c0;
    }

    public static long e(e e0, long v, m m0) {
        U u0 = e0.b;
        b b0 = e0.m;
        c c0 = e0.i;
        q.d(c0);
        b b1 = F.t(b0, m0, u0, c0, e0.c);
        e0.m = b1;
        return b1.a(e0.g, v);
    }

    @Override
    public final String toString() {
        return "ParagraphLayoutCache(paragraph=" + (this.j == null ? "null" : "<paragraph>") + ", lastDensity=" + ("InlineDensity(density=" + Float.intBitsToFloat(((int)(this.h >> 0x20))) + ", fontScale=" + Float.intBitsToFloat(((int)(this.h & 0xFFFFFFFFL))) + ')') + ')';
    }
}

