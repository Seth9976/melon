package I6;

import H6.e;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class g0 extends AbstractList implements Serializable, RandomAccess {
    public final List a;
    public final e b;
    private static final long serialVersionUID;

    public g0(e e0, List list0) {
        list0.getClass();
        this.a = list0;
        this.b = e0;
    }

    @Override
    public final Object get(int v) {
        Object object0 = this.a.get(v);
        return this.b.apply(object0);
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator();
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new f0(this, this.a.listIterator(v), 0);
    }

    @Override
    public final Object remove(int v) {
        Object object0 = this.a.remove(v);
        return this.b.apply(object0);
    }

    @Override
    public final void removeRange(int v, int v1) {
        this.a.subList(v, v1).clear();
    }

    @Override
    public final int size() {
        return this.a.size();
    }
}

