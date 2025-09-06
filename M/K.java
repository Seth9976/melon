package M;

import F.B;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import N0.q;
import P0.z;
import je.x;
import r0.p;
import r1.a;
import r1.b;
import r1.i;
import r1.l;

public final class k extends p implements z {
    public float a;
    public boolean b;

    public final long m0(long v, boolean z) {
        int v1 = a.g(v);
        if(v1 != 0x7FFFFFFF) {
            int v2 = Math.round(((float)v1) * this.a);
            return v2 <= 0 || z && !androidx.compose.foundation.layout.a.e(v2, v1, v) ? 0L : ((long)v2) << 0x20 | ((long)v1) & 0xFFFFFFFFL;
        }
        return 0L;
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        return v == 0x7FFFFFFF ? p0.d(0x7FFFFFFF) : Math.round(((float)v) / this.a);
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        return v == 0x7FFFFFFF ? p0.N(0x7FFFFFFF) : Math.round(((float)v) * this.a);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        long v2;
        int v1 = 0;
        if(this.b) {
            v2 = this.m0(v, true);
            if(l.b(v2, 0L)) {
                v2 = this.n0(v, true);
                if(l.b(v2, 0L)) {
                    v2 = this.o0(v, true);
                    if(l.b(v2, 0L)) {
                        v2 = this.p0(v, true);
                        if(l.b(v2, 0L)) {
                            v2 = this.m0(v, false);
                            if(l.b(v2, 0L)) {
                                v2 = this.n0(v, false);
                                if(l.b(v2, 0L)) {
                                    v2 = this.o0(v, false);
                                    if(l.b(v2, 0L)) {
                                        v2 = this.p0(v, false);
                                        if(l.b(v2, 0L)) {
                                            v2 = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            v2 = this.n0(v, true);
            if(l.b(v2, 0L)) {
                v2 = this.m0(v, true);
                if(l.b(v2, 0L)) {
                    v2 = this.p0(v, true);
                    if(l.b(v2, 0L)) {
                        v2 = this.o0(v, true);
                        if(l.b(v2, 0L)) {
                            v2 = this.n0(v, false);
                            if(l.b(v2, 0L)) {
                                v2 = this.m0(v, false);
                                if(l.b(v2, 0L)) {
                                    v2 = this.p0(v, false);
                                    if(l.b(v2, 0L)) {
                                        v2 = this.o0(v, false);
                                        if(l.b(v2, 0L)) {
                                            v2 = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(!l.b(v2, 0L)) {
            int v3 = (int)(v2 >> 0x20);
            int v4 = (int)(0xFFFFFFFFL & v2);
            if(v4 >= 0) {
                v1 = 1;
            }
            if(((v3 < 0 ? 0 : 1) & v1) == 0) {
                i.a("width and height must be >= 0");
            }
            v = b.h(v3, v3, v4, v4);
        }
        a0 a00 = l0.O(v);
        int v5 = a00.a;
        int v6 = a00.b;
        B b0 = new B(a00, 3);
        return o0.w(v5, v6, x.a, b0);
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        return v == 0x7FFFFFFF ? p0.C(0x7FFFFFFF) : Math.round(((float)v) / this.a);
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        return v == 0x7FFFFFFF ? p0.L(0x7FFFFFFF) : Math.round(((float)v) * this.a);
    }

    public final long n0(long v, boolean z) {
        int v1 = a.h(v);
        if(v1 != 0x7FFFFFFF) {
            int v2 = Math.round(((float)v1) / this.a);
            return v2 <= 0 || z && !androidx.compose.foundation.layout.a.e(v1, v2, v) ? 0L : ((long)v1) << 0x20 | ((long)v2) & 0xFFFFFFFFL;
        }
        return 0L;
    }

    public final long o0(long v, boolean z) {
        int v1 = a.i(v);
        int v2 = Math.round(((float)v1) * this.a);
        return v2 <= 0 || z && !androidx.compose.foundation.layout.a.e(v2, v1, v) ? 0L : ((long)v2) << 0x20 | ((long)v1) & 0xFFFFFFFFL;
    }

    public final long p0(long v, boolean z) {
        int v1 = a.j(v);
        int v2 = Math.round(((float)v1) / this.a);
        return v2 <= 0 || z && !androidx.compose.foundation.layout.a.e(v1, v2, v) ? 0L : ((long)v1) << 0x20 | ((long)v2) & 0xFFFFFFFFL;
    }
}

