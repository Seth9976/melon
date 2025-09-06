package i.n.i.b.a.s.e;

import java.util.List;

public final class t1 {
    public final int a;
    public final String b;
    public final long c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final u[] j;
    public final int k;
    public final String l;
    public final String m;
    public final List n;
    public final long[] o;
    public final long p;

    public t1(String s, String s1, int v, String s2, long v1, String s3, int v2, int v3, int v4, int v5, String s4, u[] arr_u, List list0, long[] arr_v, long v6) {
        this.l = s;
        this.m = s1;
        this.a = v;
        this.b = s2;
        this.c = v1;
        this.d = s3;
        this.e = v2;
        this.f = v3;
        this.g = v4;
        this.h = v5;
        this.i = s4;
        this.j = arr_u;
        this.n = list0;
        this.o = arr_v;
        this.p = v6;
        this.k = list0.size();
    }

    public final long a(int v) {
        return v == this.k - 1 ? this.p : this.o[v + 1] - this.o[v];
    }

    public final t1 b(u[] arr_u) {
        return new t1(this.l, this.m, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, arr_u, this.n, this.o, this.p);
    }
}

