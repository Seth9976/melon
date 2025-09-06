package ic;

import M8.a;
import kotlin.jvm.internal.q;

public final class c extends e {
    public final a a;

    public c(a a0) {
        q.g(a0, "renderer");
        super();
        this.a = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Dlna(renderer=" + this.a + ")";
    }
}

