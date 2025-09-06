package gd;

import kotlin.jvm.internal.q;

public final class s7 extends Z3 {
    public final String a;

    public s7(String s) {
        q.g(s, "tagName");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s7 ? q.b(this.a, ((s7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "UnselectTagItem(tagName=" + this.a + ")";
    }
}

