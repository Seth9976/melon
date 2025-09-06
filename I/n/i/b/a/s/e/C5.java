package i.n.i.b.a.s.e;

public final class c5 extends h9 {
    public final transient Object[] c;
    public final transient int d;
    public static final c5 e;

    static {
        c5.e = new c5(new Object[0], 0);
    }

    public c5(Object[] arr_object, int v) {
        this.c = arr_object;
        this.d = v;
    }

    @Override  // i.n.i.b.a.s.e.h9
    public final int a(int v, Object[] arr_object) {
        System.arraycopy(this.c, 0, arr_object, v, this.d);
        return v + this.d;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Object[] d() {
        return this.c;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int e() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int f() {
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return false;
    }

    @Override
    public final Object get(int v) {
        M7.p(v, this.d);
        return this.c[v];
    }

    @Override
    public final int size() {
        return this.d;
    }
}

