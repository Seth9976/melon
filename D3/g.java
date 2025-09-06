package d3;

import Ac.R0;
import Ac.U0;
import Ac.Y1;
import Ac.g1;
import Ac.h1;
import Ac.i1;
import Cc.G2;
import Cc.H3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.e1;
import Cc.r0;
import Dd.k2;
import G.C;
import M.c;
import M.j0;
import M.p0;
import M.q0;
import M.y;
import N0.M;
import N0.g0;
import O.F;
import O.I;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.k0;
import Qb.b;
import T.e;
import Tf.v;
import Vc.N;
import a1.U;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.E0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.foundation.layout.a;
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
import androidx.fragment.app.l0;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.SchemeAllowedUrlManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.P0;
import com.melon.ui.playermusic.PlayerViewCalculator;
import d5.s;
import ed.D;
import ed.t;
import f1.x;
import gd.D1;
import gd.F5;
import gd.M6;
import gd.T7;
import gd.t5;
import gd.u5;
import gd.v1;
import gd.x1;
import gd.z1;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jd.b2;
import k8.Y;
import m8.S;
import m8.X;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import r0.n;
import r0.q;
import rd.f;
import td.m0;
import td.m;
import td.u;
import va.o;
import vd.r;
import y0.T;

public abstract class g {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static final void A(String s, String s1, boolean z, l l0, int v, int v1) {
        boolean z1;
        p p0 = (p)l0;
        p0.c0(0xA86A24D6);
        int v2 = ((v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v) | (p0.g(s1) ? 0x20 : 16);
        if((v1 & 4) != 0) {
            v2 |= 0x180;
            z1 = z;
        }
        else if((v & 0x180) == 0) {
            z1 = z;
            v2 |= (p0.h(z1) ? 0x100 : 0x80);
        }
        else {
            z1 = z;
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if((v1 & 4) != 0) {
                z1 = false;
            }
            n n0 = n.a;
            q q0 = d.f(a.n(n0, 20.0f, 22.0f, 20.0f, 0.0f, 8), 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
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
            yd.h.c(s, p0, v2 & 14);
            c.d(p0, d.h(n0, 12.0f));
            yd.h.a(s1, z1, 0.0f, p0, v2 >> 3 & 0x7E, 12);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b2(s, s1, v, z1, v1);
        }
    }

    public static final void B(String s, String s1, we.k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-906760860);
        int v1 = ((v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v) | (p0.g(s1) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q0 = d.f(a.n(n0, 20.0f, 22.0f, 20.0f, 0.0f, 8), 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
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
            yd.h.c(s, p0, v1 & 14);
            c.d(p0, d.h(n0, 12.0f));
            g.b(s1, k0, p0, v1 >> 3 & 0x7E);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new vd.n(v, 0, s, s1, k0);
        }
    }

    public static final void C(String s, String s1, String s2, String s3, int v, we.k k0, l l0, int v1) {
        n n1;
        p p0 = (p)l0;
        p0.c0(0x891C767A);
        int v2 = ((v1 & 6) == 0 ? v1 | (p0.g(s) ? 4 : 2) : v1) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(s3) ? 0x800 : 0x400) | (p0.e(v) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            n n0 = n.a;
            q q0 = d.f(a.m(n0, 20.0f, 22.0f, 20.0f, 20.0f), 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
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
            yd.h.c(s, p0, v2 & 14);
            c.d(p0, d.h(n0, 12.0f));
            if(s1 != null && s1.length() != 0) {
                p0.a0(0x53588FF5);
                n1 = n0;
                N1.b(s1, null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, new l1.k(3), 20.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 6, 0x1F9F2);  // color:gray800s
                A7.d.v(n1, 20.0f, p0, false);
            }
            else {
                n1 = n0;
                p0.a0(0x519F3D8C);
                p0.p(false);
            }
            d5.l l1 = x.d;
            b b0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if((v2 & 0x380) == 0x100 || b0 == v5) {
                b0 = new b(s2, 4);
                p0.l0(b0);
            }
            b0 b00 = d5.w.O(new Object[0], l1, b0, p0);
            w0.p p1 = p0.N();
            if(p1 == v5) {
                p1 = new w0.p();
                p0.l0(p1);
            }
            r r0 = p0.N();
            if(r0 == v5) {
                r0 = new r(p1, null);
                p0.l0(r0);
            }
            J.d(p0, H.a, r0);
            x x0 = (x)b00.getValue();
            T t0 = new T(e0.T(p0, 0x7F06017C));  // color:green500s_support_high_contrast
            long v6 = e0.N(14.0f, p0);
            U u0 = new U(e0.T(p0, 0x7F06016D), v6, null, null, 0L, null, 0, e0.N(18.5f, p0), 0xFDFFFC);  // color:gray900s
            U.e0 e00 = new U.e0(7, 0x77);
            q q3 = androidx.compose.ui.focus.a.a(d.f(d.h(n1, 113.0f), 1.0f), p1);
            boolean z = p0.g(b00);
            Ec.j j0 = p0.N();
            if(z || (0xE000 & v2) == 0x4000 || j0 == v5) {
                j0 = new Ec.j(v, b00, k0);
                p0.l0(j0);
            }
            c1.h(x0, j0, q3, false, u0, e00, null, false, 5, 0, null, null, t0, m0.c.e(0x63CECAEB, p0, new vd.j(b00, s3, v)), p0, 0x180000, 0x180006, 31640);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t(s, s1, s2, s3, v, k0, v1);
        }
    }

    public static final void D(String s, String s1, int v, we.k k0, l l0, int v1) {
        n n1;
        p p0 = (p)l0;
        p0.c0(0xB8E69767);
        int v2 = ((v1 & 6) == 0 ? v1 | (p0.g(s) ? 4 : 2) : v1) | (p0.g(s1) ? 0x20 : 16) | (p0.e(v) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            q q0 = a.n(n.a, 20.0f, 22.0f, 20.0f, 0.0f, 8);
            n n0 = n.a;
            q q1 = d.f(q0, 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, n0);
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
            w.x(p0, q3, h3);
            yd.h.c(s, p0, v2 & 14);
            g.w(v, k0, p0, v2 >> 6 & 0x7E);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            if(s1 == null) {
                n1 = n0;
                p0.a0(0x81E9801F);
            }
            else {
                p0.a0(-2091320961);
                kotlin.jvm.internal.q.f("%s명이 참여하였습니다.", "getString(...)");
                String s2 = String.format("%s명이 참여하였습니다.", Arrays.copyOf(new Object[]{Cb.k.a(context0, s1)}, 1));
                c.d(p0, d.h(n0, 12.0f));
                n1 = n0;
                N1.b(s2, null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // color:gray800s
            }
            p0.p(false);
            c.d(p0, d.h(n1, 26.0f));
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(s, s1, v, k0, v1, 20);
        }
    }

    public static final void E(String s, we.a a0, boolean z, long v, we.n n0, String s1, String s2, we.a a1, boolean z1, we.a a2, we.a a3, l l0, int v1) {
        h h5;
        u u0;
        Boolean boolean1;
        V v6;
        p p0 = (p)l0;
        p0.c0(0x743DAEDF);
        int v2 = v1 | (p0.g(s) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.f(v) ? 0x800 : 0x400) | (p0.i(n0) ? 0x4000 : 0x2000) | (p0.g(s1) ? 0x20000 : 0x10000) | (p0.g(s2) ? 0x100000 : 0x80000) | (p0.i(a1) ? 0x800000 : 0x400000) | (p0.h(z1) ? 0x4000000 : 0x2000000) | (p0.i(a2) ? 0x20000000 : 0x10000000);
        int v3 = p0.i(a3) ? 4 : 2;
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v3 & 3) != 2)) {
            n n1 = n.a;
            q q0 = d.h(d.f(n1, 1.0f), E9.h.t(p0, 0x7F070417));  // dimen:player_top_info_container_height
            M.b b0 = M.j.a;
            r0.h h0 = r0.d.j;
            p0 p00 = M.n0.a(b0, h0, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            h h3 = j.f;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h4 = j.d;
            w.x(p0, q1, h4);
            c.d(p0, d.q(n1, 24.0f));
            b0 b00 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(b00 == v5) {
                b00 = w.s(Boolean.valueOf(z));
                p0.l0(b00);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            Object object0 = p0.N();
            if((((v2 & 0x1C00) == 0x800 ? 1 : 0) | ((v2 & 0x380) == 0x100 ? 1 : 0)) != 0 || object0 == v5) {
                h5 = h3;
                v6 = v5;
                boolean1 = boolean0;
                u0 = new u(z, v, b00, null);
                p0.l0(u0);
            }
            else {
                v6 = v5;
                boolean1 = boolean0;
                u0 = object0;
                h5 = h3;
            }
            J.d(p0, boolean1, u0);
            q q2 = H0.b.r(h0, d.u(n1, 3));
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v7 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h5);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q3, h4);
            c.d(p0, d.h(n1, 9.0f));
            q q4 = d.u(n1, 3);
            f f0 = p0.N();
            if((v2 & 0xE000) == 0x4000 || f0 == v6) {
                f0 = new f(n0, 1);
                p0.l0(f0);
            }
            q q5 = androidx.compose.ui.layout.a.d(q4, f0);
            p0 p01 = M.n0.a(b0, h0, p0, 0);
            int v8 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h5);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            w.x(p0, q6, h4);
            if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(0xF033D154);
                e1.x.r(r0.a.a(n1, new D(27, a0)), s, p0, 0, v2 << 3 & 0x70);
                U4.x.z(n1, 10.0f, p0, false);
            }
            else {
                p0.a0(0xEF1A6EE5);
                p0.p(false);
            }
            p0.p(true);
            p0.p(true);
            q q7 = H0.b.r(h0, q0.a(n1, 1.0f));
            sd.j j0 = p0.N();
            if(j0 == v6) {
                j0 = new sd.j(2);
                p0.l0(j0);
            }
            e1.x.s(X0.n.c(q7, false, j0), s1, s2, a1, p0, v2 >> 12 & 0x1FF0);
            c.d(p0, d.q(n1, 8.0f));
            e1.x.t(new VerticalAlignElement(r0.d.k), z1, a2, a3, p0, v2 >> 21 & 0x3F0 | v3 << 9 & 0x1C00);
            U4.x.z(n1, 10.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new m(s, a0, z, v, n0, s1, s2, a1, z1, a2, a3, v1);
        }
    }

    public static void F(SpannableStringBuilder spannableStringBuilder0, Object object0, int v, int v1) {
        Object[] arr_object = spannableStringBuilder0.getSpans(v, v1, object0.getClass());
        for(int v2 = 0; v2 < arr_object.length; ++v2) {
            Object object1 = arr_object[v2];
            if(spannableStringBuilder0.getSpanStart(object1) == v && spannableStringBuilder0.getSpanEnd(object1) == v1 && spannableStringBuilder0.getSpanFlags(object1) == 33) {
                spannableStringBuilder0.removeSpan(object1);
            }
        }
        spannableStringBuilder0.setSpan(object0, v, v1, 33);
    }

    public static q G(q q0, float f) {
        return androidx.compose.ui.graphics.a.a(q0, new v0.a(f, f, 0, true));
    }

    public static void H(Activity activity0, Uri uri0) {
        if(activity0 != null) {
            String s = uri0.getAuthority();
            if(s != null) {
                int v = 1;
                l0 l00 = null;
                switch(s) {
                    case "apphome": {
                        m8.a a0 = new m8.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                        Navigator.openMainMusic$default(Navigator.INSTANCE, true, false, 2, null);
                        String s3 = uri0.getQueryParameter("targeturl");
                        if(s3 == null) {
                            s3 = "";
                        }
                        boolean z = kotlin.jvm.internal.q.b(uri0.getQueryParameter("javascriptMethod"), "Y");
                        if(!TextUtils.isEmpty(s3)) {
                            if(!z) {
                                SchemeAllowedUrlManager schemeAllowedUrlManager0 = SchemeAllowedUrlManager.getInstance();
                                schemeAllowedUrlManager0.updateAllowedUrl(new H7.c(schemeAllowedUrlManager0, s3, activity0, a0));
                                return;
                            }
                            m8.a.r1(s3);
                            return;
                        }
                        break;
                    }
                    case "back": {
                        String s4 = uri0.getQueryParameter("count");
                        String s5 = uri0.getQueryParameter("landingUri");
                        if(s4 != null) {
                            try {
                                v = Integer.parseInt(s4);
                            }
                            catch(NumberFormatException unused_ex) {
                            }
                        }
                        Y.t("BACK:", v, LogU.Companion, "Home.kt");
                        if(activity0 instanceof BaseActivity) {
                            ((BaseActivity)activity0).navigateBack(v);
                            if(!TextUtils.isEmpty(s5)) {
                                m8.g g0 = new m8.g(((BaseActivity)activity0));
                                Uri uri1 = Uri.parse(s5);
                                kotlin.jvm.internal.q.f(uri1, "parse(...)");
                                g0.c(uri1);
                                return;
                            }
                        }
                        break;
                    }
                    case "exit": {
                        Navigator.openMainMusic$default(Navigator.INSTANCE, true, false, 2, null);
                        String s1 = uri0.getQueryParameter("message");
                        if(!TextUtils.isEmpty(s1)) {
                            kotlin.jvm.internal.q.f("안내", "getString(...)");
                            AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
                            if(appCompatActivity0 != null) {
                                l00 = appCompatActivity0.getSupportFragmentManager();
                            }
                            P0 p00 = new P0(activity0, 1);
                            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, "안내", s1, false, false, false, null, null, null, p00, null, 0x5F8);
                            return;
                        }
                        activity0.finish();
                        return;
                    }
                    case "home": {
                        String s2 = uri0.getPath();
                        if(s2 != null && s2.hashCode() == 606485877 && s2.equals("/shortcut")) {
                            g.a0("5", "M01", "E1");
                        }
                        Navigator.openMainMusic$default(Navigator.INSTANCE, true, false, 2, null);
                    }
                }
            }
        }
    }

    public static void I(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "": {
                    S s1 = new S(1);
                    s1.i1(uri0);
                    if(((va.e0)o.a()).m()) {
                        Navigator.INSTANCE.openMusicDna();
                        return;
                    }
                    Navigator.openLoginView(s1.c1());
                    return;
                }
                case "/monthlylog": {
                    String s2 = u0.y(uri0, "logMonth");
                    if(s2 != null) {
                        X x0 = new X(1);  // 初始化器: Lm8/S;-><init>(I)V
                        x0.i1(uri0);
                        if(((va.e0)o.a()).m()) {
                            Navigator.INSTANCE.openMusicDnaMonthlyLog(s2, true);
                            return;
                        }
                        Navigator.openLoginView(x0.c1());
                    }
                    break;
                }
            }
        }
    }

    public static qf.b J(String s, boolean z) [...] // Inlined contents

    public static s K(String s, String s1, String s2) {
        s s3 = new s();
        s3.b = "3";
        s3.c = s;
        s3.e = s1;
        s3.h = s2;
        return s3;
    }

    public abstract void L(z6.x arg1, float arg2, float arg3);

    // 去混淆评级： 低(20)
    public static final boolean M(String s) {
        return g.O(s) || kotlin.jvm.internal.q.b(s, "DJ");
    }

    public static final boolean N(fc.a a0) {
        kotlin.jvm.internal.q.g(a0, "<this>");
        if(a0.a != 4) {
            return false;
        }
        return a0.e == 0x8000000000000001L ? false : a0.e > 0L;
    }

    // 去混淆评级： 低(40)
    public static final boolean O(String s) {
        return kotlin.jvm.internal.q.b(s, "LABEL") || kotlin.jvm.internal.q.b(s, "PARTNER") || kotlin.jvm.internal.q.b(s, "POWER") || kotlin.jvm.internal.q.b(s, "ESSENTIAL");
    }

    public static ie.j P(ie.k k0, we.a a0) [...] // Inlined contents

    public static ie.r Q(we.a a0) {
        kotlin.jvm.internal.q.g(a0, "initializer");
        return new ie.r(a0);
    }

    public static void R(Gf.l l0, kg.k k0) {
        String s = k0.a;
        URL uRL0 = jg.c.b(k0.o.f(), s);
        String s1 = ((mg.d)l0.e(uRL0).c).a();
        kotlin.jvm.internal.q.d(s1);
        if(s1.length() == 0) {
            throw new IOException("download error: " + uRL0);
        }
        k0.b = s1;
        Element element0 = d8.d.A(s1).getDocumentElement();
        kotlin.jvm.internal.q.f(element0, "doc.documentElement");
        Element element1 = de.c.t(element0, "device");
        if(element1 == null) {
            throw new IOException();
        }
        g.V(k0, element1);
        g.S(l0, k0);
    }

    public static void S(Gf.l l0, kg.k k0) {
        String s17;
        String s16;
        String s15;
        Iterator iterator3;
        Iterator iterator6;
        Iterator iterator1;
        String s2;
        Iterator iterator0 = k0.k.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            kg.n n0 = (kg.n)object0;
            kotlin.jvm.internal.q.g(n0, "builder");
            String s = n0.c;
            if(s == null) {
                throw new IOException("scpdUrl is null");
            }
            String s1 = k0.i == null ? k0.a : k0.i;
            URL uRL0 = jg.c.a(k0.o.f(), s1, s);
            try {
                s2 = ((mg.d)l0.e(uRL0).c).a();
                kotlin.jvm.internal.q.d(s2);
            }
            catch(IOException iOException0) {
                if(!je.p.d0(ng.a.a, k0.d)) {
                    throw iOException0;
                }
                s2 = "";
            }
            if(s2.length() == 0) {
                iterator1 = iterator0;
            }
            else {
                n0.f = s2;
                Document document0 = d8.d.A(s2);
                NodeList nodeList0 = document0.getElementsByTagName("action");
                kotlin.jvm.internal.q.f(nodeList0, "doc.getElementsByTagName(\"action\")");
                c2.Y y0 = new c2.Y(nodeList0, 7);
                while(y0.hasNext()) {
                    Element element0 = (Element)(((Node)y0.next()));
                    kg.a a0 = new kg.a();
                    Node node0 = element0.getFirstChild();
                    if(node0 != null) {
                        for(Object object1: ((Iterable)je.p.c0(new Sf.p(node0, 3)).b)) {
                            Element element1 = (Element)object1;
                            String s3 = element1.getLocalName();
                            if(s3 == null) {
                                iterator3 = iterator0;
                            }
                            else {
                                switch(s3.hashCode()) {
                                    case 3373707: {
                                        iterator3 = iterator0;
                                        if(s3.equals("name")) {
                                            String s4 = element1.getTextContent();
                                            kotlin.jvm.internal.q.f(s4, "it.textContent");
                                            a0.b = s4;
                                        }
                                        break;
                                    }
                                    case 0x20EBDCFB: {
                                        if(s3.equals("argumentList")) {
                                            Node node1 = element1.getFirstChild();
                                            if(node1 != null) {
                                                for(Object object2: ((Iterable)je.p.c0(new Sf.p(node1, 3)).b)) {
                                                    Element element2 = (Element)object2;
                                                    if(kotlin.jvm.internal.q.b(element2.getLocalName(), "argument")) {
                                                        kg.f f0 = new kg.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                                                        Node node2 = element2.getFirstChild();
                                                        if(node2 != null) {
                                                            for(Object object3: ((Iterable)je.p.c0(new Sf.p(node2, 3)).b)) {
                                                                String s5 = ((Element)object3).getLocalName();
                                                                kotlin.jvm.internal.q.f(s5, "it.localName");
                                                                String s6 = ((Element)object3).getTextContent();
                                                                kotlin.jvm.internal.q.f(s6, "it.textContent");
                                                                switch(s5) {
                                                                    case "direction": {
                                                                        f0.b = "in".equalsIgnoreCase(s6);
                                                                        break;
                                                                    }
                                                                    case "name": {
                                                                        f0.a = s6;
                                                                        break;
                                                                    }
                                                                    case "relatedStateVariable": {
                                                                        f0.c = s6;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        iterator6 = iterator0;
                                                        a0.c.add(f0);
                                                    }
                                                    else {
                                                        iterator6 = iterator0;
                                                    }
                                                    iterator0 = iterator6;
                                                }
                                            }
                                        }
                                        iterator3 = iterator0;
                                        break;
                                    }
                                    default: {
                                        iterator3 = iterator0;
                                    }
                                }
                            }
                            iterator0 = iterator3;
                        }
                    }
                    n0.g.add(a0);
                }
                iterator1 = iterator0;
                NodeList nodeList1 = document0.getElementsByTagName("stateVariable");
                kotlin.jvm.internal.q.f(nodeList1, "doc.getElementsByTagName(\"stateVariable\")");
                c2.Y y1 = new c2.Y(nodeList1, 7);
                while(y1.hasNext()) {
                    Element element3 = (Element)(((Node)y1.next()));
                    ArrayList arrayList0 = new ArrayList();
                    String s7 = element3.getAttribute("sendEvents");
                    kotlin.jvm.internal.q.f(s7, "element.getAttribute(\"sendEvents\")");
                    boolean z = s7.equalsIgnoreCase("no");
                    String s8 = element3.getAttribute("multicast");
                    kotlin.jvm.internal.q.f(s8, "element.getAttribute(\"multicast\")");
                    s8.equalsIgnoreCase("yes");
                    Node node3 = element3.getFirstChild();
                    String s9 = null;
                    if(node3 == null) {
                        s15 = null;
                        s16 = null;
                        s17 = null;
                    }
                    else {
                        String s10 = null;
                        String s11 = null;
                        for(Object object4: ((Iterable)je.p.c0(new Sf.p(node3, 3)).b)) {
                            Element element4 = (Element)object4;
                            String s12 = element4.getLocalName();
                            if(s12 != null) {
                                switch(s12) {
                                    case "allowedValueList": {
                                        Node node5 = element4.getFirstChild();
                                        if(node5 == null) {
                                            continue;
                                        }
                                        for(Object object6: ((Iterable)je.p.c0(new Sf.p(node5, 3)).b)) {
                                            Element element5 = (Element)object6;
                                            if("allowedValue".equals(element5.getLocalName())) {
                                                String s14 = element5.getTextContent();
                                                kotlin.jvm.internal.q.f(s14, "it.textContent");
                                                arrayList0.add(s14);
                                            }
                                        }
                                        break;
                                    }
                                    case "allowedValueRange": {
                                        Node node4 = element4.getFirstChild();
                                        if(node4 == null) {
                                            continue;
                                        }
                                        for(Object object5: ((Iterable)je.p.c0(new Sf.p(node4, 3)).b)) {
                                            String s13 = ((Element)object5).getLocalName();
                                            kotlin.jvm.internal.q.f(s13, "it");
                                            kotlin.jvm.internal.q.f(((Element)object5).getTextContent(), "element.textContent");
                                            switch(s13.hashCode()) {
                                            }
                                        }
                                        break;
                                    }
                                    case "dataType": {
                                        s10 = element4.getTextContent();
                                        kotlin.jvm.internal.q.f(s10, "it.textContent");
                                        break;
                                    }
                                    case "defaultValue": {
                                        s11 = element4.getTextContent();
                                        kotlin.jvm.internal.q.f(s11, "it.textContent");
                                        break;
                                    }
                                    case "name": {
                                        s9 = element4.getTextContent();
                                        kotlin.jvm.internal.q.f(s9, "it.textContent");
                                    }
                                }
                            }
                        }
                        s15 = s9;
                        s16 = s10;
                        s17 = s11;
                    }
                    if(s15 == null) {
                        throw new IllegalStateException("name must be set.");
                    }
                    if(s16 == null) {
                        throw new IllegalStateException("dataType must be set.");
                    }
                    kg.q q0 = new kg.q(!z, s15, s16, arrayList0, s17);
                    n0.h.add(q0);
                }
            }
            iterator0 = iterator1;
        }
        for(Object object7: ((Iterable)k0.l)) {
            g.S(l0, ((kg.k)object7));
        }
    }

    public static final long T(long v, float f) {
        return Float.isNaN(f) || f >= 1.0f ? v : y0.s.c(v, y0.s.e(v) * f);
    }

    public static gd.H3 U(String s, String s1) {
        gd.H3 h30 = new gd.H3();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("argModeIndex", ((int)"POWERDJ".equals(s)));
        int v = 0;
        if(s1 != null) {
            switch(s1.hashCode()) {
                case 0xE884F2D9: {
                    if(s1.equals("popular") && "POWERDJ".equals(s)) {
                        v = 2;
                    }
                    break;
                }
                case 0xF206E0BB: {
                    if(s1.equals("updated") && !"POWERDJ".equals(s)) {
                        v = 2;
                    }
                    break;
                }
                case 1028554472: {
                    if(s1.equals("created")) {
                        "POWERDJ".equals(s);
                        v = 1;
                    }
                }
            }
        }
        bundle0.putInt("argOrderByIndex", v);
        h30.setArguments(bundle0);
        return h30;
    }

    public static void V(kg.k k0, Element element0) {
        int v3;
        int v2;
        String s4;
        Node node0 = element0.getFirstChild();
        if(node0 != null) {
            for(Object object0: ((Iterable)je.p.c0(new Sf.p(node0, 3)).b)) {
                Element element1 = (Element)object0;
                String s = element1.getLocalName();
                if(s != null) {
                    switch(s) {
                        case "deviceList": {
                            ArrayList arrayList0 = new ArrayList();
                            Node node5 = element1.getFirstChild();
                            if(node5 != null) {
                                for(Object object5: ((Iterable)je.p.c0(new Sf.p(node5, 3)).b)) {
                                    Element element4 = (Element)object5;
                                    if(kotlin.jvm.internal.q.b(element4.getLocalName(), "device")) {
                                        kg.k k1 = new kg.k(k0.n, k0.o);
                                        String s7 = k0.b;
                                        kotlin.jvm.internal.q.d(s7);
                                        k1.b = s7;
                                        k1.i = k0.i;
                                        g.V(k1, element4);
                                        arrayList0.add(k1);
                                    }
                                }
                            }
                            k0.l = arrayList0;
                            continue;
                        }
                        case "iconList": {
                            Node node3 = element1.getFirstChild();
                            if(node3 == null) {
                                continue;
                            }
                            for(Object object3: ((Iterable)je.p.c0(new Sf.p(node3, 3)).b)) {
                                Element element3 = (Element)object3;
                                if(kotlin.jvm.internal.q.b(element3.getLocalName(), "icon")) {
                                    Node node4 = element3.getFirstChild();
                                    String s3 = null;
                                    int v = 0;
                                    if(node4 == null) {
                                        s4 = null;
                                        v2 = 0;
                                        v3 = 0;
                                    }
                                    else {
                                        s4 = null;
                                        int v1 = 0;
                                        v2 = 0;
                                        v3 = 0;
                                        for(Object object4: ((Iterable)je.p.c0(new Sf.p(node4, 3)).b)) {
                                            String s5 = ((Element)object4).getLocalName();
                                            kotlin.jvm.internal.q.f(s5, "it.localName");
                                            String s6 = ((Element)object4).getTextContent();
                                            kotlin.jvm.internal.q.f(s6, "it.textContent");
                                            switch(s5) {
                                                case "depth": {
                                                    Integer integer1 = v.t0(s6);
                                                    v3 = integer1 == null ? 0 : ((int)integer1);
                                                    break;
                                                }
                                                case "height": {
                                                    Integer integer0 = v.t0(s6);
                                                    v2 = integer0 == null ? 0 : ((int)integer0);
                                                    break;
                                                }
                                                case "mimetype": {
                                                    s3 = s6;
                                                    break;
                                                }
                                                case "url": {
                                                    s4 = s6;
                                                    break;
                                                }
                                                case "width": {
                                                    Integer integer2 = v.t0(s6);
                                                    if(integer2 == null) {
                                                        goto label_88;
                                                    }
                                                    else {
                                                        v1 = (int)integer2;
                                                    }
                                                }
                                            }
                                            continue;
                                        label_88:
                                            v1 = 0;
                                        }
                                        v = v1;
                                    }
                                    if(s3 == null) {
                                        throw new IllegalStateException("mimetype must be set.");
                                    }
                                    if(v <= 0) {
                                        throw new IllegalStateException(("width must be > 0. actually " + v).toString());
                                    }
                                    if(v2 <= 0) {
                                        throw new IllegalStateException(("height must be > 0. actually " + v2).toString());
                                    }
                                    if(v3 <= 0) {
                                        throw new IllegalStateException(("depth must be > 0. actually " + v3).toString());
                                    }
                                    if(s4 == null) {
                                        throw new IllegalStateException("url must be set.");
                                    }
                                    kg.m m0 = new kg.m(s3, s4);
                                    k0.j.add(m0);
                                }
                            }
                            continue;
                        }
                        case "serviceList": {
                            Node node1 = element1.getFirstChild();
                            if(node1 == null) {
                                continue;
                            }
                            for(Object object1: ((Iterable)je.p.c0(new Sf.p(node1, 3)).b)) {
                                Element element2 = (Element)object1;
                                if(kotlin.jvm.internal.q.b(element2.getLocalName(), "service")) {
                                    kg.n n0 = new kg.n();
                                    Node node2 = element2.getFirstChild();
                                    if(node2 != null) {
                                        for(Object object2: ((Iterable)je.p.c0(new Sf.p(node2, 3)).b)) {
                                            String s1 = ((Element)object2).getLocalName();
                                            kotlin.jvm.internal.q.f(s1, "it.localName");
                                            String s2 = ((Element)object2).getTextContent();
                                            kotlin.jvm.internal.q.f(s2, "it.textContent");
                                            switch(s1) {
                                                case "SCPDURL": {
                                                    n0.c = s2;
                                                    break;
                                                }
                                                case "controlURL": {
                                                    n0.d = s2;
                                                    break;
                                                }
                                                case "eventSubURL": {
                                                    n0.e = s2;
                                                    break;
                                                }
                                                case "serviceId": {
                                                    n0.b = s2;
                                                    break;
                                                }
                                                case "serviceType": {
                                                    n0.a = s2;
                                                }
                                            }
                                        }
                                    }
                                    k0.k.add(n0);
                                }
                            }
                            continue;
                        }
                    }
                }
                String s8 = element1.getNamespaceURI();
                String s9 = element1.getTextContent();
                kotlin.jvm.internal.q.f(s, "tag");
                kotlin.jvm.internal.q.f(s9, "value");
                LinkedHashMap linkedHashMap0 = k0.m;
                if(s8 == null) {
                    s8 = "";
                }
                Map map0 = (Map)linkedHashMap0.get(s8);
                if(map0 == null) {
                    map0 = new LinkedHashMap();
                    linkedHashMap0.put(s8, map0);
                }
                map0.put(s, s9);
                switch(s) {
                    case "UDN": {
                        k0.c = s9;
                        break;
                    }
                    case "URLBase": {
                        k0.i = s9;
                        break;
                    }
                    case "deviceType": {
                        k0.d = s9;
                        break;
                    }
                    case "friendlyName": {
                        k0.e = s9;
                        break;
                    }
                    case "manufacturer": {
                        k0.f = s9;
                        break;
                    }
                    case "modelName": {
                        k0.g = s9;
                        break;
                    }
                    case "modelNumber": {
                        k0.h = s9;
                    }
                }
            }
        }
    }

    public static e4.f W(e4.f f0, String[] arr_s, Map map0) {
        int v = 0;
        if(f0 == null) {
            if(arr_s == null) {
                return null;
            }
            if(arr_s.length == 1) {
                return (e4.f)map0.get(arr_s[0]);
            }
            if(arr_s.length > 1) {
                e4.f f1 = new e4.f();
                while(v < arr_s.length) {
                    f1.a(((e4.f)map0.get(arr_s[v])));
                    ++v;
                }
                return f1;
            }
        }
        else {
            if(arr_s != null && arr_s.length == 1) {
                f0.a(((e4.f)map0.get(arr_s[0])));
                return f0;
            }
            if(arr_s != null && arr_s.length > 1) {
                while(v < arr_s.length) {
                    f0.a(((e4.f)map0.get(arr_s[v])));
                    ++v;
                }
            }
        }
        return f0;
    }

    public static void X(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        s s9 = new s();
        s9.b = "3";
        s9.c = s;
        s9.e = s1;
        s9.f = s2;
        s9.h = s4;
        s9.l = s8;
        if(!TextUtils.isEmpty(s3)) {
            s9.g = s3;
        }
        if(!TextUtils.isEmpty(s5)) {
            s9.i = s5;
        }
        if(!TextUtils.isEmpty(s6)) {
            s9.j = s6;
        }
        if(!TextUtils.isEmpty(s7)) {
            s9.k = s7;
        }
        com.iloen.melon.utils.a.t(s9);
    }

    public static void Y(String s, String s1, String s2, String s3, String s4, String s5, String s6) {
        s s7 = new s();
        s7.b = "3";
        s7.c = s;
        s7.e = "O17";
        s7.f = "T01";
        s7.g = s1;
        s7.h = s2;
        s7.i = s3;
        s7.j = s4;
        s7.k = s5;
        s7.l = s6;
        com.iloen.melon.utils.a.t(s7);
    }

    public static void Z(String s, String s1, String s2, String s3, String s4, String s5) {
        s s6 = new s();
        s6.b = s;
        s6.c = s1;
        s6.e = s2;
        s6.h = "V1";
        s6.l = s3;
        s6.j = s4;
        s6.k = s5;
        com.iloen.melon.utils.a.t(s6);
    }

    public static final void a(boolean z, Boolean boolean0, oc.M m0, we.a a0, we.a a1, we.n n0, we.a a2, we.n n1, we.a a3, we.a a4, boolean z1, we.a a5, String s, we.a a6, we.a a7, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-984010634);
        int v1 = p0.h(z) ? 4 : 2;
        int v2 = p0.g(boolean0) ? 0x20 : 16;
        int v3 = p0.e((m0 == null ? -1 : m0.ordinal())) ? 0x100 : 0x80;
        int v4 = p0.i(a0) ? 0x800 : 0x400;
        int v5 = 0x4000;
        int v6 = p0.i(a1) ? 0x4000 : 0x2000;
        int v7 = p0.i(n0) ? 0x20000 : 0x10000;
        int v8 = p0.i(a2) ? 0x100000 : 0x80000;
        int v9 = p0.i(n1) ? 0x800000 : 0x400000;
        int v10 = p0.i(a3) ? 0x4000000 : 0x2000000;
        int v11 = p0.i(a4) ? 0x20000000 : 0x10000000;
        int v12 = p0.h(z1) ? 4 : 2;
        int v13 = 0x400;
        int v14 = p0.i(a5) ? 0x20 : 16;
        int v15 = p0.g(s) ? 0x100 : 0x80;
        if(p0.i(a6)) {
            v13 = 0x800;
        }
        if(!p0.i(a7)) {
            v5 = 0x2000;
        }
        int v16 = v | v1 | v2 | v3 | v4 | v6 | v7 | v8 | v9 | v10 | v11;
        int v17 = v12 | v14 | v15 | v13 | v5;
        if(!p0.Q(v16 & 1, (v16 & 306783379) != 306783378 || (v17 & 9363) != 9362)) {
            p0.T();
        }
        else if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 2) {
            p0.a0(-1508163122);
            g.k(boolean0, a3, a1, n0, z, a0, a2, n1, m0, a4, z1, a5, s, a6, a7, p0, v16 >> 3 & 14 | v16 >> 21 & 0x70 | v16 >> 6 & 0x380 | v16 >> 6 & 0x1C00 | v16 << 12 & 0xE000 | v16 << 6 & 0x70000 | v16 & 0x380000 | v16 & 0x1C00000 | v16 << 18 & 0xE000000 | v16 & 0x70000000, v17 & 0xFFFE);
            p0.p(false);
        }
        else {
            p0.a0(0xA6269FCF);
            g.u(boolean0, a3, a1, n0, z, a0, a2, n1, m0, a4, z1, a5, s, a6, a7, p0, v16 >> 3 & 14 | v16 >> 21 & 0x70 | v16 >> 6 & 0x380 | v16 >> 6 & 0x1C00 | v16 << 12 & 0xE000 | v16 << 6 & 0x70000 | v16 & 0x380000 | v16 & 0x1C00000 | v16 << 18 & 0xE000000 | v16 & 0x70000000, v17 & 0xFFFE);
            p0.p(false);
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.n(z, boolean0, m0, a0, a1, n0, a2, n1, a3, a4, z1, a5, s, a6, a7, v);
        }
    }

    public static void a0(String s, String s1, String s2) {
        s s3 = new s();
        s3.b = s;
        s3.c = "";
        s3.e = s1;
        s3.h = s2;
        com.iloen.melon.utils.a.t(s3);
    }

    public static final void b(String s, we.k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-359200060);
        int v1 = (v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            q q0 = d.f(n0, 1.0f);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            w.x(p0, q1, j.d);
            long v3 = e0.T(p0, 0x7F060165);  // color:gray800s
            l1.k k1 = new l1.k(3);
            h h3 = j.d;
            N1.b(s, null, v3, 15.0f, null, null, 0L, k1, 21.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 6, 0x1F9F2);
            b0 b00 = p0.N();
            if(b00 == androidx.compose.runtime.k.a) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            q q2 = r0.a.a(d.f(a.n(n0, 0.0f, 12.0f, 0.0f, 26.0f, 5), 1.0f), new Ec.g(k0, b00, 6));
            p0 p00 = M.n0.a(M.j.e, r0.d.k, p0, 54);
            int v4 = p0.P;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            int v5 = ((Boolean)b00.getValue()).booleanValue() ? 0x7F08012A : 0x7F080129;  // drawable:btn_common_checkbox_on
            c1.n(d.h(d.q(n0, 18.0f), 18.0f), v5, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 390, 0, 0x7FF8);
            c.d(p0, d.q(n0, 8.0f));
            kotlin.jvm.internal.q.f("다시 보지 않기", "getString(...)");
            N1.b("다시 보지 않기", null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.U(s, k0, v, 23);
        }
    }

    public static void b0(String s, String s1, String s2, int v, String s3, String s4, String s5) {
        s s6 = new s();
        s6.b = "3";
        s6.c = s;
        s6.e = s1;
        s6.h = s3;
        if(!TextUtils.isEmpty(s2)) {
            s6.f = s2;
        }
        if(v > -1) {
            s6.i = String.valueOf(v);
        }
        if(!TextUtils.isEmpty(s4)) {
            s6.j = s4;
        }
        if(!TextUtils.isEmpty(s5)) {
            s6.k = s5;
        }
        com.iloen.melon.utils.a.t(s6);
    }

    public static final void c(l l0, int v) {
        ((p)l0).c0(0xF687EF5A);
        if(((p)l0).Q(v & 1, v != 0)) {
            M.p.a(androidx.compose.foundation.q.f(d.n(a.n(n.a, 0.0f, 6.0f, 8.0f, 0.0f, 9), 3.0f), e0.T(((p)l0), 0x7F060159), e.a), ((p)l0), 0);  // color:gray400s_support_high_contrast
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new B1(v, 26);
        }
    }

    public static void c0(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        s s9 = new s();
        s9.c = s1;
        s9.e = s2;
        s9.h = s4;
        if(!TextUtils.isEmpty(s)) {
            s9.b = s;
        }
        if(!TextUtils.isEmpty(s3)) {
            s9.f = s3;
        }
        if(!TextUtils.isEmpty(s5)) {
            s9.i = s5;
        }
        if(!TextUtils.isEmpty(s6)) {
            s9.j = s6;
        }
        if(!TextUtils.isEmpty(s7)) {
            s9.k = s7;
        }
        if(!TextUtils.isEmpty(s8)) {
            s9.l = s8;
        }
        com.iloen.melon.utils.a.t(s9);
    }

    public static final void d(l l0, int v) {
        int v3;
        p p0 = (p)l0;
        p0.c0(-1801064526);
        int v1 = 0;
        boolean z = true;
        if(p0.Q(v & 1, v != 0)) {
            Object object0 = p0.k(k0.h);
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(new r1.f(0.0f));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 1) {
                v3 = 339;
            }
            else {
                z = false;
                v3 = 0xC7;
            }
            if(z && ((Boolean)b01.getValue()).booleanValue()) {
                v1 = 7;
            }
            b0 b02 = p0.N();
            if(b02 == v2) {
                b02 = w.s(new r1.f(15.0f));
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v2) {
                b03 = w.s(new r1.l(0L));
                p0.l0(b03);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            boolean z1 = p0.g(((r1.c)object0));
            boolean z2 = p0.d(((float)v3));
            vd.o o0 = p0.N();
            if(z1 || z2 || o0 == v2) {
                vd.o o1 = new vd.o(((r1.c)object0), ((float)v3), b03, b00, b01, b02, null);
                p0.l0(o1);
                o0 = o1;
            }
            J.d(p0, boolean0, o0);
            w.a(E0.a.a(null), m0.c.e(0x27BF5472, p0, new vd.l(((float)v1), ((float)v3), b03, b02, b01)), p0, 56);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new M6(v, 22);
        }
    }

    public static void d0(String s, String s1, String s2) {
        s s3 = new s();
        s3.b = "6";
        if(TextUtils.isEmpty(s1)) {
            s1 = "1000000759";
        }
        s3.c = s1;
        s3.e = "S22";
        s3.h = s;
        if("M2".equals(s)) {
            boolean z = TextUtils.isEmpty(s2);
            s3.j = z ? "" : "N10001";
            if(z) {
                s2 = "";
            }
            s3.k = s2;
            s3.m = z ? "N" : "Y";
        }
        com.iloen.melon.utils.a.t(s3);
    }

    public static final void e(String s, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xE479821F);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            q q0 = d.f(a.n(n0, 20.0f, 22.0f, 20.0f, 0.0f, 8), 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
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
            yd.h.c(s, p0, v1 & 14);
            c.d(p0, d.h(n0, 12.0f));
            g.d(p0, 0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U0(s, v, 5);
        }
    }

    public static void e0(int v, String s, String s1, String s2, String s3, String s4) {
        s s5 = new s();
        s5.b = "9";
        s5.c = s;
        s5.e = "O30";
        s5.f = "T11";
        s5.h = s2;
        s5.i = String.valueOf(v);
        s5.j = s3;
        s5.k = s4;
        if(!TextUtils.isEmpty(s1)) {
            s5.g = s1;
        }
        com.iloen.melon.utils.a.t(s5);
    }

    public static final void f(String s, String s1, String s2, String s3, vd.h h0, we.a a0, we.k k0, boolean z, boolean z1, List list0, we.a a1, we.k k1, l l0, int v) {
        n n1;
        b0 b04;
        b0 b03;
        int v9;
        V v8;
        p p0 = (p)l0;
        p0.c0(-1753671801);
        int v1 = 16;
        int v2 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.g(s3) ? 0x800 : 0x400) | (p0.e((h0 == null ? -1 : h0.ordinal())) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000) | (p0.i(k0) ? 0x100000 : 0x80000) | (p0.h(z) ? 0x800000 : 0x400000) | (p0.h(z1) ? 0x4000000 : 0x2000000) | (p0.i(list0) ? 0x20000000 : 0x10000000);
        int v3 = p0.i(a1) ? 4 : 2;
        if(p0.i(k1)) {
            v1 = 0x20;
        }
        int v4 = v3 | v1;
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v4 & 19) != 18)) {
            b0 b00 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(b00 == v5) {
                b00 = U4.x.d(10, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v5) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            b0 b02 = p0.N();
            if(b02 == v5) {
                b02 = w.s("");
                p0.l0(b02);
            }
            m0 m00 = p0.N();
            if((((v2 & 0xE000) == 0x4000 ? 1 : 0) | ((v4 & 0x70) == 0x20 ? 1 : 0)) != 0 || m00 == v5) {
                m00 = new m0(h0, k1, b01, 1);
                p0.l0(m00);
            }
            J.b(H.a, m00, p0);
            n n0 = n.a;
            q q0 = d.q(d.j(n0, 0.0f, 440.0f, 1), ((float)(h0 == vd.h.h ? 285 : 270)));
            M m0 = M.p.d(r0.d.e, false);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = j.f;
            w.x(p0, m0, h1);
            h h2 = j.e;
            w.x(p0, i00, h2);
            h h3 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h3);
            }
            h h4 = j.d;
            w.x(p0, q1, h4);
            q q2 = androidx.compose.foundation.q.f(d5.n.o(n0, e.b(12.0f)), e0.T(p0, 0x7F0604AB), y0.M.a);  // color:white001s
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v7 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h3);
            }
            w.x(p0, q3, h4);
            if(s != null && s.length() != 0) {
                p0.a0(0xBF8DD005);
                switch(h0.ordinal()) {
                    case 1: {
                        v8 = v5;
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(0xBF94FB13);
                        vd.k k2 = p0.N();
                        if(k2 == v8) {
                            k2 = new vd.k(b04, 2);
                            p0.l0(k2);
                        }
                        g.B(s, (s1 == null ? "" : s1), k2, p0, v2 & 14 | 0x180);
                        p0.p(false);
                        break;
                    }
                    case 2: {
                        v8 = v5;
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(-1081182307);
                        Object object2 = je.p.m0(list0);
                        int v10 = ((Number)b03.getValue()).intValue();
                        vd.k k3 = p0.N();
                        if(k3 == v8) {
                            k3 = new vd.k(b03, 0);
                            p0.l0(k3);
                        }
                        g.D(s, (object2 instanceof String ? ((String)object2) : null), v10, k3, p0, v2 & 14 | 0xC00);
                        p0.p(false);
                        break;
                    }
                    case 3: {
                        v8 = v5;
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(-1080532547);
                        Object object3 = je.p.m0(list0);
                        Boolean boolean0 = object3 instanceof Boolean ? ((Boolean)object3) : null;
                        g.v(s, (boolean0 == null ? false : boolean0.booleanValue()), p0, v2 & 14);
                        p0.p(false);
                        break;
                    }
                    case 4: {
                        v8 = v5;
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(-1080313997);
                        g.e(s, p0, v2 & 14);
                        p0.p(false);
                        break;
                    }
                    case 5: {
                        v8 = v5;
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(-1080185037);
                        g.A(s, (s1 == null ? "" : s1), true, p0, v2 & 14 | 0x180, 0);
                        p0.p(false);
                        break;
                    }
                    case 6: {
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        p0.a0(-1080019156);
                        Object object4 = je.p.n0(2, list0);
                        String s4 = object4 instanceof String ? ((String)object4) : null;
                        if(s4 == null) {
                            s4 = "";
                        }
                        Object object5 = je.p.m0(list0);
                        Object object6 = je.p.n0(1, list0);
                        Integer integer1 = object6 instanceof Integer ? ((Integer)object6) : null;
                        int v11 = integer1 == null ? 0 : ((int)integer1);
                        vd.k k4 = p0.N();
                        if(k4 == v5) {
                            k4 = new vd.k(b02, 3);
                            p0.l0(k4);
                        }
                        v8 = v5;
                        g.C(s, s4, (s1 == null ? "" : s1), (object5 instanceof String ? ((String)object5) : null), v11, k4, p0, v2 & 14 | 0x30000);
                        p0.p(false);
                        break;
                    }
                    default: {
                        p0.a0(0xBFA807E2);
                        v9 = v2 & 0xE000;
                        b03 = b00;
                        b04 = b01;
                        n1 = n0;
                        g.A(s, (s1 == null ? "" : s1), false, p0, v2 & 14, 4);
                        p0.p(false);
                        v8 = v5;
                    }
                }
            }
            else {
                v8 = v5;
                v9 = v2 & 0xE000;
                b03 = b00;
                b04 = b01;
                n1 = n0;
                p0.a0(0xBFAA3F92);
                if(vd.s.a[h0.ordinal()] == 7) {
                    p0.a0(0xBFABDB2B);
                    Object object0 = je.p.m0(list0);
                    Integer integer0 = object0 instanceof Integer ? ((Integer)object0) : null;
                    Object object1 = je.p.n0(1, list0);
                    g.i(((int)(integer0 == null ? 0x7F0807BB : ((int)integer0))), (object1 instanceof String ? ((String)object1) : null), p0, 0);  // drawable:push
                }
                else {
                    p0.a0(0xBFB06BB9);
                    if(s1 == null || s1.length() == 0) {
                        p0.a0(0xBEF9019F);
                    }
                    else {
                        p0.a0(0x6947CB9E);
                        g.s(s1, p0, v2 >> 3 & 14);
                    }
                    p0.p(false);
                }
                p0.p(false);
            }
            p0.p(false);
            e0.C(d.f(n1, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            boolean z2 = h0 != vd.h.g || ((String)b02.getValue()).length() > 0;
            q q4 = d.h(d.f(n1, 1.0f), 44.0f);
            q q5 = H0.b.q(r0.d.n, q4);
            com.iloen.melon.player.playlist.common.g g0 = p0.N();
            if((0x70000 & v2) == 0x20000 || g0 == v8) {
                g0 = new com.iloen.melon.player.playlist.common.g(7, a0);
                p0.l0(g0);
            }
            kd.e e0 = p0.N();
            if(((v9 == 0x4000 ? 1 : 0) | ((0x380000 & v2) == 0x100000 ? 1 : 0)) != 0 || e0 == v8) {
                kd.e e1 = new kd.e(h0, k0, b03, b04, b02);
                p0.l0(e1);
                e0 = e1;
            }
            yd.h.b(z, z1, q5, s2, s3, z2, g0, e0, a1, p0, v2 >> 21 & 0x7E | v2 << 3 & 0x1C00 | v2 << 3 & 0xE000 | v4 << 24 & 0xE000000, 0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new vd.m(s, s1, s2, s3, h0, a0, k0, z, z1, list0, a1, k1, v);
        }
    }

    public static void f0(String s, String s1, String s2) {
        s s3 = new s();
        s3.b = "110";
        s3.c = "1000001515";
        if(!TextUtils.isEmpty(s)) {
            s3.e = s;
        }
        if(!TextUtils.isEmpty(s1)) {
            s3.f = s1;
        }
        if(!TextUtils.isEmpty(s2)) {
            s3.h = s2;
        }
        com.iloen.melon.utils.a.t(s3);
    }

    public static final void g(String s, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x464802C2);
        int v1 = v | (p0.g(s) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            q q0 = d.f(a.n(n.a, 16.0f, 9.0f, 16.0f, 0.0f, 8), 1.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            g.c(p0, 0);
            N1.b(s, null, e0.T(p0, 0x7F060163), 14.0f, null, null, 0L, null, 18.5f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 6, 0x1FBF2);  // color:gray700s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new k2(s, v, 1);
        }
    }

    public static final String g0(Me.e e0, String s) {
        kotlin.jvm.internal.q.g(e0, "classDescriptor");
        kotlin.jvm.internal.q.g(s, "jvmDescriptor");
        qf.b b0 = Le.d.f(xf.d.g(e0).a);
        String s1 = b0 == null ? e1.x.z(e0, jf.f.d) : yf.b.e(b0);
        kotlin.jvm.internal.q.g(s1, "internalName");
        return s1 + '.' + s;
    }

    public static final void h(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x7FCD5097);
        int v1 = (p0.i(a0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q q0 = r0.a.a(e0.M(d.h(d.q(a.n(n.a, 16.0f, 0.0f, 0.0f, 0.0f, 14), 35.0f), 20.0f), 0x7F060152, 100.0f), new D(3, a0));  // color:gray200a
            M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
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
            w.x(p0, q1, j.d);
            kotlin.jvm.internal.q.f("편집", "getString(...)");
            N1.b("편집", null, e0.T(p0, 0x7F060163), 11.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray700s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.j(v, 5, a0);
        }
    }

    public static final int h0(e1.m m0, u5.f f0) {
        if(m0 instanceof u5.a) {
            return ((u5.a)m0).e;
        }
        switch(f0.ordinal()) {
            case 0: {
                return 0x80000000;
            }
            case 1: {
                return 0x7FFFFFFF;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final void i(Integer integer0, String s, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1835945020);
        int v1 = v | (p0.g(integer0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            q q0 = androidx.compose.foundation.q.f(d.h(d.q(n.a, 285.0f), 298.0f), y0.s.d, y0.M.a);
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
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
            w.x(p0, q1, j.d);
            c1.n(d.c, integer0, s, N0.j.e, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70 | 0xC06 | v1 << 3 & 0x380, 0, 0x7FF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(integer0, s, v, 27);
        }
    }

    public static qf.b i0(qf.c c0) {
        kotlin.jvm.internal.q.g(c0, "topLevelFqName");
        return new qf.b(c0.b(), c0.a.f());
    }

    public static final void j(q q0, String s, String s1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-340040677);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            N1.b(String.valueOf(s.length()), null, e0.T(p0, 0x7F06017C), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFA);  // color:green500s_support_high_contrast
            N1.b(U4.x.k(" ", H0.e.Y(p0, 0x7F130A13), " "), null, e0.T(p0, 0x7F060160), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFA);  // string:slash "/"
            N1.b(s1, null, e0.T(p0, 0x7F060160), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 6 & 14, 0, 0x1FFFA);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.P0(q0, s, s1, v, 2);
        }
    }

    public static final void k(Boolean boolean0, we.a a0, we.a a1, we.n n0, boolean z, we.a a2, we.a a3, we.n n1, oc.M m0, we.a a4, boolean z1, we.a a5, String s, we.a a6, we.a a7, l l0, int v, int v1) {
        b0 b02;
        x1.m m2;
        x1.j j1;
        p p0 = (p)l0;
        p0.c0(0x8DB932BF);
        int v2 = (v & 6) == 0 ? (p0.g(boolean0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(a1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        int v3 = 0x2000;
        if((v & 0x6000) == 0) {
            v2 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v2 |= (p0.i(a2) ? 0x20000 : 0x10000);
        }
        if((v & 0x180000) == 0) {
            v2 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.i(n1) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.e((m0 == null ? -1 : m0.ordinal())) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v) == 0) {
            v2 |= (p0.i(a4) ? 0x20000000 : 0x10000000);
        }
        int v4 = (v1 & 6) == 0 ? v1 | (p0.h(z1) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v4 |= (p0.i(a5) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v4 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v4 |= (p0.i(a6) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            if(p0.i(a7)) {
                v3 = 0x4000;
            }
            v4 |= v3;
        }
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v4 & 9363) != 9362)) {
            q q0 = a.n(d.h(d.f(n.a, 1.0f), E9.h.t(p0, 0x7F070408)), 14.0f, 0.0f, 14.0f, 0.0f, 10);  // dimen:player_bottom_controller_height
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q1 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(q1 == v5) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v5) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v5) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            x1.m m1 = p0.N();
            if(m1 == v5) {
                m1 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v5) {
                j1 = j0;
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            else {
                j1 = j0;
            }
            boolean z2 = p0.i(q1);
            boolean z3 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z2 || z3 || g10 == v5) {
                g10 = new g1(b01, q1, m1, 16, b00);
                m2 = m1;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m2 = m1;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v5) {
                h10 = new h1(b02, m2, 16);
                p0.l0(h10);
            }
            boolean z4 = p0.i(q1);
            i1 i10 = p0.N();
            if(z4 || i10 == v5) {
                i10 = new i1(q1, 16);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new td.p(b01, j1, h10, s, a6, boolean0, a0, a1, n0, z, a2, a3, n1, m0, a4, z1, a5, a7)), g10, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.o(boolean0, a0, a1, n0, z, a2, a3, n1, m0, a4, z1, a5, s, a6, a7, v, v1, 0);
        }
    }

    public static final void l(q q0, boolean z, int v, we.a a0, we.a a1, l l0, int v1) {
        int v6;
        int v5;
        p p0 = (p)l0;
        p0.c0(0xDC9DBA46);
        int v2 = v1 | (p0.g(q0) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.e(v) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            q q1 = d.h(d.f(q0, 1.0f), E9.h.t(p0, 0x7F07040E));  // dimen:player_like_mixup_container_height
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v3 = p0.P;
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
            w.x(p0, p00, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            n n0 = n.a;
            c.d(p0, d.q(n0, 12.0f));
            q q3 = a.n(new LayoutWeightElement(1.0f, true), 0.0f, 2.0f, 0.0f, 0.0f, 13);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            r0.i i1 = r0.d.a;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q4, h3);
            if(z) {
                v5 = -1832803938;
                v6 = 0x7F130B62;  // string:talkback_like_turn_off "좋아요, 취소하기"
            }
            else {
                v5 = 0x92C2FE3F;
                v6 = 0x7F130B63;  // string:talkback_like_turn_on "좋아요, 선택하기"
            }
            String s = l1.h(p0, v5, v6, p0, false);
            g.t(a.l(r0.a.a(d.h(d.v(n0, null, 3), 48.0f), new N(s, a0, 5)), 12.0f, 0.0f, 2), z, v, p0, v2 & 0x3F0);
            p0.p(true);
            q q5 = a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13);
            M m1 = M.p.d(i1, false);
            int v7 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q6, h3);
            g.p(r0.a.a(d.h(d.v(n0, null, 3), 48.0f), new N(H0.e.Y(p0, 0x7F130B84), a1, 6)), p0, 0);  // string:talkback_mixup_play_by_song "이 곡으로 믹스업 재생"
            p0.p(true);
            U4.x.z(n0, 24.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.l(q0, z, v, a0, a1, v1);
        }
    }

    public static final void m(z1 z10, we.k k0, l l0, int v) {
        String s4;
        boolean z7;
        p p0 = (p)l0;
        p0.c0(0xE8040064);
        int v1 = (p0.i(z10) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            e1 e10 = e1.a;
            boolean z = z10.f;
            String s = z10.e;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = z10.b;
            if(s2 != null) {
                s1 = s2;
            }
            String s3 = z10.c;
            boolean z1 = z10.l;
            boolean z2 = z10.g;
            boolean z3 = z10.h;
            boolean z4 = z10.i;
            boolean z5 = z10.k;
            boolean z6 = p0.i(z10);
            v1 v10 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z6 || v10 == v2) {
                z7 = z;
                v10 = new v1(k0, z10, 1);
                p0.l0(v10);
            }
            else {
                z7 = z;
            }
            boolean z8 = p0.i(z10);
            v1 v11 = p0.N();
            if((v1 & 0x70) == 0x20 || z8 || v11 == v2) {
                s4 = s;
                v11 = new v1(k0, z10, 2);
                p0.l0(v11);
            }
            else {
                s4 = s;
            }
            boolean z9 = p0.i(z10);
            v1 v12 = p0.N();
            if((v1 & 0x70) == 0x20 || z9 || v12 == v2) {
                v12 = new v1(k0, z10, 3);
                p0.l0(v12);
            }
            boolean z10_1 = p0.i(z10);
            v1 v13 = p0.N();
            if((v1 & 0x70) == 0x20 || z10_1 || v13 == v2) {
                v13 = new v1(k0, z10, 4);
                p0.l0(v13);
            }
            boolean z11 = p0.i(z10);
            v1 v14 = p0.N();
            if((v1 & 0x70) == 0x20 || z11 || v14 == v2) {
                v14 = new v1(k0, z10, 0);
                p0.l0(v14);
            }
            c1.e(e10, z7, s4, s1, s3, z1, z2, z3, z4, z5, v10, v11, v12, v13, v14, p0, 0x30006006);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(z10, k0, v, 15);
        }
    }

    public static final void n(D1 d10, we.a a0, we.k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x1639CE65);
        int v1 = v | (p0.i(d10) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = I.a(0, 0, 3, p0);
            boolean z = p0.g(f0);
            x1 x10 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z || x10 == v2) {
                x10 = new x1(f0, a0, null);
                p0.l0(x10);
            }
            J.d(p0, H.a, x10);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            q q0 = r0.a.d(p0, n0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q0, j.d);
            boolean z1 = d10.a;
            String s = d10.b;
            String s1 = d10.c;
            C8.c c0 = p0.N();
            if((v1 & 0x380) == 0x100 || c0 == v2) {
                c0 = new C8.c(12, k0);
                p0.l0(c0);
            }
            C8.c c1 = p0.N();
            if((v1 & 0x380) == 0x100 || c1 == v2) {
                c1 = new C8.c(13, k0);
                p0.l0(c1);
            }
            Y1 y10 = p0.N();
            if((v1 & 0x380) == 0x100 || y10 == v2) {
                y10 = new Y1(6, k0);
                p0.l0(y10);
            }
            e0.l(z1, s, s1, c0, c1, y10, p0, 0);
            q q1 = d.c(n0, 1.0f);
            j0 j00 = a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z2 = p0.i(d10);
            gd.l l1 = p0.N();
            if(z2 || (v1 & 0x380) == 0x100 || l1 == v2) {
                l1 = new gd.l(8, d10, k0);
                p0.l0(l1);
            }
            c1.o(q1, f0, j00, false, null, null, null, false, l1, p0, 6, 0xF8);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(d10, a0, k0, v, 16);
        }
    }

    public static final void o(F5 f50, we.k k0, l l0, int v) {
        h h4;
        i i1;
        p p0 = (p)l0;
        p0.c0(0x288F6D79);
        int v1 = v | (p0.i(f50) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            M.d d0 = M.j.c;
            r0.g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            q q0 = r0.a.d(p0, n0);
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
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q0, h3);
            q q1 = androidx.compose.foundation.q.x(n0, androidx.compose.foundation.q.t(p0), false, 14);
            y y1 = M.w.a(d0, g0, p0, 0);
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
            w.x(p0, y1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q2, h3);
            kotlin.jvm.internal.q.f("멜론 DJ가 되시면, 멜론 유저들에게 \nDJ플레이리스트를 만들어 추천 하실 수 있어요!!", "getString(...)");
            N1.b("멜론 DJ가 되시면, 멜론 유저들에게 \nDJ플레이리스트를 만들어 추천 하실 수 있어요!!", d.f(a.m(n0, 16.0f, 19.0f, 16.0f, 16.0f), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 23.5f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);  // color:gray900s
            g.r(f50, k0, p0, v1 & 0x7E);
            g.y(f50, k0, p0, v1 & 0x7E);
            q q3 = d.h(d.f(a.n(n0, 16.0f, 20.0f, 16.0f, 0.0f, 8), 1.0f), 37.0f);
            M m0 = M.p.d(r0.d.d, false);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i02, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v4)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v4, p0, v4, h4);
            }
            w.x(p0, q4, h3);
            kotlin.jvm.internal.q.f("멜론DJ 신청TIP", "getString(...)");
            N1.b("멜론DJ 신청TIP", null, e0.T(p0, 0x7F06016D), 18.0f, null, null, 0L, null, 23.5f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC06, 0x1DBF2);  // color:gray900s
            p0.p(true);
            kotlin.jvm.internal.q.f("멜론DJ 신청을 하기 위해 DJ플레이리스트를 아래의 항목에 맞춰 만들어야 합니다.", "getString(...)");
            g.g("멜론DJ 신청을 하기 위해 DJ플레이리스트를 아래의 항목에 맞춰 만들어야 합니다.", p0, 0);
            kotlin.jvm.internal.q.f("최소 10곡 이상의 수록곡", "getString(...)");
            g.g("최소 10곡 이상의 수록곡", p0, 0);
            kotlin.jvm.internal.q.f("선곡의 테마 및 장르를 표현할 수 있는 제목 (단문 X)", "getString(...)");
            g.g("선곡의 테마 및 장르를 표현할 수 있는 제목 (단문 X)", p0, 0);
            kotlin.jvm.internal.q.f("주제를 설명하는 플레이리스트 상세 소개글 및 2개 이상의 #해시태그 기입", "getString(...)");
            g.g("주제를 설명하는 플레이리스트 상세 소개글 및 2개 이상의 #해시태그 기입", p0, 0);
            kotlin.jvm.internal.q.f("동일 아티스트/앨범 곡 20% 또는 3곡 이상 연속 수록 주의", "getString(...)");
            g.g("동일 아티스트/앨범 곡 20% 또는 3곡 이상 연속 수록 주의", p0, 0);
            kotlin.jvm.internal.q.f("나만의 음악서랍> 프로필 설정> 프로필 이미지 등록", "getString(...)");
            g.g("나만의 음악서랍> 프로필 설정> 프로필 이미지 등록", p0, 0);
            q q5 = r0.a.a(e0.M(d.h(d.f(a.m(n0, 16.0f, 17.0f, 16.0f, 20.0f), 1.0f), 40.0f), 0x7F060152, 100.0f), new Ac.l(18, k0, f50));  // color:gray200a
            M m1 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i03 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h4);
            }
            w.x(p0, q6, h3);
            kotlin.jvm.internal.q.f("신청 완료하기", "getString(...)");
            N1.b("신청 완료하기", null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(f50, k0, v, 26);
        }
    }

    public static final void p(q q0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1013483868);
        int v1 = (p0.g(q0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            n n0 = n.a;
            q q2 = d.h(d.v(n0, null, 3), 30.0f);
            q q3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.e);
            q q4 = a.l(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F0604B2), q3, e.a), 12.0f, 0.0f, 2);  // color:white300e_support_high_contrast
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
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
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q5, h3);
            q q6 = d.n(n0, 24.0f);
            androidx.compose.foundation.q.c(De.I.Q(0x7F080155, p0, 6), null, q6, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:btn_common_mixup_18
            N1.b(l1.s(n0, 4.0f, p0, 0x7F13080C, p0), null, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:play_mixup "믹스업"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Bd.h(q0, v, 8);
        }
    }

    public static final void q(String s, we.a a0, long v, we.n n0, String s1, String s2, we.a a1, we.a a2, we.a a3, boolean z, int v1, we.a a4, we.a a5, d9.h h0, boolean z1, boolean z2, boolean z3, we.k k0, long v2, long v3, Long long0, long v4, long v5, we.k k1, we.k k2, we.k k3, we.k k4, we.a a6, we.a a7, boolean z4, Boolean boolean0, oc.M m0, we.a a8, we.a a9, we.n n1, we.a a10, we.n n2, we.a a11, we.a a12, boolean z5, we.a a13, String s3, we.a a14, we.a a15, boolean z6, boolean z7, boolean z8, boolean z9, l l0, int v6) {
        M m3;
        b0 b03;
        x1.m m2;
        x1.j j1;
        a0 a02;
        Context context1;
        F.X x1;
        kotlin.jvm.internal.q.g(h0, "lyricViewModel");
        p p0 = (p)l0;
        p0.c0(0x23AF9A8D);
        int v7 = 0x2000;
        int v8 = 0x10000;
        int v9 = 0x80000;
        int v10 = 0x400000;
        int v11 = 0x2000000;
        int v12 = 0x10000000;
        int v13 = v6 | (p0.g(s) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.f(v) ? 0x100 : 0x80) | (p0.g(s1) ? 0x4000 : 0x2000) | (p0.g(s2) ? 0x20000 : 0x10000) | (p0.i(a1) ? 0x100000 : 0x80000) | (p0.i(a2) ? 0x800000 : 0x400000) | (p0.i(a3) ? 0x4000000 : 0x2000000) | (p0.h(z) ? 0x20000000 : 0x10000000);
        int v14 = p0.e(v1) ? 4 : 2;
        int v15 = p0.i(a4) ? 0x20 : 16;
        int v16 = p0.i(a5) ? 0x100 : 0x80;
        int v17 = 0x400;
        int v18 = p0.i(h0) ? 0x800 : 0x400;
        int v19 = p0.h(z1) ? 0x4000 : 0x2000;
        int v20 = p0.h(z2) ? 0x20000 : 0x10000;
        int v21 = p0.h(z3) ? 0x100000 : 0x80000;
        int v22 = p0.i(k0) ? 0x20000000 : 0x10000000;
        int v23 = p0.f(v2) ? 4 : 2;
        int v24 = p0.f(v3) ? 0x20 : 16;
        int v25 = p0.g(long0) ? 0x100 : 0x80;
        int v26 = p0.f(v4) ? 0x800 : 0x400;
        int v27 = p0.f(v5) ? 0x4000 : 0x2000;
        int v28 = p0.i(k2) ? 0x100000 : 0x80000;
        int v29 = p0.i(k3) ? 0x800000 : 0x400000;
        int v30 = p0.i(k4) ? 0x4000000 : 0x2000000;
        int v31 = p0.i(a6) ? 0x20000000 : 0x10000000;
        int v32 = p0.i(a7) ? 4 : 2;
        int v33 = p0.h(z4) ? 0x20 : 16;
        int v34 = p0.g(boolean0) ? 0x100 : 0x80;
        int v35 = p0.e((m0 == null ? -1 : m0.ordinal())) ? 0x800 : 0x400;
        int v36 = p0.i(a8) ? 0x4000 : 0x2000;
        int v37 = p0.i(a9) ? 0x20000 : 0x10000;
        int v38 = p0.i(n1) ? 0x100000 : 0x80000;
        int v39 = p0.i(a10) ? 0x800000 : 0x400000;
        int v40 = p0.i(n2) ? 0x4000000 : 0x2000000;
        int v41 = p0.i(a11) ? 0x20000000 : 0x10000000;
        int v42 = p0.i(a12) ? 4 : 2;
        int v43 = p0.h(z5) ? 0x20 : 16;
        int v44 = p0.i(a13) ? 0x100 : 0x80;
        if(p0.g(s3)) {
            v17 = 0x800;
        }
        if(p0.i(a14)) {
            v7 = 0x4000;
        }
        if(p0.i(a15)) {
            v8 = 0x20000;
        }
        if(p0.h(z6)) {
            v9 = 0x100000;
        }
        if(p0.h(z7)) {
            v10 = 0x800000;
        }
        if(p0.h(z8)) {
            v11 = 0x4000000;
        }
        if(p0.h(z9)) {
            v12 = 0x20000000;
        }
        if(p0.Q(v13 & 1, (v13 & 306783379) != 306783378 || ((0x6C00000 | v14 | v15 | v16 | v18 | v19 | v20 | v21 | v22) & 306783379) != 306783378 || ((0x30000 | v23 | v24 | v25 | v26 | v27 | v28 | v29 | v30 | v31) & 306783379) != 306783378 || ((v32 | v33 | v34 | v35 | v36 | v37 | v38 | v39 | v40 | v41) & 306783379) != 306783378 || ((v42 | v43 | v44 | v17 | v7 | v8 | v9 | v10 | v11 | v12) & 306783379) != 306783378)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z10 = p0.g(context0);
            PlayerViewCalculator playerViewCalculator0 = p0.N();
            V v45 = androidx.compose.runtime.k.a;
            if(z10 || playerViewCalculator0 == v45) {
                playerViewCalculator0 = new PlayerViewCalculator(context0);
                p0.l0(playerViewCalculator0);
            }
            a0 a00 = p0.N();
            if(a00 == v45) {
                a00 = w.p(ScreenUtils.getStatusBarHeight(context0));
                p0.l0(a00);
            }
            a0 a01 = p0.N();
            if(a01 == v45) {
                a01 = w.p(-1);
                p0.l0(a01);
            }
            b0 b00 = p0.N();
            if(b00 == v45) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            boolean z11 = ((Boolean)b00.getValue()).booleanValue() && !z3 && !z7 && z9;
            F.X x0 = p0.N();
            if(x0 == v45) {
                x0 = F.S.b(G.f.r(0xAF, 0, C.d, 2), 2);
                p0.l0(x0);
            }
            F.Y y0 = p0.N();
            if(y0 == v45) {
                x1 = x0;
                y0 = F.S.c(G.f.r(75, 0, C.d, 2), 2);
                p0.l0(y0);
            }
            else {
                x1 = x0;
            }
            FillElement fillElement0 = d.c;
            boolean z12 = p0.i(context0);
            boolean z13 = p0.i(playerViewCalculator0);
            Bd.x x2 = p0.N();
            if(z12 || z13 || x2 == v45) {
                a02 = a01;
                context1 = context0;
                x2 = new Bd.x(a00, context1, a02, playerViewCalculator0, b00, 7);
                p0.l0(x2);
            }
            else {
                context1 = context0;
                a02 = a01;
            }
            q q0 = androidx.compose.ui.layout.a.f(fillElement0, x2);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q1 = p0.N();
            if(q1 == v45) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v45) {
                j0 = l1.u(p0);
            }
            b0 b01 = p0.N();
            if(b01 == v45) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            x1.m m1 = p0.N();
            if(m1 == v45) {
                m1 = l1.v(j0, p0);
            }
            b0 b02 = p0.N();
            if(b02 == v45) {
                b02 = w.r(H.a, V.c);
                p0.l0(b02);
            }
            boolean z14 = p0.i(q1);
            boolean z15 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z14 || z15 || g10 == v45) {
                j1 = j0;
                g10 = new g1(b02, q1, m1, 17, b01);
                m2 = m1;
                b03 = b01;
                p0.l0(g10);
            }
            else {
                j1 = j0;
                m2 = m1;
                b03 = b01;
            }
            h1 h10 = p0.N();
            if(h10 == v45) {
                m3 = g10;
                h10 = new h1(b03, m2, 17);
                p0.l0(h10);
            }
            else {
                m3 = g10;
            }
            boolean z16 = p0.i(q1);
            i1 i10 = p0.N();
            if(z16 || i10 == v45) {
                i10 = new i1(q1, 17);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new td.r(b02, j1, h10, a00, z6, z3, long0, v2, v3, s, a0, v, n0, s1, s2, a1, z9, a2, a3, x1, y0, a02, z1, h0, k0, z11, z8, z, v1, a4, a5, v4, v5, z2, context1, k1, k2, k3, k4, a6, a7, z4, boolean0, m0, a8, a9, n1, a10, n2, a11, a12, z5, a13, s3, a14, a15)), m3, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.l(s, a0, v, n0, s1, s2, a1, a2, a3, z, v1, a4, a5, h0, z1, z2, z3, k0, v2, v3, long0, v4, v5, k1, k2, k3, k4, a6, a7, z4, boolean0, m0, a8, a9, n1, a10, n2, a11, a12, z5, a13, s3, a14, a15, z6, z7, z8, z9, v6);
        }
    }

    public static final void r(F5 f50, we.k k0, l l0, int v) {
        h h5;
        i i1;
        p p0 = (p)l0;
        p0.c0(0x4C4DC4F7);
        int v1 = (v & 6) == 0 ? v | (p0.i(f50) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q q0 = a.n(n.a, 16.0f, 16.0f, 16.0f, 0.0f, 8);
            n n0 = n.a;
            r0.h h0 = r0.d.k;
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = j.f;
            w.x(p0, p00, h1);
            h h2 = j.e;
            w.x(p0, i00, h2);
            h h3 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            h h4 = j.d;
            w.x(p0, q1, h4);
            kotlin.jvm.internal.q.f("내 정보", "getString(...)");
            N1.b("내 정보", new LayoutWeightElement(1.0f, true), e0.T(p0, 0x7F06016D), 18.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            C8.c c0 = p0.N();
            if((v1 & 0x70) == 0x20 || c0 == androidx.compose.runtime.k.a) {
                c0 = new C8.c(14, k0);
                p0.l0(c0);
            }
            g.h(c0, p0, 0);
            p0.p(true);
            q q2 = d.f(d.h(a.n(n0, 16.0f, 13.0f, 16.0f, 0.0f, 8), 65.0f), 1.0f);
            p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i01, h2);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v3)) {
                h5 = h3;
            }
            else {
                h5 = h3;
                A7.d.q(v3, p0, v3, h5);
            }
            w.x(p0, q3, h4);
            q q4 = androidx.compose.foundation.q.f(d.n(n0, 65.0f), ye.a.v(p0, 0x7F060145), e.a);  // color:gray050s
            q q5 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q4, e.a);  // color:gray100a
            r0.b.e(q5, (f50.a == null ? "" : f50.a), 65.0f, 0x7F080799, 0L, false, false, p0, 0xC00D80, 0x70);  // drawable:noimage_man_medium
            q q6 = H0.b.r(h0, a.n(n0, 14.0f, 0.0f, 0.0f, 0.0f, 14));
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i02, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h5);
            }
            w.x(p0, q7, h4);
            N1.b((f50.b == null ? "" : f50.b), d.f(n0, 1.0f), e0.T(p0, 0x7F06017B), 16.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500s
            N1.b((f50.c == null ? "" : f50.c), d.f(a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), 1.0f), e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray800s
            p0.p(true);
            p0.p(true);
            e0.C(d.h(d.f(a.n(n0, 0.0f, 13.0f, 0.0f, 0.0f, 13), 1.0f), 0.5f), 0L, 0, 0.0f, p0, 6, 30);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new u5(f50, k0, v, 1);
        }
    }

    public static final void s(String s, l l0, int v) {
        ((p)l0).c0(0xBD1B6ECB);
        int v1 = (v & 6) == 0 ? v | (((p)l0).g(s) ? 4 : 2) : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            q q0 = d.f(a.m(n.a, 20.0f, 26.0f, 20.0f, 26.0f), 1.0f);
            M m0 = M.p.d(r0.d.e, false);
            int v2 = ((p)l0).P;
            i0 i00 = ((p)l0).m();
            q q1 = r0.a.d(((p)l0), q0);
            k.y.getClass();
            i i0 = j.b;
            ((p)l0).e0();
            if(((p)l0).O) {
                ((p)l0).l(i0);
            }
            else {
                ((p)l0).o0();
            }
            w.x(((p)l0), m0, j.f);
            w.x(((p)l0), i00, j.e);
            h h0 = j.g;
            if(((p)l0).O || !kotlin.jvm.internal.q.b(((p)l0).N(), v2)) {
                A7.d.q(v2, ((p)l0), v2, h0);
            }
            w.x(((p)l0), q1, j.d);
            N1.b(s, null, e0.T(((p)l0), 0x7F060165), 15.0f, null, null, 0L, new l1.k(3), 21.0f, 0, false, 0, 0, null, null, ((p)l0), v1 & 14 | 0xC00, 6, 0x1F9F2);  // color:gray800s
            ((p)l0).p(true);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U0(s, v, 4);
        }
    }

    public static final void t(q q0, boolean z, int v, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0xA0D434A0);
        int v2 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            String s = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((v2 & 0x380) == 0x100 || s == v3) {
                s = v <= -1 ? "" : Cb.k.b(context0, String.valueOf(v));
                p0.l0(s);
            }
            boolean z1 = p0.g(s);
            String s1 = p0.N();
            if((v2 & 0x70) == 0x20 || z1 || s1 == v3) {
                kotlin.jvm.internal.q.f("좋아요, %1$s명", "getString(...)");
                s1 = String.format("좋아요, %1$s명", Arrays.copyOf(new Object[]{s}, 1));
                p0.l0(s1);
            }
            q q1 = X0.n.c(androidx.compose.foundation.q.p(q0), false, S.a.f);
            boolean z2 = p0.g(s1);
            sd.g g0 = p0.N();
            if(z2 || g0 == v3) {
                g0 = new sd.g(s1, 3);
                p0.l0(g0);
            }
            q q2 = X0.n.b(q1, g0);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, j.d);
            q q4 = d.n(n.a, 22.0f);
            androidx.compose.foundation.q.c(De.I.Q((z ? 0x7F08014B : 0x7F080148), p0, 0), null, q4, null, null, 0.0f, new y0.k(e0.T(p0, (z ? 0x7F06017A : 0x7F0604A1)), 5), p0, 0x1B0, 56);  // drawable:btn_common_like_22_on
            N1.b(s, null, A7.d.g(n.a, 4.0f, p0, 0x7F0604A1, p0), 14.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF2);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.h(q0, z, v, v1, 1);
        }
    }

    public static final void u(Boolean boolean0, we.a a0, we.a a1, we.n n0, boolean z, we.a a2, we.a a3, we.n n1, oc.M m0, we.a a4, boolean z1, we.a a5, String s, we.a a6, we.a a7, l l0, int v, int v1) {
        b0 b02;
        x1.m m2;
        x1.j j1;
        p p0 = (p)l0;
        p0.c0(80747203);
        int v2 = (v & 6) == 0 ? (p0.g(boolean0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(a1) ? 0x100 : 0x80);
        }
        int v3 = 0x400;
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        int v4 = 0x2000;
        if((v & 0x6000) == 0) {
            v2 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v2 |= (p0.i(a2) ? 0x20000 : 0x10000);
        }
        if((v & 0x180000) == 0) {
            v2 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((v & 0xC00000) == 0) {
            v2 |= (p0.i(n1) ? 0x800000 : 0x400000);
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.e((m0 == null ? -1 : m0.ordinal())) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v) == 0) {
            v2 |= (p0.i(a4) ? 0x20000000 : 0x10000000);
        }
        int v5 = (v1 & 6) == 0 ? v1 | (p0.h(z1) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v5 |= (p0.i(a5) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v5 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            if(p0.i(a6)) {
                v3 = 0x800;
            }
            v5 |= v3;
        }
        if((v1 & 0x6000) == 0) {
            if(p0.i(a7)) {
                v4 = 0x4000;
            }
            v5 |= v4;
        }
        if(p0.Q(v2 & 1, (v2 & 306783379) != 306783378 || (v5 & 9363) != 9362)) {
            n n2 = n.a;
            q q0 = a.l(d.h(d.f(n2, 1.0f), E9.h.t(p0, 0x7F070408)), 14.0f, 0.0f, 2);  // dimen:player_bottom_controller_height
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            q q2 = d.h(d.f(n2, 1.0f), 60.0f);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q3 = p0.N();
            V v7 = androidx.compose.runtime.k.a;
            if(q3 == v7) {
                q3 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v7) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v7) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            x1.m m1 = p0.N();
            if(m1 == v7) {
                m1 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v7) {
                j1 = j0;
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            else {
                j1 = j0;
            }
            boolean z2 = p0.i(q3);
            boolean z3 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z2 || z3 || g10 == v7) {
                g10 = new g1(b01, q3, m1, 18, b00);
                m2 = m1;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m2 = m1;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v7) {
                h10 = new h1(b02, m2, 18);
                p0.l0(h10);
            }
            boolean z4 = p0.i(q3);
            i1 i10 = p0.N();
            if(z4 || i10 == v7) {
                i10 = new i1(q3, 18);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q2, false, i10), m0.c.e(1200550679, p0, new td.t(b01, j1, h10, boolean0, a0, a1, n0, z, a2, a3, n1, m0, a4)), g10, p0, 0x30);
            p0.p(false);
            q q4 = d.h(d.f(n2, 1.0f), 60.0f);
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, r0.d.k, p0, 0x30);
            int v8 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            w.x(p0, q5, h3);
            e1.x.f(null, z1, a5, p0, v5 << 3 & 0x3F0, 1);
            q q6 = q0.a(n2, 1.0f);
            M m3 = M.p.d(r0.d.a, false);
            int v9 = p0.P;
            i0 i02 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m3, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            w.x(p0, q7, h3);
            if(s == null) {
                p0.a0(0x63FCB79F);
                e1.x.c((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n2, r0.d.e), a6, p0, v5 >> 6 & 0x70);
            }
            else {
                p0.a0(0x63F4F81B);
                q q8 = d.f(n2, 1.0f);
                p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
                int v10 = p0.P;
                i0 i03 = p0.m();
                q q9 = r0.a.d(p0, q8);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p01, h0);
                w.x(p0, i03, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                    A7.d.q(v10, p0, v10, h2);
                }
                w.x(p0, q9, h3);
                c.d(p0, d.q(n2, 20.0f));
                e1.x.d(q0.a(n2, 1.0f), s, a6, p0, v5 >> 3 & 0x3F0);
                c.d(p0, d.q(n2, 20.0f));
                p0.p(true);
            }
            p0.p(false);
            p0.p(true);
            e1.x.u(a7, null, p0, v5 >> 9 & 0x70, 1);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.o(boolean0, a0, a1, n0, z, a2, a3, n1, m0, a4, z1, a5, s, a6, a7, v, v1, 1);
        }
    }

    public static final void v(String s, boolean z, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1244032392);
        int v1 = ((v & 6) == 0 ? v | (p0.g(s) ? 4 : 2) : v) | (p0.h(z) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            q q0 = a.n(n.a, 20.0f, 22.0f, 20.0f, 0.0f, 8);
            n n0 = n.a;
            q q1 = d.f(q0, 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, n0);
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
            w.x(p0, q3, h3);
            yd.h.c(s, p0, v1 & 14);
            c.d(p0, d.h(n0, 12.0f));
            String s1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            kotlin.jvm.internal.q.f(s1, "format(...)");
            N1.b(s1, null, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // color:gray600s_support_high_contrast
            c.d(p0, d.h(n0, 12.0f));
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            kotlin.jvm.internal.q.f((z ? "동의" : "거부"), "getString(...)");
            kotlin.jvm.internal.q.f((z ? "거부" : "동의"), "getString(...)");
            kotlin.jvm.internal.q.f("멜론 광고성 정보 알림 수신에 %1$s하셨습니다.", "getString(...)");
            N1.b(String.format("멜론 광고성 정보 알림 수신에 %1$s하셨습니다.", Arrays.copyOf(new Object[]{(z ? "동의" : "거부")}, 1)), null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, new l1.k(3), 21.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // color:gray800s
            c.d(p0, d.h(n0, 12.0f));
            kotlin.jvm.internal.q.f("(알림 설정 변경 : 설정 > Push 알림 설정 > 광고성 알림 받기 수신 %1$s)", "getString(...)");
            N1.b(String.format("(알림 설정 변경 : 설정 > Push 알림 설정 > 광고성 알림 받기 수신 %1$s)", Arrays.copyOf(new Object[]{(z ? "거부" : "동의")}, 1)), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(3), 19.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // color:gray600s_support_high_contrast
            c.d(p0, d.h(n0, 26.0f));
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new ud.e(v, 1, z, s);
        }
    }

    public static final void w(int v, we.k k0, l l0, int v1) {
        n n2;
        int v11;
        int v10;
        int v9;
        int v8;
        n n1;
        p p0 = (p)l0;
        p0.c0(0x6DF9F526);
        int v2 = (v1 & 6) == 0 ? v1 | (p0.e(v) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(new x0.b(0L));
                p0.l0(b00);
            }
            a0 a00 = p0.N();
            if(a00 == v3) {
                a00 = w.p(v);
                p0.l0(a00);
            }
            int v4 = ((K0)a00).m() / 2;
            int v5 = ((K0)a00).m() % 2;
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(new r1.l(0L));
                p0.l0(b01);
            }
            q q0 = a.n(n.a, 0.0f, 12.0f, 0.0f, 0.0f, 13);
            n n0 = n.a;
            q q1 = d.h(d.f(q0, 1.0f), 44.0f);
            R0 r00 = p0.N();
            if(r00 == v3) {
                r00 = new R0(b01, 29);
                p0.l0(r00);
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, r00);
            vd.q q3 = p0.N();
            if((v2 & 0x70) == 0x20 || q3 == v3) {
                q3 = new vd.q(k0, b00, b01, a00);
                p0.l0(q3);
            }
            q q4 = J0.H.a(q2, H.a, q3);
            p0 p00 = M.n0.a(M.j.e, r0.d.j, p0, 6);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q5 = r0.a.d(p0, q4);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            w.x(p0, q5, j.d);
            p0.a0(0x630DD87D);
            if(1 <= v4) {
                int v7 = 1;
                while(true) {
                    n1 = n0;
                    v8 = v5;
                    v9 = v4;
                    c1.n(d.h(d.q(n0, 46.0f), 44.0f), 0x7F080169, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 438, 0, 0x7FF8);  // drawable:btn_common_rating_fill_46
                    if(v7 == v9) {
                        break;
                    }
                    ++v7;
                    v4 = v9;
                    v5 = v8;
                    n0 = n1;
                }
            }
            else {
                n1 = n0;
                v8 = v5;
                v9 = v4;
            }
            p0.p(false);
            if(v8 == 1) {
                p0.a0(0xFEB24A5C);
                v10 = v9;
                v11 = 1;
                n2 = n1;
                c1.n(d.h(d.q(n1, 46.0f), 44.0f), 0x7F08016A, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 438, 0, 0x7FF8);  // drawable:btn_common_rating_half_46
            }
            else {
                v10 = v9;
                v11 = v8;
                n2 = n1;
                p0.a0(0xFD1D20B8);
            }
            p0.p(false);
            p0.a0(0x630E2E26);
            for(int v12 = 0; v12 < 5 - v10 - v11; ++v12) {
                c1.n(d.h(d.q(n2, 46.0f), 44.0f), 0x7F080168, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 438, 0, 0x7FF8);  // drawable:btn_common_rating_empty_46
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.f(v, k0, v1, 3);
        }
    }

    public static final void x(q q0, oc.M m0, we.a a0, l l0, int v) {
        ((p)l0).c0(0xC39FAE9C);
        int v1 = -1;
        int v2 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).e((m0 == null ? -1 : m0.ordinal())) ? 0x20 : 16) | (((p)l0).i(a0) ? 0x100 : 0x80);
        boolean z = false;
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if(m0 != null) {
                z = true;
            }
            int v3 = 0x7F0801B3;  // drawable:btn_fullplayer_control_replay_off
            if(z) {
                switch((m0 == null ? -1 : td.v.a[m0.ordinal()])) {
                    case 1: {
                        v3 = 0x7F0801B4;  // drawable:btn_fullplayer_control_replay_on
                        break;
                    }
                    case 2: {
                        v3 = 0x7F0801B5;  // drawable:btn_fullplayer_control_replay_one
                    }
                }
            }
            int v4 = 0x7F130C21;  // string:talkback_repeat_none "반복 안 함, 변경"
            if(z) {
                if(m0 != null) {
                    v1 = td.v.a[m0.ordinal()];
                }
                switch(v1) {
                    case 1: {
                        v4 = 0x7F130C20;  // string:talkback_repeat_all "전체 음악 반복중, 변경"
                        break;
                    }
                    case 2: {
                        v4 = 0x7F130C22;  // string:talkback_repeat_one "현재 음악 반복중, 변경"
                    }
                }
            }
            String s = H0.e.Y(((p)l0), v4);
            q q1 = r0.a.a(e0.Q(d.n(q0, E9.h.t(((p)l0), 0x7F070409)), z), new Cd.e(z, a0, 3));  // dimen:player_bottom_default_button_size
            boolean z1 = ((p)l0).g(s);
            boolean z2 = ((p)l0).h(z);
            Ld.x x0 = ((p)l0).N();
            if(z1 || z2 || x0 == androidx.compose.runtime.k.a) {
                x0 = new Ld.x(s, z, 2);
                ((p)l0).l0(x0);
            }
            c1.n(X0.n.b(q1, x0), v3, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x6C00, 0, 0x7FE4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Id.h(q0, m0, a0, v, 28);
        }
    }

    public static final void y(F5 f50, we.k k0, l l0, int v) {
        n n2;
        n n1;
        V v6;
        V v5;
        Object object1;
        String s1;
        p p0 = (p)l0;
        p0.c0(645059628);
        int v1 = (v & 6) == 0 ? v | (p0.i(f50) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q q0 = a.n(n.a, 16.0f, 19.0f, 16.0f, 0.0f, 8);
            n n0 = n.a;
            q q1 = d.f(q0, 1.0f);
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, r0.d.k, p0, 0x30);
            int v2 = p0.P;
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
            w.x(p0, p00, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            kotlin.jvm.internal.q.f("나의 첫 DJ플레이리스트 만들기", "getString(...)");
            long v3 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b("나의 첫 DJ플레이리스트 만들기", new LayoutWeightElement(1.0f, true), v3, 18.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            String s = f50.e;
            Object object0 = f50.g;
            V v4 = androidx.compose.runtime.k.a;
            if(s != null && s.length() != 0) {
                p0.a0(0x4E8C834F);
                boolean z = p0.i(f50);
                t5 t50 = p0.N();
                if((v1 & 0x70) == 0x20 || z || t50 == v4) {
                    t50 = new t5(k0, f50, 0);
                    p0.l0(t50);
                }
                g.h(t50, p0, 0);
                p0.p(false);
                s1 = s;
                object1 = object0;
                v5 = v4;
            }
            else {
                p0.a0(0x4E8FBCED);
                s1 = s;
                object1 = object0;
                v5 = v4;
                c1.n(r0.a.a(a.n(n0, 8.0f, 0.0f, 0.0f, 0.0f, 14), new Ac.l1(24, k0)), 0x7F08011C, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_common_add_22_gr
                p0.p(false);
            }
            p0.p(true);
            if(s1 != null && s1.length() != 0) {
                p0.a0(1289051293);
                q q3 = a.n(n0, 0.0f, 0.0f, 0.0f, 7.0f, 7);
                String s2 = f50.e;
                String s3 = f50.d;
                String s4 = f50.f;
                String s5 = f50.b;
                Object object2 = je.p.m0(((List)object1));
                Object object3 = je.p.n0(1, ((List)object1));
                G2 g20 = G2.a;
                boolean z1 = p0.i(f50);
                t5 t51 = p0.N();
                if((v1 & 0x70) == 0x20 || z1) {
                    v6 = v5;
                    t51 = new t5(k0, f50, 1);
                    p0.l0(t51);
                }
                else {
                    v6 = v5;
                    if(t51 == v6) {
                        t51 = new t5(k0, f50, 1);
                        p0.l0(t51);
                    }
                }
                boolean z2 = p0.i(f50);
                t5 t52 = p0.N();
                if((v1 & 0x70) == 0x20 || z2 || t52 == v6) {
                    t52 = new t5(k0, f50, 2);
                    p0.l0(t52);
                }
                n1 = n0;
                c1.A(false, s2, s3, null, s4, s5, null, null, null, ((ie.m)object2), ((ie.m)object3), q3, g20, null, null, t51, t52, null, p0, 0xC06DB6, 0x1B01B6, 0x4E0000);
            }
            else {
                n1 = n0;
                p0.a0(0x4C37F556);
            }
            p0.p(false);
            if(s1 == null || s1.length() == 0) {
                p0.a0(1290124761);
                q q4 = d.f(a.m(n1, 16.0f, 8.0f, 16.0f, 17.0f), 1.0f);
                p0 p01 = M.n0.a(b0, r0.d.j, p0, 0);
                int v7 = p0.P;
                i0 i01 = p0.m();
                q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p01, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q5, h3);
                g.c(p0, 0);
                kotlin.jvm.internal.q.f("DJ 심사를 위해 플레이리스트를 만들어주세요", "getString(...)");
                N1.b("DJ 심사를 위해 플레이리스트를 만들어주세요", null, e0.T(p0, 0x7F060163), 14.0f, null, null, 0L, null, 18.5f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);  // color:gray700s
                p0.p(true);
            }
            else {
                p0.a0(0x4C37F556);
            }
            p0.p(false);
            n2 = n1;
            e0.C(d.h(d.f(n2, 1.0f), 0.5f), 0L, 0, 0.0f, p0, 6, 30);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new u5(f50, k0, v, 0);
        }
    }

    public static final void z(q q0, Boolean boolean0, we.a a0, l l0, int v) {
        String s;
        ((p)l0).c0(1802082134);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(boolean0) ? 0x20 : 16) | (((p)l0).i(a0) ? 0x100 : 0x80);
        boolean z = true;
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            if(boolean0 == null) {
                z = false;
            }
            int v2 = !z || !kotlin.jvm.internal.q.b(boolean0, Boolean.TRUE) ? 0x7F0801B6 : 0x7F0801B7;  // drawable:btn_fullplayer_control_shuffle_off
            if(z) {
                ((p)l0).a0(0xB4CA7FCC);
                s = kotlin.jvm.internal.q.b(boolean0, Boolean.TRUE) ? l1.h(((p)l0), 0xB4CAF143, 0x7F130C4D, ((p)l0), false) : l1.h(((p)l0), 0xB4CC2382, 0x7F130C4C, ((p)l0), false);  // string:talkback_shuffle_on "셔플 사용중, 변경"
                ((p)l0).p(false);
            }
            else {
                s = l1.h(((p)l0), 0xB4CD6FCA, 0x7F130C4C, ((p)l0), false);  // string:talkback_shuffle_off "셔플 사용 안 함, 변경"
            }
            q q1 = r0.a.a(e0.Q(d.n(q0, E9.h.t(((p)l0), 0x7F070409)), z), new Cd.e(z, a0, 4));  // dimen:player_bottom_default_button_size
            boolean z1 = ((p)l0).g(s);
            boolean z2 = ((p)l0).h(z);
            Ld.x x0 = ((p)l0).N();
            if(z1 || z2 || x0 == androidx.compose.runtime.k.a) {
                x0 = new Ld.x(s, z, 3);
                ((p)l0).l0(x0);
            }
            c1.n(X0.n.b(q1, x0), v2, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x6C00, 0, 0x7FE4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Id.h(q0, boolean0, a0, v, 29);
        }
    }
}

