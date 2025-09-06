package oc;

import kotlin.jvm.internal.q;

public final class u implements v {
    public final Q a;

    public u(Q q0) {
        q.g(q0, "playlistState");
        super();
        this.a = q0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u ? q.b(this.a, ((u)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(playlistState=" + this.a + ")";
    }
}

