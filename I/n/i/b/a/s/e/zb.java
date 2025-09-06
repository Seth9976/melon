package i.n.i.b.a.s.e;

public final class Zb implements sd {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final boolean d;

    public Zb(long v, long[] arr_v, long[] arr_v1) {
        M7.u(arr_v.length == arr_v1.length);
        this.d = arr_v1.length > 0;
        if(arr_v1.length <= 0 || arr_v1[0] <= 0L) {
            this.a = arr_v;
            this.b = arr_v1;
        }
        else {
            long[] arr_v2 = new long[arr_v1.length + 1];
            this.a = arr_v2;
            long[] arr_v3 = new long[arr_v1.length + 1];
            this.b = arr_v3;
            System.arraycopy(arr_v, 0, arr_v2, 1, arr_v1.length);
            System.arraycopy(arr_v1, 0, arr_v3, 1, arr_v1.length);
        }
        this.c = v;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        if(!this.d) {
            return new rd(Nd.c, Nd.c);
        }
        int v1 = L7.y(this.b, v, true);
        long v2 = this.b[v1];
        Nd nd0 = new Nd(v2, this.a[v1]);
        return v2 == v || v1 == this.b.length - 1 ? new rd(nd0, nd0) : new rd(nd0, new Nd(this.b[v1 + 1], this.a[v1 + 1]));
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.c;
    }
}

