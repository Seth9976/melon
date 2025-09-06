package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import xe.a;

public final class b implements Iterator, a {
    public int a;
    public int b;
    public boolean c;
    public final int d;
    public final Object e;

    public b(int v) {
        this.a = v;
    }

    public b(f f0, int v) {
        this.d = v;
        if(v != 1) {
            this.e = f0;
            this(f0.size());
            return;
        }
        this.e = f0;
        this(f0.size());
    }

    public b(g g0) {
        this.d = 2;
        this.e = g0;
        this(g0.c);
    }

    @Override
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override
    public final Object next() {
        Object object0;
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int v = this.b;
        switch(this.d) {
            case 0: {
                object0 = ((f)this.e).keyAt(v);
                break;
            }
            case 1: {
                object0 = ((f)this.e).valueAt(v);
                break;
            }
            default: {
                object0 = ((g)this.e).b[v];
            }
        }
        ++this.b;
        this.c = true;
        return object0;
    }

    @Override
    public final void remove() {
        if(!this.c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int v = this.b - 1;
        this.b = v;
        switch(this.d) {
            case 0: {
                ((f)this.e).removeAt(v);
                break;
            }
            case 1: {
                ((f)this.e).removeAt(v);
                break;
            }
            default: {
                ((g)this.e).a(v);
            }
        }
        --this.a;
        this.c = false;
    }
}

