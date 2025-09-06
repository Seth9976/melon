package P5;

import r7.c;
import r7.d;
import r7.e;

public final class h implements d {
    public static final h a;
    public static final c b;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h.b = c.a("prequest");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(h.b, ((r)(((D)object0))).a);
    }
}

