package G1;

import F1.c;
import F1.d;
import F1.e;
import F1.f;
import F1.j;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class i {
    public static final b a;

    static {
        i.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static boolean a(e e0) {
        d[] arr_d = e0.V;
        d d0 = arr_d[0];
        d d1 = arr_d[1];
        f f0 = e0.W == null ? null : ((f)e0.W);
        d d2 = d.a;
        if(f0 != null) {
            d d3 = f0.V[0];
        }
        if(f0 != null) {
            d d4 = f0.V[1];
        }
        boolean z = d0 == d2 || e0.C() || d0 == d.b || d0 == d.c && e0.s == 0 && e0.Z == 0.0f && e0.v(0) || d0 == d.c && e0.s == 1 && e0.w(0, e0.s());
        boolean z1 = d1 == d2 || e0.D() || d1 == d.b || d1 == d.c && e0.t == 0 && e0.Z == 0.0f && e0.v(1) || d1 == d.c && e0.t == 1 && e0.w(1, e0.m());
        return e0.Z > 0.0f && (z || z1) || z && z1;
    }

    public static o b(e e0, int v, ArrayList arrayList0, o o0) {
        int v1 = v == 0 ? e0.t0 : e0.u0;
        int v2 = 0;
        if(v1 != -1 && (o0 == null || v1 != o0.b)) {
            for(int v3 = 0; v3 < arrayList0.size(); ++v3) {
                o o1 = (o)arrayList0.get(v3);
                if(o1.b == v1) {
                    if(o0 != null) {
                        o0.c(v, o1);
                        arrayList0.remove(o0);
                    }
                    o0 = o1;
                    break;
                }
            }
        }
        else if(v1 != -1) {
            return o0;
        }
        if(o0 == null) {
            if(e0 instanceof j) {
                for(int v4 = 0; true; ++v4) {
                    int v5 = -1;
                    if(v4 >= ((j)e0).w0) {
                        break;
                    }
                    e e1 = ((j)e0).v0[v4];
                    if(v == 0) {
                        int v6 = e1.t0;
                        if(v6 != -1) {
                            v5 = v6;
                            break;
                        }
                    }
                    if(v == 1) {
                        int v7 = e1.u0;
                        if(v7 != -1) {
                            v5 = v7;
                            break;
                        }
                    }
                }
                if(v5 != -1) {
                    for(int v8 = 0; v8 < arrayList0.size(); ++v8) {
                        o o2 = (o)arrayList0.get(v8);
                        if(o2.b == v5) {
                            o0 = o2;
                            break;
                        }
                    }
                }
            }
            if(o0 == null) {
                o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
                o0.a = new ArrayList();
                o0.d = null;
                o0.e = -1;
                int v9 = o.f;
                o.f = v9 + 1;
                o0.b = v9;
                o0.c = v;
            }
            arrayList0.add(o0);
        }
        int v10 = o0.b;
        ArrayList arrayList1 = o0.a;
        if(arrayList1.contains(e0)) {
            return o0;
        }
        arrayList1.add(e0);
        if(e0 instanceof F1.i) {
            c c0 = ((F1.i)e0).y0;
            if(((F1.i)e0).z0 == 0) {
                v2 = 1;
            }
            c0.c(v2, o0, arrayList0);
        }
        if(v == 0) {
            e0.t0 = v10;
            e0.K.c(0, o0, arrayList0);
            e0.M.c(0, o0, arrayList0);
        }
        else {
            e0.u0 = v10;
            e0.L.c(v, o0, arrayList0);
            e0.O.c(v, o0, arrayList0);
            e0.N.c(v, o0, arrayList0);
        }
        e0.R.c(v, o0, arrayList0);
        return o0;
    }

    public static void c(int v, e e0, G1.c c0, boolean z) {
        if(e0.n) {
            return;
        }
        if(!(e0 instanceof f) && e0.B() && i.a(e0)) {
            f.c0(e0, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        c c1 = e0.k(2);
        c c2 = e0.k(4);
        int v1 = c1.d();
        int v2 = c2.d();
        HashSet hashSet0 = c1.a;
        d d0 = d.c;
        if(hashSet0 != null && c1.c) {
            for(Object object0: hashSet0) {
                c c3 = (c)object0;
                e e1 = c3.d;
                boolean z1 = i.a(e1);
                c c4 = e1.K;
                c c5 = e1.M;
                if(e1.B() && z1) {
                    f.c0(e1, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                boolean z2 = c3 == c4 && (c5.f != null && c5.f.c) || c3 == c5 && (c4.f != null && c4.f.c);
                d d1 = e1.V[0];
                if(d1 == d0 && !z1) {
                    if(d1 != d0 || e1.w < 0 || e1.v < 0 || e1.j0 != 8 && (e1.s != 0 || e1.Z != 0.0f) || e1.z() || e1.H || !z2 || e1.z()) {
                        continue;
                    }
                    i.e(v + 1, e0, c0, e1, z);
                }
                else if(e1.B()) {
                }
                else if(c3 == c4 && c5.f == null) {
                    int v3 = c4.e();
                    e1.M(v3 + v1, e1.s() + (v3 + v1));
                    i.c(v + 1, e1, c0, z);
                }
                else if(c3 == c5 && c4.f == null) {
                    int v4 = c5.e();
                    e1.M(v1 - v4 - e1.s(), v1 - v4);
                    i.c(v + 1, e1, c0, z);
                }
                else if(z2 && !e1.z()) {
                    i.d(v + 1, e1, c0, z);
                }
            }
        }
        if(e0 instanceof F1.i) {
            return;
        }
        HashSet hashSet1 = c2.a;
        if(hashSet1 != null && c2.c) {
            for(Object object1: hashSet1) {
                c c6 = (c)object1;
                e e2 = c6.d;
                boolean z3 = i.a(e2);
                c c7 = e2.K;
                c c8 = e2.M;
                if(e2.B() && z3) {
                    f.c0(e2, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                boolean z4 = c6 == c7 && (c8.f != null && c8.f.c) || c6 == c8 && (c7.f != null && c7.f.c);
                d d2 = e2.V[0];
                if(d2 == d0 && !z3) {
                    if(d2 != d0 || e2.w < 0 || e2.v < 0 || e2.j0 != 8 && (e2.s != 0 || e2.Z != 0.0f) || e2.z() || e2.H || !z4 || e2.z()) {
                        continue;
                    }
                    i.e(v + 1, e0, c0, e2, z);
                }
                else if(e2.B()) {
                }
                else if(c6 == c7 && c8.f == null) {
                    int v5 = c7.e();
                    e2.M(v5 + v2, e2.s() + (v5 + v2));
                    i.c(v + 1, e2, c0, z);
                }
                else if(c6 == c8 && c7.f == null) {
                    int v6 = c8.e();
                    e2.M(v2 - v6 - e2.s(), v2 - v6);
                    i.c(v + 1, e2, c0, z);
                }
                else if(z4 && !e2.z()) {
                    i.d(v + 1, e2, c0, z);
                }
            }
        }
        e0.n = true;
    }

    public static void d(int v, e e0, G1.c c0, boolean z) {
        float f = e0.g0;
        int v1 = e0.K.f.d();
        int v2 = e0.M.f.d();
        int v3 = e0.K.e();
        int v4 = e0.M.e();
        if(v1 == v2) {
            f = 0.5f;
        }
        else {
            v1 = v3 + v1;
            v2 -= v4;
        }
        int v5 = e0.s();
        int v6 = v1 <= v2 ? v2 - v1 - v5 : v1 - v2 - v5;
        int v7 = ((int)(v6 <= 0 ? f * ((float)v6) : f * ((float)v6) + 0.5f)) + v1;
        e0.M(v7, (v1 <= v2 ? v7 + v5 : v7 - v5));
        i.c(v + 1, e0, c0, z);
    }

    public static void e(int v, e e0, G1.c c0, e e1, boolean z) {
        float f = e1.g0;
        int v1 = e1.K.f.d();
        int v2 = e1.K.e() + v1;
        int v3 = e1.M.f.d() - e1.M.e();
        if(v3 >= v2) {
            int v4 = e1.s();
            if(e1.j0 != 8) {
                int v5 = e1.s;
                if(v5 == 2) {
                    int v6 = e0 instanceof f ? e0.s() : e0.W.s();
                    v4 = (int)(e1.g0 * 0.5f * ((float)v6));
                }
                else if(v5 == 0) {
                    v4 = v3 - v2;
                }
                v4 = Math.max(e1.v, v4);
                int v7 = e1.w;
                if(v7 > 0) {
                    v4 = Math.min(v7, v4);
                }
            }
            int v8 = v2 + ((int)(f * ((float)(v3 - v2 - v4)) + 0.5f));
            e1.M(v8, v4 + v8);
            i.c(v + 1, e1, c0, z);
        }
    }

    public static void f(int v, e e0, G1.c c0) {
        float f = e0.h0;
        int v1 = e0.L.f.d();
        int v2 = e0.N.f.d();
        int v3 = e0.L.e();
        int v4 = e0.N.e();
        if(v1 == v2) {
            f = 0.5f;
        }
        else {
            v1 = v3 + v1;
            v2 -= v4;
        }
        int v5 = e0.m();
        int v6 = v1 <= v2 ? v2 - v1 - v5 : v1 - v2 - v5;
        float f1 = v6 <= 0 ? f * ((float)v6) : f * ((float)v6) + 0.5f;
        int v7 = v1 + ((int)f1);
        int v8 = v7 + v5;
        if(v1 > v2) {
            v7 = v1 - ((int)f1);
            v8 = v7 - v5;
        }
        e0.N(v7, v8);
        i.i(v + 1, e0, c0);
    }

    public static void g(int v, e e0, G1.c c0, e e1) {
        float f = e1.h0;
        int v1 = e1.L.f.d();
        int v2 = e1.L.e() + v1;
        int v3 = e1.N.f.d() - e1.N.e();
        if(v3 >= v2) {
            int v4 = e1.m();
            if(e1.j0 != 8) {
                int v5 = e1.t;
                if(v5 == 2) {
                    v4 = (int)(f * 0.5f * ((float)(e0 instanceof f ? e0.m() : e0.W.m())));
                }
                else if(v5 == 0) {
                    v4 = v3 - v2;
                }
                v4 = Math.max(e1.y, v4);
                int v6 = e1.z;
                if(v6 > 0) {
                    v4 = Math.min(v6, v4);
                }
            }
            int v7 = v2 + ((int)(f * ((float)(v3 - v2 - v4)) + 0.5f));
            e1.N(v7, v4 + v7);
            i.i(v + 1, e1, c0);
        }
    }

    // 去混淆评级： 低(40)
    public static boolean h(d d0, d d1, d d2, d d3) {
        return d2 == d.a || d2 == d.b || d2 == d.d && d0 != d.b || (d3 == d.a || d3 == d.b || d3 == d.d && d1 != d.b);
    }

    public static void i(int v, e e0, G1.c c0) {
        if(e0.o) {
            return;
        }
        if(!(e0 instanceof f) && e0.B() && i.a(e0)) {
            f.c0(e0, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        c c1 = e0.k(3);
        c c2 = e0.k(5);
        int v1 = c1.d();
        int v2 = c2.d();
        HashSet hashSet0 = c1.a;
        d d0 = d.c;
        if(hashSet0 != null && c1.c) {
            for(Object object0: hashSet0) {
                c c3 = (c)object0;
                e e1 = c3.d;
                boolean z = i.a(e1);
                c c4 = e1.L;
                c c5 = e1.N;
                if(e1.B() && z) {
                    f.c0(e1, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                boolean z1 = c3 == c4 && (c5.f != null && c5.f.c) || c3 == c5 && (c4.f != null && c4.f.c);
                d d1 = e1.V[1];
                if(d1 == d0 && !z) {
                    if(d1 != d0 || e1.z < 0 || e1.y < 0 || e1.j0 != 8 && (e1.t != 0 || e1.Z != 0.0f) || e1.A() || e1.H || !z1 || e1.A()) {
                        continue;
                    }
                    i.g(v + 1, e0, c0, e1);
                }
                else if(e1.B()) {
                }
                else if(c3 == c4 && c5.f == null) {
                    int v3 = c4.e();
                    e1.N(v3 + v1, e1.m() + (v3 + v1));
                    i.i(v + 1, e1, c0);
                }
                else if(c3 == c5 && c4.f == null) {
                    int v4 = c5.e();
                    e1.N(v1 - v4 - e1.m(), v1 - v4);
                    i.i(v + 1, e1, c0);
                }
                else if(z1 && !e1.A()) {
                    i.f(v + 1, e1, c0);
                }
            }
        }
        if(e0 instanceof F1.i) {
            return;
        }
        HashSet hashSet1 = c2.a;
        if(hashSet1 != null && c2.c) {
            for(Object object1: hashSet1) {
                c c6 = (c)object1;
                e e2 = c6.d;
                boolean z2 = i.a(e2);
                c c7 = e2.L;
                c c8 = e2.N;
                if(e2.B() && z2) {
                    f.c0(e2, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                boolean z3 = c6 == c7 && (c8.f != null && c8.f.c) || c6 == c8 && (c7.f != null && c7.f.c);
                d d2 = e2.V[1];
                if(d2 == d0 && !z2) {
                    if(d2 != d0 || e2.z < 0 || e2.y < 0 || e2.j0 != 8 && (e2.t != 0 || e2.Z != 0.0f) || e2.A() || e2.H || !z3 || e2.A()) {
                        continue;
                    }
                    i.g(v + 1, e0, c0, e2);
                }
                else if(e2.B()) {
                }
                else if(c6 == c7 && c8.f == null) {
                    int v5 = c7.e();
                    e2.N(v5 + v2, e2.m() + (v5 + v2));
                    i.i(v + 1, e2, c0);
                }
                else if(c6 == c8 && c7.f == null) {
                    int v6 = c8.e();
                    e2.N(v2 - v6 - e2.m(), v2 - v6);
                    i.i(v + 1, e2, c0);
                }
                else if(z3 && !e2.A()) {
                    i.f(v + 1, e2, c0);
                }
            }
        }
        c c9 = e0.k(6);
        if(c9.a != null && c9.c) {
            int v7 = c9.d();
            for(Object object2: c9.a) {
                c c10 = (c)object2;
                e e3 = c10.d;
                boolean z4 = i.a(e3);
                c c11 = e3.O;
                if(e3.B() && z4) {
                    f.c0(e3, c0, new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                if((e3.V[1] != d0 || z4) && !e3.B() && c10 == c11) {
                    int v8 = c10.e() + v7;
                    if(e3.F) {
                        int v9 = v8 - e3.d0;
                        int v10 = e3.Y + v9;
                        e3.c0 = v9;
                        e3.L.l(v9);
                        e3.N.l(v10);
                        c11.l(v8);
                        e3.m = true;
                    }
                    i.i(v + 1, e3, c0);
                }
            }
        }
        e0.o = true;
    }
}

