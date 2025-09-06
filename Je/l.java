package je;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class l implements Collection, a {
    public final Object[] a;
    public final boolean b;

    public l(Object[] arr_object, boolean z) {
        q.g(arr_object, "values");
        super();
        this.a = arr_object;
        this.b = z;
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
        return n.Q(this.a, object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        q.g(collection0, "elements");
        if(collection0.isEmpty()) {
            return true;
        }
        for(Object object0: collection0) {
            if(!n.Q(this.a, object0)) {
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
        return this.a.length == 0;
    }

    @Override
    public final Iterator iterator() {
        return q.j(this.a);
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
        Object[] arr_object = this.a;
        q.g(arr_object, "<this>");
        Class class0 = Object[].class;
        if(this.b && arr_object.getClass().equals(class0)) {
            return arr_object;
        }
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length, class0);
        q.f(arr_object1, "copyOf(...)");
        return arr_object1;
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        return p.b(this, arr_object);
    }
}

