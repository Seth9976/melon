package p0;

import i.n.i.b.a.s.e.w8;

public final class i extends q {
    public final d b;

    public i(d d0) {
        this.b = d0;
    }

    @Override  // p0.q
    public final void c() {
        this.b.c();
        throw new w8();  // 初始化器: Ljava/lang/Exception;-><init>()V
    }
}

