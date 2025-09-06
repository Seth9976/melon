package g0;

import java.util.List;
import java.util.ListIterator;
import xe.a;

public final class d implements ListIterator, a {
    public final Object a;
    public int b;

    public d(List list0, int v) {
        this.a = list0;
        this.b = v;
    }

    @Override
    public final void add(Object object0) {
        ((List)this.a).add(this.b, object0);
        ++this.b;
    }

    @Override
    public final boolean hasNext() {
        return this.b < ((List)this.a).size();
    }

    @Override
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override
    public final Object next() {
        int v = this.b;
        this.b = v + 1;
        return ((List)this.a).get(v);
    }

    @Override
    public final int nextIndex() {
        return this.b;
    }

    @Override
    public final Object previous() {
        int v = this.b - 1;
        this.b = v;
        return ((List)this.a).get(v);
    }

    @Override
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override
    public final void remove() {
        int v = this.b - 1;
        this.b = v;
        ((List)this.a).remove(v);
    }

    @Override
    public final void set(Object object0) {
        ((List)this.a).set(this.b, object0);
    }
}

