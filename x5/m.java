package x5;

import kotlin.jvm.internal.n;
import we.a;

public final class m extends n implements a {
    public static final m b;

    static {
        m.b = new m(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.a
    public final Object invoke() {
        return System.currentTimeMillis();
    }
}

