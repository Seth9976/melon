package v3;

public final class a {
    public final long a;
    public final long b;

    public a(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? this.a == ((a)object0).a && this.b == ((a)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return ((int)this.a) * 0x1F + ((int)this.b);
    }
}

