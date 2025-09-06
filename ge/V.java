package Ge;

import Ff.k;
import H8.i;
import H8.q;
import Me.e;
import Pe.z;
import Ve.N;
import Ve.S;
import Ve.W;
import Ve.X;
import Ve.a0;
import Ve.b0;
import Ve.d0;
import Ve.s;
import Ye.b;
import Ye.c;
import Ye.d;
import e1.G;
import e1.x;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import lf.A;
import lf.I;
import lf.T;
import lf.V;
import lf.Y;
import lf.Z;
import lf.g0;
import lf.h;
import lf.n;
import lf.p;
import lf.r;
import lf.t;
import nf.f;
import pf.g;
import we.a;

public final class v implements a {
    public final int a;
    public final y b;

    public v(y y0, int v) {
        this.a = v;
        this.b = y0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        q q3;
        y y0 = this.b;
        switch(this.a) {
            case 0: {
                e e0 = y0.a();
                k k0 = e0 instanceof k ? ((k)e0) : null;
                if(k0 != null) {
                    lf.k k1 = k0.e;
                    f f0 = (f)k0.l.b;
                    kotlin.jvm.internal.q.g(k1, "<this>");
                    kotlin.jvm.internal.q.g(f0, "strings");
                    N n0 = new N();
                    Z z0 = k1.b0;
                    kotlin.jvm.internal.q.f(z0, "getTypeTable(...)");
                    z z1 = new z(z0);
                    g0 g00 = k1.d0;
                    kotlin.jvm.internal.q.f(g00, "getVersionRequirementTable(...)");
                    q q0 = new q(f0, z1, e2.a.w(g00), null, w.a);
                    List list0 = k1.g;
                    kotlin.jvm.internal.q.f(list0, "getTypeParameterList(...)");
                    q q1 = q0.t(list0);
                    List list1 = (List)q1.g;
                    z z2 = (z)q1.b;
                    n0.a = k1.d;
                    int v = k1.e;
                    f f1 = (f)q1.a;
                    String s = H0.e.I(f1, v);
                    kotlin.jvm.internal.q.g(s, "<set-?>");
                    n0.b = s;
                    List list2 = k1.g;
                    kotlin.jvm.internal.q.f(list2, "getTypeParameterList(...)");
                    for(Object object2: list2) {
                        kotlin.jvm.internal.q.d(((Y)object2));
                        b0 b00 = P4.a.I(((Y)object2), q1);
                        n0.c.add(b00);
                    }
                    for(Object object3: G.F(k1, z2)) {
                        Ve.Z z3 = P4.a.H(((T)object3), q1);
                        n0.d.add(z3);
                    }
                    List list3 = k1.r;
                    kotlin.jvm.internal.q.f(list3, "getConstructorList(...)");
                    for(Object object4: list3) {
                        n n1 = (n)object4;
                        kotlin.jvm.internal.q.d(n1);
                        S s1 = new S(n1.d);
                        List list4 = n1.e;
                        kotlin.jvm.internal.q.f(list4, "getValueParameterList(...)");
                        for(Object object5: list4) {
                            kotlin.jvm.internal.q.d(((lf.b0)object5));
                            d0 d00 = P4.a.J(((lf.b0)object5), q1);
                            s1.b.add(d00);
                        }
                        List list5 = n1.f;
                        kotlin.jvm.internal.q.f(list5, "getVersionRequirementList(...)");
                        for(Object object6: list5) {
                            kotlin.jvm.internal.q.d(((Integer)object6));
                            i i0 = P4.a.z(((int)(((Integer)object6))), q1);
                            s1.c.add(i0);
                        }
                        for(Object object7: list1) {
                            ((d)(((Xe.k)object7))).getClass();
                            kotlin.jvm.internal.q.g(b.a, "type");
                            b b0 = (b)(((Xe.b)B.a.Y(s1.e, b.a)));
                            List list6 = n1.h;
                            kotlin.jvm.internal.q.f(list6, "getAnnotationList(...)");
                            for(Object object8: list6) {
                                kotlin.jvm.internal.q.d(((h)object8));
                                s s2 = H0.e.Q(((h)object8), f1);
                                s1.d.add(s2);
                            }
                            pf.e e1 = g.a(n1, f1, z2);
                            if(e1 != null) {
                                kotlin.jvm.internal.q.g(e1.k, "name");
                                kotlin.jvm.internal.q.g(e1.l, "descriptor");
                            }
                        }
                        n0.h.add(s1);
                    }
                    List list7 = k1.w;
                    kotlin.jvm.internal.q.f(list7, "getFunctionList(...)");
                    List list8 = k1.B;
                    kotlin.jvm.internal.q.f(list8, "getPropertyList(...)");
                    List list9 = k1.D;
                    kotlin.jvm.internal.q.f(list9, "getTypeAliasList(...)");
                    for(Object object9: list7) {
                        A a0 = (A)object9;
                        W w2 = new W(a0.d, f1.getString(a0.f));
                        List list10 = a0.i;
                        kotlin.jvm.internal.q.f(list10, "getTypeParameterList(...)");
                        q q2 = q1.t(list10);
                        z z4 = (z)q2.b;
                        List list11 = a0.i;
                        kotlin.jvm.internal.q.f(list11, "getTypeParameterList(...)");
                        for(Object object10: list11) {
                            kotlin.jvm.internal.q.d(((Y)object10));
                            b0 b01 = P4.a.I(((Y)object10), q2);
                            w2.b.add(b01);
                        }
                        T t0 = G.A(a0, z4);
                        if(t0 != null) {
                            P4.a.H(t0, q2);
                        }
                        for(Object object11: G.i(a0, z4)) {
                            Ve.Z z5 = P4.a.H(((T)object11), q2);
                            w2.d.add(z5);
                        }
                        List list12 = a0.r;
                        kotlin.jvm.internal.q.f(list12, "getValueParameterList(...)");
                        for(Object object12: list12) {
                            kotlin.jvm.internal.q.d(((lf.b0)object12));
                            d0 d01 = P4.a.J(((lf.b0)object12), q2);
                            w2.e.add(d01);
                        }
                        P4.a.H(G.C(a0, z4), q2);
                        if((a0.c & 0x100) == 0x100) {
                            p p0 = a0.D;
                            kotlin.jvm.internal.q.f(p0, "getContract(...)");
                            ArrayList arrayList0 = new ArrayList(1);
                            for(Object object13: p0.b) {
                                t t1 = (t)object13;
                                if((t1.b & 1) == 1) {
                                    r r0 = t1.c;
                                    if(r0 == null) {
                                        throw new IllegalArgumentException("Required value was null.");
                                    }
                                    int v1 = r0.ordinal();
                                    if(v1 == 0) {
                                        q3 = q1;
                                    }
                                    else {
                                        q3 = q1;
                                        if(v1 != 1 && v1 != 2) {
                                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                        }
                                    }
                                    if((t1.b & 4) == 4) {
                                        lf.s s3 = t1.f;
                                        if(s3 == null) {
                                            throw new IllegalArgumentException("Required value was null.");
                                        }
                                        int v2 = s3.ordinal();
                                        if(v2 != 0 && (v2 != 1 && v2 != 2)) {
                                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                        }
                                    }
                                    Q8.h h0 = new Q8.h();  // 初始化器: Ljava/lang/Object;-><init>()V
                                    h0.a = new ArrayList(1);
                                    List list13 = t1.d;
                                    kotlin.jvm.internal.q.f(list13, "getEffectConstructorArgumentList(...)");
                                    ArrayList arrayList1 = h0.a;
                                    for(Object object14: list13) {
                                        kotlin.jvm.internal.q.d(((lf.y)object14));
                                        arrayList1.add(P4.a.F(((lf.y)object14), q2));
                                    }
                                    if((t1.b & 2) == 2) {
                                        lf.y y1 = t1.e;
                                        kotlin.jvm.internal.q.f(y1, "getConclusionOfConditionalEffect(...)");
                                        P4.a.F(y1, q2);
                                    }
                                    arrayList0.add(h0);
                                    q1 = q3;
                                }
                            }
                        }
                        List list14 = a0.B;
                        kotlin.jvm.internal.q.f(list14, "getVersionRequirementList(...)");
                        for(Object object15: list14) {
                            kotlin.jvm.internal.q.d(((Integer)object15));
                            i i1 = P4.a.z(((int)(((Integer)object15))), q2);
                            w2.f.add(i1);
                        }
                        for(Object object16: ((List)q2.g)) {
                            ((d)(((Xe.k)object16))).getClass();
                            f f2 = (f)q2.a;
                            kotlin.jvm.internal.q.g(c.a, "type");
                            c c0 = (c)(((Xe.e)B.a.Y(w2.h, c.a)));
                            List list15 = a0.G;
                            kotlin.jvm.internal.q.f(list15, "getAnnotationList(...)");
                            for(Object object17: list15) {
                                kotlin.jvm.internal.q.d(((h)object17));
                                s s4 = H0.e.Q(((h)object17), f2);
                                w2.g.add(s4);
                            }
                            List list16 = a0.I;
                            kotlin.jvm.internal.q.f(list16, "getExtensionReceiverAnnotationList(...)");
                            for(Object object18: list16) {
                                kotlin.jvm.internal.q.d(((h)object18));
                                s s5 = H0.e.Q(((h)object18), f2);
                                w2.c.add(s5);
                            }
                            pf.e e2 = g.c(a0, f2, z4);
                            if(e2 != null) {
                                kotlin.jvm.internal.q.g(e2.k, "name");
                                kotlin.jvm.internal.q.g(e2.l, "descriptor");
                            }
                            kotlin.jvm.internal.q.f(of.k.c, "lambdaClassOriginName");
                            Integer integer0 = (Integer)x.G(a0, of.k.c);
                            if(integer0 != null) {
                                f2.getString(((int)integer0));
                            }
                        }
                        n0.e.add(w2);
                    }
                    for(Object object19: list8) {
                        X x0 = P4.a.G(((I)object19), q1);
                        n0.f.add(x0);
                    }
                    for(Object object20: list9) {
                        a0 a00 = new a0(((V)object20).d, f1.getString(((V)object20).e));
                        List list17 = ((V)object20).f;
                        kotlin.jvm.internal.q.f(list17, "getTypeParameterList(...)");
                        q q4 = q1.t(list17);
                        z z6 = (z)q4.b;
                        List list18 = ((V)object20).f;
                        kotlin.jvm.internal.q.f(list18, "getTypeParameterList(...)");
                        for(Object object21: list18) {
                            kotlin.jvm.internal.q.d(((Y)object21));
                            b0 b02 = P4.a.I(((Y)object21), q4);
                            a00.b.add(b02);
                        }
                        P4.a.H(G.L(((V)object20), z6), q4);
                        P4.a.H(G.o(((V)object20), z6), q4);
                        List list19 = ((V)object20).k;
                        kotlin.jvm.internal.q.f(list19, "getAnnotationList(...)");
                        for(Object object22: list19) {
                            kotlin.jvm.internal.q.d(((h)object22));
                            s s6 = H0.e.Q(((h)object22), ((f)q4.a));
                            a00.c.add(s6);
                        }
                        List list20 = ((V)object20).l;
                        kotlin.jvm.internal.q.f(list20, "getVersionRequirementList(...)");
                        for(Object object23: list20) {
                            kotlin.jvm.internal.q.d(((Integer)object23));
                            i i2 = P4.a.z(((int)(((Integer)object23))), q4);
                            a00.d.add(i2);
                        }
                        for(Object object24: ((List)q4.g)) {
                            ((d)(((Xe.k)object24))).getClass();
                        }
                        n0.g.add(a00);
                    }
                    if((k1.c & 4) == 4) {
                        f1.getString(k1.f);
                    }
                    List list21 = k1.k;
                    kotlin.jvm.internal.q.f(list21, "getNestedClassNameList(...)");
                    for(Object object25: list21) {
                        kotlin.jvm.internal.q.d(((Integer)object25));
                        String s7 = f1.getString(((int)(((Integer)object25))));
                        n0.i.add(s7);
                    }
                    for(Object object26: k1.E) {
                        lf.v v3 = (lf.v)object26;
                        if((v3.c & 1) != 1) {
                            throw new Ve.q("No name for EnumEntry");
                        }
                        String s8 = f1.getString(v3.d);
                        n0.j.add(s8);
                        ea.c c1 = new ea.c(f1.getString(v3.d));
                        for(Object object27: list1) {
                            ((d)(((Xe.k)object27))).getClass();
                            for(Object object28: v3.e) {
                                ArrayList arrayList2 = (ArrayList)c1.c;
                                kotlin.jvm.internal.q.d(((h)object28));
                                arrayList2.add(H0.e.Q(((h)object28), f1));
                            }
                        }
                        n0.k.add(c1);
                    }
                    List list22 = k1.G;
                    kotlin.jvm.internal.q.f(list22, "getSealedSubclassFqNameList(...)");
                    for(Object object29: list22) {
                        kotlin.jvm.internal.q.d(((Integer)object29));
                        String s9 = H0.e.I(f1, ((int)(((Integer)object29))));
                        n0.l.add(s9);
                    }
                    if((k1.c & 8) == 8) {
                        f1.getString(k1.M);
                    }
                    T t2 = G.s(k1, z2);
                    if(t2 == null) {
                        if((k1.c & 8) == 8) {
                            List list23 = k1.B;
                            kotlin.jvm.internal.q.f(list23, "getPropertyList(...)");
                            boolean z7 = false;
                            Object object30 = null;
                            for(Object object31: list23) {
                                kotlin.jvm.internal.q.d(((I)object31));
                                if(G.B(((I)object31), z2) != null || !f1.getString(((I)object31).f).equals(f1.getString(k1.M))) {
                                    continue;
                                }
                                if(!z7) {
                                    object30 = object31;
                                    z7 = true;
                                    continue;
                                }
                                object30 = null;
                                goto label_343;
                            }
                            if(!z7) {
                                object30 = null;
                            }
                        label_343:
                            t2 = ((I)object30) == null ? null : G.D(((I)object30), z2);
                        }
                        else {
                            t2 = null;
                        }
                    }
                    if(t2 != null) {
                        P4.a.H(t2, q1);
                    }
                    for(Object object32: G.h(k1, z2)) {
                        Ve.Z z8 = P4.a.H(((T)object32), q1);
                        n0.n.add(z8);
                    }
                    List list24 = k1.c0;
                    kotlin.jvm.internal.q.f(list24, "getVersionRequirementList(...)");
                    for(Object object33: list24) {
                        kotlin.jvm.internal.q.d(((Integer)object33));
                        i i3 = P4.a.z(((int)(((Integer)object33))), q1);
                        n0.o.add(i3);
                    }
                    for(Object object34: list1) {
                        ((d)(((Xe.k)object34))).getClass();
                        kotlin.jvm.internal.q.g(Ye.a.b, "type");
                        Ye.a a1 = (Ye.a)(((Xe.a)B.a.Y(n0.p, Ye.a.b)));
                        List list25 = k1.Z;
                        kotlin.jvm.internal.q.f(list25, "getAnnotationList(...)");
                        for(Object object35: list25) {
                            kotlin.jvm.internal.q.d(((h)object35));
                            s s10 = H0.e.Q(((h)object35), f1);
                            n0.m.add(s10);
                        }
                        kotlin.jvm.internal.q.f(of.k.k, "anonymousObjectOriginName");
                        Integer integer1 = (Integer)x.G(k1, of.k.k);
                        if(integer1 != null) {
                            f1.getString(((int)integer1));
                        }
                        for(Object object36: ((List)k1.i(of.k.j))) {
                            kotlin.jvm.internal.q.d(((I)object36));
                            X x1 = P4.a.G(((I)object36), q1);
                            a1.a.add(x1);
                        }
                        kotlin.jvm.internal.q.f(of.k.i, "classModuleName");
                        Integer integer2 = (Integer)x.G(k1, of.k.i);
                        if(integer2 != null) {
                            f1.getString(integer2.intValue());
                        }
                        kotlin.jvm.internal.q.f(of.k.l, "jvmClassFlags");
                        Integer integer3 = (Integer)x.G(k1, of.k.l);
                    }
                    return n0;
                }
                return null;
            }
            case 1: {
                De.w w3 = y.m[9];
                Object object37 = y0.g.invoke();
                kotlin.jvm.internal.q.f(object37, "getValue(...)");
                De.w w4 = y.m[11];
                Object object38 = y0.i.invoke();
                kotlin.jvm.internal.q.f(object38, "getValue(...)");
                return je.p.A0(((Collection)object37), ((Collection)object38));
            }
            case 2: {
                De.w w5 = y.m[10];
                Object object39 = y0.h.invoke();
                kotlin.jvm.internal.q.f(object39, "getValue(...)");
                De.w w6 = y.m[12];
                Object object40 = y0.j.invoke();
                kotlin.jvm.internal.q.f(object40, "getValue(...)");
                return je.p.A0(((Collection)object39), ((Collection)object40));
            }
            case 3: {
                De.w w7 = y.m[9];
                Object object41 = y0.g.invoke();
                kotlin.jvm.internal.q.f(object41, "getValue(...)");
                De.w w8 = y.m[10];
                Object object42 = y0.h.invoke();
                kotlin.jvm.internal.q.f(object42, "getValue(...)");
                return je.p.A0(((Collection)object41), ((Collection)object42));
            }
            default: {
                De.w w0 = y.m[13];
                Object object0 = y0.k.invoke();
                kotlin.jvm.internal.q.f(object0, "getValue(...)");
                De.w w1 = y.m[14];
                Object object1 = y0.l.invoke();
                kotlin.jvm.internal.q.f(object1, "getValue(...)");
                return je.p.A0(((Collection)object0), ((Collection)object1));
            }
        }
    }
}

