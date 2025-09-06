package h7;

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
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;

    static {
        j.a = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j.b = c.a("generator");
        j.c = c.a("identifier");
        j.d = c.a("appQualitySessionId");
        j.e = c.a("startedAt");
        j.f = c.a("endedAt");
        j.g = c.a("crashed");
        j.h = c.a("app");
        j.i = c.a("user");
        j.j = c.a("os");
        j.k = c.a("device");
        j.l = c.a("events");
        j.m = c.a("generatorType");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(j.b, ((J)(((N0)object0))).a);
        ((e)object1).a(j.c, ((J)(((N0)object0))).b.getBytes(O0.a));
        ((e)object1).a(j.d, ((J)(((N0)object0))).c);
        ((e)object1).e(j.e, ((J)(((N0)object0))).d);
        ((e)object1).a(j.f, ((J)(((N0)object0))).e);
        ((e)object1).b(j.g, ((J)(((N0)object0))).f);
        ((e)object1).a(j.h, ((J)(((N0)object0))).g);
        ((e)object1).a(j.i, ((J)(((N0)object0))).h);
        ((e)object1).a(j.j, ((J)(((N0)object0))).i);
        ((e)object1).a(j.k, ((J)(((N0)object0))).j);
        ((e)object1).a(j.l, ((J)(((N0)object0))).k);
        ((e)object1).f(j.m, ((J)(((N0)object0))).l);
    }
}

