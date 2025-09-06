package Fd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class u implements o {
    public final int a;
    public final D b;
    public final Z c;
    public final String d;
    public final int e;

    public u(D d0, Z z0, int v, String s) {
        this.a = 0;
        super();
        this.b = d0;
        this.c = z0;
        this.e = v;
        this.d = s;
    }

    public u(D d0, Z z0, String s, int v) {
        this.a = 1;
        super();
        this.b = d0;
        this.c = z0;
        this.d = s;
        this.e = v;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x1FF03545);
            Object object3 = ((p)(((l)object1))).k(k0.i);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new t(((h)object3), this.b, this.c, this.d, this.e));
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        Object object4 = ((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new t(((h)object4), this.b, this.c, this.e, this.d));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

