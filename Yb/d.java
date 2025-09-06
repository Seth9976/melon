package Yb;

import Bf.a;
import b3.E;
import kotlin.jvm.internal.q;

public final class d extends a {
    public static final d b;

    static {
        q.f(E.g, "EMPTY");
        d.b = new d(E.g);  // 初始化器: LBf/a;-><init>(Ljava/lang/Object;)V
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof d;
    }

    @Override
    public final int hashCode() {
        return 0x8022C729;
    }

    @Override
    public final String toString() {
        return "None";
    }
}

