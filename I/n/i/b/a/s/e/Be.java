package i.n.i.b.a.s.e;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import x9.c;

public final class be implements bb, g0 {
    public final ab a;
    public final o7 b;
    public Md c;
    public int d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public final ArrayList k;

    public be(long v) {
        this.b = new o7();
        this.a = new ab(0);
        this.i = v;
        this.k = new ArrayList();
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final long a() {
        synchronized(this) {
        }
        return this.i;
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void a(W2 w20, boolean z) {
        synchronized(this) {
            if(z) {
                M7.J(this.d > 0);
                long v = SystemClock.elapsedRealtime();
                int v1 = (int)(v - this.e);
                this.g += (long)v1;
                long v2 = this.f;
                this.h += v2;
                if(v1 > 0) {
                    ae ae0 = new ae(v2, ((long)v1), v);
                    this.b.b(((int)Math.sqrt(v2)), ((float)v2) * 8000.0f / ((float)v1), ae0);
                    if(this.g >= 2000L || this.h >= 0x32000L) {
                        this.i = (long)this.b.a();
                        this.k.clear();
                        ArrayList arrayList0 = this.b.c();
                        this.k.addAll(arrayList0);
                        if(this.c != null) {
                            this.d(this.k);
                        }
                    }
                }
                long v3 = this.f;
                long v4 = this.i;
                if(v1 != 0 || v3 != 0L || v4 != this.j) {
                    this.j = v4;
                    this.a.a(v1, v3, v4);
                }
                int v5 = this.d - 1;
                this.d = v5;
                if(v5 > 0) {
                    this.e = v;
                }
                this.f = 0L;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final g0 b() {
        return this;
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void b(W2 w20, boolean z) {
        synchronized(this) {
            if(!z) {
                return;
            }
            if(this.d == 0) {
                this.e = SystemClock.elapsedRealtime();
            }
            ++this.d;
        }
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void c(W2 w20, boolean z, int v) {
        synchronized(this) {
            if(!z) {
                return;
            }
            this.f += (long)v;
        }
    }

    public final long d(ArrayList arrayList0) {
        try {
            E4[] arr_e4 = new E4[arrayList0.size()];
            for(int v = 0; v < arrayList0.size(); ++v) {
                ae ae0 = (ae)arrayList0.get(v);
                arr_e4[v] = new E4(ae0.a, ae0.b, ae0.c);
            }
            ((c)this.c).getClass();
            Log.d("PluginBandwidthMeter", "Not enough samples, or user does not estimate: " + arrayList0.size());
        }
        catch(Id id0) {
            M7.M(id0, "PluginBandwidthMeter", "Bitrate estimation has been failed: " + id0);
            this.c.getClass();
        }
        return -1L;
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final void h(S1 s10) {
        this.a.b(s10);
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final void p(Handler handler0, S1 s10) {
        s10.getClass();
        this.a.getClass();
        this.a.b(s10);
        Za za0 = new Za(handler0, s10);
        this.a.a.add(za0);
    }
}

