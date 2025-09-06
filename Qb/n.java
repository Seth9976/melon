package qb;

import kotlin.jvm.internal.q;

public final class n extends u {
    public final String a;

    public n(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n ? q.b(this.a, ((n)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NavigateAlbumInfo(albumId=" + this.a + ")";
    }
}

