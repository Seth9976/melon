package gd;

import kotlin.jvm.internal.q;

public final class o8 extends Z3 {
    public final a8 a;
    public final int b;

    public o8(a8 a80, int v) {
        q.g(a80, "item");
        super();
        this.a = a80;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o8)) {
            return false;
        }
        return q.b(this.a, ((o8)object0).a) ? this.b == ((o8)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickLikeTag(item=" + this.a + ", index=" + this.b + ")";
    }
}

