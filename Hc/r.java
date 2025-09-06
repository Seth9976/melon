package hc;

public final class r implements s {
    public static final r a;

    static {
        r.a = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof r;
    }

    @Override
    public final int hashCode() {
        return 0xA97A1295;
    }

    @Override
    public final String toString() {
        return "None";
    }
}

