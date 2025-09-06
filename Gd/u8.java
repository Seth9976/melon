package gd;

import kotlin.jvm.internal.q;

public final class u8 extends Z3 {
    public final h8 a;
    public final int b;

    public u8(h8 h80, int v) {
        q.g(h80, "item");
        super();
        this.a = h80;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u8)) {
            return false;
        }
        return q.b(this.a, ((u8)object0).a) ? this.b == ((u8)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickTodayTagItem(item=" + this.a + ", index=" + this.b + ")";
    }
}

