package va;

import kotlin.jvm.internal.q;

public final class l1 implements n1 {
    public final Exception a;

    public l1(Exception exception0) {
        this.a = exception0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l1 ? q.b(this.a, ((l1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NetworkError(exception=" + this.a + ")";
    }
}

