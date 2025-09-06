package Ac;

import com.melon.ui.I4;

public final class z4 implements I4 {
    public static final z4 a;

    static {
        z4.a = new z4();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof z4;
    }

    @Override
    public final int hashCode() {
        return 0x3A37CAC0;
    }

    @Override
    public final String toString() {
        return "SearchKeyword";
    }
}

