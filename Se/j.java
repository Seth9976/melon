package Se;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.n;
import we.k;

public final class j extends n implements k {
    public static final j b;

    static {
        j.b = new j(1, q.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        kotlin.jvm.internal.q.g(((Constructor)object0), "p0");
        return new q(((Constructor)object0));
    }
}

