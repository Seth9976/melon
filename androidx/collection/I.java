package androidx.collection;

import De.I;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.q;
import xe.a;

public final class i implements Set, a {
    public final int a;
    public final K b;

    public i(K k0, int v) {
        this.a = v;
        if(v != 1) {
            q.g(k0, "parent");
            super();
            this.b = k0;
            return;
        }
        q.g(k0, "parent");
        super();
        this.b = k0;
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            return this.b.c(object0);
        }
        if(!(object0 instanceof Map.Entry)) {
            return false;
        }
        q.g(((Map.Entry)object0), "element");
        Object object1 = ((Map.Entry)object0).getKey();
        return q.b(this.b.g(object1), ((Map.Entry)object0).getValue());
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        if(this.a != 0) {
            q.g(collection0, "elements");
            if(!collection0.isEmpty()) {
                for(Object object0: collection0) {
                    if(!this.b.c(object0)) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return true;
        }
        q.g(collection0, "elements");
        if(!collection0.isEmpty()) {
            for(Object object1: collection0) {
                Object object2 = ((Map.Entry)object1).getKey();
                if(!q.b(this.b.g(object2), ((Map.Entry)object1).getValue())) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return this.b.i();
    }

    @Override
    public final Iterator iterator() {
        return this.a == 0 ? I.P(new h(this, null)) : I.P(new p(this, null));
    }

    @Override
    public final boolean remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.b.e;
    }

    @Override
    public final Object[] toArray() {
        return kotlin.jvm.internal.p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        if(this.a != 0) {
            q.g(arr_object, "array");
            return kotlin.jvm.internal.p.b(this, arr_object);
        }
        q.g(arr_object, "array");
        return kotlin.jvm.internal.p.b(this, arr_object);
    }
}

