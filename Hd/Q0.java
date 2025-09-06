package hd;

import Bc.a;
import kotlin.jvm.internal.q;

public final class q0 extends J0 {
    public final a a;
    public final String b;

    public q0(a a0, String s) {
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
        if(!(object0 instanceof q0)) {
            return false;
        }
        return q.b(this.a, ((q0)object0).a) ? q.b(this.b, ((q0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickAlbumLikePlayButton(item=" + this.a + ", ordNum=" + this.b + ")";
    }
}

