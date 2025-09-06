package Cc;

import A7.d;
import Ac.A2;
import Ac.D;
import Ac.X2;
import M.Q;
import P0.h;
import P0.i;
import P0.j;
import Q0.k0;
import T.e;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import d5.n;
import gd.E8;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.a;
import s0.g;
import we.k;
import we.o;
import y0.M;

public final class z0 implements o {
    public final int a;
    public final List b;
    public final k c;

    public z0(List list0, int v, k k0) {
        this.a = v;
        this.b = list0;
        this.c = k0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v7;
        int v6;
        int v3;
        int v2;
        if(this.a != 0) {
            int v = (int)(((Integer)object2));
            q.g(((Q)object0), "$this$FlowRow");
            p p0 = (p)(((l)object1));
            if(p0.Q(v & 1, (v & 17) != 16)) {
                int v1 = 0;
                for(Object object3: this.b) {
                    if(v1 >= 0) {
                        if(((E8)object3).c) {
                            v2 = 0x5274B59F;
                            v3 = 0x7F060159;  // color:gray400s_support_high_contrast
                        }
                        else {
                            v2 = 0x527683F5;
                            v3 = 0x7F060145;  // color:gray050s
                        }
                        long v4 = d.f(p0, v2, v3, p0, false);
                        r0.q q0 = a.a(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.f(n.o(androidx.compose.foundation.layout.d.u(r0.n.a, 3), e.b(15.0f)), v4, M.a), 9.0f, 6.0f, 9.0f, 6.0f), new X2(((E8)object3), this.c, v1, 12));
                        N0.M m0 = M.p.d(r0.d.e, false);
                        int v5 = p0.P;
                        i0 i00 = p0.m();
                        r0.q q1 = a.d(p0, q0);
                        P0.k.y.getClass();
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
                        h h0 = j.g;
                        if(p0.O || !q.b(p0.N(), v5)) {
                            d.q(v5, p0, v5, h0);
                        }
                        w.x(p0, q1, j.d);
                        String s = "#" + ((E8)object3).a;
                        if(((E8)object3).c) {
                            v6 = 0x4313955E;
                            v7 = 0x7F0604A1;  // color:white000e
                        }
                        else {
                            v6 = 0x431552DF;
                            v7 = 0x7F060165;  // color:gray800s
                        }
                        N1.b(s, null, d.f(p0, v6, v7, p0, false), 0.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0, 0xC30, 0x1D7FA);
                        p0.p(true);
                        ++v1;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
            }
            else {
                p0.T();
            }
            return H.a;
        }
        ((Integer)object2).getClass();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x4B98F9C3);
        g g0 = (g)((p)(((l)object1))).k(k0.b);
        List list0 = this.b;
        boolean z = ((p)(((l)object1))).g(list0);
        s0.j j0 = ((p)(((l)object1))).N();
        V v8 = androidx.compose.runtime.k.a;
        if(z || j0 == v8) {
            j0 = new s0.j(list0, this.c);
            ((p)(((l)object1))).l0(j0);
        }
        ((s0.k)((p)(((l)object1))).k(k0.c)).a.put(j0.d, j0);
        boolean z1 = ((p)(((l)object1))).i(j0);
        A2 a20 = ((p)(((l)object1))).N();
        if(z1 || a20 == v8) {
            a20 = new A2(j0, 8);
            ((p)(((l)object1))).l0(a20);
        }
        r0.q q2 = androidx.compose.ui.layout.a.d(((r0.q)object0), a20);
        boolean z2 = ((p)(((l)object1))).i(g0);
        boolean z3 = ((p)(((l)object1))).i(j0);
        D d0 = ((p)(((l)object1))).N();
        if(z2 || z3 || d0 == v8) {
            d0 = new D(17, g0, j0);
            ((p)(((l)object1))).l0(d0);
        }
        r0.q q3 = androidx.compose.ui.focus.a.b(q2, d0);
        ((p)(((l)object1))).p(false);
        return q3;
    }
}

