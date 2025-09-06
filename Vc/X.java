package Vc;

import kotlin.jvm.internal.q;

public final class x implements y {
    public final z a;

    public x(z z0) {
        q.g(z0, "item");
        super();
        this.a = z0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? q.b(this.a, ((x)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemClick(item=" + this.a + ")";
    }
}

