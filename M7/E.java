package M7;

import r7.c;
import r7.d;

public final class e implements d {
    public static final e a;
    public static final c b;
    public static final c c;
    public static final c d;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e.b = c.a("performance");
        e.c = c.a("crashlytics");
        e.d = c.a("sessionSamplingRate");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((r7.e)object1).a(e.b, ((k)object0).a);
        ((r7.e)object1).a(e.c, ((k)object0).b);
        ((r7.e)object1).d(e.d, ((k)object0).c);
    }
}

