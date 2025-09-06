package Jc;

import Ad.C;
import kotlin.jvm.internal.q;

public final class z extends C {
    public final String a;
    public final String b;

    public z(String s, String s1) {
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z)) {
            return false;
        }
        return q.b(this.a, ((z)object0).a) ? q.b(this.b, ((z)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlayAlbumSeries(albumId=" + this.a + ", menuId=" + this.b + ")";
    }
}

