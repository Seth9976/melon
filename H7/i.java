package h7;

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
        i.b = c.a("arch");
        i.c = c.a("model");
        i.d = c.a("cores");
        i.e = c.a("ram");
        i.f = c.a("diskSpace");
        i.g = c.a("simulator");
        i.h = c.a("state");
        i.i = c.a("manufacturer");
        i.j = c.a("modelClass");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).f(i.b, ((N)(((w0)object0))).a);
        ((e)object1).a(i.c, ((N)(((w0)object0))).b);
        ((e)object1).f(i.d, ((N)(((w0)object0))).c);
        ((e)object1).e(i.e, ((N)(((w0)object0))).d);
        ((e)object1).e(i.f, ((N)(((w0)object0))).e);
        ((e)object1).b(i.g, ((N)(((w0)object0))).f);
        ((e)object1).f(i.h, ((N)(((w0)object0))).g);
        ((e)object1).a(i.i, ((N)(((w0)object0))).h);
        ((e)object1).a(i.j, ((N)(((w0)object0))).i);
    }
}

