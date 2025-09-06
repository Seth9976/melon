package Cc;

import Ac.R0;
import Ac.U2;
import Ac.X2;
import Ac.Y1;
import Ac.Z3;
import C8.j;
import De.I;
import M.c;
import M.j0;
import M.p0;
import M.q0;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import Q0.k0;
import T.e;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
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
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;
import r0.g;
import r0.n;
import wc.u;
import we.a;
import y0.s;

public abstract class w3 {
    public static final void a(a a0, l l0, int v) {
        q.g(a0, "onClick");
        ((p)l0).c0(1870205506);
        int v1 = (((p)l0).i(a0) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            androidx.compose.foundation.q.c(I.Q((ScreenUtils.isDarkMode(((Context)((p)l0).k(AndroidCompositionLocals_androidKt.b))) ? 0x7F0801CB : 0x7F0801C9), ((p)l0), 0), "back", r0.a.a(d.n(n.a, 46.0f), new u3(5, a0)), null, null, 0.0f, null, ((p)l0), 0x30, 120);  // drawable:btn_gnb_back_w
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new j(v, 1, a0);
        }
    }

    public static final void b(a a0, l l0, int v) {
        q.g(a0, "onClick");
        ((p)l0).c0(2116790164);
        int v1 = (((p)l0).i(a0) ? 4 : 2) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            androidx.compose.foundation.q.c(I.Q((ScreenUtils.isDarkMode(((Context)((p)l0).k(AndroidCompositionLocals_androidKt.b))) ? 0x7F0801D6 : 0x7F0801D8), ((p)l0), 0), "more", r0.a.a(d.n(n.a, 46.0f), new u3(6, a0)), null, null, 0.0f, null, ((p)l0), 0x30, 120);  // drawable:btn_gnb_more
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new j(v, 2, a0);
        }
    }

    public static final void c(String s, boolean z, r0.q q0, l l0, int v) {
        r0.q q2;
        q.g(s, "text");
        q.g(q0, "modifier");
        p p0 = (p)l0;
        p0.c0(-509008831);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.g(q0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            r0.q q1 = d5.n.o(d.q(d.c(q0, 1.0f), 85.0f), e.b(100.0f));
            n n0 = n.a;
            if(z) {
                p0.a0(1647739580);
                y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06017C), 1.5f);  // color:green500s_support_high_contrast
                T.d d0 = e.b(100.0f);
                q2 = androidx.compose.foundation.q.j(n0, y0.a, y0.b, d0);
                p0.p(false);
            }
            else {
                p0.a0(1648120849);
                p0.p(false);
                q2 = n0;
            }
            r0.q q3 = q1.then(q2);
            M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q4, P0.j.d);
            N1.b(s, d.q(n0, 85.0f), (z ? A7.d.f(p0, 0x634F0C47, 0x7F06017C, p0, false) : A7.d.f(p0, 0x63509768, 0x7F060160, p0, false)), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC30, 0, 0x1FDF0);  // color:green500s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z2(s, z, q0, v);
        }
    }

    public static final void d(List list0, int v, float f, we.k k0, l l0, int v1) {
        float f1;
        q.g(list0, "orderList");
        p p0 = (p)l0;
        p0.c0(-1096032976);
        int v2 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        int v3 = (v1 & 0xC00) == 0 ? v2 | 0x180 | (p0.i(k0) ? 0x800 : 0x400) : v2 | 0x180;
        if(p0.Q(v3 & 1, (v3 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            M.y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
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
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            a0 a00 = p0.N();
            if(a00 == androidx.compose.runtime.k.a) {
                a00 = w.p(v);
                p0.l0(a00);
            }
            r0.q q2 = d.h(n0, 30.0f);
            y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 1.5f);  // color:gray200a
            T.d d0 = e.b(100.0f);
            r0.q q3 = androidx.compose.foundation.q.j(q2, y1.a, y1.b, d0);
            M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q4, h3);
            p0.a0(1401164878);
            int v6 = list0.size();
            for(int v7 = 0; v7 < v6; ++v7) {
                w3.c(((String)list0.get(v7)), ((K0)a00).m() == v7, r0.a.a(androidx.compose.foundation.layout.a.n(n0, 77.0f * ((float)v7), 0.0f, 0.0f, 0.0f, 14), new X2(v7, k0, a00)), p0, 0);
            }
            A7.d.s(p0, false, true, true);
            f1 = 77.0f;
        }
        else {
            p0.T();
            f1 = f;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new v3(list0, v, f1, k0, v1);
        }
    }

    public static final void e(r0.q q0, String s, long v, float f, long v1, e1.y y0, l l0, int v2, int v3) {
        e1.y y2;
        long v17;
        r0.q q3;
        r0.q q1;
        long v12;
        int v11;
        e1.y y1;
        int v8;
        long v7;
        int v4;
        q.g(s, "text");
        ((p)l0).c0(-1302110107);
        if((v3 & 1) == 0) {
            v4 = (v2 & 6) == 0 ? v2 | (((p)l0).g(q0) ? 4 : 2) : v2;
        }
        else {
            v4 = v2 | 6;
        }
        int v5 = ((p)l0).g(s) ? 0x20 : 16;
        int v6 = ((p)l0).f(v) ? 0x100 : 0x80;
        if((v3 & 16) == 0) {
            v7 = v1;
            v8 = ((p)l0).f(v7) ? 0x4000 : 0x2000;
        }
        else {
            v7 = v1;
            v8 = 0x2000;
        }
        int v9 = v4 | v5 | v6 | v8 | 0x30000;
        int v10 = 0;
        if(((p)l0).Q(v9 & 1, (74899 & v9) != 74898)) {
            ((p)l0).V();
            if((v2 & 1) == 0 || ((p)l0).B()) {
                r0.q q2 = (v3 & 1) == 0 ? q0 : n.a;
                if((v3 & 16) != 0) {
                    v7 = e0.T(((p)l0), 0x7F06017C);  // color:green500s_support_high_contrast
                    v9 &= 0xFFFF1FFF;
                }
                q1 = q2;
                v11 = v9;
                y1 = e1.y.i;
                v12 = v7;
            }
            else {
                ((p)l0).T();
                if((v3 & 16) != 0) {
                    v9 &= 0xFFFF1FFF;
                }
                y1 = y0;
                v11 = v9;
                v12 = v7;
                q1 = q0;
            }
            ((p)l0).q();
            Matcher matcher0 = Pattern.compile("<b>(.*?)</b>").matcher(s);
            a1.d d0 = new a1.d();
            while(matcher0.find()) {
                int v13 = matcher0.start();
                int v14 = matcher0.end();
                if(v10 != v13) {
                    String s1 = s.substring(v10, v13);
                    q.f(s1, "substring(...)");
                    d0.d(s1);
                }
                String s2 = matcher0.group(1);
                int v15 = d0.g(new a1.M(v12, 0L, y1, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFA));
                try {
                    q.d(s2);
                    d0.d(s2);
                }
                finally {
                    d0.f(v15);
                }
                v10 = v14;
            }
            if(v10 < s.length()) {
                String s3 = s.substring(v10);
                q.f(s3, "substring(...)");
                d0.d(s3);
            }
            N1.a(d0.h(), q1, v, f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, null, ((p)l0), v11 & 0x380 | v11 << 3 & 0x70 | 0xC00, 0, 0x3FFF0);
            q3 = q1;
            v17 = v12;
            y2 = y1;
        }
        else {
            ((p)l0).T();
            q3 = q0;
            v17 = v7;
            y2 = y0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new x3(q3, s, v, f, v17, y2, v2, v3);
        }
    }

    public static final void f(String s, String s1, String s2, String s3, String s4, int v, we.k k0, l l0, int v1) {
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(0x199AAC8F);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(s3) ? 0x800 : 0x400) | (p0.g(s4) ? 0x4000 : 0x2000) | (p0.e(v) ? 0x20000 : 0x10000) | (p0.i(k0) ? 0x100000 : 0x80000);
        if(p0.Q(v2 & 1, (v2 & 0x92493) != 0x92492)) {
            n n0 = n.a;
            r0.q q0 = r0.a.a(d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f), new C3(v, 0, s, s3, k0));
            M.d d0 = M.j.c;
            g g0 = r0.d.m;
            M.y y0 = M.w.a(d0, g0, p0, 0);
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
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = d.h(d.f(n0, 1.0f), 110.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
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
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            r0.q q4 = d.h(d.v(n0, null, 3), 110.0f);
            M m0 = M.p.d(r0.d.a, false);
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
            w.x(p0, m0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            r0.q q6 = d.h(d.q(n0, 78.0f), 110.0f);
            r0.b.c(q6, s1, 78.0f, null, 0L, null, false, false, p0, v2 & 0x70 | 0x6000186, 0xF8);
            r0.q q7 = r0.a.a(d.n(androidx.compose.foundation.layout.a.n(n0, 50.0f, 4.0f, 0.0f, 0.0f, 12), 24.0f), new C3(v, 1, s, s3, k0));
            androidx.compose.foundation.q.c(I.Q(0x7F08015E, p0, 6), H0.e.Y(p0, 0x7F130BB6), q7, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);  // drawable:btn_common_play_01
            r0.q q8 = d.h(d.q(androidx.compose.foundation.layout.a.n(n0, 7.0f, 6.0f, 0.0f, 0.0f, 12), 55.0f), 12.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F08067F, p0, 6), null, q8, null, N0.j.g, 0.0f, null, p0, 25008, 104);  // drawable:img_station_logo_02
            p0.p(true);
            r0.q q9 = d.f(androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 0.0f, 0.0f, 14), 1.0f);
            M.y y1 = M.w.a(d0, g0, p0, 0);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q10 = r0.a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q10, h3);
            if(s2.length() > 0) {
                p0.a0(0xDDDB0A9A);
                N1.b(s2, null, e0.T(p0, 0x7F06016D), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:gray900s
            }
            else {
                p0.a0(-576209629);
            }
            p0.p(false);
            N1.b(s3, androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, v2 >> 9 & 14 | 0xC30, 0xC36, 0x1D3F0);  // color:gray900s
            N1.b(s4, androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 12 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
            c.d(p0, d.h(d.f(n0, 1.0f), 11.0f));
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.n0(s, s1, s2, s3, s4, v, k0, v1);
        }
    }

    public static final void g(String s, r0.q q0, Drawable drawable0, we.k k0, l l0, int v, int v1) {
        we.k k4;
        we.k k3;
        int v6;
        V v5;
        b0 b01;
        T.d d1;
        we.k k2;
        we.k k1;
        p p0 = (p)l0;
        p0.c0(0x7FA0F131);
        int v2 = (p0.g(s) ? 4 : 2) | v | (p0.g(q0) ? 0x20 : 16) | (p0.i(drawable0) ? 0x100 : 0x80);
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            V v3 = androidx.compose.runtime.k.a;
            if((v1 & 8) == 0) {
                k1 = k0;
            }
            else {
                K1 k10 = p0.N();
                if(k10 == v3) {
                    k10 = new K1(5);
                    p0.l0(k10);
                }
                k1 = k10;
            }
            FillElement fillElement0 = d.c;
            r0.q q1 = q0.then(fillElement0);
            T.d d0 = e.a;
            r0.q q2 = androidx.compose.foundation.q.f(d5.n.o(q1, d0), e0.T(p0, 0x7F060145), y0.M.a);  // color:gray050s
            M m0 = M.p.d(r0.d.a, false);
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, P0.j.d);
            b0 b00 = p0.N();
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            if(((Boolean)b00.getValue()).booleanValue()) {
                k2 = k1;
                b01 = b00;
                v6 = v2;
                v5 = v3;
                d1 = d0;
                p0.a0(0xA60BB2B7);
            }
            else {
                p0.a0(0xA620DFD7);
                Integer integer0 = drawable0 == null ? 0x7F080788 : drawable0;  // drawable:noimage_logo_medium
                k2 = k1;
                d1 = d0;
                b01 = b00;
                v5 = v3;
                v6 = v2;
                c1.n(fillElement0, integer0, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C06, 0, 0x7FE4);
            }
            p0.p(false);
            if(s != null && s.length() != 0) {
                p0.a0(0xA6260595);
                y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
                r0.q q4 = androidx.compose.foundation.q.j(fillElement0, y0.a, y0.b, d1);
                N0.i i1 = N0.j.b;
                Z3 z30 = p0.N();
                if((v6 & 0x1C00) == 0x800 || z30 == v5) {
                    k3 = k2;
                    z30 = new Z3(k3, b01, 1);
                    p0.l0(z30);
                }
                else {
                    k3 = k2;
                }
                k2 = k3;
                c1.n(q4, s, null, i1, false, 0, z30, null, null, 0.0f, null, 0, 0, false, false, p0, v6 << 3 & 0x70 | 0x6C00, 0x6000, 0x3FA4);
            }
            else {
                p0.a0(0xA60BB2B7);
            }
            p0.p(false);
            p0.p(true);
            k4 = k2;
        }
        else {
            p0.T();
            k4 = k0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(s, q0, drawable0, k4, v, v1, 0);
        }
    }

    public static final void h(String s, r0.q q0, Drawable drawable0, l l0, int v, int v1) {
        Drawable drawable2;
        b0 b01;
        V v6;
        int v5;
        FillElement fillElement1;
        p p0 = (p)l0;
        p0.c0(-1199642180);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.i(drawable0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Drawable drawable1 = (v1 & 4) == 0 ? drawable0 : null;
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            FillElement fillElement0 = d.c;
            r0.q q1 = q0.then(fillElement0);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q2, P0.j.d);
            if(((Boolean)b00.getValue()).booleanValue()) {
                v5 = v2;
                b01 = b00;
                v6 = v3;
                fillElement1 = fillElement0;
                p0.a0(-2050090324);
            }
            else {
                p0.a0(0x85DEF617);
                Integer integer0 = drawable1 == null ? 0x7F080788 : drawable1;  // drawable:noimage_logo_medium
                fillElement1 = fillElement0;
                v5 = v2;
                v6 = v3;
                b01 = b00;
                c1.n(androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F060145), e.b(4.0f)), integer0, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C00, 0, 0x7FE4);  // color:gray050s
            }
            p0.p(false);
            if(s == null || s.length() == 0) {
                p0.a0(-2050090324);
            }
            else {
                p0.a0(-2048484245);
                N0.i i1 = N0.j.b;
                R0 r00 = p0.N();
                if(r00 == v6) {
                    r00 = new R0(b01, 7);
                    p0.l0(r00);
                }
                c1.n(fillElement1, s, null, i1, false, 0, r00, null, null, 0.0f, null, 0, 0, false, false, p0, v5 << 3 & 0x70 | 1600518, 0, 0x7FA4);
            }
            p0.p(false);
            p0.p(true);
            drawable2 = drawable1;
        }
        else {
            p0.T();
            drawable2 = drawable0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(s, q0, drawable2, v, v1, 0);
        }
    }

    public static final void i(int v, l l0, String s, r0.q q0) {
        p p0 = (p)l0;
        p0.c0(0x854101C);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(q0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            FillElement fillElement0 = d.c;
            r0.q q1 = e0.K(q0.then(fillElement0));
            M m0 = M.p.d(r0.d.a, false);
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            if(s == null) {
                p0.a0(-1855550930);
                c1.n(androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F060145), e.b(4.0f)), 0x7F080788, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C30, 0, 0x7FE4);  // color:gray050s
            }
            else {
                p0.a0(0x9162F941);
                c1.n(fillElement0, s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70 | 0x6C06, 0, 0x7FE4);
            }
            p0.p(false);
            r0.q q3 = androidx.compose.foundation.q.e(d.f(d.h(n.a, 40.0f), 1.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06013D)), new s(e0.T(p0, 0x7F06015F))}), 0.0f, 0.0f, 14), e.d(4.0f, 4.0f, 0.0f, 0.0f, 12), 4);  // color:gray000e
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.h), p0, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new w0(s, q0, v, 2);
        }
    }

    public static final void j(r0.q q0, m0.b b0, String s, m0.b b1, l l0, int v) {
        r0.q q4;
        n n1;
        r0.q q3;
        p p0 = (p)l0;
        p0.c0(0x467D24F2);
        int v1 = v | 6 | (p0.g(s) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q1 = d.f(d.h(n0, f0.a), 1.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
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
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            b0.invoke(p0, 6);
            c.d(p0, d.q(n0, 20.0f));
            if(s == null) {
                q3 = q1;
                n1 = n0;
                p0.a0(0x23AC372C);
            }
            else {
                p0.a0(0x23CF03AD);
                q3 = q1;
                n1 = n0;
                N1.b(s, new LayoutWeightElement(1.0f, true), 0L, 18.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 6 & 14 | 0xC00, 0, 0x1FFF4);
            }
            p0.p(false);
            c.d(p0, d.q(n1, 20.0f));
            b1.invoke(p0, 6);
            p0.p(true);
            q4 = q3;
        }
        else {
            p0.T();
            q4 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(q4, b0, s, b1, v, 5);
        }
    }

    public static final void k(r0.q q0, j0 j00, List list0, int v, we.k k0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0x977F26);
        int v2 = ((v1 & 6) == 0 ? v1 | (p0.g(q0) ? 4 : 2) : v1) | (p0.e(v) ? 0x800 : 0x400) | (p0.i(k0) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            R3 r30 = (R3)list0.get(v);
            int v3 = r30.e;
            Integer integer0 = r30.d;
            r0.q q1 = d5.n.o(q0, r30.a);
            p0.a0(-572608404);
            p0.p(false);
            n n0 = n.a;
            r0.q q2 = q1.then(n0);
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, r30.c), r30.b);
            r0.q q3 = androidx.compose.foundation.layout.a.i(r0.a.a(androidx.compose.foundation.q.j(q2, y0.a, y0.b, r30.a), new X2(k0, list0, v, 2)), j00);
            M m0 = M.p.d(r0.d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
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
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q4, h3);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            if(integer0 == null) {
                p0.a0(1000530);
            }
            else {
                p0.a0(0x62F60B);
                C0.c c0 = I.Q(((int)integer0), p0, 0);
                y0.k k1 = new y0.k(e0.T(p0, v3), 5);
                androidx.compose.foundation.q.c(c0, null, d.n(n0, 18.0f), null, N0.j.d, 0.0f, k1, p0, 25008, 40);
            }
            p0.p(false);
            String s = ((Context)p0.k(AndroidCompositionLocals_androidKt.b)).getString(r30.f);
            q.f(s, "getString(...)");
            N1.b(s, null, e0.T(p0, v3), r30.g, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF2);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(q0, j00, list0, v, k0, v1);
        }
    }

    public static final void l(r0.q q0, String s, String s1, String s2, boolean z, String s3, String s4, boolean z1, boolean z2, String s5, String s6, we.k k0, l l0, int v, int v1, int v2) {
        we.k k3;
        n n3;
        n n2;
        h h9;
        M.b b1;
        we.k k2;
        n n1;
        h h8;
        r0.h h7;
        h h6;
        we.k k1;
        int v6;
        p p0 = (p)l0;
        p0.c0(-1704075669);
        int v3 = v | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.g(s2) ? 0x800 : 0x400) | (p0.h(z) ? 0x4000 : 0x2000) | (p0.g(s3) ? 0x20000 : 0x10000);
        if((v & 0x180000) == 0) {
            v3 |= (p0.g(s4) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v3 |= (p0.h(z1) ? 0x800000 : 0x400000);
        }
        int v4 = v3 | (p0.g(s5) ? 0x20000000 : 0x10000000);
        int v5 = (v1 & 6) == 0 ? v1 | (p0.g(s6) ? 4 : 2) : v1;
        if((v2 & 0x800) == 0) {
            k1 = k0;
            v6 = v5 | (p0.i(k1) ? 0x20 : 16);
        }
        else {
            v6 = v5 | 0x30;
            k1 = k0;
        }
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (v6 & 19) != 18)) {
            if((v2 & 0x800) != 0) {
                k1 = null;
            }
            r0.h h0 = r0.d.k;
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v7 = p0.P;
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
            w.x(p0, p00, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h3);
            }
            h h4 = P0.j.d;
            w.x(p0, q1, h4);
            e0.F(s, p0, v4 >> 3 & 14);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n.a, 14.0f, 0.0f, 0.0f, 0.0f, 14);
            n n0 = n.a;
            r0.q q3 = d.f(q2.then(new VerticalAlignElement(h0)), 1.0f);
            r0.h h5 = r0.d.j;
            p0 p01 = M.n0.a(M.j.g, h5, p0, 6);
            int v8 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h3);
            }
            w.x(p0, q4, h4);
            r0.q q5 = q0.a(new VerticalAlignElement(h0), 1.0f);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v9 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i02, h2);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h3);
            }
            w.x(p0, q6, h4);
            p0 p02 = M.n0.a(b0, h5, p0, 0);
            int v10 = p0.P;
            i0 i03 = p0.m();
            r0.q q7 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p02, h1);
            w.x(p0, i03, h2);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h3);
            }
            w.x(p0, q7, h4);
            int v11 = ResourceUtils.getDjIconColorId(s1);
            if(v11 > -1) {
                p0.a0(0x96B6356B);
                h6 = h3;
                h7 = h0;
                h8 = h4;
                n1 = n0;
                k2 = k1;
                b1 = b0;
                h9 = h2;
                N1.b("DJ", H0.b.r(h0, androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 4.0f, 0.0f, 11)), e0.T(p0, v11), 15.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C06, 0, 0x1FFD0);
            }
            else {
                h8 = h4;
                h9 = h2;
                h7 = h0;
                b1 = b0;
                k2 = k1;
                n1 = n0;
                h6 = h3;
                p0.a0(0x968F8B75);
            }
            p0.p(false);
            a0 a00 = p0.N();
            V v12 = androidx.compose.runtime.k.a;
            if(a00 == v12) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            r0.q q8 = d.f(n1, 1.0f);
            X3 x30 = p0.N();
            if(x30 == v12) {
                x30 = new X3(a00, 0);
                p0.l0(x30);
            }
            r0.q q9 = androidx.compose.ui.layout.a.d(q8, x30);
            p0 p03 = M.n0.a(b1, h5, p0, 0);
            int v13 = p0.P;
            i0 i04 = p0.m();
            r0.q q10 = r0.a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p03, h1);
            w.x(p0, i04, h9);
            if(p0.O || !q.b(p0.N(), v13)) {
                A7.d.q(v13, p0, v13, h6);
            }
            w.x(p0, q10, h8);
            N1.b((s2 == null ? "" : s2), androidx.compose.foundation.layout.a.n(H0.b.r(h7, d.s(n1, 0.0f, ((r1.c)p0.k(k0.h)).R(((K0)a00).m()) - 20.0f, 1)), 0.0f, 0.0f, 4.0f, 0.0f, 11), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            if(z) {
                p0.a0(0x7FBD3104);
                c1.n(H0.b.r(h7, d.n(androidx.compose.foundation.layout.a.n(n1, 0.0f, 0.0f, 2.0f, 0.0f, 11), 14.0f)), 0x7F08041C, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:ic_common_verify_14
            }
            else {
                p0.a0(0x7F806D31);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            if(s3 != null && s3.length() != 0) {
                p0.a0(0xDAB9E5F9);
                n2 = n1;
                N1.b(s3, androidx.compose.foundation.layout.a.n(d.v(n1, null, 3), 0.0f, 4.0f, 4.0f, 0.0f, 9), e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v4 >> 15 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            }
            else {
                n2 = n1;
                p0.a0(0xDA755BF9);
            }
            p0.p(false);
            if(s4 != null && s4.length() != 0) {
                p0.a0(0xDAC2FD84);
                N1.b(s4, androidx.compose.foundation.layout.a.n(d.v(n2, null, 3), 0.0f, 4.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F060159), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v4 >> 18 & 14 | 0xC30, 0xC30, 0x1D7F0);  // color:gray400s_support_high_contrast
                p0.p(false);
                n3 = n2;
            }
            else {
                n3 = n2;
                p0.a0(0xDA755BF9);
                p0.p(false);
            }
            p0.p(true);
            if(!z2 || q.b(s5, s6)) {
                k3 = k2;
                p0.a0(0xFF21E80F);
            }
            else {
                p0.a0(0xFF785A10);
                r0.q q11 = H0.b.r(h7, d.h(n3, 28.0f));
                j0 j00 = androidx.compose.foundation.layout.a.c(10.0f, 0.0f, 14.0f, 0.0f, 10);
                List list0 = e.k.A(new R3[]{N3.h, P3.h});
                Y1 y10 = p0.N();
                if((v6 & 0x70) == 0x20 || y10 == v12) {
                    k3 = k2;
                    y10 = new Y1(5, k3);
                    p0.l0(y10);
                }
                else {
                    k3 = k2;
                }
                w3.k(q11, j00, list0, ((int)z1), y10, p0, 0x1B0);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            k1 = k3;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y3(q0, s, s1, s2, z, s3, s4, z1, z2, s5, s6, k1, v, v1, v2);
        }
    }
}

