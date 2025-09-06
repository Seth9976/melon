package gd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;

public final class h5 implements o {
    public final int a;
    public final k b;
    public final j5 c;

    public h5(j5 j50, k k0) {
        this.a = 0;
        super();
        this.c = j50;
        this.b = k0;
    }

    public h5(k k0, j5 j50) {
        this.a = 1;
        super();
        this.b = k0;
        this.c = j50;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x1FF03545);
            h h0 = (h)((p)(((l)object1))).k(k0.i);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == androidx.compose.runtime.k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new g5(h0, this.b, this.c));
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        h h1 = (h)((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == androidx.compose.runtime.k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new g5(h1, this.c, this.b));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

