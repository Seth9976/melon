package ac;

public final class b implements d {
    public final long a;

    public b(long v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? this.a == ((b)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return H0.b.g(this.a, "SetRangeA(position=", ")");
    }
}

