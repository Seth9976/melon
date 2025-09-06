package q2;

import ie.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.D;
import je.p;
import je.q;
import n2.a;

public final class b extends h {
    public final LinkedHashMap a;
    public final a b;

    public b(LinkedHashMap linkedHashMap0, boolean z) {
        this.a = linkedHashMap0;
        this.b = new a(z);
    }

    public b(boolean z) {
        this(new LinkedHashMap(), z);
    }

    @Override  // q2.h
    public final Map a() {
        m m0;
        Iterable iterable0 = this.a.entrySet();
        int v = D.N(q.Q(10, iterable0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        for(Object object0: iterable0) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Object object1 = map$Entry0.getValue();
            if(object1 instanceof byte[]) {
                Object object2 = map$Entry0.getKey();
                byte[] arr_b = Arrays.copyOf(((byte[])object1), ((byte[])object1).length);
                kotlin.jvm.internal.q.f(arr_b, "copyOf(this, size)");
                m0 = new m(object2, arr_b);
            }
            else {
                m0 = new m(map$Entry0.getKey(), map$Entry0.getValue());
            }
            linkedHashMap0.put(m0.a, m0.b);
        }
        Map map0 = Collections.unmodifiableMap(linkedHashMap0);
        kotlin.jvm.internal.q.f(map0, "unmodifiableMap(map)");
        return map0;
    }

    @Override  // q2.h
    public final Object b(f f0) {
        kotlin.jvm.internal.q.g(f0, "key");
        byte[] arr_b = this.a.get(f0);
        if(arr_b instanceof byte[]) {
            arr_b = Arrays.copyOf(arr_b, arr_b.length);
            kotlin.jvm.internal.q.f(arr_b, "copyOf(this, size)");
        }
        return arr_b;
    }

    public final void e() {
        if(this.b.a.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    @Override
    public final boolean equals(Object object0) {
        boolean z;
        if(object0 instanceof b) {
            LinkedHashMap linkedHashMap0 = ((b)object0).a;
            LinkedHashMap linkedHashMap1 = this.a;
            if(linkedHashMap0 == linkedHashMap1) {
                return true;
            }
            if(linkedHashMap0.size() == linkedHashMap1.size()) {
                LinkedHashMap linkedHashMap2 = ((b)object0).a;
                if(!linkedHashMap2.isEmpty()) {
                    for(Object object1: linkedHashMap2.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object1;
                        Object object2 = linkedHashMap1.get(map$Entry0.getKey());
                        if(object2 == null) {
                            z = false;
                        }
                        else {
                            Object object3 = map$Entry0.getValue();
                            if(!(object3 instanceof byte[])) {
                                z = kotlin.jvm.internal.q.b(object3, object2);
                            }
                            else if(object2 instanceof byte[] && Arrays.equals(((byte[])object3), ((byte[])object2))) {
                                z = true;
                            }
                        }
                        if(z) {
                            continue;
                        }
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(f f0) {
        kotlin.jvm.internal.q.g(f0, "key");
        this.e();
        this.a.remove(f0);
    }

    public final void g(f f0, Object object0) {
        kotlin.jvm.internal.q.g(f0, "key");
        this.h(f0, object0);
    }

    public final void h(f f0, Object object0) {
        kotlin.jvm.internal.q.g(f0, "key");
        this.e();
        if(object0 == null) {
            this.f(f0);
            return;
        }
        LinkedHashMap linkedHashMap0 = this.a;
        if(object0 instanceof Set) {
            Set set0 = Collections.unmodifiableSet(p.T0(((Set)object0)));
            kotlin.jvm.internal.q.f(set0, "unmodifiableSet(set.toSet())");
            linkedHashMap0.put(f0, set0);
            return;
        }
        if(object0 instanceof byte[]) {
            byte[] arr_b = Arrays.copyOf(((byte[])object0), ((byte[])object0).length);
            kotlin.jvm.internal.q.f(arr_b, "copyOf(this, size)");
            linkedHashMap0.put(f0, arr_b);
            return;
        }
        linkedHashMap0.put(f0, object0);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.a.entrySet()) {
            Object object1 = ((Map.Entry)object0).getValue();
            v += (object1 instanceof byte[] ? Arrays.hashCode(((byte[])object1)) : object1.hashCode());
        }
        return v;
    }

    @Override
    public final String toString() {
        return p.q0(this.a.entrySet(), ",\n", "{\n", "\n}", q2.a.f, 24);
    }
}

