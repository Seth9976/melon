package ie;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import we.a;

public final class q implements j, Serializable {
    public volatile a a;
    public volatile Object b;
    public static final AtomicReferenceFieldUpdater c;

    static {
        q.c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "b");
    }

    @Override  // ie.j
    public final Object getValue() {
        Object object0 = this.b;
        C c0 = C.a;
        if(object0 != c0) {
            return object0;
        }
        a a0 = this.a;
        if(a0 != null) {
            Object object1 = a0.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = q.c;
            while(true) {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, c0, object1)) {
                    this.a = null;
                    return object1;
                }
                if(atomicReferenceFieldUpdater0.get(this) != c0) {
                    break;
                }
            }
        }
        return this.b;
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public final String toString() {
        return this.b == C.a ? "Lazy value not initialized yet." : String.valueOf(this.getValue());
    }

    private final Object writeReplace() {
        return new g(this.getValue());
    }
}

