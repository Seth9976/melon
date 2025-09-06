package y0;

import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import P0.z;
import je.x;
import r0.p;
import we.k;

public final class m extends p implements z {
    public k a;

    public m(k k0) {
        this.a = k0;
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a0 a00 = l0.O(v);
        int v1 = a00.a;
        int v2 = a00.b;
        l l1 = new l(0, a00, this);
        return o0.w(v1, v2, x.a, l1);
    }

    @Override
    public final String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.a + ')';
    }
}

