package M;

import F.g;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.z;
import je.x;
import r0.p;
import r1.b;

public final class h0 extends p implements z {
    public float a;
    public float b;
    public float c;
    public float d;
    public boolean e;

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        int v1 = o0.z(this.a);
        int v2 = o0.z(this.c) + v1;
        int v3 = o0.z(this.b);
        int v4 = o0.z(this.d) + v3;
        a0 a00 = l0.O(b.i(-v2, -v4, v));
        int v5 = b.g(a00.a + v2, v);
        int v6 = b.f(a00.b + v4, v);
        g g0 = new g(this, a00, o0, 9);
        return o0.w(v5, v6, x.a, g0);
    }
}

