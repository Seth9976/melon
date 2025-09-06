package ld;

import gd.Z3;

public final class g extends Z3 {
    public static final g a;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof g;
    }

    @Override
    public final int hashCode() {
        return 0x6F5E70BF;
    }

    @Override
    public final String toString() {
        return "ToggleSelectAll";
    }
}

