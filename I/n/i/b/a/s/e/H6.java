package i.n.i.b.a.s.e;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public final class h6 extends f6 {
    public final rc j;
    public final rc k;
    public final long l;

    public h6(R4 r40, long v, long v1, long v2, long v3, long v4, List list0, long v5, rc rc0, rc rc1, long v6, long v7) {
        super(r40, v, v1, v2, v4, list0, v5, v6, v7);
        this.j = rc0;
        this.k = rc1;
        this.l = v3;
    }

    @Override  // i.n.i.b.a.s.e.k6
    public final R4 a(z5 z50) {
        return this.j == null ? this.a : new R4(this.j.a(0L, z50.a.a, z50.a.h, 0L), 0L, -1L);
    }

    @Override  // i.n.i.b.a.s.e.f6
    public final long b(long v) {
        List list0 = this.f;
        if(list0 != null) {
            return (long)list0.size();
        }
        long v1 = this.l;
        if(v1 != -1L) {
            return v1 - this.d + 1L;
        }
        if(v != 0x8000000000000001L) {
            BigInteger bigInteger0 = BigInteger.valueOf(v).multiply(BigInteger.valueOf(this.b));
            BigInteger bigInteger1 = BigInteger.valueOf(this.e).multiply(BigInteger.valueOf(1000000L));
            RoundingMode roundingMode0 = RoundingMode.CEILING;
            return new BigDecimal(bigInteger0).divide(new BigDecimal(bigInteger1), 0, roundingMode0).toBigIntegerExact().longValue();
        }
        return -1L;
    }

    @Override  // i.n.i.b.a.s.e.f6
    public final R4 d(x5 x50, long v) {
        long v1 = this.d;
        List list0 = this.f;
        if(list0 != null) {
            long v2 = ((i6)list0.get(((int)(v - v1)))).a;
            return new R4(this.k.a(v, x50.a.a, x50.a.h, v2), 0L, -1L);
        }
        return new R4(this.k.a(v, x50.a.a, x50.a.h, (v - v1) * this.e), 0L, -1L);
    }
}

