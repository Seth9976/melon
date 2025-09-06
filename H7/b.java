package h7;

import r7.c;
import r7.d;
import r7.e;

public final class b implements d {
    public static final b a;
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
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b.b = c.a("pid");
        b.c = c.a("processName");
        b.d = c.a("reasonCode");
        b.e = c.a("importance");
        b.f = c.a("pss");
        b.g = c.a("rss");
        b.h = c.a("timestamp");
        b.i = c.a("traceFile");
        b.j = c.a("buildIdMappingForArch");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).f(b.b, ((D)(((q0)object0))).a);
        ((e)object1).a(b.c, ((D)(((q0)object0))).b);
        ((e)object1).f(b.d, ((D)(((q0)object0))).c);
        ((e)object1).f(b.e, ((D)(((q0)object0))).d);
        ((e)object1).e(b.f, ((D)(((q0)object0))).e);
        ((e)object1).e(b.g, ((D)(((q0)object0))).f);
        ((e)object1).e(b.h, ((D)(((q0)object0))).g);
        ((e)object1).a(b.i, ((D)(((q0)object0))).h);
        ((e)object1).a(b.j, ((D)(((q0)object0))).i);
    }
}

