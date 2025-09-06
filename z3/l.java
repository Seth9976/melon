package z3;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;
import e3.r;
import e3.x;
import i.n.i.b.a.s.e.Ae;
import i.n.i.b.a.s.e.s2;
import i.n.i.b.a.s.e.ze;
import s3.V;

public final class l {
    public final b a;
    public final VideoFrameReleaseHelper b;
    public final long c;
    public boolean d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public float k;
    public r l;

    public l(Context context0, b b0, long v) {
        this.a = b0;
        this.c = v;
        this.b = new VideoFrameReleaseHelper(context0);
        this.e = 0;
        this.f = 0x8000000000000001L;
        this.h = 0x8000000000000001L;
        this.i = 0x8000000000000001L;
        this.k = 1.0f;
        this.l = r.a;
    }

    public final int a(long v, long v1, long v2, long v3, boolean z, k k0) {
        boolean z3;
        long v16;
        long v11;
        boolean z1;
        k0.a = 0x8000000000000001L;
        k0.b = 0x8000000000000001L;
        if(this.f == 0x8000000000000001L) {
            this.f = v1;
        }
        if(Long.compare(this.h, v) != 0) {
            VideoFrameReleaseHelper videoFrameReleaseHelper0 = this.b;
            long v4 = videoFrameReleaseHelper0.n;
            if(v4 != -1L) {
                videoFrameReleaseHelper0.p = v4;
                videoFrameReleaseHelper0.q = videoFrameReleaseHelper0.o;
            }
            ++videoFrameReleaseHelper0.m;
            Ae ae0 = videoFrameReleaseHelper0.a;
            ((ze)ae0.d).e(v * 1000L);
            if(((ze)ae0.d).d()) {
                ae0.a = false;
            }
            else if(ae0.b != 0x8000000000000001L) {
                if(ae0.a) {
                    long v5 = ((ze)ae0.e).d;
                    if((v5 == 0L ? false : ((ze)ae0.e).g[((int)((v5 - 1L) % 15L))])) {
                        ((ze)ae0.e).f();
                        ((ze)ae0.e).e(ae0.b);
                    }
                }
                else {
                    ((ze)ae0.e).f();
                    ((ze)ae0.e).e(ae0.b);
                }
                ae0.a = true;
                ((ze)ae0.e).e(v * 1000L);
            }
            if(ae0.a && ((ze)ae0.e).d()) {
                ze ze0 = (ze)ae0.d;
                ae0.d = (ze)ae0.e;
                ae0.e = ze0;
                ae0.a = false;
            }
            ae0.b = v * 1000L;
            ae0.c = ((ze)ae0.d).d() ? 0 : ae0.c + 1;
            videoFrameReleaseHelper0.c();
            this.h = v;
        }
        long v6 = (long)(((double)(v - v1)) / ((double)this.k));
        if(this.d) {
            this.l.getClass();
            v6 -= x.M(SystemClock.elapsedRealtime()) - v2;
        }
        k0.a = v6;
        if(Long.compare(this.i, 0x8000000000000001L) == 0 || this.j) {
            switch(this.e) {
                case 0: {
                    z1 = this.d;
                    break;
                }
                case 1: {
                    z1 = true;
                    break;
                }
                case 2: {
                    z1 = v1 >= v3;
                    break;
                }
                case 3: {
                    this.l.getClass();
                    long v7 = x.M(SystemClock.elapsedRealtime()) - this.g;
                    z1 = !this.d || v6 >= -30000L || v7 <= 100000L ? false : true;
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        else {
            z1 = false;
        }
        if(z1) {
            return 0;
        }
        if(this.d && v1 != this.f) {
            this.l.getClass();
            long v8 = System.nanoTime();
            VideoFrameReleaseHelper videoFrameReleaseHelper1 = this.b;
            long v9 = k0.a * 1000L + v8;
            if(videoFrameReleaseHelper1.p != -1L && ((ze)videoFrameReleaseHelper1.a.d).d()) {
                Ae ae1 = videoFrameReleaseHelper1.a;
                if(((ze)ae1.d).d()) {
                    ze ze1 = (ze)ae1.d;
                    long v10 = ze1.e;
                    v11 = Long.compare(v10, 0L) == 0 ? 0L : ze1.f / v10;
                }
                else {
                    v11 = 0x8000000000000001L;
                }
                long v12 = videoFrameReleaseHelper1.q + ((long)(((float)((videoFrameReleaseHelper1.m - videoFrameReleaseHelper1.p) * v11)) / videoFrameReleaseHelper1.i));
                if(Math.abs(v9 - v12) <= 20000000L) {
                    v9 = v12;
                }
                else {
                    videoFrameReleaseHelper1.m = 0L;
                    videoFrameReleaseHelper1.p = -1L;
                    videoFrameReleaseHelper1.n = -1L;
                }
            }
            videoFrameReleaseHelper1.n = videoFrameReleaseHelper1.m;
            videoFrameReleaseHelper1.o = v9;
            m m0 = videoFrameReleaseHelper1.c;
            if(m0 != null && videoFrameReleaseHelper1.k != 0x8000000000000001L) {
                long v13 = m0.a;
                if(v13 != 0x8000000000000001L) {
                    long v14 = videoFrameReleaseHelper1.k;
                    long v15 = (v9 - v13) / v14 * v14 + v13;
                    if(v9 <= v15) {
                        v16 = v15 - v14;
                    }
                    else {
                        v16 = v15;
                        v15 = v14 + v15;
                    }
                    if(v15 - v9 >= v9 - v16) {
                        v15 = v16;
                    }
                    v9 = v15 - videoFrameReleaseHelper1.l;
                }
            }
            k0.b = v9;
            long v17 = (v9 - v8) / 1000L;
            k0.a = v17;
            boolean z2 = this.i != 0x8000000000000001L && !this.j;
            b b0 = this.a;
            if(v17 >= -500000L || z) {
                z3 = false;
            }
            else {
                V v18 = b0.i;
                v18.getClass();
                int v19 = v18.skipData(v1 - b0.k);
                if(v19 == 0) {
                    z3 = false;
                }
                else {
                    if(z2) {
                        b0.T0.d += v19;
                        b0.T0.f += b0.u1;
                    }
                    else {
                        ++b0.T0.j;
                        b0.E0(v19, b0.u1);
                    }
                    if(b0.I()) {
                        b0.S();
                    }
                    d d0 = b0.i1;
                    if(d0 != null) {
                        d0.a(false);
                    }
                    z3 = true;
                }
            }
            if(z3) {
                return 4;
            }
            long v20 = k0.a;
            if(v20 < -30000L && !z) {
                return z2 ? 3 : 2;
            }
            return v20 > 50000L ? 5 : 1;
        }
        return 5;
    }

    public final boolean b(boolean z) {
        if(z && this.e == 3) {
            this.i = 0x8000000000000001L;
            return true;
        }
        if(Long.compare(this.i, 0x8000000000000001L) == 0) {
            return false;
        }
        this.l.getClass();
        if(SystemClock.elapsedRealtime() < this.i) {
            return true;
        }
        this.i = 0x8000000000000001L;
        return false;
    }

    public final void c(boolean z) {
        long v1;
        this.j = z;
        long v = this.c;
        if(v > 0L) {
            this.l.getClass();
            v1 = SystemClock.elapsedRealtime() + v;
        }
        else {
            v1 = 0x8000000000000001L;
        }
        this.i = v1;
    }

    public final void d(int v) {
        this.e = Math.min(this.e, v);
    }

    public final void e() {
        this.d = true;
        this.l.getClass();
        this.g = x.M(SystemClock.elapsedRealtime());
        VideoFrameReleaseHelper videoFrameReleaseHelper0 = this.b;
        videoFrameReleaseHelper0.d = true;
        videoFrameReleaseHelper0.m = 0L;
        videoFrameReleaseHelper0.p = -1L;
        videoFrameReleaseHelper0.n = -1L;
        s2 s20 = videoFrameReleaseHelper0.b;
        if(s20 != null) {
            videoFrameReleaseHelper0.c.getClass();
            videoFrameReleaseHelper0.c.b.sendEmptyMessage(2);
            Handler handler0 = x.l(null);
            s20.b.registerDisplayListener(s20, handler0);
            Display display0 = s20.b.getDisplay(0);
            VideoFrameReleaseHelper.a(((VideoFrameReleaseHelper)s20.c), display0);
        }
        videoFrameReleaseHelper0.d(false);
    }

    public final void f() {
        this.d = false;
        this.i = 0x8000000000000001L;
        VideoFrameReleaseHelper videoFrameReleaseHelper0 = this.b;
        videoFrameReleaseHelper0.d = false;
        s2 s20 = videoFrameReleaseHelper0.b;
        if(s20 != null) {
            s20.b.unregisterDisplayListener(s20);
            videoFrameReleaseHelper0.c.getClass();
            videoFrameReleaseHelper0.c.b.sendEmptyMessage(3);
        }
        videoFrameReleaseHelper0.b();
    }

    public final void g(float f) {
        this.b.f = f;
        ((ze)this.b.a.d).f();
        ((ze)this.b.a.e).f();
        this.b.a.a = false;
        this.b.a.b = 0x8000000000000001L;
        this.b.a.c = 0;
        this.b.c();
    }

    public final void h(float f) {
        e3.b.c(Float.compare(f, 0.0f) > 0);
        if(f == this.k) {
            return;
        }
        this.k = f;
        this.b.i = f;
        this.b.m = 0L;
        this.b.p = -1L;
        this.b.n = -1L;
        this.b.d(false);
    }
}

