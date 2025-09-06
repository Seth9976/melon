package ed;

import java.util.List;
import kotlin.jvm.internal.q;

public final class t0 extends u0 {
    public final List a;

    public t0(List list0) {
        q.g(list0, "list");
        super();
        this.a = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t0 ? q.b(this.a, ((t0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(list=" + this.a + ")";
    }
}

