package gd;

import kotlin.jvm.internal.q;

public final class p7 extends Z3 {
    public final String a;

    public p7(String s) {
        q.g(s, "text");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p7 ? q.b(this.a, ((p7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnTagInputTextChange(text=" + this.a + ")";
    }
}

