package P5;

import r7.c;
import r7.d;
import r7.e;

public final class j implements d {
    public static final j a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;

    static {
        j.a = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j.b = c.a("requestTimeMs");
        j.c = c.a("requestUptimeMs");
        j.d = c.a("clientInfo");
        j.e = c.a("logSource");
        j.f = c.a("logSourceName");
        j.g = c.a("logEvent");
        j.h = c.a("qosTier");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).e(j.b, ((t)(((F)object0))).a);
        ((e)object1).e(j.c, ((t)(((F)object0))).b);
        ((e)object1).a(j.d, ((t)(((F)object0))).c);
        ((e)object1).a(j.e, ((t)(((F)object0))).d);
        ((e)object1).a(j.f, ((t)(((F)object0))).e);
        ((e)object1).a(j.g, ((t)(((F)object0))).f);
        ((e)object1).a(j.h, J.a);
    }
}

