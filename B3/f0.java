package b3;

import I6.V;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;

public final class f0 extends p0 {
    public final V e;
    public final int[] f;
    public final int[] g;
    public final HashMap h;

    public f0(List list0) {
        int v = list0.size();
        this.e = V.p(list0);
        this.f = new int[v];
        int v2 = 0;
        for(int v1 = 0; true; ++v1) {
            int v3 = 1;
            if(v1 >= v) {
                break;
            }
            b0 b00 = (b0)list0.get(v1);
            this.f[v1] = v2;
            if(!b00.p.isEmpty()) {
                v3 = b00.p.size();
            }
            v2 += v3;
        }
        this.g = new int[v2];
        this.h = new HashMap();
        int v5 = 0;
        for(int v4 = 0; v4 < v; ++v4) {
            b0 b01 = (b0)list0.get(v4);
            for(int v6 = 0; v6 < (b01.p.isEmpty() ? 1 : b01.p.size()); ++v6) {
                Object object0 = b0.b(b01, v6);
                this.h.put(object0, v5);
                this.g[v5] = v4;
                ++v5;
            }
        }
    }

    @Override  // b3.p0
    public final int b(Object object0) {
        Integer integer0 = (Integer)this.h.get(object0);
        return integer0 == null ? -1 : ((int)integer0);
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        int v1 = this.g[v];
        int v2 = v - this.f[v1];
        b0 b00 = (b0)this.e.get(v1);
        V v3 = b00.p;
        if(v3.isEmpty()) {
            m00.i(b00.a, b00.a, v1, b00.n + b00.m, 0L, b.f, b00.o);
            return m00;
        }
        d0 d00 = (d0)v3.get(v2);
        Pair pair0 = Pair.create(b00.a, d00.a);
        m00.i(d00.a, pair0, v1, d00.b, b00.q[v2], d00.c, d00.d);
        return m00;
    }

    @Override  // b3.p0
    public final m0 g(Object object0, m0 m00) {
        Integer integer0 = (Integer)this.h.get(object0);
        integer0.getClass();
        this.f(((int)integer0), m00, true);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return this.g.length;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        int v1 = this.g[v];
        int v2 = v - this.f[v1];
        return b0.b(((b0)this.e.get(v1)), v2);
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        b0 b00 = (b0)this.e.get(v);
        int v2 = this.f[v];
        o00.b(b00.a, b00.c, b00.e, b00.g, b00.h, b00.i, b00.j, b00.k, b00.f, b00.l, b00.m, v2, v2 + (b00.p.isEmpty() ? 1 : b00.p.size()) - 1, b00.n);
        o00.k = b00.o;
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return this.e.size();
    }
}

