package i.n.i.b.a.s.e;

import Nf.p;
import U4.x;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.iloen.melon.custom.S0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Gb implements P4, a8, v0 {
    public final Gd B;
    public u0 D;
    public Q4[] E;
    public z[] G;
    public S0 I;
    public p1 M;
    public int N;
    public List S;
    public static final Pattern T;
    public static final Pattern V;
    public final int a;
    public final d3 b;
    public final g0 c;
    public final C2 d;
    public final p e;
    public final long f;
    public final Lb g;
    public final L3 h;
    public final wc i;
    public final Fb[] j;
    public final E4 k;
    public final c0 l;
    public final IdentityHashMap m;
    public final K2 n;
    public final X1 o;
    public final Map r;
    public final Md w;

    static {
        Gb.T = Pattern.compile("CC([1-4])=(.+)");
        Gb.V = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    }

    public Gb(int v, p1 p10, int v1, d3 d30, g0 g00, C2 c20, X1 x10, p p0, K2 k20, long v2, Lb lb0, L3 l30, E4 e40, fc fc0, Map map0, Md md0, Gd gd0) {
        int v28;
        int v27;
        u[] arr_u;
        int[][] arr2_v1;
        int v8;
        this.a = v;
        this.M = p10;
        this.N = v1;
        this.b = d30;
        this.c = g00;
        this.d = c20;
        this.o = x10;
        this.e = p0;
        this.n = k20;
        this.f = v2;
        this.g = lb0;
        this.h = l30;
        this.k = e40;
        this.l = new c0(p10, fc0, l30);
        this.B = gd0;
        this.r = map0;
        this.w = md0;
        this.E = new Q4[0];
        this.G = new z[0];
        this.m = new IdentityHashMap();
        Q4[] arr_q4 = this.E;
        e40.getClass();
        this.I = new S0(arr_q4, 27);
        g4 g40 = p10.a(v1);
        List list0 = g40.d;
        this.S = list0;
        List list1 = g40.c;
        int v4 = list1.size();
        SparseIntArray sparseIntArray0 = new SparseIntArray(v4);
        ArrayList arrayList0 = new ArrayList(v4);
        SparseArray sparseArray0 = new SparseArray(v4);
        for(int v5 = 0; v5 < v4; ++v5) {
            sparseIntArray0.put(((x0)list1.get(v5)).a, v5);
            ArrayList arrayList1 = new ArrayList();
            arrayList1.add(v5);
            arrayList0.add(arrayList1);
            sparseArray0.put(v5, arrayList1);
        }
        for(int v6 = 0; v6 < v4; ++v6) {
            x0 x00 = (x0)list1.get(v6);
            List list2 = x00.f;
            O2 o20 = Gb.e("http://dashif.org/guidelines/trickmode", x00.e);
            if(o20 == null) {
                o20 = Gb.e("http://dashif.org/guidelines/trickmode", list2);
            }
            if(o20 == null) {
                v8 = v6;
            }
            else {
                int v7 = sparseIntArray0.get(Integer.parseInt(o20.b), -1);
                if(v7 != -1) {
                    v8 = v7;
                }
            }
            if(v8 == v6) {
                O2 o21 = Gb.e("urn:mpeg:dash:adaptation-set-switching:2016", list2);
                if(o21 != null) {
                    String[] arr_s = o21.b.split(",", -1);
                    for(int v9 = 0; v9 < arr_s.length; ++v9) {
                        int v10 = sparseIntArray0.get(Integer.parseInt(arr_s[v9]), -1);
                        if(v10 != -1) {
                            v8 = Math.min(v8, v10);
                        }
                    }
                }
            }
            if(v8 != v6) {
                List list3 = (List)sparseArray0.get(v6);
                List list4 = (List)sparseArray0.get(v8);
                list4.addAll(list3);
                sparseArray0.put(v6, list4);
                arrayList0.remove(list3);
            }
        }
        int v11 = arrayList0.size();
        int[][] arr2_v = new int[v11][];
        for(int v12 = 0; v12 < v11; ++v12) {
            int[] arr_v = M7.x(((Collection)arrayList0.get(v12)));
            arr2_v[v12] = arr_v;
            Arrays.sort(arr_v);
        }
        boolean[] arr_z = new boolean[v11];
        u[][] arr2_u = new u[v11][];
        int v13 = 0;
        int v14 = 0;
        for(int v3 = 0; v13 < v11; v3 = 0) {
            int[] arr_v1 = arr2_v[v13];
            int v15 = 0;
        alab1:
            while(true) {
                if(v15 >= arr_v1.length) {
                    arr2_v1 = arr2_v;
                    break;
                }
                int v16 = arr_v1[v15];
                List list5 = ((x0)list1.get(v16)).c;
                arr2_v1 = arr2_v;
                while(v3 < list5.size()) {
                    if(!((z5)list5.get(v3)).d.isEmpty() || ((x0)list1.get(v16)).b == 2) {
                        arr_z[v13] = true;
                        ++v14;
                        break alab1;
                    }
                    ++v3;
                }
                ++v15;
                arr2_v = arr2_v1;
                v3 = 0;
            }
            int[] arr_v2 = arr2_v1[v13];
        alab2:
            for(int v17 = 0; true; ++v17) {
                if(v17 >= arr_v2.length) {
                    arr_u = new u[0];
                    break;
                }
                int v18 = arr_v2[v17];
                x0 x01 = (x0)list1.get(v18);
                List list6 = ((x0)list1.get(v18)).d;
                for(int v19 = 0; v19 < list6.size(); ++v19) {
                    O2 o22 = (O2)list6.get(v19);
                    if("urn:scte:dash:cc:cea-608:2015".equals(o22.a)) {
                        ob ob0 = new ob();
                        ob0.k = "application/cea-608";
                        StringBuilder stringBuilder0 = new StringBuilder();
                        ob0.a = x.g(x01.a, ":cea608", stringBuilder0);
                        u u0 = new u(ob0);
                        arr_u = Gb.f(o22, Gb.T, u0);
                        break alab2;
                    }
                    if("urn:scte:dash:cc:cea-708:2015".equals(o22.a)) {
                        ob ob1 = new ob();
                        ob1.k = "application/cea-708";
                        StringBuilder stringBuilder1 = new StringBuilder();
                        ob1.a = x.g(x01.a, ":cea708", stringBuilder1);
                        u u1 = new u(ob1);
                        arr_u = Gb.f(o22, Gb.V, u1);
                        break alab2;
                    }
                }
            }
            arr2_u[v13] = arr_u;
            if(arr_u.length != 0) {
                ++v14;
            }
            ++v13;
            arr2_v = arr2_v1;
        }
        int v20 = list0.size() + (v14 + v11);
        vc[] arr_vc = new vc[v20];
        Fb[] arr_fb = new Fb[v20];
        int v21 = 0;
        int v22;
        for(v22 = 0; v21 < v11; v22 = v28) {
            int[] arr_v3 = arr2_v[v21];
            ArrayList arrayList2 = new ArrayList();
            for(int v23 = 0; v23 < arr_v3.length; ++v23) {
                arrayList2.addAll(((x0)list1.get(arr_v3[v23])).c);
            }
            int v24 = arrayList2.size();
            u[] arr_u1 = new u[v24];
            for(int v25 = 0; v25 < v24; ++v25) {
                Object object0 = arrayList2.get(v25);
                Class class0 = c20.a(((z5)object0).a);
                ob ob2 = ((z5)object0).a.a();
                ob2.D = class0;
                arr_u1[v25] = new u(ob2);
            }
            x0 x02 = (x0)list1.get(arr_v3[0]);
            int v26 = v22 + 1;
            if(arr_z[v21]) {
                v27 = v22 + 2;
            }
            else {
                v27 = v26;
                v26 = -1;
            }
            if(arr2_u[v21].length == 0) {
                v28 = v27;
                v27 = -1;
            }
            else {
                v28 = v27 + 1;
            }
            arr_vc[v22] = new vc(arr_u1);
            arr_fb[v22] = new Fb(x02.b, 0, v22, v26, arr_v3, v27, -1);
            if(v26 != -1) {
                ob ob3 = new ob();
                StringBuilder stringBuilder2 = new StringBuilder();
                ob3.a = x.g(x02.a, ":emsg", stringBuilder2);
                ob3.k = "application/x-emsg";
                arr_vc[v26] = new vc(new u[]{new u(ob3)});
                arr_fb[v26] = new Fb(5, 1, v22, -1, arr_v3, -1, -1);
            }
            if(v27 != -1) {
                arr_vc[v27] = new vc(arr2_u[v21]);
                arr_fb[v27] = new Fb(3, 1, v22, -1, arr_v3, -1, -1);
            }
            ++v21;
        }
        int v29 = 0;
        while(v29 < list0.size()) {
            y3 y30 = (y3)list0.get(v29);
            ob ob4 = new ob();
            ob4.a = y30.a();
            ob4.k = "application/x-emsg";
            arr_vc[v22] = new vc(new u[]{new u(ob4)});
            arr_fb[v22] = new Fb(5, 2, -1, -1, new int[0], -1, v29);
            ++v29;
            ++v22;
        }
        Pair pair0 = Pair.create(new wc(arr_vc), arr_fb);
        this.i = (wc)pair0.first;
        this.j = (Fb[])pair0.second;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long a(long v, Xb xb0) {
        Q4[] arr_q4 = this.E;
        for(int v1 = 0; v1 < arr_q4.length; ++v1) {
            Q4 q40 = arr_q4[v1];
            if(q40.a == 2) {
                return q40.e.a(v, xb0);
            }
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a() {
        return this.I.a();
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final boolean a(long v) {
        return this.I.a(v);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long b(long v) {
        Q4[] arr_q4 = this.E;
        for(int v2 = 0; v2 < arr_q4.length; ++v2) {
            arr_q4[v2].i(v);
        }
        z[] arr_z = this.G;
        for(int v1 = 0; v1 < arr_z.length; ++v1) {
            z z0 = arr_z[v1];
            int v3 = L7.g(z0.c, v, true);
            z0.g = v3;
            z0.h = !z0.d || v3 != z0.c.length ? 0x8000000000000001L : v;
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final void b(long v) {
        this.I.b(v);
    }

    @Override  // i.n.i.b.a.s.e.a8
    public final void b(b8 b80) {
        this.D.b(this);
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long c() {
        return this.I.c();
    }

    public final int d(int v, int[] arr_v) {
        int v1 = arr_v[v];
        if(v1 != -1) {
            Fb[] arr_fb = this.j;
            int v2 = arr_fb[v1].e;
            for(int v3 = 0; v3 < arr_v.length; ++v3) {
                int v4 = arr_v[v3];
                if(v4 == v2 && arr_fb[v4].c == 0) {
                    return v3;
                }
            }
        }
        return -1;
    }

    public static O2 e(String s, List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            O2 o20 = (O2)list0.get(v);
            if(s.equals(o20.a)) {
                return o20;
            }
        }
        return null;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long e() {
        return 0L;
    }

    public static u[] f(O2 o20, Pattern pattern0, u u0) {
        String s = o20.b;
        if(s == null) {
            return new u[]{u0};
        }
        String[] arr_s = s.split(";", -1);
        u[] arr_u = new u[arr_s.length];
        for(int v = 0; v < arr_s.length; ++v) {
            Matcher matcher0 = pattern0.matcher(arr_s[v]);
            if(!matcher0.matches()) {
                return new u[]{u0};
            }
            int v1 = Integer.parseInt(matcher0.group(1));
            ob ob0 = u0.a();
            ob0.a = u0.a + ":" + v1;
            ob0.C = v1;
            ob0.c = matcher0.group(2);
            arr_u[v] = new u(ob0);
        }
        return arr_u;
    }

    @Override  // i.n.i.b.a.s.e.b8
    public final long f() {
        return this.I.f();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long g() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final wc h() {
        return this.i;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void k() {
        this.g.b();
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long l() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void l(u0 u00, long v) {
        this.D = u00;
        u00.c(this);
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long m() {
        return 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final boolean m(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7) {
        for(int v = 0; v < arr_q2.length; ++v) {
            B7 b70 = arr_b7[v];
            q2 q20 = arr_q2[v];
            if(b70 != null && q20 != null && arr_z[v]) {
                b70.c(q20);
            }
        }
        return true;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final long v(q2[] arr_q2, boolean[] arr_z, B7[] arr_b7, boolean[] arr_z1, long v) {
        int[] arr_v5;
        int v11;
        vc vc1;
        int v9;
        vc vc0;
        int v6;
        int[] arr_v1;
        int[] arr_v = new int[arr_q2.length];
        for(int v1 = 0; v1 < arr_q2.length; ++v1) {
            q2 q20 = arr_q2[v1];
            arr_v[v1] = q20 == null ? -1 : this.i.a(q20.a);
        }
        for(int v2 = 0; v2 < arr_q2.length; ++v2) {
            if(arr_q2[v2] == null || !arr_z[v2]) {
                B7 b70 = arr_b7[v2];
                if(b70 instanceof Q4) {
                    ((Q4)b70).g(this);
                }
                else if(b70 instanceof O4) {
                    M7.J(((O4)b70).e.d[((O4)b70).c]);
                    ((O4)b70).e.d[((O4)b70).c] = false;
                }
                arr_b7[v2] = null;
            }
        }
        for(int v3 = 0; true; ++v3) {
            boolean z = true;
            if(v3 >= arr_q2.length) {
                break;
            }
            B7 b71 = arr_b7[v3];
            if(b71 instanceof dc || b71 instanceof O4) {
                int v4 = this.d(v3, arr_v);
                if(v4 == -1) {
                    z = arr_b7[v3] instanceof dc;
                }
                else {
                    B7 b72 = arr_b7[v3];
                    if(!(b72 instanceof O4) || ((O4)b72).a != arr_b7[v4]) {
                        z = false;
                    }
                }
                if(!z) {
                    B7 b73 = arr_b7[v3];
                    if(b73 instanceof O4) {
                        M7.J(((O4)b73).e.d[((O4)b73).c]);
                        ((O4)b73).e.d[((O4)b73).c] = false;
                    }
                    arr_b7[v3] = null;
                }
            }
        }
        int v5 = 0;
        while(v5 < arr_q2.length) {
            q2 q21 = arr_q2[v5];
            if(q21 == null) {
                arr_v1 = arr_v;
                v6 = v5;
            }
            else {
                B7 b74 = arr_b7[v5];
                if(b74 == null) {
                    arr_z1[v5] = true;
                    Fb fb0 = this.j[arr_v[v5]];
                    int v7 = fb0.c;
                    if(v7 == 0) {
                        int v8 = fb0.f;
                        if(v8 == -1) {
                            v9 = 0;
                            vc0 = null;
                        }
                        else {
                            vc0 = this.i.b[v8];
                            v9 = 1;
                        }
                        int v10 = fb0.g;
                        if(v10 == -1) {
                            vc1 = null;
                        }
                        else {
                            vc1 = this.i.b[v10];
                            v9 += vc1.a;
                        }
                        u[] arr_u = new u[v9];
                        int[] arr_v2 = new int[v9];
                        if(v8 == -1) {
                            v11 = 0;
                        }
                        else {
                            arr_u[0] = vc0.b[0];
                            arr_v2[0] = 5;
                            v11 = 1;
                        }
                        ArrayList arrayList0 = new ArrayList();
                        if(v10 != -1) {
                            for(int v12 = 0; v12 < vc1.a; ++v12) {
                                u u0 = vc1.b[v12];
                                arr_u[v11] = u0;
                                arr_v2[v11] = 3;
                                arrayList0.add(u0);
                                ++v11;
                            }
                        }
                        b0 b00 = !this.M.d || v8 == -1 ? null : new b0(this.l, this.l.a);
                        Lb lb0 = this.g;
                        p1 p10 = this.M;
                        int v13 = this.N;
                        int[] arr_v3 = fb0.a;
                        int v14 = fb0.b;
                        long v15 = this.f;
                        g0 g00 = this.c;
                        arr_v1 = arr_v;
                        Map map0 = this.r;
                        Md md0 = this.w;
                        D0 d00 = this.b.a.a();
                        if(g00 != null) {
                            d00.l(g00);
                        }
                        qe qe0 = new qe(lb0, p10, v13, arr_v3, q21, v14, d00, v15, v8 != -1, arrayList0, b00, map0, md0);
                        v6 = v5;
                        Q4 q40 = new Q4(fb0.b, arr_v2, arr_u, qe0, this, this.h, v, this.d, this.o, this.e, this.n, this.w, this.B);
                        synchronized(this) {
                            this.m.put(q40, b00);
                        }
                        arr_b7[v6] = q40;
                    }
                    else {
                        arr_v1 = arr_v;
                        v6 = v5;
                        if(v7 == 2) {
                            arr_b7[v6] = new z(((y3)this.S.get(fb0.d)), q21.a.b[0], this.M.d);
                        }
                    }
                }
                else {
                    arr_v1 = arr_v;
                    v6 = v5;
                    if(b74 instanceof Q4) {
                        ((qe)((Q4)b74).e).l = q21;
                    }
                }
            }
            v5 = v6 + 1;
            arr_v = arr_v1;
        }
        int[] arr_v4 = arr_v;
        int v17 = 0;
        while(v17 < arr_q2.length) {
            if(arr_b7[v17] != null || arr_q2[v17] == null) {
                arr_v5 = arr_v4;
            }
            else {
                Fb fb1 = this.j[arr_v4[v17]];
                if(fb1.c == 1) {
                    arr_v5 = arr_v4;
                    int v18 = this.d(v17, arr_v5);
                    if(v18 == -1) {
                        arr_b7[v17] = new dc();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    else {
                        Q4 q41 = (Q4)arr_b7[v18];
                        int v19 = fb1.b;
                        boolean[] arr_z2 = q41.d;
                        e7[] arr_e7 = q41.n;
                        int v20 = 0;
                        while(v20 < arr_e7.length) {
                            if(q41.b[v20] == v19) {
                                M7.J(!arr_z2[v20]);
                                arr_z2[v20] = true;
                                arr_e7[v20].r(v, true);
                                arr_b7[v17] = new O4(q41, q41, arr_e7[v20], v20);
                                goto label_154;
                            }
                            ++v20;
                        }
                        throw new IllegalStateException();
                    }
                }
            }
        label_154:
            ++v17;
            arr_v4 = arr_v5;
        }
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for(int v21 = 0; v21 < arr_b7.length; ++v21) {
            B7 b75 = arr_b7[v21];
            if(b75 instanceof Q4) {
                arrayList1.add(((Q4)b75));
            }
            else if(b75 instanceof z) {
                arrayList2.add(((z)b75));
            }
        }
        Q4[] arr_q4 = new Q4[arrayList1.size()];
        this.E = arr_q4;
        arrayList1.toArray(arr_q4);
        z[] arr_z3 = new z[arrayList2.size()];
        this.G = arr_z3;
        arrayList2.toArray(arr_z3);
        Q4[] arr_q41 = this.E;
        this.k.getClass();
        this.I = new S0(arr_q41, 27);
        return v;
    }

    @Override  // i.n.i.b.a.s.e.v0
    public final void w(long v, boolean z) {
        Q4[] arr_q4 = this.E;
        for(int v1 = 0; v1 < arr_q4.length; ++v1) {
            arr_q4[v1].w(v, z);
        }
    }
}

