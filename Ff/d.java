package Ff;

import Dd.g2;
import Df.B;
import Df.i;
import Df.r;
import Kf.e;
import Me.A;
import Me.E;
import Me.N;
import Me.h;
import Me.o;
import Me.p;
import Me.v;
import Me.y;
import Ne.g;
import Pe.S;
import Pe.z;
import Q1.c;
import e1.G;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import lf.T;
import lf.n;
import nf.f;
import tf.m;
import we.a;

public final class d implements a {
    public final int a;
    public final k b;

    public d(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        e e3;
        v v0;
        Iterator iterator5;
        ArrayList arrayList4;
        List list5;
        k k0 = this.b;
        switch(this.a) {
            case 0: {
                k k1 = this.b;
                tf.d d0 = new tf.d(k1, null, g.a, true, 1, N.q);  // 初始化器: LPe/i;-><init>(LMe/e;LMe/j;LNe/h;ZILMe/N;)V
                List list0 = Collections.EMPTY_LIST;
                o o0 = p.a;
                if(o0 != null) {
                    d0.H1(list0, o0);
                    d0.g = k1.g();
                    return d0;
                }
                tf.e.a(49);
                throw null;
            }
            case 1: {
                A1.g g0 = k0.l;
                List list1 = k0.e.r;
                q.f(list1, "getConstructorList(...)");
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list1) {
                    if(nf.d.n.e(((n)object0).d).booleanValue()) {
                        arrayList0.add(object0);
                    }
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    r r0 = (r)g0.i;
                    q.d(((n)object1));
                    arrayList1.add(r0.d(((n)object1), false));
                }
                return je.p.A0(je.p.A0(arrayList1, e.k.B(k0.B())), ((i)g0.a).n.a(k0));
            }
            case 2: {
                lf.k k2 = k0.e;
                if((k2.c & 4) == 4) {
                    qf.e e0 = c.B(((f)k0.l.b), k2.f);
                    h h0 = k0.r().c(e0, Ue.c.g);
                    if(h0 instanceof Me.e) {
                        return (Me.e)h0;
                    }
                }
                return null;
            }
            case 3: {
                y y0 = k0.i;
                y y1 = y.c;
                if(y0 == y1) {
                    List list2 = k0.e.G;
                    q.d(list2);
                    if(!list2.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        for(Object object2: list2) {
                            i i0 = (i)k0.l.a;
                            f f0 = (f)k0.l.b;
                            q.d(((Integer)object2));
                            Me.e e1 = i0.b(c.z(f0, ((int)(((Integer)object2)))));
                            if(e1 != null) {
                                arrayList2.add(e1);
                            }
                        }
                        return arrayList2;
                    }
                    if(y0 == y1) {
                        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                        Me.k k3 = k0.w;
                        if(k3 instanceof E) {
                            m.c(k0, linkedHashSet0, ((E)k3).E(), false);
                        }
                        m.c(k0, linkedHashSet0, k0.Z(), true);
                        return je.p.J0(linkedHashSet0, new tf.h(1));
                    }
                }
                return w.a;
            }
            case 4: {
                k k4 = this.b;
                if(k4.isInline() || k4.j()) {
                    lf.k k5 = k4.e;
                    f f1 = (f)k4.l.b;
                    z z0 = (z)k4.l.d;
                    j j0 = new j(1, ((B)k4.l.h), B.class, "simpleType", "simpleType(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;Z)Lorg/jetbrains/kotlin/types/SimpleType;", 0, 0);
                    g2 g20 = new g2(1, k4, k.class, "getValueClassPropertyType", "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;", 0, 6);
                    q.g(k5, "<this>");
                    q.g(f1, "nameResolver");
                    if(k5.T.size() > 0) {
                        List list3 = k5.T;
                        q.f(list3, "getMultiFieldValueClassUnderlyingNameList(...)");
                        ArrayList arrayList3 = new ArrayList(je.q.Q(10, list3));
                        for(Object object3: list3) {
                            q.d(((Integer)object3));
                            arrayList3.add(c.B(f1, ((int)(((Integer)object3)))));
                        }
                        ie.m m0 = new ie.m(k5.X.size(), k5.W.size());
                        if(m0.equals(new ie.m(arrayList3.size(), 0))) {
                            List list4 = k5.X;
                            q.f(list4, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
                            list5 = new ArrayList(je.q.Q(10, list4));
                            for(Object object4: list4) {
                                q.d(((Integer)object4));
                                ((ArrayList)list5).add(z0.c(((int)(((Integer)object4)))));
                            }
                            arrayList4 = new ArrayList(je.q.Q(10, list5));
                            iterator5 = list5.iterator();
                            goto label_102;
                        }
                        else {
                            if(!m0.equals(new ie.m(0, arrayList3.size()))) {
                                throw new IllegalStateException(("class " + c.B(f1, k5.e) + " has illegal multi-field value class representation").toString());
                            }
                            list5 = k5.W;
                            arrayList4 = new ArrayList(je.q.Q(10, list5));
                            iterator5 = list5.iterator();
                        label_102:
                            while(iterator5.hasNext()) {
                                Object object5 = iterator5.next();
                                arrayList4.add(j0.invoke(object5));
                            }
                            v0 = new A(je.p.W0(arrayList3, arrayList4));
                        }
                    }
                    else if((k5.c & 8) == 8) {
                        qf.e e2 = c.B(f1, k5.M);
                        T t0 = G.s(k5, z0);
                        if(t0 == null) {
                        label_115:
                            e3 = (e)g20.invoke(e2);
                            if(e3 == null) {
                                throw new IllegalStateException(("cannot determine underlying type for value class " + c.B(f1, k5.e) + " with property " + e2).toString());
                            }
                            v0 = new v(e2, e3);
                        }
                        else {
                            e3 = (e)j0.invoke(t0);
                            if(e3 == null) {
                                goto label_115;
                            }
                            else {
                                v0 = new v(e2, e3);
                            }
                        }
                    }
                    else {
                        v0 = null;
                    }
                    if(v0 != null) {
                        return v0;
                    }
                    if(!k4.f.a(1, 5, 1)) {
                        Pe.i i1 = k4.B();
                        if(i1 == null) {
                            throw new IllegalStateException(("Inline class has no primary constructor: " + k4).toString());
                        }
                        List list6 = i1.F();
                        q.f(list6, "getValueParameters(...)");
                        qf.e e4 = ((S)je.p.k0(list6)).getName();
                        q.f(e4, "getName(...)");
                        Hf.B b0 = k4.t(e4);
                        if(b0 == null) {
                            throw new IllegalStateException(("Value class has no underlying property: " + k4).toString());
                        }
                        return new v(e4, b0);
                    }
                }
                return null;
            }
            case 5: {
                return je.p.P0(((i)k0.l.a).e.j(k0.G));
            }
            default: {
                return Me.w.c(k0);
            }
        }
    }
}

