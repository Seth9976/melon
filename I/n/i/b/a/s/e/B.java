package i.n.i.b.a.s.e;

public final class b {
    public final long a;

    public b(long v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof b) {
            ((b)object0).getClass();
            return this.a == ((b)object0).a;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((int)(this.a ^ this.a >>> 0x20)) * 0x745F;
    }
}

