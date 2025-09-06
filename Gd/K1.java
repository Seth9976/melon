package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class k1 extends p0 {
    public final f1 a;

    public k1(f1 f10) {
        q.g(f10, "item");
        super();
        this.a = f10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k1 ? q.b(this.a, ((k1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickItem(item=" + this.a + ")";
    }
}

