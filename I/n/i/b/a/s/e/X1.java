package i.n.i.b.a.s.e;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import k8.Y;

public final class x1 extends q2 {
    public final bb g;
    public final long h;
    public final long i;
    public final long j;
    public final float k;
    public final float l;
    public final h9 m;
    public final E4 n;
    public final boolean o;
    public final int p;
    public float q;
    public int r;
    public int s;
    public long t;
    public C7 u;

    public x1(vc vc0, int[] arr_v, bb bb0, long v, long v1, long v2, float f, float f1, h9 h90, E4 e40, boolean z, int v3) {
        super(vc0, arr_v, 0);
        long v4;
        if(v2 < v) {
            Log.w("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            v4 = v;
        }
        else {
            v4 = v2;
        }
        this.g = bb0;
        this.h = v * 1000L;
        this.i = v1 * 1000L;
        this.j = v4 * 1000L;
        this.k = f;
        this.l = f1;
        this.m = h9.q(h90);
        this.n = e40;
        this.q = 1.0f;
        this.o = z;
        this.p = v3;
        this.s = 0;
        this.t = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final int a(long v, List list0) {
        this.n.getClass();
        long v1 = SystemClock.elapsedRealtime();
        if(this.t != 0x8000000000000001L && v1 - this.t < 1000L && (list0.isEmpty() || ((C7)M7.A(list0)).equals(this.u))) {
            return list0.size();
        }
        this.t = v1;
        this.u = list0.isEmpty() ? null : ((C7)M7.A(list0));
        if(list0.isEmpty()) {
            return 0;
        }
        if(this.o) {
            return list0.size();
        }
        int v3 = list0.size();
        long v4 = L7.z(((C7)list0.get(v3 - 1)).g - v, this.q);
        long v5 = this.j;
        if(v4 >= v5) {
            x1.o(list0);
            u u0 = this.d[this.n(v1, false)];
            for(int v2 = 0; v2 < v3; ++v2) {
                C7 c70 = (C7)list0.get(v2);
                if(L7.z(c70.g - v, this.q) >= v5 && c70.d.h < u0.h && (c70.d.B != -1 && c70.d.B < 720 && (c70.d.w != -1 && c70.d.w < 0x500 && c70.d.B < u0.B))) {
                    return v2;
                }
            }
        }
        return v3;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final void c(float f) {
        this.q = f;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final void d(long v, long v1, long v2, List list0, c8[] arr_c8, int v3) {
        int v15;
        boolean z1;
        boolean z;
        int v12;
        if(this.o) {
            return;
        }
        this.n.getClass();
        long v4 = SystemClock.elapsedRealtime();
        if(this.r >= arr_c8.length || !arr_c8[this.r].next()) {
            for(int v5 = 0; true; ++v5) {
                if(v5 >= arr_c8.length) {
                    x1.o(list0);
                    break;
                }
                c8 c81 = arr_c8[v5];
                if(c81.next()) {
                    c81.a();
                    c81.b();
                    break;
                }
            }
        }
        else {
            c8 c80 = arr_c8[this.r];
            c80.a();
            c80.b();
        }
        int v6 = this.s;
        if(v6 == 0) {
            this.s = 1;
            this.r = this.n(v4, true);
            return;
        }
        int v7 = this.r;
        int v8 = list0.isEmpty() ? -1 : this.b(((C7)M7.A(list0)).d);
        if(v8 != -1) {
            v6 = ((C7)M7.A(list0)).e;
            v7 = v8;
        }
        int v9 = this.n(v4, v3 == 0);
        if(this.g(v7, v4)) {
            v15 = v9;
        }
        else {
            u u0 = this.d[v7];
            u u1 = this.d[v9];
            if(u1.h > u0.h) {
                int v10 = Long.compare(v2, 0x8000000000000001L);
                if(v1 < (v10 == 0 || v2 > this.h ? this.h : ((long)(((float)v2) * this.l)))) {
                    long v11 = 0L;
                    for(Object object0: list0) {
                        v11 += ((C7)object0).h - ((C7)object0).g;
                    }
                    v12 = v9;
                    long v13 = list0.size() <= 0 ? 0x8000000000000001L : v11 / ((long)list0.size());
                    if(v10 == 0 || list0.size() < 2) {
                        z1 = false;
                    }
                    else {
                        if(v13 == 0x8000000000000001L) {
                            z = false;
                        }
                        else {
                            long v14 = v2 - v1;
                            z = ((float)v14) < ((float)v13) * 1.5f;
                            StringBuilder stringBuilder0 = Y.o(v14, "remaining=", " average=");
                            stringBuilder0.append(v13);
                            Log.d("AdaptiveTrackSelection", stringBuilder0.toString());
                        }
                        z1 = z;
                    }
                    if(z1) {
                        v15 = u1.h >= u0.h || v1 < this.i ? v12 : v7;
                    }
                    else {
                        v15 = v7;
                    }
                }
                else {
                    v12 = v9;
                    v15 = u1.h >= u0.h || v1 < this.i ? v12 : v7;
                }
            }
            else {
                v12 = v9;
                v15 = u1.h >= u0.h || v1 < this.i ? v12 : v7;
            }
        }
        if(v15 != v7) {
            v6 = 3;
        }
        this.s = v6;
        this.r = v15;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final void e(u u0, int v) {
        for(int v2 = 0; true; ++v2) {
            u[] arr_u = this.d;
            int v3 = this.b;
            if(v2 >= v3) {
                break;
            }
            if(arr_u[v2].equals(u0)) {
                this.r = v2;
                this.s = v;
                return;
            }
        }
        if(u0.h != -1) {
            this.s = v;
            this.n.getClass();
            long v4 = SystemClock.elapsedRealtime();
            int v5 = 0;
            for(int v1 = 0; v1 < v3; ++v1) {
                if(!this.g(v1, v4)) {
                    if(arr_u[v1].h <= u0.h) {
                        this.r = v1;
                        return;
                    }
                    v5 = v1;
                }
            }
            this.r = v5;
        }
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final int i() {
        return this.s;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final int j() {
        return this.r;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final void k() {
        this.u = null;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final void l() {
        this.t = 0x8000000000000001L;
        this.u = null;
    }

    @Override  // i.n.i.b.a.s.e.q2
    public final Object m() {
        return null;
    }

    public final int n(long v, boolean z) {
        long v1 = (long)(((float)(((long)(((float)this.g.a()) * this.k)))) / this.q);
        h9 h90 = this.m;
        if(!h90.isEmpty()) {
            int v2;
            for(v2 = 1; v2 < h90.size() - 1 && ((v1)h90.get(v2)).a < v1; ++v2) {
            }
            v1 v10 = (v1)h90.get(v2 - 1);
            v1 v11 = (v1)h90.get(v2);
            v1 = ((long)(((float)(v1 - v10.a)) / ((float)(v11.a - v10.a)) * ((float)(v11.b - v10.b)))) + v10.b;
        }
        u[] arr_u = this.d;
        int v3 = this.b;
        int v4 = 0;
        if(z) {
            int v5 = this.p;
            if(v5 != -1) {
                int v6 = 0;
                while(v4 < v3) {
                    int v7 = arr_u[v4].h;
                    if(v7 != -1 && v5 < v7) {
                        v6 = v4;
                    }
                    ++v4;
                }
                return v6;
            }
        }
        int v8 = 0;
        while(v4 < v3) {
            if(v == 0x8000000000000000L || !this.g(v4, v)) {
                if(((long)arr_u[v4].h) <= v1) {
                    return v4;
                }
                v8 = v4;
            }
            ++v4;
        }
        return v8;
    }

    public static long o(List list0) {
        if(!list0.isEmpty()) {
            C7 c70 = (C7)M7.A(list0);
            long v = c70.g;
            if(v != 0x8000000000000001L) {
                return c70.h == 0x8000000000000001L ? 0x8000000000000001L : c70.h - v;
            }
        }
        return 0x8000000000000001L;
    }

    public static void p(ArrayList arrayList0, long[] arr_v) {
        long v = 0L;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            v += arr_v[v2];
        }
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            c9 c90 = (c9)arrayList0.get(v1);
            if(c90 != null) {
                c90.b(new v1(v, arr_v[v1]));
            }
        }
    }
}

