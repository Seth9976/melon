package sd;

import Ac.e1;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import we.a;
import we.n;
import x1.e;
import x1.j;

public final class k extends r implements n {
    public final b0 f;
    public final j g;
    public final a h;
    public final boolean i;
    public final String j;
    public final String k;

    public k(b0 b00, j j0, a a0, boolean z, String s, String s1) {
        this.f = b00;
        this.g = j0;
        this.h = a0;
        this.i = z;
        this.j = s;
        this.k = s1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
            ((p)(((l)object0))).T();
            return h0;
        }
        this.f.setValue(h0);
        j j0 = this.g;
        int v = j0.b;
        j0.h();
        ((p)(((l)object0))).a0(0x4F53A99E);
        wa.a a0 = j0.f();
        e e0 = ((j)a0.a).e();
        e e1 = ((j)a0.a).e();
        e e2 = ((j)a0.a).e();
        r0.n n0 = r0.n.a;
        q q0 = d.n(n0, 18.0f);
        boolean z = this.i;
        boolean z1 = ((p)(((l)object0))).h(z);
        sd.l l0 = ((p)(((l)object0))).N();
        V v1 = androidx.compose.runtime.k.a;
        if(z1 || l0 == v1) {
            l0 = new sd.l(z);
            ((p)(((l)object0))).l0(l0);
        }
        c1.n(j.b(q0, e0, l0), 0x7F080676, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object0))), 25008, 0, 0x7FE8);  // drawable:img_simple_dj_16
        m m0 = ((p)(((l)object0))).N();
        if(m0 == v1) {
            m0 = m.b;
            ((p)(((l)object0))).l0(m0);
        }
        q q1 = X0.n.b(n0, m0);
        boolean z2 = ((p)(((l)object0))).g(e0);
        e1 e10 = ((p)(((l)object0))).N();
        if(z2 || e10 == v1) {
            e10 = new e1(e0, 8);
            ((p)(((l)object0))).l0(e10);
        }
        q q2 = j.b(q1, e1, e10);
        long v2 = e0.T(((p)(((l)object0))), 0x7F06016D);  // color:gray900s
        N1.b(this.j, q2, v2, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((p)(((l)object0))), 0xC00, 0xC30, 0x1D7F0);
        m m1 = ((p)(((l)object0))).N();
        if(m1 == v1) {
            m1 = m.c;
            ((p)(((l)object0))).l0(m1);
        }
        q q3 = j.b(n0, e2, m1);
        m m2 = ((p)(((l)object0))).N();
        if(m2 == v1) {
            m2 = m.d;
            ((p)(((l)object0))).l0(m2);
        }
        q q4 = X0.n.b(q3, m2);
        long v3 = e0.T(((p)(((l)object0))), 0x7F060160);  // color:gray600s_support_high_contrast
        N1.b(this.k, q4, v3, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((p)(((l)object0))), 0xC00, 0xC30, 0x1D7F0);
        ((p)(((l)object0))).p(false);
        if(j0.b != v) {
            J.h(this.h, ((p)(((l)object0))));
        }
        return h0;
    }
}

