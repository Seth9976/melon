package gd;

import kotlin.jvm.internal.q;

public final class q7 extends Z3 {
    public final String a;

    public q7(String s) {
        q.g(s, "keyword");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q7 ? q.b(this.a, ((q7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "RequestAutoCompleteTag(keyword=" + this.a + ")";
    }
}

