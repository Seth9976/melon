package h7;

import r7.c;
import r7.d;
import r7.e;

public final class s implements d {
    public static final s a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;

    static {
        s.a = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
        s.b = c.a("batteryLevel");
        s.c = c.a("batteryVelocity");
        s.d = c.a("proximityOn");
        s.e = c.a("orientation");
        s.f = c.a("ramUsed");
        s.g = c.a("diskUsed");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(s.b, ((c0)(((F0)object0))).a);
        ((e)object1).f(s.c, ((c0)(((F0)object0))).b);
        ((e)object1).b(s.d, ((c0)(((F0)object0))).c);
        ((e)object1).f(s.e, ((c0)(((F0)object0))).d);
        ((e)object1).e(s.f, ((c0)(((F0)object0))).e);
        ((e)object1).e(s.g, ((c0)(((F0)object0))).f);
    }
}

