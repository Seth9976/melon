package Mc;

import Cc.T3;
import Cc.U3;
import Cc.c1;
import Cc.e0;
import M.y;
import N0.M;
import O.F;
import O.I;
import Oc.q;
import Oc.r;
import Oc.s;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.C0;
import Q0.N;
import Q0.k0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.J;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import com.iloen.melon.custom.l1;
import com.melon.ui.K4;
import e1.m;
import ie.H;
import r0.d;
import r1.c;
import we.a;
import we.n;

public final class p implements n {
    public final int a;
    public final K4 b;
    public final v c;

    public p(K4 k40, v v0, int v1) {
        this.a = v1;
        this.b = k40;
        this.c = v0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        androidx.compose.runtime.p p0;
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if(((androidx.compose.runtime.p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                s s0 = this.b instanceof s ? ((s)this.b) : null;
                if(s0 == null) {
                    ((androidx.compose.runtime.p)(((l)object0))).a0(1529402095);
                    ((androidx.compose.runtime.p)(((l)object0))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object0))).a0(0x5B28D2F0);
                if(s0 instanceof Oc.p) {
                    ((androidx.compose.runtime.p)(((l)object0))).a0(0xE7140AF9);
                    e0.v(((Oc.p)s0).a, ((androidx.compose.runtime.p)(((l)object0))), 0);
                    ((androidx.compose.runtime.p)(((l)object0))).p(false);
                    p0 = (androidx.compose.runtime.p)(((l)object0));
                }
                else {
                    v v1 = this.c;
                    if(s0 instanceof q) {
                        ((androidx.compose.runtime.p)(((l)object0))).a0(0xE716DAE0);
                        a a0 = v1.getDefaultNetworkErrorHandle().a();
                        a a1 = v1.getDefaultNetworkErrorHandle().b();
                        c1.w(((q)s0).a, a0, a1, 0.0f, 0.0f, ((androidx.compose.runtime.p)(((l)object0))), 0, 24);
                        p0 = (androidx.compose.runtime.p)(((l)object0));
                        p0.p(false);
                        p0.p(false);
                        return H.a;
                    }
                    androidx.compose.runtime.p p1 = (androidx.compose.runtime.p)(((l)object0));
                    if(!(s0 instanceof r)) {
                        throw l1.c(p1, -2091696812, false);
                    }
                    p1.a0(0xE71F2D66);
                    M m0 = M.p.d(d.a, false);
                    int v2 = p1.P;
                    i0 i00 = p1.m();
                    r0.n n0 = r0.n.a;
                    r0.q q0 = r0.a.d(p1, n0);
                    k.y.getClass();
                    i i0 = j.b;
                    p1.e0();
                    if(p1.O) {
                        p1.l(i0);
                    }
                    else {
                        p1.o0();
                    }
                    h h0 = j.f;
                    w.x(p1, m0, h0);
                    h h1 = j.e;
                    w.x(p1, i00, h1);
                    h h2 = j.g;
                    if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v2)) {
                        A7.d.q(v2, p1, v2, h2);
                    }
                    h h3 = j.d;
                    w.x(p1, q0, h3);
                    C0 c00 = N.u(p1);
                    F f0 = I.a(0, 0, 3, p1);
                    r0.q q1 = androidx.compose.ui.input.nestedscroll.a.a(n0, c00, null);
                    y y0 = M.w.a(M.j.c, d.m, p1, 0);
                    int v3 = p1.P;
                    i0 i01 = p1.m();
                    r0.q q2 = r0.a.d(p1, q1);
                    p1.e0();
                    if(p1.O) {
                        p1.l(i0);
                    }
                    else {
                        p1.o0();
                    }
                    w.x(p1, y0, h0);
                    w.x(p1, i01, h1);
                    if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v3)) {
                        A7.d.q(v3, p1, v3, h2);
                    }
                    w.x(p1, q2, h3);
                    U3 u30 = ((r)s0).c;
                    v1.o(((r)s0).a, p1, 6);
                    v1.n(new LayoutWeightElement(1.0f, true), ((r)s0), f0, p1, 0);
                    boolean z = p1.g(f0);
                    boolean z1 = p1.i(v1);
                    t t0 = p1.N();
                    if(z || z1 || t0 == androidx.compose.runtime.k.a) {
                        t0 = new t(f0, v1, null);
                        p1.l0(t0);
                    }
                    J.d(p1, Boolean.TRUE, t0);
                    p1.p(true);
                    b0 b00 = m.x(((Oc.k)v1.i.getValue()).i, p1);
                    p1.a0(0x4F2D254D);
                    r0.q q3 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.h);
                    if(u30.d > 0) {
                        p1.a0(2006878228);
                        c c0 = (c)p1.k(k0.h);
                        Object object2 = b00.getValue();
                        kotlin.jvm.internal.q.d(object2);
                        Object object3 = b00.getValue();
                        kotlin.jvm.internal.q.d(object3);
                        q3 = androidx.compose.foundation.layout.a.n(q3, 0.0f, 0.0f, 0.0f, c0.R(((Number)((ie.m)object2).b).intValue() - ((Number)((ie.m)object3).a).intValue()), 7);
                    }
                    else {
                        p1.a0(2007270905);
                    }
                    p1.p(false);
                    p1.p(false);
                    T3.a(q3, ((r)s0).c, 0.0f, p1, 0, 4);
                    p0 = p1;
                    De.I.V(v1, u30.d <= 0, true);
                    p0.p(true);
                    p0.p(false);
                }
                p0.p(false);
                return H.a;
            }
            ((androidx.compose.runtime.p)(((l)object0))).T();
            return H.a;
        }
        int v4 = (int)(((Integer)object1));
        if(((androidx.compose.runtime.p)(((l)object0))).Q(v4 & 1, (v4 & 3) != 2)) {
            long v5 = e0.T(((androidx.compose.runtime.p)(((l)object0))), 0x7F0604AA);  // color:white000s_support_high_contrast
            m0.b b0 = m0.c.e(110197181, ((androidx.compose.runtime.p)(((l)object0))), new p(this.b, this.c, 1));
            Q1.c.g(androidx.compose.foundation.layout.d.c, null, v5, 0L, 0.0f, b0, ((androidx.compose.runtime.p)(((l)object0))), 0x180006, 58);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object0))).T();
        return H.a;
    }
}

