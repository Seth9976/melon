package df;

import Ac.q0;
import Se.n;
import Se.t;
import Se.w;
import Se.z;
import Sf.f;
import Sf.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.D;
import je.p;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class a implements c {
    public final n a;
    public final k b;
    public final q0 c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final LinkedHashMap f;

    public a(n n0, k k0) {
        q.g(n0, "jClass");
        super();
        this.a = n0;
        this.b = k0;
        q0 q00 = new q0(this, 21);
        this.c = q00;
        g g0 = new g(p.c0(n0.d()), true, q00);
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        f f0 = new f(g0);
        while(f0.hasNext()) {
            Object object0 = f0.next();
            e e0 = ((w)object0).c();
            ArrayList arrayList0 = linkedHashMap0.get(e0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                linkedHashMap0.put(e0, arrayList0);
            }
            arrayList0.add(object0);
        }
        this.d = linkedHashMap0;
        g g1 = new g(p.c0(this.a.b()), true, this.b);
        LinkedHashMap linkedHashMap1 = new LinkedHashMap();
        f f1 = new f(g1);
        while(f1.hasNext()) {
            Object object1 = f1.next();
            linkedHashMap1.put(((t)object1).c(), object1);
        }
        this.e = linkedHashMap1;
        ArrayList arrayList1 = this.a.f();
        k k1 = this.b;
        ArrayList arrayList2 = new ArrayList();
        for(Object object2: arrayList1) {
            if(((Boolean)k1.invoke(object2)).booleanValue()) {
                arrayList2.add(object2);
            }
        }
        int v = D.N(je.q.Q(10, arrayList2));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(v);
        for(Object object3: arrayList2) {
            linkedHashMap2.put(((z)object3).c(), object3);
        }
        this.f = linkedHashMap2;
    }

    @Override  // df.c
    public final Set a() {
        g g0 = new g(p.c0(this.a.d()), true, this.c);
        Set set0 = new LinkedHashSet();
        f f0 = new f(g0);
        while(f0.hasNext()) {
            set0.add(((w)f0.next()).c());
        }
        return set0;
    }

    @Override  // df.c
    public final Set b() {
        return this.f.keySet();
    }

    @Override  // df.c
    public final Set c() {
        g g0 = new g(p.c0(this.a.b()), true, this.b);
        Set set0 = new LinkedHashSet();
        f f0 = new f(g0);
        while(f0.hasNext()) {
            set0.add(((t)f0.next()).c());
        }
        return set0;
    }

    @Override  // df.c
    public final t d(e e0) {
        q.g(e0, "name");
        return (t)this.e.get(e0);
    }

    @Override  // df.c
    public final Collection e(e e0) {
        q.g(e0, "name");
        List list0 = (List)this.d.get(e0);
        return list0 != null ? list0 : je.w.a;
    }

    @Override  // df.c
    public final z f(e e0) {
        q.g(e0, "name");
        return (z)this.f.get(e0);
    }
}

