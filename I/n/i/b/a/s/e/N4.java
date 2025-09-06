package i.n.i.b.a.s.e;

public final class n4 {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public static final n4 e;

    static {
        n4.e = new n4();
    }

    public n4() {
        this(0, 0, 0, 1.0f);
    }

    public n4(int v, int v1, int v2, float f) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof n4 && this.a == ((n4)object0).a && this.b == ((n4)object0).b && this.c == ((n4)object0).c && this.d == ((n4)object0).d;
    }

    @Override
    public final int hashCode() {
        return Float.floatToRawIntBits(this.d) + (((this.a + 0xD9) * 0x1F + this.b) * 0x1F + this.c) * 0x1F;
    }
}

