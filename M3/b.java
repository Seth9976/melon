package m3;

import I6.V;
import I6.w;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.SystemClock;
import androidx.media3.session.N;
import b3.I;
import e3.x;
import g3.e;
import g3.f;
import g3.t;
import i.n.i.b.a.s.e.Ca;
import i.n.i.b.a.s.e.P3;
import i.n.i.b.a.s.e.Ta;
import i.n.i.b.a.s.e.a1;
import i.n.i.b.a.s.e.v4;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import s3.q;
import w3.g;
import w3.k;
import w3.m;

public final class b implements g {
    public final Uri a;
    public final k b;
    public final f c;
    public h d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public IOException j;
    public boolean k;
    public final c l;

    public b(c c0, Uri uri0) {
        this.l = c0;
        this.a = uri0;
        this.b = new k("DefaultHlsPlaylistTracker:MediaPlaylist");
        this.c = ((e)c0.a.b).createDataSource();
    }

    @Override  // w3.g
    public final N a(w3.h h0, long v, long v1, IOException iOException0, int v2) {
        int v3 = ((m)h0).c;
        Uri uri0 = ((m)h0).d.c;
        q q0 = new q(((m)h0).d.d, v1);
        boolean z = uri0.getQueryParameter("_HLS_msn") != null;
        N n0 = k.e;
        c c0 = this.l;
        if(z || iOException0 instanceof m3.m) {
            int v4 = iOException0 instanceof t ? ((t)iOException0).d : 0x7FFFFFFF;
            if(iOException0 instanceof m3.m || (v4 == 400 || v4 == 503)) {
                this.g = SystemClock.elapsedRealtime();
                this.e(false);
                c0.f.t(q0, v3, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, iOException0, true);
                return n0;
            }
        }
        Ca ca0 = new Ca(v2, iOException0);
        int v5 = 0;
        for(Object object0: c0.e) {
            v5 |= !((p)object0).a(this.a, ca0, false);
        }
        Nf.p p0 = c0.c;
        if(v5 != 0) {
            p0.getClass();
            long v6 = Nf.p.f(ca0);
            n0 = v6 == 0x8000000000000001L ? k.f : new N(v6, 0, false);
        }
        int v7 = n0.a == 0 || n0.a == 1 ? 1 : 0;
        c0.f.t(q0, v3, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, iOException0, ((boolean)(v7 ^ 1)));
        if(v7 == 0) {
            p0.getClass();
        }
        return n0;
    }

    public static boolean b(b b0, long v) {
        b0.h = SystemClock.elapsedRealtime() + v;
        c c0 = b0.l;
        if(b0.a.equals(c0.k)) {
            List list0 = c0.j.e;
            int v1 = list0.size();
            long v2 = SystemClock.elapsedRealtime();
            for(int v3 = 0; v3 < v1; ++v3) {
                Uri uri0 = ((j)list0.get(v3)).a;
                b b1 = (b)c0.d.get(uri0);
                b1.getClass();
                if(v2 > b1.h) {
                    c0.k = b1.a;
                    b1.g(c0.c(b1.a));
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final Uri c() {
        Uri uri0 = this.a;
        if(this.d != null && (this.d.v.a != 0x8000000000000001L || this.d.v.e)) {
            Uri.Builder uri$Builder0 = uri0.buildUpon();
            h h0 = this.d;
            if(h0.v.e) {
                uri$Builder0.appendQueryParameter("_HLS_msn", String.valueOf(h0.k + ((long)h0.r.size())));
                h h1 = this.d;
                if(h1.n != 0x8000000000000001L) {
                    int v = h1.s.size();
                    if(!h1.s.isEmpty() && ((d)w.j(h1.s)).m) {
                        --v;
                    }
                    uri$Builder0.appendQueryParameter("_HLS_part", String.valueOf(v));
                }
            }
            Ta ta0 = this.d.v;
            if(ta0.a != 0x8000000000000001L) {
                uri$Builder0.appendQueryParameter("_HLS_skip", (ta0.b ? "v2" : "YES"));
            }
            return uri$Builder0.build();
        }
        return uri0;
    }

    @Override  // w3.g
    public final void d(w3.h h0, long v, long v1) {
        l l0 = (l)((m)h0).f;
        q q0 = new q(((m)h0).d.d, v1);
        if(l0 instanceof h) {
            this.i(((h)l0), q0);
            this.l.f.s(q0, 4, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
        }
        else {
            I i0 = I.b("Loaded playlist has unexpected type.");
            this.j = i0;
            this.l.f.t(q0, 4, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, i0, true);
        }
        this.l.c.getClass();
    }

    public final void e(boolean z) {
        this.g((z ? this.c() : this.a));
    }

    public final void f(Uri uri0) {
        w3.l l0 = this.l.b.d(this.l.j, this.d);
        m m0 = new m(this.c, uri0, l0);
        int v = this.l.c.e(m0.c);
        this.b.d(m0, this, v);
        this.l.f.u(new q(m0.b), m0.c, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
    }

    public final void g(Uri uri0) {
        this.h = 0L;
        if(this.i || (this.b.b() || this.b.c != null)) {
            return;
        }
        long v = SystemClock.elapsedRealtime();
        long v1 = this.g;
        if(v < v1) {
            this.i = true;
            this.l.h.postDelayed(new P3(19, this, uri0), v1 - v);
            return;
        }
        this.f(uri0);
    }

    @Override  // w3.g
    public final void h(w3.h h0, long v, long v1, boolean z) {
        q q0 = new q(((m)h0).d.d, v1);
        this.l.c.getClass();
        this.l.f.r(q0, 4, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L);
    }

    public final void i(h h0, q q0) {
        boolean z1;
        a1 a10;
        long v8;
        h h2;
        V v16;
        int v15;
        long v9;
        boolean z;
        h h1 = this.d;
        long v = SystemClock.elapsedRealtime();
        this.e = v;
        c c0 = this.l;
        CopyOnWriteArrayList copyOnWriteArrayList0 = c0.e;
        if(h1 == null) {
            h0.getClass();
            z = true;
        }
        else {
            int v1 = Long.compare(h0.k, h1.k);
            if(v1 > 0) {
                z = true;
            }
            else if(v1 >= 0) {
                int v2 = h0.r.size() - h1.r.size();
                if(v2 == 0) {
                    int v3 = h0.s.size();
                    int v4 = h1.s.size();
                    z = v3 <= v4 && (v3 != v4 || !h0.o || h1.o) ? false : true;
                }
                else if(v2 <= 0) {
                    z = false;
                }
                else {
                    z = true;
                }
            }
            else {
                z = false;
            }
        }
        V v5 = h0.r;
        long v6 = h0.k;
        long v7 = 0L;
        if(z) {
            if(h0.p) {
                v9 = h0.h;
            }
            else {
                long v10 = c0.l == null ? 0L : c0.l.h;
                if(h1 == null) {
                    v9 = v10;
                }
                else {
                    long v11 = h1.k;
                    v9 = v10;
                    int v12 = h1.r.size();
                    long v13 = h1.h;
                    int v14 = (int)(v6 - v11);
                    m3.f f0 = v14 >= h1.r.size() ? null : ((m3.f)h1.r.get(v14));
                    if(f0 != null) {
                        v9 = v13 + f0.e;
                    }
                    else if(((long)v12) == v6 - v11) {
                        v9 = v13 + h1.u;
                    }
                }
            }
            if(h0.i) {
                v15 = h0.j;
            }
            else {
                int v17 = c0.l == null ? 0 : c0.l.j;
                if(h1 != null) {
                    int v18 = (int)(v6 - h1.k);
                    m3.f f1 = v18 >= h1.r.size() ? null : ((m3.f)h1.r.get(v18));
                    if(f1 != null) {
                        int v19 = ((m3.f)v5.get(0)).d;
                        v17 = h1.j + f1.d - v19;
                    }
                }
                v15 = v17;
            }
            v16 = v5;
            v8 = v6;
            h2 = new h(h0.d, h0.a, h0.b, h0.e, h0.g, v9, true, v15, h0.k, h0.l, h0.m, h0.n, h0.c, h0.o, h0.p, h0.q, v16, h0.s, h0.v, h0.t);
        }
        else if(!h0.o) {
            h2 = h1;
            v8 = v6;
        }
        else if(h1.o) {
            h2 = h1;
            v8 = v6;
        }
        else {
            v8 = v6;
            h2 = new h(h1.d, h1.a, h1.b, h1.e, h1.g, h1.h, h1.i, h1.j, h1.k, h1.l, h1.m, h1.n, h1.c, true, h1.p, h1.q, h1.r, h1.s, h1.v, h1.t);
        }
        this.d = h2;
        Uri uri0 = this.a;
        if(h2 != h1) {
            this.j = null;
            this.f = v;
            if(uri0.equals(c0.k)) {
                if(c0.l == null) {
                    c0.m = !h2.o;
                    c0.n = h2.h;
                }
                c0.l = h2;
                c0.i.u(h2);
            }
            for(Object object0: copyOnWriteArrayList0) {
                ((p)object0).onPlaylistChanged();
            }
        }
        else if(!h2.o) {
            h h3 = this.d;
            if(v8 + ((long)h0.r.size()) < h3.k) {
                a10 = new a1();  // 初始化器: Ljava/io/IOException;-><init>()V
                z1 = true;
            }
            else {
                a10 = ((double)(v - this.f)) > ((double)x.Z(h3.m)) * 3.5 ? new v4() : null;  // 初始化器: Ljava/io/IOException;-><init>()V
                z1 = false;
            }
            if(a10 != null) {
                this.j = a10;
                Ca ca0 = new Ca(1, a10);
                for(Object object1: copyOnWriteArrayList0) {
                    ((p)object1).a(uri0, ca0, z1);
                }
            }
        }
        h h4 = this.d;
        long v20 = h4.m;
        if(!h4.v.e) {
            if(h4 == h1) {
                v20 /= 2L;
            }
            v7 = v20;
        }
        this.g = x.Z(v7) + v - q0.b;
        if(!this.d.o && (uri0.equals(c0.k) || this.k)) {
            this.g(this.c());
        }
    }
}

