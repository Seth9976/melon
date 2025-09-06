package i.n.i.b.a.s.e;

public final class i6 {
    public final long a;
    public final long b;

    public i6(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return i6.class == class0 && this.a == ((i6)object0).a && this.b == ((i6)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((int)this.a) * 0x1F + ((int)this.b);
    }
}

