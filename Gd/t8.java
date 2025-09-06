package gd;

import kotlin.jvm.internal.q;

public final class t8 extends Z3 {
    public final e8 a;
    public final int b;

    public t8(e8 e80, int v) {
        q.g(e80, "item");
        super();
        this.a = e80;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t8)) {
            return false;
        }
        return q.b(this.a, ((t8)object0).a) ? this.b == ((t8)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickTagThumbnail(item=" + this.a + ", index=" + this.b + ")";
    }
}

