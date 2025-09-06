package i.n.i.b.a.s.e;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class p8 extends AbstractSet {
    public final Set a;
    public final Set b;

    public p8(Set set0, Set set1) {
        this.a = set0;
        this.b = set1;
        super();
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean contains(Object object0) {
        return this.a.contains(object0) && this.b.contains(object0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean containsAll(Collection collection0) {
        return this.a.containsAll(collection0) && this.b.containsAll(collection0);
    }

    @Override
    public final boolean isEmpty() {
        return Collections.disjoint(this.b, this.a);
    }

    @Override
    public final Iterator iterator() {
        return new o8(this);
    }

    @Override
    public final boolean remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final int size() {
        int v = 0;
        for(Object object0: this.a) {
            if(this.b.contains(object0)) {
                ++v;
            }
        }
        return v;
    }
}

