package i0;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public final class g extends a {
    public final e c;
    public int d;
    public i e;
    public int f;

    public g(e e0, int v) {
        super(v, e0.h);
        this.c = e0;
        this.d = e0.i();
        this.f = -1;
        this.b();
    }

    public final void a() {
        if(this.d != this.c.i()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override  // i0.a
    public final void add(Object object0) {
        this.a();
        this.c.add(this.a, object0);
        ++this.a;
        this.b = this.c.b();
        this.d = this.c.i();
        this.f = -1;
        this.b();
    }

    public final void b() {
        e e0 = this.c;
        Object[] arr_object = e0.f;
        if(arr_object == null) {
            this.e = null;
            return;
        }
        int v = e0.h - 1 & 0xFFFFFFE0;
        int v1 = this.a <= v ? this.a : v;
        int v2 = e0.d / 5 + 1;
        i i0 = this.e;
        if(i0 == null) {
            this.e = new i(arr_object, v1, v, v2);
            return;
        }
        i0.a = v1;
        i0.b = v;
        i0.c = v2;
        if(i0.d.length < v2) {
            i0.d = new Object[v2];
        }
        int v3 = 0;
        i0.d[0] = arr_object;
        if(v1 == v) {
            v3 = 1;
        }
        i0.e = v3;
        i0.b(v1 - v3, 1);
    }

    @Override
    public final Object next() {
        this.a();
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int v = this.a;
        this.f = v;
        i i0 = this.e;
        e e0 = this.c;
        if(i0 == null) {
            this.a = v + 1;
            return e0.g[v];
        }
        if(i0.hasNext()) {
            ++this.a;
            return i0.next();
        }
        int v1 = this.a;
        this.a = v1 + 1;
        return e0.g[v1 - i0.b];
    }

    @Override
    public final Object previous() {
        this.a();
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        int v = this.a;
        this.f = v - 1;
        i i0 = this.e;
        e e0 = this.c;
        if(i0 == null) {
            this.a = v - 1;
            return e0.g[v - 1];
        }
        int v1 = i0.b;
        if(v > v1) {
            this.a = v - 1;
            return e0.g[v - 1 - v1];
        }
        this.a = v - 1;
        return i0.previous();
    }

    @Override  // i0.a
    public final void remove() {
        this.a();
        int v = this.f;
        if(v == -1) {
            throw new IllegalStateException();
        }
        e e0 = this.c;
        e0.d(v);
        int v1 = this.f;
        if(v1 < this.a) {
            this.a = v1;
        }
        this.b = e0.b();
        this.d = e0.i();
        this.f = -1;
        this.b();
    }

    @Override  // i0.a
    public final void set(Object object0) {
        this.a();
        int v = this.f;
        if(v == -1) {
            throw new IllegalStateException();
        }
        this.c.set(v, object0);
        this.d = this.c.i();
        this.b();
    }
}

