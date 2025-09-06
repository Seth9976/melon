package cd;

import kotlin.jvm.internal.q;

public final class d1 implements e1 {
    public final b1 a;

    public d1(b1 b10) {
        q.g(b10, "uiState");
        super();
        this.a = b10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d1 ? q.b(this.a, ((d1)object0).a) : false;
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

