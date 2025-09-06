package jd;

import gd.Z3;

public final class O extends Z3 {
    public static final O a;

    static {
        O.a = new O();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof O;
    }

    @Override
    public final int hashCode() {
        return 0x1D3B7902;
    }

    @Override
    public final String toString() {
        return "CancelSendImage";
    }
}

