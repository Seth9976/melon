package ic;

public final class d extends e {
    public static final d a;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof d;
    }

    @Override
    public final int hashCode() {
        return 0xD3F341D8;
    }

    @Override
    public final String toString() {
        return "Mobile";
    }
}

