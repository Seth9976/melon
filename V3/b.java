package v3;

import I6.Q;
import I6.V;
import I6.w;
import android.os.SystemClock;
import b3.q0;
import e3.r;
import e3.x;
import java.util.ArrayList;
import java.util.List;
import w3.f;

public final class b extends c {
    public final w3.c g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final V o;
    public final r p;
    public float q;
    public int r;
    public int s;
    public long t;
    public t3.b u;

    public b(q0 q00, int[] arr_v, w3.c c0, long v, long v1, long v2, V v3) {
        super(q00, arr_v);
        if(v2 < v) {
            e3.b.D("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            v2 = v;
        }
        this.g = c0;
        this.h = v * 1000L;
        this.i = v1 * 1000L;
        this.j = v2 * 1000L;
        this.k = 0x4FF;
        this.l = 0x2CF;
        this.m = 0.7f;
        this.n = 0.75f;
        this.o = V.p(v3);
        this.p = r.a;
        this.q = 1.0f;
        this.s = 0;
        this.t = 0x8000000000000001L;
    }

    @Override  // v3.o
    public final void d(long v, long v1, long v2, List list0, t3.c[] arr_c) {
        long v5;
        this.p.getClass();
        long v3 = SystemClock.elapsedRealtime();
        int v4 = 0;
        if(this.r >= arr_c.length || !arr_c[this.r].next()) {
            for(int v6 = 0; true; ++v6) {
                if(v6 >= arr_c.length) {
                    v5 = b.i(list0);
                    break;
                }
                t3.c c1 = arr_c[v6];
                if(c1.next()) {
                    v5 = c1.getChunkEndTimeUs() - c1.getChunkStartTimeUs();
                    break;
                }
            }
        }
        else {
            t3.c c0 = arr_c[this.r];
            v5 = c0.getChunkEndTimeUs() - c0.getChunkStartTimeUs();
        }
        int v7 = this.s;
        if(v7 == 0) {
            this.s = 1;
            this.r = this.h(v3);
            return;
        }
        int v8 = this.r;
        androidx.media3.common.b[] arr_b = this.d;
        if(!list0.isEmpty()) {
            androidx.media3.common.b b0 = ((t3.b)w.j(list0)).d;
            while(v4 < this.b) {
                if(arr_b[v4] == b0) {
                    goto label_31;
                }
                ++v4;
            }
        }
        v4 = -1;
    label_31:
        if(v4 != -1) {
            v7 = ((t3.b)w.j(list0)).e;
            v8 = v4;
        }
        int v9 = this.h(v3);
        if(v9 != v8 && !this.a(v8, v3)) {
            androidx.media3.common.b b1 = arr_b[v8];
            androidx.media3.common.b b2 = arr_b[v9];
            if(b2.j > b1.j && v1 < (Long.compare(v2, 0x8000000000000001L) == 0 ? this.h : Math.min(((long)(((float)(v5 == 0x8000000000000001L ? v2 : v2 - v5)) * this.n)), this.h)) || b2.j < b1.j && v1 >= this.i) {
                v9 = v8;
            }
        }
        if(v9 != v8) {
            v7 = 3;
        }
        this.s = v7;
        this.r = v9;
    }

    @Override  // v3.c
    public final void disable() {
        this.u = null;
    }

    @Override  // v3.c
    public final void enable() {
        this.t = 0x8000000000000001L;
        this.u = null;
    }

    @Override  // v3.c
    public final int evaluateQueueSize(long v, List list0) {
        this.p.getClass();
        long v1 = SystemClock.elapsedRealtime();
        if(this.t != 0x8000000000000001L && v1 - this.t < 1000L && (list0.isEmpty() || ((t3.b)w.j(list0)).equals(this.u))) {
            return list0.size();
        }
        this.t = v1;
        this.u = list0.isEmpty() ? null : ((t3.b)w.j(list0));
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = list0.size();
        long v4 = x.B(((t3.b)list0.get(v3 - 1)).g - v, this.q);
        long v5 = this.j;
        if(v4 >= v5) {
            b.i(list0);
            androidx.media3.common.b b0 = this.d[this.h(v1)];
            for(int v2 = 0; v2 < v3; ++v2) {
                t3.b b1 = (t3.b)list0.get(v2);
                if(x.B(b1.g - v, this.q) >= v5 && b1.d.j < b0.j && (b1.d.v != -1 && b1.d.v <= this.l && (b1.d.u != -1 && b1.d.u <= this.k && b1.d.v < b0.v))) {
                    return v2;
                }
            }
        }
        return v3;
    }

    public static void g(ArrayList arrayList0, long[] arr_v) {
        long v = 0L;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            v += arr_v[v2];
        }
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            Q q0 = (Q)arrayList0.get(v1);
            if(q0 != null) {
                q0.a(new a(v, arr_v[v1]));
            }
        }
    }

    @Override  // v3.o
    public final int getSelectedIndex() {
        return this.r;
    }

    @Override  // v3.o
    public final Object getSelectionData() {
        return null;
    }

    @Override  // v3.o
    public final int getSelectionReason() {
        return this.s;
    }

    public final int h(long v) {
        synchronized(((f)this.g)) {
        }
        long v1 = (long)(((float)((f)this.g).k) * this.m);
        this.g.getClass();
        long v2 = (long)(((float)v1) / this.q);
        if(!this.o.isEmpty()) {
            int v3;
            for(v3 = 1; v3 < this.o.size() - 1 && ((a)this.o.get(v3)).a < v2; ++v3) {
            }
            a a0 = (a)this.o.get(v3 - 1);
            a a1 = (a)this.o.get(v3);
            v2 = a0.b + ((long)(((float)(v2 - a0.a)) / ((float)(a1.a - a0.a)) * ((float)(a1.b - a0.b))));
        }
        int v5 = 0;
        for(int v4 = 0; v4 < this.b; ++v4) {
            if(v == 0x8000000000000000L || !this.a(v4, v)) {
                if(((long)this.d[v4].j) <= v2) {
                    return v4;
                }
                v5 = v4;
            }
        }
        return v5;
    }

    public static long i(List list0) {
        if(!list0.isEmpty()) {
            t3.b b0 = (t3.b)w.j(list0);
            long v = b0.g;
            if(v != 0x8000000000000001L) {
                return b0.h == 0x8000000000000001L ? 0x8000000000000001L : b0.h - v;
            }
        }
        return 0x8000000000000001L;
    }

    @Override  // v3.c
    public final void onPlaybackSpeed(float f) {
        this.q = f;
    }
}

