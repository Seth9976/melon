package I6;

import java.util.Objects;
import y5.a;

public final class t0 extends V {
    public final transient Object[] c;
    public final transient int d;
    public final transient int e;

    public t0(Object[] arr_object, int v, int v1) {
        this.c = arr_object;
        this.d = v;
        this.e = v1;
    }

    @Override
    public final Object get(int v) {
        a.n(v, this.e);
        Object object0 = this.c[v * 2 + this.d];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override  // I6.O
    public final boolean i() {
        return true;
    }

    @Override
    public final int size() {
        return this.e;
    }

    @Override  // I6.V
    public Object writeReplace() {
        return super.writeReplace();
    }
}

