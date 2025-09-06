package ld;

import gd.Z3;

public final class f extends Z3 {
    public static final f a;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof f;
    }

    @Override
    public final int hashCode() {
        return -2001954747;
    }

    @Override
    public final String toString() {
        return "ClickRefresh";
    }
}

