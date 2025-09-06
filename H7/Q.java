package h7;

import r7.c;
import r7.d;
import r7.e;

public final class q implements d {
    public static final q a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;

    static {
        q.a = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q.b = c.a("pc");
        q.c = c.a("symbol");
        q.d = c.a("file");
        q.e = c.a("offset");
        q.f = c.a("importance");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).e(q.b, ((Y)(((A0)object0))).a);
        ((e)object1).a(q.c, ((Y)(((A0)object0))).b);
        ((e)object1).a(q.d, ((Y)(((A0)object0))).c);
        ((e)object1).e(q.e, ((Y)(((A0)object0))).d);
        ((e)object1).f(q.f, ((Y)(((A0)object0))).e);
    }
}

