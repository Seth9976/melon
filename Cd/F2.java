package cd;

import kotlin.jvm.internal.q;

public final class f2 implements h2 {
    public final d2 a;

    public f2(d2 d20) {
        q.g(d20, "tagItemUiState");
        super();
        this.a = d20;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f2 ? q.b(this.a, ((f2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemShown(tagItemUiState=" + this.a + ")";
    }
}

