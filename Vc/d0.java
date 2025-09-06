package Vc;

import kotlin.jvm.internal.q;

public final class d0 implements g0 {
    public final a0 a;

    public d0(a0 a00) {
        q.g(a00, "item");
        super();
        this.a = a00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d0 ? q.b(this.a, ((d0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnMixUpButtonClick(item=" + this.a + ")";
    }
}

