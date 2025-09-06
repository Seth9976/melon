package P5;

import r7.c;
import r7.d;
import r7.e;

public final class i implements d {
    public static final i a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;

    static {
        i.a = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i.b = c.a("eventTimeMs");
        i.c = c.a("eventCode");
        i.d = c.a("complianceData");
        i.e = c.a("eventUptimeMs");
        i.f = c.a("sourceExtension");
        i.g = c.a("sourceExtensionJsonProto3");
        i.h = c.a("timezoneOffsetSeconds");
        i.i = c.a("networkConnectionInfo");
        i.j = c.a("experimentIds");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).e(i.b, ((s)(((E)object0))).a);
        ((e)object1).a(i.c, ((s)(((E)object0))).b);
        ((e)object1).a(i.d, ((s)(((E)object0))).c);
        ((e)object1).e(i.e, ((s)(((E)object0))).d);
        ((e)object1).a(i.f, ((s)(((E)object0))).e);
        ((e)object1).a(i.g, ((s)(((E)object0))).f);
        ((e)object1).e(i.h, ((s)(((E)object0))).g);
        ((e)object1).a(i.i, ((s)(((E)object0))).h);
        ((e)object1).a(i.j, ((s)(((E)object0))).i);
    }
}

