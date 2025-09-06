package r1;

public final class p {
    public final long a;

    public p(long v) {
        this.a = v;
    }

    public static final boolean a(long v, long v1) {
        return v == v1;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof p && this.a == ((p)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        long v = this.a;
        if(p.a(v, 0L)) {
            return "Unspecified";
        }
        if(p.a(v, 0x100000000L)) {
            return "Sp";
        }
        return p.a(v, 0x200000000L) ? "Em" : "Invalid";
    }
}

