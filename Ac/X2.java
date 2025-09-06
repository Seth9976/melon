package Ac;

public final class x2 extends z2 {
    public static final x2 a;

    static {
        x2.a = new x2();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof x2;
    }

    @Override
    public final int hashCode() {
        return 1404148947;
    }

    @Override
    public final String toString() {
        return "Loading";
    }
}

