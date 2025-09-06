package hc;

public final class f implements h {
    public static final f a;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof f;
    }

    @Override
    public final int hashCode() {
        return -1730644181;
    }

    @Override
    public final String toString() {
        return "Connecting";
    }
}

