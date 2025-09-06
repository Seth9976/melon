package gd;

import kotlin.jvm.internal.q;

public final class e6 extends Z3 {
    public final String a;

    public e6(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e6 ? q.b(this.a, ((e6)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickTag(tagSeq=" + this.a + ")";
    }
}

