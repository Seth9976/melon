package androidx.compose.animation;

import A7.d;
import Ac.J;
import F.A;
import F.C;
import F.D;
import F.F;
import F.L;
import F.M;
import F.O;
import F.S;
import F.X;
import F.Y;
import F.c;
import F.n0;
import F.t;
import F.u;
import F.y;
import F.z;
import G.P;
import G.l0;
import G.t0;
import G.w0;
import G.y0;
import G.z0;
import P0.h;
import P0.i;
import P0.j;
import U4.x;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.graphics.a;
import r0.q;
import we.k;
import we.n;

public abstract class b {
    public static final void a(t0 t00, k k0, q q0, X x0, Y y0, n n0, m0.b b0, l l0, int v) {
        Y y2;
        X x3;
        l0 l012;
        l0 l011;
        l0 l010;
        l0 l08;
        l0 l07;
        int v10;
        l0 l05;
        l0 l03;
        l0 l01;
        n0 n01;
        V v9;
        t0 t02;
        int v7;
        p p0 = (p)l0;
        p0.c0(0xCAD5A942);
        int v1 = (v & 6) == 0 ? (p0.g(t00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.g(x0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.g(y0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(n0) ? 0x20000 : 0x10000);
        }
        int v2 = (0xC00000 & v) == 0 ? v1 | 0x180000 | (p0.i(b0) ? 0x800000 : 0x400000) : v1 | 0x180000;
        if(!p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            p0.T();
        }
        else if(!((Boolean)k0.invoke(((O0)t00.d).getValue())).booleanValue() && !((Boolean)k0.invoke(t00.c())).booleanValue() && !t00.g() && !t00.d()) {
            p0.a0(1790694746);
            p0.p(false);
        }
        else {
            p0.a0(0x6A9AB186);
            int v3 = v2 & 14 | 0x30;
            boolean z = (v3 & 14 ^ 6) > 4 && p0.g(t00) || (v3 & 6) == 4;
            Object object0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z || object0 == v4) {
                object0 = t00.c();
                p0.l0(object0);
            }
            if(t00.g()) {
                object0 = t00.c();
            }
            p0.a0(0xE42FFE03);
            L l1 = b.g(t00, k0, object0, p0);
            p0.p(false);
            Object object1 = ((O0)t00.d).getValue();
            p0.a0(0xE42FFE03);
            L l2 = b.g(t00, k0, object1, p0);
            p0.p(false);
            int v5 = v3 & 14 | 0xC00;
            int v6 = v5 & 14 ^ 6;
            boolean z1 = v6 > 4 && p0.g(t00) || (v5 & 6) == 4;
            t0 t01 = p0.N();
            if(z1 || t01 == v4) {
                v7 = v5;
                t01 = new t0(new P(l1), t00, x.m(new StringBuilder(), t00.c, " > EnterExitTransition"));
                p0.l0(t01);
            }
            else {
                v7 = v5;
            }
            boolean z2 = v6 > 4 && p0.g(t00) || (v7 & 6) == 4;
            boolean z3 = p0.g(t01);
            J j0 = p0.N();
            if(z2 || z3 || j0 == v4) {
                j0 = new J(14, t00, t01);
                p0.l0(j0);
            }
            androidx.compose.runtime.J.b(t01, j0, p0);
            if(t00.g()) {
                t01.j(l1, l2);
            }
            else {
                t01.k(l2);
                ((O0)t01.k).setValue(Boolean.FALSE);
            }
            b0 b00 = w.w(n0, p0);
            Object object2 = t01.c();
            b0 b01 = t01.d;
            Object object3 = n0.invoke(object2, ((O0)b01).getValue());
            boolean z4 = p0.g(t01);
            boolean z5 = p0.g(b00);
            F.x x1 = p0.N();
            if(z4 || z5 || x1 == v4) {
                x1 = new F.x(t01, b00, null);
                p0.l0(x1);
            }
            b0 b02 = w.t(p0, object3, x1);
            if(t01.c() != L.c || ((O0)b01).getValue() != L.c || !((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(0x6AAA653B);
                F f0 = p0.N();
                if((v2 & 14) == 4 || f0 == v4) {
                    f0 = new F();
                    p0.l0(f0);
                }
                boolean z6 = p0.g(t01);
                b0 b03 = p0.N();
                if(z6 || b03 == v4) {
                    b03 = w.s(x0);
                    p0.l0(b03);
                }
                if(t01.c() != ((O0)b01).getValue() || t01.c() != L.b) {
                    if(((O0)b01).getValue() == L.b) {
                        b03.setValue(((X)b03.getValue()).a(x0));
                    }
                }
                else if(t01.g()) {
                    b03.setValue(x0);
                }
                else {
                    b03.setValue(X.b);
                }
                X x2 = (X)b03.getValue();
                boolean z7 = p0.g(t01);
                b0 b04 = p0.N();
                if(z7 || b04 == v4) {
                    b04 = w.s(y0);
                    p0.l0(b04);
                }
                if(t01.c() != ((O0)b01).getValue() || t01.c() != L.b) {
                    if(((O0)b01).getValue() != L.b) {
                        b04.setValue(((Y)b04.getValue()).a(y0));
                    }
                }
                else if(t01.g()) {
                    b04.setValue(y0);
                }
                else {
                    b04.setValue(Y.b);
                }
                Y y1 = (Y)b04.getValue();
                n0 n00 = x2.a;
                int v8 = n00.c != null || y1.a.c != null ? 1 : 0;
                if(n00.b == null && y1.a.b == null) {
                    t02 = t01;
                    v9 = v4;
                    n01 = n00;
                    p0.a0(0xCF0FB728);
                    p0.p(false);
                    l01 = null;
                }
                else {
                    p0.a0(0xCF0E19DD);
                    y0 y00 = z0.g;
                    String s = p0.N();
                    if(s == v4) {
                        s = "Built-in slide";
                        p0.l0("Built-in slide");
                    }
                    t02 = t01;
                    v9 = v4;
                    n01 = n00;
                    l0 l00 = w0.b(t02, y00, s, p0, 0x180, 0);
                    p0.p(false);
                    l01 = l00;
                }
                if(v8 == 0) {
                    p0.a0(-820851041);
                    p0.p(false);
                    l03 = null;
                }
                else {
                    p0.a0(0xCF111DB7);
                    y0 y01 = z0.h;
                    String s1 = p0.N();
                    if(s1 == v9) {
                        s1 = "Built-in shrink/expand";
                        p0.l0("Built-in shrink/expand");
                    }
                    l0 l02 = w0.b(t02, y01, s1, p0, 0x180, 0);
                    p0.p(false);
                    l03 = l02;
                }
                if(v8 == 0) {
                    p0.a0(-820608001);
                    p0.p(false);
                    l05 = null;
                }
                else {
                    p0.a0(0xCF13EE1A);
                    y0 y02 = z0.g;
                    String s2 = p0.N();
                    if(s2 == v9) {
                        s2 = "Built-in InterruptionHandlingOffset";
                        p0.l0("Built-in InterruptionHandlingOffset");
                    }
                    l0 l04 = w0.b(t02, y02, s2, p0, 0x180, 0);
                    p0.p(false);
                    l05 = l04;
                }
                boolean z8 = n01.d != null || y1.a.d != null;
                if(n01.a == null && y1.a.a == null) {
                    v10 = v8 ^ 1;
                    p0.a0(0xD7C67D6F);
                    p0.p(false);
                    l07 = null;
                }
                else {
                    p0.a0(-675026101);
                    y0 y03 = z0.a;
                    String s3 = p0.N();
                    if(s3 == v9) {
                        s3 = "Built-in alpha";
                        p0.l0("Built-in alpha");
                    }
                    v10 = v8 ^ 1;
                    l0 l06 = w0.b(t02, y03, s3, p0, 0x180, 0);
                    p0.p(false);
                    l07 = l06;
                }
                if(z8) {
                    p0.a0(-674790005);
                    y0 y04 = z0.a;
                    String s4 = p0.N();
                    if(s4 == v9) {
                        s4 = "Built-in scale";
                        p0.l0("Built-in scale");
                    }
                    l08 = l07;
                    l0 l09 = w0.b(t02, y04, s4, p0, 0x180, 0);
                    p0.p(false);
                    l010 = l09;
                }
                else {
                    l08 = l07;
                    p0.a0(0xD7CA17AF);
                    p0.p(false);
                    l010 = null;
                }
                if(z8) {
                    p0.a0(0xD7CB46E8);
                    l011 = l010;
                    l012 = w0.b(t02, S.a, "TransformOriginInterruptionHandling", p0, 0x180, 0);
                    p0.p(false);
                }
                else {
                    l011 = l010;
                    p0.a0(0xD7CDE44F);
                    p0.p(false);
                    l012 = null;
                }
                boolean z9 = p0.i(l08);
                boolean z10 = p0.g(x2);
                boolean z11 = p0.g(y1);
                boolean z12 = p0.i(l011);
                boolean z13 = p0.g(t02);
                boolean z14 = p0.i(l012);
                M m0 = p0.N();
                if((z9 | z10 | z11 | z12 | z13 | z14) != 0 || m0 == v9) {
                    x3 = x2;
                    y2 = y1;
                    m0 = new M(l08, l011, t02, x3, y2, l012);
                    p0.l0(m0);
                }
                else {
                    x3 = x2;
                    y2 = y1;
                }
                boolean z15 = p0.h(((boolean)v10));
                O o0 = O.f;
                boolean z16 = p0.g(o0);
                F.P p1 = p0.N();
                if(z15 || z16 || p1 == v9) {
                    p1 = new F.P(((boolean)v10), o0, 0);
                    p0.l0(p1);
                }
                q q1 = a.a(r0.n.a, p1).then(new EnterExitTransitionElement(t02, l03, l05, l01, x3, y2, o0, m0));
                p0.a0(0x5E4809F0);
                p0.p(false);
                q q2 = q0.then(q1.then(r0.n.a));
                t t0 = p0.N();
                if(t0 == v9) {
                    t0 = new t(f0);
                    p0.l0(t0);
                }
                int v11 = p0.P;
                i0 i00 = p0.m();
                q q3 = r0.a.d(p0, q2);
                P0.k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, t0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                    d.q(v11, p0, v11, h0);
                }
                w.x(p0, q3, j.d);
                b0.invoke(f0, p0, ((int)(v2 >> 18 & 0x70)));
                p0.p(true);
            }
            else {
                p0.a0(1790688794);
            }
            p0.p(false);
            p0.p(false);
        }
        androidx.compose.runtime.n0 n02 = p0.t();
        if(n02 != null) {
            n02.d = new u(t00, k0, q0, x0, y0, n0, b0, v);
        }
    }

    public static final void b(P p0, q q0, X x0, Y y0, String s, m0.b b0, l l0, int v) {
        Y y2;
        q q1;
        String s1;
        ((p)l0).c0(0xF2B6D706);
        int v1 = v | (((p)l0).g(p0) ? 4 : 2) | 0x30 | (((p)l0).g(x0) ? 0x100 : 0x80) | 0x6C00;
        if(((p)l0).Q(v1 & 1, (74899 & v1) != 74898)) {
            Y y1 = S.c(null, 3).a(S.e());
            b.f(w0.d(p0, ((p)l0), v1 & 14 | 0x30), c.k, r0.n.a, x0, y1, b0, ((p)l0), v1 << 3 & 0x1C00 | 0x361B0);
            s1 = "AnimatedVisibility";
            q1 = r0.n.a;
            y2 = y1;
        }
        else {
            ((p)l0).T();
            q1 = q0;
            y2 = y0;
            s1 = s;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new y(p0, q1, x0, y2, s1, b0, v, 1);
        }
    }

    public static final void c(boolean z, q q0, X x0, Y y0, String s, m0.b b0, l l0, int v) {
        Y y2;
        q q1;
        String s1;
        ((p)l0).c0(1766503102);
        int v1 = (((p)l0).h(z) ? 0x20 : 16) | v | 0x180;
        if((v & 0xC00) == 0) {
            v1 |= (((p)l0).g(x0) ? 0x800 : 0x400);
        }
        if(((p)l0).Q((v1 | 0x36000) & 1, (0x92491 & (v1 | 0x36000)) != 0x92490)) {
            Y y1 = S.c(null, 3).a(S.f());
            b.f(w0.e(Boolean.valueOf(z), "AnimatedVisibility", ((p)l0), (v1 | 0x36000) >> 3 & 14 | 0x30), c.j, r0.n.a, x0, y1, b0, ((p)l0), (v1 | 0x36000) & 0x1C00 | 0x361B0);
            s1 = "AnimatedVisibility";
            q1 = r0.n.a;
            y2 = y1;
        }
        else {
            ((p)l0).T();
            q1 = q0;
            y2 = y0;
            s1 = s;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new A(z, q1, x0, y2, s1, b0, v);
        }
    }

    public static final void d(boolean z, q q0, X x0, Y y0, String s, m0.b b0, l l0, int v, int v1) {
        Y y2;
        q q2;
        String s1;
        ((p)l0).c0(0x7C7F8C4E);
        int v2 = (v & 6) == 0 ? (((p)l0).h(z) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (((p)l0).g(q0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (((p)l0).g(x0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (((p)l0).g(y0) ? 0x800 : 0x400);
        }
        int v3 = (0x30000 & v) == 0 ? v2 | 0x6000 | (((p)l0).i(b0) ? 0x20000 : 0x10000) : v2 | 0x6000;
        if(((p)l0).Q(v3 & 1, (74899 & v3) != 74898)) {
            q q1 = (v1 & 2) == 0 ? q0 : r0.n.a;
            Y y1 = (v1 & 8) == 0 ? y0 : S.e().a(S.c(null, 3));
            b.f(w0.e(Boolean.valueOf(z), "AnimatedVisibility", ((p)l0), v3 & 14 | v3 >> 9 & 0x70), c.i, q1, x0, y1, b0, ((p)l0), v3 << 3 & 0xE000 | (v3 << 3 & 0x380 | 0x30 | v3 << 3 & 0x1C00) | v3 & 0x70000);
            s1 = "AnimatedVisibility";
            q2 = q1;
            y2 = y1;
        }
        else {
            ((p)l0).T();
            q2 = q0;
            y2 = y0;
            s1 = s;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(z, q2, x0, y2, s1, b0, v, v1);
        }
    }

    public static final void e(P p0, q q0, X x0, Y y0, String s, m0.b b0, l l0, int v) {
        Y y2;
        q q1;
        String s1;
        ((p)l0).c0(0xCD4C0296);
        int v1 = v | (((p)l0).g(p0) ? 0x20 : 16) | 0x36180;
        if(((p)l0).Q(v1 & 1, (0x92491 & v1) != 0x92490)) {
            Y y1 = S.f().a(S.c(null, 3));
            b.f(w0.d(p0, ((p)l0), v1 >> 3 & 14 | 0x30), c.h, r0.n.a, x0, y1, b0, ((p)l0), 0x36DB0);
            s1 = "AnimatedVisibility";
            q1 = r0.n.a;
            y2 = y1;
        }
        else {
            ((p)l0).T();
            q1 = q0;
            y2 = y0;
            s1 = s;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new y(p0, q1, x0, y2, s1, b0, v, 0);
        }
    }

    public static final void f(t0 t00, k k0, q q0, X x0, Y y0, m0.b b0, l l0, int v) {
        ((p)l0).c0(0x19A0F3EB);
        int v1 = (v & 6) == 0 ? (((p)l0).g(t00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).g(q0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((p)l0).g(x0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (((p)l0).g(y0) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v1 |= (((p)l0).i(b0) ? 0x20000 : 0x10000);
        }
        int v2 = 0;
        if(((p)l0).Q(v1 & 1, (74899 & v1) != 74898)) {
            if((v1 & 14) == 4) {
                v2 = 1;
            }
            C c0 = ((p)l0).N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | v2) != 0 || c0 == androidx.compose.runtime.k.a) {
                c0 = new C(k0, t00);
                ((p)l0).l0(c0);
            }
            b.a(t00, k0, androidx.compose.ui.layout.a.b(q0, c0), x0, y0, F.j.h, b0, ((p)l0), 0x30000 | v1 & 14 | v1 & 0x70 | v1 & 0x1C00 | 0xE000 & v1 | v1 << 6 & 0x1C00000);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new D(t00, k0, q0, x0, y0, b0, v);
        }
    }

    public static final L g(t0 t00, k k0, Object object0, l l0) {
        L l1;
        ((p)l0).X(-902032957, t00);
        if(t00.g()) {
            ((p)l0).a0(2101770115);
            ((p)l0).p(false);
            if(((Boolean)k0.invoke(object0)).booleanValue()) {
                l1 = L.b;
            }
            else if(((Boolean)k0.invoke(t00.c())).booleanValue()) {
                l1 = L.c;
            }
            else {
                l1 = L.a;
            }
        }
        else {
            ((p)l0).a0(2102044248);
            b0 b00 = ((p)l0).N();
            if(b00 == androidx.compose.runtime.k.a) {
                b00 = w.s(Boolean.FALSE);
                ((p)l0).l0(b00);
            }
            if(((Boolean)k0.invoke(t00.c())).booleanValue()) {
                b00.setValue(Boolean.TRUE);
            }
            if(((Boolean)k0.invoke(object0)).booleanValue()) {
                l1 = L.b;
            }
            else {
                l1 = ((Boolean)b00.getValue()).booleanValue() ? L.c : L.a;
            }
            ((p)l0).p(false);
        }
        ((p)l0).p(false);
        return l1;
    }
}

