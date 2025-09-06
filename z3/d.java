package z3;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.b;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;
import b3.i;
import b3.x0;
import b3.z0;
import e3.t;
import e3.u;
import e3.x;
import ea.a;
import i.n.i.b.a.s.e.u9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import o3.j;

public final class d {
    public final ArrayList a;
    public final k b;
    public b c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public p l;
    public Executor m;
    public final g n;

    public d(g g0, Context context0) {
        this.n = g0;
        x.I(context0);
        this.a = new ArrayList();
        this.b = new k();
        this.h = 0x8000000000000001L;
        this.l = p.a0;
        this.m = g.o;
    }

    public final void a(boolean z) {
        this.i = false;
        this.h = 0x8000000000000001L;
        g g0 = this.n;
        if(g0.n == 1) {
            ++g0.m;
            a a0 = g0.f;
            if(z) {
                ((l)a0.a).b.m = 0L;
                ((l)a0.a).b.p = -1L;
                ((l)a0.a).b.n = -1L;
                ((l)a0.a).h = 0x8000000000000001L;
                ((l)a0.a).f = 0x8000000000000001L;
                ((l)a0.a).d(1);
                ((l)a0.a).i = 0x8000000000000001L;
            }
            n n0 = (n)a0.b;
            u u0 = n0.d;
            boolean z1 = false;
            n0.f.b = 0;
            n0.f.c = 0;
            n0.j = 0x8000000000000001L;
            u u1 = n0.e;
            if(u1.k() > 0) {
                e3.b.c(u1.k() > 0);
                while(u1.k() > 1) {
                    u1.h();
                }
                Object object0 = u1.h();
                object0.getClass();
                u1.b(0L, ((Long)object0));
            }
            if(n0.g != null) {
                u0.d();
            }
            else if(u0.k() > 0) {
                if(u0.k() > 0) {
                    z1 = true;
                }
                e3.b.c(z1);
                while(u0.k() > 1) {
                    u0.h();
                }
                Object object1 = u0.h();
                object1.getClass();
                n0.g = (z0)object1;
            }
            t t0 = g0.k;
            e3.b.k(t0);
            t0.c(new u9(g0, 22));
        }
        this.k = 0x8000000000000001L;
    }

    public final boolean b(long v, boolean z, long v1, long v2, B7.b b0) {
        g g0 = this.n;
        e3.b.j(false);
        long v3 = v - this.f;
        try {
            if(g0.b.a(v3, v1, v2, this.d, z, this.b) == 4) {
                return false;
            }
        }
        catch(androidx.media3.exoplayer.l l0) {
            b b1 = this.c;
            e3.b.k(b1);
            throw new q(l0, b1);
        }
        if(v3 < this.g && !z) {
            ((z3.b)b0.c).D0(((j)b0.b), b0.a);
            return true;
        }
        this.f(v1, v2);
        if(this.j) {
            long v4 = this.k;
            if(v4 != 0x8000000000000001L) {
                if(g0.m != 0) {
                    return false;
                }
                long v5 = g0.c.j;
                if(v5 == 0x8000000000000001L || v5 < v4) {
                    return false;
                }
            }
            this.e();
            this.j = false;
            this.k = 0x8000000000000001L;
        }
        e3.b.k(null);
        throw null;
    }

    public final void c(b b0) {
        g g0 = this.n;
        e3.b.j(g0.n == 0);
        i i0 = b0.B;
        if(i0 != null) {
            i0.d();
        }
        Looper looper0 = Looper.myLooper();
        e3.b.k(looper0);
        g0.k = g0.g.a(looper0, null);
        try {
            g0.d.a();
            Pair pair0 = g0.l;
            if(pair0 != null) {
                Surface surface0 = (Surface)pair0.first;
                e3.q q0 = (e3.q)pair0.second;
            }
        }
        catch(x0 x00) {
            throw new q(x00, b0);
        }
        throw null;
    }

    public final void d(boolean z) {
        ((l)this.n.f.a).c(z);
    }

    public final void e() {
        if(this.c == null) {
            return;
        }
        new ArrayList(this.a);
        b b0 = this.c;
        b0.getClass();
        e3.b.k(null);
        i i0 = b0.B;
        if(i0 != null) {
            i0.d();
        }
        int v = b0.v;
        boolean z = false;
        e3.b.d(b0.u > 0, "width must be positive, but is: " + b0.u);
        if(v > 0) {
            z = true;
        }
        e3.b.d(z, "height must be positive, but is: " + v);
        throw null;
    }

    public final void f(long v, long v1) {
        try {
            g.a(this.n, v, v1);
        }
        catch(androidx.media3.exoplayer.l l0) {
            throw new q(l0, (this.c == null ? new b(new b3.n()) : this.c));
        }
    }

    public final void g(int v) {
        VideoFrameReleaseHelper videoFrameReleaseHelper0 = ((l)this.n.f.a).b;
        if(videoFrameReleaseHelper0.j != v) {
            videoFrameReleaseHelper0.j = v;
            videoFrameReleaseHelper0.d(true);
        }
    }

    public final void h(Surface surface0, e3.q q0) {
        g g0 = this.n;
        if(g0.l != null && ((Surface)g0.l.first).equals(surface0) && ((e3.q)g0.l.second).equals(q0)) {
            return;
        }
        g0.l = Pair.create(surface0, q0);
    }

    public final void i(float f) {
        ((l)this.n.f.a).h(f);
    }

    public final void j(long v, long v1, long v2, long v3) {
        this.d = v;
        this.e = v1;
        this.f = v2;
        this.g = v3;
    }

    public final void k(List list0) {
        ArrayList arrayList0 = this.a;
        if(arrayList0.equals(list0)) {
            return;
        }
        arrayList0.clear();
        arrayList0.addAll(list0);
        arrayList0.addAll(this.n.e);
        this.e();
    }
}

