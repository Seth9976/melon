package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class e1 implements sd {
    public final int a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public e1(int[] arr_v, long[] arr_v1, long[] arr_v2, long[] arr_v3) {
        this.b = arr_v;
        this.c = arr_v1;
        this.d = arr_v2;
        this.e = arr_v3;
        this.a = arr_v.length;
        if(arr_v.length > 0) {
            this.f = arr_v2[arr_v.length - 1] + arr_v3[arr_v.length - 1];
            return;
        }
        this.f = 0L;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        int v1 = L7.y(this.e, v, true);
        long v2 = this.e[v1];
        Nd nd0 = new Nd(v2, this.c[v1]);
        return v2 >= v || v1 == this.a - 1 ? new rd(nd0, nd0) : new rd(nd0, new Nd(this.e[v1 + 1], this.c[v1 + 1]));
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return true;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.f;
    }

    @Override
    public final String toString() {
        return "ChunkIndex(length=" + this.a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}

