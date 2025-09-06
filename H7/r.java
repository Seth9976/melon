package h7;

import r7.c;
import r7.d;
import r7.e;

public final class r implements d {
    public static final r a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        r.a = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
        r.b = c.a("processName");
        r.c = c.a("pid");
        r.d = c.a("importance");
        r.e = c.a("defaultProcess");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(r.b, ((a0)(((D0)object0))).a);
        ((e)object1).f(r.c, ((a0)(((D0)object0))).b);
        ((e)object1).f(r.d, ((a0)(((D0)object0))).c);
        ((e)object1).b(r.e, ((a0)(((D0)object0))).d);
    }
}

