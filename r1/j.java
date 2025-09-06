package r1;

public final class j {
    public final long a;

    public j(long v) {
        this.a = v;
    }

    public static final boolean a(long v, long v1) [...] // 潜在的解密器

    public static final long b(long v, long v1) {
        return ((long)(((int)(v >> 0x20)) - ((int)(v1 >> 0x20)))) << 0x20 | ((long)(((int)(v & 0xFFFFFFFFL)) - ((int)(v1 & 0xFFFFFFFFL)))) & 0xFFFFFFFFL;
    }

    public static final long c(long v, long v1) {
        return ((long)(((int)(v >> 0x20)) + ((int)(v1 >> 0x20)))) << 0x20 | ((long)(((int)(v & 0xFFFFFFFFL)) + ((int)(v1 & 0xFFFFFFFFL)))) & 0xFFFFFFFFL;
    }

    public static String d(long v) [...] // 潜在的解密器

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j && this.a == ((j)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return j.d(this.a);
    }
}

