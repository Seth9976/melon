package Ce;

import java.util.Iterator;
import java.util.NoSuchElementException;
import xe.a;

public final class f implements Iterator, a {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public f(int v, int v1, int v2) {
        this.a = v2;
        this.b = v1;
        boolean z = false;
        if(v2 <= 0) {
            if(v >= v1) {
                z = true;
            }
        }
        else if(v <= v1) {
            z = true;
        }
        this.c = z;
        if(!z) {
            v = v1;
        }
        this.d = v;
    }

    @Override
    public final boolean hasNext() {
        return this.c;
    }

    @Override
    public final Object next() {
        return this.nextInt();
    }

    public final int nextInt() {
        int v = this.d;
        if(v == this.b) {
            if(!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
            return v;
        }
        this.d = this.a + v;
        return v;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

