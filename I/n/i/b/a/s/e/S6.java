package i.n.i.b.a.s.e;

public final class s6 extends u6 {
    @Override  // i.n.i.b.a.s.e.u6
    public final u6 a(int v, int v1) {
        if(v < v1) {
            return s6.f(-1);
        }
        return v <= v1 ? s6.f(0) : s6.f(1);
    }

    @Override  // i.n.i.b.a.s.e.u6
    public final u6 b(Object object0, Object object1, o4 o40) {
        return s6.f(o40.compare(object0, object1));
    }

    @Override  // i.n.i.b.a.s.e.u6
    public final u6 c(boolean z, boolean z1) {
        if(z == z1) {
            return s6.f(0);
        }
        return z ? s6.f(1) : s6.f(-1);
    }

    @Override  // i.n.i.b.a.s.e.u6
    public final u6 d(boolean z, boolean z1) {
        if(z1 == z) {
            return s6.f(0);
        }
        return z1 ? s6.f(1) : s6.f(-1);
    }

    @Override  // i.n.i.b.a.s.e.u6
    public final int e() {
        return 0;
    }

    public static u6 f(int v) {
        if(v < 0) {
            return u6.b;
        }
        return v > 0 ? u6.c : u6.a;
    }
}

