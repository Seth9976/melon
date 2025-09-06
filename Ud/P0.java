package ud;

public final class p0 extends t0 {
    public static final p0 a;

    static {
        p0.a = new p0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof p0;
    }

    @Override
    public final int hashCode() {
        return 689640929;
    }

    @Override
    public final String toString() {
        return "NextClickUserEvent";
    }
}

