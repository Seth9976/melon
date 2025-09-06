package rd;

import kotlin.jvm.internal.q;
import oc.Q;

public final class u0 extends v0 {
    public final Q a;

    public u0(Q q0) {
        q.g(q0, "playlistState");
        super();
        this.a = q0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u0 ? q.b(this.a, ((u0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "InvalidPlaylistState(playlistState=" + this.a + ")";
    }
}

