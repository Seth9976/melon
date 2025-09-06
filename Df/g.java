package df;

import Jf.k;
import Jf.l;
import Me.e;
import Me.w;
import Me.z;
import Se.c;
import Se.n;
import Ze.v;
import com.google.firebase.messaging.u;
import ie.m;
import java.util.ArrayList;
import je.C;
import kotlin.jvm.internal.q;
import qf.b;
import we.a;

public final class g implements a {
    public final int a;
    public final h b;

    public g(h h0, int v) {
        this.a = v;
        this.b = h0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return c.a(d.v(d.s(this.b.b.a))).a();
            }
            case 1: {
                qf.c c0 = this.b.b();
                Se.d d0 = this.b.b;
                u u0 = this.b.a;
                if(c0 == null) {
                    return l.c(k.Z, new String[]{d0.toString()});
                }
                cf.a a0 = (cf.a)u0.a;
                z z0 = a0.o;
                e e1 = Le.e.b(c0, z0.d());
                if(e1 == null) {
                    n n0 = new n(d.v(d.s(d0.a)));
                    a0.k.getClass();
                    wa.a a1 = (wa.a)a0.k.b;
                    if(a1 != null) {
                        e1 = a1.f(n0);
                        return e1 == null ? w.f(z0, new b(c0.b(), c0.a.f()), a0.d.c().l).g() : e1.g();
                    }
                    q.m("resolver");
                    throw null;
                }
                return e1.g();
            }
            default: {
                h h0 = this.b;
                ArrayList arrayList0 = h0.b.b();
                ArrayList arrayList1 = new ArrayList();
                for(Object object0: arrayList0) {
                    qf.e e0 = ((Se.e)(((gf.a)object0))).a;
                    if(e0 == null) {
                        e0 = v.b;
                    }
                    vf.g g0 = h0.c(((gf.a)object0));
                    m m0 = g0 == null ? null : new m(e0, g0);
                    if(m0 != null) {
                        arrayList1.add(m0);
                    }
                }
                return C.Y(arrayList1);
            }
        }
    }
}

