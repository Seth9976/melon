package Ac;

import Pc.e;
import java.util.List;
import kotlin.jvm.internal.q;

public final class z3 implements e {
    public final List a;

    public z3(List list0) {
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof z3 ? q.b(this.a, ((z3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Show(sortList=" + this.a + ")";
    }
}

