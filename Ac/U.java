package ac;

public final class u implements v {
    public static final u a;

    static {
        u.a = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof u;
    }

    @Override
    public final int hashCode() {
        return 0xA9281428;
    }

    @Override
    public final String toString() {
        return "Streaming";
    }
}

