package Ce;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import xe.a;

public final class b implements Iterator, a {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public b(char c, char c1, int v) {
        this.a = v;
        this.b = c1;
        boolean z = false;
        if(v <= 0) {
            if(q.h(c, c1) >= 0) {
                z = true;
            }
        }
        else if(q.h(c, c1) <= 0) {
            z = true;
        }
        this.c = z;
        if(!z) {
            c = c1;
        }
        this.d = c;
    }

    @Override
    public final boolean hasNext() {
        return this.c;
    }

    @Override
    public final Object next() {
        int v = this.d;
        if(v == this.b) {
            if(!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
            return Character.valueOf(((char)v));
        }
        this.d = this.a + v;
        return Character.valueOf(((char)v));
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

