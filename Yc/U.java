package yc;

import gd.Z3;

public final class u extends Z3 {
    public static final u a;

    static {
        u.a = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof u;
    }

    @Override
    public final int hashCode() {
        return 0x35C56F4C;
    }

    @Override
    public final String toString() {
        return "ClickRefreshButton";
    }
}

