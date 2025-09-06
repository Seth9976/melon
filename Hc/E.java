package hc;

public final class e implements h {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e;
    }

    @Override
    public final int hashCode() {
        return -1164206026;
    }

    @Override
    public final String toString() {
        return "Connected";
    }
}

