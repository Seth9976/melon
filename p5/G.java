package P5;

import r7.c;
import r7.d;
import r7.e;

public final class g implements d {
    public static final g a;
    public static final c b;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = c.a("originAssociatedProductId");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(g.b, ((q)(((C)object0))).a);
    }
}

