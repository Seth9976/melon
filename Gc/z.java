package gc;

public final class z implements D {
    public static final z a;

    static {
        z.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof z;
    }

    @Override
    public final int hashCode() {
        return 0x94C844A1;
    }

    @Override
    public final String toString() {
        return "End";
    }
}

