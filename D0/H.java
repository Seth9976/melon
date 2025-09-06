package d0;

import A0.i;
import F.b0;
import G.C;
import G.f;
import G.x0;
import X0.n;
import a1.x;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import b0.u;
import df.v;
import r0.q;
import we.a;
import x0.b;
import x0.c;
import y0.L;
import y0.g;
import y0.j;

public abstract class h {
    public static final float a;
    public static final float b;
    public static final float c;
    public static final float d;
    public static final float e;
    public static final float f;
    public static final x0 g;

    static {
        h.a = 2.5f;
        h.b = 5.5f;
        h.c = 16.0f;
        h.d = 40.0f;
        h.e = 10.0f;
        h.f = 5.0f;
        h.g = f.r(300, 0, C.d, 2);
    }

    public static final void a(a a0, long v, l l0, int v1) {
        ((p)l0).c0(0xDE0AC7E6);
        int v2 = (v1 & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((p)l0).f(v) ? 0x20 : 16);
        }
        if((v2 & 19) != 18 || !((p)l0).D()) {
            g g0 = ((p)l0).N();
            int v3 = 1;
            V v4 = k.a;
            if(g0 == v4) {
                g0 = j.a();
                g0.h(1);
                ((p)l0).l0(g0);
            }
            E e0 = ((p)l0).N();
            if(e0 == v4) {
                e0 = w.i(new u(1, a0));
                ((p)l0).l0(e0);
            }
            b1 b10 = G.j.b(((Number)e0.getValue()).floatValue(), h.g, null, null, ((p)l0), 0x30, 28);
            Y.V v5 = ((p)l0).N();
            if((v2 & 14) == 4 || v5 == v4) {
                v5 = new Y.V(2, a0);
                ((p)l0).l0(v5);
            }
            q q0 = d.n(n.c(r0.n.a, true, v5), h.c);
            boolean z = ((p)l0).g(b10);
            if((v2 & 0x70) != 0x20) {
                v3 = 0;
            }
            boolean z1 = ((p)l0).i(g0);
            x x0 = ((p)l0).N();
            if(((v2 & 14) == 4 | z | v3 | z1) != 0 || x0 == v4) {
                x x1 = new x(a0, b10, v, g0, 2);
                ((p)l0).l0(x1);
                x0 = x1;
            }
            androidx.compose.foundation.q.b(q0, x0, ((p)l0), 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new d0.d(a0, v, v1);
        }
    }

    public static final void b(A0.f f0, L l0, c c0, long v, float f1, b0 b00) {
        ((g)l0).g();
        ((g)l0).e(0.0f, 0.0f);
        float f2 = f0.Y(h.e);
        float f3 = b00.b;
        ((g)l0).d(f2 * f3 / 2.0f, f0.Y(h.f) * f3);
        ((g)l0).d(f0.Y(h.e) * f3, 0.0f);
        float f4 = f0.Y(h.e);
        float f5 = f0.Y(h.a);
        ((g)l0).i(v.h(b.d(c0.a()) + Math.min(c0.c - c0.a, c0.d - c0.b) / 2.0f - f4 * f3 / 2.0f, b.e(c0.a()) - f5));
        float f6 = b00.a;
        float f7 = f0.Y(h.a);
        long v1 = f0.g0();
        androidx.media3.session.legacy.V v2 = f0.a0();
        long v3 = v2.l();
        v2.h().q();
        try {
            ((A0.c)v2.a).I(v1, f6 - f7);
            A0.f.H(f0, ((g)l0), v, f1, new i(0, 0, f0.Y(h.a), 0.0f, 30), 0x30);
        }
        finally {
            o.y(v2, v3);
        }
    }
}

