package h7;

import r7.c;
import r7.d;
import r7.e;

public final class a implements d {
    public static final a a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.b = c.a("arch");
        a.c = c.a("libraryName");
        a.d = c.a("buildId");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(a.b, ((E)(((p0)object0))).a);
        ((e)object1).a(a.c, ((E)(((p0)object0))).b);
        ((e)object1).a(a.d, ((E)(((p0)object0))).c);
    }
}

