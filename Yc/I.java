package yc;

import Ac.Y1;
import Ac.i2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Dd.k2;
import De.I;
import M.c;
import M.j;
import M.p0;
import M.w;
import M.y;
import N0.M;
import P0.h;
import Rc.r;
import T.e;
import Tf.u;
import androidx.compose.foundation.D0;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
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
import bd.F;
import com.iloen.melon.net.v4x.common.GraphDataListInfo;
import com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.K4;
import d5.n;
import java.util.ArrayList;
import java.util.List;
import jd.Z0;
import kotlinx.coroutines.CoroutineScope;
import r0.a;
import r0.g;
import r0.q;
import we.k;
import zc.H;
import zc.o;
import zc.s;

public abstract class i {
    public static final void a(k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xF09321);
        int v1 = (v & 6) == 0 ? (p0.i(k0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            q q0 = a.a(n.o(androidx.compose.foundation.q.f(d.h(d.f(androidx.compose.foundation.layout.a.l(r0.n.a, 20.0f, 0.0f, 2), 1.0f), 48.0f), e0.T(p0, 0x7F060145), e.b(4.0f)), e.b(4.0f)), new Z0(15, k0));  // color:gray050s
            y y0 = w.a(j.e, r0.d.n, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            N1.b("", null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new r(k0, v, 4);
        }
    }

    public static final void b(RESPONSE fiveMinuteChartGraphRes$RESPONSE0, float f, k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1090419050);
        int v1 = v | (p0.i(fiveMinuteChartGraphRes$RESPONSE0) ? 4 : 2) | (p0.d(f) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            a0 a00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(a00 == v2) {
                a00 = androidx.compose.runtime.w.p(0);
                p0.l0(a00);
            }
            List list0 = fiveMinuteChartGraphRes$RESPONSE0.getFiveChartGraphList();
            je.w w0 = je.w.a;
            List list1 = list0 == null ? w0 : list0;
            if(list1.isEmpty()) {
                p0.a0(1814788056);
            }
            else {
                p0.a0(1836636205);
                r0.n n0 = r0.n.a;
                q q0 = d.f(n0, 1.0f);
                y y0 = w.a(j.c, r0.d.n, p0, 0x30);
                int v3 = p0.P;
                i0 i00 = p0.m();
                q q1 = a.d(p0, q0);
                P0.k.y.getClass();
                P0.i i0 = P0.j.b;
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
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h0);
                }
                androidx.compose.runtime.w.x(p0, q1, P0.j.d);
                int v4 = ((K0)a00).m();
                xc.q q2 = p0.N();
                if((v1 & 0x380) == 0x100 || q2 == v2) {
                    q2 = new xc.q(4, ((K0)a00), k0);
                    p0.l0(q2);
                }
                Rc.q q3 = p0.N();
                if((v1 & 0x380) == 0x100 || q3 == v2) {
                    q3 = new Rc.q(8, k0);
                    p0.l0(q3);
                }
                s.a(list1, v4, q2, q3, p0, 0);
                int v5 = ((K0)a00).m();
                List list2 = fiveMinuteChartGraphRes$RESPONSE0.getXLabels();
                if(list2 == null) {
                    list2 = w0;
                }
                zc.j.a(v5, list2, list1, null, f, p0, v1 << 9 & 0xE000);
                c.d(p0, d.h(n0, 3.0f));
                Rc.q q4 = p0.N();
                if((v1 & 0x380) == 0x100 || q4 == v2) {
                    q4 = new Rc.q(9, k0);
                    p0.l0(q4);
                }
                Rc.q q5 = p0.N();
                if((v1 & 0x380) == 0x100 || q5 == v2) {
                    q5 = new Rc.q(10, k0);
                    p0.l0(q5);
                }
                Rc.q q6 = p0.N();
                if((v1 & 0x380) == 0x100 || q6 == v2) {
                    q6 = new Rc.q(11, k0);
                    p0.l0(q6);
                }
                o.a(list1, q4, q5, q6, p0, 0);
                if(list1.isEmpty()) {
                    p0.a0(0xA37CFD29);
                }
                else {
                    p0.a0(0xA4E18011);
                    i.a(k0, p0, v1 >> 6 & 14);
                }
                p0.p(false);
                c.d(p0, d.h(n0, 40.0f));
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new yc.c(fiveMinuteChartGraphRes$RESPONSE0, f, k0, v, 0);
        }
    }

    public static final void c(String s, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1448420185);
        int v1 = v | (p0.g(s) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.n n0 = r0.n.a;
            q q0 = d.f(n0, 1.0f);
            y y0 = w.a(j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c.d(p0, d.h(n0, 101.0f));
            q q2 = d.n(n0, 79.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F080786, p0, 6), null, q2, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:noimage_logo_large
            c.d(p0, d.h(n0, 13.0f));
            N1.b(s, null, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 22.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 6, 0x1F9F2);  // color:gray700s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new k2(s, v, 7);
        }
    }

    public static final void d(K4 k40, k k0, l l0, int v) {
        int v4;
        ((p)l0).c0(1585086828);
        int v1 = (((p)l0).g(k40) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            a0 a00 = ((p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if(a00 == v2) {
                a00 = androidx.compose.runtime.w.p(0);
                ((p)l0).l0(a00);
            }
            a0 a01 = ((p)l0).N();
            if(a01 == v2) {
                a01 = androidx.compose.runtime.w.p(0);
                ((p)l0).l0(a01);
            }
            a0 a02 = ((p)l0).N();
            if(a02 == v2) {
                a02 = androidx.compose.runtime.w.p(0);
                ((p)l0).l0(a02);
            }
            CoroutineScope coroutineScope0 = ((p)l0).N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(((p)l0));
                ((p)l0).l0(coroutineScope0);
            }
            Q0 q00 = androidx.compose.foundation.q.t(((p)l0));
            if(q00.f.b()) {
                if(((K0)a01).m() >= q00.g()) {
                    int v3 = ((K0)a00).m();
                    v4 = Math.min(Math.abs(((K0)a01).m() - q00.g()) + v3, 0);
                }
                else {
                    v4 = Math.max(((K0)a00).m() - Math.abs(((K0)a01).m() - q00.g()), -ViewUtilsKt.dpToPx(68.0f));
                }
                ((K0)a00).n(v4);
                ((K0)a01).n(q00.g());
                ((K0)a02).n(((K0)a00).m());
            }
            androidx.compose.runtime.w.a(D0.a.a(null), m0.c.e(112096812, ((p)l0), new F(k40, q00, k0, a02, coroutineScope0, a00, a01)), ((p)l0), 56);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new yc.d(k40, k0, v, 1);
        }
    }

    public static final void e(com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE oneHourChartGraphRes$RESPONSE0, float f, k k0, l l0, int v) {
        h h11;
        h h10;
        h h9;
        h h8;
        P0.i i5;
        M.d d2;
        g g1;
        float f1;
        int v11;
        List list9;
        Integer integer0;
        r0.n n3;
        K0 k01;
        List list5;
        r0.n n2;
        h h7;
        r0.i i4;
        String s2;
        ArrayList arrayList1;
        P0.i i3;
        int v9;
        h h6;
        b0 b02;
        M.d d1;
        r0.n n1;
        b0 b01;
        h h5;
        K0 k00;
        h h4;
        CoroutineScope coroutineScope1;
        String s1;
        p p0 = (p)l0;
        p0.c0(-997807662);
        int v1 = v | (p0.i(oneHourChartGraphRes$RESPONSE0) ? 4 : 2) | (p0.d(f) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            a0 a00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(a00 == v2) {
                a00 = androidx.compose.runtime.w.p(0);
                p0.l0(a00);
            }
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            List list0 = oneHourChartGraphRes$RESPONSE0.getChartGraphList();
            je.w w0 = je.w.a;
            if(list0 == null) {
                list0 = w0;
            }
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                String s = ((GraphDataListInfo)object0).shareValue;
                kotlin.jvm.internal.q.f(s, "shareValue");
                arrayList0.add(Float.parseFloat(s));
            }
            GraphDataListInfo graphDataListInfo0 = (GraphDataListInfo)je.p.n0(((K0)a00).m(), list0);
            List list1 = graphDataListInfo0 == null ? null : graphDataListInfo0.rankDataList;
            if(list1 == null) {
                list1 = w0;
            }
            GraphDataListInfo graphDataListInfo1 = (GraphDataListInfo)je.p.n0(((K0)a00).m(), list0);
            if(graphDataListInfo1 == null) {
                s1 = "";
            }
            else {
                s1 = graphDataListInfo1.peekTime;
                if(s1 == null) {
                    s1 = "";
                }
            }
            GraphDataListInfo graphDataListInfo2 = (GraphDataListInfo)je.p.n0(((K0)a00).m(), list0);
            int v3 = graphDataListInfo2 == null ? 0 : graphDataListInfo2.firstRankSerialCount;
            b0 b00 = p0.N();
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(zc.d.f);
                p0.l0(b00);
            }
            if(list0.isEmpty()) {
                p0.a0(0xF1FAD210);
            }
            else {
                p0.a0(0xF2FA68E4);
                r0.n n0 = r0.n.a;
                q q0 = d.f(n0, 1.0f);
                M.d d0 = j.c;
                y y0 = w.a(d0, r0.d.m, p0, 0);
                int v4 = p0.P;
                i0 i00 = p0.m();
                q q1 = a.d(p0, q0);
                P0.k.y.getClass();
                g g0 = r0.d.m;
                P0.i i0 = P0.j.b;
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
                    coroutineScope1 = coroutineScope0;
                    A7.d.q(v4, p0, v4, h2);
                }
                else {
                    coroutineScope1 = coroutineScope0;
                    if(!kotlin.jvm.internal.q.b(p0.N(), v4)) {
                        A7.d.q(v4, p0, v4, h2);
                    }
                }
                h h3 = P0.j.d;
                androidx.compose.runtime.w.x(p0, q1, h3);
                M m0 = M.p.d(r0.d.a, false);
                int v5 = p0.P;
                r0.i i1 = r0.d.a;
                i0 i01 = p0.m();
                q q2 = a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m0, h0);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                androidx.compose.runtime.w.x(p0, q2, h3);
                q q3 = d.f(n0, 1.0f);
                y y1 = w.a(d0, r0.d.n, p0, 0x30);
                int v6 = p0.P;
                i0 i02 = p0.m();
                q q4 = a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y1, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
                androidx.compose.runtime.w.x(p0, q4, h3);
                List list2 = oneHourChartGraphRes$RESPONSE0.getChartGraphList();
                List list3 = list2 == null ? w0 : list2;
                int v7 = ((K0)a00).m();
                yc.e e0 = p0.N();
                if((v1 & 0x380) == 0x100 || e0 == v2) {
                    h4 = h3;
                    k00 = (K0)a00;
                    e0 = new yc.e(k00, b00, k0);
                    p0.l0(e0);
                }
                else {
                    h4 = h3;
                    k00 = (K0)a00;
                }
                Rc.q q5 = p0.N();
                if((v1 & 0x380) == 0x100 || q5 == v2) {
                    h5 = h1;
                    q5 = new Rc.q(7, k0);
                    p0.l0(q5);
                }
                else {
                    h5 = h1;
                }
                s.a(list3, v7, e0, q5, p0, 0);
                if(list0.isEmpty()) {
                    b01 = b00;
                    n1 = n0;
                    p0.a0(1176209827);
                }
                else {
                    p0.a0(0x47291955);
                    int v8 = k00.m();
                    List list4 = oneHourChartGraphRes$RESPONSE0.getXLabels();
                    if(list4 == null) {
                        list4 = w0;
                    }
                    boolean z = p0.i(coroutineScope1);
                    ed.i i2 = p0.N();
                    if((v1 & 0x380) == 0x100 || z || i2 == v2) {
                        i2 = new ed.i(b00, coroutineScope1, k0, 5);
                        p0.l0(i2);
                    }
                    b01 = b00;
                    n1 = n0;
                    H.a(v8, list4, list0, true, f, null, i2, p0, v1 << 12 & 0x70000 | 0xC00);
                }
                p0.p(false);
                p0.p(true);
                if(b01.getValue() == zc.d.b) {
                    p0.a0(-753486709);
                    d1 = d0;
                    b02 = b01;
                    h6 = h0;
                    v9 = v3;
                    i3 = i0;
                    arrayList1 = arrayList0;
                    s2 = s1;
                    i4 = i1;
                    h7 = h4;
                    n2 = n1;
                    list5 = list1;
                    k01 = k00;
                    c1.n(d.f(n1, 1.0f), 0x7F0800A2, null, null, false, 0, null, null, null, 0.0f, null, 0, 1, false, false, p0, 0x6036, 0x180, 0x6FEC);  // drawable:artist_channel_confetti_900kb
                }
                else {
                    h6 = h0;
                    v9 = v3;
                    i3 = i0;
                    arrayList1 = arrayList0;
                    n2 = n1;
                    d1 = d0;
                    b02 = b01;
                    s2 = s1;
                    list5 = list1;
                    i4 = i1;
                    h7 = h4;
                    k01 = k00;
                    p0.a0(0xD1FAE679);
                }
                p0.p(false);
                if(b02.getValue() == zc.d.c) {
                    p0.a0(0xD31C3FE2);
                    q q6 = d.n(n2, 360.0f);
                    c1.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.h), 0x7F080947, null, null, false, 0, null, null, null, 0.0f, null, 0, 1, false, false, p0, 0x6030, 0x180, 0x6FEC);  // drawable:webp_graph_bg_02
                    p0.p(false);
                    n3 = n2;
                }
                else {
                    n3 = n2;
                    p0.a0(0xD1FAE679);
                    p0.p(false);
                }
                p0.p(true);
                c.d(p0, d.h(n3, 35.0f));
                d5.w.a(s2, v9, k01.m(), p0, 0);
                c.d(p0, d.h(n3, 50.0f));
                List list6 = oneHourChartGraphRes$RESPONSE0.getChartGraphList();
                if(list6 == null) {
                    integer0 = null;
                }
                else {
                    GraphDataListInfo graphDataListInfo3 = (GraphDataListInfo)list6.get(k01.m());
                    integer0 = graphDataListInfo3 == null ? null : graphDataListInfo3.graphTop7;
                }
                if(integer0 == null) {
                    p0.a0(595257028);
                }
                else {
                    p0.a0(595257029);
                    if(integer0.intValue() > 0) {
                        p0.a0(-1897610425);
                        int v10 = k01.m();
                        List list7 = oneHourChartGraphRes$RESPONSE0.getXLabels();
                        if(list7 == null) {
                            list7 = w0;
                        }
                        List list8 = oneHourChartGraphRes$RESPONSE0.getChartGraphList();
                        if(list8 == null) {
                            list9 = null;
                        }
                        else {
                            GraphDataListInfo graphDataListInfo4 = (GraphDataListInfo)list8.get(k01.m());
                            list9 = graphDataListInfo4 == null ? null : graphDataListInfo4.graphDataList;
                        }
                        if(list9 == null) {
                            list9 = w0;
                        }
                        List list10 = oneHourChartGraphRes$RESPONSE0.getChartGraphList();
                        if(list10 == null) {
                            v11 = 0;
                        }
                        else {
                            GraphDataListInfo graphDataListInfo5 = (GraphDataListInfo)list10.get(k01.m());
                            v11 = graphDataListInfo5 == null ? 0 : graphDataListInfo5.graphTop7;
                        }
                        String s3 = oneHourChartGraphRes$RESPONSE0.getStandard();
                        if(s3 == null) {
                            f1 = 0.0f;
                        }
                        else {
                            Float float0 = u.g0(s3);
                            f1 = float0 == null ? 0.0f : ((float)float0);
                        }
                        zc.w.a(v10, list7, list9, v11, f1, null, p0, 0);
                        A7.d.v(n3, 20.0f, p0, false);
                    }
                    else {
                        p0.a0(0x8DB827F5);
                        p0.p(false);
                    }
                }
                p0.p(false);
                if(arrayList1.isEmpty()) {
                    h8 = h6;
                    g1 = g0;
                    i5 = i3;
                    h9 = h5;
                    h10 = h2;
                    d2 = d1;
                    h11 = h7;
                    p0.a0(0x224F327F);
                    p0.p(false);
                }
                else {
                    p0.a0(595923560);
                    g1 = g0;
                    d2 = d1;
                    y y2 = w.a(d2, g1, p0, 0);
                    int v12 = p0.P;
                    i0 i03 = p0.m();
                    q q7 = a.d(p0, n3);
                    p0.e0();
                    if(p0.O) {
                        i5 = i3;
                        p0.l(i5);
                    }
                    else {
                        i5 = i3;
                        p0.o0();
                    }
                    h8 = h6;
                    androidx.compose.runtime.w.x(p0, y2, h8);
                    h9 = h5;
                    androidx.compose.runtime.w.x(p0, i03, h9);
                    if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v12)) {
                        h10 = h2;
                    }
                    else {
                        h10 = h2;
                        A7.d.q(v12, p0, v12, h10);
                    }
                    h11 = h7;
                    androidx.compose.runtime.w.x(p0, q7, h11);
                    q q8 = androidx.compose.foundation.layout.a.l(n3, 20.0f, 0.0f, 2);
                    M m1 = M.p.d(i4, false);
                    int v13 = p0.P;
                    i0 i04 = p0.m();
                    q q9 = a.d(p0, q8);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i5);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m1, h8);
                    androidx.compose.runtime.w.x(p0, i04, h9);
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v13)) {
                        A7.d.q(v13, p0, v13, h10);
                    }
                    androidx.compose.runtime.w.x(p0, q9, h11);
                    d8.d.f(k01.m(), arrayList1, null, p0, 0);
                    A7.d.s(p0, true, true, false);
                }
                if(list5.isEmpty()) {
                    p0.a0(0x224F327F);
                }
                else {
                    p0.a0(0x238B10C9);
                    y y3 = w.a(d2, g1, p0, 0);
                    int v14 = p0.P;
                    i0 i05 = p0.m();
                    q q10 = a.d(p0, n3);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i5);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, y3, h8);
                    androidx.compose.runtime.w.x(p0, i05, h9);
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v14)) {
                        A7.d.q(v14, p0, v14, h10);
                    }
                    androidx.compose.runtime.w.x(p0, q10, h11);
                    c.d(p0, d.h(n3, 40.0f));
                    c.a(androidx.compose.foundation.layout.a.l(n3, 20.0f, 0.0f, 2), null, false, m0.c.e(0x1C15D3C1, p0, new i2(k01, list5, oneHourChartGraphRes$RESPONSE0, 6)), p0, 0xC06, 6);
                    p0.p(true);
                }
                p0.p(false);
                c.d(p0, d.h(n3, 5.0f));
                if(list0.isEmpty()) {
                    p0.a0(0x224F327F);
                }
                else {
                    p0.a0(0x2394DC27);
                    i.a(k0, p0, v1 >> 6 & 14);
                }
                p0.p(false);
                c.d(p0, d.h(n3, 40.0f));
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new yc.c(oneHourChartGraphRes$RESPONSE0, f, k0, v, 1);
        }
    }

    public static final void f(String s, String s1, k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1702641350);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            r0.n n0 = r0.n.a;
            q q0 = d.f(n0, 1.0f);
            p0 p00 = M.n0.a(j.e, r0.d.k, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c.d(p0, d.q(n0, 5.0f));
            N1.b(s, null, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 0, 0x1FFF2);  // color:gray600s_support_high_contrast
            c.d(p0, androidx.compose.foundation.q.f(n.o(d.n(androidx.compose.foundation.layout.a.l(n0, 3.0f, 0.0f, 2), 2.0f), e.a), e0.T(p0, 0x7F060154), y0.M.a));  // color:gray200s_support_high_contrast
            N1.b(s1, null, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 3 & 14 | 0xC00, 0, 0x1FFF2);  // color:gray600s_support_high_contrast
            c.d(p0, d.q(n0, 5.0f));
            q q2 = a.a(d.n(n0, 20.0f), new Z0(16, k0));
            androidx.compose.foundation.q.c(I.Q(0x7F08024E, p0, 6), "", q2, null, null, 0.0f, null, p0, 0, 120);  // drawable:btn_refresh_20
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new vd.n(v, 1, s, s1, k0);
        }
    }

    public static final void g(K4 k40, k k0, l l0, int v) {
        String s2;
        String s1;
        p p0 = (p)l0;
        p0.c0(0x500A6EB9);
        int v1 = (p0.g(k40) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            long v2 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            r0.n n0 = r0.n.a;
            q q0 = d.h(androidx.compose.foundation.q.f(n0, v2, y0.M.a), 68.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            Y1 y10 = p0.N();
            if((v1 & 0x70) == 0x20 || y10 == androidx.compose.runtime.k.a) {
                y10 = new Y1(12, k0);
                p0.l0(y10);
            }
            androidx.compose.ui.viewinterop.a.a(y10, null, null, p0, 0, 6);
            q q2 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.h);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            String s = "";
            if(k40 instanceof m) {
                s1 = ((m)k40).a.getRankDay();
                if(s1 == null) {
                    s1 = "";
                }
            }
            else if(k40 instanceof yc.k) {
                s1 = ((yc.k)k40).a.getRankDay();
                if(s1 == null) {
                    s1 = "";
                }
            }
            else {
                s1 = "";
            }
            if(k40 instanceof m) {
                s2 = ((m)k40).a.getRankHour();
                if(s2 != null) {
                    s = s2;
                }
            }
            else if(k40 instanceof yc.k) {
                s2 = ((yc.k)k40).a.getRankHour();
                if(s2 != null) {
                    s = s2;
                }
            }
            i.f(s1, s, k0, p0, v1 << 3 & 0x380);
            c.d(p0, d.h(n0, 10.0f));
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new yc.d(k40, k0, v, 0);
        }
    }
}

