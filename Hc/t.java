package hc;

public final class t implements w {
    public static final t a;

    static {
        t.a = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof t;
    }

    @Override
    public final int hashCode() {
        return 0x895F6570;
    }

    @Override
    public final String toString() {
        return "Cast";
    }
}

