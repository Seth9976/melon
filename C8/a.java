package C8;

import Ac.A2;
import Bd.e;
import Cc.R1;
import Cc.S1;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import Cc.s0;
import Cd.O;
import Dc.B;
import E9.h;
import Gd.G;
import Gd.g;
import Gd.o;
import Gd.z;
import Hc.x;
import Hd.J;
import Hd.v0;
import J0.v;
import M.c;
import M.j;
import M.w;
import M.y;
import Nc.N;
import Nc.d1;
import Nc.h0;
import Nc.x0;
import O.F;
import P0.i;
import Vc.q0;
import Vc.r;
import Yc.E;
import android.os.Bundle;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.utils.system.CompatUtils;
import com.melon.ui.U0;
import d;
import h7.u0;
import ie.H;
import ie.m;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import wc.u;
import we.n;
import y0.M;
import y8.f;

public final class a implements n {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public a(Object object0, int v, int v1) {
        this.a = v1;
        this.b = object0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        Object object3;
        V v0 = k.a;
        u u0 = M.a;
        r0.n n0 = r0.n.a;
        x x0 = null;
        boolean z = false;
        H h0 = H.a;
        Object object2 = this.b;
        switch(this.a) {
            case 0: {
                int v1 = (int)(((Integer)object1));
                if((v1 & 3) != 2) {
                    z = true;
                }
                if(((p)(((l)object0))).Q(v1 & 1, z)) {
                    c.a(null, null, false, m0.c.e(0x61EC54C1, ((p)(((l)object0))), new e(((b)object2), 1)), ((p)(((l)object0))), 0xC00, 7);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 1: {
                ((Integer)object1).getClass();
                e0.o(((Cc.M)object2), ((l)object0), 1);
                return h0;
            }
            case 2: {
                ((Integer)object1).getClass();
                e0.v(((U0)object2), ((l)object0), 1);
                return h0;
            }
            case 3: {
                ((Integer)object1).getClass();
                R1.a(((S1)object2), ((l)object0), 1);
                return h0;
            }
            case 4: {
                ((Integer)object1).getClass();
                h.k(((O)object2), ((l)object0), 1);
                return h0;
            }
            case 5: {
                q.g(((v)object0), "<unused var>");
                Dc.u u1 = ((Dc.k)object2).a;
                F f0 = u1.a;
                B b0 = u1.n;
                Float float0 = (float)(((Number)((O0)u1.h).getValue()).floatValue() + Float.intBitsToFloat(((int)(((x0.b)object1).a & 0xFFFFFFFFL))));
                ((O0)u1.h).setValue(float0);
                O.v v2 = u1.a();
                if(v2 != null) {
                    float f1 = (float)v2.m;
                    float f2 = u1.b() + f1;
                    int v3 = ((Number)u0.h(f0.h()).b).intValue();
                    if(b0.e == null) {
                        float f3 = ((float)v2.n) + f2;
                        Iterator iterator0 = ((Iterable)f0.h().k).iterator();
                        while(true) {
                            object3 = null;
                            if(!iterator0.hasNext()) {
                                break;
                            }
                            object3 = iterator0.next();
                            O.v v4 = (O.v)object3;
                            float f4 = ((float)v4.n) / 2.0f + ((float)v4.m);
                            if(f2 <= f4 && f4 <= f3 && v2.a != v4.a && u1.m.contains(v4.j) && (v4.m >= 0 && v4.m + v4.n <= v3)) {
                                break;
                            }
                        }
                        if(((O.v)object3) != null) {
                            u1.d(v2, ((O.v)object3));
                        }
                    }
                    float f5 = f2 + ((float)f0.h().r) + u1.l;
                    float f6 = ((float)v3) - f5;
                    float f7 = u1.f;
                    if(Float.compare(f5 - 0.0f, f7) < 0) {
                        Dc.p p0 = new Dc.p(u1, 0);
                        float f8 = P4.a.i((f5 - 0.0f + f7) / (f7 * 2.0f), 0.0f, 1.0f);
                        b0.b(p0, Dc.v.a, (1.0f - f8) * 10.0f);
                        return h0;
                    }
                    if(f6 < f7) {
                        Dc.p p1 = new Dc.p(u1, 1);
                        float f9 = P4.a.i((f6 + f7) / (f7 * 2.0f), 0.0f, 1.0f);
                        b0.b(p1, Dc.v.b, (1.0f - f9) * 10.0f);
                        return h0;
                    }
                    Job job0 = b0.f;
                    if(job0 != null) {
                        DefaultImpls.cancel$default(job0, null, 1, null);
                    }
                    b0.e = null;
                }
                return h0;
            }
            case 6: {
                ((Integer)object1).getClass();
                h.c(((d9.h)object2), ((l)object0), 1);
                return h0;
            }
            case 7: {
                int v5 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v5 & 1, (v5 & 3) != 2)) {
                    h.c(((d9.h)B.a.r(((Fc.p)((Fc.k)object2).getViewModel()).c, ((p)(((l)object0))), 0).getValue()), ((p)(((l)object0))), 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 8: {
                ((Integer)object1).getClass();
                d.a(((e)object2), ((l)object0), 1);
                return h0;
            }
            case 9: {
                int v6 = (int)(((Integer)object1));
                p p2 = (p)(((l)object0));
                if(p2.Q(v6 & 1, (v6 & 3) != 2)) {
                    r0.q q0 = androidx.compose.foundation.q.f(n0, e0.T(p2, 0x7F0604AA), u0);  // color:white000s_support_high_contrast
                    y y0 = w.a(j.c, r0.d.m, p2, 0);
                    int v7 = p2.P;
                    i0 i00 = p2.m();
                    r0.q q1 = r0.a.d(p2, q0);
                    P0.k.y.getClass();
                    i i0 = P0.j.b;
                    p2.e0();
                    if(p2.O) {
                        p2.l(i0);
                    }
                    else {
                        p2.o0();
                    }
                    androidx.compose.runtime.w.x(p2, y0, P0.j.f);
                    androidx.compose.runtime.w.x(p2, i00, P0.j.e);
                    P0.h h1 = P0.j.g;
                    if(p2.O || !q.b(p2.N(), v7)) {
                        A7.d.q(v7, p2, v7, h1);
                    }
                    androidx.compose.runtime.w.x(p2, q1, P0.j.d);
                    boolean z1 = p2.i(((g)object2));
                    A2 a20 = p2.N();
                    if(z1 || a20 == v0) {
                        a20 = new A2(((g)object2), 19);
                        p2.l0(a20);
                    }
                    androidx.compose.ui.viewinterop.a.a(a20, null, null, p2, 0, 6);
                    Gd.a.a(((Gd.n)((g)object2).getViewModel()), p2, 0);
                    p2.p(true);
                    return h0;
                }
                p2.T();
                return h0;
            }
            case 10: {
                ((Integer)object1).getClass();
                Gd.a.a(((Gd.n)object2), ((l)object0), 1);
                return h0;
            }
            case 11: {
                int v8 = (int)(((Integer)object1));
                p p3 = (p)(((l)object0));
                if(p3.Q(v8 & 1, (v8 & 3) != 2)) {
                    z z2 = (z)B.a.r(((G)((Gd.u)object2).getViewModel()).g, p3, 0).getValue();
                    r0.q q2 = androidx.compose.foundation.q.f(n0, e0.T(p3, 0x7F0604AA), u0);  // color:white000s_support_high_contrast
                    y y1 = w.a(j.c, r0.d.m, p3, 0);
                    int v9 = p3.P;
                    i0 i01 = p3.m();
                    r0.q q3 = r0.a.d(p3, q2);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p3.e0();
                    if(p3.O) {
                        p3.l(i1);
                    }
                    else {
                        p3.o0();
                    }
                    androidx.compose.runtime.w.x(p3, y1, P0.j.f);
                    androidx.compose.runtime.w.x(p3, i01, P0.j.e);
                    P0.h h2 = P0.j.g;
                    if(p3.O || !q.b(p3.N(), v9)) {
                        A7.d.q(v9, p3, v9, h2);
                    }
                    androidx.compose.runtime.w.x(p3, q3, P0.j.d);
                    boolean z3 = p3.i(((Gd.u)object2));
                    o o0 = p3.N();
                    if(z3 || o0 == v0) {
                        o0 = new o(((Gd.u)object2), 0);
                        p3.l0(o0);
                    }
                    androidx.compose.ui.viewinterop.a.a(o0, null, null, p3, 0, 6);
                    if(z2 instanceof Gd.x) {
                        p3.a0(0x2E58AAAC);
                        c1.G(null, p3, 0, 1);
                        p3.p(false);
                    }
                    else if(z2 instanceof Gd.y) {
                        p3.a0(0x2E5AAE4A);
                        ((Gd.u)object2).o(((Gd.y)z2), p3, 0);
                        p3.p(false);
                    }
                    else {
                        throw l1.c(p3, 0xCFF24E07, false);
                    }
                    p3.p(true);
                    return h0;
                }
                p3.T();
                return h0;
            }
            case 12: {
                int v10 = (int)(((Integer)object1));
                if((v10 & 3) != 2) {
                    z = true;
                }
                if(((p)(((l)object0))).Q(v10 & 1, z)) {
                    r0.a.a(((s0)object2), null, ((p)(((l)object0))), 0x180);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 13: {
                String s = (String)object0;
                EventComment eventComment0 = (EventComment)CompatUtils.getSerializable(((Bundle)object1), "data", EventComment.class);
                if(eventComment0 != null) {
                    Object object4 = ((Hc.i)((Hc.w)object2).getViewModel()).c().g.getValue();
                    if(object4 instanceof x) {
                        x0 = (x)object4;
                    }
                    if(x0 != null && eventComment0.chnlSeq == x0.d && q.b(eventComment0.contsRefValue, x0.e)) {
                        ((Hc.w)object2).sendUserEvent(new Jc.c((String.valueOf(eventComment0.chnlSeq) == null ? "" : String.valueOf(eventComment0.chnlSeq)), eventComment0.contsRefValue));
                    }
                }
                return h0;
            }
            case 14: {
                int v11 = (int)(((Integer)object1));
                if((v11 & 3) != 2) {
                    z = true;
                }
                if(((p)(((l)object0))).Q(v11 & 1, z)) {
                    ((J)object2).o(((Ud.j)((J)object2).e.getValue()), ((p)(((l)object0))), 6);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 15: {
                ((Integer)object1).getClass();
                Id.e.b(((v0)object2), ((l)object0), 1);
                return h0;
            }
            case 16: {
                ((Integer)object1).getClass();
                Id.e.d(((Id.a)object2), ((l)object0), 1);
                return h0;
            }
            case 17: {
                ((Integer)object1).getClass();
                ((Mc.B)object2).o(((l)object0), 1);
                return h0;
            }
            case 18: {
                ((Integer)object1).getClass();
                com.google.firebase.b.d(((N)object2), ((l)object0), 7);
                return h0;
            }
            case 19: {
                ((Integer)object1).getClass();
                x1.a.b(((h0)object2), ((l)object0), 7);
                return h0;
            }
            case 20: {
                ((Integer)object1).getClass();
                ye.a.h(((x0)object2), ((l)object0), 7);
                return h0;
            }
            case 21: {
                ((Integer)object1).getClass();
                Nc.c1.a(((d1)object2), ((l)object0), 1);
                return h0;
            }
            case 22: {
                q.g(((CharSequence)object0), "$this$DelimitedRangesSequence");
                int v12 = Tf.o.G0(((CharSequence)object0), ((char[])object2), ((int)(((Integer)object1))), false);
                return v12 >= 0 ? new m(v12, 1) : null;
            }
            case 23: {
                U8.w w0 = (U8.w)((U8.l)object2).getViewModel();
                w0.getClass();
                f.b().c.equalizerBandGainDb[((int)(((Integer)object0)))] = (float)(((int)(((Integer)object1))));
                f.i();
                w0.updateUiState(new Ma.k(16));
                ((U8.w)((U8.l)object2).getViewModel()).g(true);
                return h0;
            }
            case 24: {
                ((Integer)object1).getClass();
                ((Uc.j.a)object2).m(((l)object0), 1);
                return h0;
            }
            case 25: {
                ((Integer)object1).getClass();
                V4.u.e(((r)object2), ((l)object0), 1);
                return h0;
            }
            case 26: {
                ((Integer)object1).getClass();
                a.a.h(((q0)object2), ((l)object0), 1);
                return h0;
            }
            case 27: {
                ((Integer)object1).getClass();
                com.google.firebase.b.o(((Vc.s0)object2), ((l)object0), 1);
                return h0;
            }
            case 28: {
                ((Integer)object1).getClass();
                ((E)object2).m(((l)object0), 1);
                return h0;
            }
            default: {
                return SafeCollector_commonKt.a(((SafeCollector)object2), ((int)(((Integer)object0))), ((me.g)object1));
            }
        }
    }
}

