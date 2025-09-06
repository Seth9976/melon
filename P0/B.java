package p0;

import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class b extends r implements k {
    public final int f;
    public final k g;
    public final k h;

    public b(k k0, k k1, int v) {
        this.f = v;
        this.g = k0;
        this.h = k1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v;
        switch(this.f) {
            case 0: {
                synchronized(m.b) {
                    v = m.d;
                    m.d = v + 1L;
                }
                return new d(v, ((l)object0), this.g, this.h);
            }
            case 1: {
                this.g.invoke(object0);
                this.h.invoke(object0);
                return H.a;
            }
            default: {
                this.g.invoke(object0);
                this.h.invoke(object0);
                return H.a;
            }
        }
    }
}

