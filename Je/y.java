package je;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class y implements Serializable, Set, a {
    public static final y a = null;
    private static final long serialVersionUID = 0x2F46B01576D7E2F4L;

    static {
        y.a = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
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
        return object0 instanceof Set && ((Set)object0).isEmpty();
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Iterator iterator() {
        return v.a;
    }

    private final Object readResolve() {
        return y.a;
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
        return 0;
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

