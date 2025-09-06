package h1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import je.w;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class b implements Collection, a {
    public final List a;
    public final int b;
    public static final b c;

    static {
        b.c = new b(w.a);
    }

    public b(List list0) {
        this.a = list0;
        this.b = list0.size();
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
        return object0 instanceof h1.a ? this.a.contains(((h1.a)object0)) : false;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        return this.a.containsAll(collection0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.a, ((b)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return this.a.iterator();
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
    public final boolean removeIf(Predicate predicate0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.b;
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return p.b(this, arr_object);
    }

    @Override
    public final String toString() {
        return "LocaleList(localeList=" + this.a + ')';
    }
}

