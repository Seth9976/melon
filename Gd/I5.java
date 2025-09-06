package gd;

import com.melon.ui.I4;

public final class i5 implements I4 {
    public static final i5 a;

    static {
        i5.a = new i5();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof i5;
    }

    @Override
    public final int hashCode() {
        return 0x36776773;
    }

    @Override
    public final String toString() {
        return "PerformBack";
    }
}

