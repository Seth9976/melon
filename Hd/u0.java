package hd;

import kotlin.jvm.internal.q;

public final class u0 extends J0 {
    public final String a;
    public final String b;

    public u0(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u0)) {
            return false;
        }
        return q.b(this.a, ((u0)object0).a) ? q.b(this.b, ((u0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickArtistArtistThumbnail(artistId=" + this.a + ", artistName=" + this.b + ")";
    }
}

