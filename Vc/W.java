package Vc;

import kotlin.jvm.internal.q;

public final class w implements y {
    public final z a;

    public w(z z0) {
        q.g(z0, "item");
        super();
        this.a = z0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? q.b(this.a, ((w)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnComponentShown(item=" + this.a + ")";
    }
}

