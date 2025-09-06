package Ff;

import A3.g;
import De.t;
import De.w;
import Gf.e;
import Gf.i;
import Gf.j;
import Gf.m;
import Q1.c;
import com.iloen.melon.utils.a;
import ie.H;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import je.D;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import lf.A;
import lf.V;
import nf.f;

public final class q {
    public final LinkedHashMap a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final e d;
    public final e e;
    public final j f;
    public final i g;
    public final i h;
    public final r i;
    public static final w[] j;

    static {
        z z0 = new z(q.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0);
        t t0 = a.e(q.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0, I.a);
        q.j = new w[]{I.a.g(z0), t0};
    }

    public q(r r0, List list0, List list1, List list2) {
        kotlin.jvm.internal.q.g(list0, "functionList");
        kotlin.jvm.internal.q.g(list1, "propertyList");
        kotlin.jvm.internal.q.g(list2, "typeAliasList");
        this.i = r0;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object0: list0) {
            qf.e e0 = c.B(((f)r0.b.b), ((A)(((rf.a)object0))).f);
            ArrayList arrayList0 = linkedHashMap0.get(e0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                linkedHashMap0.put(e0, arrayList0);
            }
            arrayList0.add(object0);
        }
        this.a = q.c(linkedHashMap0);
        r r1 = this.i;
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        for(Object object1: list1) {
            qf.e e1 = c.B(((f)r1.b.b), ((lf.I)(((rf.a)object1))).f);
            ArrayList arrayList1 = linkedHashMap1.get(e1);
            if(arrayList1 == null) {
                arrayList1 = new ArrayList();
                linkedHashMap1.put(e1, arrayList1);
            }
            arrayList1.add(object1);
        }
        this.b = q.c(linkedHashMap1);
        ((Df.i)this.i.b.a).c.getClass();
        r r2 = this.i;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for(Object object2: list2) {
            qf.e e2 = c.B(((f)r2.b.b), ((V)(((rf.a)object2))).e);
            ArrayList arrayList2 = linkedHashMap2.get(e2);
            if(arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap2.put(e2, arrayList2);
            }
            arrayList2.add(object2);
        }
        this.c = q.c(linkedHashMap2);
        this.d = ((Df.i)this.i.b.a).a.b(new o(this, 0));
        this.e = ((Df.i)this.i.b.a).a.b(new o(this, 1));
        this.f = ((Df.i)this.i.b.a).a.c(new o(this, 2));
        m m0 = ((Df.i)this.i.b.a).a;
        p p0 = new p(this, this.i, 0);
        m0.getClass();
        this.g = new i(m0, p0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        m m1 = ((Df.i)this.i.b.a).a;
        p p1 = new p(this, this.i, 1);
        m1.getClass();
        this.h = new i(m1, p1);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    public final Collection a(qf.e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return !((Set)P4.a.r(this.g, q.j[0])).contains(e0) ? je.w.a : ((Collection)this.d.invoke(e0));
    }

    public final Collection b(qf.e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return !((Set)P4.a.r(this.h, q.j[1])).contains(e0) ? je.w.a : ((Collection)this.e.invoke(e0));
    }

    public static LinkedHashMap c(LinkedHashMap linkedHashMap0) {
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(D.N(linkedHashMap0.size()));
        for(Object object0: linkedHashMap0.entrySet()) {
            Object object1 = ((Map.Entry)object0).getKey();
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            Iterable iterable0 = (Iterable)((Map.Entry)object0).getValue();
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object2: iterable0) {
                int v = ((rf.a)object2).a();
                g g0 = g.w(byteArrayOutputStream0, (g.h(v) + v <= 0x1000 ? g.h(v) + v : 0x1000));
                g0.M(v);
                ((rf.a)object2).d(g0);
                g0.k();
                arrayList0.add(H.a);
            }
            linkedHashMap1.put(object1, byteArrayOutputStream0.toByteArray());
        }
        return linkedHashMap1;
    }
}

