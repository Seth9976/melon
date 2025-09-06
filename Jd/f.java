package jd;

import K.m;
import Nc.W0;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.J0;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class f implements o {
    public final int a;
    public final J0 b;

    public f(J0 j00, int v) {
        this.a = v;
        this.b = j00;
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
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new W0(23, h1, ((g)this.b)));
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
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new i(0), new W0(24, h2, ((F1)this.b)));
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
                r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new W0(27, h0, ((ld.m)this.b)));
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

