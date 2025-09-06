package androidx.recyclerview.widget;

import b2.e;

public final class a1 {
    public int a;
    public p0 b;
    public p0 c;
    public static final e d;

    static {
        a1.d = new e(20, 0);
    }

    public static a1 a() {
        a1 a10 = (a1)a1.d.acquire();
        return a10 == null ? new a1() : a10;  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

