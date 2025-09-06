package kg;

import com.google.firebase.messaging.u;
import d3.g;
import ie.m;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import je.C;
import je.x;
import kotlin.jvm.internal.q;
import lg.b;

public final class p {
    public final b a;
    public final u b;
    public final Map c;
    public final Map d;
    public final r e;
    public final l f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public p(l l0, String s, String s1, String s2, String s3, String s4, String s5, List list0, List list1) {
        q.g(l0, "device");
        Map map1;
        q.g(s1, "serviceType");
        q.g(s2, "serviceId");
        q.g(s3, "scpdUrl");
        q.g(s4, "controlUrl");
        q.g(s5, "eventSubUrl");
        q.g(list0, "actionBuilderList");
        q.g(list1, "stateVariables");
        super();
        this.f = l0;
        this.g = s;
        this.h = s1;
        this.i = s2;
        this.j = s4;
        this.k = s5;
        this.a = l0.f.l;
        this.b = l0.f.m;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list1));
        for(Object object0: list1) {
            arrayList0.add(new m(((kg.q)object0).b, ((kg.q)object0)));
        }
        Map map0 = C.Y(arrayList0);
        this.d = map0;
        this.e = g.Q(new o(this, 2));
        if(list0.isEmpty()) {
            map1 = x.a;
        }
        else {
            for(Object object1: list0) {
                ((a)object1).getClass();
                ((a)object1).a = this;
                for(Object object2: ((a)object1).c) {
                    f f0 = (f)object2;
                    String s6 = f0.c;
                    if(s6 == null) {
                        throw new IllegalStateException("relatedStateVariable name is null");
                    }
                    kg.q q0 = (kg.q)map0.get(s6);
                    if(q0 == null) {
                        String s7 = Tf.o.e1(s6).toString();
                        kg.q q1 = (kg.q)map0.get(s7);
                        if(q1 == null) {
                            throw new IllegalStateException("There is no StateVariable [" + s6 + ']');
                        }
                        q.g(s7, "name");
                        f0.c = s7;
                        q0 = q1;
                    }
                    f0.d = q0;
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
            for(Object object3: list0) {
                p p0 = ((a)object3).a;
                if(p0 == null) {
                    throw new IllegalStateException("service must be set.");
                }
                String s8 = ((a)object3).b;
                if(s8 == null) {
                    throw new IllegalStateException("name must be set.");
                }
                ArrayList arrayList2 = new ArrayList(je.q.Q(10, ((a)object3).c));
                for(Object object4: ((a)object3).c) {
                    String s9 = ((f)object4).a;
                    if(s9 == null) {
                        throw new IllegalStateException("name must be set.");
                    }
                    kg.q q2 = ((f)object4).d;
                    if(q2 == null) {
                        throw new IllegalStateException("related state variable must be set.");
                    }
                    arrayList2.add(new kg.g(s9, ((f)object4).b, q2));
                }
                ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
                for(Object object5: arrayList2) {
                    arrayList3.add(new m(((kg.g)object5).a, ((kg.g)object5)));
                }
                arrayList1.add(new d(p0, s8, C.Y(arrayList3)));
            }
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object6: arrayList1) {
                arrayList4.add(new m(((d)object6).d, ((d)object6)));
            }
            map1 = C.Y(arrayList4);
        }
        this.c = map1;
        g.Q(new o(this, 0));
        g.Q(new o(this, 1));
    }

    public final kg.r a() {
        return (kg.r)this.e.getValue();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        return object0 instanceof p ? q.b(this.f, ((p)object0).f) && q.b(this.i, ((p)object0).i) : false;
    }

    @Override
    public final int hashCode() {
        return this.i.hashCode() + this.f.j.hashCode();
    }
}

