package w8;

import J2.i;
import U4.F;
import V4.u;
import a.a;
import android.content.Context;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import cd.W1;
import ie.H;
import kc.s2;
import kotlinx.coroutines.CoroutineScope;
import m0.c;
import ob.z;
import we.o;

public final class h implements o {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final w0 d;
    public final Object e;
    public final Object f;

    public h(q q0, String s, boolean z, boolean z1, String s1) {
        this.a = 1;
        super();
        this.d = q0;
        this.e = s;
        this.b = z;
        this.c = z1;
        this.f = s1;
    }

    public h(w0 w00, s2 s20, z z0, boolean z1, boolean z2, int v) {
        this.a = v;
        this.d = w00;
        this.e = s20;
        this.f = z0;
        this.b = z1;
        this.c = z2;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        b0 b022;
        b0 b021;
        b0 b020;
        b0 b019;
        Object object5;
        Context context0;
        s2 s21;
        b0 b018;
        b0 b017;
        b0 b016;
        z z4;
        b0 b015;
        b0 b014;
        b0 b013;
        b0 b012;
        p p2;
        z z16;
        b0 b033;
        Object object12;
        b0 b032;
        s2 s24;
        p p5;
        b0 b031;
        b0 b026;
        l l1;
        z z11;
        b0 b025;
        switch(this.a) {
            case 0: {
                m m0 = (m)this.d;
                s2 s22 = (s2)this.e;
                z z7 = (z)this.f;
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((i)object0), "$this$Column");
                Object object6 = ((p)(((androidx.compose.runtime.l)object1))).k(B2.h.b);
                b0 b023 = ((p)(((androidx.compose.runtime.l)object1))).N();
                V v1 = k.a;
                if(b023 == v1) {
                    b023 = w.s("");
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b023);
                }
                b0 b024 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if(b024 == v1) {
                    b024 = w.s(Boolean.TRUE);
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b024);
                }
                Object object7 = w.e(w0.p(s22, ((p)(((androidx.compose.runtime.l)object1)))), "", null, ((p)(((androidx.compose.runtime.l)object1))), 0x30, 2).getValue();
                boolean z8 = ((p)(((androidx.compose.runtime.l)object1))).i(s22);
                boolean z9 = ((p)(((androidx.compose.runtime.l)object1))).i(((Context)object6));
                boolean z10 = ((p)(((androidx.compose.runtime.l)object1))).i(z7);
                Object object8 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if((z8 | z9 | z10) != 0 || object8 == v1) {
                    b025 = b023;
                    l1 = new l(s22, ((Context)object6), z7, b025, b024, null);
                    z11 = z7;
                    b026 = b024;
                    ((p)(((androidx.compose.runtime.l)object1))).l0(l1);
                }
                else {
                    b025 = b023;
                    z11 = z7;
                    l1 = object8;
                    b026 = b024;
                }
                J.d(((p)(((androidx.compose.runtime.l)object1))), object7, l1);
                B2.l l2 = B2.l.a;
                if(this.b) {
                    ((p)(((androidx.compose.runtime.l)object1))).a0(0xB6907734);
                    a.i(u.w(l2, 8.0f), ((p)(((androidx.compose.runtime.l)object1))), 0);
                }
                else {
                    ((p)(((androidx.compose.runtime.l)object1))).a0(0xB659AA02);
                }
                ((p)(((androidx.compose.runtime.l)object1))).p(false);
                F.f(u.o(l2), 0, 1, c.e(0x6EDC31E4, ((p)(((androidx.compose.runtime.l)object1))), new W1(m0, this.c, b025, 2)), ((p)(((androidx.compose.runtime.l)object1))), 0xC00, 2);
                m0.x(z11, s22, ((Boolean)b026.getValue()).booleanValue(), this.c, true, ((p)(((androidx.compose.runtime.l)object1))), 0x6000);
                return H.a;
            }
            case 1: {
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((i)object0), "$this$Column");
                Object object9 = ((p)(((androidx.compose.runtime.l)object1))).k(B2.h.b);
                ((q)this.d).b(((String)this.e), ((Context)object9).getColor((this.b ? 0x7F060171 : 0x7F0604A1)), 16.0f, null, ((p)(((androidx.compose.runtime.l)object1))), 0x180, 8);  // color:gray990e
                a.i(u.w(B2.l.a, ((float)(this.c ? 6 : 4))), ((p)(((androidx.compose.runtime.l)object1))), 0);
                ((q)this.d).b(((String)this.f), ((Context)object9).getColor((this.b ? 0x7F060164 : 0x7F0604B7)), 13.0f, null, ((p)(((androidx.compose.runtime.l)object1))), 0x180, 8);  // color:gray750e
                return H.a;
            }
            case 2: {
                q q1 = (q)this.d;
                s2 s23 = (s2)this.e;
                z z12 = (z)this.f;
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((i)object0), "$this$Column");
                Object object10 = ((p)(((androidx.compose.runtime.l)object1))).k(B2.h.b);
                b0 b027 = ((p)(((androidx.compose.runtime.l)object1))).N();
                V v2 = k.a;
                if(b027 == v2) {
                    b027 = w.s(Boolean.FALSE);
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b027);
                }
                b0 b028 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if(b028 == v2) {
                    b028 = w.s("");
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b028);
                }
                b0 b029 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if(b029 == v2) {
                    b029 = w.s("");
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b029);
                }
                b0 b030 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if(b030 == v2) {
                    b030 = w.s(Boolean.TRUE);
                    ((p)(((androidx.compose.runtime.l)object1))).l0(b030);
                }
                Object object11 = w.e(w0.p(s23, ((p)(((androidx.compose.runtime.l)object1)))), "", null, ((p)(((androidx.compose.runtime.l)object1))), 0x30, 2).getValue();
                boolean z13 = ((p)(((androidx.compose.runtime.l)object1))).i(s23);
                boolean z14 = ((p)(((androidx.compose.runtime.l)object1))).i(((Context)object10));
                boolean z15 = ((p)(((androidx.compose.runtime.l)object1))).i(z12);
                w8.p p4 = ((p)(((androidx.compose.runtime.l)object1))).N();
                if((z13 | z14 | z15) != 0 || p4 == v2) {
                    b031 = b027;
                    p5 = (p)(((androidx.compose.runtime.l)object1));
                    object12 = object11;
                    w8.p p6 = new w8.p(s23, ((Context)object10), z12, b031, b028, b029, b030, null);
                    s24 = s23;
                    z16 = z12;
                    b032 = b028;
                    b033 = b029;
                    p5.l0(p6);
                    p4 = p6;
                }
                else {
                    b031 = b027;
                    p5 = (p)(((androidx.compose.runtime.l)object1));
                    s24 = s23;
                    b032 = b028;
                    object12 = object11;
                    b033 = b029;
                    z16 = z12;
                }
                J.d(p5, object12, p4);
                B2.l l3 = B2.l.a;
                if(this.b) {
                    p5.a0(0xDF09A295);
                    a.i(u.w(l3, 10.0f), p5, 0);
                }
                else {
                    p5.a0(0xDECEDE04);
                }
                p5.p(false);
                F.f(u.o(l3), 0, 2, c.e(1960866210, p5, new n(q1, this.c, b031, 1)), p5, 0xC00, 2);
                a.i(u.w(l3, 15.0f), p5, 0);
                q1.w(u.o(l3), ((String)b032.getValue()), ((String)b033.getValue()), this.c, true, p5, 0x6000);
                a.i(u.w(l3, 8.0f), p5, 0);
                q1.x(z16, s24, ((Boolean)b030.getValue()).booleanValue(), this.c, true, p5, 0x6000);
                return H.a;
            }
            default: {
                Q q0 = (Q)this.d;
                s2 s20 = (s2)this.e;
                z z0 = (z)this.f;
                ((Integer)object2).getClass();
                kotlin.jvm.internal.q.g(((i)object0), "$this$Column");
                p p0 = (p)(((androidx.compose.runtime.l)object1));
                Object object3 = p0.k(B2.h.b);
                CoroutineScope coroutineScope0 = p0.N();
                V v0 = k.a;
                if(coroutineScope0 == v0) {
                    coroutineScope0 = J.i(p0);
                    p0.l0(coroutineScope0);
                }
                b0 b00 = p0.N();
                if(b00 == v0) {
                    b00 = w.s(null);
                    p0.l0(b00);
                }
                b0 b01 = p0.N();
                if(b01 == v0) {
                    b01 = w.s(null);
                    p0.l0(b01);
                }
                b0 b02 = p0.N();
                if(b02 == v0) {
                    b02 = w.s(null);
                    p0.l0(b02);
                }
                b0 b03 = p0.N();
                if(b03 == v0) {
                    b03 = w.s(Boolean.TRUE);
                    p0.l0(b03);
                }
                b0 b04 = p0.N();
                if(b04 == v0) {
                    b04 = w.s(null);
                    p0.l0(b04);
                }
                b0 b05 = p0.N();
                if(b05 == v0) {
                    b05 = w.s(Boolean.FALSE);
                    p0.l0(b05);
                }
                b0 b06 = p0.N();
                if(b06 == v0) {
                    b06 = w.s("");
                    p0.l0(b06);
                }
                b0 b07 = p0.N();
                if(b07 == v0) {
                    b07 = w.s("");
                    p0.l0(b07);
                }
                b0 b08 = p0.N();
                if(b08 == v0) {
                    b08 = w.s("");
                    p0.l0(b08);
                }
                b0 b09 = p0.N();
                if(b09 == v0) {
                    b09 = w.s(Boolean.FALSE);
                    p0.l0(b09);
                }
                b0 b010 = p0.N();
                if(b010 == v0) {
                    b010 = w.s(Boolean.FALSE);
                    p0.l0(b010);
                }
                b0 b011 = p0.N();
                if(b011 == v0) {
                    b011 = w.s(Boolean.TRUE);
                    p0.l0(b011);
                }
                Object object4 = w.e(w0.p(s20, p0), "", null, p0, 0x30, 2).getValue();
                boolean z1 = p0.i(s20);
                boolean z2 = p0.i(((Context)object3));
                boolean z3 = p0.i(z0);
                P p1 = p0.N();
                if((z1 | z2 | z3) != 0 || p1 == v0) {
                    b012 = b03;
                    b013 = b05;
                    object5 = object4;
                    p2 = p0;
                    P p3 = new P(s20, ((Context)object3), z0, b00, b01, b02, b04, b013, b012, b06, b07, b08, b09, b010, b011, null);
                    b019 = b06;
                    b020 = b07;
                    b017 = b08;
                    b018 = b09;
                    b014 = b010;
                    b015 = b011;
                    context0 = (Context)object3;
                    z4 = z0;
                    b016 = b01;
                    b022 = b02;
                    b021 = b04;
                    s21 = s20;
                    p2.l0(p3);
                    p1 = p3;
                }
                else {
                    p2 = p0;
                    b012 = b03;
                    b013 = b05;
                    b014 = b010;
                    b015 = b011;
                    z4 = z0;
                    b016 = b01;
                    b017 = b08;
                    b018 = b09;
                    s21 = s20;
                    context0 = (Context)object3;
                    object5 = object4;
                    b019 = b06;
                    b020 = b07;
                    b021 = b04;
                    b022 = b02;
                }
                J.d(p2, object5, p1);
                B2.l l0 = B2.l.a;
                boolean z5 = this.b;
                if(z5) {
                    p2.a0(0xABA3B0F2);
                    a.i(u.w(l0, 4.0f), p2, 0);
                }
                else {
                    p2.a0(0xAB481B80);
                }
                p2.p(false);
                F.f(Q1.c.M(u.o(l0), 14.0f, 6.0f, 10), 0, 1, c.e(-370679386, p2, new Dc.a(q0, b013, b012, this.c, 12)), p2, 0xC00, 2);
                B2.n n0 = u.o(l0);
                w8.F f0 = new w8.F(z5, q0, s21, context0, coroutineScope0, this.c, b022, b021, b013, b019, b020, b017, b012, b016);
                boolean z6 = this.c;
                F.f(n0, 0, 0, c.e(-980260963, p2, f0), p2, 0xC00, 6);
                if(z5) {
                    p2.a0(0xAC0EAD91);
                    a.i(u.w(l0, 10.0f), p2, 0);
                }
                else {
                    p2.a0(0xAB481B80);
                }
                p2.p(false);
                F.f(u.o(new J2.q(Q1.c.X(6.0f), Q1.c.X(0.0f), Q1.c.X(6.0f), Q1.c.X(0.0f))), 0, 0, c.e(0x5CB4B41E, p2, new G(s21, q0, b012, z6, b014, b015, z4, b018)), p2, 0xC00, 6);
                return H.a;
            }
        }
    }
}

