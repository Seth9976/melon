package I6;

import java.util.Objects;
import y5.a;

public final class p0 extends V {
    public final transient Object[] c;
    public final transient int d;
    public static final p0 e;

    static {
        p0.e = new p0(new Object[0], 0);
    }

    public p0(Object[] arr_object, int v) {
        this.c = arr_object;
        this.d = v;
    }

    @Override  // I6.V
    public final int d(int v, Object[] arr_object) {
        System.arraycopy(this.c, 0, arr_object, v, this.d);
        return v + this.d;
    }

    @Override  // I6.O
    public final Object[] e() {
        return this.c;
    }

    @Override  // I6.O
    public final int f() {
        return this.d;
    }

    @Override  // I6.O
    public final int g() {
        return 0;
    }

    @Override
    public final Object get(int v) {
        a.n(v, this.d);
        Object object0 = this.c[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override  // I6.O
    public final boolean i() {
        return false;
    }

    @Override
    public final int size() {
        return this.d;
    }

    @Override  // I6.V
    public Object writeReplace() {
        return super.writeReplace();
    }
}

