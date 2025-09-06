package Q5;

import r7.c;
import r7.d;

public final class e implements d {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.a("clientMetrics");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        object0.getClass();
        throw new ClassCastException();
    }
}

