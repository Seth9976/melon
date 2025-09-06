package je;

import c2.Y;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class d extends Y implements ListIterator {
    public final f d;

    public d(f f0, int v) {
        this.d = f0;
        super(f0, 5);
        f.Companion.getClass();
        c.c(v, f0.size());
        this.b = v;
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override
    public final int nextIndex() {
        return this.b;
    }

    @Override
    public final Object previous() {
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        int v = this.b - 1;
        this.b = v;
        return this.d.get(v);
    }

    @Override
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

