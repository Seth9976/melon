package U;

import A7.d;
import G.I0;
import G.s0;
import I.L0;
import I.Y0;
import I.u0;
import J0.a;
import L2.N;
import P0.h;
import P0.j;
import Q0.R0;
import Q0.T0;
import Q0.e1;
import Q0.g0;
import Q0.h0;
import Q0.k0;
import Q0.y0;
import Q1.c;
import W.t;
import Y.D;
import Y.Q;
import Y.Z;
import a1.M;
import a1.O;
import a1.U;
import a1.e;
import a1.g;
import a1.i;
import android.content.ClipData;
import android.view.KeyEvent;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.platform.AndroidClipboard;
import f1.C;
import f1.F;
import f1.x;
import f1.y;
import ie.H;
import ie.m;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import r0.q;
import we.k;
import y0.T;
import y0.s;
import y0.u;

public abstract class b0 {
    public static final Y a;
    public static final a b;
    public static final a c;

    static {
        b0.a = new Y(1);
        b0.b = new a(0x3F0);
        b0.c = new a(0x3FE);
    }

    public static final void A(int v, int v1) {
        if(v <= 0 || v1 <= 0) {
            L.a.a(("both minLines " + v + " and maxLines " + v1 + " must be greater than zero"));
        }
        if(v > v1) {
            L.a.a(("minLines " + v + " must be less than or equal to maxLines " + v1));
        }
    }

    public static final void a(g g0, q q0, U u0, k k0, int v, boolean z, int v1, int v2, Map map0, u u1, l l0, int v3) {
        boolean z1;
        int v8;
        p p0 = (p)l0;
        p0.c0(0xAFEC53B5);
        int v4 = (v3 & 6) == 0 ? (p0.g(g0) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v4 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v4 |= (p0.g(u0) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            v4 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if((v3 & 0x6000) == 0) {
            v4 |= (p0.e(v) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v3) == 0) {
            v4 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v3) == 0) {
            v4 |= (p0.e(v1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v3) == 0) {
            v4 |= (p0.e(v2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v3) == 0) {
            v4 |= (p0.i(map0) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v3) == 0) {
            v4 |= (p0.i(u1) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v4 & 1, (306783379 & v4) != 306783378)) {
            b0.A(v2, v1);
            if(p0.k(D.a) != null) {
                throw new ClassCastException();
            }
            p0.a0(0xA19AF772);
            p0.p(false);
            int v5 = g0.b.length();
            List list0 = g0.a;
            if(list0 != null) {
                int v6 = list0.size();
                int v7 = 0;
                while(v7 < v6) {
                    e e0 = (e)list0.get(v7);
                    v8 = v4;
                    if(e0.a instanceof O && "androidx.compose.foundation.text.inlineContent".equals(e0.d) && i.b(0, v5, e0.b, e0.c)) {
                        z1 = true;
                        goto label_42;
                    }
                    ++v7;
                    v4 = v8;
                }
            }
            v8 = v4;
            z1 = false;
        label_42:
            if(z1 || V4.u.v(g0)) {
                boolean z2 = true;
                p0.a0(-1582650709);
                if((v8 & 14) != 4) {
                    z2 = false;
                }
                androidx.compose.runtime.b0 b00 = p0.N();
                V v10 = androidx.compose.runtime.k.a;
                if(z2 || b00 == v10) {
                    b00 = w.s(g0);
                    p0.l0(b00);
                }
                g g1 = (g)b00.getValue();
                Object object0 = p0.k(k0.k);
                boolean z3 = p0.g(b00);
                Y0 y00 = p0.N();
                if(z3 || y00 == v10) {
                    y00 = new Y0(b00, 2);
                    p0.l0(y00);
                }
                b0.h(q0, g1, k0, z1, map0, u0, v, z, v1, v2, ((e1.i)object0), u1, y00, p0, v8 >> 3 & 910 | v8 >> 12 & 0xE000 | v8 << 9 & 0x70000 | 0x380000 & v8 << 6 | 0x1C00000 & v8 << 6 | 0xE000000 & v8 << 6 | v8 << 6 & 0x70000000, v8 >> 21 & 0x380 | 0x6000);
            }
            else {
                p0.a0(-1583500636);
                q q1 = b0.z(q0, g0, u0, k0, v, z, v1, v2, ((e1.i)p0.k(k0.k)), null, null, u1, null);
                f f0 = f.c;
                int v9 = p0.P;
                q q2 = r0.a.d(p0, q1);
                i0 i00 = p0.m();
                P0.k.y.getClass();
                P0.i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, f0, j.f);
                w.x(p0, i00, j.e);
                w.x(p0, q2, j.d);
                h h0 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                    d.q(v9, p0, v9, h0);
                }
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new o(g0, q0, u0, k0, v, z, v1, v2, map0, u1, v3, 0);
        }
    }

    public static final void b(g g0, q q0, U u0, k k0, int v, boolean z, int v1, int v2, Map map0, u u1, l l0, int v3) {
        ((p)l0).c0(0xC08FFDC4);
        int v4 = (v3 & 6) == 0 ? (((p)l0).g(g0) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v4 |= (((p)l0).g(q0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v4 |= (((p)l0).g(u0) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            v4 |= (((p)l0).i(k0) ? 0x800 : 0x400);
        }
        if((v3 & 0x6000) == 0) {
            v4 |= (((p)l0).e(v) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v3) == 0) {
            v4 |= (((p)l0).h(z) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v3) == 0) {
            v4 |= (((p)l0).e(v1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v3) == 0) {
            v4 |= (((p)l0).e(v2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v3) == 0) {
            v4 |= (((p)l0).i(map0) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v3) == 0) {
            v4 |= (((p)l0).i(u1) ? 0x20000000 : 0x10000000);
        }
        if(((p)l0).Q(v4 & 1, (306783379 & v4) != 306783378)) {
            b0.a(g0, q0, u0, k0, v, z, v1, v2, map0, u1, ((p)l0), v4 & 0x7FFFFFFE);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new o(g0, q0, u0, k0, v, z, v1, v2, map0, u1, v3, 1);
        }
    }

    public static final void c(String s, q q0, U u0, k k0, int v, boolean z, int v1, int v2, u u1, l l0, int v3, int v4) {
        int v12;
        int v11;
        u u3;
        boolean z2;
        k k3;
        q q1;
        int v7;
        int v6;
        k k1;
        p p0 = (p)l0;
        p0.c0(-1040751001);
        int v5 = (v3 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v5 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v5 |= (p0.g(u0) ? 0x100 : 0x80);
        }
        if((v4 & 8) != 0) {
            v5 |= 0xC00;
            k1 = k0;
        }
        else if((v3 & 0xC00) == 0) {
            k1 = k0;
            v5 |= (p0.i(k1) ? 0x800 : 0x400);
        }
        else {
            k1 = k0;
        }
        if((v4 & 16) != 0) {
            v5 |= 0x6000;
        }
        else if((v3 & 0x6000) == 0) {
            v5 |= (p0.e(v) ? 0x4000 : 0x2000);
        }
        if((v4 & 0x20) != 0) {
            v5 |= 0x30000;
        }
        else if((0x30000 & v3) == 0) {
            v5 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v3) == 0) {
            v5 |= (p0.e(v1) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) != 0) {
            v5 |= 0xC00000;
        }
        else if((0xC00000 & v3) == 0) {
            v5 |= (p0.e(v2) ? 0x800000 : 0x400000);
        }
        if((v4 & 0x100) != 0) {
            v6 = v5 | 0x6000000;
            v7 = v4 & 0x100;
        }
        else if((v3 & 0x6000000) == 0) {
            v7 = v4 & 0x100;
            v6 = v5 | (p0.i(u1) ? 0x4000000 : 0x2000000);
        }
        else {
            v7 = v4 & 0x100;
            v6 = v5;
        }
        if(p0.Q((v6 | 0x30000000) & 1, ((v6 | 0x30000000) & 306783379) != 306783378)) {
            k k2 = (v4 & 8) == 0 ? k1 : null;
            int v8 = (v4 & 16) == 0 ? v : 1;
            boolean z1 = (v4 & 0x20) == 0 ? z : true;
            int v9 = (v4 & 0x80) == 0 ? v2 : 1;
            u u2 = v7 == 0 ? u1 : null;
            b0.A(v9, v1);
            if(p0.k(D.a) != null) {
                throw new ClassCastException();
            }
            p0.a0(0xA1544B12);
            p0.p(false);
            if(k2 == null) {
                p0.a0(0xA1607D5A);
                q1 = q0.then(new TextStringSimpleElement(s, u0, ((e1.i)p0.k(k0.k)), v8, z1, v1, v9, u2));
                p0.p(false);
                k3 = null;
            }
            else {
                p0.a0(0xA156AD05);
                k3 = k2;
                q1 = b0.z(q0, new g(s), u0, k3, v8, z1, v1, v9, ((e1.i)p0.k(k0.k)), null, null, u2, null);
                p0.p(false);
            }
            f f0 = f.c;
            int v10 = p0.P;
            q q2 = r0.a.d(p0, q1);
            i0 i00 = p0.m();
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, f0, j.f);
            w.x(p0, i00, j.e);
            w.x(p0, q2, j.d);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                d.q(v10, p0, v10, h0);
            }
            p0.p(true);
            z2 = z1;
            u3 = u2;
            v11 = v8;
            v12 = v9;
            k1 = k3;
        }
        else {
            p0.T();
            z2 = z;
            v12 = v2;
            u3 = u1;
            v11 = v;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new n(s, q0, u0, k1, v11, z2, v1, v12, u3, v3, v4);
        }
    }

    public static final void d(String s, q q0, U u0, k k0, int v, boolean z, int v1, int v2, u u1, l l0, int v3) {
        ((p)l0).c0(0xB94271D2);
        int v4 = (v3 & 6) == 0 ? (((p)l0).g(s) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v4 |= (((p)l0).g(q0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v4 |= (((p)l0).g(u0) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            v4 |= (((p)l0).i(k0) ? 0x800 : 0x400);
        }
        if((v3 & 0x6000) == 0) {
            v4 |= (((p)l0).e(v) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v3) == 0) {
            v4 |= (((p)l0).h(z) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v3) == 0) {
            v4 |= (((p)l0).e(v1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v3) == 0) {
            v4 |= (((p)l0).e(v2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v3) == 0) {
            v4 |= (((p)l0).i(u1) ? 0x4000000 : 0x2000000);
        }
        if(((p)l0).Q(v4 & 1, (0x2492493 & v4) != 0x2492492)) {
            b0.c(s, q0, u0, k0, v, z, v1, v2, u1, ((p)l0), v4 & 0xFFFFFFE, 0x200);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U.p(s, q0, u0, k0, v, z, v1, v2, u1, v3);
        }
    }

    public static final void e(Q q0, b b0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x89A76B73);
        int v1 = (v & 6) == 0 ? (p0.i(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(b0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            H.n n0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(n0 == v2) {
                n0 = new H.n();
                p0.l0(n0);
            }
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            androidx.compose.runtime.b0 b00 = p0.N();
            if(b00 == v2) {
                b00 = w.s(new p0(0));
                p0.l0(b00);
            }
            B2.o o0 = p0.N();
            if(o0 == v2) {
                o0 = new B2.o(n0, 23);
                p0.l0(o0);
            }
            F.g g0 = new F.g(b00, n0, q0, 17);
            boolean z = q0.k();
            boolean z1 = p0.i(coroutineScope0);
            boolean z2 = p0.i(q0);
            I.i i0 = p0.N();
            if(z1 || z2 || i0 == v2) {
                i0 = new I.i(coroutineScope0, b00, q0, 5);
                p0.l0(i0);
            }
            c.d(n0, o0, g0, null, z, i0, b0, p0, v1 << 15 & 0x380000 | 54);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s0(q0, b0, v, 2);
        }
    }

    public static final void f(x x0, k k0, q q0, U u0, F f0, k k1, T t0, boolean z, int v, int v1, f1.j j0, d0 d00, boolean z1, we.o o0, l l0, int v2, int v3) {
        boolean z27;
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier1;
        y y3;
        f1.p p10;
        e1 e11;
        f1.p p8;
        androidx.compose.runtime.b0 b01;
        r0.n n1;
        f0 f03;
        w0.p p7;
        y y2;
        U.x x3;
        q q3;
        int v28;
        f0 f02;
        f1.p p6;
        y y1;
        G g3;
        V v27;
        f1.D d4;
        t t3;
        H0 h01;
        f0 f01;
        R.b b1;
        w0.h h1;
        int v26;
        w0.p p5;
        int v25;
        int v24;
        int v23;
        x x1;
        boolean z6;
        boolean z5;
        r1.c c2;
        g g1;
        e1.i i1;
        r1.c c1;
        int v17;
        f0 f00;
        V v16;
        int v15;
        f1.p p4;
        f1.D d3;
        int v12;
        w0.p p2;
        p p0 = (p)l0;
        p0.c0(-244533042);
        int v4 = (v2 & 6) == 0 ? v2 | (p0.g(x0) ? 4 : 2) : v2;
        if((v2 & 0x30) == 0) {
            v4 |= (p0.i(k0) ? 0x20 : 16);
        }
        int v5 = 0x80;
        if((v2 & 0x180) == 0) {
            v4 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        int v6 = 0x400;
        if((v2 & 0xC00) == 0) {
            v4 |= (p0.g(u0) ? 0x800 : 0x400);
        }
        int v7 = 0x2000;
        if((v2 & 0x6000) == 0) {
            v4 |= (p0.g(f0) ? 0x4000 : 0x2000);
        }
        int v8 = 0x20000;
        if((v2 & 0x30000) == 0) {
            v4 |= (p0.i(k1) ? 0x20000 : 0x10000);
        }
        if((v2 & 0x180000) == 0) {
            v4 |= (p0.g(null) ? 0x100000 : 0x80000);
        }
        if((v2 & 0xC00000) == 0) {
            v4 |= (p0.g(t0) ? 0x800000 : 0x400000);
        }
        if((v2 & 0x6000000) == 0) {
            v4 |= (p0.h(z) ? 0x4000000 : 0x2000000);
        }
        if((v2 & 0x30000000) == 0) {
            v4 |= (p0.e(v) ? 0x20000000 : 0x10000000);
        }
        int v9 = (v3 & 6) == 0 ? v3 | (p0.e(v1) ? 4 : 2) : v3;
        if((v3 & 0x30) == 0) {
            v9 |= (p0.g(j0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            if(p0.g(d00)) {
                v5 = 0x100;
            }
            v9 |= v5;
        }
        if((v3 & 0xC00) == 0) {
            if(p0.h(z1)) {
                v6 = 0x800;
            }
            v9 |= v6;
        }
        if((v3 & 0x6000) == 0) {
            if(p0.h(false)) {
                v7 = 0x4000;
            }
            v9 |= v7;
        }
        if((v3 & 0x30000) == 0) {
            if(!p0.i(o0)) {
                v8 = 0x10000;
            }
            v9 |= v8;
        }
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (0x92493 & (v9 | 0x180000)) != 0x92492)) {
            p0.V();
            if((v2 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            w0.p p1 = p0.N();
            V v10 = androidx.compose.runtime.k.a;
            if(p1 == v10) {
                p1 = new w0.p();
                p0.l0(p1);
            }
            W.f f1 = p0.N();
            if(f1 == v10) {
                f1 = new W.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.l0(f1);
            }
            y y0 = p0.N();
            if(y0 == v10) {
                y0 = new y(f1);
                p0.l0(y0);
            }
            r1.c c0 = (r1.c)p0.k(k0.h);
            e1.i i0 = (e1.i)p0.k(k0.k);
            long v11 = ((Y.Y)p0.k(Z.a)).b;
            w0.h h0 = (w0.h)p0.k(k0.i);
            e1 e10 = (e1)p0.k(k0.t);
            R0 r00 = (R0)p0.k(k0.p);
            u0 u00 = v != 1 || z || !j0.a ? u0.a : u0.b;
            p0.a0(0x9A5A5F74);
            Object[] arr_object = {u00};
            d5.l l1 = H0.g;
            boolean z2 = p0.g(u00);
            B2.o o1 = p0.N();
            if(z2 || o1 == v10) {
                o1 = new B2.o(u00, 25);
                p0.l0(o1);
            }
            H0 h00 = (H0)d5.w.P(arr_object, l1, null, o1, p0, 0, 4);
            p0.p(false);
            if(((u0)((O0)h00.f).getValue()) != u00) {
                throw new IllegalArgumentException("Mismatching scroller orientation; " + (u00 == u0.a ? "only single-line, non-wrap text fields can scroll horizontally" : "single-line, non-wrap text fields can only scroll horizontally"));
            }
            f1.D d0 = p0.N();
            if((((v4 & 14) == 4 ? 1 : 0) | ((v4 & 0xE000) == 0x4000 ? 1 : 0)) != 0 || d0 == v10) {
                f1.D d1 = P0.a(f0, x0.a);
                a1.T t1 = x0.c;
                if(t1 == null) {
                    p2 = p1;
                    v12 = v4 & 14;
                    d0 = d1;
                }
                else {
                    v12 = v4 & 14;
                    p2 = p1;
                    int v13 = d1.b.t(((int)(t1.a >> 0x20)));
                    int v14 = d1.b.t(((int)(t1.a & 0xFFFFFFFFL)));
                    a1.d d2 = new a1.d(d1.a);
                    d2.a(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, l1.l.c, null, 0xEFFF), Math.min(v13, v14), Math.max(v13, v14));
                    d0 = new f1.D(d2.h(), d1.b);
                }
                p0.l0(d0);
            }
            else {
                p2 = p1;
                v12 = v4 & 14;
            }
            g g0 = d0.a;
            f1.p p3 = d0.b;
            n0 n00 = p0.A();
            if(n00 == null) {
                throw new IllegalStateException("no recompose scope found");
            }
            n00.a |= 1;
            boolean z3 = p0.g(r00);
            Object object0 = p0.N();
            if(z3 || object0 == v10) {
                d3 = d0;
                v16 = v10;
                v17 = v12;
                p4 = p3;
                v15 = v9 | 0x180000;
                g1 = g0;
                c1 = c0;
                i1 = i0;
                f00 = new f0(new U.s0(g0, u0, z, c0, i0, 0), n00, r00);
                p0.l0(f00);
            }
            else {
                d3 = d0;
                p4 = p3;
                v15 = v9 | 0x180000;
                v16 = v10;
                f00 = object0;
                v17 = v12;
                c1 = c0;
                i1 = i0;
                g1 = g0;
            }
            f00.u = k0;
            f00.y = v11;
            f00.r.b = d00;
            f00.r.c = h0;
            f00.j = x0.a;
            U.s0 s00 = f00.a;
            if(kotlin.jvm.internal.q.b(s00.a, g1) && kotlin.jvm.internal.q.b(s00.b, u0) && s00.e == z && s00.f == 1 && s00.c == 0x7FFFFFFF && s00.d == 1 && kotlin.jvm.internal.q.b(s00.g, c1) && kotlin.jvm.internal.q.b(s00.i, je.w.a) && s00.h == i1) {
                c2 = c1;
            }
            else {
                c2 = c1;
                s00 = new U.s0(g1, u0, z, c2, i1, 0);
            }
            if(f00.a != s00) {
                f00.p = true;
            }
            f00.a = s00;
            d5.l l2 = f00.d;
            C c3 = f00.e;
            l2.getClass();
            a1.T t2 = x0.c;
            long v18 = x0.b;
            boolean z4 = kotlin.jvm.internal.q.b(t2, ((V3.d)l2.c).f());
            g g2 = x0.a;
            if(!kotlin.jvm.internal.q.b(((x)l2.b).a.b, g2.b)) {
                l2.c = new V3.d(v18, g2);
                z5 = true;
                z6 = false;
            }
            else if(a1.T.a(((x)l2.b).b, v18)) {
                z5 = false;
                z6 = false;
            }
            else {
                ((V3.d)l2.c).i(a1.T.e(v18), a1.T.d(v18));
                z5 = false;
                z6 = true;
            }
            if(t2 == null) {
                ((V3.d)l2.c).d = -1;
                ((V3.d)l2.c).e = -1;
            }
            else {
                long v19 = t2.a;
                if(!a1.T.b(v19)) {
                    ((V3.d)l2.c).h(a1.T.e(v19), a1.T.d(v19));
                }
            }
            long v20 = 0L;
            if(z5 || !z6 && !z4) {
                ((V3.d)l2.c).d = -1;
                ((V3.d)l2.c).e = -1;
                x1 = x.a(x0, null, 0L, 3);
            }
            else {
                x1 = x0;
            }
            x x2 = (x)l2.b;
            l2.b = x1;
            if(c3 != null) {
                c3.a(x2, x1);
            }
            U.O0 o00 = p0.N();
            if(o00 == v16) {
                o00 = new U.O0();  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.l0(o00);
            }
            long v21 = System.currentTimeMillis();
            if(o00.e) {
                o00.d = v21;
                o00.a(x0);
            }
            else {
                Long long0 = o00.d;
                if(long0 != null) {
                    v20 = (long)long0;
                }
                if(v21 > v20 + 5000L) {
                    o00.d = v21;
                    o00.a(x0);
                }
            }
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v16) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            R.b b0 = p0.N();
            if(b0 == v16) {
                b0 = new R.b();
                p0.l0(b0);
            }
            Q q1 = p0.N();
            if(q1 == v16) {
                q1 = new Q(o00);
                p0.l0(q1);
            }
            q1.b = p4;
            q1.f = f0;
            q1.c = f00.v;
            q1.d = f00;
            ((O0)q1.e).setValue(x0);
            q1.h = (h0)p0.k(k0.f);
            q1.i = coroutineScope0;
            q1.j = (T0)p0.k(k0.q);
            q1.k = (F0.a)p0.k(k0.l);
            q1.l = p2;
            ((O0)q1.m).setValue(Boolean.TRUE);
            ((O0)q1.n).setValue(Boolean.valueOf(z1));
            boolean z7 = p0.i(f00);
            boolean z8 = p0.i(y0);
            int v22 = v15 & 0x70 ^ 0x30;
            if(v22 <= 0x20 || !p0.g(j0)) {
                v23 = v17;
                v24 = (v15 & 0x30) == 0x20 ? 1 : 0;
            }
            else {
                v23 = v17;
                v24 = 1;
            }
            boolean z9 = p0.i(p4);
            boolean z10 = p0.i(coroutineScope0);
            boolean z11 = p0.i(b0);
            boolean z12 = p0.i(q1);
            Object object1 = p0.N();
            if(((v15 & 0x1C00) == 0x800 | z7 | ((v15 & 0xE000) == 0x4000 ? 1 : 0) | z8 | (v17 == 4 ? 1 : 0) | v24 | z9 | z10 | z11 | z12) != 0 || object1 == v16) {
                v25 = v15;
                p5 = p2;
                v26 = v23;
                h1 = h0;
                h01 = h00;
                t3 = f1;
                y1 = y0;
                v27 = v16;
                f01 = f00;
                d4 = d3;
                g3 = new G(f01, z1, y1, x0, j0, p4, q1, coroutineScope0, b0);
                b1 = b0;
                p6 = p4;
                p0.l0(g3);
            }
            else {
                v25 = v15;
                p5 = p2;
                v26 = v23;
                h1 = h0;
                b1 = b0;
                f01 = f00;
                h01 = h00;
                t3 = f1;
                d4 = d3;
                v27 = v16;
                g3 = object1;
                y1 = y0;
                p6 = p4;
            }
            r0.n n0 = r0.n.a;
            q q2 = androidx.compose.foundation.q.q(androidx.compose.ui.focus.a.b(androidx.compose.ui.focus.a.a(n0, p5), g3), z1, null);
            androidx.compose.runtime.b0 b00 = w.w(Boolean.valueOf(z1), p0);
            boolean z13 = p0.g(b00);
            boolean z14 = p0.i(f01);
            boolean z15 = p0.i(y1);
            boolean z16 = p0.i(q1);
            if(v22 <= 0x20 || !p0.g(j0)) {
                f02 = f01;
                v28 = (v25 & 0x30) == 0x20 ? 1 : 0;
            }
            else {
                f02 = f01;
                v28 = 1;
            }
            Object object2 = p0.N();
            if((z13 | z14 | z15 | z16 | v28) != 0 || object2 == v27) {
                q3 = q2;
                p7 = p5;
                n1 = n0;
                f03 = f02;
                x3 = new U.x(f03, b00, y1, q1, j0, null);
                b01 = b00;
                y2 = y1;
                p0.l0(x3);
            }
            else {
                q3 = q2;
                x3 = object2;
                y2 = y1;
                p7 = p5;
                f03 = f02;
                n1 = n0;
                b01 = b00;
            }
            J.d(p0, H.a, x3);
            boolean z17 = p0.i(f03);
            E e0 = p0.N();
            if(z17 || e0 == v27) {
                e0 = new E(f03, 1);
                p0.l0(e0);
            }
            q q4 = J0.H.a(n1, 0x845FED, new H.e(1, e0));
            boolean z18 = p0.i(f03);
            boolean z19 = p0.i(p6);
            boolean z20 = p0.i(q1);
            I i2 = p0.N();
            if((z18 | (v15 & 0xE000) == 0x4000 | ((v15 & 0x1C00) == 0x800 ? 1 : 0) | z19 | z20) != 0 || i2 == v27) {
                p8 = p6;
                I i3 = new I(f03, p7, z1, q1, p8);
                p0.l0(i3);
                i2 = i3;
            }
            else {
                p8 = p6;
            }
            if(z1) {
                q4 = r0.a.a(q4, new J0.C(1, i2));
            }
            P p9 = new P(q1.x, q1.w);
            q q5 = J0.u.f(q4.then(new SuspendPointerInputElement(q1.x, q1.w, p9, 4)), b0.b);
            boolean z21 = p0.i(f03);
            boolean z22 = p0.i(p8);
            F.g g4 = p0.N();
            if((z21 | v26 == 4 | z22) != 0 || g4 == v27) {
                g4 = new F.g(f03, x0, p8, 12);
                p0.l0(g4);
            }
            q q6 = androidx.compose.ui.draw.a.a(n1, g4);
            boolean z23 = p0.i(f03);
            boolean z24 = p0.g(e10);
            boolean z25 = p0.i(q1);
            boolean z26 = p0.i(p8);
            U.H h2 = p0.N();
            if((z23 | (v15 & 0x1C00) == 0x800 | z24 | z25 | (v26 == 4 ? 1 : 0) | z26) != 0 || h2 == v27) {
                p10 = p8;
                y3 = y2;
                U.H h3 = new U.H(f03, z1, e10, q1, x0, p10);
                e11 = e10;
                p0.l0(h3);
                h2 = h3;
            }
            else {
                e11 = e10;
                p10 = p8;
                y3 = y2;
            }
            q q7 = androidx.compose.ui.layout.a.d(n1, h2);
            CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier0 = new CoreTextFieldSemanticsModifier(d4, x0, f03, z1, f0 instanceof f1.q, p10, q1, j0, p7);
            if(!z1 || !((Boolean)((O0)((y0)e11).a).getValue()).booleanValue()) {
                coreTextFieldSemanticsModifier1 = coreTextFieldSemanticsModifier0;
                z27 = false;
            }
            else {
                coreTextFieldSemanticsModifier1 = coreTextFieldSemanticsModifier0;
                z27 = !a1.T.b(((a1.T)((O0)f03.z).getValue()).a) || !a1.T.b(((a1.T)((O0)f03.A).getValue()).a) ? false : true;
            }
            q q8 = z27 ? r0.a.a(n1, new v0(t0, f03, x0, p10)) : n1;
            boolean z28 = p0.i(q1);
            U.y y4 = p0.N();
            if(z28 || y4 == v27) {
                y4 = new U.y(q1, 0);
                p0.l0(y4);
            }
            J.b(q1, y4, p0);
            boolean z29 = p0.i(f03);
            boolean z30 = p0.i(y3);
            int v29 = (v22 <= 0x20 || !p0.g(j0)) && (v25 & 0x30) != 0x20 ? 0 : 1;
            G.a a0 = p0.N();
            if((z29 | z30 | (v26 == 4 ? 1 : 0) | v29) != 0 || a0 == v27) {
                G.a a1 = new G.a(f03, y3, x0, j0, 3);
                p0.l0(a1);
                a0 = a1;
            }
            J.b(j0, a0, p0);
            q q9 = r0.a.a(n1, new z0(f03, q1, x0, true, v == 1, p10, o00, f03.v, j0.e));
            boolean z31 = j0.d != 7 && j0.d != 8;
            boolean z32 = ((Boolean)b01.getValue()).booleanValue();
            boolean z33 = p0.h(z31);
            boolean z34 = p0.i(t3);
            U.J j1 = p0.N();
            if(z33 || z34 || j1 == v27) {
                j1 = new U.J(z31, t3);
                p0.l0(j1);
            }
            q q10 = androidx.compose.foundation.text.handwriting.a.a(z32, z31, j1);
            long v30 = ((s)p0.k(U.i.a)).a;
            boolean z35 = p0.i(f03);
            boolean z36 = p0.f(v30);
            F.p p11 = p0.N();
            if(z35 || z36 || p11 == v27) {
                p11 = new F.p(f03, v30, 2);
                p0.l0(p11);
            }
            q q11 = androidx.compose.ui.layout.a.d(r0.a.a(androidx.compose.ui.input.key.a.c(androidx.compose.ui.input.key.a.c(androidx.compose.foundation.text.input.internal.a.a(q0.then(androidx.compose.ui.draw.a.a(n1, p11)), t3, f03, q1).then(q10).then(q3), new Ld.p(16, h1, f03)), new Ld.p(14, f03, q1)).then(q9), new F0(h01, z1, 0)).then(q5).then(coreTextFieldSemanticsModifier1), new E(f03, 0));
            boolean z37 = z1 && f03.b() && ((Boolean)((O0)f03.q).getValue()).booleanValue() && ((Boolean)((O0)((y0)e11).a).getValue()).booleanValue();
            q q12 = z37 ? r0.a.a(n1, new F.d(q1, 7)) : n1;
            b0.g(q11, q1, m0.c.e(-492537660, p0, new U.C(o0, f03, u0, v1, v, h01, x0, f0, q8, q6, q7, q12, b1, q1, z37, k1, p10, c2)), p0, 0x180);
        }
        else {
            p0.T();
        }
        n0 n01 = p0.t();
        if(n01 != null) {
            n01.d = new U.D(x0, k0, q0, u0, f0, k1, t0, z, v, v1, j0, d00, z1, o0, v2, v3);
        }
    }

    public static final void g(q q0, Q q1, b b0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-20551815);
        int v1 = (p0.g(q0) ? 4 : 2) | v | (p0.i(q1) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            N0.M m0 = M.p.d(r0.d.a, true);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, j.d);
            b0.e(q1, b0, p0, v1 >> 3 & 0x7E);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new L0(q0, q1, b0, v, 4);
        }
    }

    public static final void h(q q0, g g0, k k0, boolean z, Map map0, U u0, int v, boolean z1, int v1, int v2, e1.i i0, u u1, k k1, l l0, int v3, int v4) {
        U.h0 h00;
        k k2;
        androidx.compose.runtime.b0 b01;
        int v20;
        int v15;
        ArrayList arrayList0;
        m m0;
        we.a a1;
        we.a a0;
        U.L0 l01;
        p p0 = (p)l0;
        p0.c0(0x81B92561);
        int v5 = (v3 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v5 |= (p0.g(g0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v5 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        int v6 = 0x400;
        if((v3 & 0xC00) == 0) {
            v5 |= (p0.h(z) ? 0x800 : 0x400);
        }
        int v7 = 0x2000;
        if((v3 & 0x6000) == 0) {
            v5 |= (p0.i(map0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v3) == 0) {
            v5 |= (p0.g(u0) ? 0x20000 : 0x10000);
        }
        if((v3 & 0x180000) == 0) {
            v5 |= (p0.e(v) ? 0x100000 : 0x80000);
        }
        if((v3 & 0xC00000) == 0) {
            v5 |= (p0.h(z1) ? 0x800000 : 0x400000);
        }
        if((v3 & 0x6000000) == 0) {
            v5 |= (p0.e(v1) ? 0x4000000 : 0x2000000);
        }
        if((v3 & 0x30000000) == 0) {
            v5 |= (p0.e(v2) ? 0x20000000 : 0x10000000);
        }
        int v8 = (v4 & 6) == 0 ? v4 | (p0.i(i0) ? 4 : 2) : v4;
        if((v4 & 0x30) == 0) {
            v8 |= (p0.i(null) ? 0x20 : 16);
        }
        if((v4 & 0x180) == 0) {
            v8 |= (p0.i(u1) ? 0x100 : 0x80);
        }
        if((v4 & 0xC00) == 0) {
            if(p0.i(k1)) {
                v6 = 0x800;
            }
            v8 |= v6;
        }
        if((v4 & 0x6000) == 0) {
            if(((0x8000 & v4) == 0 ? p0.g(null) : p0.i(null))) {
                v7 = 0x4000;
            }
            v8 |= v7;
        }
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (v8 & 9363) != 9362)) {
            boolean z2 = V4.u.v(g0);
            V v9 = androidx.compose.runtime.k.a;
            if(z2) {
                p0.a0(-613484007);
                U.L0 l00 = p0.N();
                if((v5 & 0x70) == 0x20 || l00 == v9) {
                    l00 = new U.L0(g0);
                    p0.l0(l00);
                }
                l01 = l00;
                p0.p(false);
            }
            else {
                p0.a0(0xDB6FFA92);
                p0.p(false);
                l01 = null;
            }
            if(V4.u.v(g0)) {
                p0.a0(0xDB7300D9);
                boolean z3 = p0.g(l01);
                G.g g1 = p0.N();
                if((v5 & 0x70) == 0x20 || z3 || g1 == v9) {
                    g1 = new G.g(18, l01, g0);
                    p0.l0(g1);
                }
                a0 = g1;
            }
            else {
                p0.a0(0xDB747CD7);
                B2.o o0 = p0.N();
                if((v5 & 0x70) == 0x20 || o0 == v9) {
                    o0 = new B2.o(g0, 22);
                    p0.l0(o0);
                }
                a0 = o0;
            }
            p0.p(false);
            if(!z) {
                a1 = a0;
                m0 = new m(null, null);
            }
            else if(map0 == null || map0.isEmpty()) {
                a1 = a0;
                m0 = U.g.a;
            }
            else {
                int v10 = g0.b.length();
                a1 = a0;
                List list0 = g0.a;
                if(list0 == null) {
                    arrayList0 = je.w.a;
                }
                else {
                    arrayList0 = new ArrayList(list0.size());
                    int v11 = list0.size();
                    int v12 = 0;
                    while(v12 < v11) {
                        e e0 = (e)list0.get(v12);
                        int v13 = e0.c;
                        int v14 = e0.b;
                        String s = e0.d;
                        if(!(e0.a instanceof O) || !"androidx.compose.foundation.text.inlineContent".equals(s) || !i.b(0, v10, v14, v13)) {
                            v15 = v10;
                        }
                        else {
                            v15 = v10;
                            kotlin.jvm.internal.q.e(e0.a, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                            arrayList0.add(new e(s, v14, v13, ((O)e0.a).a));
                        }
                        ++v12;
                        v10 = v15;
                    }
                }
                ArrayList arrayList1 = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int v16 = arrayList0.size();
                int v17 = 0;
                while(v17 < v16) {
                    e e1 = (e)arrayList0.get(v17);
                    int v18 = e1.c;
                    int v19 = e1.b;
                    W w0 = (W)map0.get(e1.a);
                    if(w0 == null) {
                        v20 = v16;
                    }
                    else {
                        v20 = v16;
                        arrayList1.add(new e(w0.a, v19, v18));
                        arrayList2.add(new e(w0.b, v19, v18));
                    }
                    ++v17;
                    v16 = v20;
                }
                m0 = new m(arrayList1, arrayList2);
            }
            List list1 = (List)m0.a;
            List list2 = (List)m0.b;
            if(z) {
                p0.a0(-612806750);
                androidx.compose.runtime.b0 b00 = p0.N();
                if(b00 == v9) {
                    b00 = w.s(null);
                    p0.l0(b00);
                }
                b01 = b00;
                p0.p(false);
            }
            else {
                p0.a0(-612718990);
                p0.p(false);
                b01 = null;
            }
            if(z) {
                p0.a0(0xDB7C12B3);
                boolean z4 = p0.g(b01);
                Y0 y00 = p0.N();
                if(z4 || y00 == v9) {
                    y00 = new Y0(b01, 3);
                    p0.l0(y00);
                }
                p0.p(false);
                k2 = y00;
            }
            else {
                p0.a0(0xDB7D29B2);
                p0.p(false);
                k2 = null;
            }
            Object object0 = a1.invoke();
            boolean z5 = p0.i(l01);
            U.q q1 = p0.N();
            if(z5 || (v5 & 0x380) == 0x100 || q1 == v9) {
                q1 = new U.q(l01, k0, 0);
                p0.l0(q1);
            }
            q q2 = b0.z(q0, ((g)object0), u0, q1, v, z1, v1, v2, i0, list1, k2, u1, k1);
            if(z) {
                p0.a0(0xDB8F4D48);
                boolean z7 = p0.i(l01);
                r r1 = p0.N();
                if(z7 || r1 == v9) {
                    r1 = new r(l01, 1);
                    p0.l0(r1);
                }
                boolean z8 = p0.g(b01);
                O.m m1 = p0.N();
                if(z8 || m1 == v9) {
                    m1 = new O.m(b01, 2);
                    p0.l0(m1);
                }
                h00 = new M0(0, r1, m1);
            }
            else {
                p0.a0(0xDB8C9AED);
                boolean z6 = p0.i(l01);
                r r0 = p0.N();
                if(z6 || r0 == v9) {
                    r0 = new r(l01, 0);
                    p0.l0(r0);
                }
                h00 = new U.h0(r0, 0);
            }
            p0.p(false);
            int v21 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, h00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v21)) {
                d.q(v21, p0, v21, h0);
            }
            w.x(p0, q3, j.d);
            if(l01 == null) {
                p0.a0(-509592027);
            }
            else {
                p0.a0(0x200D6D5C);
                l01.a(p0, 0);
            }
            p0.p(false);
            if(list2 == null) {
                p0.a0(0xE1A1047F);
            }
            else {
                p0.a0(0xE1A10480);
                U.g.a(g0, list2, p0, v5 >> 3 & 14);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U.s(q0, g0, k0, z, map0, u0, v, z1, v1, v2, i0, u1, k1, v3, v4);
        }
    }

    public static final void i(Q q0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1436003720);
        int v1 = (p0.i(q0) ? 4 : 2) | v;
        if(!p0.Q(v1 & 1, (v1 & 3) != 2)) {
            p0.T();
        }
        else if(q0.d != null && ((Boolean)((O0)q0.d.o).getValue()).booleanValue()) {
            J0 j00 = null;
            g g0 = q0.d == null ? null : q0.d.a.a;
            if(g0 == null || g0.b.length() <= 0) {
                p0.a0(0xEECBD01E);
            }
            else {
                p0.a0(0xEEB7DB0D);
                boolean z = p0.g(q0);
                Y.H h0 = p0.N();
                V v2 = androidx.compose.runtime.k.a;
                if(z || h0 == v2) {
                    h0 = new Y.H(q0, 0);
                    p0.l0(h0);
                }
                r1.c c0 = (r1.c)p0.k(k0.h);
                int v3 = q0.b.t(((int)(q0.m().b >> 0x20)));
                f0 f00 = q0.d;
                if(f00 != null) {
                    j00 = f00.d();
                }
                kotlin.jvm.internal.q.d(j00);
                int v4 = P4.a.j(v3, 0, j00.a.a.a.b.length());
                x0.c c1 = j00.a.c(v4);
                long v5 = ((long)Float.floatToRawIntBits(c0.Y(w0.a) / 2.0f + c1.a)) << 0x20 | 0xFFFFFFFFL & ((long)Float.floatToRawIntBits(c1.d));
                boolean z1 = p0.f(v5);
                L l1 = p0.N();
                if(z1 || l1 == v2) {
                    l1 = new L(v5);
                    p0.l0(l1);
                }
                boolean z2 = p0.i(h0);
                boolean z3 = p0.i(q0);
                P p1 = p0.N();
                if(z2 || z3 || p1 == v2) {
                    p1 = new P(h0, q0);
                    p0.l0(p1);
                }
                q q1 = J0.H.a(r0.n.a, h0, p1);
                boolean z4 = p0.f(v5);
                N n0 = p0.N();
                if(z4 || n0 == v2) {
                    n0 = new N(v5, 2);
                    p0.l0(n0);
                }
                U.e.a(l1, X0.n.c(q1, false, n0), 0L, p0, 0);
            }
            p0.p(false);
        }
        else {
            p0.a0(0xEECBD01E);
            p0.p(false);
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new F.e(q0, v, 12);
        }
    }

    public static final void j(Q q0, boolean z, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(626339208);
        int v1 = (v & 6) == 0 ? (p0.i(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z) ? 0x20 : 16);
        }
        if(!p0.Q(v1 & 1, (v1 & 19) != 18)) {
            p0.T();
        }
        else if(z) {
            p0.a0(0xB30E0CDE);
            f0 f00 = q0.d;
            a1.Q q1 = null;
            if(f00 != null) {
                J0 j00 = f00.d();
                if(j00 != null) {
                    a1.Q q2 = j00.a;
                    if(!(q0.d == null ? true : q0.d.p)) {
                        q1 = q2;
                    }
                }
            }
            if(q1 == null) {
                p0.a0(-1290601288);
            }
            else {
                p0.a0(-1290601287);
                if(a1.T.b(q0.m().b)) {
                    p0.a0(0x9B9D771A);
                }
                else {
                    p0.a0(-1685230508);
                    int v2 = q0.b.t(((int)(q0.m().b >> 0x20)));
                    int v3 = q0.b.t(((int)(q0.m().b & 0xFFFFFFFFL)));
                    l1.j j0 = q1.a(v2);
                    l1.j j1 = q1.a(Math.max(v3 - 1, 0));
                    if(q0.d == null || !((Boolean)((O0)q0.d.m).getValue()).booleanValue()) {
                        p0.a0(0x9B97D59A);
                    }
                    else {
                        p0.a0(0x9B93CD47);
                        V4.u.f(true, j0, q0, p0, v1 << 6 & 0x380 | 6);
                    }
                    p0.p(false);
                    if(q0.d == null || !((Boolean)((O0)q0.d.n).getValue()).booleanValue()) {
                        p0.a0(-1684200998);
                    }
                    else {
                        p0.a0(0x9B991D48);
                        V4.u.f(false, j1, q0, p0, v1 << 6 & 0x380 | 6);
                    }
                    p0.p(false);
                }
                p0.p(false);
                f0 f01 = q0.d;
                if(f01 != null) {
                    androidx.compose.runtime.b0 b00 = f01.l;
                    if(!kotlin.jvm.internal.q.b(q0.u.a.b, q0.m().a.b)) {
                        ((O0)b00).setValue(Boolean.FALSE);
                    }
                    if(f01.b()) {
                        if(((Boolean)((O0)b00).getValue()).booleanValue()) {
                            q0.r();
                        }
                        else {
                            q0.n();
                        }
                    }
                }
            }
            p0.p(false);
            p0.p(false);
        }
        else {
            p0.a0(0x26CFEB7F);
            p0.p(false);
            q0.n();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new K(q0, z, v);
        }
    }

    public static final void k(f0 f00) {
        C c0 = f00.e;
        if(c0 != null) {
            x x0 = x.a(((x)f00.d.b), null, 0L, 3);
            f00.v.invoke(x0);
            y y0 = c0.a;
            AtomicReference atomicReference0 = y0.b;
            while(true) {
                if(atomicReference0.compareAndSet(c0, null)) {
                    y0.a.b();
                    break;
                }
                if(atomicReference0.get() != c0) {
                    break;
                }
            }
        }
        f00.e = null;
    }

    public static final x0.c l(r1.c c0, int v, f1.D d0, a1.Q q0, boolean z, int v1) {
        x0.c c1 = q0 == null ? x0.c.e : q0.c(d0.b.t(v));
        int v2 = c0.z(w0.a);
        float f = z ? ((float)v1) - c1.a - ((float)v2) : c1.a;
        return z ? new x0.c(f, c1.b, ((float)v1) - c1.a, c1.d) : new x0.c(f, c1.b, ((float)v2) + c1.a, c1.d);
    }

    public static final boolean m(int v, KeyEvent keyEvent0) {
        return ((int)(H0.e.J(keyEvent0) >> 0x20)) == v;
    }

    public static final ArrayList n(List list0, we.a a0) {
        I0 i00;
        if(((Boolean)a0.invoke()).booleanValue()) {
            ArrayList arrayList0 = new ArrayList(list0.size());
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                N0.L l0 = (N0.L)list0.get(v1);
                Object object0 = l0.q();
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                e e0 = (e)((N0)object0).a.c;
                a1.Q q0 = (a1.Q)((O0)((U.L0)((N0)object0).a.b).a).getValue();
                if(q0 == null) {
                    i00 = new I0(0, 0, U.h.h);
                }
                else {
                    e e1 = U.L0.c(e0, q0);
                    if(e1 == null) {
                        i00 = new I0(0, 0, U.h.i);
                    }
                    else {
                        r1.k k0 = e1.m.B(q0.i(e1.b, e1.c).c());
                        B2.o o0 = new B2.o(k0, 26);
                        i00 = new I0(k0.c - k0.a, k0.d - k0.b, o0);
                    }
                }
                arrayList0.add(new m(l0.O(df.d.r(i00.b, i00.b, i00.c, i00.c)), ((kotlin.jvm.internal.r)i00.d)));
            }
            return arrayList0;
        }
        return null;
    }

    public static final void o(y y0, f0 f00, x x0, f1.j j0, f1.p p0) {
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        F.g g0 = new F.g(f00.d, f00.v, h0, 14);
        y0.a.f(x0, j0, g0, f00.w);
        C c0 = new C(y0, y0.a);
        y0.b.set(c0);
        h0.a = c0;
        f00.e = c0;
        b0.x(f00, x0, p0);
    }

    public static final void p(a1.d d0, String s, String s1) {
        if(s1.length() <= 0) {
            L.a.a("alternateText can\'t be an empty string.");
        }
        a1.c c0 = new a1.c(new O(s), d0.a.length(), 0, 4);
        d0.b.add(c0);
        d0.c.add(c0);
        d0.b.size();
        d0.d(s1);
        d0.e();
    }

    public static void q(a1.d d0, String s) {
        b0.p(d0, s, "\uFFFD");
    }

    public static final int r(float f) {
        return Math.round(((float)Math.ceil(f)));
    }

    // 去混淆评级： 低(23)
    public static final int s(int v, String s) {
        BreakIterator breakIterator0 = BreakIterator.getCharacterInstance();
        breakIterator0.setText(s);
        return breakIterator0.following(v);
    }

    public static final int t(CharSequence charSequence0, int v) {
        int v1 = charSequence0.length();
        while(v < v1) {
            if(charSequence0.charAt(v) == 10) {
                return v;
            }
            ++v;
        }
        return charSequence0.length();
    }

    public static final int u(CharSequence charSequence0, int v) {
        while(v > 0) {
            if(charSequence0.charAt(v - 1) == 10) {
                return v;
            }
            --v;
        }
        return 0;
    }

    public static final int v(int v, String s) {
        BreakIterator breakIterator0 = BreakIterator.getCharacterInstance();
        breakIterator0.setText(s);
        return breakIterator0.preceding(v);
    }

    public static final Object w(Q q0, oe.c c0) {
        boolean z3;
        int v6;
        int v5;
        Q q1;
        boolean z2;
        int v4;
        int v3;
        boolean z;
        v v0;
        if(c0 instanceof v) {
            v0 = (v)c0;
            int v1 = v0.G;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                v0.G = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        g0 g00 = v0.E;
        ne.a a0 = ne.a.a;
        int v2 = 0;
        switch(v0.G) {
            case 0: {
                d5.n.D(g00);
                z = q0.f instanceof f1.q;
                boolean z1 = a1.T.b(q0.m().b);
                v3 = !z1;
                v4 = z1 || z ? 0 : 1;
                if(q0.j()) {
                    h0 h00 = q0.h;
                    if(h00 == null) {
                        z2 = false;
                    }
                    else {
                        v0.r = q0;
                        v0.w = z;
                        v0.B = v3;
                        v0.D = v4;
                        v0.G = 1;
                        ClipData clipData0 = ((AndroidClipboard)h00).a.a.getPrimaryClip();
                        g0 g01 = clipData0 == null ? null : new g0(clipData0);
                        if(g01 == a0) {
                            return a0;
                        }
                        q1 = q0;
                        v5 = v4;
                        g00 = g01;
                        v6 = v3;
                        goto label_45;
                    }
                    z3 = z2;
                    break;
                }
                else {
                    z3 = false;
                }
                break;
            }
            case 1: {
                v5 = v0.D;
                v6 = v0.B;
                z = v0.w;
                q1 = v0.r;
                d5.n.D(g00);
            label_45:
                if(g00 == null || !g00.a.getDescription().hasMimeType("text/*")) {
                    v4 = v5;
                    q0 = q1;
                    v3 = v6;
                    z2 = false;
                }
                else {
                    v4 = v5;
                    q0 = q1;
                    v3 = v6;
                    z2 = true;
                }
                z3 = z2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        boolean z4 = v3 != 0 && q0.j() && !z;
        boolean z5 = a1.T.c(q0.m().b) != q0.m().a.b.length();
        if(q0.j() && a1.T.b(q0.m().b)) {
            v2 = 16;
        }
        return new p0((z3 ? 2 : 0) | v4 | (z4 ? 4 : 0) | (z5 ? 8 : 0) | v2);
    }

    public static final void x(f0 f00, x x0, f1.p p0) {
        p0.h h0 = p0.q.d();
        k k0 = h0 == null ? null : h0.e();
        p0.h h1 = p0.q.e(h0);
        try {
            J0 j00 = f00.d();
            if(j00 == null) {
                return;
            }
            C c0 = f00.e;
            if(c0 == null) {
                return;
            }
            N0.v v1 = f00.c();
            if(v1 == null) {
                return;
            }
            U.s0 s00 = f00.a;
            boolean z = f00.b();
            b0.y(x0, s00, j00.a, v1, c0, z, p0);
        }
        finally {
            p0.q.g(h0, h1, k0);
        }
    }

    public static void y(x x0, U.s0 s00, a1.Q q0, N0.v v0, C c0, boolean z, f1.p p0) {
        x0.c c1;
        if(z) {
            int v1 = p0.t(a1.T.d(x0.b));
            if(v1 < q0.a.a.b.length()) {
                c1 = q0.b(v1);
            }
            else {
                c1 = v1 == 0 ? new x0.c(0.0f, 0.0f, 1.0f, ((float)(((int)(x0.b(s00.b, s00.g, s00.h) & 0xFFFFFFFFL))))) : q0.b(v1 - 1);
            }
            long v2 = v0.j0(((long)Float.floatToRawIntBits(c1.a)) << 0x20 | ((long)Float.floatToRawIntBits(c1.b)) & 0xFFFFFFFFL);
            x0.c c2 = e.k.d(((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v2 >> 0x20))))) << 0x20, ((long)Float.floatToRawIntBits(c1.c - c1.a)) << 0x20 | ((long)Float.floatToRawIntBits(c1.d - c1.b)) & 0xFFFFFFFFL);
            if(kotlin.jvm.internal.q.b(((C)c0.a.b.get()), c0)) {
                c0.b.c(c2);
            }
        }
    }

    public static final q z(q q0, g g0, U u0, k k0, int v, boolean z, int v1, int v2, e1.i i0, List list0, k k1, u u1, k k2) {
        TextAnnotatedStringElement textAnnotatedStringElement0 = new TextAnnotatedStringElement(g0, u0, i0, k0, v, z, v1, v2, list0, k1, u1, k2);
        return q0.then(r0.n.a).then(textAnnotatedStringElement0);
    }
}

