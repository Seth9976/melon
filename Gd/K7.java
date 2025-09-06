package gd;

import kotlin.jvm.internal.q;

public final class k7 extends Z3 {
    public final V6 a;

    public k7(V6 v60) {
        q.g(v60, "item");
        super();
        this.a = v60;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k7 ? q.b(this.a, ((k7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickDjPlaylistItem(item=" + this.a + ")";
    }
}

