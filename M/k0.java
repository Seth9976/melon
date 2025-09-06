package M;

import N.a;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.z;
import je.x;
import r0.p;
import r1.b;

public final class k0 extends p implements z {
    public i0 a;

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        float f = this.a.b(o0.getLayoutDirection());
        float f1 = this.a.d();
        float f2 = this.a.c(o0.getLayoutDirection());
        float f3 = this.a.a();
        int v1 = 0;
        int v2 = Float.compare(f, 0.0f) < 0 ? 0 : 1;
        int v3 = Float.compare(f1, 0.0f) < 0 ? 0 : 1;
        int v4 = Float.compare(f2, 0.0f) < 0 ? 0 : 1;
        if(Float.compare(f3, 0.0f) >= 0) {
            v1 = 1;
        }
        if((v1 & (v2 & v3 & v4)) == 0) {
            a.a("Padding must be non-negative");
        }
        int v5 = o0.z(f);
        int v6 = o0.z(f2) + v5;
        int v7 = o0.z(f1);
        int v8 = o0.z(f3) + v7;
        a0 a00 = l0.O(b.i(-v6, -v8, v));
        int v9 = b.g(a00.a + v6, v);
        int v10 = b.f(a00.b + v8, v);
        U u0 = new U(a00, v5, v7, 1);
        return o0.w(v9, v10, x.a, u0);
    }
}

