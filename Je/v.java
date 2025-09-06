package je;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import xe.a;

public final class v implements ListIterator, a {
    public static final v a;

    static {
        v.a = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final boolean hasPrevious() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return 0;
    }

    @Override
    public final Object previous() {
        throw new NoSuchElementException();
    }

    @Override
    public final int previousIndex() {
        return -1;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

