package df;

import Ac.U2;
import Ac.Y1;
import Cc.G2;
import Cc.G3;
import Cc.N1;
import Cc.P0;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Cc.w3;
import E9.h;
import F.f0;
import Jc.t0;
import M.j0;
import M.p0;
import M.y;
import Me.L;
import O.F;
import P0.i;
import P0.j;
import Q0.C0;
import Q0.N;
import Q0.W0;
import Sf.a;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.android.material.internal.B;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.artistchannel.viewholder.e;
import com.iloen.melon.friend.FriendAddTaskController;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v6x.response.SearchTagBase;
import com.iloen.melon.popup.s;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.SchemeAllowedUrlManager;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import e1.m;
import ed.G0;
import ed.H0;
import ed.I0;
import ed.J0;
import ed.O0;
import ed.v0;
import ed.w0;
import g3.t;
import gd.B2;
import gd.M0;
import gd.S5;
import gd.U5;
import gd.V5;
import gd.W5;
import gd.Y5;
import gd.q2;
import gd.r2;
import gd.u2;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import je.I;
import k3.x;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.q;
import m8.u0;
import o9.b;
import p8.O;
import r0.n;
import r1.c;
import r1.o;
import r1.p;
import s0.f;
import wc.u;
import we.k;
import y0.M;

public abstract class d {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;

    public static boolean A(Throwable throwable0) {
        return false;
    }

    public static final boolean B(L l0) {
        q.g(l0, "<this>");
        return l0.getGetter() == null;
    }

    public abstract void C(Throwable arg1);

    public abstract void D(b arg1);

    public static final ArrayList E(BufferedReader bufferedReader0) {
        ArrayList arrayList0 = new ArrayList();
        try {
            for(Object object0: new a(new W0(bufferedReader0, 8))) {
                q.g(((String)object0), "it");
                arrayList0.add(((String)object0));
            }
        }
        catch(Throwable throwable0) {
            d8.d.l(bufferedReader0, throwable0);
            throw throwable0;
        }
        bufferedReader0.close();
        return arrayList0;
    }

    public static final String F(BufferedReader bufferedReader0) {
        StringWriter stringWriter0 = new StringWriter();
        char[] arr_c = new char[0x2000];
        for(int v = bufferedReader0.read(arr_c); v >= 0; v = bufferedReader0.read(arr_c)) {
            stringWriter0.write(arr_c, 0, v);
        }
        String s = stringWriter0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static final float G(long v, float f, c c0) {
        if(o.a(v, o.c)) {
            return f;
        }
        long v1 = o.b(v);
        if(p.a(v1, 0x100000000L)) {
            return c0.B(v);
        }
        return p.a(v1, 0x200000000L) ? o.c(v) * f : NaNf;
    }

    public static final float H(long v, float f, c c0) {
        long v1 = o.b(v);
        if(p.a(v1, 0x100000000L)) {
            return ((double)c0.W()) > 1.05 ? o.c(v) / o.c(c0.p(f)) * f : c0.B(v);
        }
        return p.a(v1, 0x200000000L) ? o.c(v) * f : NaNf;
    }

    public static final Object I(Set set0, Enum enum0, Enum enum1, Enum enum2, boolean z) {
        Enum enum3;
        if(z) {
            if(set0.contains(enum0)) {
                enum3 = enum0;
            }
            else if(set0.contains(enum1)) {
                enum3 = enum1;
            }
            else {
                enum3 = null;
            }
            if(q.b(enum3, enum0) && q.b(enum2, enum1)) {
                return null;
            }
            return enum2 == null ? enum3 : enum2;
        }
        if(enum2 != null) {
            set0 = je.p.T0(I.L(set0, enum2));
        }
        return je.p.F0(set0);
    }

    public static final void J(Spannable spannable0, long v, int v1, int v2) {
        if(v != 16L) {
            spannable0.setSpan(new ForegroundColorSpan(M.z(v)), v1, v2, 33);
        }
    }

    public static final void K(Spannable spannable0, long v, c c0, int v1, int v2) {
        long v3 = o.b(v);
        if(p.a(v3, 0x100000000L)) {
            spannable0.setSpan(new AbsoluteSizeSpan(ye.a.V(c0.B(v)), false), v1, v2, 33);
            return;
        }
        if(p.a(v3, 0x200000000L)) {
            spannable0.setSpan(new RelativeSizeSpan(o.c(v)), v1, v2, 33);
        }
    }

    public static final void L(Spannable spannable0, h1.b b0, int v, int v1) {
        if(b0 != null) {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, b0));
            for(Object object0: b0.a) {
                arrayList0.add(((h1.a)object0).a);
            }
            Locale[] arr_locale = (Locale[])arrayList0.toArray(new Locale[0]);
            spannable0.setSpan(new LocaleSpan(new LocaleList(((Locale[])Arrays.copyOf(arr_locale, arr_locale.length)))), v, v1, 33);
        }
    }

    public static final void M(Spannable spannable0, Object object0, int v, int v1) {
        spannable0.setSpan(object0, v, v1, 33);
    }

    public static final String N(float f) {
        if(Float.isNaN(f)) {
            return "NaN";
        }
        if(Float.isInfinite(f)) {
            return f < 0.0f ? "-Infinity" : "Infinity";
        }
        int v = (int)(f * 10.0f);
        return String.valueOf(((float)(f * 10.0f - ((float)v) >= 0.5f ? v + 1 : ((int)(f * 10.0f)))) / 10.0f);
    }

    public static final f a(String s) {
        return new f(m.E(s));
    }

    public static final void b(r2 r20, k k0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-1013080954);
        int v1 = (((androidx.compose.runtime.p)l0).g(r20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            String s = r20.d;
            int v2 = r20.e;
            String s1 = r20.f;
            String s2 = r20.b;
            String s3 = r20.c;
            float f = h.t(((androidx.compose.runtime.p)l0), 0x7F0700E3);  // dimen:detail_list_padding_left_right
            r0.q q0 = androidx.compose.foundation.layout.a.l(n.a, f, 0.0f, 2);
            w0 w00 = ((androidx.compose.runtime.p)l0).N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0)) != 0 || w00 == androidx.compose.runtime.k.a) {
                w00 = new w0(6, k0, r20);
                ((androidx.compose.runtime.p)l0).l0(w00);
            }
            e0.q(s, v2, s1, s2, s3, q0, w00, ((androidx.compose.runtime.p)l0), 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new e(r20, k0, v, 18);
        }
    }

    public static final void c(u2 u20, k k0, k k1, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xD0426F66);
        int v1 = v | (p0.i(u20) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = w.i(new M0(f0, 6));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = w.i(new M0(f0, 7));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Boolean boolean1 = (Boolean)e1.getValue();
            boolean1.booleanValue();
            q2 q20 = p0.N();
            if((v1 & 0x380) == 0x100 || q20 == v2) {
                q20 = new q2(k1, e0, e1, null);
                p0.l0(q20);
            }
            J.f(boolean0, boolean1, q20, p0);
            r0.q q0 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.a.n(n.a, 0.0f, 16.0f, 0.0f, 0.0f, 13), 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = p0.i(u20);
            gd.l l1 = p0.N();
            if(z || (v1 & 0x70) == 0x20 || l1 == v2) {
                l1 = new gd.l(10, u20, k0);
                p0.l0(l1);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, l1, p0, 6, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(u20, k0, k1, v, 18);
        }
    }

    public static final void d(B2 b20, k k0, l l0, int v) {
        q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(-1504590202);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 0.0f, 0.0f, 40.0f, 7);
            v.d(b20.a, q0, null, false, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0x30 | v1 << 12 & 0x70000, 12);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 0);
        }
    }

    public static final void e(int v, l l0, List list0, we.a a0, k k0) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x2BF4497E);
        int v1 = v | (p0.i(list0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            F f0 = O.I.a(0, 0, 3, p0);
            boolean z = p0.g(f0);
            U5 u50 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x380) == 0x100 || z || u50 == v2) {
                u50 = new U5(f0, a0, null);
                p0.l0(u50);
            }
            J.d(p0, H.a, u50);
            C0 c00 = N.u(p0);
            n n0 = n.a;
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(n0, c00, null);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            r0.q q2 = androidx.compose.foundation.layout.d.c(n0, 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(list0);
            gd.e e0 = p0.N();
            if((v1 & 0x1C00) == 0x800 || z1 || e0 == v2) {
                e0 = new gd.e(list0, 7, k0);
                p0.l0(e0);
            }
            c1.o(q2, f0, j00, false, null, null, null, false, e0, p0, 0, 0xF8);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s(list0, a0, k0, v);
        }
    }

    public static final void f(W5 w50, k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xADA0380F);
        int v1 = (p0.i(w50) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        boolean z = false;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            long v2 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.q.f(n.a, v2, M.a), 0.0f, 25.0f, 0.0f, 12.0f, 5);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            List list0 = w50.b;
            int v4 = w50.a;
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            Y1 y10 = p0.N();
            if(z || y10 == androidx.compose.runtime.k.a) {
                y10 = new Y1(8, k0);
                p0.l0(y10);
            }
            w3.d(list0, v4, 0.0f, y10, p0, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new e(w50, k0, v, 27);
        }
    }

    public static final void g(V5 v50, int v, k k0, l l0, int v1) {
        k k1;
        boolean z2;
        ie.m m2;
        ie.m m1;
        ((androidx.compose.runtime.p)l0).c0(0xA8BDD3F0);
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(v50) ? 4 : 2) | v1 : v1;
        if((v1 & 0x180) == 0) {
            v2 |= (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x83) != 130)) {
            boolean z = v50.a;
            String s = v50.c;
            String s1 = v50.d;
            String s2 = v50.e;
            String s3 = v50.k;
            String s4 = v50.b;
            String s5 = v50.f;
            String s6 = v50.g;
            boolean z1 = true;
            String s7 = v50.m;
            Y5 y50 = v50.h;
            ie.m m0 = null;
            if(y50 == null) {
                m1 = null;
            }
            else {
                String s8 = y50.a;
                if(s8 == null) {
                    m1 = null;
                }
                else {
                    String s9 = y50.b;
                    m1 = s9 == null ? null : new ie.m(s8, s9);
                }
            }
            Y5 y51 = v50.i;
            if(y51 == null) {
                m2 = m1;
            }
            else {
                String s10 = y51.a;
                if(s10 == null) {
                    m2 = m1;
                }
                else {
                    String s11 = y51.b;
                    if(s11 == null) {
                        m2 = m1;
                    }
                    else {
                        m2 = m1;
                        m0 = new ie.m(s10, s11);
                    }
                }
            }
            G2 g20 = G2.a;
            Y1 y10 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if((v2 & 0x380) == 0x100 || y10 == v3) {
                z2 = z;
                y10 = new Y1(7, k0);
                ((androidx.compose.runtime.p)l0).l0(y10);
            }
            else {
                z2 = z;
            }
            boolean z3 = ((androidx.compose.runtime.p)l0).i(v50);
            S5 s50 = ((androidx.compose.runtime.p)l0).N();
            if((v2 & 0x380) == 0x100 || z3 || s50 == v3) {
                k1 = y10;
                s50 = new S5(k0, v50, 0);
                ((androidx.compose.runtime.p)l0).l0(s50);
            }
            else {
                k1 = y10;
            }
            boolean z4 = ((androidx.compose.runtime.p)l0).i(v50);
            S5 s51 = ((androidx.compose.runtime.p)l0).N();
            if((v2 & 0x380) == 0x100 || z4 || s51 == v3) {
                s51 = new S5(k0, v50, 1);
                ((androidx.compose.runtime.p)l0).l0(s51);
            }
            boolean z5 = ((androidx.compose.runtime.p)l0).i(v50);
            S5 s52 = ((androidx.compose.runtime.p)l0).N();
            if((v2 & 0x380) == 0x100 || z5 || s52 == v3) {
                s52 = new S5(k0, v50, 2);
                ((androidx.compose.runtime.p)l0).l0(s52);
            }
            boolean z6 = ((androidx.compose.runtime.p)l0).i(v50);
            if((v2 & 0x380) != 0x100) {
                z1 = false;
            }
            S5 s53 = ((androidx.compose.runtime.p)l0).N();
            if(z6 || z1 || s53 == v3) {
                s53 = new S5(v50, k0);
                ((androidx.compose.runtime.p)l0).l0(s53);
            }
            c1.A(z2, s4, s, s1, s2, s5, s6, s3, s7, m2, m0, null, g20, k1, s50, s51, s52, s53, ((androidx.compose.runtime.p)l0), 0x6D80, 0x180000, 0x48000);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(v50, v, k0, v1, 18);
        }
    }

    public static final void h(SearchTagBase searchTagBase0, int v, int v1, U2 u20, v0 v00, we.o o0, l l0, int v2) {
        V v9;
        long v8;
        String s1;
        r0.q q2;
        V v7;
        String s;
        q.g(o0, "addImpressionLog");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1048128332);
        int v3 = v2 | (p0.i(searchTagBase0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.e(v1) ? 0x100 : 0x80) | (p0.i(u20) ? 0x800 : 0x400) | (p0.i(v00) ? 0x4000 : 0x2000) | (p0.i(o0) ? 0x20000 : 0x10000);
        if(p0.Q(v3 & 1, (74899 & v3) != 74898)) {
            K.m m0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(m0 == v4) {
                m0 = androidx.appcompat.app.o.d(p0);
            }
            b0 b00 = ye.a.u(m0, p0, 6);
            b1 b10 = f0.b((((Boolean)b00.getValue()).booleanValue() ? A7.d.f(p0, 0x169CD3BE, 0x7F06017A, p0, false) : A7.d.f(p0, 379469202, 0x7F06048A, p0, false)), null, "", p0, 10);  // color:green500e_support_high_contrast
            y0.E e0 = u.e(e.k.A(new y0.s[]{new y0.s(e0.T(p0, 0x7F06017A)), new y0.s(e0.T(p0, 0x7F060177))}), 0.0f, 0.0f, 14);  // color:green500e_support_high_contrast
            y0.E e1 = u.e(e.k.A(new y0.s[]{new y0.s(e0.T(p0, 0x7F060458)), new y0.s(e0.T(p0, 0x7F06047B))}), 0.0f, 0.0f, 14);  // color:purple500e
            if(!q.b(searchTagBase0.tagType, "ARTIST") || (searchTagBase0.artistImagePath == null || searchTagBase0.artistImagePath.length() == 0)) {
                s = !q.b(searchTagBase0.tagType, "PROMOTION") || (searchTagBase0.promotionImagePath == null || searchTagBase0.promotionImagePath.length() == 0) ? null : searchTagBase0.promotionImagePath;
            }
            else {
                s = searchTagBase0.artistImagePath;
            }
            boolean z = q.b(searchTagBase0.promotionYn, "Y");
            boolean z1 = q.b(searchTagBase0.priorityYn, "Y");
            int v5 = z | z1;
            long v6 = e0.T(p0, 0x7F060140);  // color:gray001e_support_high_contrast
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.v(n.a, null, 3), 3.0f, 0.0f, 3.0f, 9.0f, 2), 46.0f);
            r0.q q1 = d5.n.o(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014F), q0, T.e.b(23.0f)), T.e.b(23.0f));  // color:gray150a
            boolean z2 = p0.i(searchTagBase0);
            t0 t00 = p0.N();
            if((z2 | (v3 & 0x1C00) == 0x800 | ((v3 & 0x380) == 0x100 ? 1 : 0) | ((0xE000 & v3) == 0x4000 ? 1 : 0)) == 0) {
                v7 = v4;
                if(t00 == v7) {
                    goto label_34;
                }
                else {
                    q2 = q1;
                    s1 = s;
                    v8 = v6;
                    v9 = v7;
                }
            }
            else {
                v7 = v4;
            label_34:
                q2 = q1;
                s1 = s;
                v8 = v6;
                v9 = v7;
                t0 t01 = new t0(u20, searchTagBase0, v1, v00, 6);
                p0.l0(t01);
                t00 = t01;
            }
            r0.q q3 = androidx.compose.foundation.q.m(q2, m0, null, false, null, t00, 28);
            boolean z3 = p0.h(z);
            boolean z4 = p0.g(e1);
            boolean z5 = p0.h(z1);
            boolean z6 = p0.g(e0);
            boolean z7 = p0.f(v8);
            boolean z8 = p0.g(b00);
            boolean z9 = p0.g(b10);
            G0 g00 = p0.N();
            if((z3 | z4 | z5 | z6 | z7 | z8 | z9) != 0 || g00 == v9) {
                g00 = new G0(z, e1, z1, e0, v8, b00, b10);
                p0.l0(g00);
            }
            r0.q q4 = androidx.compose.ui.draw.a.a(q3, g00);
            boolean z10 = p0.i(searchTagBase0);
            P0 p00 = p0.N();
            if((z10 | (v3 & 0x70000) == 0x20000 | ((v3 & 0x380) == 0x100 ? 1 : 0)) != 0 || p00 == v9) {
                p00 = new P0(searchTagBase0, o0, v1, 10);
                p0.l0(p00);
            }
            r0.q q5 = m3.b(q4, p00);
            boolean z11 = p0.i(searchTagBase0);
            H0 h00 = p0.N();
            if(z11 || h00 == v9) {
                h00 = new H0(searchTagBase0, 0);
                p0.l0(h00);
            }
            r0.q q6 = X0.n.b(q5, h00);
            N0.M m1 = M.p.d(r0.d.e, false);
            int v10 = p0.P;
            i0 i00 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h0);
            }
            w.x(p0, q7, j.d);
            if(s1 == null || s1.length() == 0) {
                p0.a0(0x33B4AF37);
                boolean z13 = p0.g(b00);
                U8.F f1 = p0.N();
                if(z13 || f1 == v9) {
                    f1 = new U8.F(b00, 6);
                    p0.l0(f1);
                }
                d.j(searchTagBase0, v, ((boolean)v5), f1, p0, v3 & 0x7E);
            }
            else {
                p0.a0(867620525);
                boolean z12 = p0.g(b00);
                U8.F f0 = p0.N();
                if(z12 || f0 == v9) {
                    f0 = new U8.F(b00, 7);
                    p0.l0(f0);
                }
                d.i(searchTagBase0, v, s1, ((boolean)v5), f0, p0, v3 & 0x7E);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(searchTagBase0, v, v1, u20, v00, o0, v2);
        }
    }

    public static final void i(SearchTagBase searchTagBase0, int v, String s, boolean z, we.a a0, l l0, int v1) {
        int v5;
        int v4;
        q.g(s, "imagePath");
        q.g(a0, "isPressed");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1953769608);
        int v2 = v1 | (p0.i(searchTagBase0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.g(s) ? 0x100 : 0x80) | (p0.h(z) ? 0x800 : 0x400) | (p0.i(a0) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.s(androidx.compose.foundation.layout.d.u(n0, 3), 0.0f, e0.Z(p0, v), 1), 6.0f, 0.0f, 13.0f, 0.0f, 10);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            r0.q q2 = d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 36.0f), 36.0f), T.e.a);
            c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q2, T.e.b(36.0f)), e0.T(p0, 0x7F060145), M.a), s, null, null, false, 0x7F08079A, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 >> 3 & 0x70 | 0x30000, 0, 0x7FDC);  // color:gray100a
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 5.0f));
            String s1 = searchTagBase0.disPlayKeyword;
            q.f(s1, "disPlayKeyword");
            if(z) {
                v4 = -1306742930;
                v5 = 0x7F0604A1;  // color:white000e
            }
            else {
                v4 = -1306741365;
                v5 = 0x7F06016D;  // color:gray900s
            }
            long v6 = A7.d.f(p0, v4, v5, p0, false);
            N1.b(s1, e2.a.r(n0, (((Boolean)a0.invoke()).booleanValue() ? 0.5f : 1.0f)), v6, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.c(searchTagBase0, v, s, z, a0, v1, 5);
        }
    }

    public static final void j(SearchTagBase searchTagBase0, int v, boolean z, we.a a0, l l0, int v1) {
        int v5;
        int v4;
        q.g(a0, "isPressed");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1248660650);
        int v2 = v1 | (p0.i(searchTagBase0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.m(androidx.compose.foundation.layout.d.s(androidx.compose.foundation.layout.d.u(n0, 3), 0.0f, e0.Z(p0, v), 1), 18.0f, 10.0f, 18.0f, 10.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            String s = searchTagBase0.disPlayKeyword;
            q.f(s, "disPlayKeyword");
            if(z) {
                v4 = 0x7F6CB9EE;
                v5 = 0x7F0604A1;  // color:white000e
            }
            else {
                v4 = 0x7F6CBFED;
                v5 = 0x7F06016D;  // color:gray900s
            }
            long v6 = A7.d.f(p0, v4, v5, p0, false);
            N1.b(s, e2.a.r(n0, (((Boolean)a0.invoke()).booleanValue() ? 0.5f : 1.0f)), v6, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Rc.c(searchTagBase0, v, z, a0, v1);
        }
    }

    public static final void k(SearchTagBase searchTagBase0, int v, int v1, U2 u20, k k0, v0 v00, l l0, int v2) {
        y0.k k2;
        String s1;
        long v12;
        boolean z5;
        int v10;
        int v9;
        int v8;
        int v7;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xB5230A8);
        int v3 = v2 | (p0.i(searchTagBase0) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.e(v1) ? 0x100 : 0x80) | (p0.i(u20) ? 0x800 : 0x400) | (p0.i(k0) ? 0x4000 : 0x2000) | (p0.i(v00) ? 0x20000 : 0x10000);
        if(p0.Q(v3 & 1, (74899 & v3) != 74898)) {
            K.m m0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(m0 == v4) {
                m0 = androidx.appcompat.app.o.d(p0);
            }
            b0 b00 = ye.a.u(m0, p0, 6);
            boolean z = q.b((searchTagBase0 == null ? null : searchTagBase0.promotionYn), "Y");
            y0.E e0 = u.e(e.k.A(new y0.s[]{new y0.s(e0.T(p0, 0x7F060458)), new y0.s(e0.T(p0, 0x7F06047B))}), 0.0f, 0.0f, 14);  // color:purple500e
            b1 b10 = G.j.b((((Boolean)b00.getValue()).booleanValue() ? 1.0f : 0.0f), null, "", null, p0, 0xC00, 22);
            long v5 = e0.T(p0, 0x7F06017A);  // color:green500e_support_high_contrast
            String s = searchTagBase0 == null ? null : searchTagBase0.landingUrl;
            int v6 = s == null || s.length() == 0 ? 1 : 0;
            if(v6 == 0) {
                v7 = 14;
                v8 = 16;
            }
            else {
                v8 = 18;
                v7 = 18;
            }
            n n0 = n.a;
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.s(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 3.0f, 9.0f, 2), 46.0f), 0.0f, e0.Z(p0, v), 1), null, 3), T.e.b(23.0f));
            if(z) {
                v9 = 0x7F896190;
                v10 = 0x7F06047B;  // color:sky500e
            }
            else {
                v9 = 0x7F896778;
                v10 = 0x7F06017D;  // color:green501s
            }
            r0.q q1 = androidx.compose.foundation.q.i(0.5f, A7.d.f(p0, v9, v10, p0, false), q0, T.e.b(23.0f));
            boolean z1 = p0.h(z);
            boolean z2 = p0.g(e0);
            boolean z3 = p0.g(b10);
            boolean z4 = p0.f(v5);
            I0 i00 = p0.N();
            if((z1 | z2 | z3 | z4) != 0 || i00 == v4) {
                i00 = new I0(z, e0, v5, b10);
                z5 = z;
                p0.l0(i00);
            }
            else {
                z5 = z;
            }
            r0.q q2 = androidx.compose.foundation.layout.a.n(androidx.compose.ui.draw.a.a(q1, i00), ((float)v8), 0.0f, ((float)v7), 0.0f, 10);
            boolean z6 = p0.h(((boolean)(v6 ^ 1)));
            boolean z7 = p0.i(searchTagBase0);
            J0 j00 = p0.N();
            if((((v3 & 0x70000) == 0x20000 ? 1 : 0) | (z6 | (0xE000 & v3) == 0x4000 | z7 | ((v3 & 0x1C00) == 0x800 ? 1 : 0) | ((v3 & 0x380) == 0x100 ? 1 : 0))) != 0 || j00 == v4) {
                J0 j01 = new J0(((boolean)(v6 ^ 1)), k0, searchTagBase0, u20, v1, v00);
                p0.l0(j01);
                j00 = j01;
            }
            r0.q q3 = androidx.compose.foundation.q.m(q2, m0, null, false, null, j00, 28);
            boolean z8 = p0.i(searchTagBase0);
            H0 h00 = p0.N();
            if(z8 || h00 == v4) {
                h00 = new H0(searchTagBase0, 1);
                p0.l0(h00);
            }
            r0.q q4 = X0.n.b(q3, h00);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v11 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i01, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h0);
            }
            w.x(p0, q5, j.d);
            if(((Boolean)b00.getValue()).booleanValue()) {
                v12 = A7.d.f(p0, -19945060, 0x7F0604A1, p0, false);  // color:white000e
            }
            else {
                p0.a0(-19871001);
                v12 = z5 ? A7.d.f(p0, -970471444, 0x7F06047B, p0, false) : A7.d.f(p0, -970469948, 0x7F06017A, p0, false);  // color:sky500e
                p0.p(false);
            }
            if(searchTagBase0 == null) {
                s1 = "";
            }
            else {
                s1 = searchTagBase0.disPlayKeyword;
                if(s1 == null) {
                    s1 = "";
                }
            }
            N1.b(s1, e2.a.r(new LayoutWeightElement(1.0f, false), (((Boolean)b00.getValue()).booleanValue() ? 0.5f : 1.0f)), v12, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            if(v6 == 0) {
                p0.a0(0xFED897BD);
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
                if(z5) {
                    p0.a0(-970452078);
                    y0.k k1 = new y0.k(e0.T(p0, 0x7F06047B), 5);  // color:sky500e
                    p0.p(false);
                    k2 = k1;
                }
                else {
                    p0.a0(-19193063);
                    p0.p(false);
                    k2 = null;
                }
                c1.n(androidx.compose.foundation.layout.d.n(n0, 12.0f), 0x7F0800A0, null, null, false, 0, null, null, null, 0.0f, k2, 0, 0, false, false, p0, 0x6036, 0, 0x7BEC);  // drawable:arrow_search_tag
            }
            else {
                p0.a0(-34770562);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(searchTagBase0, v, v1, u20, k0, v00, v2);
        }
    }

    public static final void l(r0.q q0, O0 o00, k k0, l l0, int v) {
        r0.q q1;
        float f1;
        float f;
        q.g(q0, "modifier");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x2D3DCFA0);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.g(o00) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v2 = o00.b == null || o00.b.length() == 0 ? 1 : 0;
            Point point0 = ScreenUtils.getScreenSize(context0);
            int v3 = ScreenUtils.dipToPixel(context0, 149.0f);
            Resources resources0 = context0.getResources();
            f = v2 == 0 ? ((float)(point0.x - resources0.getDimensionPixelSize(0x7F070421) * 2 - resources0.getDimensionPixelSize(0x7F07041E))) : ((float)(point0.x - resources0.getDimensionPixelSize(0x7F070421) * 2)) - resources0.getDimension(0x7F07041D);  // dimen:search_tag_page_pading
            f1 = resources0.getDimension(0x7F07041F);  // dimen:search_depth_item_except_outside_container_size
            int v4 = (int)(f - f1);
            if(v4 < v3) {
                v3 = v4;
            }
            boolean z = o00.c;
            K.m m0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(m0 == v5) {
                m0 = androidx.appcompat.app.o.d(p0);
            }
            b0 b00 = ye.a.u(m0, p0, 6);
            n n0 = n.a;
            if(z) {
                p0.a0(-720850810);
                q1 = androidx.compose.foundation.q.e(n0, u.e(e.k.A(new y0.s[]{new y0.s(e0.T(p0, 0x7F060458)), new y0.s(e0.T(p0, 0x7F06047B))}), 0.0f, 0.0f, 14), null, 6);  // color:purple500e
            }
            else {
                p0.a0(-720843110);
                q1 = androidx.compose.foundation.q.f(n0, e0.T(p0, 0x7F06017A), M.a);  // color:green500e_support_high_contrast
            }
            p0.p(false);
            r0.q q2 = androidx.compose.foundation.layout.a.n(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(q0, null, 3), 46.0f), T.e.b(23.0f)).then(q1), 18.0f, 0.0f, (v2 == 0 ? 16.0f : 18.0f), 0.0f, 10);
            w0 w00 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 0x380) == 0x100 ? 1 : 0)) != 0 || w00 == v5) {
                w00 = new w0(2, k0, o00);
                p0.l0(w00);
            }
            r0.q q3 = androidx.compose.foundation.q.m(q2, m0, null, false, null, w00, 28);
            boolean z1 = p0.h(((boolean)(v2 ^ 1)));
            Qc.s s0 = p0.N();
            if((v1 & 0x70) == 0x20 || z1 || s0 == v5) {
                s0 = new Qc.s(((boolean)(v2 ^ 1)), o00, 7);
                p0.l0(s0);
            }
            r0.q q4 = X0.n.b(q3, s0);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            P0.k.y.getClass();
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            w.x(p0, q5, j.d);
            long v7 = e0.T(p0, 0x7F0604A1);  // color:white000e
            e1.y y0 = e1.y.i;
            r0.q q6 = androidx.compose.foundation.layout.d.s(new LayoutWeightElement(1.0f, false), 0.0f, e0.Z(p0, v3), 1);
            N1.b(String.valueOf(o00.a), e2.a.r(q6, (((Boolean)b00.getValue()).booleanValue() ? 0.5f : 1.0f)), v7, 14.0f, y0, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);
            if(v2 == 0) {
                p0.a0(-1027635014);
                String s1 = l1.s(n0, 4.0f, p0, 0x7F130908, p0);  // string:search_tag_shortcut "바로가기"
                long v8 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(s1, e2.a.r(n0, (((Boolean)b00.getValue()).booleanValue() ? 0.5f : 1.0f)), v8, 12.0f, y0, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C00, 0xC00, 0x1DFD0);
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
                c1.n(e2.a.r(androidx.compose.foundation.layout.d.n(n0, 12.0f), (((Boolean)b00.getValue()).booleanValue() ? 0.5f : 1.0f)), 0x7F080837, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:selector_search_tag_shortcut_src
            }
            else {
                p0.a0(0xC2209006);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(q0, o00, k0, v, 12);
        }
    }

    public static void m(Bundle bundle0, String s) {
        if(!bundle0.containsKey(s)) {
            throw new IllegalArgumentException("Bundle must contain " + s);
        }
    }

    public static void n(Activity activity0, Uri uri0) {
        if(activity0 != null) {
            String s = uri0.getPath();
            if(s != null && s.hashCode() == 0 && s.equals("")) {
                String s1 = uri0.getQueryParameter("mode");
                String s2 = uri0.getQueryParameter("mkey");
                String s3 = uri0.getQueryParameter("fkey");
                m8.j j0 = new m8.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.i1(uri0);
                O.a(new PvLogDummyReq(activity0, "mymusicFriendInviteConfirm"));
                if(s1 != null && !"F".equals(s1)) {
                    if(!((va.e0)va.o.a()).m()) {
                        Navigator.openLoginView(j0.c1());
                        return;
                    }
                    FriendAddTaskController friendAddTaskController0 = new FriendAddTaskController();
                    friendAddTaskController0.setOnResultListener(new m8.i());  // 初始化器: Ljava/lang/Object;-><init>()V
                    friendAddTaskController0.request(s2, s3, s1);
                }
            }
        }
    }

    public static boolean o(Activity activity0, Uri uri0, boolean z) {
        if(activity0 != null) {
            String s = uri0.getPath();
            if(s != null && s.hashCode() == 0 && s.equals("")) {
                String s1 = uri0.getQueryParameter("url");
                String s2 = uri0.getQueryParameter("type");
                String s3 = uri0.getQueryParameter("close");
                String s4 = uri0.getQueryParameter("method");
                NameValuePairList nameValuePairList0 = NetUtils.INSTANCE.getWebViewParamList(uri0);
                if(s1 != null) {
                    m8.v0 v00 = new m8.v0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(z) {
                        SchemeAllowedUrlManager schemeAllowedUrlManager0 = SchemeAllowedUrlManager.getInstance();
                        schemeAllowedUrlManager0.updateAllowedUrl(new u0(schemeAllowedUrlManager0, s1, activity0, v00, s2, s3, s4, nameValuePairList0));
                        return true;
                    }
                    m8.v0.r1(activity0, s1, s2, s3, s4, nameValuePairList0);
                }
                return true;
            }
        }
        return false;
    }

    public static byte[] p(g3.f f0, String s, byte[] arr_b, Map map0) {
        g3.j j2;
        byte[] arr_b1;
        g3.h h0;
        g3.w w0 = new g3.w(f0);
        Uri uri0 = Uri.parse(s);
        e3.b.l(uri0, "The uri must be set.");
        g3.j j0 = new g3.j(uri0, 2, arr_b, map0, 0L, -1L, null, 1);
        g3.j j1 = j0;
        int v = 0;
        while(true) {
            try {
            label_6:
                h0 = new g3.h(w0, j1);
            }
            catch(Exception exception0) {
                break;
            }
            try {
                try {
                    arr_b1 = J6.b.b(h0);
                    goto label_31;
                }
                catch(t unused_ex) {
                }
                String s1 = null;
                if((t0.d == 307 || t0.d == 308) && v < 5) {
                    Map map1 = t0.e;
                    if(map1 != null) {
                        List list0 = (List)map1.get("Location");
                        if(list0 != null && !list0.isEmpty()) {
                            s1 = (String)list0.get(0);
                        }
                    }
                }
                if(s1 == null) {
                    throw t0;
                }
                ++v;
                g3.i i0 = j1.a();
                Uri uri1 = Uri.parse(s1);
                i0.e = uri1;
                e3.b.l(uri1, "The uri must be set.");
                j2 = new g3.j(((Uri)i0.e), i0.a, ((byte[])i0.f), ((Map)i0.g), i0.b, i0.d, ((String)i0.h), i0.c);
            }
            catch(Throwable throwable0) {
                goto label_29;
            }
            try {
                h0.close();
            }
            catch(IOException unused_ex) {
            }
            catch(Exception exception0) {
                break;
            }
            j1 = j2;
            goto label_6;
            try {
                try {
                label_29:
                    h0.close();
                }
                catch(IOException unused_ex) {
                }
                throw throwable0;
                try {
                label_31:
                    h0.close();
                }
                catch(IOException unused_ex) {
                }
                return arr_b1;
            }
            catch(Exception exception0) {
                break;
            }
        }
        Uri uri2 = w0.c;
        uri2.getClass();
        throw new x(j0, uri2, w0.a.getResponseHeaders(), w0.b, exception0);
    }

    public static long q(int v, int v1, int v2, int v3) {
        int v4 = 0x3FFFE;
        int v5 = Math.min(v2, 0x3FFFE);
        int v6 = 0x7FFFFFFF;
        int v7 = v3 == 0x7FFFFFFF ? 0x7FFFFFFF : Math.min(v3, 0x3FFFE);
        int v8 = v7 == 0x7FFFFFFF ? v5 : v7;
        if(v8 >= 0x1FFF) {
            if(v8 < 0x7FFF) {
                v4 = 0xFFFE;
            }
            else if(v8 < 0xFFFF) {
                v4 = 0x7FFE;
            }
            else {
                if(v8 < 0x3FFFF) {
                    v4 = 0x1FFE;
                    goto label_17;
                }
                r1.b.k(v8);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    label_17:
        if(v1 != 0x7FFFFFFF) {
            v6 = Math.min(v4, v1);
        }
        return r1.b.a(Math.min(v4, v), v6, v5, v7);
    }

    public static long r(int v, int v1, int v2, int v3) {
        int v4 = 0x3FFFE;
        int v5 = Math.min(v, 0x3FFFE);
        int v6 = 0x7FFFFFFF;
        int v7 = v1 == 0x7FFFFFFF ? 0x7FFFFFFF : Math.min(v1, 0x3FFFE);
        int v8 = v7 == 0x7FFFFFFF ? v5 : v7;
        if(v8 >= 0x1FFF) {
            if(v8 < 0x7FFF) {
                v4 = 0xFFFE;
            }
            else if(v8 < 0xFFFF) {
                v4 = 0x7FFE;
            }
            else {
                if(v8 < 0x3FFFF) {
                    v4 = 0x1FFE;
                    goto label_17;
                }
                r1.b.k(v8);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    label_17:
        if(v3 != 0x7FFFFFFF) {
            v6 = Math.min(v4, v3);
        }
        return r1.b.a(v5, v7, Math.min(v4, v2), v6);
    }

    public static final De.d s(Annotation annotation0) {
        q.g(annotation0, "<this>");
        Class class0 = annotation0.annotationType();
        q.f(class0, "annotationType(...)");
        return d.y(class0);
    }

    public static final String[] t(s0.o o0) {
        q.e(o0, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidContentType");
        return (String[])((f)o0).b.toArray(new String[0]);
    }

    public static Rect u(Context context0, int v, int v1) {
        TypedArray typedArray0 = B.m(context0, null, d6.a.y, v, v1, new int[0]);
        int v2 = typedArray0.getDimensionPixelSize(2, context0.getResources().getDimensionPixelSize(0x7F070329));  // dimen:mtrl_alert_dialog_background_inset_start
        int v3 = typedArray0.getDimensionPixelSize(3, context0.getResources().getDimensionPixelSize(0x7F07032A));  // dimen:mtrl_alert_dialog_background_inset_top
        int v4 = typedArray0.getDimensionPixelSize(1, context0.getResources().getDimensionPixelSize(0x7F070328));  // dimen:mtrl_alert_dialog_background_inset_end
        int v5 = typedArray0.getDimensionPixelSize(0, context0.getResources().getDimensionPixelSize(0x7F070327));  // dimen:mtrl_alert_dialog_background_inset_bottom
        typedArray0.recycle();
        if(context0.getResources().getConfiguration().getLayoutDirection() == 1) {
            int v6 = v4;
            v4 = v2;
            v2 = v6;
        }
        return new Rect(v2, v3, v4, v5);
    }

    public static final Class v(De.d d0) {
        q.g(d0, "<this>");
        Class class0 = ((g)d0).c();
        q.e(class0, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return class0;
    }

    public static final Class w(De.d d0) {
        q.g(d0, "<this>");
        Class class0 = ((g)d0).c();
        if(!class0.isPrimitive()) {
            return class0;
        }
        switch(class0.getName()) {
            case "boolean": {
                return Boolean.class;
            }
            case "byte": {
                return Byte.class;
            }
            case "char": {
                return Character.class;
            }
            case "double": {
                return Double.class;
            }
            case "float": {
                return Float.class;
            }
            case "int": {
                return Integer.class;
            }
            case "long": {
                return Long.class;
            }
            case "short": {
                return Short.class;
            }
            case "void": {
                return Void.class;
            }
            default: {
                return class0;
            }
        }
    }

    public static final Class x(De.d d0) {
        q.g(d0, "<this>");
        Class class0 = ((g)d0).c();
        if(class0.isPrimitive()) {
            return class0;
        }
        switch(class0.getName()) {
            case "java.lang.Boolean": {
                return Boolean.TYPE;
            }
            case "java.lang.Byte": {
                return Byte.TYPE;
            }
            case "java.lang.Character": {
                return Character.TYPE;
            }
            case "java.lang.Double": {
                return Double.TYPE;
            }
            case "java.lang.Float": {
                return Float.TYPE;
            }
            case "java.lang.Integer": {
                return Integer.TYPE;
            }
            case "java.lang.Long": {
                return Long.TYPE;
            }
            case "java.lang.Short": {
                return Short.TYPE;
            }
            case "java.lang.Void": {
                return Void.TYPE;
            }
            default: {
                return null;
            }
        }
    }

    public static final De.d y(Class class0) {
        q.g(class0, "<this>");
        return kotlin.jvm.internal.I.a.b(class0);
    }

    public static boolean z(Throwable throwable0) {
        return false;
    }
}

