package je;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;
import xe.a;

public final class x implements Serializable, Map, a {
    public static final x a = null;
    private static final long serialVersionUID = 0x72723771CB044CD2L;

    static {
        x.a = new x();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean containsKey(Object object0) {
        return false;
    }

    @Override
    public final boolean containsValue(Object object0) {
        if(!(object0 instanceof Void)) {
            return false;
        }
        q.g(((Void)object0), "value");
        return false;
    }

    @Override
    public final Set entrySet() {
        return y.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof Map && ((Map)object0).isEmpty();
    }

    @Override
    public final Object get(Object object0) {
        return null;
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
    public final Set keySet() {
        return y.a;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void putAll(Map map0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final Object readResolve() {
        return x.a;
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
    public final int size() {
        return 0;
    }

    @Override
    public final String toString() {
        return "{}";
    }

    @Override
    public final Collection values() {
        return w.a;
    }
}

