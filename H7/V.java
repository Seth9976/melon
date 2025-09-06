package h7;

import r7.c;
import r7.d;
import r7.e;

public final class v implements d {
    public static final v a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        v.a = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v.b = c.a("rolloutVariant");
        v.c = c.a("parameterKey");
        v.d = c.a("parameterValue");
        v.e = c.a("templateVersion");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(v.b, ((f0)(((I0)object0))).a);
        ((e)object1).a(v.c, ((f0)(((I0)object0))).b);
        ((e)object1).a(v.d, ((f0)(((I0)object0))).c);
        ((e)object1).e(v.e, ((f0)(((I0)object0))).d);
    }
}

