package i.n.i.b.a.s.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

public enum nd implements Iterator {
    INSTANCE;

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final void remove() {
        throw new IllegalStateException("no calls to next() since the last call to remove()");
    }
}

