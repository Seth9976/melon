package b3;

public final class z0 {
    public final int a;
    public final int b;
    public final float c;
    public static final z0 d;
    public static final String e;
    public static final String f;
    public static final String g;

    static {
        z0.d = new z0(0, 0, 1.0f);
        z0.e = "0";
        z0.f = "1";
        z0.g = "3";
    }

    public z0(int v, int v1, float f) {
        this.a = v;
        this.b = v1;
        this.c = f;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof z0 && this.a == ((z0)object0).a && this.b == ((z0)object0).b && this.c == ((z0)object0).c;
    }

    @Override
    public final int hashCode() {
        return Float.floatToRawIntBits(this.c) + ((this.a + 0xD9) * 0x1F + this.b) * 0x1F;
    }
}

