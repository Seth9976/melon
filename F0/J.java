package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.a;
import androidx.compose.runtime.c;
import androidx.compose.runtime.q;
import e1.b;
import m0.d;

public final class j extends I {
    public static final j d;

    static {
        j.d = new j(0, 2, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        d d0 = (d)w0.j(0);
        int v = e00.c(((a)w0.j(1)));
        if(e00.t >= v) {
            q.c("Check failed");
        }
        b.H(e00, c0, v);
        int v1 = e00.t;
        int v2;
        for(v2 = e00.v; v2 >= 0 && !e00.w(v2); v2 = e00.C(v2, e00.b)) {
        }
        int v3 = v2 + 1;
        int v4 = 0;
        while(v3 < v1) {
            if(e00.t(v1, v3)) {
                if(e00.w(v3)) {
                    v4 = 0;
                }
                ++v3;
            }
            else {
                v4 += (e00.w(v3) ? 1 : e00.b[e00.q(v3) * 5 + 1] & 0x3FFFFFF);
                v3 += e00.s(v3);
            }
        }
        int v5;
        while((v5 = e00.t) < v) {
            if(e00.t(v, v5)) {
                if(e00.t < e00.u && (e00.b[e00.q(e00.t) * 5 + 1] & 0x40000000) != 0) {
                    c0.k(e00.B(e00.t));
                    v4 = 0;
                }
                e00.N();
            }
            else {
                v4 += e00.I();
            }
        }
        if(v5 != v) {
            q.c("Check failed");
        }
        d0.a = v4;
    }
}

