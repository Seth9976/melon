package i.n.i.b.a.s.e;

public final class d4 implements u0, v0 {
    public final v0 a;
    public final long b;
    public u0 c;

    public d4(v0 v00, long v) {
        this.a = v00;
        this.b = v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        return this.a.a(v - this.b, xb0) + this.b;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.a.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        return this.a.a(v - this.b);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        return this.a.b(v - this.b) + this.b;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.a.b(v - this.b);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        v0 v00 = (v0)b80;
        u0 u00 = this.c;
        u00.getClass();
        u00.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        long v = this.a.c();
        return v == 0x8000000000000000L ? 0x8000000000000000L : v + this.b;
    }

    @Override  // i.n.i.b.a.s.e.u0
    public final void c(v0 v00) {
        u0 u00 = this.c;
        u00.getClass();
        u00.c(this);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return this.a.e();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        long v = this.a.f();
        return v == 0x8000000000000000L ? 0x8000000000000000L : v + this.b;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return this.a.g();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        return this.a.h();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        this.a.k();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return this.a.l();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.c = u00;
        this.a.l(this, v - this.b);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        long v = this.a.m();
        return v == 0x8000000000000001L ? 0x8000000000000001L : v + this.b;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        return this.a.m(arr_q2, arr_z, arr_b7);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        B7[] arr_b71 = new B7[arr_b7.length];
        for(int v2 = 0; true; ++v2) {
            B7 b70 = null;
            if(v2 >= arr_b7.length) {
                break;
            }
            e4 e40 = (e4)arr_b7[v2];
            if(e40 != null) {
                b70 = e40.a;
            }
            arr_b71[v2] = b70;
        }
        long v3 = this.b;
        long v4 = this.a.v(arr_q2, arr_z, arr_b71, arr_z1, v - v3);
        for(int v1 = 0; v1 < arr_b7.length; ++v1) {
            B7 b71 = arr_b71[v1];
            if(b71 == null) {
                arr_b7[v1] = null;
            }
            else {
                B7 b72 = arr_b7[v1];
                if(b72 == null || ((e4)b72).a != b71) {
                    arr_b7[v1] = new e4(b71, v3);
                }
            }
        }
        return v4 + v3;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        this.a.w(v - this.b, z);
    }
}

