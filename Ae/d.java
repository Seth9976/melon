package Ae;

import java.io.Serializable;

public final class d implements Serializable {
    public static final d a;
    private static final long serialVersionUID;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    private final Object readResolve() {
        return f.a;
    }
}

