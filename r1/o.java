package r1;

import e1.u;

public final class o {
    public final long a;
    public static final p[] b;
    public static final long c;

    static {
        o.b = new p[]{new p(0L), new p(0x100000000L), new p(0x200000000L)};
        o.c = u.M(0L, NaNf);
    }

    public o(long v) {
        this.a = v;
    }

    public static final boolean a(long v, long v1) {
        return v == v1;
    }

    public static final long b(long v) {
        return o.b[((int)((v & 0xFF00000000L) >>> 0x20))].a;
    }

    public static final float c(long v) [...] // 潜在的解密器

    public static String d(long v) {
        long v1 = o.b(v);
        if(p.a(v1, 0L)) {
            return "Unspecified";
        }
        if(p.a(v1, 0x100000000L)) {
            return o.c(v) + ".sp";
        }
        return p.a(v1, 0x200000000L) ? o.c(v) + ".em" : "Invalid";
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof o && this.a == ((o)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return o.d(this.a);
    }
}

