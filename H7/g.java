package h7;

import r7.c;
import r7.d;
import r7.e;

public final class g implements d {
    public static final g a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = c.a("identifier");
        g.c = c.a("version");
        g.d = c.a("displayVersion");
        g.e = c.a("organization");
        g.f = c.a("installationUuid");
        g.g = c.a("developmentPlatform");
        g.h = c.a("developmentPlatformVersion");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(g.b, ((K)(((v0)object0))).a);
        ((e)object1).a(g.c, ((K)(((v0)object0))).b);
        ((e)object1).a(g.d, ((K)(((v0)object0))).c);
        ((e)object1).a(g.e, null);
        ((e)object1).a(g.f, ((K)(((v0)object0))).d);
        ((e)object1).a(g.g, ((K)(((v0)object0))).e);
        ((e)object1).a(g.h, ((K)(((v0)object0))).f);
    }
}

