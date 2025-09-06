package ic;

import kotlin.jvm.internal.q;
import l4.O;

public final class b extends e {
    public final O a;

    public b(O o0) {
        this.a = o0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.a, ((b)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Cast(routeInfo=" + this.a + ")";
    }
}

