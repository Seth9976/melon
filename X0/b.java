package x0;

import df.d;

public final class b {
    public final long a;

    public b(long v) {
        this.a = v;
    }

    public static long a(int v, long v1, float f) {
        float f1 = (v & 1) == 0 ? 0.0f : Float.intBitsToFloat(((int)(v1 >> 0x20)));
        if((v & 2) != 0) {
            f = Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)));
        }
        return ((long)Float.floatToRawIntBits(f1)) << 0x20 | ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL;
    }

    public static final boolean b(long v, long v1) {
        return v == v1;
    }

    public static final float c(long v) {
        float f = Float.intBitsToFloat(((int)(v >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
        return (float)Math.sqrt(f1 * f1 + f * f);
    }

    public static final float d(long v) {
        return Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public static final float e(long v) {
        return Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b && this.a == ((b)object0).a;
    }

    public static final long f(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) - Float.intBitsToFloat(((int)(v1 >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL;
    }

    public static final long g(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 >> 0x20))) + Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
    }

    public static final long h(long v, float f) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) * f)) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) * f)) & 0xFFFFFFFFL;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public static String i(long v) {
        return (0x7FFFFFFF7FFFFFFFL & v) == 0x7FC000007FC00000L ? "Offset.Unspecified" : "Offset(" + d.N(Float.intBitsToFloat(((int)(v >> 0x20)))) + ", " + d.N(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) + ')';
    }

    @Override
    public final String toString() {
        return b.i(this.a);
    }
}

