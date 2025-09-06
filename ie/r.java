package ie;

import java.io.Serializable;
import kotlin.jvm.internal.q;
import we.a;

public final class r implements j, Serializable {
    public a a;
    public volatile Object b;
    public final Object c;

    public r(a a0) {
        q.g(a0, "initializer");
        super();
        this.a = a0;
        this.b = C.a;
        this.c = this;
    }

    @Override  // ie.j
    public final Object getValue() {
        Object object0 = this.b;
        C c0 = C.a;
        if(object0 != c0) {
            return object0;
        }
        synchronized(this.c) {
            Object object2 = this.b;
            if(object2 == c0) {
                a a0 = this.a;
                q.d(a0);
                object2 = a0.invoke();
                this.b = object2;
                this.a = null;
            }
            return object2;
        }
    }

    @Override
    public final String toString() {
        return this.b == C.a ? "Lazy value not initialized yet." : String.valueOf(this.getValue());
    }

    private final Object writeReplace() {
        return new g(this.getValue());
    }
}

