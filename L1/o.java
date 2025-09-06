package l1;

import kotlin.jvm.internal.r;
import we.a;

public final class o extends r implements a {
    public final int f;
    public final p g;

    public o(p p0, int v) {
        this.f = v;
        this.g = p0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f != 0 ? this.g : this.g.a();
    }
}

