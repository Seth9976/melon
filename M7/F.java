package M7;

import r7.c;
import r7.d;
import r7.e;

public final class f implements d {
    public static final f a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.b = c.a("processName");
        f.c = c.a("pid");
        f.d = c.a("importance");
        f.e = c.a("defaultProcess");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(f.b, ((D)object0).a);
        ((e)object1).f(f.c, ((D)object0).b);
        ((e)object1).f(f.d, ((D)object0).c);
        ((e)object1).b(f.e, ((D)object0).d);
    }
}

