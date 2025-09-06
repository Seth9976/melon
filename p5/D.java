package P5;

import r7.c;
import r7.e;

public final class d implements r7.d {
    public static final d a;
    public static final c b;
    public static final c c;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        d.b = c.a("clientType");
        d.c = c.a("androidClientInfo");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((n)(((y)object0))).getClass();
        ((e)object1).a(d.b, x.a);
        ((e)object1).a(d.c, ((n)(((y)object0))).a);
    }
}

