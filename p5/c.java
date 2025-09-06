package P5;

import r7.d;
import r7.e;

public final class c implements d {
    public static final c a;
    public static final r7.c b;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = r7.c.a("logRequest");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(c.b, ((m)(((w)object0))).a);
    }
}

