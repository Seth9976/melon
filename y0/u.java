package y0;

public final class U {
    public final long a;
    public static final long b;
    public static final int c;

    static {
        U.b = 0x3F0000003F000000L;
    }

    public U(long v) {
        this.a = v;
    }

    public static final boolean a(long v, long v1) {
        return v == v1;
    }

    public static final float b(long v) {
        return Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public static final float c(long v) {
        return Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public static String d(long v) {
        return "TransformOrigin(packedValue=" + v + ')';
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof U && this.a == ((U)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return U.d(this.a);
    }
}

