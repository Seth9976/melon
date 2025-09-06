package td;

import kotlin.jvm.internal.q;
import pc.z0;

public final class h0 extends j0 {
    public final z0 a;

    public h0(z0 z00) {
        q.g(z00, "playlistState");
        super();
        this.a = z00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h0 ? q.b(this.a, ((h0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "InvalidMixUpPlaylistState(playlistState=" + this.a + ")";
    }
}

