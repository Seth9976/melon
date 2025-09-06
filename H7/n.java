package h7;

import r7.c;
import r7.d;
import r7.e;

public final class n implements d {
    public static final n a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;

    static {
        n.a = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
        n.b = c.a("type");
        n.c = c.a("reason");
        n.d = c.a("frames");
        n.e = c.a("causedBy");
        n.f = c.a("overflowCount");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(n.b, ((U)(((y0)object0))).a);
        ((e)object1).a(n.c, ((U)(((y0)object0))).b);
        ((e)object1).a(n.d, ((U)(((y0)object0))).c);
        ((e)object1).a(n.e, ((U)(((y0)object0))).d);
        ((e)object1).f(n.f, ((U)(((y0)object0))).e);
    }
}

