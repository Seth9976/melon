package va;

import e1.x;
import kotlin.jvm.internal.q;

public final class g0 extends i0 {
    public final x a;

    public g0(x x0) {
        this.a = x0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g0 ? q.b(this.a, ((g0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Failure(melonLoginError=" + this.a + ")";
    }
}

