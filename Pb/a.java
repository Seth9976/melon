package pb;

import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final String b;

    public a(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        return q.b(this.a, ((a)object0).a) ? q.b(this.b, ((a)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ArtistInfo(artistId=" + this.a + ", artistName=" + this.b + ")";
    }
}

