package i.n.i.b.a.s.e;

import java.util.List;

public abstract class f6 extends k6 {
    public final long d;
    public final long e;
    public final List f;
    public final long g;
    public final long h;
    public final long i;

    public f6(R4 r40, long v, long v1, long v2, long v3, List list0, long v4, long v5, long v6) {
        super(r40, v, v1);
        this.d = v2;
        this.e = v3;
        this.f = list0;
        this.i = v4;
        this.g = v5;
        this.h = v6;
    }

    public abstract long b(long arg1);

    public final long c(long v, long v1) {
        long v2 = this.b(v);
        return v2 == -1L ? ((long)(((int)(this.i(v1 - this.h + this.i, v) - this.f(v, v1))))) : v2;
    }

    public abstract R4 d(x5 arg1, long arg2);

    public final long e(long v) {
        return this.f == null ? L7.C((v - this.d) * this.e, 1000000L, this.b) : L7.C(((i6)this.f.get(((int)(v - this.d)))).a - this.c, 1000000L, this.b);
    }

    public final long f(long v, long v1) {
        int v2 = Long.compare(this.b(v), -1L);
        long v3 = this.d;
        if(v2 == 0) {
            return this.g == 0x8000000000000001L ? v3 : Math.max(v3, this.i(v1 - this.h - this.g, v));
        }
        return v3;
    }

    public final long g(long v, long v1) {
        long v2 = this.b;
        long v3 = this.d;
        List list0 = this.f;
        if(list0 != null) {
            return ((i6)list0.get(((int)(v - v3)))).b * 1000000L / v2;
        }
        long v4 = this.b(v1);
        return v4 == -1L || v != v3 + v4 - 1L ? this.e * 1000000L / v2 : v1 - this.e(v);
    }

    public boolean h() {
        return this.f != null;
    }

    public final long i(long v, long v1) {
        long v2 = this.b(v1);
        long v3 = this.d;
        if(Long.compare(v2, 0L) != 0) {
            if(this.f != null) {
                goto label_7;
            }
            long v4 = v / (this.e * 1000000L / this.b) + v3;
            if(v4 >= v3) {
                return v2 == -1L ? v4 : Math.min(v4, v3 + v2 - 1L);
            label_7:
                long v5 = v2 + v3 - 1L;
                long v6 = v3;
                while(v6 <= v5) {
                    long v7 = (v5 - v6) / 2L + v6;
                    int v8 = Long.compare(this.e(v7), v);
                    if(v8 < 0) {
                        v6 = v7 + 1L;
                        continue;
                    }
                    if(v8 > 0) {
                        v5 = v7 - 1L;
                        continue;
                    }
                    return v7;
                }
                return v6 == v3 ? v6 : v5;
            }
        }
        return v3;
    }
}

