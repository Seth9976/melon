package I6;

import java.util.AbstractList;
import java.util.ListIterator;

public final class f0 extends F0 implements ListIterator {
    public final int b;
    public final AbstractList c;

    public f0(AbstractList abstractList0, ListIterator listIterator0, int v) {
        this.b = v;
        this.c = abstractList0;
        super(listIterator0);
    }

    @Override  // I6.F0
    public final Object a(Object object0) {
        return this.b == 0 ? ((g0)this.c).b.apply(object0) : ((h0)this.c).b.apply(object0);
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasPrevious() {
        return ((ListIterator)this.a).hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return ((ListIterator)this.a).nextIndex();
    }

    @Override
    public final Object previous() {
        return this.a(((ListIterator)this.a).previous());
    }

    @Override
    public final int previousIndex() {
        return ((ListIterator)this.a).previousIndex();
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException();
    }
}

