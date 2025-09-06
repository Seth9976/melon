package i.n.i.b.a.s.e;

public final class I5 extends Qb {
    public final transient K5 c;
    public final transient J5 d;

    public I5(K5 k50, J5 j50) {
        this.c = k50;
        this.d = j50;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int a(int v, Object[] arr_object) {
        return this.d.a(v, arr_object);
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final h9 b() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean contains(Object object0) {
        return this.c.get(object0) != null;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Ea i() {
        return this.d.o(0);
    }

    @Override
    public final int size() {
        return this.c.f;
    }
}

