package jd;

import Ad.C;

public final class b1 extends C {
    public static final b1 a;

    static {
        b1.a = new b1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof b1;
    }

    @Override
    public final int hashCode() {
        return 0xA6529809;
    }

    @Override
    public final String toString() {
        return "Close";
    }
}

