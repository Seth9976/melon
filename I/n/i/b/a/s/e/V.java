package i.n.i.b.a.s.e;

public final class v extends Vc {
    public final Object c;
    public final Object d;
    public static final Object e;

    static {
        v.e = new Object();
    }

    public v(i i0, Object object0, Object object1) {
        super(i0);
        this.c = object0;
        this.d = object1;
    }

    @Override  // i.n.i.b.a.s.e.Vc
    public final int d(Object object0) {
        if(v.e.equals(object0)) {
            Object object1 = this.d;
            if(object1 != null) {
                object0 = object1;
            }
        }
        return this.b.d(object0);
    }

    @Override  // i.n.i.b.a.s.e.Vc
    public final g h(int v, g g0, boolean z) {
        this.b.h(v, g0, z);
        if(L7.p(g0.b, this.d) && z) {
            g0.b = v.e;
        }
        return g0;
    }

    @Override  // i.n.i.b.a.s.e.Vc
    public final h j(int v, h h0, long v1) {
        this.b.j(v, h0, v1);
        if(L7.p(h0.a, this.c)) {
            h0.a = h.r;
        }
        return h0;
    }

    @Override  // i.n.i.b.a.s.e.Vc
    public final Object o(int v) {
        Object object0 = this.b.o(v);
        return L7.p(object0, this.d) ? v.e : object0;
    }
}

