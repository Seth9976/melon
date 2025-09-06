package h7;

import r7.c;
import r7.d;
import r7.e;

public final class k implements d {
    public static final k a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;

    static {
        k.a = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        k.b = c.a("execution");
        k.c = c.a("customAttributes");
        k.d = c.a("internalKeys");
        k.e = c.a("background");
        k.f = c.a("currentProcessDetails");
        k.g = c.a("appProcessDetails");
        k.h = c.a("uiOrientation");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(k.b, ((Q)(((E0)object0))).a);
        ((e)object1).a(k.c, ((Q)(((E0)object0))).b);
        ((e)object1).a(k.d, ((Q)(((E0)object0))).c);
        ((e)object1).a(k.e, ((Q)(((E0)object0))).d);
        ((e)object1).a(k.f, ((Q)(((E0)object0))).e);
        ((e)object1).a(k.g, ((Q)(((E0)object0))).f);
        ((e)object1).f(k.h, ((Q)(((E0)object0))).g);
    }
}

