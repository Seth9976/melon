package Ac;

import com.melon.ui.K4;

public final class c0 implements K4 {
    public static final c0 a;

    static {
        c0.a = new c0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof c0;
    }

    @Override
    public final int hashCode() {
        return 0x4B322318;
    }

    @Override
    public final String toString() {
        return "Confirm";
    }
}

