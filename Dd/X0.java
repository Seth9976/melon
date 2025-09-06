package Dd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class x0 extends p0 {
    public final V1 a;

    public x0(V1 v10) {
        q.g(v10, "uiState");
        super();
        this.a = v10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x0 ? q.b(this.a, ((x0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnFollowingClick(uiState=" + this.a + ")";
    }
}

