package Jc;

import Ad.C;
import kotlin.jvm.internal.q;

public final class y extends C {
    public final String a;
    public final String b;

    public y(String s, String s1) {
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
        if(!(object0 instanceof y)) {
            return false;
        }
        return q.b(this.a, ((y)object0).a) ? q.b(this.b, ((y)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlayAlbumOther(albumId=" + this.a + ", menuId=" + this.b + ")";
    }
}

