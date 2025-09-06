package G;

import Ac.J;
import F.K;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import d3.g;
import ie.k;

public abstract class w0 {
    public static final int a;

    static {
        g.P(k.c, u0.f);
    }

    public static final void a(t0 t00, o0 o00, Object object0, Object object1, D d0, l l0, int v) {
        ((p)l0).c0(0x33AE021D);
        int v1 = (v & 6) == 0 ? (((p)l0).g(t00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(o00) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((v & 0x200) == 0 ? ((p)l0).g(object0) : ((p)l0).i(object0)) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((v & 0x1000) == 0 ? ((p)l0).g(object1) : ((p)l0).i(object1)) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (((0x8000 & v) == 0 ? ((p)l0).g(d0) : ((p)l0).i(d0)) ? 0x4000 : 0x2000);
        }
        if(!((p)l0).Q(v1 & 1, (v1 & 9363) != 9362)) {
            ((p)l0).T();
        }
        else if(t00.g()) {
            o00.g(object0, object1, d0);
        }
        else {
            o00.i(object1, d0);
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new K(t00, o00, object0, object1, d0, v);
        }
    }

    public static final l0 b(t0 t00, y0 y00, String s, l l0, int v, int v1) {
        if((v1 & 2) != 0) {
            s = "DeferredAnimation";
        }
        boolean z = ((p)l0).g(t00);
        l0 l00 = ((p)l0).N();
        V v2 = androidx.compose.runtime.k.a;
        if(z || l00 == v2) {
            l00 = new l0(t00, y00, s);
            ((p)l0).l0(l00);
        }
        boolean z1 = ((p)l0).g(t00);
        boolean z2 = ((p)l0).i(l00);
        J j0 = ((p)l0).N();
        if(z1 || z2 || j0 == v2) {
            j0 = new J(15, t00, l00);
            ((p)l0).l0(j0);
        }
        androidx.compose.runtime.J.b(l00, j0, ((p)l0));
        if(t00.g()) {
            k0 k00 = (k0)((O0)l00.b).getValue();
            if(k00 != null) {
                Object object0 = ((we.k)k00.c).invoke(l00.c.f().c());
                Object object1 = ((we.k)k00.c).invoke(l00.c.f().b());
                D d0 = (D)k00.b.invoke(l00.c.f());
                k00.a.g(object0, object1, d0);
            }
        }
        return l00;
    }

    public static final o0 c(t0 t00, Object object0, Object object1, D d0, y0 y00, l l0) {
        boolean z = ((p)l0).g(t00);
        o0 o00 = ((p)l0).N();
        V v0 = androidx.compose.runtime.k.a;
        if(z || o00 == v0) {
            u u0 = (u)y00.a.invoke(object1);
            u0.d();
            o00 = new o0(t00, object0, u0, y00);
            ((p)l0).l0(o00);
        }
        w0.a(t00, o00, object0, object1, d0, ((p)l0), 0);
        boolean z1 = ((p)l0).g(t00);
        boolean z2 = ((p)l0).g(o00);
        J j0 = ((p)l0).N();
        if(z1 || z2 || j0 == v0) {
            j0 = new J(16, t00, o00);
            ((p)l0).l0(j0);
        }
        androidx.compose.runtime.J.b(o00, j0, ((p)l0));
        return o00;
    }

    public static final t0 d(P p0, l l0, int v) {
        boolean z = (v & 14 ^ 6) > 4 && ((p)l0).g(p0) || (v & 6) == 4;
        t0 t00 = ((p)l0).N();
        V v1 = androidx.compose.runtime.k.a;
        if(z || t00 == v1) {
            t00 = new t0(p0, null, "AnimatedVisibility");
            ((p)l0).l0(t00);
        }
        ((p)l0).a0(1031290843);
        t00.a(((O0)p0.c).getValue(), ((p)l0), 0);
        ((p)l0).p(false);
        boolean z1 = ((p)l0).g(t00);
        F.J j0 = ((p)l0).N();
        if(z1 || j0 == v1) {
            j0 = new F.J(t00, 1);
            ((p)l0).l0(j0);
        }
        androidx.compose.runtime.J.b(t00, j0, ((p)l0));
        return t00;
    }

    public static final t0 e(Object object0, String s, l l0, int v) {
        t0 t00 = ((p)l0).N();
        V v1 = androidx.compose.runtime.k.a;
        if(t00 == v1) {
            t00 = new t0(new P(object0), null, s);
            ((p)l0).l0(t00);
        }
        t00.a(object0, ((p)l0), v & 8 | 0x30 | v & 14);
        F.J j0 = ((p)l0).N();
        if(j0 == v1) {
            j0 = new F.J(t00, 2);
            ((p)l0).l0(j0);
        }
        androidx.compose.runtime.J.b(t00, j0, ((p)l0));
        return t00;
    }
}

