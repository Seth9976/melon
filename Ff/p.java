package Ff;

import je.I;
import we.a;

public final class p implements a {
    public final int a;
    public final q b;
    public final r c;

    public p(q q0, r r0, int v) {
        this.a = v;
        this.b = q0;
        this.c = r0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? I.K(this.b.a.keySet(), this.c.o()) : I.K(this.b.b.keySet(), this.c.p());
    }
}

