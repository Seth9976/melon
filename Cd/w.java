package cd;

public final class w implements y {
    public static final w a;

    static {
        w.a = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof w;
    }

    @Override
    public final int hashCode() {
        return 0xCF39B006;
    }

    @Override
    public final String toString() {
        return "OnTooltipClick";
    }
}

