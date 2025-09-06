package Ge;

import we.a;

public final class a0 implements a {
    public final int a;
    public final c0 b;

    public a0(c0 c00, int v) {
        this.a = v;
        this.b = c00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? this.b.r() : new b0(this.b);
    }
}

