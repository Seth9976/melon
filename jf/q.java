package jf;

import we.k;

public final class q implements k {
    public static final q a;

    static {
        q.a = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        kotlin.jvm.internal.q.g(((String)object0), "it");
        return ((String)object0).length() <= 1 ? ((String)object0) : "L" + ((String)object0) + ';';
    }
}

