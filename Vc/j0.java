package Vc;

import kotlin.jvm.internal.q;

public final class j0 implements l0 {
    public final h0 a;

    public j0(h0 h00) {
        this.a = h00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j0 ? q.b(this.a, ((j0)object0).a) : false;
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

