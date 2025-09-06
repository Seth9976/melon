package r0;

import A7.d;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.z;
import gd.y1;
import je.x;

public final class u extends p implements z {
    public float a;

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a0 a00 = l0.O(v);
        int v1 = a00.a;
        int v2 = a00.b;
        y1 y10 = new y1(24, a00, this);
        return o0.w(v1, v2, x.a, y10);
    }

    @Override
    public final String toString() {
        return d.m(new StringBuilder("ZIndexModifier(zIndex="), this.a, ')');
    }
}

