package ke;

import P0.r;
import e1.u;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import je.c;
import je.f;
import je.h;
import je.n;
import kotlin.jvm.internal.q;

public final class b extends h implements Serializable, RandomAccess {
    public Object[] a;
    public int b;
    public boolean c;
    public static final b d;

    static {
        b b0 = new b(0);
        b0.c = true;
        b.d = b0;
    }

    public b(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.a = new Object[v];
    }

    @Override
    public final void add(int v, Object object0) {
        this.k();
        int v1 = this.b;
        f.Companion.getClass();
        c.c(v, v1);
        ++this.modCount;
        this.l(v, 1);
        this.a[v] = object0;
    }

    @Override
    public final boolean add(Object object0) {
        this.k();
        int v = this.b;
        ++this.modCount;
        this.l(v, 1);
        this.a[v] = object0;
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        q.g(collection0, "elements");
        this.k();
        int v1 = this.b;
        f.Companion.getClass();
        c.c(v, v1);
        int v2 = collection0.size();
        this.g(v, collection0, v2);
        return v2 > 0;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        this.k();
        int v = collection0.size();
        this.g(this.b, collection0, v);
        return v > 0;
    }

    @Override  // je.h
    public final int b() {
        return this.b;
    }

    @Override
    public final void clear() {
        this.k();
        this.p(0, this.b);
    }

    @Override  // je.h
    public final Object d(int v) {
        this.k();
        int v1 = this.b;
        f.Companion.getClass();
        c.b(v, v1);
        return this.o(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof List) {
                Object[] arr_object = this.a;
                int v = this.b;
                if(v == ((List)object0).size()) {
                    for(int v1 = 0; v1 < v; ++v1) {
                        if(!q.b(arr_object[v1], ((List)object0).get(v1))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void g(int v, Collection collection0, int v1) {
        ++this.modCount;
        this.l(v, v1);
        Iterator iterator0 = collection0.iterator();
        for(int v2 = 0; v2 < v1; ++v2) {
            Object[] arr_object = this.a;
            Object object0 = iterator0.next();
            arr_object[v + v2] = object0;
        }
    }

    @Override
    public final Object get(int v) {
        int v1 = this.b;
        f.Companion.getClass();
        c.b(v, v1);
        return this.a[v];
    }

    @Override
    public final int hashCode() {
        Object[] arr_object = this.a;
        int v = this.b;
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            Object object0 = arr_object[v2];
            v1 = v1 * 0x1F + (object0 == null ? 0 : object0.hashCode());
        }
        return v1;
    }

    public final void i(int v, Object object0) {
        ++this.modCount;
        this.l(v, 1);
        this.a[v] = object0;
    }

    @Override
    public final int indexOf(Object object0) {
        for(int v = 0; v < this.b; ++v) {
            if(q.b(this.a[v], object0)) {
                return v;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.b == 0;
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator(0);
    }

    public final void k() {
        if(this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public final void l(int v, int v1) {
        int v2 = this.b + v1;
        if(v2 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] arr_object = this.a;
        if(v2 > arr_object.length) {
            f.Companion.getClass();
            Object[] arr_object1 = this.a;
            q.g(arr_object1, "<this>");
            Object[] arr_object2 = Arrays.copyOf(arr_object1, c.e(arr_object.length, v2));
            q.f(arr_object2, "copyOf(...)");
            this.a = arr_object2;
        }
        n.W(this.a, v + v1, this.a, v, this.b);
        this.b += v1;
    }

    @Override
    public final int lastIndexOf(Object object0) {
        for(int v = this.b - 1; v >= 0; --v) {
            if(q.b(this.a[v], object0)) {
                return v;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        int v1 = this.b;
        f.Companion.getClass();
        c.c(v, v1);
        return new r(this, v);
    }

    public final Object o(int v) {
        ++this.modCount;
        Object[] arr_object = this.a;
        Object object0 = arr_object[v];
        n.W(arr_object, v, arr_object, v + 1, this.b);
        Object[] arr_object1 = this.a;
        int v1 = this.b - 1;
        q.g(arr_object1, "<this>");
        arr_object1[v1] = null;
        --this.b;
        return object0;
    }

    public final void p(int v, int v1) {
        if(v1 > 0) {
            ++this.modCount;
        }
        n.W(this.a, v, this.a, v + v1, this.b);
        u.R(this.a, this.b - v1, this.b);
        this.b -= v1;
    }

    public final int q(int v, int v1, Collection collection0, boolean z) {
        int v2 = 0;
        int v3 = 0;
        while(v2 < v1) {
            int v4 = v + v2;
            if(collection0.contains(this.a[v4]) == z) {
                ++v2;
                this.a[v3 + v] = this.a[v4];
                ++v3;
            }
            else {
                ++v2;
            }
        }
        int v5 = v1 - v3;
        n.W(this.a, v + v3, this.a, v1 + v, this.b);
        u.R(this.a, this.b - v5, this.b);
        if(v5 > 0) {
            ++this.modCount;
        }
        this.b -= v5;
        return v5;
    }

    @Override
    public final boolean remove(Object object0) {
        this.k();
        int v = this.indexOf(object0);
        if(v >= 0) {
            this.d(v);
        }
        return v >= 0;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        q.g(collection0, "elements");
        this.k();
        return this.q(0, this.b, collection0, false) > 0;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        q.g(collection0, "elements");
        this.k();
        return this.q(0, this.b, collection0, true) > 0;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.k();
        int v1 = this.b;
        f.Companion.getClass();
        c.b(v, v1);
        Object[] arr_object = this.a;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        return object1;
    }

    @Override
    public final List subList(int v, int v1) {
        int v2 = this.b;
        f.Companion.getClass();
        c.d(v, v1, v2);
        return new a(this.a, v, v1 - v, null, this);
    }

    @Override
    public final Object[] toArray() {
        return n.a0(this.a, 0, this.b);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        int v = this.b;
        if(arr_object.length < v) {
            Object[] arr_object1 = Arrays.copyOfRange(this.a, 0, v, arr_object.getClass());
            q.f(arr_object1, "copyOfRange(...)");
            return arr_object1;
        }
        n.W(this.a, 0, arr_object, 0, v);
        int v1 = this.b;
        if(v1 < arr_object.length) {
            arr_object[v1] = null;
        }
        return arr_object;
    }

    @Override
    public final String toString() {
        return u.m(this.a, 0, this.b, this);
    }

    private final Object writeReplace() {
        if(!this.c) {
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }
        return new g(this, 0);
    }
}

