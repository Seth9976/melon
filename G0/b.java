package g0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.c;

public final class b implements List, c {
    public final e a;

    public b(e e0) {
        this.a = e0;
    }

    @Override
    public final void add(int v, Object object0) {
        this.a.a(v, object0);
    }

    @Override
    public final boolean add(Object object0) {
        this.a.b(object0);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        return this.a.e(v, collection0);
    }

    @Override
    public final boolean addAll(Collection collection0) {
        return this.a.e(this.a.c, collection0);
    }

    @Override
    public final void clear() {
        this.a.g();
    }

    @Override
    public final boolean contains(Object object0) {
        return this.a.h(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        e e0 = this.a;
        e0.getClass();
        for(Object object0: collection0) {
            if(!e0.h(object0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        f.a(v, this);
        return this.a.a[v];
    }

    @Override
    public final int indexOf(Object object0) {
        return this.a.i(object0);
    }

    @Override
    public final boolean isEmpty() {
        return this.a.c == 0;
    }

    @Override
    public final Iterator iterator() {
        return new d(this, 0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
        int v = this.a.c - 1;
        Object[] arr_object = this.a.a;
        while(v >= 0) {
            if(q.b(object0, arr_object[v])) {
                return v;
            }
            --v;
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return new d(this, 0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new d(this, v);
    }

    @Override
    public final Object remove(int v) {
        f.a(v, this);
        return this.a.k(v);
    }

    @Override
    public final boolean remove(Object object0) {
        return this.a.j(object0);
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        e e0 = this.a;
        e0.getClass();
        if(!collection0.isEmpty()) {
            int v = e0.c;
            for(Object object0: collection0) {
                e0.j(object0);
            }
            return v != e0.c;
        }
        return false;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        e e0 = this.a;
        int v = e0.c;
        for(int v1 = v - 1; -1 < v1; --v1) {
            if(!collection0.contains(e0.a[v1])) {
                e0.k(v1);
            }
        }
        return v != e0.c;
    }

    @Override
    public final Object set(int v, Object object0) {
        f.a(v, this);
        Object[] arr_object = this.a.a;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        return object1;
    }

    @Override
    public final int size() {
        return this.a.c;
    }

    @Override
    public final List subList(int v, int v1) {
        f.b(v, v1, this);
        return new g0.c(this, v, v1);
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return p.b(this, arr_object);
    }
}

