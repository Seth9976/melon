package jd;

import Ad.C;

public final class c1 extends C {
    public static final c1 a;

    static {
        c1.a = new c1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof c1;
    }

    @Override
    public final int hashCode() {
        return 0xC16FAEB7;
    }

    @Override
    public final String toString() {
        return "RefreshChannel";
    }
}

