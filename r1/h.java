package r1;

public final class h {
    public final long a;

    public h(long v) {
        this.a = v;
    }

    public static final float a(long v) [...] // 潜在的解密器

    public static final float b(long v) [...] // 潜在的解密器

    public static String c(long v) {
        return v == 0x7FC000007FC00000L ? "DpSize.Unspecified" : f.b(h.b(v)) + " x " + f.b(h.a(v));
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h && this.a == ((h)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return h.c(this.a);
    }
}

