package Vc;

import kotlin.jvm.internal.q;

public final class k0 implements l0 {
    public final h0 a;

    public k0(h0 h00) {
        this.a = h00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k0 ? q.b(this.a, ((k0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnPlayButtonClick(item=" + this.a + ")";
    }
}

