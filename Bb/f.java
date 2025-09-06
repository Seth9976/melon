package bb;

import kotlin.jvm.internal.q;

public final class f extends o {
    public final Exception a;

    public f(Exception exception0) {
        this.a = exception0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
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

