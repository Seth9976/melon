package gd;

import kotlin.jvm.internal.q;

public final class v8 extends Z3 {
    public final c8 a;
    public final int b;

    public v8(c8 c80, int v) {
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
        if(!(object0 instanceof v8)) {
            return false;
        }
        return q.b(this.a, ((v8)object0).a) ? this.b == ((v8)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlayPlaylist(item=" + this.a + ", index=" + this.b + ")";
    }
}

