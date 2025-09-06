package F;

import G.y;
import Q0.k0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import r1.c;

public abstract class m0 {
    public static final float a;

    static {
        m0.a = 0.015f;
    }

    public static final y a(l l0) {
        c c0 = (c)((p)l0).k(k0.h);
        boolean z = ((p)l0).d(c0.b());
        y y0 = ((p)l0).N();
        if(z || y0 == k.a) {
            y0 = new y(new A0.c(c0));
            ((p)l0).l0(y0);
        }
        return y0;
    }
}

