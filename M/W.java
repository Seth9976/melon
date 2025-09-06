package M;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import r0.d;
import r0.g;

public abstract class w {
    public static final y a;

    static {
        w.a = new y(j.c, d.m);
    }

    public static final y a(h h0, g g0, l l0, int v) {
        if(q.b(h0, j.c) && g0.equals(d.m)) {
            ((p)l0).a0(0x14A0E7E8);
            ((p)l0).p(false);
            return w.a;
        }
        ((p)l0).a0(0x14A1BA3F);
        int v1 = 1;
        int v2 = ((v & 14 ^ 6) <= 4 || !((p)l0).g(h0)) && (v & 6) != 4 ? 0 : 1;
        if(((v & 0x70 ^ 0x30) <= 0x20 || !((p)l0).g(g0)) && (v & 0x30) != 0x20) {
            v1 = 0;
        }
        y y0 = ((p)l0).N();
        if((v2 | v1) != 0 || y0 == k.a) {
            y0 = new y(h0, g0);
            ((p)l0).l0(y0);
        }
        ((p)l0).p(false);
        return y0;
    }
}

