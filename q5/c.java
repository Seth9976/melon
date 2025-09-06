package Q5;

import H0.b;
import r7.d;
import u7.a;
import u7.e;

public final class c implements d {
    public static final c a;
    public static final r7.c b;
    public static final r7.c c;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        a a0 = new a(1);
        c.b = new r7.c("eventsDroppedCount", b.o(b.n(e.class, a0)));
        a a1 = new a(3);
        c.c = new r7.c("reason", b.o(b.n(e.class, a1)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).e(c.b, ((T5.d)object0).a);
        ((r7.e)object1).a(c.c, ((T5.d)object0).b);
    }
}

