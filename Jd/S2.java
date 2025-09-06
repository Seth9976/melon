package jd;

import gd.Z3;

public final class s2 extends Z3 {
    public static final s2 a;

    static {
        s2.a = new s2();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof s2;
    }

    @Override
    public final int hashCode() {
        return 0x902D352B;
    }

    @Override
    public final String toString() {
        return "GetArtistList";
    }
}

