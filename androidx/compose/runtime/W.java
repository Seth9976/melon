package androidx.compose.runtime;

import G.s0;
import T3.e;
import androidx.collection.y;
import d5.m;
import ie.H;
import j0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import m0.b;
import m0.f;
import m0.g;
import me.i;
import we.n;

public abstract class w {
    public static final Object a;

    static {
        w.a = new Object();
    }

    public static final int A(int v) [...] // Inlined contents

    public static final g B(m0[] arr_m0, i0 i00, i0 i01) {
        f f0 = new f(g.d);
        for(int v = 0; v < arr_m0.length; ++v) {
            m0 m00 = arr_m0[v];
            l0 l00 = m00.a;
            if(m00.f || !i00.containsKey(l00)) {
                f0.put(l00, l00.c(m00, ((e1)i01.get(l00))));
            }
        }
        return f0.a();
    }

    public static final void a(m0 m00, b b0, l l0, int v) {
        boolean z2;
        e1 e10;
        p p0 = (p)l0;
        p0.c0(-1350970552);
        P0.w w0 = p0.w;
        i0 i00 = p0.m();
        p0.W(201, q.b);
        Object object0 = p0.N();
        if(kotlin.jvm.internal.q.b(object0, k.a)) {
            e10 = null;
        }
        else {
            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            e10 = (e1)object0;
        }
        l0 l00 = m00.a;
        e1 e11 = l00.c(m00, e10);
        boolean z = e11.equals(e10);
        if(!z) {
            p0.l0(e11);
        }
        boolean z1 = true;
        if(p0.O) {
            if(m00.f || !i00.containsKey(l00)) {
                i00 = (g)i00;
                e e0 = i00.a.u(l00.hashCode(), l00, e11, 0);
                if(e0 != null) {
                    i00 = new g(((j)e0.b), i00.b + e0.a);  // 初始化器: Lj0/b;-><init>(Lj0/j;I)V
                }
            }
            p0.I = true;
            z2 = false;
        }
        else {
            Object object1 = p0.F.b(p0.F.g, p0.F.b);
            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            if((!p0.D() || !z) && (m00.f || !i00.containsKey(l00))) {
                i00 = (g)i00;
                e e1 = i00.a.u(l00.hashCode(), l00, e11, 0);
                if(e1 != null) {
                    i00 = new g(((j)e1.b), i00.b + e1.a);  // 初始化器: Lj0/b;-><init>(Lj0/j;I)V
                }
            }
            else if(z && !p0.v || !p0.v) {
                i00 = (i0)object1;
            }
            z2 = p0.x || ((i0)object1) != i00;
        }
        if(z2 && !p0.O) {
            p0.L(i00);
        }
        w0.c(((int)p0.v));
        p0.v = z2;
        p0.J = i00;
        p0.U(202, q.c, i00, 0);
        b0.invoke(p0, ((int)(v >> 3 & 14)));
        p0.p(false);
        p0.p(false);
        if(w0.b() == 0) {
            z1 = false;
        }
        p0.v = z1;
        p0.J = null;
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s0(m00, b0, v, 6);
        }
    }

    public static final void b(m0[] arr_m0, n n0, l l0, int v) {
        boolean z1;
        i0 i01;
        p p0 = (p)l0;
        p0.c0(-1390796515);
        P0.w w0 = p0.w;
        i0 i00 = p0.m();
        p0.W(201, q.b);
        boolean z = true;
        if(p0.O) {
            i01 = p0.k0(i00, w.B(arr_m0, i00, g.d));
            p0.I = true;
            z1 = false;
        }
        else {
            Object object0 = p0.F.g(p0.F.g, 0);
            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Object object1 = p0.F.g(p0.F.g, 1);
            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            g g0 = w.B(arr_m0, i00, ((i0)object1));
            if(!p0.D() || p0.x || !((i0)object1).equals(g0)) {
                i01 = p0.k0(i00, g0);
                z1 = p0.x || !kotlin.jvm.internal.q.b(i01, ((i0)object0));
            }
            else {
                int v1 = p0.k;
                p0.k = p0.F.p() + v1;
                i01 = (i0)object0;
                z1 = false;
            }
        }
        if(z1 && !p0.O) {
            p0.L(i01);
        }
        w0.c(((int)p0.v));
        p0.v = z1;
        p0.J = i01;
        p0.U(202, q.c, i01, 0);
        n0.invoke(p0, ((int)(v >> 3 & 14)));
        p0.p(false);
        p0.p(false);
        if(w0.b() == 0) {
            z = false;
        }
        p0.v = z;
        p0.J = null;
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s0(arr_m0, n0, v, 5);
        }
    }

    public static final void c(y y0, int v) {
        if(y0.b != 0 && (y0.c(0) == v || y0.c(y0.b - 1) == v)) {
            return;
        }
        int v1 = y0.b;
        y0.a(v);
        while(v1 > 0) {
            int v2 = (v1 + 1 >>> 1) - 1;
            int v3 = y0.c(v2);
            if(v <= v3) {
                break;
            }
            y0.f(v1, v3);
            v1 = v2;
        }
        y0.f(v1, v);
    }

    public static void d(E0 e00, List list0, v v0) {
        if(!list0.isEmpty()) {
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = e00.c(((a)list0.get(v2)));
                int v4 = e00.K(e00.q(v3), e00.b);
                V v5 = v4 < e00.f(e00.q(v3 + 1), e00.b) ? e00.c[e00.g(v4)] : k.a;
                n0 n00 = v5 instanceof n0 ? ((n0)v5) : null;
                if(n00 != null) {
                    n00.b = v0;
                }
            }
        }
    }

    public static final b0 e(Flow flow0, Object object0, i i0, l l0, int v, int v1) {
        if((v1 & 2) != 0) {
            i0 = me.j.a;
        }
        boolean z = ((p)l0).i(i0);
        boolean z1 = ((p)l0).i(flow0);
        V0 v00 = ((p)l0).N();
        V v2 = k.a;
        if(z || z1 || v00 == v2) {
            v00 = new V0(i0, flow0, null);
            ((p)l0).l0(v00);
        }
        b0 b00 = ((p)l0).N();
        if(b00 == v2) {
            b00 = w.s(object0);
            ((p)l0).l0(b00);
        }
        boolean z2 = ((p)l0).i(v00);
        S0 s00 = ((p)l0).N();
        if(z2 || s00 == v2) {
            s00 = new S0(v00, b00, null);
            ((p)l0).l0(s00);
        }
        J.f(flow0, i0, s00, ((p)l0));
        return b00;
    }

    public static final b0 f(StateFlow stateFlow0, l l0) {
        return w.e(stateFlow0, stateFlow0.getValue(), me.j.a, l0, 0, 0);
    }

    public static final g0.e g() {
        m m0 = Q0.b;
        g0.e e0 = (g0.e)m0.i();
        if(e0 == null) {
            e0 = new g0.e(new o[0]);
            m0.v(e0);
        }
        return e0;
    }

    public static final E h(P0 p00, we.a a0) {
        return new E(p00, a0);
    }

    public static final E i(we.a a0) {
        return new E(null, a0);
    }

    public static final int j(l l0) {
        return ((p)l0).P;
    }

    public abstract Object k(B0 arg1);

    public static final W l(i i0) {
        W w0 = (W)i0.get(V.b);
        if(w0 == null) {
            throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
        }
        return w0;
    }

    public static final void m() {
        throw new IllegalStateException("Invalid applier");
    }

    public static List n(E0 e00, int v, E0 e01, boolean z, boolean z1, boolean z2) {
        boolean z4;
        List list0;
        int v19;
        int v18;
        int v1 = e00.s(v);
        int v2 = v + v1;
        int v3 = e00.f(e00.q(v), e00.b);
        int v4 = e00.f(e00.q(v2), e00.b);
        int v5 = v4 - v3;
        boolean z3 = v >= 0 && (e00.b[e00.q(v) * 5 + 1] & 0xC000000) != 0;
        e01.u(v1);
        e01.v(v5, e01.t);
        if(e00.g < v2) {
            e00.z(v2);
        }
        if(e00.k < v4) {
            e00.A(v4, v2);
        }
        int[] arr_v = e01.b;
        int v6 = e01.t;
        je.n.S(v6 * 5, v * 5, v2 * 5, e00.b, arr_v);
        Object[] arr_object = e01.c;
        int v7 = e01.i;
        System.arraycopy(e00.c, v3, arr_object, v7, v5);
        int v8 = e01.v;
        arr_v[v6 * 5 + 2] = v8;
        int v9 = v6 - v;
        int v10 = v6 + v1;
        int v11 = e01.f(v6, arr_v);
        int v12 = e01.l;
        int v13 = e01.m;
        int v14 = v6 * 5;
        int v15 = v6;
        while(v15 < v10) {
            if(v15 != v6) {
                int v16 = v15 * 5 + 2;
                arr_v[v16] += v9;
            }
            int v17 = e01.f(v15, arr_v);
            if(v13 < v15) {
                v18 = v6;
                v19 = 0;
            }
            else {
                v18 = v6;
                v19 = e01.k;
            }
            arr_v[v15 * 5 + 4] = E0.h(v17 + (v7 - v11), v19, v12, arr_object.length);
            if(v15 == v13) {
                ++v13;
            }
            ++v15;
            v6 = v18;
        }
        e01.m = v13;
        int v20 = D0.b(e00.d, v, e00.n());
        int v21 = D0.b(e00.d, v2, e00.n());
        if(v20 < v21) {
            ArrayList arrayList0 = e00.d;
            list0 = new ArrayList(v21 - v20);
            for(int v22 = v20; v22 < v21; ++v22) {
                a a0 = (a)arrayList0.get(v22);
                a0.a += v9;
                ((ArrayList)list0).add(a0);
            }
            int v23 = D0.b(e01.d, e01.t, e01.n());
            e01.d.addAll(v23, list0);
            arrayList0.subList(v20, v21).clear();
        }
        else {
            list0 = je.w.a;
        }
        if(!list0.isEmpty()) {
            HashMap hashMap0 = e00.e;
            if(hashMap0 != null && e01.e != null) {
                int v24 = list0.size();
                for(int v25 = 0; v25 < v24; ++v25) {
                    N n0 = (N)hashMap0.get(((a)list0.get(v25)));
                }
            }
        }
        HashMap hashMap1 = e01.e;
        if(hashMap1 != null) {
            a a1 = e01.P(v8);
            if(a1 != null) {
                N n1 = (N)hashMap1.get(a1);
            }
        }
        int v26 = e00.C(v, e00.b);
        if(!z2) {
            z4 = false;
        }
        else if(z) {
            if(v26 >= 0) {
                e00.N();
                e00.a(v26 - e00.t);
                e00.N();
            }
            e00.a(v - e00.t);
            boolean z5 = e00.F();
            if(v26 >= 0) {
                e00.J();
                e00.i();
                e00.J();
                e00.i();
            }
            z4 = z5;
        }
        else {
            boolean z6 = e00.G(v, v1);
            e00.H(v3, v5, v - 1);
            z4 = z6;
        }
        if(z4) {
            q.c("Unexpectedly removed anchors");
        }
        int v27 = e01.o;
        int v28 = arr_v[v14 + 1];
        e01.o = v27 + ((0x40000000 & v28) == 0 ? v28 & 0x3FFFFFF : 1);
        if(z1) {
            e01.t = v10;
            e01.i = v7 + v5;
        }
        if(z3) {
            e01.R(v8);
        }
        return list0;
    }

    public static final Z o(float f) {
        return new ParcelableSnapshotMutableFloatState(f);
    }

    public static final a0 p(int v) {
        return new ParcelableSnapshotMutableIntState(v);
    }

    public static final M0 q(long v) {
        return new ParcelableSnapshotMutableLongState(v);
    }

    public static final b0 r(Object object0, P0 p00) {
        return new ParcelableSnapshotMutableState(object0, p00);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
    }

    public static b0 s(Object object0) {
        return new ParcelableSnapshotMutableState(object0, V.f);  // 初始化器: Landroidx/compose/runtime/O0;-><init>(Ljava/lang/Object;Landroidx/compose/runtime/P0;)V
    }

    public static final b0 t(l l0, Object object0, n n0) {
        b0 b00 = ((p)l0).N();
        V v0 = k.a;
        if(b00 == v0) {
            b00 = w.s(object0);
            ((p)l0).l0(b00);
        }
        boolean z = ((p)l0).i(n0);
        R0 r00 = ((p)l0).N();
        if(z || r00 == v0) {
            r00 = new R0(n0, b00, null);
            ((p)l0).l0(r00);
        }
        J.d(((p)l0), H.a, r00);
        return b00;
    }

    public static final Object u(i0 i00, l0 l00) {
        kotlin.jvm.internal.q.e(l00, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        e1 e10 = i00.get(l00);
        if(e10 == null) {
            e10 = l00.b();
        }
        return e10.a(i00);
    }

    public static final androidx.compose.runtime.n v(l l0) {
        ((p)l0).W(206, q.e);
        if(((p)l0).O) {
            E0.x(((p)l0).H);
        }
        Object object0 = ((p)l0).F();
        androidx.compose.runtime.m m0 = object0 instanceof androidx.compose.runtime.m ? ((androidx.compose.runtime.m)object0) : null;
        if(m0 == null) {
            m0 = new androidx.compose.runtime.m(new androidx.compose.runtime.n(((p)l0), ((p)l0).P, ((p)l0).p, ((p)l0).B, ((p)l0).g.B));
            ((p)l0).m0(m0);
        }
        i0 i00 = ((p)l0).m();
        ((O0)m0.a.f).setValue(i00);
        ((p)l0).p(false);
        return m0.a;
    }

    public static final b0 w(Object object0, l l0) {
        b0 b00 = ((p)l0).N();
        if(b00 == k.a) {
            b00 = w.s(object0);
            ((p)l0).l0(b00);
        }
        b00.setValue(object0);
        return b00;
    }

    public static final void x(l l0, Object object0, n n0) {
        if(!((p)l0).O && kotlin.jvm.internal.q.b(((p)l0).N(), object0)) {
            return;
        }
        ((p)l0).l0(object0);
        ((p)l0).c(object0, n0);
    }

    public static final Flow y(we.a a0) {
        return FlowKt.flow(new W0(a0, null));
    }

    public static final int z(y y0) {
        int v = y0.c(0);
    label_1:
        while(y0.b != 0 && y0.c(0) == v) {
            y0.f(0, y0.d());
            y0.e(y0.b - 1);
            int v1 = y0.b;
            int v2 = 0;
            while(v2 < v1 >>> 1) {
                int v3 = y0.c(v2);
                int v4 = (v2 + 1) * 2;
                int v5 = v4 - 1;
                int v6 = y0.c(v5);
                if(v4 < v1) {
                    int v7 = y0.c(v4);
                    if(v7 > v6) {
                        if(v7 <= v3) {
                            continue label_1;
                        }
                        y0.f(v2, v7);
                        y0.f(v4, v3);
                        v2 = v4;
                        continue;
                    }
                }
                if(v6 > v3) {
                    y0.f(v2, v6);
                    y0.f(v5, v3);
                    v2 = v5;
                    continue;
                }
                continue label_1;
            }
        }
        return v;
    }
}

