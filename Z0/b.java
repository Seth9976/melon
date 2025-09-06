package z0;

public abstract class b {
    public static final long a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final int e;

    static {
        b.a = 0x300000000L;
        b.b = 0x300000001L;
        b.c = 0x300000002L;
        b.d = 0x400000003L;
    }

    public static final boolean a(long v, long v1) {
        return v == v1;
    }

    public static String b(long v) {
        if(b.a(v, 0x300000000L)) {
            return "Rgb";
        }
        if(b.a(v, 0x300000001L)) {
            return "Xyz";
        }
        if(b.a(v, 0x300000002L)) {
            return "Lab";
        }
        return b.a(v, b.d) ? "Cmyk" : "Unknown";
    }
}

