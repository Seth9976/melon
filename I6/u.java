package I6;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import y5.a;

public final class U extends V {
    public final transient int c;
    public final transient int d;
    public final V e;

    public U(V v0, int v1, int v2) {
        this.e = v0;
        super();
        this.c = v1;
        this.d = v2;
    }

    @Override  // I6.O
    public final Object[] e() {
        return this.e.e();
    }

    @Override  // I6.O
    public final int f() {
        return this.e.g() + this.c + this.d;
    }

    @Override  // I6.O
    public final int g() {
        return this.e.g() + this.c;
    }

    @Override
    public final Object get(int v) {
        a.n(v, this.d);
        return this.e.get(v + this.c);
    }

    @Override  // I6.O
    public final boolean i() {
        return true;
    }

    @Override  // I6.V
    public final Iterator iterator() {
        return this.r(0);
    }

    @Override  // I6.V
    public final ListIterator listIterator() {
        return this.r(0);
    }

    @Override  // I6.V
    public final ListIterator listIterator(int v) {
        return this.r(v);
    }

    @Override
    public final int size() {
        return this.d;
    }

    @Override  // I6.V
    public final List subList(int v, int v1) {
        return this.x(v, v1);
    }

    @Override  // I6.V
    public Object writeReplace() {
        return super.writeReplace();
    }

    @Override  // I6.V
    public final V x(int v, int v1) {
        a.q(v, v1, this.d);
        return this.e.x(v + this.c, v1 + this.c);
    }
}

