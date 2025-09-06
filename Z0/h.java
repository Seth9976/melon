package z0;

import androidx.collection.z;

public abstract class h {
    public static final z a;

    static {
        e e0 = new e(d.e, d.e, 1);  // 初始化器: Lz0/g;-><init>(Lz0/c;Lz0/c;I)V
        g g0 = new g(d.e, d.x, 0);
        g g1 = new g(d.x, d.e, 0);
        z z0 = new z();
        z0.h(d.e.c | d.e.c << 6, e0);
        z0.h(d.x.c << 6 | d.e.c, g0);
        z0.h(d.e.c << 6 | d.x.c, g1);
        h.a = z0;
    }
}

