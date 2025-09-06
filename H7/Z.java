package h7;

import r7.c;
import r7.d;

public final class z implements d {
    public static final z a;
    public static final c b;

    static {
        z.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
        z.b = c.a("identifier");
    }

    // 检测为 Lambda 实现
    @Override  // r7.a
    public final void a(Object object0, Object object1) [...]
}

