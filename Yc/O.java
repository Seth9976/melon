package yc;

import gd.Z3;

public final class o extends Z3 {
    public static final o a;

    static {
        o.a = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof o;
    }

    @Override
    public final int hashCode() {
        return 0x740F89FA;
    }

    @Override
    public final String toString() {
        return "ClickBackButton";
    }
}

