package A8;

public final class z implements G {
    public static final z a;

    static {
        z.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 检测为 Lambda 实现
    @Override  // A8.G
    public final String a() [...]

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof z;
    }

    @Override
    public final int hashCode() {
        return 0x2E6F1829;
    }

    @Override
    public final String toString() {
        return "Kakao";
    }
}

