package F;

import G.a0;
import G.e;
import G.z0;
import N0.L;
import N0.N;
import N0.O;
import androidx.compose.animation.c;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import je.x;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import r1.b;
import r1.l;

public final class j0 extends d0 {
    public a0 a;
    public long b;
    public long c;
    public boolean d;
    public final b0 e;

    public j0(a0 a00) {
        this.a = a00;
        this.b = c.a;
        this.c = b.b(0, 0, 15);
        this.e = w.s(null);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        g0 g02;
        g0 g01;
        long v3;
        long v2;
        N0.a0 a00;
        boolean z = true;
        if(o0.u()) {
            this.c = v;
            this.d = true;
            a00 = l0.O(v);
        }
        else {
            a00 = l0.O((this.d ? this.c : v));
        }
        long v1 = ((long)a00.b) & 0xFFFFFFFFL | ((long)a00.a) << 0x20;
        if(o0.u()) {
            this.b = v1;
            v2 = v1;
            v3 = v2;
        }
        else {
            long v4 = l.b(this.b, c.a) ? v1 : this.b;
            b0 b00 = this.e;
            g0 g00 = (g0)((O0)b00).getValue();
            if(g00 == null) {
                v3 = v1;
                l l1 = new l(v4);
                l l2 = new l(0x100000001L);
                g02 = new g0(new e(l1, z0.h, l2, 8), v4);
            }
            else {
                e e0 = g00.a;
                v3 = v1;
                if(l.b(v4, ((l)e0.d()).a) || ((Boolean)((O0)e0.d).getValue()).booleanValue()) {
                    z = false;
                }
                if(!l.b(v4, ((l)((O0)e0.e).getValue()).a) || z) {
                    g00.b = ((l)e0.d()).a;
                    g01 = g00;
                    BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new h0(g01, v4, this, null), 3, null);
                }
                else {
                    g01 = g00;
                }
                g02 = g01;
            }
            ((O0)b00).setValue(g02);
            v2 = b.d(v, ((l)g02.a.d()).a);
        }
        i0 i00 = new i0(this, v3, ((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)), o0, a00);
        return o0.w(((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)), x.a, i00);
    }

    @Override  // r0.p
    public final void onAttach() {
        super.onAttach();
        this.b = c.a;
        this.d = false;
    }

    @Override  // r0.p
    public final void onReset() {
        super.onReset();
        ((O0)this.e).setValue(null);
    }
}

