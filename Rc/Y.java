package Rc;

import Cc.e0;
import F.E;
import M.p;
import P0.h;
import P0.i;
import P0.j;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.jvm.internal.q;
import r0.a;
import we.k;
import we.o;
import y0.M;

public final class y implements o {
    public final int a;
    public final O b;
    public final k c;

    public y(O o0, k k0, int v) {
        this.a = v;
        this.b = o0;
        this.c = k0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Integer)object2).getClass();
        if(this.a != 0) {
            q.g(((E)object0), "$this$AnimatedVisibility");
            long v = e0.T(((l)object1), 0x7F06019A);  // color:lock_screen_player_bg
            r0.q q0 = androidx.compose.foundation.q.f(d.c, v, M.a);
            N0.M m0 = p.d(r0.d.a, false);
            int v1 = ((androidx.compose.runtime.p)(((l)object1))).P;
            i0 i00 = ((androidx.compose.runtime.p)(((l)object1))).m();
            r0.q q1 = a.d(((l)object1), q0);
            P0.k.y.getClass();
            i i0 = j.b;
            ((androidx.compose.runtime.p)(((l)object1))).e0();
            if(((androidx.compose.runtime.p)(((l)object1))).O) {
                ((androidx.compose.runtime.p)(((l)object1))).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object1))).o0();
            }
            w.x(((l)object1), m0, j.f);
            w.x(((l)object1), i00, j.e);
            h h0 = j.g;
            if(((androidx.compose.runtime.p)(((l)object1))).O || !q.b(((androidx.compose.runtime.p)(((l)object1))).N(), v1)) {
                A7.d.q(v1, ((androidx.compose.runtime.p)(((l)object1))), v1, h0);
            }
            w.x(((l)object1), q1, j.d);
            K.a(this.b, null, ((l)object1), 0);
            K.e(this.b, true, this.c, ((l)object1), 0x30);
            ((androidx.compose.runtime.p)(((l)object1))).p(true);
            return H.a;
        }
        q.g(((E)object0), "$this$AnimatedVisibility");
        long v2 = e0.T(((l)object1), 0x7F06019A);  // color:lock_screen_player_bg
        r0.q q2 = androidx.compose.foundation.q.f(d.c, v2, M.a);
        N0.M m1 = p.d(r0.d.a, false);
        int v3 = ((androidx.compose.runtime.p)(((l)object1))).P;
        i0 i01 = ((androidx.compose.runtime.p)(((l)object1))).m();
        r0.q q3 = a.d(((l)object1), q2);
        P0.k.y.getClass();
        i i1 = j.b;
        ((androidx.compose.runtime.p)(((l)object1))).e0();
        if(((androidx.compose.runtime.p)(((l)object1))).O) {
            ((androidx.compose.runtime.p)(((l)object1))).l(i1);
        }
        else {
            ((androidx.compose.runtime.p)(((l)object1))).o0();
        }
        w.x(((l)object1), m1, j.f);
        w.x(((l)object1), i01, j.e);
        h h1 = j.g;
        if(((androidx.compose.runtime.p)(((l)object1))).O || !q.b(((androidx.compose.runtime.p)(((l)object1))).N(), v3)) {
            A7.d.q(v3, ((androidx.compose.runtime.p)(((l)object1))), v3, h1);
        }
        w.x(((l)object1), q3, j.d);
        K.a(this.b, null, ((l)object1), 0);
        K.e(this.b, false, this.c, ((l)object1), 0x30);
        ((androidx.compose.runtime.p)(((l)object1))).p(true);
        return H.a;
    }
}

