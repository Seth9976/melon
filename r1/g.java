package r1;

public final class g {
    public final long a;

    public g(long v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof g && this.a == ((g)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return this.a == 0x7FC000007FC00000L ? "DpOffset.Unspecified" : "(" + f.b(Float.intBitsToFloat(((int)(this.a >> 0x20)))) + ", " + f.b(Float.intBitsToFloat(((int)(this.a & 0xFFFFFFFFL)))) + ')';
    }
}

