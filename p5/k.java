package P5;

import r7.c;
import r7.d;
import r7.e;

public final class k implements d {
    public static final k a;
    public static final c b;
    public static final c c;

    static {
        k.a = new k();  // 初始化器: Ljava/lang/Object;-><init>()V
        k.b = c.a("networkType");
        k.c = c.a("mobileSubtype");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(k.b, ((v)(((I)object0))).a);
        ((e)object1).a(k.c, ((v)(((I)object0))).b);
    }
}

