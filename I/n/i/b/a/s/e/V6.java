package i.n.i.b.a.s.e;

public final class v6 extends Qb {
    public final transient Object[] c;
    public final transient Object[] d;
    public final transient int e;
    public final transient int f;
    public final transient int g;
    public static final v6 h;

    static {
        v6.h = new v6(new Object[0], 0, null, 0, 0);
    }

    public v6(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        this.c = arr_object;
        this.d = arr_object1;
        this.e = v1;
        this.f = v;
        this.g = v2;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int a(int v, Object[] arr_object) {
        System.arraycopy(this.c, 0, arr_object, v, this.g);
        return v + this.g;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean contains(Object object0) {
        if(object0 != null) {
            Object[] arr_object = this.d;
            if(arr_object != null) {
                for(int v = Ja.L(object0.hashCode()); true; v = v1 + 1) {
                    int v1 = v & this.e;
                    Object object1 = arr_object[v1];
                    if(object1 == null) {
                        break;
                    }
                    if(object1.equals(object0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Object[] d() {
        return this.c;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int e() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final int f() {
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final boolean g() {
        return false;
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final int hashCode() {
        return this.f;
    }

    @Override  // i.n.i.b.a.s.e.N7
    public final Ea i() {
        return this.b().o(0);
    }

    @Override  // i.n.i.b.a.s.e.Qb
    public final h9 p() {
        return h9.r(this.g, this.c);
    }

    @Override
    public final int size() {
        return this.g;
    }
}

