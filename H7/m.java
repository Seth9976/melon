package h7;

import r7.c;
import r7.d;
import r7.e;

public final class m implements d {
    public static final m a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;

    static {
        m.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        m.b = c.a("threads");
        m.c = c.a("exception");
        m.d = c.a("appExitInfo");
        m.e = c.a("signal");
        m.f = c.a("binaries");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(m.b, ((S)(((C0)object0))).a);
        ((e)object1).a(m.c, ((S)(((C0)object0))).b);
        ((e)object1).a(m.d, ((S)(((C0)object0))).c);
        ((e)object1).a(m.e, ((S)(((C0)object0))).d);
        ((e)object1).a(m.f, ((S)(((C0)object0))).e);
    }
}

