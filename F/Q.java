package F;

import G.k0;
import G.l0;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import androidx.compose.animation.a;
import androidx.compose.runtime.b0;
import je.x;
import r1.l;

public final class q extends d0 {
    public l0 a;
    public b0 b;
    public r c;
    public long d;

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        long v1;
        a0 a00 = l0.O(v);
        if(o0.u()) {
            v1 = ((long)a00.a) << 0x20 | ((long)a00.b) & 0xFFFFFFFFL;
        }
        else {
            l0 l00 = this.a;
            if(l00 == null) {
                v1 = ((long)a00.a) << 0x20 | ((long)a00.b) & 0xFFFFFFFFL;
                this.d = v1;
            }
            else {
                long v2 = ((long)a00.b) & 0xFFFFFFFFL | ((long)a00.a) << 0x20;
                k0 k00 = l00.a(new p(this, v2, 0), new p(this, v2, 1));
                this.c.getClass();
                v1 = ((l)k00.getValue()).a;
                this.d = ((l)k00.getValue()).a;
            }
        }
        o o1 = new o(this, a00, v1);
        return o0.w(((int)(v1 >> 0x20)), ((int)(0xFFFFFFFFL & v1)), x.a, o1);
    }

    @Override  // r0.p
    public final void onReset() {
        super.onReset();
        this.d = a.a;
    }
}

