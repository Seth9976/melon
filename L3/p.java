package l3;

import B3.F;
import B3.L;
import B3.t;
import G.E0;
import I6.Q;
import I6.V;
import I6.w;
import J0.h;
import P3.c;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.b;
import androidx.media3.exoplayer.J;
import androidx.media3.exoplayer.K;
import androidx.media3.session.N;
import androidx.recyclerview.widget.p0;
import b3.H;
import b3.q0;
import e3.v;
import e3.x;
import g3.f;
import g3.j;
import i.n.i.b.a.s.e.Ca;
import i.n.i.b.a.s.e.G6;
import i.n.i.b.a.s.e.ad;
import i.n.i.b.a.s.e.eb;
import i.n.i.b.a.s.e.kc;
import i.n.i.b.a.s.e.l6;
import i.n.i.b.a.s.e.u9;
import i3.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k3.k;
import kb.D;
import s3.T;
import s3.X;
import s3.g0;
import s3.q;
import s3.z;
import t3.a;
import w3.d;
import w3.g;
import w3.i;

public final class p implements t, T, X, g, i {
    public final Handler B;
    public final ArrayList D;
    public final Map E;
    public a G;
    public o[] I;
    public int[] M;
    public final HashSet N;
    public final SparseIntArray S;
    public n T;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public int Z;
    public final String a;
    public final int b;
    public b b0;
    public final D c;
    public b c0;
    public final l3.g d;
    public boolean d0;
    public final d e;
    public g0 e0;
    public final b f;
    public Set f0;
    public final k3.o g;
    public int[] g0;
    public final k h;
    public int h0;
    public final Nf.p i;
    public boolean i0;
    public final w3.k j;
    public boolean[] j0;
    public final B7.b k;
    public boolean[] k0;
    public final int l;
    public long l0;
    public final h m;
    public long m0;
    public final ArrayList n;
    public boolean n0;
    public final List o;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public final m r;
    public long r0;
    public DrmInitData s0;
    public l3.i t0;
    public static final Set u0;
    public final m w;

    static {
        p.u0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    }

    public p(String s, int v, D d0, l3.g g0, Map map0, d d1, long v1, b b0, k3.o o0, k k0, Nf.p p0, B7.b b1, int v2) {
        this.a = s;
        this.b = v;
        this.c = d0;
        this.d = g0;
        this.E = map0;
        this.e = d1;
        this.f = b0;
        this.g = o0;
        this.h = k0;
        this.i = p0;
        this.k = b1;
        this.l = v2;
        this.j = new w3.k("Loader:HlsSampleStreamWrapper");
        h h0 = new h(11);
        h0.c = null;
        h0.b = false;
        h0.d = null;
        this.m = h0;
        this.M = new int[0];
        this.N = new HashSet(p.u0.size());
        this.S = new SparseIntArray(p.u0.size());
        this.I = new o[0];
        this.k0 = new boolean[0];
        this.j0 = new boolean[0];
        ArrayList arrayList0 = new ArrayList();
        this.n = arrayList0;
        this.o = Collections.unmodifiableList(arrayList0);
        this.D = new ArrayList();
        this.r = new m(this, 0);
        this.w = new m(this, 1);
        this.B = x.l(null);
        this.l0 = v1;
        this.m0 = v1;
    }

    @Override  // w3.g
    public final N a(w3.h h0, long v, long v1, IOException iOException0, int v2) {
        N n1;
        if(((a)h0) instanceof l3.i && !((l3.i)(((a)h0))).K && iOException0 instanceof g3.t) {
            switch(((g3.t)iOException0).d) {
                case 404: 
                case 410: {
                    return w3.k.d;
                }
            }
        }
        long v3 = ((a)h0).i.b;
        q q0 = new q(((a)h0).i.d, v1);
        x.Z(((a)h0).g);
        x.Z(((a)h0).h);
        Ca ca0 = new Ca(v2, iOException0);
        p0 p00 = e1.b.t(this.d.q);
        this.i.getClass();
        N n0 = Nf.p.d(p00, ca0);
        boolean z = n0 == null || n0.a != 2 ? false : this.d.q.c(this.d.q.indexOf(this.d.h.b(((a)h0).d)), n0.b);
        if(z) {
            if(((a)h0) instanceof l3.i && v3 == 0L) {
                ArrayList arrayList0 = this.n;
                e3.b.j(((l3.i)arrayList0.remove(arrayList0.size() - 1)) == ((a)h0));
                if(arrayList0.isEmpty()) {
                    this.m0 = this.l0;
                }
                else {
                    ((l3.i)w.j(arrayList0)).J = true;
                }
            }
            n1 = w3.k.e;
        }
        else {
            long v4 = Nf.p.f(ca0);
            n1 = v4 == 0x8000000000000001L ? w3.k.f : new N(v4, 0, false);
        }
        int v5 = n1.a == 0 || n1.a == 1 ? 1 : 0;
        this.k.t(q0, ((a)h0).c, this.b, ((a)h0).d, ((a)h0).e, ((a)h0).f, ((a)h0).g, ((a)h0).h, iOException0, ((boolean)(v5 ^ 1)));
        if(v5 == 0) {
            this.G = null;
        }
        if(z) {
            if(!this.Y) {
                J j0 = new J();
                j0.a = this.l0;
                this.b(new K(j0));
                return n1;
            }
            this.c.a(this);
        }
        return n1;
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        h h2;
        l3.b b2;
        e3.p p0;
        c c2;
        j j2;
        f f6;
        long v24;
        boolean z7;
        f f5;
        ad ad1;
        l l1;
        byte[] arr_b3;
        f f3;
        byte[] arr_b2;
        w3.k k2;
        D d4;
        byte[] arr_b;
        boolean z6;
        l3.h h7;
        boolean z4;
        Uri uri2;
        ad ad0;
        int v16;
        int v15;
        l3.g g1;
        Uri uri1;
        long v11;
        l3.i i2;
        int v10;
        m3.c c1;
        long v6;
        D d1;
        h h1;
        long v;
        List list0;
        if(!this.p0) {
            w3.k k1 = this.j;
            if(k1.b() || k1.c != null) {
                return false;
            }
            if(this.r()) {
                list0 = Collections.EMPTY_LIST;
                v = this.m0;
                o[] arr_o = this.I;
                for(int v1 = 0; v1 < arr_o.length; ++v1) {
                    arr_o[v1].t = this.m0;
                }
            }
            else {
                l3.i i0 = this.p();
                v = i0.H ? i0.h : Math.max(this.l0, i0.g);
                list0 = this.o;
            }
            h h0 = this.m;
            h0.c = null;
            h0.b = false;
            h0.d = null;
            boolean z = this.Y || !list0.isEmpty();
            l3.g g0 = this.d;
            D d0 = g0.j;
            Uri[] arr_uri = g0.e;
            m3.c c0 = g0.g;
            l3.i i1 = list0.isEmpty() ? null : ((l3.i)w.j(list0));
            int v2 = i1 == null ? -1 : g0.h.b(i1.d);
            long v3 = k0.a;
            long v4 = v - v3;
            long v5 = g0.r == 0x8000000000000001L ? 0x8000000000000001L : g0.r - v3;
            if(i1 == null || g0.p) {
                d1 = d0;
                v6 = v3;
                c1 = c0;
                h1 = h0;
            }
            else {
                h1 = h0;
                d1 = d0;
                v6 = v3;
                long v7 = i1.h - i1.g;
                c1 = c0;
                v4 = Math.max(0L, v4 - v7);
                if(v5 != 0x8000000000000001L) {
                    v5 = Math.max(0L, v5 - v7);
                }
            }
            t3.c[] arr_c = g0.a(i1, v);
            g0.q.d(v6, v4, v5, list0, arr_c);
            int v8 = g0.q.getSelectedIndexInTrackGroup();
            boolean z1 = v2 != v8;
            Uri uri0 = arr_uri[v8];
            if(c1.e(uri0)) {
                h2 = h1;
                m3.h h3 = c1.b(uri0, true);
                h3.getClass();
                long v9 = h3.h;
                g0.p = h3.c;
                if(h3.o) {
                    v10 = v2;
                    i2 = i1;
                    v11 = 0x8000000000000001L;
                }
                else {
                    v10 = v2;
                    i2 = i1;
                    v11 = h3.u + v9 - c1.n;
                }
                g0.r = v11;
                m3.h h4 = h3;
                long v12 = v9 - c1.n;
                Pair pair0 = g0.c(i2, z1, h4, v12, v);
                long v13 = (long)(((Long)pair0.first));
                int v14 = (int)(((Integer)pair0.second));
                if(v13 >= h4.k || i2 == null || !z1) {
                    g1 = g0;
                    v15 = v14;
                    uri1 = uri0;
                    v16 = v8;
                }
                else {
                    uri1 = arr_uri[v10];
                    m3.h h5 = c1.b(uri1, true);
                    h5.getClass();
                    v12 = h5.h - c1.n;
                    h4 = h5;
                    g1 = g0;
                    Pair pair1 = g1.c(i2, false, h4, v12, v);
                    v13 = (long)(((Long)pair1.first));
                    v15 = (int)(((Integer)pair1.second));
                    v16 = v10;
                }
                V v17 = h4.r;
                long v18 = h4.k;
                String s = h4.a;
                boolean z2 = h4.c;
                if(v16 != v10 && v10 != -1) {
                    m3.b b0 = (m3.b)c1.d.get(arr_uri[v10]);
                    if(b0 != null) {
                        b0.k = false;
                    }
                }
                if(v13 < v18) {
                    g1.n = new s3.b();  // 初始化器: Ljava/io/IOException;-><init>()V
                    k2 = k1;
                }
                else {
                    V v19 = h4.s;
                    int v20 = (int)(v13 - v18);
                    if(v20 == v17.size()) {
                        if(v15 == -1) {
                            v15 = 0;
                        }
                        ad0 = v15 < v19.size() ? new ad(((m3.g)v19.get(v15)), v13, v15) : null;
                    }
                    else {
                        m3.f f0 = (m3.f)v17.get(v20);
                        if(v15 == -1) {
                            ad0 = new ad(f0, v13, -1);
                        }
                        else if(v15 < f0.m.size()) {
                            ad0 = new ad(((m3.g)f0.m.get(v15)), v13, v15);
                        }
                        else if(v20 + 1 < v17.size()) {
                            ad0 = new ad(((m3.g)v17.get(v20 + 1)), v13 + 1L, -1);
                        }
                        else {
                            ad0 = v19.isEmpty() ? null : new ad(((m3.g)v19.get(0)), v13 + 1L, 0);
                        }
                    }
                    if(ad0 != null) {
                    label_133:
                        boolean z3 = ad0.c;
                        m3.g g2 = (m3.g)ad0.d;
                        g1.s = false;
                        g1.o = null;
                        SystemClock.elapsedRealtime();
                        m3.f f1 = g2.b;
                        long v21 = g2.e;
                        if(f1 == null) {
                            uri2 = null;
                        }
                        else {
                            String s1 = f1.g;
                            uri2 = s1 == null ? null : e3.b.A(s, s1);
                        }
                        l3.d d2 = g1.d(uri2, v16, true);
                        h2.c = d2;
                        if(d2 == null) {
                            Uri uri3 = g2.g == null ? null : e3.b.A(s, g2.g);
                            l3.d d3 = g1.d(uri3, v16, false);
                            h2.c = d3;
                            if(d3 == null) {
                                if(i2 == null || uri1.equals(i2.m) && i2.H) {
                                    z4 = false;
                                }
                                else {
                                    if(g2 instanceof m3.d) {
                                        z2 = ((m3.d)g2).l || ad0.b == 0 && z2;
                                    }
                                    z4 = z2 && v12 + v21 >= i2.h ? false : true;
                                }
                                if(z4 && z3) {
                                    k2 = k1;
                                }
                                else {
                                    l3.h h6 = g1.a;
                                    f f2 = g1.b;
                                    b b1 = g1.f[v16];
                                    int v22 = g1.q.getSelectionReason();
                                    Object object0 = g1.q.getSelectionData();
                                    boolean z5 = g1.l;
                                    List list1 = g1.i;
                                    l6 l60 = g1.d;
                                    if(uri3 == null) {
                                        d1.getClass();
                                        h7 = h6;
                                        z6 = z5;
                                        arr_b = null;
                                        d4 = d1;
                                    }
                                    else {
                                        h7 = h6;
                                        z6 = z5;
                                        d4 = d1;
                                        arr_b = (byte[])((kc)d4.b).get(uri3);
                                    }
                                    byte[] arr_b1 = uri2 == null ? null : ((byte[])((kc)d4.b).get(uri2));
                                    l l0 = g1.k;
                                    Map map0 = Collections.EMPTY_MAP;
                                    k2 = k1;
                                    Uri uri4 = e3.b.A(s, g2.a);
                                    long v23 = g2.c;
                                    e3.b.l(uri4, "The uri must be set.");
                                    j j0 = new j(uri4, 1, null, map0, g2.i, g2.j, null, (z3 ? 8 : 0));
                                    if(arr_b == null) {
                                        arr_b2 = null;
                                    }
                                    else {
                                        g2.h.getClass();
                                        arr_b2 = l3.i.b(g2.h);
                                    }
                                    if(arr_b == null) {
                                        f3 = f2;
                                    }
                                    else {
                                        arr_b2.getClass();
                                        f3 = new l3.a(f2, arr_b, arr_b2);
                                    }
                                    m3.f f4 = g2.b;
                                    if(f4 == null) {
                                        l1 = l0;
                                        ad1 = ad0;
                                        v24 = v23;
                                        j2 = null;
                                        f6 = null;
                                        z7 = false;
                                    }
                                    else {
                                        if(arr_b1 == null) {
                                            arr_b3 = null;
                                        }
                                        else {
                                            f4.h.getClass();
                                            arr_b3 = l3.i.b(f4.h);
                                        }
                                        l1 = l0;
                                        Uri uri5 = e3.b.A(s, f4.a);
                                        ad1 = ad0;
                                        e3.b.l(uri5, "The uri must be set.");
                                        j j1 = new j(uri5, 1, null, map0, f4.i, f4.j, null, 0);
                                        if(arr_b1 == null) {
                                            f5 = f2;
                                        }
                                        else {
                                            arr_b3.getClass();
                                            f5 = new l3.a(f2, arr_b1, arr_b3);
                                        }
                                        z7 = arr_b1 != null;
                                        v24 = v23;
                                        f6 = f5;
                                        j2 = j1;
                                    }
                                    int v25 = h4.j + g2.d;
                                    if(i2 == null) {
                                        c2 = new c(null);
                                        p0 = new e3.p(10);
                                        b2 = null;
                                    }
                                    else {
                                        boolean z8 = j2 == i2.q || j2 != null && i2.q != null && j2.a.equals(i2.q.a) && j2.e == i2.q.e;
                                        boolean z9 = uri1.equals(i2.m) && i2.H;
                                        c2 = i2.y;
                                        p0 = i2.z;
                                        b2 = !z8 || !z9 || i2.J || i2.l != v25 ? null : i2.C;
                                    }
                                    long v26 = ad1.a;
                                    int v27 = ad1.b;
                                    boolean z10 = g2.k;
                                    SparseArray sparseArray0 = l60.a;
                                    v v28 = (v)sparseArray0.get(v25);
                                    if(v28 == null) {
                                        v28 = new v(0x7FFFFFFFFFFFFFFEL);
                                        sparseArray0.put(v25, v28);
                                    }
                                    h2.c = new l3.i(h7, f3, j0, b1, arr_b != null, f6, j2, z7, uri1, list1, v22, object0, v12 + v21, v12 + v21 + v24, v26, v27, !z3, v25, z10, z6, v28, g2.f, b2, c2, p0, z4, l1);
                                }
                            }
                            else {
                                k2 = k1;
                            }
                        }
                        else {
                            k2 = k1;
                        }
                    }
                    else if(!h4.o) {
                        h2.d = uri1;
                        g1.s &= uri1.equals(g1.o);
                        g1.o = uri1;
                        k2 = k1;
                    }
                    else if(!z && !v17.isEmpty()) {
                        ad0 = new ad(((m3.g)w.j(v17)), v18 + ((long)v17.size()) - 1L, -1);
                        goto label_133;
                    }
                    else {
                        h2.b = true;
                        k2 = k1;
                    }
                }
            }
            else {
                h2 = h1;
                h2.d = uri0;
                g0.s &= uri0.equals(g0.o);
                g0.o = uri0;
                k2 = k1;
            }
            boolean z11 = h2.b;
            a a0 = (a)h2.c;
            Uri uri6 = (Uri)h2.d;
            if(z11) {
                this.m0 = 0x8000000000000001L;
                this.p0 = true;
                return true;
            }
            if(a0 != null) {
                if(a0 instanceof l3.i) {
                    this.t0 = (l3.i)a0;
                    this.b0 = ((l3.i)a0).d;
                    this.m0 = 0x8000000000000001L;
                    this.n.add(((l3.i)a0));
                    Q q0 = V.o();
                    o[] arr_o1 = this.I;
                    for(int v29 = 0; v29 < arr_o1.length; ++v29) {
                        o o0 = arr_o1[v29];
                        q0.a(((int)(o0.q + o0.p)));
                    }
                    I6.p0 p00 = q0.g();
                    ((l3.i)a0).D = this;
                    ((l3.i)a0).I = p00;
                    o[] arr_o2 = this.I;
                    for(int v30 = 0; v30 < arr_o2.length; ++v30) {
                        o o1 = arr_o2[v30];
                        o1.getClass();
                        o1.C = (long)((l3.i)a0).k;
                        if(((l3.i)a0).n) {
                            o1.G = true;
                        }
                    }
                }
                this.G = a0;
                k2.d(a0, this, this.i.e(a0.c));
                q q1 = new q(a0.b);
                this.k.u(q1, a0.c, this.b, a0.d, a0.e, a0.f, a0.g, a0.h);
                return true;
            }
            else if(uri6 != null) {
                ((m3.b)((l3.j)this.c.b).b.d.get(uri6)).e(true);
                return false;
            }
        }
        return false;
    }

    @Override  // w3.g
    public final void d(w3.h h0, long v, long v1) {
        this.G = null;
        if(((a)h0) instanceof l3.d) {
            this.d.m = ((l3.d)(((a)h0))).j;
            Uri uri0 = ((l3.d)(((a)h0))).b.a;
            byte[] arr_b = ((l3.d)(((a)h0))).l;
            arr_b.getClass();
            uri0.getClass();
            byte[] arr_b1 = (byte[])((kc)this.d.j.b).put(uri0, arr_b);
        }
        q q0 = new q(((a)h0).i.d, v1);
        this.i.getClass();
        this.k.s(q0, ((a)h0).c, this.b, ((a)h0).d, ((a)h0).e, ((a)h0).f, ((a)h0).g, ((a)h0).h);
        if(!this.Y) {
            J j0 = new J();
            j0.a = this.l0;
            this.b(new K(j0));
            return;
        }
        this.c.a(this);
    }

    @Override  // B3.t
    public final void endTracks() {
        this.q0 = true;
        this.B.post(this.w);
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        ArrayList arrayList0 = this.n;
        if(this.p0) {
            return 0x8000000000000000L;
        }
        if(this.r()) {
            return this.m0;
        }
        long v = this.l0;
        l3.i i0 = this.p();
        if(!i0.H) {
            i0 = arrayList0.size() <= 1 ? null : ((l3.i)com.iloen.melon.utils.a.i(2, arrayList0));
        }
        if(i0 != null) {
            v = Math.max(v, i0.h);
        }
        if(this.X) {
            o[] arr_o = this.I;
            for(int v1 = 0; v1 < arr_o.length; ++v1) {
                v = Math.max(v, arr_o[v1].v);
            }
        }
        return v;
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        if(this.r()) {
            return this.m0;
        }
        return this.p0 ? 0x8000000000000000L : this.p().h;
    }

    @Override  // w3.g
    public final void h(w3.h h0, long v, long v1, boolean z) {
        this.G = null;
        q q0 = new q(((a)h0).i.d, v1);
        this.i.getClass();
        this.k.r(q0, ((a)h0).c, this.b, ((a)h0).d, ((a)h0).e, ((a)h0).f, ((a)h0).g, ((a)h0).h);
        if(!z) {
            if(this.r() || this.Z == 0) {
                this.v();
            }
            if(this.Z > 0) {
                this.c.a(this);
            }
        }
    }

    @Override  // s3.T
    public final void i() {
        this.B.post(this.r);
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.j.b();
    }

    public final void j() {
        e3.b.j(this.Y);
        this.e0.getClass();
        this.f0.getClass();
    }

    public static B3.p k(int v, int v1) {
        e3.b.D("HlsSampleStreamWrapper", "Unmapped track with id " + v + " of type " + v1);
        return new B3.p();
    }

    public final g0 l(q0[] arr_q0) {
        for(int v = 0; v < arr_q0.length; ++v) {
            q0 q00 = arr_q0[v];
            b[] arr_b = new b[q00.a];
            for(int v1 = 0; v1 < q00.a; ++v1) {
                b b0 = q00.d[v1];
                int v2 = this.g.c(b0);
                b3.n n0 = b0.a();
                n0.K = v2;
                arr_b[v1] = new b(n0);
            }
            arr_q0[v] = new q0(q00.b, arr_b);
        }
        return new g0(arr_q0);
    }

    public static b m(b b0, b b1, boolean z) {
        String s2;
        if(b0 == null) {
            return b1;
        }
        String s = b0.k;
        String s1 = b1.n;
        int v = H.g(s1);
        if(x.r(v, s) == 1) {
            s2 = x.s(s, v);
            s1 = H.c(s2);
        }
        else {
            s2 = H.a(s, s1);
        }
        b3.n n0 = b1.a();
        n0.a = b0.a;
        n0.b = b0.b;
        n0.c = V.p(b0.c);
        n0.d = b0.d;
        n0.e = b0.e;
        n0.f = b0.f;
        n0.h = z ? b0.h : -1;
        n0.i = z ? b0.i : -1;
        n0.j = s2;
        if(v == 2) {
            n0.t = b0.u;
            n0.u = b0.v;
            n0.v = b0.w;
        }
        if(s1 != null) {
            n0.m = H.l(s1);
        }
        int v1 = b0.C;
        if(v1 != -1 && v == 1) {
            n0.B = v1;
        }
        Metadata metadata0 = b0.l;
        if(metadata0 != null) {
            Metadata metadata1 = b1.l;
            if(metadata1 != null) {
                metadata0 = metadata1.b(metadata0);
            }
            n0.k = metadata0;
        }
        return new b(n0);
    }

    @Override  // B3.t
    public final void n(F f0) {
    }

    public final void o(int v) {
        long v10;
        ArrayList arrayList0;
        e3.b.j(!this.j.b());
        int v1 = v;
    alab1:
        while(true) {
            arrayList0 = this.n;
            if(v1 >= arrayList0.size()) {
                goto label_19;
            }
            int v2 = v1;
            while(v2 < arrayList0.size()) {
                if(((l3.i)arrayList0.get(v2)).n) {
                    goto label_16;
                }
                ++v2;
            }
            l3.i i0 = (l3.i)arrayList0.get(v1);
            for(int v3 = 0; true; ++v3) {
                if(v3 >= this.I.length) {
                    break alab1;
                }
                int v4 = i0.c(v3);
                if(this.I[v3].l() > v4) {
                label_16:
                    ++v1;
                    break;
                }
            }
        }
        goto label_20;
    label_19:
        v1 = -1;
    label_20:
        if(v1 == -1) {
            return;
        }
        long v5 = this.p().h;
        l3.i i1 = (l3.i)arrayList0.get(v1);
        x.Q(arrayList0, v1, arrayList0.size());
        int v6 = 0;
        while(v6 < this.I.length) {
            int v7 = i1.c(v6);
            o o0 = this.I[v6];
            G6 g60 = o0.a;
            long v8 = o0.h(v7);
            int v9 = g60.a;
            e3.b.c(v8 <= g60.b);
            g60.b = v8;
            if(v8 == 0L) {
                v10 = v5;
            label_55:
                g60.h(((E0)g60.e));
                E0 e03 = new E0(g60.b, v9);
                g60.e = e03;
                g60.f = e03;
                g60.g = e03;
            }
            else {
                E0 e00 = (E0)g60.e;
                if(v8 == e00.a) {
                    v10 = v5;
                    goto label_55;
                }
                else {
                    while(g60.b > e00.b) {
                        e00 = (E0)e00.d;
                    }
                    E0 e01 = (E0)e00.d;
                    e01.getClass();
                    g60.h(e01);
                    E0 e02 = new E0(e00.b, v9);
                    e00.d = e02;
                    v10 = v5;
                    if(g60.b == e00.b) {
                        e00 = e02;
                    }
                    g60.g = e00;
                    if(((E0)g60.f) == e01) {
                        g60.f = e02;
                    }
                }
            }
            ++v6;
            v5 = v10;
        }
        if(arrayList0.isEmpty()) {
            this.m0 = this.l0;
        }
        else {
            ((l3.i)w.j(arrayList0)).J = true;
        }
        this.p0 = false;
        s3.v v11 = new s3.v(1, this.V, null, 3, null, x.Z(i1.g), x.Z(v5));
        z z0 = (z)this.k.b;
        z0.getClass();
        H7.c c0 = new H7.c(this.k, z0, v11, 21);
        this.k.k(c0);
    }

    @Override  // w3.i
    public final void onLoaderReleased() {
        o[] arr_o = this.I;
        for(int v = 0; v < arr_o.length; ++v) {
            o o0 = arr_o[v];
            o0.u(true);
            k3.h h0 = o0.h;
            if(h0 != null) {
                h0.d(o0.e);
                o0.h = null;
                o0.g = null;
            }
        }
    }

    public final l3.i p() {
        return (l3.i)com.iloen.melon.utils.a.i(1, this.n);
    }

    public static int q(int v) {
        if(v != 1) {
            switch(v) {
                case 2: {
                    return 3;
                }
                case 3: {
                    return 1;
                }
                default: {
                    return 0;
                }
            }
        }
        return 2;
    }

    public final boolean r() {
        return this.m0 != 0x8000000000000001L;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        w3.k k0 = this.j;
        if(k0.c != null) {
            return;
        }
        if(!this.r()) {
            l3.g g0 = this.d;
            List list0 = this.o;
            if(k0.b()) {
                this.G.getClass();
                if((g0.n == null ? g0.q.b(v, this.G, list0) : false)) {
                    k0.a();
                }
            }
            else {
                int v1;
                for(v1 = list0.size(); v1 > 0 && g0.b(((l3.i)list0.get(v1 - 1))) == 2; --v1) {
                }
                if(v1 < list0.size()) {
                    this.o(v1);
                }
                int v2 = g0.n != null || g0.q.length() < 2 ? list0.size() : g0.q.evaluateQueueSize(v, list0);
                if(v2 < this.n.size()) {
                    this.o(v2);
                }
            }
        }
    }

    public final void s() {
        if(!this.d0 && this.g0 == null && this.X) {
            o[] arr_o = this.I;
            for(int v = 0; true; ++v) {
                if(v >= arr_o.length) {
                    g0 g00 = this.e0;
                    if(g00 != null) {
                        int v1 = g00.a;
                        int[] arr_v = new int[v1];
                        this.g0 = arr_v;
                        Arrays.fill(arr_v, -1);
                        for(int v2 = 0; v2 < v1; ++v2) {
                            for(int v3 = 0; true; ++v3) {
                                o[] arr_o1 = this.I;
                                if(v3 >= arr_o1.length) {
                                    break;
                                }
                                b b0 = arr_o1[v3].o();
                                e3.b.k(b0);
                                b b1 = this.e0.a(v2).d[0];
                                String s = b0.n;
                                String s1 = b1.n;
                                int v4 = H.g(s);
                                if(v4 == 3) {
                                    if(Objects.equals(s, s1) && (!"application/cea-608".equals(s) && !"application/cea-708".equals(s) || b0.H == b1.H)) {
                                        this.g0[v2] = v3;
                                        break;
                                    }
                                }
                                else if(v4 == H.g(s1)) {
                                    this.g0[v2] = v3;
                                    break;
                                }
                            }
                        }
                        for(Object object0: this.D) {
                            ((l3.l)object0).a();
                        }
                        return;
                    }
                    int v6 = -1;
                    int v7 = -2;
                    for(int v5 = 0; true; ++v5) {
                        int v8 = 1;
                        if(v5 >= this.I.length) {
                            break;
                        }
                        b b2 = this.I[v5].o();
                        e3.b.k(b2);
                        String s2 = b2.n;
                        if(H.k(s2)) {
                            v8 = 2;
                        }
                        else if(!H.h(s2)) {
                            v8 = H.j(s2) ? 3 : -2;
                        }
                        if(p.q(v8) > p.q(v7)) {
                            v6 = v5;
                            v7 = v8;
                        }
                        else if(v8 == v7 && v6 != -1) {
                            v6 = -1;
                        }
                    }
                    q0 q00 = this.d.h;
                    int v9 = q00.a;
                    this.h0 = -1;
                    this.g0 = new int[this.I.length];
                    for(int v10 = 0; v10 < this.I.length; ++v10) {
                        this.g0[v10] = v10;
                    }
                    q0[] arr_q0 = new q0[this.I.length];
                    for(int v11 = 0; v11 < this.I.length; ++v11) {
                        b b3 = this.I[v11].o();
                        e3.b.k(b3);
                        String s3 = this.a;
                        b b4 = this.f;
                        if(v11 == v6) {
                            b[] arr_b = new b[v9];
                            for(int v12 = 0; v12 < v9; ++v12) {
                                b b5 = q00.d[v12];
                                if(v7 == 1 && b4 != null) {
                                    b5 = b5.e(b4);
                                }
                                arr_b[v12] = v9 == 1 ? b3.e(b5) : p.m(b5, b3, true);
                            }
                            arr_q0[v11] = new q0(s3, arr_b);
                            this.h0 = v11;
                        }
                        else {
                            if(v7 != 2 || !H.h(b3.n)) {
                                b4 = null;
                            }
                            StringBuilder stringBuilder0 = U4.x.p(s3, ":muxed:");
                            stringBuilder0.append((v11 >= v6 ? v11 - 1 : v11));
                            arr_q0[v11] = new q0(stringBuilder0.toString(), new b[]{p.m(b4, b3, false)});
                        }
                    }
                    this.e0 = this.l(arr_q0);
                    e3.b.j(this.f0 == null);
                    this.f0 = Collections.EMPTY_SET;
                    this.Y = true;
                    this.c.n();
                    break;
                }
                if(arr_o[v].o() == null) {
                    break;
                }
            }
        }
    }

    public final void t() {
        w3.k k0 = this.j;
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
        l3.g g0 = this.d;
        s3.b b0 = g0.n;
        if(b0 != null) {
            throw b0;
        }
        Uri uri0 = g0.o;
        if(uri0 != null && g0.s) {
            m3.b b1 = (m3.b)g0.g.d.get(uri0);
            w3.k k1 = b1.b;
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
            IOException iOException4 = b1.j;
            if(iOException4 != null) {
                throw iOException4;
            }
        }
    }

    @Override  // B3.t
    public final L track(int v, int v1) {
        Set set0 = p.u0;
        boolean z = set0.contains(v1);
        boolean z1 = false;
        HashSet hashSet0 = this.N;
        SparseIntArray sparseIntArray0 = this.S;
        L l0 = null;
        if(z) {
            e3.b.c(set0.contains(v1));
            int v2 = sparseIntArray0.get(v1, -1);
            if(v2 != -1) {
                if(hashSet0.add(v1)) {
                    this.M[v2] = v;
                }
                l0 = this.M[v2] == v ? this.I[v2] : p.k(v, v1);
            }
        }
        else {
            for(int v3 = 0; true; ++v3) {
                o[] arr_o = this.I;
                if(v3 >= arr_o.length) {
                    break;
                }
                if(this.M[v3] == v) {
                    l0 = arr_o[v3];
                    break;
                }
            }
        }
        if(l0 == null) {
            if(this.q0) {
                return p.k(v, v1);
            }
            int v4 = this.I.length;
            if(v1 == 1 || v1 == 2) {
                z1 = true;
            }
            l0 = new o(this.e, this.g, this.h, this.E);
            l0.t = this.l0;
            if(z1) {
                l0.I = this.s0;
                l0.z = true;
            }
            long v5 = this.r0;
            if(l0.F != v5) {
                l0.F = v5;
                l0.z = true;
            }
            l3.i i0 = this.t0;
            if(i0 != null) {
                l0.C = (long)i0.k;
            }
            l0.f = this;
            int[] arr_v = Arrays.copyOf(this.M, v4 + 1);
            this.M = arr_v;
            arr_v[v4] = v;
            o[] arr_o1 = this.I;
            Object[] arr_object = Arrays.copyOf(arr_o1, arr_o1.length + 1);
            arr_object[arr_o1.length] = l0;
            this.I = (o[])arr_object;
            boolean[] arr_z = Arrays.copyOf(this.k0, v4 + 1);
            this.k0 = arr_z;
            arr_z[v4] = z1;
            this.i0 |= z1;
            hashSet0.add(v1);
            sparseIntArray0.append(v1, v4);
            if(p.q(v1) > p.q(this.V)) {
                this.W = v4;
                this.V = v1;
            }
            this.j0 = Arrays.copyOf(this.j0, v4 + 1);
        }
        if(v1 == 5) {
            if(this.T == null) {
                this.T = new n(l0, this.l);
            }
            return this.T;
        }
        return l0;
    }

    public final void u(q0[] arr_q0, int[] arr_v) {
        this.e0 = this.l(arr_q0);
        this.f0 = new HashSet();
        for(int v = 0; v < arr_v.length; ++v) {
            this.f0.add(this.e0.a(arr_v[v]));
        }
        this.h0 = 0;
        u9 u90 = new u9(this.c, 13);
        this.B.post(u90);
        this.Y = true;
    }

    public final void v() {
        o[] arr_o = this.I;
        for(int v = 0; v < arr_o.length; ++v) {
            arr_o[v].u(this.n0);
        }
        this.n0 = false;
    }

    public final boolean w(long v, boolean z) {
        this.l0 = v;
        if(this.r()) {
            this.m0 = v;
            return true;
        }
        l3.i i0 = null;
        ArrayList arrayList0 = this.n;
        if(this.d.p) {
            for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                l3.i i1 = (l3.i)arrayList0.get(v2);
                if(i1.g == v) {
                    i0 = i1;
                    break;
                }
            }
        }
        if(this.X && !z) {
            for(int v3 = 0; true; ++v3) {
                boolean z1 = true;
                if(v3 >= this.I.length) {
                    break;
                }
                o o0 = this.I[v3];
                if(!(i0 == null ? o0.w(v, false) : o0.v(i0.c(v3))) && (this.k0[v3] || !this.i0)) {
                    z1 = false;
                    break;
                }
            }
            if(z1) {
                return false;
            }
        }
        this.m0 = v;
        this.p0 = false;
        arrayList0.clear();
        w3.k k0 = this.j;
        if(k0.b()) {
            if(this.X) {
                o[] arr_o = this.I;
                for(int v1 = 0; v1 < arr_o.length; ++v1) {
                    arr_o[v1].g();
                }
            }
            k0.a();
            return true;
        }
        k0.c = null;
        this.v();
        return true;
    }
}

