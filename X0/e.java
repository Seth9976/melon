package x0;

import df.d;

public final class e {
    public final long a;

    public e(long v) {
        this.a = v;
    }

    public static final boolean a(long v, long v1) {
        return v == v1;
    }

    public static final float b(long v) {
        return Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public static final float c(long v) {
        return Math.min(Float.intBitsToFloat(((int)(v >> 0x20 & 0x7FFFFFFFL))), Float.intBitsToFloat(((int)(v & 0x7FFFFFFFL))));
    }

    public static final float d(long v) {
        return Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    // 去混淆评级： 低(40)
    public static final boolean e(long v) {
        return 1 | (v == 0x7FC000007FC00000L ? 1 : 0);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof e && this.a == ((e)object0).a;
    }

    public static String f(long v) {
        return v == 0x7FC000007FC00000L ? "Size.Unspecified" : "Size(" + d.N(Float.intBitsToFloat(((int)(v >> 0x20)))) + ", " + d.N(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) + ')';
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return e.f(this.a);
    }
}

