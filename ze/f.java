package Ze;

import Je.o;
import Je.p;
import Le.d;
import ie.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.C;
import je.D;
import je.q;
import qf.b;
import qf.c;
import qf.e;

public abstract class f {
    public static final Object a;
    public static final LinkedHashMap b;
    public static final Set c;
    public static final Set d;

    static {
        e e0 = e.e("name");
        m m0 = new m(o.j.a(e0).g(), p.d);
        e e1 = e.e("ordinal");
        m m1 = new m(o.j.a(e1).g(), e.e("ordinal"));
        m m2 = new m(d5.f.g("size", o.C), e.e("size"));
        m m3 = new m(d5.f.g("size", o.G), e.e("size"));
        e e2 = e.e("length");
        Map map0 = C.S(new m[]{m0, m1, m2, m3, new m(o.e.a(e2).g(), e.e("length")), new m(d5.f.g("keys", o.G), e.e("keySet")), new m(d5.f.g("values", o.G), e.e("values")), new m(d5.f.g("entries", o.G), e.e("entrySet")), new m(d5.f.g("size", o.a0), e.e("length")), new m(d5.f.g("size", o.b0), e.e("length")), new m(d5.f.g("size", o.c0), e.e("length"))});
        f.a = map0;
        Iterable iterable0 = map0.entrySet();
        ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(new m(((c)((Map.Entry)object0).getKey()).a.f(), ((Map.Entry)object0).getValue()));
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object1: arrayList0) {
            e e3 = (e)((m)object1).b;
            ArrayList arrayList1 = linkedHashMap0.get(e3);
            if(arrayList1 == null) {
                arrayList1 = new ArrayList();
                linkedHashMap0.put(e3, arrayList1);
            }
            arrayList1.add(((e)((m)object1).a));
        }
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(D.N(linkedHashMap0.size()));
        for(Object object2: linkedHashMap0.entrySet()) {
            linkedHashMap1.put(((Map.Entry)object2).getKey(), je.p.e0(((Iterable)((Map.Entry)object2).getValue())));
        }
        f.b = linkedHashMap1;
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object3: ((Map)f.a).entrySet()) {
            b b0 = d.f(((c)((Map.Entry)object3).getKey()).b().a);
            kotlin.jvm.internal.q.d(b0);
            linkedHashSet0.add(b0.a().a(((e)((Map.Entry)object3).getValue())));
        }
        Set set0 = ((Map)f.a).keySet();
        f.c = set0;
        ArrayList arrayList2 = new ArrayList(q.Q(10, set0));
        for(Object object4: set0) {
            arrayList2.add(((c)object4).a.f());
        }
        f.d = je.p.T0(arrayList2);
    }
}

