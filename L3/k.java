package l3;

import B7.b;
import I6.V;
import Nf.p;
import android.net.Uri;
import android.os.Looper;
import b3.E;
import b3.F;
import b3.y;
import g3.e;
import g3.f;
import g3.x;
import i.n.i.b.a.s.e.Ta;
import i.n.i.b.a.s.e.eb;
import i3.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.o;
import kb.D;
import m3.c;
import s3.Z;
import s3.a;
import s3.q;
import s3.z;
import w3.d;
import w3.m;

public final class k extends a {
    public final h h;
    public final D i;
    public final e3.h j;
    public final o k;
    public final p l;
    public final boolean m;
    public final int n;
    public final c o;
    public final long p;
    public y q;
    public x r;
    public E s;

    static {
        F.a("media3.exoplayer.hls");
    }

    public k(E e0, D d0, l3.c c0, e3.h h0, o o0, p p0, c c1, long v, boolean z, int v1) {
        this.s = e0;
        this.q = e0.c;
        this.i = d0;
        this.h = c0;
        this.j = h0;
        this.k = o0;
        this.l = p0;
        this.o = c1;
        this.p = v;
        this.m = z;
        this.n = v1;
    }

    @Override  // s3.a
    public final boolean a(E e0) {
        E e1 = this.h();
        e1.b.getClass();
        return e0.b != null && e0.b.a.equals(e1.b.a) && e0.b.e.equals(e1.b.e) && Objects.equals(e0.b.c, e1.b.c) && e1.c.equals(e0.c);
    }

    @Override  // s3.a
    public final s3.x b(z z0, d d0, long v) {
        b b0 = new b(0, ((CopyOnWriteArrayList)this.c.c), z0);
        k3.k k0 = new k3.k(this.d.c, 0, z0);
        x x0 = this.r;
        l l0 = this.g;
        e3.b.k(l0);
        return new j(this.h, this.o, this.i, x0, this.k, k0, this.l, b0, d0, this.j, this.m, this.n, l0);
    }

    @Override  // s3.a
    public final E h() {
        synchronized(this) {
        }
        return this.s;
    }

    @Override  // s3.a
    public final void j() {
        c c0 = this.o;
        w3.k k0 = c0.g;
        if(k0 != null) {
            IOException iOException0 = k0.c;
            if(iOException0 != null) {
                throw iOException0;
            }
            eb eb0 = k0.b;
            if(eb0 != null) {
                IOException iOException1 = eb0.d;
                if(iOException1 != null && eb0.e > eb0.b) {
                    throw iOException1;
                }
            }
        }
        Uri uri0 = c0.k;
        if(uri0 != null) {
            m3.b b0 = (m3.b)c0.d.get(uri0);
            w3.k k1 = b0.b;
            IOException iOException2 = k1.c;
            if(iOException2 != null) {
                throw iOException2;
            }
            eb eb1 = k1.b;
            if(eb1 != null) {
                IOException iOException3 = eb1.d;
                if(iOException3 != null && eb1.e > eb1.b) {
                    throw iOException3;
                }
            }
            IOException iOException4 = b0.j;
            if(iOException4 != null) {
                throw iOException4;
            }
        }
    }

    @Override  // s3.a
    public final void l(x x0) {
        this.r = x0;
        Looper looper0 = Looper.myLooper();
        looper0.getClass();
        l l0 = this.g;
        e3.b.k(l0);
        this.k.d(looper0, l0);
        this.k.prepare();
        boolean z = false;
        b b0 = new b(0, ((CopyOnWriteArrayList)this.c.c), null);
        E e0 = this.h();
        e0.b.getClass();
        c c0 = this.o;
        c0.getClass();
        c0.h = e3.x.l(null);
        c0.f = b0;
        c0.i = this;
        f f0 = ((e)c0.a.b).createDataSource();
        w3.l l1 = c0.b.createPlaylistParser();
        m m0 = new m(f0, e0.b.a, l1);
        if(c0.g == null) {
            z = true;
        }
        e3.b.j(z);
        w3.k k0 = new w3.k("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        c0.g = k0;
        k0.d(m0, c0, c0.c.e(m0.c));
        b0.u(new q(m0.b), m0.c, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
    }

    @Override  // s3.a
    public final void n(s3.x x0) {
        ((j)x0).b.e.remove(((j)x0));
        l3.p[] arr_p = ((j)x0).E;
        for(int v = 0; v < arr_p.length; ++v) {
            l3.p p0 = arr_p[v];
            if(p0.Y) {
                l3.o[] arr_o = p0.I;
                for(int v1 = 0; v1 < arr_o.length; ++v1) {
                    l3.o o0 = arr_o[v1];
                    o0.g();
                    k3.h h0 = o0.h;
                    if(h0 != null) {
                        h0.d(o0.e);
                        o0.h = null;
                        o0.g = null;
                    }
                }
            }
            g g0 = p0.d;
            int v2 = g0.q.getSelectedIndexInTrackGroup();
            m3.b b0 = (m3.b)g0.g.d.get(g0.e[v2]);
            if(b0 != null) {
                b0.k = false;
            }
            g0.n = null;
            p0.j.c(p0);
            p0.B.removeCallbacksAndMessages(null);
            p0.d0 = true;
            p0.D.clear();
        }
        ((j)x0).w = null;
    }

    @Override  // s3.a
    public final void p() {
        c c0 = this.o;
        c0.k = null;
        c0.l = null;
        c0.j = null;
        c0.n = 0x8000000000000001L;
        c0.g.c(null);
        c0.g = null;
        HashMap hashMap0 = c0.d;
        for(Object object0: hashMap0.values()) {
            ((m3.b)object0).b.c(null);
        }
        c0.h.removeCallbacksAndMessages(null);
        c0.h = null;
        hashMap0.clear();
        this.k.release();
    }

    @Override  // s3.a
    public final void s(E e0) {
        synchronized(this) {
            this.s = e0;
        }
    }

    public static m3.d t(long v, List list0) {
        m3.d d0 = null;
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            m3.d d1 = (m3.d)list0.get(v1);
            long v2 = d1.e;
            if(v2 <= v && d1.l) {
                d0 = d1;
            }
            else if(v2 > v) {
                break;
            }
        }
        return d0;
    }

    public final void u(m3.h h0) {
        long v14;
        Z z3;
        long v11;
        long v12;
        boolean z = h0.g;
        V v0 = h0.r;
        long v1 = h0.u;
        long v2 = h0.e;
        int v3 = h0.d;
        long v4 = h0.h;
        long v5 = h0.p ? e3.x.Z(v4) : 0x8000000000000001L;
        long v6 = v3 == 1 || v3 == 2 ? v5 : 0x8000000000000001L;
        c c0 = this.o;
        c0.j.getClass();
        e3.h h1 = new e3.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        long v7 = 0L;
        if(c0.m) {
            Ta ta0 = h0.v;
            long v8 = v4 - c0.n;
            boolean z1 = h0.o;
            long v9 = h0.p ? e3.x.M(e3.x.y(this.p)) - (v4 + v1) : 0L;
            long v10 = this.q.a;
            if(v10 == 0x8000000000000001L) {
                if(v2 == 0x8000000000000001L) {
                    v12 = ta0.d;
                    if(v12 == 0x8000000000000001L || h0.n == 0x8000000000000001L) {
                        v12 = ta0.c;
                        if(v12 == 0x8000000000000001L) {
                            v12 = 3L * h0.m;
                        }
                    }
                }
                else {
                    v12 = v1 - v2;
                }
                v11 = v12 + v9;
            }
            else {
                v11 = e3.x.M(v10);
            }
            long v13 = v1 + v9;
            y y0 = this.h().c;
            boolean z2 = Float.compare(y0.d, -3.402823E+38f) == 0 && y0.e == -3.402823E+38f && ta0.c == 0x8000000000000001L && ta0.d == 0x8000000000000001L;
            b3.x x0 = new b3.x();
            x0.a = e3.x.Z(e3.x.i(v11, v9, v13));
            float f = 1.0f;
            x0.d = z2 ? 1.0f : this.q.d;
            if(!z2) {
                f = this.q.e;
            }
            x0.e = f;
            y y1 = new y(x0);
            this.q = y1;
            if(v2 == 0x8000000000000001L) {
                v2 = v13 - e3.x.M(y1.a);
            }
            if(z) {
                v7 = v2;
            }
            else {
                m3.d d0 = k.t(v2, h0.s);
                if(d0 != null) {
                    v7 = d0.e;
                }
                else if(!v0.isEmpty()) {
                    m3.f f1 = (m3.f)v0.get(e3.x.c(v0, v2, true));
                    m3.d d1 = k.t(v2, f1.m);
                    v7 = d1 == null ? f1.e : d1.e;
                }
            }
            E e0 = this.h();
            z3 = new Z(v6, v5, (z1 ? v8 + v1 : 0x8000000000000001L), h0.u, v8, v7, true, !z1, v3 == 2 && h0.f, h1, e0, this.q);
        }
        else {
            if(v2 == 0x8000000000000001L || v0.isEmpty()) {
                v14 = 0L;
            }
            else {
                if(!z && v2 != v1) {
                    v2 = ((m3.f)v0.get(e3.x.c(v0, v2, true))).e;
                }
                v14 = v2;
            }
            E e1 = this.h();
            z3 = new Z(v6, v5, h0.u, h0.u, 0L, v14, true, false, true, h1, e1, null);
        }
        this.m(z3);
    }
}

