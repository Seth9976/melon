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

public final class u0 extends p implements z {
    public float a;
    public float b;

    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        int v1 = p0.d(v);
        int v2 = Float.isNaN(this.b) ? 0 : q0.z(this.b);
        return v1 >= v2 ? v1 : v2;
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        int v1 = p0.N(v);
        int v2 = Float.isNaN(this.a) ? 0 : q0.z(this.a);
        return v1 >= v2 ? v1 : v2;
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        int v6;
        int v3;
        int v1 = 0;
        if(Float.isNaN(this.a) || a.j(v) != 0) {
            v3 = a.j(v);
        }
        else {
            int v2 = o0.z(this.a);
            v3 = a.h(v);
            if(v2 < 0) {
                v2 = 0;
            }
            if(v2 <= v3) {
                v3 = v2;
            }
        }
        int v4 = a.h(v);
        if(Float.isNaN(this.b) || a.i(v) != 0) {
            v6 = a.i(v);
        }
        else {
            int v5 = o0.z(this.b);
            v6 = a.g(v);
            if(v5 >= 0) {
                v1 = v5;
            }
            if(v1 <= v6) {
                v6 = v1;
            }
        }
        a0 a00 = l0.O(b.a(v3, v4, v6, a.g(v)));
        int v7 = a00.a;
        int v8 = a00.b;
        B b0 = new B(a00, 7);
        return o0.w(v7, v8, x.a, b0);
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        int v1 = p0.C(v);
        int v2 = Float.isNaN(this.b) ? 0 : q0.z(this.b);
        return v1 >= v2 ? v1 : v2;
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        int v1 = p0.L(v);
        int v2 = Float.isNaN(this.a) ? 0 : q0.z(this.a);
        return v1 >= v2 ? v1 : v2;
    }
}

