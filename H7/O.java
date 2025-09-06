package h7;

import r7.c;
import r7.d;
import r7.e;

public final class o implements d {
    public static final o a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        o.a = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o.b = c.a("name");
        o.c = c.a("code");
        o.d = c.a("address");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(o.b, ((V)(((z0)object0))).a);
        ((e)object1).a(o.c, ((V)(((z0)object0))).b);
        ((e)object1).e(o.d, ((V)(((z0)object0))).c);
    }
}

