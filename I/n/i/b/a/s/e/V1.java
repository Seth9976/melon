package i.n.i.b.a.s.e;

public final class v1 {
    public final long a;
    public final long b;

    public v1(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v1 ? this.a == ((v1)object0).a && this.b == ((v1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return ((int)this.a) * 0x1F + ((int)this.b);
    }
}

