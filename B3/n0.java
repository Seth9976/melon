package b3;

import I6.V;
import e3.b;

public final class n0 extends p0 {
    public final V e;
    public final V f;
    public final int[] g;
    public final int[] h;

    public n0(I6.p0 p00, I6.p0 p01, int[] arr_v) {
        b.c(p00.d == arr_v.length);
        this.e = p00;
        this.f = p01;
        this.g = arr_v;
        this.h = new int[arr_v.length];
        for(int v = 0; v < arr_v.length; ++v) {
            this.h[arr_v[v]] = v;
        }
    }

    @Override  // b3.p0
    public final int a(boolean z) {
        if(this.p()) {
            return -1;
        }
        return z ? this.g[0] : 0;
    }

    @Override  // b3.p0
    public final int b(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override  // b3.p0
    public final int c(boolean z) {
        if(this.p()) {
            return -1;
        }
        return z ? this.g[this.e.size() - 1] : this.e.size() - 1;
    }

    @Override  // b3.p0
    public final int e(int v, int v1, boolean z) {
        if(v1 == 1) {
            return v;
        }
        if(v == this.c(z)) {
            return v1 == 2 ? this.a(z) : -1;
        }
        return z ? this.g[this.h[v] + 1] : v + 1;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        m0 m01 = (m0)this.f.get(v);
        m00.i(m01.a, m01.b, m01.c, m01.d, m01.e, m01.g, m01.f);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return this.f.size();
    }

    @Override  // b3.p0
    public final int k(int v, int v1, boolean z) {
        if(v1 == 1) {
            return v;
        }
        if(v == this.a(z)) {
            return v1 == 2 ? this.c(z) : -1;
        }
        return z ? this.g[this.h[v] - 1] : v - 1;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        throw new UnsupportedOperationException();
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        o0 o01 = (o0)this.e.get(v);
        o00.b(o01.a, o01.c, o01.d, o01.e, o01.f, o01.g, o01.h, o01.i, o01.j, o01.l, o01.m, o01.n, o01.o, o01.p);
        o00.k = o01.k;
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return this.e.size();
    }
}

