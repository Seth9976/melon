package d0;

import X.k;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import b0.w;
import ie.H;
import kotlin.jvm.internal.r;
import r0.n;
import we.o;

public final class a extends r implements o {
    public final long f;
    public final q g;

    public a(long v, q q0) {
        this.f = v;
        this.g = q0;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        boolean z = ((Boolean)object0).booleanValue();
        int v = ((Number)object2).intValue();
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).h(z) ? 4 : 2);
        }
        if((v & 19) == 18 && ((p)(((l)object1))).D()) {
            ((p)(((l)object1))).T();
            return H.a;
        }
        if(z) {
            ((p)(((l)object1))).a0(0x2261D09B);
            w.b(d.n(n.a, h.c), this.f, h.a, 0L, 0, ((p)(((l)object1))), 390);
            ((p)(((l)object1))).p(false);
            return H.a;
        }
        ((p)(((l)object1))).a0(577079337);
        q q0 = this.g;
        boolean z1 = ((p)(((l)object1))).g(q0);
        k k0 = ((p)(((l)object1))).N();
        if(z1 || k0 == androidx.compose.runtime.k.a) {
            k0 = new k(q0, 14);
            ((p)(((l)object1))).l0(k0);
        }
        h.a(k0, this.f, ((p)(((l)object1))), 0);
        ((p)(((l)object1))).p(false);
        return H.a;
    }
}

