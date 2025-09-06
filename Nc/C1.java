package Nc;

import Cc.N1;
import Cc.e0;
import H0.e;
import M.c;
import M.j;
import M.w;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.google.firebase.b;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;

public abstract class c1 {
    public static final void a(d1 d10, l l0, int v) {
        q.g(d10, "uiState");
        p p0 = (p)l0;
        p0.c0(-2089173611);
        int v1 = v | (p0.g(d10) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = a.a(d.q(n0, 136.0f), new b1(d10, 0));
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            r0.q q2 = e0.L(d.n(n0, 136.0f), 0x7F0604AE);  // color:white120e
            M m0 = M.p.d(r0.d.a, false);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            b.f(6, p0, d10.c, d.c);
            r0.q q4 = d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 6.0f, 0.0f, 9), 24.0f);
            r0.q q5 = a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.c), new b1(d10, 1));
            j5.n.b(0x7F080309, e.Y(p0, 0x7F130BB4), q5, null, null, null, p0, 6, 0xFF8);  // drawable:common_btn_play_01
            p0.p(true);
            c.d(p0, d.h(n0, 8.0f));
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(d10.a, null, v4, 14.0f, null, null, 0L, null, 16.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);
            c.d(p0, d.h(n0, 6.0f));
            long v5 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b(d10.b, null, v5, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.a(d10, v, 21);
        }
    }
}

