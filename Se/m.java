package Se;

import java.lang.reflect.Method;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.k;

public final class m extends n implements k {
    public static final m b;

    static {
        m.b = new m(1, w.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((Method)object0), "p0");
        return new w(((Method)object0));
    }
}

