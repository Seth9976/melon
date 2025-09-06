package je;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class F extends h {
    public final ArrayList a;

    public F(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    @Override
    public final void add(int v, Object object0) {
        int v1 = p.b0(this, v);
        this.a.add(v1, object0);
    }

    @Override  // je.h
    public final int b() {
        return this.a.size();
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override  // je.h
    public final Object d(int v) {
        int v1 = p.a0(this, v);
        return this.a.remove(v1);
    }

    @Override
    public final Object get(int v) {
        int v1 = p.a0(this, v);
        return this.a.get(v1);
    }

    @Override
    public final Iterator iterator() {
        return new E(this, 0);
    }

    @Override
    public final ListIterator listIterator() {
        return new E(this, 0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new E(this, v);
    }

    @Override
    public final Object set(int v, Object object0) {
        int v1 = p.a0(this, v);
        return this.a.set(v1, object0);
    }
}

