package ac;

public final class s implements v {
    public static final s a;

    static {
        s.a = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof s;
    }

    @Override
    public final int hashCode() {
        return 0x89F2EFB2;
    }

    @Override
    public final String toString() {
        return "None";
    }
}

