package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class j2 extends p0 {
    public final c2 a;

    public j2(c2 c20) {
        q.g(c20, "item");
        super();
        this.a = c20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j2 ? q.b(this.a, ((j2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickProgramShowAll(item=" + this.a + ")";
    }
}

