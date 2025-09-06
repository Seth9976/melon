package qb;

import kotlin.jvm.internal.q;

public final class o extends u {
    public final String a;

    public o(String s) {
        q.g(s, "artistId");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof o ? q.b(this.a, ((o)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NavigateArtistInfo(artistId=" + this.a + ")";
    }
}

