package i.n.i.b.a.s.e;

import android.util.Log;

public final class o5 implements me {
    public final L3 a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final long g;
    public int h;
    public boolean i;

    public o5() {
        L3 l30 = new L3();
        super();
        o5.d(2500, 0, "bufferForPlaybackMs", "0");
        o5.d(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        o5.d(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        o5.d(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        o5.d(50000, 50000, "maxBufferMs", "minBufferMs");
        o5.d(0, 0, "backBufferDurationMs", "0");
        this.a = l30;
        this.b = 50000000L;
        this.c = 50000000L;
        this.d = 2500000L;
        this.e = 5000000L;
        this.f = -1;
        this.h = 0xC80000;
        this.g = 0L;
    }

    @Override  // i.n.i.b.a.s.e.me
    public final boolean a(int v, long v1, float f) {
        int v2 = this.a.d() < this.h ? 0 : 1;
        long v3 = this.c;
        if(v1 < Math.max((Float.compare(f, 1.0f) <= 0 ? this.b : Math.min(L7.i(this.b, f), v3)), 500000L)) {
            this.i = v2 ^ 1;
            if(v2 != 0 && v1 < 500000L) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
                return this.i;
            }
        }
        else if(v1 >= v3 || v2 != 0) {
            this.i = false;
        }
        return this.i;
    }

    @Override  // i.n.i.b.a.s.e.me
    public final void b() {
        this.e(false);
    }

    @Override  // i.n.i.b.a.s.e.me
    public final void b(d2[] arr_d2, q2[] arr_q2) {
        int v = this.f;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; true; ++v1) {
                int v3 = 0xC80000;
                if(v1 >= arr_d2.length) {
                    break;
                }
                if(arr_q2[v1] != null) {
                    switch(arr_d2[v1].a) {
                        case 0: {
                            v3 = 0x89A0000;
                            break;
                        }
                        case 1: {
                            break;
                        }
                        case 2: {
                            v3 = 0x7D00000;
                            break;
                        }
                        case 3: 
                        case 5: 
                        case 6: {
                            v3 = 0x20000;
                            break;
                        }
                        case 7: {
                            v3 = 0;
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException();
                        }
                    }
                    v2 += v3;
                }
            }
            v = Math.max(0xC80000, v2);
        }
        this.h = v;
        this.a.a(v);
    }

    @Override  // i.n.i.b.a.s.e.me
    public final boolean c() {
        return false;
    }

    @Override  // i.n.i.b.a.s.e.me
    public final boolean c(long v, float f, boolean z, long v1) {
        long v2 = L7.z(v, f);
        long v3 = z ? this.e : this.d;
        if(v1 != 0x8000000000000001L) {
            v3 = Math.min(v1 / 2L, v3);
        }
        return v3 <= 0L || v2 >= v3 || this.a.d() >= this.h;
    }

    public static void d(int v, int v1, String s, String s1) {
        M7.s((s + " cannot be less than " + s1), v >= v1);
    }

    @Override  // i.n.i.b.a.s.e.me
    public final L3 d() {
        return this.a;
    }

    @Override  // i.n.i.b.a.s.e.me
    public final void e() {
        this.e(true);
    }

    public final void e(boolean z) {
        this.h = this.f == -1 ? 0xC80000 : this.f;
        this.i = false;
        if(z) {
            L3 l30 = this.a;
            synchronized(l30) {
                if(l30.a) {
                    l30.a(0);
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.me
    public final long f() {
        return this.g;
    }

    @Override  // i.n.i.b.a.s.e.me
    public final void g() {
        this.e(true);
    }
}

