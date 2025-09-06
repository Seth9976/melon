package zc;

import Ac.e;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import M.g;
import M.j0;
import M.j;
import M.y;
import N0.M;
import Nb.p0;
import Nc.C1;
import O.F;
import O.I;
import P0.h;
import androidx.compose.animation.c;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHCHARTINFO;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import r0.i;
import r0.q;
import wc.u;
import we.n;

public abstract class s {
    public static final void a(List list0, int v, n n0, n n1, l l0, int v1) {
        F f1;
        ((p)l0).c0(-1364727068);
        int v2 = v1 | (((p)l0).i(list0) ? 4 : 2) | (((p)l0).e(v) ? 0x20 : 16) | (((p)l0).i(n0) ? 0x100 : 0x80) | (((p)l0).i(n1) ? 0x800 : 0x400);
        if(((p)l0).Q(v2 & 1, (v2 & 0x493) != 1170)) {
            F f0 = I.a(0, 0, 3, ((p)l0));
            CoroutineScope coroutineScope0 = ((p)l0).N();
            V v3 = k.a;
            if(coroutineScope0 == v3) {
                coroutineScope0 = J.i(((p)l0));
                ((p)l0).l0(coroutineScope0);
            }
            q q0 = d.h(r0.n.a, 190.0f);
            j0 j00 = a.c(20.0f, 0.0f, (v == e.k.s(list0) ? 10.0f : 20.0f), 0.0f, 10);
            g g0 = j.h(18.0f);
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(coroutineScope0);
            boolean z2 = ((p)l0).g(f0);
            p0 p00 = ((p)l0).N();
            if(((v2 & 0x70) == 0x20 | z | ((v2 & 0x380) == 0x100 ? 1 : 0) | z1 | z2 | ((v2 & 0x1C00) == 0x800 ? 1 : 0)) != 0 || p00 == v3) {
                p0 p01 = new p0(list0, v, n0, coroutineScope0, f0, n1);
                f1 = f0;
                ((p)l0).l0(p01);
                p00 = p01;
            }
            else {
                f1 = f0;
            }
            c1.q(q0, f1, j00, g0, null, null, false, p00, ((p)l0), 0x6006, 0xE8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new e(list0, v, n0, n1, v1);
        }
    }

    public static final void b(int v, GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0, int v1, we.k k0, we.k k1, l l0, int v2) {
        String s2;
        String s;
        List list1;
        r0.g g0 = r0.d.n;
        p p0 = (p)l0;
        p0.c0(0xC0ECFEBC);
        int v3 = (v2 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.i(graphDataListInfo$GRAPHCHARTINFO0) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.e(v1) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v3 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (p0.i(k1) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            List list0 = e.k.A(new Integer[]{0x7F0800B4, 0x7F0800B5, 0x7F0800B6, 0x7F0800B7, 0x7F0800B8});  // drawable:badge_nowgraph_ranking_1
            r0.n n0 = r0.n.a;
            q q0 = r0.a.a(c.a(d.s(n0, 60.0f, 0.0f, 2)), new zc.n(k0, graphDataListInfo$GRAPHCHARTINFO0, 3));
            i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O) {
                list1 = list0;
                A7.d.q(v4, p0, v4, h2);
            }
            else {
                list1 = list0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h2);
                }
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            u u0 = y0.M.a;
            if(v1 == v) {
                p0.a0(0x8AE06104);
                q q2 = a.n(n0, (v == 0 ? 0.0f : 8.0f), 0.0f, 0.0f, 0.0f, 14);
                y y0 = M.w.a(j.c, r0.d.m, p0, 0x30);
                int v5 = p0.P;
                M.d d0 = j.c;
                i0 i01 = p0.m();
                q q3 = r0.a.d(p0, q2);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                w.x(p0, q3, h3);
                M.c.d(p0, d.h(n0, 24.0f));
                q q4 = d.o(n0, 130.0f, 126.0f);
                M m1 = M.p.d(i0, false);
                int v6 = p0.P;
                i0 i02 = p0.m();
                q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
                w.x(p0, q5, h3);
                c1.n(androidx.compose.foundation.q.f(d.n(e0.L(n0, 0x7F06014A), 120.0f), e0.T(p0, 0x7F060145), u0), (graphDataListInfo$GRAPHCHARTINFO0 == null ? null : graphDataListInfo$GRAPHCHARTINFO0.albumImgLarge), null, null, false, 0x7F080788, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30000, 0, 0x7FDC);  // color:gray100a
                q q6 = d.n(n0, 50.0f);
                q q7 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.i);
                androidx.compose.foundation.q.c(De.I.Q(((Number)list1.get(v)).intValue(), p0, 0), "", q7, null, null, 0.0f, null, p0, 0x30, 120);
                q q8 = r0.a.a(a.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.c), 0.0f, 6.0f, 16.0f, 0.0f, 9), new zc.n(k1, graphDataListInfo$GRAPHCHARTINFO0, 4));
                androidx.compose.foundation.q.c(De.I.Q(0x7F080309, p0, 6), null, q8, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:common_btn_play_01
                p0.p(true);
                M.c.d(p0, d.h(n0, 3.0f));
                q q9 = d.q(n0, 120.0f);
                y y1 = M.w.a(d0, g0, p0, 0x30);
                int v7 = p0.P;
                i0 i03 = p0.m();
                q q10 = r0.a.d(p0, q9);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y1, h0);
                w.x(p0, i03, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q10, h3);
                if(graphDataListInfo$GRAPHCHARTINFO0 == null) {
                    s = "";
                }
                else {
                    s = graphDataListInfo$GRAPHCHARTINFO0.songName;
                    if(s == null) {
                        s = "";
                    }
                }
                N1.b(s, null, e0.T(p0, 0x7F06016D), 15.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 120786);  // color:gray900s
                M.c.d(p0, d.h(n0, 3.0f));
                if(graphDataListInfo$GRAPHCHARTINFO0 == null) {
                    s2 = "";
                }
                else {
                    String s1 = graphDataListInfo$GRAPHCHARTINFO0.getArtistNames();
                    s2 = s1 == null ? "" : s1;
                }
                N1.b(s2, null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
                A7.d.s(p0, true, true, false);
            }
            else {
                p0.a0(0x8B0858F4);
                y y2 = M.w.a(j.c, g0, p0, 0x30);
                int v8 = p0.P;
                i0 i04 = p0.m();
                q q11 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y2, h0);
                w.x(p0, i04, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                w.x(p0, q11, h3);
                M.c.d(p0, d.h(n0, 54.0f));
                c1.n(androidx.compose.foundation.q.f(d.n(e0.L(n0, 0x7F06014A), 60.0f), e0.T(p0, 0x7F060145), u0), (graphDataListInfo$GRAPHCHARTINFO0 == null ? null : graphDataListInfo$GRAPHCHARTINFO0.albumImgLarge), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);  // color:gray100a
                M.c.d(p0, d.h(n0, 6.0f));
                N1.b((v + 1 + "위"), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray600s_support_high_contrast
                p0.p(true);
                p0.p(false);
            }
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C1(v, graphDataListInfo$GRAPHCHARTINFO0, v1, k0, k1, v2);
        }
    }
}

