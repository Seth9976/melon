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

public final class s0 extends p implements z {
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;

    public final long m0(O o0) {
        int v3;
        int v2;
        int v1;
        int v = 0;
        if(Float.isNaN(this.c)) {
            v1 = 0x7FFFFFFF;
        }
        else {
            v1 = o0.z(this.c);
            if(v1 < 0) {
                v1 = 0;
            }
        }
        if(Float.isNaN(this.d)) {
            v2 = 0x7FFFFFFF;
        }
        else {
            v2 = o0.z(this.d);
            if(v2 < 0) {
                v2 = 0;
            }
        }
        if(Float.isNaN(this.a)) {
            v3 = 0;
        }
        else {
            v3 = o0.z(this.a);
            if(v3 < 0) {
                v3 = 0;
            }
            if(v3 > v1) {
                v3 = v1;
            }
            if(v3 == 0x7FFFFFFF) {
                v3 = 0;
            }
        }
        if(!Float.isNaN(this.b)) {
            int v4 = o0.z(this.b);
            if(v4 < 0) {
                v4 = 0;
            }
            if(v4 > v2) {
                v4 = v2;
            }
            if(v4 != 0x7FFFFFFF) {
                v = v4;
            }
        }
        return b.a(v3, v1, v, v2);
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        long v1 = this.m0(((O)q0));
        if(a.e(v1)) {
            return a.g(v1);
        }
        if(!this.e) {
            v = b.g(v, v1);
        }
        return b.f(p0.d(v), v1);
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        long v1 = this.m0(((O)q0));
        if(a.f(v1)) {
            return a.h(v1);
        }
        if(!this.e) {
            v = b.f(v, v1);
        }
        return b.g(p0.N(v), v1);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        int v9;
        int v7;
        int v5;
        int v3;
        long v2;
        long v1 = this.m0(o0);
        if(this.e) {
            v2 = b.e(v, v1);
        }
        else {
            if(Float.isNaN(this.a)) {
                v3 = a.j(v);
                int v4 = a.h(v1);
                if(v3 > v4) {
                    v3 = v4;
                }
            }
            else {
                v3 = a.j(v1);
            }
            if(Float.isNaN(this.c)) {
                v5 = a.h(v);
                int v6 = a.j(v1);
                if(v5 < v6) {
                    v5 = v6;
                }
            }
            else {
                v5 = a.h(v1);
            }
            if(Float.isNaN(this.b)) {
                v7 = a.i(v);
                int v8 = a.g(v1);
                if(v7 > v8) {
                    v7 = v8;
                }
            }
            else {
                v7 = a.i(v1);
            }
            if(Float.isNaN(this.d)) {
                v9 = a.g(v);
                int v10 = a.i(v1);
                if(v9 < v10) {
                    v9 = v10;
                }
            }
            else {
                v9 = a.g(v1);
            }
            v2 = b.a(v3, v5, v7, v9);
        }
        a0 a00 = l0.O(v2);
        int v11 = a00.a;
        int v12 = a00.b;
        B b0 = new B(a00, 6);
        return o0.w(v11, v12, x.a, b0);
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        long v1 = this.m0(((O)q0));
        if(a.e(v1)) {
            return a.g(v1);
        }
        if(!this.e) {
            v = b.g(v, v1);
        }
        return b.f(p0.C(v), v1);
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        long v1 = this.m0(((O)q0));
        if(a.f(v1)) {
            return a.h(v1);
        }
        if(!this.e) {
            v = b.f(v, v1);
        }
        return b.g(p0.L(v), v1);
    }
}

