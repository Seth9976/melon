package kg;

import gd.k4;
import ie.H;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import pc.t;
import we.k;

public final class c extends r implements k {
    public final int f;
    public final d g;
    public final k h;

    public c(d d0, k k0, int v) {
        this.f = v;
        this.g = d0;
        this.h = k0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            q.g(((IOException)object0), "it");
            if(this.h != null) {
                ((t)this.g.a.a).C(new k4(3, this, ((IOException)object0)));
            }
            return H.a;
        }
        q.g(((Map)object0), "it");
        if(this.h != null) {
            ((t)this.g.a.a).C(new k4(2, this, ((Map)object0)));
        }
        return H.a;
    }
}

