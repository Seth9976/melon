package td;

import B.a;
import Cc.u2;
import android.graphics.Point;
import android.net.Uri;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import cd.x1;
import com.melon.ui.common.composable.PlayBgColorData;
import com.melon.ui.playermusic.PlayerViewCalculator;
import d3.g;
import d9.h;
import ie.H;
import ie.m;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ld.j;
import ob.A;
import oc.M;
import pb.r;
import we.n;

public final class w implements n {
    public final int a;
    public final b0 b;

    public w(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        Long long2;
        int v7;
        boolean z18;
        String s4;
        String s3;
        boolean z16;
        n n0;
        boolean z7;
        long v5;
        Y y0;
        b0 b015;
        V v4;
        switch(this.a) {
            case 0: {
                int v12 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v12 & 1, (v12 & 3) != 2)) {
                    b0 b016 = this.b;
                    Object object6 = a.r(((t1)b016.getViewModel()).n, ((p)(((l)object0))), 0).getValue();
                    p0 p01 = object6 instanceof p0 ? ((p0)object6) : null;
                    if(p01 != null) {
                        androidx.compose.runtime.b0 b017 = ((p)(((l)object0))).N();
                        V v13 = k.a;
                        if(b017 == v13) {
                            b017 = androidx.compose.runtime.w.s(null);
                            ((p)(((l)object0))).l0(b017);
                        }
                        Uri uri0 = p01.e;
                        boolean z36 = ((p)(((l)object0))).i(b016);
                        boolean z37 = ((p)(((l)object0))).i(uri0);
                        X x16 = ((p)(((l)object0))).N();
                        if(z36 || z37 || x16 == v13) {
                            x16 = new X(b017, b016, uri0, null);
                            ((p)(((l)object0))).l0(x16);
                        }
                        J.d(((p)(((l)object0))), uri0, x16);
                        u2.a(((PlayBgColorData)b017.getValue()), null, 0.0f, 0.0f, null, null, null, null, false, ((p)(((l)object0))), 0, 510);
                        return H.a;
                    }
                }
                else {
                    ((p)(((l)object0))).T();
                }
                return H.a;
            }
            case 1: {
                D0 d00 = new D0(((int)(((Integer)object0))), ((long)(((Long)object1))));
                this.b.sendUserEvent(d00);
                return H.a;
            }
            case 2: {
                C0 c00 = new C0(((int)(((Integer)object0))), ((long)(((Long)object1))));
                this.b.sendUserEvent(c00);
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    b0 b00 = this.b;
                    Object object2 = a.r(((t1)b00.getViewModel()).n, p0, 0).getValue();
                    p0 p00 = object2 instanceof p0 ? ((p0)object2) : null;
                    if(p00 != null) {
                        androidx.compose.runtime.b0 b01 = a.r(((t1)b00.getViewModel()).p, p0, 0);
                        androidx.compose.runtime.b0 b02 = a.r(((t1)b00.getViewModel()).A, p0, 0);
                        androidx.compose.runtime.b0 b03 = a.r(((t1)b00.getViewModel()).o, p0, 0);
                        androidx.compose.runtime.b0 b04 = a.r(((t1)b00.getViewModel()).q, p0, 0);
                        androidx.compose.runtime.b0 b05 = a.r(((t1)b00.getViewModel()).r, p0, 0);
                        androidx.compose.runtime.b0 b06 = a.r(((t1)b00.getViewModel()).s, p0, 0);
                        androidx.compose.runtime.b0 b07 = a.r(((t1)b00.getViewModel()).E, p0, 0);
                        androidx.compose.runtime.b0 b08 = a.r(((t1)b00.getViewModel()).G, p0, 0);
                        androidx.compose.runtime.b0 b09 = a.r(b00.k, p0, 0);
                        androidx.compose.runtime.b0 b010 = a.r(((t1)b00.getViewModel()).w, p0, 0);
                        androidx.compose.runtime.b0 b011 = a.r(((t1)b00.getViewModel()).y, p0, 0);
                        androidx.compose.runtime.b0 b012 = p0.N();
                        V v1 = k.a;
                        if(b012 == v1) {
                            b012 = androidx.compose.runtime.w.s(Boolean.TRUE);
                            p0.l0(b012);
                        }
                        androidx.compose.runtime.b0 b013 = p0.N();
                        if(b013 == v1) {
                            b013 = androidx.compose.runtime.w.s(new m(0.0f, 0.0f));
                            p0.l0(b013);
                        }
                        Flow flow0 = p0.N();
                        if(flow0 == v1) {
                            Z z0 = new Z(3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                            flow0 = FlowKt.combine(b00.r, b00.w, z0);
                            p0.l0(flow0);
                        }
                        androidx.compose.runtime.b0 b014 = a.p(flow0, Boolean.FALSE, p0, 0x30);
                        Object object3 = a.r(((t1)b00.getViewModel()).t, p0, 0).getValue();
                        boolean z1 = p00.f && p00.g;
                        E e0 = p0.N();
                        if(e0 == v1) {
                            e0 = androidx.compose.runtime.w.i(new Cc.b0(b06, 12));
                            p0.l0(e0);
                        }
                        Boolean boolean0 = (Boolean)b07.getValue();
                        boolean z2 = boolean0.booleanValue();
                        boolean z3 = !((Boolean)b012.getValue()).booleanValue() && !p00.j && !b00.m && ((PlayerViewCalculator)b00.l.getValue()).b(((Point)b09.getValue())) > 0;
                        Long long0 = p0.N();
                        if(long0 == v1) {
                            long0 = 300L;
                            p0.l0(300L);
                        }
                        long v2 = long0.longValue();
                        long v3 = z3 ? v2 : 0L;
                        boolean z4 = p0.h(z2);
                        boolean z5 = p0.h(z3);
                        boolean z6 = p0.i(b00);
                        Object object4 = p0.N();
                        if((z4 | z5 | z6) == 0 && object4 != v1) {
                            y0 = object4;
                            b015 = b00;
                            v4 = v1;
                            v5 = v3;
                            z7 = z2;
                        }
                        else {
                            v4 = v1;
                            b015 = b00;
                            y0 = new Y(z2, z3, b015, v2, b012, b013, null);
                            v5 = v3;
                            z7 = z2;
                            p0.l0(y0);
                        }
                        J.d(p0, boolean0, y0);
                        String s = p00.e.toString();
                        q.f(s, "toString(...)");
                        boolean z8 = p0.i(b015);
                        x x0 = p0.N();
                        if(z8 || x0 == v4) {
                            x0 = new x(b015, 6);
                            p0.l0(x0);
                        }
                        x1 x10 = p0.N();
                        if(x10 == v4) {
                            x10 = new x1(b013, 2);
                            p0.l0(x10);
                        }
                        String s1 = p00.c;
                        String s2 = p00.d;
                        boolean z9 = p0.i(b015);
                        x x1 = p0.N();
                        if(z9 || x1 == v4) {
                            x1 = new x(b015, 11);
                            p0.l0(x1);
                        }
                        boolean z10 = p0.i(b015);
                        x x2 = p0.N();
                        if(z10 || x2 == v4) {
                            x2 = new x(b015, 12);
                            p0.l0(x2);
                        }
                        boolean z11 = p0.i(b015);
                        x x3 = p0.N();
                        if(z11 || x3 == v4) {
                            x3 = new x(b015, 13);
                            p0.l0(x3);
                        }
                        boolean z12 = p00.h;
                        int v6 = p00.i;
                        boolean z13 = p0.i(b015);
                        x x4 = p0.N();
                        if(z13 || x4 == v4) {
                            x4 = new x(b015, 14);
                            p0.l0(x4);
                        }
                        boolean z14 = p0.i(b015);
                        x x5 = p0.N();
                        if(z14 || x5 == v4) {
                            x5 = new x(b015, 15);
                            p0.l0(x5);
                        }
                        Object object5 = b010.getValue();
                        boolean z15 = ((Boolean)b011.getValue()).booleanValue();
                        if(!((t1)b015.getViewModel()).isLoginUser() || !z1 || !((h)b010.getValue()).i) {
                            n0 = x10;
                            z16 = false;
                        }
                        else {
                            n0 = x10;
                            z16 = true;
                        }
                        boolean z17 = p0.i(b015);
                        L l0 = p0.N();
                        if(z17 || l0 == v4) {
                            s4 = s2;
                            z18 = z12;
                            v7 = v6;
                            s3 = s1;
                            L l1 = new L(1, b015, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 5);
                            p0.l0(l1);
                            l0 = l1;
                        }
                        else {
                            s3 = s1;
                            s4 = s2;
                            z18 = z12;
                            v7 = v6;
                        }
                        long v8 = ((A)b01.getValue()).a;
                        long v9 = ((A)b01.getValue()).b;
                        Long long1 = (Long)b02.getValue();
                        long v10 = ((Number)((m)e0.getValue()).a).longValue();
                        long v11 = ((Number)((m)e0.getValue()).b).longValue();
                        j j0 = p0.N();
                        if(j0 == v4) {
                            j0 = new j(26);
                            p0.l0(j0);
                        }
                        boolean z19 = p0.i(b015);
                        y y1 = p0.N();
                        if(z19 || y1 == v4) {
                            y1 = new y(b015, 0);
                            p0.l0(y1);
                        }
                        boolean z20 = p0.i(b015);
                        y y2 = p0.N();
                        if(z20 || y2 == v4) {
                            y2 = new y(b015, 2);
                            p0.l0(y2);
                        }
                        boolean z21 = p0.i(b015);
                        y y3 = p0.N();
                        if(z21 || y3 == v4) {
                            y3 = new y(b015, 3);
                            p0.l0(y3);
                        }
                        boolean z22 = p0.i(b015);
                        x x6 = p0.N();
                        if(z22 || x6 == v4) {
                            x6 = new x(b015, 0);
                            p0.l0(x6);
                        }
                        boolean z23 = p0.i(b015);
                        x x7 = p0.N();
                        if(z23 || x7 == v4) {
                            x7 = new x(b015, 1);
                            p0.l0(x7);
                        }
                        boolean z24 = ((Boolean)b03.getValue()).booleanValue();
                        Boolean boolean1 = (Boolean)b04.getValue();
                        M m0 = (M)b05.getValue();
                        boolean z25 = p0.i(b015);
                        x x8 = p0.N();
                        if(z25 || x8 == v4) {
                            long2 = long1;
                            x8 = new x(b015, 2);
                            p0.l0(x8);
                        }
                        else {
                            long2 = long1;
                        }
                        boolean z26 = p0.i(b015);
                        x x9 = p0.N();
                        if(z26 || x9 == v4) {
                            x9 = new x(b015, 3);
                            p0.l0(x9);
                        }
                        boolean z27 = p0.i(b015);
                        w w0 = p0.N();
                        if(z27 || w0 == v4) {
                            w0 = new w(b015, 1);
                            p0.l0(w0);
                        }
                        boolean z28 = p0.i(b015);
                        x x10_1 = p0.N();
                        if(z28 || x10_1 == v4) {
                            x10_1 = new x(b015, 4);
                            p0.l0(x10_1);
                        }
                        boolean z29 = p0.i(b015);
                        w w1 = p0.N();
                        if(z29 || w1 == v4) {
                            w1 = new w(b015, 2);
                            p0.l0(w1);
                        }
                        boolean z30 = p0.i(b015);
                        x x11 = p0.N();
                        if(z30 || x11 == v4) {
                            x11 = new x(b015, 5);
                            p0.l0(x11);
                        }
                        boolean z31 = p0.i(b015);
                        x x12 = p0.N();
                        if(z31 || x12 == v4) {
                            x12 = new x(b015, 7);
                            p0.l0(x12);
                        }
                        boolean z32 = ((Boolean)b08.getValue()).booleanValue();
                        boolean z33 = p0.i(b015);
                        x x13 = p0.N();
                        if(z33 || x13 == v4) {
                            x13 = new x(b015, 8);
                            p0.l0(x13);
                        }
                        boolean z34 = p0.i(b015);
                        x x14 = p0.N();
                        if(z34 || x14 == v4) {
                            x14 = new x(b015, 9);
                            p0.l0(x14);
                        }
                        boolean z35 = p0.i(b015);
                        x x15 = p0.N();
                        if(z35 || x15 == v4) {
                            x15 = new x(b015, 10);
                            p0.l0(x15);
                        }
                        g.q(s, x0, v5, n0, s3, s4, x1, x2, x3, z18, v7, x4, x5, ((h)object5), z15, z16, z7, l0, v8, v9, long2, v10, v11, j0, y1, y2, y3, x6, x7, z24, boolean1, m0, x8, x9, w0, x10_1, w1, x11, x12, z32, x13, ((String)object3), x14, x15, p00.l == r.l, ((Boolean)b014.getValue()).booleanValue(), p00.j, z1, p0, 0xC00);
                        return H.a;
                    }
                }
                else {
                    p0.T();
                }
                return H.a;
            }
        }
    }
}

