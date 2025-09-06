package b0;

import M.U;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.l;
import P0.z;
import je.x;
import r1.f;

public final class p extends r0.p implements l, z {
    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        float f = ((f)P0.f.i(this, o.a)).a;
        int v1 = 0;
        if(f < 0.0f) {
            f = 0.0f;
        }
        a0 a00 = l0.O(v);
        boolean z = this.isAttached() && !Float.isNaN(f) && Float.compare(f, 0.0f) > 0;
        if(!Float.isNaN(f)) {
            v1 = o0.z(f);
        }
        int v2 = z ? Math.max(a00.a, v1) : a00.a;
        int v3 = z ? Math.max(a00.b, v1) : a00.b;
        U u0 = new U(v2, a00, v3, 4);
        return o0.w(v2, v3, x.a, u0);
    }
}

