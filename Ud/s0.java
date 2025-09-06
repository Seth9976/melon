package ud;

public final class s0 extends t0 {
    public static final s0 a;

    static {
        s0.a = new s0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof s0;
    }

    @Override
    public final int hashCode() {
        return 0xCC4C0BE9;
    }

    @Override
    public final String toString() {
        return "RewindClickUserEvent";
    }
}

