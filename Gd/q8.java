package gd;

import kotlin.jvm.internal.q;

public final class q8 extends Z3 {
    public final c8 a;
    public final int b;

    public q8(c8 c80, int v) {
        q.g(c80, "item");
        super();
        this.a = c80;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q8)) {
            return false;
        }
        return q.b(this.a, ((q8)object0).a) ? this.b == ((q8)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickPlaylist(item=" + this.a + ", index=" + this.b + ")";
    }
}

