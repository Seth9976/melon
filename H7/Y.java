package h7;

import r7.c;
import r7.d;
import r7.e;

public final class y implements d {
    public static final y a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        y.a = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
        y.b = c.a("platform");
        y.c = c.a("version");
        y.d = c.a("buildVersion");
        y.e = c.a("jailbroken");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).f(y.b, ((j0)(((L0)object0))).a);
        ((e)object1).a(y.c, ((j0)(((L0)object0))).b);
        ((e)object1).a(y.d, ((j0)(((L0)object0))).c);
        ((e)object1).b(y.e, ((j0)(((L0)object0))).d);
    }
}

