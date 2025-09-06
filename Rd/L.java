package rd;

import F.E;
import M.c;
import M.j;
import M.n0;
import M.p0;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.jvm.internal.q;
import r0.d;
import we.a;
import we.n;
import we.o;

public final class l implements o {
    public final String a;
    public final a b;
    public final boolean c;
    public final long d;
    public final n e;
    public final String f;
    public final String g;
    public final a h;

    public l(String s, a a0, boolean z, long v, n n0, String s1, String s2, a a1) {
        this.a = s;
        this.b = a0;
        this.c = z;
        this.d = v;
        this.e = n0;
        this.f = s1;
        this.g = s2;
        this.h = a1;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Number)object2).intValue();
        q.g(((E)object0), "$this$AnimatedVisibility");
        p0 p00 = n0.a(j.a, d.j, ((androidx.compose.runtime.l)object1), 0);
        int v = ((p)(((androidx.compose.runtime.l)object1))).P;
        i0 i00 = ((p)(((androidx.compose.runtime.l)object1))).m();
        r0.q q0 = r0.a.d(((androidx.compose.runtime.l)object1), androidx.compose.foundation.layout.d.c);
        k.y.getClass();
        i i0 = P0.j.b;
        ((p)(((androidx.compose.runtime.l)object1))).e0();
        if(((p)(((androidx.compose.runtime.l)object1))).O) {
            ((p)(((androidx.compose.runtime.l)object1))).l(i0);
        }
        else {
            ((p)(((androidx.compose.runtime.l)object1))).o0();
        }
        w.x(((androidx.compose.runtime.l)object1), p00, P0.j.f);
        w.x(((androidx.compose.runtime.l)object1), i00, P0.j.e);
        h h0 = P0.j.g;
        if(((p)(((androidx.compose.runtime.l)object1))).O || !q.b(((p)(((androidx.compose.runtime.l)object1))).N(), v)) {
            A7.d.q(v, ((p)(((androidx.compose.runtime.l)object1))), v, h0);
        }
        w.x(((androidx.compose.runtime.l)object1), q0, P0.j.d);
        c.d(((androidx.compose.runtime.l)object1), androidx.compose.foundation.layout.d.q(r0.n.a, 24.0f));
        x.k(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, ((androidx.compose.runtime.l)object1), 0);
        ((p)(((androidx.compose.runtime.l)object1))).p(true);
        return H.a;
    }
}

