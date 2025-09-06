package a1;

import T7.b;
import e.k;
import r1.c;
import r1.m;
import x0.e;
import y0.I;
import y0.M;
import y0.Q;

public final class p implements Q {
    public static final p a;
    public static final b b;
    public static final b c;

    static {
        p.a = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p.b = new b(23);
        p.c = new b(24);
    }

    @Override  // y0.Q
    public M i(long v, m m0, c c0) {
        float f = e.c(v);
        long v1 = ((long)Float.floatToRawIntBits(f / 2.0f)) << 0x20 | ((long)Float.floatToRawIntBits(f / 2.0f)) & 0xFFFFFFFFL;
        return new I(e1.b.j(k.d(0L, v), v1, v1, v1, v1));
    }
}

