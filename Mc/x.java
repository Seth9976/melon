package Mc;

import Cc.c1;
import Cc.e0;
import N0.M;
import O.F;
import O.I;
import Oc.A;
import Oc.y;
import Oc.z;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.C0;
import Q0.N;
import androidx.compose.runtime.J;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.custom.l1;
import com.melon.ui.K4;
import ie.H;
import m0.b;
import m0.c;
import r0.d;
import r0.q;
import we.a;
import we.n;

public final class x implements n {
    public final int a;
    public final K4 b;
    public final B c;

    public x(K4 k40, B b0, int v) {
        this.a = v;
        this.b = k40;
        this.c = b0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        p p0;
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                Oc.B b0 = this.b instanceof Oc.B ? ((Oc.B)this.b) : null;
                if(b0 == null) {
                    ((p)(((l)object0))).a0(0x6AE97DAD);
                    ((p)(((l)object0))).p(false);
                    return H.a;
                }
                ((p)(((l)object0))).a0(0x6AE97DAE);
                if(b0 instanceof y) {
                    ((p)(((l)object0))).a0(0xC56229B8);
                    e0.v(((y)b0).a, ((p)(((l)object0))), 0);
                    ((p)(((l)object0))).p(false);
                    p0 = (p)(((l)object0));
                }
                else {
                    B b1 = this.c;
                    if(b0 instanceof z) {
                        ((p)(((l)object0))).a0(0xC564F99F);
                        a a0 = b1.getDefaultNetworkErrorHandle().a();
                        a a1 = b1.getDefaultNetworkErrorHandle().b();
                        p0 = (p)(((l)object0));
                        c1.w(((z)b0).a, a0, a1, 0.0f, 0.0f, p0, 0, 24);
                        p0.p(false);
                    }
                    else if(b0 instanceof A) {
                        ((p)(((l)object0))).a0(0xC56C67C3);
                        M m0 = M.p.d(d.a, false);
                        int v1 = ((p)(((l)object0))).P;
                        i0 i00 = ((p)(((l)object0))).m();
                        q q0 = r0.a.d(((p)(((l)object0))), r0.n.a);
                        k.y.getClass();
                        i i0 = j.b;
                        ((p)(((l)object0))).e0();
                        if(((p)(((l)object0))).O) {
                            ((p)(((l)object0))).l(i0);
                        }
                        else {
                            ((p)(((l)object0))).o0();
                        }
                        w.x(((p)(((l)object0))), m0, j.f);
                        w.x(((p)(((l)object0))), i00, j.e);
                        h h0 = j.g;
                        if(((p)(((l)object0))).O || !kotlin.jvm.internal.q.b(((p)(((l)object0))).N(), v1)) {
                            A7.d.q(v1, ((p)(((l)object0))), v1, h0);
                        }
                        w.x(((p)(((l)object0))), q0, j.d);
                        C0 c00 = N.u(((p)(((l)object0))));
                        F f0 = I.a(0, 0, 3, ((p)(((l)object0))));
                        b1.n(androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c, c00, null), f0, ((A)b0), ((p)(((l)object0))), 0);
                        p0 = (p)(((l)object0));
                        boolean z = p0.g(f0);
                        boolean z1 = p0.i(b1);
                        Mc.A a2 = p0.N();
                        if(z || z1 || a2 == androidx.compose.runtime.k.a) {
                            a2 = new Mc.A(f0, b1, null);
                            p0.l0(a2);
                        }
                        J.d(p0, Boolean.TRUE, a2);
                        p0.p(true);
                        p0.p(false);
                    }
                    else {
                        throw l1.c(((p)(((l)object0))), 1769390935, false);
                    }
                }
                p0.p(false);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            long v2 = e0.T(((p)(((l)object0))), 0x7F0604AA);  // color:white000s_support_high_contrast
            b b2 = c.e(0xAF2F3E9D, ((p)(((l)object0))), new x(this.b, this.c, 1));
            Q1.c.g(androidx.compose.foundation.layout.d.c, null, v2, 0L, 0.0f, b2, ((p)(((l)object0))), 0x180006, 58);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

