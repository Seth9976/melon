package e1;

import Ac.X2;
import Cc.N1;
import Cc.N3;
import Cc.P3;
import Cc.R3;
import Cc.c1;
import Cc.e0;
import Cc.w3;
import Ce.f;
import Hd.F0;
import M.j0;
import M.j;
import M.q0;
import M.w;
import M.y;
import N0.M;
import O.F;
import O.I;
import P0.h;
import P0.i;
import Q0.C0;
import Q0.N;
import Q0.k0;
import T.e;
import Vb.p0;
import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.content.Context;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidFontLoader;
import androidx.lifecycle.K;
import com.iloen.melon.net.mcp.TrackBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.track.Event;
import com.melon.playlist.interfaces.PlayableData;
import df.v;
import ed.D;
import ed.s;
import ed.w0;
import f0.J;
import gd.B2;
import gd.G4;
import gd.I4;
import gd.J0;
import gd.J4;
import gd.K0;
import gd.K4;
import gd.L0;
import gd.M0;
import gd.O0;
import gd.P0;
import gd.o;
import gd.x;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m8.Q;
import m8.S;
import od.a;
import q8.d;
import r0.g;
import r0.n;
import r1.k;
import x0.c;

public abstract class m {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static TypedValue A(Context context0, int v, String s) {
        TypedValue typedValue0 = m.y(context0, v);
        if(typedValue0 == null) {
            throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", s, context0.getResources().getResourceName(v)));
        }
        return typedValue0;
    }

    public static final k B(c c0) {
        return new k(Math.round(c0.a), Math.round(c0.b), Math.round(c0.c), Math.round(c0.d));
    }

    public static final void C(J j0, int v, Object object0) {
        j0.k[j0.l - j0.g[j0.h - 1].c + v] = object0;
    }

    public static final void D(J j0, int v, Object object0, int v1, Object object1) {
        int v2 = j0.l - j0.g[j0.h - 1].c;
        Object[] arr_object = j0.k;
        arr_object[v + v2] = object0;
        arr_object[v2 + v1] = object1;
    }

    public static Set E(Object object0) [...] // Inlined contents

    public static final Event F(we.k k0) {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        k0.invoke(d0);
        return (Event)d0.p();
    }

    public static final String G(a a0) {
        q.g(a0, "<this>");
        switch(a0.ordinal()) {
            case 0: {
                return "1000003216";
            }
            case 1: {
                return "1000003217";
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final void a(gd.k k0, r0.q q0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x661DDD05);
        int v1 = v | (p0.g(k0) ? 4 : 2) | (p0.g(q0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            n n0 = n.a;
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
            r0.q q3 = androidx.compose.foundation.layout.a.d(1.0f, e0.L(n0, 0x7F06014A), false);  // color:gray100a
            w3.h(k0.a, q3, null, p0, 0, 4);
            r0.q q4 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 4.0f, 0.0f, 9), 24.0f);
            c1.n(r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.c), new D(2, a0)), 0x7F080309, "재생", null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FF8);  // drawable:common_btn_play_01
            p0.p(true);
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b((k0.b == null ? "" : k0.b), androidx.compose.foundation.layout.a.n(n0, 0.0f, 9.0f, 0.0f, 0.0f, 13), v4, 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 2, null, null, p0, 0xC30, 27702, 0x193F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(k0, q0, a0, v, 13);
        }
    }

    public static final void b(x x0, int v, we.k k0, l l0, int v1) {
        int v11;
        String s4;
        g g1;
        List list0 = x0.g;
        q.g(k0, "onUserEvent");
        p p0 = (p)l0;
        p0.c0(0xBB516472);
        int v2 = (v1 & 6) == 0 ? (p0.i(x0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v3 = ScreenUtils.dipToPixel(context0, 380.0f);
            if(ScreenUtils.isPortrait(context0)) {
                v3 = ScreenUtils.getScreenWidth(context0) - ScreenUtils.dipToPixel(context0, 20.0f) * 2;
            }
            r1.c c0 = (r1.c)p0.k(k0.h);
            q.f("팔로워 %s", "getString(...)");
            String s = String.format("팔로워 %s", Arrays.copyOf(new Object[]{x0.d}, 1));
            float f = c0.R(v3);
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.q(n.a, f), e.b(4.0f));
            n n0 = n.a;
            r0.q q1 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.q.f(q0, e0.T(p0, 0x7F060145), y0.M.a), 0.0f, 0.0f, 0.0f, 26.0f, 7);  // color:gray050s
            boolean z = p0.i(x0);
            boolean z1 = p0.g(s);
            p0 p00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z || z1 || p00 == v4) {
                p00 = new p0(29, x0, s);
                p0.l0(p00);
            }
            r0.q q2 = X0.n.c(q1, false, p00);
            M.d d0 = j.c;
            g g0 = r0.d.m;
            y y0 = w.a(d0, g0, p0, 0);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
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
            if(p0.O) {
                g1 = g0;
                A7.d.q(v5, p0, v5, h2);
            }
            else {
                g1 = g0;
                if(!q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 24.0f, 0.0f, 0.0f, 13);
            M.p0 p01 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            String s1 = x0.a;
            r0.q q6 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 0.0f, 0.0f, 14), 64.0f), 72.0f), 0.0f, 4.0f, 0.0f, 4.0f, 5);
            boolean z2 = p0.i(x0);
            boolean z3 = p0.i(context0);
            gd.l l1 = p0.N();
            if(z2 || z3 || l1 == v4) {
                l1 = new gd.l(0, x0, context0);
                p0.l0(l1);
            }
            w3.g(s1, r0.a.a(X0.n.c(q6, false, l1), new o(k0, x0, v, 0)), ViewUtils.getDefaultImage(context0, ((int)e0.a0(64.0f, p0)), true), null, p0, 0, 8);
            r0.q q7 = q0.a(androidx.compose.foundation.layout.a.n(n0, 12.0f, 0.0f, 12.0f, 0.0f, 10), 1.0f);
            y y1 = w.a(d0, g1, p0, 0);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            String s2 = x0.c == null ? "" : x0.c;
            long v8 = e0.T(p0, 0x7F06016D);  // color:gray900s
            e1.y y2 = e1.y.i;
            s s3 = p0.N();
            if(s3 == v4) {
                s4 = s2;
                s3 = new s(7);
                p0.l0(s3);
            }
            else {
                s4 = s2;
            }
            N1.b(s4, r0.a.a(X0.n.c(n0, false, s3), new o(k0, x0, v, 1)), v8, 16.0f, y2, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p0, 0x30C00, 0xC36, 0x1D3D0);
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F060160), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray600s_support_high_contrast
            p0.p(true);
            r0.q q9 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 16.0f, 0.0f, 11), 28.0f);
            s s5 = p0.N();
            if(s5 == v4) {
                s5 = new s(8);
                p0.l0(s5);
            }
            r0.q q10 = X0.n.c(q9, false, s5);
            j0 j00 = androidx.compose.foundation.layout.a.c(10.0f, 0.0f, 14.0f, 0.0f, 10);
            List list1 = e.k.A(new R3[]{N3.h, P3.h});
            boolean z4 = x0.f;
            boolean z5 = p0.i(x0);
            F0 f00 = p0.N();
            if(((v2 & 0x380) == 0x100 | z5 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || f00 == v4) {
                f00 = new F0(k0, x0, v, 22);
                p0.l0(f00);
            }
            w3.k(q10, j00, list1, ((int)z4), f00, p0, 0x1B0);
            p0.p(true);
            long v9 = e0.T(p0, 0x7F060163);  // color:gray700s
            N1.b((x0.e == null ? "" : x0.e), androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 10.0f, E9.h.t(p0, 0x7F0700E3), 0.0f, 8), 1.0f), 3), v9, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // dimen:detail_list_padding_left_right
            r0.q q11 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 22.0f, 16.0f, 0.0f, 8), 1.0f);
            M.p0 p02 = M.n0.a(j.h(11.0f), r0.d.j, p0, 6);
            int v10 = p0.P;
            i0 i03 = p0.m();
            r0.q q12 = r0.a.d(p0, q11);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p02, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h2);
            }
            androidx.compose.runtime.w.x(p0, q12, h3);
            gd.k k1 = (gd.k)je.p.m0(list0);
            if(k1 == null) {
                p0.a0(0xE8788544);
                p0.p(false);
                v11 = v2 & 0x70;
            }
            else {
                p0.a0(0xE8788545);
                r0.q q13 = q0.a(androidx.compose.foundation.layout.d.u(n0, 3), 1.0f);
                s s6 = p0.N();
                if(s6 == v4) {
                    s6 = new s(9);
                    p0.l0(s6);
                }
                r0.q q14 = r0.a.a(X0.n.c(q13, false, s6), new gd.q(k0, k1, v, 0));
                boolean z6 = p0.g(k1);
                v11 = v2 & 0x70;
                gd.m m0 = p0.N();
                if((z6 | (v2 & 0x380) == 0x100 | (v11 == 0x20 ? 1 : 0)) != 0 || m0 == v4) {
                    m0 = new gd.m(k0, k1, v, 0);
                    p0.l0(m0);
                }
                m.a(k1, q14, m0, p0, 0);
                p0.p(false);
            }
            gd.k k2 = (gd.k)je.p.t0(list0);
            if(k2 == null) {
                p0.a0(-393640050);
            }
            else {
                p0.a0(-393640049);
                r0.q q15 = q0.a(androidx.compose.foundation.layout.d.u(n0, 3), 1.0f);
                s s7 = p0.N();
                if(s7 == v4) {
                    s7 = new s(10);
                    p0.l0(s7);
                }
                r0.q q16 = r0.a.a(X0.n.c(q15, false, s7), new gd.q(k0, k2, v, 1));
                boolean z7 = p0.g(k2);
                gd.m m1 = p0.N();
                if((z7 | (v2 & 0x380) == 0x100 | (v11 == 0x20 ? 1 : 0)) != 0 || m1 == v4) {
                    m1 = new gd.m(k0, k2, v, 1);
                    p0.l0(m1);
                }
                m.a(k2, q16, m1, p0, 0);
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
            n00.d = new Nc.p(x0, v, k0, v1, 9);
        }
    }

    public static final void c(P0 p00, int v, we.k k0, l l0, int v1) {
        ((p)l0).c0(440329480);
        int v2 = (v1 & 6) == 0 ? (((p)l0).i(p00) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((p)l0).e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            String s = p00.b;
            String s1 = p00.c;
            String s2 = p00.e;
            String s3 = p00.f;
            boolean z = ((p)l0).i(p00);
            K0 k00 = ((p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(((v2 & 0x380) == 0x100 | z | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || k00 == v3) {
                k00 = new K0(k0, p00, v, 0);
                ((p)l0).l0(k00);
            }
            boolean z1 = ((p)l0).i(p00);
            K0 k01 = ((p)l0).N();
            if(((v2 & 0x380) == 0x100 | z1 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || k01 == v3) {
                k01 = new K0(k0, p00, v, 1);
                ((p)l0).l0(k01);
            }
            boolean z2 = ((p)l0).i(p00);
            K0 k02 = ((p)l0).N();
            if(((v2 & 0x380) == 0x100 | z2 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || k02 == v3) {
                k02 = new K0(k0, p00, v, 2);
                ((p)l0).l0(k02);
            }
            c1.C(s, null, s1, s2, s3, 6.0f, 6.0f, k00, k01, k02, ((p)l0), 0x1B0000, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(p00, v, k0, v1, 12);
        }
    }

    public static final void d(int v, l l0, List list0, we.a a0, we.k k0, we.k k1) {
        p p0 = (p)l0;
        p0.c0(-1052194519);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(k1) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            F f0 = I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new Ac.M(f0, 28));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new Ac.M(f0, 29));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Object object0 = e1.getValue();
            ((Boolean)object0).booleanValue();
            L0 l00 = p0.N();
            if((v1 & 0x1C00) == 0x800 || l00 == v2) {
                l00 = new L0(k1, e0, e1, null);
                p0.l0(l00);
            }
            androidx.compose.runtime.J.f(boolean0, ((Boolean)object0), l00, p0);
            C0 c00 = N.u(p0);
            boolean z = p0.g(f0);
            O0 o00 = p0.N();
            if((v1 & 0x70) == 0x20 || z || o00 == v2) {
                o00 = new O0(f0, a0, null);
                p0.l0(o00);
            }
            androidx.compose.runtime.J.d(p0, H.a, o00);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.c(n.a, 1.0f), 0.0f, 10.0f, 0.0f, 0.0f, 13), c00, null);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(list0);
            gd.e e2 = p0.N();
            if(z1 || (v1 & 0x380) == 0x100 || e2 == v2) {
                e2 = new gd.e(list0, 3, k0);
                p0.l0(e2);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e2, p0, 0, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new J0(list0, a0, k0, k1, v, 0);
        }
    }

    public static final void e(B2 b20, we.k k0, l l0, int v) {
        q.g(k0, "onUserEvent");
        ((p)l0).c0(0x1D945EC0);
        int v1 = (((p)l0).i(b20) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 0.0f, 0.0f, 40.0f, 7);
            v.d(b20.a, q0, "전체보기", true, b20, k0, ((p)l0), 0xE000 & v1 << 12 | 0xC30 | v1 << 12 & 0x70000, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 3);
        }
    }

    public static final void f(J4 j40, int v, we.k k0, l l0, int v1) {
        ((p)l0).c0(0x2F8D30E4);
        int v2 = (v1 & 6) == 0 ? (((p)l0).g(j40) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((p)l0).e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(r0.a.a(androidx.compose.foundation.layout.d.f(n.a, 1.0f), new X2(k0, j40, v, 10)), E9.h.t(((p)l0), 0x7F0700AC), 0.0f, 2), 88.0f);  // dimen:context_list_padding_left_right
            String s = j40.h;
            String s1 = j40.c;
            String s2 = j40.b;
            String s3 = j40.f;
            String s4 = j40.e;
            boolean z = j40.g;
            String s5 = j40.a;
            boolean z1 = j40.d;
            String s6 = j40.i;
            F0 f00 = ((p)l0).N();
            if((((v2 & 14) == 4 ? 1 : 0) | ((v2 & 0x380) == 0x100 ? 1 : 0) | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || f00 == androidx.compose.runtime.k.a) {
                f00 = new F0(j40, k0, v, 24);
                ((p)l0).l0(f00);
            }
            w3.l(q0, s, s2, s1, z1, s4, s3, z, true, s5, s6, f00, ((p)l0), 0x6000000, 0, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(j40, v, k0, v1, 17);
        }
    }

    public static final void g(K4 k40, we.k k0, l l0, int v) {
        ((p)l0).c0(0x2D2C2087);
        int v1 = (((p)l0).i(k40) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            int v2 = k40.a;
            List list0 = k40.d;
            List list1 = k40.b;
            boolean z = false;
            int v3 = k40.c;
            String s = k40.e;
            boolean z1 = ((p)l0).i(k40);
            gd.l l1 = ((p)l0).N();
            V v4 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z1 || l1 == v4) {
                l1 = new gd.l(22, k0, k40);
                ((p)l0).l0(l1);
            }
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            boolean z2 = ((p)l0).i(k40);
            w0 w00 = ((p)l0).N();
            if(z2 || z || w00 == v4) {
                w00 = new w0(9, k0, k40);
                ((p)l0).l0(w00);
            }
            e0.B(v2, list1, list0, v3, s, l1, w00, ((p)l0), 0, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(k40, k0, v, 23);
        }
    }

    public static final void h(int v, l l0, List list0, we.a a0, we.k k0, we.k k1) {
        p p0 = (p)l0;
        p0.c0(0xA23471A9);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80) | (p0.i(k1) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            F f0 = I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new M0(f0, 14));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = androidx.compose.runtime.w.i(new M0(f0, 15));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.getClass();
            Object object0 = e1.getValue();
            ((Boolean)object0).getClass();
            G4 g40 = p0.N();
            if((v1 & 0x1C00) == 0x800 || g40 == v2) {
                g40 = new G4(k1, e0, e1, null);
                p0.l0(g40);
            }
            androidx.compose.runtime.J.f(boolean0, ((Boolean)object0), g40, p0);
            C0 c00 = N.u(p0);
            boolean z = p0.g(f0);
            I4 i40 = p0.N();
            if((v1 & 0x380) == 0x100 || z || i40 == v2) {
                i40 = new I4(f0, a0, null);
                p0.l0(i40);
            }
            androidx.compose.runtime.J.d(p0, H.a, i40);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c(n.a, 1.0f), c00, null);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(list0);
            gd.e e2 = p0.N();
            if(z1 || (v1 & 0x70) == 0x20 || e2 == v2) {
                e2 = new gd.e(list0, 6, k0);
                p0.l0(e2);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e2, p0, 0, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new J0(list0, k0, a0, k1, v);
        }
    }

    public static final long i(float f, float f1) {
        return ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
    }

    public static final ArrayList j(Collection collection0) {
        q.g(collection0, "<this>");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, collection0));
        for(Object object0: collection0) {
            q.g(((Playable)object0), "<this>");
            TrackBase trackBase0 = new TrackBase("");
            trackBase0.id = "";
            trackBase0.menuId = "";
            trackBase0.orgMenuId = "";
            trackBase0.registeredDate = ((Playable)object0).getCreatedAt();
            trackBase0.addOrder = ((Playable)object0).getCreatedSeq();
            arrayList0.add(trackBase0);
        }
        return arrayList0;
    }

    public static ke.i k(ke.i i0) {
        i0.a.b();
        return i0.size() <= 0 ? ke.i.b : i0;
    }

    public static v4.c l(GetTopicsResponse getTopicsResponse0) {
        q.g(getTopicsResponse0, "response");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: getTopicsResponse0.getTopics()) {
            arrayList0.add(new v4.d(((Topic)object0).getTaxonomyVersion(), ((Topic)object0).getModelVersion(), ((Topic)object0).getTopicId()));
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: getTopicsResponse0.getEncryptedTopics()) {
            byte[] arr_b = ((EncryptedTopic)object1).getEncryptedTopic();
            q.f(arr_b, "encryptedTopic.encryptedTopic");
            String s = ((EncryptedTopic)object1).getKeyIdentifier();
            q.f(s, "encryptedTopic.keyIdentifier");
            byte[] arr_b1 = ((EncryptedTopic)object1).getEncapsulatedKey();
            q.f(arr_b1, "encryptedTopic.encapsulatedKey");
            arrayList1.add(new v4.a(arr_b, s, arr_b1));
        }
        return new v4.c(arrayList1, arrayList0);
    }

    public static final e1.k m(Context context0) {
        AndroidFontLoader androidFontLoader0 = new AndroidFontLoader(context0);
        return Build.VERSION.SDK_INT < 0x1F ? new e1.k(androidFontLoader0, new e1.a(0)) : new e1.k(androidFontLoader0, new e1.a(z.a.a(context0)));
    }

    public static void n(Context context0, Uri uri0) {
        if(context0 != null) {
            String s = uri0.getPath();
            if(s != null && s.hashCode() == 0x57F9CED4 && s.equals("/playingSong")) {
                String s1 = uri0.getQueryParameter("like");
                if(s1 == null) {
                    s1 = "";
                }
                S s2 = new S(0);
                s2.i1(uri0);
                if(!((va.e0)va.o.a()).m()) {
                    Navigator.openLoginView(s2.c1());
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Q(context0, s1, null), 3, null);
            }
        }
    }

    public static Method o(Method[] arr_method, String s, Class[] arr_class) {
        Method method0;
        int v = 0;
    alab1:
        while(true) {
            method0 = null;
            if(v >= arr_method.length) {
                break alab1;
            }
            method0 = arr_method[v];
            if(!q.b(s, method0.getName()) && !Tf.v.r0(method0.getName(), s + '-', false)) {
                ++v;
                continue alab1;
            }
            Class[] arr_class1 = method0.getParameterTypes();
            Class[] arr_class2 = (Class[])Arrays.copyOf(arr_class, arr_class.length);
            if(arr_class1.length != arr_class2.length) {
                ++v;
                continue alab1;
            }
            ArrayList arrayList0 = new ArrayList(arr_class1.length);
            int v1 = arr_class1.length;
            int v2 = 0;
            for(int v3 = 0; v2 < v1; ++v3) {
                Class class0 = arr_class1[v2];
                Class class1 = arr_class2[v3];
                arrayList0.add(Boolean.valueOf(df.d.y(class0).equals(df.d.y(class1)) || class0.isAssignableFrom(class1)));
                ++v2;
            }
            if(arrayList0.isEmpty()) {
                break;
            }
            else {
                Iterator iterator0 = arrayList0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        break alab1;
                    }
                    Object object0 = iterator0.next();
                    if(((Boolean)object0).booleanValue()) {
                        continue;
                    }
                    ++v;
                    continue alab1;
                }
            }
            throw new NoSuchMethodException(s + " not found");
        }
        if(method0 == null) {
            throw new NoSuchMethodException(s + " not found");
        }
        return method0;
    }

    public static Method p(Class class0, String s, Object[] arr_object) {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; true; ++v) {
            Method method0 = null;
            if(v >= arr_object.length) {
                break;
            }
            Object object0 = arr_object[v];
            if(object0 != null) {
                method0 = object0.getClass();
            }
            if(method0 != null) {
                arrayList0.add(method0);
            }
        }
        Class[] arr_class = (Class[])arrayList0.toArray(new Class[0]);
        try {
            Class class1 = Integer.TYPE;
            Ce.g g0 = P4.a.K(0, (arr_class.length == 0 ? 1 : ((int)Math.ceil(((double)arr_class.length) / 10.0))));
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, g0));
            f f0 = g0.b();
            while(f0.c) {
                f0.nextInt();
                arrayList1.add(class1);
            }
            Class[] arr_class1 = (Class[])arrayList1.toArray(new Class[0]);
            Q8.h h0 = new Q8.h(3);
            ArrayList arrayList2 = h0.a;
            h0.h(arr_class);
            h0.f(l.class);
            h0.h(arr_class1);
            return m.o(class0.getDeclaredMethods(), s, ((Class[])arrayList2.toArray(new Class[arrayList2.size()])));
        }
        catch(ReflectiveOperationException unused_ex) {
            try {
                Method[] arr_method = class0.getDeclaredMethods();
                for(int v1 = 0; v1 < arr_method.length; ++v1) {
                    Method method1 = arr_method[v1];
                    if(q.b(method1.getName(), s) || Tf.v.r0(method1.getName(), s + '-', false)) {
                        return method1;
                    }
                }
            }
            catch(ReflectiveOperationException unused_ex) {
            }
            return null;
        }
    }

    public static final b3.N q(kc.h h0) {
        q.g(h0, "<this>");
        oc.w w0 = ((com.melon.playlist.b)h0.a).u();
        if(w0 == null) {
            q.f(b3.N.b, "EMPTY");
            return b3.N.b;
        }
        b3.l l0 = new b3.l(0);
        int[] arr_v = je.p.O0(Nb.a.a);
        l0.e(Arrays.copyOf(arr_v, arr_v.length));
        boolean z = e1.n.k(w0.getId());
        boolean z1 = e1.n.k(w0.getId());
        if(z || z1) {
            int[] arr_v1 = je.p.O0(Nb.a.b);
            l0.e(Arrays.copyOf(arr_v1, arr_v1.length));
            if(z) {
                int[] arr_v2 = je.p.O0(Nb.a.d);
                l0.e(Arrays.copyOf(arr_v2, arr_v2.length));
            }
            if(z1) {
                int[] arr_v3 = je.p.O0(Nb.a.c);
                l0.e(Arrays.copyOf(arr_v3, arr_v3.length));
            }
        }
        if(w0.n()) {
            int[] arr_v4 = je.p.O0(Nb.a.e);
            l0.e(Arrays.copyOf(arr_v4, arr_v4.length));
        }
        return new b3.N(l0.f());
    }

    public static final long r(long v) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) / 2.0f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) / 2.0f)) << 0x20;
    }

    public static final String s(int v) {
        return String.valueOf(v + 1);
    }

    public static final Playable t(kc.h h0, String s) {
        q.g(h0, "<this>");
        q.g(s, "trackIdFromMediaId");
        oc.w w0 = ((com.melon.playlist.b)h0.a).u();
        oc.Q q0 = w0 == null ? null : w0.getState();
        if(q0 != null) {
            List list0 = q0.c();
            if(list0 != null) {
                for(Object object0: list0) {
                    if(q.b(((PlayableData)object0).b, s)) {
                        return ((PlayableData)object0) == null ? null : ((PlayableData)object0).a;
                    }
                    if(false) {
                        break;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public static void u(String s, String s1, l l0, Object[] arr_object) {
        try {
            Class class0 = Class.forName(s);
            Method method0 = m.p(class0, s1, Arrays.copyOf(arr_object, arr_object.length));
            if(method0 == null) {
                throw new NoSuchMethodException("Composable " + s + '.' + s1 + " not found");
            }
            method0.setAccessible(true);
            if(Modifier.isStatic(method0.getModifiers())) {
                m.v(method0, null, l0, Arrays.copyOf(arr_object, arr_object.length));
                return;
            }
            m.v(method0, class0.getConstructor(null).newInstance(null), l0, Arrays.copyOf(arr_object, arr_object.length));
            return;
        }
        catch(Exception exception0) {
        }
        Log.w("PreviewLogger", "Failed to invoke Composable Method \'" + s + '.' + s1 + '\'', null);
        throw exception0;
    }

    public static void v(Method method0, Object object0, l l0, Object[] arr_object) {
        Object object1;
        Class[] arr_class = method0.getParameterTypes();
        int v = -1;
        int v1 = arr_class.length - 1;
        if(v1 >= 0) {
            while(true) {
                if(q.b(arr_class[v1], l.class)) {
                    v = v1;
                    break;
                }
                if(v1 - 1 < 0) {
                    break;
                }
                --v1;
            }
        }
        int v2 = (v == 0 ? 1 : ((int)Math.ceil(((double)((object0 == null ? 0 : 1) + v)) / 10.0))) + (v + 1);
        Class[] arr_class1 = method0.getParameterTypes();
        if((arr_class1.length == v2 ? 0 : ((int)Math.ceil(((double)v) / 31.0))) + v2 != arr_class1.length) {
            throw new IllegalStateException("params don\'t add up to total params");
        }
        Object[] arr_object1 = new Object[arr_class1.length];
        int v3 = 0;
        while(v3 < arr_class1.length) {
            if(v3 < 0 || v3 >= v) {
            label_39:
                if(v3 == v) {
                    object1 = l0;
                }
                else if(v + 1 > v3 || v3 >= v2) {
                    if(v2 > v3 || v3 >= arr_class1.length) {
                        throw new IllegalStateException("Unexpected index");
                    }
                    object1 = 0x1FFFFF;
                }
                else {
                    object1 = 0;
                }
            }
            else {
                if(v3 < 0 || v3 > je.n.l0(arr_object)) {
                    switch(method0.getParameterTypes()[v3].getName()) {
                        case "boolean": {
                            object1 = Boolean.FALSE;
                            goto label_47;
                        }
                        case "byte": {
                            object1 = (byte)0;
                            goto label_47;
                        }
                        case "char": {
                            object1 = Character.valueOf('\u0000');
                            goto label_47;
                        }
                        case "double": {
                            object1 = 0.0;
                            goto label_47;
                        }
                        case "float": {
                            object1 = 0.0f;
                            goto label_47;
                        }
                        case "int": {
                            object1 = 0;
                            goto label_47;
                        }
                        case "long": {
                            object1 = 0L;
                            goto label_47;
                        }
                        case "short": {
                            object1 = (short)0;
                            goto label_47;
                        }
                        default: {
                            object1 = null;
                            goto label_47;
                        }
                    }
                }
                else {
                    object1 = arr_object[v3];
                    goto label_47;
                }
                goto label_39;
            }
        label_47:
            arr_object1[v3] = object1;
            ++v3;
        }
        method0.invoke(object0, Arrays.copyOf(arr_object1, arr_class1.length));
    }

    public static String w(String s) {
        if(s != null) {
            if(s.equals("<unknown>")) {
                return "\u0001";
            }
            boolean z = s.startsWith("\u0001");
            String s1 = s.trim().toLowerCase();
            if(s1.startsWith("the ")) {
                s1 = s1.substring(4);
            }
            if(s1.startsWith("an ")) {
                s1 = s1.substring(3);
            }
            if(s1.startsWith("a ")) {
                s1 = s1.substring(2);
            }
            if(s1.endsWith(", the") || s1.endsWith(",the") || s1.endsWith(", an") || s1.endsWith(",an") || s1.endsWith(", a") || s1.endsWith(",a")) {
                s1 = s1.substring(0, s1.lastIndexOf(44));
            }
            String s2 = s1.replaceAll("[\\[\\]\\(\\)\"\'.,?!]", "").trim();
            if(s2.length() > 0) {
                StringBuilder stringBuilder0 = new StringBuilder(".");
                int v1 = s2.length();
                for(int v = 0; v < v1; ++v) {
                    stringBuilder0.append(s2.charAt(v));
                    stringBuilder0.append('.');
                }
                String s3 = DatabaseUtils.getCollationKey(stringBuilder0.toString());
                return z ? "\u0001" + s3 : s3;
            }
            return "";
        }
        return null;
    }

    public static final b0 x(K k0, l l0) {
        Object object0 = k0.getValue();
        androidx.lifecycle.D d0 = (androidx.lifecycle.D)((p)l0).k(Q2.e.a);
        b0 b00 = ((p)l0).N();
        V v0 = androidx.compose.runtime.k.a;
        if(b00 == v0) {
            if(k0.isInitialized()) {
                object0 = k0.getValue();
            }
            b00 = androidx.compose.runtime.w.s(object0);
            ((p)l0).l0(b00);
        }
        boolean z = ((p)l0).i(k0);
        boolean z1 = ((p)l0).i(d0);
        F.g g0 = ((p)l0).N();
        if(z || z1 || g0 == v0) {
            g0 = new F.g(k0, d0, b00, 18);
            ((p)l0).l0(g0);
        }
        androidx.compose.runtime.J.a(k0, d0, g0, ((p)l0));
        return b00;
    }

    public static TypedValue y(Context context0, int v) {
        TypedValue typedValue0 = new TypedValue();
        return context0.getTheme().resolveAttribute(v, typedValue0, true) ? typedValue0 : null;
    }

    public static boolean z(Context context0, int v, boolean z) {
        TypedValue typedValue0 = m.y(context0, v);
        return typedValue0 == null || typedValue0.type != 18 ? z : typedValue0.data != 0;
    }
}

