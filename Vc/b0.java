package Vc;

import kotlin.jvm.internal.q;

public final class b0 implements g0 {
    public final a0 a;

    public b0(a0 a00) {
        q.g(a00, "item");
        super();
        this.a = a00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b0 ? q.b(this.a, ((b0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnCardClick(item=" + this.a + ")";
    }
}

