package Cc;

import A0.f;
import Ac.B;
import Ac.C0;
import Ac.D;
import Ac.U0;
import Ac.U2;
import Ac.a4;
import Ac.i2;
import Ac.r;
import De.I;
import G.C;
import G.X;
import H0.e;
import I.X0;
import M.B0;
import M.c;
import M.g;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.q0;
import M.w;
import M.y;
import M.z;
import N0.M;
import N0.m;
import P0.K;
import P0.h;
import P0.i;
import P0.k;
import Q0.k0;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.s;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.M0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import e1.x;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import r0.n;
import wc.u;
import we.a;

public abstract class e0 {
    public static final b a;
    public static final b b;

    static {
        e0.a = new b(0xB9790E7E, new P(3), false);
        e0.b = new b(-741570754, new P(4), false);
    }

    public static final void A(List list0, int v, a a0, l l0, int v1) {
        q.g(list0, "orderList");
        p p0 = (p)l0;
        p0.c0(-2002391343);
        int v2 = v1 | (p0.i(list0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.a.l(d.f(d.h(n0, E9.h.t(p0, 0x7F0703F2)), 1.0f), 20.0f, 0.0f, 2);  // dimen:new_filter_layout_height
            p0 p00 = n0.a(j.g, r0.d.k, p0, 54);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            p0.a0(0xDE60326B);
            p0.p(false);
            c.d(p0, new LayoutWeightElement(1.0f, true));
            r0.q q4 = r0.a.a(n0, new u0(11, a0));
            p0 p01 = n0.a(j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            c1.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 4.0f, 0.0f, 11), 0x7F08017C, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_common_toggle_14
            N1.b(((String)list0.get(v)), null, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(list0, v, a0, v1, 1);
        }
    }

    public static final void B(int v, List list0, List list1, int v1, String s, we.k k0, a a0, l l0, int v2, int v3) {
        String s3;
        String s2;
        i i2;
        h h6;
        h h5;
        h h4;
        i i1;
        q.g(list0, "filterList");
        q.g(list1, "orderList");
        p p0 = (p)l0;
        p0.c0(0x2D350E7A);
        int v4 = v2 | (p0.e(v) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.i(list1) ? 0x100 : 0x80) | (p0.e(v1) ? 0x800 : 0x400);
        int v5 = ((v3 & 16) == 0 ? v4 | (p0.g(s) ? 0x4000 : 0x2000) : v4 | 0x6000) | (p0.i(k0) ? 0x20000 : 0x10000) | (p0.i(a0) ? 0x100000 : 0x80000);
        if(p0.Q(v5 & 1, (v5 & 0x92493) != 0x92492)) {
            String s1 = (v3 & 16) == 0 ? s : null;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            a0 a00 = p0.N();
            V v7 = androidx.compose.runtime.k.a;
            if(a00 == v7) {
                a00 = androidx.compose.runtime.w.p(v);
                p0.l0(a00);
            }
            r0.q q2 = d.h(n0, 56.0f);
            g g0 = j.h(8.0f);
            int v8 = ((K0)a00).m();
            D d0 = p0.N();
            if((v5 & 0x70000) == 0x20000 || d0 == v7) {
                d0 = new D(19, ((K0)a00), k0);
                p0.l0(d0);
            }
            e0.b(q2, v8, list0, g0, 0x7F06017A, 0x7F060152, 0x7F06017A, 0x7F06048A, 0x7F0604A1, 0x7F060163, 100.0f, 15.0f, 30.0f, 13.0f, d0, p0, v5 << 3 & 0x380 | 920349702, 0);  // color:green500e_support_high_contrast
            r0.q q3 = androidx.compose.foundation.layout.a.l(d.f(d.h(n0, 38.0f), 1.0f), 20.0f, 0.0f, 2);
            p0 p00 = n0.a(j.g, r0.d.k, p0, 54);
            int v9 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v9)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v9, p0, v9, h4);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            if(s1 == null) {
                h5 = h4;
                i2 = i1;
                h6 = h0;
                s2 = null;
                p0.a0(0x156D0942);
            }
            else {
                p0.a0(0x1592F596);
                h5 = h4;
                h6 = h0;
                i2 = i1;
                N1.b(s1, null, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v5 >> 12 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
                s2 = s1;
            }
            p0.p(false);
            c.d(p0, new LayoutWeightElement(1.0f, true));
            r0.q q5 = r0.a.a(n0, new u0(12, a0));
            p0 p01 = n0.a(j.a, r0.d.j, p0, 0);
            int v10 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h6);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h5);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            c1.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 4.0f, 0.0f, 11), 0x7F08017C, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_common_toggle_14
            N1.b(((String)list1.get(v1)), null, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
            A7.d.s(p0, true, true, true);
            s3 = s2;
        }
        else {
            p0.T();
            s3 = s;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b1(v, list0, list1, v1, s3, k0, a0, v2, v3);
        }
    }

    public static final void C(r0.q q0, long v, int v1, float f, l l0, int v2, int v3) {
        int v14;
        long v13;
        float f4;
        long v12;
        int v11;
        int v10;
        float f1;
        q.g(q0, "modifier");
        ((p)l0).c0(0x6B1F78BF);
        int v4 = 2;
        long v5 = v;
        int v6 = ((v2 & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v2 : v2) | ((v3 & 2) != 0 || !((p)l0).f(v5) ? 16 : 0x20);
        int v7 = v6 | 0x80;
        if((v3 & 8) != 0) {
            v7 = v6 | 3200;
            f1 = f;
        }
        else if((v2 & 0xC00) == 0) {
            f1 = f;
            v7 |= (((p)l0).d(f1) ? 0x800 : 0x400);
        }
        else {
            f1 = f;
        }
        int v8 = v7 | 0x6000;
        int v9 = 0;
        if(((p)l0).Q(v8 & 1, (v8 & 9363) != 9362)) {
            ((p)l0).V();
            if((v2 & 1) == 0 || ((p)l0).B()) {
                if((v3 & 2) != 0) {
                    v5 = e0.T(((p)l0), 0x7F06014A);  // color:gray100a
                    v8 &= 0xFFFFFF8F;
                }
                v10 = v8 & -897;
                if((v3 & 8) != 0) {
                    f1 = 0.5f;
                }
            }
            else {
                ((p)l0).T();
                if((v3 & 2) != 0) {
                    v8 &= 0xFFFFFF8F;
                }
                v10 = v8 & -897;
                v4 = v1;
            }
            ((p)l0).q();
            if((v10 & 0x70 ^ 0x30) > 0x20 && ((p)l0).f(v5) || (v10 & 0x30) == 0x20) {
                v9 = 1;
            }
            boolean z = ((p)l0).e(v4);
            boolean z1 = ((p)l0).i(null);
            F f2 = ((p)l0).N();
            if((((v10 & 0x1C00) == 0x800 ? 1 : 0) | v9 | z | z1) != 0 || f2 == androidx.compose.runtime.k.a) {
                v11 = v4;
                v12 = v5;
                F f3 = new F(f1, v12, v11, 1);
                ((p)l0).l0(f3);
                f2 = f3;
            }
            else {
                v11 = v4;
                v12 = v5;
            }
            androidx.compose.foundation.q.b(q0, f2, ((p)l0), v10 & 14);
            f4 = f1;
            v13 = v12;
            v14 = v11;
        }
        else {
            ((p)l0).T();
            v14 = v1;
            f4 = f1;
            v13 = v5;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new H(q0, v13, v14, f4, v2, v3);
        }
    }

    public static final void D(a a0, l l0, int v) {
        ((p)l0).c0(0x76664116);
        int v1 = (v & 6) == 0 ? (((p)l0).i(a0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.c(d.q(n0, 48.0f), 1.0f), new u0(2, a0));
            M m0 = M.p.d(r0.d.a, false);
            int v2 = ((p)l0).P;
            i0 i00 = ((p)l0).m();
            r0.q q1 = r0.a.d(((p)l0), q0);
            k.y.getClass();
            i i0 = P0.j.b;
            ((p)l0).e0();
            if(((p)l0).O) {
                ((p)l0).l(i0);
            }
            else {
                ((p)l0).o0();
            }
            androidx.compose.runtime.w.x(((p)l0), m0, P0.j.f);
            androidx.compose.runtime.w.x(((p)l0), i00, P0.j.e);
            h h0 = P0.j.g;
            if(((p)l0).O || !q.b(((p)l0).N(), v2)) {
                A7.d.q(v2, ((p)l0), v2, h0);
            }
            androidx.compose.runtime.w.x(((p)l0), q1, P0.j.d);
            c1.n(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.d), 15.0f, 0.0f, 0.0f, 0.0f, 14), 0x7F080223, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FFC);  // drawable:btn_offer_20_w
            ((p)l0).p(true);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x0(v, 1, a0);
        }
    }

    public static final void E(int v, l l0, String s, r0.q q0) {
        ((p)l0).c0(-2140722027);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            c1.g(q0, (s == null ? "" : s), e0.T(((p)l0), 0x7F0604A1), 13.0f, null, null, new s(20.0f, 0), 0, 0, ((p)l0), v1 & 14 | 0xC00, 0x1B0);  // color:white000e
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new w0(q0, s, v, 0);
        }
    }

    public static final void F(String s, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1649702196);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            r0.q q0 = r0.a.d(p0, n0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            r0.q q1 = d.n(n0, 72.0f);
            q.g(q1, "<this>");
            r0.q q2 = androidx.compose.foundation.q.f(r0.a.a(q1, new P(0)), e0.T(p0, 0x7F060145), y0.M.a);  // color:gray050s
            u u0 = y0.M.a;
            c1.n(q2, 0x7F080799, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C30, 0, 0x7FE4);  // drawable:noimage_man_medium
            if(s != null && s.length() != 0) {
                p0.a0(0x4A9AE67C);
                r0.q q3 = d.n(n0, 72.0f);
                q.g(q3, "<this>");
                c1.n(androidx.compose.foundation.q.f(r0.a.a(q3, new P(0)), e0.T(p0, 0x7F060145), u0), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70 | 0x6C00, 0, 0x7FE4);  // color:gray050s
            }
            else {
                p0.a0(0x4A8CF330);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U0(s, v, 1);
        }
    }

    public static final void G(a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(845890536);
        int v1 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.c(d.q(n0, 53.0f), 1.0f), new u0(3, a0));
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e);
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            c1.n(d.o(n0, 23.33f, 14.0f), 0x7F080155, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_common_mixup_18
            c.d(p0, d.h(n0, 6.0f));
            N1.b(e.Y(p0, 0x7F13080E), null, e0.T(p0, 0x7F0604A1), 9.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:play_other_recommendation_malrang "다른추천"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new x0(v, 0, a0);
        }
    }

    public static final void H(String s, String s1, l l0, int v) {
        String s3;
        p p0 = (p)l0;
        p0.c0(0xF752CFA5);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s1) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Bc.h h0 = x.I(p0);
            String s2 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || s2 == v2) {
                if(h0 == null) {
                    s3 = "";
                }
                else {
                    s3 = h0.a(s1);
                    if(s3 == null) {
                        s3 = "";
                    }
                }
                s2 = s3;
                p0.l0(s2);
            }
            String s4 = s + ", " + s2;
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c1.n(d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 0.5f, 7), 11.0f), 0x7F0804B0, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC36, 0, 0x7FF4);  // drawable:ic_malang_song_11
            c.d(p0, d.q(n0, 1.0f));
            p0.a0(0xFCBF278B);
            a1.d d0 = new a1.d();
            int v4 = d0.g(new a1.M(e0.T(p0, 0x7F0604A1), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));  // color:white000e
            try {
                d0.c(s);
            }
            finally {
                d0.f(v4);
            }
            d0.d(" ");
            int v6 = d0.g(new a1.M(e0.T(p0, 0x7F0604B7), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));  // color:white700e
            try {
                d0.c(s1);
            }
            finally {
                d0.f(v6);
            }
            a1.g g0 = d0.h();
            p0.p(false);
            r0.q q2 = androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 0.0f, 1.5f, 0.0f, 0.0f, 13);
            boolean z = p0.g(s4);
            Ac.g g1 = p0.N();
            if(z || g1 == v2) {
                g1 = new Ac.g(s4, 5);
                p0.l0(g1);
            }
            N1.a(g0, X0.n.c(q2, false, g1), 0L, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, p0, 0xC00, 0xC30, 0x3D7F4);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new y0(v, 0, s, s1);
        }
    }

    public static r0.q I(r0.q q0, int v, int v1) {
        if((v1 & 1) != 0) {
            v = 0x7F060145;  // color:gray050s
        }
        q.g(q0, "$this$bgSolidRoundCorner");
        return r0.a.a(q0, new W(v, 4.0f));
    }

    public static final r0.q J(r0.q q0) {
        q.g(q0, "<this>");
        return r0.a.a(q0, new P(2));
    }

    public static final r0.q K(r0.q q0) {
        q.g(q0, "<this>");
        return r0.a.a(q0, new P(1));
    }

    public static final r0.q L(r0.q q0, int v) {
        q.g(q0, "<this>");
        return r0.a.a(q0, new S(v, 0));
    }

    public static final r0.q M(r0.q q0, int v, float f) {
        q.g(q0, "$this$defaultBorderWithClip");
        return r0.a.a(q0, new W(f, v));
    }

    public static final long N(float f, l l0) {
        return ((r1.c)((p)l0).k(k0.h)).j(f);
    }

    public static void O(A0.d d0, boolean z) {
        q.g(d0, "<this>");
        A0.b b0 = ((K)d0).a;
        float f = ((K)d0).Y(30.0f);
        float f1 = 0.0f;
        long v = ((long)Float.floatToRawIntBits((z ? 0.0f : Float.intBitsToFloat(((int)(b0.c() >> 0x20))) - f))) << 0x20;
        long v1 = ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
        List list0 = e.k.A(new y0.s[]{new y0.s(y0.s.f), new y0.s(y0.s.b)});
        if(!z) {
            f1 = Float.intBitsToFloat(((int)(b0.c() >> 0x20)));
        }
        if(!z) {
            f = Float.intBitsToFloat(((int)(b0.c() >> 0x20))) - f;
        }
        f.f0(d0, u.e(list0, f1, f, 8), v, v1, 1.0f, null, 0x30);
    }

    public static r0.q P(r0.q q0, T.d d0, long v, float f) {
        q.g(q0, "$this$dropShadow");
        return androidx.compose.ui.draw.a.a(q0, new N(0.0f, d0, v, 0.0f, f));
    }

    public static final r0.q Q(r0.q q0, boolean z) {
        q.g(q0, "<this>");
        return r0.a.a(q0, new Cc.V(z, 0));
    }

    public static r0.q R(r0.q q0, O.F f0, float f1, boolean z, boolean z1, a a0, int v) {
        if((v & 16) != 0) {
            a0 = new Vb.i(9);
        }
        Vb.i i0 = new Vb.i(9);
        q.g(q0, "$this$fadingEdgeVertical");
        q.g(f0, "scrollableState");
        q.g(a0, "topCondition");
        C0 c00 = new C0(23);
        return q0.then(androidx.compose.ui.draw.a.c(androidx.compose.ui.graphics.a.a(d.c, c00), new H0(f0, a0, z, f1, i0, z1)));
    }

    public static final r0.q S(r0.q q0, X0 x00, float f) {
        q.g(q0, "$this$fadingEdgeVertical");
        q.g(x00, "scrollableState");
        return q0.then(androidx.compose.ui.draw.a.c(androidx.compose.ui.graphics.a.b(n.a, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, 0xFFFF), new I0(f, 0, x00)));
    }

    public static final long T(l l0, int v) {
        boolean z = ((Boolean)((p)l0).k(Q0.w0.a)).booleanValue();
        Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
        return z ? y0.M.c(ColorUtils.getColor(context0, v, false)) : y0.M.c(ColorUtils.getColor(context0, v, ScreenUtils.INSTANCE.isHighContrastMode()));
    }

    public static final B2.n U(B2.n n0, C2.a a0) {
        q.g(n0, "<this>");
        return n0.b(new C2.b(a0, 0x7F0807E6));  // drawable:ripple_no_effect
    }

    public static final B2.n V(B2.n n0, a a0, l l0) {
        q.g(n0, "<this>");
        q.g(a0, "block");
        ((p)l0).b0(0x3D7E2F8);
        ((p)l0).b0(0xF188FCFB);
        C2.e e0 = new C2.e(String.valueOf(((p)l0).P), a0);
        ((p)l0).p(false);
        B2.n n1 = n0.b(new C2.b(e0, 0x7F0807E6));  // drawable:ripple_no_effect
        ((p)l0).p(false);
        return n1;
    }

    public static final void W(O.F f0, int v, a a0, l l0, int v1) {
        q.g(f0, "<this>");
        q.g(a0, "onLoadMore");
        ((p)l0).c0(0x1D7F1715);
        int v2 = (((p)l0).g(f0) ? 4 : 2) | v1 | (((p)l0).i(a0) ? 0x100 : 0x80);
        boolean z = false;
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if(v < 0) {
                throw new IllegalArgumentException(("buffer cannot be negative, but was " + v).toString());
            }
            E e0 = ((p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(e0 == v3) {
                e0 = androidx.compose.runtime.w.i(new T(f0, v, 0));
                ((p)l0).l0(e0);
            }
            if((v2 & 0x380) == 0x100) {
                z = true;
            }
            d0 d00 = ((p)l0).N();
            if(z || d00 == v3) {
                d00 = new d0(e0, a0, null);
                ((p)l0).l0(d00);
            }
            J.d(((p)l0), e0, d00);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U(f0, v, a0, v1, 0);
        }
    }

    public static final r0.q X(r0.q q0, Context context0, l l0) {
        q.g(q0, "<this>");
        q.g(context0, "context");
        ((p)l0).a0(0xFD570BE4);
        ((p)l0).p(false);
        return q0.then(r0.a.a(n.a, new B0(3, 1)));
    }

    public static final float Y(float f, l l0) {
        return ((r1.c)((p)l0).k(k0.h)).S(f);
    }

    public static final float Z(l l0, int v) {
        return ((r1.c)((p)l0).k(k0.h)).R(v);
    }

    public static final void a(Bc.a a0, a a1, a a2, a a3, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x7F9DAFB1);
        int v1 = v | (p0.g(a0) ? 4 : 2) | (p0.i(a1) ? 0x20 : 16) | (p0.i(a2) ? 0x100 : 0x80) | (p0.i(a3) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            boolean z = a0.f;
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f), 122.0f), new B(10, a1));
            if(!z) {
                q0 = e2.a.r(q0, 0.3f);
            }
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = r0.a.a(e0.K(d.h(d.q(n0, 110.0f), 110.0f)), new B(11, a2));
            r0.b.c(q3, a0.b, 110.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            if(z) {
                p0.a0(0x8F03C76D);
                r0.q q4 = r0.a.a(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.c), 0.0f, 6.0f, 6.0f, 0.0f, 9), new B(12, a3));
                androidx.compose.foundation.q.c(I.Q(0x7F08015E, p0, 6), null, q4, null, N0.j.g, 0.0f, null, p0, 0x6030, 104);  // drawable:btn_common_play_01
            }
            else {
                p0.a0(0x8EE6CCFB);
            }
            p0.p(false);
            p0.p(true);
            r0.q q5 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            long v5 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(a0.c, null, v5, 15.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 0.0f, 0.0f, 13);
            long v6 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(a0.d, q7, v6, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            r0.q q8 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13);
            long v7 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(a0.e, q8, v7, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(a0, a1, a2, a3, v, 3);
        }
    }

    public static final float a0(float f, l l0) {
        return ((r1.c)((p)l0).k(k0.h)).Y(f);
    }

    public static final void b(r0.q q0, int v, List list0, g g0, int v1, int v2, int v3, int v4, int v5, int v6, float f, float f1, float f2, float f3, we.k k0, l l0, int v7, int v8) {
        r0.q q2;
        V v13;
        int v12;
        int v9;
        q.g(list0, "itemList");
        ((p)l0).c0(0xDEDFCA7B);
        if((v8 & 1) == 0) {
            v9 = (v7 & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v7 : v7;
        }
        else {
            v9 = v7 | 6;
        }
        if((v7 & 0x30) == 0) {
            v9 |= (((p)l0).e(v) ? 0x20 : 16);
        }
        if((v7 & 0x180) == 0) {
            v9 |= (((p)l0).i(list0) ? 0x100 : 0x80);
        }
        if((v7 & 0xC00) == 0) {
            v9 |= (((p)l0).g(g0) ? 0x800 : 0x400);
        }
        if((v7 & 0x6000) == 0) {
            v9 |= (((p)l0).e(v1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v7) == 0) {
            v9 |= (((p)l0).e(v2) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v7) == 0) {
            v9 |= (((p)l0).e(v3) ? 0x100000 : 0x80000);
        }
        if((v7 & 0xC00000) == 0) {
            v9 |= (((p)l0).e(v4) ? 0x800000 : 0x400000);
        }
        if((v7 & 0x6000000) == 0) {
            v9 |= (((p)l0).e(v5) ? 0x4000000 : 0x2000000);
        }
        if((v7 & 0x30000000) == 0) {
            v9 |= (((p)l0).e(v6) ? 0x20000000 : 0x10000000);
        }
        int v10 = ((p)l0).i(k0) ? 0x4000 : 0x2000;
        if(((p)l0).Q(v9 & 1, (v9 & 306783379) != 306783378 || ((3510 | v10) & 9363) != 9362)) {
            r0.q q1 = (v8 & 1) == 0 ? q0 : n.a;
            O.F f4 = O.I.a(0, 0, 3, ((p)l0));
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            r0.h h0 = r0.d.k;
            boolean z = ((p)l0).i(list0);
            Cc.c c0 = ((p)l0).N();
            V v11 = androidx.compose.runtime.k.a;
            if((((v9 & 0xE000) == 0x4000 ? 1 : 0) | (z | (v9 & 0x70) == 0x20) | ((v9 & 0x70000) == 0x20000 ? 1 : 0) | ((v9 & 0x380000) == 0x100000 ? 1 : 0) | ((v9 & 0x1C00000) == 0x800000 ? 1 : 0) | ((v9 & 0xE000000) == 0x4000000 ? 1 : 0) | ((v9 & 0x70000000) == 0x20000000 ? 1 : 0) | (((3510 | v10) & 0xE000) == 0x4000 ? 1 : 0)) != 0 || c0 == v11) {
                v12 = v9 & 0x70;
                v13 = v11;
                Cc.c c1 = new Cc.c(list0, v, v1, v2, v3, v4, v5, v6, f, k0, f1, f2, f3);
                ((p)l0).l0(c1);
                c0 = c1;
            }
            else {
                v12 = v9 & 0x70;
                v13 = v11;
            }
            q2 = q1;
            c1.q(q2, f4, j00, g0, h0, null, false, c0, ((p)l0), 0x30180 | v9 & 14 | v9 << 3 & 0xE000, 200);
            Integer integer0 = v;
            boolean z1 = ((p)l0).g(f4);
            Cc.f f5 = ((p)l0).N();
            if(z1 || v12 == 0x20 || f5 == v13) {
                f5 = new Cc.f(f4, v, null);
                ((p)l0).l0(f5);
            }
            J.d(((p)l0), integer0, f5);
        }
        else {
            ((p)l0).T();
            q2 = q0;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Cc.d(q2, v, list0, g0, v1, v2, v3, v4, v5, v6, f, f1, f2, f3, k0, v7, v8);
        }
    }

    public static final void c(r0.q q0, boolean z, long v, String s, String s1, N0.k k0, float f, we.k k1, l l0, int v1, int v2) {
        long v7;
        p p0 = (p)l0;
        p0.c0(0x907D6FF9);
        int v3 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (p0.h(false) ? 0x100 : 0x80);
        }
        int v4 = (v1 & 0x6000) == 0 ? v3 | 0xC00 | (p0.i(s) ? 0x4000 : 0x2000) : v3 | 0xC00;
        if((0x30000 & v1) == 0) {
            v4 |= (p0.g(s1) ? 0x20000 : 0x10000);
        }
        int v5 = (0xC00000 & v1) == 0 ? v4 | 0x180000 | (p0.g(k0) ? 0x800000 : 0x400000) : v4 | 0x180000;
        if((0x6000000 & v1) == 0) {
            v5 |= (p0.d(f) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v1) == 0) {
            v5 |= (p0.i(k1) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v5 & 1, (306783379 & v5) != 306783378)) {
            G.e e0 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(e0 == v6) {
                e0 = G.f.a(1.0f);
                p0.l0(e0);
            }
            M0 m00 = p0.N();
            if(m00 == v6) {
                m00 = androidx.compose.runtime.w.q(0L);
                p0.l0(m00);
            }
            b0 b00 = p0.N();
            if(b00 == v6) {
                b00 = androidx.compose.runtime.w.s(s1);
                p0.l0(b00);
            }
            c1.n(androidx.compose.ui.graphics.a.b(q0, ((Number)e0.d()).floatValue(), ((Number)e0.d()).floatValue(), 0.0f, 0.0f, 0.0f, null, false, 0x1FFFC), s, null, k0, false, 0, k1, null, null, 0.0f, null, 0, 0, false, false, p0, v5 >> 9 & 0x70 | v5 >> 12 & 0x380 | v5 >> 12 & 0x1C00 | v5 >> 9 & 0x380000, 0, 0x7FB0);
            Object[] arr_object = {s, Boolean.valueOf(z), s1, Boolean.FALSE, f};
            boolean z1 = p0.i(e0);
            Cc.j j0 = p0.N();
            if((z1 | (0x70000 & v5) == 0x20000 | ((v5 & 0x70) == 0x20 ? 1 : 0) | ((0xE000000 & v5) == 0x4000000 ? 1 : 0) | ((v5 & 0x1C00) == 0x800 ? 1 : 0) | ((v5 & 0x380) == 0x100 ? 1 : 0)) != 0 || j0 == v6) {
                Cc.j j1 = new Cc.j(s1, e0, z, f, 10000L, false, b00, m00, null);
                p0.l0(j1);
                j0 = j1;
            }
            J.g(arr_object, j0, p0);
            v7 = 10000L;
        }
        else {
            p0.T();
            v7 = v;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.h(q0, z, v7, s, s1, k0, f, k1, v1, v2);
        }
    }

    public static final void d(String s, String s1, boolean z, boolean z1, a a0, a a1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-378301566);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.h(z1) ? 0x800 : 0x400) | (p0.i(a0) ? 0x4000 : 0x2000) | (p0.i(a1) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(n0, 88.0f), new B(13, a0));
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = d.h(d.q(androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 14.0f, 0.0f, 10), 72.0f), 72.0f);
            r0.q q3 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q2, T.e.a);  // color:gray100a
            String s2 = "";
            r0.b.e(q3, (s == null ? "" : s), 72.0f, null, 0L, false, false, p0, 0xC00180, 120);
            if(s1 != null) {
                s2 = s1;
            }
            N1.b(s2, U4.x.r(1.0f, androidx.compose.foundation.layout.a.n(n0, 7.0f, 0.0f, 0.0f, 0.0f, 14), true), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            if(z) {
                p0.a0(0xDACC956A);
                c1.n(androidx.compose.foundation.layout.a.n(r0.a.a(n0, new B(14, a1)), 14.0f, 0.0f, 20.0f, 0.0f, 10), ((int)(z1 ? 0x7F08013E : 0x7F08013C)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);  // drawable:btn_common_fan_22_on
            }
            else {
                p0.a0(0xDAAFCCDC);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.k(s, s1, z, z1, a0, a1, v);
        }
    }

    public static final void e(String s, String s1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xC8A6BE33);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s1) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Bc.h h0 = x.I(p0);
            String s2 = p0.N();
            String s3 = "";
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 14) == 4 || s2 == v2) {
                if(h0 == null) {
                    s2 = "";
                }
                else {
                    String s4 = h0.a(s);
                    s2 = s4 == null ? "" : s4;
                }
                p0.l0(s2);
            }
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            r0.q q2 = d5.n.o(d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 0.5f, 7), 14.0f), T.e.a);
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(ye.a.v(p0, 0x7F0604AE), 0.5f);  // color:white120e
            r0.q q3 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q2, y0.a, y0.b, T.e.a), e0.T(p0, 0x7F0604AF), y0.M.a);  // color:white160e_support_high_contrast
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            androidx.compose.runtime.w.x(p0, q4, h4);
            c1.n(d.c, s1, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 & 0x70 | 0xD86, 0, 0x7FF0);
            p0.p(true);
            c.d(p0, d.q(n0, 3.0f));
            r0.q q5 = androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 0.0f, 0.5f, 0.0f, 0.0f, 13);
            boolean z = p0.g(s2);
            Ac.g g0 = p0.N();
            if(z || g0 == v2) {
                g0 = new Ac.g(s2, 6);
                p0.l0(g0);
            }
            r0.q q6 = X0.n.c(q5, false, g0);
            if(s != null) {
                s3 = s;
            }
            N1.b(s3, q6, e0.T(p0, 0x7F0604A1), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new y0(v, 1, s, s1);
        }
    }

    public static final void f(String s, String s1, String s2, r0.q q0, float f, int v, float f1, a a0, a a1, l l0, int v1, int v2) {
        r0.q q9;
        p p0 = (p)l0;
        p0.c0(1204543214);
        int v3 = (v1 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(null) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.g(s2) ? 0x800 : 0x400);
        }
        if((v2 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            v3 |= (p0.g(q0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v3 |= (p0.d(f) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v3 |= (p0.e(v) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v3 |= (p0.d(f1) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v1) == 0) {
            v3 |= (p0.i(a0) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v1) == 0) {
            v3 |= (p0.i(a1) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v3 & 1, (306783379 & v3) != 306783378)) {
            n n0 = n.a;
            r0.q q1 = (v2 & 16) == 0 ? q0 : n0;
            r0.q q2 = r0.a.a(d.f(d.h(androidx.compose.foundation.layout.a.n(q1, 0.0f, 0.0f, 0.0f, 11.0f, 7), 110.0f), 1.0f), new B(15, a1));
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            w3.h(s, e0.K(d.q(n0, 78.0f)), null, p0, v3 & 14, 4);
            r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 50.0f, 4.0f, 0.0f, 0.0f, 12);
            boolean z = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z || n1 == androidx.compose.runtime.k.a) {
                n1 = new Cc.n(context0, 0);
                p0.l0(n1);
            }
            c1.n(r0.a.a(X0.n.c(q5, false, n1), new B(16, a0)), 0x7F08015E, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_common_play_01
            c1.n(androidx.compose.foundation.layout.a.n(n0, 7.0f, 6.0f, 0.0f, 0.0f, 12), 0x7F08067F, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:img_station_logo_02
            p0.p(true);
            r0.q q6 = androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 0.0f, 0.0f, 14);
            r0.q q7 = H0.b.r(r0.d.k, q6);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            p0.a0(-229749650);
            p0.p(false);
            N1.b((s1 == null ? "" : s1), androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC36, 0x1D3F0);  // color:gray900s
            N1.b((s2 == null ? "" : s2), androidx.compose.foundation.layout.a.n(n0, 0.0f, f, 0.0f, 0.0f, 13), e0.T(p0, v), f1, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v3 >> 12 & 0x1C00, 0xC30, 0x1D7F0);
            p0.p(true);
            p0.p(true);
            q9 = q1;
        }
        else {
            p0.T();
            q9 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new o(s, s1, s2, q9, f, v, f1, a0, a1, v1, v2);
        }
    }

    public static final void g(String s, boolean z, List list0, float f, int v, float f1, a a0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0xDB0BA2CA);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(list0) ? 0x100 : 0x80) | (p0.i(a0) ? 0x100000 : 0x80000);
        if(p0.Q(v2 & 1, (0x92493 & v2) != 0x92492)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.q q0 = androidx.compose.foundation.layout.a.n(d.f(n.a, 1.0f), E9.h.t(p0, 0x7F0700E3), 0.0f, E9.h.t(p0, 0x7F0700E3), 30.0f, 2);  // dimen:detail_list_padding_left_right
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            e0.h(s, z, null, a0, p0, v2 & 0x7E | v2 >> 9 & 0x1C00, 4);
            p0.a0(0xF315085F);
            int v4 = 0;
            for(Object object0: list0) {
                if(v4 >= 0) {
                    e0.f(((Cc.s)object0).a, ((Cc.s)object0).b, ((Cc.s)object0).c, null, f, v, f1, ((Cc.s)object0).d, ((Cc.s)object0).e, p0, 0xDB0000, 16);
                    ++v4;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.p(s, z, list0, f, v, f1, a0, v1);
        }
    }

    public static final void h(String s, boolean z, r0.q q0, a a0, l l0, int v, int v1) {
        r0.q q4;
        a a2;
        a a1;
        p p0 = (p)l0;
        p0.c0(0x8CE6F9C6);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
            a1 = a0;
        }
        else if((v & 0xC00) == 0) {
            a1 = a0;
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        else {
            a1 = a0;
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q1 = (v1 & 4) == 0 ? q0 : n0;
            if((v1 & 8) != 0) {
                a1 = null;
            }
            r0.q q2 = d.f(d.h(q1, 42.0f), 1.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            N1.b((s == null ? "" : s), U4.x.r(1.0f, d.f(d.h(n0, 18.0f), 1.0f), true), e0.T(p0, 0x7F06016D), 16.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);  // color:gray900s
            if(z) {
                p0.a0(1448483708);
                q.f("전체보기", "getString(...)");
                long v4 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
                N1.b("전체보기", r0.a.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), new B(17, a1)), v4, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            }
            else {
                p0.a0(1446940280);
            }
            p0.p(false);
            p0.p(true);
            a2 = a1;
            q4 = q1;
        }
        else {
            p0.T();
            q4 = q0;
            a2 = a1;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.q(s, z, q4, a2, v, v1);
        }
    }

    public static final void i(Kd.g g0, String s, long v, long v1, long v2, boolean z, boolean z1, a a0, a a1, l l0, int v3) {
        q.g(s, "rank");
        p p0 = (p)l0;
        p0.c0(1851036247);
        int v4 = v3 | (p0.i(g0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.f(v) ? 0x100 : 0x80) | (p0.f(v1) ? 0x800 : 0x400) | (p0.f(v2) ? 0x4000 : 0x2000) | 0xC00000 | (p0.i(a0) ? 0x4000000 : 0x2000000) | (p0.i(a1) ? 0x20000000 : 0x10000000);
        if(p0.Q(v4 & 1, (306783379 & v4) != 306783378)) {
            p0.V();
            if((v3 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z2 = g0.i;
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(d.f(n0, 1.0f), 60.0f), new Cc.w(0));
            if(!z2) {
                q0 = e2.a.r(q0, 0.3f);
            }
            boolean z3 = p0.i(context0);
            boolean z4 = p0.i(g0);
            t t0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(((v4 & 0x70) == 0x20 | z3 | z4) != 0 || t0 == v5) {
                t0 = new t(context0, s, g0, 0);
                p0.l0(t0);
            }
            r0.q q1 = X0.n.c(q0, true, t0);
            M.b b0 = j.a;
            p0 p00 = n0.a(b0, r0.d.j, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = U4.x.r(1.0f, d.c(n0, 1.0f), true);
            p0 p01 = n0.a(b0, r0.d.k, p0, 0x30);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            boolean z5 = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z5 || n1 == v5) {
                n1 = new Cc.n(context0, 1);
                p0.l0(n1);
            }
            int v8 = v4 << 3 & 0x70;
            c1.R(X0.n.c(q5, false, n1), g0, v2, z, a0, p0, v8 | v4 >> 6 & 0x380 | 0xC00 | v4 >> 12 & 0xE000, 0);
            r0.q q6 = d.t(d.q(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 30.0f), 3);
            C0 c00 = p0.N();
            if(c00 == v5) {
                c00 = new C0(11);
                p0.l0(c00);
            }
            N1.b(s, X0.n.b(q6, c00), v, 17.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, v4 >> 3 & 14 | 0xC00 | v4 & 0x380, 0, 0x1FDF0);
            c1.S(d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 5.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3), g0, v, v1, true, false, false, p0, v8 | 6 | v4 & 0x380 | v4 & 0x1C00 | 0x36DB6000, 438, 0);
            p0.p(true);
            c1.Q(z2, z1, v, a1, null, p0, 0x30 | v4 & 0x380 | v4 >> 18 & 0x1C00 | 0x6000, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.u(g0, s, v, v1, v2, z, z1, a0, a1, v3);
        }
    }

    public static final void j(boolean z, float f, a a0, l l0, int v) {
        ((p)l0).c0(-1149804194);
        int v1 = (((p)l0).h(z) ? 4 : 2) | v | 0x30 | (((p)l0).i(a0) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            f = 18.0f;
            n n0 = n.a;
            if(z) {
                ((p)l0).a0(0xA96DEB48);
                r0.q q0 = r0.a.a(d.n(n0, 18.0f), new B(18, a0));
                androidx.compose.foundation.q.c(I.Q(0x7F080170, ((p)l0), 6), e.Y(((p)l0), 0x7F130AF3), q0, null, null, 0.0f, null, ((p)l0), 0, 120);  // drawable:btn_common_select_18_on
            }
            else {
                ((p)l0).a0(-1452091302);
                r0.q q1 = r0.a.a(d.n(n0, 18.0f), new B(19, a0));
                C0.c c0 = I.Q(0x7F08016F, ((p)l0), 6);  // drawable:btn_common_select_18_off
                y0.k k0 = new y0.k(e0.T(((p)l0), 0x7F060154), 5);  // color:gray200s_support_high_contrast
                androidx.compose.foundation.q.c(c0, e.Y(((p)l0), 0x7F130AF3), q1, null, null, 0.0f, k0, ((p)l0), 0, 56);  // string:talkback_common_select "%s 선택됨"
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Cc.y(z, f, a0, v);
        }
    }

    public static final void k(r0.q q0, boolean z, l l0, int v) {
        ((p)l0).c0(-1850680530);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).h(z) ? 0x20 : 16);
        }
        if(!((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            ((p)l0).T();
        }
        else if(z) {
            ((p)l0).a0(0x33F4119B);
            androidx.compose.foundation.q.c(I.Q(0x7F080172, ((p)l0), 6), null, q0, null, null, 0.0f, null, ((p)l0), v1 << 6 & 0x380 | 0x30, 120);  // drawable:btn_common_select_18_w_on
            ((p)l0).p(false);
        }
        else {
            ((p)l0).a0(0x33F70B68);
            androidx.compose.foundation.q.c(I.Q(0x7F080171, ((p)l0), 6), null, q0, null, null, 0.0f, new y0.k(e0.T(((p)l0), 0x7F0604B2), 5), ((p)l0), v1 << 6 & 0x380 | 0x30, 56);  // drawable:btn_common_select_18_w_off
            ((p)l0).p(false);
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Cc.x(q0, z, v, 0);
        }
    }

    public static final void l(boolean z, String s, String s1, a a0, a a1, we.k k0, l l0, int v) {
        q.g(s, "songCountStr");
        p p0 = (p)l0;
        p0.c0(0xFA575B6B);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000) | 0x30000 | (p0.i(k0) ? 0x100000 : 0x80000);
        if(p0.Q(v1 & 1, (0x92493 & v1) != 0x92492)) {
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            r0.q q0 = r0.a.d(p0, n0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            c.d(p0, d.h(n0, 4.0f));
            e0.n(a0, a1, p0, v1 & 0x1C00 | 438 | 0xE000 & v1 | 0x30000);
            r0.q q1 = d.f(d.h(androidx.compose.foundation.layout.a.n(n0, 20.0f, 16.0f, 20.0f, 0.0f, 8), E9.h.t(p0, 0x7F0703F2)), 1.0f);  // dimen:new_filter_layout_height
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            e0.x(z, k0, p0, v1 & 14 | v1 >> 15 & 0x70);
            c.c((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.f), j.h(6.0f), null, null, 0, 0, m0.c.e(0xD29F24CC, p0, new a4(1, s, s1)), p0, 0x180030, 60);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.I(z, s, s1, a0, a1, k0, v);
        }
    }

    public static final void m(l l0, int v) {
        ((p)l0).c0(1301071401);
        if(((p)l0).Q((v | 6) & 1, ((v | 6) & 3) != 2)) {
            P4.a.b(androidx.compose.foundation.layout.a.l(d.h(d.f(n.a, 1.0f), 0.5f), 20.0f, 0.0f, 2), e0.T(((p)l0), 0x7F06014A), 0.0f, 0.0f, ((p)l0), 0, 12);  // color:gray100a
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.F(v, 7);
        }
    }

    public static final void n(a a0, a a1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x12DCB0C8);
        int v1 = (v & 6) == 0 ? (p0.h(true) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(true) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.h(false) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.i(a1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(null) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            float f = E9.h.t(p0, 0x7F070407);  // dimen:play_shuffle_button_height
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(d.f(d.h(n0, f), 1.0f), 20.0f, 0.0f, 2);
            p0 p00 = n0.a(j.h(10.0f), r0.d.j, p0, 6);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            p0.a0(-1504143940);
            String s = e.Y(p0, 0x7F1302F5);  // string:detail_common_play_button_all "전체"
            boolean z = p0.i(context0);
            Cc.n n1 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(z || n1 == v3) {
                n1 = new Cc.n(context0, 2);
                p0.l0(n1);
            }
            c1.j(r0.a.a(q0.a(X0.n.c(n0, false, n1), 1.0f), new B(20, a0)), s, p0, 0x7F080405, 0x30);  // drawable:ic_common_play_01
            p0.p(false);
            p0.a0(0xA660A871);
            String s1 = e.Y(p0, 0x7F1302F7);  // string:detail_common_play_button_shuffle "셔플"
            boolean z1 = p0.i(context0);
            Cc.n n2 = p0.N();
            if(z1 || n2 == v3) {
                n2 = new Cc.n(context0, 3);
                p0.l0(n2);
            }
            c1.j(r0.a.a(q0.a(X0.n.c(n0, false, n2), 1.0f), new B(21, a1)), s1, p0, 0x7F08040E, 0x30);  // drawable:ic_common_shuffle_01
            p0.p(false);
            p0.a0(-1505722026);
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.J(v, 0, a0, a1);
        }
    }

    public static final void o(Cc.M m0, l l0, int v) {
        h h9;
        i i2;
        h h7;
        V v5;
        h h6;
        h h5;
        n n1;
        h h4;
        i i1;
        p p0 = (p)l0;
        p0.c0(0x28DB7C9B);
        int v1 = v | (p0.g(m0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.m(d.f(n0, 1.0f), 20.0f, 11.0f, 20.0f, 11.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            V v3 = androidx.compose.runtime.k.a;
            if(m0.d.length() > 0) {
                p0.a0(0xDA8A921F);
                C0 c00 = p0.N();
                if(c00 == v3) {
                    c00 = new C0(12);
                    p0.l0(c00);
                }
                r0.q q2 = X0.n.c(n0, false, c00);
                long v4 = e0.T(p0, m0.h);
                i1 = i0;
                h4 = h0;
                n1 = n0;
                h5 = h2;
                h6 = h3;
                v5 = v3;
                h7 = h1;
                Cc.E.a(q2, m0.d, m0.e, m0.f, 0, 15.0f, v4, 0L, null, 1, 0, null, 0.0f, null, null, p0, 0x30030000, 0, 0xFD90);
                A7.d.v(n1, 5.0f, p0, false);
            }
            else {
                n1 = n0;
                h7 = h1;
                h6 = h3;
                h5 = h2;
                i1 = i0;
                h4 = h0;
                v5 = v3;
                p0.a0(0xDA700711);
                p0.p(false);
            }
            r0.q q3 = d.f(n1, 1.0f);
            r0.h h8 = r0.d.k;
            M.b b0 = j.a;
            p0 p00 = n0.a(b0, h8, p0, 0x30);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h4);
            androidx.compose.runtime.w.x(p0, i01, h7);
            if(!p0.O && q.b(p0.N(), v6)) {
                h9 = h5;
            }
            else {
                h9 = h5;
                A7.d.q(v6, p0, v6, h9);
            }
            androidx.compose.runtime.w.x(p0, q4, h6);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            p0 p01 = n0.a(b0, h8, p0, 0x30);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h4);
            androidx.compose.runtime.w.x(p0, i02, h7);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h9);
            }
            androidx.compose.runtime.w.x(p0, q5, h6);
            C0 c01 = p0.N();
            if(c01 == v5) {
                c01 = new C0(13);
                p0.l0(c01);
            }
            r0.q q6 = r0.a.a(X0.n.c(n1, false, c01), new L(m0, 1));
            long v8 = e0.T(p0, m0.g);
            long v9 = e0.T(p0, 0x7F06016D);  // color:gray900s
            Cc.E.a(q6, m0.a, m0.b, m0.c, 0, 22.0f, v8, v9, e1.y.i, 1, 0, e1.y.i, 0.0f, null, null, p0, 0x36030000, 0x30, 0xF410);
            if(m0.i.length() > 0) {
                p0.a0(0x11A24537);
                c.d(p0, d.q(n1, 4.0f));
                c1.n(d.h(d.q(n1, m0.j), m0.k), m0.i, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6180, 0, 0x7FE8);
            }
            else {
                p0.a0(0x116FEAC9);
            }
            p0.p(false);
            p0.p(true);
            if(m0.n == null) {
                p0.a0(0x7944F8AD);
            }
            else {
                p0.a0(0x797F50FC);
                r0.q q7 = r0.a.a(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), new L(m0, 0));
                long v10 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
                N1.b(m0.l, q7, v10, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(m0, v, 1);
        }
    }

    public static final void p(String s, String s1, String s2, r0.q q0, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xB38AB524);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(q0) ? 0x800 : 0x400) | (p0.i(a0) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            r0.q q1 = r0.a.a(d.f(d.h(androidx.compose.foundation.layout.a.n(q0, 0.0f, 0.0f, 0.0f, 11.0f, 7), 84.0f), 1.0f), new u0(0, a0));
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            n n0 = n.a;
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            w3.h(s, e0.K(d.c(d.q(n0, 150.0f), 1.0f)), null, p0, v1 & 14, 4);
            c1.n(androidx.compose.foundation.layout.a.n(n0, 7.0f, 6.0f, 0.0f, 0.0f, 12), 0x7F08064C, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:img_magazine_logo_02
            p0.p(true);
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 0.0f, 0.0f, 14);
            r0.q q5 = H0.b.r(r0.d.k, q4);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            N1.b((s1 == null ? "" : s1), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);  // color:gray900s
            N1.b((s2 == null ? "" : s2), androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t0(s, s1, s2, q0, a0, v, 0);
        }
    }

    public static final void q(String s, int v, String s1, String s2, String s3, r0.q q0, a a0, l l0, int v1) {
        n n1;
        i i1;
        h h6;
        h h5;
        h h4;
        p p0 = (p)l0;
        p0.c0(0x94D911E0);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.g(s2) ? 0x800 : 0x400) | (p0.g(s3) ? 0x4000 : 0x2000) | (p0.g(q0) ? 0x20000 : 0x10000) | 0xD80000 | (p0.i(a0) ? 0x4000000 : 0x2000000);
        if(p0.Q(v2 & 1, (0x2492493 & v2) != 0x2492492)) {
            r0.q q1 = d.f(d.h(androidx.compose.foundation.layout.a.n(q0, 0.0f, 0.0f, 0.0f, 11.0f, 7), 84.0f), 1.0f);
            C0 c00 = p0.N();
            if(c00 == androidx.compose.runtime.k.a) {
                c00 = new C0(18);
                p0.l0(c00);
            }
            r0.q q2 = r0.a.a(X0.n.c(q1, false, c00), new u0(1, a0));
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            n n0 = n.a;
            r0.q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            w3.i(v2 & 14 | 0x30, p0, s, d.c(d.q(n0, 150.0f), 1.0f));
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            if(v == -1) {
                n1 = n0;
                h6 = h1;
                h4 = h2;
                i1 = i0;
                h5 = h0;
                p0.a0(-590878036);
            }
            else {
                p0.a0(-588806988);
                h4 = h2;
                h5 = h0;
                h6 = h1;
                i1 = i0;
                n1 = n0;
                c1.n(b0.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 7.0f, 7.0f, 0.0f, 9), r0.d.c), v, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 & 0x70, 0, 0x7FFC);
            }
            p0.p(false);
            N1.b(s1, b0.a(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 8.0f, 6), r0.d.g), e0.T(p0, 0x7F0604A1), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, new a1.U(0L, 0L, null, null, 0L, new y0.P(e0.T(p0, 0x7F060160), 2), 0, 0L, 0xFFDFFF), p0, 0xC00, 0, 0xFFF0);  // color:white000e
            p0.p(true);
            r0.q q5 = androidx.compose.foundation.layout.a.n(n1, 12.0f, 0.0f, 0.0f, 0.0f, 14);
            r0.q q6 = H0.b.r(r0.d.k, q5);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h5);
            androidx.compose.runtime.w.x(p0, i02, h6);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            String s4 = "";
            N1.b((s2 == null ? "" : s2), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);  // color:gray900s
            if(s3 != null) {
                s4 = s3;
            }
            N1.b(s4, androidx.compose.foundation.layout.a.n(n1, 0.0f, 3.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.n0(s, v, s1, s2, s3, q0, a0, v1);
        }
    }

    public static final void r(r0.q q0, long v, int v1, float f, l l0, int v2) {
        int v6;
        int v5;
        int v4;
        q.g(q0, "modifier");
        ((p)l0).c0(0xC7200556);
        int v3 = v2 | (((p)l0).f(v) ? 0x20 : 16) | 0x6080;
        boolean z = false;
        if(((p)l0).Q(v3 & 1, (v3 & 9363) != 9362)) {
            ((p)l0).V();
            if((v2 & 1) == 0 || ((p)l0).B()) {
                v4 = v3 & -897;
                v5 = 2;
            }
            else {
                ((p)l0).T();
                v4 = v3 & -897;
                v5 = v1;
            }
            ((p)l0).q();
            if((v4 & 0x70) == 0x20) {
                z = true;
            }
            boolean z1 = ((p)l0).e(v5);
            boolean z2 = ((p)l0).i(null);
            F f1 = ((p)l0).N();
            if((z1 | z | z2) != 0 || f1 == androidx.compose.runtime.k.a) {
                F f2 = new F(f, v, v5, 0);
                ((p)l0).l0(f2);
                f1 = f2;
            }
            androidx.compose.foundation.q.b(q0, f1, ((p)l0), 6);
            v6 = v5;
        }
        else {
            ((p)l0).T();
            v6 = v1;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new G(q0, v, v6, f, v2);
        }
    }

    public static final void s(r0.q q0, pc.b b0, String s, String s1, String s2, String s3, a a0, a a1, a a2, a a3, l l0, int v, int v1) {
        long v4;
        long v3;
        a a4;
        q.g(q0, "modifier");
        p p0 = (p)l0;
        p0.c0(0xFB48586);
        int v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.e((b0 == null ? -1 : b0.ordinal())) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.g(s1) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.g(s2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.g(s3) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v2 |= (p0.i(a0) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v2 |= (p0.i(a1) ? 0x800000 : 0x400000);
        }
        if((v1 & 0x100) != 0) {
            v2 |= 0x6000000;
        }
        else if((0x6000000 & v) == 0) {
            v2 |= (p0.i(a2) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v) == 0) {
            v2 |= (p0.i(a3) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v2 & 1, (306783379 & v2) != 306783378)) {
            a4 = (v1 & 0x100) == 0 ? a2 : null;
            if(b0 == null) {
                v4 = A7.d.f(p0, -1601878680, 0x7F060157, p0, false);  // color:gray400e
            }
            else {
                p0.a0(0xA08482B0);
                p0.p(false);
                switch(b0.ordinal()) {
                    case 0: 
                    case 4: {
                        v3 = 0xFF1520BFL;
                        break;
                    }
                    case 1: 
                    case 5: {
                        v3 = 0xFF45009DL;
                        break;
                    }
                    case 2: 
                    case 6: {
                        v3 = 0xFF6B0498L;
                        break;
                    }
                    case 3: 
                    case 7: {
                        v3 = 0xFF3912B9L;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                v4 = v3 << 0x20;
            }
            r0.q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.l(q0, 20.0f, 0.0f, 2), v4, T.e.b(6.0f));
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            e0.D(a0, p0, v2 >> 18 & 14);
            r0.q q3 = r0.a.a(d.c(new LayoutWeightElement(1.0f, true), 1.0f), new r(e.Y(p0, 0x7F130B16), a4, a1, 2));  // string:talkback_dj_malrang_open_other_recommend_list "다른 제안 목록 보기"
            M m0 = M.p.d(r0.d.a, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            n n0 = n.a;
            r0.q q5 = d.f(n0, 1.0f);
            r0.q q6 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.e);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            e0.E(v2 >> 3 & 0x70 | 6, p0, s, d.f(n0, 1.0f));
            c.d(p0, d.h(n0, 3.0f));
            if(s3 != null && s3.length() != 0) {
                p0.a0(0xCC76E40A);
                e0.e(s2, s3, p0, v2 >> 12 & 0x7E);
            }
            else {
                p0.a0(0xCC79ABD4);
                e0.H(s1, s2, p0, v2 >> 9 & 0x7E);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            c.d(p0, d.q(n0, 13.0f));
            M.p.a(androidx.compose.foundation.q.f(d.c(d.q(n0, 1.0f), 1.0f), e0.T(p0, 0x7F060151), y0.M.a), p0, 0);  // color:gray160e
            e0.G(a3, p0, v2 >> 27 & 14);
            p0.p(true);
        }
        else {
            p0.T();
            a4 = a2;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new v0(q0, b0, s, s1, s2, s3, a0, a1, a4, a3, v, v1);
        }
    }

    public static final void t(Bc.c c0, a a0, a a1, a a2, l l0, int v) {
        h h5;
        p p0 = (p)l0;
        p0.c0(-1644006908);
        int v1 = v | (p0.g(c0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(a1) ? 0x100 : 0x80) | (p0.i(a2) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f), 122.0f), new u0(4, a0));
            boolean z = p0.i(context0);
            D d0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 14) == 4 || z || d0 == v2) {
                d0 = new D(16, context0, c0);
                p0.l0(d0);
            }
            r0.q q1 = X0.n.c(q0, true, d0);
            r0.h h0 = r0.d.k;
            p0 p00 = n0.a(j.a, h0, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            M.b b0 = j.a;
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h4);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            androidx.compose.runtime.w.x(p0, q3, h4);
            r0 r00 = r0.b;
            r0.q q4 = r0.a.a(e0.K(d.h(d.q(n0, 110.0f), 110.0f)), new u0(5, a1));
            boolean z1 = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z1 || n1 == v2) {
                n1 = new Cc.n(context0, 4);
                p0.l0(n1);
            }
            r00.c(X0.n.c(q4, false, n1), c0.b, 110.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            r0.q q5 = r0.a.a(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.c), 0.0f, 6.0f, 6.0f, 0.0f, 9), new u0(6, a2));
            androidx.compose.foundation.q.c(I.Q(0x7F08015E, p0, 6), "앨범 재생", q5, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);  // drawable:btn_common_play_01
            m m1 = N0.j.g;
            p0.p(true);
            r0.q q6 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f), 3);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h1);
            androidx.compose.runtime.w.x(p0, i02, h2);
            if(!p0.O && q.b(p0.N(), v5)) {
                h5 = h3;
            }
            else {
                h5 = h3;
                A7.d.q(v5, p0, v5, h5);
            }
            androidx.compose.runtime.w.x(p0, q7, h4);
            C0 c00 = p0.N();
            if(c00 == v2) {
                c00 = new C0(19);
                p0.l0(c00);
            }
            r0.q q8 = X0.n.b(n0, c00);
            long v6 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(c0.c, q8, v6, 15.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            r0.q q9 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 0.0f, 0.0f, 13);
            C0 c01 = p0.N();
            if(c01 == v2) {
                c01 = new C0(20);
                p0.l0(c01);
            }
            r0.q q10 = X0.n.b(q9, c01);
            long v7 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(c0.d, q10, v7, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            r0.q q11 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13);
            p0 p01 = n0.a(b0, h0, p0, 0x30);
            int v8 = p0.P;
            i0 i03 = p0.m();
            r0.q q12 = r0.a.d(p0, q11);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h1);
            androidx.compose.runtime.w.x(p0, i03, h2);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h5);
            }
            androidx.compose.runtime.w.x(p0, q12, h4);
            r0.q q13 = d.o(n0, 14.0f, 13.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F0803F9, p0, 6), null, q13, null, m1, 0.0f, null, p0, 25008, 104);  // drawable:ic_common_like_13
            r0.q q14 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
            C0 c02 = p0.N();
            if(c02 == v2) {
                c02 = new C0(21);
                p0.l0(c02);
            }
            r0.q q15 = X0.n.b(q14, c02);
            long v9 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(c0.e, q15, v9, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(c0, a0, a1, a2, v, 4);
        }
    }

    public static final void u(r0.q q0, String s, we.k k0, String s1, U.e0 e00, U.d0 d00, f1.F f0, a a0, l l0, int v, int v1) {
        f1.F f2;
        U.d0 d01;
        q.g(s, "value");
        q.g(k0, "onValueChange");
        q.g(s1, "hint");
        ((p)l0).c0(0xE8FE1066);
        int v2 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(s) ? 0x20 : 16) | (((p)l0).i(k0) ? 0x100 : 0x80) | (((p)l0).g(s1) ? 0x800 : 0x400);
        int v3 = (v1 & 0x20) == 0 ? v2 | (((p)l0).g(d00) ? 0x20000 : 0x10000) : v2 | 0x30000;
        int v4 = ((v1 & 0x40) == 0 ? v3 | (((p)l0).g(f0) ? 0x100000 : 0x80000) : v3 | 0x180000) | (((p)l0).i(a0) ? 0x800000 : 0x400000);
        if(((p)l0).Q(v4 & 1, (0x492493 & v4) != 4793490)) {
            d01 = (v1 & 0x20) == 0 ? d00 : U.d0.c;
            f1.F f1 = (v1 & 0x40) == 0 ? f0 : f1.E.a;
            y0.T t0 = new y0.T(ye.a.v(((p)l0), 0x7F06017C));  // color:green500s_support_high_contrast
            Object object0 = ((p)l0).k(Z.T.a);
            long v5 = e0.N(14.0f, ((p)l0));
            c1.i(s, k0, q0, false, a1.U.a(((a1.U)object0), ye.a.v(((p)l0), 0x7F06016D), v5, null, N1.a, 0L, 0L, null, null, 0xFFFFDC), e00, d01, true, false, 0, 0, f1, null, t0, m0.c.e(0x1A3224DB, ((p)l0), new i2(s, s1, a0, 1)), ((p)l0), v4 >> 3 & 0x70 | (v4 >> 3 & 14 | 0x6000000) | v4 << 6 & 0x380 | 0x180000 | v4 << 6 & 0x1C00000, v4 >> 12 & 0x380 | 0x180000, 0x6E18);  // color:gray900s
            f2 = f1;
        }
        else {
            ((p)l0).T();
            d01 = d00;
            f2 = f0;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new A0(q0, s, k0, s1, e00, d01, f2, a0, v, v1);
        }
    }

    public static final void v(com.melon.ui.U0 u00, l l0, int v) {
        q.g(u00, "uiState");
        p p0 = (p)l0;
        p0.c0(0x9277CE1C);
        int v1 = v | (p0.g(u00) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            String s = u00.b;
            int v2 = u00.a;
            String s1 = u00.c;
            String s2 = u00.d;
            a a0 = u00.e;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            if(s.length() == 0) {
                s = "목록이 없습니다.";
                q.f("목록이 없습니다.", "getString(...)");
            }
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, d.c);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            n n0 = n.a;
            r0.q q1 = d.h(d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 100.0f, 0.0f, 0.0f, 13), 79.0f), 79.0f);
            androidx.compose.foundation.q.c(I.Q(v2, p0, 0), null, q1, null, null, 0.0f, null, p0, 0x1B0, 120);
            r0.q q2 = d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 14.0f, 14.5f, 14.0f, 0.0f, 8), 1.0f), 3);
            long v4 = e0.T(p0, 0x7F060163);  // color:gray700s
            l1.k k0 = new l1.k(3);
            h h3 = P0.j.d;
            N1.b(s, q2, v4, 15.0f, null, null, 0L, k0, 18.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1F9F0);
            if(s1.length() > 0) {
                p0.a0(-663561790);
                N1.b(s1, d.t(d.f(androidx.compose.foundation.layout.a.n(n0, 14.0f, 14.5f, 14.0f, 0.0f, 8), 1.0f), 3), e0.T(p0, 0x7F06015D), 13.0f, null, null, 0L, new l1.k(3), 16.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1F9F0);  // color:gray500s_support_high_contrast
            }
            else {
                p0.a0(-665960260);
            }
            p0.p(false);
            if(s2.length() > 0) {
                p0.a0(0xD87B78B1);
                r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 14.0f, 20.0f, 14.0f, 0.0f, 8);
                androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
                T.d d0 = T.e.b(100.0f);
                r0.q q4 = r0.a.a(androidx.compose.foundation.q.j(q3, y1.a, y1.b, d0), new u0(8, a0));
                M m0 = M.p.d(r0.d.e, false);
                int v5 = p0.P;
                i0 i01 = p0.m();
                r0.q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m0, h0);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                androidx.compose.runtime.w.x(p0, q5, h3);
                N1.b(s2, d.h(d.v(androidx.compose.foundation.layout.a.l(n0, 14.0f, 0.0f, 2), null, 3), 36.0f), e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 1, 0, null, null, p0, 0xC30, 0xC00, 0x1DDF0);  // color:gray900s
                p0.p(true);
            }
            else {
                p0.a0(-665960260);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(u00, v, 2);
        }
    }

    public static final void w(List list0, float f, float f1, int v, a a0, l l0, int v1) {
        int v5;
        float f3;
        float f2;
        G.I i0;
        b0 b04;
        Cc.B0 b00;
        androidx.compose.runtime.n0 n00;
        p p0 = (p)l0;
        p0.c0(0x46D307AD);
        int v2 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        int v3 = (v1 & 0x6000) == 0 ? v2 | 0xDB0 | (p0.i(a0) ? 0x4000 : 0x2000) : v2 | 0xDB0;
        if(!p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            p0.T();
            f3 = f;
            f2 = f1;
            v5 = v;
        label_92:
            n00 = p0.t();
            if(n00 != null) {
                b00 = new D0(f3, f2, v5, v1, list0, a0);
                n00.d = b00;
            }
        }
        else if(list0.isEmpty()) {
            n00 = p0.t();
            if(n00 != null) {
                b00 = new Cc.B0(144.0f, 215.0f, v1, 0, list0, a0);
                n00.d = b00;
            }
        }
        else {
            b0 b01 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(b01 == v4) {
                b01 = androidx.compose.runtime.w.s(Boolean.TRUE);
                p0.l0(b01);
            }
            androidx.lifecycle.D d0 = (androidx.lifecycle.D)p0.k(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean z = p0.i(d0);
            D d1 = p0.N();
            if(z || d1 == v4) {
                d1 = new D(18, d0, b01);
                p0.l0(d1);
            }
            J.b(d0, d1, p0);
            b0 b02 = p0.N();
            if(b02 == v4) {
                b02 = U4.x.d(0, p0);
            }
            b0 b03 = p0.N();
            if(b03 == v4) {
                b03 = androidx.compose.runtime.w.s(1.0f);
                p0.l0(b03);
            }
            G.L l1 = G.f.p("", p0, 0);
            if(((Boolean)b01.getValue()).booleanValue()) {
                p0.a0(-405036930);
                b04 = b03;
                i0 = G.f.f(l1, 1.0f, 1.3f, G.f.n(G.f.r(3000, 0, C.d, 2), X.a, 0L, 4), "", p0, 0x71B8, 0);
            }
            else {
                b04 = b03;
                p0.a0(0xE7E04D81);
                Z z1 = p0.N();
                if(z1 == v4) {
                    z1 = androidx.compose.runtime.w.o(0.0f);
                    p0.l0(z1);
                }
                i0 = z1;
            }
            p0.p(false);
            if(((Number)b04.getValue()).floatValue() > ((Number)i0.getValue()).floatValue()) {
                b02.setValue(((int)((((Number)b02.getValue()).intValue() + 1) % list0.size())));
            }
            b04.setValue(i0.getValue());
            if(list0.size() == 1 || MelonSettingInfo.isLowMemoryMode()) {
                p0.a0(-404440521);
                r0.q q0 = r0.a.a(e0.L(d.o(n.a, 144.0f, 215.0f), 0x7F0604AE), new u0(9, a0));  // color:white120e
                M m0 = M.p.d(r0.d.a, false);
                int v6 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                i i1 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m0, P0.j.f);
                androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                h h0 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h0);
                }
                androidx.compose.runtime.w.x(p0, q1, P0.j.d);
                Object object0 = list0.get(0);
                c1.n(d.c, object0, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC06, 0, 0x7FF4);
                p0.p(true);
                p0.p(false);
                n00 = p0.t();
                if(n00 != null) {
                    b00 = new Cc.B0(144.0f, 215.0f, v1, 1, list0, a0);
                    n00.d = b00;
                }
            }
            else {
                p0.a0(-407511691);
                p0.p(false);
                ye.a.e(((Number)b02.getValue()).intValue(), null, G.f.r(300, 0, C.d, 2), "", m0.c.e(0xA7F89567, p0, new Cc.C0(144.0f, 215.0f, a0, i0, list0)), p0, 0x6C00, 2);
                Integer integer0 = list0.size();
                F0 f00 = p0.N();
                if(f00 == v4) {
                    f00 = new F0(b02, null);
                    p0.l0(f00);
                }
                J.d(p0, integer0, f00);
                f2 = 215.0f;
                f3 = 144.0f;
                v5 = 3000;
                goto label_92;
            }
        }
    }

    public static final void x(boolean z, we.k k0, l l0, int v) {
        long v3;
        p p0 = (p)l0;
        p0.c0(1802199513);
        int v1 = (v & 6) == 0 ? (p0.h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            float f = E9.h.t(p0, 0x7F0703F2);  // dimen:new_filter_layout_height
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.h(n0, f), new Cc.M0(k0, z, 0));
            boolean z1 = p0.i(context0);
            J0 j00 = p0.N();
            if((v1 & 14) == 4 || z1 || j00 == androidx.compose.runtime.k.a) {
                j00 = new J0(context0, 0, z);
                p0.l0(j00);
            }
            r0.q q1 = X0.n.c(q0, false, j00);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            c1.n(null, ((int)(z ? 0x7F080126 : 0x7F080125)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFD);  // drawable:btn_common_check_17_on
            String s = e.Y(p0, (z ? 0x7F1310D9 : 0x7F130914));  // string:unselect_selection "선택해제"
            if(z) {
                p0.a0(0x3941802A);
                v3 = ye.a.v(p0, 0x7F06017C);  // color:green500s_support_high_contrast
            }
            else {
                p0.a0(0x3942F560);
                v3 = ye.a.v(p0, 0x7F060165);  // color:gray800s
            }
            p0.p(false);
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14), v3, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.K0(z, k0, v, 0);
        }
    }

    public static final void y(List list0, int v, we.k k0, l l0, int v1) {
        a0 a02;
        p p0 = (p)l0;
        p0.c0(0x8966B35A);
        int v2 = v1 | (p0.i(list0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            a0 a00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(a00 == v3) {
                a00 = androidx.compose.runtime.w.p(0);
                p0.l0(a00);
            }
            n n0 = n.a;
            a0 a01 = a00;
            r0.q q0 = androidx.compose.foundation.q.f(d.h(d.f(n0, 1.0f), 50.0f), e0.T(p0, 0x7F0604AA), y0.M.a);  // color:white000s_support_high_contrast
            M m0 = M.p.d(r0.d.h, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = d.h(d.f(n0, 1.0f), 50.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            p0.a0(0x279A45A2);
            int v6 = 0;
            for(Object object0: list0) {
                if(v6 >= 0) {
                    LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
                    boolean z = p0.e(v6);
                    P0 p01 = p0.N();
                    if(z || (v2 & 0x380) == 0x100 || p01 == v3) {
                        a02 = a01;
                        p01 = new P0(v6, k0, a02, 0);
                        p0.l0(p01);
                    }
                    else {
                        a02 = a01;
                    }
                    r0.q q4 = androidx.compose.foundation.q.n(layoutWeightElement0, null, p01, 7);
                    y y0 = w.a(j.c, r0.d.m, p0, 0);
                    int v7 = p0.P;
                    i0 i02 = p0.m();
                    r0.q q5 = r0.a.d(p0, q4);
                    k.y.getClass();
                    i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, y0, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i02, P0.j.e);
                    h h4 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v7)) {
                        A7.d.q(v7, p0, v7, h4);
                    }
                    androidx.compose.runtime.w.x(p0, q5, P0.j.d);
                    N1.b(((String)object0), d.u(d.c.then(new LayoutWeightElement(1.0f, true)), 2), e0.T(p0, (((K0)a02).m() == v6 ? 0x7F06017C : 0x7F06016D)), 0.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30000, 0, 0x1FFD8);  // color:green500s_support_high_contrast
                    P4.a.b(d.h(d.f(n0, 1.0f), 2.0f), e0.T(p0, (((K0)a02).m() == v6 ? 0x7F06017A : 0x7F06048A)), 0.0f, 0.0f, p0, 6, 12);  // color:green500e_support_high_contrast
                    p0.p(true);
                    ++v6;
                    a01 = a02;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
            P4.a.b(null, e0.T(p0, 0x7F06014A), 1.0f, 0.0f, p0, 0x180, 9);  // color:gray100a
            p0.p(true);
            Integer integer0 = v;
            Q0 q00 = p0.N();
            if((v2 & 0x70) == 0x20 || q00 == v3) {
                q00 = new Q0(v, a01, null);
                p0.l0(q00);
            }
            J.d(p0, integer0, q00);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new O0(list0, v, k0, v1, 1);
        }
    }

    public static final void z(List list0, int v, we.k k0, l l0, int v1) {
        int v8;
        r0.i i0 = r0.d.e;
        p p0 = (p)l0;
        p0.c0(0x6A53FEE1);
        int v2 = v1 | (p0.i(list0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.f(d.h(d.f(n0, 1.0f), 46.0f), e0.T(p0, 0x7F0604AA), y0.M.a);  // color:white000s_support_high_contrast
            M m0 = M.p.d(r0.d.h, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = d.h(d.f(n0, 1.0f), 46.0f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            p0.a0(0xAF57188B);
            int v5 = 0;
            for(Object object0: list0) {
                if(v5 >= 0) {
                    r0.q q4 = r0.a.a(androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 14.0f, 0.0f, 13.5f, 0.0f, 10), new S0(k0, v5, 0));
                    y y0 = w.a(j.c, r0.d.m, p0, 0);
                    int v6 = p0.P;
                    i0 i02 = p0.m();
                    r0.q q5 = r0.a.d(p0, q4);
                    k.y.getClass();
                    i i2 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i2);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, y0, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i02, P0.j.e);
                    h h4 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v6)) {
                        A7.d.q(v6, p0, v6, h4);
                    }
                    androidx.compose.runtime.w.x(p0, q5, P0.j.d);
                    if(((N0)object0).a == T0.b) {
                        p0.a0(0x47F3147B);
                        r0.q q6 = d.q(z.a(n0, 1.0f), 110.0f);
                        r0.q q7 = H0.b.q(r0.d.n, q6);
                        String s = ((N0)object0).b;
                        N0.i i3 = N0.j.c;
                        int v7 = ((N0)object0).d;
                        if(v7 == -1 || v != v5) {
                            v7 = ((N0)object0).c;
                        }
                        v8 = v5;
                        c1.n(q7, v7, s, i3, false, 0, null, null, i0, 0.0f, null, 0, 0, false, false, p0, 0x6000C00, 0, 0x7EF0);
                    }
                    else {
                        v8 = v5;
                        p0.a0(1207719032);
                        r0.q q8 = d.u(z.a(d.c, 1.0f), 2);
                        N1.b(((N0)object0).b, q8, e0.T(p0, (v == v8 ? 0x7F06017C : 0x7F06016D)), 15.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD0);  // color:green500s_support_high_contrast
                    }
                    p0.p(false);
                    P4.a.b(d.h(d.f(n0, 1.0f), 2.0f), e0.T(p0, (v == v8 ? 0x7F06017A : 0x7F06048A)), 0.0f, 0.0f, p0, 6, 12);  // color:green500e_support_high_contrast
                    p0.p(true);
                    ++v5;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
            P4.a.b(null, e0.T(p0, 0x7F06014A), 0.5f, 0.0f, p0, 0x180, 9);  // color:gray100a
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new O0(list0, v, k0, v1, 0);
        }
    }
}

