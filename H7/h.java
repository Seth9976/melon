package h7;

import r7.c;
import r7.d;

public final class h implements d {
    public static final h a;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.a("clsId");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        object0.getClass();
        throw new ClassCastException();
    }
}

