package h7;

import r7.d;
import r7.e;

public final class c implements d {
    public static final c a;
    public static final r7.c b;
    public static final r7.c c;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = r7.c.a("key");
        c.c = r7.c.a("value");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(c.b, ((F)(((r0)object0))).a);
        ((e)object1).a(c.c, ((F)(((r0)object0))).b);
    }
}

