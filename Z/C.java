package Z;

import M.i0;
import M.j;
import M.n0;
import M.p0;
import M.r0;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import b0.b;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import we.n;
import we.o;

public final class c extends r implements n {
    public final int f;
    public final i0 g;
    public final o h;

    public c(i0 i00, o o0, int v) {
        this.f = v;
        this.g = i00;
        this.h = o0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                int v1 = ((Number)object1).intValue();
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    q q2 = a.i(d.a(r0.n.a, Z.a.b, Z.a.c), this.g);
                    p0 p01 = n0.a(j.e, r0.d.k, ((p)(((l)object0))), 54);
                    int v2 = ((p)(((l)object0))).P;
                    androidx.compose.runtime.i0 i01 = ((p)(((l)object0))).m();
                    q q3 = r0.a.d(((p)(((l)object0))), q2);
                    k.y.getClass();
                    i i1 = P0.j.b;
                    ((p)(((l)object0))).e0();
                    if(((p)(((l)object0))).O) {
                        ((p)(((l)object0))).l(i1);
                    }
                    else {
                        ((p)(((l)object0))).o0();
                    }
                    w.x(((p)(((l)object0))), p01, P0.j.f);
                    w.x(((p)(((l)object0))), i01, P0.j.e);
                    h h1 = P0.j.g;
                    if(((p)(((l)object0))).O || !kotlin.jvm.internal.q.b(((p)(((l)object0))).N(), v2)) {
                        A7.d.q(v2, ((p)(((l)object0))), v2, h1);
                    }
                    w.x(((p)(((l)object0))), q3, P0.j.d);
                    this.h.invoke(r0.a, ((p)(((l)object0))), 6);
                    ((p)(((l)object0))).p(true);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 1: {
                int v3 = ((Number)object1).intValue();
                if(((p)(((l)object0))).Q(v3 & 1, (v3 & 3) != 2)) {
                    T.a(((U)((p)(((l)object0))).k(V.b)).k, m0.c.e(-630330208, ((p)(((l)object0))), new c(this.g, this.h, 0)), ((p)(((l)object0))), 0x30);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            default: {
                if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
                    ((p)(((l)object0))).T();
                    return H.a;
                }
                q q0 = a.i(d.a(r0.n.a, b.b, b.c), this.g);
                p0 p00 = n0.a(j.e, r0.d.k, ((l)object0), 54);
                int v = ((p)(((l)object0))).P;
                androidx.compose.runtime.i0 i00 = ((p)(((l)object0))).m();
                q q1 = r0.a.d(((l)object0), q0);
                k.y.getClass();
                i i0 = P0.j.b;
                ((p)(((l)object0))).e0();
                if(((p)(((l)object0))).O) {
                    ((p)(((l)object0))).l(i0);
                }
                else {
                    ((p)(((l)object0))).o0();
                }
                w.x(((l)object0), p00, P0.j.f);
                w.x(((l)object0), i00, P0.j.e);
                h h0 = P0.j.g;
                if(((p)(((l)object0))).O || !kotlin.jvm.internal.q.b(((p)(((l)object0))).N(), v)) {
                    A7.d.q(v, ((p)(((l)object0))), v, h0);
                }
                w.x(((l)object0), q1, P0.j.d);
                this.h.invoke(r0.a, ((l)object0), 6);
                ((p)(((l)object0))).p(true);
                return H.a;
            }
        }
    }
}

