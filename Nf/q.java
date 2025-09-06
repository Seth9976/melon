package Nf;

import Hf.g;
import java.util.Iterator;

public final class q extends a {
    public final g a;
    public final int b;

    public q(int v, g g0) {
        this.a = g0;
        this.b = v;
    }

    @Override  // Nf.a
    public final int b() {
        return 1;
    }

    @Override  // Nf.a
    public final void d(int v, g g0) {
        throw new IllegalStateException();
    }

    @Override  // Nf.a
    public final Object get(int v) {
        return v == this.b ? this.a : null;
    }

    @Override  // Nf.a
    public final Iterator iterator() {
        return new Qf.g(this, 2);
    }
}

