package androidx.collection;

import java.util.AbstractSet;
import java.util.Iterator;

public final class a extends AbstractSet {
    public final f a;

    public a(f f0) {
        this.a = f0;
        super();
    }

    @Override
    public final Iterator iterator() {
        return new d(this.a);
    }

    @Override
    public final int size() {
        return this.a.size();
    }
}

