package d0;

import N0.M;
import P0.i;
import P0.j;
import P0.k;
import T.d;
import T.e;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.graphics.a;

public final class c {
    public static final c a;
    public static final d b;
    public static final float c;
    public static final float d;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = e.a;
        c.c = 80.0f;
        c.d = e0.c.c;
    }

    public final void a(q q0, boolean z, r0.q q1, long v, long v1, float f, l l0, int v2) {
        float f1;
        int v4;
        p p0 = (p)l0;
        p0.c0(0xBFD04390);
        int v3 = v2 | (p0.g(q0) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.g(q1) ? 0x100 : 0x80) | (p0.f(v) ? 0x800 : 0x400) | (p0.f(v1) ? 0x4000 : 0x2000) | 0x10000 | (p0.g(this) ? 0x100000 : 0x80000);
        if((0x92493 & v3) != 0x92492 || !p0.D()) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                v4 = v3 & 0xFFF8FFFF;
                f1 = c.c;
            }
            else {
                p0.T();
                v4 = v3 & 0xFFF8FFFF;
                f1 = f;
            }
            p0.q();
            r0.q q2 = androidx.compose.foundation.q.f(a.a(androidx.compose.ui.draw.a.c(androidx.compose.foundation.layout.d.n(q1, h.d), d0.e.g), new f(q0, z, f1, c.d, c.b)), v, c.b);
            M m0 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            w.x(p0, q3, j.d);
            ye.a.e(Boolean.valueOf(z), null, G.f.r(100, 0, null, 6), null, m0.c.e(0xA008A6B, p0, new d0.a(v1, q0)), p0, v4 >> 3 & 14 | 0x6180, 10);
            p0.p(true);
        }
        else {
            p0.T();
            f1 = f;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b(this, q0, z, q1, v, v1, f1, v2);
        }
    }
}

