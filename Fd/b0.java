package Fd;

import kotlin.jvm.internal.q;

public final class b0 extends d0 {
    public final String a;

    public b0(String s) {
        q.g(s, "keyword");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b0 ? q.b(this.a, ((b0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "KeywordChange(keyword=" + this.a + ")";
    }
}

