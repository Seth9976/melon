package i.n.i.b.a.s.e;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public final class P7 extends i {
    public final int b;
    public final T8 c;
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;
    public final i[] h;
    public final Object[] i;
    public final HashMap j;

    public P7(ArrayList arrayList0, T8 t80) {
        this.c = t80;
        this.b = t80.b.length;
        int v = arrayList0.size();
        this.f = new int[v];
        this.g = new int[v];
        this.h = new i[v];
        this.i = new Object[v];
        this.j = new HashMap();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        for(Object object0: arrayList0) {
            this.h[v3] = ((x2)object0).b();
            this.g[v3] = v1;
            this.f[v3] = v2;
            v1 += this.h[v3].l();
            v2 += this.h[v3].a();
            this.i[v3] = ((x2)object0).a();
            this.j.put(this.i[v3], v3);
            ++v3;
        }
        this.d = v1;
        this.e = v2;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int a() {
        return this.e;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int b(int v, int v1, boolean z) {
        int[] arr_v = this.g;
        int v2 = L7.t(v + 1, arr_v);
        int v3 = arr_v[v2];
        i[] arr_i = this.h;
        int v4 = arr_i[v2].b(v - v3, (v1 == 2 ? 0 : v1), z);
        if(v4 != -1) {
            return v3 + v4;
        }
        int v5;
        for(v5 = this.q(v2, z); v5 != -1 && arr_i[v5].p(); v5 = this.q(v5, z)) {
        }
        if(v5 != -1) {
            int v6 = arr_v[v5];
            return arr_i[v5].e(z) + v6;
        }
        return v1 == 2 ? this.e(z) : -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int d(Object object0) {
        if(object0 instanceof Pair) {
            Object object1 = ((Pair)object0).first;
            Object object2 = ((Pair)object0).second;
            Integer integer0 = (Integer)this.j.get(object1);
            int v = integer0 == null ? -1 : ((int)integer0);
            if(v != -1) {
                int v1 = this.h[v].d(object2);
                return v1 == -1 ? -1 : this.f[v] + v1;
            }
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int e(boolean z) {
        i[] arr_i;
        int v = 0;
        if(this.b != 0) {
            if(z) {
                int[] arr_v = this.c.b;
                v = arr_v.length <= 0 ? -1 : arr_v[0];
            }
            while(true) {
                arr_i = this.h;
                if(!arr_i[v].p()) {
                    break;
                }
                v = this.q(v, z);
                if(v != -1) {
                    continue;
                }
                return -1;
            }
            int v1 = this.g[v];
            return arr_i[v].e(z) + v1;
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final g h(int v, g g0, boolean z) {
        int v1 = L7.t(v + 1, this.f);
        int v2 = this.g[v1];
        this.h[v1].h(v - this.f[v1], g0, z);
        g0.c += v2;
        if(z) {
            Object object0 = this.i[v1];
            Object object1 = g0.b;
            object1.getClass();
            g0.b = Pair.create(object0, object1);
        }
        return g0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final g i(Object object0, g g0) {
        Object object1 = ((Pair)object0).first;
        Object object2 = ((Pair)object0).second;
        Integer integer0 = (Integer)this.j.get(object1);
        int v = integer0 == null ? -1 : ((int)integer0);
        int v1 = this.g[v];
        this.h[v].i(object2, g0);
        g0.c += v1;
        g0.b = object0;
        return g0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final h j(int v, h h0, long v1) {
        int v2 = L7.t(v + 1, this.g);
        int v3 = this.g[v2];
        int v4 = this.f[v2];
        this.h[v2].j(v - v3, h0, v1);
        Pair pair0 = this.i[v2];
        if(!h.r.equals(h0.a)) {
            pair0 = Pair.create(pair0, h0.a);
        }
        h0.a = pair0;
        h0.o += v4;
        h0.p += v4;
        return h0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int l() {
        return this.d;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int m(int v, int v1, boolean z) {
        int[] arr_v = this.g;
        int v2 = L7.t(v + 1, arr_v);
        int v3 = arr_v[v2];
        i[] arr_i = this.h;
        int v4 = arr_i[v2].m(v - v3, (v1 == 2 ? 0 : v1), z);
        if(v4 != -1) {
            return v3 + v4;
        }
        int v5;
        for(v5 = this.r(v2, z); v5 != -1 && arr_i[v5].p(); v5 = this.r(v5, z)) {
        }
        if(v5 != -1) {
            int v6 = arr_v[v5];
            return arr_i[v5].n(z) + v6;
        }
        return v1 == 2 ? this.n(z) : -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int n(boolean z) {
        i[] arr_i;
        int v1;
        int v = this.b;
        if(v != 0) {
            if(z) {
                int[] arr_v = this.c.b;
                v1 = arr_v.length > 0 ? arr_v[arr_v.length - 1] : -1;
            }
            else {
                v1 = v - 1;
            }
            while(true) {
                arr_i = this.h;
                if(!arr_i[v1].p()) {
                    break;
                }
                v1 = this.r(v1, z);
                if(v1 != -1) {
                    continue;
                }
                return -1;
            }
            int v2 = this.g[v1];
            return arr_i[v1].n(z) + v2;
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final Object o(int v) {
        int v1 = L7.t(v + 1, this.f);
        Object object0 = this.h[v1].o(v - this.f[v1]);
        return Pair.create(this.i[v1], object0);
    }

    public final int q(int v, boolean z) {
        if(z) {
            int v1 = this.c.c[v] + 1;
            int[] arr_v = this.c.b;
            return v1 >= arr_v.length ? -1 : arr_v[v1];
        }
        return v >= this.b - 1 ? -1 : v + 1;
    }

    public final int r(int v, boolean z) {
        if(z) {
            int v1 = this.c.c[v] - 1;
            return v1 < 0 ? -1 : this.c.b[v1];
        }
        return v <= 0 ? -1 : v - 1;
    }
}

