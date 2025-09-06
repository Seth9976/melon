package Cc;

import Ac.Y2;
import Ld.K;
import Ld.o;
import O.F;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.melon.ui.K4;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ie.H;
import ie.f;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import we.k;
import we.n;
import we.p;
import yd.h;
import zd.Q;
import zd.m;
import zd.v;

public final class f3 extends r implements p {
    public final int f;
    public final Object g;
    public final Object h;
    public final f i;
    public final Object j;
    public final Object k;

    public f3(List list0, Object object0, f f0, Object object1, Object object2, int v) {
        this.f = v;
        this.g = list0;
        this.h = object0;
        this.i = f0;
        this.j = object1;
        this.k = object2;
        super(4);
    }

    public f3(List list0, Q q0, K4 k40, k k0, List list1) {
        this.f = 2;
        this.g = list0;
        this.h = q0;
        this.j = k40;
        this.i = k0;
        this.k = list1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                int v3 = ((Number)object1).intValue();
                int v4 = ((Number)object3).intValue();
                b0 b00 = (b0)this.h;
                int v5 = (v4 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v4 : v4;
                if((v4 & 0x30) == 0) {
                    v5 |= (((androidx.compose.runtime.p)(((l)object2))).e(v3) ? 0x20 : 16);
                }
                boolean z = true;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v5 & 1, (v5 & 0x93) != 0x92)) {
                    Object object5 = ((List)this.g).get(v3);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(1900292697);
                    Object object6 = je.p.n0(v3, w.a);
                    boolean z1 = v3 == ((Number)((O0)b00).getValue()).intValue();
                    boolean z2 = ((androidx.compose.runtime.p)(((l)object2))).g(b00);
                    if(((v5 & 0x70 ^ 0x30) <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v3)) && (v5 & 0x30) != 0x20) {
                        z = false;
                    }
                    boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).g(((k)this.i));
                    boolean z4 = ((androidx.compose.runtime.p)(((l)object2))).i(((CoroutineScope)this.j));
                    boolean z5 = ((androidx.compose.runtime.p)(((l)object2))).g(((F)this.k));
                    Y2 y20 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((z2 | z | z3 | z4 | z5) != 0 || y20 == androidx.compose.runtime.k.a) {
                        y20 = new Y2(b00, v3, ((k)this.i), ((CoroutineScope)this.j), ((F)this.k));
                        ((androidx.compose.runtime.p)(((l)object2))).l0(y20);
                    }
                    c1.M(((String)object5), ((String)object6), 0.0f, 0.0f, 0.0f, z1, y20, ((androidx.compose.runtime.p)(((l)object2))), 0, 28);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                int v6 = ((Number)object1).intValue();
                int v7 = ((Number)object3).intValue();
                n n1 = (n)this.i;
                n n2 = (n)this.h;
                int v8 = (v7 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v7 : v7;
                if((v7 & 0x30) == 0) {
                    v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v6) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v8 & 1, (v8 & 0x93) != 0x92)) {
                    K k1 = (K)((ArrayList)this.g).get(v6);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(-1006997145);
                    LottieComposition lottieComposition0 = (LottieComposition)((LottieCompositionResult)this.j).getValue();
                    float f = ((Number)((LottieAnimationState)this.k).getValue()).floatValue();
                    boolean z6 = ((androidx.compose.runtime.p)(((l)object2))).g(n2);
                    boolean z7 = ((androidx.compose.runtime.p)(((l)object2))).i(k1);
                    int v9 = v8 & 0x70 ^ 0x30;
                    int v10 = (v9 <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v6)) && (v8 & 0x30) != 0x20 ? 0 : 1;
                    Ld.n n3 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v11 = androidx.compose.runtime.k.a;
                    if((z6 | z7 | v10) != 0 || n3 == v11) {
                        n3 = new Ld.n(n2, k1, v6);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(n3);
                    }
                    boolean z8 = ((androidx.compose.runtime.p)(((l)object2))).g(n1);
                    boolean z9 = ((androidx.compose.runtime.p)(((l)object2))).i(k1);
                    int v12 = (v9 <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v6)) && (v8 & 0x30) != 0x20 ? 0 : 1;
                    o o0 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((v12 | (z8 | z9)) != 0 || o0 == v11) {
                        o0 = new o(n1, k1, v6);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(o0);
                    }
                    d4.d(k1, n3, o0, v6, lottieComposition0, f, ((androidx.compose.runtime.p)(((l)object2))), (v8 & 0x7E) << 6 & 0x1C00);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            default: {
                k k0 = (k)this.i;
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                Q q0 = (Q)this.h;
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object4 = ((List)this.g).get(v);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x519E7FD6);
                    if(v != 0 || !(q0 instanceof m) || !((m)q0).x() && !((m)q0).m() && !((m)q0).n()) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x4FBF5FDA);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x51A07738);
                        v.a(((m)q0), ((K4)this.j), k0, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    r0.n n0 = r0.n.a;
                    h.d(q0, ((MelonBottomSheetItem)object4), v, r0.a.a(d.h(d.f(n0, 1.0f), 52.0f), new yd.f(((MelonBottomSheetItem)object4), k0, v, q0, 1)), ((k)this.i), ((androidx.compose.runtime.p)(((l)object2))), (v2 & 0x7E) << 3 & 0x380);
                    if(v == ((List)this.k).size() - 1) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x51AFD8B4);
                        A7.d.v(n0, 10.0f, ((androidx.compose.runtime.p)(((l)object2))), false);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x4FBF5FDA);
                        ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
        }
    }
}

