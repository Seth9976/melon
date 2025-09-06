package androidx.collection;

import N0.l0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.q;
import xe.a;

public final class w implements Map, a {
    public final K a;
    public i b;
    public i c;
    public l0 d;

    public w(K k0) {
        q.g(k0, "parent");
        super();
        this.a = k0;
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object compute(Object object0, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object computeIfAbsent(Object object0, Function function0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object computeIfPresent(Object object0, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.a.c(object0);
    }

    @Override
    public final boolean containsValue(Object object0) {
        return this.a.d(object0);
    }

    @Override
    public final Set entrySet() {
        Set set0 = this.b;
        if(set0 != null) {
            return set0;
        }
        i i0 = new i(this.a, 0);
        this.b = i0;
        return i0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return w.class == class0 ? q.b(this.a, ((w)object0).a) : false;
        }
        return false;
    }

    @Override
    public final Object get(Object object0) {
        return this.a.g(object0);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return this.a.i();
    }

    @Override
    public final Set keySet() {
        Set set0 = this.c;
        if(set0 != null) {
            return set0;
        }
        i i0 = new i(this.a, 1);
        this.c = i0;
        return i0;
    }

    @Override
    public final Object merge(Object object0, Object object1, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void putAll(Map map0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object putIfAbsent(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean remove(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object replace(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean replace(Object object0, Object object1, Object object2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void replaceAll(BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.a.e;
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return "{}";
    }

    @Override
    public final Collection values() {
        Collection collection0 = this.d;
        if(collection0 != null) {
            return collection0;
        }
        l0 l00 = new l0(this.a);
        this.d = l00;
        return l00;
    }
}

