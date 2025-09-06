package gd;

import kotlin.jvm.internal.q;

public final class b7 extends d7 {
    public final String a;

    public b7(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b7 ? q.b(this.a, ((b7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "RecommendTitleItem(title=" + this.a + ")";
    }
}

