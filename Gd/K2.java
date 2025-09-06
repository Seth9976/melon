package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class k2 extends p0 {
    public final b2 a;

    public k2(b2 b20) {
        q.g(b20, "item");
        super();
        this.a = b20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k2 ? q.b(this.a, ((k2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "PlayCastItem(item=" + this.a + ")";
    }
}

