package Dd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class v0 extends p0 {
    public final String a;

    public v0(String s) {
        q.g(s, "artistId");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v0 ? q.b(this.a, ((v0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnArtistChannelClick(artistId=" + this.a + ")";
    }
}

