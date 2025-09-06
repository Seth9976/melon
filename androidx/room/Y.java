package androidx.room;

import A4.a;
import H4.b;

public final class y extends b {
    public final z c;

    public y(z z0, int v) {
        this.c = z0;
        super(v, 0);
    }

    @Override  // H4.b
    public final void k(I4.b b0) {
        a a0 = new a(b0);
        this.c.d(a0);
    }

    @Override  // H4.b
    public final void l(I4.b b0, int v, int v1) {
        this.n(b0, v, v1);
    }

    @Override  // H4.b
    public final void m(I4.b b0) {
        a a0 = new a(b0);
        this.c.f(a0);
        this.c.g = b0;
    }

    @Override  // H4.b
    public final void n(I4.b b0, int v, int v1) {
        a a0 = new a(b0);
        this.c.e(a0, v, v1);
    }
}

