package i0;

import java.util.ListIterator;

public abstract class a implements ListIterator, xe.a {
    public int a;
    public int b;

    public a(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public void add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override
    public final int nextIndex() {
        return this.a;
    }

    @Override
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void set(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

