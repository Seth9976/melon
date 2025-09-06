package I6;

import i.n.i.b.a.s.e.B1;
import i.n.i.b.a.s.e.F;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.Y4;
import i.n.i.b.a.s.e.b5;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import x1.a;

public final class s extends AbstractCollection {
    public final int a;
    public final Object b;

    public s(Serializable serializable0, int v) {
        this.a = v;
        this.b = serializable0;
        super();
    }

    public s(AbstractMap abstractMap0, int v) {
        this.a = v;
        super();
        this.b = abstractMap0;
    }

    @Override
    public final void clear() {
        switch(this.a) {
            case 0: {
                ((q)this.b).d();
                return;
            }
            case 1: {
                ((B)this.b).clear();
                return;
            }
            case 2: {
                ((f)this.b).clear();
                return;
            }
            case 3: {
                ((f)this.b).clear();
                return;
            }
            case 4: {
                ((B1)this.b).c();
                return;
            }
            default: {
                ((b5)this.b).clear();
            }
        }
    }

    @Override
    public boolean contains(Object object0) {
        switch(this.a) {
            case 0: {
                for(Object object1: ((q)this.b).a().values()) {
                    if(((Collection)object1).contains(object0)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
                return false;
            }
            case 2: {
                return ((f)this.b).containsValue(object0);
            }
            case 3: {
                return ((f)this.b).containsValue(object0);
            }
            case 4: {
                return ((B1)this.b).a(object0);
            }
            default: {
                return super.contains(object0);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        switch(this.a) {
            case 2: {
                return ((f)this.b).isEmpty();
            }
            case 3: {
                return ((f)this.b).isEmpty();
            }
            default: {
                return super.isEmpty();
            }
        }
    }

    @Override
    public final Iterator iterator() {
        switch(this.a) {
            case 0: {
                return new c(((q)this.b));
            }
            case 1: {
                B b0 = (B)this.b;
                Map map0 = b0.b();
                return map0 != null ? map0.values().iterator() : new x(b0, 2);
            }
            case 2: {
                return new i0(((f)this.b).entrySet().iterator());  // 初始化器: LI6/F0;-><init>(Ljava/util/Iterator;)V
            }
            case 3: {
                return new F(((f)this.b).entrySet().iterator());
            }
            case 4: {
                return new c(((B1)this.b));
            }
            default: {
                return new Y4(((b5)this.b), 2);
            }
        }
    }

    @Override
    public boolean remove(Object object0) {
        switch(this.a) {
            case 2: {
                f f0 = (f)this.b;
                try {
                    return super.remove(object0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    for(Object object1: f0.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object1;
                        if(a.w(object0, map$Entry0.getValue())) {
                            f0.remove(map$Entry0.getKey());
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                    return false;
                }
            }
            case 3: {
                f f1 = (f)this.b;
                try {
                    return super.remove(object0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    for(Object object2: f1.entrySet()) {
                        Map.Entry map$Entry1 = (Map.Entry)object2;
                        if(M7.v(object0, map$Entry1.getValue())) {
                            f1.remove(map$Entry1.getKey());
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                    return false;
                }
            }
            default: {
                return super.remove(object0);
            }
        }
    }

    @Override
    public boolean removeAll(Collection collection0) {
        switch(this.a) {
            case 2: {
                f f0 = (f)this.b;
                try {
                    collection0.getClass();
                    return super.removeAll(collection0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    HashSet hashSet0 = new HashSet();
                    for(Object object0: f0.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object0;
                        if(collection0.contains(map$Entry0.getValue())) {
                            hashSet0.add(map$Entry0.getKey());
                        }
                    }
                    return f0.keySet().removeAll(hashSet0);
                }
            }
            case 3: {
                f f1 = (f)this.b;
                try {
                    collection0.getClass();
                    return super.removeAll(collection0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    HashSet hashSet1 = new HashSet();
                    for(Object object1: f1.entrySet()) {
                        Map.Entry map$Entry1 = (Map.Entry)object1;
                        if(collection0.contains(map$Entry1.getValue())) {
                            hashSet1.add(map$Entry1.getKey());
                        }
                    }
                    return f1.keySet().removeAll(hashSet1);
                }
            }
            default: {
                return super.removeAll(collection0);
            }
        }
    }

    @Override
    public boolean retainAll(Collection collection0) {
        switch(this.a) {
            case 2: {
                f f0 = (f)this.b;
                try {
                    collection0.getClass();
                    return super.retainAll(collection0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    HashSet hashSet0 = new HashSet();
                    for(Object object0: f0.entrySet()) {
                        Map.Entry map$Entry0 = (Map.Entry)object0;
                        if(collection0.contains(map$Entry0.getValue())) {
                            hashSet0.add(map$Entry0.getKey());
                        }
                    }
                    return f0.keySet().retainAll(hashSet0);
                }
            }
            case 3: {
                f f1 = (f)this.b;
                try {
                    collection0.getClass();
                    return super.retainAll(collection0);
                }
                catch(UnsupportedOperationException unused_ex) {
                    HashSet hashSet1 = new HashSet();
                    for(Object object1: f1.entrySet()) {
                        Map.Entry map$Entry1 = (Map.Entry)object1;
                        if(collection0.contains(map$Entry1.getValue())) {
                            hashSet1.add(map$Entry1.getKey());
                        }
                    }
                    return f1.keySet().retainAll(hashSet1);
                }
            }
            default: {
                return super.retainAll(collection0);
            }
        }
    }

    @Override
    public final int size() {
        switch(this.a) {
            case 0: {
                return ((q)this.b).e;
            }
            case 1: {
                return ((B)this.b).size();
            }
            case 2: {
                return ((f)this.b).b.size();
            }
            case 3: {
                return ((f)this.b).b.size();
            }
            case 4: {
                return ((B1)this.b).e;
            }
            default: {
                return ((b5)this.b).h;
            }
        }
    }
}

