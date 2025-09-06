package I6;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Objects;
import y5.a;

public final class q0 extends V {
    public final r0 c;

    public q0(r0 r00) {
        this.c = r00;
        super();
    }

    @Override
    public final Object get(int v) {
        a.n(v, this.c.g);
        Object object0 = this.c.e[v * 2 + this.c.f];
        Objects.requireNonNull(object0);
        Object object1 = this.c.e[v * 2 + (this.c.f ^ 1)];
        Objects.requireNonNull(object1);
        return new AbstractMap.SimpleImmutableEntry(object0, object1);
    }

    @Override  // I6.O
    public final boolean i() {
        return true;
    }

    @Override
    public final int size() {
        return this.c.g;
    }

    @Override  // I6.V
    public Object writeReplace() {
        return super.writeReplace();
    }
}

