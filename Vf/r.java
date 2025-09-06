package vf;

import Hf.x;
import kotlin.jvm.internal.q;

public final class r extends t {
    public final x a;

    public r(x x0) {
        this.a = x0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r ? q.b(this.a, ((r)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LocalClass(type=" + this.a + ')';
    }
}

