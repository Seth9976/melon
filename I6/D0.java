package I6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y5.a;

public enum d0 implements Iterator {
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
        a.s("no calls to next() since the last call to remove()", false);
    }
}

