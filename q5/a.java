package Q5;

import H0.b;
import r7.c;
import r7.d;
import u7.e;

public final class a implements d {
    public static final a a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        u7.a a0 = new u7.a(1);
        a.b = new c("window", b.o(b.n(e.class, a0)));
        u7.a a1 = new u7.a(2);
        a.c = new c("logSourceMetrics", b.o(b.n(e.class, a1)));
        u7.a a2 = new u7.a(3);
        a.d = new c("globalMetrics", b.o(b.n(e.class, a2)));
        u7.a a3 = new u7.a(4);
        a.e = new c("appNamespace", b.o(b.n(e.class, a3)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).a(a.b, ((T5.a)object0).a);
        ((r7.e)object1).a(a.c, ((T5.a)object0).b);
        ((r7.e)object1).a(a.d, ((T5.a)object0).c);
        ((r7.e)object1).a(a.e, ((T5.a)object0).d);
    }
}

