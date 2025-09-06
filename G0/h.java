package g0;

import De.I;
import androidx.collection.L;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;
import xe.a;

public final class h implements Set, a {
    public final L a;

    public h(L l0) {
        this.a = l0;
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
        return this.a.c(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        if(collection0 instanceof Collection && collection0.isEmpty()) {
            return true;
        }
        for(Object object0: collection0) {
            if(!this.a.c(object0)) {
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
        return this.a.g();
    }

    @Override
    public final Iterator iterator() {
        return I.P(new g(this, null));
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
        return this.a.d;
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

