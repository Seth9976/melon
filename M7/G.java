package M7;

import r7.c;
import r7.d;
import r7.e;

public final class g implements d {
    public static final g a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = c.a("eventType");
        g.c = c.a("sessionData");
        g.d = c.a("applicationInfo");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((O)object0).getClass();
        ((e)object1).a(g.b, n.b);
        ((e)object1).a(g.c, ((O)object0).a);
        ((e)object1).a(g.d, ((O)object0).b);
    }
}

