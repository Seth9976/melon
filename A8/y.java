package A8;

public final class y implements G {
    public static final y a;

    static {
        y.a = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 检测为 Lambda 实现
    @Override  // A8.G
    public final String a() [...]

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof y;
    }

    @Override
    public final int hashCode() {
        return 0xE40746A7;
    }

    @Override
    public final String toString() {
        return "IdAndPwdSavingSimple";
    }
}

