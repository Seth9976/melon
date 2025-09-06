package G;

import Q0.t0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import d5.n;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import ne.a;
import oe.c;
import oe.i;
import r0.d;

public abstract class f {
    public static final q a;
    public static final r b;
    public static final s c;
    public static final t d;
    public static final q e;
    public static final r f;
    public static final s g;
    public static final t h;
    public static final float[] i;

    static {
        f.a = new q(Infinityf);
        f.b = new r(Infinityf, Infinityf);
        f.c = new s(Infinityf, Infinityf, Infinityf);
        f.d = new t(Infinityf, Infinityf, Infinityf, Infinityf);
        f.e = new q(-Infinityf);
        f.f = new r(-Infinityf, -Infinityf);
        f.g = new s(-Infinityf, -Infinityf, -Infinityf);
        f.h = new t(-Infinityf, -Infinityf, -Infinityf, -Infinityf);
        f.i = new float[91];
    }

    public static e a(float f) {
        return new e(f, z0.a, 0.01f, 8);
    }

    public static p b(float f, float f1, int v) {
        if((v & 2) != 0) {
            f1 = 0.0f;
        }
        q q0 = new q(f1);
        return new p(z0.a, f, q0, 0x8000000000000000L, 0x8000000000000000L, false);
    }

    public static final Object c(p p0, k k0, long v, we.k k1, c c0) {
        Object object4;
        we.k k3;
        Object object2;
        p p1;
        H h1;
        g0 g00;
        H h0;
        e0 e00;
        k k2 = k0;
        if(c0 instanceof e0) {
            e00 = (e0)c0;
            int v1 = e00.G;
            if((v1 & 0x80000000) == 0) {
                e00 = new e0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                e00.G = v1 ^ 0x80000000;
            }
        }
        else {
            e00 = new e0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = e00.E;
        a a0 = a.a;
        switch(e00.G) {
            case 0: {
                n.D(object0);
                Object object1 = k2.g(0L);
                u u0 = k2.c(0L);
                h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                if(v == 0x8000000000000000L) {
                    try {
                        g00 = new g0(h0, object1, k2, u0, p0, f.m(e00.getContext()), k1);
                        h1 = h0;
                    }
                    catch(CancellationException cancellationException0) {
                        p1 = p0;
                        break;
                    }
                    try {
                        e00.r = p0;
                        e00.w = k2;
                        e00.B = k1;
                        e00.D = h1;
                        e00.G = 1;
                        if(k2.b()) {
                            object2 = f.t(g00, e00);
                        }
                        else {
                            d0 d00 = new d0(1, g00);
                            object2 = w.l(e00.getContext()).c(d00, e00);
                        }
                    }
                    catch(CancellationException cancellationException0) {
                        p1 = p0;
                        goto label_55;
                    }
                    if(object2 != a0) {
                        p1 = p0;
                        k3 = k1;
                        h0 = h1;
                        goto label_69;
                    }
                    return a0;
                }
                else {
                    try {
                        h1 = h0;
                        G.n n0 = new G.n(object1, k2.f(), u0, v, k2.h(), v, new f0(1, p0));
                        p1 = p0;
                        f.l(n0, v, f.m(e00.getContext()), k2, p0, k1);
                        h1.a = n0;
                        p1 = p0;
                        k2 = k0;
                        k3 = k1;
                        h0 = h1;
                        goto label_69;
                    }
                    catch(CancellationException cancellationException0) {
                    }
                label_55:
                    h0 = h1;
                    break;
                }
                goto label_69;
            }
            case 1: {
                h0 = e00.D;
                k3 = e00.B;
                k2 = e00.w;
                p1 = e00.r;
                goto label_68;
            }
            case 2: {
                h0 = e00.D;
                k3 = e00.B;
                k2 = e00.w;
                p1 = e00.r;
                try {
                label_68:
                    n.D(object0);
                    do {
                    label_69:
                        Object object3 = h0.a;
                        kotlin.jvm.internal.q.d(object3);
                        if(!((Boolean)((O0)((G.n)object3).i).getValue()).booleanValue()) {
                            return ie.H.a;
                        }
                        h0 h00 = new h0(h0, f.m(e00.getContext()), k2, p1, k3);
                        e00.r = p1;
                        e00.w = k2;
                        e00.B = k3;
                        e00.D = h0;
                        e00.G = 2;
                        if(k2.b()) {
                            object4 = f.t(h00, e00);
                        }
                        else {
                            d0 d01 = new d0(1, h00);
                            object4 = w.l(e00.getContext()).c(d01, e00);
                        }
                    }
                    while(object4 != a0);
                    return a0;
                }
                catch(CancellationException cancellationException0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        G.n n1 = (G.n)h0.a;
        if(n1 != null) {
            ((O0)n1.i).setValue(Boolean.FALSE);
        }
        G.n n2 = (G.n)h0.a;
        if(n2 != null && n2.g == p1.d) {
            p1.f = false;
        }
        throw cancellationException0;
    }

    public static Object d(float f, o o0, we.n n0, i i0, int v) {
        if((v & 8) != 0) {
            o0 = f.q(0.0f, 7, null);
        }
        Float float0 = new Float(0.0f);
        q q0 = new q(new Float(0.0f).floatValue());
        j0 j00 = new j0(o0, z0.a, float0, new Float(f), q0);
        ie.H h0 = f.c(new p(z0.a, float0, q0, 56), j00, 0x8000000000000000L, new d0(n0), i0);
        a a0 = a.a;
        ie.H h1 = ie.H.a;
        if(h0 != a0) {
            h0 = h1;
        }
        return h0 == a0 ? h0 : h1;
    }

    public static final Object e(p p0, y y0, boolean z, we.k k0, c c0) {
        Object object0 = ((O0)p0.b).getValue();
        Object object1 = f.c(p0, new x(y0, p0.a, object0, p0.c), (z ? p0.d : 0x8000000000000000L), k0, c0);
        return object1 == a.a ? object1 : ie.H.a;
    }

    public static final I f(L l0, float f, float f1, G.H h0, String s, l l1, int v, int v1) {
        if((v1 & 8) != 0) {
            s = "FloatAnimation";
        }
        return f.i(l0, f, f1, z0.a, h0, s, l1, 33208 | v << 3 & 0x70000, 0);
    }

    public static final Object g(p p0, Float float0, o o0, boolean z, we.k k0, c c0) {
        Object object0 = ((O0)p0.b).getValue();
        Object object1 = f.c(p0, new j0(o0, p0.a, object0, float0, p0.c), (z ? p0.d : 0x8000000000000000L), k0, c0);
        return object1 == a.a ? object1 : ie.H.a;
    }

    public static Object h(p p0, Float float0, a0 a00, boolean z, we.k k0, c c0, int v) {
        if((v & 2) != 0) {
            a00 = f.q(0.0f, 7, null);
        }
        if((v & 8) != 0) {
            k0 = i0.g;
        }
        return f.g(p0, float0, a00, z, k0, c0);
    }

    public static final I i(L l0, Number number0, Number number1, y0 y00, G.H h0, String s, l l1, int v, int v1) {
        I i0 = ((androidx.compose.runtime.p)l1).N();
        V v2 = androidx.compose.runtime.k.a;
        if(i0 == v2) {
            I i1 = new I(l0, number0, number1, y00, h0);
            ((androidx.compose.runtime.p)l1).l0(i1);
            i0 = i1;
        }
        boolean z = (0xE000 & v ^ 0x6000) > 0x4000 && ((androidx.compose.runtime.p)l1).i(h0) || (v & 0x6000) == 0x4000;
        E2.c c0 = ((androidx.compose.runtime.p)l1).N();
        if(z || c0 == v2) {
            E2.c c1 = new E2.c(number0, i0, number1, h0, 1);
            ((androidx.compose.runtime.p)l1).l0(c1);
            c0 = c1;
        }
        J.h(c0, ((androidx.compose.runtime.p)l1));
        boolean z1 = ((androidx.compose.runtime.p)l1).i(l0);
        Ac.J j0 = ((androidx.compose.runtime.p)l1).N();
        if(z1 || j0 == v2) {
            j0 = new Ac.J(12, l0, i0);
            ((androidx.compose.runtime.p)l1).l0(j0);
        }
        J.b(i0, j0, ((androidx.compose.runtime.p)l1));
        return i0;
    }

    public static final u j(u u0) {
        u u1 = u0.c();
        int v = u1.b();
        for(int v1 = 0; v1 < v; ++v1) {
            u1.e(u0.a(v1), v1);
        }
        return u1;
    }

    public static p k(p p0, float f, float f1, int v) {
        if((v & 1) != 0) {
            f = ((Number)((O0)p0.b).getValue()).floatValue();
        }
        if((v & 2) != 0) {
            f1 = ((q)p0.c).a;
        }
        long v1 = p0.d;
        long v2 = p0.e;
        boolean z = p0.f;
        q q0 = new q(f1);
        return new p(p0.a, f, q0, v1, v2, z);
    }

    public static final void l(G.n n0, long v, float f, k k0, p p0, we.k k1) {
        long v1 = f == 0.0f ? k0.e() : ((long)(((float)(v - n0.c)) / f));
        n0.g = v;
        Object object0 = k0.g(v1);
        ((O0)n0.e).setValue(object0);
        n0.f = k0.c(v1);
        if(k0.d(v1)) {
            n0.h = n0.g;
            ((O0)n0.i).setValue(Boolean.FALSE);
        }
        f.s(n0, p0);
        k1.invoke(n0);
    }

    public static final float m(me.i i0) {
        r0.r r0 = (r0.r)i0.get(d.r);
        float f = r0 == null ? 1.0f : r0.h();
        if(f >= 0.0f) {
            return f;
        }
        W.b("negative scale factor");
        return f;
    }

    public static G.H n(z z0, X x0, long v, int v1) {
        if((v1 & 2) != 0) {
            x0 = X.a;
        }
        if((v1 & 4) != 0) {
            v = 0L;
        }
        return new G.H(z0, x0, v);
    }

    public static final O o(we.k k0) {
        N n0 = new N();
        k0.invoke(n0);
        return new O(n0);
    }

    public static final L p(String s, l l0, int v) {
        if((v & 1) != 0) {
            s = "InfiniteTransition";
        }
        L l1 = ((androidx.compose.runtime.p)l0).N();
        if(l1 == androidx.compose.runtime.k.a) {
            l1 = new L(s);
            ((androidx.compose.runtime.p)l0).l0(l1);
        }
        l1.a(((androidx.compose.runtime.p)l0), 0);
        return l1;
    }

    public static a0 q(float f, int v, Object object0) {
        if((v & 2) != 0) {
            f = 1500.0f;
        }
        if((v & 4) != 0) {
            object0 = null;
        }
        return new a0(1.0f, f, object0);
    }

    public static x0 r(int v, int v1, A a0, int v2) {
        if((v2 & 1) != 0) {
            v = 300;
        }
        if((v2 & 2) != 0) {
            v1 = 0;
        }
        if((v2 & 4) != 0) {
            a0 = C.a;
        }
        return new x0(v, v1, a0);
    }

    public static final void s(G.n n0, p p0) {
        Object object0 = ((O0)n0.e).getValue();
        ((O0)p0.b).setValue(object0);
        u u0 = p0.c;
        u u1 = n0.f;
        int v = u0.b();
        for(int v1 = 0; v1 < v; ++v1) {
            u0.e(u1.a(v1), v1);
        }
        p0.e = n0.h;
        p0.d = n0.g;
        p0.f = ((Boolean)((O0)n0.i).getValue()).booleanValue();
    }

    public static final Object t(we.k k0, Continuation continuation0) {
        if(continuation0.getContext().get(t0.b) != null) {
            throw new ClassCastException();
        }
        return w.l(continuation0.getContext()).c(k0, continuation0);
    }
}

