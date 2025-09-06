package yc;

import gd.Z3;

public final class p extends Z3 {
    public static final p a;

    static {
        p.a = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof p;
    }

    @Override
    public final int hashCode() {
        return 0xFD6671CF;
    }

    @Override
    public final String toString() {
        return "ClickChartButton";
    }
}

