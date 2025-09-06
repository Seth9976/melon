package P;

import java.util.List;

public final class u {
    public final int a;
    public final t[] b;
    public final w c;
    public final List d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;

    public u(int v, t[] arr_t, w w0, List list0, boolean z, int v1) {
        this.a = v;
        this.b = arr_t;
        this.c = w0;
        this.d = list0;
        this.e = z;
        this.f = v1;
        int v2 = 0;
        int v4 = 0;
        for(int v3 = 0; v3 < arr_t.length; ++v3) {
            v4 = Math.max(v4, arr_t[v3].l);
        }
        this.g = v4;
        int v5 = v4 + this.f;
        if(v5 >= 0) {
            v2 = v5;
        }
        this.h = v2;
    }

    public final t[] a(int v, int v1, int v2) {
        t[] arr_t = this.b;
        int v3 = 0;
        int v5 = 0;
        for(int v4 = 0; v3 < arr_t.length; ++v4) {
            t t0 = arr_t[v3];
            int v6 = (int)((b)this.d.get(v4)).a;
            t0.k(v, this.c.b[v5], v1, v2, (this.e ? this.a : v5), (this.e ? v5 : this.a));
            v5 += v6;
            ++v3;
        }
        return arr_t;
    }
}

