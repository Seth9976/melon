package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c implements Set {
    public final f a;

    public c(f f0) {
        this.a = f0;
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        return this.a.containsKey(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        return this.a.containsAll(collection0);
    }

    @Override
    public final boolean equals(Object object0) {
        return f.equalsSetHelper(this, object0);
    }

    @Override
    public final int hashCode() {
        f f0 = this.a;
        int v = f0.size() - 1;
        int v1 = 0;
        while(v >= 0) {
            Object object0 = f0.keyAt(v);
            v1 += (object0 == null ? 0 : object0.hashCode());
            --v;
        }
        return v1;
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new b(this.a, 0);
    }

    @Override
    public final boolean remove(Object object0) {
        f f0 = this.a;
        int v = f0.indexOfKey(object0);
        if(v >= 0) {
            f0.removeAt(v);
            return true;
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        return this.a.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        return this.a.retainAll(collection0);
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    public final Object[] toArray() {
        f f0 = this.a;
        int v = f0.size();
        Object[] arr_object = new Object[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_object[v1] = f0.keyAt(v1);
        }
        return arr_object;
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        f f0 = this.a;
        int v = f0.size();
        if(arr_object.length < v) {
            arr_object = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v);
        }
        for(int v1 = 0; v1 < v; ++v1) {
            arr_object[v1] = f0.keyAt(v1);
        }
        if(arr_object.length > v) {
            arr_object[v] = null;
        }
        return arr_object;
    }
}

