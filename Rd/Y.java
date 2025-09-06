package rd;

import android.graphics.Point;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import cd.x1;
import com.iloen.melon.playback.Playable;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import d9.h;
import ie.H;
import ie.m;
import jd.N2;
import kotlin.jvm.internal.q;
import ld.j;
import pb.r;
import pc.b;
import va.e0;
import we.a;
import we.n;

public final class y implements n {
    public final int a;
    public final P b;

    public y(P p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        h h1;
        String s13;
        N2 n20;
        boolean z41;
        String s12;
        String s11;
        String s10;
        String s9;
        int v8;
        String s8;
        String s7;
        boolean z39;
        boolean z38;
        a a10;
        b0 b013;
        boolean z35;
        b0 b012;
        b1 b10;
        boolean z25;
        M m0;
        V v6;
        Boolean boolean2;
        switch(this.a) {
            case 0: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    P p2 = this.b;
                    Object object3 = B.a.r(((K1)p2.getViewModel()).q, ((p)(((l)object0))), 0).getValue();
                    b b0 = null;
                    D0 d00 = object3 instanceof D0 ? ((D0)object3) : null;
                    if(d00 != null) {
                        boolean z19 = ((Boolean)B.a.r(((K1)p2.getViewModel()).G, ((p)(((l)object0))), 0).getValue()).booleanValue();
                        FillElement fillElement1 = d.c;
                        DjMalrangInfo djMalrangInfo0 = d00.a;
                        if(djMalrangInfo0 != null) {
                            b0 = djMalrangInfo0.i;
                        }
                        rd.a.b(fillElement1, b0, z19, 0L, 0L, ((p)(((l)object0))), 6);
                        return H.a;
                    }
                }
                else {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            case 1: {
                S0 s00 = new S0(((int)(((Integer)object0))), ((long)(((Long)object1))));
                this.b.sendUserEvent(s00);
                return H.a;
            }
            case 2: {
                R0 r00 = new R0(((int)(((Integer)object0))), ((long)(((Long)object1))));
                this.b.sendUserEvent(r00);
                return H.a;
            }
            case 3: {
                int v3 = (int)(((Integer)object1));
                p p3 = (p)(((l)object0));
                if(p3.Q(v3 & 1, (v3 & 3) != 2)) {
                    P p4 = this.b;
                    Object object4 = B.a.r(((K1)p4.getViewModel()).q, p3, 0).getValue();
                    D0 d01 = object4 instanceof D0 ? ((D0)object4) : null;
                    if(d01 != null) {
                        b0 b01 = B.a.r(((K1)p4.getViewModel()).t, p3, 0);
                        b0 b02 = B.a.r(((K1)p4.getViewModel()).B, p3, 0);
                        b0 b03 = B.a.r(((K1)p4.getViewModel()).s, p3, 0);
                        b0 b04 = B.a.r(((K1)p4.getViewModel()).u, p3, 0);
                        Object object5 = B.a.r(((K1)p4.getViewModel()).v, p3, 0).getValue();
                        b0 b05 = B.a.r(((K1)p4.getViewModel()).G, p3, 0);
                        b0 b06 = B.a.r(((K1)p4.getViewModel()).I, p3, 0);
                        b0 b07 = B.a.r(p4.j, p3, 0);
                        b0 b08 = B.a.r(((K1)p4.getViewModel()).x, p3, 0);
                        b0 b09 = B.a.r(((K1)p4.getViewModel()).z, p3, 0);
                        b0 b010 = p3.N();
                        V v4 = k.a;
                        if(b010 == v4) {
                            b010 = w.s(Boolean.TRUE);
                            p3.l0(b010);
                        }
                        b0 b011 = p3.N();
                        if(b011 == v4) {
                            b011 = w.s(new m(0.0f, 0.0f));
                            p3.l0(b011);
                        }
                        E e0 = p3.N();
                        if(e0 == v4) {
                            e0 = w.i(new Cc.b0(b04, 9));
                            p3.l0(e0);
                        }
                        Boolean boolean1 = (Boolean)b05.getValue();
                        boolean z20 = boolean1.booleanValue();
                        boolean z21 = !((Boolean)b010.getValue()).booleanValue() && !p4.l && ((DjMalrangPlayerViewCalculator)p4.k.getValue()).a(((Point)b07.getValue())).x > 0;
                        Long long0 = p3.N();
                        if(long0 == v4) {
                            long0 = 300L;
                            p3.l0(300L);
                        }
                        long v5 = long0.longValue();
                        boolean z22 = p3.h(z20);
                        boolean z23 = p3.h(z21);
                        boolean z24 = p3.i(p4);
                        Object object6 = p3.N();
                        if((z22 | z23 | z24) == 0 && object6 != v4) {
                            m0 = object6;
                            boolean2 = boolean1;
                            z25 = z20;
                            v6 = v4;
                        }
                        else {
                            boolean2 = boolean1;
                            v6 = v4;
                            m0 = new M(z20, z21, p4, v5, b010, b011, null);
                            z25 = z20;
                            p3.l0(m0);
                        }
                        J.d(p3, boolean2, m0);
                        b b1 = d01.a == null ? null : d01.a.i;
                        String s = d01.i.toString();
                        q.f(s, "toString(...)");
                        boolean z26 = p3.i(p4);
                        A a1 = p3.N();
                        if(z26 || a1 == v6) {
                            a1 = new A(p4, 4);
                            p3.l0(a1);
                        }
                        x1 x10 = p3.N();
                        if(x10 == v6) {
                            x10 = new x1(b011, 1);
                            p3.l0(x10);
                        }
                        String s1 = d01.g;
                        String s2 = d01.h;
                        boolean z27 = p3.i(p4);
                        A a2 = p3.N();
                        if(z27 || a2 == v6) {
                            a2 = new A(p4, 11);
                            p3.l0(a2);
                        }
                        boolean z28 = p3.i(p4);
                        A a3 = p3.N();
                        if(z28 || a3 == v6) {
                            a3 = new A(p4, 12);
                            p3.l0(a3);
                        }
                        boolean z29 = p3.i(p4);
                        A a4 = p3.N();
                        if(z29 || a4 == v6) {
                            a4 = new A(p4, 13);
                            p3.l0(a4);
                        }
                        String s3 = d01.b;
                        String s4 = d01.c;
                        String s5 = d01.d;
                        String s6 = d01.e;
                        boolean z30 = p3.i(p4);
                        A a5 = p3.N();
                        if(z30 || a5 == v6) {
                            b10 = e0;
                            a5 = new A(p4, 14);
                            p3.l0(a5);
                        }
                        else {
                            b10 = e0;
                        }
                        boolean z31 = p3.i(p4);
                        A a6 = p3.N();
                        if(z31 || a6 == v6) {
                            b012 = b01;
                            a6 = new A(p4, 15);
                            p3.l0(a6);
                        }
                        else {
                            b012 = b01;
                        }
                        boolean z32 = p3.i(p4);
                        A a7 = p3.N();
                        if(z32 || a7 == v6) {
                            a7 = new A(p4, 16);
                            p3.l0(a7);
                        }
                        boolean z33 = d01.j;
                        int v7 = d01.k;
                        boolean z34 = p3.i(p4);
                        A a8 = p3.N();
                        if(z34 || a8 == v6) {
                            z35 = z33;
                            a8 = new A(p4, 17);
                            p3.l0(a8);
                        }
                        else {
                            z35 = z33;
                        }
                        boolean z36 = p3.i(p4);
                        A a9 = p3.N();
                        if(z36 || a9 == v6) {
                            a9 = new A(p4, 20);
                            p3.l0(a9);
                        }
                        h h0 = (h)b08.getValue();
                        boolean z37 = ((Boolean)b09.getValue()).booleanValue();
                        if(!((e0)((K1)p4.getViewModel()).f).m() || !((h)b08.getValue()).i) {
                            b013 = b02;
                            a10 = a3;
                            z38 = z35;
                            z39 = false;
                        }
                        else {
                            b013 = b02;
                            a10 = a3;
                            z38 = z35;
                            z39 = true;
                        }
                        boolean z40 = p3.i(p4);
                        Object object7 = p3.N();
                        if(!z40 && object7 != v6) {
                            n20 = object7;
                            s7 = s;
                            v8 = v7;
                            s9 = s2;
                            s10 = s3;
                            s12 = s4;
                            s8 = s6;
                            z41 = z37;
                            s11 = s5;
                        }
                        else {
                            s7 = s;
                            s8 = s6;
                            v8 = v7;
                            s9 = s2;
                            s10 = s3;
                            s11 = s5;
                            s12 = s4;
                            z41 = z37;
                            n20 = new N2(1, p4, P.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 21);
                            p3.l0(n20);
                        }
                        long v9 = ((ob.A)b012.getValue()).a;
                        long v10 = ((ob.A)b012.getValue()).b;
                        Long long1 = (Long)b013.getValue();
                        long v11 = ((Number)((m)b10.getValue()).a).longValue();
                        long v12 = ((Number)((m)b10.getValue()).b).longValue();
                        j j0 = p3.N();
                        if(j0 == v6) {
                            s13 = s7;
                            j0 = new j(26);
                            p3.l0(j0);
                        }
                        else {
                            s13 = s7;
                        }
                        boolean z42 = p3.i(p4);
                        z z43 = p3.N();
                        if(z42 || z43 == v6) {
                            h1 = h0;
                            z43 = new z(p4, 3);
                            p3.l0(z43);
                        }
                        else {
                            h1 = h0;
                        }
                        boolean z44 = p3.i(p4);
                        z z45 = p3.N();
                        if(z44 || z45 == v6) {
                            z45 = new z(p4, 0);
                            p3.l0(z45);
                        }
                        boolean z46 = p3.i(p4);
                        z z47 = p3.N();
                        if(z46 || z47 == v6) {
                            z47 = new z(p4, 1);
                            p3.l0(z47);
                        }
                        boolean z48 = p3.i(p4);
                        A a11 = p3.N();
                        if(z48 || a11 == v6) {
                            a11 = new A(p4, 0);
                            p3.l0(a11);
                        }
                        boolean z49 = p3.i(p4);
                        A a12 = p3.N();
                        if(z49 || a12 == v6) {
                            a12 = new A(p4, 1);
                            p3.l0(a12);
                        }
                        boolean z50 = ((Boolean)b03.getValue()).booleanValue();
                        boolean z51 = p3.i(p4);
                        A a13 = p3.N();
                        if(z51 || a13 == v6) {
                            a13 = new A(p4, 2);
                            p3.l0(a13);
                        }
                        boolean z52 = p3.i(p4);
                        A a14 = p3.N();
                        if(z52 || a14 == v6) {
                            a14 = new A(p4, 3);
                            p3.l0(a14);
                        }
                        boolean z53 = p3.i(p4);
                        y y0 = p3.N();
                        if(z53 || y0 == v6) {
                            y0 = new y(p4, 1);
                            p3.l0(y0);
                        }
                        boolean z54 = p3.i(p4);
                        A a15 = p3.N();
                        if(z54 || a15 == v6) {
                            a15 = new A(p4, 5);
                            p3.l0(a15);
                        }
                        boolean z55 = p3.i(p4);
                        y y1 = p3.N();
                        if(z55 || y1 == v6) {
                            y1 = new y(p4, 2);
                            p3.l0(y1);
                        }
                        boolean z56 = p3.i(p4);
                        A a16 = p3.N();
                        if(z56 || a16 == v6) {
                            a16 = new A(p4, 6);
                            p3.l0(a16);
                        }
                        boolean z57 = p3.i(p4);
                        A a17 = p3.N();
                        if(z57 || a17 == v6) {
                            a17 = new A(p4, 7);
                            p3.l0(a17);
                        }
                        boolean z58 = ((Boolean)b06.getValue()).booleanValue();
                        boolean z59 = p3.i(p4);
                        A a18 = p3.N();
                        if(z59 || a18 == v6) {
                            a18 = new A(p4, 8);
                            p3.l0(a18);
                        }
                        boolean z60 = p3.i(p4);
                        A a19 = p3.N();
                        if(z60 || a19 == v6) {
                            a19 = new A(p4, 9);
                            p3.l0(a19);
                        }
                        boolean z61 = p3.i(p4);
                        A a20 = p3.N();
                        if(z61 || a20 == v6) {
                            a20 = new A(p4, 10);
                            p3.l0(a20);
                        }
                        x.c(b1, s13, a1, (z21 ? 1000L : 0L), x10, s1, s9, a2, a10, a4, s10, s12, s11, s8, a5, a6, a7, z38, v8, a8, a9, h1, z41, z39, z25, n20, v9, v10, long1, v11, v12, j0, z43, z45, z47, a11, a12, z50, a13, a14, y0, a15, y1, a16, a17, z58, a18, ((String)object5), a19, a20, d01.l == r.l, p3, 0x6000);
                        return H.a;
                    }
                }
                else {
                    p3.T();
                }
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    P p1 = this.b;
                    Object object2 = B.a.r(((K1)p1.getViewModel()).D, p0, 0).getValue();
                    boolean z = ((Boolean)B.a.r(((K1)p1.getViewModel()).G, p0, 0).getValue()).booleanValue();
                    a0 a00 = ((rd.b0)object2) instanceof a0 ? ((a0)(((rd.b0)object2))) : null;
                    Playable playable0 = a00 == null ? null : a00.a.f;
                    FillElement fillElement0 = d.c;
                    boolean z1 = p0.i(p1);
                    boolean z2 = p0.i(playable0);
                    C c0 = p0.N();
                    V v1 = k.a;
                    if(z1 || z2 || c0 == v1) {
                        c0 = new C(p1, playable0);
                        p0.l0(c0);
                    }
                    boolean z3 = p0.i(playable0);
                    boolean z4 = p0.i(p1);
                    C c1 = p0.N();
                    if(z3 || z4 || c1 == v1) {
                        c1 = new C(playable0, p1, 1);
                        p0.l0(c1);
                    }
                    boolean z5 = p0.i(playable0);
                    boolean z6 = p0.i(p1);
                    C c2 = p0.N();
                    if(z5 || z6 || c2 == v1) {
                        c2 = new C(playable0, p1, 2);
                        p0.l0(c2);
                    }
                    boolean z7 = p0.i(playable0);
                    boolean z8 = p0.i(p1);
                    C c3 = p0.N();
                    if(z7 || z8 || c3 == v1) {
                        c3 = new C(playable0, p1, 3);
                        p0.l0(c3);
                    }
                    boolean z9 = p0.i(playable0);
                    boolean z10 = p0.i(p1);
                    C c4 = p0.N();
                    if(z9 || z10 || c4 == v1) {
                        c4 = new C(playable0, p1, 4);
                        p0.l0(c4);
                    }
                    boolean z11 = p0.i(playable0);
                    boolean z12 = p0.i(p1);
                    C c5 = p0.N();
                    if(z11 || z12 || c5 == v1) {
                        c5 = new C(playable0, p1, 5);
                        p0.l0(c5);
                    }
                    boolean z13 = p0.i(playable0);
                    boolean z14 = p0.i(p1);
                    C c6 = p0.N();
                    if(z13 || z14 || c6 == v1) {
                        c6 = new C(playable0, p1, 6);
                        p0.l0(c6);
                    }
                    boolean z15 = p0.i(playable0);
                    boolean z16 = p0.i(p1);
                    m9.l l0 = p0.N();
                    if(z15 || z16 || l0 == v1) {
                        l0 = new m9.l(6, playable0, p1);
                        p0.l0(l0);
                    }
                    boolean z17 = p0.i(p1);
                    A a0 = p0.N();
                    if(z17 || a0 == v1) {
                        a0 = new A(p1, 19);
                        p0.l0(a0);
                    }
                    rd.a.g(fillElement0, ((rd.b0)object2), z, c0, 200L, c1, c2, c3, c4, c5, c6, l0, a0, p0, 0x6006);
                    b0 b00 = p0.N();
                    if(b00 == v1) {
                        b00 = w.s(Boolean.TRUE);
                        p0.l0(b00);
                    }
                    Boolean boolean0 = Boolean.valueOf(((rd.b0)object2) instanceof a0);
                    boolean z18 = p0.i(p1);
                    N n0 = p0.N();
                    if(z18 || n0 == v1) {
                        n0 = new N(p1, b00, null);
                        p0.l0(n0);
                    }
                    J.d(p0, boolean0, n0);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
        }
    }
}

