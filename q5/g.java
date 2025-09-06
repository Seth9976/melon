package Q5;

import H0.b;
import r7.c;
import r7.d;
import u7.a;
import u7.e;

public final class g implements d {
    public static final g a;
    public static final c b;
    public static final c c;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        a a0 = new a(1);
        g.b = new c("startMs", b.o(b.n(e.class, a0)));
        a a1 = new a(2);
        g.c = new c("endMs", b.o(b.n(e.class, a1)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).e(g.b, ((T5.g)object0).a);
        ((r7.e)object1).e(g.c, ((T5.g)object0).b);
    }
}

