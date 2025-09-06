package Y6;

import H7.k;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import v7.b;
import ye.a;

public final class h implements d {
    public final HashMap a;
    public final HashMap b;
    public final HashMap c;
    public final HashSet d;
    public final m e;
    public final AtomicReference f;
    public final R6.d g;
    public static final k h;

    static {
        h.h = new k(1);
    }

    public h(ArrayList arrayList0, ArrayList arrayList1, R6.d d0) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashSet();
        this.f = new AtomicReference();
        m m0 = new m();
        this.e = m0;
        this.g = d0;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(c.c(m0, m.class, new Class[]{v7.c.class, b.class}));
        arrayList2.add(c.c(this, h.class, new Class[0]));
        for(Object object0: arrayList1) {
            c c0 = (c)object0;
            if(c0 != null) {
                arrayList2.add(c0);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object1: arrayList0) {
            arrayList3.add(object1);
        }
        ArrayList arrayList4 = new ArrayList();
        synchronized(this) {
            Iterator iterator2 = arrayList3.iterator();
            while(iterator2.hasNext()) {
                Object object2 = iterator2.next();
                y7.b b0 = (y7.b)object2;
                try {
                    ComponentRegistrar componentRegistrar0 = (ComponentRegistrar)b0.get();
                    if(componentRegistrar0 == null) {
                        continue;
                    }
                    arrayList2.addAll(this.g.y(componentRegistrar0));
                    iterator2.remove();
                }
                catch(n n0) {
                    iterator2.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", n0);
                }
            }
            Iterator iterator3 = arrayList2.iterator();
            while(iterator3.hasNext()) {
                Object object3 = iterator3.next();
                Object[] arr_object = ((c)object3).b.toArray();
                int v1 = 0;
            label_46:
                if(v1 >= arr_object.length) {
                    continue;
                }
                Object object4 = arr_object[v1];
                if(object4.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                    if(this.d.contains(object4.toString())) {
                        iterator3.remove();
                        continue;
                    }
                    this.d.add(object4.toString());
                }
                ++v1;
                goto label_46;
            }
            if(this.a.isEmpty()) {
                a.z(arrayList2);
            }
            else {
                ArrayList arrayList5 = new ArrayList(this.a.keySet());
                arrayList5.addAll(arrayList2);
                a.z(arrayList5);
            }
            for(Object object5: arrayList2) {
                o o0 = new o(new g(0, this, ((c)object5)));
                this.a.put(((c)object5), o0);
            }
            arrayList4.addAll(this.i(arrayList2));
            arrayList4.addAll(this.j());
            this.h();
        }
        for(Object object6: arrayList4) {
            ((Runnable)object6).run();
        }
        Boolean boolean0 = (Boolean)this.f.get();
        if(boolean0 != null) {
            this.g(this.a, boolean0.booleanValue());
        }
    }

    @Override  // Y6.d
    public final q a(s s0) {
        y7.b b0 = this.c(s0);
        if(b0 == null) {
            return new q(q.c, q.d);
        }
        return b0 instanceof q ? ((q)b0) : new q(null, b0);
    }

    @Override  // Y6.d
    public final y7.b c(s s0) {
        synchronized(this) {
            B.a.o(s0, "Null interface requested.");
            return (y7.b)this.b.get(s0);
        }
    }

    @Override  // Y6.d
    public final y7.b f(s s0) {
        synchronized(this) {
            y7.b b0 = (p)this.c.get(s0);
            return b0 != null ? b0 : h.h;
        }
    }

    public final void g(HashMap hashMap0, boolean z) {
        ArrayDeque arrayDeque0;
        for(Object object0: hashMap0.entrySet()) {
            c c0 = (c)((Map.Entry)object0).getKey();
            y7.b b0 = (y7.b)((Map.Entry)object0).getValue();
            if(c0.d == 1 || c0.d == 2 && z) {
                b0.get();
            }
        }
        m m0 = this.e;
        synchronized(m0) {
            arrayDeque0 = m0.b;
            if(arrayDeque0 == null) {
                arrayDeque0 = null;
            }
            else {
                m0.b = null;
            }
        }
        if(arrayDeque0 != null) {
            Iterator iterator1 = arrayDeque0.iterator();
            if(iterator1.hasNext()) {
                throw H0.b.b(iterator1);
            }
        }
    }

    public final void h() {
        HashMap hashMap0 = this.b;
        HashMap hashMap1 = this.c;
        for(Object object0: this.a.keySet()) {
            c c0 = (c)object0;
            for(Object object1: c0.c) {
                Y6.k k0 = (Y6.k)object1;
                s s0 = k0.a;
                if(k0.b == 2 && !hashMap1.containsKey(s0)) {
                    Set set0 = Collections.EMPTY_SET;
                    p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                    p0.b = null;
                    p0.a = Collections.newSetFromMap(new ConcurrentHashMap());
                    p0.a.addAll(set0);
                    hashMap1.put(s0, p0);
                }
                else if(!hashMap0.containsKey(s0)) {
                    switch(k0.b) {
                        case 1: {
                            throw new l("Unsatisfied dependency for component " + c0 + ": " + s0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                        }
                        case 2: {
                            continue;
                        }
                    }
                    hashMap0.put(s0, new q(q.c, q.d));
                }
            }
        }
    }

    public final ArrayList i(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            c c0 = (c)object0;
            if(c0.e == 0) {
                y7.b b0 = (y7.b)this.a.get(c0);
                for(Object object1: c0.b) {
                    s s0 = (s)object1;
                    HashMap hashMap0 = this.b;
                    if(hashMap0.containsKey(s0)) {
                        arrayList1.add(new A3.m(7, ((q)(((y7.b)hashMap0.get(s0)))), b0));
                    }
                    else {
                        hashMap0.put(s0, b0);
                    }
                }
            }
        }
        return arrayList1;
    }

    public final ArrayList j() {
        HashMap hashMap0 = this.c;
        ArrayList arrayList0 = new ArrayList();
        HashMap hashMap1 = new HashMap();
        for(Object object0: this.a.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            c c0 = (c)map$Entry0.getKey();
            if(c0.e != 0) {
                y7.b b0 = (y7.b)map$Entry0.getValue();
                for(Object object1: c0.b) {
                    s s0 = (s)object1;
                    if(!hashMap1.containsKey(s0)) {
                        hashMap1.put(s0, new HashSet());
                    }
                    ((Set)hashMap1.get(s0)).add(b0);
                }
            }
        }
        for(Object object2: hashMap1.entrySet()) {
            Map.Entry map$Entry1 = (Map.Entry)object2;
            if(hashMap0.containsKey(map$Entry1.getKey())) {
                p p1 = (p)hashMap0.get(map$Entry1.getKey());
                for(Object object3: ((Set)map$Entry1.getValue())) {
                    arrayList0.add(new A3.m(8, p1, ((y7.b)object3)));
                }
            }
            else {
                s s1 = (s)map$Entry1.getKey();
                Set set0 = (Set)(((Collection)map$Entry1.getValue()));
                p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                p0.b = null;
                p0.a = Collections.newSetFromMap(new ConcurrentHashMap());
                p0.a.addAll(set0);
                hashMap0.put(s1, p0);
            }
        }
        return arrayList0;
    }
}

