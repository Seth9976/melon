package ke;

import P0.r;
import e1.u;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import je.c;
import je.f;
import je.h;
import je.n;
import kotlin.jvm.internal.q;

public final class a extends h implements Serializable, RandomAccess {
    public Object[] a;
    public final int b;
    public int c;
    public final a d;
    public final b e;

    public a(Object[] arr_object, int v, int v1, a a0, b b0) {
        q.g(arr_object, "backing");
        q.g(b0, "root");
        super();
        this.a = arr_object;
        this.b = v;
        this.c = v1;
        this.d = a0;
        this.e = b0;
        this.modCount = b0.modCount;
    }

    @Override
    public final void add(int v, Object object0) {
        this.l();
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.c(v, v1);
        this.i(this.b + v, object0);
    }

    @Override
    public final boolean add(Object object0) {
        this.l();
        this.k();
        this.i(this.b + this.c, object0);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        q.g(collection0, "elements");
        this.l();
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.c(v, v1);
        int v2 = collection0.size();
        this.g(this.b + v, collection0, v2);
        return v2 > 0;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        this.l();
        this.k();
        int v = collection0.size();
        this.g(this.b + this.c, collection0, v);
        return v > 0;
    }

    @Override  // je.h
    public final int b() {
        this.k();
        return this.c;
    }

    @Override
    public final void clear() {
        this.l();
        this.k();
        this.p(this.b, this.c);
    }

    @Override  // je.h
    public final Object d(int v) {
        this.l();
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        return this.o(this.b + v);
    }

    @Override
    public final boolean equals(Object object0) {
        this.k();
        if(object0 != this) {
            if(object0 instanceof List) {
                Object[] arr_object = this.a;
                int v = this.c;
                if(v == ((List)object0).size()) {
                    for(int v1 = 0; v1 < v; ++v1) {
                        if(!q.b(arr_object[this.b + v1], ((List)object0).get(v1))) {
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
        b b0 = this.e;
        a a0 = this.d;
        if(a0 == null) {
            b0.g(v, collection0, v1);
        }
        else {
            a0.g(v, collection0, v1);
        }
        this.a = b0.a;
        this.c += v1;
    }

    @Override
    public final Object get(int v) {
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        return this.a[this.b + v];
    }

    @Override
    public final int hashCode() {
        this.k();
        Object[] arr_object = this.a;
        int v = this.c;
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            Object object0 = arr_object[this.b + v2];
            v1 = v1 * 0x1F + (object0 == null ? 0 : object0.hashCode());
        }
        return v1;
    }

    public final void i(int v, Object object0) {
        ++this.modCount;
        b b0 = this.e;
        a a0 = this.d;
        if(a0 == null) {
            b0.i(v, object0);
        }
        else {
            a0.i(v, object0);
        }
        this.a = b0.a;
        ++this.c;
    }

    @Override
    public final int indexOf(Object object0) {
        this.k();
        for(int v = 0; v < this.c; ++v) {
            if(q.b(this.a[this.b + v], object0)) {
                return v;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        this.k();
        return this.c == 0;
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator(0);
    }

    public final void k() {
        if(this.e.modCount != this.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void l() {
        if(this.e.c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final int lastIndexOf(Object object0) {
        this.k();
        for(int v = this.c - 1; v >= 0; --v) {
            if(q.b(this.a[this.b + v], object0)) {
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
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.c(v, v1);
        return new r(this, v);
    }

    public final Object o(int v) {
        ++this.modCount;
        Object object0 = this.d == null ? this.e.o(v) : this.d.o(v);
        --this.c;
        return object0;
    }

    public final void p(int v, int v1) {
        if(v1 > 0) {
            ++this.modCount;
        }
        a a0 = this.d;
        if(a0 == null) {
            this.e.p(v, v1);
        }
        else {
            a0.p(v, v1);
        }
        this.c -= v1;
    }

    public final int q(int v, int v1, Collection collection0, boolean z) {
        int v2 = this.d == null ? this.e.q(v, v1, collection0, z) : this.d.q(v, v1, collection0, z);
        if(v2 > 0) {
            ++this.modCount;
        }
        this.c -= v2;
        return v2;
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public final boolean remove(Object object0) {
        this.l();
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
        this.l();
        this.k();
        return this.q(this.b, this.c, collection0, false) > 0;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        q.g(collection0, "elements");
        this.l();
        this.k();
        return this.q(this.b, this.c, collection0, true) > 0;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.l();
        this.k();
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        Object[] arr_object = this.a;
        int v2 = this.b + v;
        Object object1 = arr_object[v2];
        arr_object[v2] = object0;
        return object1;
    }

    @Override
    public final List subList(int v, int v1) {
        int v2 = this.c;
        f.Companion.getClass();
        c.d(v, v1, v2);
        return new a(this.a, this.b + v, v1 - v, this, this.e);
    }

    @Override
    public final Object[] toArray() {
        this.k();
        return n.a0(this.a, this.b, this.c + this.b);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        this.k();
        int v = this.c;
        int v1 = this.b;
        if(arr_object.length < v) {
            Object[] arr_object1 = Arrays.copyOfRange(this.a, v1, v + v1, arr_object.getClass());
            q.f(arr_object1, "copyOfRange(...)");
            return arr_object1;
        }
        n.W(this.a, 0, arr_object, v1, v + v1);
        int v2 = this.c;
        if(v2 < arr_object.length) {
            arr_object[v2] = null;
        }
        return arr_object;
    }

    @Override
    public final String toString() {
        this.k();
        return u.m(this.a, this.b, this.c, this);
    }

    private final Object writeReplace() {
        if(!this.e.c) {
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }
        return new g(this, 0);
    }
}

