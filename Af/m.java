package Af;

import we.k;

public final class m implements k {
    public final int a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final m e;

    static {
        m.b = new m(0);
        m.c = new m(1);
        m.d = new m(2);
        m.e = new m(3);
    }

    public m(int v) {
        this.a = v;
        super();
    }

    // 检测为 Lambda 实现
    @Override  // we.k
    public final Object invoke(Object object0) [...]
}

