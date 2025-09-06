package I6;

import java.util.List;
import java.util.ListIterator;

public final class n extends e implements ListIterator {
    public final o e;

    public n(o o0) {
        this.e = o0;
        super(o0);
    }

    public n(o o0, int v) {
        this.e = o0;
        super(o0, ((List)o0.b).listIterator(v));
    }

    @Override
    public final void add(Object object0) {
        o o0 = this.e;
        this.b().add(object0);
        ++o0.f.e;
        if(o0.isEmpty()) {
            o0.b();
        }
    }

    public final ListIterator b() {
        this.a();
        return (ListIterator)this.b;
    }

    @Override
    public final boolean hasPrevious() {
        return this.b().hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return this.b().nextIndex();
    }

    @Override
    public final Object previous() {
        return this.b().previous();
    }

    @Override
    public final int previousIndex() {
        return this.b().previousIndex();
    }

    @Override
    public final void set(Object object0) {
        this.b().set(object0);
    }
}

