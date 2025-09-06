package androidx.compose.foundation;

import K.l;
import K.m;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.r;
import r0.n;
import r0.q;
import we.a;
import we.o;

public final class z extends r implements o {
    public final boolean f;
    public final String g;
    public final a h;

    public z(String s, boolean z, a a0) {
        this.f = z;
        this.g = s;
        this.h = a0;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        l l0;
        q q0 = (q)object0;
        ((Number)object2).intValue();
        ((p)(((androidx.compose.runtime.l)object1))).a0(0xD2EF1E09);
        Object object3 = ((p)(((androidx.compose.runtime.l)object1))).k(i0.a);
        if(((f0)object3) instanceof l0) {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0x24D0A640);
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
            l0 = null;
        }
        else {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0x24D2AC4A);
            m m0 = ((p)(((androidx.compose.runtime.l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((androidx.compose.runtime.l)object1))));
            }
            l0 = m0;
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
        }
        q q1 = androidx.compose.foundation.q.l(n.a, l0, ((f0)object3), this.f, this.g, null, this.h);
        ((p)(((androidx.compose.runtime.l)object1))).p(false);
        return q1;
    }
}

