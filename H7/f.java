package h7;

import r7.c;
import r7.d;
import r7.e;

public final class f implements d {
    public static final f a;
    public static final c b;
    public static final c c;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.b = c.a("filename");
        f.c = c.a("contents");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(f.b, ((H)(((s0)object0))).a);
        ((e)object1).a(f.c, ((H)(((s0)object0))).b);
    }
}

