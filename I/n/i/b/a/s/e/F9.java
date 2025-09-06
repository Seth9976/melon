package i.n.i.b.a.s.e;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class f9 extends h9 {
    public final transient int c;
    public final transient int d;
    public final h9 e;

    public f9(h9 h90, int v, int v1) {
        this.e = h90;
        super();
        this.c = v;
        this.d = v1;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Object[] d() {
        return this.e.d();
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int e() {
        return this.e.f() + this.c + this.d;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int f() {
        return this.e.f() + this.c;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return true;
    }

    @Override
    public final Object get(int v) {
        M7.p(v, this.d);
        return this.e.get(v + this.c);
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final Iterator iterator() {
        return this.o(0);
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final ListIterator listIterator() {
        return this.o(0);
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final ListIterator listIterator(int v) {
        return this.o(v);
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final h9 p(int v, int v1) {
        M7.F(v, v1, this.d);
        return this.e.p(v + this.c, v1 + this.c);
    }

    @Override
    public final int size() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final List subList(int v, int v1) {
        return this.p(v, v1);
    }
}

