package i.n.i.b.a.s.e;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class d9 extends Ea implements ListIterator {
    public final int a;
    public int b;
    public final h9 c;

    public d9(h9 h90, int v) {
        int v1 = h90.size();
        super();
        M7.E(v, v1);
        this.a = v1;
        this.b = v;
        this.c = h90;
    }

    public final Object a(int v) {
        return this.c.get(v);
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int v = this.b;
        this.b = v + 1;
        return this.a(v);
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
        return this.a(v);
    }

    @Override
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException();
    }
}

