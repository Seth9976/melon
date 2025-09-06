package i.n.i.b.a.s.e;

import android.net.Uri;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bd {
    public final re a;
    public final D0 b;
    public final D0 c;
    public final l6 d;
    public final Uri[] e;
    public final u[] f;
    public final W8 g;
    public final vc h;
    public final List i;
    public final Ga j;
    public final Map k;
    public final Map l;
    public final Md m;
    public final Gd n;
    public final int o;
    public boolean p;
    public byte[] q;
    public F6 r;
    public Uri s;
    public boolean t;
    public q2 u;
    public long v;
    public boolean w;
    public int x;

    public bd(re re0, W8 w80, Uri[] arr_uri, u[] arr_u, d3 d30, g0 g00, l6 l60, List list0, Map map0, Map map1, Md md0, int v, Gd gd0) {
        q2 q21;
        this.a = re0;
        this.g = w80;
        this.e = arr_uri;
        this.f = arr_u;
        this.d = l60;
        this.i = list0;
        this.j = new Ga(4);
        this.q = L7.g;
        this.v = 0x8000000000000001L;
        this.k = map0;
        this.l = map1;
        this.m = md0;
        this.o = v;
        this.n = gd0;
        D0 d00 = d30.a();
        this.b = d00;
        if(g00 != null) {
            d00.l(g00);
        }
        this.c = d30.a();
        this.h = new vc(arr_u);
        ArrayList arrayList0 = new ArrayList();
        int v1 = 0;
        for(int v2 = 0; v2 < arr_uri.length; ++v2) {
            if((arr_u[v2].e & 0x4000) == 0) {
                arrayList0.add(v2);
            }
        }
        vc vc0 = this.h;
        int[] arr_v = M7.x(arrayList0);
        Zc zc0 = new Zc(vc0, arr_v, 0);  // 初始化器: Li/n/i/b/a/s/e/q2;-><init>(Li/n/i/b/a/s/e/vc;[II)V
        u u0 = null;
        u[] arr_u1 = zc0.d;
        int v3 = zc0.b;
        if(gd0.b != -1) {
            while(v1 < v3) {
                u u1 = arr_u1[v1];
                if(u1.h != -1 && u1.h < gd0.b) {
                    u0 = u1;
                    break;
                }
                ++v1;
            }
            zc0.g = u0 == null ? v3 - 1 : zc0.b(u0);
        }
        else if(gd0.c == -1) {
            zc0.g = zc0.b(vc0.b[arr_v[0]]);
        }
        else {
            while(v1 < v3) {
                u u2 = arr_u1[v1];
                if(u2.h != -1 && gd0.c < u2.h && (u0 == null || u0.h > u2.h)) {
                    u0 = u2;
                }
                ++v1;
            }
            zc0.g = u0 == null ? v3 - 1 : zc0.b(u0);
        }
        this.u = zc0;
        if(md0 != null) {
            int[] arr_v1 = M7.x(arrayList0);
            vc vc1 = this.h;
            if(vc1.a > 1) {
                q2 q20 = this.u;
                q21 = new U4(vc1, arr_v1, new E4(21), md0, q20, v, (v == 0 ? 2 : v), true);
            }
            else {
                q21 = this.u;
            }
            this.u = q21;
        }
    }

    public final int a(d0 d00) {
        int v = d00.w;
        if(v != -1) {
            int v1 = this.h.a(d00.d);
            Ua ua0 = this.g.b(this.e[v1], false);
            ua0.getClass();
            h9 h90 = ua0.p;
            int v2 = (int)(d00.l - ua0.i);
            if(v2 >= 0) {
                h9 h91 = v2 >= h90.size() ? ua0.q : ((Ra)h90.get(v2)).m;
                if(v < h91.size()) {
                    Pa pa0 = (Pa)h91.get(v);
                    if(pa0.m) {
                        return 0;
                    }
                    return L7.p(Uri.parse(Ja.r(ua0.a, pa0.a)), d00.b.b) ? 1 : 2;
                }
                return 2;
            }
        }
        return 1;
    }

    public final Pair b(d0 d00, boolean z, Ua ua0, long v, long v1) {
        long v7;
        boolean z1 = true;
        int v2 = -1;
        if(d00 != null) {
            long v3 = d00.l;
            int v4 = d00.w;
            if(!z) {
                if(d00.g0) {
                    if(v4 == -1) {
                        v3 = d00.a();
                    }
                    Long long0 = v3;
                    if(v4 != -1) {
                        v2 = v4 + 1;
                    }
                    return new Pair(long0, v2);
                }
                return new Pair(v3, v4);
            }
        }
        h9 h90 = ua0.q;
        h9 h91 = ua0.p;
        long v5 = ua0.i;
        long v6 = v + ua0.s;
        Gd gd0 = this.n;
        if(d00 == null || this.t) {
            v7 = v1;
        }
        else if(gd0.G) {
            v7 = d00.h;
        }
        else {
            v7 = d00.g;
        }
        if(!ua0.m && v7 >= v6) {
            return new Pair(((long)(v5 + ((long)h91.size()))), -1);
        }
        long v8 = v7 - v;
        Long long1 = v8;
        if(this.g.w && d00 != null) {
            z1 = false;
        }
        int v10 = L7.x(h91, long1, z1);
        long v11 = ((long)v10) + v5;
        long v12 = 1L;
        if(gd0.G && d00 != null) {
            long v13 = d00.a();
            if(v13 >= ((long)h91.size()) + v5) {
                v13 = ((long)h91.size()) + v5 - 1L;
            }
            v11 = v13;
            v10 = (int)(v11 - v5);
        }
        if(v10 >= 0) {
            Ra ra0 = (Ra)h91.get(v10);
            h9 h92 = v8 >= ra0.e + ra0.c ? h90 : ra0.m;
            for(int v9 = 0; v9 < h92.size(); ++v9) {
                Pa pa0 = (Pa)h92.get(v9);
                if(v8 < pa0.e + pa0.c) {
                    if(!pa0.l) {
                        break;
                    }
                    if(h92 != h90) {
                        v12 = 0L;
                    }
                    return new Pair(((long)(v11 + v12)), v9);
                }
            }
        }
        return new Pair(v11, -1);
    }

    public final Xc c(Uri uri0, int v) {
        if(uri0 == null) {
            return null;
        }
        Ga ga0 = this.j;
        byte[] arr_b = (byte[])((kc)ga0.b).remove(uri0);
        if(arr_b != null) {
            byte[] arr_b1 = (byte[])((kc)ga0.b).put(uri0, arr_b);
            return null;
        }
        W2 w20 = new W2(uri0, 1, null, this.l, 0L, -1L, null, 1, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L);
        if(this.m != null) {
            HashMap hashMap0 = M7.o(this.l);
            try {
                W2 w21 = w20.a();
                w21.b = uri0;
                w21.e = hashMap0;
                w20 = w21.d();
            }
            catch(Id unused_ex) {
            }
        }
        this.n.getClass();
        u u0 = this.f[v];
        int v1 = this.u.i();
        Object object0 = this.u.m();
        byte[] arr_b2 = this.q;
        Xc xc0 = new Xc(this.c, w20, 3, u0, v1, object0, 0x8000000000000001L, 0x8000000000000001L);  // 初始化器: Li/n/i/b/a/s/e/w3;-><init>(Li/n/i/b/a/s/e/D0;Li/n/i/b/a/s/e/W2;ILi/n/i/b/a/s/e/u;ILjava/lang/Object;JJ)V
        if(arr_b2 == null) {
            arr_b2 = L7.g;
        }
        xc0.l = arr_b2;
        return xc0;
    }

    public final c8[] d(d0 d00, long v) {
        List list0;
        int v1 = d00 == null ? -1 : this.h.a(d00.d);
        int v2 = this.u.c.length;
        c8[] arr_c8 = new c8[v2];
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = this.u.c[v3];
            Uri uri0 = this.e[v4];
            W8 w80 = this.g;
            if(w80.d(uri0)) {
                Ua ua0 = w80.b(uri0, false);
                ua0.getClass();
                long v5 = ua0.f - w80.B;
                Pair pair0 = this.b(d00, v4 != v1, ua0, v5, v);
                long v6 = (long)(((Long)pair0.first));
                int v7 = (int)(((Integer)pair0.second));
                h9 h90 = ua0.q;
                h9 h91 = ua0.p;
                int v8 = (int)(v6 - ua0.i);
                if(v8 < 0 || h91.size() < v8) {
                    list0 = c5.e;
                }
                else {
                    ArrayList arrayList0 = new ArrayList();
                    if(v8 < h91.size()) {
                        if(v7 != -1) {
                            Ra ra0 = (Ra)h91.get(v8);
                            if(v7 == 0) {
                                arrayList0.add(ra0);
                            }
                            else if(v7 < ra0.m.size()) {
                                arrayList0.addAll(ra0.m.subList(v7, ra0.m.size()));
                            }
                            ++v8;
                        }
                        arrayList0.addAll(h91.subList(v8, h91.size()));
                        v7 = 0;
                    }
                    if(ua0.l != 0x8000000000000001L) {
                        if(v7 == -1) {
                            v7 = 0;
                        }
                        if(v7 < h90.size()) {
                            arrayList0.addAll(h90.subList(v7, h90.size()));
                        }
                    }
                    list0 = Collections.unmodifiableList(arrayList0);
                }
                arr_c8[v3] = new Yc(v5, list0);
            }
            else {
                arr_c8[v3] = c8.K;
            }
        }
        return arr_c8;
    }
}

