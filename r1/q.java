package r1;

public final class q {
    public final long a;

    public q(long v) {
        this.a = v;
    }

    public static long a(long v, float f, float f1, int v1) {
        if((v1 & 1) != 0) {
            f = Float.intBitsToFloat(((int)(v >> 0x20)));
        }
        if((v1 & 2) != 0) {
            f1 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
        }
        return ((long)Float.floatToRawIntBits(f)) << 0x20 | ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL;
    }

    public static final float b(long v) {
        return Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public static final float c(long v) {
        return Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public static final long d(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) - Float.intBitsToFloat(((int)(v1 >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL;
    }

    public static final long e(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 >> 0x20))) + Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof q && this.a == ((q)object0).a;
    }

    public static final long f(long v, float f) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) * f)) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) * f)) & 0xFFFFFFFFL;
    }

    public static String g(long v) {
        return "(" + q.b(v) + ", " + q.c(v) + ") px/sec";
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return q.g(this.a);
    }
}

