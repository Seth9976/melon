package i.n.i.b.a.s.e;

import Gf.l;
import I.H1;
import b3.Z;
import com.google.android.exoplayer2.ui.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public final class qe implements w5 {
    public final Lb a;
    public final int[] b;
    public final int c;
    public final D0 d;
    public final long e;
    public final b0 f;
    public final Map g;
    public final Md h;
    public final boolean i;
    public final ArrayList j;
    public pe[] k;
    public q2 l;
    public p1 m;
    public int n;
    public int o;
    public F6 p;
    public boolean q;

    public qe(Lb lb0, p1 p10, int v, int[] arr_v, q2 q20, int v1, D0 d00, long v2, boolean z, ArrayList arrayList0, b0 b00, Map map0, Md md0) {
        this.a = lb0;
        this.m = p10;
        this.b = arr_v;
        this.l = q20;
        this.c = v1;
        this.d = d00;
        this.n = v;
        this.e = v2;
        this.f = b00;
        this.g = map0;
        this.h = md0;
        this.o = 0;
        this.i = z;
        this.j = arrayList0;
        long v4 = p10.d(v);
        ArrayList arrayList1 = this.c();
        int[] arr_v1 = q20.c;
        this.k = new pe[arr_v1.length];
        for(int v3 = 0; v3 < this.k.length; ++v3) {
            Object object0 = arrayList1.get(arr_v1[v3]);
            pe[] arr_pe = this.k;
            arr_pe[v3] = new pe(v4, ((z5)object0), Ma.b(v1, ((z5)object0).a, z, arrayList0, b00), 0L, ((z5)object0).f());
        }
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final long a(long v, Xb xb0) {
        pe[] arr_pe = this.k;
        for(int v1 = 0; v1 < arr_pe.length; ++v1) {
            pe pe0 = arr_pe[v1];
            Wc wc0 = pe0.c;
            Wc wc1 = pe0.c;
            long v2 = pe0.d;
            if(wc0 != null) {
                long v3 = wc0.d(v, v2) + pe0.e;
                long v4 = pe0.d(v3);
                long v5 = wc1.b(v2);
                return v4 >= v || v5 != -1L && v3 >= wc1.b() + pe0.e + v5 - 1L ? xb0.a(v, v4, v4) : xb0.a(v, v4, pe0.d(v3 + 1L));
            }
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void a() {
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void b() {
        F6 f60 = this.p;
        if(f60 != null) {
            throw f60;
        }
        this.a.b();
    }

    public final ArrayList c() {
        List list0 = this.m.a(this.n).c;
        ArrayList arrayList0 = new ArrayList();
        int[] arr_v = this.b;
        for(int v = 0; v < arr_v.length; ++v) {
            arrayList0.addAll(((x0)list0.get(arr_v[v])).c);
        }
        return arrayList0;
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void g() {
        pe[] arr_pe = this.k;
        for(int v = 0; v < arr_pe.length; ++v) {
            pe pe0 = arr_pe[v];
        }
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void h(w3 w30) {
        if(!(w30 instanceof f7)) {
            if(w30 instanceof C7) {
                ++this.o;
            }
        label_14:
            b0 b00 = this.f;
            if(b00 != null) {
                if(b00.d == 0x8000000000000001L || w30.h > b00.d) {
                    b00.d = w30.h;
                }
                b00.e.g = true;
            }
        }
        else if(this.l.b(((f7)w30).d) >= 0) {
            int v = this.l.b(((f7)w30).d);
            pe[] arr_pe = this.k;
            pe pe0 = arr_pe[v];
            if(pe0.c == null) {
                N2 n20 = pe0.a;
                e1 e10 = n20.h instanceof e1 ? ((e1)n20.h) : null;
                if(e10 != null) {
                    H1 h10 = new H1(e10, pe0.b.c, 10);
                    arr_pe[v] = new pe(pe0.d, pe0.b, n20, pe0.e, h10);
                }
            }
            goto label_14;
        }
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final boolean i(w3 w30, boolean z, IOException iOException0, long v) {
        if(z) {
            b0 b00 = this.f;
            if(b00 != null) {
                boolean z1 = b00.d != 0x8000000000000001L && b00.d < w30.g;
                c0 c00 = b00.e;
                if(c00.f.d) {
                    if(c00.h) {
                        return true;
                    }
                    if(z1) {
                        if(c00.g) {
                            c00.h = true;
                            c00.g = false;
                            c00.b.b.Z.removeCallbacks(c00.b.b.G);
                            c00.b.b.z();
                            return true;
                        }
                        return true;
                    }
                }
            }
            if(!this.m.d && w30 instanceof C7 && iOException0 instanceof i8 && ((i8)iOException0).b == 404) {
                pe pe0 = this.k[this.l.b(w30.d)];
                long v1 = pe0.c.b(pe0.d);
                if(v1 != -1L && v1 != 0L) {
                    long v2 = pe0.c.b();
                    if(((C7)w30).a() > v2 + pe0.e + v1 - 1L) {
                        this.q = true;
                        return true;
                    }
                }
            }
            return v != 0x8000000000000001L && this.l.f(this.l.b(w30.d), v);
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final int j(long v, List list0) {
        if(this.p == null) {
            return this.l.c.length < 2 ? list0.size() : this.l.a(v, list0);
        }
        return list0.size();
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void k(long v, long v1, List list0, l l0) {
        Map map1;
        U8 u80;
        c c1;
        int v35;
        long v16;
        long v21;
        long v20;
        int v12;
        int v11;
        boolean z;
        if(this.p == null) {
            long v2 = b4.a(this.m.a);
            long v3 = b4.a(this.m.a(this.n).b);
            b0 b00 = this.f;
            if(b00 == null) {
                goto label_29;
            }
            c0 c00 = b00.e;
            p1 p10 = c00.f;
            fc fc0 = c00.b;
            if(!p10.d) {
                z = false;
            }
            else if(c00.h) {
                z = true;
            }
            else {
                Map.Entry map$Entry0 = c00.e.ceilingEntry(p10.h);
                if(map$Entry0 == null || ((long)(((Long)map$Entry0.getValue()))) >= v3 + v2 + v1) {
                    z = false;
                }
                else {
                    long v4 = (long)(((Long)map$Entry0.getKey()));
                    jc jc0 = fc0.b;
                    if(jc0.m0 == 0x8000000000000001L || jc0.m0 < v4) {
                        jc0.m0 = v4;
                    }
                    z = true;
                }
                if(z && c00.g) {
                    c00.h = true;
                    c00.g = false;
                    fc0.b.Z.removeCallbacks(fc0.b.G);
                    fc0.b.z();
                }
            }
            if(!z) {
            label_29:
                long v5 = b4.a(L7.h(this.e));
                long v6 = this.m.a;
                long v7 = v6 == 0x8000000000000001L ? 0x8000000000000001L : v5 - b4.a(v6 + this.m.a(this.n).b);
                C7 c70 = list0.isEmpty() ? null : ((C7)Z.h(1, list0));
                int v8 = this.l.c.length;
                c8[] arr_c8 = new c8[v8];
                int v9 = 0;
                while(v9 < v8) {
                    pe pe0 = this.k[v9];
                    Wc wc0 = pe0.c;
                    long v10 = pe0.d;
                    E4 e40 = c8.K;
                    if(wc0 == null) {
                        arr_c8[v9] = e40;
                        v11 = v8;
                        v12 = v9;
                    }
                    else {
                        v11 = v8;
                        v12 = v9;
                        long v13 = wc0.h(v10, v5) + pe0.e;
                        long v14 = pe0.b(v5);
                        long v15 = c70 == null ? L7.A(pe0.c.d(v1, v10) + pe0.e, v13, v14) : c70.a();
                        arr_c8[v12] = v15 < v13 ? e40 : new Vd(pe0, v15, v14);
                    }
                    v9 = v12 + 1;
                    v8 = v11;
                }
                if(this.m.d) {
                    long v17 = this.k[0].b(v5);
                    long v18 = this.k[0].c(v17);
                    p1 p11 = this.m;
                    long v19 = p11.a;
                    if(v19 == 0x8000000000000001L) {
                        v20 = v18;
                        v21 = 0x8000000000000001L;
                    }
                    else {
                        v21 = v5 - b4.a(v19 + p11.a(this.n).b);
                        v20 = v18;
                    }
                    v16 = Math.max(0L, Math.min(v21, v20) - v);
                }
                else {
                    v16 = 0x8000000000000001L;
                }
                this.l.d(v, v1 - v, v16, list0, arr_c8, this.o);
                pe[] arr_pe = this.k;
                pe pe1 = arr_pe[this.l.j()];
                N2 n20 = pe1.a;
                long v22 = pe1.d;
                Wc wc1 = pe1.c;
                z5 z50 = pe1.b;
                Md md0 = this.h;
                Map map0 = this.g;
                if(n20 != null) {
                    R4 r40 = n20.i == null ? z50.e : null;
                    R4 r41 = wc1 == null ? z50.i() : null;
                    if(r40 != null || r41 != null) {
                        u u0 = this.l.h();
                        int v23 = this.l.i();
                        Object object0 = this.l.m();
                        if(r40 == null) {
                            r40 = r41;
                        }
                        else {
                            R4 r42 = r40.a(r41, z50.b);
                            if(r42 != null) {
                                r40 = r42;
                            }
                        }
                        W2 w20 = M7.c(z50, r40, 0, map0);
                        E4 e41 = new E4(this.c, u0.h, -1L, 0x8000000000000001L);
                        c c0 = md0 == null ? null : new c(this, object0, this.c, e41, 2);
                        l0.c = new f7(this.d, w20, u0, v23, object0, pe1.a, c0);
                        return;
                    }
                }
                boolean z1 = false;
                int v24 = Long.compare(v22, 0x8000000000000001L);
                if(v24 != 0) {
                    z1 = true;
                }
                if(wc1.b(v22) == 0L) {
                    l0.b = z1;
                    return;
                }
                long v25 = wc1.h(v22, v5) + pe1.e;
                long v26 = pe1.b(v5);
                long v27 = c70 == null ? L7.A(wc1.d(v1, v22) + pe1.e, v25, v26) : c70.a();
                if(v27 < v25) {
                    this.p = new F6();  // 初始化器: Ljava/io/IOException;-><init>()V
                    return;
                }
                int v28 = Long.compare(v27, v26);
                if(v28 <= 0 && (!this.q || v28 < 0)) {
                    if(z1 && pe1.d(v27) >= v22) {
                        l0.b = true;
                        return;
                    }
                    int v29 = (int)Math.min(1L, v26 - v27 + 1L);
                    if(v24 != 0) {
                        while(v29 > 1 && pe1.d(((long)v29) + v27 - 1L) >= v22) {
                            --v29;
                        }
                    }
                    long v30 = list0.isEmpty() ? v1 : 0x8000000000000001L;
                    u u1 = this.l.h();
                    int v31 = this.l.i();
                    Object object1 = this.l.m();
                    long v32 = pe1.d(v27);
                    long v33 = pe1.c(v27);
                    R4 r43 = wc1.c(v27 - pe1.e);
                    String s = z50.b;
                    int v34 = this.c;
                    if(md0 == null) {
                        v35 = v34;
                        c1 = null;
                    }
                    else {
                        v35 = v34;
                        c1 = new c(md0, object1, v34, new E4(v34, u1.h, -1L, (v33 - v32) / 1000L), 3);
                    }
                    D0 d00 = this.d;
                    if(pe1.a == null) {
                        long v36 = pe1.c(v27);
                        u80 = new U8(d00, M7.c(z50, r43, (wc1.a() || v7 == 0x8000000000000001L || pe1.c(v27) <= v7 ? 0 : 8), map0), u1, v31, object1, v32, v36, v27, v35, u1, c1);
                    }
                    else {
                        int v37 = 1;
                        int v38 = 1;
                        while(true) {
                            if(v38 >= v29) {
                                map1 = map0;
                                break;
                            }
                            map1 = map0;
                            R4 r44 = r43.a(wc1.c(v27 + ((long)v38) - pe1.e), s);
                            if(r44 == null) {
                                break;
                            }
                            ++v37;
                            ++v38;
                            map0 = map1;
                            r43 = r44;
                        }
                        long v39 = v27 + ((long)v37) - 1L;
                        long v40 = pe1.c(v39);
                        u80 = new e6(d00, M7.c(z50, r43, (wc1.a() || v7 == 0x8000000000000001L || pe1.c(v39) <= v7 ? 0 : 8), map1), u1, v31, object1, v32, v40, v30, (v24 == 0 || v22 > v40 ? 0x8000000000000001L : v22), v27, v37, -z50.c, pe1.a, c1);
                    }
                    l0.c = u80;
                    return;
                }
                l0.b = z1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.w5
    public final void l(q2 q20) {
        q20.e(this.l.h(), this.l.i());
        this.l = q20;
        long v1 = this.k[0].e;
        int[] arr_v = q20.c;
        this.k = new pe[arr_v.length];
        ArrayList arrayList0 = this.c();
        long v2 = this.m.d(this.n);
        for(int v = 0; v < this.k.length; ++v) {
            Object object0 = arrayList0.get(arr_v[v]);
            pe[] arr_pe = this.k;
            arr_pe[v] = new pe(v2, ((z5)object0), Ma.b(this.c, ((z5)object0).a, this.i, this.j, this.f), v1, ((z5)object0).f());
        }
    }
}

