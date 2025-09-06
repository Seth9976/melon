package cd;

import kotlin.jvm.internal.q;

public final class r0 implements t0 {
    public final q0 a;

    public r0(q0 q00) {
        q.g(q00, "uiState");
        super();
        this.a = q00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r0 ? q.b(this.a, ((r0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemClick(uiState=" + this.a + ")";
    }
}

