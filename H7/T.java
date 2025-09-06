package h7;

import r7.c;
import r7.d;
import r7.e;

public final class t implements d {
    public static final t a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;

    static {
        t.a = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
        t.b = c.a("timestamp");
        t.c = c.a("type");
        t.d = c.a("app");
        t.e = c.a("device");
        t.f = c.a("log");
        t.g = c.a("rollouts");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).e(t.b, ((P)(((K0)object0))).a);
        ((e)object1).a(t.c, ((P)(((K0)object0))).b);
        ((e)object1).a(t.d, ((P)(((K0)object0))).c);
        ((e)object1).a(t.e, ((P)(((K0)object0))).d);
        ((e)object1).a(t.f, ((P)(((K0)object0))).e);
        ((e)object1).a(t.g, ((P)(((K0)object0))).f);
    }
}

