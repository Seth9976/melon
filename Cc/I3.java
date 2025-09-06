package Cc;

import Ac.W;
import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import df.e;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class i3 implements o {
    public final int a;
    public final b0 b;

    public i3(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x98A5F823);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.m(((r0.q)object0), m0, null, false, new i(0), new e(this.b, 3), 4);
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        h h0 = (h)((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new W(3, h0, this.b));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

