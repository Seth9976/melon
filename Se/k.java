package Se;

import java.lang.reflect.Member;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;

public final class k extends n implements we.k {
    public static final k b;

    static {
        k.b = new k(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Member)object0), "p0");
        return Boolean.valueOf(((Member)object0).isSynthetic());
    }
}

