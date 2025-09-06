package I6;

import H6.e;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public final class h0 extends AbstractSequentialList implements Serializable {
    public final List a;
    public final e b;
    private static final long serialVersionUID;

    public h0(e e0, List list0) {
        list0.getClass();
        this.a = list0;
        this.b = e0;
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new f0(this, this.a.listIterator(v), 1);
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

