package Ge;

import we.a;

public final class d0 implements a {
    public final int a;
    public final f0 b;

    public d0(f0 f00, int v) {
        this.a = v;
        this.b = f00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? this.b.r() : new e0(this.b);
    }
}

