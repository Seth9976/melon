package v1;

import ie.H;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import r1.k;
import we.a;

public final class l extends r implements a {
    public final G f;
    public final m g;
    public final k h;
    public final long i;
    public final long j;

    public l(G g0, m m0, k k0, long v, long v1) {
        this.f = g0;
        this.g = m0;
        this.h = k0;
        this.i = v;
        this.j = v1;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        this.f.a = this.g.getPositionProvider().a(this.h, this.i, this.g.getParentLayoutDirection(), this.j);
        return H.a;
    }
}

