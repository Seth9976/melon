package f0;

import G.I0;
import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.c;
import m0.d;

public final class f extends I {
    public static final f d;

    static {
        f.d = new f(0, 2, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        d d0 = (d)w0.j(1);
        int v = d0 == null ? 0 : d0.a;
        a a0 = (a)w0.j(0);
        if(v > 0) {
            c0 = new I0(c0, v);
        }
        a0.H(c0, e00, h0);
    }
}

