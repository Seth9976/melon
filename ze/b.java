package Ze;

import Ac.q0;
import J0.h;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import je.D;
import je.I;
import je.p;
import je.u;
import je.w;
import kotlin.jvm.internal.q;
import qf.c;
import qf.e;
import vf.g;
import vf.j;
import xf.d;

public final class b {
    public final h a;
    public final ConcurrentHashMap b;
    public static final LinkedHashMap c;

    static {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        a[] arr_a = a.values();
        for(int v = 0; v < arr_a.length; ++v) {
            a a0 = arr_a[v];
            String s = a0.a;
            if(linkedHashMap0.get(s) == null) {
                linkedHashMap0.put(s, a0);
            }
        }
        b.c = linkedHashMap0;
    }

    public b(h h0) {
        this.a = h0;
        this.b = new ConcurrentHashMap();
    }

    public static ArrayList a(Object object0, boolean z) {
        q.g(((Ne.b)object0), "<this>");
        Map map0 = ((Ne.b)object0).a();
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: map0.entrySet()) {
            e e0 = (e)((Map.Entry)object1).getKey();
            g g0 = (g)((Map.Entry)object1).getValue();
            List list0 = !z || q.b(e0, v.b) ? b.j(g0) : w.a;
            u.U(arrayList0, list0);
        }
        return arrayList0;
    }

    public final s b(s s0, Ne.h h0) {
        m m2;
        hf.h h4;
        ie.m m3;
        boolean z4;
        m m1;
        z z1;
        boolean z;
        q.g(h0, "annotations");
        h h1 = this.a;
        if(!h1.b) {
            ArrayList arrayList0 = new ArrayList();
            Iterator iterator0 = h0.iterator();
            while(true) {
                z = false;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                c c0 = b.d(object0);
                m m0 = (m)n.e.get(c0);
                if(m0 == null) {
                    m1 = null;
                }
                else {
                    c c1 = b.d(object0);
                    if(c1 == null || !((Map)n.c).containsKey(c1)) {
                        z z2 = this.h(object0);
                        z1 = z2 == null ? ((t)h1.c).a : z2;
                    }
                    else {
                        z1 = (z)((q0)h1.d).invoke(c1);
                    }
                    if(z1 == z.b) {
                        z1 = null;
                    }
                    if(z1 != null) {
                        hf.h h2 = hf.h.a(m0.a, null, z1 == z.c, 1);
                        q.g(m0.b, "qualifierApplicabilityTypes");
                        m1 = new m(h2, m0.b, m0.c);
                    }
                }
                if(m1 == null) {
                    if(((t)h1.c).d) {
                        m3 = null;
                    }
                    else {
                        Object object1 = b.c(object0, Ze.w.f);
                        if(object1 != null) {
                            for(Object object2: b.e(object0)) {
                                if(this.i(object2) == null) {
                                    continue;
                                }
                                goto label_37;
                            }
                            object2 = null;
                        label_37:
                            if(object2 != null) {
                                ArrayList arrayList1 = b.a(object1, true);
                                LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                                for(Object object3: arrayList1) {
                                    a a0 = (a)b.c.get(((String)object3));
                                    if(a0 != null) {
                                        linkedHashSet0.add(a0);
                                    }
                                }
                                if(linkedHashSet0.contains(a.e)) {
                                    Set set0 = je.n.A0(a.values());
                                    a a1 = a.f;
                                    LinkedHashSet linkedHashSet1 = new LinkedHashSet(D.N(set0.size()));
                                    boolean z3 = false;
                                    for(Object object4: set0) {
                                        if(z3 || !q.b(object4, a1)) {
                                            z4 = true;
                                        }
                                        else {
                                            z4 = false;
                                            z3 = true;
                                        }
                                        if(z4) {
                                            linkedHashSet1.add(object4);
                                        }
                                    }
                                    linkedHashSet0 = I.K(linkedHashSet1, linkedHashSet0);
                                }
                                m3 = new ie.m(object2, linkedHashSet0);
                            }
                        }
                    }
                    if(m3 != null) {
                        Object object5 = m3.a;
                        Set set1 = (Set)m3.b;
                        z z5 = this.h(object0);
                        if(z5 == null) {
                            z z6 = this.h(object5);
                            z5 = z6 == null ? ((t)h1.c).a : z6;
                        }
                        z z7 = z.b;
                        if(z5 != z7) {
                            q.g(object5, "$this$extractNullability");
                            hf.h h3 = this.g(object5, false);
                            if(h3 == null) {
                                Object object6 = this.i(object5);
                                if(object6 != null) {
                                    z z8 = this.h(object5);
                                    if(z8 == null) {
                                        z8 = ((t)h1.c).a;
                                    }
                                    if(z8 != z7) {
                                        hf.h h5 = this.g(object6, false);
                                        h4 = h5 == null ? null : hf.h.a(h5, null, z8 == z.c, 1);
                                        goto label_94;
                                    }
                                }
                                h4 = null;
                            }
                            else {
                                h4 = h3;
                            }
                        label_94:
                            if(h4 == null) {
                                m2 = null;
                            }
                            else {
                                if(z5 == z.c) {
                                    z = true;
                                }
                                m2 = new m(hf.h.a(h4, null, z, 1), set1);
                            }
                            goto label_102;
                        }
                    }
                    m2 = null;
                }
                else {
                    m2 = m1;
                }
            label_102:
                if(m2 != null) {
                    arrayList0.add(m2);
                }
            }
            if(!arrayList0.isEmpty()) {
                Class class0 = a.class;
                EnumMap enumMap0 = new EnumMap(class0);
                for(Object object7: arrayList0) {
                    m m4 = (m)object7;
                    for(Object object8: m4.b) {
                        enumMap0.containsKey(((a)object8));
                        enumMap0.put(((a)object8), m4);
                    }
                }
                EnumMap enumMap1 = s0 == null ? new EnumMap(class0) : new EnumMap(s0.a);
                for(Object object9: enumMap0.entrySet()) {
                    a a2 = (a)((Map.Entry)object9).getKey();
                    m m5 = (m)((Map.Entry)object9).getValue();
                    if(m5 != null) {
                        enumMap1.put(a2, m5);
                        z = true;
                    }
                }
                return z ? new s(enumMap1) : s0;
            }
        }
        return s0;
    }

    public static Object c(Object object0, c c0) {
        for(Object object1: b.e(object0)) {
            if(q.b(b.d(object1), c0)) {
                return object1;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public static c d(Object object0) {
        q.g(((Ne.b)object0), "<this>");
        return ((Ne.b)object0).b();
    }

    public static Iterable e(Object object0) {
        q.g(((Ne.b)object0), "<this>");
        Me.e e0 = d.d(((Ne.b)object0));
        if(e0 != null) {
            Iterable iterable0 = e0.getAnnotations();
            if(iterable0 != null) {
                return iterable0;
            }
        }
        return w.a;
    }

    public static boolean f(Object object0, c c0) {
        Iterable iterable0 = b.e(object0);
        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
            for(Object object1: iterable0) {
                if(q.b(b.d(object1), c0)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public final hf.h g(Object object0, boolean z) {
        hf.g g0;
        c c0 = b.d(object0);
        if(c0 != null) {
            boolean z1 = false;
            z z2 = (z)((q0)this.a.d).invoke(c0);
            z2.getClass();
            if(z2 == z.b) {
                return null;
            }
            if(Ze.w.k.contains(c0)) {
                g0 = hf.g.c;
                goto label_28;
            }
            if(Ze.w.l.contains(c0)) {
                g0 = hf.g.b;
                goto label_28;
            }
            boolean z3 = false;
            if(Ze.w.m.contains(c0)) {
                z3 = true;
                g0 = hf.g.a;
            }
            else if(c0.equals(Ze.w.g)) {
                z3 = true;
                String s = (String)p.l0(b.a(object0, false));
                if(s == null) {
                    g0 = hf.g.c;
                }
                else {
                    switch(s) {
                        case "ALWAYS": {
                            g0 = hf.g.c;
                            break;
                        }
                        case "MAYBE": 
                        case "NEVER": {
                            g0 = hf.g.b;
                            break;
                        }
                        case "UNKNOWN": {
                            g0 = hf.g.a;
                            break;
                        }
                        default: {
                            return null;
                        }
                    }
                }
            }
            if(z3) {
            label_28:
                if(z2 == z.c || z) {
                    z1 = true;
                }
                return new hf.h(g0, z1);
            }
        }
        return null;
    }

    public final z h(Object object0) {
        t t0 = (t)this.a.c;
        c c0 = b.d(object0);
        z z0 = (z)t0.c.get(c0);
        if(z0 != null) {
            return z0;
        }
        Object object1 = b.c(object0, Ze.w.q);
        if(object1 != null) {
            String s = (String)p.l0(b.a(object1, false));
            if(s != null) {
                z z1 = t0.b;
                if(z1 == null) {
                    switch(s) {
                        case "IGNORE": {
                            return z.b;
                        }
                        case "STRICT": {
                            return z.d;
                        }
                        case "WARN": {
                            return z.c;
                        }
                        default: {
                            return null;
                        }
                    }
                }
                return z1;
            }
        }
        return null;
    }

    public final Object i(Object object0) {
        q.g(object0, "annotation");
        if(!((t)this.a.c).d) {
            c c0 = b.d(object0);
            if(p.d0(Ze.w.j, c0) || b.f(object0, Ze.w.d)) {
                return object0;
            }
            if(b.f(object0, Ze.w.e)) {
                Me.e e0 = d.d(((Ne.b)object0));
                q.d(e0);
                ConcurrentHashMap concurrentHashMap0 = this.b;
                Object object1 = concurrentHashMap0.get(e0);
                if(object1 != null) {
                    return object1;
                }
                Object object2 = null;
                for(Object object3: b.e(object0)) {
                    Object object4 = this.i(object3);
                    if(object4 != null) {
                        object2 = object4;
                        break;
                    }
                }
                if(object2 != null) {
                    Object object5 = concurrentHashMap0.putIfAbsent(e0, object2);
                    return object5 == null ? object2 : object5;
                }
            }
        }
        return null;
    }

    public static List j(g g0) {
        if(g0 instanceof vf.b) {
            List list0 = new ArrayList();
            for(Object object0: ((Iterable)((vf.b)g0).a)) {
                u.U(list0, b.j(((g)object0)));
            }
            return list0;
        }
        return g0 instanceof j ? k.z(((j)g0).c.c()) : w.a;
    }
}

