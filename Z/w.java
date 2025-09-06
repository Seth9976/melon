package Z;

import C0.c;
import D2.N0;
import N0.j;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.draw.a;
import r0.n;
import r0.q;
import x0.e;
import y0.k;
import y0.s;

public abstract class w {
    public static final q a;

    static {
        w.a = d.n(n.a, 24.0f);
    }

    public static final void a(c c0, q q0, long v, l l0, int v1, int v2) {
        q q3;
        q q2;
        q q1;
        int v4;
        ((p)l0).c0(-1142959010);
        int v3 = v1 | (((p)l0).i(c0) ? 4 : 2);
        if((v2 & 4) == 0) {
            q1 = q0;
            v4 = v3 | (((p)l0).g(q1) ? 0x100 : 0x80);
        }
        else {
            v4 = v3 | 0x180;
            q1 = q0;
        }
        int v5 = v4 | (((p)l0).f(v) ? 0x800 : 0x400);
        boolean z = true;
        if(((p)l0).Q(v5 & 1, (v5 & 0x493) != 1170)) {
            ((p)l0).V();
            n n0 = n.a;
            if((v1 & 1) != 0 && !((p)l0).B()) {
                ((p)l0).T();
            }
            else if((v2 & 4) != 0) {
                q1 = n0;
            }
            ((p)l0).q();
            if(((v5 & 0x1C00 ^ 0xC00) <= 0x800 || !((p)l0).f(v)) && (v5 & 0xC00) != 0x800) {
                z = false;
            }
            k k0 = ((p)l0).N();
            if(z || k0 == androidx.compose.runtime.k.a) {
                k0 = s.d(v, s.g) ? null : new k(v, 5);
                ((p)l0).l0(k0);
            }
            ((p)l0).a0(980649859);
            ((p)l0).p(false);
            if(e.a(c0.getIntrinsicSize-NH-jbRc(), 0x7FC000007FC00000L)) {
                q2 = w.a;
            }
            else {
                long v6 = c0.getIntrinsicSize-NH-jbRc();
                q2 = Float.isInfinite(e.d(v6)) && Float.isInfinite(e.b(v6)) ? w.a : n0;
            }
            M.p.a(a.d(q1.then(q2), c0, null, j.c, 0.0f, k0, 22).then(n0), ((p)l0), 0);
        }
        else {
            ((p)l0).T();
        }
        q3 = q1;
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new N0(c0, q3, v, v1, v2);
        }
    }
}

