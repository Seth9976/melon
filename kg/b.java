package kg;

import je.p;
import kotlin.jvm.internal.r;
import we.a;

public final class b extends r implements a {
    public final int f;
    public final d g;

    public b(d d0, int v) {
        this.f = v;
        this.g = d0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? new e(this.g) : p.P0(this.g.e.values());
    }
}

