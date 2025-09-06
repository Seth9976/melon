package T7;

import Vd.A;
import Vd.z;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public abstract class m implements Iterator {
    public final int a;
    public int b;
    public Map.Entry c;
    public Map.Entry d;
    public final AbstractMap e;

    public m(o o0) {
        this.a = 0;
        super();
        this.e = o0;
        this.c = o0.f.d;
        this.d = null;
        this.b = o0.e;
    }

    public m(A a0) {
        this.a = 1;
        super();
        this.e = a0;
        this.c = a0.c.d;
        this.d = null;
        this.b = a0.e;
    }

    public n a() {
        n n0 = (n)this.c;
        o o0 = (o)this.e;
        if(n0 == o0.f) {
            throw new NoSuchElementException();
        }
        if(o0.e != this.b) {
            throw new ConcurrentModificationException();
        }
        this.c = n0.d;
        this.d = n0;
        return n0;
    }

    public z b() {
        z z0 = (z)this.c;
        A a0 = (A)this.e;
        if(z0 == a0.c) {
            throw new NoSuchElementException();
        }
        if(a0.e != this.b) {
            throw new ConcurrentModificationException();
        }
        this.c = z0.d;
        this.d = z0;
        return z0;
    }

    @Override
    public final boolean hasNext() {
        return this.a == 0 ? ((n)this.c) != ((o)this.e).f : ((z)this.c) != ((A)this.e).c;
    }

    @Override
    public Object next() {
        return this.a != 0 ? this.b() : this.a();
    }

    @Override
    public final void remove() {
        if(this.a != 0) {
            A a0 = (A)this.e;
            z z0 = (z)this.d;
            if(z0 == null) {
                throw new IllegalStateException();
            }
            a0.c(z0, true);
            this.d = null;
            this.b = a0.e;
            return;
        }
        o o0 = (o)this.e;
        n n0 = (n)this.d;
        if(n0 == null) {
            throw new IllegalStateException();
        }
        o0.c(n0, true);
        this.d = null;
        this.b = o0.e;
    }
}

