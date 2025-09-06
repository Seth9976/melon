package h7;

import r7.c;
import r7.d;
import r7.e;

public final class p implements d {
    public static final p a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        p.a = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p.b = c.a("name");
        p.c = c.a("importance");
        p.d = c.a("frames");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(p.b, ((W)(((B0)object0))).a);
        ((e)object1).f(p.c, ((W)(((B0)object0))).b);
        ((e)object1).a(p.d, ((W)(((B0)object0))).c);
    }
}

