package i4;

import B3.E;
import B3.F;
import B3.G;
import e3.x;
import java.math.RoundingMode;

public final class d implements F {
    public final V3.d a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public d(V3.d d0, int v, long v1, long v2) {
        this.a = d0;
        this.b = v;
        this.c = v1;
        long v3 = (v2 - v1) / ((long)d0.d);
        this.d = v3;
        this.e = this.a(v3);
    }

    public final long a(long v) {
        return x.T(v * ((long)this.b), 1000000L, this.a.c, RoundingMode.DOWN);
    }

    @Override  // B3.F
    public final long getDurationUs() {
        return this.e;
    }

    @Override  // B3.F
    public final E getSeekPoints(long v) {
        V3.d d0 = this.a;
        long v1 = x.i(((long)d0.c) * v / (((long)this.b) * 1000000L), 0L, this.d - 1L);
        long v2 = this.c;
        long v3 = ((long)d0.d) * v1 + v2;
        long v4 = this.a(v1);
        G g0 = new G(v4, v3);
        if(v4 < v && v1 != this.d - 1L) {
            long v5 = ((long)d0.d) * (v1 + 1L) + v2;
            return new E(g0, new G(this.a(v1 + 1L), v5));
        }
        return new E(g0, g0);
    }

    @Override  // B3.F
    public final boolean isSeekable() {
        return true;
    }
}

