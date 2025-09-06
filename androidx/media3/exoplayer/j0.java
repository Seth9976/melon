package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import e3.r;
import e3.x;
import i.n.i.b.a.s.e.E4;
import i.n.i.b.a.s.e.S9;
import i.n.i.b.a.s.e.Z8;
import i.n.i.b.a.s.e.b4;
import i.n.i.b.a.s.e.x6;

public final class j0 implements L, S9 {
    public boolean a;
    public long b;
    public long c;
    public Object d;
    public Object e;

    public j0(long v, int v1) {
        this.b = v;
        this.c = v + ((long)v1);
    }

    public j0(Runnable runnable0) {
        this.d = new Handler(Looper.getMainLooper());
        this.e = runnable0;
    }

    @Override  // androidx.media3.exoplayer.L
    public void a(b3.L l0) {
        if(this.a) {
            this.h(this.getPositionUs());
        }
        this.e = l0;
    }

    public int c(long v) {
        return ((int)(v - this.b)) + ((Z8)this.d).b;
    }

    public void d(long v) {
        this.b = v;
        if(this.a) {
            ((E4)this.d).getClass();
            this.c = SystemClock.elapsedRealtime();
        }
    }

    @Override  // i.n.i.b.a.s.e.S9
    public x6 e() {
        return (x6)this.e;
    }

    @Override  // i.n.i.b.a.s.e.S9
    public void e(x6 x60) {
        if(this.a) {
            this.d(this.t());
        }
        this.e = x60;
    }

    public void f() {
        if(!this.a) {
            ((E4)this.d).getClass();
            this.c = SystemClock.elapsedRealtime();
            this.a = true;
        }
    }

    public void g(long v, boolean z) {
        if(z) {
            long v1 = this.c;
            if(v1 - v < 30000L) {
                this.b = Math.max(this.b, v + 30000L - v1);
                this.a = true;
            }
        }
    }

    @Override  // androidx.media3.exoplayer.L
    public b3.L getPlaybackParameters() {
        return (b3.L)this.e;
    }

    @Override  // androidx.media3.exoplayer.L
    public long getPositionUs() {
        long v = this.b;
        if(this.a) {
            ((r)this.d).getClass();
            long v1 = SystemClock.elapsedRealtime() - this.c;
            b3.L l0 = (b3.L)this.e;
            return l0.a == 1.0f ? x.M(v1) + v : v1 * ((long)l0.c) + v;
        }
        return v;
    }

    public void h(long v) {
        this.b = v;
        if(this.a) {
            ((r)this.d).getClass();
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public void i() {
        if(!this.a) {
            ((r)this.d).getClass();
            this.c = SystemClock.elapsedRealtime();
            this.a = true;
        }
    }

    @Override  // i.n.i.b.a.s.e.S9
    public long t() {
        long v = this.b;
        if(this.a) {
            ((E4)this.d).getClass();
            long v1 = SystemClock.elapsedRealtime() - this.c;
            x6 x60 = (x6)this.e;
            return x60.a == 1.0f ? b4.a(v1) + v : v1 * ((long)x60.c) + v;
        }
        return v;
    }
}

