package androidx.media3.exoplayer;

import e3.b;
import e3.x;
import java.util.HashMap;
import w3.d;

public final class j {
    public final d a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final long g;
    public final HashMap h;
    public long i;

    public j() {
        d d0 = new d();
        super();
        j.a(2500, 0, "bufferForPlaybackMs", "0");
        j.a(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        j.a(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        j.a(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        j.a(50000, 50000, "maxBufferMs", "minBufferMs");
        j.a(0, 0, "backBufferDurationMs", "0");
        this.a = d0;
        this.b = x.M(50000L);
        this.c = x.M(50000L);
        this.d = x.M(2500L);
        this.e = x.M(5000L);
        this.f = -1;
        this.g = x.M(0L);
        this.h = new HashMap();
        this.i = -1L;
    }

    public static void a(int v, int v1, String s, String s1) {
        b.d(v >= v1, s + " cannot be less than " + s1);
    }

    public final int b() {
        int v = 0;
        for(Object object0: this.h.values()) {
            v += ((i)object0).b;
        }
        return v;
    }

    public final boolean c(I i0) {
        long v = this.c;
        i i1 = (i)this.h.get(i0.a);
        i1.getClass();
        synchronized(this.a) {
        }
        int v1 = this.a.d * this.a.b < this.b() ? 0 : 1;
        long v2 = this.b;
        float f = i0.c;
        if(f > 1.0f) {
            v2 = Math.min(x.x(v2, f), v);
        }
        long v3 = i0.b;
        if(v3 < Math.max(v2, 500000L)) {
            i1.a = v1 ^ 1;
            if(v1 != 0 && v3 < 500000L) {
                b.D("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
                return i1.a;
            }
        }
        else if(v3 >= v || v1 != 0) {
            i1.a = false;
        }
        return i1.a;
    }

    public final void d() {
        if(this.h.isEmpty()) {
            d d0 = this.a;
            synchronized(d0) {
                if(d0.a) {
                    d0.a(0);
                }
            }
            return;
        }
        int v1 = this.b();
        this.a.a(v1);
    }
}

