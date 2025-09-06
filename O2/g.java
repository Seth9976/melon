package O2;

import y0.s;

public final class g implements a {
    public final long a;

    public g(long v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g ? s.d(this.a, ((g)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "FixedColorProvider(color=" + s.j(this.a) + ')';
    }
}

