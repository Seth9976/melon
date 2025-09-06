package Jc;

import Ac.X;
import Cc.N1;
import Cc.e0;
import Cc.r0;
import J8.G;
import L5.c;
import M.j;
import M.w;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import T.e;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.O0;
import r0.a;
import r0.d;
import r0.n;
import r0.q;

public final class z0 extends O0 {
    public final G a;

    public z0(G g0) {
        super(g0.b);
        this.a = g0;
    }

    public final void a(q q0, Z z0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x9FFB1A5A);
        int v1 = v | (p0.g(z0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            q q1 = a.a(q0, new X(z0, 8));
            y y0 = w.a(j.c, d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = a.d(p0, q1);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            n n0 = n.a;
            q q3 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            q q4 = e0.K(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 180.0f));
            String s = z0.f;
            r0.b.c(q4, z0.e, 180.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            if(s.length() > 0) {
                p0.a0(182794920);
                q q5 = d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.c, 90.0f), e.d(0.0f, 0.0f, 4.0f, 4.0f, 3));
                q q6 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.h);
                androidx.compose.foundation.q.c(c.a(d5.w.B(context0, 0x7F080888), p0), "", q6, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:shape_gradient_gray500e_transparent_angle270_bottom_round4
                j5.n.b(s, null, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.g), 10.0f, 0.0f, 0.0f, 10.0f, 6), 260.0f), 50.0f), null, N0.j.b, null, p0, 0x180030, 0xFB8);
            }
            else {
                p0.a0(0xA9FDEEC);
            }
            p0.p(false);
            p0.p(true);
            q q7 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 8.0f, 0.0f, 0.0f, 13), 1.0f), 3);
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(z0.b, q7, v4, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            q q8 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), 1.0f), 3);
            long v5 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(z0.c, q8, v5, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(this, q0, z0, v, 2);
        }
    }
}

