package l2;

import kotlin.jvm.internal.r;
import we.a;

public final class n extends r implements a {
    public final int f;
    public final M g;

    public n(M m0, int v) {
        this.f = v;
        this.g = m0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? this.g.a.createConnection() : ((l0)this.g.j.getValue()).d();
    }
}

