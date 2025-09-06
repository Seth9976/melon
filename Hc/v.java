package hc;

public final class v implements w {
    public static final v a;

    static {
        v.a = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof v;
    }

    @Override
    public final int hashCode() {
        return 0xC0E9B293;
    }

    @Override
    public final String toString() {
        return "Mobile";
    }
}

