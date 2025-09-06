package androidx.media3.exoplayer;

import android.util.Pair;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.x;
import java.util.ArrayList;
import java.util.HashMap;
import s3.Y;

public final class g0 extends p0 {
    public final int e;
    public final Y f;
    public final int g;
    public final int h;
    public final int[] i;
    public final int[] j;
    public final p0[] k;
    public final Object[] l;
    public final HashMap m;
    public static final int n;

    public g0(ArrayList arrayList0, Y y0) {
        p0[] arr_p0 = new p0[arrayList0.size()];
        int v = 0;
        int v1 = 0;
        for(Object object0: arrayList0) {
            arr_p0[v1] = ((P)object0).a();
            ++v1;
        }
        Object[] arr_object = new Object[arrayList0.size()];
        for(Object object1: arrayList0) {
            arr_object[v] = ((P)object1).getUid();
            ++v;
        }
        this(arr_p0, arr_object, y0);
    }

    public g0(p0[] arr_p0, Object[] arr_object, Y y0) {
        this.f = y0;
        this.e = y0.b.length;
        this.k = arr_p0;
        this.i = new int[arr_p0.length];
        this.j = new int[arr_p0.length];
        this.l = arr_object;
        this.m = new HashMap();
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        for(int v3 = 0; v < arr_p0.length; ++v3) {
            p0 p00 = arr_p0[v];
            this.k[v3] = p00;
            this.j[v3] = v1;
            this.i[v3] = v2;
            v1 += p00.o();
            v2 += this.k[v3].h();
            this.m.put(arr_object[v3], v3);
            ++v;
        }
        this.g = v1;
        this.h = v2;
    }

    @Override  // b3.p0
    public final int a(boolean z) {
        p0[] arr_p0;
        int v = 0;
        if(this.e != 0) {
            if(z) {
                int[] arr_v = this.f.b;
                v = arr_v.length <= 0 ? -1 : arr_v[0];
            }
            while(true) {
                arr_p0 = this.k;
                if(!arr_p0[v].p()) {
                    break;
                }
                v = this.q(v, z);
                if(v != -1) {
                    continue;
                }
                return -1;
            }
            int v1 = this.j[v];
            return arr_p0[v].a(z) + v1;
        }
        return -1;
    }

    @Override  // b3.p0
    public final int b(Object object0) {
        if(object0 instanceof Pair) {
            Object object1 = ((Pair)object0).first;
            Object object2 = ((Pair)object0).second;
            Integer integer0 = (Integer)this.m.get(object1);
            int v = integer0 == null ? -1 : ((int)integer0);
            if(v != -1) {
                int v1 = this.k[v].b(object2);
                return v1 == -1 ? -1 : this.i[v] + v1;
            }
        }
        return -1;
    }

    @Override  // b3.p0
    public final int c(boolean z) {
        p0[] arr_p0;
        int v1;
        int v = this.e;
        if(v != 0) {
            if(z) {
                int[] arr_v = this.f.b;
                v1 = arr_v.length > 0 ? arr_v[arr_v.length - 1] : -1;
            }
            else {
                v1 = v - 1;
            }
            while(true) {
                arr_p0 = this.k;
                if(!arr_p0[v1].p()) {
                    break;
                }
                v1 = this.r(v1, z);
                if(v1 != -1) {
                    continue;
                }
                return -1;
            }
            int v2 = this.j[v1];
            return arr_p0[v1].c(z) + v2;
        }
        return -1;
    }

    @Override  // b3.p0
    public final int e(int v, int v1, boolean z) {
        int[] arr_v = this.j;
        int v2 = 0;
        int v3 = x.d(arr_v, v + 1, false, false);
        int v4 = arr_v[v3];
        p0[] arr_p0 = this.k;
        p0 p00 = arr_p0[v3];
        if(v1 != 2) {
            v2 = v1;
        }
        int v5 = p00.e(v - v4, v2, z);
        if(v5 != -1) {
            return v4 + v5;
        }
        int v6;
        for(v6 = this.q(v3, z); v6 != -1 && arr_p0[v6].p(); v6 = this.q(v6, z)) {
        }
        if(v6 != -1) {
            int v7 = arr_v[v6];
            return arr_p0[v6].a(z) + v7;
        }
        return v1 == 2 ? this.a(z) : -1;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        int v1 = x.d(this.i, v + 1, false, false);
        int v2 = this.j[v1];
        this.k[v1].f(v - this.i[v1], m00, z);
        m00.c += v2;
        if(z) {
            Object object0 = this.l[v1];
            Object object1 = m00.b;
            object1.getClass();
            m00.b = Pair.create(object0, object1);
        }
        return m00;
    }

    @Override  // b3.p0
    public final m0 g(Object object0, m0 m00) {
        Object object1 = ((Pair)object0).first;
        Object object2 = ((Pair)object0).second;
        Integer integer0 = (Integer)this.m.get(object1);
        int v = integer0 == null ? -1 : ((int)integer0);
        int v1 = this.j[v];
        this.k[v].g(object2, m00);
        m00.c += v1;
        m00.b = object0;
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return this.h;
    }

    @Override  // b3.p0
    public final int k(int v, int v1, boolean z) {
        int[] arr_v = this.j;
        int v2 = 0;
        int v3 = x.d(arr_v, v + 1, false, false);
        int v4 = arr_v[v3];
        p0[] arr_p0 = this.k;
        p0 p00 = arr_p0[v3];
        if(v1 != 2) {
            v2 = v1;
        }
        int v5 = p00.k(v - v4, v2, z);
        if(v5 != -1) {
            return v4 + v5;
        }
        int v6;
        for(v6 = this.r(v3, z); v6 != -1 && arr_p0[v6].p(); v6 = this.r(v6, z)) {
        }
        if(v6 != -1) {
            int v7 = arr_v[v6];
            return arr_p0[v6].c(z) + v7;
        }
        return v1 == 2 ? this.c(z) : -1;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        int v1 = x.d(this.i, v + 1, false, false);
        Object object0 = this.k[v1].l(v - this.i[v1]);
        return Pair.create(this.l[v1], object0);
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        int v2 = x.d(this.j, v + 1, false, false);
        int v3 = this.j[v2];
        int v4 = this.i[v2];
        this.k[v2].m(v - v3, o00, v1);
        Pair pair0 = this.l[v2];
        if(!o0.q.equals(o00.a)) {
            pair0 = Pair.create(pair0, o00.a);
        }
        o00.a = pair0;
        o00.n += v4;
        o00.o += v4;
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return this.g;
    }

    public final int q(int v, boolean z) {
        if(z) {
            int v1 = this.f.c[v] + 1;
            int[] arr_v = this.f.b;
            return v1 >= arr_v.length ? -1 : arr_v[v1];
        }
        return v >= this.e - 1 ? -1 : v + 1;
    }

    public final int r(int v, boolean z) {
        if(z) {
            int v1 = this.f.c[v] - 1;
            return v1 < 0 ? -1 : this.f.b[v1];
        }
        return v <= 0 ? -1 : v - 1;
    }
}

