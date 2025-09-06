package hd;

import Bc.a;
import kotlin.jvm.internal.q;

public final class p0 extends J0 {
    public final a a;
    public final String b;

    public p0(a a0, String s) {
        q.g(s, "ordNum");
        super();
        this.a = a0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p0)) {
            return false;
        }
        return q.b(this.a, ((p0)object0).a) ? q.b(this.b, ((p0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickAlbumLike(item=" + this.a + ", ordNum=" + this.b + ")";
    }
}

