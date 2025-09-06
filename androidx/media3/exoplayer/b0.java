package androidx.media3.exoplayer;

import android.os.SystemClock;
import b3.L;
import b3.p0;
import e3.x;
import java.util.List;
import s3.g0;
import s3.z;
import v3.s;

public final class b0 {
    public final p0 a;
    public final z b;
    public final long c;
    public final long d;
    public final int e;
    public final l f;
    public final boolean g;
    public final g0 h;
    public final s i;
    public final List j;
    public final z k;
    public final boolean l;
    public final int m;
    public final int n;
    public final L o;
    public final boolean p;
    public volatile long q;
    public volatile long r;
    public volatile long s;
    public volatile long t;
    public static final z u;

    static {
        b0.u = new z(new Object());
    }

    public b0(p0 p00, z z0, long v, long v1, int v2, l l0, boolean z1, g0 g00, s s0, List list0, z z2, boolean z3, int v3, int v4, L l1, long v5, long v6, long v7, long v8, boolean z4) {
        this.a = p00;
        this.b = z0;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = l0;
        this.g = z1;
        this.h = g00;
        this.i = s0;
        this.j = list0;
        this.k = z2;
        this.l = z3;
        this.m = v3;
        this.n = v4;
        this.o = l1;
        this.q = v5;
        this.r = v6;
        this.s = v7;
        this.t = v8;
        this.p = z4;
    }

    public final b0 a() {
        long v = this.q;
        long v1 = this.r;
        long v2 = this.j();
        long v3 = SystemClock.elapsedRealtime();
        return new b0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, v, v1, v2, v3, this.p);
    }

    public final b0 b(z z0) {
        return new b0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, z0, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final b0 c(z z0, long v, long v1, long v2, long v3, g0 g00, s s0, List list0) {
        long v4 = this.q;
        long v5 = SystemClock.elapsedRealtime();
        return new b0(this.a, z0, v1, v2, this.e, this.f, this.g, g00, s0, list0, this.k, this.l, this.m, this.n, this.o, v4, v3, v, v5, this.p);
    }

    public final b0 d(int v, int v1, boolean z) {
        return new b0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, v, v1, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final b0 e(l l0) {
        return new b0(this.a, this.b, this.c, this.d, this.e, l0, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final b0 f(L l0) {
        return new b0(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, l0, this.q, this.r, this.s, this.t, this.p);
    }

    public final b0 g(int v) {
        return new b0(this.a, this.b, this.c, this.d, v, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public final b0 h(p0 p00) {
        return new b0(p00, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.q, this.r, this.s, this.t, this.p);
    }

    public static b0 i(s s0) {
        return new b0(p0.a, b0.u, 0x8000000000000001L, 0L, 1, null, false, g0.d, s0, I6.p0.e, b0.u, false, 1, 0, L.d, 0L, 0L, 0L, 0L, false);
    }

    public final long j() {
        long v1;
        long v;
        if(!this.k()) {
            return this.s;
        }
        do {
            v = this.t;
            v1 = this.s;
        }
        while(v != this.t);
        long v2 = SystemClock.elapsedRealtime();
        return x.M(x.Z(v1) + ((long)(((float)(v2 - v)) * this.o.a)));
    }

    public final boolean k() {
        return this.e == 3 && this.l && this.n == 0;
    }
}

