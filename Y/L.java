package Y;

import A7.d;
import l1.j;

public final class l {
    public final j a;
    public final int b;
    public final long c;

    public l(j j0, int v, long v1) {
        this.a = j0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        if(this.a != ((l)object0).a) {
            return false;
        }
        return this.b == ((l)object0).b ? this.c == ((l)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.c) + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "AnchorInfo(direction=" + this.a + ", offset=" + this.b + ", selectableId=" + this.c + ')';
    }
}

