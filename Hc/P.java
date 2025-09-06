package hc;

import ac.l;
import kotlin.jvm.internal.q;

public final class p implements s {
    public final l a;

    public p(l l0) {
        this.a = l0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? q.b(this.a, ((p)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Cast(contentsInfo=" + this.a + ")";
    }
}

