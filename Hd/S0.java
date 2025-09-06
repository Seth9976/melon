package hd;

import kotlin.jvm.internal.q;

public final class s0 extends J0 {
    public final String a;
    public final String b;

    public s0(String s, String s1) {
        q.g(s, "artistId");
        q.g(s1, "artistName");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s0)) {
            return false;
        }
        return q.b(this.a, ((s0)object0).a) ? q.b(this.b, ((s0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickArtistAlbumMore(artistId=" + this.a + ", artistName=" + this.b + ")";
    }
}

