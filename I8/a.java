package i8;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public final int[] a;
    public final int b;
    public static final enum a c;
    public static final enum a d;
    public static final enum a e;
    public static final enum a f;
    public static final a[] g;

    static {
        a a0 = new a("TERMINATOR", 0, new int[]{0, 0, 0}, 0);
        a.c = new a("NUMERIC", 1, new int[]{10, 12, 14}, 1);
        a.d = new a("ALPHANUMERIC", 2, new int[]{9, 11, 13}, 2);
        a a1 = new a("STRUCTURED_APPEND", 3, new int[]{0, 0, 0}, 3);
        a.e = new a("BYTE", 4, new int[]{8, 16, 16}, 4);
        a a2 = new a("ECI", 5, new int[]{0, 0, 0}, 7);
        a.f = new a("KANJI", 6, new int[]{8, 10, 12}, 8);
        a.g = new a[]{a0, a.c, a.d, a1, a.e, a2, a.f, new a("FNC1_FIRST_POSITION", 7, new int[]{0, 0, 0}, 5), new a("FNC1_SECOND_POSITION", 8, new int[]{0, 0, 0}, 9), new a("HANZI", 9, new int[]{8, 10, 12}, 13)};
    }

    public a(String s, int v, int[] arr_v, int v1) {
        super(s, v);
        this.a = arr_v;
        this.b = v1;
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.g.clone();
    }
}

