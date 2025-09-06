package i.n.i.b.a.s.e;

public final class oe implements u0, v0 {
    public final e2 a;
    public final long b;
    public final L3 c;
    public a6 d;
    public v0 e;
    public u0 f;
    public long g;

    public oe(e2 e20, L3 l30, long v) {
        this.a = e20;
        this.c = l30;
        this.b = v;
        this.g = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        return this.e.a(v, xb0);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.e != null && this.e.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        return this.e != null && this.e.a(v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        return this.e.b(v);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.e.b(v);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        v0 v00 = (v0)b80;
        this.f.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        return this.e.c();
    }

    @Override  // i.n.i.b.a.s.e.u0
    public final void c(v0 v00) {
        this.f.c(this);
    }

    public final void d(e2 e20) {
        long v = this.g == 0x8000000000000001L ? this.b : this.g;
        a6 a60 = this.d;
        a60.getClass();
        v0 v00 = a60.b(e20, this.c, v);
        this.e = v00;
        if(this.f != null) {
            v00.l(this, v);
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return 0L;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.e.f();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        return this.e.h();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        v0 v00 = this.e;
        if(v00 != null) {
            v00.k();
            return;
        }
        a6 a60 = this.d;
        if(a60 != null) {
            a60.l();
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return this.e.l();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.f = u00;
        v0 v00 = this.e;
        if(v00 != null) {
            v00.l(this, (this.g == 0x8000000000000001L ? this.b : this.g));
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        return this.e.m();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        return this.e.m(arr_q2, arr_z, arr_b7);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        long v1 = this.g;
        if(v1 != 0x8000000000000001L && v == this.b) {
            this.g = 0x8000000000000001L;
            return this.e.v(arr_q2, arr_z, arr_b7, arr_z1, v1);
        }
        return this.e.v(arr_q2, arr_z, arr_b7, arr_z1, v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        this.e.w(v, z);
    }
}

