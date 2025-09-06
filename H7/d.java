package h7;

import r7.c;
import r7.e;

public final class d implements r7.d {
    public static final d a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        d.b = c.a("sdkVersion");
        d.c = c.a("gmpAppId");
        d.d = c.a("platform");
        d.e = c.a("installationUuid");
        d.f = c.a("firebaseInstallationId");
        d.g = c.a("firebaseAuthenticationToken");
        d.h = c.a("appQualitySessionId");
        d.i = c.a("buildVersion");
        d.j = c.a("displayVersion");
        d.k = c.a("session");
        d.l = c.a("ndkPayload");
        d.m = c.a("appExitInfo");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(d.b, ((B)(((O0)object0))).b);
        ((e)object1).a(d.c, ((B)(((O0)object0))).c);
        ((e)object1).f(d.d, ((B)(((O0)object0))).d);
        ((e)object1).a(d.e, ((B)(((O0)object0))).e);
        ((e)object1).a(d.f, ((B)(((O0)object0))).f);
        ((e)object1).a(d.g, ((B)(((O0)object0))).g);
        ((e)object1).a(d.h, ((B)(((O0)object0))).h);
        ((e)object1).a(d.i, ((B)(((O0)object0))).i);
        ((e)object1).a(d.j, ((B)(((O0)object0))).j);
        ((e)object1).a(d.k, ((B)(((O0)object0))).k);
        ((e)object1).a(d.l, ((B)(((O0)object0))).l);
        ((e)object1).a(d.m, ((B)(((O0)object0))).m);
    }
}

