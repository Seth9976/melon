package U3;

import B3.E;
import B3.G;
import e3.b;
import e3.x;

public final class h implements f {
    public final long a;
    public final int b;
    public final long c;
    public final int d;
    public final long e;
    public final long f;
    public final long[] g;

    public h(long v, int v1, long v2, int v3, long v4, long[] arr_v) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = v4;
        this.g = arr_v;
        this.f = v4 == -1L ? -1L : v + v4;
    }

    @Override  // U3.f
    public final int e() {
        return this.d;
    }

    @Override  // U3.f
    public final long getDataEndPosition() {
        return this.f;
    }

    @Override  // B3.F
    public final long getDurationUs() {
        return this.c;
    }

    @Override  // B3.F
    public final E getSeekPoints(long v) {
        int v1 = this.b;
        long v2 = this.a;
        if(!this.isSeekable()) {
            G g0 = new G(0L, v2 + ((long)v1));
            return new E(g0, g0);
        }
        long v3 = x.i(v, 0L, this.c);
        double f = ((double)v3) * 100.0 / ((double)this.c);
        double f1 = 0.0;
        if(f > 0.0) {
            if(f >= 100.0) {
                f1 = 256.0;
            }
            else {
                b.k(this.g);
                double f2 = (double)this.g[((int)f)];
                f1 = ((((int)f) == 99 ? 256.0 : ((double)this.g[((int)f) + 1])) - f2) * (f - ((double)(((int)f)))) + f2;
            }
        }
        G g1 = new G(v3, v2 + x.i(Math.round(f1 / 256.0 * ((double)this.e)), v1, this.e - 1L));
        return new E(g1, g1);
    }

    @Override  // U3.f
    public final long getTimeUs(long v) {
        long v1 = v - this.a;
        if(this.isSeekable() && v1 > ((long)this.b)) {
            b.k(this.g);
            double f = ((double)v1) * 256.0 / ((double)this.e);
            int v2 = x.e(this.g, ((long)f), true);
            long v3 = ((long)v2) * this.c / 100L;
            long v4 = this.g[v2];
            long v5 = this.c * ((long)(v2 + 1)) / 100L;
            long v6 = v2 == 99 ? 0x100L : this.g[v2 + 1];
            return v4 == v6 ? Math.round(0.0 * ((double)(v5 - v3))) + v3 : Math.round((f - ((double)v4)) / ((double)(v6 - v4)) * ((double)(v5 - v3))) + v3;
        }
        return 0L;
    }

    @Override  // B3.F
    public final boolean isSeekable() {
        return this.g != null;
    }
}

