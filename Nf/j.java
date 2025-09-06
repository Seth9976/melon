package Nf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import xe.a;

public final class j implements Iterator, a {
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
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

