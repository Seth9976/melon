package je;

import Tf.k;
import hd.i;
import j0.b;
import j0.h;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;
import xe.a;

public abstract class g implements Map, a {
    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean containsValue(Object object0) {
        Set set0 = this.entrySet();
        if(set0.isEmpty()) {
            return false;
        }
        for(Object object1: set0) {
            if(q.b(((Map.Entry)object1).getValue(), object0)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override
    public final Set entrySet() {
        return new h(((b)this), 0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof Map)) {
            return false;
        }
        if(((b)this).b != ((Map)object0).size()) {
            return false;
        }
        Iterable iterable0 = ((Map)object0).entrySet();
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return true;
        }
        for(Object object1: iterable0) {
            if(((Map.Entry)object1) != null) {
                Object object2 = ((Map.Entry)object1).getKey();
                Object object3 = ((Map.Entry)object1).getValue();
                Object object4 = this.get(object2);
                if(!q.b(object3, object4) || object4 == null && !this.containsKey(object2)) {
                    return false;
                }
                continue;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.entrySet().hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return ((b)this).b == 0;
    }

    @Override
    public final Set keySet() {
        return new h(((b)this), 1);
    }

    @Override
    public final Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void putAll(Map map0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return ((b)this).b;
    }

    @Override
    public final String toString() {
        return p.q0(this.entrySet(), ", ", "{", "}", new i(this, 12), 24);
    }

    @Override
    public final Collection values() {
        return new k(((b)this), 1);
    }
}

