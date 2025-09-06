package g7;

import r7.c;
import r7.d;
import r7.e;

public final class a implements d {
    public static final a a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.b = c.a("rolloutId");
        a.c = c.a("parameterKey");
        a.d = c.a("parameterValue");
        a.e = c.a("variantId");
        a.f = c.a("templateVersion");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(a.b, ((b)(((o)object0))).b);
        ((e)object1).a(a.c, ((b)(((o)object0))).c);
        ((e)object1).a(a.d, ((b)(((o)object0))).d);
        ((e)object1).a(a.e, ((b)(((o)object0))).e);
        ((e)object1).e(a.f, ((b)(((o)object0))).f);
    }
}

