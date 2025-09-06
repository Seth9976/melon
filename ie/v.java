package ie;

import c2.Y;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class v implements Collection, a {
    public final byte[] a;

    public v(byte[] arr_b) {
        this.a = arr_b;
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
        if(!(object0 instanceof u)) {
            return false;
        }
        int v = ((u)object0).a;
        byte[] arr_b = this.a;
        q.g(arr_b, "<this>");
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= arr_b.length) {
                v1 = -1;
                break;
            }
            if(v == arr_b[v1]) {
                break;
            }
        }
        return v1 >= 0;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        q.g(collection0, "elements");
        if(!collection0.isEmpty()) {
            for(Object object0: collection0) {
                if(object0 instanceof u) {
                    int v = ((u)object0).a;
                    byte[] arr_b = this.a;
                    q.g(arr_b, "<this>");
                    int v1 = 0;
                    while(true) {
                        if(v1 < arr_b.length) {
                            if(v == arr_b[v1]) {
                                break;
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }
                        v1 = -1;
                        break;
                    }
                    if(v1 >= 0) {
                        continue;
                    }
                }
                return false;
            }
        }
        return true;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof v && q.b(this.a, ((v)object0).a);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override
    public final boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override
    public final Iterator iterator() {
        return new Y(this.a);
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
        return this.a.length;
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        return p.b(this, arr_object);
    }

    @Override
    public final String toString() {
        return "UByteArray(storage=" + Arrays.toString(this.a) + ')';
    }
}

