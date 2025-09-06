package ud;

import Cc.N1;
import Cc.a0;
import Cc.c1;
import H0.e;
import M.c;
import M.j;
import M.w;
import M.y;
import N0.M;
import O.F;
import O.I;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.lyric.LyricsInfo;
import e1.m;
import gd.M6;
import gd.T7;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import r0.d;
import r0.n;
import r0.q;

public abstract class a {
    public static final b a;
    public static final b b;
    public static final b c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;

    static {
        a.a = new b(-2005641956, new sd.a(4), false);
        a.b = new b(2023160121, new sd.a(5), false);
        a.c = new b(1323751330, new sd.a(6), false);
    }

    public static final void a(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x203901D);
        if(p0.Q(v & 1, v != 0)) {
            y y0 = w.a(j.c, d.m, p0, 0);
            int v1 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            q q0 = r0.a.d(p0, n0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 9.5f));
            N1.b(e.Y(p0, 0x7F13038E), null, ye.a.v(p0, 0x7F0604C1), 13.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // string:empty_lyrics "등록된 가사가 없습니다"
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new M6(v, 21);
        }
    }

    public static final void b(q q0, F f0, List list0, Integer integer0, l l0, int v) {
        ((p)l0).c0(-1568413078);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(f0) ? 0x20 : 16) | (((p)l0).i(list0) ? 0x100 : 0x80) | (((p)l0).g(integer0) ? 0x800 : 0x400);
        boolean z = false;
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            ((p)l0).V();
            if((v & 1) != 0 && !((p)l0).B()) {
                ((p)l0).T();
            }
            ((p)l0).q();
            boolean z1 = ((p)l0).i(list0);
            if((v1 & 0x1C00) == 0x800) {
                z = true;
            }
            m9.l l1 = ((p)l0).N();
            if(z1 || z || l1 == androidx.compose.runtime.k.a) {
                l1 = new m9.l(17, list0, integer0);
                ((p)l0).l0(l1);
            }
            c1.o(q0, f0, null, false, null, null, null, false, l1, ((p)l0), v1 & 0x7E, 0xFC);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new td.i(q0, f0, list0, integer0, v, 1);
        }
    }

    public static final void c(q q0, List list0, l l0, int v) {
        ((p)l0).c0(0x8C520779);
        int v1 = (((p)l0).g(q0) ? 4 : 2) | v | (((p)l0).i(list0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            boolean z = ((p)l0).i(list0);
            Bd.l l1 = ((p)l0).N();
            if(z || l1 == androidx.compose.runtime.k.a) {
                l1 = new Bd.l(list0, 3);
                ((p)l0).l0(l1);
            }
            c1.o(q0, null, null, false, null, null, null, false, l1, ((p)l0), v1 & 14, 0xFE);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new T7(q0, list0, v, 26);
        }
    }

    public static final void d(String s, boolean z, l l0, int v) {
        n n1;
        kotlin.jvm.internal.q.g(s, "lyric");
        p p0 = (p)l0;
        p0.c0(0xD35134B0);
        int v1 = v | (p0.g(s) ? 4 : 2);
        if((v & 0x30) == 0) {
            v1 |= (p0.h(z) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            y y0 = w.a(j.c, d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            q q0 = r0.a.d(p0, n0);
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
            androidx.compose.runtime.w.x(p0, q0, h3);
            q q1 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 15.5f);
            M m0 = M.p.d(d.d, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            androidx.compose.runtime.w.x(p0, q2, h3);
            if(z) {
                p0.a0(0x15112F58);
                n1 = n0;
                N1.b(s, null, ye.a.v(p0, 0x7F0604C2), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:white_90
            }
            else {
                n1 = n0;
                p0.a0(0x15159AD8);
                N1.b(s, null, ye.a.v(p0, 0x7F0604C0), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:white_60
            }
            p0.p(false);
            p0.p(true);
            A7.d.v(n1, 5.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new ud.e(v, 0, z, s);
        }
    }

    public static final void e(q q0, d9.h h0, we.a a0, l l0, int v) {
        je.w w1;
        ArrayList arrayList0;
        r0.i i0 = d.e;
        kotlin.jvm.internal.q.g(a0, "onClick");
        p p0 = (p)l0;
        p0.c0(1854617701);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(h0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            q q1 = r0.a.a(q0, new a0(0, 0, null, a0, true));
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            p0.a0(-512505721);
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = androidx.compose.runtime.w.s(Boolean.TRUE);
                p0.l0(b00);
            }
            if(h0 == null) {
                p0.a0(0xE173E9B4);
                a.a(p0, 0);
            }
            else {
                p0.a0(0xE15651B7);
                p0.p(false);
                b0 b01 = m.x(h0.k, p0);
                b0 b02 = m.x(h0.h, p0);
                boolean z = p0.g(((List)b01.getValue()));
                Boolean boolean0 = p0.N();
                if(z || boolean0 == v3) {
                    boolean0 = Boolean.valueOf(h0.i);
                    p0.l0(boolean0);
                }
                boolean z1 = boolean0.booleanValue();
                boolean z2 = p0.g(((List)b01.getValue()));
                Boolean boolean1 = p0.N();
                if(z2 || boolean1 == v3) {
                    boolean1 = Boolean.valueOf(h0.j);
                    p0.l0(boolean1);
                }
                boolean z3 = boolean1.booleanValue();
                List list0 = (List)b01.getValue();
                Integer integer0 = (Integer)b02.getValue();
                if(!z1 || list0 == null || list0.isEmpty()) {
                    p0.a0(0xE17B460B);
                    a.a(p0, 0);
                }
                else {
                    n n0 = n.a;
                    je.w w0 = je.w.a;
                    androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                    if(z3) {
                        p0.a0(-511936500);
                        q q3 = b0.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 36.0f), i0);
                        List list1 = (List)b01.getValue();
                        if(list1 == null) {
                            arrayList0 = w0;
                        }
                        else {
                            arrayList0 = new ArrayList(je.q.Q(10, list1));
                            for(Object object0: list1) {
                                String s = ((LyricsInfo)object0).b;
                                if(s == null) {
                                    s = "";
                                }
                                arrayList0.add(s);
                            }
                        }
                        a.c(q3, arrayList0, p0, 0);
                    }
                    else {
                        p0.a0(0xE181C5C0);
                        F f0 = I.a(0, 0, 3, p0);
                        boolean z4 = p0.g(integer0);
                        boolean z5 = p0.g(f0);
                        f f1 = p0.N();
                        if(z4 || z5 || f1 == v3) {
                            f1 = new f(integer0, f0, b00, null);
                            p0.l0(f1);
                        }
                        J.d(p0, integer0, f1);
                        CoroutineScope coroutineScope0 = p0.N();
                        if(coroutineScope0 == v3) {
                            coroutineScope0 = J.i(p0);
                            p0.l0(coroutineScope0);
                        }
                        ud.h h2 = p0.N();
                        if(h2 == v3) {
                            h2 = new ud.h(coroutineScope0, f0, h0);
                            p0.l0(h2);
                        }
                        q q4 = b0.a(androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 36.0f), h2, null), i0);
                        List list2 = (List)b01.getValue();
                        if(list2 == null) {
                            w1 = w0;
                        }
                        else {
                            ArrayList arrayList1 = new ArrayList(je.q.Q(10, list2));
                            for(Object object1: list2) {
                                String s1 = ((LyricsInfo)object1).b;
                                if(s1 == null) {
                                    s1 = "";
                                }
                                arrayList1.add(s1);
                            }
                            w1 = arrayList1;
                        }
                        a.b(q4, f0, w1, ((Integer)b02.getValue()), p0, 0);
                    }
                }
            }
            p0.p(false);
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(q0, h0, a0, v, 18);
        }
    }
}

