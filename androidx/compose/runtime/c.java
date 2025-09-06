package androidx.compose.runtime;

import java.util.Iterator;
import xe.a;

public final class C implements Iterable, Iterator, a {
    public final B0 a;
    public final int b;
    public int c;

    public C(B0 b00, int v) {
        this.a = b00;
        int[] arr_v = b00.a;
        int v1 = arr_v[v * 5 + 4];
        this.b = v + 1 >= b00.b ? b00.d : arr_v[(v + 1) * 5 + 4];
        this.c = v1;
    }

    @Override
    public final boolean hasNext() {
        return this.c < this.b;
    }

    @Override
    public final Iterator iterator() {
        return this;
    }

    @Override
    public final Object next() {
        Object object0;
        int v = this.c;
        if(v >= 0) {
            Object[] arr_object = this.a.c;
            object0 = v < arr_object.length ? arr_object[v] : null;
        }
        else {
            object0 = null;
        }
        this.c = v + 1;
        return object0;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

