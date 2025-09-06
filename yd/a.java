package yd;

import Cc.N1;
import Cc.e0;
import M.c;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import a1.g;
import a1.t;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import r0.q;
import r1.f;
import rd.S;
import wc.u;
import we.n;
import y0.s;

public final class a implements n {
    public final float a;
    public final float b;
    public final b0 c;
    public final boolean d;
    public final String e;
    public final float f;
    public final b0 g;
    public final b0 h;

    public a(float f, float f1, b0 b00, boolean z, String s, float f2, b0 b01, b0 b02) {
        this.a = f;
        this.b = f1;
        this.c = b00;
        this.d = z;
        this.e = s;
        this.f = f2;
        this.g = b01;
        this.h = b02;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        p p0 = (p)(((l)object0));
        if(p0.Q(v & 1, (v & 3) != 2)) {
            q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, this.a, 7);
            r0.n n0 = r0.n.a;
            q q1 = d.j(q0, 0.0f, this.b, 1);
            M m0 = M.p.d(r0.d.a, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            Q0 q00 = androidx.compose.foundation.q.t(p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = w.i(new S(q00, 5));
                p0.l0(e0);
            }
            q q3 = androidx.compose.foundation.q.x(d.f(n0, 1.0f), q00, false, 14);
            vd.k k0 = p0.N();
            if(k0 == v2) {
                k0 = new vd.k(this.c, 6);
                p0.l0(k0);
            }
            q q4 = androidx.compose.ui.layout.a.f(q3, k0);
            y y0 = M.w.a(M.j.e, r0.d.n, p0, 54);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q5, h3);
            String s = this.e;
            b0 b00 = this.g;
            if(this.d) {
                p0.a0(0xCD31071F);
                p0.a0(0x593336CB);
                a1.S s1 = new a1.S(new a1.M(e0.T(p0, 0x7F06017C), 0L, null, null, null, null, null, 0L, null, null, null, 0L, l1.l.c, null, 0xEFFE), null, null, null);  // color:green500s_support_high_contrast
                p0.p(false);
                g g0 = t.h(s, s1, 4);
                float f = ((f)b00.getValue()).a;
                N1.a(g0, null, e0.T(p0, 0x7F060165), f, null, null, 0L, new l1.k(3), 21.0f, 0, false, 0, 0, null, null, null, p0, 0, 6, 0x3F9F2);  // color:gray800s
            }
            else {
                p0.a0(-851600515);
                float f1 = ((f)b00.getValue()).a;
                N1.b(s, null, e0.T(p0, 0x7F060165), f1, null, null, 0L, new l1.k(3), 21.0f, 0, false, 0, 0, null, null, p0, 0, 6, 0x1F9F2);  // color:gray800s
            }
            p0.p(false);
            c.d(p0, d.h(n0, this.f));
            p0.p(true);
            if(!((Boolean)this.h.getValue()).booleanValue() || !((Boolean)e0.getValue()).booleanValue()) {
                p0.a0(1360574834);
            }
            else {
                p0.a0(0x517F7531);
                q q6 = androidx.compose.foundation.q.e(d.h(d.f(n0, 1.0f), 60.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F0604AB))}), 0.0f, 0.0f, 14), null, 6);  // color:transparent
                M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.h), p0, 0);
            }
            p0.p(false);
            p0.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

