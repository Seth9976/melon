package wb;

import kotlin.jvm.internal.q;

public final class b extends f {
    public final Exception a;

    public b(Exception exception0) {
        q.g(exception0, "exception");
        super();
        this.a = exception0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.a, ((b)object0).a) : false;
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

