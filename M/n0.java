package M;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import r0.d;
import r0.h;

public abstract class n0 {
    public static final p0 a;

    static {
        n0.a = new p0(j.a, d.j);
    }

    public static final p0 a(f f0, h h0, l l0, int v) {
        if(q.b(f0, j.a) && q.b(h0, d.j)) {
            ((p)l0).a0(0xCD65D3FB);
            ((p)l0).p(false);
            return n0.a;
        }
        ((p)l0).a0(0xCD669AB2);
        int v1 = 1;
        int v2 = ((v & 14 ^ 6) <= 4 || !((p)l0).g(f0)) && (v & 6) != 4 ? 0 : 1;
        if(((v & 0x70 ^ 0x30) <= 0x20 || !((p)l0).g(h0)) && (v & 0x30) != 0x20) {
            v1 = 0;
        }
        p0 p00 = ((p)l0).N();
        if((v2 | v1) != 0 || p00 == k.a) {
            p00 = new p0(f0, h0);
            ((p)l0).l0(p00);
        }
        ((p)l0).p(false);
        return p00;
    }
}

