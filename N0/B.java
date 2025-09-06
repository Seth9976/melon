package N0;

import kotlin.jvm.internal.n;
import ye.a;

public final class b extends n implements we.n {
    public static final b b;

    static {
        b.b = new b(2, a.class, "max", "max(II)I", 1);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return Math.max(((Number)object0).intValue(), ((Number)object1).intValue());
    }
}

