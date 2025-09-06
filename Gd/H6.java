package gd;

import kotlin.jvm.internal.q;

public final class h6 extends Z3 {
    public final V5 a;

    public h6(V5 v50) {
        q.g(v50, "item");
        super();
        this.a = v50;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h6 ? q.b(this.a, ((h6)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "PlayDjPlaylist(item=" + this.a + ")";
    }
}

