package rf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class v implements Iterator {
    public final Stack a;
    public s b;

    public v(d d0) {
        this.a = new Stack();
        while(d0 instanceof x) {
            this.a.push(((x)d0));
            d0 = ((x)d0).c;
        }
        this.b = (s)d0;
    }

    public final s a() {
        s s1;
        s s0 = this.b;
        if(s0 == null) {
            throw new NoSuchElementException();
        }
        do {
            Stack stack0 = this.a;
            if(stack0.isEmpty()) {
                s1 = null;
                break;
            }
            d d0;
            for(d0 = ((x)stack0.pop()).d; d0 instanceof x; d0 = ((x)d0).c) {
                stack0.push(((x)d0));
            }
            s1 = (s)d0;
        }
        while(s1.b.length == 0);
        this.b = s1;
        return s0;
    }

    @Override
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override
    public final Object next() {
        return this.a();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

