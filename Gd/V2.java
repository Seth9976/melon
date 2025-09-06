package gd;

import Pc.e;
import kotlin.jvm.internal.q;

public final class v2 implements e {
    public final r2 a;

    public v2(r2 r20) {
        q.g(r20, "item");
        super();
        this.a = r20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v2 ? q.b(this.a, ((v2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickMvItem(item=" + this.a + ")";
    }
}

