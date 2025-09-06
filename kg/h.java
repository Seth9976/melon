package kg;

import gd.k4;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import pc.t;
import we.k;

public final class h extends r implements k {
    public final int f;
    public final j g;

    public h(j j0, int v) {
        this.f = v;
        this.g = j0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                q.g(((jg.h)object0), "message");
                ((t)this.g.m.b).C(new k4(4, this, ((jg.h)object0)));
                return H.a;
            }
            case 1: {
                q.g(((jg.h)object0), "message");
                ((t)this.g.m.b).C(new k4(5, this, ((jg.h)object0)));
                return H.a;
            }
            default: {
                q.g(((l)object0), "it");
                this.g.b(((l)object0));
                return H.a;
            }
        }
    }
}

