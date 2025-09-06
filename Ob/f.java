package ob;

import d5.n;
import df.v;
import e1.u;
import fc.a;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.D;
import je.p;
import je.q;
import kotlin.coroutines.Continuation;
import oc.Q;
import oe.i;
import q2.b;
import q2.h;
import we.o;

public final class f extends i implements o {
    public Object B;
    public final int r;
    public Object w;

    public f(int v, int v1, Continuation continuation0) {
        this.r = v1;
        super(v, continuation0);
    }

    public f(z z0, Continuation continuation0) {
        this.r = 0;
        this.B = z0;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.r) {
            case 0: {
                Q q0 = (Q)object1;
                f f1 = new f(((z)this.B), ((Continuation)object2));
                f1.w = (a)object0;
                return f1.invokeSuspend(H.a);
            }
            case 1: {
                f f2 = new f(3, 1, ((Continuation)object2));
                f2.w = (o2.f)object0;
                f2.B = (h)object1;
                return f2.invokeSuspend(H.a);
            }
            default: {
                f f0 = new f(3, 2, ((Continuation)object2));
                f0.w = (String)object0;
                f0.B = (String)object1;
                return f0.invokeSuspend(H.a);
            }
        }
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = true;
        switch(this.r) {
            case 0: {
                a a0 = (a)this.w;
                n.D(object0);
                return ((z)this.B).d(a0);
            }
            case 1: {
                n.D(object0);
                o2.f f0 = (o2.f)this.w;
                h h0 = (h)this.B;
                Iterable iterable0 = h0.a().keySet();
                ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
                for(Object object1: iterable0) {
                    arrayList0.add(((q2.f)object1).a);
                }
                Map map0 = f0.a.getAll();
                kotlin.jvm.internal.q.f(map0, "prefs.all");
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                for(Object object2: map0.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object2;
                    String s2 = (String)map$Entry0.getKey();
                    if((f0.b == null ? true : f0.b.contains(s2))) {
                        linkedHashMap0.put(map$Entry0.getKey(), map$Entry0.getValue());
                    }
                }
                LinkedHashMap linkedHashMap1 = new LinkedHashMap(D.N(linkedHashMap0.size()));
                for(Object object3: linkedHashMap0.entrySet()) {
                    Object object4 = ((Map.Entry)object3).getKey();
                    Set set0 = ((Map.Entry)object3).getValue();
                    if(set0 instanceof Set) {
                        set0 = p.T0(set0);
                    }
                    linkedHashMap1.put(object4, set0);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for(Object object5: linkedHashMap1.entrySet()) {
                    Map.Entry map$Entry1 = (Map.Entry)object5;
                    if(!arrayList0.contains(((String)map$Entry1.getKey()))) {
                        linkedHashMap2.put(map$Entry1.getKey(), map$Entry1.getValue());
                    }
                }
                b b0 = h0.c();
                for(Object object6: linkedHashMap2.entrySet()) {
                    String s3 = (String)((Map.Entry)object6).getKey();
                    Object object7 = ((Map.Entry)object6).getValue();
                    if(object7 instanceof Boolean) {
                        b0.h(v.n(s3), object7);
                    }
                    else if(object7 instanceof Float) {
                        kotlin.jvm.internal.q.g(s3, "name");
                        b0.h(new q2.f(s3), object7);
                    }
                    else if(object7 instanceof Integer) {
                        b0.h(v.z(s3), object7);
                    }
                    else if(object7 instanceof Long) {
                        b0.h(v.B(s3), object7);
                    }
                    else if(object7 instanceof String) {
                        b0.h(v.K(s3), object7);
                    }
                    else if(object7 instanceof Set) {
                        kotlin.jvm.internal.q.g(s3, "name");
                        q2.f f1 = new q2.f(s3);
                        kotlin.jvm.internal.q.e(object7, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                        b0.h(f1, ((Set)object7));
                    }
                }
                return b0.d();
            }
            default: {
                String s = (String)this.w;
                String s1 = (String)this.B;
                n.D(object0);
                if(!u.o(s) || s1.length() <= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
    }
}

