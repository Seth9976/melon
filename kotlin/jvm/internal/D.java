package kotlin.jvm.internal;

import java.io.Serializable;

public final class d implements Serializable {
    public static final d a;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    private Object readResolve() {
        return d.a;
    }
}

