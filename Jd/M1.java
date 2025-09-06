package jd;

import gd.Z3;

public final class m1 extends Z3 {
    public static final m1 a;

    static {
        m1.a = new m1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof m1;
    }

    @Override
    public final int hashCode() {
        return 0x6A602C41;
    }

    @Override
    public final String toString() {
        return "ClickGnbSearch";
    }
}

