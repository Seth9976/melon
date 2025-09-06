package Vc;

import kotlin.jvm.internal.q;

public final class c0 implements g0 {
    public final a0 a;

    public c0(a0 a00) {
        q.g(a00, "item");
        super();
        this.a = a00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c0 ? q.b(this.a, ((c0)object0).a) : false;
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

