package P5;

import r7.c;
import r7.d;

public final class e implements d {
    public static final e a;
    public static final c b;
    public static final c c;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e.b = c.a("privacyContext");
        e.c = c.a("productIdOrigin");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).a(e.b, ((o)(((A)object0))).a);
        ((r7.e)object1).a(e.c, z.a);
    }
}

