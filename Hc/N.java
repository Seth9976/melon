package hc;

import L8.s;
import kotlin.jvm.internal.q;

public final class n implements o {
    public final s a;

    public n(s s0) {
        q.g(s0, "controller");
        super();
        this.a = s0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n ? q.b(this.a, ((n)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Dlna(controller=" + this.a + ")";
    }
}

