package jd;

import Ad.C;

public final class d1 extends C {
    public static final d1 a;

    static {
        d1.a = new d1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof d1;
    }

    @Override
    public final int hashCode() {
        return 0x2F95B356;
    }

    @Override
    public final String toString() {
        return "ShowEditPopup";
    }
}

