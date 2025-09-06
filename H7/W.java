package h7;

import r7.c;
import r7.d;
import r7.e;

public final class w implements d {
    public static final w a;
    public static final c b;
    public static final c c;

    static {
        w.a = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
        w.b = c.a("rolloutId");
        w.c = c.a("variantId");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(w.b, ((g0)(((H0)object0))).a);
        ((e)object1).a(w.c, ((g0)(((H0)object0))).b);
    }
}

