package i.n.i.b.a.s.e;

import java.util.NoSuchElementException;

public final class md extends Ea {
    public boolean a;
    public final Object b;

    public md(Object object0) {
        this.b = object0;
    }

    @Override
    public final boolean hasNext() {
        return !this.a;
    }

    @Override
    public final Object next() {
        if(this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.b;
    }
}

