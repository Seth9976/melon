package ef;

import kotlin.jvm.internal.q;
import we.k;

public final class g implements k {
    public static final g a;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((String)object0), "it");
        return "(raw) " + ((String)object0);
    }
}

