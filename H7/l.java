package h7;

import r7.c;
import r7.d;
import r7.e;

public final class l implements d {
    public static final l a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        l.a = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l.b = c.a("baseAddress");
        l.c = c.a("size");
        l.d = c.a("name");
        l.e = c.a("uuid");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).e(l.b, ((T)(((x0)object0))).a);
        ((e)object1).e(l.c, ((T)(((x0)object0))).b);
        ((e)object1).a(l.d, ((T)(((x0)object0))).c);
        String s = ((T)(((x0)object0))).d;
        ((e)object1).a(l.e, (s == null ? null : s.getBytes(O0.a)));
    }
}

