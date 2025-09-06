package e1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class o extends j implements List, a {
    public final List f;

    public o(List list0) {
        this.f = list0;
        if(list0.isEmpty()) {
            g1.a.c("At least one font should be passed to FontFamily");
        }
    }

    @Override
    public final void add(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void addFirst(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void addLast(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object0) {
        return object0 instanceof H ? this.f.contains(((H)object0)) : false;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        return this.f.containsAll(collection0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof o ? q.b(this.f, ((o)object0).f) : false;
    }

    @Override
    public final Object get(int v) {
        return (H)this.f.get(v);
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override
    public final int indexOf(Object object0) {
        return object0 instanceof H ? this.f.indexOf(((H)object0)) : -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return this.f.iterator();
    }

    @Override
    public final int lastIndexOf(Object object0) {
        return object0 instanceof H ? this.f.lastIndexOf(((H)object0)) : -1;
    }

    @Override
    public final ListIterator listIterator() {
        return this.f.listIterator();
    }

    @Override
    public final ListIterator listIterator(int v) {
        return this.f.listIterator(v);
    }

    @Override
    public final Object remove(int v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
    public final Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void replaceAll(UnaryOperator unaryOperator0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object set(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.f.size();
    }

    @Override
    public final void sort(Comparator comparator0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final List subList(int v, int v1) {
        return this.f.subList(v, v1);
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
        return "FontListFontFamily(fonts=" + this.f + ')';
    }
}

