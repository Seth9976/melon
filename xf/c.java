package xf;

import Pe.S;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.k;

public final class c extends n implements k {
    public static final c b;

    static {
        c.b = new c(1, S.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((S)object0), "p0");
        return Boolean.valueOf(((S)object0).u1());
    }
}

