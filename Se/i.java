package Se;

import java.lang.reflect.Member;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.k;

public final class i extends n implements k {
    public static final i b;

    static {
        i.b = new i(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Member)object0), "p0");
        return Boolean.valueOf(((Member)object0).isSynthetic());
    }
}

