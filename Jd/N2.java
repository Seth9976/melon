package jd;

import Ac.U2;
import Bd.F;
import Cc.B;
import Cc.N1;
import Cc.S0;
import Cc.c1;
import Cc.e0;
import Dd.k1;
import Ec.b;
import Kc.Z;
import M.B0;
import M.c;
import M.j0;
import M.p0;
import M.q0;
import M.y;
import N0.M;
import O.I;
import P0.h;
import P0.i;
import P0.j;
import Q.K;
import Q.O;
import Q.e;
import a1.U;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.system.ScreenUtils;
import d5.f;
import gd.T7;
import h7.u0;
import hd.h0;
import ie.H;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import r0.g;
import r0.n;
import r0.q;
import wc.u;
import we.a;
import we.k;
import y0.P;
import y0.s;

public abstract class n2 {
    public static final void a(boolean z, String s, int v, k k0, List list0, k k1, k k2, a a0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(-238440824);
        int v2 = (v1 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.i(list0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.i(k1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v2 |= (p0.i(k2) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v2 |= (p0.i(a0) ? 0x800000 : 0x400000);
        }
        if(p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            FillElement fillElement0 = d.c;
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q0 = r0.a.d(p0, fillElement0);
            P0.k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q0, h3);
            n n0 = n.a;
            M.p.a(androidx.compose.foundation.q.e(d.f(d.c(n0, 0.15f), 1.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06015F)), new s(e0.T(p0, 0x7F060157)), new s(e0.T(p0, 0x7F06013D))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:gray600e
            q q1 = e0.X(fillElement0, ((Context)p0.k(AndroidCompositionLocals_androidKt.b)), p0);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q2, h3);
            int v5 = list0.isEmpty() ? 1 : list0.size();
            n2.h(z, s, v, list0, k1, k2, a0, p0, v2 & 0x3FE | v2 >> 3 & 0x1C00 | 0xE000 & v2 >> 3 | 0x70000 & v2 >> 3 | 0x380000 & v2 >> 3);
            l1.x(1.0f, true, p0);
            if(list0.isEmpty()) {
                p0.a0(1069016286);
            }
            else {
                p0.a0(0x40C30833);
                n2.e(v, v5, v2 >> 6 & 14, p0);
                c.d(p0, d.h(n0, 8.0f));
                n2.g(list0, v, k0, p0, v2 >> 12 & 14 | v2 >> 3 & 0x70 | v2 >> 3 & 0x380);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c2(z, s, v, k0, list0, k1, k2, a0, v1);
        }
    }

    public static final void b(K k0, List list0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x5860F08B);
        int v1 = v | (p0.g(k0) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q0 = r0.a.d(p0, d.c);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q0, j.d);
            u0.b(k0, null, null, null, 0, 0.0f, null, f.z(k0, G.f.q(1500.0f, 1, 1.0f), p0, v1 & 14, 22), false, null, null, null, m0.c.e(0xD0B7EF12, p0, new b(list0, 1)), p0, v1 & 14, 0x3F7E);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(k0, list0, v, 20);
        }
    }

    public static final void c(q2 q20, k k0, k k1, a a0, l l0, int v) {
        a0 a04;
        V v8;
        Object object2;
        V v6;
        a0 a03;
        Context context1;
        a0 a02;
        Context context0;
        int v4;
        e e1;
        h h7;
        a0 a01;
        h h6;
        h h5;
        h h3;
        p p0 = (p)l0;
        p0.c0(0xD96B0A4F);
        int v1 = v | (p0.i(q20) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            a0 a00 = p0.N();
            if(a00 == v2) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            B0 b01 = new B0(3, 0);
            q q0 = androidx.compose.foundation.q.f(r0.a.a(d.c, b01), e0.T(p0, 0x7F060171), y0.M.a);  // color:gray990e
            FillElement fillElement0 = d.c;
            q q1 = r0.a.a(q0, new hd.s(b00, k0, ((Context)object0), q20, a00, 2));
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
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
            if(p0.O) {
                h3 = h1;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                h3 = h1;
                if(!kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h4 = j.d;
            w.x(p0, q2, h4);
            boolean z = p0.i(q20);
            ed.f f0 = p0.N();
            if(z || f0 == v2) {
                f0 = new ed.f(q20, 29);
                p0.l0(f0);
            }
            e e0 = O.b(f0, p0, 0, 3);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            b0 b02 = p0.N();
            if(b02 == v2) {
                b02 = w.s(Boolean.TRUE);
                p0.l0(b02);
            }
            if(((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(-562790842);
                boolean z1 = p0.i(coroutineScope0);
                boolean z2 = p0.i(q20);
                boolean z3 = p0.g(e0);
                f2 f20 = p0.N();
                if((z1 | z2 | z3) != 0 || f20 == v2) {
                    h5 = h0;
                    h6 = h3;
                    a01 = a00;
                    h7 = h2;
                    f20 = new f2(coroutineScope0, q20, e0, b02, null);
                    p0.l0(f20);
                }
                else {
                    h5 = h0;
                    h6 = h3;
                    a01 = a00;
                    h7 = h2;
                }
                J.d(p0, H.a, f20);
            }
            else {
                h5 = h0;
                h6 = h3;
                a01 = a00;
                h7 = h2;
                p0.a0(0xDE7D4F19);
                Integer integer0 = ((K0)a01).m();
                boolean z4 = p0.g(e0);
                boolean z5 = p0.i(coroutineScope0);
                h2 h20 = p0.N();
                if(z4 || z5 || h20 == v2) {
                    h20 = new h2(e0, ((K0)a01), coroutineScope0, null);
                    p0.l0(h20);
                }
                J.d(p0, integer0, h20);
            }
            p0.p(false);
            boolean z6 = p0.g(e0);
            boolean z7 = p0.i(((Context)object0));
            boolean z8 = p0.i(q20);
            j2 j20 = p0.N();
            if((z6 | (v1 & 0x70) == 0x20 | z7 | z8) != 0 || j20 == v2) {
                v4 = v1 & 0x70;
                a02 = a01;
                j20 = new j2(e0, a02, k0, ((Context)object0), q20, null);
                context0 = (Context)object0;
                e1 = e0;
                p0.l0(j20);
            }
            else {
                e1 = e0;
                v4 = v1 & 0x70;
                context0 = (Context)object0;
                a02 = a01;
            }
            J.d(p0, e1, j20);
            Object object1 = q20.b;
            if(((List)object1).isEmpty()) {
                p0.a0(0xDE96F14A);
                g g0 = r0.d.n;
                y y0 = M.w.a(M.j.c, g0, p0, 0x30);
                int v5 = p0.P;
                i0 i01 = p0.m();
                q q3 = r0.a.d(p0, fillElement0);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h5);
                w.x(p0, i01, h6);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h7);
                }
                w.x(p0, q3, h4);
                context1 = context0;
                a03 = a02;
                v6 = v2;
                c1.n(H0.b.q(g0, d.n(androidx.compose.foundation.layout.a.n(n.a, 0.0f, 150.0f, 0.0f, 0.0f, 13), 79.0f)), 0x7F080786, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:noimage_logo_large
                kotlin.jvm.internal.q.f("이미지가 없습니다.", "getString(...)");
                long v7 = e0.T(p0, 0x7F060163);  // color:gray700s
                N1.b("이미지가 없습니다.", androidx.compose.foundation.layout.a.n(n.a, 0.0f, 12.0f, 0.0f, 0.0f, 13), v7, 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);
                p0.p(true);
                p0.p(false);
                object2 = object1;
            }
            else {
                a03 = a02;
                context1 = context0;
                v6 = v2;
                p0.a0(0xDEA34FA6);
                object2 = object1;
                n2.b(e1, ((List)object2), p0, 0);
                p0.p(false);
            }
            if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(0xDEA5C119);
                boolean z9 = p0.i(q20);
                k2 k20 = p0.N();
                if(z9) {
                    v8 = v6;
                label_155:
                    a04 = a03;
                    k20 = new k2(a04, q20, null);
                    p0.l0(k20);
                }
                else {
                    v8 = v6;
                    if(k20 == v8) {
                        goto label_155;
                    }
                    else {
                        a04 = a03;
                    }
                }
                J.d(p0, object2, k20);
                boolean z10 = q20.a;
                String s = q20.d;
                int v9 = ((K0)a04).m() < ((List)object2).size() ? ((K0)a04).m() : ((List)object2).size() - 1;
                boolean z11 = p0.i(context1);
                boolean z12 = p0.i(q20);
                F f1 = p0.N();
                if((z11 | v4 == 0x20 | z12) != 0 || f1 == v8) {
                    F f2 = new F(((K0)a04), k0, context1, q20, 17);
                    p0.l0(f2);
                    f1 = f2;
                }
                n2.a(z10, s, v9, f1, ((List)q20.b), k0, k1, a0, p0, v1 << 12 & 0x1FF0000);
            }
            else {
                p0.a0(0xDDCB08CD);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(q20, k0, k1, a0, v, 27);
        }
    }

    public static final void d(a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1659649190);
        int v1 = (p0.i(a0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            FillElement fillElement0 = d.c;
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q0 = r0.a.d(p0, fillElement0);
            P0.k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q0, h3);
            q q1 = e0.X(fillElement0, ((Context)p0.k(AndroidCompositionLocals_androidKt.b)), p0);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            w.x(p0, q2, h3);
            h0 h00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(h00 == v4) {
                h00 = new h0(18);
                p0.l0(h00);
            }
            h0 h01 = p0.N();
            if(h01 == v4) {
                h01 = new h0(19);
                p0.l0(h01);
            }
            n2.h(false, null, 0, je.w.a, h00, h01, a0, p0, v1 << 18 & 0x380000 | 0x36DB6);
            q q3 = d.n(androidx.compose.foundation.layout.a.n(n.a, 0.0f, 100.0f, 0.0f, 0.0f, 13), 79.0f);
            c1.n(H0.b.q(r0.d.n, q3), 0x7F080791, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:noimage_logo_xlarge
            kotlin.jvm.internal.q.f("문제가 발생했습니다.\n 잠시후 이용하시기 바랍니다.", "getString(...)");
            q q4 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 12.0f, 0.0f, 0.0f, 13);
            N1.b("문제가 발생했습니다.\n 잠시후 이용하시기 바랍니다.", H0.b.q(r0.d.n, q4), e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:gray700s
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.j(v, 8, a0);
        }
    }

    public static final void e(int v, int v1, int v2, l l0) {
        p p0 = (p)l0;
        p0.c0(0x23676B0C);
        int v3 = (v2 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.e(v1) ? 0x20 : 16);
        }
        if(p0.Q(v3 & 1, (v3 & 19) != 18)) {
            n n0 = n.a;
            q q0 = d.h(d.f(n0, 1.0f), 26.0f);
            M m0 = M.p.d(r0.d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            T.d d0 = T.e.b(13.0f);
            q q2 = androidx.compose.foundation.layout.a.k(androidx.compose.foundation.q.f(n0, e0.T(p0, 0x7F060164), d0), 8.0f, 5.0f);  // color:gray750e
            p0 p00 = M.n0.a(M.j.e, r0.d.j, p0, 6);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q3, h3);
            N1.b(String.valueOf(v + 1), new VerticalAlignElement(r0.d.k), e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:white000e
            N1.b("/", androidx.compose.foundation.layout.a.l(new VerticalAlignElement(r0.d.k), 1.0f, 0.0f, 2), e0.T(p0, 0x7F0604A1), 11.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC06, 0, 0x1FDF0);  // color:white000e
            N1.b(String.valueOf(v1), new VerticalAlignElement(r0.d.k), e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:white000e
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new d2(v, v1, v2);
        }
    }

    public static final void f(int v, String s, boolean z, k k0, l l0, int v1) {
        q q2;
        p p0 = (p)l0;
        p0.c0(0xE646A291);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            q q0 = r0.a.d(p0, n0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q0, j.d);
            c1.n(r0.a.a(e0.L(d.n(n0, 48.0f), 0x7F0604AE), new S0(k0, v, 1)), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 & 0x70 | 0xC00, 0, 0x7FF4);  // color:white120e
            q q1 = d.n(n0, 48.0f);
            if(z) {
                p0.a0(-1362458606);
                q2 = androidx.compose.foundation.q.i(2.0f, e0.T(p0, 0x7F0604A1), n0, T.e.b(4.0f));  // color:white000e
            }
            else {
                p0.a0(-1362209955);
                q2 = androidx.compose.foundation.q.f(n0, e0.T(p0, 0x7F06015B), y0.M.a);  // color:gray500e
            }
            p0.p(false);
            c.d(p0, q1.then(q2));
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b2(z, s, v, k0, v1);
        }
    }

    public static final void g(List list0, int v, k k0, l l0, int v1) {
        h h4;
        int v10;
        O.F f2;
        int v9;
        n n1;
        V v8;
        r0.i i2;
        u u1;
        int v7;
        p p0 = (p)l0;
        p0.c0(-1243304337);
        int v2 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q0 = d.h(d.f(n0, 1.0f), 88.0f);
            long v3 = e0.T(p0, 0x7F060168);  // color:gray850e
            u u0 = y0.M.a;
            q q1 = androidx.compose.foundation.q.f(q0, v3, u0);
            r0.i i0 = r0.d.e;
            M m0 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            O.F f0 = I.a(0, 0, 3, p0);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            float f1 = ((float)(ScreenUtils.getScreenWidth(context0) / 2)) - e0.a0(24.0f, p0) - e0.a0(20.0f, p0);
            int v5 = ScreenUtils.pixelToDip(context0, ((int)f1));
            b0 b00 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(b00 == v6) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            Integer integer0 = v;
            boolean z = p0.g(f0);
            boolean z1 = p0.d(f1);
            l2 l20 = p0.N();
            if(((v2 & 0x70) == 0x20 | z | z1) != 0 || l20 == v6) {
                v7 = v2 & 0x70;
                u1 = u0;
                i2 = i0;
                v8 = v6;
                n1 = n0;
                v9 = v5;
                v10 = v2;
                h4 = h1;
                f2 = f0;
                l20 = new l2(v, f2, f1, b00, null);
                p0.l0(l20);
            }
            else {
                v7 = v2 & 0x70;
                u1 = u0;
                i2 = i0;
                v8 = v6;
                n1 = n0;
                v9 = v5;
                f2 = f0;
                v10 = v2;
                h4 = h1;
            }
            J.d(p0, integer0, l20);
            if(list0.isEmpty()) {
                p0.a0(1093049920);
                q q3 = e0.L(androidx.compose.foundation.q.f(d.n(n1, 48.0f), e0.T(p0, 0x7F060144), u1), 0x7F0604AE);  // color:gray050e
                M m1 = M.p.d(i2, false);
                int v11 = p0.P;
                i0 i01 = p0.m();
                q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i01, h4);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
                w.x(p0, q4, h3);
                c1.n(d.n(n1, 32.0f), 0x7F08078B, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:noimage_logo_mini
                p0.p(true);
            }
            else {
                p0.a0(0x412DE908);
                M.g g0 = M.j.h(8.0f);
                j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                boolean z2 = p0.i(list0);
                boolean z3 = p0.e(v9);
                B b0 = p0.N();
                if((z2 | z3 | (v7 == 0x20 ? 1 : 0) | ((v10 & 0x380) == 0x100 ? 1 : 0)) != 0 || b0 == v8) {
                    b0 = new B(v9, v, list0, k0);
                    p0.l0(b0);
                }
                c1.q(null, f2, j00, g0, null, null, false, b0, p0, 0x6180, 0xE9);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(list0, v, k0, v1, 24);
        }
    }

    public static final void h(boolean z, String s, int v, List list0, k k0, k k1, a a0, l l0, int v1) {
        n n1;
        String s2;
        r0.i i0 = r0.d.i;
        p p0 = (p)l0;
        p0.c0(0xF011481B);
        int v2 = (v1 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(list0) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.i(k0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.i(k1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v2 |= (p0.i(a0) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            n n0 = n.a;
            q q0 = d.h(d.f(n0, 1.0f), 50.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            q q2 = d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f);
            q q3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.d);
            r0.h h4 = r0.d.k;
            p0 p00 = M.n0.a(M.j.a, h4, p0, 0x30);
            int v4 = p0.P;
            M.b b0 = M.j.a;
            i0 i01 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q4, h3);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            jd.a a1 = (jd.a)je.p.n0(v, list0);
            q q5 = androidx.compose.foundation.q.f(d5.n.o(d.n(n0, 38.0f), T.e.a), e0.T(p0, 0x7F060144), y0.M.a);  // color:gray050e
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604AE), 0.5f);  // color:white120e
            c1.n(r0.a.a(androidx.compose.foundation.q.j(q5, y0.a, y0.b, T.e.a), new Z(5)), (a1 == null ? null : a1.f), null, N0.j.b, false, 0x7F08079F, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30C00, 0, 0x7FD4);  // drawable:noimage_person_mini
            q q6 = H0.b.r(h4, androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14));
            y y1 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q7, h3);
            p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
            int v6 = p0.P;
            i0 i03 = p0.m();
            q q8 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q8, h3);
            jd.a a2 = (jd.a)je.p.n0(v, list0);
            String s1 = "";
            if(a2 == null) {
                s2 = "";
            }
            else {
                s2 = a2.e;
                if(s2 == null) {
                    s2 = "";
                }
            }
            long v7 = e0.T(p0, 0x7F0604A1);  // color:white000e
            U u0 = new U(0L, 0L, null, null, 0L, new P(e0.T(p0, 0x7F06003E), 0L, 2.0f), 0, 0L, 0xFFDFFF);  // color:black_50
            N1.b(s2, null, v7, 14.0f, e1.y.h, null, 0L, null, 0.0f, 0, false, 0, 0, null, u0, p0, 0x30C00, 0, 0xFFD2);
            androidx.compose.foundation.q.c(De.I.Q(0x7F08041E, p0, 6), null, d.n(androidx.compose.foundation.layout.a.n(new VerticalAlignElement(h4), 3.0f, 0.0f, 0.0f, 0.0f, 14), 12.0f), null, null, 0.0f, null, p0, 0x30, 120);  // drawable:ic_common_verify_artist_12
            p0.p(true);
            c.d(p0, d.h(n0, 1.0f));
            jd.a a3 = (jd.a)je.p.n0(v, list0);
            if(a3 != null) {
                String s3 = a3.g;
                if(s3 != null) {
                    s1 = s3;
                }
            }
            N1.b(s1, null, e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, new U(0L, 0L, null, null, 0L, new P(e0.T(p0, 0x7F06003E), 0L, 2.0f), 0, 0L, 0xFFDFFF), p0, 0xC00, 0, 0xFFF2);  // color:white700e
            p0.p(true);
            c.d(p0, q0.a(n0, 1.0f));
            if(list0.isEmpty() || !z || !kotlin.jvm.internal.q.b(s, ((jd.a)list0.get(v)).d)) {
                n1 = n0;
                p0.a0(0xFF2F0491);
            }
            else {
                p0.a0(0xC9450E);
                n1 = n0;
                c1.n(r0.a.a(H0.b.r(h4, d.h(d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 5.0f, 0.0f, 11), 46.0f), 50.0f)), new k1(k0, context0, list0, v, k1)), 0x7F0801D4, null, null, false, 0, null, null, i0, 0.0f, null, 0, 0, false, false, p0, 0x6000030, 0, 0x7EFC);  // drawable:btn_gnb_delete_shadow
            }
            p0.p(false);
            c1.n(r0.a.a(d.h(d.q(n1, 46.0f), 50.0f), new k1(list0, v, k0, context0, a0)), 0x7F0801D0, null, null, false, 0, null, null, i0, 0.0f, null, 0, 0, false, false, p0, 0x6000030, 0, 0x7EFC);  // drawable:btn_gnb_close_shadow
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.b(z, s, v, list0, k0, k1, a0, v1);
        }
    }
}

