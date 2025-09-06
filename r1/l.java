package r1;

public final class l {
    public final long a;

    public l(long v) {
        this.a = v;
    }

    public static boolean a(long v, Object object0) {
        return object0 instanceof l ? v == ((l)object0).a : false;
    }

    public static final boolean b(long v, long v1) [...] // 潜在的解密器

    public static String c(long v) {
        return ((int)(v >> 0x20)) + " x " + ((int)(v & 0xFFFFFFFFL));
    }

    @Override
    public final boolean equals(Object object0) {
        return l.a(this.a, object0);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return l.c(this.a);
    }
}

