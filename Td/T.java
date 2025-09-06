package td;

import Cc.c1;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import d3.g;
import ie.H;
import kotlin.jvm.internal.r;
import oc.M;
import we.a;
import we.n;
import x1.e;
import x1.j;

public final class t extends r implements n {
    public final a B;
    public final b0 f;
    public final j g;
    public final a h;
    public final Boolean i;
    public final a j;
    public final a k;
    public final n l;
    public final boolean m;
    public final a n;
    public final a o;
    public final n r;
    public final M w;

    public t(b0 b00, j j0, a a0, Boolean boolean0, a a1, a a2, n n0, boolean z, a a3, a a4, n n1, M m0, a a5) {
        this.f = b00;
        this.g = j0;
        this.h = a0;
        this.i = boolean0;
        this.j = a1;
        this.k = a2;
        this.l = n0;
        this.m = z;
        this.n = a3;
        this.o = a4;
        this.r = n1;
        this.w = m0;
        this.B = a5;
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
        p p0 = (p)(((l)object0));
        p0.a0(0xA324D763);
        wa.a a0 = j0.f();
        e e0 = ((j)a0.a).e();
        e e1 = ((j)a0.a).e();
        e e2 = ((j)a0.a).e();
        e e3 = ((j)a0.a).e();
        e e4 = ((j)a0.a).e();
        q q0 = p0.N();
        V v1 = k.a;
        if(q0 == v1) {
            q0 = q.g;
            p0.l0(q0);
        }
        r0.n n0 = r0.n.a;
        g.z(j.b(n0, e0, q0), this.i, this.j, p0, 0);
        boolean z = p0.g(e0);
        boolean z1 = p0.g(e2);
        rd.p p1 = p0.N();
        if(z || z1 || p1 == v1) {
            p1 = new rd.p(e0, e2, 22);
            p0.l0(p1);
        }
        c1.E(j.b(n0, e1, p1), this.k, this.l, p0, 0);
        q q1 = p0.N();
        if(q1 == v1) {
            q1 = q.h;
            p0.l0(q1);
        }
        c1.z(0, p0, j.b(n0, e2, q1), this.n, this.m);
        boolean z2 = p0.g(e2);
        boolean z3 = p0.g(e4);
        rd.p p2 = p0.N();
        if(z2 || z3 || p2 == v1) {
            p2 = new rd.p(e2, e4, 23);
            p0.l0(p2);
        }
        c1.x(j.b(n0, e3, p2), this.o, this.r, p0, 0);
        q q2 = p0.N();
        if(q2 == v1) {
            q2 = q.i;
            p0.l0(q2);
        }
        g.x(j.b(n0, e4, q2), this.w, this.B, p0, 0);
        p0.p(false);
        if(j0.b != v) {
            J.h(this.h, p0);
        }
        return h0;
    }
}

