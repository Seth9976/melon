package Ce;

public final class g extends e {
    public static final g d;

    static {
        g.d = new g(1, 0, 1);  // 初始化器: LCe/e;-><init>(III)V
    }

    public final boolean d(int v) {
        return this.a <= v && v <= this.b;
    }

    // 去混淆评级： 低(30)
    @Override  // Ce.e
    public final boolean equals(Object object0) {
        return object0 instanceof g && (this.isEmpty() && ((g)object0).isEmpty() || this.a == ((g)object0).a && this.b == ((g)object0).b);
    }

    // 去混淆评级： 低(20)
    @Override  // Ce.e
    public final int hashCode() {
        return this.isEmpty() ? -1 : this.a * 0x1F + this.b;
    }

    @Override  // Ce.e
    public final boolean isEmpty() {
        return this.a > this.b;
    }

    @Override  // Ce.e
    public final String toString() {
        return this.a + ".." + this.b;
    }
}

