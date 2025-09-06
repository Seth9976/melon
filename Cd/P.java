package cd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class p implements o {
    public final int a;
    public final b b;

    public p(int v, b b0) {
        this.a = v;
        this.b = b0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((androidx.compose.runtime.p)(((l)object1))).a0(0x1FF03545);
            h h0 = (h)((androidx.compose.runtime.p)(((l)object1))).k(k0.i);
            m m0 = ((androidx.compose.runtime.p)(((l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new cd.o(h0, this.b, 1));
            ((androidx.compose.runtime.p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((androidx.compose.runtime.p)(((l)object1))).a0(0x1FF03545);
        h h1 = (h)((androidx.compose.runtime.p)(((l)object1))).k(k0.i);
        m m1 = ((androidx.compose.runtime.p)(((l)object1))).N();
        if(m1 == k.a) {
            m1 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new cd.o(h1, this.b, 0));
        ((androidx.compose.runtime.p)(((l)object1))).p(false);
        return q1;
    }
}

