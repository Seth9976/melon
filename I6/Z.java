package I6;

import i.n.i.b.a.s.e.b5;
import java.util.AbstractMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y5.a;

public abstract class z implements Iterator {
    public final int a;
    public int b;
    public int c;
    public int d;
    public final AbstractMap e;

    public z(B b0) {
        this.a = 0;
        super();
        this.e = b0;
        this.b = b0.e;
        this.c = b0.isEmpty() ? -1 : 0;
        this.d = -1;
    }

    public z(b5 b50) {
        this.a = 1;
        super();
        this.e = b50;
        this.b = b50.f;
        this.c = b50.isEmpty() ? -1 : 0;
        this.d = -1;
    }

    public abstract Object a(int arg1);

    public abstract Object b(int arg1);

    @Override
    public final boolean hasNext() {
        return this.c >= 0;
    }

    @Override
    public final Object next() {
        if(this.a != 0) {
            b5 b50 = (b5)this.e;
            if(b50.f != this.b) {
                throw new ConcurrentModificationException();
            }
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.d = this.c;
            Object object0 = this.a(this.c);
            this.c = this.c + 1 < b50.h ? this.c + 1 : -1;
            return object0;
        }
        B b0 = (B)this.e;
        if(b0.e != this.b) {
            throw new ConcurrentModificationException();
        }
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.d = this.c;
        Object object1 = this.b(this.c);
        this.c = this.c + 1 < b0.f ? this.c + 1 : -1;
        return object1;
    }

    @Override
    public final void remove() {
        if(this.a != 0) {
            b5 b50 = (b5)this.e;
            int v = this.b;
            if(b50.f != v) {
                throw new ConcurrentModificationException();
            }
            int v1 = this.d;
            if(v1 < 0) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            this.b = v + 1;
            b5.e(b50, v1);
            --this.c;
            this.d = -1;
            return;
        }
        B b0 = (B)this.e;
        if(b0.e != this.b) {
            throw new ConcurrentModificationException();
        }
        a.s("no calls to next() since the last call to remove()", this.d >= 0);
        this.b += 0x20;
        b0.remove(b0.k()[this.d]);
        --this.c;
        this.d = -1;
    }
}

