package F;

import G.D;
import G.f;
import G.m0;
import U.f0;
import androidx.compose.animation.a;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b1;
import ie.H;
import kotlin.jvm.internal.r;
import r1.l;
import we.k;

public final class p extends r implements k {
    public final int f;
    public final Object g;
    public final long h;

    public p(Object object0, long v, int v1) {
        this.f = v1;
        this.g = object0;
        this.h = v;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v1;
        switch(this.f) {
            case 0: {
                Object object1 = ((m0)object0).c();
                q q0 = (q)this.g;
                long v = 0L;
                if(!kotlin.jvm.internal.q.b(object1, q0.c.c())) {
                    b1 b10 = (b1)q0.c.c.g(((m0)object0).c());
                    v1 = b10 == null ? 0L : ((l)b10.getValue()).a;
                }
                else if(l.b(q0.d, a.a)) {
                    v1 = this.h;
                }
                else {
                    v1 = q0.d;
                }
                b1 b11 = (b1)q0.c.c.g(((m0)object0).b());
                if(b11 != null) {
                    v = ((l)b11.getValue()).a;
                }
                k0 k00 = (k0)q0.b.getValue();
                if(k00 != null) {
                    l l0 = new l(v1);
                    l l1 = new l(v);
                    D d0 = (D)k00.a.invoke(l0, l1);
                    if(d0 != null) {
                        return d0;
                    }
                }
                return f.q(400.0f, 5, null);
            }
            case 1: {
                q q1 = (q)this.g;
                if(kotlin.jvm.internal.q.b(object0, q1.c.c())) {
                    return l.b(q1.d, a.a) ? new l(this.h) : new l(q1.d);
                }
                b1 b12 = (b1)q1.c.c.g(object0);
                return b12 == null ? new l(0L) : new l(((l)b12.getValue()).a);
            }
            default: {
                f0 f00 = (f0)this.g;
                if(((Boolean)((O0)f00.s).getValue()).booleanValue() || ((Boolean)((O0)f00.t).getValue()).booleanValue()) {
                    A0.f.d0(((A0.f)object0), this.h, 0L, 0.0f, null, 0, 0x7E);
                }
                return H.a;
            }
        }
    }
}

