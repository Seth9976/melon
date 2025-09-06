package td;

import Cc.e0;
import F.E;
import M.j;
import M.w;
import M.y;
import N0.M;
import P0.i;
import U4.x;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import d3.g;
import d9.h;
import ie.H;
import kotlin.jvm.internal.q;
import r0.d;
import r0.n;
import we.a;
import we.k;
import we.o;

public final class s implements o {
    public final a0 a;
    public final boolean b;
    public final h c;
    public final Long d;
    public final k e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final a j;
    public final a k;

    public s(a0 a00, boolean z, h h0, Long long0, k k0, boolean z1, boolean z2, boolean z3, int v, a a0, a a1) {
        this.a = a00;
        this.b = z;
        this.c = h0;
        this.d = long0;
        this.e = k0;
        this.f = z1;
        this.g = z2;
        this.h = z3;
        this.i = v;
        this.j = a0;
        this.k = a1;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        p p1;
        ((Number)object2).intValue();
        q.g(((E)object0), "$this$AnimatedVisibility");
        float f = e0.Z(((l)object1), ((K0)this.a).m());
        if(Float.compare(f, 0.0f) > 0) {
            p p0 = (p)(((l)object1));
            p0.a0(0x9742FA96);
            y y0 = w.a(j.c, d.m, p0, 0);
            int v = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v)) {
                A7.d.q(v, p0, v, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            n n0 = n.a;
            r0.q q1 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), f);
            M m0 = M.p.d(d.a, false);
            int v1 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            if(this.f) {
                p0.a0(0x2257045B);
                p1 = p0;
                g.l((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, (this.g ? d.b : d.h)), this.h, this.i, this.j, this.k, p1, 0);
            }
            else {
                p1 = p0;
                p1.a0(0x21B5D3B9);
            }
            p1.p(false);
            p1.p(true);
            if(this.b) {
                p1.a0(0x287CEE86);
                qd.h.a(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), this.c, this.d != null, this.e, p1, 0);
            }
            else {
                p1.a0(0x27CEBF53);
            }
            p1.p(false);
            p1.p(true);
            p1.p(false);
            return H.a;
        }
        ((p)(((l)object1))).a0(0x96A67982);
        ((p)(((l)object1))).p(false);
        return H.a;
    }
}

