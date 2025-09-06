package Nc;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class u1 implements o {
    public final int a;
    public final v1 b;

    public u1(v1 v10, int v) {
        this.a = v;
        this.b = v10;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                h h1 = (h)((p)(((l)object1))).k(k0.i);
                m m1 = ((p)(((l)object1))).N();
                if(m1 == k.a) {
                    m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new t1(h1, this.b, 0));
                ((p)(((l)object1))).p(false);
                return q1;
            }
            case 1: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                h h2 = (h)((p)(((l)object1))).k(k0.i);
                m m2 = ((p)(((l)object1))).N();
                if(m2 == k.a) {
                    m2 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new i(0), new t1(h2, this.b, 1));
                ((p)(((l)object1))).p(false);
                return q2;
            }
            default: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                h h0 = (h)((p)(((l)object1))).k(k0.i);
                m m0 = ((p)(((l)object1))).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new t1(h0, this.b, 2));
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

