package de;

import Cc.H3;
import Cc.N1;
import Cc.S;
import Cc.U;
import Cc.c1;
import Cc.e0;
import Cc.t0;
import D0.E;
import M.b;
import M.j;
import M.p0;
import M.w;
import M.y;
import P0.h;
import P0.i;
import T.e;
import Tf.o;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.detail.MixMakerPlaylistBySongIdsDetailFragment;
import com.iloen.melon.fragments.main.foru.ForUMixMakerMainFragment;
import com.iloen.melon.fragments.main.foru.ForUTasteArtistFragment;
import com.iloen.melon.player.playlist.common.g;
import com.iloen.melon.utils.Navigator;
import e1.F;
import g3.f;
import i.n.i.b.a.s.e.M3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import je.D;
import kotlin.jvm.internal.q;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import r0.a;
import r0.n;
import ud.s;
import wc.u;
import we.k;
import y0.M;
import zd.D0;
import zd.Q;
import zd.m;
import zd.q0;
import zd.y0;

public abstract class c {
    public final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static Boolean i;
    public static final int j;

    public c() {
        this.a = 15;
        super();
    }

    public static final void a(m m0, k k0, l l0, int v) {
        q.g(m0, "type");
        q.g(k0, "onUserEvent");
        p p0 = (p)l0;
        p0.c0(-1397336705);
        int v1 = (v & 6) == 0 ? (p0.i(m0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.q q0 = d.f(n.a, 1.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c.b(m0, p0, v1 & 14);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(m0, k0, v, 25);
        }
    }

    public static final void b(m m0, l l0, int v) {
        h h6;
        int v3;
        h h5;
        N0.i i2;
        r0.q q2;
        N0.i i0 = N0.j.b;
        q.g(m0, "type");
        p p0 = (p)l0;
        p0.c0(0x9D0E20E0);
        int v1 = (v & 6) == 0 ? v | (p0.i(m0) ? 4 : 2) : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 8.0f, 0.0f, 8.0f, 5);
            n n0 = n.a;
            r0.h h0 = r0.d.k;
            b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h3);
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            zd.l l1 = m0.t();
            switch(l1.ordinal()) {
                case 0: {
                    q2 = e0.L(d.n(n0, 44.0f), 0x7F06014A);  // color:gray100a
                    break;
                }
                case 1: {
                    q2 = e0.L(d.h(d.q(n0, 30.0f), 44.0f), 0x7F06014A);  // color:gray100a
                    break;
                }
                case 2: {
                    q2 = e0.L(d.h(d.q(n0, 79.0f), 44.0f), 0x7F06014A);  // color:gray100a
                    break;
                }
                case 3: {
                    r0.q q3 = d.n(n0, 44.0f);
                    q.g(q3, "<this>");
                    q2 = a.a(q3, new S(0x7F06014A, 1));  // color:gray100a
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            switch(l1.ordinal()) {
                case 1: {
                    i2 = N0.j.d;
                    break;
                }
                case 2: {
                    i2 = N0.j.e;
                    break;
                }
                case 0: 
                case 3: {
                    i2 = i0;
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            switch(l1.ordinal()) {
                case 1: {
                    v3 = 0x7F080794;  // drawable:noimage_logo_xmini
                    h5 = h4;
                    break;
                }
                case 0: 
                case 2: {
                    h5 = h4;
                    v3 = 0x7F08078B;  // drawable:noimage_logo_mini
                    break;
                }
                case 3: {
                    v3 = 0x7F08079F;  // drawable:noimage_person_mini
                    h5 = h4;
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            Object object0 = m0.s();
            r0.q q4 = androidx.compose.foundation.q.f(q2, e0.T(p0, 0x7F060145), M.a);  // color:gray050s
            u u0 = M.a;
            c1.n(q4, object0, null, i2, false, v3, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FD4);
            M.c.d(p0, d.q(n0, 10.0f));
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(!p0.O && q.b(p0.N(), v4)) {
                h6 = h3;
            }
            else {
                h6 = h3;
                A7.d.q(v4, p0, v4, h6);
            }
            androidx.compose.runtime.w.x(p0, q5, h5);
            N1.b(m0.r(), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray900s
            if(o.H0("")) {
                p0.a0(0x5909948);
            }
            else {
                p0.a0(99448021);
                M.c.d(p0, d.h(n0, 2.0f));
                p0 p01 = M.n0.a(b0, h0, p0, 0x30);
                int v5 = p0.P;
                i0 i02 = p0.m();
                r0.q q6 = a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p01, h1);
                androidx.compose.runtime.w.x(p0, i02, h2);
                if(p0.O || !q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h6);
                }
                androidx.compose.runtime.w.x(p0, q6, h5);
                N1.b("", null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
                if(m0 instanceof q0) {
                    p0.a0(0x3FEB865D);
                    M.p.a(androidx.compose.foundation.q.f(d5.n.o(d.n(androidx.compose.foundation.layout.a.l(n0, 5.0f, 0.0f, 2), 2.0f), e.a), e0.T(p0, 0x7F06015D), u0), p0, 0);  // color:gray500s_support_high_contrast
                    long v6 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
                    N1.b(((q0)m0).c, null, v6, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
                }
                else {
                    p0.a0(0x3F862229);
                }
                p0.p(false);
                p0.p(true);
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
            n00.d = new W8.a(m0, v, 7);
        }
    }

    public static final r1.e c(Context context0) {
        float f = context0.getResources().getConfiguration().fontScale;
        float f1 = context0.getResources().getDisplayMetrics().density;
        s1.a a0 = s1.b.a(f);
        if(a0 == null) {
            a0 = new r1.n(f);
        }
        return new r1.e(f1, f, a0);
    }

    public static final void d(Q q0, k k0, we.a a0, l l0, int v, int v1) {
        q.g(q0, "type");
        q.g(k0, "onUserEvent");
        ((p)l0).c0(0xD875D09E);
        int v2 = (((p)l0).i(q0) ? 4 : 2) | v;
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        int v3 = (v1 & 4) == 0 ? v2 | (((p)l0).i(a0) ? 0x100 : 0x80) : v2 | 0x180;
        if(((p)l0).Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            if((v1 & 4) != 0) {
                a0 = null;
            }
            if(q0 instanceof y0) {
                ((p)l0).a0(0xB64319A0);
            }
            else if(q0 instanceof m) {
                ((p)l0).a0(0xB6445304);
                c.a(((m)q0), k0, ((p)l0), v3 & 0x70);
            }
            else {
                if(!(q0 instanceof D0)) {
                    throw l1.c(((p)l0), -1841023789, false);
                }
                ((p)l0).a0(0xB645ED86);
                c.f(((D0)q0), a0, ((p)l0), v3 >> 3 & 0x70);
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new H3(q0, k0, a0, v, v1, 22);
        }
    }

    public static final void e(r0.q q0, float f, float f1, y0.Q q1, long v, l l0, int v1) {
        float f5;
        long v5;
        y0.Q q5;
        float f4;
        long v3;
        y0.Q q2;
        float f3;
        float f2;
        p p0 = (p)l0;
        p0.c0(0xFC55CD11);
        int v2 = v1 | (p0.g(q0) ? 4 : 2) | 0x25B0;
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            p0.V();
            if((v1 & 1) == 0 || p0.B()) {
                f2 = 36.0f;
                f3 = 5.0f;
                q2 = e.b(100.0f);
                v3 = e0.T(p0, 0x7F060156);  // color:gray300s
            }
            else {
                p0.T();
                f2 = f;
                f3 = f1;
                q2 = q1;
                v3 = v;
            }
            p0.q();
            r0.q q3 = d.f(n.a, 1.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q4 = a.d(p0, q3);
            P0.k.y.getClass();
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
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q4, P0.j.d);
            M.p.a(androidx.compose.foundation.q.f(d5.n.o(d.o(androidx.compose.foundation.layout.a.n(q0, 0.0f, 5.0f, 0.0f, 8.0f, 5), f2, f3), q2), v3, M.a), p0, 0);
            p0.p(true);
            f4 = f3;
            q5 = q2;
            v5 = v3;
            f5 = f2;
        }
        else {
            p0.T();
            f5 = f;
            f4 = f1;
            q5 = q1;
            v5 = v;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new zd.i(q0, f5, f4, q5, v5, v1);
        }
    }

    public static final void f(D0 d00, we.a a0, l l0, int v) {
        q.g(d00, "type");
        p p0 = (p)l0;
        p0.c0(-1715380865);
        int v1 = (v & 6) == 0 ? (p0.i(d00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = d.f(d.h(n0, 48.0f), 1.0f);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
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
            if(d00 instanceof zd.a) {
                p0.a0(0xC837A822);
                y0.k k0 = new y0.k(e0.T(p0, 0x7F060165), 5);  // color:gray800s
                c1.n(a.a(d.n(n0, 22.0f), new s(16, a0)), 0x7F080287, null, null, false, 0, null, null, null, 0.0f, k0, 0, 0, false, false, p0, 0x30, 0, 0x7BFC);  // drawable:btn_web_toolbar_back
                x.z(n0, 10.0f, p0, false);
            }
            else {
                p0.a0(0xC809B7DF);
                p0.p(false);
            }
            N1.b(d00.r(), null, e0.T(p0, 0x7F06016D), 18.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(d00, a0, v, 26);
        }
    }

    public static final void g(we.a a0, we.a a1, we.a a2, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x8FFF55FE);
        int v1 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a2) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = d.f(androidx.compose.foundation.layout.a.m(n0, 20.0f, 26.0f, 20.0f, 26.0f), 1.0f);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = a.d(p0, n0);
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
            androidx.compose.runtime.w.x(p0, q2, h3);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q.f("재생 목록 바로가기", "getString(...)");
            long v4 = e0.T(p0, 0x7F060163);  // color:gray700s
            N1.b("재생 목록 바로가기", a.a(d.f(n0, 1.0f), new s(13, a0)), v4, 16.0f, null, null, 0L, new l1.k(5), 18.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);
            M.c.d(p0, d.h(n0, 24.0f));
            q.f("검색 바로가기", "getString(...)");
            long v5 = e0.T(p0, 0x7F060163);  // color:gray700s
            N1.b("검색 바로가기", a.a(d.f(n0, 1.0f), new s(14, a1)), v5, 16.0f, null, null, 0L, new l1.k(5), 18.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);
            M.c.d(p0, d.h(n0, 24.0f));
            q.f("위젯 설정", "getString(...)");
            long v6 = e0.T(p0, 0x7F060163);  // color:gray700s
            N1.b("위젯 설정", a.a(d.f(n0, 1.0f), new s(15, a2)), v6, 16.0f, null, null, 0L, new l1.k(5), 18.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(a0, a1, a2, v, 21);
        }
    }

    public static final void h(we.a a0, we.a a1, we.a a2, we.a a3, we.a a4, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1312114370);
        int v1 = v | (p0.i(a0) ? 4 : 2) | (p0.i(a1) ? 0x20 : 16) | (p0.i(a2) ? 0x100 : 0x80) | (p0.i(a3) ? 0x800 : 0x400) | (p0.i(a4) ? 0x4000 : 0x2000);
        if(p0.Q(v1 & 1, (v1 & 9363) != 9362)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = d.q(d.j(n0, 0.0f, 440.0f, 1), 270.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.f(d5.n.o(n0, e.b(12.0f)), e0.T(p0, 0x7F0604AB), M.a);  // color:white001s
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = a.d(p0, q2);
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
            c.g(a1, a2, a3, p0, v1 >> 3 & 0x3FE);
            e0.C(d.f(n0, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            r0.q q4 = d.h(d.f(n0, 1.0f), 44.0f);
            r0.q q5 = H0.b.q(r0.d.n, q4);
            g g0 = p0.N();
            if((v1 & 14) == 4 || g0 == androidx.compose.runtime.k.a) {
                g0 = new g(8, a0);
                p0.l0(g0);
            }
            yd.h.b(false, true, q5, "", "취소", false, null, g0, a4, p0, 0xE000000 & v1 << 12 | 0x180C36, 0x20);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new t0(a0, a1, a2, a3, a4, v);
        }
    }

    public static final Object[] i(int v, Object object0, Object object1, Object[] arr_object) {
        Object[] arr_object1 = new Object[arr_object.length + 2];
        je.n.Y(arr_object, 0, arr_object1, v, 6);
        je.n.W(arr_object, v + 2, arr_object1, v, arr_object.length);
        arr_object1[v] = object0;
        arr_object1[v + 1] = object1;
        return arr_object1;
    }

    public static final Object[] j(int v, Object[] arr_object) {
        Object[] arr_object1 = new Object[arr_object.length - 2];
        je.n.Y(arr_object, 0, arr_object1, v, 6);
        je.n.W(arr_object, v, arr_object1, v + 2, arr_object.length);
        return arr_object1;
    }

    public static final Object[] k(int v, Object[] arr_object) {
        Object[] arr_object1 = new Object[arr_object.length - 1];
        je.n.Y(arr_object, 0, arr_object1, v, 6);
        je.n.W(arr_object, v, arr_object1, v + 1, arr_object.length);
        return arr_object1;
    }

    public static final Element l(Element element0, String s, String s1) {
        q.g(s, "namespaceUri");
        q.g(s1, "qualifiedName");
        Element element1 = element0.getOwnerDocument().createElementNS(s, s1);
        element0.appendChild(element1);
        q.f(element1, "ownerDocument.createElem….also { appendChild(it) }");
        return element1;
    }

    public abstract String m();

    public static void n(f f0) {
        if(f0 != null) {
            try {
                f0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static v2.o o(Context context0) {
        F f0 = Build.VERSION.SDK_INT >= 28 ? new v2.b() : new F();  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
        ProviderInfo providerInfo0 = null;
        PackageManager packageManager0 = context0.getPackageManager();
        Q1.c.o(packageManager0, "Package manager required to locate emoji font provider");
        for(Object object0: packageManager0.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0)) {
            ProviderInfo providerInfo1 = ((ResolveInfo)object0).providerInfo;
            if(providerInfo1 != null && (providerInfo1.applicationInfo != null && (providerInfo1.applicationInfo.flags & 1) == 1)) {
                providerInfo0 = providerInfo1;
                break;
            }
        }
        if(providerInfo0 == null) {
            return null;
        }
        try {
            String s = providerInfo0.authority;
            String s1 = providerInfo0.packageName;
            Signature[] arr_signature = f0.s(packageManager0, s1);
            ArrayList arrayList0 = new ArrayList();
            for(int v = 0; v < arr_signature.length; ++v) {
                arrayList0.add(arr_signature[v].toByteArray());
            }
            Z1.d d0 = new Z1.d(s, s1, "emojicompat-emoji-font", Collections.singletonList(arrayList0));
            return d0 == null ? null : new v2.o(new v2.n(context0, d0));
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.wtf("emoji2.text.DefaultEmojiConfig", packageManager$NameNotFoundException0);
            return null;
        }
    }

    public static final File p(Context context0, String s) {
        q.g(context0, "<this>");
        q.g(s, "fileName");
        return new File(context0.getApplicationContext().getFilesDir(), "datastore/" + s);
    }

    public static final boolean q(long v, long v1) {
        return v == v1;
    }

    public static void r(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "/concernmusic": {
                    Navigator.INSTANCE.openForUMusicSetting();
                    break;
                }
                case "/mixmaker": {
                    Navigator.open(ForUMixMakerMainFragment.Companion.newInstance());
                    return;
                }
                case "/mixmaker/detail": {
                    Set set0 = uri0.getQueryParameterNames();
                    q.f(set0, "getQueryParameterNames(...)");
                    int v = D.N(je.q.Q(10, set0));
                    if(v < 16) {
                        v = 16;
                    }
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                    for(Object object0: set0) {
                        linkedHashMap0.put(object0, uri0.getQueryParameter(((String)object0)));
                    }
                    String s1 = (String)linkedHashMap0.get("songids");
                    if(s1 != null) {
                        String s2 = (String)linkedHashMap0.get("title");
                        if(s2 != null) {
                            Navigator.open(MixMakerPlaylistBySongIdsDetailFragment.Companion.newInstance(s1, s2));
                            return;
                        }
                    }
                    return;
                }
                case "/selfrecommend": {
                    Navigator.INSTANCE.openForUSelfRecommend("");
                    return;
                }
                case "/usertaste": {
                    Navigator.open(ForUTasteArtistFragment.Companion.newInstance());
                }
            }
        }
    }

    public static void s(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "": {
                    Navigator.INSTANCE.openStation();
                    return;
                }
                case "/episode": {
                    String s1 = uri0.getQueryParameter("seq");
                    if(s1 != null) {
                        Navigator.INSTANCE.openCastEpisodeDetail(s1);
                        return;
                    }
                    break;
                }
                case "/listen": {
                    String s3 = uri0.getQueryParameter("seq");
                    if(s3 != null) {
                        Navigator.INSTANCE.openStationListen(s3, "1000002296");
                        return;
                    }
                    break;
                }
                case "/popular": {
                    Navigator.INSTANCE.openStationPopularDetail();
                    return;
                }
                case "/program": {
                    String s2 = uri0.getQueryParameter("seq");
                    if(s2 != null) {
                        Navigator.INSTANCE.openStationProgram(s2);
                        return;
                    }
                    break;
                }
            }
        }
    }

    public static final Element t(Element element0, String s) {
        q.g(s, "localName");
        Node node0 = element0.getFirstChild();
        if(node0 != null) {
            E e0 = new E();
            e0.b = node0;
            while(e0.hasNext()) {
                Object object0 = e0.next();
                if(q.b(((Element)object0).getLocalName(), s)) {
                    return object0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.a == 15 ? this.m() : super.toString();
    }

    public static de.g u(I i0, o0 o00) {
        x9.a a0 = ((k8.h)(((de.b)E9.w.s(i0, de.b.class)))).c.a();
        C9.e e0 = (C9.e)a0.a;
        o00.getClass();
        return new de.g(e0, o00, ((ea.a)a0.b));
    }

    public static final int v(int v, int v1) [...] // Inlined contents

    public static long w(e3.p p0, int v, int v1) {
        p0.G(v);
        if(p0.a() < 5) {
            return 0x8000000000000001L;
        }
        int v2 = p0.g();
        if((0x800000 & v2) != 0) {
            return 0x8000000000000001L;
        }
        if((0x1FFF00 & v2) >> 8 != v1) {
            return 0x8000000000000001L;
        }
        if((v2 & 0x20) != 0 && p0.u() >= 7 && p0.a() >= 7 && (p0.u() & 16) == 16) {
            byte[] arr_b = new byte[6];
            p0.e(arr_b, 0, 6);
            return (((long)arr_b[0]) & 0xFFL) << 25 | (((long)arr_b[1]) & 0xFFL) << 17 | (((long)arr_b[2]) & 0xFFL) << 9 | (((long)arr_b[3]) & 0xFFL) << 1 | (((long)arr_b[4]) & 0xFFL) >> 7;
        }
        return 0x8000000000000001L;
    }

    public static String x(long v) {
        return Float.compare(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) == 0 ? "CornerRadius.circular(" + df.d.N(Float.intBitsToFloat(((int)(v >> 0x20)))) + ')' : "CornerRadius.elliptical(" + df.d.N(Float.intBitsToFloat(((int)(v >> 0x20)))) + ", " + df.d.N(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) + ')';
    }
}

