package i.n.i.b.a.s.e;

public final class o implements ke {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final long d;

    public o(long[] arr_v, long[] arr_v1, long v, long v1) {
        this.a = arr_v;
        this.b = arr_v1;
        this.c = v;
        this.d = v1;
    }

    @Override  // i.n.i.b.a.s.e.ke
    public final long a(long v) {
        return this.a[L7.y(this.b, v, true)];
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        int v1 = L7.y(this.a, v, true);
        long v2 = this.a[v1];
        Nd nd0 = new Nd(v2, this.b[v1]);
        return v2 >= v || v1 == this.a.length - 1 ? new rd(nd0, nd0) : new rd(nd0, new Nd(this.a[v1 + 1], this.b[v1 + 1]));
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.ke
    public final long c() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.c;
    }
}

