package androidx.media3.exoplayer;

import android.os.SystemClock;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.Rd;
import i.n.i.b.a.s.e.b4;
import i.n.i.b.a.s.e.c;

public final class h implements Rd {
    public final long a;
    public final long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public float i;
    public float j;
    public float k;
    public long l;
    public long m;
    public long n;

    public h(long v, long v1) {
        this.a = v;
        this.b = v1;
        this.c = 0x8000000000000001L;
        this.d = 0x8000000000000001L;
        this.f = 0x8000000000000001L;
        this.g = 0x8000000000000001L;
        this.j = 0.97f;
        this.i = 1.03f;
        this.k = 1.0f;
        this.l = 0x8000000000000001L;
        this.e = 0x8000000000000001L;
        this.h = 0x8000000000000001L;
        this.m = 0x8000000000000001L;
        this.n = 0x8000000000000001L;
        super();
    }

    @Override  // i.n.i.b.a.s.e.Rd
    public void a() {
        long v = this.h;
        if(v == 0x8000000000000001L) {
            return;
        }
        long v1 = v + this.b;
        this.h = v1;
        long v2 = this.g;
        if(v2 != 0x8000000000000001L && v1 > v2) {
            this.h = v2;
        }
        this.l = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.Rd
    public void a(long v) {
        this.d = v;
        this.c();
    }

    @Override  // i.n.i.b.a.s.e.Rd
    public long b() {
        return this.h;
    }

    public void c() {
        long v = this.c;
        if(v == 0x8000000000000001L) {
            v = 0x8000000000000001L;
        }
        else {
            long v1 = this.d;
            if(v1 != 0x8000000000000001L) {
                v = v1;
            }
            long v2 = this.f;
            if(v2 != 0x8000000000000001L && v < v2) {
                v = v2;
            }
            long v3 = this.g;
            if(v3 != 0x8000000000000001L && v > v3) {
                v = v3;
            }
        }
        if(this.e == v) {
            return;
        }
        this.e = v;
        this.h = v;
        this.m = 0x8000000000000001L;
        this.n = 0x8000000000000001L;
        this.l = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.Rd
    public float d(long v, long v1) {
        if(Long.compare(this.c, 0x8000000000000001L) == 0) {
            return 1.0f;
        }
        long v2 = v - v1;
        long v3 = this.m;
        if(v3 == 0x8000000000000001L) {
            this.m = v2;
            this.n = 0L;
        }
        else {
            long v4 = Math.max(v2, ((long)(((float)v2) * 0.001f + ((float)v3) * 0.999f)));
            this.m = v4;
            this.n = (long)(0.001f * ((float)Math.abs(v2 - v4)) + 0.999f * ((float)this.n));
        }
        if(Long.compare(this.l, 0x8000000000000001L) != 0 && SystemClock.elapsedRealtime() - this.l < 1000L) {
            return this.k;
        }
        this.l = SystemClock.elapsedRealtime();
        long v5 = this.n * 3L + this.m;
        if(Long.compare(this.h, v5) > 0) {
            long[] arr_v = {v5, this.e, this.h - (((long)((this.k - 1.0f) * 1000000.0f)) + ((long)((this.i - 1.0f) * 1000000.0f)))};
            long v6 = arr_v[0];
            for(int v7 = 1; v7 < 3; ++v7) {
                long v8 = arr_v[v7];
                if(v8 > v6) {
                    v6 = v8;
                }
            }
            this.h = v6;
        }
        else {
            long v9 = L7.A(v - ((long)(Math.max(0.0f, this.k - 1.0f) / 1.000000E-07f)), this.h, v5);
            this.h = v9;
            long v10 = this.g;
            if(v10 != 0x8000000000000001L && v9 > v10) {
                this.h = v10;
            }
        }
        long v11 = v - this.h;
        if(Math.abs(v11) < this.a) {
            this.k = 1.0f;
            return 1.0f;
        }
        this.k = L7.a(1.000000E-07f * ((float)v11) + 1.0f, this.j, this.i);
        return this.k;
    }

    public void e() {
        long v1;
        long v = this.c;
        if(v == 0x8000000000000001L) {
            v1 = 0x8000000000000001L;
        }
        else {
            v1 = this.d;
            if(v1 == 0x8000000000000001L) {
                long v2 = this.f;
                if(v2 != 0x8000000000000001L && v < v2) {
                    v = v2;
                }
                v1 = this.g;
                if(v1 == 0x8000000000000001L || v <= v1) {
                    v1 = v;
                }
            }
        }
        if(this.e == v1) {
            return;
        }
        this.e = v1;
        this.h = v1;
        this.m = 0x8000000000000001L;
        this.n = 0x8000000000000001L;
        this.l = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.Rd
    public void o(c c0) {
        this.c = b4.a(c0.a);
        this.f = b4.a(c0.b);
        this.g = b4.a(c0.c);
        this.j = c0.d == -3.402823E+38f ? 0.97f : c0.d;
        this.i = c0.e == -3.402823E+38f ? 1.03f : c0.e;
        this.c();
    }
}

