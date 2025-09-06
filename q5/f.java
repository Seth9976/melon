package Q5;

import H0.b;
import r7.c;
import r7.d;
import u7.a;
import u7.e;

public final class f implements d {
    public static final f a;
    public static final c b;
    public static final c c;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        a a0 = new a(1);
        f.b = new c("currentCacheSizeBytes", b.o(b.n(e.class, a0)));
        a a1 = new a(2);
        f.c = new c("maxCacheSizeBytes", b.o(b.n(e.class, a1)));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).e(f.b, ((T5.f)object0).a);
        ((r7.e)object1).e(f.c, ((T5.f)object0).b);
    }
}

