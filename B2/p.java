package B2;

import B0.e;
import Bd.s;
import Cc.P;
import De.I;
import F.C;
import F.g;
import H.c;
import H.i;
import I.F0;
import I.S;
import I.t;
import I2.a;
import J0.v;
import M.f;
import M.h;
import N0.B;
import N0.M;
import N0.N;
import N0.k0;
import O.y;
import P.w;
import P0.L;
import P0.g0;
import P0.j0;
import Q0.P0;
import Q0.u;
import U4.F;
import U8.z;
import Z.T;
import a1.U;
import androidx.compose.foundation.lazy.layout.X;
import androidx.compose.foundation.lazy.layout.j;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.q;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import m0.b;
import r1.m;
import t0.d;
import we.n;

public final class p extends r implements n {
    public final int f;
    public final Object g;
    public final Object h;

    public p(int v, Object object0, Object object1) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        super(2);
    }

    public p(c c0, g g0) {
        this.f = 3;
        this.g = c0;
        this.h = g0;
        super(2);
    }

    public p(Object object0, Object object1, int v, int v1) {
        this.f = v1;
        this.g = object0;
        this.h = object1;
        super(2);
    }

    public p(b b0, Object object0, int v) {
        this.f = v;
        this.h = b0;
        this.g = object0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v0 = k.a;
        boolean z = false;
        H h0 = H.a;
        Object object2 = this.h;
        Object object3 = this.g;
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                I.b(((a)object3), ((b)object2), ((l)object0), 49);
                return h0;
            }
            case 1: {
                ((Number)object1).intValue();
                ((i)object3).a(((c)object2), ((l)object0), 1);
                return h0;
            }
            case 2: {
                ((Number)object1).intValue();
                H.p.a(((c)object3), ((b)object2), ((l)object0), 385);
                return h0;
            }
            case 3: {
                int v3 = ((Number)object1).intValue();
                if((v3 & 3) != 2) {
                    z = true;
                }
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v3 & 1, z)) {
                    H.p.a(((c)object3), m0.c.e(0x44F1A924, ((androidx.compose.runtime.p)(((l)object0))), new C(2, ((g)object2), ((c)object3))), ((androidx.compose.runtime.p)(((l)object0))), 0x180);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 4: {
                long v4 = ((x0.b)object1).a;
                B.a.j(((s)object3), ((v)object0));
                Channel channel0 = ((S)object2).g;
                if(channel0 != null) {
                    ChannelResult.box-impl(channel0.trySend-JP2dKIU(new t(v4)));
                }
                return h0;
            }
            case 5: {
                ((Number)object1).floatValue();
                float f1 = ((E)object3).a;
                ((E)object3).a = ((F0)object2).a(((Number)object0).floatValue() - f1) + f1;
                return h0;
            }
            case 6: {
                int v5 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v5 & 1, (v5 & 3) != 2)) {
                    ((b)object2).invoke(((androidx.compose.foundation.layout.c)object3), ((androidx.compose.runtime.p)(((l)object0))), 0);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 7: {
                return ((M)object3).measure-3p2s80s(((k0)object0), ((k0)object0).c0(h0, new b(-1945019079, new p(((b)object2), new androidx.compose.foundation.layout.c(((k0)object0), ((r1.a)object1).a), 6), true)), ((r1.a)object1).a);
            }
            case 8: {
                int v6 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v6 & 1, (v6 & 3) != 2)) {
                    Boolean boolean0 = (Boolean)((O0)((B)object3).f).getValue();
                    boolean z2 = boolean0.booleanValue();
                    ((androidx.compose.runtime.p)(((l)object0))).d0(boolean0);
                    boolean z3 = ((androidx.compose.runtime.p)(((l)object0))).h(z2);
                    if(z2) {
                        ((n)object2).invoke(((androidx.compose.runtime.p)(((l)object0))), 0);
                    }
                    else {
                        if(((androidx.compose.runtime.p)(((l)object0))).k != 0) {
                            q.c("No nodes can be emitted before calling dactivateToEndGroup");
                        }
                        if(!((androidx.compose.runtime.p)(((l)object0))).O) {
                            if(z3) {
                                int v7 = ((androidx.compose.runtime.p)(((l)object0))).F.g;
                                int v8 = ((androidx.compose.runtime.p)(((l)object0))).F.h;
                                ((androidx.compose.runtime.p)(((l)object0))).L.getClass();
                                ((androidx.compose.runtime.p)(((l)object0))).L.d(false);
                                ((androidx.compose.runtime.p)(((l)object0))).L.b.g.L(f0.i.d);
                                q.a(v7, v8, ((androidx.compose.runtime.p)(((l)object0))).r);
                                ((androidx.compose.runtime.p)(((l)object0))).F.q();
                            }
                            else {
                                ((androidx.compose.runtime.p)(((l)object0))).S();
                            }
                        }
                    }
                    if(((androidx.compose.runtime.p)(((l)object0))).x && ((androidx.compose.runtime.p)(((l)object0))).F.i == ((androidx.compose.runtime.p)(((l)object0))).y) {
                        ((androidx.compose.runtime.p)(((l)object0))).y = -1;
                        ((androidx.compose.runtime.p)(((l)object0))).x = false;
                    }
                    ((androidx.compose.runtime.p)(((l)object0))).p(false);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 9: {
                long v9 = ((r1.a)object1).a;
                if(r1.a.h(v9) == 0x7FFFFFFF) {
                    L.a.a("LazyVerticalGrid\'s width should be bound by parent.");
                }
                int v10 = r1.a.h(v9);
                int[] arr_v = je.p.O0(((P.a)object3).a(v10, ((r1.c)object0).z(((f)object2).a())));
                int[] arr_v1 = new int[arr_v.length];
                ((f)object2).d(((r1.c)object0), v10, arr_v, m.a, arr_v1);
                return new w(arr_v, arr_v1);
            }
            case 10: {
                long v11 = ((r1.a)object1).a;
                if(r1.a.g(v11) == 0x7FFFFFFF) {
                    L.a.a("LazyHorizontalGrid\'s height should be bound by parent.");
                }
                int v12 = r1.a.g(v11);
                int[] arr_v2 = je.p.O0(((P.a)object3).a(v12, ((r1.c)object0).z(((h)object2).a())));
                int[] arr_v3 = new int[arr_v2.length];
                ((h)object2).c(((r1.c)object0), v12, arr_v2, arr_v3);
                return new w(arr_v2, arr_v3);
            }
            case 11: {
                P0.I i1 = ((j0)object3).l;
                if(i1.I()) {
                    ((j0)object3).W = (y0.q)object0;
                    ((j0)object3).V = (e)object1;
                    ((u)L.a(i1)).getSnapshotObserver().a(((j0)object3), P0.e.i, ((g0)object2));
                    ((j0)object3).Z = false;
                    return h0;
                }
                ((j0)object3).Z = true;
                return h0;
            }
            case 12: {
                ((Number)object1).floatValue();
                float f2 = ((y)object2).b.a(((Number)object0).floatValue() - ((E)object3).a);
                ((E)object3).a += f2;
                return h0;
            }
            case 13: {
                ((Number)object1).intValue();
                AndroidCompositionLocals_androidKt.a(((u)object3), ((n)object2), ((l)object0), 1);
                return h0;
            }
            case 14: {
                ((Number)object1).intValue();
                F.g(((r0.q)object3), ((b)object2), ((l)object0), 49);
                return h0;
            }
            case 15: {
                ((Number)object1).intValue();
                T.a(((U)object3), ((b)object2), ((l)object0), 49);
                return h0;
            }
            case 16: {
                return new P.b(((P.b)((z)object3).invoke(((P.m)object0), ((List)object2).get(((Number)object1).intValue()))).a);
            }
            case 17: {
                int v13 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v13 & 1, (v13 & 3) != 2)) {
                    Object object4 = ((androidx.compose.foundation.lazy.layout.u)object3).b.invoke();
                    int v14 = ((androidx.compose.foundation.lazy.layout.t)object2).c;
                    Object object5 = ((androidx.compose.foundation.lazy.layout.t)object2).a;
                    if(v14 >= ((androidx.compose.foundation.lazy.layout.v)object4).getItemCount() || !((androidx.compose.foundation.lazy.layout.v)object4).c(v14).equals(object5)) {
                        v14 = ((androidx.compose.foundation.lazy.layout.v)object4).b(object5);
                        if(v14 != -1) {
                            ((androidx.compose.foundation.lazy.layout.t)object2).c = v14;
                        }
                    }
                    if(v14 == -1) {
                        ((androidx.compose.runtime.p)(((l)object0))).a0(0xD8A69B71);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object0))).a0(-660404355);
                        j.g(((androidx.compose.foundation.lazy.layout.v)object4), ((androidx.compose.foundation.lazy.layout.u)object3).a, v14, ((androidx.compose.foundation.lazy.layout.t)object2).a, ((androidx.compose.runtime.p)(((l)object0))), 0);
                    }
                    ((androidx.compose.runtime.p)(((l)object0))).p(false);
                    boolean z4 = ((androidx.compose.runtime.p)(((l)object0))).i(((androidx.compose.foundation.lazy.layout.t)object2));
                    androidx.compose.foundation.w w0 = ((androidx.compose.runtime.p)(((l)object0))).N();
                    if(z4 || w0 == v0) {
                        w0 = new androidx.compose.foundation.w(((androidx.compose.foundation.lazy.layout.t)object2), 4);
                        ((androidx.compose.runtime.p)(((l)object0))).l0(w0);
                    }
                    J.b(object5, w0, ((androidx.compose.runtime.p)(((l)object0))));
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 18: {
                return (N)((n)object2).invoke(new androidx.compose.foundation.lazy.layout.z(((androidx.compose.foundation.lazy.layout.u)object3), ((k0)object0)), new r1.a(((r1.a)object1).a));
            }
            case 19: {
                int v15 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v15 & 1, (v15 & 3) != 2)) {
                    ((b)object2).invoke(((X)object3), ((androidx.compose.runtime.p)(((l)object0))), 0);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 20: {
                int v16 = ((Number)object1).intValue();
                return new P.b(((P.b)((P)object3).invoke(((P.m)object0), v16, ((ArrayList)object2).get(v16))).a);
            }
            case 21: {
                int v17 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v17 & 1, (v17 & 3) != 2)) {
                    e1.n.b(((ComposeViewAdapter)object3).g, ((b)object2), ((androidx.compose.runtime.p)(((l)object0))), 0);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 22: {
                ((Number)object1).intValue();
                e1.n.b(((m1.m)object3), ((b)object2), ((l)object0), 1);
                return h0;
            }
            case 23: {
                int v18 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v18 & 1, (v18 & 3) != 2)) {
                    e1.m.u(((String)object3), ((String)object2), ((androidx.compose.runtime.p)(((l)object0))), new Object[0]);
                    return h0;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            case 24: {
                int v19 = ((Number)object0).intValue();
                if(!((P0)object3).b.b(((X0.p)object1).g)) {
                    ((d)object2).j(v19, ((X0.p)object1));
                    ((d)object2).h.trySend-JP2dKIU(h0);
                }
                return h0;
            }
            default: {
                int v1 = ((Number)object1).intValue();
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object0));
                if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
                    r0.q q0 = X0.n.c(r0.n.a, false, v1.d.i);
                    boolean z1 = p0.i(((v1.m)object3));
                    v1.f f0 = p0.N();
                    if(z1 || f0 == v0) {
                        f0 = new v1.f(((v1.m)object3), 1);
                        p0.l0(f0);
                    }
                    r0.q q1 = e2.a.r(androidx.compose.ui.layout.a.f(q0, f0), (((v1.m)object3).getCanCalculatePosition() ? 1.0f : 0.0f));
                    n n0 = (n)((b0)object2).getValue();
                    int v2 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q2 = r0.a.d(p0, q1);
                    P0.k.y.getClass();
                    P0.i i0 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, v1.h.a, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                    P0.h h1 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h1);
                    }
                    androidx.compose.runtime.w.x(p0, q2, P0.j.d);
                    n0.invoke(p0, 0);
                    p0.p(true);
                    return h0;
                }
                p0.T();
                return h0;
            }
        }
    }
}

