package Ve;

import ie.m;
import kotlin.jvm.internal.q;
import we.k;

public final class r implements k {
    public static final r a;

    static {
        r.a = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((m)object0), "<destruct>");
        return ((String)((m)object0).a) + " = " + ((M)((m)object0).b);
    }
}

