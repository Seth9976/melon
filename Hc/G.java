package hc;

import kotlin.jvm.internal.q;

public final class g implements h {
    public final String a;

    public g(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? q.b(this.a, ((g)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Disconnected(reason=" + this.a + ")";
    }
}

