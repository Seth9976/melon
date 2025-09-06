package F;

import B0.b;
import G.a0;
import G.e;
import G.f;
import G.j;
import G.x0;
import G.y0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import y0.s;

public abstract class f0 {
    public static final a0 a;

    static {
        f0.a = f.q(0.0f, 7, null);
    }

    public static final e a(long v) {
        s s0 = new s(v);
        b b0 = new b(s.g(v), 4);
        return new e(s0, new y0(c.l, b0), null, 12);
    }

    public static final b1 b(long v, x0 x00, String s, l l0, int v1) {
        if((v1 & 2) != 0) {
            x00 = f0.a;
        }
        boolean z = ((p)l0).g(s.g(v));
        y0 y00 = ((p)l0).N();
        if(z || y00 == k.a) {
            b b0 = new b(s.g(v), 4);
            y0 y01 = new y0(c.l, b0);
            ((p)l0).l0(y01);
            y00 = y01;
        }
        return j.c(new s(v), y00, x00, null, s, null, ((p)l0), 0x6000, 8);
    }
}

