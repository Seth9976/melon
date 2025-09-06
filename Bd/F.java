package bd;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import Lc.c;
import M.n0;
import M.p0;
import M.y;
import P0.h;
import P0.j;
import T.e;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v5x.response.FlexibleRes.ImageType;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.g;
import r0.i;
import r0.n;
import wc.u;
import we.a;
import y0.M;
import y0.s;

public abstract class f {
    public static final void a(String s, ImageType flexibleRes$ImageType0, String s1, String s2, int v, String s3, List list0, long v1, a a0, a a1, l l0, int v2) {
        String s5;
        String s4;
        q.g(flexibleRes$ImageType0, "imageType");
        p p0 = (p)l0;
        p0.c0(0x5810225C);
        int v3 = v2 | (p0.g(s) ? 4 : 2) | (p0.e(flexibleRes$ImageType0.ordinal()) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80) | (p0.e(v) ? 0x4000 : 0x2000) | (p0.g(s3) ? 0x20000 : 0x10000) | (p0.i(list0) ? 0x100000 : 0x80000) | (p0.f(v1) ? 0x800000 : 0x400000) | (p0.i(a0) ? 0x4000000 : 0x2000000) | (p0.i(a1) ? 0x20000000 : 0x10000000);
        if(p0.Q(v3 & 1, (0x12492093 & v3) != 0x12492092)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                s4 = "";
            }
            else {
                p0.T();
                s4 = s2;
            }
            p0.q();
            n n0 = n.a;
            r0.q q0 = e0.L(n0, 0x7F0604AE);  // color:white120e
            u u0 = M.a;
            r0.q q1 = r0.a.a(d.h(d.q(androidx.compose.foundation.q.f(q0, v1, u0), 311.0f), 196.0f), new c(16, a0));
            Bc.d d0 = p0.N();
            if((v3 & 0x70000000) == 0x20000000 || d0 == k.a) {
                d0 = new Bc.d(14, a1);
                p0.l0(d0);
            }
            r0.q q2 = m3.b(q1, d0);
            i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = j.b;
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
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q3, h3);
            c1.n(androidx.compose.foundation.layout.a.g(d.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.c), 136.0f), 9.0f, -9.0f), 0x7F080661, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:img_musicwave_pattern
            r0.q q4 = androidx.compose.foundation.layout.a.n(d.c, 20.0f, 20.0f, 20.0f, 0.0f, 8);
            M.d d1 = M.j.c;
            g g0 = r0.d.m;
            y y0 = M.w.a(d1, g0, p0, 0);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            r0.q q6 = d.f(n0, 1.0f);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q7, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y1 = M.w.a(d1, g0, p0, 0);
            int v7 = p0.P;
            i0 i03 = p0.m();
            r0.q q8 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q8, h3);
            N1.c(s1, v, androidx.compose.foundation.layout.a.n(d.f(n0, 1.0f), 0.0f, 4.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F0604A1), 18.0f, e1.y.i, null, 0L, 22.0f, 2, false, 2, 0, null, null, p0, v3 >> 6 & 14 | 0x186180 | v3 >> 9 & 0x70, 25008, 0x3A7A0);  // color:white000e
            M.c.d(p0, d.h(n0, 6.0f));
            N1.b(s3, null, e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, v3 >> 15 & 14 | 0xC00, 0xC00, 0x1DFF2);  // color:white700e
            p0.p(true);
            M.c.d(p0, d.q(n0, 36.0f));
            r0.q q9 = d5.n.o(d.n(n0, 78.0f), (flexibleRes$ImageType0 == ImageType.ARTIST ? e.a : e.b(4.0f)));
            androidx.compose.foundation.y y2 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604AE), 0.5f);  // color:white120e
            T.d d2 = flexibleRes$ImageType0 == ImageType.ARTIST ? e.a : e.b(4.0f);
            c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q9, y2.a, y2.b, d2), e0.T(p0, 0x7F060145), u0), s, null, N0.j.b, false, (flexibleRes$ImageType0 == ImageType.ARTIST ? 0x7F080799 : 0x7F08078D), null, null, null, 0.0f, null, 0, 0, false, false, p0, v3 << 3 & 0x70 | 0xC00, 0, 0x7FD4);  // color:gray050s
            l1.y(p0, true, n0, 22.0f, p0);
            if(list0.isEmpty()) {
                p0.a0(0xA20F4C62);
            }
            else {
                p0.a0(-1570408068);
                N0.M m1 = M.p.d(i0, false);
                int v8 = p0.P;
                i0 i04 = p0.m();
                r0.q q10 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i04, h1);
                if(p0.O || !q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                w.x(p0, q10, h3);
                bd.y.c(list0, 0L, p0, v3 >> 18 & 14, 2);
                r0.q q11 = androidx.compose.foundation.q.e(d.h(d.f(n0, 1.0f), 24.0f), u.f(e.k.A(new s[]{new s(v1), new s(s.f)}), 0.0f, 0.0f, 14), null, 6);
                N0.M m2 = M.p.d(i0, false);
                int v9 = p0.P;
                i0 i05 = p0.m();
                r0.q q12 = r0.a.d(p0, q11);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m2, h0);
                w.x(p0, i05, h1);
                if(p0.O || !q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h2);
                }
                w.x(p0, q12, h3);
                p0.p(true);
                p0.p(true);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            s5 = s4;
        }
        else {
            p0.T();
            s5 = s2;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new bd.e(s, flexibleRes$ImageType0, s1, s5, v, s3, list0, v1, a0, a1, v2);
        }
    }
}

