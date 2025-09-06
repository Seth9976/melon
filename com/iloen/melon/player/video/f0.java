package com.iloen.melon.player.video;

import Cc.e0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import de.c;
import ie.H;
import kotlin.jvm.internal.q;
import r0.d;
import r0.n;
import we.k;
import we.p;
import y0.M;
import zd.Q;

public final class f0 implements p {
    public final Q a;
    public final k b;

    public f0(Q q0, k k0) {
        this.a = q0;
        this.b = k0;
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        ((Integer)object1).getClass();
        int v = (int)(((Integer)object3));
        q.g(((a)object0), "$this$stickyHeader");
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v & 1, (v & 0x81) != 0x80)) {
            long v1 = e0.T(((androidx.compose.runtime.p)(((l)object2))), 0x7F0604AB);  // color:white001s
            r0.q q0 = androidx.compose.foundation.q.f(n.a, v1, M.a);
            y y0 = w.a(j.c, d.m, ((androidx.compose.runtime.p)(((l)object2))), 0);
            int v2 = ((androidx.compose.runtime.p)(((l)object2))).P;
            i0 i00 = ((androidx.compose.runtime.p)(((l)object2))).m();
            r0.q q1 = r0.a.d(((androidx.compose.runtime.p)(((l)object2))), q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            ((androidx.compose.runtime.p)(((l)object2))).e0();
            if(((androidx.compose.runtime.p)(((l)object2))).O) {
                ((androidx.compose.runtime.p)(((l)object2))).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object2))).o0();
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)(((l)object2))), y0, P0.j.f);
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)(((l)object2))), i00, P0.j.e);
            h h0 = P0.j.g;
            if(((androidx.compose.runtime.p)(((l)object2))).O || !q.b(((androidx.compose.runtime.p)(((l)object2))).N(), v2)) {
                A7.d.q(v2, ((androidx.compose.runtime.p)(((l)object2))), v2, h0);
            }
            androidx.compose.runtime.w.x(((androidx.compose.runtime.p)(((l)object2))), q1, P0.j.d);
            c.e(new HorizontalAlignElement(d.n), 0.0f, 0.0f, null, 0L, ((androidx.compose.runtime.p)(((l)object2))), 0);
            k k0 = this.b;
            boolean z = ((androidx.compose.runtime.p)(((l)object2))).g(k0);
            com.iloen.melon.player.video.c c0 = ((androidx.compose.runtime.p)(((l)object2))).N();
            if(z || c0 == androidx.compose.runtime.k.a) {
                c0 = new com.iloen.melon.player.video.c(k0, 3);
                ((androidx.compose.runtime.p)(((l)object2))).l0(c0);
            }
            c.d(this.a, k0, c0, ((androidx.compose.runtime.p)(((l)object2))), 0, 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(true);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

