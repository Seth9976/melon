package P;

import java.util.List;
import r1.b;

public final class p {
    public final boolean a;
    public final w b;
    public final int c;
    public final int d;
    public final o e;
    public final B f;
    public final boolean g;
    public final w h;

    public p(boolean z, w w0, int v, int v1, o o0, B b0) {
        this.g = z;
        this.h = w0;
        this.a = z;
        this.b = w0;
        this.c = v;
        this.d = v1;
        this.e = o0;
        this.f = b0;
    }

    public final long a(int v, int v1) {
        int v2;
        w w0 = this.b;
        int[] arr_v = w0.a;
        if(v1 == 1) {
            v2 = arr_v[v];
        }
        else {
            int v3 = v1 + v - 1;
            v2 = w0.b[v3] + arr_v[v3] - w0.b[v];
        }
        if(v2 < 0) {
            v2 = 0;
        }
        return this.a ? b.h(v2, v2, 0, 0x7FFFFFFF) : b.h(0, 0x7FFFFFFF, v2, v2);
    }

    public final u b(int v) {
        z z0 = this.f.b(v);
        int v1 = z0.a;
        List list0 = z0.b;
        int v2 = list0.size();
        int v4 = v2 == 0 || v1 + v2 == this.c ? 0 : this.d;
        t[] arr_t = new t[v2];
        int v5 = 0;
        for(int v3 = 0; v3 < v2; ++v3) {
            int v6 = (int)((P.b)list0.get(v3)).a;
            long v7 = this.a(v5, v6);
            t t0 = this.e.a(v1 + v3, v7, v5, v6, v4);
            v5 += v6;
            arr_t[v3] = t0;
        }
        return new u(v, arr_t, this.h, z0.b, this.g, v4);
    }
}

