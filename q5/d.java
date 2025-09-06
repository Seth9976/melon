package Q5;

import H0.b;
import r7.c;
import u7.a;
import u7.e;

public final class d implements r7.d {
    public static final d a;
    public static final c b;
    public static final c c;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        a a0 = new a(1);
        d.b = new c("logSource", b.o(b.n(e.class, a0)));
        a a1 = new a(2);
        d.c = new c("logEventDropped", b.o(b.n(e.class, a1)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).a(d.b, ((T5.e)object0).a);
        ((r7.e)object1).a(d.c, ((T5.e)object0).b);
    }
}

