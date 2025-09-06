package hc;

public final class a implements d {
    public static final a a;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof a;
    }

    @Override
    public final int hashCode() {
        return 1020119827;
    }

    @Override
    public final String toString() {
        return "None";
    }
}

