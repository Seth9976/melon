package i.n.i.b.a.s.e;

public final class i9 extends Qb {
    public final transient Object c;
    public transient int d;

    public i9(Object object0) {
        object0.getClass();
        this.c = object0;
    }

    public i9(Object object0, int v) {
        this.c = object0;
        this.d = v;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int a(int v, Object[] arr_object) {
        arr_object[v] = this.c;
        return v + 1;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean contains(Object object0) {
        return this.c.equals(object0);
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return false;
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final int hashCode() {
        int v = this.d;
        if(v == 0) {
            v = this.c.hashCode();
            this.d = v;
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Ea i() {
        return new md(this.c);
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final h9 p() {
        return h9.l(this.c);
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final boolean q() {
        return this.d != 0;
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final String toString() {
        return "[" + this.c.toString() + ']';
    }
}

