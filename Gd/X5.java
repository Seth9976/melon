package gd;

import com.melon.ui.I4;

public final class x5 implements I4 {
    public static final x5 a;

    static {
        x5.a = new x5();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof x5;
    }

    @Override
    public final int hashCode() {
        return 382228076;
    }

    @Override
    public final String toString() {
        return "PerformBack";
    }
}

