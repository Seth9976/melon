package i.n.i.b.a.s.e;

import android.util.Pair;

public final class td implements ke {
    public final long[] a;
    public final long[] b;
    public final long c;

    public td(long v, long[] arr_v, long[] arr_v1) {
        this.a = arr_v;
        this.b = arr_v1;
        if(v == 0x8000000000000001L) {
            v = b4.a(arr_v1[arr_v1.length - 1]);
        }
        this.c = v;
    }

    @Override  // i.n.i.b.a.s.e.ke
    public final long a(long v) {
        return b4.a(((long)(((Long)td.b(v, this.a, this.b).second))));
    }

    public static Pair b(long v, long[] arr_v, long[] arr_v1) {
        int v1 = L7.y(arr_v, v, true);
        long v2 = arr_v[v1];
        long v3 = arr_v1[v1];
        if(v1 + 1 == arr_v.length) {
            return Pair.create(v2, v3);
        }
        long v4 = arr_v[v1 + 1];
        long v5 = arr_v1[v1 + 1];
        return v4 == v2 ? Pair.create(v, ((long)(((long)(0.0 * ((double)(v5 - v3)))) + v3))) : Pair.create(v, ((long)(((long)((((double)v) - ((double)v2)) / ((double)(v4 - v2)) * ((double)(v5 - v3)))) + v3)));
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        Pair pair0 = td.b(b4.b(L7.A(v, 0L, this.c)), this.b, this.a);
        Nd nd0 = new Nd(b4.a(((long)(((Long)pair0.first)))), ((long)(((Long)pair0.second))));
        return new rd(nd0, nd0);
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.ke
    public final long c() {
        return -1L;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.c;
    }
}

