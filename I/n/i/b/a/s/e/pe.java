package i.n.i.b.a.s.e;

public final class pe {
    public final N2 a;
    public final z5 b;
    public final Wc c;
    public final long d;
    public final long e;

    public pe(long v, z5 z50, N2 n20, long v1, Wc wc0) {
        this.d = v;
        this.b = z50;
        this.e = v1;
        this.a = n20;
        this.c = wc0;
    }

    public final pe a(long v, z5 z50) {
        Wc wc0 = this.b.f();
        Wc wc1 = z50.f();
        if(wc0 == null) {
            return new pe(v, z50, this.a, this.e, null);
        }
        if(!wc0.a()) {
            return new pe(v, z50, this.a, this.e, wc1);
        }
        long v1 = wc0.b(v);
        if(v1 == 0L) {
            return new pe(v, z50, this.a, this.e, wc1);
        }
        long v2 = wc0.b();
        long v3 = wc0.a(v2);
        long v4 = v1 + v2;
        long v5 = wc0.a(v4 - 1L);
        long v6 = wc0.c(v4 - 1L, v);
        long v7 = wc1.b();
        long v8 = wc1.a(v7);
        int v9 = Long.compare(v6 + v5, v8);
        long v10 = this.e;
        if(v9 == 0) {
            return new pe(v, z50, this.a, v4 - v7 + v10, wc1);
        }
        if(v9 < 0) {
            throw new F6();  // 初始化器: Ljava/io/IOException;-><init>()V
        }
        if(v8 < v3) {
            long v11 = v10 - (wc1.d(v3, v) - v2);
            return new pe(v, z50, this.a, v11, wc1);
        }
        long v12 = wc0.d(v8, v) - v7;
        return new pe(v, z50, this.a, v12 + v10, wc1);
    }

    public final long b(long v) {
        long v1 = this.c.h(this.d, v);
        return this.c.g(this.d, v) + (v1 + this.e) - 1L;
    }

    public final long c(long v) {
        long v1 = this.d(v);
        return this.c.c(v - this.e, this.d) + v1;
    }

    public final long d(long v) {
        return this.c.a(v - this.e);
    }
}

