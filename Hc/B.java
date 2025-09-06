package hc;

public final class b implements d {
    public static final b a;

    static {
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof b;
    }

    @Override
    public final int hashCode() {
        return 0x3CCEA70F;
    }

    @Override
    public final String toString() {
        return "Play";
    }
}

