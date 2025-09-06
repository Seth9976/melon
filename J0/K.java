package j0;

import java.util.Iterator;
import xe.a;

public abstract class k implements Iterator, a {
    public Object[] a;
    public int b;
    public int c;

    public k() {
        this.a = j.e.d;
    }

    public final void a(Object[] arr_object, int v, int v1) {
        this.a = arr_object;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

