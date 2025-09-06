package i.n.i.b.a.s.e;

import Nf.p;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.exoplayer.j0;
import com.facebook.appevents.c;
import com.iloen.melon.custom.S0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class r1 implements Ad, a8, v0 {
    public int B;
    public wc D;
    public D3[] E;
    public D3[] G;
    public int I;
    public S0 M;
    public final Gd N;
    public final E4 S;
    public boolean T;
    public q1[] V;
    public String[] W;
    public String[] X;
    public String[] Y;
    public boolean[] Z;
    public final re a;
    public final W8 b;
    public boolean b0;
    public final d3 c;
    public boolean c0;
    public final g0 d;
    public final C2 e;
    public final X1 f;
    public final p g;
    public final K2 h;
    public final L3 i;
    public final IdentityHashMap j;
    public final l6 k;
    public final E4 l;
    public final int m;
    public final Map n;
    public final Map o;
    public final Md r;
    public u0 w;

    public r1(re re0, W8 w80, d3 d30, g0 g00, C2 c20, X1 x10, p p0, K2 k20, L3 l30, E4 e40, int v, Map map0, Map map1, Md md0, Gd gd0, E4 e41) {
        this.b0 = false;
        this.c0 = false;
        this.a = re0;
        this.b = w80;
        this.c = d30;
        this.d = g00;
        this.e = c20;
        this.f = x10;
        this.g = p0;
        this.h = k20;
        this.i = l30;
        this.l = e40;
        this.m = v;
        e40.getClass();
        this.M = new S0(new b8[0], 27);
        this.n = map0;
        this.o = map1;
        this.r = md0;
        this.N = gd0;
        this.S = e41;
        this.j = new IdentityHashMap();
        this.k = new l6(e41);
        this.E = new D3[0];
        this.G = new D3[0];
        this.V = new q1[0];
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.M.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        if(this.D == null) {
            D3[] arr_d3 = this.E;
            for(int v1 = 0; v1 < arr_d3.length; ++v1) {
                D3 d30 = arr_d3[v1];
                if(!d30.b0) {
                    d30.a(d30.o0);
                }
            }
            return false;
        }
        return this.M.a(v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        D3[] arr_d3 = this.G;
        if(arr_d3.length > 0) {
            boolean z = arr_d3[0].j(v, false);
            for(int v1 = 1; true; ++v1) {
                D3[] arr_d31 = this.G;
                if(v1 >= arr_d31.length) {
                    break;
                }
                arr_d31[v1].j(v, z);
            }
            if(z) {
                this.k.a.clear();
            }
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.M.b(v);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        D3 d30 = (D3)b80;
        this.w.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        return this.M.c();
    }

    public final int d(String s) {
        for(int v = 0; true; ++v) {
            D3[] arr_d3 = this.E;
            if(v >= arr_d3.length) {
                break;
            }
            b x8$b0 = null;
            D3 d30 = arr_d3[v];
            d30.p();
            x8 x80 = d30.h0.b[d30.k0].b[0].j;
            if(x80 != null) {
                for(int v1 = 0; true; ++v1) {
                    b[] arr_x8$b = x80.a;
                    if(v1 >= arr_x8$b.length) {
                        break;
                    }
                    b x8$b1 = arr_x8$b[v1];
                    if(x8$b1.getClass().isAssignableFrom(hf.class)) {
                        x8$b0 = x8$b1;
                        break;
                    }
                }
            }
            if(((hf)x8$b0) != null && TextUtils.equals(((hf)x8$b0).b, s)) {
                return v;
            }
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        SparseArray sparseArray0 = this.k.a;
        r6 r60 = sparseArray0.size() >= 0 ? ((r6)sparseArray0.get(sparseArray0.keyAt(0))) : null;
        return r60 == null ? 0L : r60.c();
    }

    public final D3 e(int v, Uri[] arr_uri, u[] arr_u, u u0, List list0, Map map0, long v1) {
        bd bd0 = new bd(this.a, this.b, arr_uri, arr_u, this.c, this.d, this.k, list0, this.n, this.o, this.r, v, this.N);
        C3 c30 = new C3();  // 初始化器: Ljava/lang/Object;-><init>()V
        c30.a = false;
        c30.b = 0L;
        return new D3(v, this, bd0, map0, this.i, v1, u0, this.e, this.f, this.g, this.h, this.m, this.r, this.N, c30, this.S);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.M.f();
    }

    public final void f(q2[] arr_q2, int[] arr_v) {
        if(this.T) {
            String s = null;
            String s1 = null;
            String s2 = null;
            for(int v = 0; v < arr_q2.length; ++v) {
                q2 q20 = arr_q2[v];
                if(q20 != null) {
                    vc vc0 = q20.a;
                    D3[] arr_d3 = this.E;
                    for(int v1 = 0; v1 < arr_d3.length; ++v1) {
                        D3 d30 = arr_d3[v1];
                        d30.p();
                        wc wc0 = d30.h0;
                        int v2 = wc0.a(vc0);
                        if(v2 != -1) {
                            b x8$b0 = null;
                            x8 x80 = wc0.b[v2].b[0].j;
                            if(x80 != null) {
                                for(int v3 = 0; true; ++v3) {
                                    b[] arr_x8$b = x80.a;
                                    if(v3 >= arr_x8$b.length) {
                                        break;
                                    }
                                    b x8$b1 = arr_x8$b[v3];
                                    if(x8$b1.getClass().isAssignableFrom(hf.class)) {
                                        x8$b0 = x8$b1;
                                        break;
                                    }
                                }
                            }
                            if(((hf)x8$b0) != null) {
                                String s3 = ((hf)x8$b0).b;
                                if(s3 == null) {
                                }
                                else if(this.W != null && Arrays.asList(this.W).contains(s3)) {
                                    s = s3;
                                }
                                else if(this.X != null && Arrays.asList(this.X).contains(s3)) {
                                    s1 = s3;
                                }
                                else if(this.Y != null && Arrays.asList(this.Y).contains(s3)) {
                                    s2 = s3;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            if(s != null || s1 != null || s2 != null) {
                int v4 = s == null ? -1 : this.d(s);
                for(int v5 = 0; v5 < arr_q2.length; ++v5) {
                    q2 q21 = arr_q2[v5];
                    if(q21 != null) {
                        String s4 = q21.d[0].l;
                        if(!mb.j(s4) || s == null) {
                            if(!mb.h(s4)) {
                                if(!mb.i(s4)) {
                                    arr_v[v5] = v4;
                                }
                                else if(s2 != null) {
                                    int v8 = this.d(s2);
                                    if(v8 != -1) {
                                        arr_v[v5] = v8;
                                    }
                                }
                                else if(v4 != -1) {
                                    D3 d32 = this.E[v4];
                                    d32.p();
                                    wc wc2 = d32.h0;
                                    for(int v9 = 0; v9 < wc2.a; ++v9) {
                                        if(mb.i(wc2.b[v9].b[0].l)) {
                                            arr_v[v5] = v4;
                                            break;
                                        }
                                    }
                                }
                            }
                            else if(s1 != null) {
                                int v6 = this.d(s1);
                                if(v6 != -1) {
                                    arr_v[v5] = v6;
                                }
                            }
                            else if(v4 != -1) {
                                D3 d31 = this.E[v4];
                                d31.p();
                                wc wc1 = d31.h0;
                                for(int v7 = 0; v7 < wc1.a; ++v7) {
                                    if(mb.h(wc1.b[v7].b[0].l)) {
                                        arr_v[v5] = v4;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(v4 != -1) {
                            arr_v[v5] = v4;
                        }
                    }
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return this.b.B;
    }

    public final void g(B7[] arr_b7, e7[] arr_e7, boolean[] arr_z) {
        if(this.N.c0) {
            for(int v = 0; v < arr_b7.length; ++v) {
                B7 b70 = arr_b7[v];
                q1[] arr_q1 = this.V;
                q1 q10 = arr_q1[v];
                if(b70 == null) {
                    arr_q1[v] = null;
                }
                else if(q10 != null) {
                    if(arr_e7 != null) {
                        e7 e70 = arr_e7[v];
                        ArrayList arrayList0 = q10.a;
                        q10.b = b70;
                        if(e70 != null) {
                            if(arrayList0.size() == 0) {
                                q10.e = e70.D();
                            }
                            arrayList0.add(e70);
                        }
                        q10.d = true;
                        q10.c = 0x8000000000000001L;
                    }
                    arr_b7[v] = q10;
                    if(arr_z != null) {
                        arr_z[v] = false;
                    }
                }
                else {
                    q1 q11 = new q1(b70);
                    arr_b7[v] = q11;
                    this.V[v] = q11;
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        wc wc0 = this.D;
        wc0.getClass();
        return wc0;
    }

    public final void h(B7[] arr_b7) {
        if(this.N.c0) {
            if(this.V.length == 0) {
                this.V = new q1[arr_b7.length];
            }
            for(int v = 0; v < arr_b7.length; ++v) {
                q1 q10 = (q1)arr_b7[v];
                if(q10 != null) {
                    arr_b7[v] = q10.b;
                }
            }
        }
    }

    public final void i() {
        int v9;
        int v = this.B - 1;
        this.B = v;
        if(v > 0) {
            return;
        }
        D3[] arr_d3 = this.E;
        int v2 = 0;
        for(int v1 = 0; v1 < arr_d3.length; ++v1) {
            D3 d30 = arr_d3[v1];
            d30.p();
            v2 += d30.h0.a;
        }
        vc[] arr_vc = new vc[v2];
        D3[] arr_d31 = this.E;
        for(int v3 = 0; v3 < arr_d31.length; ++v3) {
            D3 d31 = arr_d31[v3];
            d31.p();
            int v5 = d31.h0.a;
            int v6 = 0;
            for(int v4 = 0; v6 < v5; ++v4) {
                d31.p();
                arr_vc[v4] = d31.h0.b[v6];
                ++v6;
            }
        }
        this.D = new wc(arr_vc);
        if(this.T) {
            ArrayList arrayList0 = new ArrayList();
            for(int v7 = 0; true; ++v7) {
                D3[] arr_d32 = this.E;
                if(v7 >= arr_d32.length) {
                    break;
                }
                D3 d32 = arr_d32[v7];
                d32.p();
                wc wc0 = d32.h0;
                for(int v8 = 0; true; ++v8) {
                    d32.p();
                    if(v8 >= d32.h0.a) {
                        break;
                    }
                    String s = wc0.b[v8].b[0].l;
                    if(s != null) {
                        if(!mb.j(s)) {
                            if(!mb.h(s)) {
                                if(s.equals("application/cea-608")) {
                                    v9 = 0;
                                }
                            }
                            else if(v7 != 0) {
                                v9 = !this.b0;
                            }
                        }
                        else if(v7 == 0) {
                            v9 = !this.c0;
                        }
                        else {
                            v9 = 1;
                        }
                        if(v9 != 0) {
                            arrayList0.add(wc0.b[v8]);
                        }
                    }
                }
            }
            this.D = new wc(((vc[])arrayList0.toArray(new vc[0])));
        }
        this.w.c(this);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        D3[] arr_d3 = this.E;
        for(int v = 0; v < arr_d3.length; ++v) {
            D3 d30 = arr_d3[v];
            d30.y();
            if(d30.s0 && !d30.b0) {
                throw new H4("Loading finished before preparation is complete.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        int v13;
        HashSet hashSet3;
        ArrayList arrayList11;
        int v9;
        HashSet hashSet1;
        ArrayList arrayList6;
        ArrayList arrayList5;
        ArrayList arrayList7;
        u[] arr_u1;
        boolean z1;
        boolean z;
        this.w = u00;
        this.b.getClass();
        this.b.g.add(this);
        va va0 = this.b.n;
        va0.getClass();
        List list0 = va0.h;
        List list1 = va0.f;
        List list2 = va0.g;
        List list3 = va0.e;
        Map map0 = Collections.EMPTY_MAP;
        this.B = 0;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        if(!list3.isEmpty()) {
            int v1 = list3.size();
            int[] arr_v = new int[v1];
            int v2 = 0;
            int v4 = 0;
            for(int v3 = 0; v3 < list3.size(); ++v3) {
                u u0 = ((ua)list3.get(v3)).b;
                String s = u0.i;
                if(u0.B > 0 || L7.D(2, s) != null) {
                    arr_v[v3] = 2;
                    ++v4;
                }
                else if(L7.D(1, s) == null) {
                    arr_v[v3] = -1;
                }
                else {
                    arr_v[v3] = 1;
                    ++v2;
                }
            }
            if(v4 > 0) {
                v1 = v4;
                z = false;
                z1 = true;
            }
            else if(v2 < v1) {
                v1 -= v2;
                z1 = false;
                z = true;
            }
            else {
                z1 = false;
                z = false;
            }
            Uri[] arr_uri = new Uri[v1];
            u[] arr_u = new u[v1];
            int[] arr_v1 = new int[v1];
            int v5 = 0;
            int v6 = 0;
            while(v5 < list3.size()) {
                if(z1) {
                    arr_u1 = arr_u;
                    if(arr_v[v5] == 2) {
                        goto label_56;
                    }
                }
                else {
                    arr_u1 = arr_u;
                label_56:
                    if(!z || arr_v[v5] != 1) {
                        ua ua0 = (ua)list3.get(v5);
                        arr_uri[v6] = ua0.a;
                        arr_u1[v6] = ua0.b;
                        arr_v1[v6] = v5;
                        ++v6;
                    }
                }
                ++v5;
                arr_u = arr_u1;
            }
            String s1 = arr_u[0].i;
            L7.w(2, s1);
            boolean z2 = L7.w(1, s1) > 1;
            arrayList0.add(this.e(0, arr_uri, arr_u, va0.i, va0.j, map0, v));
            arrayList1.add(arr_v1);
        }
        if(this.N.b0 && list1.size() > 0) {
            HashMap hashMap0 = new HashMap();
            for(Object object0: list3) {
                ua ua1 = (ua)object0;
                String s2 = ua1.c;
                if(s2 != null) {
                    int v7 = ua1.b.h;
                    if(v7 != -1) {
                        hashMap0.put(s2, v7);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(list1.size());
            ArrayList arrayList3 = new ArrayList(list1.size());
            ArrayList arrayList4 = new ArrayList(list1.size());
            HashSet hashSet0 = new HashSet();
            boolean z3 = false;
            int v8 = 0;
            while(v8 < list1.size()) {
                String s3 = ((ta)list1.get(v8)).d;
                if(hashSet0.add(s3)) {
                    arrayList2.clear();
                    arrayList3.clear();
                    arrayList4.clear();
                    int v10 = 0;
                    while(v10 < list1.size()) {
                        if(s3.equals(((ta)list1.get(v10)).d)) {
                            ta ta0 = (ta)list1.get(v10);
                            arrayList4.add(v10);
                            arrayList7 = arrayList4;
                            u u1 = ta0.b;
                            arrayList2.add(ta0.a);
                            String s4 = ta0.c;
                            if(hashMap0.containsKey(s4)) {
                                int v11 = (int)(((Integer)hashMap0.get(s4)));
                                ob ob0 = u1.a();
                                ob0.f = v11;
                                ob0.g = v11;
                                u1 = new u(ob0);
                            }
                            arrayList3.add(u1);
                        }
                        else {
                            arrayList7 = arrayList4;
                        }
                        ++v10;
                        arrayList4 = arrayList7;
                    }
                    arrayList6 = arrayList4;
                    hashSet1 = hashSet0;
                    arrayList5 = arrayList3;
                    v9 = v8;
                    D3 d30 = this.e(2, ((Uri[])arrayList2.toArray(new Uri[0])), ((u[])arrayList3.toArray(new u[0])), null, Collections.EMPTY_LIST, map0, v);
                    arrayList1.add(M7.x(arrayList6));
                    arrayList0.add(d30);
                    z3 = true;
                }
                else {
                    arrayList5 = arrayList3;
                    arrayList6 = arrayList4;
                    hashSet1 = hashSet0;
                    v9 = v8;
                }
                v8 = v9 + 1;
                arrayList3 = arrayList5;
                arrayList4 = arrayList6;
                hashSet0 = hashSet1;
            }
            this.T = z3;
        }
        ArrayList arrayList8 = new ArrayList(list2.size());
        ArrayList arrayList9 = new ArrayList(list2.size());
        ArrayList arrayList10 = new ArrayList(list2.size());
        HashSet hashSet2 = new HashSet();
        int v12 = 0;
        while(v12 < list2.size()) {
            String s5 = ((ta)list2.get(v12)).d;
            if(hashSet2.add(s5)) {
                arrayList8.clear();
                arrayList9.clear();
                arrayList10.clear();
                for(int v14 = 0; v14 < list2.size(); ++v14) {
                    if(s5.equals(((ta)list2.get(v14)).d)) {
                        ta ta1 = (ta)list2.get(v14);
                        arrayList10.add(v14);
                        arrayList8.add(ta1.a);
                        arrayList9.add(ta1.b);
                        L7.w(1, ta1.b.i);
                    }
                }
                v13 = v12;
                hashSet3 = hashSet2;
                arrayList11 = arrayList10;
                D3 d31 = this.e(1, ((Uri[])arrayList8.toArray(new Uri[0])), ((u[])arrayList9.toArray(new u[0])), null, Collections.EMPTY_LIST, map0, v);
                arrayList1.add(M7.x(arrayList11));
                arrayList0.add(d31);
            }
            else {
                arrayList11 = arrayList10;
                hashSet3 = hashSet2;
                v13 = v12;
            }
            v12 = v13 + 1;
            arrayList10 = arrayList11;
            hashSet2 = hashSet3;
        }
        this.I = arrayList0.size();
        for(int v15 = 0; v15 < list0.size(); ++v15) {
            ta ta2 = (ta)list0.get(v15);
            D3 d32 = this.e(3, new Uri[]{ta2.a}, new u[]{ta2.b}, null, Collections.EMPTY_LIST, map0, v);
            arrayList1.add(new int[]{v15});
            arrayList0.add(d32);
            d32.h0 = d32.e(new vc[]{new vc(new u[]{ta2.b})});
            d32.i0 = new HashSet();
            d32.k0 = 0;
            c c0 = new c(d32.b, 28);
            d32.w.post(c0);
            d32.b0 = true;
        }
        this.E = (D3[])arrayList0.toArray(new D3[0]);
        int[][] arr2_v = (int[][])arrayList1.toArray(new int[0][]);
        D3[] arr_d3 = this.E;
        this.B = arr_d3.length;
        arr_d3[0].c.p = true;
        for(int v16 = 0; v16 < arr_d3.length; ++v16) {
            D3 d33 = arr_d3[v16];
            if(!d33.b0) {
                d33.a(d33.o0);
            }
        }
        this.G = this.E;
        if(this.T) {
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            for(Object object1: list1) {
                hashSet4.add(((ta)object1).d);
            }
            this.W = (String[])hashSet4.toArray(new String[0]);
            for(Object object2: list2) {
                hashSet5.add(((ta)object2).d);
            }
            this.X = (String[])hashSet5.toArray(new String[0]);
            for(Object object3: list0) {
                hashSet6.add(((ta)object3).d);
            }
            this.Y = (String[])hashSet6.toArray(new String[0]);
            this.c0 = this.W.length != 0;
            this.b0 = this.X.length == 0;
            this.Z = new boolean[this.E.length];
            for(int v17 = 0; v17 < this.E.length; ++v17) {
                boolean[] arr_z = this.Z;
                arr_z[v17] = true;
                if(this.c0 && v17 == 0) {
                    arr_z[0] = false;
                }
            }
            if(this.Z != null) {
                ArrayList arrayList12 = new ArrayList(this.Z.length);
                for(int v18 = 0; true; ++v18) {
                    boolean[] arr_z1 = this.Z;
                    if(v18 >= arr_z1.length) {
                        break;
                    }
                    if(arr_z1[v18]) {
                        arrayList12.add(((D3)arrayList0.get(v18)));
                    }
                }
                this.G = (D3[])arrayList12.toArray(new D3[0]);
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        this.h(arr_b7);
        int[] arr_v = new int[arr_q2.length];
        for(int v = 0; v < arr_q2.length; ++v) {
            B7 b70 = arr_b7[v];
            q2 q20 = arr_q2[v];
            if(b70 != null && q20 != null) {
                vc vc0 = q20.a;
                for(int v1 = 0; true; ++v1) {
                    D3[] arr_d3 = this.E;
                    if(v1 >= arr_d3.length) {
                        break;
                    }
                    D3 d30 = arr_d3[v1];
                    d30.p();
                    if(d30.h0.a(vc0) != -1) {
                        arr_v[v] = v1;
                        break;
                    }
                }
            }
        }
        this.f(arr_q2, arr_v);
        q2[] arr_q21 = new q2[arr_q2.length];
        for(int v2 = 0; v2 < this.E.length; ++v2) {
            for(int v3 = 0; v3 < arr_q2.length; ++v3) {
                arr_q21[v3] = arr_v[v3] == v2 ? arr_q2[v3] : null;
            }
            D3 d31 = this.E[v2];
            d31.getClass();
            for(int v4 = 0; v4 < arr_q2.length; ++v4) {
                if(arr_z[v4]) {
                    q2 q21 = arr_q21[v4];
                    if(q21 != null) {
                        if(d31.h0.a(q21.a) == d31.k0) {
                            q21.e(d31.c.u.h(), d31.c.u.i());
                            d31.c.u = q21;
                        }
                        d31.x0 = true;
                    }
                }
            }
        }
        this.g(arr_b7, null, null);
        return true;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        Gd gd3;
        D3[] arr_d34;
        B7[] arr_b74;
        int v36;
        boolean z4;
        int v34;
        IdentityHashMap identityHashMap3;
        e7[] arr_e73;
        int v33;
        D3[] arr_d33;
        int v32;
        B7[] arr_b73;
        int v31;
        bd bd1;
        D3 d32;
        int[] arr_v2;
        int v26;
        D3[] arr_d32;
        q2[] arr_q22;
        int v22;
        e7[] arr_e72;
        B7 b72;
        IdentityHashMap identityHashMap1;
        G6 g60;
        e7[] arr_e71;
        Gd gd1;
        Looper looper1;
        IdentityHashMap identityHashMap0;
        this.h(arr_b7);
        int[] arr_v = new int[arr_q2.length];
        int[] arr_v1 = new int[arr_q2.length];
        for(int v1 = 0; true; ++v1) {
            identityHashMap0 = this.j;
            if(v1 >= arr_q2.length) {
                break;
            }
            B7 b70 = arr_b7[v1];
            arr_v[v1] = b70 == null ? -1 : ((int)(((Integer)identityHashMap0.get(b70))));
            arr_v1[v1] = -1;
            q2 q20 = arr_q2[v1];
            if(q20 != null) {
                vc vc0 = q20.a;
                for(int v2 = 0; true; ++v2) {
                    D3[] arr_d3 = this.E;
                    if(v2 >= arr_d3.length) {
                        break;
                    }
                    D3 d30 = arr_d3[v2];
                    d30.p();
                    if(d30.h0.a(vc0) != -1) {
                        arr_v1[v1] = v2;
                        break;
                    }
                }
            }
        }
        this.f(arr_q2, arr_v1);
        Gd gd0 = this.N;
        Looper looper0 = null;
        if(gd0.c0) {
            e7[] arr_e7 = new e7[arr_q2.length];
            int v3 = 0;
            while(v3 < arr_q2.length) {
                B7 b71 = arr_b7[v3];
                if(b71 == null || arr_v[v3] == -1 || arr_v1[v3] == -1) {
                    gd1 = gd0;
                    arr_e71 = arr_e7;
                    identityHashMap1 = identityHashMap0;
                    looper1 = looper0;
                }
                else {
                    e7 e70 = new e7(new L3(), looper0, ((C2)looper0), ((X1)looper0));
                    arr_e7[v3] = e70;
                    e70.y = false;
                    ea.b b0 = new ea.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    looper1 = looper0;
                    gd1 = gd0;
                    I8 i80 = new I8(1);
                    i80.r(0x200000);
                    arr_e71 = arr_e7;
                    if(b71.b(b0, i80, 2) != -3) {
                        e70.a(((u)b0.b));
                        long v4 = 0x8000000000000001L;
                        while(true) {
                            i80.o();
                            int v5 = b71.b(b0, i80, 0);
                            if(v5 == -5) {
                                e70.a(((u)b0.b));
                            }
                            else {
                                if(v5 != -4) {
                                    break;
                                }
                                long v6 = v4 == 0x8000000000000001L ? i80.f + 8000000L : v4;
                                if(i80.f > v6) {
                                    break;
                                }
                                int v7 = i80.d.position();
                                i80.d.position(0);
                                int v8 = i80.f(0x80000000) ? 0x80000000 : 0;
                                int v9 = i80.f(4) ? 4 : 0;
                                boolean z = i80.f(1);
                                int v10 = i80.f(0x40000000) ? 0x40000000 : 0;
                                int v11 = i80.f(0x2000000) ? 0x2000000 : 0;
                                byte[] arr_b = i80.d.array();
                                int v12 = v7;
                                int v13 = 0;
                                while(true) {
                                    g60 = e70.a;
                                    if(v12 <= 0) {
                                        break;
                                    }
                                    int v14 = g60.f(v12);
                                    j0 j00 = (j0)g60.g;
                                    System.arraycopy(arr_b, v13, ((Z8)j00.d).a, j00.c(g60.b), v14);
                                    v13 += v14;
                                    v12 -= v14;
                                    g60.c(v14);
                                }
                                g60.getClass();
                                e70.f(i80.f, v8 | v9 | z | v10 | v11, v7, 0, null);
                                v4 = v6;
                            }
                        }
                    }
                    identityHashMap1 = identityHashMap0;
                }
                ++v3;
                looper0 = looper1;
                gd0 = gd1;
                arr_e7 = arr_e71;
                identityHashMap0 = identityHashMap1;
            }
            b72 = looper0;
            arr_e72 = arr_e7;
        }
        else {
            b72 = null;
            arr_e72 = null;
        }
        Gd gd2 = gd0;
        IdentityHashMap identityHashMap2 = identityHashMap0;
        identityHashMap2.clear();
        B7[] arr_b71 = new B7[arr_q2.length];
        int v15 = arr_q2.length;
        B7[] arr_b72 = new B7[v15];
        q2[] arr_q21 = new q2[arr_q2.length];
        D3[] arr_d31 = new D3[this.E.length];
        int v16 = arr_q2.length;
        int v17 = 0;
        boolean z1 = false;
        int v18 = 0;
        while(v17 < this.E.length) {
            for(int v19 = 0; v19 < arr_q2.length; ++v19) {
                arr_b72[v19] = arr_v[v19] == v17 ? arr_b7[v19] : b72;
                q2 q21 = arr_v1[v19] == v17 ? arr_q2[v19] : b72;
                arr_q21[v19] = q21;
            }
            D3 d31 = this.E[v17];
            boolean z2 = this.T;
            d31.p();
            boolean z3 = z2;
            sa sa0 = d31.i;
            bd bd0 = d31.c;
            ArrayList arrayList0 = d31.m;
            int v20 = d31.c0;
            int v21 = 0;
            while(v21 < arr_q2.length) {
                P2 p20 = (P2)arr_b72[v21];
                if(p20 == null || arr_q21[v21] != null && arr_z[v21]) {
                    v22 = v15;
                    arr_q22 = arr_q21;
                }
                else {
                    v22 = v15;
                    --d31.c0;
                    arr_q22 = arr_q21;
                    if(p20.c != -1) {
                        p20.b.p();
                        p20.b.j0.getClass();
                        int v23 = p20.b.j0[p20.a];
                        M7.J(p20.b.m0[v23]);
                        p20.b.m0[v23] = false;
                        p20.c = -1;
                    }
                    arr_b72[v21] = b72;
                }
                ++v21;
                v15 = v22;
                arr_q21 = arr_q22;
            }
            q2[] arr_q23 = arr_q21;
            q2 q22 = bd0.u;
            int v24 = z1 || (d31.r0 ? v20 == 0 : v != d31.o0) ? 1 : 0;
            q2 q23 = q22;
            int v25 = 0;
            while(v25 < arr_q2.length) {
                q2 q24 = arr_q23[v25];
                if(q24 == null) {
                    arr_d32 = arr_d31;
                    v26 = v17;
                    arr_v2 = arr_v1;
                }
                else {
                    vc vc1 = q24.a;
                    arr_d32 = arr_d31;
                    int v27 = d31.h0.a(vc1);
                    v26 = v17;
                    if(v27 != -1 || !z3) {
                        arr_v2 = arr_v1;
                    }
                    else {
                        wc wc0 = d31.h0;
                        arr_v2 = arr_v1;
                        int v28 = 0;
                        while(true) {
                            if(v28 < wc0.a) {
                                if(wc0.b[v28].equals(vc1)) {
                                    break;
                                }
                                else {
                                    ++v28;
                                    continue;
                                }
                            }
                            v28 = -1;
                            break;
                        }
                        v27 = v28;
                    }
                    if(v27 == d31.k0) {
                        q24.e(bd0.u.h(), bd0.u.i());
                        bd0.u = q24;
                        q23 = q24;
                    }
                    if(arr_b72[v25] == null) {
                        ++d31.c0;
                        P2 p21 = new P2(d31, v27);
                        arr_b72[v25] = p21;
                        arr_z1[v25] = true;
                        if(d31.j0 != null) {
                            p21.a();
                            if(v24 == 0) {
                                B3 b30 = d31.N[d31.j0[v27]];
                                v24 = b30.r(v, true) || b30.C() == 0 ? 0 : 1;
                            }
                        }
                    }
                }
                ++v25;
                arr_d31 = arr_d32;
                v17 = v26;
                arr_v1 = arr_v2;
            }
            long v29 = 0L;
            int[] arr_v3 = arr_v1;
            if(d31.c0 == 0) {
                bd0.r = b72;
                d31.e0 = b72;
                d31.q0 = true;
                arrayList0.clear();
                if(sa0.m()) {
                    if(d31.Z) {
                        B3[] arr_b3 = d31.N;
                        for(int v30 = 0; v30 < arr_b3.length; ++v30) {
                            arr_b3[v30].v();
                        }
                    }
                    sa0.f();
                }
                else {
                    d31.z();
                }
                d32 = d31;
                bd1 = bd0;
                v31 = v16;
                arr_b73 = arr_b71;
                v32 = v15;
                arr_d33 = arr_d31;
                v33 = v17;
                arr_e73 = arr_e72;
                identityHashMap3 = identityHashMap2;
            }
            else {
                if(arrayList0.isEmpty() || L7.p(q23, q22)) {
                    d32 = d31;
                    bd1 = bd0;
                    v31 = v16;
                    arr_b73 = arr_b71;
                    v34 = v15;
                    arr_d33 = arr_d31;
                    v33 = v17;
                    arr_e73 = arr_e72;
                    identityHashMap3 = identityHashMap2;
                }
                else if(!d31.r0) {
                    if(v < 0L) {
                        v29 = -v;
                    }
                    d0 d00 = d31.s();
                    c8[] arr_c8 = bd0.d(d00, v);
                    bd1 = bd0;
                    v31 = v16;
                    arr_b73 = arr_b71;
                    d32 = d31;
                    v34 = v15;
                    arr_d33 = arr_d31;
                    v33 = v17;
                    arr_e73 = arr_e72;
                    identityHashMap3 = identityHashMap2;
                    q23.d(v, v29, 0x8000000000000001L, d31.n, arr_c8, 0);
                    int v35 = bd1.h.a(d00.d);
                    if(q23.c[q23.j()] != v35) {
                        d32.q0 = true;
                        z4 = true;
                        v36 = 1;
                        goto label_265;
                    }
                }
                else {
                    d32 = d31;
                    bd1 = bd0;
                    v31 = v16;
                    arr_b73 = arr_b71;
                    v34 = v15;
                    arr_d33 = arr_d31;
                    v33 = v17;
                    arr_e73 = arr_e72;
                    identityHashMap3 = identityHashMap2;
                    d32.q0 = true;
                    z4 = true;
                    v36 = 1;
                    goto label_265;
                }
                z4 = z1;
                v36 = v24;
            label_265:
                if(v36 == 0) {
                    v32 = v34;
                }
                else {
                    if(d32.E.a0) {
                        d32.z0.getClass();
                    }
                    d32.j(v, z4);
                    v32 = v34;
                    for(int v37 = 0; v37 < v32; ++v37) {
                        if(arr_b72[v37] != null) {
                            arr_z1[v37] = true;
                        }
                    }
                }
                v24 = v36;
            }
            ArrayList arrayList1 = d32.B;
            arrayList1.clear();
            for(int v38 = 0; v38 < v32; ++v38) {
                B7 b73 = arr_b72[v38];
                if(b73 != null) {
                    arrayList1.add(((P2)b73));
                }
            }
            d32.r0 = true;
            int v39 = 0;
            boolean z5 = false;
            while(v39 < arr_q2.length) {
                B7 b74 = arr_b72[v39];
                if(arr_v3[v39] == v33) {
                    b74.getClass();
                    arr_b74 = arr_b73;
                    arr_b74[v39] = b74;
                    identityHashMap3.put(b74, v33);
                    z5 = true;
                }
                else {
                    arr_b74 = arr_b73;
                    if(arr_v[v39] == v33) {
                        M7.J(b74 == null);
                    }
                }
                ++v39;
                arr_b73 = arr_b74;
            }
            if(z5) {
                int v40 = v18;
                arr_d34 = arr_d33;
                arr_d34[v40] = d32;
                v18 = v40 + 1;
                if(v40 == 0) {
                    bd1.p = true;
                    if(v24 == 0 && (this.G.length != 0 && d32 == this.G[0])) {
                        gd3 = gd2;
                    }
                    else {
                        gd3 = gd2;
                        if(!gd3.c0) {
                            this.k.a.clear();
                            z1 = true;
                        }
                    }
                }
                else {
                    gd3 = gd2;
                    bd1.p = v33 < this.I;
                }
            }
            else {
                gd3 = gd2;
                arr_d34 = arr_d33;
            }
            v17 = v33 + 1;
            gd2 = gd3;
            arr_d31 = arr_d34;
            v15 = v32;
            arr_b71 = arr_b73;
            identityHashMap2 = identityHashMap3;
            arr_e72 = arr_e73;
            v16 = v31;
        }
        this.g(arr_b71, arr_e72, arr_z1);
        System.arraycopy(arr_b71, 0, arr_b7, 0, v16);
        D3[] arr_d35 = (D3[])L7.s(v18, arr_d31);
        this.G = arr_d35;
        this.l.getClass();
        this.M = new S0(arr_d35, 27);
        return v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        D3[] arr_d3 = this.G;
        for(int v1 = 0; v1 < arr_d3.length; ++v1) {
            D3 d30 = arr_d3[v1];
            if(d30.Z && !d30.u()) {
                int v2 = d30.N.length;
                for(int v3 = 0; v3 < v2; ++v3) {
                    d30.N[v3].p(v, z, d30.m0[v3]);
                }
            }
        }
    }
}

