package hc;

public final class c implements d {
    public static final c a;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof c;
    }

    @Override
    public final int hashCode() {
        return 1020273629;
    }

    @Override
    public final String toString() {
        return "Stop";
    }
}

