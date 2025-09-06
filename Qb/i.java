package qb;

import kotlin.jvm.internal.q;

public final class i extends u {
    public final Exception a;

    public i(Exception exception0) {
        q.g(exception0, "exception");
        super();
        this.a = exception0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ArtistInfoError(exception=" + this.a + ")";
    }
}

