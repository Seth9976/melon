package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public final class e implements Collection {
    public final f a;

    public e(f f0) {
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
        return this.a.__restricted$indexOfValue(object0) >= 0;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        for(Object object0: collection0) {
            if(!this.contains(object0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new b(this.a, 1);
    }

    @Override
    public final boolean remove(Object object0) {
        f f0 = this.a;
        int v = f0.__restricted$indexOfValue(object0);
        if(v >= 0) {
            f0.removeAt(v);
            return true;
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        f f0 = this.a;
        int v = f0.size();
        boolean z = false;
        for(int v1 = 0; v1 < v; ++v1) {
            if(collection0.contains(f0.valueAt(v1))) {
                f0.removeAt(v1);
                --v1;
                --v;
                z = true;
            }
        }
        return z;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        f f0 = this.a;
        int v = f0.size();
        boolean z = false;
        for(int v1 = 0; v1 < v; ++v1) {
            if(!collection0.contains(f0.valueAt(v1))) {
                f0.removeAt(v1);
                --v1;
                --v;
                z = true;
            }
        }
        return z;
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
            arr_object[v1] = f0.valueAt(v1);
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
            arr_object[v1] = f0.valueAt(v1);
        }
        if(arr_object.length > v) {
            arr_object[v] = null;
        }
        return arr_object;
    }
}

