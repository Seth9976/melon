package vb;

import kotlin.jvm.internal.q;

public final class p extends s {
    public final Exception a;

    public p(Exception exception0) {
        q.g(exception0, "exception");
        super();
        this.a = exception0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? q.b(this.a, ((p)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Error(exception=" + this.a + ")";
    }
}

