package zc;

import Cc.I2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import M.c;
import M.j;
import M.p0;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import T.e;
import U4.x;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHCHARTINFO;
import com.iloen.melon.net.v4x.common.GraphDataListInfo;
import java.util.List;
import r0.a;
import r0.d;
import r0.q;
import we.n;

public abstract class o {
    public static final void a(List list0, n n0, n n1, n n2, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xA1840613);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(n0) ? 0x20 : 16) | (p0.i(n1) ? 0x100 : 0x80) | (p0.i(n2) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            y y0 = w.a(j.c, d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.n n3 = r0.n.a;
            q q0 = a.d(p0, n3);
            k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            p0.a0(0x4FB62711);
            int v3 = 0;
            for(Object object0: list0) {
                if(v3 >= 0) {
                    GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0 = ((GraphDataListInfo)object0).graphChartInfo;
                    boolean z = p0.e(v3);
                    zc.l l1 = p0.N();
                    V v4 = androidx.compose.runtime.k.a;
                    if((v1 & 0x70) == 0x20 || z || l1 == v4) {
                        l1 = new zc.l(v3, 0, n0);
                        p0.l0(l1);
                    }
                    boolean z1 = p0.e(v3);
                    zc.l l2 = p0.N();
                    if((v1 & 0x380) == 0x100 || z1 || l2 == v4) {
                        l2 = new zc.l(v3, 1, n1);
                        p0.l0(l2);
                    }
                    boolean z2 = p0.e(v3);
                    zc.l l3 = p0.N();
                    if((v1 & 0x1C00) == 0x800 || z2 || l3 == v4) {
                        l3 = new zc.l(v3, 2, n2);
                        p0.l0(l3);
                    }
                    o.b(v3, graphDataListInfo$GRAPHCHARTINFO0, l1, l2, l3, p0, 0);
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            A7.d.v(n3, 20.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.i(list0, n0, n1, n2, v, 5);
        }
    }

    public static final void b(int v, GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0, we.k k0, we.k k1, we.k k2, l l0, int v1) {
        String s3;
        String s1;
        p p0 = (p)l0;
        p0.c0(1483033082);
        int v2 = v1 | (p0.e(v) ? 4 : 2) | (p0.i(graphDataListInfo$GRAPHCHARTINFO0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(k1) ? 0x800 : 0x400) | (p0.i(k2) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            r0.n n0 = r0.n.a;
            q q0 = androidx.compose.foundation.layout.d.h(n0, 60.0f);
            p0 p00 = M.n0.a(j.a, d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 20.0f));
            q q2 = d5.n.o(androidx.compose.foundation.layout.d.n(n0, 44.0f), e.b(4.0f));
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d0 = e.b(4.0f);
            c1.n(a.a(androidx.compose.foundation.q.j(q2, y0.a, y0.b, d0), new zc.n(graphDataListInfo$GRAPHCHARTINFO0, k1, 0)), (graphDataListInfo$GRAPHCHARTINFO0 == null ? null : graphDataListInfo$GRAPHCHARTINFO0.albumImgLarge), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFC);
            N1.b(String.valueOf(v + 1), androidx.compose.foundation.layout.a.l(n0, 15.0f, 0.0f, 2), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray900s
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y1 = w.a(j.c, d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            if(graphDataListInfo$GRAPHCHARTINFO0 == null) {
                s1 = "";
            }
            else {
                String s = graphDataListInfo$GRAPHCHARTINFO0.songName;
                s1 = s == null ? "" : s;
            }
            N1.b(s1, null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray900s
            if(graphDataListInfo$GRAPHCHARTINFO0 == null) {
                s3 = "";
            }
            else {
                String s2 = graphDataListInfo$GRAPHCHARTINFO0.getArtistNames();
                s3 = s2 == null ? "" : s2;
            }
            N1.b(s3, null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
            q q4 = a.a(androidx.compose.foundation.layout.d.n(n0, 18.0f), new zc.n(graphDataListInfo$GRAPHCHARTINFO0, k0, 1));
            androidx.compose.foundation.q.c(I.Q(0x7F0807B2, p0, 6), null, q4, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:play
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
            q q5 = a.a(n0, new zc.n(graphDataListInfo$GRAPHCHARTINFO0, k2, 2));
            androidx.compose.foundation.q.c(I.Q(0x7F080159, p0, 6), null, q5, null, null, 0.0f, null, p0, 0x30, 120);  // drawable:btn_common_moreview_01
            x.z(n0, 8.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new I2(v, graphDataListInfo$GRAPHCHARTINFO0, k0, k1, k2, v1);
        }
    }
}

