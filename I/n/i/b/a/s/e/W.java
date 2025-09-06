package i.n.i.b.a.s.e;

public final class w extends i {
    public final e b;

    public w(e e0) {
        this.b = e0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int a() {
        return 1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int d(Object object0) {
        return object0 == v.e ? 0 : -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final g h(int v, g g0, boolean z) {
        Object object0 = null;
        Integer integer0 = z ? 0 : null;
        if(z) {
            object0 = v.e;
        }
        g0.a = integer0;
        g0.b = object0;
        g0.c = 0;
        g0.d = 0x8000000000000001L;
        g0.e = 0L;
        g0.g = Ud.e;
        g0.f = true;
        return g0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final h j(int v, h h0, long v1) {
        h0.a(this.b, null, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, false, true, null, 0L, 0x8000000000000001L, 0, 0L);
        h0.l = true;
        return h0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int l() {
        return 1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final Object o(int v) {
        return v.e;
    }
}

