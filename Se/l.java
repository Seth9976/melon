package Se;

import java.lang.reflect.Field;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.k;

public final class l extends n implements k {
    public static final l b;

    static {
        l.b = new l(1, t.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Field)object0), "p0");
        return new t(((Field)object0));
    }
}

