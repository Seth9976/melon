package N0;

import P0.l0;
import P0.m0;
import r1.a;

public final class l implements L {
    public final int a;
    public final p b;
    public final Enum c;
    public final Enum d;

    public l(p p0, Enum enum0, Enum enum1, int v) {
        this.a = v;
        this.b = p0;
        this.c = enum0;
        this.d = enum1;
        super();
    }

    @Override  // N0.p
    public final int C(int v) {
        switch(this.a) {
            case 0: {
                return this.b.C(v);
            }
            case 1: {
                return this.b.C(v);
            }
            default: {
                return this.b.C(v);
            }
        }
    }

    @Override  // N0.p
    public final int L(int v) {
        switch(this.a) {
            case 0: {
                return this.b.L(v);
            }
            case 1: {
                return this.b.L(v);
            }
            default: {
                return this.b.L(v);
            }
        }
    }

    @Override  // N0.p
    public final int N(int v) {
        switch(this.a) {
            case 0: {
                return this.b.N(v);
            }
            case 1: {
                return this.b.N(v);
            }
            default: {
                return this.b.N(v);
            }
        }
    }

    @Override  // N0.L
    public final a0 O(long v) {
        switch(this.a) {
            case 0: {
                r r0 = (r)this.c;
                int v4 = 0x7FFF;
                p p1 = this.b;
                if(((s)this.d) == s.a) {
                    int v5 = r0 == r.b ? p1.N(a.g(v)) : p1.L(a.g(v));
                    if(a.c(v)) {
                        v4 = a.g(v);
                    }
                    return new n(v5, v4, 0);
                }
                int v6 = r0 == r.b ? p1.d(a.h(v)) : p1.C(a.h(v));
                if(a.d(v)) {
                    v4 = a.h(v);
                }
                return new n(v4, v6, 0);
            }
            case 1: {
                P p2 = (P)this.c;
                int v7 = 0x7FFF;
                p p3 = this.b;
                if(((Q)this.d) == Q.a) {
                    int v8 = p2 == P.b ? p3.N(a.g(v)) : p3.L(a.g(v));
                    if(a.c(v)) {
                        v7 = a.g(v);
                    }
                    return new n(v8, v7, 1);
                }
                int v9 = p2 == P.b ? p3.d(a.h(v)) : p3.C(a.h(v));
                if(a.d(v)) {
                    v7 = a.h(v);
                }
                return new n(v7, v9, 1);
            }
            default: {
                l0 l00 = (l0)this.c;
                int v1 = 0x7FFF;
                p p0 = this.b;
                if(((m0)this.d) == m0.a) {
                    int v2 = l00 == l0.b ? p0.N(a.g(v)) : p0.L(a.g(v));
                    if(a.c(v)) {
                        v1 = a.g(v);
                    }
                    return new n(v2, v1, 2);
                }
                int v3 = l00 == l0.b ? p0.d(a.h(v)) : p0.C(a.h(v));
                if(a.d(v)) {
                    v1 = a.h(v);
                }
                return new n(v1, v3, 2);
            }
        }
    }

    @Override  // N0.p
    public final int d(int v) {
        switch(this.a) {
            case 0: {
                return this.b.d(v);
            }
            case 1: {
                return this.b.d(v);
            }
            default: {
                return this.b.d(v);
            }
        }
    }

    @Override  // N0.p
    public final Object q() {
        switch(this.a) {
            case 0: {
                return this.b.q();
            }
            case 1: {
                return this.b.q();
            }
            default: {
                return this.b.q();
            }
        }
    }
}

