package androidx.compose.foundation.lazy.layout;

import G.f;
import G.p;
import I.J1;
import O.y;
import Q.K;
import d5.n;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.H;
import ne.a;
import r1.c;

public abstract class P {
    public static final float a;
    public static final float b;
    public static final float c;

    static {
        P.a = 2500.0f;
        P.b = 1500.0f;
        P.c = 50.0f;
    }

    // 去混淆评级： 低(40)
    public static final boolean a(boolean z, y y0, int v, int v1) {
        return z ? y0.c() > v || y0.c() == v && y0.d() > v1 : y0.c() < v || y0.c() == v && y0.d() < v1;
    }

    public static final Object b(y y0, int v, int v1, int v2, c c0, oe.c c1) {
        N n3;
        E e0;
        float f12;
        int v15;
        int v14;
        float f11;
        C c3;
        H h2;
        F f10;
        int v13;
        int v12;
        N n2;
        int v10;
        int v9;
        y y2;
        y y1;
        int v8;
        int v7;
        float f7;
        N n1;
        float f6;
        F f5;
        float f4;
        int v6;
        int v5;
        H h1;
        C c2;
        N n0;
        if(c1 instanceof N) {
            n0 = (N)c1;
            int v3 = n0.W;
            if((v3 & 0x80000000) == 0) {
                n0 = new N(c1);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                n0.W = v3 ^ 0x80000000;
            }
        }
        else {
            n0 = new N(c1);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = n0.V;
        a a0 = a.a;
    alab1:
        switch(n0.W) {
            case 0: {
                n.D(object0);
                if(((float)v) < 0.0f) {
                    L.a.a("Index should be non-negative");
                }
                try {
                    float f = c0.Y(P.a);
                    float f1 = c0.Y(P.b);
                    float f2 = c0.Y(P.c);
                    c2 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                    c2.a = true;
                    h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h1.a = f.b(0.0f, 0.0f, 30);
                    if(P.c(y0, v)) {
                        throw new h(y0.b(v), ((p)h1.a));
                    }
                    int v4 = v <= y0.c() ? 0 : 1;
                    F f3 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f3.a = 1;
                    v5 = v1;
                    v6 = v2;
                    f4 = f1;
                    f5 = f3;
                    f6 = f;
                    n1 = n0;
                    f7 = f2;
                    v7 = v;
                    v8 = v4;
                    y1 = y0;
                    goto label_78;
                }
                catch(h h0) {
                    y2 = y0;
                    v9 = v1;
                    v10 = v;
                    n2 = n0;
                    goto label_134;
                }
            }
            case 1: {
                try {
                    v8 = n0.M;
                    float f8 = n0.T;
                    float f9 = n0.S;
                    f6 = n0.N;
                    int v11 = n0.I;
                    v12 = n0.G;
                    v13 = n0.E;
                    f10 = n0.D;
                    h2 = n0.B;
                    c3 = n0.w;
                    y y3 = n0.r;
                    y2 = y3;
                    n.D(object0);
                    f11 = f9;
                    y2 = y3;
                    v5 = v12;
                    n1 = n0;
                    f7 = f8;
                    v14 = v11;
                }
                catch(h h0) {
                    v9 = v12;
                    v10 = v13;
                    n2 = n0;
                    goto label_134;
                }
                while(true) {
                    c2 = c3;
                    h1 = h2;
                    ++f10.a;
                    y1 = y2;
                    v7 = v13;
                    f5 = f10;
                    f4 = f11;
                    v6 = v14;
                label_78:
                    if(!c2.a) {
                        break alab1;
                    }
                    try {
                        switch(y1.a) {
                            case 0: {
                                v15 = ((O.F)y1.c).h().n;
                                break;
                            }
                            case 1: {
                                v15 = ((P.F)y1.c).g().o;
                                break;
                            }
                            default: {
                                v15 = ((K)y1.c).l();
                            }
                        }
                        if(v15 <= 0) {
                            break alab1;
                        }
                        int v16 = y1.b(v7) + v5;
                        if(((float)Math.abs(v16)) < f6) {
                            f12 = Math.max(Math.abs(v16), f7);
                            if(v8 == 0) {
                                f12 = -f12;
                            }
                        }
                        else {
                            f12 = v8 == 0 ? -f6 : f6;
                        }
                        p p0 = f.k(((p)h1.a), 0.0f, 0.0f, 30);
                        h1.a = p0;
                        e0 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                        int v17 = ((Number)((p)h1.a).a()).floatValue() == 0.0f ? 1 : 0;
                    }
                    catch(h h0) {
                        v10 = v7;
                        n3 = n1;
                        v9 = v5;
                        y2 = y1;
                        goto label_133;
                    }
                    try {
                        n3 = n1;
                        y2 = y1;
                        v10 = v7;
                        v9 = v5;
                        O o0 = new O(y1, v7, f12, e0, c2, v8 != 0, f4, f5, v6, v5, h1);
                        y2 = y1;
                        v10 = v7;
                        c3 = c2;
                        f10 = f5;
                        v14 = v6;
                        v9 = v5;
                        h2 = h1;
                        n1.r = y2;
                        n1.w = c3;
                        n1.B = h2;
                        n1.D = f10;
                        n1.E = v10;
                        n1.G = v9;
                        n1.I = v14;
                        n1.N = f6;
                        n1.S = f4;
                        n1.T = f7;
                        n1.M = v8;
                        f11 = f4;
                        n1.W = 1;
                        n3 = n1;
                        if(f.h(p0, new Float(f12), null, ((boolean)(v17 ^ 1)), o0, n3, 2) == a0) {
                            break;
                        }
                        goto label_149;
                    }
                    catch(h h0) {
                    }
                label_133:
                    n2 = n3;
                label_134:
                    p p1 = f.k(h0.b, 0.0f, 0.0f, 30);
                    float f13 = (float)(h0.a + v9);
                    E e1 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                    int v18 = ((Number)p1.a()).floatValue() == 0.0f ? 1 : 0;
                    J1 j10 = new J1(f13, e1, y2, 2);
                    n2.r = y2;
                    n2.w = null;
                    n2.B = null;
                    n2.D = null;
                    n2.E = v10;
                    n2.G = v9;
                    n2.W = 2;
                    if(f.h(p1, new Float(f13), null, ((boolean)(v18 ^ 1)), j10, n2, 2) == a0) {
                        break;
                    }
                    y2.f(v10, v9);
                    return ie.H.a;
                label_149:
                    v13 = v10;
                    v5 = v9;
                    n1 = n3;
                }
                return a0;
            }
            case 2: {
                int v19 = n0.G;
                int v20 = n0.E;
                y y4 = n0.r;
                n.D(object0);
                y4.f(v20, v19);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ie.H.a;
    }

    public static final boolean c(y y0, int v) {
        int v1 = y0.c();
        return v <= y0.e() && v1 <= v;
    }
}

