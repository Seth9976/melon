package Z;

import M.U;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.f;
import P0.l;
import P0.z;
import r0.p;

public final class y extends p implements l, z {
    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        boolean z = this.isAttached() && ((Boolean)f.i(this, x.a)).booleanValue();
        a0 a00 = l0.O(v);
        int v1 = z ? Math.max(a00.a, o0.z(48.0f)) : a00.a;
        int v2 = z ? Math.max(a00.b, o0.z(48.0f)) : a00.b;
        U u0 = new U(v1, a00, v2, 2);
        return o0.w(v1, v2, je.x.a, u0);
    }
}

