package v0;

import r1.c;
import r1.d;
import r1.m;

public final class g implements b {
    public static final g a;
    public static final m b;
    public static final d c;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = m.a;
        g.c = new d(1.0f, 1.0f);
    }

    @Override  // v0.b
    public final c b() {
        return g.c;
    }

    @Override  // v0.b
    public final long c() {
        return 0x7FC000007FC00000L;
    }

    @Override  // v0.b
    public final m getLayoutDirection() {
        return g.b;
    }
}

