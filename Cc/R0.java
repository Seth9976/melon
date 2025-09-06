package Cc;

import Ac.E;
import De.I;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import T.e;
import U4.x;
import android.content.Context;
import androidx.compose.foundation.layout.a;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.request.ImageRequest.Builder;
import m0.b;
import m0.c;
import r0.d;
import r0.n;
import r0.q;
import wc.u;

public final class r0 {
    public static final r0 a;
    public static final r0 b;

    static {
        r0.a = new r0();  // 初始化器: Ljava/lang/Object;-><init>()V
        r0.b = new r0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public void a(s0 s00, q q0, l l0, int v) {
        q q4;
        kotlin.jvm.internal.q.g(s00, "uiState");
        p p0 = (p)l0;
        p0.c0(0x2B4FADFE);
        int v1 = v | (p0.i(s00) ? 4 : 2) | 0x30;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            q q1 = a.l(n0, 20.0f, 0.0f, 2);
            p0 p00 = n0.a(j.h(12.0f), d.j, p0, 6);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            p0.a0(-930364756);
            for(Object object0: je.p.K0(3, ((Iterable)s00.a))) {
                q q3 = x.r(1.0f, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 48.0f), true);
                r0.a.b(((r)object0), q3, p0, 0x180);
            }
            p0.p(false);
            p0.p(true);
            q4 = n0;
        }
        else {
            p0.T();
            q4 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new E(this, s00, q4, v, 6);
        }
    }

    public void b(r r0, q q0, l l0, int v) {
        kotlin.jvm.internal.q.g(r0, "uiState");
        ((p)l0).c0(0x3591751A);
        int v1 = v | (((p)l0).g(r0) ? 4 : 2) | (((p)l0).g(q0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            q q1 = d5.n.o(q0, e.b(4.0f));
            Z.j j0 = Z.a.a(e0.T(((p)l0), 0x7F060145), ((p)l0), 0, 14);  // color:gray050s
            j0 j00 = new j0(0.0f, 0.0f, 0.0f, 0.0f);
            b b0 = c.e(0x55B3790A, ((p)l0), new Bd.e(r0, 2));
            H0.e.b(r0.c, q1, false, null, null, j0, j00, b0, ((p)l0), 0x36000000, 0x7C);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E(this, r0, q0, v, 7);
        }
    }

    public void c(q q0, String s, float f, Integer integer0, long v, T.d d0, boolean z, boolean z1, l l0, int v1, int v2) {
        boolean z6;
        boolean z5;
        int v9;
        boolean z4;
        T.d d2;
        boolean z3;
        long v8;
        Integer integer2;
        boolean z2;
        int v6;
        T.d d1;
        int v5;
        long v4;
        Integer integer1;
        kotlin.jvm.internal.q.g(s, "imageUrl");
        ((p)l0).c0(410358622);
        int v3 = (v1 & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (((p)l0).d(f) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
            integer1 = integer0;
        }
        else if((v1 & 0xC00) == 0) {
            integer1 = integer0;
            v3 |= (((p)l0).g(integer1) ? 0x800 : 0x400);
        }
        else {
            integer1 = integer0;
        }
        if((v1 & 0x6000) == 0) {
            if((v2 & 16) == 0) {
                v4 = v;
                v5 = ((p)l0).f(v4) ? 0x4000 : 0x2000;
            }
            else {
                v4 = v;
                v5 = 0x2000;
            }
            v3 |= v5;
        }
        else {
            v4 = v;
        }
        if((0x30000 & v1) == 0) {
            if((v2 & 0x20) == 0) {
                d1 = d0;
                v6 = ((p)l0).g(d1) ? 0x20000 : 0x10000;
            }
            else {
                d1 = d0;
                v6 = 0x10000;
            }
            v3 |= v6;
        }
        else {
            d1 = d0;
        }
        if((v2 & 0x40) != 0) {
            v3 |= 0x180000;
            z2 = z;
        }
        else if((0x180000 & v1) == 0) {
            z2 = z;
            v3 |= (((p)l0).h(z2) ? 0x100000 : 0x80000);
        }
        else {
            z2 = z;
        }
        if((v2 & 0x80) != 0) {
            v3 |= 0xC00000;
        }
        else if((v1 & 0xC00000) == 0) {
            v3 |= (((p)l0).h(z1) ? 0x800000 : 0x400000);
        }
        int v7 = (v1 & 0x6000000) == 0 ? v3 | (((p)l0).g(this) ? 0x4000000 : 0x2000000) : v3;
        if(((p)l0).Q(v7 & 1, (v7 & 0x2492493) != 0x2492492)) {
            ((p)l0).V();
            if((v1 & 1) == 0 || ((p)l0).B()) {
                if((v2 & 8) != 0) {
                    integer1 = null;
                }
                if((v2 & 16) != 0) {
                    v4 = e0.T(((p)l0), 0x7F060145);  // color:gray050s
                    v7 &= 0xFFFF1FFF;
                }
                if((v2 & 0x20) != 0) {
                    d1 = e.b(4.0f);
                    v7 &= 0xFFF8FFFF;
                }
                if((v2 & 0x40) != 0) {
                    z2 = false;
                }
                if((v2 & 0x80) == 0) {
                label_83:
                    integer2 = integer1;
                    v8 = v4;
                    z3 = z2;
                    d2 = d1;
                    z4 = z1;
                }
                else {
                    integer2 = integer1;
                    v8 = v4;
                    z3 = z2;
                    d2 = d1;
                    z4 = true;
                }
            }
            else {
                ((p)l0).T();
                if((v2 & 16) != 0) {
                    v7 &= 0xFFFF1FFF;
                }
                if((v2 & 0x20) != 0) {
                    v7 &= 0xFFF8FFFF;
                }
                goto label_83;
            }
            ((p)l0).q();
            if(integer2 != null) {
                v9 = (int)integer2;
            }
            else if(Float.compare(f, 0.0f) < 0) {
                v9 = 0x7F08093C;  // drawable:transparent
            }
            else if(Float.compare(f, 40.0f) <= 0) {
                v9 = 0x7F080794;  // drawable:noimage_logo_xmini
            }
            else if(Float.compare(f, 89.0f) <= 0) {
                v9 = 0x7F08078B;  // drawable:noimage_logo_mini
            }
            else if(Float.compare(f, 117.0f) <= 0) {
                v9 = 0x7F08078D;  // drawable:noimage_logo_small
            }
            else {
                v9 = Float.compare(f, 184.0f) > 0 ? 0x7F080786 : 0x7F080788;  // drawable:noimage_logo_large
            }
            this.d(q0, v9, d2, s, v8, z3, z4, ((p)l0), v7 & 14 | v7 >> 9 & 0x380 | v7 << 6 & 0x1C00 | v7 & 0xE000 | 0x70000 & v7 >> 3 | 0x380000 & v7 >> 3 | v7 >> 3 & 0x1C00000);
            z5 = z4;
            d1 = d2;
            z6 = z3;
            v4 = v8;
            integer1 = integer2;
        }
        else {
            ((p)l0).T();
            z5 = z1;
            z6 = z2;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new D3(this, q0, s, f, integer1, v4, d1, z6, z5, v1, v2);
        }
    }

    public void d(q q0, int v, T.d d0, String s, long v1, boolean z, boolean z1, l l0, int v2) {
        u u1;
        p p0 = (p)l0;
        p0.c0(0x9602094D);
        int v3 = (v2 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.g(d0) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v3 |= (p0.g(s) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (p0.f(v1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v3 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v2) == 0) {
            v3 |= (p0.h(z1) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v3 & 1, (0x92493 & v3) != 0x92492)) {
            p0.V();
            if((v2 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, P0.j.d);
            u u0 = y0.M.a;
            if(v == -1) {
                u1 = u0;
                p0.a0(0x460B93FE);
                M.p.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), v1, u1), p0, 0);
            }
            else {
                p0.a0(0x46055132);
                q q2 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), v1, u0);
                u1 = u0;
                androidx.compose.foundation.q.c(I.Q(v, p0, v3 >> 3 & 14), null, q2, null, N0.j.f, 0.0f, null, p0, 0x6030, 104);
            }
            p0.p(false);
            if(z) {
                p0.a0(0x460FCC45);
                M.p.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c, d0), e0.T(p0, 0x7F06014D), u1), p0, 0);  // color:gray125e
            }
            else {
                p0.a0(0x45C5E54F);
            }
            p0.p(false);
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
            imageRequest$Builder0.c = s;
            imageRequest$Builder0.n = Boolean.valueOf(z1);
            j5.n.b(imageRequest$Builder0.a(), null, d5.n.o(androidx.compose.foundation.layout.d.c, d0), null, N0.j.b, null, p0, 0x180030, 0xFB8);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new E3(this, q0, v, d0, s, v1, z, z1, v2);
        }
    }

    public void e(q q0, String s, float f, Integer integer0, long v, boolean z, boolean z1, l l0, int v1, int v2) {
        Integer integer3;
        long v9;
        boolean z5;
        int v8;
        Integer integer1;
        boolean z4;
        boolean z3;
        int v6;
        int v7;
        boolean z2;
        int v5;
        long v4;
        kotlin.jvm.internal.q.g(s, "imageUrl");
        ((p)l0).c0(2104013371);
        int v3 = (v1 & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (((p)l0).d(f) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            v3 |= (((p)l0).g(integer0) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            if((v2 & 16) == 0) {
                v4 = v;
                v5 = ((p)l0).f(v4) ? 0x4000 : 0x2000;
            }
            else {
                v4 = v;
                v5 = 0x2000;
            }
            v3 |= v5;
        }
        else {
            v4 = v;
        }
        if((v2 & 0x20) != 0) {
            v3 |= 0x30000;
            z2 = z;
        }
        else if((0x30000 & v1) == 0) {
            z2 = z;
            v3 |= (((p)l0).h(z2) ? 0x20000 : 0x10000);
        }
        else {
            z2 = z;
        }
        if((v2 & 0x40) != 0) {
            v3 |= 0x180000;
        }
        else if((0x180000 & v1) == 0) {
            v3 |= (((p)l0).h(z1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v3 |= (((p)l0).g(this) ? 0x800000 : 0x400000);
        }
        if(((p)l0).Q(v3 & 1, (0x492493 & v3) != 4793490)) {
            ((p)l0).V();
            if((v1 & 1) == 0 || ((p)l0).B()) {
                Integer integer2 = (v2 & 8) == 0 ? integer0 : null;
                if((v2 & 16) == 0) {
                    v7 = v3;
                }
                else {
                    v7 = v3 & 0xFFFF1FFF;
                    v4 = e0.T(((p)l0), 0x7F060145);  // color:gray050s
                }
                if((v2 & 0x20) != 0) {
                    z2 = false;
                }
                if((v2 & 0x40) == 0) {
                    z3 = z2;
                    z4 = z1;
                    integer1 = integer2;
                    v6 = v7;
                }
                else {
                    integer1 = integer2;
                    v6 = v7;
                    z3 = z2;
                    z4 = true;
                }
            }
            else {
                ((p)l0).T();
                v6 = (v2 & 16) == 0 ? v3 : v3 & 0xFFFF1FFF;
                z3 = z2;
                z4 = z1;
                integer1 = integer0;
            }
            ((p)l0).q();
            if(integer1 != null) {
                v8 = (int)integer1;
            }
            else if(Float.compare(f, 28.0f) <= 0) {
                v8 = 0x7F0807A2;  // drawable:noimage_person_xmini
            }
            else if(Float.compare(f, 47.0f) <= 0) {
                v8 = 0x7F08079A;  // drawable:noimage_man_mini
            }
            else if(Float.compare(f, 64.0f) <= 0) {
                v8 = 0x7F08079C;  // drawable:noimage_man_small
            }
            else {
                v8 = Float.compare(f, 112.0f) > 0 ? 0x7F080798 : 0x7F080799;  // drawable:noimage_man_big
            }
            this.d(q0, v8, e.a, s, v4, z3, z4, ((p)l0), v6 & 14 | v6 << 6 & 0x1C00 | 0xE000 & v6 | 0x70000 & v6 | 0x380000 & v6 | v6 & 0x1C00000);
            z5 = z4;
            z2 = z3;
            v9 = v4;
            integer3 = integer1;
        }
        else {
            ((p)l0).T();
            v9 = v4;
            z5 = z1;
            integer3 = integer0;
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new F3(this, q0, s, f, integer3, v9, z2, z5, v1, v2);
        }
    }
}

