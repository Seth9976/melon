package yc;

import gd.Z3;

public final class q extends Z3 {
    public static final q a;

    static {
        q.a = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof q;
    }

    @Override
    public final int hashCode() {
        return 0xB4C7B881;
    }

    @Override
    public final String toString() {
        return "ClickInfoButton";
    }
}

