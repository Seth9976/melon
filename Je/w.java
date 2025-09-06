package je;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class w implements Serializable, List, RandomAccess, a {
    public static final w a = null;
    private static final long serialVersionUID = 0x996FC7D0A7E06032L;

    static {
        w.a = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
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
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object0) {
        if(!(object0 instanceof Void)) {
            return false;
        }
        q.g(((Void)object0), "element");
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        q.g(collection0, "elements");
        return collection0.isEmpty();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof List && ((List)object0).isEmpty();
    }

    @Override
    public final Object get(int v) {
        throw new IndexOutOfBoundsException("Empty list doesn\'t contain element at index " + v + '.');
    }

    @Override
    public final int hashCode() {
        return 1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Void)) {
            return -1;
        }
        q.g(((Void)object0), "element");
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Iterator iterator() {
        return v.a;
    }

    @Override
    public final int lastIndexOf(Object object0) {
        if(!(object0 instanceof Void)) {
            return -1;
        }
        q.g(((Void)object0), "element");
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return v.a;
    }

    @Override
    public final ListIterator listIterator(int v) {
        if(v != 0) {
            throw new IndexOutOfBoundsException("Index: " + v);
        }
        return v.a;
    }

    private final Object readResolve() {
        return w.a;
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
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object set(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public final List subList(int v, int v1) {
        if(v != 0 || v1 != 0) {
            throw new IndexOutOfBoundsException("fromIndex: " + v + ", toIndex: " + v1);
        }
        return this;
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
        return "[]";
    }
}

