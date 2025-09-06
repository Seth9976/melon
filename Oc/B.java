package oc;

import kotlin.jvm.internal.q;
import nc.C0;

public final class b {
    public final Q a;

    public b(C0 c00) {
        q.g(c00, "playlistState");
        super();
        this.a = c00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.a, ((b)object0).a) : false;
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

