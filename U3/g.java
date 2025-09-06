package U3;

import B3.E;
import B3.G;
import e3.x;

public final class g implements f {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final long d;
    public final int e;

    public g(long[] arr_v, long[] arr_v1, long v, long v1, int v2) {
        this.a = arr_v;
        this.b = arr_v1;
        this.c = v;
        this.d = v1;
        this.e = v2;
    }

    @Override  // U3.f
    public final int e() {
        return this.e;
    }

    @Override  // U3.f
    public final long getDataEndPosition() {
        return this.d;
    }

    @Override  // B3.F
    public final long getDurationUs() {
        return this.c;
    }

    @Override  // B3.F
    public final E getSeekPoints(long v) {
        int v1 = x.e(this.a, v, true);
        long v2 = this.a[v1];
        G g0 = new G(v2, this.b[v1]);
        return v2 >= v || v1 == this.a.length - 1 ? new E(g0, g0) : new E(g0, new G(this.a[v1 + 1], this.b[v1 + 1]));
    }

    @Override  // U3.f
    public final long getTimeUs(long v) {
        return this.a[x.e(this.b, v, true)];
    }

    @Override  // B3.F
    public final boolean isSeekable() {
        return true;
    }
}

