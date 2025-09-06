package gd;

import kotlin.jvm.internal.q;

public final class l7 extends Z3 {
    public final V6 a;

    public l7(V6 v60) {
        q.g(v60, "item");
        super();
        this.a = v60;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l7 ? q.b(this.a, ((l7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickPlayButton(item=" + this.a + ")";
    }
}

