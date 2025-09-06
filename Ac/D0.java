package Ac;

import com.melon.ui.K4;

public final class d0 implements K4 {
    public static final d0 a;

    static {
        d0.a = new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof d0;
    }

    @Override
    public final int hashCode() {
        return 0xE5CE4AFC;
    }

    @Override
    public final String toString() {
        return "HintText";
    }
}

